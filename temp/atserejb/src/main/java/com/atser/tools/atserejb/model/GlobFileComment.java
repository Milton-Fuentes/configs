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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_COMMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileComment.findAll", query = "SELECT g FROM GlobFileComment g")
    , @NamedQuery(name = "GlobFileComment.findById", query = "SELECT g FROM GlobFileComment g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileComment.findByFileId", query = "SELECT g FROM GlobFileComment g WHERE g.fileId = :fileId")
    , @NamedQuery(name = "GlobFileComment.findByParentId", query = "SELECT g FROM GlobFileComment g WHERE g.parentId = :parentId")
    , @NamedQuery(name = "GlobFileComment.findByAuthor", query = "SELECT g FROM GlobFileComment g WHERE g.author = :author")
    , @NamedQuery(name = "GlobFileComment.findByCreated", query = "SELECT g FROM GlobFileComment g WHERE g.created = :created")
    , @NamedQuery(name = "GlobFileComment.findBySubject", query = "SELECT g FROM GlobFileComment g WHERE g.subject = :subject")
    , @NamedQuery(name = "GlobFileComment.findByComments", query = "SELECT g FROM GlobFileComment g WHERE g.comments = :comments")})
public class GlobFileComment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FILE_ID")
    private BigInteger fileId;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "AUTHOR")
    private BigInteger author;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 50)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;

    public GlobFileComment() {
    }

    public GlobFileComment(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public BigInteger getAuthor() {
        return author;
    }

    public void setAuthor(BigInteger author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        if (!(object instanceof GlobFileComment)) {
            return false;
        }
        GlobFileComment other = (GlobFileComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileComment[ id=" + id + " ]";
    }
    
}
