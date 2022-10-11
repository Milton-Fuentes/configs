/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/*
, @NamedQuery(name = "GlobRoles.findByRoleName", query = "SELECT g FROM GlobRoles g WHERE g.roleName = :roleName")
    , @NamedQuery(name = "GlobRoles.findByShortdesc", query = "SELECT g FROM GlobRoles g WHERE g.shortdesc = :shortdesc")
    , @NamedQuery(name = "GlobRoles.findByDescription", query = "SELECT g FROM GlobRoles g WHERE g.description = :description")
    , @NamedQuery(name = "GlobRoles.findByActive", query = "SELECT g FROM GlobRoles g WHERE g.active = :active")
    , @NamedQuery(name = "GlobRoles.findByLastMod", query = "SELECT g FROM GlobRoles g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobRoles.findByLastModBy", query = "SELECT g FROM GlobRoles g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobRoles.findByLastModIp", query = "SELECT g FROM GlobRoles g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobRoles.findByTemp", query = "SELECT g FROM GlobRoles g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobRoles.findByCreateBy", query = "SELECT g FROM GlobRoles g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobRoles.findByCreateByIp", query = "SELECT g FROM GlobRoles g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobRoles.findByCreateDate", query = "SELECT g FROM GlobRoles g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobRoles.findByIsReq", query = "SELECT g FROM GlobRoles g WHERE g.isReq = :isReq")
    , @NamedQuery(name = "GlobRoles.findByFunctionId", query = "SELECT g FROM GlobRoles g WHERE g.functionId = :functionId")
    , @NamedQuery(name = "GlobRoles.findByCreateDateTmp", query = "SELECT g FROM GlobRoles g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobRoles.findByLastModTmp", query = "SELECT g FROM GlobRoles g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobRoles.findByTempTmp", query = "SELECT g FROM GlobRoles g WHERE g.tempTmp = :tempTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_ROLES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobRoles.findAll", query = "SELECT g FROM GlobRoles g"),
    @NamedQuery(name = "GlobRoles.findByRoleName", query = "SELECT g FROM GlobRoles g WHERE g.active = 'Y' AND g.roleName = :roleName"),
    @NamedQuery(name = "GlobRoles.findById", query = "SELECT g FROM GlobRoles g WHERE g.id = :id")})
public class GlobRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_ROLES_ID_SEQ", sequenceName = "GLOB_ROLES_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_ROLES_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Size(max = 50)
    @Column(name = "SHORTDESC")
    private String shortdesc;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_REQ")
    private Character isReq;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @OneToMany(mappedBy = "roleId")
    private List<GlobProfiles> globProfilesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolesId", fetch = FetchType.LAZY)
    private List<GlobClientRoles> globClientRolesList;

    public GlobRoles() {
    }

    public GlobRoles(BigDecimal id) {
        this.id = id;
    }

    public GlobRoles(BigDecimal id, String roleName, Character isReq) {
        this.id = id;
        this.roleName = roleName;
        this.isReq = isReq;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getIsReq() {
        return isReq;
    }

    public void setIsReq(Character isReq) {
        this.isReq = isReq;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    @XmlTransient
    public List<GlobProfiles> getGlobProfilesList() {
        return globProfilesList;
    }

    public void setGlobProfilesList(List<GlobProfiles> globProfilesList) {
        this.globProfilesList = globProfilesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobRoles)) {
            return false;
        }
        GlobRoles other = (GlobRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobRoles[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobClientRoles> getGlobClientRolesList() {
        return globClientRolesList;
    }

    public void setGlobClientRolesList(List<GlobClientRoles> globClientRolesList) {
        this.globClientRolesList = globClientRolesList;
    }

}
