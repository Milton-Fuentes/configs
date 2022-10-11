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
 * @author droldan
 */
@Entity
@Table(name = "BPMRFIMETADATA", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmrfimetadata.findAll", query = "SELECT b FROM Bpmrfimetadata b")
    , @NamedQuery(name = "Bpmrfimetadata.findByPersistenceid", query = "SELECT b FROM Bpmrfimetadata b WHERE b.persistenceid = :persistenceid")
    , @NamedQuery(name = "Bpmrfimetadata.findByContentType", query = "SELECT b FROM Bpmrfimetadata b WHERE b.contentType = :contentType")
    , @NamedQuery(name = "Bpmrfimetadata.findByDiscipline", query = "SELECT b FROM Bpmrfimetadata b WHERE b.discipline = :discipline")
    , @NamedQuery(name = "Bpmrfimetadata.findByDocumentType", query = "SELECT b FROM Bpmrfimetadata b WHERE b.documentType = :documentType")
    , @NamedQuery(name = "Bpmrfimetadata.findByExternalUrl", query = "SELECT b FROM Bpmrfimetadata b WHERE b.externalUrl = :externalUrl")
    , @NamedQuery(name = "Bpmrfimetadata.findByKeywords", query = "SELECT b FROM Bpmrfimetadata b WHERE b.keywords = :keywords")
    , @NamedQuery(name = "Bpmrfimetadata.findByPersistenceversion", query = "SELECT b FROM Bpmrfimetadata b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpmrfimetadata.findByRevision", query = "SELECT b FROM Bpmrfimetadata b WHERE b.revision = :revision")})
public class Bpmrfimetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMRFIMETADATA_SEQ", sequenceName = "BPMRFIMETADATA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMRFIMETADATA_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Size(max = 255)
    @Column(name = "CONTENT_TYPE")
    private String contentType;
    @Size(max = 255)
    @Column(name = "DISCIPLINE")
    private String discipline;
    @Size(max = 255)
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;
    @Size(max = 255)
    @Column(name = "EXTERNAL_URL")
    private String externalUrl;
    @Size(max = 255)
    @Column(name = "KEYWORDS")
    private String keywords;
    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;
    @Size(max = 255)
    @Column(name = "REVISION")
    private String revision;
    @Size(max = 255)
    @Column(name = "REVISION_DATE")
    private String revisionDate;
    @JsonIgnore
    @OneToMany(mappedBy = "dcDataPid")
    private List<Bpmrfibo> bpmrfiboList;

    public Bpmrfimetadata() {
    }

    public Bpmrfimetadata(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }
    
    public Bpmrfimetadata(String persistenceid) {
        this.persistenceid = NumberSupport.getBigDecimal(persistenceid);
    }


    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public String getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }
    
    @XmlTransient
    public List<Bpmrfibo> getBpmrfiboList() {
        return bpmrfiboList;
    }

    public void setBpmrfiboList(List<Bpmrfibo> bpmrfiboList) {
        this.bpmrfiboList = bpmrfiboList;
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
        if (!(object instanceof Bpmrfimetadata)) {
            return false;
        }
        Bpmrfimetadata other = (Bpmrfimetadata) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmrfimetadata[ persistenceid=" + persistenceid + " ]";
    }
    
}
