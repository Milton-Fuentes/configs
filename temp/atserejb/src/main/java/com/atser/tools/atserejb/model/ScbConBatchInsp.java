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
@Table(name = "SCB_CONBATCHINSP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbConBatchInsp.findAll", query = "SELECT a FROM ScbConBatchInsp a")})
public class ScbConBatchInsp implements Serializable {

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
    @Size(max = 255)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @JsonSkipXssSerialization
    @Size(max = 50)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 100)
    @Column(name = "TICKETNO")
    private String ticketno;
    @Size(max = 100)
    @Column(name = "TRUCKNO")
    private String truckno;
    @Size(max = 50)
    @Column(name = "BATCHTIME")
    private String batchtime;
    @Size(max = 50)
    @Column(name = "VOLUME")
    private String volume;
    @Size(max = 50)
    @Column(name = "TOTAL_CU_YD")
    private String totalCuYd;
    @Size(max = 50)
    @Column(name = "CEMENT")
    private String cement;
    @Size(max = 50)
    @Column(name = "FLYASH")
    private String flyash;
    @Size(max = 50)
    @Column(name = "TOTAL_CEMENTITIOUS")
    private String totalCementitious;
    @Size(max = 255)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Size(max = 50)
    @Column(name = "COARSE_AGG")
    private String coarseAgg;
    @Size(max = 50)
    @Column(name = "FINE_AGG")
    private String fineAgg;
    @Size(max = 50)
    @Column(name = "TOTAL_AGG")
    private String totalAgg;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_MOIST")
    private String coarseAggMoist;
    @Size(max = 50)
    @Column(name = "FINE_AGG_MOIST")
    private String fineAggMoist;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_WATER")
    private String coarseAggWater;
    @Size(max = 50)
    @Column(name = "FINE_AGG_WATER")
    private String fineAggWater;
    @Size(max = 50)
    @Column(name = "ICE")
    private String ice;
    @Size(max = 50)
    @Column(name = "WATER_ADDED")
    private String waterAdded;
    @Size(max = 50)
    @Column(name = "TOTAL_WATER")
    private String totalWater;
    @Size(max = 50)
    @Column(name = "ADMIX1")
    private String admix1;
    @Size(max = 50)
    @Column(name = "ADMIX2")
    private String admix2;
    @Size(max = 50)
    @Column(name = "ADMIX3")
    private String admix3;
    @Size(max = 50)
    @Column(name = "WATER_CEMENT_RATIO")
    private String waterCementRatio;
    @Size(max = 50)
    @Column(name = "CONTRACT_NO")
    private String contractNo;
    @Size(max = 50)
    @Column(name = "NOTICE")
    private String notice;
    @Size(max = 50)
    @Column(name = "WATER_WITHHELD")
    private String waterWithheld;
    @Column(name = "REJECTED")
    private Character rejected;

    public ScbConBatchInsp() {
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

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
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

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getTruckno() {
        return truckno;
    }

    public void setTruckno(String truckno) {
        this.truckno = truckno;
    }

    public String getBatchtime() {
        return batchtime;
    }

    public void setBatchtime(String batchtime) {
        this.batchtime = batchtime;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTotalCuYd() {
        return totalCuYd;
    }

    public void setTotalCuYd(String totalCuYd) {
        this.totalCuYd = totalCuYd;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getFlyash() {
        return flyash;
    }

    public void setFlyash(String flyash) {
        this.flyash = flyash;
    }

    public String getTotalCementitious() {
        return totalCementitious;
    }

    public void setTotalCementitious(String totalCementitious) {
        this.totalCementitious = totalCementitious;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCoarseAgg() {
        return coarseAgg;
    }

    public void setCoarseAgg(String coarseAgg) {
        this.coarseAgg = coarseAgg;
    }

    public String getFineAgg() {
        return fineAgg;
    }

    public void setFineAgg(String fineAgg) {
        this.fineAgg = fineAgg;
    }

    public String getTotalAgg() {
        return totalAgg;
    }

    public void setTotalAgg(String totalAgg) {
        this.totalAgg = totalAgg;
    }

    public String getCoarseAggMoist() {
        return coarseAggMoist;
    }

    public void setCoarseAggMoist(String coarseAggMoist) {
        this.coarseAggMoist = coarseAggMoist;
    }

    public String getFineAggMoist() {
        return fineAggMoist;
    }

    public void setFineAggMoist(String fineAggMoist) {
        this.fineAggMoist = fineAggMoist;
    }

    public String getCoarseAggWater() {
        return coarseAggWater;
    }

    public void setCoarseAggWater(String coarseAggWater) {
        this.coarseAggWater = coarseAggWater;
    }

    public String getFineAggWater() {
        return fineAggWater;
    }

    public void setFineAggWater(String fineAggWater) {
        this.fineAggWater = fineAggWater;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
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

    public String getAdmix1() {
        return admix1;
    }

    public void setAdmix1(String admix1) {
        this.admix1 = admix1;
    }

    public String getAdmix2() {
        return admix2;
    }

    public void setAdmix2(String admix2) {
        this.admix2 = admix2;
    }

    public String getAdmix3() {
        return admix3;
    }

    public void setAdmix3(String admix3) {
        this.admix3 = admix3;
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

    public String getWaterWithheld() {
        return waterWithheld;
    }

    public void setWaterWithheld(String waterWithheld) {
        this.waterWithheld = waterWithheld;
    }

    public Character getRejected() {
        return rejected;
    }

    public void setRejected(Character rejected) {
        this.rejected = rejected;
    }

}
