/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.number.NumberSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dperez
 */
@Entity
@Table(name = "BPMCORRESPONDENCEMETADATA", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmcorrespondencemetadata.findAll", query = "SELECT b FROM Bpmcorrespondencemetadata b"),
    @NamedQuery(name = "Bpmcorrespondencemetadata.findByPersistenceid", query = "SELECT b FROM Bpmcorrespondencemetadata b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmcorrespondencemetadata.findByPersistenceversion", query = "SELECT b FROM Bpmcorrespondencemetadata b WHERE b.persistenceversion = :persistenceversion"),
    @NamedQuery(name = "Bpmcorrespondencemetadata.findByRevision", query = "SELECT b FROM Bpmcorrespondencemetadata b WHERE b.revision = :revision")})
public class Bpmcorrespondencemetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "BPMCORRESPONDENCEMETADATA_SEQ", sequenceName = "BPMCORRESPONDENCEMETADATA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMCORRESPONDENCEMETADATA_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;

    @Size(max = 55)
    @Column(name = "SENT_RECEIVED")
    private String sentReceived;

    @Size(max = 255)
    @Column(name = "SENT_RECEIVED_DATE")
    private String sentReceivedDate;

    @Size(max = 255)
    @Column(name = "DELIVERY_METHOD")
    private String deliveryMethod;

    @Size(max = 255)
    @Column(name = "TRACKING_NUMBER")
    private String trackingNumber;

    @Size(max = 55)
    @Column(name = "COMPANY_SENT_TO")
    private String companySentTo;

    @Size(max = 55)
    @Column(name = "PERSON_SENT_TO")
    private String personSentTo;

    @Size(max = 255)
    @Column(name = "SUBJECT")
    private String subject;

    @Size(max = 255)
    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;

    @Size(max = 255)
    @Column(name = "REVISION")
    private String revision;

    @JsonIgnore
    @OneToMany(mappedBy = "dcDataPid")
    private List<Bpmcorrespondencebo> bpmcorrespondenceboList;

    public Bpmcorrespondencemetadata() {
    }

    public Bpmcorrespondencemetadata(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmcorrespondencemetadata(String persistenceid) {
        this.persistenceid = NumberSupport.getBigDecimal(persistenceid);
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public String getSentReceived() {
        return sentReceived;
    }

    public void setSentReceived(String sentReceived) {
        this.sentReceived = sentReceived;
    }

    public String getSentReceivedDate() {
        return sentReceivedDate;
    }

    public void setSentReceivedDate(String sentReceivedDate) {
        this.sentReceivedDate = sentReceivedDate;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCompanySentTo() {
        return companySentTo;
    }

    public void setCompanySentTo(String companySentTo) {
        this.companySentTo = companySentTo;
    }

    public String getPersonSentTo() {
        return personSentTo;
    }

    public void setPersonSentTo(String personSentTo) {
        this.personSentTo = personSentTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<Bpmcorrespondencebo> getBpmcorrespondenceboList() {
        return bpmcorrespondenceboList;
    }

    public void setBpmcorrespondenceboList(List<Bpmcorrespondencebo> bpmcorrespondenceboList) {
        this.bpmcorrespondenceboList = bpmcorrespondenceboList;
    }

    public BigInteger getPersistenceversion() {
        return persistenceversion;
    }

    public void setPersistenceversion(BigInteger persistenceversion) {
        this.persistenceversion = persistenceversion;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persistenceid != null ? persistenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bpmcorrespondencemetadata)) {
            return false;
        }
        Bpmcorrespondencemetadata other = (Bpmcorrespondencemetadata) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmcorrespondencemetadata[ persistenceid=" + persistenceid + " ]";
    }

}
