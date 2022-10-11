/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
    , @NamedQuery(name = "InReportType.findByReportName", query = "SELECT i FROM InReportType i WHERE i.reportName = :reportName")
    , @NamedQuery(name = "InReportType.findByReportTable", query = "SELECT i FROM InReportType i WHERE i.reportTable = :reportTable")
    , @NamedQuery(name = "InReportType.findByReportJsp", query = "SELECT i FROM InReportType i WHERE i.reportJsp = :reportJsp")
    , @NamedQuery(name = "InReportType.findByReportPrintout", query = "SELECT i FROM InReportType i WHERE i.reportPrintout = :reportPrintout")
    , @NamedQuery(name = "InReportType.findByActive", query = "SELECT i FROM InReportType i WHERE i.active = :active")
    , @NamedQuery(name = "InReportType.findByLastMod", query = "SELECT i FROM InReportType i WHERE i.lastMod = :lastMod")
    , @NamedQuery(name = "InReportType.findByLastModBy", query = "SELECT i FROM InReportType i WHERE i.lastModBy = :lastModBy")
    , @NamedQuery(name = "InReportType.findByLastModIp", query = "SELECT i FROM InReportType i WHERE i.lastModIp = :lastModIp")
    , @NamedQuery(name = "InReportType.findByTemp", query = "SELECT i FROM InReportType i WHERE i.temp = :temp")
    , @NamedQuery(name = "InReportType.findByCreateBy", query = "SELECT i FROM InReportType i WHERE i.createBy = :createBy")
    , @NamedQuery(name = "InReportType.findByCreateByIp", query = "SELECT i FROM InReportType i WHERE i.createByIp = :createByIp")
    , @NamedQuery(name = "InReportType.findByCreateDate", query = "SELECT i FROM InReportType i WHERE i.createDate = :createDate")
    , @NamedQuery(name = "InReportType.findByLastModTmp", query = "SELECT i FROM InReportType i WHERE i.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "InReportType.findByTempTmp", query = "SELECT i FROM InReportType i WHERE i.tempTmp = :tempTmp")
    , @NamedQuery(name = "InReportType.findByCreateDateTmp", query = "SELECT i FROM InReportType i WHERE i.createDateTmp = :createDateTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "IN_REPORT_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InReportType.findAll", query = "SELECT i FROM InReportType i")
    , @NamedQuery(name = "InReportType.findById", query = "SELECT i FROM InReportType i WHERE i.id = :id")})
public class InReportType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "REPORT_NAME")
    private String reportName;
    @Size(max = 4000)
    @Column(name = "REPORT_TABLE")
    private String reportTable;
    @Size(max = 4000)
    @Column(name = "REPORT_JSP")
    private String reportJsp;
    @Size(max = 4000)
    @Column(name = "REPORT_PRINTOUT")
    private String reportPrintout;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @OneToMany(mappedBy = "reportTypeId")
    private List<InReport> inReportList;

    public InReportType() {
    }

    public InReportType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportTable() {
        return reportTable;
    }

    public void setReportTable(String reportTable) {
        this.reportTable = reportTable;
    }

    public String getReportJsp() {
        return reportJsp;
    }

    public void setReportJsp(String reportJsp) {
        this.reportJsp = reportJsp;
    }

    public String getReportPrintout() {
        return reportPrintout;
    }

    public void setReportPrintout(String reportPrintout) {
        this.reportPrintout = reportPrintout;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    @XmlTransient
    public List<InReport> getInReportList() {
        return inReportList;
    }

    public void setInReportList(List<InReport> inReportList) {
        this.inReportList = inReportList;
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
        if (!(object instanceof InReportType)) {
            return false;
        }
        InReportType other = (InReportType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.InReportType[ id=" + id + " ]";
    }
    
}
