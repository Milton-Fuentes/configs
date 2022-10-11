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
@Table(name = "DOT_RDV_T59", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotRdvT59.findAll", query = "SELECT a FROM DotRdvT59 a")})
public class DotRdvT59 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 50)
    @Column(name = "EMULSION_TYPE")
    private String emulsionType;
    @Size(max = 184)
    @Column(name = "TESTNO")
    private String testno;
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
    @Column(name = "SUPPLIER_ID")
    private BigDecimal supplierId;
    @Size(max = 255)
    @Column(name = "PRODUCED_BY")
    private String producedBy;
    @Size(max = 250)
    @Column(name = "PRODUCER_LOCATION")
    private String producerLocation;
    @Column(name = "BINDER_GRADE_ID")
    private BigInteger binderGradeId;
    @Size(max = 50)
    @Column(name = "WTEMPTYAPP")
    private String wtemptyapp;
    @Size(max = 50)
    @Column(name = "WTAFTERDISTILL")
    private String wtafterdistill;
    @Size(max = 50)
    @Column(name = "SAMPLE")
    private String sample;
    @Size(max = 50)
    @Column(name = "WTBEFOREDISTILL")
    private String wtbeforedistill;
    @Size(max = 50)
    @Column(name = "PERRESIDUE")
    private String perresidue;
    @Size(max = 50)
    @Column(name = "VOLOILDISTILL")
    private String voloildistill;
    @Size(max = 50)
    @Column(name = "VOLPERDISTILL")
    private String volperdistill;
    @Size(max = 50)
    @Column(name = "EVAP_TAREWT")
    private String evapTarewt;
    @Size(max = 50)
    @Column(name = "EVAP_ORIG_MASS")
    private String evapOrigMass;
    @Size(max = 50)
    @Column(name = "EVAP_FINAL_MASS")
    private String evapFinalMass;
    @Size(max = 50)
    @Column(name = "EVAP_PERRESIDUE")
    private String evapPerresidue;
    @Size(max = 50)
    @Column(name = "SAYFURVIS")
    private String sayfurvis;
    @Size(max = 50)
    @Column(name = "SAYFURVIS122")
    private String sayfurvis122;
    @Size(max = 50)
    @Column(name = "SAYFURVIS_SPEC")
    private String sayfurvisSpec;
    @Size(max = 50)
    @Column(name = "SAYFURVIS122_SPEC")
    private String sayfurvis122Spec;
    @Size(max = 50)
    @Column(name = "RPREPLICATE1")
    private String rpreplicate1;
    @Size(max = 50)
    @Column(name = "RPREPLICATE2")
    private String rpreplicate2;
    @Size(max = 50)
    @Column(name = "RPREPLICATE3")
    private String rpreplicate3;
    @Size(max = 50)
    @Column(name = "RPAVG")
    private String rpavg;
    @Size(max = 50)
    @Column(name = "EVAP_SPEC_MIN")
    private String evapSpecMin;
    @Size(max = 50)
    @Column(name = "EVAP_RESULT")
    private String evapResult;
    @Size(max = 50)
    @Column(name = "SAMPLE_AFTER")
    private String sampleAfter;
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

    public DotRdvT59() {
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getEmulsionType() {
        return emulsionType;
    }

    public void setEmulsionType(String emulsionType) {
        this.emulsionType = emulsionType;
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

    public BigDecimal getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getProducerLocation() {
        return producerLocation;
    }

    public void setProducerLocation(String producerLocation) {
        this.producerLocation = producerLocation;
    }

    public BigInteger getBinderGradeId() {
        return binderGradeId;
    }

    public void setBinderGradeId(BigInteger binderGradeId) {
        this.binderGradeId = binderGradeId;
    }

    public String getWtemptyapp() {
        return wtemptyapp;
    }

    public void setWtemptyapp(String wtemptyapp) {
        this.wtemptyapp = wtemptyapp;
    }

    public String getWtafterdistill() {
        return wtafterdistill;
    }

    public void setWtafterdistill(String wtafterdistill) {
        this.wtafterdistill = wtafterdistill;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getWtbeforedistill() {
        return wtbeforedistill;
    }

    public void setWtbeforedistill(String wtbeforedistill) {
        this.wtbeforedistill = wtbeforedistill;
    }

    public String getPerresidue() {
        return perresidue;
    }

    public void setPerresidue(String perresidue) {
        this.perresidue = perresidue;
    }

    public String getVoloildistill() {
        return voloildistill;
    }

    public void setVoloildistill(String voloildistill) {
        this.voloildistill = voloildistill;
    }

    public String getVolperdistill() {
        return volperdistill;
    }

    public void setVolperdistill(String volperdistill) {
        this.volperdistill = volperdistill;
    }

    public String getEvapTarewt() {
        return evapTarewt;
    }

    public void setEvapTarewt(String evapTarewt) {
        this.evapTarewt = evapTarewt;
    }

    public String getEvapOrigMass() {
        return evapOrigMass;
    }

    public void setEvapOrigMass(String evapOrigMass) {
        this.evapOrigMass = evapOrigMass;
    }

    public String getEvapFinalMass() {
        return evapFinalMass;
    }

    public void setEvapFinalMass(String evapFinalMass) {
        this.evapFinalMass = evapFinalMass;
    }

    public String getEvapPerresidue() {
        return evapPerresidue;
    }

    public void setEvapPerresidue(String evapPerresidue) {
        this.evapPerresidue = evapPerresidue;
    }

    public String getSayfurvis() {
        return sayfurvis;
    }

    public void setSayfurvis(String sayfurvis) {
        this.sayfurvis = sayfurvis;
    }

    public String getSayfurvis122() {
        return sayfurvis122;
    }

    public void setSayfurvis122(String sayfurvis122) {
        this.sayfurvis122 = sayfurvis122;
    }

    public String getSayfurvisSpec() {
        return sayfurvisSpec;
    }

    public void setSayfurvisSpec(String sayfurvisSpec) {
        this.sayfurvisSpec = sayfurvisSpec;
    }

    public String getSayfurvis122Spec() {
        return sayfurvis122Spec;
    }

    public void setSayfurvis122Spec(String sayfurvis122Spec) {
        this.sayfurvis122Spec = sayfurvis122Spec;
    }

    public String getRpreplicate1() {
        return rpreplicate1;
    }

    public void setRpreplicate1(String rpreplicate1) {
        this.rpreplicate1 = rpreplicate1;
    }

    public String getRpreplicate2() {
        return rpreplicate2;
    }

    public void setRpreplicate2(String rpreplicate2) {
        this.rpreplicate2 = rpreplicate2;
    }

    public String getRpreplicate3() {
        return rpreplicate3;
    }

    public void setRpreplicate3(String rpreplicate3) {
        this.rpreplicate3 = rpreplicate3;
    }

    public String getRpavg() {
        return rpavg;
    }

    public void setRpavg(String rpavg) {
        this.rpavg = rpavg;
    }

    public String getEvapSpecMin() {
        return evapSpecMin;
    }

    public void setEvapSpecMin(String evapSpecMin) {
        this.evapSpecMin = evapSpecMin;
    }

    public String getEvapResult() {
        return evapResult;
    }

    public void setEvapResult(String evapResult) {
        this.evapResult = evapResult;
    }

    public String getSampleAfter() {
        return sampleAfter;
    }

    public void setSampleAfter(String sampleAfter) {
        this.sampleAfter = sampleAfter;
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
    public String getTestno() {
        if (StringSupport.isNotNullAndNotEmpty(testno) && testno.contains("../../")) {
            return testno.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testno;
    }
}
