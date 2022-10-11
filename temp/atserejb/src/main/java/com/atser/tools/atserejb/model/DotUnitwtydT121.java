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
@Table(name = "DOT_UNITWTYD_T121", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotUnitwtydT121.findAll", query = "SELECT a FROM DotUnitwtydT121 a")})
public class DotUnitwtydT121 implements Serializable {

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
    @Column(name = "ROWNTEST")
    private Integer rowntest;
    @Column(name = "SUBBIDITEM_ID")
    private Integer subbiditemId;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "MIX_DESIGN_ID")
    private Integer mixDesignId;
    @Column(name = "TEST_ID")
    private Integer testId;
    @Column(name = "QA_SAMPLE_ID")
    private Integer qaSampleId;
    @Column(name = "LAB_ID")
    private Integer labId;
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Column(name = "BIDITEM_ID")
    private Integer biditemId;
    @Column(name = "REQ_AIRCONT_SPEC_MAX")
    private Integer reqAircontSpecMax;
    @Column(name = "REQ_AIRCONT_SPEC_MIN")
    private Integer reqAircontSpecMin;
    @JsonSkipXssSerialization
    @Size(max = 184)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 50)
    @Column(name = "VOLCON")
    private String volcon;
    @Size(max = 50)
    @Column(name = "UNITWT")
    private String unitwt;
    @Size(max = 50)
    @Column(name = "YIELDYD")
    private String yieldyd;
    @Size(max = 50)
    @Column(name = "YIELDMFT")
    private String yieldmft;
    @Size(max = 50)
    @Column(name = "YIELDMFTYD")
    private String yieldmftyd;
    @Size(max = 50)
    @Column(name = "RELYIELD")
    private String relyield;
    @Size(max = 50)
    @Column(name = "CEMENTCONTENT")
    private String cementcontent;
    @Size(max = 50)
    @Column(name = "AIRCONTENT")
    private String aircontent;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "MASSCONMEAS")
    private String massconmeas;
    @Size(max = 50)
    @Column(name = "MASSMEAS")
    private String massmeas;
    @Size(max = 50)
    @Column(name = "VOLMEAS")
    private String volmeas;
    @Size(max = 50)
    @Column(name = "TOTALMASS")
    private String totalmass;
    @Size(max = 50)
    @Column(name = "MASSCEMENT")
    private String masscement;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "AIRCONTENT_SPEC_MAX")
    private String aircontentSpecMax;
    @Size(max = 50)
    @Column(name = "AIRCONTENT_SPEC_MIN")
    private String aircontentSpecMin;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "THEOUNITWT")
    private String theounitwt;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotUnitwtydT121() {
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

    public Integer getRowntest() {
        return rowntest;
    }

    public void setRowntest(Integer rowntest) {
        this.rowntest = rowntest;
    }

    public Integer getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(Integer subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(Integer mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(Integer qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(Integer biditemId) {
        this.biditemId = biditemId;
    }

    public Integer getReqAircontSpecMax() {
        return reqAircontSpecMax;
    }

    public void setReqAircontSpecMax(Integer reqAircontSpecMax) {
        this.reqAircontSpecMax = reqAircontSpecMax;
    }

    public Integer getReqAircontSpecMin() {
        return reqAircontSpecMin;
    }

    public void setReqAircontSpecMin(Integer reqAircontSpecMin) {
        this.reqAircontSpecMin = reqAircontSpecMin;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getVolcon() {
        return volcon;
    }

    public void setVolcon(String volcon) {
        this.volcon = volcon;
    }

    public String getUnitwt() {
        return unitwt;
    }

    public void setUnitwt(String unitwt) {
        this.unitwt = unitwt;
    }

    public String getYieldyd() {
        return yieldyd;
    }

    public void setYieldyd(String yieldyd) {
        this.yieldyd = yieldyd;
    }

    public String getYieldmft() {
        return yieldmft;
    }

    public void setYieldmft(String yieldmft) {
        this.yieldmft = yieldmft;
    }

    public String getYieldmftyd() {
        return yieldmftyd;
    }

    public void setYieldmftyd(String yieldmftyd) {
        this.yieldmftyd = yieldmftyd;
    }

    public String getRelyield() {
        return relyield;
    }

    public void setRelyield(String relyield) {
        this.relyield = relyield;
    }

    public String getCementcontent() {
        return cementcontent;
    }

    public void setCementcontent(String cementcontent) {
        this.cementcontent = cementcontent;
    }

    public String getAircontent() {
        return aircontent;
    }

    public void setAircontent(String aircontent) {
        this.aircontent = aircontent;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getMassconmeas() {
        return massconmeas;
    }

    public void setMassconmeas(String massconmeas) {
        this.massconmeas = massconmeas;
    }

    public String getMassmeas() {
        return massmeas;
    }

    public void setMassmeas(String massmeas) {
        this.massmeas = massmeas;
    }

    public String getVolmeas() {
        return volmeas;
    }

    public void setVolmeas(String volmeas) {
        this.volmeas = volmeas;
    }

    public String getTotalmass() {
        return totalmass;
    }

    public void setTotalmass(String totalmass) {
        this.totalmass = totalmass;
    }

    public String getMasscement() {
        return masscement;
    }

    public void setMasscement(String masscement) {
        this.masscement = masscement;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getAircontentSpecMax() {
        return aircontentSpecMax;
    }

    public void setAircontentSpecMax(String aircontentSpecMax) {
        this.aircontentSpecMax = aircontentSpecMax;
    }

    public String getAircontentSpecMin() {
        return aircontentSpecMin;
    }

    public void setAircontentSpecMin(String aircontentSpecMin) {
        this.aircontentSpecMin = aircontentSpecMin;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTheounitwt() {
        return theounitwt;
    }

    public void setTheounitwt(String theounitwt) {
        this.theounitwt = theounitwt;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
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

}
