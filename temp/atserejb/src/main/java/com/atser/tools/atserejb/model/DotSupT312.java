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
@Table(name = "DOT_SUP_T312", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSupT312.findAll", query = "SELECT a FROM DotSupT312 a")})
public class DotSupT312 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "CORR_RELATIVE_DENSITY2")
    private String corrRelativeDensity2;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO2")
    private String specimenNo2;
    @Size(max = 50)
    @Column(name = "HEIGHT_DESIGN")
    private String heightDesign;
    @Size(max = 50)
    @Column(name = "HEIGHT_MAX")
    private String heightMax;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 374)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 50)
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
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "THEO_MAX_SPEC_GRAV")
    private String theoMaxSpecGrav;
    @Size(max = 50)
    @Column(name = "BULK_SPEC_GRAV")
    private String bulkSpecGrav;
    @Size(max = 50)
    @Column(name = "HEIGHT_EXTRUDED_SPECIMEN")
    private String heightExtrudedSpecimen;
    @Size(max = 50)
    @Column(name = "AVG_UNCORR_RELATIVE_DENSITY")
    private String avgUncorrRelativeDensity;
    @Size(max = 50)
    @Column(name = "AVG_CORR_RELATIVE_DENSITY")
    private String avgCorrRelativeDensity;
    @Size(max = 50)
    @Column(name = "NO")
    private String no;
    @Size(max = 50)
    @Column(name = "TEMP_COMP")
    private String tempComp;
    @Size(max = 50)
    @Column(name = "NO_GYRATION")
    private String noGyration;
    @Size(max = 50)
    @Column(name = "HEIGHT")
    private String height;
    @Size(max = 50)
    @Column(name = "GYRATION_HEIGHT")
    private String gyrationHeight;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "SPECIMEN_DIAMETER")
    private String specimenDiameter;
    @Size(max = 50)
    @Column(name = "MASS_SPECIMEN")
    private String massSpecimen;
    @Size(max = 50)
    @Column(name = "MAXIMUM_SG")
    private String maximumSg;
    @Size(max = 50)
    @Column(name = "VOLUME_SPECIMEN")
    private String volumeSpecimen;
    @Size(max = 50)
    @Column(name = "UNCORR_RELATIVE_DENSITY")
    private String uncorrRelativeDensity;
    @Size(max = 50)
    @Column(name = "BULK_SPECGRAV")
    private String bulkSpecgrav;
    @Size(max = 50)
    @Column(name = "CORR_RELATIVE_DENSITY")
    private String corrRelativeDensity;
    @Size(max = 50)
    @Column(name = "NO_GYRATION2")
    private String noGyration2;
    @Size(max = 255)
    @Column(name = "HEIGHT2")
    private String height2;
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

    public DotSupT312() {
    }

    public String getCorrRelativeDensity2() {
        return corrRelativeDensity2;
    }

    public void setCorrRelativeDensity2(String corrRelativeDensity2) {
        this.corrRelativeDensity2 = corrRelativeDensity2;
    }

    public String getSpecimenNo2() {
        return specimenNo2;
    }

    public void setSpecimenNo2(String specimenNo2) {
        this.specimenNo2 = specimenNo2;
    }

    public String getHeightDesign() {
        return heightDesign;
    }

    public void setHeightDesign(String heightDesign) {
        this.heightDesign = heightDesign;
    }

    public String getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(String heightMax) {
        this.heightMax = heightMax;
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

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getTheoMaxSpecGrav() {
        return theoMaxSpecGrav;
    }

    public void setTheoMaxSpecGrav(String theoMaxSpecGrav) {
        this.theoMaxSpecGrav = theoMaxSpecGrav;
    }

    public String getBulkSpecGrav() {
        return bulkSpecGrav;
    }

    public void setBulkSpecGrav(String bulkSpecGrav) {
        this.bulkSpecGrav = bulkSpecGrav;
    }

    public String getHeightExtrudedSpecimen() {
        return heightExtrudedSpecimen;
    }

    public void setHeightExtrudedSpecimen(String heightExtrudedSpecimen) {
        this.heightExtrudedSpecimen = heightExtrudedSpecimen;
    }

    public String getAvgUncorrRelativeDensity() {
        return avgUncorrRelativeDensity;
    }

    public void setAvgUncorrRelativeDensity(String avgUncorrRelativeDensity) {
        this.avgUncorrRelativeDensity = avgUncorrRelativeDensity;
    }

    public String getAvgCorrRelativeDensity() {
        return avgCorrRelativeDensity;
    }

    public void setAvgCorrRelativeDensity(String avgCorrRelativeDensity) {
        this.avgCorrRelativeDensity = avgCorrRelativeDensity;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTempComp() {
        return tempComp;
    }

    public void setTempComp(String tempComp) {
        this.tempComp = tempComp;
    }

    public String getNoGyration() {
        return noGyration;
    }

    public void setNoGyration(String noGyration) {
        this.noGyration = noGyration;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGyrationHeight() {
        return gyrationHeight;
    }

    public void setGyrationHeight(String gyrationHeight) {
        this.gyrationHeight = gyrationHeight;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getSpecimenDiameter() {
        return specimenDiameter;
    }

    public void setSpecimenDiameter(String specimenDiameter) {
        this.specimenDiameter = specimenDiameter;
    }

    public String getMassSpecimen() {
        return massSpecimen;
    }

    public void setMassSpecimen(String massSpecimen) {
        this.massSpecimen = massSpecimen;
    }

    public String getMaximumSg() {
        return maximumSg;
    }

    public void setMaximumSg(String maximumSg) {
        this.maximumSg = maximumSg;
    }

    public String getVolumeSpecimen() {
        return volumeSpecimen;
    }

    public void setVolumeSpecimen(String volumeSpecimen) {
        this.volumeSpecimen = volumeSpecimen;
    }

    public String getUncorrRelativeDensity() {
        return uncorrRelativeDensity;
    }

    public void setUncorrRelativeDensity(String uncorrRelativeDensity) {
        this.uncorrRelativeDensity = uncorrRelativeDensity;
    }

    public String getBulkSpecgrav() {
        return bulkSpecgrav;
    }

    public void setBulkSpecgrav(String bulkSpecgrav) {
        this.bulkSpecgrav = bulkSpecgrav;
    }

    public String getCorrRelativeDensity() {
        return corrRelativeDensity;
    }

    public void setCorrRelativeDensity(String corrRelativeDensity) {
        this.corrRelativeDensity = corrRelativeDensity;
    }

    public String getNoGyration2() {
        return noGyration2;
    }

    public void setNoGyration2(String noGyration2) {
        this.noGyration2 = noGyration2;
    }

    public String getHeight2() {
        return height2;
    }

    public void setHeight2(String height2) {
        this.height2 = height2;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
