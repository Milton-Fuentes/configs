/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "VW_DISPATCHMAINLOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwDispatchMainLog.findAll", query = "SELECT a FROM VwDispatchMainLog a"),
    @NamedQuery(name = "VwDispatchMainLog.findById", query = "SELECT q FROM VwDispatchMainLog q WHERE q.id = :id")})
public class VwDispatchMainLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Size(max = 10)
    @Column(name = "OFFICE_LOCATION")
    private String officeLocation;
    @Column(name = "SERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDate;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "PROJECT_CLIENT_ID")
    private BigInteger projectClientId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 4000)
    @Column(name = "PROJECT_CLIENT_NAME")
    private String projectClientName;
    @Column(name = "CONTRACT_AMOUNT")
    private BigDecimal contractAmount;
    @Column(name = "INVOICED_AMOUNT")
    private BigDecimal invoicedAmount;
    @Size(max = 4000)
    @Column(name = "SERVICES_REQUESTED")
    private String servicesRequested;
    @Size(max = 4000)
    @Column(name = "SPEC_INSTR")
    private String specInstr;
    @Size(max = 4000)
    @Column(name = "TIME_SITE")
    private String timeSite;
    @Column(name = "HOURS")
    private BigDecimal hours;
    @Column(name = "RATE")
    private BigDecimal rate;
    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;
    @Column(name = "GROSS_MARGIN")
    private BigDecimal grossMargin;
    @Size(max = 4000)
    @Column(name = "TECHNICIAN")
    private String technician;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Size(max = 103)
    @Column(name = "LAB_FUNCTION")
    private String labFunction;
    @Column(name = "WO_ID")
    private BigInteger woId;
    @Size(max = 4000)
    @Column(name = "DEPT")
    private String dept;
    @Size(max = 3)
    @Column(name = "CANCELLEDCALL")
    private String cancelledCall;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "WO_NO")
    private String woNo;
    @Size(max = 3)
    @Column(name = "CANCELLEDWO")
    private String cancelledWo;
    @Column(name = "TOTALHOURS")
    private BigDecimal totalHours;
    @Size(max = 4000)
    @Column(name = "REQUESTED_BY")
    private String requestedBy;
    @Size(max = 50)
    @Column(name = "REQUESTED_DATE")
    private String requestedDate;
    @Size(max = 50)
    @Column(name = "REQUESTED_TIME")
    private String requestedTime;
    @Column(name = "PAPERWORK_RECEIVED")
    private Character paperworkReceived;
    @Column(name = "CERT_BILLING_CODE_ID")
    private BigInteger certBillingCodeId;
    @Size(max = 50)
    @Column(name = "ASSIGNMENT")
    private String assigment;
    @Size(max = 255)
    @Column(name = "CERT_BILLING_CODE_DESC")
    private String certBillingCodeDesc;
    @Column(name = "CREDIT_HOLD")
    private Character creditHold;
    @Column(name = "TECHREFID")
    private BigInteger techRefId;
    @Column(name = "DECISIONFLAG")
    private Long decisionFlag;
    @Size(max = 50)
    @Column(name = "REQLOCATION")
    private String reqLocation;
    @Size(max = 25)
    @Column(name = "EMAIL_STATUS")
    private String emailStatus;
    @Size(max = 255)
    @Column(name = "EMAIL_REASON")
    private String emailReason;

    public VwDispatchMainLog() {
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

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getProjectClientId() {
        return projectClientId;
    }

    public void setProjectClientId(BigInteger projectClientId) {
        this.projectClientId = projectClientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectClientName() {
        return projectClientName;
    }

    public void setProjectClientName(String projectClientName) {
        this.projectClientName = projectClientName;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setInvoicedAmount(BigDecimal invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public String getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(String servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public String getSpecInstr() {
        return specInstr;
    }

    public void setSpecInstr(String specInstr) {
        this.specInstr = specInstr;
    }

    public String getTimeSite() {
        return timeSite;
    }

    public void setTimeSite(String timeSite) {
        this.timeSite = timeSite;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin) {
        this.grossMargin = grossMargin;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public BigInteger getWoId() {
        return woId;
    }

    public void setWoId(BigInteger woId) {
        this.woId = woId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCancelledCall() {
        return StringSupport.isNullOrEmpty(cancelledCall) ? "No" : cancelledCall;
    }

    public void setCancelledCall(String cancelledCall) {
        this.cancelledCall = cancelledCall;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWoNo() {
        return woNo;
    }

    public void setWoNo(String woNo) {
        this.woNo = woNo;
    }

    public String getCancelledWo() {
        return StringSupport.isNullOrEmpty(cancelledWo) ? "No" : cancelledWo;
    }

    public void setCancelledWo(String cancelledWo) {
        this.cancelledWo = cancelledWo;
    }

    public BigDecimal getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(BigDecimal totalHours) {
        this.totalHours = totalHours;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    public Character getPaperworkReceived() {
        if (paperworkReceived == null || paperworkReceived == ' ') {
            return 'N';
        }
        return paperworkReceived;
    }

    public void setPaperworkReceived(Character paperworkReceived) {
        this.paperworkReceived = paperworkReceived;
    }

    public BigInteger getCertBillingCodeId() {
        return certBillingCodeId;
    }

    public void setCertBillingCodeId(BigInteger certBillingCodeId) {
        this.certBillingCodeId = certBillingCodeId;
    }

    public String getAssigment() {
        return assigment;
    }

    public void setAssigment(String assigment) {
        this.assigment = assigment;
    }

    public String getCertBillingCodeDesc() {
        return certBillingCodeDesc;
    }

    public void setCertBillingCodeDesc(String certBillingCodeDesc) {
        this.certBillingCodeDesc = certBillingCodeDesc;
    }

    public Character getCreditHold() {
        return creditHold;
    }

    public void setCreditHold(Character creditHold) {
        this.creditHold = creditHold;
    }

    public BigInteger getTechRefId() {
        return techRefId;
    }

    public void setTechRefId(BigInteger techRefId) {
        this.techRefId = techRefId;
    }

    public Long getDecisionFlag() {
        return decisionFlag;
    }

    public void setDecisionFlag(Long decisionFlag) {
        this.decisionFlag = decisionFlag;
    }

    public String getReqLocation() {
        return reqLocation;
    }

    public void setReqLocation(String reqLocation) {
        this.reqLocation = reqLocation;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailReason() {
        return emailReason;
    }

    public void setEmailReason(String emailReason) {
        this.emailReason = emailReason;
    }
}
