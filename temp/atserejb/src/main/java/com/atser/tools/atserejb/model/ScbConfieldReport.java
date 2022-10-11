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
@Table(name = "SCB_CONFIELD_REPORT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbConfieldReport.findAll", query = "SELECT a FROM ScbConfieldReport a")})
public class ScbConfieldReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "QTY_REP")
    private BigDecimal qtyRep;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_NO")
    private String testNo;
    @JsonSkipXssSerialization
    @Size(max = 168)
    @Column(name = "SAMPLENO_LINK")
    private String samplenoLink;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 255)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 12)
    @Column(name = "MIX_TEMPERATURE")
    private String mixTemperature;
    @Size(max = 512)
    @Column(name = "SAMPLE_BY")
    private String sampleBy;
    @Size(max = 8)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "SLUMP")
    private BigDecimal slump;
    @Column(name = "AIRCONTENT")
    private BigDecimal aircontent;
    @Column(name = "UNITWEIGHT")
    private BigDecimal unitweight;
    @Column(name = "CEMENT")
    private BigDecimal cement;
    @Column(name = "FLYASH")
    private BigDecimal flyash;
    @Column(name = "WATER")
    private BigDecimal water;
    @Column(name = "WATERADDED")
    private BigDecimal wateradded;
    @Column(name = "FINEAGGREGATE")
    private BigDecimal fineaggregate;
    @Column(name = "COARSEAGGREGATE")
    private BigDecimal coarseaggregate;

    public ScbConfieldReport() {
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

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
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

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public BigDecimal getQtyRep() {
        return qtyRep;
    }

    public void setQtyRep(BigDecimal qtyRep) {
        this.qtyRep = qtyRep;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getSamplenoLink() {
        return samplenoLink;
    }

    public void setSamplenoLink(String samplenoLink) {
        this.samplenoLink = samplenoLink;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getMixTemperature() {
        return mixTemperature;
    }

    public void setMixTemperature(String mixTemperature) {
        this.mixTemperature = mixTemperature;
    }

    public String getSampleBy() {
        return sampleBy;
    }

    public void setSampleBy(String sampleBy) {
        this.sampleBy = sampleBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    public BigDecimal getSlump() {
        return slump;
    }

    public void setSlump(BigDecimal slump) {
        this.slump = slump;
    }

    public BigDecimal getAircontent() {
        return aircontent;
    }

    public void setAircontent(BigDecimal aircontent) {
        this.aircontent = aircontent;
    }

    public BigDecimal getUnitweight() {
        return unitweight;
    }

    public void setUnitweight(BigDecimal unitweight) {
        this.unitweight = unitweight;
    }

    public BigDecimal getCement() {
        return cement;
    }

    public void setCement(BigDecimal cement) {
        this.cement = cement;
    }

    public BigDecimal getFlyash() {
        return flyash;
    }

    public void setFlyash(BigDecimal flyash) {
        this.flyash = flyash;
    }

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(BigDecimal water) {
        this.water = water;
    }

    public BigDecimal getWateradded() {
        return wateradded;
    }

    public void setWateradded(BigDecimal wateradded) {
        this.wateradded = wateradded;
    }

    public BigDecimal getFineaggregate() {
        return fineaggregate;
    }

    public void setFineaggregate(BigDecimal fineaggregate) {
        this.fineaggregate = fineaggregate;
    }

    public BigDecimal getCoarseaggregate() {
        return coarseaggregate;
    }

    public void setCoarseaggregate(BigDecimal coarseaggregate) {
        this.coarseaggregate = coarseaggregate;
    }
    
    
}
