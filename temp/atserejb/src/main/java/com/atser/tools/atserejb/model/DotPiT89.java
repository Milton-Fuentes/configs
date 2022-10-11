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
@Table(name = "dot_pi_t89", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotPiT89.findAll", query = "SELECT a FROM DotPiT89 a")})
public class DotPiT89 implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "LLSPEC")
    private String llspec;
    @Size(max = 50)
    @Column(name = "PLSPEC")
    private String plspec;
    @Size(max = 50)
    @Column(name = "PISPEC")
    private String pispec;
    @Column(name = "ISPLASTIC")
    private Character isplastic;
    @Size(max = 50)
    @Column(name = "LIQUIDLIMIT")
    private String liquidlimit;
    @Size(max = 50)
    @Column(name = "PLASTICLIMIT")
    private String plasticlimit;
    @Size(max = 50)
    @Column(name = "PLASTICINDEX")
    private String plasticindex;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 5)
    @Column(name = "ISMULTI")
    private String ismulti;
    @Size(max = 50)
    @Column(name = "MULTIPOINT")
    private String multipoint;
    @Size(max = 4000)
    @Column(name = "MATERIALSOURCE")
    private String materialsource;
    @Size(max = 4000)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 4000)
    @Column(name = "SOILCLASS")
    private String soilclass;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "LLDEVICE")
    private String lldevice;
    @Size(max = 255)
    @Column(name = "FLATGROOVINGTOOL")
    private String flatgroovingtool;
    @Size(max = 255)
    @Column(name = "GAGE")
    private String gage;
    @Size(max = 255)
    @Column(name = "GROUNDGLASSPLATE")
    private String groundglassplate;
    @Size(max = 255)
    @Column(name = "NO40SIEVE")
    private String no40sieve;
    @Size(max = 255)
    @Column(name = "NO10SIEVE")
    private String no10sieve;
    @Size(max = 255)
    @Column(name = "PLROLLINGDEVICE")
    private String plrollingdevice;
    @Size(max = 255)
    @Column(name = "DRYINGOVEN")
    private String dryingoven;
    @Size(max = 255)
    @Column(name = "BALANCE")
    private String balance;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 100)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "LINEARSHRINKAGE")
    private String linearshrinkage;
    @Size(max = 15)
    @Column(name = "LL_RESULT")
    private String llResult;
    @Size(max = 15)
    @Column(name = "PL_RESULT")
    private String plResult;
    @Size(max = 15)
    @Column(name = "PI_RESULT")
    private String piResult;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 303)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotPiT89() {
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

    public String getLlspec() {
        return llspec;
    }

    public void setLlspec(String llspec) {
        this.llspec = llspec;
    }

    public String getPlspec() {
        return plspec;
    }

    public void setPlspec(String plspec) {
        this.plspec = plspec;
    }

    public String getPispec() {
        return pispec;
    }

    public void setPispec(String pispec) {
        this.pispec = pispec;
    }

    public Character getIsplastic() {
        return isplastic;
    }

    public void setIsplastic(Character isplastic) {
        this.isplastic = isplastic;
    }

    public String getLiquidlimit() {
        return liquidlimit;
    }

    public void setLiquidlimit(String liquidlimit) {
        this.liquidlimit = liquidlimit;
    }

    public String getPlasticlimit() {
        return plasticlimit;
    }

    public void setPlasticlimit(String plasticlimit) {
        this.plasticlimit = plasticlimit;
    }

    public String getPlasticindex() {
        return plasticindex;
    }

    public void setPlasticindex(String plasticindex) {
        this.plasticindex = plasticindex;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
    }

    public String getIsmulti() {
        return ismulti;
    }

    public void setIsmulti(String ismulti) {
        this.ismulti = ismulti;
    }

    public String getMultipoint() {
        return multipoint;
    }

    public void setMultipoint(String multipoint) {
        this.multipoint = multipoint;
    }

    public String getMaterialsource() {
        return materialsource;
    }

    public void setMaterialsource(String materialsource) {
        this.materialsource = materialsource;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getSoilclass() {
        return soilclass;
    }

    public void setSoilclass(String soilclass) {
        this.soilclass = soilclass;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLldevice() {
        return lldevice;
    }

    public void setLldevice(String lldevice) {
        this.lldevice = lldevice;
    }

    public String getFlatgroovingtool() {
        return flatgroovingtool;
    }

    public void setFlatgroovingtool(String flatgroovingtool) {
        this.flatgroovingtool = flatgroovingtool;
    }

    public String getGage() {
        return gage;
    }

    public void setGage(String gage) {
        this.gage = gage;
    }

    public String getGroundglassplate() {
        return groundglassplate;
    }

    public void setGroundglassplate(String groundglassplate) {
        this.groundglassplate = groundglassplate;
    }

    public String getNo40sieve() {
        return no40sieve;
    }

    public void setNo40sieve(String no40sieve) {
        this.no40sieve = no40sieve;
    }

    public String getNo10sieve() {
        return no10sieve;
    }

    public void setNo10sieve(String no10sieve) {
        this.no10sieve = no10sieve;
    }

    public String getPlrollingdevice() {
        return plrollingdevice;
    }

    public void setPlrollingdevice(String plrollingdevice) {
        this.plrollingdevice = plrollingdevice;
    }

    public String getDryingoven() {
        return dryingoven;
    }

    public void setDryingoven(String dryingoven) {
        this.dryingoven = dryingoven;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getLinearshrinkage() {
        return linearshrinkage;
    }

    public void setLinearshrinkage(String linearshrinkage) {
        this.linearshrinkage = linearshrinkage;
    }

    public String getLlResult() {
        return llResult;
    }

    public void setLlResult(String llResult) {
        this.llResult = llResult;
    }

    public String getPlResult() {
        return plResult;
    }

    public void setPlResult(String plResult) {
        this.plResult = plResult;
    }

    public String getPiResult() {
        return piResult;
    }

    public void setPiResult(String piResult) {
        this.piResult = piResult;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
