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
@NamedQuery(name = "CmForm.findByFormTypeId", query = "SELECT c FROM CmForm c WHERE c.formTypeId = :formTypeId"),
    @NamedQuery(name = "CmForm.findByContractId", query = "SELECT c FROM CmForm c WHERE c.contractId = :contractId"),
    @NamedQuery(name = "CmForm.findByActive", query = "SELECT c FROM CmForm c WHERE c.active = :active"),
    @NamedQuery(name = "CmForm.findByLastMod", query = "SELECT c FROM CmForm c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmForm.findByLastModBy", query = "SELECT c FROM CmForm c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmForm.findByLastModIp", query = "SELECT c FROM CmForm c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmForm.findByCreateBy", query = "SELECT c FROM CmForm c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmForm.findByCreateByIp", query = "SELECT c FROM CmForm c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmForm.findByCreateDate", query = "SELECT c FROM CmForm c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CmForm.findByParentId", query = "SELECT c FROM CmForm c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmForm.findByAlerted", query = "SELECT c FROM CmForm c WHERE c.alerted = :alerted"),
    @NamedQuery(name = "CmForm.findByTechnicalAppv", query = "SELECT c FROM CmForm c WHERE c.technicalAppv = :technicalAppv"),
    @NamedQuery(name = "CmForm.findByTechnicalAppvDate", query = "SELECT c FROM CmForm c WHERE c.technicalAppvDate = :technicalAppvDate"),
    @NamedQuery(name = "CmForm.findByTimecostAppv", query = "SELECT c FROM CmForm c WHERE c.timecostAppv = :timecostAppv"),
    @NamedQuery(name = "CmForm.findByTimecostAppvDate", query = "SELECT c FROM CmForm c WHERE c.timecostAppvDate = :timecostAppvDate"),
    @NamedQuery(name = "CmForm.findByAlertedClose", query = "SELECT c FROM CmForm c WHERE c.alertedClose = :alertedClose")
*/

/*
-- RFI
SELECT cmfd.* FROM cm_form cmf INNER JOIN cm_form_data cmfd ON (cmf.id=cmfd.cm_form_id)
WHERE cmf.active = 'Y' AND cmf.form_type_id=69 AND cmf.bpm_process_done = 'N' ;

-- Submittal
SELECT cmfd.* FROM cm_form cmf INNER JOIN cm_form_data cmfd ON (cmf.id=cmfd.cm_form_id)
WHERE cmf.active = 'Y' AND cmf.form_type_id=115 AND cmf.bpm_process_done = 'N';
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmForm.findAll", query = "SELECT c FROM CmForm c"),
    @NamedQuery(name = "CmForm.findById", query = "SELECT c FROM CmForm c WHERE c.id = :id")})
public class CmForm implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORM_TYPE_ID")
    private BigInteger formTypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
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
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "ALERTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alerted;
    @Column(name = "TECHNICAL_APPV")
    private Character technicalAppv;
    @Column(name = "TECHNICAL_APPV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date technicalAppvDate;
    @Column(name = "TIMECOST_APPV")
    private Character timecostAppv;
    @Column(name = "TIMECOST_APPV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timecostAppvDate;
    @Column(name = "ALERTED_CLOSE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alertedClose;
    @Column(name = "BPM_PROCESS_DONE")
    private Character bpmProcessDone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmFormId")
    private List<CmFormData> cmFormDataList;
    @OneToMany(mappedBy = "cmFormId")
    private List<CmFormAttach> cmFormAttachList;
    @OneToMany(mappedBy = "cmFormId")
    private List<CmFormRouting> cmFormRoutingList;

    public CmForm() {
    }

    public CmForm(BigDecimal id) {
        this.id = id;
    }

    public CmForm(BigDecimal id, BigInteger formTypeId, BigInteger contractId) {
        this.id = id;
        this.formTypeId = formTypeId;
        this.contractId = contractId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFormTypeId() {
        return formTypeId;
    }

    public void setFormTypeId(BigInteger formTypeId) {
        this.formTypeId = formTypeId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
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

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public Date getAlerted() {
        return alerted;
    }

    public void setAlerted(Date alerted) {
        this.alerted = alerted;
    }

    public Character getTechnicalAppv() {
        return technicalAppv;
    }

    public void setTechnicalAppv(Character technicalAppv) {
        this.technicalAppv = technicalAppv;
    }

    public Date getTechnicalAppvDate() {
        return technicalAppvDate;
    }

    public void setTechnicalAppvDate(Date technicalAppvDate) {
        this.technicalAppvDate = technicalAppvDate;
    }

    public Character getTimecostAppv() {
        return timecostAppv;
    }

    public void setTimecostAppv(Character timecostAppv) {
        this.timecostAppv = timecostAppv;
    }

    public Date getTimecostAppvDate() {
        return timecostAppvDate;
    }

    public void setTimecostAppvDate(Date timecostAppvDate) {
        this.timecostAppvDate = timecostAppvDate;
    }

    public Date getAlertedClose() {
        return alertedClose;
    }

    public void setAlertedClose(Date alertedClose) {
        this.alertedClose = alertedClose;
    }

    public Character getBpmProcessDone() {
        return bpmProcessDone;
    }

    public void setBpmProcessDone(Character bpmProcessDone) {
        this.bpmProcessDone = bpmProcessDone;
    }

    @XmlTransient
    public List<CmFormData> getCmFormDataList() {
        return cmFormDataList;
    }

    public void setCmFormDataList(List<CmFormData> cmFormDataList) {
        this.cmFormDataList = cmFormDataList;
    }

    @XmlTransient
    public List<CmFormAttach> getCmFormAttachList() {
        return cmFormAttachList;
    }

    public void setCmFormAttachList(List<CmFormAttach> cmFormAttachList) {
        this.cmFormAttachList = cmFormAttachList;
    }

    @XmlTransient
    public List<CmFormRouting> getCmFormRoutingList() {
        return cmFormRoutingList;
    }

    public void setCmFormRoutingList(List<CmFormRouting> cmFormRoutingList) {
        this.cmFormRoutingList = cmFormRoutingList;
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
        if (!(object instanceof CmForm)) {
            return false;
        }
        CmForm other = (CmForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmForm[ id=" + id + " ]";
    }
    
}
