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
@NamedQuery(name = "QaSampleSpecimens.findBySampleId", query = "SELECT q FROM QaSampleSpecimens q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaSampleSpecimens.findBySpecimenNo", query = "SELECT q FROM QaSampleSpecimens q WHERE q.specimenNo = :specimenNo"),
    @NamedQuery(name = "QaSampleSpecimens.findByActive", query = "SELECT q FROM QaSampleSpecimens q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleSpecimens.findByLastMod", query = "SELECT q FROM QaSampleSpecimens q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleSpecimens.findByLastModBy", query = "SELECT q FROM QaSampleSpecimens q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleSpecimens.findByLastModIp", query = "SELECT q FROM QaSampleSpecimens q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleSpecimens.findByCreateDate", query = "SELECT q FROM QaSampleSpecimens q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSampleSpecimens.findByCreateBy", query = "SELECT q FROM QaSampleSpecimens q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSampleSpecimens.findByCreateByIp", query = "SELECT q FROM QaSampleSpecimens q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleSpecimens.findByVersion", query = "SELECT q FROM QaSampleSpecimens q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleSpecimens.findBySerialNo", query = "SELECT q FROM QaSampleSpecimens q WHERE q.serialNo = :serialNo"),
    @NamedQuery(name = "QaSampleSpecimens.findByLatGps", query = "SELECT q FROM QaSampleSpecimens q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QaSampleSpecimens.findByLonGps", query = "SELECT q FROM QaSampleSpecimens q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QaSampleSpecimens.findByAltGps", query = "SELECT q FROM QaSampleSpecimens q WHERE q.altGps = :altGps")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_SAMPLE_SPECIMENS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleSpecimens.findAll", query = "SELECT q FROM QaSampleSpecimens q"),
    @NamedQuery(name = "QaSampleSpecimens.findById", query = "SELECT q FROM QaSampleSpecimens q WHERE q.id = :id")})
public class QaSampleSpecimens implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLE_ID")
    private BigInteger sampleId;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
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
    @Size(max = 50)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;

    public QaSampleSpecimens() {
    }

    public QaSampleSpecimens(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigInteger sampleId) {
        this.sampleId = sampleId;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
    }

    public String getLonGps() {
        return lonGps;
    }

    public void setLonGps(String lonGps) {
        this.lonGps = lonGps;
    }

    public String getAltGps() {
        return altGps;
    }

    public void setAltGps(String altGps) {
        this.altGps = altGps;
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
        if (!(object instanceof QaSampleSpecimens)) {
            return false;
        }
        QaSampleSpecimens other = (QaSampleSpecimens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleSpecimens[ id=" + id + " ]";
    }
    
}
