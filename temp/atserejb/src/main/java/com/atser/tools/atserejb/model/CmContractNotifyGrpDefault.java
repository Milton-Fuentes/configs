/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CM_CONTRACT_NOTIFY_GRP_DEFAULT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContractNotifyGrpDefault.findAll", query = "SELECT c FROM CmContractNotifyGrpDefault c")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findById", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.id = :id")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findByGroupName", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.groupName = :groupName")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findByDescription", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.description = :description")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findByEmailSubject", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.emailSubject = :emailSubject")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findByEmailContent", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.emailContent = :emailContent")
    , @NamedQuery(name = "CmContractNotifyGrpDefault.findByGroupType", query = "SELECT c FROM CmContractNotifyGrpDefault c WHERE c.groupType = :groupType")})
public class CmContractNotifyGrpDefault implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "GROUP_NAME")
    private String groupName;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 1000)
    @Column(name = "EMAIL_SUBJECT")
    private String emailSubject;
    @Size(max = 2000)
    @Column(name = "EMAIL_CONTENT")
    private String emailContent;
    @Size(max = 100)
    @Column(name = "GROUP_TYPE")
    private String groupType;

    public CmContractNotifyGrpDefault() {
    }

    public CmContractNotifyGrpDefault(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
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
        if (!(object instanceof CmContractNotifyGrpDefault)) {
            return false;
        }
        CmContractNotifyGrpDefault other = (CmContractNotifyGrpDefault) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContractNotifyGrpDefault[ id=" + id + " ]";
    }
    
}
