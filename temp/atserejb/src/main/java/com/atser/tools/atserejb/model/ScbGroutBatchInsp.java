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
@Table(name = "SCB_GROUTBATCHINSP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbGroutBatchInsp.findAll", query = "SELECT a FROM ScbGroutBatchInsp a")})
public class ScbGroutBatchInsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "TEST_NO")
    private BigInteger testNo;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "NUM_POINTS")
    private BigInteger numPoints;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 50)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Size(max = 200)
    @Column(name = "MIXER_SRNO")
    private String mixerSrno;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @JsonSkipXssSerialization
    @Size(max = 141)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "BATCHNO")
    private String batchno;
    @Size(max = 50)
    @Column(name = "LOTNO")
    private String lotno;
    @Size(max = 50)
    @Column(name = "NO_OF_BAGS")
    private String noOfBags;
    @Size(max = 50)
    @Column(name = "BIN_NUMBER")
    private String binNumber;
    @Size(max = 50)
    @Column(name = "TOTAL_GROUT")
    private String totalGrout;
    @Size(max = 50)
    @Column(name = "TOTAL_BAGS")
    private String totalBags;
    @Size(max = 50)
    @Column(name = "ICE")
    private String ice;
    @Size(max = 50)
    @Column(name = "WATER_INITIAL_READING")
    private String waterInitialReading;
    @Size(max = 50)
    @Column(name = "WATER_FINAL_READING")
    private String waterFinalReading;
    @Size(max = 50)
    @Column(name = "WATER_ADDED")
    private String waterAdded;
    @Size(max = 50)
    @Column(name = "TOTAL_WATER")
    private String totalWater;
    @Size(max = 50)
    @Column(name = "WATER_CEMENT_RATIO")
    private String waterCementRatio;
    @Size(max = 50)
    @Column(name = "CONTRACT_NO")
    private String contractNo;
    @Size(max = 50)
    @Column(name = "NOTICE")
    private String notice;
    @Column(name = "REJECTED")
    private Character rejected;

    public ScbGroutBatchInsp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
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

    public BigInteger getTestNo() {
        return testNo;
    }

    public void setTestNo(BigInteger testNo) {
        this.testNo = testNo;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigInteger getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigInteger numPoints) {
        this.numPoints = numPoints;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getMixerSrno() {
        return mixerSrno;
    }

    public void setMixerSrno(String mixerSrno) {
        this.mixerSrno = mixerSrno;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getLotno() {
        return lotno;
    }

    public void setLotno(String lotno) {
        this.lotno = lotno;
    }

    public String getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(String noOfBags) {
        this.noOfBags = noOfBags;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getTotalGrout() {
        return totalGrout;
    }

    public void setTotalGrout(String totalGrout) {
        this.totalGrout = totalGrout;
    }

    public String getTotalBags() {
        return totalBags;
    }

    public void setTotalBags(String totalBags) {
        this.totalBags = totalBags;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getWaterInitialReading() {
        return waterInitialReading;
    }

    public void setWaterInitialReading(String waterInitialReading) {
        this.waterInitialReading = waterInitialReading;
    }

    public String getWaterFinalReading() {
        return waterFinalReading;
    }

    public void setWaterFinalReading(String waterFinalReading) {
        this.waterFinalReading = waterFinalReading;
    }

    public String getWaterAdded() {
        return waterAdded;
    }

    public void setWaterAdded(String waterAdded) {
        this.waterAdded = waterAdded;
    }

    public String getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(String totalWater) {
        this.totalWater = totalWater;
    }

    public String getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(String waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Character getRejected() {
        return rejected;
    }

    public void setRejected(Character rejected) {
        this.rejected = rejected;
    }

}
