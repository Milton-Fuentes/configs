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
@Table(name = "DOT_GMM_T209", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotGmmT209.findAll", query = "SELECT a FROM DotGmmT209 a")})
public class DotGmmT209 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
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
    @Size(max = 50)
    @Column(name = "UNIT_WEIGHT")
    private String unitWeight;
    @Size(max = 20)
    @Column(name = "TRIAL_NO")
    private String trialNo;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 10)
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Size(max = 255)
    @Column(name = "SURFACE_DRY_WT")
    private String surfaceDryWt;
    @Size(max = 255)
    @Column(name = "VOLUME")
    private String volume;
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
    @Size(max = 214)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 92)
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
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "MIX_DESIGNATION")
    private String mixDesignation;
    @Size(max = 50)
    @Column(name = "TEST_TEMPERATURE")
    private String testTemperature;
    @Size(max = 50)
    @Column(name = "AVEMAXSPECGRAV")
    private String avemaxspecgrav;
    @Size(max = 255)
    @Column(name = "SAMPLELOCATION")
    private String samplelocation;
    @Size(max = 50)
    @Column(name = "BULKSPECGRAV")
    private String bulkspecgrav;
    @Size(max = 50)
    @Column(name = "BULKSSD")
    private String bulkssd;
    @Size(max = 50)
    @Column(name = "APPSPECGRAV")
    private String appspecgrav;
    @Size(max = 50)
    @Column(name = "REPORT")
    private String report;
    @Size(max = 100)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 255)
    @Column(name = "GENERAL_TESTLOC")
    private String generalTestloc;
    @Size(max = 4000)
    @Column(name = "GRADE")
    private String grade;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "SUBLOT_NO")
    private BigDecimal sublotNo;
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
    @Column(name = "AVE_UNIT_WEIGHT")
    private String aveUnitWeight;
    @Column(name = "LOT_NO")
    private Character lotNo;
    @Size(max = 50)
    @Column(name = "WTSAMPLE_AIR")
    private String wtsampleAir;
    @Size(max = 50)
    @Column(name = "WTCONTAINER_WATER")
    private String wtcontainerWater;
    @Size(max = 50)
    @Column(name = "WTCONTAINER_SAMPLE_WATER")
    private String wtcontainerSampleWater;
    @Size(max = 50)
    @Column(name = "TEST_TEMP")
    private String testTemp;
    @Size(max = 50)
    @Column(name = "RFACTOR")
    private String rfactor;
    @Size(max = 50)
    @Column(name = "CORRFACTORTHERMALEXP")
    private String corrfactorthermalexp;
    @Size(max = 50)
    @Column(name = "MAXSPECGRAV")
    private String maxspecgrav;
    @Size(max = 50)
    @Column(name = "AC")
    private String ac;
    @Size(max = 50)
    @Column(name = "SPECGRAV")
    private String specgrav;
    @Size(max = 50)
    @Column(name = "PAVINGDRY")
    private String pavingdry;
    @Size(max = 50)
    @Column(name = "PAVINGCALIB")
    private String pavingcalib;
    @Size(max = 50)
    @Column(name = "PAVINGPYCNOM")
    private String pavingpycnom;
    @Size(max = 50)
    @Column(name = "PAVINGSURFACE")
    private String pavingsurface;
    @Size(max = 50)
    @Column(name = "RESULTGT")
    private String resultgt;
    @Size(max = 50)
    @Column(name = "RESULTGTC")
    private String resultgtc;
    @Size(max = 50)
    @Column(name = "BOWLNO")
    private String bowlno;
    @Size(max = 50)
    @Column(name = "BOWLAIR")
    private String bowlair;
    @Size(max = 50)
    @Column(name = "BOWLWATER")
    private String bowlwater;
    @Size(max = 50)
    @Column(name = "SAMPLEBOWLAIR")
    private String samplebowlair;
    @Size(max = 50)
    @Column(name = "SAMPLEBOWLWATER")
    private String samplebowlwater;
    @Size(max = 50)
    @Column(name = "DRYSAMPLE")
    private String drysample;
    @Size(max = 50)
    @Column(name = "SAMPLEAIR")
    private String sampleair;
    @Size(max = 50)
    @Column(name = "SAMPLEWATER")
    private String samplewater;
    @Size(max = 50)
    @Column(name = "GMM")
    private String gmm;
    @Size(max = 50)
    @Column(name = "GS")
    private String gs;
    @Size(max = 50)
    @Column(name = "RAWGSE")
    private String rawgse;

    public DotGmmT209() {
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
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

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getTrialNo() {
        return trialNo;
    }

    public void setTrialNo(String trialNo) {
        this.trialNo = trialNo;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getSurfaceDryWt() {
        return surfaceDryWt;
    }

    public void setSurfaceDryWt(String surfaceDryWt) {
        this.surfaceDryWt = surfaceDryWt;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public String getTestTemperature() {
        return testTemperature;
    }

    public void setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
    }

    public String getAvemaxspecgrav() {
        return avemaxspecgrav;
    }

    public void setAvemaxspecgrav(String avemaxspecgrav) {
        this.avemaxspecgrav = avemaxspecgrav;
    }

    public String getSamplelocation() {
        return samplelocation;
    }

    public void setSamplelocation(String samplelocation) {
        this.samplelocation = samplelocation;
    }

    public String getBulkspecgrav() {
        return bulkspecgrav;
    }

    public void setBulkspecgrav(String bulkspecgrav) {
        this.bulkspecgrav = bulkspecgrav;
    }

    public String getBulkssd() {
        return bulkssd;
    }

    public void setBulkssd(String bulkssd) {
        this.bulkssd = bulkssd;
    }

    public String getAppspecgrav() {
        return appspecgrav;
    }

    public void setAppspecgrav(String appspecgrav) {
        this.appspecgrav = appspecgrav;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getGeneralTestloc() {
        return generalTestloc;
    }

    public void setGeneralTestloc(String generalTestloc) {
        this.generalTestloc = generalTestloc;
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

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigDecimal getSublotNo() {
        return sublotNo;
    }

    public void setSublotNo(BigDecimal sublotNo) {
        this.sublotNo = sublotNo;
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

    public String getAveUnitWeight() {
        return aveUnitWeight;
    }

    public void setAveUnitWeight(String aveUnitWeight) {
        this.aveUnitWeight = aveUnitWeight;
    }

    public Character getLotNo() {
        return lotNo;
    }

    public void setLotNo(Character lotNo) {
        this.lotNo = lotNo;
    }

    public String getWtsampleAir() {
        return wtsampleAir;
    }

    public void setWtsampleAir(String wtsampleAir) {
        this.wtsampleAir = wtsampleAir;
    }

    public String getWtcontainerWater() {
        return wtcontainerWater;
    }

    public void setWtcontainerWater(String wtcontainerWater) {
        this.wtcontainerWater = wtcontainerWater;
    }

    public String getWtcontainerSampleWater() {
        return wtcontainerSampleWater;
    }

    public void setWtcontainerSampleWater(String wtcontainerSampleWater) {
        this.wtcontainerSampleWater = wtcontainerSampleWater;
    }

    public String getTestTemp() {
        return testTemp;
    }

    public void setTestTemp(String testTemp) {
        this.testTemp = testTemp;
    }

    public String getRfactor() {
        return rfactor;
    }

    public void setRfactor(String rfactor) {
        this.rfactor = rfactor;
    }

    public String getCorrfactorthermalexp() {
        return corrfactorthermalexp;
    }

    public void setCorrfactorthermalexp(String corrfactorthermalexp) {
        this.corrfactorthermalexp = corrfactorthermalexp;
    }

    public String getMaxspecgrav() {
        return maxspecgrav;
    }

    public void setMaxspecgrav(String maxspecgrav) {
        this.maxspecgrav = maxspecgrav;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getSpecgrav() {
        return specgrav;
    }

    public void setSpecgrav(String specgrav) {
        this.specgrav = specgrav;
    }

    public String getPavingdry() {
        return pavingdry;
    }

    public void setPavingdry(String pavingdry) {
        this.pavingdry = pavingdry;
    }

    public String getPavingcalib() {
        return pavingcalib;
    }

    public void setPavingcalib(String pavingcalib) {
        this.pavingcalib = pavingcalib;
    }

    public String getPavingpycnom() {
        return pavingpycnom;
    }

    public void setPavingpycnom(String pavingpycnom) {
        this.pavingpycnom = pavingpycnom;
    }

    public String getPavingsurface() {
        return pavingsurface;
    }

    public void setPavingsurface(String pavingsurface) {
        this.pavingsurface = pavingsurface;
    }

    public String getResultgt() {
        return resultgt;
    }

    public void setResultgt(String resultgt) {
        this.resultgt = resultgt;
    }

    public String getResultgtc() {
        return resultgtc;
    }

    public void setResultgtc(String resultgtc) {
        this.resultgtc = resultgtc;
    }

    public String getBowlno() {
        return bowlno;
    }

    public void setBowlno(String bowlno) {
        this.bowlno = bowlno;
    }

    public String getBowlair() {
        return bowlair;
    }

    public void setBowlair(String bowlair) {
        this.bowlair = bowlair;
    }

    public String getBowlwater() {
        return bowlwater;
    }

    public void setBowlwater(String bowlwater) {
        this.bowlwater = bowlwater;
    }

    public String getSamplebowlair() {
        return samplebowlair;
    }

    public void setSamplebowlair(String samplebowlair) {
        this.samplebowlair = samplebowlair;
    }

    public String getSamplebowlwater() {
        return samplebowlwater;
    }

    public void setSamplebowlwater(String samplebowlwater) {
        this.samplebowlwater = samplebowlwater;
    }

    public String getDrysample() {
        return drysample;
    }

    public void setDrysample(String drysample) {
        this.drysample = drysample;
    }

    public String getSampleair() {
        return sampleair;
    }

    public void setSampleair(String sampleair) {
        this.sampleair = sampleair;
    }

    public String getSamplewater() {
        return samplewater;
    }

    public void setSamplewater(String samplewater) {
        this.samplewater = samplewater;
    }

    public String getGmm() {
        return gmm;
    }

    public void setGmm(String gmm) {
        this.gmm = gmm;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getRawgse() {
        return rawgse;
    }

    public void setRawgse(String rawgse) {
        this.rawgse = rawgse;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
