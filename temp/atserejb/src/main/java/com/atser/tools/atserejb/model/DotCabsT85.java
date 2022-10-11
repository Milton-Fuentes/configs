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
@Table(name = "dot_cabs_t85", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotCabsT85.findAll", query = "SELECT a FROM DotCabsT85 a")})
public class DotCabsT85 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "EXCESS_WATER")
    private String excessWater;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 187)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 71)
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
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 50)
    @Column(name = "CAWTOVENDRY")
    private String cawtovendry;
    @Size(max = 50)
    @Column(name = "CAWTSATSURF")
    private String cawtsatsurf;
    @Size(max = 50)
    @Column(name = "CAWTWATER")
    private String cawtwater;
    @Size(max = 50)
    @Column(name = "CABULKSGDRY")
    private String cabulksgdry;
    @Size(max = 50)
    @Column(name = "CABULKSGSSD")
    private String cabulksgssd;
    @Size(max = 50)
    @Column(name = "CAAPSG")
    private String caapsg;
    @Size(max = 50)
    @Column(name = "CAWATERABSORP")
    private String cawaterabsorp;
    @Size(max = 50)
    @Column(name = "FAWTOVENDRY")
    private String fawtovendry;
    @Size(max = 50)
    @Column(name = "FAWTSSD")
    private String fawtssd;
    @Size(max = 50)
    @Column(name = "FAWTCALPYCNO")
    private String fawtcalpycno;
    @Size(max = 50)
    @Column(name = "FAWTPYCNO")
    private String fawtpycno;
    @Size(max = 50)
    @Column(name = "FABULKSGDRY")
    private String fabulksgdry;
    @Size(max = 50)
    @Column(name = "FABULKSGSSD")
    private String fabulksgssd;
    @Size(max = 50)
    @Column(name = "FAAPSG")
    private String faapsg;
    @Size(max = 50)
    @Column(name = "FAWATERABSORP")
    private String fawaterabsorp;
    @Size(max = 50)
    @Column(name = "MCWTORGSAMPLE")
    private String mcwtorgsample;
    @Size(max = 50)
    @Column(name = "MCWTDRYSAMPLE")
    private String mcwtdrysample;
    @Size(max = 50)
    @Column(name = "MFWTORGSAMPLE")
    private String mfwtorgsample;
    @Size(max = 50)
    @Column(name = "MFWTDRYSAMPLE")
    private String mfwtdrysample;
    @Size(max = 50)
    @Column(name = "MCOARSEAGGMOIST")
    private String mcoarseaggmoist;
    @Size(max = 50)
    @Column(name = "MFINEAGGMOIST")
    private String mfineaggmoist;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
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

    public DotCabsT85() {
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getExcessWater() {
        return excessWater;
    }

    public void setExcessWater(String excessWater) {
        this.excessWater = excessWater;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
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

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
    }

    public String getCawtovendry() {
        return cawtovendry;
    }

    public void setCawtovendry(String cawtovendry) {
        this.cawtovendry = cawtovendry;
    }

    public String getCawtsatsurf() {
        return cawtsatsurf;
    }

    public void setCawtsatsurf(String cawtsatsurf) {
        this.cawtsatsurf = cawtsatsurf;
    }

    public String getCawtwater() {
        return cawtwater;
    }

    public void setCawtwater(String cawtwater) {
        this.cawtwater = cawtwater;
    }

    public String getCabulksgdry() {
        return cabulksgdry;
    }

    public void setCabulksgdry(String cabulksgdry) {
        this.cabulksgdry = cabulksgdry;
    }

    public String getCabulksgssd() {
        return cabulksgssd;
    }

    public void setCabulksgssd(String cabulksgssd) {
        this.cabulksgssd = cabulksgssd;
    }

    public String getCaapsg() {
        return caapsg;
    }

    public void setCaapsg(String caapsg) {
        this.caapsg = caapsg;
    }

    public String getCawaterabsorp() {
        return cawaterabsorp;
    }

    public void setCawaterabsorp(String cawaterabsorp) {
        this.cawaterabsorp = cawaterabsorp;
    }

    public String getFawtovendry() {
        return fawtovendry;
    }

    public void setFawtovendry(String fawtovendry) {
        this.fawtovendry = fawtovendry;
    }

    public String getFawtssd() {
        return fawtssd;
    }

    public void setFawtssd(String fawtssd) {
        this.fawtssd = fawtssd;
    }

    public String getFawtcalpycno() {
        return fawtcalpycno;
    }

    public void setFawtcalpycno(String fawtcalpycno) {
        this.fawtcalpycno = fawtcalpycno;
    }

    public String getFawtpycno() {
        return fawtpycno;
    }

    public void setFawtpycno(String fawtpycno) {
        this.fawtpycno = fawtpycno;
    }

    public String getFabulksgdry() {
        return fabulksgdry;
    }

    public void setFabulksgdry(String fabulksgdry) {
        this.fabulksgdry = fabulksgdry;
    }

    public String getFabulksgssd() {
        return fabulksgssd;
    }

    public void setFabulksgssd(String fabulksgssd) {
        this.fabulksgssd = fabulksgssd;
    }

    public String getFaapsg() {
        return faapsg;
    }

    public void setFaapsg(String faapsg) {
        this.faapsg = faapsg;
    }

    public String getFawaterabsorp() {
        return fawaterabsorp;
    }

    public void setFawaterabsorp(String fawaterabsorp) {
        this.fawaterabsorp = fawaterabsorp;
    }

    public String getMcwtorgsample() {
        return mcwtorgsample;
    }

    public void setMcwtorgsample(String mcwtorgsample) {
        this.mcwtorgsample = mcwtorgsample;
    }

    public String getMcwtdrysample() {
        return mcwtdrysample;
    }

    public void setMcwtdrysample(String mcwtdrysample) {
        this.mcwtdrysample = mcwtdrysample;
    }

    public String getMfwtorgsample() {
        return mfwtorgsample;
    }

    public void setMfwtorgsample(String mfwtorgsample) {
        this.mfwtorgsample = mfwtorgsample;
    }

    public String getMfwtdrysample() {
        return mfwtdrysample;
    }

    public void setMfwtdrysample(String mfwtdrysample) {
        this.mfwtdrysample = mfwtdrysample;
    }

    public String getMcoarseaggmoist() {
        return mcoarseaggmoist;
    }

    public void setMcoarseaggmoist(String mcoarseaggmoist) {
        this.mcoarseaggmoist = mcoarseaggmoist;
    }

    public String getMfineaggmoist() {
        return mfineaggmoist;
    }

    public void setMfineaggmoist(String mfineaggmoist) {
        this.mfineaggmoist = mfineaggmoist;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
