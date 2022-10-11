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
import java.util.Date;
import javax.persistence.Basic;
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
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "CmContractActivity.findByContractId", query = "SELECT c FROM CmContractActivity c WHERE c.contractId = :contractId")
    , @NamedQuery(name = "CmContractActivity.findByActvLevel1", query = "SELECT c FROM CmContractActivity c WHERE c.actvLevel1 = :actvLevel1")
    , @NamedQuery(name = "CmContractActivity.findByActvLevel2", query = "SELECT c FROM CmContractActivity c WHERE c.actvLevel2 = :actvLevel2")
    , @NamedQuery(name = "CmContractActivity.findByActvCatg", query = "SELECT c FROM CmContractActivity c WHERE c.actvCatg = :actvCatg")
    , @NamedQuery(name = "CmContractActivity.findByActvNo", query = "SELECT c FROM CmContractActivity c WHERE c.actvNo = :actvNo")
    , @NamedQuery(name = "CmContractActivity.findByActvDescript", query = "SELECT c FROM CmContractActivity c WHERE c.actvDescript = :actvDescript")
    , @NamedQuery(name = "CmContractActivity.findByPerComp", query = "SELECT c FROM CmContractActivity c WHERE c.perComp = :perComp")
    , @NamedQuery(name = "CmContractActivity.findByOrigDuration", query = "SELECT c FROM CmContractActivity c WHERE c.origDuration = :origDuration")
    , @NamedQuery(name = "CmContractActivity.findByBaseStartDate", query = "SELECT c FROM CmContractActivity c WHERE c.baseStartDate = :baseStartDate")
    , @NamedQuery(name = "CmContractActivity.findByBaseEndDate", query = "SELECT c FROM CmContractActivity c WHERE c.baseEndDate = :baseEndDate")
    , @NamedQuery(name = "CmContractActivity.findByActualStartDate", query = "SELECT c FROM CmContractActivity c WHERE c.actualStartDate = :actualStartDate")
    , @NamedQuery(name = "CmContractActivity.findByActualEndDate", query = "SELECT c FROM CmContractActivity c WHERE c.actualEndDate = :actualEndDate")
    , @NamedQuery(name = "CmContractActivity.findByTotalFloatDays", query = "SELECT c FROM CmContractActivity c WHERE c.totalFloatDays = :totalFloatDays")
    , @NamedQuery(name = "CmContractActivity.findByBdgtLaborUnits", query = "SELECT c FROM CmContractActivity c WHERE c.bdgtLaborUnits = :bdgtLaborUnits")
    , @NamedQuery(name = "CmContractActivity.findByBdgtNonlaborUnits", query = "SELECT c FROM CmContractActivity c WHERE c.bdgtNonlaborUnits = :bdgtNonlaborUnits")
    , @NamedQuery(name = "CmContractActivity.findByBdgtTotalCost", query = "SELECT c FROM CmContractActivity c WHERE c.bdgtTotalCost = :bdgtTotalCost")
    , @NamedQuery(name = "CmContractActivity.findByCalendarType", query = "SELECT c FROM CmContractActivity c WHERE c.calendarType = :calendarType")
    , @NamedQuery(name = "CmContractActivity.findByComments", query = "SELECT c FROM CmContractActivity c WHERE c.comments = :comments")
    , @NamedQuery(name = "CmContractActivity.findByStatus", query = "SELECT c FROM CmContractActivity c WHERE c.status = :status")
    , @NamedQuery(name = "CmContractActivity.findByActive", query = "SELECT c FROM CmContractActivity c WHERE c.active = :active")
    , @NamedQuery(name = "CmContractActivity.findByField1", query = "SELECT c FROM CmContractActivity c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmContractActivity.findByField2", query = "SELECT c FROM CmContractActivity c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmContractActivity.findByField3", query = "SELECT c FROM CmContractActivity c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmContractActivity.findByField4", query = "SELECT c FROM CmContractActivity c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmContractActivity.findByField5", query = "SELECT c FROM CmContractActivity c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmContractActivity.findByField6", query = "SELECT c FROM CmContractActivity c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmContractActivity.findByCreateBy", query = "SELECT c FROM CmContractActivity c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmContractActivity.findByCreateByIp", query = "SELECT c FROM CmContractActivity c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmContractActivity.findByLastModBy", query = "SELECT c FROM CmContractActivity c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmContractActivity.findByLastMod", query = "SELECT c FROM CmContractActivity c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmContractActivity.findByLastModIp", query = "SELECT c FROM CmContractActivity c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmContractActivity.findByVersion", query = "SELECT c FROM CmContractActivity c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Where(clause = "active = 'Y'")
@Table(name = "CM_CONTRACT_ACTIVITY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContractActivity.findAll", query = "SELECT c FROM CmContractActivity c")
    , @NamedQuery(name = "CmContractActivity.findById", query = "SELECT c FROM CmContractActivity c WHERE c.id = :id")})
