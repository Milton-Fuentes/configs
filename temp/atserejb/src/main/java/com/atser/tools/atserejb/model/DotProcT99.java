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
@Table(name = "dot_proc_t99", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotProcT99.findAll", query = "SELECT a FROM DotProcT99 a")})
public class DotProcT99 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Column(name = "TESTDESIGN")
    private String testdesign;
    @Size(max = 50)
    @Column(name = "TESTMETHOD")
    private String testmethod;
    @Size(max = 50)
    @Column(name = "PREPMETHOD")
    private String prepmethod;
    @Size(max = 50)
    @Column(name = "TYPERAMMER")
    private String typerammer;
    @Size(max = 50)
    @Column(name = "FIELD11")
    private String field11;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "SOILCLASS")
    private String soilclass;
    @Size(max = 50)
    @Column(name = "SAMPLE_MOLDSIZE")
    private String sampleMoldsize;
    @Size(max = 50)
    @Column(name = "SAMPLE_MOLDVOL")
    private String sampleMoldvol;
    @Size(max = 50)
    @Column(name = "SPECGRAVITY")
    private String specgravity;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSITY")
    private String maxdrydensity;
    @Size(max = 50)
    @Column(name = "OPTMOISTCONTENT")
    private String optmoistcontent;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSOVER")
    private String maxdrydensover;
    @Size(max = 50)
    @Column(name = "CORMOISTCONTENTOVER")
    private String cormoistcontentover;
    @Size(max = 255)
    @Column(name = "INIT_SOIL_DESC")
    private String initSoilDesc;
    @Size(max = 50)
    @Column(name = "SAMPLE_LOC")
    private String sampleLoc;
    @Size(max = 50)
    @Column(name = "PASS_NO4")
    private String passNo4;
    @Size(max = 50)
    @Column(name = "PASS_NO10")
    private String passNo10;
    @Size(max = 50)
    @Column(name = "PASS_NO40")
    private String passNo40;
    @Size(max = 50)
    @Column(name = "PASS_NO200")
    private String passNo200;
    @Size(max = 50)
    @Column(name = "COMPACTION_METHOD")
    private String compactionMethod;
    @Size(max = 50)
    @Column(name = "LIQUID_LIMIT")
    private String liquidLimit;
    @Size(max = 50)
    @Column(name = "PLASTIC_LIMIT")
    private String plasticLimit;
    @Size(max = 50)
    @Column(name = "PLASTIC_INDEX")
    private String plasticIndex;
    @Size(max = 50)
    @Column(name = "BULK_SPEC_GRAV")
    private String bulkSpecGrav;
    @Size(max = 50)
    @Column(name = "ABSORPTION")
    private String absorption;
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 4000)
    @Column(name = "SOURCE")
    private String source;
    @Size(max = 255)
    @Column(name = "STRUCTURE")
    private String structure;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "SAMPLEDBY")
    private String sampledby;
    @Size(max = 255)
    @Column(name = "PROCTORMOLDS")
    private String proctormolds;
    @Size(max = 255)
    @Column(name = "PROCTORHAMMER")
    private String proctorhammer;
    @Size(max = 255)
    @Column(name = "OVEN")
    private String oven;
    @Size(max = 255)
    @Column(name = "BALANCE")
    private String balance;
    @Size(max = 255)
    @Column(name = "SCALE")
    private String scale;
    @Size(max = 255)
    @Column(name = "PERCENTCOARSER")
    private String percentcoarser;
    @Size(max = 50)
    @Column(name = "ORG_SAMPLE_WT")
    private String orgSampleWt;
    @Size(max = 50)
    @Column(name = "RET_3_4")
    private String ret34;
    @Size(max = 50)
    @Column(name = "RET_3_8")
    private String ret38;
    @Size(max = 50)
    @Column(name = "RET_NO4")
    private String retNo4;
    @Size(max = 50)
    @Column(name = "PER_RET_3_4")
    private String perRet34;
    @Size(max = 50)
    @Column(name = "PER_RET_3_8")
    private String perRet38;
    @Size(max = 50)
    @Column(name = "PER_RET_NO4")
    private String perRetNo4;
    @Size(max = 50)
    @Column(name = "PERCENTCOARSER_MOIST")
    private String percentcoarserMoist;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "NUM_POINTS")
    private BigDecimal numPoints;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Column(name = "HIDE_ON_PDA")
    private Character hideOnPda;
    @Size(max = 50)
    @Column(name = "WET_MASS_WATER_ADD")
    private String wetMassWaterAdd;
    @Size(max = 50)
    @Column(name = "WET_SAMPLE_MOLDVOL_LIN")
    private String wetSampleMoldvolLin;
    @Size(max = 50)
    @Column(name = "WET_SAMPLE_MOLDSIZE")
    private String wetSampleMoldsize;
    @Size(max = 50)
    @Column(name = "WET_ESTDRYDENSITY")
    private String wetEstdrydensity;
    @Size(max = 50)
    @Column(name = "WET_MASS_MATERIAL")
    private String wetMassMaterial;
    @Size(max = 50)
    @Column(name = "OVEN_DRY_WT")
    private String ovenDryWt;
    @Size(max = 50)
    @Column(name = "WT_PYCN_WATER")
    private String wtPycnWater;
    @Size(max = 50)
    @Column(name = "WT_AGG_PYCN_WATER")
    private String wtAggPycnWater;
    @Size(max = 50)
    @Column(name = "HYGR_MOIST")
    private String hygrMoist;
    @Column(name = "SPECGRAVITY_ISCALC")
    private Character specgravityIscalc;
    @Size(max = 50)
    @Column(name = "MOLD_TARE_WT")
    private String moldTareWt;
    @Size(max = 50)
    @Column(name = "PERCENT_OVERSIZED")
    private String percentOversized;
    @Size(max = 50)
    @Column(name = "PERCENT_FINER_MATERIAL")
    private String percentFinerMaterial;
    @Size(max = 50)
    @Column(name = "TOTAL_WEIGHT")
    private String totalWeight;
    @Size(max = 50)
    @Column(name = "RET_NO10")
    private String retNo10;
    @Size(max = 50)
    @Column(name = "PER_RET_NO10")
    private String perRetNo10;
    @Size(max = 50)
    @Column(name = "PLUS_10_ABSORB_PERC")
    private String plus10AbsorbPerc;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 5)
    @Column(name = "POINT")
    private String point;
    @Size(max = 50)
    @Column(name = "DRYDENSITY")
    private String drydensity;
    @Size(max = 50)
    @Column(name = "MOISTCONTENT")
    private String moistcontent;
    @Size(max = 10)
    @Column(name = "WET_ESTWATER")
    private String wetEstwater;
    @Size(max = 10)
    @Column(name = "WET_SOILMOLDWT")
    private String wetSoilmoldwt;
    @Size(max = 10)
    @Column(name = "WET_MOLDWT")
    private String wetMoldwt;
    @Size(max = 10)
    @Column(name = "WET_SOILWT")
    private String wetSoilwt;
    @Size(max = 10)
    @Column(name = "WET_UNITWT")
    private String wetUnitwt;
    @Size(max = 10)
    @Column(name = "DRY_CONTAINERNO")
    private String dryContainerno;
    @Size(max = 10)
    @Column(name = "DRY_WETSOILTARE")
    private String dryWetsoiltare;
    @Size(max = 10)
    @Column(name = "DRY_DRYSOILTARE")
    private String dryDrysoiltare;
    @Size(max = 10)
    @Column(name = "DRY_TARE")
    private String dryTare;
    @Size(max = 10)
    @Column(name = "DRY_SOILWT")
    private String drySoilwt;
    @Size(max = 10)
    @Column(name = "DRY_WATERWT")
    private String dryWaterwt;
    @Size(max = 10)
    @Column(name = "WET_SAMPLE_MOLDVOL")
    private String wetSampleMoldvol;
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
    @Size(max = 307)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 77)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;

    public DotProcT99() {
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

    public String getTestdesign() {
        return testdesign;
    }

    public void setTestdesign(String testdesign) {
        this.testdesign = testdesign;
    }

    public String getTestmethod() {
        return testmethod;
    }

    public void setTestmethod(String testmethod) {
        this.testmethod = testmethod;
    }

    public String getPrepmethod() {
        return prepmethod;
    }

    public void setPrepmethod(String prepmethod) {
        this.prepmethod = prepmethod;
    }

    public String getTyperammer() {
        return typerammer;
    }

    public void setTyperammer(String typerammer) {
        this.typerammer = typerammer;
    }

    public String getField11() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11 = field11;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoilclass() {
        return soilclass;
    }

    public void setSoilclass(String soilclass) {
        this.soilclass = soilclass;
    }

    public String getSampleMoldsize() {
        return sampleMoldsize;
    }

    public void setSampleMoldsize(String sampleMoldsize) {
        this.sampleMoldsize = sampleMoldsize;
    }

    public String getSampleMoldvol() {
        return sampleMoldvol;
    }

    public void setSampleMoldvol(String sampleMoldvol) {
        this.sampleMoldvol = sampleMoldvol;
    }

    public String getSpecgravity() {
        return specgravity;
    }

    public void setSpecgravity(String specgravity) {
        this.specgravity = specgravity;
    }

    public String getMaxdrydensity() {
        return maxdrydensity;
    }

    public void setMaxdrydensity(String maxdrydensity) {
        this.maxdrydensity = maxdrydensity;
    }

    public String getOptmoistcontent() {
        return optmoistcontent;
    }

    public void setOptmoistcontent(String optmoistcontent) {
        this.optmoistcontent = optmoistcontent;
    }

    public String getMaxdrydensover() {
        return maxdrydensover;
    }

    public void setMaxdrydensover(String maxdrydensover) {
        this.maxdrydensover = maxdrydensover;
    }

    public String getCormoistcontentover() {
        return cormoistcontentover;
    }

    public void setCormoistcontentover(String cormoistcontentover) {
        this.cormoistcontentover = cormoistcontentover;
    }

    public String getInitSoilDesc() {
        return initSoilDesc;
    }

    public void setInitSoilDesc(String initSoilDesc) {
        this.initSoilDesc = initSoilDesc;
    }

    public String getSampleLoc() {
        return sampleLoc;
    }

    public void setSampleLoc(String sampleLoc) {
        this.sampleLoc = sampleLoc;
    }

    public String getPassNo4() {
        return passNo4;
    }

    public void setPassNo4(String passNo4) {
        this.passNo4 = passNo4;
    }

    public String getPassNo10() {
        return passNo10;
    }

    public void setPassNo10(String passNo10) {
        this.passNo10 = passNo10;
    }

    public String getPassNo40() {
        return passNo40;
    }

    public void setPassNo40(String passNo40) {
        this.passNo40 = passNo40;
    }

    public String getPassNo200() {
        return passNo200;
    }

    public void setPassNo200(String passNo200) {
        this.passNo200 = passNo200;
    }

    public String getCompactionMethod() {
        return compactionMethod;
    }

    public void setCompactionMethod(String compactionMethod) {
        this.compactionMethod = compactionMethod;
    }

    public String getLiquidLimit() {
        return liquidLimit;
    }

    public void setLiquidLimit(String liquidLimit) {
        this.liquidLimit = liquidLimit;
    }

    public String getPlasticLimit() {
        return plasticLimit;
    }

    public void setPlasticLimit(String plasticLimit) {
        this.plasticLimit = plasticLimit;
    }

    public String getPlasticIndex() {
        return plasticIndex;
    }

    public void setPlasticIndex(String plasticIndex) {
        this.plasticIndex = plasticIndex;
    }

    public String getBulkSpecGrav() {
        return bulkSpecGrav;
    }

    public void setBulkSpecGrav(String bulkSpecGrav) {
        this.bulkSpecGrav = bulkSpecGrav;
    }

    public String getAbsorption() {
        return absorption;
    }

    public void setAbsorption(String absorption) {
        this.absorption = absorption;
    }

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSampledby() {
        return sampledby;
    }

    public void setSampledby(String sampledby) {
        this.sampledby = sampledby;
    }

    public String getProctormolds() {
        return proctormolds;
    }

    public void setProctormolds(String proctormolds) {
        this.proctormolds = proctormolds;
    }

    public String getProctorhammer() {
        return proctorhammer;
    }

    public void setProctorhammer(String proctorhammer) {
        this.proctorhammer = proctorhammer;
    }

    public String getOven() {
        return oven;
    }

    public void setOven(String oven) {
        this.oven = oven;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getPercentcoarser() {
        return percentcoarser;
    }

    public void setPercentcoarser(String percentcoarser) {
        this.percentcoarser = percentcoarser;
    }

    public String getOrgSampleWt() {
        return orgSampleWt;
    }

    public void setOrgSampleWt(String orgSampleWt) {
        this.orgSampleWt = orgSampleWt;
    }

    public String getRet34() {
        return ret34;
    }

    public void setRet34(String ret34) {
        this.ret34 = ret34;
    }

    public String getRet38() {
        return ret38;
    }

    public void setRet38(String ret38) {
        this.ret38 = ret38;
    }

    public String getRetNo4() {
        return retNo4;
    }

    public void setRetNo4(String retNo4) {
        this.retNo4 = retNo4;
    }

    public String getPerRet34() {
        return perRet34;
    }

    public void setPerRet34(String perRet34) {
        this.perRet34 = perRet34;
    }

    public String getPerRet38() {
        return perRet38;
    }

    public void setPerRet38(String perRet38) {
        this.perRet38 = perRet38;
    }

    public String getPerRetNo4() {
        return perRetNo4;
    }

    public void setPerRetNo4(String perRetNo4) {
        this.perRetNo4 = perRetNo4;
    }

    public String getPercentcoarserMoist() {
        return percentcoarserMoist;
    }

    public void setPercentcoarserMoist(String percentcoarserMoist) {
        this.percentcoarserMoist = percentcoarserMoist;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getSplitno() {
        return splitno;
    }

    public void setSplitno(String splitno) {
        this.splitno = splitno;
    }

    public Character getSplitsample() {
        return splitsample;
    }

    public void setSplitsample(Character splitsample) {
        this.splitsample = splitsample;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigDecimal numPoints) {
        this.numPoints = numPoints;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Character getHideOnPda() {
        return hideOnPda;
    }

    public void setHideOnPda(Character hideOnPda) {
        this.hideOnPda = hideOnPda;
    }

    public String getWetMassWaterAdd() {
        return wetMassWaterAdd;
    }

    public void setWetMassWaterAdd(String wetMassWaterAdd) {
        this.wetMassWaterAdd = wetMassWaterAdd;
    }

    public String getWetSampleMoldvolLin() {
        return wetSampleMoldvolLin;
    }

    public void setWetSampleMoldvolLin(String wetSampleMoldvolLin) {
        this.wetSampleMoldvolLin = wetSampleMoldvolLin;
    }

    public String getWetSampleMoldsize() {
        return wetSampleMoldsize;
    }

    public void setWetSampleMoldsize(String wetSampleMoldsize) {
        this.wetSampleMoldsize = wetSampleMoldsize;
    }

    public String getWetEstdrydensity() {
        return wetEstdrydensity;
    }

    public void setWetEstdrydensity(String wetEstdrydensity) {
        this.wetEstdrydensity = wetEstdrydensity;
    }

    public String getWetMassMaterial() {
        return wetMassMaterial;
    }

    public void setWetMassMaterial(String wetMassMaterial) {
        this.wetMassMaterial = wetMassMaterial;
    }

    public String getOvenDryWt() {
        return ovenDryWt;
    }

    public void setOvenDryWt(String ovenDryWt) {
        this.ovenDryWt = ovenDryWt;
    }

    public String getWtPycnWater() {
        return wtPycnWater;
    }

    public void setWtPycnWater(String wtPycnWater) {
        this.wtPycnWater = wtPycnWater;
    }

    public String getWtAggPycnWater() {
        return wtAggPycnWater;
    }

    public void setWtAggPycnWater(String wtAggPycnWater) {
        this.wtAggPycnWater = wtAggPycnWater;
    }

    public String getHygrMoist() {
        return hygrMoist;
    }

    public void setHygrMoist(String hygrMoist) {
        this.hygrMoist = hygrMoist;
    }

    public Character getSpecgravityIscalc() {
        return specgravityIscalc;
    }

    public void setSpecgravityIscalc(Character specgravityIscalc) {
        this.specgravityIscalc = specgravityIscalc;
    }

    public String getMoldTareWt() {
        return moldTareWt;
    }

    public void setMoldTareWt(String moldTareWt) {
        this.moldTareWt = moldTareWt;
    }

    public String getPercentOversized() {
        return percentOversized;
    }

    public void setPercentOversized(String percentOversized) {
        this.percentOversized = percentOversized;
    }

    public String getPercentFinerMaterial() {
        return percentFinerMaterial;
    }

    public void setPercentFinerMaterial(String percentFinerMaterial) {
        this.percentFinerMaterial = percentFinerMaterial;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getRetNo10() {
        return retNo10;
    }

    public void setRetNo10(String retNo10) {
        this.retNo10 = retNo10;
    }

    public String getPerRetNo10() {
        return perRetNo10;
    }

    public void setPerRetNo10(String perRetNo10) {
        this.perRetNo10 = perRetNo10;
    }

    public String getPlus10AbsorbPerc() {
        return plus10AbsorbPerc;
    }

    public void setPlus10AbsorbPerc(String plus10AbsorbPerc) {
        this.plus10AbsorbPerc = plus10AbsorbPerc;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDrydensity() {
        return drydensity;
    }

    public void setDrydensity(String drydensity) {
        this.drydensity = drydensity;
    }

    public String getMoistcontent() {
        return moistcontent;
    }

    public void setMoistcontent(String moistcontent) {
        this.moistcontent = moistcontent;
    }

    public String getWetEstwater() {
        return wetEstwater;
    }

    public void setWetEstwater(String wetEstwater) {
        this.wetEstwater = wetEstwater;
    }

    public String getWetSoilmoldwt() {
        return wetSoilmoldwt;
    }

    public void setWetSoilmoldwt(String wetSoilmoldwt) {
        this.wetSoilmoldwt = wetSoilmoldwt;
    }

    public String getWetMoldwt() {
        return wetMoldwt;
    }

    public void setWetMoldwt(String wetMoldwt) {
        this.wetMoldwt = wetMoldwt;
    }

    public String getWetSoilwt() {
        return wetSoilwt;
    }

    public void setWetSoilwt(String wetSoilwt) {
        this.wetSoilwt = wetSoilwt;
    }

    public String getWetUnitwt() {
        return wetUnitwt;
    }

    public void setWetUnitwt(String wetUnitwt) {
        this.wetUnitwt = wetUnitwt;
    }

    public String getDryContainerno() {
        return dryContainerno;
    }

    public void setDryContainerno(String dryContainerno) {
        this.dryContainerno = dryContainerno;
    }

    public String getDryWetsoiltare() {
        return dryWetsoiltare;
    }

    public void setDryWetsoiltare(String dryWetsoiltare) {
        this.dryWetsoiltare = dryWetsoiltare;
    }

    public String getDryDrysoiltare() {
        return dryDrysoiltare;
    }

    public void setDryDrysoiltare(String dryDrysoiltare) {
        this.dryDrysoiltare = dryDrysoiltare;
    }

    public String getDryTare() {
        return dryTare;
    }

    public void setDryTare(String dryTare) {
        this.dryTare = dryTare;
    }

    public String getDrySoilwt() {
        return drySoilwt;
    }

    public void setDrySoilwt(String drySoilwt) {
        this.drySoilwt = drySoilwt;
    }

    public String getDryWaterwt() {
        return dryWaterwt;
    }

    public void setDryWaterwt(String dryWaterwt) {
        this.dryWaterwt = dryWaterwt;
    }

    public String getWetSampleMoldvol() {
        return wetSampleMoldvol;
    }

    public void setWetSampleMoldvol(String wetSampleMoldvol) {
        this.wetSampleMoldvol = wetSampleMoldvol;
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

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
