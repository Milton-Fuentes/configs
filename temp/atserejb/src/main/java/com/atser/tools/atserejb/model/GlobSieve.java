/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "GlobSieve.findByCommonName", query = "SELECT g FROM GlobSieve g WHERE g.commonName = :commonName"),
    @NamedQuery(name = "GlobSieve.findByMmName", query = "SELECT g FROM GlobSieve g WHERE g.mmName = :mmName"),
    @NamedQuery(name = "GlobSieve.findByActive", query = "SELECT g FROM GlobSieve g WHERE g.active = :active"),
    @NamedQuery(name = "GlobSieve.findByLastMod", query = "SELECT g FROM GlobSieve g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSieve.findByLastModBy", query = "SELECT g FROM GlobSieve g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSieve.findByLastModIp", query = "SELECT g FROM GlobSieve g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSieve.findByTemp", query = "SELECT g FROM GlobSieve g WHERE g.temp = :temp"),
    @NamedQuery(name = "GlobSieve.findByCreateBy", query = "SELECT g FROM GlobSieve g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSieve.findByCreateByIp", query = "SELECT g FROM GlobSieve g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSieve.findByCreateDate", query = "SELECT g FROM GlobSieve g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobSieve.findByTempTmp", query = "SELECT g FROM GlobSieve g WHERE g.tempTmp = :tempTmp"),
    @NamedQuery(name = "GlobSieve.findByLastModTmp", query = "SELECT g FROM GlobSieve g WHERE g.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "GlobSieve.findByCreateDateTmp", query = "SELECT g FROM GlobSieve g WHERE g.createDateTmp = :createDateTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SIEVE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSieve.findAll", query = "SELECT g FROM GlobSieve g"),
    @NamedQuery(name = "GlobSieve.findById", query = "SELECT g FROM GlobSieve g WHERE g.id = :id")})
public class GlobSieve implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "COMMON_NAME")
    private String commonName;
    @Size(max = 4000)
    @Column(name = "MM_NAME")
    private String mmName;
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
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;

    public GlobSieve() {
    }

    public GlobSieve(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getMmName() {
        return mmName;
    }

    public void setMmName(String mmName) {
        this.mmName = mmName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
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
        if (!(object instanceof GlobSieve)) {
            return false;
        }
        GlobSieve other = (GlobSieve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSieve[ id=" + id + " ]";
    }
    
}
