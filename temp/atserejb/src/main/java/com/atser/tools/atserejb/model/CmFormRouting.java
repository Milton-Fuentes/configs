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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "CmFormRouting.findByParentId", query = "SELECT c FROM CmFormRouting c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmFormRouting.findByAuthor", query = "SELECT c FROM CmFormRouting c WHERE c.author = :author"),
    @NamedQuery(name = "CmFormRouting.findBySend", query = "SELECT c FROM CmFormRouting c WHERE c.send = :send"),
    @NamedQuery(name = "CmFormRouting.findByRespSubject", query = "SELECT c FROM CmFormRouting c WHERE c.respSubject = :respSubject"),
    @NamedQuery(name = "CmFormRouting.findByRespType", query = "SELECT c FROM CmFormRouting c WHERE c.respType = :respType"),
    @NamedQuery(name = "CmFormRouting.findByRespRequired", query = "SELECT c FROM CmFormRouting c WHERE c.respRequired = :respRequired"),
    @NamedQuery(name = "CmFormRouting.findByRespBy", query = "SELECT c FROM CmFormRouting c WHERE c.respBy = :respBy"),
    @NamedQuery(name = "CmFormRouting.findByPriority", query = "SELECT c FROM CmFormRouting c WHERE c.priority = :priority"),
    @NamedQuery(name = "CmFormRouting.findByRType", query = "SELECT c FROM CmFormRouting c WHERE c.rType = :rType"),
    @NamedQuery(name = "CmFormRouting.findByComments", query = "SELECT c FROM CmFormRouting c WHERE c.comments = :comments"),
    @NamedQuery(name = "CmFormRouting.findByReceiver", query = "SELECT c FROM CmFormRouting c WHERE c.receiver = :receiver"),
    @NamedQuery(name = "CmFormRouting.findByCc", query = "SELECT c FROM CmFormRouting c WHERE c.cc = :cc"),
    @NamedQuery(name = "CmFormRouting.findByCcParent", query = "SELECT c FROM CmFormRouting c WHERE c.ccParent = :ccParent"),
    @NamedQuery(name = "CmFormRouting.findByOpened", query = "SELECT c FROM CmFormRouting c WHERE c.opened = :opened"),
    @NamedQuery(name = "CmFormRouting.findByResponded", query = "SELECT c FROM CmFormRouting c WHERE c.responded = :responded")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_ROUTING", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormRouting.findAll", query = "SELECT c FROM CmFormRouting c"),
    @NamedQuery(name = "CmFormRouting.findById", query = "SELECT c FROM CmFormRouting c WHERE c.id = :id")})
public class CmFormRouting implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "AUTHOR")
    private BigInteger author;
    @Column(name = "SEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date send;
    @Size(max = 150)
    @Column(name = "RESP_SUBJECT")
    private String respSubject;
    @Size(max = 50)
    @Column(name = "RESP_TYPE")
    private String respType;
    @Column(name = "RESP_REQUIRED")
    private Character respRequired;
    @Column(name = "RESP_BY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date respBy;
    @Size(max = 50)
    @Column(name = "PRIORITY")
    private String priority;
    @Size(max = 50)
    @Column(name = "R_TYPE")
    private String rType;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "RECEIVER")
    private BigInteger receiver;
    @Size(max = 250)
    @Column(name = "CC")
    private String cc;
    @Column(name = "CC_PARENT")
    private BigInteger ccParent;
    @Column(name = "OPENED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opened;
    @Column(name = "RESPONDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responded;
    @JoinColumn(name = "CM_FORM_ID", referencedColumnName = "ID")
    @ManyToOne
    private CmForm cmFormId;

    public CmFormRouting() {
    }

    public CmFormRouting(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Date getSend() {
        return send;
    }

    public void setSend(Date send) {
        this.send = send;
    }

    public String getRespSubject() {
        return respSubject;
    }

    public void setRespSubject(String respSubject) {
        this.respSubject = respSubject;
    }

    public String getRespType() {
        return respType;
    }

    public void setRespType(String respType) {
        this.respType = respType;
    }

    public Character getRespRequired() {
        return respRequired;
    }

    public void setRespRequired(Character respRequired) {
        this.respRequired = respRequired;
    }

    public Date getRespBy() {
        return respBy;
    }

    public void setRespBy(Date respBy) {
        this.respBy = respBy;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRType() {
        return rType;
    }

    public void setRType(String rType) {
        this.rType = rType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigInteger getReceiver() {
        return receiver;
    }

    public void setReceiver(BigInteger receiver) {
        this.receiver = receiver;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public BigInteger getCcParent() {
        return ccParent;
    }

    public void setCcParent(BigInteger ccParent) {
        this.ccParent = ccParent;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public Date getResponded() {
        return responded;
    }

    public void setResponded(Date responded) {
        this.responded = responded;
    }

    public CmForm getCmFormId() {
        return cmFormId;
    }

    public void setCmFormId(CmForm cmFormId) {
        this.cmFormId = cmFormId;
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
        if (!(object instanceof CmFormRouting)) {
            return false;
        }
        CmFormRouting other = (CmFormRouting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormRouting[ id=" + id + " ]";
    }
    
}
