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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "QasoilDensity.findBySampletestId", query = "SELECT q FROM QasoilDensity q WHERE q.sampletestId = :sampletestId"),
    @NamedQuery(name = "QasoilDensity.findByCategory", query = "SELECT q FROM QasoilDensity q WHERE q.category = :category"),
    @NamedQuery(name = "QasoilDensity.findByCompspec", query = "SELECT q FROM QasoilDensity q WHERE q.compspec = :compspec"),
    @NamedQuery(name = "QasoilDensity.findByMoistureTolReq", query = "SELECT q FROM QasoilDensity q WHERE q.moistureTolReq = :moistureTolReq"),
    @NamedQuery(name = "QasoilDensity.findByProctorType", query = "SELECT q FROM QasoilDensity q WHERE q.proctorType = :proctorType"),
    @NamedQuery(name = "QasoilDensity.findByTestinstr", query = "SELECT q FROM QasoilDensity q WHERE q.testinstr = :testinstr"),
    @NamedQuery(name = "QasoilDensity.findBySerialno", query = "SELECT q FROM QasoilDensity q WHERE q.serialno = :serialno"),
    @NamedQuery(name = "QasoilDensity.findByStdctdensity", query = "SELECT q FROM QasoilDensity q WHERE q.stdctdensity = :stdctdensity"),
    @NamedQuery(name = "QasoilDensity.findByStdctmoisture", query = "SELECT q FROM QasoilDensity q WHERE q.stdctmoisture = :stdctmoisture"),
    @NamedQuery(name = "QasoilDensity.findByTesttype", query = "SELECT q FROM QasoilDensity q WHERE q.testtype = :testtype"),
    @NamedQuery(name = "QasoilDensity.findByWeather", query = "SELECT q FROM QasoilDensity q WHERE q.weather = :weather"),
    @NamedQuery(name = "QasoilDensity.findBySpecRef", query = "SELECT q FROM QasoilDensity q WHERE q.specRef = :specRef"),
    @NamedQuery(name = "QasoilDensity.findByPage", query = "SELECT q FROM QasoilDensity q WHERE q.page = :page"),
    @NamedQuery(name = "QasoilDensity.findByReport", query = "SELECT q FROM QasoilDensity q WHERE q.report = :report"),
    @NamedQuery(name = "QasoilDensity.findByUnitengmet", query = "SELECT q FROM QasoilDensity q WHERE q.unitengmet = :unitengmet"),
    @NamedQuery(name = "QasoilDensity.findByField1", query = "SELECT q FROM QasoilDensity q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QasoilDensity.findByField2", query = "SELECT q FROM QasoilDensity q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QasoilDensity.findByField3", query = "SELECT q FROM QasoilDensity q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QasoilDensity.findByField4", query = "SELECT q FROM QasoilDensity q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QasoilDensity.findByField5", query = "SELECT q FROM QasoilDensity q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QasoilDensity.findByField6", query = "SELECT q FROM QasoilDensity q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QasoilDensity.findByField7", query = "SELECT q FROM QasoilDensity q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QasoilDensity.findByField8", query = "SELECT q FROM QasoilDensity q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QasoilDensity.findByField9", query = "SELECT q FROM QasoilDensity q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QasoilDensity.findByField10", query = "SELECT q FROM QasoilDensity q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QasoilDensity.findByActive", query = "SELECT q FROM QasoilDensity q WHERE q.active = :active"),
    @NamedQuery(name = "QasoilDensity.findByLastModBy", query = "SELECT q FROM QasoilDensity q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QasoilDensity.findByLastModIp", query = "SELECT q FROM QasoilDensity q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QasoilDensity.findByCreateBy", query = "SELECT q FROM QasoilDensity q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QasoilDensity.findByCreateByIp", query = "SELECT q FROM QasoilDensity q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QasoilDensity.findByVersion", query = "SELECT q FROM QasoilDensity q WHERE q.version = :version"),
    @NamedQuery(name = "QasoilDensity.findByRptFilename", query = "SELECT q FROM QasoilDensity q WHERE q.rptFilename = :rptFilename"),
    @NamedQuery(name = "QasoilDensity.findByCompEquipment", query = "SELECT q FROM QasoilDensity q WHERE q.compEquipment = :compEquipment"),
    @NamedQuery(name = "QasoilDensity.findByRemarks", query = "SELECT q FROM QasoilDensity q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QasoilDensity.findByForeman", query = "SELECT q FROM QasoilDensity q WHERE q.foreman = :foreman"),
    @NamedQuery(name = "QasoilDensity.findByCategoryno", query = "SELECT q FROM QasoilDensity q WHERE q.categoryno = :categoryno"),
    @NamedQuery(name = "QasoilDensity.findByRandomshtno", query = "SELECT q FROM QasoilDensity q WHERE q.randomshtno = :randomshtno"),
    @NamedQuery(name = "QasoilDensity.findByMaterialdesc", query = "SELECT q FROM QasoilDensity q WHERE q.materialdesc = :materialdesc"),
    @NamedQuery(name = "QasoilDensity.findByGenTestloc", query = "SELECT q FROM QasoilDensity q WHERE q.genTestloc = :genTestloc"),
    @NamedQuery(name = "QasoilDensity.findByFarSummary", query = "SELECT q FROM QasoilDensity q WHERE q.farSummary = :farSummary"),
    @NamedQuery(name = "QasoilDensity.findByAvgCompaction", query = "SELECT q FROM QasoilDensity q WHERE q.avgCompaction = :avgCompaction"),
    @NamedQuery(name = "QasoilDensity.findBySplitno", query = "SELECT q FROM QasoilDensity q WHERE q.splitno = :splitno"),
    @NamedQuery(name = "QasoilDensity.findBySplitsample", query = "SELECT q FROM QasoilDensity q WHERE q.splitsample = :splitsample"),
    @NamedQuery(name = "QasoilDensity.findByClass1", query = "SELECT q FROM QasoilDensity q WHERE q.class1 = :class1"),
    @NamedQuery(name = "QasoilDensity.findByLastModTmp", query = "SELECT q FROM QasoilDensity q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QasoilDensity.findByTempTmp", query = "SELECT q FROM QasoilDensity q WHERE q.tempTmp = :tempTmp"),
    @NamedQuery(name = "QasoilDensity.findByCreateDateTmp", query = "SELECT q FROM QasoilDensity q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QasoilDensity.findByTemp", query = "SELECT q FROM QasoilDensity q WHERE q.temp = :temp"),
    @NamedQuery(name = "QasoilDensity.findByLastMod", query = "SELECT q FROM QasoilDensity q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QasoilDensity.findByCreateDate", query = "SELECT q FROM QasoilDensity q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QasoilDensity.findByContractName", query = "SELECT q FROM QasoilDensity q WHERE q.contractName = :contractName"),
    @NamedQuery(name = "QasoilDensity.findByPdaReportNo", query = "SELECT q FROM QasoilDensity q WHERE q.pdaReportNo = :pdaReportNo"),
    @NamedQuery(name = "QasoilDensity.findByTestplanId", query = "SELECT q FROM QasoilDensity q WHERE q.testplanId = :testplanId"),
    @NamedQuery(name = "QasoilDensity.findByCompspecMax", query = "SELECT q FROM QasoilDensity q WHERE q.compspecMax = :compspecMax"),
    @NamedQuery(name = "QasoilDensity.findByQuantity", query = "SELECT q FROM QasoilDensity q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QasoilDensity.findByOwner", query = "SELECT q FROM QasoilDensity q WHERE q.owner = :owner"),
    @NamedQuery(name = "QasoilDensity.findBySuperintendentId", query = "SELECT q FROM QasoilDensity q WHERE q.superintendentId = :superintendentId"),
    @NamedQuery(name = "QasoilDensity.findByForemanId", query = "SELECT q FROM QasoilDensity q WHERE q.foremanId = :foremanId"),
    @NamedQuery(name = "QasoilDensity.findByBidItemNumber", query = "SELECT q FROM QasoilDensity q WHERE q.bidItemNumber = :bidItemNumber"),
    @NamedQuery(name = "QasoilDensity.findByDbSection", query = "SELECT q FROM QasoilDensity q WHERE q.dbSection = :dbSection"),
    @NamedQuery(name = "QasoilDensity.findByDepartLab", query = "SELECT q FROM QasoilDensity q WHERE q.departLab = :departLab"),
    @NamedQuery(name = "QasoilDensity.findByArriveSite", query = "SELECT q FROM QasoilDensity q WHERE q.arriveSite = :arriveSite"),
    @NamedQuery(name = "QasoilDensity.findByLunchHours", query = "SELECT q FROM QasoilDensity q WHERE q.lunchHours = :lunchHours"),
    @NamedQuery(name = "QasoilDensity.findByLunchMins", query = "SELECT q FROM QasoilDensity q WHERE q.lunchMins = :lunchMins"),
    @NamedQuery(name = "QasoilDensity.findByDepartSite", query = "SELECT q FROM QasoilDensity q WHERE q.departSite = :departSite"),
    @NamedQuery(name = "QasoilDensity.findByArriveLab", query = "SELECT q FROM QasoilDensity q WHERE q.arriveLab = :arriveLab"),
    @NamedQuery(name = "QasoilDensity.findByTotalHours", query = "SELECT q FROM QasoilDensity q WHERE q.totalHours = :totalHours"),
    @NamedQuery(name = "QasoilDensity.findByTechnicianHoursOvertime", query = "SELECT q FROM QasoilDensity q WHERE q.technicianHoursOvertime = :technicianHoursOvertime"),
    @NamedQuery(name = "QasoilDensity.findByMoistureTolReqPlus", query = "SELECT q FROM QasoilDensity q WHERE q.moistureTolReqPlus = :moistureTolReqPlus"),
    @NamedQuery(name = "QasoilDensity.findByMoistureTolReqMinus", query = "SELECT q FROM QasoilDensity q WHERE q.moistureTolReqMinus = :moistureTolReqMinus"),
    @NamedQuery(name = "QasoilDensity.findByTestReportNo", query = "SELECT q FROM QasoilDensity q WHERE q.testReportNo = :testReportNo"),
    @NamedQuery(name = "QasoilDensity.findByNumPoints", query = "SELECT q FROM QasoilDensity q WHERE q.numPoints = :numPoints"),
    @NamedQuery(name = "QasoilDensity.findBySoilSpecId", query = "SELECT q FROM QasoilDensity q WHERE q.soilSpecId = :soilSpecId"),
    @NamedQuery(name = "QasoilDensity.findByChartType", query = "SELECT q FROM QasoilDensity q WHERE q.chartType = :chartType"),
    @NamedQuery(name = "QasoilDensity.findByMileage", query = "SELECT q FROM QasoilDensity q WHERE q.mileage = :mileage"),
    @NamedQuery(name = "QasoilDensity.findByGaugeModelNo", query = "SELECT q FROM QasoilDensity q WHERE q.gaugeModelNo = :gaugeModelNo"),
    @NamedQuery(name = "QasoilDensity.findByGaugeNo", query = "SELECT q FROM QasoilDensity q WHERE q.gaugeNo = :gaugeNo"),
    @NamedQuery(name = "QasoilDensity.findByDateCalibration", query = "SELECT q FROM QasoilDensity q WHERE q.dateCalibration = :dateCalibration"),
    @NamedQuery(name = "QasoilDensity.findByIsPlus10Correction", query = "SELECT q FROM QasoilDensity q WHERE q.isPlus10Correction = :isPlus10Correction"),
    @NamedQuery(name = "QasoilDensity.findByTotalWeight", query = "SELECT q FROM QasoilDensity q WHERE q.totalWeight = :totalWeight"),
    @NamedQuery(name = "QasoilDensity.findByRetNo10", query = "SELECT q FROM QasoilDensity q WHERE q.retNo10 = :retNo10"),
    @NamedQuery(name = "QasoilDensity.findByPerRetNo10", query = "SELECT q FROM QasoilDensity q WHERE q.perRetNo10 = :perRetNo10"),
    @NamedQuery(name = "QasoilDensity.findByPlus10AbsorbPerc", query = "SELECT q FROM QasoilDensity q WHERE q.plus10AbsorbPerc = :plus10AbsorbPerc")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QASOIL_DENSITY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QasoilDensity.findAll", query = "SELECT q FROM QasoilDensity q"),
    @NamedQuery(name = "QasoilDensity.findById", query = "SELECT q FROM QasoilDensity q WHERE q.id = :id"),
    @NamedQuery(name = "QasoilDensity.findBySampletestId", query = "SELECT q FROM QasoilDensity q WHERE q.sampletestId = :sampletestId")})
