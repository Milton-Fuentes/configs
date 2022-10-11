/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobClientLabDefault.findByClientId", query = "SELECT g FROM GlobClientLabDefault g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientLabDefault.findByRegionId", query = "SELECT g FROM GlobClientLabDefault g WHERE g.regionId = :regionId"),
    @NamedQuery(name = "GlobClientLabDefault.findByMasterLabId", query = "SELECT g FROM GlobClientLabDefault g WHERE g.masterLabId = :masterLabId"),
    @NamedQuery(name = "GlobClientLabDefault.findByFunctionId", query = "SELECT g FROM GlobClientLabDefault g WHERE g.functionId = :functionId"),
    @NamedQuery(name = "GlobClientLabDefault.findByTypeProject", query = "SELECT g FROM GlobClientLabDefault g WHERE g.typeProject = :typeProject"),
    @NamedQuery(name = "GlobClientLabDefault.findByActive", query = "SELECT g FROM GlobClientLabDefault g WHERE g.active = :active"),
    @NamedQuery(name = "GlobClientLabDefault.findByLastMod", query = "SELECT g FROM GlobClientLabDefault g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobClientLabDefault.findByLastModBy", query = "SELECT g FROM GlobClientLabDefault g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobClientLabDefault.findByLastModIp", query = "SELECT g FROM GlobClientLabDefault g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobClientLabDefault.findByCreateDate", query = "SELECT g FROM GlobClientLabDefault g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobClientLabDefault.findByCreateBy", query = "SELECT g FROM GlobClientLabDefault g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobClientLabDefault.findByCreateByIp", query = "SELECT g FROM GlobClientLabDefault g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobClientLabDefault.findByVersion", query = "SELECT g FROM GlobClientLabDefault g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_LAB_DEFAULT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientLabDefault.findAll", query = "SELECT g FROM GlobClientLabDefault g"),
    @NamedQuery(name = "GlobClientLabDefault.findById", query = "SELECT g FROM GlobClientLabDefault g WHERE g.id = :id")})
public class GlobClientLabDefault implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MASTER_LAB_ID")
    private BigInteger masterLabId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Size(max = 50)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public GlobClientLabDefault() {
    }

    public GlobClientLabDefault(BigDecimal id) {
        this.id = id;
    }

    public GlobClientLabDefault(BigDecimal id, BigInteger clientId, BigInteger regionId, BigInteger masterLabId, BigInteger functionId) {
        this.id = id;
        this.clientId = clientId;
        this.regionId = regionId;
        this.masterLabId = masterLabId;
        this.functionId = functionId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public BigInteger getMasterLabId() {
        return masterLabId;
    }

    public void setMasterLabId(BigInteger masterLabId) {
        this.masterLabId = masterLabId;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof GlobClientLabDefault)) {
            return false;
        }
        GlobClientLabDefault other = (GlobClientLabDefault) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientLabDefault[ id=" + id + " ]";
    }
    
}
