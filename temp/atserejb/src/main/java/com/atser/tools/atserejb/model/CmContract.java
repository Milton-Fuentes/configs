/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "CmContract.findByCNumber", query = "SELECT c FROM CmContract c WHERE c.cNumber = :cNumber")
    , @NamedQuery(name = "CmContract.findByCDate", query = "SELECT c FROM CmContract c WHERE c.cDate = :cDate")
    , @NamedQuery(name = "CmContract.findByCName", query = "SELECT c FROM CmContract c WHERE c.cName = :cName")
    , @NamedQuery(name = "CmContract.findByCAmount", query = "SELECT c FROM CmContract c WHERE c.cAmount = :cAmount")
    , @NamedQuery(name = "CmContract.findByCDays", query = "SELECT c FROM CmContract c WHERE c.cDays = :cDays")
    , @NamedQuery(name = "CmContract.findByStartingDate", query = "SELECT c FROM CmContract c WHERE c.startingDate = :startingDate")
    , @NamedQuery(name = "CmContract.findByCutoffDate", query = "SELECT c FROM CmContract c WHERE c.cutoffDate = :cutoffDate")
    , @NamedQuery(name = "CmContract.findByPManager", query = "SELECT c FROM CmContract c WHERE c.pManager = :pManager")
    , @NamedQuery(name = "CmContract.findByInspector", query = "SELECT c FROM CmContract c WHERE c.inspector = :inspector")
    , @NamedQuery(name = "CmContract.findByEstimator", query = "SELECT c FROM CmContract c WHERE c.estimator = :estimator")
    , @NamedQuery(name = "CmContract.findByKeyMap", query = "SELECT c FROM CmContract c WHERE c.keyMap = :keyMap")
    , @NamedQuery(name = "CmContract.findByDrawgNo", query = "SELECT c FROM CmContract c WHERE c.drawgNo = :drawgNo")
    , @NamedQuery(name = "CmContract.findByWmbe", query = "SELECT c FROM CmContract c WHERE c.wmbe = :wmbe")
    , @NamedQuery(name = "CmContract.findByDamagesPerDay", query = "SELECT c FROM CmContract c WHERE c.damagesPerDay = :damagesPerDay")
    , @NamedQuery(name = "CmContract.findByNtpLetterDate", query = "SELECT c FROM CmContract c WHERE c.ntpLetterDate = :ntpLetterDate")
    , @NamedQuery(name = "CmContract.findByPreConstructionMeetingDate", query = "SELECT c FROM CmContract c WHERE c.preConstructionMeetingDate = :preConstructionMeetingDate")
    , @NamedQuery(name = "CmContract.findByPreConstructionMeetingLoc", query = "SELECT c FROM CmContract c WHERE c.preConstructionMeetingLoc = :preConstructionMeetingLoc")
    , @NamedQuery(name = "CmContract.findBySubcompdate", query = "SELECT c FROM CmContract c WHERE c.subcompdate = :subcompdate")
    , @NamedQuery(name = "CmContract.findByInsurexpdate", query = "SELECT c FROM CmContract c WHERE c.insurexpdate = :insurexpdate")
    , @NamedQuery(name = "CmContract.findByDrugpdate", query = "SELECT c FROM CmContract c WHERE c.drugpdate = :drugpdate")
    , @NamedQuery(name = "CmContract.findByField1", query = "SELECT c FROM CmContract c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmContract.findByField2", query = "SELECT c FROM CmContract c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmContract.findByField3", query = "SELECT c FROM CmContract c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmContract.findByField4", query = "SELECT c FROM CmContract c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmContract.findByField5", query = "SELECT c FROM CmContract c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmContract.findByField6", query = "SELECT c FROM CmContract c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmContract.findByField7", query = "SELECT c FROM CmContract c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmContract.findByField8", query = "SELECT c FROM CmContract c WHERE c.field8 = :field8")
    , @NamedQuery(name = "CmContract.findByCStatus", query = "SELECT c FROM CmContract c WHERE c.cStatus = :cStatus")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_CONTRACT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContract.findAll", query = "SELECT c FROM CmContract c")
    , @NamedQuery(name = "CmContract.findById", query = "SELECT c FROM CmContract c WHERE c.id = :id")})
