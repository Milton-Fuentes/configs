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
@Table(name = "DOT_RUT_T340", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotRutT340.findAll", query = "SELECT a FROM DotRutT340 a")})
public class DotRutT340 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "RIGHT_DEPTH_GAUGE_READING2")
    private String rightDepthGaugeReading2;
    @Size(max = 50)
    @Column(name = "RIGHT_DEPTH_GAUGE_READING3")
    private String rightDepthGaugeReading3;
    @Size(max = 50)
    @Column(name = "RIGHT_DEPTH_GAUGE_READING4")
    private String rightDepthGaugeReading4;
    @Size(max = 50)
    @Column(name = "RIGHT_DEPTH_GAUGE_READING5")
    private String rightDepthGaugeReading5;
    @Size(max = 50)
    @Column(name = "RIGHT_AVERAGE_DEPTH")
    private String rightAverageDepth;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "CENTER_AVG_AIR_VOIDS_PCT")
    private String centerAvgAirVoidsPct;
    @Size(max = 50)
    @Column(name = "RIGHT_SAMPLE_ID")
    private String rightSampleId;
    @Size(max = 50)
    @Column(name = "RIGHT_FRONT_GMB")
    private String rightFrontGmb;
    @Size(max = 50)
    @Column(name = "RIGHT_BACK_GMB")
    private String rightBackGmb;
    @Size(max = 50)
    @Column(name = "RIGHT_FRONT_GMM")
    private String rightFrontGmm;
    @Size(max = 50)
    @Column(name = "RIGHT_BACK_GMM")
    private String rightBackGmm;
    @Size(max = 50)
    @Column(name = "RIGHT_FRONT_AIR_VOID_PCT")
    private String rightFrontAirVoidPct;
    @Size(max = 50)
    @Column(name = "RIGHT_BACK_AIR_VOID_PCT")
    private String rightBackAirVoidPct;
    @Size(max = 50)
    @Column(name = "RIGHT_AVG_AIR_VOIDS_PCT")
    private String rightAvgAirVoidsPct;
    @Size(max = 50)
    @Column(name = "OVERAGE_AVERAGE_RUT_DEPTH")
    private String overageAverageRutDepth;
    @Size(max = 50)
    @Column(name = "STANDARD_DEVIATION")
    private String standardDeviation;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_DEPTH_GAUGE_READ1")
    private String leftFinalDepthGaugeRead1;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_DEPTH_GAUGE_READ2")
    private String leftFinalDepthGaugeRead2;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_DEPTH_GAUGE_READ3")
    private String leftFinalDepthGaugeRead3;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_DEPTH_GAUGE_READ4")
    private String leftFinalDepthGaugeRead4;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_DEPTH_GAUGE_READ5")
    private String leftFinalDepthGaugeRead5;
    @Size(max = 50)
    @Column(name = "LEFT_FINAL_AVERAGE_DEPTH")
    private String leftFinalAverageDepth;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_DEPTH_GAUGE_READ1")
    private String centerFinalDepthGaugeRead1;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_DEPTH_GAUGE_READ2")
    private String centerFinalDepthGaugeRead2;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_DEPTH_GAUGE_READ3")
    private String centerFinalDepthGaugeRead3;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_DEPTH_GAUGE_READ4")
    private String centerFinalDepthGaugeRead4;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_DEPTH_GAUGE_READ5")
    private String centerFinalDepthGaugeRead5;
    @Size(max = 50)
    @Column(name = "CENTER_FINAL_AVERAGE_DEPTH")
    private String centerFinalAverageDepth;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_DEPTH_GAUGE_READ1")
    private String rightFinalDepthGaugeRead1;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_DEPTH_GAUGE_READ2")
    private String rightFinalDepthGaugeRead2;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_DEPTH_GAUGE_READ3")
    private String rightFinalDepthGaugeRead3;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_DEPTH_GAUGE_READ4")
    private String rightFinalDepthGaugeRead4;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_DEPTH_GAUGE_READ5")
    private String rightFinalDepthGaugeRead5;
    @Size(max = 50)
    @Column(name = "RIGHT_FINAL_AVERAGE_DEPTH")
    private String rightFinalAverageDepth;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "LEFT_BACK_SAMPLE_ID")
    private String leftBackSampleId;
    @Size(max = 50)
    @Column(name = "CENTER_BACK_SAMPLE_ID")
    private String centerBackSampleId;
    @Size(max = 50)
    @Column(name = "RIGHT_BACK_SAMPLE_ID")
    private String rightBackSampleId;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "LEFT_FRONT_SAMPLE_LOCATION")
    private String leftFrontSampleLocation;
    @Size(max = 50)
    @Column(name = "LEFT_BACK_SAMPLE_LOCATION")
    private String leftBackSampleLocation;
    @Size(max = 50)
    @Column(name = "CENTER_FRONT_SAMPLE_LOCATION")
    private String centerFrontSampleLocation;
    @Size(max = 50)
    @Column(name = "CENTER_BACK_SAMPLE_LOCATION")
    private String centerBackSampleLocation;
    @Size(max = 50)
    @Column(name = "RIGHT_FRONT_SAMPLE_LOCATION")
    private String rightFrontSampleLocation;
    @Size(max = 50)
    @Column(name = "RIGHT_BACK_SAMPLE_LOCATION")
    private String rightBackSampleLocation;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "LEFT_STROKE_COUNT")
    private String leftStrokeCount;
    @Size(max = 50)
    @Column(name = "LEFT_TEMPERATUREF")
    private String leftTemperaturef;
    @Size(max = 50)
    @Column(name = "LEFT_TEMPERATUREC")
    private String leftTemperaturec;
    @Size(max = 50)
    @Column(name = "LEFT_DEPTH_GAUGE_READING1")
    private String leftDepthGaugeReading1;
    @Size(max = 50)
    @Column(name = "LEFT_DEPTH_GAUGE_READING2")
    private String leftDepthGaugeReading2;
    @Size(max = 50)
    @Column(name = "LEFT_DEPTH_GAUGE_READING3")
    private String leftDepthGaugeReading3;
    @Size(max = 50)
    @Column(name = "LEFT_DEPTH_GAUGE_READING4")
    private String leftDepthGaugeReading4;
    @Size(max = 50)
    @Column(name = "LEFT_DEPTH_GAUGE_READING5")
    private String leftDepthGaugeReading5;
    @Size(max = 50)
    @Column(name = "LEFT_AVERAGE_DEPTH")
    private String leftAverageDepth;
    @Size(max = 50)
    @Column(name = "CENTER_STROKE_COUNT")
    private String centerStrokeCount;
    @Size(max = 50)
    @Column(name = "CENTER_TEMPERATUREF")
    private String centerTemperaturef;
    @Size(max = 50)
    @Column(name = "CENTER_TEMPERATUREC")
    private String centerTemperaturec;
    @Size(max = 50)
    @Column(name = "CENTER_DEPTH_GAUGE_READING1")
    private String centerDepthGaugeReading1;
    @Size(max = 50)
    @Column(name = "CENTER_DEPTH_GAUGE_READING2")
    private String centerDepthGaugeReading2;
    @Size(max = 50)
    @Column(name = "CENTER_DEPTH_GAUGE_READING3")
    private String centerDepthGaugeReading3;
    @Size(max = 50)
    @Column(name = "CENTER_DEPTH_GAUGE_READING4")
    private String centerDepthGaugeReading4;
    @Size(max = 50)
    @Column(name = "CENTER_DEPTH_GAUGE_READING5")
    private String centerDepthGaugeReading5;
    @Size(max = 50)
    @Column(name = "CENTER_AVERAGE_DEPTH")
    private String centerAverageDepth;
    @Size(max = 50)
    @Column(name = "RIGHT_STROKE_COUNT")
    private String rightStrokeCount;
    @Size(max = 50)
    @Column(name = "RIGHT_TEMPERATUREF")
    private String rightTemperaturef;
    @Size(max = 50)
    @Column(name = "RIGHT_TEMPERATUREC")
    private String rightTemperaturec;
    @Size(max = 50)
    @Column(name = "RIGHT_DEPTH_GAUGE_READING1")
    private String rightDepthGaugeReading1;
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
    @Column(name = "TYPE_OF_SPECIMEN")
    private String typeOfSpecimen;
    @Size(max = 50)
    @Column(name = "METHOD_OF_MEASUREMENT")
    private String methodOfMeasurement;
    @Size(max = 50)
    @Column(name = "LEFT_SAMPLE_ID")
    private String leftSampleId;
    @Size(max = 50)
    @Column(name = "LEFT_FRONT_GMB")
    private String leftFrontGmb;
    @Size(max = 50)
    @Column(name = "LEFT_BACK_GMB")
    private String leftBackGmb;
    @Size(max = 50)
    @Column(name = "LEFT_FRONT_GMM")
    private String leftFrontGmm;
    @Size(max = 50)
    @Column(name = "LEFT_BACK_GMM")
    private String leftBackGmm;
    @Size(max = 50)
    @Column(name = "LEFT_FRONT_AIR_VOID_PCT")
    private String leftFrontAirVoidPct;
    @Size(max = 50)
    @Column(name = "LEFT_BACK_AIR_VOID_PCT")
    private String leftBackAirVoidPct;
    @Size(max = 50)
    @Column(name = "LEFT_AVG_AIR_VOIDS_PCT")
    private String leftAvgAirVoidsPct;
    @Size(max = 50)
    @Column(name = "CENTER_SAMPLE_ID")
    private String centerSampleId;
    @Size(max = 50)
    @Column(name = "CENTER_FRONT_GMB")
    private String centerFrontGmb;
    @Size(max = 50)
    @Column(name = "CENTER_BACK_GMB")
    private String centerBackGmb;
    @Size(max = 50)
    @Column(name = "CENTER_FRONT_GMM")
    private String centerFrontGmm;
    @Size(max = 50)
    @Column(name = "CENTER_BACK_GMM")
    private String centerBackGmm;
    @Size(max = 50)
    @Column(name = "CENTER_FRONT_AIR_VOID_PCT")
    private String centerFrontAirVoidPct;
    @Size(max = 50)
    @Column(name = "CENTER_BACK_AIR_VOID_PCT")
    private String centerBackAirVoidPct;

    public DotRutT340() {
    }

    public String getRightDepthGaugeReading2() {
        return rightDepthGaugeReading2;
    }

    public void setRightDepthGaugeReading2(String rightDepthGaugeReading2) {
        this.rightDepthGaugeReading2 = rightDepthGaugeReading2;
    }

    public String getRightDepthGaugeReading3() {
        return rightDepthGaugeReading3;
    }

    public void setRightDepthGaugeReading3(String rightDepthGaugeReading3) {
        this.rightDepthGaugeReading3 = rightDepthGaugeReading3;
    }

    public String getRightDepthGaugeReading4() {
        return rightDepthGaugeReading4;
    }

    public void setRightDepthGaugeReading4(String rightDepthGaugeReading4) {
        this.rightDepthGaugeReading4 = rightDepthGaugeReading4;
    }

    public String getRightDepthGaugeReading5() {
        return rightDepthGaugeReading5;
    }

    public void setRightDepthGaugeReading5(String rightDepthGaugeReading5) {
        this.rightDepthGaugeReading5 = rightDepthGaugeReading5;
    }

    public String getRightAverageDepth() {
        return rightAverageDepth;
    }

    public void setRightAverageDepth(String rightAverageDepth) {
        this.rightAverageDepth = rightAverageDepth;
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

    public String getCenterAvgAirVoidsPct() {
        return centerAvgAirVoidsPct;
    }

    public void setCenterAvgAirVoidsPct(String centerAvgAirVoidsPct) {
        this.centerAvgAirVoidsPct = centerAvgAirVoidsPct;
    }

    public String getRightSampleId() {
        return rightSampleId;
    }

    public void setRightSampleId(String rightSampleId) {
        this.rightSampleId = rightSampleId;
    }

    public String getRightFrontGmb() {
        return rightFrontGmb;
    }

    public void setRightFrontGmb(String rightFrontGmb) {
        this.rightFrontGmb = rightFrontGmb;
    }

    public String getRightBackGmb() {
        return rightBackGmb;
    }

    public void setRightBackGmb(String rightBackGmb) {
        this.rightBackGmb = rightBackGmb;
    }

    public String getRightFrontGmm() {
        return rightFrontGmm;
    }

    public void setRightFrontGmm(String rightFrontGmm) {
        this.rightFrontGmm = rightFrontGmm;
    }

    public String getRightBackGmm() {
        return rightBackGmm;
    }

    public void setRightBackGmm(String rightBackGmm) {
        this.rightBackGmm = rightBackGmm;
    }

    public String getRightFrontAirVoidPct() {
        return rightFrontAirVoidPct;
    }

    public void setRightFrontAirVoidPct(String rightFrontAirVoidPct) {
        this.rightFrontAirVoidPct = rightFrontAirVoidPct;
    }

    public String getRightBackAirVoidPct() {
        return rightBackAirVoidPct;
    }

    public void setRightBackAirVoidPct(String rightBackAirVoidPct) {
        this.rightBackAirVoidPct = rightBackAirVoidPct;
    }

    public String getRightAvgAirVoidsPct() {
        return rightAvgAirVoidsPct;
    }

    public void setRightAvgAirVoidsPct(String rightAvgAirVoidsPct) {
        this.rightAvgAirVoidsPct = rightAvgAirVoidsPct;
    }

    public String getOverageAverageRutDepth() {
        return overageAverageRutDepth;
    }

    public void setOverageAverageRutDepth(String overageAverageRutDepth) {
        this.overageAverageRutDepth = overageAverageRutDepth;
    }

    public String getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public String getLeftFinalDepthGaugeRead1() {
        return leftFinalDepthGaugeRead1;
    }

    public void setLeftFinalDepthGaugeRead1(String leftFinalDepthGaugeRead1) {
        this.leftFinalDepthGaugeRead1 = leftFinalDepthGaugeRead1;
    }

    public String getLeftFinalDepthGaugeRead2() {
        return leftFinalDepthGaugeRead2;
    }

    public void setLeftFinalDepthGaugeRead2(String leftFinalDepthGaugeRead2) {
        this.leftFinalDepthGaugeRead2 = leftFinalDepthGaugeRead2;
    }

    public String getLeftFinalDepthGaugeRead3() {
        return leftFinalDepthGaugeRead3;
    }

    public void setLeftFinalDepthGaugeRead3(String leftFinalDepthGaugeRead3) {
        this.leftFinalDepthGaugeRead3 = leftFinalDepthGaugeRead3;
    }

    public String getLeftFinalDepthGaugeRead4() {
        return leftFinalDepthGaugeRead4;
    }

    public void setLeftFinalDepthGaugeRead4(String leftFinalDepthGaugeRead4) {
        this.leftFinalDepthGaugeRead4 = leftFinalDepthGaugeRead4;
    }

    public String getLeftFinalDepthGaugeRead5() {
        return leftFinalDepthGaugeRead5;
    }

    public void setLeftFinalDepthGaugeRead5(String leftFinalDepthGaugeRead5) {
        this.leftFinalDepthGaugeRead5 = leftFinalDepthGaugeRead5;
    }

    public String getLeftFinalAverageDepth() {
        return leftFinalAverageDepth;
    }

    public void setLeftFinalAverageDepth(String leftFinalAverageDepth) {
        this.leftFinalAverageDepth = leftFinalAverageDepth;
    }

    public String getCenterFinalDepthGaugeRead1() {
        return centerFinalDepthGaugeRead1;
    }

    public void setCenterFinalDepthGaugeRead1(String centerFinalDepthGaugeRead1) {
        this.centerFinalDepthGaugeRead1 = centerFinalDepthGaugeRead1;
    }

    public String getCenterFinalDepthGaugeRead2() {
        return centerFinalDepthGaugeRead2;
    }

    public void setCenterFinalDepthGaugeRead2(String centerFinalDepthGaugeRead2) {
        this.centerFinalDepthGaugeRead2 = centerFinalDepthGaugeRead2;
    }

    public String getCenterFinalDepthGaugeRead3() {
        return centerFinalDepthGaugeRead3;
    }

    public void setCenterFinalDepthGaugeRead3(String centerFinalDepthGaugeRead3) {
        this.centerFinalDepthGaugeRead3 = centerFinalDepthGaugeRead3;
    }

    public String getCenterFinalDepthGaugeRead4() {
        return centerFinalDepthGaugeRead4;
    }

    public void setCenterFinalDepthGaugeRead4(String centerFinalDepthGaugeRead4) {
        this.centerFinalDepthGaugeRead4 = centerFinalDepthGaugeRead4;
    }

    public String getCenterFinalDepthGaugeRead5() {
        return centerFinalDepthGaugeRead5;
    }

    public void setCenterFinalDepthGaugeRead5(String centerFinalDepthGaugeRead5) {
        this.centerFinalDepthGaugeRead5 = centerFinalDepthGaugeRead5;
    }

    public String getCenterFinalAverageDepth() {
        return centerFinalAverageDepth;
    }

    public void setCenterFinalAverageDepth(String centerFinalAverageDepth) {
        this.centerFinalAverageDepth = centerFinalAverageDepth;
    }

    public String getRightFinalDepthGaugeRead1() {
        return rightFinalDepthGaugeRead1;
    }

    public void setRightFinalDepthGaugeRead1(String rightFinalDepthGaugeRead1) {
        this.rightFinalDepthGaugeRead1 = rightFinalDepthGaugeRead1;
    }

    public String getRightFinalDepthGaugeRead2() {
        return rightFinalDepthGaugeRead2;
    }

    public void setRightFinalDepthGaugeRead2(String rightFinalDepthGaugeRead2) {
        this.rightFinalDepthGaugeRead2 = rightFinalDepthGaugeRead2;
    }

    public String getRightFinalDepthGaugeRead3() {
        return rightFinalDepthGaugeRead3;
    }

    public void setRightFinalDepthGaugeRead3(String rightFinalDepthGaugeRead3) {
        this.rightFinalDepthGaugeRead3 = rightFinalDepthGaugeRead3;
    }

    public String getRightFinalDepthGaugeRead4() {
        return rightFinalDepthGaugeRead4;
    }

    public void setRightFinalDepthGaugeRead4(String rightFinalDepthGaugeRead4) {
        this.rightFinalDepthGaugeRead4 = rightFinalDepthGaugeRead4;
    }

    public String getRightFinalDepthGaugeRead5() {
        return rightFinalDepthGaugeRead5;
    }

    public void setRightFinalDepthGaugeRead5(String rightFinalDepthGaugeRead5) {
        this.rightFinalDepthGaugeRead5 = rightFinalDepthGaugeRead5;
    }

    public String getRightFinalAverageDepth() {
        return rightFinalAverageDepth;
    }

    public void setRightFinalAverageDepth(String rightFinalAverageDepth) {
        this.rightFinalAverageDepth = rightFinalAverageDepth;
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

    public String getLeftBackSampleId() {
        return leftBackSampleId;
    }

    public void setLeftBackSampleId(String leftBackSampleId) {
        this.leftBackSampleId = leftBackSampleId;
    }

    public String getCenterBackSampleId() {
        return centerBackSampleId;
    }

    public void setCenterBackSampleId(String centerBackSampleId) {
        this.centerBackSampleId = centerBackSampleId;
    }

    public String getRightBackSampleId() {
        return rightBackSampleId;
    }

    public void setRightBackSampleId(String rightBackSampleId) {
        this.rightBackSampleId = rightBackSampleId;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getLeftFrontSampleLocation() {
        return leftFrontSampleLocation;
    }

    public void setLeftFrontSampleLocation(String leftFrontSampleLocation) {
        this.leftFrontSampleLocation = leftFrontSampleLocation;
    }

    public String getLeftBackSampleLocation() {
        return leftBackSampleLocation;
    }

    public void setLeftBackSampleLocation(String leftBackSampleLocation) {
        this.leftBackSampleLocation = leftBackSampleLocation;
    }

    public String getCenterFrontSampleLocation() {
        return centerFrontSampleLocation;
    }

    public void setCenterFrontSampleLocation(String centerFrontSampleLocation) {
        this.centerFrontSampleLocation = centerFrontSampleLocation;
    }

    public String getCenterBackSampleLocation() {
        return centerBackSampleLocation;
    }

    public void setCenterBackSampleLocation(String centerBackSampleLocation) {
        this.centerBackSampleLocation = centerBackSampleLocation;
    }

    public String getRightFrontSampleLocation() {
        return rightFrontSampleLocation;
    }

    public void setRightFrontSampleLocation(String rightFrontSampleLocation) {
        this.rightFrontSampleLocation = rightFrontSampleLocation;
    }

    public String getRightBackSampleLocation() {
        return rightBackSampleLocation;
    }

    public void setRightBackSampleLocation(String rightBackSampleLocation) {
        this.rightBackSampleLocation = rightBackSampleLocation;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getLeftStrokeCount() {
        return leftStrokeCount;
    }

    public void setLeftStrokeCount(String leftStrokeCount) {
        this.leftStrokeCount = leftStrokeCount;
    }

    public String getLeftTemperaturef() {
        return leftTemperaturef;
    }

    public void setLeftTemperaturef(String leftTemperaturef) {
        this.leftTemperaturef = leftTemperaturef;
    }

    public String getLeftTemperaturec() {
        return leftTemperaturec;
    }

    public void setLeftTemperaturec(String leftTemperaturec) {
        this.leftTemperaturec = leftTemperaturec;
    }

    public String getLeftDepthGaugeReading1() {
        return leftDepthGaugeReading1;
    }

    public void setLeftDepthGaugeReading1(String leftDepthGaugeReading1) {
        this.leftDepthGaugeReading1 = leftDepthGaugeReading1;
    }

    public String getLeftDepthGaugeReading2() {
        return leftDepthGaugeReading2;
    }

    public void setLeftDepthGaugeReading2(String leftDepthGaugeReading2) {
        this.leftDepthGaugeReading2 = leftDepthGaugeReading2;
    }

    public String getLeftDepthGaugeReading3() {
        return leftDepthGaugeReading3;
    }

    public void setLeftDepthGaugeReading3(String leftDepthGaugeReading3) {
        this.leftDepthGaugeReading3 = leftDepthGaugeReading3;
    }

    public String getLeftDepthGaugeReading4() {
        return leftDepthGaugeReading4;
    }

    public void setLeftDepthGaugeReading4(String leftDepthGaugeReading4) {
        this.leftDepthGaugeReading4 = leftDepthGaugeReading4;
    }

    public String getLeftDepthGaugeReading5() {
        return leftDepthGaugeReading5;
    }

    public void setLeftDepthGaugeReading5(String leftDepthGaugeReading5) {
        this.leftDepthGaugeReading5 = leftDepthGaugeReading5;
    }

    public String getLeftAverageDepth() {
        return leftAverageDepth;
    }

    public void setLeftAverageDepth(String leftAverageDepth) {
        this.leftAverageDepth = leftAverageDepth;
    }

    public String getCenterStrokeCount() {
        return centerStrokeCount;
    }

    public void setCenterStrokeCount(String centerStrokeCount) {
        this.centerStrokeCount = centerStrokeCount;
    }

    public String getCenterTemperaturef() {
        return centerTemperaturef;
    }

    public void setCenterTemperaturef(String centerTemperaturef) {
        this.centerTemperaturef = centerTemperaturef;
    }

    public String getCenterTemperaturec() {
        return centerTemperaturec;
    }

    public void setCenterTemperaturec(String centerTemperaturec) {
        this.centerTemperaturec = centerTemperaturec;
    }

    public String getCenterDepthGaugeReading1() {
        return centerDepthGaugeReading1;
    }

    public void setCenterDepthGaugeReading1(String centerDepthGaugeReading1) {
        this.centerDepthGaugeReading1 = centerDepthGaugeReading1;
    }

    public String getCenterDepthGaugeReading2() {
        return centerDepthGaugeReading2;
    }

    public void setCenterDepthGaugeReading2(String centerDepthGaugeReading2) {
        this.centerDepthGaugeReading2 = centerDepthGaugeReading2;
    }

    public String getCenterDepthGaugeReading3() {
        return centerDepthGaugeReading3;
    }

    public void setCenterDepthGaugeReading3(String centerDepthGaugeReading3) {
        this.centerDepthGaugeReading3 = centerDepthGaugeReading3;
    }

    public String getCenterDepthGaugeReading4() {
        return centerDepthGaugeReading4;
    }

    public void setCenterDepthGaugeReading4(String centerDepthGaugeReading4) {
        this.centerDepthGaugeReading4 = centerDepthGaugeReading4;
    }

    public String getCenterDepthGaugeReading5() {
        return centerDepthGaugeReading5;
    }

    public void setCenterDepthGaugeReading5(String centerDepthGaugeReading5) {
        this.centerDepthGaugeReading5 = centerDepthGaugeReading5;
    }

    public String getCenterAverageDepth() {
        return centerAverageDepth;
    }

    public void setCenterAverageDepth(String centerAverageDepth) {
        this.centerAverageDepth = centerAverageDepth;
    }

    public String getRightStrokeCount() {
        return rightStrokeCount;
    }

    public void setRightStrokeCount(String rightStrokeCount) {
        this.rightStrokeCount = rightStrokeCount;
    }

    public String getRightTemperaturef() {
        return rightTemperaturef;
    }

    public void setRightTemperaturef(String rightTemperaturef) {
        this.rightTemperaturef = rightTemperaturef;
    }

    public String getRightTemperaturec() {
        return rightTemperaturec;
    }

    public void setRightTemperaturec(String rightTemperaturec) {
        this.rightTemperaturec = rightTemperaturec;
    }

    public String getRightDepthGaugeReading1() {
        return rightDepthGaugeReading1;
    }

    public void setRightDepthGaugeReading1(String rightDepthGaugeReading1) {
        this.rightDepthGaugeReading1 = rightDepthGaugeReading1;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getTypeOfSpecimen() {
        return typeOfSpecimen;
    }

    public void setTypeOfSpecimen(String typeOfSpecimen) {
        this.typeOfSpecimen = typeOfSpecimen;
    }

    public String getMethodOfMeasurement() {
        return methodOfMeasurement;
    }

    public void setMethodOfMeasurement(String methodOfMeasurement) {
        this.methodOfMeasurement = methodOfMeasurement;
    }

    public String getLeftSampleId() {
        return leftSampleId;
    }

    public void setLeftSampleId(String leftSampleId) {
        this.leftSampleId = leftSampleId;
    }

    public String getLeftFrontGmb() {
        return leftFrontGmb;
    }

    public void setLeftFrontGmb(String leftFrontGmb) {
        this.leftFrontGmb = leftFrontGmb;
    }

    public String getLeftBackGmb() {
        return leftBackGmb;
    }

    public void setLeftBackGmb(String leftBackGmb) {
        this.leftBackGmb = leftBackGmb;
    }

    public String getLeftFrontGmm() {
        return leftFrontGmm;
    }

    public void setLeftFrontGmm(String leftFrontGmm) {
        this.leftFrontGmm = leftFrontGmm;
    }

    public String getLeftBackGmm() {
        return leftBackGmm;
    }

    public void setLeftBackGmm(String leftBackGmm) {
        this.leftBackGmm = leftBackGmm;
    }

    public String getLeftFrontAirVoidPct() {
        return leftFrontAirVoidPct;
    }

    public void setLeftFrontAirVoidPct(String leftFrontAirVoidPct) {
        this.leftFrontAirVoidPct = leftFrontAirVoidPct;
    }

    public String getLeftBackAirVoidPct() {
        return leftBackAirVoidPct;
    }

    public void setLeftBackAirVoidPct(String leftBackAirVoidPct) {
        this.leftBackAirVoidPct = leftBackAirVoidPct;
    }

    public String getLeftAvgAirVoidsPct() {
        return leftAvgAirVoidsPct;
    }

    public void setLeftAvgAirVoidsPct(String leftAvgAirVoidsPct) {
        this.leftAvgAirVoidsPct = leftAvgAirVoidsPct;
    }

    public String getCenterSampleId() {
        return centerSampleId;
    }

    public void setCenterSampleId(String centerSampleId) {
        this.centerSampleId = centerSampleId;
    }

    public String getCenterFrontGmb() {
        return centerFrontGmb;
    }

    public void setCenterFrontGmb(String centerFrontGmb) {
        this.centerFrontGmb = centerFrontGmb;
    }

    public String getCenterBackGmb() {
        return centerBackGmb;
    }

    public void setCenterBackGmb(String centerBackGmb) {
        this.centerBackGmb = centerBackGmb;
    }

    public String getCenterFrontGmm() {
        return centerFrontGmm;
    }

    public void setCenterFrontGmm(String centerFrontGmm) {
        this.centerFrontGmm = centerFrontGmm;
    }

    public String getCenterBackGmm() {
        return centerBackGmm;
    }

    public void setCenterBackGmm(String centerBackGmm) {
        this.centerBackGmm = centerBackGmm;
    }

    public String getCenterFrontAirVoidPct() {
        return centerFrontAirVoidPct;
    }

    public void setCenterFrontAirVoidPct(String centerFrontAirVoidPct) {
        this.centerFrontAirVoidPct = centerFrontAirVoidPct;
    }

    public String getCenterBackAirVoidPct() {
        return centerBackAirVoidPct;
    }

    public void setCenterBackAirVoidPct(String centerBackAirVoidPct) {
        this.centerBackAirVoidPct = centerBackAirVoidPct;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
