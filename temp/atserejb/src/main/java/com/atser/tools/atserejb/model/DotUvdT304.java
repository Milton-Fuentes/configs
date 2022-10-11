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
@Table(name = "dot_uvd_t304", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotUvdT304.findAll", query = "SELECT a FROM DotUvdT304 a")})
public class DotUvdT304 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "VOID2")
    private String void2;
    @Size(max = 20)
    @Column(name = "VOID3")
    private String void3;
    @Size(max = 20)
    @Column(name = "VOID4")
    private String void4;
    @Size(max = 20)
    @Column(name = "AVERAGEVOIDS")
    private String averagevoids;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 368)
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
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "VOLUME")
    private String volume;
    @Size(max = 50)
    @Column(name = "NET_MASS")
    private String netMass;
    @Size(max = 50)
    @Column(name = "BULK_DRY_SPEC_GRAV")
    private String bulkDrySpecGrav;
    @Size(max = 50)
    @Column(name = "UNCOMPACTED_VOIDS")
    private String uncompactedVoids;
    @Size(max = 20)
    @Column(name = "CUPWEIGHT")
    private String cupweight;
    @Size(max = 20)
    @Column(name = "GSB")
    private String gsb;
    @Size(max = 20)
    @Column(name = "CUPSAMPLEWEIGHT1")
    private String cupsampleweight1;
    @Size(max = 20)
    @Column(name = "CUPSAMPLEWEIGHT2")
    private String cupsampleweight2;
    @Size(max = 20)
    @Column(name = "CUPSAMPLEWEIGHT3")
    private String cupsampleweight3;
    @Size(max = 20)
    @Column(name = "CUPSAMPLEWEIGHT4")
    private String cupsampleweight4;
    @Size(max = 20)
    @Column(name = "SAMPLEWEIGHT1")
    private String sampleweight1;
    @Size(max = 20)
    @Column(name = "SAMPLEWEIGHT2")
    private String sampleweight2;
    @Size(max = 20)
    @Column(name = "SAMPLEWEIGHT3")
    private String sampleweight3;
    @Size(max = 20)
    @Column(name = "SAMPLEWEIGHT4")
    private String sampleweight4;
    @Size(max = 20)
    @Column(name = "SAMWDIVGSB1")
    private String samwdivgsb1;
    @Size(max = 20)
    @Column(name = "SAMWDIVGSB2")
    private String samwdivgsb2;
    @Size(max = 20)
    @Column(name = "SAMWDIVGSB3")
    private String samwdivgsb3;
    @Size(max = 20)
    @Column(name = "SAMWDIVGSB4")
    private String samwdivgsb4;
    @Size(max = 20)
    @Column(name = "VOID1")
    private String void1;
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

    public DotUvdT304() {
    }

    public String getVoid2() {
        return void2;
    }

    public void setVoid2(String void2) {
        this.void2 = void2;
    }

    public String getVoid3() {
        return void3;
    }

    public void setVoid3(String void3) {
        this.void3 = void3;
    }

    public String getVoid4() {
        return void4;
    }

    public void setVoid4(String void4) {
        this.void4 = void4;
    }

    public String getAveragevoids() {
        return averagevoids;
    }

    public void setAveragevoids(String averagevoids) {
        this.averagevoids = averagevoids;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
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

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNetMass() {
        return netMass;
    }

    public void setNetMass(String netMass) {
        this.netMass = netMass;
    }

    public String getBulkDrySpecGrav() {
        return bulkDrySpecGrav;
    }

    public void setBulkDrySpecGrav(String bulkDrySpecGrav) {
        this.bulkDrySpecGrav = bulkDrySpecGrav;
    }

    public String getUncompactedVoids() {
        return uncompactedVoids;
    }

    public void setUncompactedVoids(String uncompactedVoids) {
        this.uncompactedVoids = uncompactedVoids;
    }

    public String getCupweight() {
        return cupweight;
    }

    public void setCupweight(String cupweight) {
        this.cupweight = cupweight;
    }

    public String getGsb() {
        return gsb;
    }

    public void setGsb(String gsb) {
        this.gsb = gsb;
    }

    public String getCupsampleweight1() {
        return cupsampleweight1;
    }

    public void setCupsampleweight1(String cupsampleweight1) {
        this.cupsampleweight1 = cupsampleweight1;
    }

    public String getCupsampleweight2() {
        return cupsampleweight2;
    }

    public void setCupsampleweight2(String cupsampleweight2) {
        this.cupsampleweight2 = cupsampleweight2;
    }

    public String getCupsampleweight3() {
        return cupsampleweight3;
    }

    public void setCupsampleweight3(String cupsampleweight3) {
        this.cupsampleweight3 = cupsampleweight3;
    }

    public String getCupsampleweight4() {
        return cupsampleweight4;
    }

    public void setCupsampleweight4(String cupsampleweight4) {
        this.cupsampleweight4 = cupsampleweight4;
    }

    public String getSampleweight1() {
        return sampleweight1;
    }

    public void setSampleweight1(String sampleweight1) {
        this.sampleweight1 = sampleweight1;
    }

    public String getSampleweight2() {
        return sampleweight2;
    }

    public void setSampleweight2(String sampleweight2) {
        this.sampleweight2 = sampleweight2;
    }

    public String getSampleweight3() {
        return sampleweight3;
    }

    public void setSampleweight3(String sampleweight3) {
        this.sampleweight3 = sampleweight3;
    }

    public String getSampleweight4() {
        return sampleweight4;
    }

    public void setSampleweight4(String sampleweight4) {
        this.sampleweight4 = sampleweight4;
    }

    public String getSamwdivgsb1() {
        return samwdivgsb1;
    }

    public void setSamwdivgsb1(String samwdivgsb1) {
        this.samwdivgsb1 = samwdivgsb1;
    }

    public String getSamwdivgsb2() {
        return samwdivgsb2;
    }

    public void setSamwdivgsb2(String samwdivgsb2) {
        this.samwdivgsb2 = samwdivgsb2;
    }

    public String getSamwdivgsb3() {
        return samwdivgsb3;
    }

    public void setSamwdivgsb3(String samwdivgsb3) {
        this.samwdivgsb3 = samwdivgsb3;
    }

    public String getSamwdivgsb4() {
        return samwdivgsb4;
    }

    public void setSamwdivgsb4(String samwdivgsb4) {
        this.samwdivgsb4 = samwdivgsb4;
    }

    public String getVoid1() {
        return void1;
    }

    public void setVoid1(String void1) {
        this.void1 = void1;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