public class CmContract implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "C_NUMBER")
    private String cNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "C_NAME")
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_AMOUNT")
    private double cAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_DAYS")
    private BigInteger cDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;
    @Column(name = "CUTOFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cutoffDate;
    @Size(max = 50)
    @Column(name = "P_MANAGER")
    private String pManager;
    @Size(max = 50)
    @Column(name = "INSPECTOR")
    private String inspector;
    @Size(max = 50)
    @Column(name = "ESTIMATOR")
    private String estimator;
    @Size(max = 50)
    @Column(name = "KEY_MAP")
    private String keyMap;
    @Size(max = 50)
    @Column(name = "DRAWG_NO")
    private String drawgNo;
    @Size(max = 10)
    @Column(name = "WMBE")
    private String wmbe;
    @Column(name = "DAMAGES_PER_DAY")
    private Double damagesPerDay;
    @Column(name = "NTP_LETTER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ntpLetterDate;
    @Column(name = "PRE_CONSTRUCTION_MEETING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preConstructionMeetingDate;
    @Size(max = 250)
    @Column(name = "PRE_CONSTRUCTION_MEETING_LOC")
    private String preConstructionMeetingLoc;
    @Column(name = "SUBCOMPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subcompdate;
    @Column(name = "INSUREXPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insurexpdate;
    @Column(name = "DRUGPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date drugpdate;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    private Double field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Size(max = 50)
    @Column(name = "C_STATUS")
    private String cStatus;
    @JoinColumn(name = "P_NUMBER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CmProject pNumberId;

    public CmContract() {
    }

    public CmContract(BigDecimal id) {
        this.id = id;
    }

    public CmContract(BigDecimal id, String cNumber, Date cDate, String cName, double cAmount, BigInteger cDays, Date startingDate) {
        this.id = id;
        this.cNumber = cNumber;
        this.cDate = cDate;
        this.cName = cName;
        this.cAmount = cAmount;
        this.cDays = cDays;
        this.startingDate = startingDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCNumber() {
        return cNumber;
    }

    public void setCNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public double getCAmount() {
        return cAmount;
    }

    public void setCAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    public BigInteger getCDays() {
        return cDays;
    }

    public void setCDays(BigInteger cDays) {
        this.cDays = cDays;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(Date cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public String getPManager() {
        return pManager;
    }

    public void setPManager(String pManager) {
        this.pManager = pManager;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getEstimator() {
        return estimator;
    }

    public void setEstimator(String estimator) {
        this.estimator = estimator;
    }

    public String getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(String keyMap) {
        this.keyMap = keyMap;
    }

    public String getDrawgNo() {
        return drawgNo;
    }

    public void setDrawgNo(String drawgNo) {
        this.drawgNo = drawgNo;
    }

    public String getWmbe() {
        return wmbe;
    }

    public void setWmbe(String wmbe) {
        this.wmbe = wmbe;
    }

    public Double getDamagesPerDay() {
        return damagesPerDay;
    }

    public void setDamagesPerDay(Double damagesPerDay) {
        this.damagesPerDay = damagesPerDay;
    }

    public Date getNtpLetterDate() {
        return ntpLetterDate;
    }

    public void setNtpLetterDate(Date ntpLetterDate) {
        this.ntpLetterDate = ntpLetterDate;
    }

    public Date getPreConstructionMeetingDate() {
        return preConstructionMeetingDate;
    }

    public void setPreConstructionMeetingDate(Date preConstructionMeetingDate) {
        this.preConstructionMeetingDate = preConstructionMeetingDate;
    }

    public String getPreConstructionMeetingLoc() {
        return preConstructionMeetingLoc;
    }

    public void setPreConstructionMeetingLoc(String preConstructionMeetingLoc) {
        this.preConstructionMeetingLoc = preConstructionMeetingLoc;
    }

    public Date getSubcompdate() {
        return subcompdate;
    }

    public void setSubcompdate(Date subcompdate) {
        this.subcompdate = subcompdate;
    }

    public Date getInsurexpdate() {
        return insurexpdate;
    }

    public void setInsurexpdate(Date insurexpdate) {
        this.insurexpdate = insurexpdate;
    }

    public Date getDrugpdate() {
        return drugpdate;
    }

    public void setDrugpdate(Date drugpdate) {
        this.drugpdate = drugpdate;
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

    public Double getField6() {
        return field6;
    }

    public void setField6(Double field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public CmProject getPNumberId() {
        return pNumberId;
    }

    public void setPNumberId(CmProject pNumberId) {
        this.pNumberId = pNumberId;
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
        if (!(object instanceof CmContract)) {
            return false;
        }
        CmContract other = (CmContract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContract[ id=" + id + " ]";
    }
    
}
