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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "CmEmGroup.findByName", query = "SELECT c FROM CmEmGroup c WHERE c.name = :name")
    , @NamedQuery(name = "CmEmGroup.findByDescription", query = "SELECT c FROM CmEmGroup c WHERE c.description = :description")
    , @NamedQuery(name = "CmEmGroup.findByLastModBy", query = "SELECT c FROM CmEmGroup c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmEmGroup.findByLastMod", query = "SELECT c FROM CmEmGroup c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmEmGroup.findByVersion", query = "SELECT c FROM CmEmGroup c WHERE c.version = :version")
    , @NamedQuery(name = "CmEmGroup.findByLastModIp", query = "SELECT c FROM CmEmGroup c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmEmGroup.findByCreateBy", query = "SELECT c FROM CmEmGroup c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmEmGroup.findByCreateByIp", query = "SELECT c FROM CmEmGroup c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmEmGroup.findByCreateDate", query = "SELECT c FROM CmEmGroup c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CmEmGroup.findByClientId", query = "SELECT c FROM CmEmGroup c WHERE c.clientId = :clientId")
    , @NamedQuery(name = "CmEmGroup.findByStatus", query = "SELECT c FROM CmEmGroup c WHERE c.status = :status")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE CM_EM_GROUP SET status = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 1")
@Table(name = "CM_EM_GROUP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmEmGroup.findAll", query = "SELECT c FROM CmEmGroup c")
    , @NamedQuery(name = "CmEmGroup.findById", query = "SELECT c FROM CmEmGroup c WHERE c.id = :id")})
public class CmEmGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CM_EM_GROUP_ID_SEQ", sequenceName = "CM_EM_GROUP_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_EM_GROUP_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 20)
    @Column(name = "VERSION", nullable = false, insertable = false)
    private String version;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "STATUS", nullable = false, insertable = false)
    private Short status;
    @JoinTable(name = "CM_EM_GROUP_USERS", 
            joinColumns = { @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")}, 
            inverseJoinColumns = {@JoinColumn(name = "MB_USERID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<GlobUsers> globUsersList;

    public CmEmGroup() {
    }

    public CmEmGroup(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
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

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @XmlTransient
    public List<GlobUsers> getGlobUsersList() {
        return globUsersList;
    }

    public void setGlobUsersList(List<GlobUsers> globUsersList) {
        this.globUsersList = globUsersList;
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
        if (!(object instanceof CmEmGroup)) {
            return false;
        }
        CmEmGroup other = (CmEmGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmEmGroup[ id=" + id + " ]";
    }
    
}
