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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_RELATED", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileRelated.findAll", query = "SELECT g FROM GlobFileRelated g")
    , @NamedQuery(name = "GlobFileRelated.findById", query = "SELECT g FROM GlobFileRelated g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileRelated.findByRelatedId", query = "SELECT g FROM GlobFileRelated g WHERE g.relatedId = :relatedId")
    , @NamedQuery(name = "GlobFileRelated.findByFileId", query = "SELECT g FROM GlobFileRelated g WHERE g.fileId = :fileId")
    , @NamedQuery(name = "GlobFileRelated.findByOwner", query = "SELECT g FROM GlobFileRelated g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobFileRelated.findByCreated", query = "SELECT g FROM GlobFileRelated g WHERE g.created = :created")})
public class GlobFileRelated implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RELATED_ID")
    private BigInteger relatedId;
    @Column(name = "FILE_ID")
    private BigInteger fileId;
    @Column(name = "OWNER")
    private BigInteger owner;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public GlobFileRelated() {
    }

    public GlobFileRelated(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(BigInteger relatedId) {
        this.relatedId = relatedId;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
        if (!(object instanceof GlobFileRelated)) {
            return false;
        }
        GlobFileRelated other = (GlobFileRelated) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileRelated[ id=" + id + " ]";
    }
    
}
