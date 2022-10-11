/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeUSDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeUSSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "VW_BPM_DISPATCH_BO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBpmDispatchBo.findAll", query = "SELECT a FROM VwBpmDispatchBo a")})
public class VwBpmDispatchBo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
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
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "DATETIMEREQ_ONJOBSITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimereqOnjobsite;
    @Size(max = 255)
    @Column(name = "DECISIONID")
    private String decisionid;
    @Column(name = "DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneDate;
    @Size(max = 255)
    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;
    @Lob
    @Column(name = "FINALREMARK")
    private String finalremark;
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
    @Transient
    private String canbeCancelled;

    public VwBpmDispatchBo() {
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    @JsonSerialize(using = JsonDateTimeUSSerializer.class)
    @JsonDeserialize(using = JsonDateTimeUSDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDatetimereqOnjobsite() {
        return datetimereqOnjobsite;
    }

    public void setDatetimereqOnjobsite(Date datetimereqOnjobsite) {
        this.datetimereqOnjobsite = datetimereqOnjobsite;
    }

    public String getDecisionid() {
        return decisionid;
    }

    public void setDecisionid(String decisionid) {
        this.decisionid = decisionid;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
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

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRequestnumber() {
        return requestnumber;
    }

    public void setRequestnumber(String requestnumber) {
        this.requestnumber = requestnumber;
    }

    public BigInteger getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(BigInteger requestorId) {
        this.requestorId = requestorId;
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

    public String getMixDesignType() {
        return mixDesignType;
    }

    public void setMixDesignType(String mixDesignType) {
        this.mixDesignType = mixDesignType;
    }

    public String getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(String requestLocation) {
        this.requestLocation = requestLocation;
    }

    public String getReqQty() {
        return reqQty;
    }

    public void setReqQty(String reqQty) {
        this.reqQty = reqQty;
    }

    @JsonGetter(value = "cancelStatus")
    public String getCanbeCancelled() {
        return canbeCancelled;
    }

    public void setCanbeCancelled(String canbeCancelled) {
        this.canbeCancelled = canbeCancelled;
    }
}
