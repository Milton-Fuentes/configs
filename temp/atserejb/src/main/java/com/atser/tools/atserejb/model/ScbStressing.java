/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfuentes
 */
@Entity
@Table(name = "SCB_STRESSING_REPORT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbStressing.findAll", query = "SELECT s FROM ScbStressing s")})
public class ScbStressing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "APPLY_FOR_ALL_STRANDS")
    private Character applyForAllStrands;
    @Column(name = "ALL_STRANDS_STRESSED_TOGETHER")
    private Character allStrandsStressedTogether;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "TENDON_DESIGN_LENGTH")
    private BigDecimal tendonDesignLength;
    @Column(name = "NUM_POINTS")
    private BigInteger numPoints;
    @Column(name = "TEST_NO")
    private BigInteger testNo;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "OUT_COIL_ID")
    private BigInteger outCoilId;
    @Column(name = "OUT_EQUIP_RAM_CALIB_ID")
    private BigInteger outEquipRamCalibId;
    @Column(name = "EQUIP_RAM_CALIB_ID")
    private BigInteger equipRamCalibId;
    @Column(name = "COIL_ID")
    private BigInteger coilId;
    @Column(name = "TENDON_DESIGN_ID")
    private BigInteger tendonDesignId;
    @Size(max = 103)
    @Column(name = "RAM_GAUGE_NO")
    private String ramGaugeNo;
    @JsonSkipXssSerialization
    @Size(max = 122)
    @Column(name = "TESTNO_NOLINK")
    private String testnoNolink;
    @JsonSkipXssSerialization
    @Size(max = 142)
    @Column(name = "TESTNO")
    private String testno;
    @JsonSkipXssSerialization
    @Size(max = 247)
    @Column(name = "TESTNO_LINK")
    private String reportNoLink;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "SEGMENT_LOCATION")
    private String segmentLocation;
    @Size(max = 255)
    @Column(name = "TENDON_TYPE")
    private String tendonType;
    @Size(max = 255)
    @Column(name = "E_BEFORE_ANCHOR_SET")
    private String eBeforeAnchorSet;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 306)
    @Column(name = "STRAND_DESIGNATION")
    private String strandDesignation;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "ENET")
    private String enet;
    @Size(max = 50)
    @Column(name = "ENET80")
    private String enet80;
    @Size(max = 50)
    @Column(name = "EPLAN_SEATED")
    private String eplanSeated;
    @Size(max = 50)
    @Column(name = "E_VALUE")
    private String eValue;
    @Size(max = 50)
    @Column(name = "FORCE_ADJUSTMENT")
    private String forceAdjustment;
    @Size(max = 50)
    @Column(name = "OUT_INPUT_GP_REQUIRED")
    private String outInputGpRequired;
    @Size(max = 50)
    @Column(name = "INSTALLATION_DATE")
    private String installationDate;
    @Size(max = 50)
    @Column(name = "JACKING_END")
    private String jackingEnd;
    @Size(max = 50)
    @Column(name = "JACKING_MODE_USED")
    private String jackingModeUsed;
    @Size(max = 50)
    @Column(name = "LE_SEATING_PART")
    private String leSeatingPart;
    @Size(max = 50)
    @Column(name = "LE_SEATING_TOTAL")
    private String leSeatingTotal;
    @Size(max = 50)
    @Column(name = "LE_SEATING_WHOLE")
    private String leSeatingWhole;
    @Size(max = 50)
    @Column(name = "LIVE_END_SEATING")
    private String liveEndSeating;
    @Size(max = 50)
    @Column(name = "LIVE_END_SEATING_PART")
    private String liveEndSeatingPart;
    @Size(max = 50)
    @Column(name = "LIVE_END_SEATING_WHOLE")
    private String liveEndSeatingWhole;
    @Size(max = 50)
    @Column(name = "STRAND_NO")
    private String strandNo;
    @Size(max = 50)
    @Column(name = "STRESSING_DATE_TIME")
    private String stressingDateTime;
    @Size(max = 50)
    @Column(name = "TECH")
    private String tech;
    @Size(max = 50)
    @Column(name = "TOTAL_JACKING_LOSS")
    private String totalJackingLoss;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 50)
    @Column(name = "NUMBER_OF_STRANDS_BARS")
    private String numberOfStrandsBars;
    @Size(max = 50)
    @Column(name = "NOMINAL_DIA")
    private String nominalDia;
    @Size(max = 50)
    @Column(name = "AREADESIGN")
    private String areadesign;
    @Size(max = 50)
    @Column(name = "EMODDESIGN")
    private String emoddesign;
    @Size(max = 50)
    @Column(name = "JACKING_FORCE")
    private String jackingForce;
    @Size(max = 50)
    @Column(name = "JACKING_MODE_DESIGN")
    private String jackingModeDesign;
    @Size(max = 50)
    @Column(name = "JACKING_END_DESIGN")
    private String jackingEndDesign;
    @Size(max = 50)
    @Column(name = "COIL_NO")
    private String coilNo;
    @Size(max = 50)
    @Column(name = "HEAT_ID")
    private String heatId;
    @Size(max = 50)
    @Column(name = "AREAACTUAL")
    private String areaactual;
    @Size(max = 50)
    @Column(name = "LENGTH_ACTUAL_COIL")
    private String lengthActualCoil;
    @Size(max = 50)
    @Column(name = "EMODACTUAL")
    private String emodactual;
    @Size(max = 50)
    @Column(name = "OUTPUT_GAUGE_PRESSURE_REQUIRED")
    private String outputGaugePressureRequired;
    @Size(max = 50)
    @Column(name = "ADJUSTMENT_FACTOR")
    private String adjustmentFactor;
    @Size(max = 50)
    @Column(name = "CALIBRATION_DUE")
    private String calibrationDue;
    @Size(max = 50)
    @Column(name = "RAM_MODEL")
    private String ramModel;
    @Size(max = 50)
    @Column(name = "RAM_TYPE")
    private String ramType;
    @Size(max = 50)
    @Column(name = "FULLY_STROKED_RAM_LENGTH")
    private String fullyStrokedRamLength;
    @Size(max = 50)
    @Column(name = "WEDGE_PLATE_THICKNESS")
    private String wedgePlateThickness;
    @Size(max = 50)
    @Column(name = "JACKING_CHAIR_LENGTH")
    private String jackingChairLength;
    @Size(max = 50)
    @Column(name = "INPUT_JACKING_FORCE")
    private String inputJackingForce;
    @Size(max = 50)
    @Column(name = "PCT_MAXIMUM_JACKING_FORCE1")
    private String pctMaximumJackingForce1;
    @Size(max = 50)
    @Column(name = "GAUGE_PRESSURE_REQUIRED1")
    private String gaugePressureRequired1;
    @Size(max = 50)
    @Column(name = "PCT_MAXIMUM_JACKING_FORCE2")
    private String pctMaximumJackingForce2;
    @Size(max = 50)
    @Column(name = "GAUGE_PRESSURE_REQUIRED2")
    private String gaugePressureRequired2;
    @Size(max = 50)
    @Column(name = "PCT_MAXIMUM_JACKING_FORCE3")
    private String pctMaximumJackingForce3;
    @Size(max = 50)
    @Column(name = "GAUGE_PRESSURE_REQUIRED3")
    private String gaugePressureRequired3;
    @Size(max = 50)
    @Column(name = "PCT_MAXIMUM_JACKING_FORCE4")
    private String pctMaximumJackingForce4;
    @Size(max = 50)
    @Column(name = "GAUGE_PRESSURE_REQUIRED4")
    private String gaugePressureRequired4;
    @Size(max = 50)
    @Column(name = "PCT_MAXIMUM_JACKING_FORCE5")
    private String pctMaximumJackingForce5;
    @Size(max = 50)
    @Column(name = "GAUGE_PRESSURE_REQUIRED5")
    private String gaugePressureRequired5;
    @Size(max = 50)
    @Column(name = "INPUT_GAUGE_PRESSURE_REQUIRED")
    private String inputGaugePressureRequired;
    @Size(max = 50)
    @Column(name = "OUTPUT_JACKING_FORCE")
    private String outputJackingForce;
    @Size(max = 50)
    @Column(name = "AVG_EADJUSTED")
    private String avgEadjusted;
    @Size(max = 50)
    @Column(name = "AVG_EPLAN_SEATED")
    private String avgEplanSeated;
    @Size(max = 50)
    @Column(name = "AVG_EADJUSTED_EPLAN_SEATED")
    private String avgEadjustedEplanSeated;
    @Size(max = 50)
    @Column(name = "ACTUAL_JACKING_FORCE")
    private String actualJackingForce;
    @Size(max = 50)
    @Column(name = "COIL_LENGTH_USED")
    private String coilLengthUsed;
    @Size(max = 50)
    @Column(name = "COMPARISON_FACTOR")
    private String comparisonFactor;
    @Size(max = 50)
    @Column(name = "DEAD_END_SEATING")
    private String deadEndSeating;
    @Size(max = 50)
    @Column(name = "DEAD_END_SEATING_PART")
    private String deadEndSeatingPart;
    @Size(max = 50)
    @Column(name = "DEAD_END_SEATING_WHOLE")
    private String deadEndSeatingWhole;
    @Size(max = 50)
    @Column(name = "EADJUSTED")
    private String eadjusted;
    @Size(max = 50)
    @Column(name = "EADJUSTED_EPLAN_SEATED")
    private String eadjustedEplanSeated;
    @Size(max = 512)
    @Column(name = "TENDON_DESIGNATION")
    private String tendonDesignation;

    public ScbStressing() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    public Character getApplyForAllStrands() {
        return applyForAllStrands;
    }

    public void setApplyForAllStrands(Character applyForAllStrands) {
        this.applyForAllStrands = applyForAllStrands;
    }

    public Character getAllStrandsStressedTogether() {
        return allStrandsStressedTogether;
    }

    public void setAllStrandsStressedTogether(Character allStrandsStressedTogether) {
        this.allStrandsStressedTogether = allStrandsStressedTogether;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public BigDecimal getTendonDesignLength() {
        return tendonDesignLength;
    }

    public void setTendonDesignLength(BigDecimal tendonDesignLength) {
        this.tendonDesignLength = tendonDesignLength;
    }

    public BigInteger getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigInteger numPoints) {
        this.numPoints = numPoints;
    }

    public BigInteger getTestNo() {
        return testNo;
    }

    public void setTestNo(BigInteger testNo) {
        this.testNo = testNo;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getOutCoilId() {
        return outCoilId;
    }

    public void setOutCoilId(BigInteger outCoilId) {
        this.outCoilId = outCoilId;
    }

    public BigInteger getOutEquipRamCalibId() {
        return outEquipRamCalibId;
    }

    public void setOutEquipRamCalibId(BigInteger outEquipRamCalibId) {
        this.outEquipRamCalibId = outEquipRamCalibId;
    }

    public BigInteger getEquipRamCalibId() {
        return equipRamCalibId;
    }

    public void setEquipRamCalibId(BigInteger equipRamCalibId) {
        this.equipRamCalibId = equipRamCalibId;
    }

    public BigInteger getCoilId() {
        return coilId;
    }

    public void setCoilId(BigInteger coilId) {
        this.coilId = coilId;
    }

    public BigInteger getTendonDesignId() {
        return tendonDesignId;
    }

    public void setTendonDesignId(BigInteger tendonDesignId) {
        this.tendonDesignId = tendonDesignId;
    }

    public String getRamGaugeNo() {
        return ramGaugeNo;
    }

    public void setRamGaugeNo(String ramGaugeNo) {
        this.ramGaugeNo = ramGaugeNo;
    }

    public String getTestnoNolink() {
        return testnoNolink;
    }

    public void setTestnoNolink(String testnoNolink) {
        this.testnoNolink = testnoNolink;
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testno) && testno.contains("../../")) {
            return testno.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testno;
    }

    public String getReportNoLink() {
        return reportNoLink;
    }

    public void setReportNoLink(String reportNoLink) {
        this.reportNoLink = reportNoLink;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getSegmentLocation() {
        return segmentLocation;
    }

    public void setSegmentLocation(String segmentLocation) {
        this.segmentLocation = segmentLocation;
    }

    public String getTendonType() {
        return tendonType;
    }

    public void setTendonType(String tendonType) {
        this.tendonType = tendonType;
    }

    public String geteBeforeAnchorSet() {
        return eBeforeAnchorSet;
    }

    public void seteBeforeAnchorSet(String eBeforeAnchorSet) {
        this.eBeforeAnchorSet = eBeforeAnchorSet;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrandDesignation() {
        return strandDesignation;
    }

    public void setStrandDesignation(String strandDesignation) {
        this.strandDesignation = strandDesignation;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEnet() {
        return enet;
    }

    public void setEnet(String enet) {
        this.enet = enet;
    }

    public String getEnet80() {
        return enet80;
    }

    public void setEnet80(String enet80) {
        this.enet80 = enet80;
    }

    public String getEplanSeated() {
        return eplanSeated;
    }

    public void setEplanSeated(String eplanSeated) {
        this.eplanSeated = eplanSeated;
    }

    public String geteValue() {
        return eValue;
    }

    public void seteValue(String eValue) {
        this.eValue = eValue;
    }

    public String getForceAdjustment() {
        return forceAdjustment;
    }

    public void setForceAdjustment(String forceAdjustment) {
        this.forceAdjustment = forceAdjustment;
    }

    public String getOutInputGpRequired() {
        return outInputGpRequired;
    }

    public void setOutInputGpRequired(String outInputGpRequired) {
        this.outInputGpRequired = outInputGpRequired;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public String getJackingEnd() {
        return jackingEnd;
    }

    public void setJackingEnd(String jackingEnd) {
        this.jackingEnd = jackingEnd;
    }

    public String getJackingModeUsed() {
        return jackingModeUsed;
    }

    public void setJackingModeUsed(String jackingModeUsed) {
        this.jackingModeUsed = jackingModeUsed;
    }

    public String getLeSeatingPart() {
        return leSeatingPart;
    }

    public void setLeSeatingPart(String leSeatingPart) {
        this.leSeatingPart = leSeatingPart;
    }

    public String getLeSeatingTotal() {
        return leSeatingTotal;
    }

    public void setLeSeatingTotal(String leSeatingTotal) {
        this.leSeatingTotal = leSeatingTotal;
    }

    public String getLeSeatingWhole() {
        return leSeatingWhole;
    }

    public void setLeSeatingWhole(String leSeatingWhole) {
        this.leSeatingWhole = leSeatingWhole;
    }

    public String getLiveEndSeating() {
        return liveEndSeating;
    }

    public void setLiveEndSeating(String liveEndSeating) {
        this.liveEndSeating = liveEndSeating;
    }

    public String getLiveEndSeatingPart() {
        return liveEndSeatingPart;
    }

    public void setLiveEndSeatingPart(String liveEndSeatingPart) {
        this.liveEndSeatingPart = liveEndSeatingPart;
    }

    public String getLiveEndSeatingWhole() {
        return liveEndSeatingWhole;
    }

    public void setLiveEndSeatingWhole(String liveEndSeatingWhole) {
        this.liveEndSeatingWhole = liveEndSeatingWhole;
    }

    public String getStrandNo() {
        return strandNo;
    }

    public void setStrandNo(String strandNo) {
        this.strandNo = strandNo;
    }

    public String getStressingDateTime() {
        return stressingDateTime;
    }

    public void setStressingDateTime(String stressingDateTime) {
        this.stressingDateTime = stressingDateTime;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getTotalJackingLoss() {
        return totalJackingLoss;
    }

    public void setTotalJackingLoss(String totalJackingLoss) {
        this.totalJackingLoss = totalJackingLoss;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getNumberOfStrandsBars() {
        return numberOfStrandsBars;
    }

    public void setNumberOfStrandsBars(String numberOfStrandsBars) {
        this.numberOfStrandsBars = numberOfStrandsBars;
    }

    public String getNominalDia() {
        return nominalDia;
    }

    public void setNominalDia(String nominalDia) {
        this.nominalDia = nominalDia;
    }

    public String getAreadesign() {
        return areadesign;
    }

    public void setAreadesign(String areadesign) {
        this.areadesign = areadesign;
    }

    public String getEmoddesign() {
        return emoddesign;
    }

    public void setEmoddesign(String emoddesign) {
        this.emoddesign = emoddesign;
    }

    public String getJackingForce() {
        return jackingForce;
    }

    public void setJackingForce(String jackingForce) {
        this.jackingForce = jackingForce;
    }

    public String getJackingModeDesign() {
        return jackingModeDesign;
    }

    public void setJackingModeDesign(String jackingModeDesign) {
        this.jackingModeDesign = jackingModeDesign;
    }

    public String getJackingEndDesign() {
        return jackingEndDesign;
    }

    public void setJackingEndDesign(String jackingEndDesign) {
        this.jackingEndDesign = jackingEndDesign;
    }

    public String getCoilNo() {
        return coilNo;
    }

    public void setCoilNo(String coilNo) {
        this.coilNo = coilNo;
    }

    public String getHeatId() {
        return heatId;
    }

    public void setHeatId(String heatId) {
        this.heatId = heatId;
    }

    public String getAreaactual() {
        return areaactual;
    }

    public void setAreaactual(String areaactual) {
        this.areaactual = areaactual;
    }

    public String getLengthActualCoil() {
        return lengthActualCoil;
    }

    public void setLengthActualCoil(String lengthActualCoil) {
        this.lengthActualCoil = lengthActualCoil;
    }

    public String getEmodactual() {
        return emodactual;
    }

    public void setEmodactual(String emodactual) {
        this.emodactual = emodactual;
    }

    public String getOutputGaugePressureRequired() {
        return outputGaugePressureRequired;
    }

    public void setOutputGaugePressureRequired(String outputGaugePressureRequired) {
        this.outputGaugePressureRequired = outputGaugePressureRequired;
    }

    public String getAdjustmentFactor() {
        return adjustmentFactor;
    }

    public void setAdjustmentFactor(String adjustmentFactor) {
        this.adjustmentFactor = adjustmentFactor;
    }

    public String getCalibrationDue() {
        return calibrationDue;
    }

    public void setCalibrationDue(String calibrationDue) {
        this.calibrationDue = calibrationDue;
    }

    public String getRamModel() {
        return ramModel;
    }

    public void setRamModel(String ramModel) {
        this.ramModel = ramModel;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getFullyStrokedRamLength() {
        return fullyStrokedRamLength;
    }

    public void setFullyStrokedRamLength(String fullyStrokedRamLength) {
        this.fullyStrokedRamLength = fullyStrokedRamLength;
    }

    public String getWedgePlateThickness() {
        return wedgePlateThickness;
    }

    public void setWedgePlateThickness(String wedgePlateThickness) {
        this.wedgePlateThickness = wedgePlateThickness;
    }

    public String getJackingChairLength() {
        return jackingChairLength;
    }

    public void setJackingChairLength(String jackingChairLength) {
        this.jackingChairLength = jackingChairLength;
    }

    public String getInputJackingForce() {
        return inputJackingForce;
    }

    public void setInputJackingForce(String inputJackingForce) {
        this.inputJackingForce = inputJackingForce;
    }

    public String getPctMaximumJackingForce1() {
        return pctMaximumJackingForce1;
    }

    public void setPctMaximumJackingForce1(String pctMaximumJackingForce1) {
        this.pctMaximumJackingForce1 = pctMaximumJackingForce1;
    }

    public String getGaugePressureRequired1() {
        return gaugePressureRequired1;
    }

    public void setGaugePressureRequired1(String gaugePressureRequired1) {
        this.gaugePressureRequired1 = gaugePressureRequired1;
    }

    public String getPctMaximumJackingForce2() {
        return pctMaximumJackingForce2;
    }

    public void setPctMaximumJackingForce2(String pctMaximumJackingForce2) {
        this.pctMaximumJackingForce2 = pctMaximumJackingForce2;
    }

    public String getGaugePressureRequired2() {
        return gaugePressureRequired2;
    }

    public void setGaugePressureRequired2(String gaugePressureRequired2) {
        this.gaugePressureRequired2 = gaugePressureRequired2;
    }

    public String getPctMaximumJackingForce3() {
        return pctMaximumJackingForce3;
    }

    public void setPctMaximumJackingForce3(String pctMaximumJackingForce3) {
        this.pctMaximumJackingForce3 = pctMaximumJackingForce3;
    }

    public String getGaugePressureRequired3() {
        return gaugePressureRequired3;
    }

    public void setGaugePressureRequired3(String gaugePressureRequired3) {
        this.gaugePressureRequired3 = gaugePressureRequired3;
    }

    public String getPctMaximumJackingForce4() {
        return pctMaximumJackingForce4;
    }

    public void setPctMaximumJackingForce4(String pctMaximumJackingForce4) {
        this.pctMaximumJackingForce4 = pctMaximumJackingForce4;
    }

    public String getGaugePressureRequired4() {
        return gaugePressureRequired4;
    }

    public void setGaugePressureRequired4(String gaugePressureRequired4) {
        this.gaugePressureRequired4 = gaugePressureRequired4;
    }

    public String getPctMaximumJackingForce5() {
        return pctMaximumJackingForce5;
    }

    public void setPctMaximumJackingForce5(String pctMaximumJackingForce5) {
        this.pctMaximumJackingForce5 = pctMaximumJackingForce5;
    }

    public String getGaugePressureRequired5() {
        return gaugePressureRequired5;
    }

    public void setGaugePressureRequired5(String gaugePressureRequired5) {
        this.gaugePressureRequired5 = gaugePressureRequired5;
    }

    public String getInputGaugePressureRequired() {
        return inputGaugePressureRequired;
    }

    public void setInputGaugePressureRequired(String inputGaugePressureRequired) {
        this.inputGaugePressureRequired = inputGaugePressureRequired;
    }

    public String getOutputJackingForce() {
        return outputJackingForce;
    }

    public void setOutputJackingForce(String outputJackingForce) {
        this.outputJackingForce = outputJackingForce;
    }

    public String getAvgEadjusted() {
        return avgEadjusted;
    }

    public void setAvgEadjusted(String avgEadjusted) {
        this.avgEadjusted = avgEadjusted;
    }

    public String getAvgEplanSeated() {
        return avgEplanSeated;
    }

    public void setAvgEplanSeated(String avgEplanSeated) {
        this.avgEplanSeated = avgEplanSeated;
    }

    public String getAvgEadjustedEplanSeated() {
        return avgEadjustedEplanSeated;
    }

    public void setAvgEadjustedEplanSeated(String avgEadjustedEplanSeated) {
        this.avgEadjustedEplanSeated = avgEadjustedEplanSeated;
    }

    public String getActualJackingForce() {
        return actualJackingForce;
    }

    public void setActualJackingForce(String actualJackingForce) {
        this.actualJackingForce = actualJackingForce;
    }

    public String getCoilLengthUsed() {
        return coilLengthUsed;
    }

    public void setCoilLengthUsed(String coilLengthUsed) {
        this.coilLengthUsed = coilLengthUsed;
    }

    public String getComparisonFactor() {
        return comparisonFactor;
    }

    public void setComparisonFactor(String comparisonFactor) {
        this.comparisonFactor = comparisonFactor;
    }

    public String getDeadEndSeating() {
        return deadEndSeating;
    }

    public void setDeadEndSeating(String deadEndSeating) {
        this.deadEndSeating = deadEndSeating;
    }

    public String getDeadEndSeatingPart() {
        return deadEndSeatingPart;
    }

    public void setDeadEndSeatingPart(String deadEndSeatingPart) {
        this.deadEndSeatingPart = deadEndSeatingPart;
    }

    public String getDeadEndSeatingWhole() {
        return deadEndSeatingWhole;
    }

    public void setDeadEndSeatingWhole(String deadEndSeatingWhole) {
        this.deadEndSeatingWhole = deadEndSeatingWhole;
    }

    public String getEadjusted() {
        return eadjusted;
    }

    public void setEadjusted(String eadjusted) {
        this.eadjusted = eadjusted;
    }

    public String getEadjustedEplanSeated() {
        return eadjustedEplanSeated;
    }

    public void setEadjustedEplanSeated(String eadjustedEplanSeated) {
        this.eadjustedEplanSeated = eadjustedEplanSeated;
    }

    public String getTendonDesignation() {
        return tendonDesignation;
    }

    public void setTendonDesignation(String tendonDesignation) {
        this.tendonDesignation = tendonDesignation;
    }

}
