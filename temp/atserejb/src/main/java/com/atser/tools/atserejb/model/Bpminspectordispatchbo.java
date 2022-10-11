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
, @NamedQuery(name = "Bpminspectordispatchbo.findByActivityId", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.activityId = :activityId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByCancreaterevision", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.cancreaterevision = :cancreaterevision")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByCaseId", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.caseId = :caseId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByClientid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.clientId = :clientId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByContractid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.contractId = :contractId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByCreated", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.created = :created")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByDecisionid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.decisionid = :decisionid")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByDoneDate", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.doneDate = :doneDate")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByEmailtonotify", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.emailToNotify = :emailToNotify")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByFinaldisposition", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.finaldisposition = :finaldisposition")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByInspectorrouter", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.inspectorrouter = :inspectorrouter")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByInternalstatus", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.internalstatus = :internalstatus")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByIsapprovedfromre", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.isapprovedfromre = :isapprovedfromre")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByIscancel", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.iscancel = :iscancel")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByIsrollback", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.isrollback = :isrollback")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByParentId", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.parentId = :parentId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByPersistenceversion", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByProjectid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.projectId = :projectId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestname", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestName = :requestName")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestLocation", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestLocation = :requestLocation")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestServicedate", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestServicedate = :requestServicedate")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestSource", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestSource = :requestSource")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestedby", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestedBy = :requestedBy")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestnumber", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestnumber = :requestnumber")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRequestorid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.requestorId = :requestorId")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByRestorepoint", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.restorepoint = :restorepoint")
    , @NamedQuery(name = "Bpminspectordispatchbo.findByStatus", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.status = :status")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMINSPECTORDISPATCHBO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpminspectordispatchbo.findAll", query = "SELECT b FROM Bpminspectordispatchbo b"),
    @NamedQuery(name = "Bpminspectordispatchbo.findByPersistenceid", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpminspectordispatchbo.findByFolderId", query = "SELECT b FROM Bpminspectordispatchbo b WHERE b.folderId = :folderId")
})
public class Bpminspectordispatchbo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMINSPECTORDISPATCHBO_SEQ", sequenceName = "BPMINSPECTORDISPATCHBO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMINSPECTORDISPATCHBO_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Size(max = 255)
    @Column(name = "ACTIVITYID")
    private String activityId;
    @Column(name = "CANCREATEREVISION")
    private Short cancreaterevision;
    @Column(name = "CASE_ID")
    private BigInteger caseId;
    @Size(max = 255)
    @Column(name = "CLIENTID")
    private String clientId;
    @Size(max = 255)
    @Column(name = "CONTRACTID")
    private String contractId;
    @Size(max = 255)
    @Column(name = "CREATED")
    private String created;
    @Size(max = 255)
    @Column(name = "DECISIONID")
    private String decisionid;
    @Size(max = 255)
    @Column(name = "DONE_DATE")
    private String doneDate;
    @Size(max = 255)
    @Column(name = "EMAILTONOTIFY")
    private String emailToNotify;
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
    @Column(name = "INSPECTORROUTER")
    private Long inspectorrouter;
    @Size(max = 255)
    @Column(name = "INTERNALSTATUS")
    private String internalstatus;
    @Column(name = "ISAPPROVEDFROMRE")
    private Short isapprovedfromre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCANCEL")
    private short iscancel;
    @Column(name = "ISROLLBACK")
    private Short isrollback;
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
    @Lob
    @Column(name = "REQUESTDESCRIPTION")
    private String requestDescription;
    @Size(max = 255)
    @Column(name = "REQUESTNAME")
    private String requestName;
    @Size(max = 255)
    @Column(name = "REQUEST_LOCATION")
    private String requestLocation;
    @Size(max = 255)
    @Column(name = "REQUEST_SERVICEDATE")
    private String requestServicedate;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpminspectordispatchboPid", fetch = FetchType.LAZY)
    private List<Bpminspectordispatchremark> bpminspectordispatchremarkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inspdispatchid", fetch = FetchType.LAZY)
    private List<GlobInspworkorder> globInspworkorderList;
    @Transient
    private String canbeCancelled;

    public Bpminspectordispatchbo() {
    }

    public Bpminspectordispatchbo(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpminspectordispatchbo(BigDecimal persistenceid, BigInteger folderId, short iscancel, String requestnumber) {
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

    public Short getCancreaterevision() {
        return cancreaterevision;
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

    public Long getInspectorrouter() {
        return inspectorrouter;
    }

    public void setInspectorrouter(Long inspectorrouter) {
        this.inspectorrouter = inspectorrouter;
    }

    public String getInternalstatus() {
        return internalstatus;
    }

    public void setInternalstatus(String internalstatus) {
        this.internalstatus = internalstatus;
    }

    public Short getIsapprovedfromre() {
        return isapprovedfromre;
    }

    public void setIsapprovedfromre(Short isapprovedfromre) {
        this.isapprovedfromre = isapprovedfromre;
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

    public String getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(String requestLocation) {
        this.requestLocation = requestLocation;
    }

    public String getRequestServicedate() {
        return requestServicedate;
    }

    public void setRequestServicedate(String requestServicedate) {
        this.requestServicedate = requestServicedate;
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public String getEmailToNotify() {
        return emailToNotify;
    }

    public void setEmailToNotify(String emailToNotify) {
        this.emailToNotify = emailToNotify;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
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

    @XmlTransient
    public List<Bpminspectordispatchremark> getBpminspectordispatchremarkList() {
        return bpminspectordispatchremarkList;
    }

    public void setBpminspectordispatchremarkList(List<Bpminspectordispatchremark> bpminspectordispatchremarkList) {
        this.bpminspectordispatchremarkList = bpminspectordispatchremarkList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persistenceid != null ? persistenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bpminspectordispatchbo)) {
            return false;
        }
        Bpminspectordispatchbo other = (Bpminspectordispatchbo) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpminspectordispatchbo[ persistenceid=" + persistenceid + " ]";
    }

    @XmlTransient
    public List<GlobInspworkorder> getGlobInspworkorderList() {
        return globInspworkorderList;
    }

    public void setGlobInspworkorderList(List<GlobInspworkorder> globInspworkorderList) {
        this.globInspworkorderList = globInspworkorderList;
    }

}
