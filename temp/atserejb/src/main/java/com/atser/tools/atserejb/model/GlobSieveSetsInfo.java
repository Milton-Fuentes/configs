/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
@NamedQuery(name = "GlobSieveSetsInfo.findByClientId", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByCategoryId", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.categoryId = :categoryId"),
    @NamedQuery(name = "GlobSieveSetsInfo.findBySetName", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.setName = :setName"),
    @NamedQuery(name = "GlobSieveSetsInfo.findBySpecSection", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.specSection = :specSection"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByRemarks", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByField1", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByField2", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByCreateBy", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByCreateByIp", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByCreateDateTmp", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "GlobSieveSetsInfo.findByCreateDate", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.createDate = :createDate")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SIEVE_SETS_INFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSieveSetsInfo.findAll", query = "SELECT g FROM GlobSieveSetsInfo g"),
    @NamedQuery(name = "GlobSieveSetsInfo.findById", query = "SELECT g FROM GlobSieveSetsInfo g WHERE g.id = :id")})
public class GlobSieveSetsInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @JoinColumn(name = "CATEGORY_ID")
    @ManyToOne(optional = false)
    private QaSampleCatg categoryId;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Size(max = 50)
    @Column(name = "SPEC_SECTION")
    private String specSection;
    @Size(max = 200)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GlobSieveSets> globSieveSetsList;

    public GlobSieveSetsInfo() {
    }

    public GlobSieveSetsInfo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public QaSampleCatg getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(QaSampleCatg categoryId) {
        this.categoryId = categoryId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSpecSection() {
        return specSection;
    }

    public void setSpecSection(String specSection) {
        this.specSection = specSection;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    public List<GlobSieveSets> getGlobSieveSetsList() {
        return globSieveSetsList;
    }

    public void setGlobSieveSetsList(List<GlobSieveSets> globSieveSetsList) {
        this.globSieveSetsList = globSieveSetsList;
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
        if (!(object instanceof GlobSieveSetsInfo)) {
            return false;
        }
        GlobSieveSetsInfo other = (GlobSieveSetsInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSieveSetsInfo[ id=" + id + " ]";
    }

}
