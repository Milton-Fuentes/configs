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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
    @NamedQuery(name = "QmCvlSection.findByClientId", query = "SELECT q FROM QmCvlSection q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QmCvlSection.findBySectionName", query = "SELECT q FROM QmCvlSection q WHERE q.sectionName = :sectionName"),
    @NamedQuery(name = "QmCvlSection.findByActive", query = "SELECT q FROM QmCvlSection q WHERE q.active = :active"),
    @NamedQuery(name = "QmCvlSection.findByLastMod", query = "SELECT q FROM QmCvlSection q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QmCvlSection.findByLastModBy", query = "SELECT q FROM QmCvlSection q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QmCvlSection.findByLastModIp", query = "SELECT q FROM QmCvlSection q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QmCvlSection.findByCreateDate", query = "SELECT q FROM QmCvlSection q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QmCvlSection.findByCreateBy", query = "SELECT q FROM QmCvlSection q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QmCvlSection.findByCreateByIp", query = "SELECT q FROM QmCvlSection q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QmCvlSection.findByVersion", query = "SELECT q FROM QmCvlSection q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QM_CVL_SECTION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmCvlSection.findAll", query = "SELECT q FROM QmCvlSection q"),
    @NamedQuery(name = "QmCvlSection.findById", query = "SELECT q FROM QmCvlSection q WHERE q.id = :id")})
public class QmCvlSection implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "SECTION_NAME")
    private String sectionName;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @OneToMany(mappedBy = "sectionId", fetch = FetchType.LAZY)
    private List<QmCvlField> qmCvlFieldList;

    public QmCvlSection() {
    }

    public QmCvlSection(BigDecimal id) {
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlTransient
    public List<QmCvlField> getQmCvlFieldList() {
        return qmCvlFieldList;
    }

    public void setQmCvlFieldList(List<QmCvlField> qmCvlFieldList) {
        this.qmCvlFieldList = qmCvlFieldList;
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
        if (!(object instanceof QmCvlSection)) {
            return false;
        }
        QmCvlSection other = (QmCvlSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmCvlSection[ id=" + id + " ]";
    }
    
}
