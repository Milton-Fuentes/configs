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
, @NamedQuery(name = "Bpmrfibo.findByCancreaterevision", query = "SELECT b FROM Bpmrfibo b WHERE b.cancreaterevision = :cancreaterevision")
    , @NamedQuery(name = "Bpmrfibo.findByCaseId", query = "SELECT b FROM Bpmrfibo b WHERE b.caseId = :caseId")
    , @NamedQuery(name = "Bpmrfibo.findByClientid", query = "SELECT b FROM Bpmrfibo b WHERE b.clientId = :clientid")
    , @NamedQuery(name = "Bpmrfibo.findByCompanyFrom", query = "SELECT b FROM Bpmrfibo b WHERE b.companyFrom = :companyFrom")
    , @NamedQuery(name = "Bpmrfibo.findByContractid", query = "SELECT b FROM Bpmrfibo b WHERE b.contractId = :contractid")
    , @NamedQuery(name = "Bpmrfibo.findByContractorNumber", query = "SELECT b FROM Bpmrfibo b WHERE b.contractorNumber = :contractorNumber")
    , @NamedQuery(name = "Bpmrfibo.findByCreated", query = "SELECT b FROM Bpmrfibo b WHERE b.created = :created")
    , @NamedQuery(name = "Bpmrfibo.findByDecisionid", query = "SELECT b FROM Bpmrfibo b WHERE b.decisionid = :decisionid")
    , @NamedQuery(name = "Bpmrfibo.findByDoneDate", query = "SELECT b FROM Bpmrfibo b WHERE b.doneDate = :doneDate")
    , @NamedQuery(name = "Bpmrfibo.findByDrwnumber", query = "SELECT b FROM Bpmrfibo b WHERE b.drwnumber = :drwnumber")
    , @NamedQuery(name = "Bpmrfibo.findByFinaldisposition", query = "SELECT b FROM Bpmrfibo b WHERE b.finaldisposition = :finaldisposition")
    , @NamedQuery(name = "Bpmrfibo.findByInternalstatus", query = "SELECT b FROM Bpmrfibo b WHERE b.internalstatus = :internalstatus")
    , @NamedQuery(name = "Bpmrfibo.findByIsapproved", query = "SELECT b FROM Bpmrfibo b WHERE b.isapproved = :isapproved")
    , @NamedQuery(name = "Bpmrfibo.findByIseorneedreview", query = "SELECT b FROM Bpmrfibo b WHERE b.iseorneedreview = :iseorneedreview")
    , @NamedQuery(name = "Bpmrfibo.findByIsemneedreview", query = "SELECT b FROM Bpmrfibo b WHERE b.isemneedreview = :isemneedreview")
    , @NamedQuery(name = "Bpmrfibo.findByIsneededrevision", query = "SELECT b FROM Bpmrfibo b WHERE b.isneededrevision = :isneededrevision")
    , @NamedQuery(name = "Bpmrfibo.findByOnworkid", query = "SELECT b FROM Bpmrfibo b WHERE b.onworkid = :onworkid")
    , @NamedQuery(name = "Bpmrfibo.findByOnworkname", query = "SELECT b FROM Bpmrfibo b WHERE b.onworkname = :onworkname")
    , @NamedQuery(name = "Bpmrfibo.findByParentId", query = "SELECT b FROM Bpmrfibo b WHERE b.parentId = :parentId")
    , @NamedQuery(name = "Bpmrfibo.findByPersistenceversion", query = "SELECT b FROM Bpmrfibo b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpmrfibo.findByPersonFrom", query = "SELECT b FROM Bpmrfibo b WHERE b.personFrom = :personFrom")
    , @NamedQuery(name = "Bpmrfibo.findByPrioritycode", query = "SELECT b FROM Bpmrfibo b WHERE b.prioritycode = :prioritycode")
    , @NamedQuery(name = "Bpmrfibo.findByProjectid", query = "SELECT b FROM Bpmrfibo b WHERE b.projectId = :projectid")
    , @NamedQuery(name = "Bpmrfibo.findByQuestion", query = "SELECT b FROM Bpmrfibo b WHERE b.question = :question")
    , @NamedQuery(name = "Bpmrfibo.findByRejectreason", query = "SELECT b FROM Bpmrfibo b WHERE b.rejectreason = :rejectreason")
    , @NamedQuery(name = "Bpmrfibo.findByReply", query = "SELECT b FROM Bpmrfibo b WHERE b.reply = :reply")
    , @NamedQuery(name = "Bpmrfibo.findByRequestorid", query = "SELECT b FROM Bpmrfibo b WHERE b.requestorid = :requestorid")
    , @NamedQuery(name = "Bpmrfibo.findByResponseDueDate", query = "SELECT b FROM Bpmrfibo b WHERE b.responseDueDate = :responseDueDate")
    , @NamedQuery(name = "Bpmrfibo.findByRfiinternalnumber", query = "SELECT b FROM Bpmrfibo b WHERE b.rfiinternalnumber = :rfiinternalnumber")
    , @NamedQuery(name = "Bpmrfibo.findByRfiname", query = "SELECT b FROM Bpmrfibo b WHERE b.rfiname = :rfiname")
    , @NamedQuery(name = "Bpmrfibo.findByRfinumber", query = "SELECT b FROM Bpmrfibo b WHERE b.rfinumber = :rfinumber")
    , @NamedQuery(name = "Bpmrfibo.findByStatus", query = "SELECT b FROM Bpmrfibo b WHERE b.status = :status")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMRFIBO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmrfibo.findAll", query = "SELECT b FROM Bpmrfibo b"),
    @NamedQuery(name = "Bpmrfibo.findByPersistenceid", query = "SELECT b FROM Bpmrfibo b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmrfibo.findByFolderId", query = "SELECT b FROM Bpmrfibo b WHERE b.folderId = :folderId")})
