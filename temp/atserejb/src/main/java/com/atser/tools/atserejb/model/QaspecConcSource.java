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
@Table(name = "QASPEC_CONC_SOURCE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaspecConcSource.findAll", query = "SELECT q FROM QaspecConcSource q"),
    @NamedQuery(name = "QaspecConcSource.findById", query = "SELECT q FROM QaspecConcSource q WHERE q.id = :id"),
    @NamedQuery(name = "QaspecConcSource.findBySource", query = "SELECT q FROM QaspecConcSource q WHERE q.source = :source"),
    @NamedQuery(name = "QaspecConcSource.findByClientId", query = "SELECT q FROM QaspecConcSource q WHERE q.clientId = :clientId")})
public class QaspecConcSource implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "SOURCE", length = 200)
    private String source;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public QaspecConcSource() {
    }

    public QaspecConcSource(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof QaspecConcSource)) {
            return false;
        }
        QaspecConcSource other = (QaspecConcSource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaspecConcSource[ id=" + id + " ]";
    }
    
}
