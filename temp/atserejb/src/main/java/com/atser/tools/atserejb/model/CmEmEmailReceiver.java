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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_EM_EMAIL_RECEIVER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmEmEmailReceiver.findAll", query = "SELECT c FROM CmEmEmailReceiver c")
    , @NamedQuery(name = "CmEmEmailReceiver.findById", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.id = :id")
    , @NamedQuery(name = "CmEmEmailReceiver.findByEmailId", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.emailId = :emailId")
    , @NamedQuery(name = "CmEmEmailReceiver.findByToUserid", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.toUserid = :toUserid")
    , @NamedQuery(name = "CmEmEmailReceiver.findByCcUserid", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.ccUserid = :ccUserid")
    , @NamedQuery(name = "CmEmEmailReceiver.findByToGroupid", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.toGroupid = :toGroupid")
    , @NamedQuery(name = "CmEmEmailReceiver.findByCcGroupid", query = "SELECT c FROM CmEmEmailReceiver c WHERE c.ccGroupid = :ccGroupid")})
public class CmEmEmailReceiver implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMAIL_ID")
    private BigInteger emailId;
    @Column(name = "TO_USERID")
    private BigInteger toUserid;
    @Column(name = "CC_USERID")
    private BigInteger ccUserid;
    @Column(name = "TO_GROUPID")
    private BigInteger toGroupid;
    @Column(name = "CC_GROUPID")
    private BigInteger ccGroupid;

    public CmEmEmailReceiver() {
    }

    public CmEmEmailReceiver(BigDecimal id) {
        this.id = id;
    }

    public CmEmEmailReceiver(BigDecimal id, BigInteger emailId) {
        this.id = id;
        this.emailId = emailId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEmailId() {
        return emailId;
    }

    public void setEmailId(BigInteger emailId) {
        this.emailId = emailId;
    }

    public BigInteger getToUserid() {
        return toUserid;
    }

    public void setToUserid(BigInteger toUserid) {
        this.toUserid = toUserid;
    }

    public BigInteger getCcUserid() {
        return ccUserid;
    }

    public void setCcUserid(BigInteger ccUserid) {
        this.ccUserid = ccUserid;
    }

    public BigInteger getToGroupid() {
        return toGroupid;
    }

    public void setToGroupid(BigInteger toGroupid) {
        this.toGroupid = toGroupid;
    }

    public BigInteger getCcGroupid() {
        return ccGroupid;
    }

    public void setCcGroupid(BigInteger ccGroupid) {
        this.ccGroupid = ccGroupid;
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
        if (!(object instanceof CmEmEmailReceiver)) {
            return false;
        }
        CmEmEmailReceiver other = (CmEmEmailReceiver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmEmEmailReceiver[ id=" + id + " ]";
    }
    
}
