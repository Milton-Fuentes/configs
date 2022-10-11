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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
, @NamedQuery(name = "Bpmsubmittalbo.findByCancreaterevision", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.canCreateRevision = :canCreateRevision")
    , @NamedQuery(name = "Bpmsubmittalbo.findByCaseId", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.caseId = :caseId")
    , @NamedQuery(name = "Bpmsubmittalbo.findByCompanyFrom", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.companyFrom = :companyFrom")
    , @NamedQuery(name = "Bpmsubmittalbo.findByContractorNumber", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.contractorNumber = :contractorNumber")
    , @NamedQuery(name = "Bpmsubmittalbo.findByCreated", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.created = :created")
    , @NamedQuery(name = "Bpmsubmittalbo.findByIsapproved", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.isapproved = :isapproved")
    , @NamedQuery(name = "Bpmsubmittalbo.findByIseorneedreview", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.iseorneedreview = :iseorneedreview")
    , @NamedQuery(name = "Bpmsubmittalbo.findByIsemneedreview", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.isemneedreview = :isemneedreview")
    , @NamedQuery(name = "Bpmsubmittalbo.findByIsneededrevision", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.isneededrevision = :isneededrevision")
    , @NamedQuery(name = "Bpmsubmittalbo.findByName", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.name = :name")
    , @NamedQuery(name = "Bpmsubmittalbo.findByNotes", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.notes = :notes")
    , @NamedQuery(name = "Bpmsubmittalbo.findByOnWorkId", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.onWorkId = :onWorkId")
    , @NamedQuery(name = "Bpmsubmittalbo.findByOnWorkName", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.onWorkName = :onWorkName")
    , @NamedQuery(name = "Bpmsubmittalbo.findByParentId", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.parentId = :parentId")
    , @NamedQuery(name = "Bpmsubmittalbo.findByPersistenceversion", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpmsubmittalbo.findByPersonFrom", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.personFrom = :personFrom")
    , @NamedQuery(name = "Bpmsubmittalbo.findByRejectreason", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.rejectreason = :rejectreason")
    , @NamedQuery(name = "Bpmsubmittalbo.findByRequestedDueDate", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.requestedDueDate = :requestedDueDate")
    , @NamedQuery(name = "Bpmsubmittalbo.findByRequestorId", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.requestorId = :requestorId")
    , @NamedQuery(name = "Bpmsubmittalbo.findBySpecNumber", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.specNumber = :specNumber")
    , @NamedQuery(name = "Bpmsubmittalbo.findByStatus", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.status = :status")
    , @NamedQuery(name = "Bpmsubmittalbo.findBySubinternalnumber", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.subinternalnumber = :subinternalnumber")
    , @NamedQuery(name = "Bpmsubmittalbo.findBySubnumber", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.subnumber = :subnumber")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMSUBMITTALBO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmsubmittalbo.findAll", query = "SELECT b FROM Bpmsubmittalbo b"),
    @NamedQuery(name = "Bpmsubmittalbo.findByPersistenceid", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmsubmittalbo.findByFolderId", query = "SELECT b FROM Bpmsubmittalbo b WHERE b.folderId = :folderId")
})
public class Bpmsubmittalbo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMSUBMITTALBO_SEQ", sequenceName = "BPMSUBMITTALBO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMSUBMITTALBO_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;

    @Column(name = "CANCREATEREVISION")
    private Short canCreateRevision;

    @Column(name = "CASE_ID")
    private BigInteger caseId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMPANY_FROM")
    private String companyFrom;

    @Size(max = 255)
    @Column(name = "CONTRACTOR_NUMBER")
    private String contractorNumber;

    @Size(max = 255)
    @Column(name = "DECISIONID")
    private String decisionId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CREATED")
    private String created;

    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "DONE_DATE")
    private String doneDate;

    @Size(max = 255)
    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;

    @Column(name = "ISAPPROVED")
    private Short isapproved;

    @Column(name = "ISEORNEEDREVIEW")
    private Short iseorneedreview;

    @Column(name = "ISEMNEEDREVIEW")
    private Short isemneedreview;

    @Column(name = "ISNEEDEDREVISION")
    private Short isneededrevision;

    @Column(name = "ISRENEEDEDREVIEW")
    private Short isreneededreview;

    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "FINALREMARK")
    private String finalRemark;

    @Lob
    @Column(name = "NOTES")
    private String notes;

    @Size(max = 255)
    @Column(name = "ONWORKID")
    private String onWorkId;

    @Size(max = 255)
    @Column(name = "ONWORKNAME")
    private String onWorkName;

    @Column(name = "PARENT_ID")
    private BigInteger parentId;

    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PERSON_FROM")
    private String personFrom;

    @Lob
    @Column(name = "REJECTREASON")
    private String rejectreason;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "REQUESTED_DUE_DATE")
    private String requestedDueDate;

    @Column(name = "REQUESTORID")
    private BigInteger requestorId;

    @Size(max = 255)
    @Column(name = "SPEC_NUMBER")
    private String specNumber;

    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;

    @Size(max = 255)
    @Column(name = "INTERNALSTATUS")
    private String internalstatus;

    @Size(max = 255)
    @Column(name = "SUBINTERNALNUMBER")
    private String subinternalnumber;

    @Size(max = 255)
    @Column(name = "CLIENTID")
    private String clientId;

    @Size(max = 255)
    @Column(name = "CONTRACTID")
    private String contractId;

    @Size(max = 255)
    @Column(name = "PROJECTID")
    private String projectId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SUBNUMBER")
    private String subnumber;

    @Size(max = 255)
    @Column(name = "EM_IDS")
    private String emIds;

    @Size(max = 255)
    @Column(name = "RE_IDS")
    private String reIds;

    @Size(max = 155)
    @Column(name = "STKH_IDS")
    private String stkhIds;

    @Size(max = 155)
    @Column(name = "STKH_GRP_IDS")
    private String stkhGrpIds;

    @Size(max = 255)
    @Column(name = "REFERENCE_DOCS")
    private String referenceDocs;

    @Size(max = 255)
    @Column(name = "ISSUE")
    private String issue;

    @Size(max = 255)
    @Column(name = "PROPOSED_SOLUTION")
    private String proposedSolution;

    @JoinColumn(name = "DC_DATA_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne
    private Bpmsubmittalmetadata dcDataPid;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpmsubmittalboPid", fetch = FetchType.LAZY)
    private List<Bpmsubmittalremark> bpmsubmittalremarkList;

    @Transient
    private BpmTaskInstance taskInstanceCurrent;

    @Transient
    private List<BpmTaskInstance> taskInstanceList;

    public Bpmsubmittalbo() {
    }

    public Bpmsubmittalbo(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmsubmittalbo(BigDecimal persistenceid, String companyFrom, BigInteger folderId, String personFrom, String requestedDueDate, String subnumber) {
        this.persistenceid = persistenceid;
        this.companyFrom = companyFrom;
        this.folderId = folderId;
        this.personFrom = personFrom;
        this.requestedDueDate = requestedDueDate;
        this.subnumber = subnumber;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
    }

    public String getOnWorkId() {
        return onWorkId;
    }

    public void setOnWorkId(String onWorkId) {
        this.onWorkId = onWorkId;
    }

    public String getOnWorkName() {
        return onWorkName;
    }

    public void setOnWorkName(String onWorkName) {
        this.onWorkName = onWorkName;
    }

    public String getInternalstatus() {
        return internalstatus;
    }

    public void setInternalstatus(String internalstatus) {
        this.internalstatus = internalstatus;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFinalRemark() {
        return finalRemark;
    }

    public void setFinalRemark(String finalRemark) {
        this.finalRemark = finalRemark;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Short getCanCreateRevision() {
        return canCreateRevision;
    }

    public void setCanCreateRevision(Short canCreateRevision) {
        this.canCreateRevision = canCreateRevision;
    }

    public BigInteger getCaseId() {
        return caseId;
    }

    public void setCaseId(BigInteger caseId) {
        this.caseId = caseId;
    }

    public String getFinaldisposition() {
        return finaldisposition;
    }

    public void setFinaldisposition(String finaldisposition) {
        this.finaldisposition = finaldisposition;
    }

    public Short getIsreneededreview() {
        return isreneededreview;
    }

    public void setIsreneededreview(Short isreneededreview) {
        this.isreneededreview = isreneededreview;
    }

    public String getCompanyFrom() {
        return companyFrom;
    }

    public void setCompanyFrom(String companyFrom) {
        this.companyFrom = companyFrom;
    }

    public String getContractorNumber() {
        return contractorNumber;
    }

    public void setContractorNumber(String contractorNumber) {
        this.contractorNumber = contractorNumber;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public Short getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Short isapproved) {
        this.isapproved = isapproved;
    }

    public Short getIseorneedreview() {
        return iseorneedreview;
    }

    public void setIseorneedreview(Short iseorneedreview) {
        this.iseorneedreview = iseorneedreview;
    }

    public Short getIsemneedreview() {
        return isemneedreview;
    }

    public void setIsemneedreview(Short isemneedreview) {
        this.isemneedreview = isemneedreview;
    }

    public Short getIsneededrevision() {
        return isneededrevision;
    }

    public void setIsneededrevision(Short isneededrevision) {
        this.isneededrevision = isneededrevision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(String personFrom) {
        this.personFrom = personFrom;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public String getRequestedDueDate() {
        return requestedDueDate;
    }

    public void setRequestedDueDate(String requestedDueDate) {
        this.requestedDueDate = requestedDueDate;
    }

    public BigInteger getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(BigInteger requestorid) {
        this.requestorId = requestorid;
    }

    public String getSpecNumber() {
        return specNumber;
    }

    public void setSpecNumber(String specNumber) {
        this.specNumber = specNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubinternalnumber() {
        return subinternalnumber;
    }

    public void setSubinternalnumber(String subinternalnumber) {
        this.subinternalnumber = subinternalnumber;
    }

    public String getSubnumber() {
        return subnumber;
    }

    public void setSubnumber(String subnumber) {
        this.subnumber = subnumber;
    }

    public String getEmIds() {
        return emIds;
    }

    public void setEmIds(String emIds) {
        this.emIds = emIds;
    }

    public String getReIds() {
        return reIds;
    }

    public void setReIds(String reIds) {
        this.reIds = reIds;
    }

    public String getStkhIds() {
        return stkhIds;
    }

    public void setStkhIds(String stkhIds) {
        this.stkhIds = stkhIds;
    }

    public String getStkhGrpIds() {
        return stkhGrpIds;
    }

    public void setStkhGrpIds(String stkhGrpIds) {
        this.stkhGrpIds = stkhGrpIds;
    }

    public String getReferenceDocs() {
        return referenceDocs;
    }

    public void setReferenceDocs(String referenceDocs) {
        this.referenceDocs = referenceDocs;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getProposedSolution() {
        return proposedSolution;
    }

    public void setProposedSolution(String proposedSolution) {
        this.proposedSolution = proposedSolution;
    }

    public Bpmsubmittalmetadata getDcDataPid() {
        return dcDataPid;
    }

    public void setDcDataPid(Bpmsubmittalmetadata dcDataPid) {
        this.dcDataPid = dcDataPid;
    }

    @XmlTransient
    public List<Bpmsubmittalremark> getBpmsubmittalremarkList() {
        return bpmsubmittalremarkList;
    }

    public void setBpmsubmittalremarkList(List<Bpmsubmittalremark> bpmsubmittalremarkList) {
        this.bpmsubmittalremarkList = bpmsubmittalremarkList;
    }

    public BpmTaskInstance getTaskInstanceCurrent() {
        return taskInstanceCurrent;
    }

    public void setTaskInstanceCurrent(BpmTaskInstance taskInstanceCurrent) {
        this.taskInstanceCurrent = taskInstanceCurrent;
    }

    public List<BpmTaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<BpmTaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
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
        if (!(object instanceof Bpmsubmittalbo)) {
            return false;
        }
        Bpmsubmittalbo other = (Bpmsubmittalbo) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmsubmittalbo[ persistenceid=" + persistenceid + " ]";
    }

}
