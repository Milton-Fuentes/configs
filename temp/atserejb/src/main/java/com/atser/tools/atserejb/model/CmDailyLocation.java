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
, @NamedQuery(name = "CmDailyLocation.findByContractId", query = "SELECT c FROM CmDailyLocation c WHERE c.contractId = :contractId")
    , @NamedQuery(name = "CmDailyLocation.findByLocation", query = "SELECT c FROM CmDailyLocation c WHERE c.location = :location")
    , @NamedQuery(name = "CmDailyLocation.findByDescription", query = "SELECT c FROM CmDailyLocation c WHERE c.description = :description")
    , @NamedQuery(name = "CmDailyLocation.findByCreateBy", query = "SELECT c FROM CmDailyLocation c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmDailyLocation.findByCreateByIp", query = "SELECT c FROM CmDailyLocation c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmDailyLocation.findByLastModBy", query = "SELECT c FROM CmDailyLocation c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmDailyLocation.findByLastMod", query = "SELECT c FROM CmDailyLocation c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmDailyLocation.findByLastModIp", query = "SELECT c FROM CmDailyLocation c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmDailyLocation.findByVersion", query = "SELECT c FROM CmDailyLocation c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_DAILY_LOCATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmDailyLocation.findAll", query = "SELECT c FROM CmDailyLocation c")
    , @NamedQuery(name = "CmDailyLocation.findById", query = "SELECT c FROM CmDailyLocation c WHERE c.id = :id")})
public class CmDailyLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Size(max = 1000)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public CmDailyLocation() {
    }

    public CmDailyLocation(BigDecimal id) {
        this.id = id;
    }

    public CmDailyLocation(BigDecimal id, BigInteger contractId) {
        this.id = id;
        this.contractId = contractId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
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
        if (!(object instanceof CmDailyLocation)) {
            return false;
        }
        CmDailyLocation other = (CmDailyLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmDailyLocation[ id=" + id + " ]";
    }
    
}
