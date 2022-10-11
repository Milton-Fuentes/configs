/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@NamedQuery(name = "QaSampleLocationRecord.findByLocationId", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.locationId = :locationId"),
    @NamedQuery(name = "QaSampleLocationRecord.findByContactId", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.contactId = :contactId"),
    @NamedQuery(name = "QaSampleLocationRecord.findByDateTime", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.dateTime = :dateTime"),
    @NamedQuery(name = "QaSampleLocationRecord.findByRemark", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.remark = :remark"),
    @NamedQuery(name = "QaSampleLocationRecord.findByActive", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleLocationRecord.findBySampleId", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaSampleLocationRecord.findByVersion", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_SAMPLE_LOCATION_RECORD", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleLocationRecord.findAll", query = "SELECT q FROM QaSampleLocationRecord q"),
    @NamedQuery(name = "QaSampleLocationRecord.findById", query = "SELECT q FROM QaSampleLocationRecord q WHERE q.id = :id")})
public class QaSampleLocationRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "LOCATION_ID")
    private String locationId;
    @Column(name = "CONTACT_ID")
    private BigInteger contactId;
    @Column(name = "DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Size(max = 250)
    @Column(name = "REMARK")
    private String remark;
    @Size(max = 1)
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "SAMPLE_ID")
    private BigInteger sampleId;
    @Column(name = "VERSION")
    private BigInteger version;

    public QaSampleLocationRecord() {
    }

    public QaSampleLocationRecord(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public BigInteger getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigInteger sampleId) {
        this.sampleId = sampleId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
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
        if (!(object instanceof QaSampleLocationRecord)) {
            return false;
        }
        QaSampleLocationRecord other = (QaSampleLocationRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleLocationRecord[ id=" + id + " ]";
    }
    
}
