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
@Table(name = "CM_CONTRACT_NOTIFY_EM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContractNotifyEm.findAll", query = "SELECT c FROM CmContractNotifyEm c")
    , @NamedQuery(name = "CmContractNotifyEm.findById", query = "SELECT c FROM CmContractNotifyEm c WHERE c.id = :id")
    , @NamedQuery(name = "CmContractNotifyEm.findByFormDataId", query = "SELECT c FROM CmContractNotifyEm c WHERE c.formDataId = :formDataId")
    , @NamedQuery(name = "CmContractNotifyEm.findByGroupId", query = "SELECT c FROM CmContractNotifyEm c WHERE c.groupId = :groupId")
    , @NamedQuery(name = "CmContractNotifyEm.findByPersonId", query = "SELECT c FROM CmContractNotifyEm c WHERE c.personId = :personId")
    , @NamedQuery(name = "CmContractNotifyEm.findByEmailList", query = "SELECT c FROM CmContractNotifyEm c WHERE c.emailList = :emailList")
    , @NamedQuery(name = "CmContractNotifyEm.findByEmailNote", query = "SELECT c FROM CmContractNotifyEm c WHERE c.emailNote = :emailNote")
    , @NamedQuery(name = "CmContractNotifyEm.findByNoticeSendDate", query = "SELECT c FROM CmContractNotifyEm c WHERE c.noticeSendDate = :noticeSendDate")})
public class CmContractNotifyEm implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FORM_DATA_ID")
    private BigInteger formDataId;
    @Column(name = "GROUP_ID")
    private BigInteger groupId;
    @Column(name = "PERSON_ID")
    private BigInteger personId;
    @Size(max = 2000)
    @Column(name = "EMAIL_LIST")
    private String emailList;
    @Size(max = 4000)
    @Column(name = "EMAIL_NOTE")
    private String emailNote;
    @Column(name = "NOTICE_SEND_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date noticeSendDate;

    public CmContractNotifyEm() {
    }

    public CmContractNotifyEm(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFormDataId() {
        return formDataId;
    }

    public void setFormDataId(BigInteger formDataId) {
        this.formDataId = formDataId;
    }

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }

    public BigInteger getPersonId() {
        return personId;
    }

    public void setPersonId(BigInteger personId) {
        this.personId = personId;
    }

    public String getEmailList() {
        return emailList;
    }

    public void setEmailList(String emailList) {
        this.emailList = emailList;
    }

    public String getEmailNote() {
        return emailNote;
    }

    public void setEmailNote(String emailNote) {
        this.emailNote = emailNote;
    }

    public Date getNoticeSendDate() {
        return noticeSendDate;
    }

    public void setNoticeSendDate(Date noticeSendDate) {
        this.noticeSendDate = noticeSendDate;
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
        if (!(object instanceof CmContractNotifyEm)) {
            return false;
        }
        CmContractNotifyEm other = (CmContractNotifyEm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContractNotifyEm[ id=" + id + " ]";
    }
    
}
