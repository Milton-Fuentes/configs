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
import java.math.BigInteger;
import java.util.Date;
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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author mfuentes
 */
@Entity
@Immutable
@Table(name = "DOT_AIRCONTENT_T152", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotAircontentT152.findAll", query = "SELECT a FROM DotAircontentT152 a")})
public class DotAircontentT152 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "PROJECT_ID")
    private String projectId;
    @Column(name = "SUBBIDITEM_ID")
    private String subbiditemId;
    @Column(name = "MIX_DESIGN_ID")
    private String mixDesignId;
    @Column(name = "CLIENT_ID")
    private String clientId;
    @Column(name = "TEST_ID")
    private String testId;
    @Column(name = "LAB_ID")
    private String labId;
    @Column(name = "BIDITEM_ID")
    private String biditemId;
    @Column(name = "QA_SAMPLE_ID")
    private String qaSampleId;
    @Column(name = "REQ_AIRCONT_SPEC_MAX")
    private String reqAircontSpecMax;
    @Column(name = "REQ_AIRCONT_SPEC_MIN")
    private String reqAircontSpecMin;
    @JsonSkipXssSerialization
    @Size(max = 197)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "AIRCONTENT_SPEC_MAX")
    private String aircontentSpecMax;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "CORR_AIRCONTENT")
    private String corrAircontent;
    @Size(max = 50)
    @Column(name = "CORR_FACTOR")
    private String corrFactor;
    @Size(max = 50)
    @Column(name = "AIRCONTENT")
    private String aircontent;
    @Size(max = 50)
    @Column(name = "AIRCONTENT_SPEC_MIN")
    private String aircontentSpecMin;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotAircontentT152() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(String subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public String getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(String mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(String biditemId) {
        this.biditemId = biditemId;
    }

    public String getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(String qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public String getReqAircontSpecMax() {
        return reqAircontSpecMax;
    }

    public void setReqAircontSpecMax(String reqAircontSpecMax) {
        this.reqAircontSpecMax = reqAircontSpecMax;
    }

    public String getReqAircontSpecMin() {
        return reqAircontSpecMin;
    }

    public void setReqAircontSpecMin(String reqAircontSpecMin) {
        this.reqAircontSpecMin = reqAircontSpecMin;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
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

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
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

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getAircontentSpecMax() {
        return aircontentSpecMax;
    }

    public void setAircontentSpecMax(String aircontentSpecMax) {
        this.aircontentSpecMax = aircontentSpecMax;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getCorrAircontent() {
        return corrAircontent;
    }

    public void setCorrAircontent(String corrAircontent) {
        this.corrAircontent = corrAircontent;
    }

    public String getCorrFactor() {
        return corrFactor;
    }

    public void setCorrFactor(String corrFactor) {
        this.corrFactor = corrFactor;
    }

    public String getAircontent() {
        return aircontent;
    }

    public void setAircontent(String aircontent) {
        this.aircontent = aircontent;
    }

    public String getAircontentSpecMin() {
        return aircontentSpecMin;
    }

    public void setAircontentSpecMin(String aircontentSpecMin) {
        this.aircontentSpecMin = aircontentSpecMin;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public void setSubbiditemDescript(String subbiditemDescript) {
        this.subbiditemDescript = subbiditemDescript;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public void setBiditemDescript(String biditemDescript) {
        this.biditemDescript = biditemDescript;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