public class CmContractActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Size(max = 500)
    @Column(name = "ACTV_LEVEL1")
    private String actvLevel1;
    @Size(max = 500)
    @Column(name = "ACTV_LEVEL2")
    private String actvLevel2;
    @Size(max = 500)
    @Column(name = "ACTV_CATG")
    private String actvCatg;
    @Size(max = 500)
    @Column(name = "ACTV_NO")
    private String actvNo;
    @Size(max = 500)
    @Column(name = "ACTV_DESCRIPT")
    private String actvDescript;
    @Size(max = 50)
    @Column(name = "PER_COMP")
    private String perComp;
    @Column(name = "ORIG_DURATION")
    private Double origDuration;
    @Column(name = "BASE_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baseStartDate;
    @Column(name = "BASE_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baseEndDate;
    @Column(name = "ACTUAL_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStartDate;
    @Column(name = "ACTUAL_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDate;
    @Column(name = "TOTAL_FLOAT_DAYS")
    private Double totalFloatDays;
    @Column(name = "BDGT_LABOR_UNITS")
    private Double bdgtLaborUnits;
    @Column(name = "BDGT_NONLABOR_UNITS")
    private Double bdgtNonlaborUnits;
    @Column(name = "BDGT_TOTAL_COST")
    private Double bdgtTotalCost;
    @Size(max = 50)
    @Column(name = "CALENDAR_TYPE")
    private String calendarType;
    @Size(max = 3000)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public CmContractActivity() {
    }

    public CmContractActivity(BigDecimal id) {
        this.id = id;
    }

    public CmContractActivity(BigDecimal id, BigInteger contractId) {
        this.id = id;
        this.contractId = contractId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public String getActvLevel1() {
        return actvLevel1;
    }

    public void setActvLevel1(String actvLevel1) {
        this.actvLevel1 = actvLevel1;
    }

    public String getActvLevel2() {
        return actvLevel2;
    }

    public void setActvLevel2(String actvLevel2) {
        this.actvLevel2 = actvLevel2;
    }

    public String getActvCatg() {
        return actvCatg;
    }

    public void setActvCatg(String actvCatg) {
        this.actvCatg = actvCatg;
    }

    public String getActvNo() {
        return actvNo;
    }
    
    public String getActivityFullName() {
        return this.getActvNo() + " - " + this.getActvDescript();
    }

    public void setActvNo(String actvNo) {
        this.actvNo = actvNo;
    }

    public String getActvDescript() {
        return actvDescript;
    }

    public void setActvDescript(String actvDescript) {
        this.actvDescript = actvDescript;
    }

    public String getPerComp() {
        return perComp;
    }

    public void setPerComp(String perComp) {
        this.perComp = perComp;
    }

    public Double getOrigDuration() {
        return origDuration;
    }

    public void setOrigDuration(Double origDuration) {
        this.origDuration = origDuration;
    }

    public Date getBaseStartDate() {
        return baseStartDate;
    }

    public void setBaseStartDate(Date baseStartDate) {
        this.baseStartDate = baseStartDate;
    }

    public Date getBaseEndDate() {
        return baseEndDate;
    }

    public void setBaseEndDate(Date baseEndDate) {
        this.baseEndDate = baseEndDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Double getTotalFloatDays() {
        return totalFloatDays;
    }

    public void setTotalFloatDays(Double totalFloatDays) {
        this.totalFloatDays = totalFloatDays;
    }

    public Double getBdgtLaborUnits() {
        return bdgtLaborUnits;
    }

    public void setBdgtLaborUnits(Double bdgtLaborUnits) {
        this.bdgtLaborUnits = bdgtLaborUnits;
    }

    public Double getBdgtNonlaborUnits() {
        return bdgtNonlaborUnits;
    }

    public void setBdgtNonlaborUnits(Double bdgtNonlaborUnits) {
        this.bdgtNonlaborUnits = bdgtNonlaborUnits;
    }

    public Double getBdgtTotalCost() {
        return bdgtTotalCost;
    }

    public void setBdgtTotalCost(Double bdgtTotalCost) {
        this.bdgtTotalCost = bdgtTotalCost;
    }

    public String getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof CmContractActivity)) {
            return false;
        }
        CmContractActivity other = (CmContractActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContractActivity[ id=" + id + " ]";
    }
    
}
