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
    @NamedQuery(name = "QaSampleAssets.findBySampleId", query = "SELECT q FROM QaSampleAssets q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaSampleAssets.findByAssetNo", query = "SELECT q FROM QaSampleAssets q WHERE q.assetNo = :assetNo"),
    @NamedQuery(name = "QaSampleAssets.findByActive", query = "SELECT q FROM QaSampleAssets q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleAssets.findByLastMod", query = "SELECT q FROM QaSampleAssets q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleAssets.findByLastModBy", query = "SELECT q FROM QaSampleAssets q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleAssets.findByLastModIp", query = "SELECT q FROM QaSampleAssets q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleAssets.findByCreateDate", query = "SELECT q FROM QaSampleAssets q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSampleAssets.findByCreateBy", query = "SELECT q FROM QaSampleAssets q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSampleAssets.findByCreateByIp", query = "SELECT q FROM QaSampleAssets q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleAssets.findByVersion", query = "SELECT q FROM QaSampleAssets q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleAssets.findByLatGps", query = "SELECT q FROM QaSampleAssets q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QaSampleAssets.findByLonGps", query = "SELECT q FROM QaSampleAssets q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QaSampleAssets.findByAltGps", query = "SELECT q FROM QaSampleAssets q WHERE q.altGps = :altGps")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_SAMPLE_ASSETS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleAssets.findAll", query = "SELECT q FROM QaSampleAssets q"),
    @NamedQuery(name = "QaSampleAssets.findById", query = "SELECT q FROM QaSampleAssets q WHERE q.id = :id")})
public class QaSampleAssets implements Serializable {

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
    @Column(name = "ASSET_NO")
    private String assetNo;
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
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;

    public QaSampleAssets() {
    }

    public QaSampleAssets(BigDecimal id) {
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

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
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
        if (!(object instanceof QaSampleAssets)) {
            return false;
        }
        QaSampleAssets other = (QaSampleAssets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleAssets[ id=" + id + " ]";
    }
    
}
