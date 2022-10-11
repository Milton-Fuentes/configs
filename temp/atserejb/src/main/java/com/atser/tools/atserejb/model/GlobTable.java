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
    , @NamedQuery(name = "GlobTable.findByTName", query = "SELECT g FROM GlobTable g WHERE g.tName = :tName")
    , @NamedQuery(name = "GlobTable.findByActive", query = "SELECT g FROM GlobTable g WHERE g.active = :active")
    , @NamedQuery(name = "GlobTable.findByLastMod", query = "SELECT g FROM GlobTable g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobTable.findByLastModBy", query = "SELECT g FROM GlobTable g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobTable.findByLastModIp", query = "SELECT g FROM GlobTable g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobTable.findByTemp", query = "SELECT g FROM GlobTable g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobTable.findByCreateBy", query = "SELECT g FROM GlobTable g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobTable.findByCreateByIp", query = "SELECT g FROM GlobTable g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobTable.findByCreateDate", query = "SELECT g FROM GlobTable g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobTable.findByLastModTmp", query = "SELECT g FROM GlobTable g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobTable.findByTempTmp", query = "SELECT g FROM GlobTable g WHERE g.tempTmp = :tempTmp")
    , @NamedQuery(name = "GlobTable.findByCreateDateTmp", query = "SELECT g FROM GlobTable g WHERE g.createDateTmp = :createDateTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_TABLE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobTable.findAll", query = "SELECT g FROM GlobTable g")
    , @NamedQuery(name = "GlobTable.findById", query = "SELECT g FROM GlobTable g WHERE g.id = :id")})
public class GlobTable implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "T_NAME")
    private String tName;
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
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;

    public GlobTable() {
    }

    public GlobTable(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
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
        if (!(object instanceof GlobTable)) {
            return false;
        }
        GlobTable other = (GlobTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobTable[ id=" + id + " ]";
    }
    
}
