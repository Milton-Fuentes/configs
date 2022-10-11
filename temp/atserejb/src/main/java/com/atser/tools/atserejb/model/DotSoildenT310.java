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
@Table(name = "dot_soilden_t310", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSoildenT310.findAll", query = "SELECT a FROM DotSoildenT310 a")})
public class DotSoildenT310 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "MOISTURECONTENT")
    private String moisturecontent;
    @Size(max = 50)
    @Column(name = "COMPACTION")
    private String compaction;
    @Size(max = 10)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "STDCTMOISTURE")
    private String stdctmoisture;
    @Size(max = 255)
    @Column(name = "GEN_TESTLOC")
    private String genTestloc;
    @Size(max = 255)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 50)
    @Column(name = "COMPSPEC")
    private String compspec;
    @Size(max = 50)
    @Column(name = "COMPSPEC_MAX")
    private String compspecMax;
    @Size(max = 255)
    @Column(name = "TEST_DURATION")
    private String testDuration;
    @Size(max = 255)
    @Column(name = "TARGET_LIFT_THICKNESS")
    private String targetLiftThickness;
    @Size(max = 50)
    @Column(name = "TESTTYPE")
    private String testtype;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "FIELD_TEST_NO")
    private String fieldTestNo;
    @Size(max = 255)
    @Column(name = "TEST_LOCATION")
    private String testLocation;
    @Size(max = 4000)
    @Column(name = "TEST_STATION")
    private String testStation;
    @Size(max = 4000)
    @Column(name = "TEST_OFFSET")
    private String testOffset;
    @Size(max = 100)
    @Column(name = "ELEVDEPTH")
    private String elevdepth;
    @Size(max = 50)
    @Column(name = "PROCTOR_NO")
    private String proctorNo;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSITY")
    private String maxdrydensity;
    @Size(max = 50)
    @Column(name = "OPTMOISTURE")
    private String optmoisture;
    @Size(max = 50)
    @Column(name = "WETDENSITY")
    private String wetdensity;
    @Size(max = 50)
    @Column(name = "DRYDENSITY")
    private String drydensity;
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
    @Size(max = 352)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 122)
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
    @Column(name = "TESTINSTR")
    private String testinstr;
    @Size(max = 50)
    @Column(name = "GAUGE_MODEL_NO")
    private String gaugeModelNo;
    @Size(max = 50)
    @Column(name = "SERIALNO")
    private String serialno;
    @Size(max = 50)
    @Column(name = "GAUGE_NO")
    private String gaugeNo;
    @Size(max = 50)
    @Column(name = "DATE_CALIBRATION")
    private String dateCalibration;
    @Size(max = 50)
    @Column(name = "STDCTDENSITY")
    private String stdctdensity;

    public DotSoildenT310() {
    }

    public String getMoisturecontent() {
        return moisturecontent;
    }

    public void setMoisturecontent(String moisturecontent) {
        this.moisturecontent = moisturecontent;
    }

    public String getCompaction() {
        return compaction;
    }

    public void setCompaction(String compaction) {
        this.compaction = compaction;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
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

    public String getStdctmoisture() {
        return stdctmoisture;
    }

    public void setStdctmoisture(String stdctmoisture) {
        this.stdctmoisture = stdctmoisture;
    }

    public String getGenTestloc() {
        return genTestloc;
    }

    public void setGenTestloc(String genTestloc) {
        this.genTestloc = genTestloc;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getCompspec() {
        return compspec;
    }

    public void setCompspec(String compspec) {
        this.compspec = compspec;
    }

    public String getCompspecMax() {
        return compspecMax;
    }

    public void setCompspecMax(String compspecMax) {
        this.compspecMax = compspecMax;
    }

    public String getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(String testDuration) {
        this.testDuration = testDuration;
    }

    public String getTargetLiftThickness() {
        return targetLiftThickness;
    }

    public void setTargetLiftThickness(String targetLiftThickness) {
        this.targetLiftThickness = targetLiftThickness;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFieldTestNo() {
        return fieldTestNo;
    }

    public void setFieldTestNo(String fieldTestNo) {
        this.fieldTestNo = fieldTestNo;
    }

    public String getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
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

    public String getElevdepth() {
        return elevdepth;
    }

    public void setElevdepth(String elevdepth) {
        this.elevdepth = elevdepth;
    }

    public String getProctorNo() {
        return proctorNo;
    }

    public void setProctorNo(String proctorNo) {
        this.proctorNo = proctorNo;
    }

    public String getMaxdrydensity() {
        return maxdrydensity;
    }

    public void setMaxdrydensity(String maxdrydensity) {
        this.maxdrydensity = maxdrydensity;
    }

    public String getOptmoisture() {
        return optmoisture;
    }

    public void setOptmoisture(String optmoisture) {
        this.optmoisture = optmoisture;
    }

    public String getWetdensity() {
        return wetdensity;
    }

    public void setWetdensity(String wetdensity) {
        this.wetdensity = wetdensity;
    }

    public String getDrydensity() {
        return drydensity;
    }

    public void setDrydensity(String drydensity) {
        this.drydensity = drydensity;
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

    public String getTestinstr() {
        return testinstr;
    }

    public void setTestinstr(String testinstr) {
        this.testinstr = testinstr;
    }

    public String getGaugeModelNo() {
        return gaugeModelNo;
    }

    public void setGaugeModelNo(String gaugeModelNo) {
        this.gaugeModelNo = gaugeModelNo;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
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

    public String getStdctdensity() {
        return stdctdensity;
    }

    public void setStdctdensity(String stdctdensity) {
        this.stdctdensity = stdctdensity;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