public class QasoilDensity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QASOIL_DENSITY_ID_SEQ", sequenceName = "QASOIL_DENSITY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QASOIL_DENSITY_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "COMPSPEC")
    private String compspec;
    @Size(max = 50)
    @Column(name = "MOISTURE_TOL_REQ")
    private String moistureTolReq;
    @Size(max = 50)
    @Column(name = "PROCTOR_TYPE")
    private String proctorType;
    @Size(max = 50)
    @Column(name = "TESTINSTR")
    private String testinstr;
    @Size(max = 50)
    @Column(name = "SERIALNO")
    private String serialno;
    @Size(max = 50)
    @Column(name = "STDCTDENSITY")
    private String stdctdensity;
    @Size(max = 50)
    @Column(name = "STDCTMOISTURE")
    private String stdctmoisture;
    @Size(max = 50)
    @Column(name = "TESTTYPE")
    private String testtype;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 50)
    @Column(name = "SPEC_REF")
    private String specRef;
    @Size(max = 50)
    @Column(name = "PAGE")
    private String page;
    @Size(max = 50)
    @Column(name = "REPORT")
    private String report;
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 255)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 255)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 255)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 255)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 255)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 255)
    @Column(name = "FIELD6")
    private String field6;
    @Size(max = 255)
    @Column(name = "FIELD7")
    private String field7;
    @Size(max = 255)
    @Column(name = "FIELD8")
    private String field8;
    @Size(max = 255)
    @Column(name = "FIELD9")
    private String field9;
    @Size(max = 255)
    @Column(name = "FIELD10")
    private String field10;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 4000)
    @Column(name = "RPT_FILENAME")
    private String rptFilename;
    @Size(max = 4000)
    @Column(name = "COMP_EQUIPMENT")
    private String compEquipment;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "FOREMAN")
    private String foreman;
    @Size(max = 255)
    @Column(name = "CATEGORYNO")
    private String categoryno;
    @Size(max = 255)
    @Column(name = "RANDOMSHTNO")
    private String randomshtno;
    @Size(max = 255)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 255)
    @Column(name = "GEN_TESTLOC")
    private String genTestloc;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 255)
    @Column(name = "AVG_COMPACTION")
    private String avgCompaction;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 255)
    @Column(name = "CLASS")
    private String class1;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Size(max = 50)
    @Column(name = "PDA_REPORT_NO")
    private String pdaReportNo;
    @Column(name = "TESTPLAN_ID")
    private BigInteger testplanId;
    @Size(max = 50)
    @Column(name = "COMPSPEC_MAX")
    private String compspecMax;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 255)
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "SUPERINTENDENT_ID")
    private BigInteger superintendentId;
    @Column(name = "FOREMAN_ID")
    private BigInteger foremanId;
    @Size(max = 255)
    @Column(name = "BID_ITEM_NUMBER")
    private String bidItemNumber;
    @Size(max = 255)
    @Column(name = "DB_SECTION")
    private String dbSection;
    @Size(max = 50)
    @Column(name = "DEPART_LAB")
    private String departLab;
    @Size(max = 50)
    @Column(name = "ARRIVE_SITE")
    private String arriveSite;
    @Size(max = 50)
    @Column(name = "LUNCH_HOURS")
    private String lunchHours;
    @Size(max = 50)
    @Column(name = "LUNCH_MINS")
    private String lunchMins;
    @Size(max = 50)
    @Column(name = "DEPART_SITE")
    private String departSite;
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB")
    private String arriveLab;
    @Size(max = 50)
    @Column(name = "TOTAL_HOURS")
    private String totalHours;
    @Column(name = "TECHNICIAN_HOURS_OVERTIME")
    private BigInteger technicianHoursOvertime;
    @Size(max = 50)
    @Column(name = "MOISTURE_TOL_REQ_PLUS")
    private String moistureTolReqPlus;
    @Size(max = 50)
    @Column(name = "MOISTURE_TOL_REQ_MINUS")
    private String moistureTolReqMinus;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "NUM_POINTS")
    private BigInteger numPoints;
    @Column(name = "SOIL_SPEC_ID")
    private BigInteger soilSpecId;
    @Size(max = 25)
    @Column(name = "CHART_TYPE")
    private String chartType;
    @Size(max = 100)
    @Column(name = "MILEAGE")
    private String mileage;
    @Size(max = 50)
    @Column(name = "GAUGE_MODEL_NO")
    private String gaugeModelNo;
    @Size(max = 50)
    @Column(name = "GAUGE_NO")
    private String gaugeNo;
    @Size(max = 50)
    @Column(name = "DATE_CALIBRATION")
    private String dateCalibration;
    @Size(max = 50)
    @Column(name = "IS_PLUS_10_CORRECTION")
    private String isPlus10Correction;
    @Size(max = 50)
    @Column(name = "TOTAL_WEIGHT")
    private String totalWeight;
    @Size(max = 50)
    @Column(name = "RET_NO10")
    private String retNo10;
    @Size(max = 50)
    @Column(name = "PER_RET_NO10")
    private String perRetNo10;
    @Size(max = 50)
    @Column(name = "PLUS_10_ABSORB_PERC")
    private String plus10AbsorbPerc;

    public QasoilDensity() {
    }

    public QasoilDensity(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompspec() {
        return compspec;
    }

    public void setCompspec(String compspec) {
        this.compspec = compspec;
    }

    public String getMoistureTolReq() {
        return moistureTolReq;
    }

    public void setMoistureTolReq(String moistureTolReq) {
        this.moistureTolReq = moistureTolReq;
    }

    public String getProctorType() {
        return proctorType;
    }

    public void setProctorType(String proctorType) {
        this.proctorType = proctorType;
    }

    public String getTestinstr() {
        return testinstr;
    }

    public void setTestinstr(String testinstr) {
        this.testinstr = testinstr;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getStdctdensity() {
        return stdctdensity;
    }

    public void setStdctdensity(String stdctdensity) {
        this.stdctdensity = stdctdensity;
    }

    public String getStdctmoisture() {
        return stdctmoisture;
    }

    public void setStdctmoisture(String stdctmoisture) {
        this.stdctmoisture = stdctmoisture;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getSpecRef() {
        return specRef;
    }

    public void setSpecRef(String specRef) {
        this.specRef = specRef;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
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

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRptFilename() {
        return rptFilename;
    }

    public void setRptFilename(String rptFilename) {
        this.rptFilename = rptFilename;
    }

    public String getCompEquipment() {
        return compEquipment;
    }

    public void setCompEquipment(String compEquipment) {
        this.compEquipment = compEquipment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getForeman() {
        return foreman;
    }

    public void setForeman(String foreman) {
        this.foreman = foreman;
    }

    public String getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(String categoryno) {
        this.categoryno = categoryno;
    }

    public String getRandomshtno() {
        return randomshtno;
    }

    public void setRandomshtno(String randomshtno) {
        this.randomshtno = randomshtno;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getGenTestloc() {
        return genTestloc;
    }

    public void setGenTestloc(String genTestloc) {
        this.genTestloc = genTestloc;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getAvgCompaction() {
        return avgCompaction;
    }

    public void setAvgCompaction(String avgCompaction) {
        this.avgCompaction = avgCompaction;
    }

    public String getSplitno() {
        return splitno;
    }

    public void setSplitno(String splitno) {
        this.splitno = splitno;
    }

    public Character getSplitsample() {
        return splitsample;
    }

    public void setSplitsample(Character splitsample) {
        this.splitsample = splitsample;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getPdaReportNo() {
        return pdaReportNo;
    }

    public void setPdaReportNo(String pdaReportNo) {
        this.pdaReportNo = pdaReportNo;
    }

    public BigInteger getTestplanId() {
        return testplanId;
    }

    public void setTestplanId(BigInteger testplanId) {
        this.testplanId = testplanId;
    }

    public String getCompspecMax() {
        return compspecMax;
    }

    public void setCompspecMax(String compspecMax) {
        this.compspecMax = compspecMax;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigInteger getSuperintendentId() {
        return superintendentId;
    }

    public void setSuperintendentId(BigInteger superintendentId) {
        this.superintendentId = superintendentId;
    }

    public BigInteger getForemanId() {
        return foremanId;
    }

    public void setForemanId(BigInteger foremanId) {
        this.foremanId = foremanId;
    }

    public String getBidItemNumber() {
        return bidItemNumber;
    }

    public void setBidItemNumber(String bidItemNumber) {
        this.bidItemNumber = bidItemNumber;
    }

    public String getDbSection() {
        return dbSection;
    }

    public void setDbSection(String dbSection) {
        this.dbSection = dbSection;
    }

    public String getDepartLab() {
        return departLab;
    }

    public void setDepartLab(String departLab) {
        this.departLab = departLab;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    public void setArriveSite(String arriveSite) {
        this.arriveSite = arriveSite;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public String getLunchMins() {
        return lunchMins;
    }

    public void setLunchMins(String lunchMins) {
        this.lunchMins = lunchMins;
    }

    public String getDepartSite() {
        return departSite;
    }

    public void setDepartSite(String departSite) {
        this.departSite = departSite;
    }

    public String getArriveLab() {
        return arriveLab;
    }

    public void setArriveLab(String arriveLab) {
        this.arriveLab = arriveLab;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public BigInteger getTechnicianHoursOvertime() {
        return technicianHoursOvertime;
    }

    public void setTechnicianHoursOvertime(BigInteger technicianHoursOvertime) {
        this.technicianHoursOvertime = technicianHoursOvertime;
    }

    public String getMoistureTolReqPlus() {
        return moistureTolReqPlus;
    }

    public void setMoistureTolReqPlus(String moistureTolReqPlus) {
        this.moistureTolReqPlus = moistureTolReqPlus;
    }

    public String getMoistureTolReqMinus() {
        return moistureTolReqMinus;
    }

    public void setMoistureTolReqMinus(String moistureTolReqMinus) {
        this.moistureTolReqMinus = moistureTolReqMinus;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigInteger numPoints) {
        this.numPoints = numPoints;
    }

    public BigInteger getSoilSpecId() {
        return soilSpecId;
    }

    public void setSoilSpecId(BigInteger soilSpecId) {
        this.soilSpecId = soilSpecId;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getGaugeModelNo() {
        return gaugeModelNo;
    }

    public void setGaugeModelNo(String gaugeModelNo) {
        this.gaugeModelNo = gaugeModelNo;
    }

    public String getGaugeNo() {
        return gaugeNo;
    }

    public void setGaugeNo(String gaugeNo) {
        this.gaugeNo = gaugeNo;
    }

    public String getDateCalibration() {
        return dateCalibration;
    }

    public void setDateCalibration(String dateCalibration) {
        this.dateCalibration = dateCalibration;
    }

    public String getIsPlus10Correction() {
        return isPlus10Correction;
    }

    public void setIsPlus10Correction(String isPlus10Correction) {
        this.isPlus10Correction = isPlus10Correction;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getRetNo10() {
        return retNo10;
    }

    public void setRetNo10(String retNo10) {
        this.retNo10 = retNo10;
    }

    public String getPerRetNo10() {
        return perRetNo10;
    }

    public void setPerRetNo10(String perRetNo10) {
        this.perRetNo10 = perRetNo10;
    }

    public String getPlus10AbsorbPerc() {
        return plus10AbsorbPerc;
    }

    public void setPlus10AbsorbPerc(String plus10AbsorbPerc) {
        this.plus10AbsorbPerc = plus10AbsorbPerc;
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
        if (!(object instanceof QasoilDensity)) {
            return false;
        }
        QasoilDensity other = (QasoilDensity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QasoilDensity[ id=" + id + " ]";
    }

}
