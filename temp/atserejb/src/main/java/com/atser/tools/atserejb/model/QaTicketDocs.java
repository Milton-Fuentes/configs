/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TICKET_DOCS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTicketDocs.findAll", query = "SELECT q FROM QaTicketDocs q"),
    @NamedQuery(name = "QaTicketDocs.findById", query = "SELECT q FROM QaTicketDocs q WHERE q.id = :id"),
    @NamedQuery(name = "QaTicketDocs.findByTicketId", query = "SELECT q FROM QaTicketDocs q WHERE q.ticketId = :ticketId"),
    @NamedQuery(name = "QaTicketDocs.findBySourcePath", query = "SELECT q FROM QaTicketDocs q WHERE q.sourcePath = :sourcePath"),
    @NamedQuery(name = "QaTicketDocs.findByFTitle", query = "SELECT q FROM QaTicketDocs q WHERE q.fTitle = :fTitle"),
    @NamedQuery(name = "QaTicketDocs.findByExtension", query = "SELECT q FROM QaTicketDocs q WHERE q.extension = :extension"),
    @NamedQuery(name = "QaTicketDocs.findByFName", query = "SELECT q FROM QaTicketDocs q WHERE q.fName = :fName"),
    @NamedQuery(name = "QaTicketDocs.findByNote1", query = "SELECT q FROM QaTicketDocs q WHERE q.note1 = :note1")})
public class QaTicketDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKET_ID")
    private BigInteger ticketId;
    @Size(max = 255)
    @Column(name = "SOURCE_PATH")
    private String sourcePath;
    @Size(max = 255)
    @Column(name = "F_TITLE")
    private String fTitle;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 4000)
    @Column(name = "NOTE1")
    private String note1;

    public QaTicketDocs() {
    }

    public QaTicketDocs(BigDecimal id) {
        this.id = id;
    }

    public QaTicketDocs(BigDecimal id, BigInteger ticketId) {
        this.id = id;
        this.ticketId = ticketId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTicketId() {
        return ticketId;
    }

    public void setTicketId(BigInteger ticketId) {
        this.ticketId = ticketId;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFTitle() {
        return fTitle;
    }

    public void setFTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
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
        if (!(object instanceof QaTicketDocs)) {
            return false;
        }
        QaTicketDocs other = (QaTicketDocs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTicketDocs[ id=" + id + " ]";
    }
    
}
