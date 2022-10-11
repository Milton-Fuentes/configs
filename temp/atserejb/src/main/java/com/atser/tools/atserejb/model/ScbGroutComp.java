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
@Table(name = "SCB_GROUTCOMP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbGroutComp.findAll", query = "SELECT a FROM ScbGroutComp a")})
public class ScbGroutComp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 255)
    @Column(name = "DRAFT")
    private String draft;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
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
    @Size(max = 50)
    @Column(name = "CYLINDER_NO")
    private String cylinderNo;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Column(name = "TESTAGE")
    private BigInteger testage;
    @Size(max = 50)
    @Column(name = "LENGTH")
    private String length;
    @Size(max = 50)
    @Column(name = "WIDTH")
    private String width;
    @Size(max = 50)
    @Column(name = "HEIGHT")
    private String height;
    @Size(max = 50)
    @Column(name = "MAXIMUMLOAD")
    private String maximumload;
    @Column(name = "COMPRESSIVESTRENGTH")
    private BigInteger compressivestrength;
    @Column(name = "SPECIFIEDSTRENGTH")
    private BigInteger specifiedstrength;
    @Size(max = 50)
    @Column(name = "TECH")
    private String tech;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigInteger qaSampleId;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "CLASS_ID")
    private BigInteger classId;
    @Size(max = 50)
    @Column(name = "LAB_FUNCTION")
    private String labFunction;
    @Size(max = 250)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 250)
    @Column(name = "ITEM_MAT")
    private String itemMat;
    @Size(max = 250)
    @Column(name = "ITEM_CLASS")
    private String itemClass;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 12)
    @Column(name = "BATCH_SIZE")
    private String batchSize;
    @Column(name = "COMPSTR28DAY")
    private BigInteger compstr28day;
    @Column(name = "AVG28DAY_STRENGTH")
    private BigInteger avg28dayStrength;
    @JsonSkipXssSerialization
    @Size(max = 235)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 50)
    @Column(name = "APPVD")
    private String appvd;
    @Size(max = 20)
    @Column(name = "TESTCONTROL")
    private String testcontrol;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN_SP")
    private String sampleTcnSp;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "LOTNO")
    private BigInteger lotno;
    @Column(name = "SUBLOTNO")
    private BigInteger sublotno;
    @Size(max = 100)
    @Column(name = "TICKET_NO")
    private String ticketno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "SAMPLENO")
    private String sampleno;
    @Column(name = "REPORTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportdate;
    @Column(name = "TESTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testdate;
    @Size(max = 50)
    @Column(name = "SAMPLESPERSET")
    private String samplesperset;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "SAMPLEIDNO")
    private String sampleidno;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 50)
    @Column(name = "COMPANYID")
    private String companyid;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "LABID")
    private String labid;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "STATION")
    private String station;

    public ScbGroutComp() {
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

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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

    public String getCylinderNo() {
        return cylinderNo;
    }

    public void setCylinderNo(String cylinderNo) {
        this.cylinderNo = cylinderNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public BigInteger getTestage() {
        return testage;
    }

    public void setTestage(BigInteger testage) {
        this.testage = testage;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMaximumload() {
        return maximumload;
    }

    public void setMaximumload(String maximumload) {
        this.maximumload = maximumload;
    }

    public BigInteger getCompressivestrength() {
        return compressivestrength;
    }

    public void setCompressivestrength(BigInteger compressivestrength) {
        this.compressivestrength = compressivestrength;
    }

    public BigInteger getSpecifiedstrength() {
        return specifiedstrength;
    }

    public void setSpecifiedstrength(BigInteger specifiedstrength) {
        this.specifiedstrength = specifiedstrength;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public BigInteger getMatId() {
        return matId;
    }

    public void setMatId(BigInteger matId) {
        this.matId = matId;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemMat() {
        return itemMat;
    }

    public void setItemMat(String itemMat) {
        this.itemMat = itemMat;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public BigInteger getCompstr28day() {
        return compstr28day;
    }

    public void setCompstr28day(BigInteger compstr28day) {
        this.compstr28day = compstr28day;
    }

    public BigInteger getAvg28dayStrength() {
        return avg28dayStrength;
    }

    public void setAvg28dayStrength(BigInteger avg28dayStrength) {
        this.avg28dayStrength = avg28dayStrength;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getAppvd() {
        return appvd;
    }

    public void setAppvd(String appvd) {
        this.appvd = appvd;
    }

    public String getTestcontrol() {
        return testcontrol;
    }

    public void setTestcontrol(String testcontrol) {
        this.testcontrol = testcontrol;
    }

    public String getSampleTcnSp() {
        return sampleTcnSp;
    }

    public void setSampleTcnSp(String sampleTcnSp) {
        this.sampleTcnSp = sampleTcnSp;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public BigInteger getLotno() {
        return lotno;
    }

    public void setLotno(BigInteger lotno) {
        this.lotno = lotno;
    }

    public BigInteger getSublotno() {
        return sublotno;
    }

    public void setSublotno(BigInteger sublotno) {
        this.sublotno = sublotno;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getSampleno() {
        return sampleno;
    }

    public void setSampleno(String sampleno) {
        this.sampleno = sampleno;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public String getSamplesperset() {
        return samplesperset;
    }

    public void setSamplesperset(String samplesperset) {
        this.samplesperset = samplesperset;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getSampleidno() {
        return sampleidno;
    }

    public void setSampleidno(String sampleidno) {
        this.sampleidno = sampleidno;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

}
