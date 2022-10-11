/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "Bpmdispatchbo.findByCancreaterevision", query = "SELECT b FROM Bpmdispatchbo b WHERE b.cancreaterevision = :cancreaterevision")
    , @NamedQuery(name = "Bpmdispatchbo.findByCaseId", query = "SELECT b FROM Bpmdispatchbo b WHERE b.caseId = :caseId")
    , @NamedQuery(name = "Bpmdispatchbo.findByClientid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.clientId = :clientId")
    , @NamedQuery(name = "Bpmdispatchbo.findByContractid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.contractId = :contractId")
    , @NamedQuery(name = "Bpmdispatchbo.findByCreated", query = "SELECT b FROM Bpmdispatchbo b WHERE b.created = :created")
    , @NamedQuery(name = "Bpmdispatchbo.findByDatetimereqOnjobsite", query = "SELECT b FROM Bpmdispatchbo b WHERE b.datetimereqOnjobsite = :datetimereqOnjobsite")
    , @NamedQuery(name = "Bpmdispatchbo.findByDecisionid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.decisionid = :decisionid")
    , @NamedQuery(name = "Bpmdispatchbo.findByDoneDate", query = "SELECT b FROM Bpmdispatchbo b WHERE b.doneDate = :doneDate")
    , @NamedQuery(name = "Bpmdispatchbo.findByFinaldisposition", query = "SELECT b FROM Bpmdispatchbo b WHERE b.finaldisposition = :finaldisposition")
    , @NamedQuery(name = "Bpmdispatchbo.findByInternalstatus", query = "SELECT b FROM Bpmdispatchbo b WHERE b.internalstatus = :internalstatus")
    , @NamedQuery(name = "Bpmdispatchbo.findByIsapprovedfromdispatch", query = "SELECT b FROM Bpmdispatchbo b WHERE b.isapprovedfromdispatch = :isapprovedfromdispatch")
    , @NamedQuery(name = "Bpmdispatchbo.findByIsapprovedfromqa", query = "SELECT b FROM Bpmdispatchbo b WHERE b.isapprovedfromqa = :isapprovedfromqa")
    , @NamedQuery(name = "Bpmdispatchbo.findByIscancel", query = "SELECT b FROM Bpmdispatchbo b WHERE b.iscancel = :iscancel")
    , @NamedQuery(name = "Bpmdispatchbo.findByIsrollback", query = "SELECT b FROM Bpmdispatchbo b WHERE b.isrollback = :isrollback")
    , @NamedQuery(name = "Bpmdispatchbo.findByParentId", query = "SELECT b FROM Bpmdispatchbo b WHERE b.parentId = :parentId")
    , @NamedQuery(name = "Bpmdispatchbo.findByPersistenceversion", query = "SELECT b FROM Bpmdispatchbo b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpmdispatchbo.findByProjectid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.projectId = :projectId")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestdescription", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestDescription = :requestDescription")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestname", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestName = :requestName")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestSource", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestSource = :requestSource")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestedby", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestedBy = :requestedBy")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestnumber", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestnumber = :requestnumber")
    , @NamedQuery(name = "Bpmdispatchbo.findByRequestorid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.requestorId = :requestorId")
    , @NamedQuery(name = "Bpmdispatchbo.findByRestorepoint", query = "SELECT b FROM Bpmdispatchbo b WHERE b.restorepoint = :restorepoint")
    , @NamedQuery(name = "Bpmdispatchbo.findByStatus", query = "SELECT b FROM Bpmdispatchbo b WHERE b.status = :status")
    , @NamedQuery(name = "Bpmdispatchbo.findByTechrouter", query = "SELECT b FROM Bpmdispatchbo b WHERE b.techrouter = :techrouter")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMDISPATCHBO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmdispatchbo.findAll", query = "SELECT b FROM Bpmdispatchbo b"),
    @NamedQuery(name = "Bpmdispatchbo.findByPersistenceid", query = "SELECT b FROM Bpmdispatchbo b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmdispatchbo.findByFolderId", query = "SELECT b FROM Bpmdispatchbo b WHERE b.folderId = :folderId")
})
public class Bpmdispatchbo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMDISPATCHBO_SEQ", sequenceName = "BPMDISPATCHBO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMDISPATCHBO_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Column(name = "CANCREATEREVISION")
    private Short cancreaterevision;
    @Column(name = "CASE_ID")
    private BigInteger caseId;
    @Size(max = 255)
    @Column(name = "CLIENTID")
    private String clientId;
    @Size(max = 255)
    @Column(name = "ACTIVITYID")
    private String activityId;
    @Size(max = 255)
    @Column(name = "CONTRACTID")
    private String contractId;
    @Size(max = 255)
    @Column(name = "CREATED")
    //@HADateTime(dateFormat = "MM/dd/yyyy hh:mm a")
    private String created;
    @Size(max = 255)
    @Column(name = "DATETIMEREQ_ONJOBSITE")
    private String datetimereqOnjobsite;
    @Size(max = 255)
    @Column(name = "DECISIONID")
    private String decisionid;
    @Size(max = 255)
    @Column(name = "DONE_DATE")
    private String doneDate;
    @Size(max = 255)
    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;
    @Lob
    @Column(name = "FINALREMARK")
    private String finalremark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Size(max = 255)
    @Column(name = "INTERNALSTATUS")
    private String internalstatus;
    @Column(name = "ISAPPROVEDFROMDISPATCH")
    private Short isapprovedfromdispatch;
    @Column(name = "ISAPPROVEDFROMQA")
    private Short isapprovedfromqa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCANCEL")
    private short iscancel;
    @Column(name = "ISROLLBACK")
    private Short isrollback;
    @Lob
    @Column(name = "REQUESTDESCRIPTION")
    private String requestDescription;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;
    @Size(max = 255)
    @Column(name = "PROJECTID")
    private String projectId;
    @Lob
    @Column(name = "REJECTREASON")
    private String rejectreason;
    @Size(max = 255)
    @Column(name = "REQUESTNAME")
    private String requestName;
    @Size(max = 255)
    @Column(name = "REQUEST_SOURCE")
    private String requestSource;
    @Size(max = 255)
    @Column(name = "REQUESTEDBY")
    private String requestedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REQUESTNUMBER")
    private String requestnumber;
    @Column(name = "REQUESTORID")
    private BigInteger requestorId;
    @Size(max = 255)
    @Column(name = "RESTOREPOINT")
    private String restorepoint;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TECHROUTER")
    private Long techrouter;
    @Size(max = 255)
    @Column(name = "EMAILTONOTIFY")
    private String emailToNotify;
    @Size(max = 255)
    @Column(name = "BATCHPLANT")
    private String batchPlant;
    @Size(max = 255)
    @Column(name = "MIXDESIGN")
    private String mixDesign;
    @Size(max = 255)
    @Column(name = "MIXDESIGNTYPE")
    private String mixDesignType;
    @Size(max = 255)
    @Column(name = "REQUEST_LOCATION")
    private String requestLocation;
    @Size(max = 255)
    @Column(name = "REQQTY")
    private String reqQty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpmdispatchboPid", fetch = FetchType.LAZY)
    private List<Bpmdispatchremark> bpmdispatchremarkList;
    @Transient
    private String canbeCancelled;

    public Bpmdispatchbo() {
    }

    public Bpmdispatchbo(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmdispatchbo(BigDecimal persistenceid, BigInteger folderId, short iscancel, String requestnumber) {
        this.persistenceid = persistenceid;
        this.folderId = folderId;
        this.iscancel = iscancel;
        this.requestnumber = requestnumber;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public String getCanbeCancelled() {
        return canbeCancelled;
    }

    public void setCanbeCancelled(String canbeCancelled) {
        this.canbeCancelled = canbeCancelled;
    }

    public String getCancelStatus() {
        return canbeCancelled;
    }

    public Short getCancreaterevision() {
        return cancreaterevision;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setCancreaterevision(Short cancreaterevision) {
        this.cancreaterevision = cancreaterevision;
    }

    public BigInteger getCaseId() {
        return caseId;
    }

    public void setCaseId(BigInteger caseId) {
        this.caseId = caseId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDatetimereqOnjobsite() {
        return datetimereqOnjobsite;
    }

    public void setDatetimereqOnjobsite(String datetimereqOnjobsite) {
        this.datetimereqOnjobsite = datetimereqOnjobsite;
    }

    public String getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(String requestLocation) {
        this.requestLocation = requestLocation;
    }

    public String getDecisionid() {
        return decisionid;
    }

    public void setDecisionid(String decisionid) {
        this.decisionid = decisionid;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getFinaldisposition() {
        return finaldisposition;
    }

    public void setFinaldisposition(String finaldisposition) {
        this.finaldisposition = finaldisposition;
    }

    public String getFinalremark() {
        return finalremark;
    }

    public void setFinalremark(String finalremark) {
        this.finalremark = finalremark;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getInternalstatus() {
        return internalstatus;
    }

    public void setInternalstatus(String internalstatus) {
        this.internalstatus = internalstatus;
    }

    public Short getIsapprovedfromdispatch() {
        return isapprovedfromdispatch;
    }

    public void setIsapprovedfromdispatch(Short isapprovedfromdispatch) {
        this.isapprovedfromdispatch = isapprovedfromdispatch;
    }

    public Short getIsapprovedfromqa() {
        return isapprovedfromqa;
    }

    public void setIsapprovedfromqa(Short isapprovedfromqa) {
        this.isapprovedfromqa = isapprovedfromqa;
    }

    public short getIscancel() {
        return iscancel;
    }

    public void setIscancel(short iscancel) {
        this.iscancel = iscancel;
    }

    public Short getIsrollback() {
        return isrollback;
    }

    public void setIsrollback(Short isrollback) {
        this.isrollback = isrollback;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public BigInteger getPersistenceversion() {
        return persistenceversion;
    }

    public void setPersistenceversion(BigInteger persistenceversion) {
        this.persistenceversion = persistenceversion;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getRequestnumber() {
        return requestnumber;
    }

    public void setRequestnumber(String requestnumber) {
        this.requestnumber = requestnumber;
    }

    public String getRestorepoint() {
        return restorepoint;
    }

    public void setRestorepoint(String restorepoint) {
        this.restorepoint = restorepoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTechrouter() {
        return techrouter;
    }

    public void setTechrouter(Long techrouter) {
        this.techrouter = techrouter;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public BigInteger getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(BigInteger requestorId) {
        this.requestorId = requestorId;
    }

    public String getEmailToNotify() {
        return emailToNotify;
    }

    public void setEmailToNotify(String emailToNotify) {
        this.emailToNotify = emailToNotify;
    }

    public String getBatchPlant() {
        return batchPlant;
    }

    public void setBatchPlant(String batchPlant) {
        this.batchPlant = batchPlant;
    }

    public String getMixDesign() {
        return mixDesign;
    }

    public void setMixDesign(String mixDesign) {
        this.mixDesign = mixDesign;
    }

    public String getReqQty() {
        return reqQty;
    }

    public void setReqQty(String reqQty) {
        this.reqQty = reqQty;
    }

    @XmlTransient
    public List<Bpmdispatchremark> getBpmdispatchremarkList() {
        return bpmdispatchremarkList;
    }

    public void setBpmdispatchremarkList(List<Bpmdispatchremark> bpmdispatchremarkList) {
        this.bpmdispatchremarkList = bpmdispatchremarkList;
    }

    public String getMixDesignType() {
        return mixDesignType;
    }

    public void setMixDesignType(String mixDesignType) {
        this.mixDesignType = mixDesignType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persistenceid != null ? persistenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bpmdispatchbo)) {
            return false;
        }
        Bpmdispatchbo other = (Bpmdispatchbo) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmdispatchbo[ persistenceid=" + persistenceid + " ]";
    }

}
