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
@Table(name = "dot_wwr_e8", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotWwrE8.findAll", query = "SELECT a FROM DotWwrE8 a")})
public class DotWwrE8 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "MESH_SIZE_RESULT")
    private String meshSizeResult;
    @Column(name = "DISCARD")
    private Character discard;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
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
    @Size(max = 376)
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
    @Column(name = "HORIZONTAL_DIAMETER_SPEC_MIN")
    private String horizontalDiameterSpecMin;
    @Size(max = 50)
    @Column(name = "HORIZONTAL_DIAMETER_SPEC_MAX")
    private String horizontalDiameterSpecMax;
    @Size(max = 50)
    @Column(name = "VERTICAL_DIAMETER_SPEC_MIN")
    private String verticalDiameterSpecMin;
    @Size(max = 50)
    @Column(name = "VERTICAL_DIAMETER_SPEC_MAX")
    private String verticalDiameterSpecMax;
    @Size(max = 50)
    @Column(name = "TENSILE_SPEC_MIN")
    private String tensileSpecMin;
    @Size(max = 50)
    @Column(name = "REDUCTION_AREA_SPEC_MIN")
    private String reductionAreaSpecMin;
    @Size(max = 50)
    @Column(name = "MESH_SIZE_SPEC_MIN")
    private String meshSizeSpecMin;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "WIRE_SIZES")
    private String wireSizes;
    @Size(max = 50)
    @Column(name = "HORIZONTAL_DIAMETER")
    private String horizontalDiameter;
    @Size(max = 50)
    @Column(name = "VERTICAL_DIAMETER")
    private String verticalDiameter;
    @Size(max = 50)
    @Column(name = "TENSILE")
    private String tensile;
    @Size(max = 50)
    @Column(name = "REDUCTION_AREA")
    private String reductionArea;
    @Size(max = 50)
    @Column(name = "MESH_SIZE")
    private String meshSize;
    @Size(max = 50)
    @Column(name = "HORIZONTAL_DIAMETER_RESULT")
    private String horizontalDiameterResult;
    @Size(max = 50)
    @Column(name = "VERTICAL_DIAMETER_RESULT")
    private String verticalDiameterResult;
    @Size(max = 50)
    @Column(name = "TENSILE_RESULT")
    private String tensileResult;
    @Size(max = 50)
    @Column(name = "REDUCTION_AREA_RESULT")
    private String reductionAreaResult;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
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

    public DotWwrE8() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMeshSizeResult() {
        return meshSizeResult;
    }

    public void setMeshSizeResult(String meshSizeResult) {
        this.meshSizeResult = meshSizeResult;
    }

    public Character getDiscard() {
        return discard;
    }

    public void setDiscard(Character discard) {
        this.discard = discard;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getHorizontalDiameterSpecMin() {
        return horizontalDiameterSpecMin;
    }

    public void setHorizontalDiameterSpecMin(String horizontalDiameterSpecMin) {
        this.horizontalDiameterSpecMin = horizontalDiameterSpecMin;
    }

    public String getHorizontalDiameterSpecMax() {
        return horizontalDiameterSpecMax;
    }

    public void setHorizontalDiameterSpecMax(String horizontalDiameterSpecMax) {
        this.horizontalDiameterSpecMax = horizontalDiameterSpecMax;
    }

    public String getVerticalDiameterSpecMin() {
        return verticalDiameterSpecMin;
    }

    public void setVerticalDiameterSpecMin(String verticalDiameterSpecMin) {
        this.verticalDiameterSpecMin = verticalDiameterSpecMin;
    }

    public String getVerticalDiameterSpecMax() {
        return verticalDiameterSpecMax;
    }

    public void setVerticalDiameterSpecMax(String verticalDiameterSpecMax) {
        this.verticalDiameterSpecMax = verticalDiameterSpecMax;
    }

    public String getTensileSpecMin() {
        return tensileSpecMin;
    }

    public void setTensileSpecMin(String tensileSpecMin) {
        this.tensileSpecMin = tensileSpecMin;
    }

    public String getReductionAreaSpecMin() {
        return reductionAreaSpecMin;
    }

    public void setReductionAreaSpecMin(String reductionAreaSpecMin) {
        this.reductionAreaSpecMin = reductionAreaSpecMin;
    }

    public String getMeshSizeSpecMin() {
        return meshSizeSpecMin;
    }

    public void setMeshSizeSpecMin(String meshSizeSpecMin) {
        this.meshSizeSpecMin = meshSizeSpecMin;
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

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getWireSizes() {
        return wireSizes;
    }

    public void setWireSizes(String wireSizes) {
        this.wireSizes = wireSizes;
    }

    public String getHorizontalDiameter() {
        return horizontalDiameter;
    }

    public void setHorizontalDiameter(String horizontalDiameter) {
        this.horizontalDiameter = horizontalDiameter;
    }

    public String getVerticalDiameter() {
        return verticalDiameter;
    }

    public void setVerticalDiameter(String verticalDiameter) {
        this.verticalDiameter = verticalDiameter;
    }

    public String getTensile() {
        return tensile;
    }

    public void setTensile(String tensile) {
        this.tensile = tensile;
    }

    public String getReductionArea() {
        return reductionArea;
    }

    public void setReductionArea(String reductionArea) {
        this.reductionArea = reductionArea;
    }

    public String getMeshSize() {
        return meshSize;
    }

    public void setMeshSize(String meshSize) {
        this.meshSize = meshSize;
    }

    public String getHorizontalDiameterResult() {
        return horizontalDiameterResult;
    }

    public void setHorizontalDiameterResult(String horizontalDiameterResult) {
        this.horizontalDiameterResult = horizontalDiameterResult;
    }

    public String getVerticalDiameterResult() {
        return verticalDiameterResult;
    }

    public void setVerticalDiameterResult(String verticalDiameterResult) {
        this.verticalDiameterResult = verticalDiameterResult;
    }

    public String getTensileResult() {
        return tensileResult;
    }

    public void setTensileResult(String tensileResult) {
        this.tensileResult = tensileResult;
    }

    public String getReductionAreaResult() {
        return reductionAreaResult;
    }

    public void setReductionAreaResult(String reductionAreaResult) {
        this.reductionAreaResult = reductionAreaResult;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
