/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "VW_RTPO_BALANCE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRtpoBalance.findAll", query = "SELECT a FROM VwRtpoBalance a")})
public class VwRtpoBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ROW_ID")
    private BigDecimal rowId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Column(name = "PROGRAM_NAME")
    @Size(max = 100)
    private String programName;
    @Column(name = "PHASE")
    @Size(max = 15)
    private String phase;
    @Column(name = "JOB_NO")
    @Size(max = 256)
    private String jobNo;
    @Column(name = "PURCHASE_ORDER_NO")
    @Size(max = 50)
    private String purchaseOrderNo;
    @Column(name = "C_NUMBER")
    @Size(max = 50)
    private String cnumber;
    @Column(name = "C_NAME")
    @Size(max = 255)
    private String cname;
    @Column(name = "C_STATUS")
    @Size(max = 50)
    private String cstatus;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "C_DESCRIPTION")
    @Size(max = 4000)
    private String cdescription;
    @Column(name = "C_AMOUNT")
    private Double camount;
    @Column(name = "P_STATUS")
    @Size(max = 50)
    private String pstatus;
    @Column(name = "P_NUMBER")
    @Size(max = 25)
    private String pnumber;
    @Column(name = "PROJECT_CODE")
    @Size(max = 50)
    private String projectCode;
    @Column(name = "P_DATE")
    @Temporal(TemporalType.DATE)
    private Date pdate;
    @Column(name = "P_NAME")
    @Size(max = 255)
    private String pname;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    public VwRtpoBalance() {
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setRowId(BigDecimal rowId) {
        this.rowId = rowId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public Double getCamount() {
        return camount;
    }

    public void setCamount(Double camount) {
        this.camount = camount;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }    
}
