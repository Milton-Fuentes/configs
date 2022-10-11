/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "SCB_GROUTWICK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbGroutWick.findAll", query = "SELECT a FROM ScbGroutWick a")})
public class ScbGroutWick implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
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
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigInteger qaSampleId;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @JsonSkipXssSerialization
    @Size(max = 389)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN_SP")
    private String sampleTcnSp;
    @Size(max = 50)
    @Column(name = "INITIAL_GROUT_VOLUME")
    private String initialGroutVolume;
    @Size(max = 50)
    @Column(name = "LEVEL_UPPER_SURFACE_START")
    private String levelUpperSurfaceStart;
    @Size(max = 50)
    @Column(name = "FINAL_BLEED_VOLUME")
    private String finalBleedVolume;
    @Size(max = 50)
    @Column(name = "FINAL_BLEEDING_PCT")
    private String finalBleedingPct;
    @Size(max = 50)
    @Column(name = "TIME_INTERVAL")
    private String timeInterval;
    @Size(max = 50)
    @Column(name = "UPPER_SURF_BLEED_WATER_LEVEL")
    private String upperSurfBleedWaterLevel;
    @Size(max = 50)
    @Column(name = "UPPER_SURF_GROUT_LEVEL")
    private String upperSurfGroutLevel;
    @Size(max = 50)
    @Column(name = "TIME_INTERVAL_BLEED_VOLUME")
    private String timeIntervalBleedVolume;
    @Size(max = 50)
    @Column(name = "TIME_INTERVAL_BLEEDING_PCT")
    private String timeIntervalBleedPct;
    @Size(max = 50)
    @Column(name = "SPECIFICATION_REQUIREMENT")
    private String specificationRequirement;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;

    public ScbGroutWick() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
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

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
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

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(BigInteger qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getSampleTcnSp() {
        return sampleTcnSp;
    }

    public void setSampleTcnSp(String sampleTcnSp) {
        this.sampleTcnSp = sampleTcnSp;
    }

    public String getInitialGroutVolume() {
        return initialGroutVolume;
    }

    public void setInitialGroutVolume(String initialGroutVolume) {
        this.initialGroutVolume = initialGroutVolume;
    }

    public String getLevelUpperSurfaceStart() {
        return levelUpperSurfaceStart;
    }

    public void setLevelUpperSurfaceStart(String levelUpperSurfaceStart) {
        this.levelUpperSurfaceStart = levelUpperSurfaceStart;
    }

    public String getFinalBleedVolume() {
        return finalBleedVolume;
    }

    public void setFinalBleedVolume(String finalBleedVolume) {
        this.finalBleedVolume = finalBleedVolume;
    }

    public String getFinalBleedingPct() {
        return finalBleedingPct;
    }

    public void setFinalBleedingPct(String finalBleedingPct) {
        this.finalBleedingPct = finalBleedingPct;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getUpperSurfBleedWaterLevel() {
        return upperSurfBleedWaterLevel;
    }

    public void setUpperSurfBleedWaterLevel(String upperSurfBleedWaterLevel) {
        this.upperSurfBleedWaterLevel = upperSurfBleedWaterLevel;
    }

    public String getUpperSurfGroutLevel() {
        return upperSurfGroutLevel;
    }

    public void setUpperSurfGroutLevel(String upperSurfGroutLevel) {
        this.upperSurfGroutLevel = upperSurfGroutLevel;
    }

    public String getTimeIntervalBleedVolume() {
        return timeIntervalBleedVolume;
    }

    public void setTimeIntervalBleedVolume(String timeIntervalBleedVolume) {
        this.timeIntervalBleedVolume = timeIntervalBleedVolume;
    }

    public String getTimeIntervalBleedPct() {
        return timeIntervalBleedPct;
    }

    public void setTimeIntervalBleedPct(String timeIntervalBleedPct) {
        this.timeIntervalBleedPct = timeIntervalBleedPct;
    }

    public String getSpecificationRequirement() {
        return specificationRequirement;
    }

    public void setSpecificationRequirement(String specificationRequirement) {
        this.specificationRequirement = specificationRequirement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
