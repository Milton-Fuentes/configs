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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "GlobStakeholderGroup.findByName", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.name = :name")
    , @NamedQuery(name = "GlobStakeholderGroup.findByDescription", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.description = :description")
    , @NamedQuery(name = "GlobStakeholderGroup.findByStatus", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.status = :status")
    , @NamedQuery(name = "GlobStakeholderGroup.findByClientId", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobStakeholderGroup.findByCreateDate", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.createDate = :createDate")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_STAKEHOLDER_GROUP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobStakeholderGroup.findAll", query = "SELECT g FROM GlobStakeholderGroup g"),
    @NamedQuery(name = "GlobStakeholderGroup.findById", query = "SELECT g FROM GlobStakeholderGroup g WHERE g.id = :id")})
public class GlobStakeholderGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @NotNull
    @Basic(optional = false)
    @Column(name = "ID")
    @SequenceGenerator(name = "GLOB_STAKEHOLDER_GROUP_SEQ", sequenceName = "GLOB_STAKEHOLDER_GROUP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_STAKEHOLDER_GROUP_SEQ")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "NAME")
    private String name;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinTable(name = "GLOB_STAKEHOLDER_GROUP_STK",
            joinColumns = {
                @JoinColumn(name = "ID_STKGROUP", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_STK", referencedColumnName = "ID")}
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private List<GlobStakeholder> globStakeholderList;

    public GlobStakeholderGroup() {
    }

    public GlobStakeholderGroup(BigDecimal id) {
        this.id = id;
    }

    public GlobStakeholderGroup(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    public List<GlobStakeholder> getGlobStakeholderList() {
        return globStakeholderList;
    }

    public void setGlobStakeholderList(List<GlobStakeholder> globStakeholderList) {
        this.globStakeholderList = globStakeholderList;
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
        if (!(object instanceof GlobStakeholderGroup)) {
            return false;
        }
        GlobStakeholderGroup other = (GlobStakeholderGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobStakeholderGroup[ id=" + id + " ]";
    }

}