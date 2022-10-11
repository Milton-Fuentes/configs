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
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "Bpmcorrespondencebo.findByCancreaterevision", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.canCreateRevision = :canCreateRevision")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByCaseId", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.caseId = :caseId")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByCompanyFrom", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.companyFrom = :companyFrom")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByContractorNumber", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.contractorNumber = :contractorNumber")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByCreated", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.created = :created")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByIsapproved", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.isapproved = :isapproved")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByIseorneedreview", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.iseorneedreview = :iseorneedreview")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByIsemneedreview", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.isemneedreview = :isemneedreview")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByIsneededrevision", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.isneededrevision = :isneededrevision")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByName", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.name = :name")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByNotes", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.notes = :notes")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByOnWorkId", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.onWorkId = :onWorkId")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByOnWorkName", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.onWorkName = :onWorkName")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByParentId", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.parentId = :parentId")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByPersistenceversion", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByPersonFrom", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.personFrom = :personFrom")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByRejectreason", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.rejectreason = :rejectreason")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByRequestedDueDate", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.requestedDueDate = :requestedDueDate")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByRequestorId", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.requestorId = :requestorId")
    , @NamedQuery(name = "Bpmcorrespondencebo.findBySpecNumber", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.specNumber = :specNumber")
    , @NamedQuery(name = "Bpmcorrespondencebo.findByStatus", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.status = :status")
    , @NamedQuery(name = "Bpmcorrespondencebo.findBySubinternalnumber", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.subinternalnumber = :subinternalnumber")
    , @NamedQuery(name = "Bpmcorrespondencebo.findBySubnumber", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.subnumber = :subnumber")
 */
/**
 *
 * @author dperez
 */
@Entity
@Table(name = "BPMCORRESPONDENCEBO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmcorrespondencebo.findAll", query = "SELECT b FROM Bpmcorrespondencebo b"),
    @NamedQuery(name = "Bpmcorrespondencebo.findByPersistenceid", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmcorrespondencebo.findByFolderId", query = "SELECT b FROM Bpmcorrespondencebo b WHERE b.folderId = :folderId")
})
public class Bpmcorrespondencebo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMCORRESPONDENCEBO_SEQ", sequenceName = "BPMCORRESPONDENCEBO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMCORRESPONDENCEBO_SEQ")
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

    @Size(max = 55)
    @Column(name = "INFORMATION_STATUS")
    private String informationStatus;

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
    @Column(name = "NOTES")
    private String notes;

    @Column(name = "PARENT_ID")
    private BigInteger parentId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PERSON_FROM")
    private String personFrom;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "REQUESTED_DUE_DATE")
    private String requestedDueDate;

    @Column(name = "REQUESTORID")
    private BigInteger requestorId;

    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;

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
    @Column(name = "CORNUMBER")
    private String cornumber;

    @Size(max = 255)
    @Column(name = "PD_IDS")
    private String pdIds;

    @Size(max = 255)
    @Column(name = "RE_IDS")
    private String reIds;

    @Size(max = 155)
    @Column(name = "STKH_IDS")
    private String stkhIds;

    @Size(max = 155)
    @Column(name = "STKH_GRP_IDS")
    private String stkhGrpIds;

    @Size(max = 55)
    @Column(name = "CATEGORY")
    private String category;

    @JoinColumn(name = "DC_DATA_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Bpmcorrespondencemetadata dcDataPid;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpmcorrespondenceboPid", fetch = FetchType.LAZY)
    private List<Bpmcorrespondenceremark> bpmcorrespondenceremarkList;

    public Bpmcorrespondencebo() {
    }

    public Bpmcorrespondencebo(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmcorrespondencebo(BigDecimal persistenceid, String companyFrom, BigInteger folderId, String personFrom, String requestedDueDate, String cornumber) {
        this.persistenceid = persistenceid;
        this.companyFrom = companyFrom;
        this.folderId = folderId;
        this.personFrom = personFrom;
        this.requestedDueDate = requestedDueDate;
        this.cornumber = cornumber;
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

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
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

    public String getInformationStatus() {
        return informationStatus;
    }

    public void setInformationStatus(String informationStatus) {
        this.informationStatus = informationStatus;
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

    public String getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(String personFrom) {
        this.personFrom = personFrom;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCornumber() {
        return cornumber;
    }

    public void setCornumber(String cornumber) {
        this.cornumber = cornumber;
    }

    public String getPdIds() {
        return pdIds;
    }

    public void setPdIds(String pdIds) {
        this.pdIds = pdIds;
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

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bpmcorrespondencemetadata getDcDataPid() {
        return dcDataPid;
    }

    public void setDcDataPid(Bpmcorrespondencemetadata dcDataPid) {
        this.dcDataPid = dcDataPid;
    }

    @XmlTransient
    public List<Bpmcorrespondenceremark> getBpmcorrespondenceremarkList() {
        return bpmcorrespondenceremarkList;
    }

    public void setBpmcorrespondenceremarkList(List<Bpmcorrespondenceremark> bpmcorrespondenceremarkList) {
        this.bpmcorrespondenceremarkList = bpmcorrespondenceremarkList;
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
        if (!(object instanceof Bpmcorrespondencebo)) {
            return false;
        }
        Bpmcorrespondencebo other = (Bpmcorrespondencebo) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmcorrespondencebo[ persistenceid=" + persistenceid + " ]";
    }

}
