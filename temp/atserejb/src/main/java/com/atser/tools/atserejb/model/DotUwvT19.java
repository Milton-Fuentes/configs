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
@Table(name = "dot_uwv_t19", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotUwvT19.findAll", query = "SELECT a FROM DotUwvT19 a")})
public class DotUwvT19 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "DENSITYWATER")
    private String densitywater;
    @Size(max = 50)
    @Column(name = "SPECGRAV")
    private String specgrav;
    @Size(max = 50)
    @Column(name = "UNITWT")
    private String unitwt;
    @Size(max = 50)
    @Column(name = "VOID_CONTENT")
    private String voidContent;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 358)
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
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 50)
    @Column(name = "CPLUSMEAS")
    private String cplusmeas;
    @Size(max = 50)
    @Column(name = "CMEAS")
    private String cmeas;
    @Size(max = 50)
    @Column(name = "CVOLMEAS")
    private String cvolmeas;
    @Size(max = 50)
    @Column(name = "CSPECGRAV")
    private String cspecgrav;
    @Size(max = 50)
    @Column(name = "CUNITWT")
    private String cunitwt;
    @Size(max = 50)
    @Column(name = "CVOID")
    private String cvoid;
    @Size(max = 255)
    @Column(name = "TEST_PRO")
    private String testPro;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "FPLUSMEAS")
    private String fplusmeas;
    @Size(max = 50)
    @Column(name = "FMEAS")
    private String fmeas;
    @Size(max = 50)
    @Column(name = "FVOLMEAS")
    private String fvolmeas;
    @Size(max = 50)
    @Column(name = "FSPECGRAV")
    private String fspecgrav;
    @Size(max = 50)
    @Column(name = "FUNITWT")
    private String funitwt;
    @Size(max = 50)
    @Column(name = "FVOID")
    private String fvoid;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "CDENSITYWATER")
    private String cdensitywater;
    @Size(max = 50)
    @Column(name = "FDENSITYWATER")
    private String fdensitywater;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "PLUSMEAS")
    private String plusmeas;
    @Size(max = 50)
    @Column(name = "MEAS")
    private String meas;
    @Size(max = 50)
    @Column(name = "VOLMEAS")
    private String volmeas;
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

    public DotUwvT19() {
    }

    public String getDensitywater() {
        return densitywater;
    }

    public void setDensitywater(String densitywater) {
        this.densitywater = densitywater;
    }

    public String getSpecgrav() {
        return specgrav;
    }

    public void setSpecgrav(String specgrav) {
        this.specgrav = specgrav;
    }

    public String getUnitwt() {
        return unitwt;
    }

    public void setUnitwt(String unitwt) {
        this.unitwt = unitwt;
    }

    public String getVoidContent() {
        return voidContent;
    }

    public void setVoidContent(String voidContent) {
        this.voidContent = voidContent;
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

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
    }

    public String getCplusmeas() {
        return cplusmeas;
    }

    public void setCplusmeas(String cplusmeas) {
        this.cplusmeas = cplusmeas;
    }

    public String getCmeas() {
        return cmeas;
    }

    public void setCmeas(String cmeas) {
        this.cmeas = cmeas;
    }

    public String getCvolmeas() {
        return cvolmeas;
    }

    public void setCvolmeas(String cvolmeas) {
        this.cvolmeas = cvolmeas;
    }

    public String getCspecgrav() {
        return cspecgrav;
    }

    public void setCspecgrav(String cspecgrav) {
        this.cspecgrav = cspecgrav;
    }

    public String getCunitwt() {
        return cunitwt;
    }

    public void setCunitwt(String cunitwt) {
        this.cunitwt = cunitwt;
    }

    public String getCvoid() {
        return cvoid;
    }

    public void setCvoid(String cvoid) {
        this.cvoid = cvoid;
    }

    public String getTestPro() {
        return testPro;
    }

    public void setTestPro(String testPro) {
        this.testPro = testPro;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFplusmeas() {
        return fplusmeas;
    }

    public void setFplusmeas(String fplusmeas) {
        this.fplusmeas = fplusmeas;
    }

    public String getFmeas() {
        return fmeas;
    }

    public void setFmeas(String fmeas) {
        this.fmeas = fmeas;
    }

    public String getFvolmeas() {
        return fvolmeas;
    }

    public void setFvolmeas(String fvolmeas) {
        this.fvolmeas = fvolmeas;
    }

    public String getFspecgrav() {
        return fspecgrav;
    }

    public void setFspecgrav(String fspecgrav) {
        this.fspecgrav = fspecgrav;
    }

    public String getFunitwt() {
        return funitwt;
    }

    public void setFunitwt(String funitwt) {
        this.funitwt = funitwt;
    }

    public String getFvoid() {
        return fvoid;
    }

    public void setFvoid(String fvoid) {
        this.fvoid = fvoid;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCdensitywater() {
        return cdensitywater;
    }

    public void setCdensitywater(String cdensitywater) {
        this.cdensitywater = cdensitywater;
    }

    public String getFdensitywater() {
        return fdensitywater;
    }

    public void setFdensitywater(String fdensitywater) {
        this.fdensitywater = fdensitywater;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getPlusmeas() {
        return plusmeas;
    }

    public void setPlusmeas(String plusmeas) {
        this.plusmeas = plusmeas;
    }

    public String getMeas() {
        return meas;
    }

    public void setMeas(String meas) {
        this.meas = meas;
    }

    public String getVolmeas() {
        return volmeas;
    }

    public void setVolmeas(String volmeas) {
        this.volmeas = volmeas;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
