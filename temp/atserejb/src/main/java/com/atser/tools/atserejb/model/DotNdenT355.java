package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author mfuentes
 */
@Entity
@Immutable
@Table(name = "DOT_NDEN_T355", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotNdenT355.findAll", query = "SELECT a FROM DotNdenT355 a")})
public class DotNdenT355 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigDecimal testId;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigDecimal labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigDecimal qaSampleId;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Column(name = "MIX_DESIGN_ID")
    private BigDecimal mixDesignId;
    @Size(max = 30)
    @Column(name = "MIX_DESIGN_NO")
    private String mixDesignNo;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "SAMPLETEST_ID")
    private BigDecimal sampletestId;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 20)
    @Column(name = "ASPHALTCEMENT")
    private String asphaltcement;
    @Size(max = 80)
    @Column(name = "ADDITIVE")
    private String additive;
    @Size(max = 557)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 327)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Column(name = "BIDITEM_ID")
    private BigDecimal biditemId;
    @Column(name = "SUBBIDITEM_ID")
    private BigInteger subbiditemId;
    @Column(name = "WBS_ID")
    private BigInteger wbsId;
    @Size(max = 200)
    @Column(name = "WBS_NO")
    private String wbsNo;
    @Size(max = 500)
    @Column(name = "WBS_DESCRIPT")
    private String wbsDescript;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Column(name = "BINDER_GRADE_ID")
    private BigInteger binderGradeId;
    @Size(max = 100)
    @Column(name = "MIX_DESIGNATION")
    private String mixDesignation;
    @Size(max = 100)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 15)
    @Column(name = "COMPSPEC_LO")
    private String compspecLo;
    @Size(max = 15)
    @Column(name = "COMPSPEC_HI")
    private String compspecHi;
    @Size(max = 50)
    @Column(name = "COMPSPEC")
    private String compspec;
    @Size(max = 50)
    @Column(name = "TESTINSTR")
    private String testinstr;
    @Size(max = 50)
    @Column(name = "SERIALNO")
    private String serialno;
    @Size(max = 15)
    @Column(name = "REF_COUNT")
    private String refCount;
    @Size(max = 50)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 15)
    @Column(name = "THEOMAX")
    private String theomax;
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
    @Column(name = "AMBIENTTEMP")
    private String ambienttemp;
    @Size(max = 50)
    @Column(name = "LAYERTHICK")
    private String layerthick;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 5)
    @Column(name = "ISRETEST")
    private String isretest;
    @Size(max = 255)
    @Column(name = "GENERAL_TESTLOC")
    private String generalTestloc;
    @Size(max = 4000)
    @Column(name = "RPT_FILENAME")
    private String rptFilename;
    @Size(max = 4000)
    @Column(name = "PLACE_LOC")
    private String placeLoc;
    @Size(max = 4000)
    @Column(name = "SOURCE_MATERIAL")
    private String sourceMaterial;
    @Size(max = 4000)
    @Column(name = "COMP_EQUIPMENT")
    private String compEquipment;
    @Size(max = 4000)
    @Column(name = "GRADE")
    private String grade;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "FOREMAN")
    private String foreman;
    @Size(max = 255)
    @Column(name = "PROBE_DEPTH")
    private String probeDepth;
    @Size(max = 50)
    @Column(name = "RANDOM_SHEET_NO")
    private String randomSheetNo;
    @Size(max = 4000)
    @Column(name = "SPECSECTION")
    private String specsection;
    @Size(max = 255)
    @Column(name = "CATEGORYNO")
    private String categoryno;
    @Size(max = 255)
    @Column(name = "MIX_DESIGNATION2")
    private String mixDesignation2;
    @Size(max = 255)
    @Column(name = "PASSDRUMV")
    private String passdrumv;
    @Size(max = 255)
    @Column(name = "PASSDRUMNV")
    private String passdrumnv;
    @Size(max = 255)
    @Column(name = "PASSPNEUTIRED")
    private String passpneutired;
    @Size(max = 255)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 255)
    @Column(name = "MATERIALTEMP")
    private String materialtemp;
    @Column(name = "DENSITY_TYPE")
    private BigDecimal densityType;
    @Size(max = 50)
    @Column(name = "DAILY_TONNAGE")
    private String dailyTonnage;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Size(max = 50)
    @Column(name = "PDA_REPORT_NO")
    private String pdaReportNo;
    @Column(name = "TESTPLAN_ID")
    private BigDecimal testplanId;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Column(name = "NUM_POINTS")
    private BigInteger numPoints;
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
    @Column(name = "CORR_FACTOR")
    private String corrFactor;
    @Size(max = 255)
    @Column(name = "TEST_DURATION")
    private String testDuration;
    @Size(max = 255)
    @Column(name = "FIELD_TEST_NO")
    private String fieldTestNo;
    @Size(max = 50)
    @Column(name = "COURSELIFT")
    private String courselift;
    @Size(max = 15)
    @Column(name = "DENSITY_CT")
    private String densityCt;
    @Size(max = 15)
    @Column(name = "DR_RATIO")
    private String drRatio;
    @Size(max = 15)
    @Column(name = "FIELD_SPECGRAV")
    private String fieldSpecgrav;
    @Size(max = 15)
    @Column(name = "CORRECTION_FACTOR")
    private String correctionFactor;
    @Size(max = 15)
    @Column(name = "ADJ_FIELDSG")
    private String adjFieldsg;
    @Size(max = 15)
    @Column(name = "PCT_RELCOMPACTION")
    private String pctRelcompaction;
    @Size(max = 15)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Column(name = "DEN_ISRETEST")
    private Character denIsretest;
    @Column(name = "RETEST_SAMPLETEST_ID")
    private BigDecimal retestSampletestId;
    @Size(max = 10)
    @Column(name = "RETEST_TEST_NO")
    private String retestTestNo;
    @Size(max = 255)
    @Column(name = "DEN_REMARKS")
    private String denRemarks;
    @Size(max = 50)
    @Column(name = "BULKDENSITY")
    private String bulkdensity;
    @Size(max = 50)
    @Column(name = "WETDENSITY")
    private String wetdensity;
    @Size(max = 50)
    @Column(name = "COMPACTION")
    private String compaction;
    @Size(max = 4000)
    @Column(name = "DENSITY_1")
    private String density1;
    @Size(max = 4000)
    @Column(name = "DENSITY_2")
    private String density2;
    @Size(max = 4000)
    @Column(name = "DENSITY_3")
    private String density3;
    @Size(max = 4000)
    @Column(name = "DENSITY_4")
    private String density4;
    @Size(max = 4000)
    @Column(name = "FIELD_TESTNO")
    private String fieldTestno;
    @Size(max = 4000)
    @Column(name = "REF_LINE")
    private String refLine;
    @Size(max = 4000)
    @Column(name = "BEG_STAT")
    private String begStat;
    @Size(max = 4000)
    @Column(name = "END_STAT")
    private String endStat;
    @Size(max = 4000)
    @Column(name = "RANDOM_1")
    private String random1;
    @Size(max = 4000)
    @Column(name = "RANDOM_2")
    private String random2;
    @Size(max = 4000)
    @Column(name = "TEST_STATION")
    private String testStation;
    @Size(max = 4000)
    @Column(name = "TEST_OFFSET")
    private String testOffset;
    @Column(name = "SUPERCEDED")
    private Character superceded;
    @Size(max = 4000)
    @Column(name = "BEG_STN")
    private String begStn;
    @Size(max = 50)
    @Column(name = "LOT_LENGTH")
    private String lotLength;
    @Size(max = 4000)
    @Column(name = "TEST_LOCATION")
    private String testLocation;
    @Size(max = 50)
    @Column(name = "LOT_WIDTH")
    private String lotWidth;
    @Size(max = 4000)
    @Column(name = "RETESTREMARKS")
    private String retestremarks;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 50)
    @Column(name = "HMA_THICKNESS")
    private String hmaThickness;
    @Size(max = 50)
    @Column(name = "SUBLOT")
    private String sublot;
    @Size(max = 50)
    @Column(name = "GAUGE_ROTATION")
    private String gaugeRotation;
    @Size(max = 50)
    @Column(name = "WET_DENSITY1")
    private String wetDensity1;
    @Size(max = 50)
    @Column(name = "WET_DENSITY2")
    private String wetDensity2;
    @Size(max = 50)
    @Column(name = "DIFF_READING")
    private String diffReading;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;

    public DotNdenT355() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getTestId() {
        return testId;
    }

    public void setTestId(BigDecimal testId) {
        this.testId = testId;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getLabId() {
        return labId;
    }

    public void setLabId(BigDecimal labId) {
        this.labId = labId;
    }

    public BigDecimal getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(BigDecimal qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public BigDecimal getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigDecimal mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getMixDesignNo() {
        return mixDesignNo;
    }

    public void setMixDesignNo(String mixDesignNo) {
        this.mixDesignNo = mixDesignNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public BigDecimal getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigDecimal sampletestId) {
        this.sampletestId = sampletestId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAsphaltcement() {
        return asphaltcement;
    }

    public void setAsphaltcement(String asphaltcement) {
        this.asphaltcement = asphaltcement;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public BigDecimal getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigDecimal biditemId) {
        this.biditemId = biditemId;
    }

    public BigInteger getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(BigInteger subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public BigInteger getWbsId() {
        return wbsId;
    }

    public void setWbsId(BigInteger wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsNo() {
        return wbsNo;
    }

    public void setWbsNo(String wbsNo) {
        this.wbsNo = wbsNo;
    }

    public String getWbsDescript() {
        return wbsDescript;
    }

    public void setWbsDescript(String wbsDescript) {
        this.wbsDescript = wbsDescript;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public void setBiditemDescript(String biditemDescript) {
        this.biditemDescript = biditemDescript;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public void setSubbiditemDescript(String subbiditemDescript) {
        this.subbiditemDescript = subbiditemDescript;
    }

    public BigInteger getBinderGradeId() {
        return binderGradeId;
    }

    public void setBinderGradeId(BigInteger binderGradeId) {
        this.binderGradeId = binderGradeId;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompspecLo() {
        return compspecLo;
    }

    public void setCompspecLo(String compspecLo) {
        this.compspecLo = compspecLo;
    }

    public String getCompspecHi() {
        return compspecHi;
    }

    public void setCompspecHi(String compspecHi) {
        this.compspecHi = compspecHi;
    }

    public String getCompspec() {
        return compspec;
    }

    public void setCompspec(String compspec) {
        this.compspec = compspec;
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

    public String getRefCount() {
        return refCount;
    }

    public void setRefCount(String refCount) {
        this.refCount = refCount;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getTheomax() {
        return theomax;
    }

    public void setTheomax(String theomax) {
        this.theomax = theomax;
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

    public String getAmbienttemp() {
        return ambienttemp;
    }

    public void setAmbienttemp(String ambienttemp) {
        this.ambienttemp = ambienttemp;
    }

    public String getLayerthick() {
        return layerthick;
    }

    public void setLayerthick(String layerthick) {
        this.layerthick = layerthick;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getIsretest() {
        return isretest;
    }

    public void setIsretest(String isretest) {
        this.isretest = isretest;
    }

    public String getGeneralTestloc() {
        return generalTestloc;
    }

    public void setGeneralTestloc(String generalTestloc) {
        this.generalTestloc = generalTestloc;
    }

    public String getRptFilename() {
        return rptFilename;
    }

    public void setRptFilename(String rptFilename) {
        this.rptFilename = rptFilename;
    }

    public String getPlaceLoc() {
        return placeLoc;
    }

    public void setPlaceLoc(String placeLoc) {
        this.placeLoc = placeLoc;
    }

    public String getSourceMaterial() {
        return sourceMaterial;
    }

    public void setSourceMaterial(String sourceMaterial) {
        this.sourceMaterial = sourceMaterial;
    }

    public String getCompEquipment() {
        return compEquipment;
    }

    public void setCompEquipment(String compEquipment) {
        this.compEquipment = compEquipment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getProbeDepth() {
        return probeDepth;
    }

    public void setProbeDepth(String probeDepth) {
        this.probeDepth = probeDepth;
    }

    public String getRandomSheetNo() {
        return randomSheetNo;
    }

    public void setRandomSheetNo(String randomSheetNo) {
        this.randomSheetNo = randomSheetNo;
    }

    public String getSpecsection() {
        return specsection;
    }

    public void setSpecsection(String specsection) {
        this.specsection = specsection;
    }

    public String getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(String categoryno) {
        this.categoryno = categoryno;
    }

    public String getMixDesignation2() {
        return mixDesignation2;
    }

    public void setMixDesignation2(String mixDesignation2) {
        this.mixDesignation2 = mixDesignation2;
    }

    public String getPassdrumv() {
        return passdrumv;
    }

    public void setPassdrumv(String passdrumv) {
        this.passdrumv = passdrumv;
    }

    public String getPassdrumnv() {
        return passdrumnv;
    }

    public void setPassdrumnv(String passdrumnv) {
        this.passdrumnv = passdrumnv;
    }

    public String getPasspneutired() {
        return passpneutired;
    }

    public void setPasspneutired(String passpneutired) {
        this.passpneutired = passpneutired;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getMaterialtemp() {
        return materialtemp;
    }

    public void setMaterialtemp(String materialtemp) {
        this.materialtemp = materialtemp;
    }

    public BigDecimal getDensityType() {
        return densityType;
    }

    public void setDensityType(BigDecimal densityType) {
        this.densityType = densityType;
    }

    public String getDailyTonnage() {
        return dailyTonnage;
    }

    public void setDailyTonnage(String dailyTonnage) {
        this.dailyTonnage = dailyTonnage;
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

    public BigDecimal getTestplanId() {
        return testplanId;
    }

    public void setTestplanId(BigDecimal testplanId) {
        this.testplanId = testplanId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigInteger getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigInteger numPoints) {
        this.numPoints = numPoints;
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

    public String getCorrFactor() {
        return corrFactor;
    }

    public void setCorrFactor(String corrFactor) {
        this.corrFactor = corrFactor;
    }

    public String getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(String testDuration) {
        this.testDuration = testDuration;
    }

    public String getFieldTestNo() {
        return fieldTestNo;
    }

    public void setFieldTestNo(String fieldTestNo) {
        this.fieldTestNo = fieldTestNo;
    }

    public String getCourselift() {
        return courselift;
    }

    public void setCourselift(String courselift) {
        this.courselift = courselift;
    }

    public String getDensityCt() {
        return densityCt;
    }

    public void setDensityCt(String densityCt) {
        this.densityCt = densityCt;
    }

    public String getDrRatio() {
        return drRatio;
    }

    public void setDrRatio(String drRatio) {
        this.drRatio = drRatio;
    }

    public String getFieldSpecgrav() {
        return fieldSpecgrav;
    }

    public void setFieldSpecgrav(String fieldSpecgrav) {
        this.fieldSpecgrav = fieldSpecgrav;
    }

    public String getCorrectionFactor() {
        return correctionFactor;
    }

    public void setCorrectionFactor(String correctionFactor) {
        this.correctionFactor = correctionFactor;
    }

    public String getAdjFieldsg() {
        return adjFieldsg;
    }

    public void setAdjFieldsg(String adjFieldsg) {
        this.adjFieldsg = adjFieldsg;
    }

    public String getPctRelcompaction() {
        return pctRelcompaction;
    }

    public void setPctRelcompaction(String pctRelcompaction) {
        this.pctRelcompaction = pctRelcompaction;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public Character getDenIsretest() {
        return denIsretest;
    }

    public void setDenIsretest(Character denIsretest) {
        this.denIsretest = denIsretest;
    }

    public BigDecimal getRetestSampletestId() {
        return retestSampletestId;
    }

    public void setRetestSampletestId(BigDecimal retestSampletestId) {
        this.retestSampletestId = retestSampletestId;
    }

    public String getRetestTestNo() {
        return retestTestNo;
    }

    public void setRetestTestNo(String retestTestNo) {
        this.retestTestNo = retestTestNo;
    }

    public String getDenRemarks() {
        return denRemarks;
    }

    public void setDenRemarks(String denRemarks) {
        this.denRemarks = denRemarks;
    }

    public String getBulkdensity() {
        return bulkdensity;
    }

    public void setBulkdensity(String bulkdensity) {
        this.bulkdensity = bulkdensity;
    }

    public String getWetdensity() {
        return wetdensity;
    }

    public void setWetdensity(String wetdensity) {
        this.wetdensity = wetdensity;
    }

    public String getCompaction() {
        return compaction;
    }

    public void setCompaction(String compaction) {
        this.compaction = compaction;
    }

    public String getDensity1() {
        return density1;
    }

    public void setDensity1(String density1) {
        this.density1 = density1;
    }

    public String getDensity2() {
        return density2;
    }

    public void setDensity2(String density2) {
        this.density2 = density2;
    }

    public String getDensity3() {
        return density3;
    }

    public void setDensity3(String density3) {
        this.density3 = density3;
    }

    public String getDensity4() {
        return density4;
    }

    public void setDensity4(String density4) {
        this.density4 = density4;
    }

    public String getFieldTestno() {
        return fieldTestno;
    }

    public void setFieldTestno(String fieldTestno) {
        this.fieldTestno = fieldTestno;
    }

    public String getRefLine() {
        return refLine;
    }

    public void setRefLine(String refLine) {
        this.refLine = refLine;
    }

    public String getBegStat() {
        return begStat;
    }

    public void setBegStat(String begStat) {
        this.begStat = begStat;
    }

    public String getEndStat() {
        return endStat;
    }

    public void setEndStat(String endStat) {
        this.endStat = endStat;
    }

    public String getRandom1() {
        return random1;
    }

    public void setRandom1(String random1) {
        this.random1 = random1;
    }

    public String getRandom2() {
        return random2;
    }

    public void setRandom2(String random2) {
        this.random2 = random2;
    }

    public String getTestStation() {
        return testStation;
    }

    public void setTestStation(String testStation) {
        this.testStation = testStation;
    }

    public String getTestOffset() {
        return testOffset;
    }

    public void setTestOffset(String testOffset) {
        this.testOffset = testOffset;
    }

    public Character getSuperceded() {
        return superceded;
    }

    public void setSuperceded(Character superceded) {
        this.superceded = superceded;
    }

    public String getBegStn() {
        return begStn;
    }

    public void setBegStn(String begStn) {
        this.begStn = begStn;
    }

    public String getLotLength() {
        return lotLength;
    }

    public void setLotLength(String lotLength) {
        this.lotLength = lotLength;
    }

    public String getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
    }

    public String getLotWidth() {
        return lotWidth;
    }

    public void setLotWidth(String lotWidth) {
        this.lotWidth = lotWidth;
    }

    public String getRetestremarks() {
        return retestremarks;
    }

    public void setRetestremarks(String retestremarks) {
        this.retestremarks = retestremarks;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHmaThickness() {
        return hmaThickness;
    }

    public void setHmaThickness(String hmaThickness) {
        this.hmaThickness = hmaThickness;
    }

    public String getSublot() {
        return sublot;
    }

    public void setSublot(String sublot) {
        this.sublot = sublot;
    }

    public String getGaugeRotation() {
        return gaugeRotation;
    }

    public void setGaugeRotation(String gaugeRotation) {
        this.gaugeRotation = gaugeRotation;
    }

    public String getWetDensity1() {
        return wetDensity1;
    }

    public void setWetDensity1(String wetDensity1) {
        this.wetDensity1 = wetDensity1;
    }

    public String getWetDensity2() {
        return wetDensity2;
    }

    public void setWetDensity2(String wetDensity2) {
        this.wetDensity2 = wetDensity2;
    }

    public String getDiffReading() {
        return diffReading;
    }

    public void setDiffReading(String diffReading) {
        this.diffReading = diffReading;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
