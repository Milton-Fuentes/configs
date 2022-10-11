/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.file.FileSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "WsReport.findByClientId", query = "SELECT w FROM WsReport w WHERE w.clientId = :clientId"),
    @NamedQuery(name = "WsReport.findByReportCode", query = "SELECT w FROM WsReport w WHERE w.reportCode = :reportCode"),
    @NamedQuery(name = "WsReport.findByReportName", query = "SELECT w FROM WsReport w WHERE w.reportName = :reportName"),
    @NamedQuery(name = "WsReport.findByReportPath", query = "SELECT w FROM WsReport w WHERE w.reportPath = :reportPath"),
    @NamedQuery(name = "WsReport.findByActive", query = "SELECT w FROM WsReport w WHERE w.active = :active"),
    @NamedQuery(name = "WsReport.findByDeleted", query = "SELECT w FROM WsReport w WHERE w.deleted = :deleted"),
    @NamedQuery(name = "WsReport.findByCreated", query = "SELECT w FROM WsReport w WHERE w.created = :created"),
    @NamedQuery(name = "WsReport.findByCreatedBy", query = "SELECT w FROM WsReport w WHERE w.createdBy = :createdBy"),
    @NamedQuery(name = "WsReport.findByCreatedByIp", query = "SELECT w FROM WsReport w WHERE w.createdByIp = :createdByIp"),
    @NamedQuery(name = "WsReport.findByLastMod", query = "SELECT w FROM WsReport w WHERE w.lastMod = :lastMod"),
    @NamedQuery(name = "WsReport.findByLastModBy", query = "SELECT w FROM WsReport w WHERE w.lastModBy = :lastModBy"),
    @NamedQuery(name = "WsReport.findByLastModByIp", query = "SELECT w FROM WsReport w WHERE w.lastModByIp = :lastModByIp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "WS_REPORT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE WS_REPORT SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsReport.findAll", query = "SELECT w FROM WsReport w"),
    @NamedQuery(name = "WsReport.findById", query = "SELECT w FROM WsReport w WHERE w.id = :id"),
    @NamedQuery(name = "WsReport.findSpecReport", query = "SELECT w FROM WsReport w WHERE w.clientId = :clientId AND w.reportFunctionality = :reportFunctionality AND w.reportCode = :reportCode AND w.active = 'Y'")})
public class WsReport implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "WS_REPORT_SEQ", sequenceName = "WS_REPORT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_REPORT_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID", nullable = false)
    private BigInteger clientId;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "REPORT_FUNCTIONALITY", length = 255)
    private String reportFunctionality;
    @Size(max = 150)
    @Column(name = "REPORT_CODE", length = 150)
    private String reportCode;
    @Size(max = 255)
    @Column(name = "REPORT_NAME", length = 255)
    private String reportName;
    @Size(max = 1024)
    @Column(name = "REPORT_PATH", length = 1024)
    private String reportPath;
    @Column(name = "REPORT_ORDER")
    private Integer reportOrder;
    @Size(max = 10)
    @Column(name = "ACTIVE", length = 10)
    private String active;
    @JsonIgnore
    @Size(max = 10)
    @Column(name = "DELETED", length = 10, insertable = false, updatable = false)
    private String deleted;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 150)
    @Column(name = "CREATED_BY", length = 150)
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP", length = 50)
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 150)
    @Column(name = "LAST_MOD_BY", length = 150)
    private String lastModBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_BY_IP", length = 50)
    private String lastModByIp;
    @JoinTable(name = "WS_REPORT_SUBREPORT", joinColumns = {
        @JoinColumn(name = "REPORT_ID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "SUBREPORT_ID", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<WsSubreport> subReportList;

    public WsReport() {
    }

    public WsReport(BigDecimal id) {
        this.id = id;
    }

    public WsReport(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
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

    public String getReportFunctionality() {
        return reportFunctionality;
    }

    public void setReportFunctionality(String reportFunctionality) {
        this.reportFunctionality = reportFunctionality;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Integer getReportOrder() {
        return reportOrder;
    }

    public void setReportOrder(Integer reportOrder) {
        this.reportOrder = reportOrder;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModByIp() {
        return lastModByIp;
    }

    public void setLastModByIp(String lastModByIp) {
        this.lastModByIp = lastModByIp;
    }

    @XmlTransient
    public List<WsSubreport> getSubReportList() {
        return subReportList;
    }

    public void setSubReportList(List<WsSubreport> subReportList) {
        this.subReportList = subReportList;
    }

    public Map<String, Object> generateSubReportsForJasper(String tplbasePath) {
        Map<String, Object> paramsJasper = new HashMap<>();
        subReportList.forEach(it -> {
            paramsJasper.put(it.getSubreportName(), FileSupport.FicheroAByteArrayIS(tplbasePath + it.getSubreportPath()));
        });
        return paramsJasper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WsReport)) {
            return false;
        }
        WsReport other = (WsReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsReport[ id=" + id + " ]";
    }

}