public class Bpmrfibo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMRFIBO_SEQ", sequenceName = "BPMRFIBO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMRFIBO_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Column(name = "CANCREATEREVISION")
    private Short canCreateRevision;
    @Column(name = "CASE_ID")
    private BigInteger caseId;
    @Size(max = 255)
    @Column(name = "CLIENTID")
    private String clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMPANY_FROM")
    private String companyFrom;
    @Size(max = 255)
    @Column(name = "CONTRACTID")
    private String contractId;
    @Size(max = 255)
    @Column(name = "CONTRACTOR_NUMBER")
    private String contractorNumber;
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
    @Column(name = "DRWNUMBER")
    private String drwnumber;
    @Size(max = 255)
    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Size(max = 255)
    @Column(name = "INTERNALSTATUS")
    private String internalstatus;

    //--------------------------------
    @Column(name = "IS_INITIAL_REVIEW_ACCEPTED")
    private Short isInitialReviewAccepted;

    @Column(name = "IS_INITIAL_INFORMATION_ACCEPTED")
    private Short isInitialInformationAccepted;

    @Column(name = "IS_RESPONSE_ACCEPTED")
    private Short isResponseAccepted;

    @Column(name = "IS_NEEDED_REVIEW_EOR")
    private Short isNeededReviewEor;

    @Size(max = 255)
    @Column(name = "EM_IDS")
    private String emIds;
    @Size(max = 255)
    @Column(name = "RE_IDS")
    private String reIds;

    @Size(max = 255)
    @Column(name = "EOR_IDS")
    private String eorIds;

    @Size(max = 255)
    @Column(name = "ONWORKID")
    private String onworkid;
    @Size(max = 255)
    @Column(name = "ONWORKNAME")
    private String onworkname;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PERSON_FROM")
    private String personFrom;
    @Size(max = 255)
    @Column(name = "PRIORITYCODE")
    private String prioritycode;
    @Size(max = 255)
    @Column(name = "PROJECTID")
    private String projectId;
    @Lob
    @Column(name = "QUESTION")
    private String question;
    @Lob
    @Column(name = "REJECTREASON")
    private String rejectreason;
    @Lob
    @Column(name = "REPLY")
    private String reply;
    @Column(name = "REQUESTORID")
    private BigInteger requestorid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RESPONSE_DUE_DATE")
    private String responseDueDate;
    @Size(max = 255)
    @Column(name = "RFIINTERNALNUMBER")
    private String rfiinternalnumber;
    @Size(max = 255)
    @Column(name = "RFINAME")
    private String rfiname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RFINUMBER")
    private String rfinumber;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;

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

    @Column(name = "CHECK_WORK_IMPACT")
    private Character checkWorkImpact;

    @Column(name = "CHECK_SCHEDULE_IMPACT")
    private Character checkScheduleImpact;

    @Column(name = "CHECK_COST_IMPACT")
    private Character checkCostImpact;

    @JoinColumn(name = "DC_DATA_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne
    private Bpmrfimetadata dcDataPid;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpmrfiboPid")
    private List<Bpmrfiremark> bpmrfiremarkList;

    @Transient
    private BpmTaskInstance taskInstanceCurrent;

    @Transient
    private List<BpmTaskInstance> taskInstanceList;

    public Bpmrfibo() {
    }

    public Bpmrfibo(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmrfibo(BigDecimal persistenceid, String companyFrom, BigInteger folderId, String personFrom, String responseDueDate, String rfinumber) {
        this.persistenceid = persistenceid;
        this.companyFrom = companyFrom;
        this.folderId = folderId;
        this.personFrom = personFrom;
        this.responseDueDate = responseDueDate;
        this.rfinumber = rfinumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
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

    public String getCompanyFrom() {
        return companyFrom;
    }

    public void setCompanyFrom(String companyFrom) {
        this.companyFrom = companyFrom;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public String getDrwnumber() {
        return drwnumber;
    }

    public void setDrwnumber(String drwnumber) {
        this.drwnumber = drwnumber;
    }

    public String getFinaldisposition() {
        return finaldisposition;
    }

    public void setFinaldisposition(String finaldisposition) {
        this.finaldisposition = finaldisposition;
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

    public Short getIsInitialReviewAccepted() {
        return isInitialReviewAccepted;
    }

    public void setIsInitialReviewAccepted(Short isInitialReviewAccepted) {
        this.isInitialReviewAccepted = isInitialReviewAccepted;
    }

    public Short getIsInitialInformationAccepted() {
        return isInitialInformationAccepted;
    }

    public void setIsInitialInformationAccepted(Short isInitialInformationAccepted) {
        this.isInitialInformationAccepted = isInitialInformationAccepted;
    }

    public Short getIsResponseAccepted() {
        return isResponseAccepted;
    }

    public void setIsResponseAccepted(Short isResponseAccepted) {
        this.isResponseAccepted = isResponseAccepted;
    }

    public Short getIsNeededReviewEor() {
        return isNeededReviewEor;
    }

    public void setIsNeededReviewEor(Short isNeededReviewEor) {
        this.isNeededReviewEor = isNeededReviewEor;
    }

    public String getEorIds() {
        return eorIds;
    }

    public void setEorIds(String eorIds) {
        this.eorIds = eorIds;
    }

    public String getOnworkid() {
        return onworkid;
    }

    public void setOnworkid(String onworkid) {
        this.onworkid = onworkid;
    }

    public String getOnworkname() {
        return onworkname;
    }

    public void setOnworkname(String onworkname) {
        this.onworkname = onworkname;
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

    public String getPrioritycode() {
        return prioritycode;
    }

    public void setPrioritycode(String prioritycode) {
        this.prioritycode = prioritycode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public BigInteger getRequestorid() {
        return requestorid;
    }

    public void setRequestorid(BigInteger requestorid) {
        this.requestorid = requestorid;
    }

    public String getResponseDueDate() {
        return responseDueDate;
    }

    public void setResponseDueDate(String responseDueDate) {
        this.responseDueDate = responseDueDate;
    }

    public String getRfiinternalnumber() {
        return rfiinternalnumber;
    }

    public void setRfiinternalnumber(String rfiinternalnumber) {
        this.rfiinternalnumber = rfiinternalnumber;
    }

    public String getRfiname() {
        return rfiname;
    }

    public void setRfiname(String rfiname) {
        this.rfiname = rfiname;
    }

    public String getRfinumber() {
        return rfinumber;
    }

    public void setRfinumber(String rfinumber) {
        this.rfinumber = rfinumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bpmrfimetadata getDcDataPid() {
        return dcDataPid;
    }

    public void setDcDataPid(Bpmrfimetadata dcDataPid) {
        this.dcDataPid = dcDataPid;
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

    public Character getCheckWorkImpact() {
        return checkWorkImpact;
    }

    public void setCheckWorkImpact(Character checkWorkImpact) {
        this.checkWorkImpact = checkWorkImpact;
    }

    public Character getCheckScheduleImpact() {
        return checkScheduleImpact;
    }

    public void setCheckScheduleImpact(Character checkScheduleImpact) {
        this.checkScheduleImpact = checkScheduleImpact;
    }

    public Character getCheckCostImpact() {
        return checkCostImpact;
    }

    public void setCheckCostImpact(Character checkCostImpact) {
        this.checkCostImpact = checkCostImpact;
    }

    @XmlTransient
    public List<Bpmrfiremark> getBpmrfiremarkList() {
        return bpmrfiremarkList;
    }

    public void setBpmrfiremarkList(List<Bpmrfiremark> bpmrfiremarkList) {
        this.bpmrfiremarkList = bpmrfiremarkList;
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
        if (!(object instanceof Bpmrfibo)) {
            return false;
        }
        Bpmrfibo other = (Bpmrfibo) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmrfibo[ persistenceid=" + persistenceid + " ]";
    }

}
