/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMPROCESSTRACKING", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE BPMPROCESSTRACKING SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 0")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpmProcessTracking.findAll", query = "SELECT b FROM BpmProcessTracking b"),
    @NamedQuery(name = "BpmProcessTracking.findByPersistenceid", query = "SELECT b FROM BpmProcessTracking b WHERE b.persistenceid = :persistenceid")
})
public class BpmProcessTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "BPMPROCESSTRACKING_SEQ", sequenceName = "BPMPROCESSTRACKING_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMPROCESSTRACKING_SEQ")
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REF_ID")
    private BigInteger refId;
    @Size(max = 255)
    @Column(name = "SYSTEM_MODULE")
    private String systemModule;
    @Basic(optional = false)
    @Column(name = "FUNCTIONALITYID")
    private BigInteger functionalityId;
    @Basic(optional = false)
    @Column(name = "CLIENTID")
    private BigInteger clientId;
    @Basic(optional = false)
    @Column(name = "PROJECTID")
    private BigInteger projectId;
    @Basic(optional = false)
    @Column(name = "CONTRACTID")
    private BigInteger contractId;
    @Basic(optional = false)
    @Column(name = "CASE_ID")
    private BigInteger caseId;
    @Basic(optional = false)
    @Column(name = "PROCESS_ID")
    private BigInteger processId;
    @Basic(optional = false)
    @Column(name = "PROCESSCATGID")
    private BigInteger processCatgId;
    @Size(max = 512)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 512)
    @Column(name = "INTERNAL_STATUS")
    private String internalStatus;
    @Size(max = 255)
    @Column(name = "CREATED")
    private String created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "CREATED_BY_ID")
    private BigInteger createdById;
    @Size(max = 255)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "DELETED")
    private Short deleted;
    @Version
    @Column(name = "PERSISTENCEVERSION")
    private Integer persistenceversion;

    public BpmProcessTracking() {
    }

    public BpmProcessTracking(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public BpmProcessTracking(BigDecimal persistenceid, BigInteger refId, BigInteger clientId) {
        this.persistenceid = persistenceid;
        this.refId = refId;
        this.clientId = clientId;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public BigInteger getRefId() {
        return refId;
    }

    public void setRefId(BigInteger refId) {
        this.refId = refId;
    }

    public String getSystemModule() {
        return systemModule;
    }

    public void setSystemModule(String systemModule) {
        this.systemModule = systemModule;
    }

    public BigInteger getFunctionalityId() {
        return functionalityId;
    }

    public void setFunctionalityId(BigInteger functionalityId) {
        this.functionalityId = functionalityId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public BigInteger getCaseId() {
        return caseId;
    }

    public void setCaseId(BigInteger caseId) {
        this.caseId = caseId;
    }

    public BigInteger getProcessId() {
        return processId;
    }

    public void setProcessId(BigInteger processId) {
        this.processId = processId;
    }

    public BigInteger getProcessCatgId() {
        return processCatgId;
    }

    public void setProcessCatgId(BigInteger processCatgId) {
        this.processCatgId = processCatgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInternalStatus() {
        return internalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public BigInteger getCreatedById() {
        return createdById;
    }

    public void setCreatedById(BigInteger createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Integer getPersistenceversion() {
        return persistenceversion;
    }

    public void setPersistenceversion(Integer persistenceversion) {
        this.persistenceversion = persistenceversion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.refId);
        hash = 23 * hash + Objects.hashCode(this.systemModule);
        hash = 23 * hash + Objects.hashCode(this.functionalityId);
        hash = 23 * hash + Objects.hashCode(this.clientId);
        hash = 23 * hash + Objects.hashCode(this.projectId);
        hash = 23 * hash + Objects.hashCode(this.contractId);
        hash = 23 * hash + Objects.hashCode(this.processCatgId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BpmProcessTracking other = (BpmProcessTracking) obj;
        if (!Objects.equals(this.systemModule, other.systemModule)) {
            return false;
        }
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.functionalityId, other.functionalityId)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.contractId, other.contractId)) {
            return false;
        }
        if (!Objects.equals(this.processCatgId, other.processCatgId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BpmProcessTracking{" + "persistenceid=" + persistenceid + ", refId=" + refId + ", clientId=" + clientId + ", caseId=" + caseId + ", processId=" + processId + '}';
    }
}
