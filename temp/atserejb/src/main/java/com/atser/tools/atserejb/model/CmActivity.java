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
@NamedQuery(name = "CmActivity.findByParentId", query = "SELECT c FROM CmActivity c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmActivity.findByALetter", query = "SELECT c FROM CmActivity c WHERE c.aLetter = :aLetter"),
    @NamedQuery(name = "CmActivity.findByRemarks", query = "SELECT c FROM CmActivity c WHERE c.remarks = :remarks"),
    @NamedQuery(name = "CmActivity.findByActive", query = "SELECT c FROM CmActivity c WHERE c.active = :active"),
    @NamedQuery(name = "CmActivity.findByLastMod", query = "SELECT c FROM CmActivity c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmActivity.findByLastModBy", query = "SELECT c FROM CmActivity c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmActivity.findByLastModIp", query = "SELECT c FROM CmActivity c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmActivity.findByCreateBy", query = "SELECT c FROM CmActivity c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmActivity.findByCreateByIp", query = "SELECT c FROM CmActivity c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmActivity.findByCreateDate", query = "SELECT c FROM CmActivity c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CmActivity.findByAName", query = "SELECT c FROM CmActivity c WHERE c.aName = :aName")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_ACTIVITY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmActivity.findAll", query = "SELECT c FROM CmActivity c"),
    @NamedQuery(name = "CmActivity.findById", query = "SELECT c FROM CmActivity c WHERE c.id = :id")})
public class CmActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Size(max = 10)
    @Column(name = "A_LETTER")
    private String aLetter;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 250)
    @Column(name = "A_NAME")
    private String aName;
    @OneToMany(mappedBy = "activityId")
    private List<CmFormType> cmFormTypeList;
    @JoinColumn(name = "PHASE_ID", referencedColumnName = "ID")
    @ManyToOne
    private CmPhase phaseId;

    public CmActivity() {
    }

    public CmActivity(BigDecimal id) {
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

    public String getALetter() {
        return aLetter;
    }

    public void setALetter(String aLetter) {
        this.aLetter = aLetter;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    @XmlTransient
    public List<CmFormType> getCmFormTypeList() {
        return cmFormTypeList;
    }

    public void setCmFormTypeList(List<CmFormType> cmFormTypeList) {
        this.cmFormTypeList = cmFormTypeList;
    }

    public CmPhase getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(CmPhase phaseId) {
        this.phaseId = phaseId;
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
        if (!(object instanceof CmActivity)) {
            return false;
        }
        CmActivity other = (CmActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmActivity[ id=" + id + " ]";
    }
    
}
