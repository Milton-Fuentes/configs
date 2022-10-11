/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "GLOB_FILE_NOTIFY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileNotify.findAll", query = "SELECT g FROM GlobFileNotify g"),
    @NamedQuery(name = "GlobFileNotify.findById", query = "SELECT g FROM GlobFileNotify g WHERE g.id = :id"),
    @NamedQuery(name = "GlobFileNotify.findByFileId", query = "SELECT g FROM GlobFileNotify g WHERE g.fileId = :fileId"),
    @NamedQuery(name = "GlobFileNotify.findBySenderId", query = "SELECT g FROM GlobFileNotify g WHERE g.senderId = :senderId"),
    @NamedQuery(name = "GlobFileNotify.findByRecieverId", query = "SELECT g FROM GlobFileNotify g WHERE g.recieverId = :recieverId"),
    @NamedQuery(name = "GlobFileNotify.findByDateNotify", query = "SELECT g FROM GlobFileNotify g WHERE g.dateNotify = :dateNotify"),
    @NamedQuery(name = "GlobFileNotify.findBySiteauditId", query = "SELECT g FROM GlobFileNotify g WHERE g.siteauditId = :siteauditId")})
public class GlobFileNotify implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_FILE_NOTIFY_ID_SEQ", sequenceName = "GLOB_FILE_NOTIFY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_FILE_NOTIFY_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FILE_ID")
    private BigInteger fileId;

    @JoinColumn(name = "SENDER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobUsers senderId;

    @JoinColumn(name = "RECIEVER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobUsers recieverId;

    @Column(name = "DATE_NOTIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNotify;

    @JoinColumn(name = "SITEAUDIT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobSiteaudit siteauditId;

    public GlobFileNotify() {
    }

    public GlobFileNotify(BigDecimal id) {
        this.id = id;
    }

    public GlobFileNotify(BigInteger fileId, GlobUsers senderId, GlobUsers recieverId, Date dateNotify, GlobSiteaudit siteauditId) {
        this.fileId = fileId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.dateNotify = dateNotify;
        this.siteauditId = siteauditId;
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

    public GlobUsers getSenderId() {
        return senderId;
    }

    public void setSenderId(GlobUsers senderId) {
        this.senderId = senderId;
    }

    public GlobUsers getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(GlobUsers recieverId) {
        this.recieverId = recieverId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @JsonGetter("dateNotify")
    public Date getDateNotify() {
        return dateNotify;
    }

    public void setDateNotify(Date dateNotify) {
        this.dateNotify = dateNotify;
    }

    public GlobSiteaudit getSiteauditId() {
        return siteauditId;
    }

    public void setSiteauditId(GlobSiteaudit siteauditId) {
        this.siteauditId = siteauditId;
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
        if (!(object instanceof GlobFileNotify)) {
            return false;
        }
        GlobFileNotify other = (GlobFileNotify) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileNotify[ id=" + id + " ]";
    }

}
