/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeUSDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeUSSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobNotificationTrack.findByModule", query = "SELECT g FROM GlobNotificationTrack g WHERE g.module = :module")
    , @NamedQuery(name = "GlobNotificationTrack.findByFunctionality", query = "SELECT g FROM GlobNotificationTrack g WHERE g.functionality = :functionality")    
    , @NamedQuery(name = "GlobNotificationTrack.findByCreated", query = "SELECT g FROM GlobNotificationTrack g WHERE g.created = :created")
    , @NamedQuery(name = "GlobNotificationTrack.findByNtfType", query = "SELECT g FROM GlobNotificationTrack g WHERE g.ntfType = :ntfType")
    , @NamedQuery(name = "GlobNotificationTrack.findByStatus", query = "SELECT g FROM GlobNotificationTrack g WHERE g.status = :status")
    , @NamedQuery(name = "GlobNotificationTrack.findByAnswer", query = "SELECT g FROM GlobNotificationTrack g WHERE g.answer = :answer")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_NOTIFICATION_TRACK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobNotificationTrack.findAll", query = "SELECT g FROM GlobNotificationTrack g")
    , @NamedQuery(name = "GlobNotificationTrack.findById", query = "SELECT g FROM GlobNotificationTrack g WHERE g.id = :id")
    , @NamedQuery(name = "GlobNotificationTrack.findByRefidAndStatus", query = "SELECT g FROM GlobNotificationTrack g WHERE g.refid = :refid AND g.status = :status AND g.functionality = :functionality")
    , @NamedQuery(name = "GlobNotificationTrack.findByRefidAndNotSended", query = "SELECT g FROM GlobNotificationTrack g WHERE g.refid = :refid AND g.status != :status AND g.functionality = :functionality")
    , @NamedQuery(name = "GlobNotificationTrack.findByRefid", query = "SELECT g FROM GlobNotificationTrack g WHERE g.refid = :refid AND g.functionality = :functionality")
    , @NamedQuery(name = "GlobNotificationTrack.findByUniqueToken", query = "SELECT g FROM GlobNotificationTrack g WHERE g.uniqueToken = :uniqueToken")})
public class GlobNotificationTrack implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_NOTIFICATION_TRACK_SEQ", sequenceName = "GLOB_NOTIFICATION_TRACK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_NOTIFICATION_TRACK_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "MODULE")
    private String module;
    @Size(max = 100)
    @Column(name = "FUNCTIONALITY")
    private String functionality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFID")
    private BigInteger refid;
    @Basic(optional = false)
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Lob
    @Column(name = "SENT_TO")
    private String sentTo;
    @Lob
    @Column(name = "SENT_FROM")
    private String sentFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NTF_TYPE")
    private String ntfType;
    @Lob
    @Column(name = "SUBJECT")
    private String subject;
    @JsonSkipXssSerialization
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Size(max = 255)
    @Column(name = "UNIQUE_TOKEN")
    private String uniqueToken;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "ANSWER")
    private String answer;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    // @Column(name = "CATEGORY_ID")
    // private BigInteger categoryId;
    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData categoryId;
    @Lob
    @Column(name = "SENDER_INFO")
    private String senderInfo;

    public GlobNotificationTrack() {
    }

    public GlobNotificationTrack(BigDecimal id) {
        this.id = id;
    }

    public GlobNotificationTrack(BigDecimal id, BigInteger refid, Date created, String ntfType) {
        this.id = id;
        this.refid = refid;
        this.created = created;
        this.ntfType = ntfType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public BigInteger getRefid() {
        return refid;
    }

    public void setRefid(BigInteger refid) {
        this.refid = refid;
    }

    @JsonSerialize(using = JsonDateTimeUSSerializer.class)
    @JsonDeserialize(using = JsonDateTimeUSDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getNtfType() {
        return ntfType;
    }

    public void setNtfType(String ntfType) {
        this.ntfType = ntfType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public QmCvlFieldData getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(QmCvlFieldData categoryId) {
        this.categoryId = categoryId;
    }

    public String getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(String senderInfo) {
        this.senderInfo = senderInfo;
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
        if (!(object instanceof GlobNotificationTrack)) {
            return false;
        }
        GlobNotificationTrack other = (GlobNotificationTrack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobNotificationTrack[ id=" + id + " ]";
    }

}
