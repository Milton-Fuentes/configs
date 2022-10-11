/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.objects.to.jasper.view.InvoiceSummaryTO;
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
@Table(name = "VW_QM_SUMMARY_INVOICE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQmSummaryInvoice.findAll", query = "SELECT a FROM VwQmSummaryInvoice a")})
public class VwQmSummaryInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "PROJECT_CLIENT_NO")
    private String projectClientNo;
    @Size(max = 4000)
    @Column(name = "PROJECT_CLIENT_NAME")
    private String projectClientName;
    @Size(max = 103)
    @Column(name = "OFFICELOCATION")
    private String officeLocation;
    @Size(max = 255)
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Size(max = 25)
    @Column(name = "PROJECT_NUMBER")
    private String projectNumber;
    @Size(max = 255)
    @Column(name = "INVOICE_NO")
    private String invoiceNo;
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Column(name = "INVOICE_AMOUNT")
    private BigDecimal invoiceAmount;
    @Column(name = "TOTAL_TODATE_AMOUNT")
    private BigDecimal totalToDateAmount;
    @Column(name = "TOTAL_BALANCE_AMOUNT")
    private BigDecimal totalBalanceAmount;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;

    public VwQmSummaryInvoice() {
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectClientNo() {
        return projectClientNo;
    }

    public void setProjectClientNo(String projectClientNo) {
        this.projectClientNo = projectClientNo;
    }

    public String getProjectClientName() {
        return projectClientName;
    }

    public void setProjectClientName(String projectClientName) {
        this.projectClientName = projectClientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getTotalToDateAmount() {
        return totalToDateAmount;
    }

    public void setTotalToDateAmount(BigDecimal totalToDateAmount) {
        this.totalToDateAmount = totalToDateAmount;
    }

    public BigDecimal getTotalBalanceAmount() {
        return totalBalanceAmount;
    }

    public void setTotalBalanceAmount(BigDecimal totalBalanceAmount) {
        this.totalBalanceAmount = totalBalanceAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    public InvoiceSummaryTO convertToInvoiceSummaryTO() {
        InvoiceSummaryTO obj = new InvoiceSummaryTO();
        obj.setProjectClientNo(StringSupport.emptyOnNull(this.getProjectClientNo()));
        obj.setProjectClientName(StringSupport.emptyOnNull(this.getProjectClientName()));
        obj.setProjectName(StringSupport.emptyOnNull(this.getProjectName()));
        obj.setProjectNumber(StringSupport.emptyOnNull(this.getProjectNumber()));
        obj.setOfficeLocation(StringSupport.emptyOnNull(this.getOfficeLocation()));
        obj.setInvoiceNo(StringSupport.emptyOnNull(this.getInvoiceNo()));
        obj.setInvoiceDate(DateSupport.formatDate(this.getInvoiceDate(), DateSupport.FORMAT_US));
        obj.setInvoiceAmount("$ " + CurrencySupport.formatBigDecimalToString(this.getInvoiceAmount(), 2));
        obj.setTotalToDateAmount("$ " + CurrencySupport.formatBigDecimalToString(this.getTotalToDateAmount(), 2));
        obj.setTotalBalanceAmount("$ " + CurrencySupport.formatBigDecimalToString(this.getTotalBalanceAmount(), 2));
        obj.setStatus(StringSupport.emptyOnNull(this.getStatus()));
        return obj;
    }

}
