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
@Table(name = "DOT_TSR_T283", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotTsrT283.findAll", query = "SELECT a FROM DotTsrT283 a")})
public class DotTsrT283 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "FREEZE_LOAD")
    private String freezeLoad;
    @Size(max = 50)
    @Column(name = "FREEZE_WET_STRENGTH")
    private String freezeWetStrength;
    @Size(max = 50)
    @Column(name = "FREEZE_PCT_SATURATION")
    private String freezePctSaturation;
    @Size(max = 50)
    @Column(name = "FREEZE_PCT_SWELL")
    private String freezePctSwell;
    @Size(max = 50)
    @Column(name = "WATER_DAMAGE")
    private String waterDamage;
    @Size(max = 50)
    @Column(name = "AGG_DAMAGE")
    private String aggDamage;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "AVG_DRY_WTSUBMERGED")
    private String avgDryWtsubmerged;
    @Size(max = 50)
    @Column(name = "AVG_DRY_SSDWT")
    private String avgDrySsdwt;
    @Size(max = 50)
    @Column(name = "AVG_DRY_VOLUME")
    private String avgDryVolume;
    @Size(max = 50)
    @Column(name = "AVG_DRY_BULKSPECGRAV")
    private String avgDryBulkspecgrav;
    @Size(max = 50)
    @Column(name = "AVG_DRY_PERVOID")
    private String avgDryPervoid;
    @Size(max = 50)
    @Column(name = "AVG_DRY_VOIDS_VOLUME")
    private String avgDryVoidsVolume;
    @Size(max = 50)
    @Column(name = "AVG_DRY_LOADING")
    private String avgDryLoading;
    @Size(max = 50)
    @Column(name = "AVG_DRY_TENSSTR")
    private String avgDryTensstr;
    @Size(max = 50)
    @Column(name = "AVG_WET_HEIGHT")
    private String avgWetHeight;
    @Size(max = 50)
    @Column(name = "AVG_WET_WTAIR")
    private String avgWetWtair;
    @Size(max = 50)
    @Column(name = "AVG_WET_WTSUBMERGED")
    private String avgWetWtsubmerged;
    @Size(max = 50)
    @Column(name = "AVG_WET_SSDWT")
    private String avgWetSsdwt;
    @Size(max = 50)
    @Column(name = "AVG_WET_VOLUME")
    private String avgWetVolume;
    @Size(max = 50)
    @Column(name = "AVG_WET_BULKSPECGRAV")
    private String avgWetBulkspecgrav;
    @Size(max = 50)
    @Column(name = "AVG_WET_PERVOID")
    private String avgWetPervoid;
    @Size(max = 50)
    @Column(name = "AVG_WET_VOIDS_VOLUME")
    private String avgWetVoidsVolume;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_WATER_MASS")
    private String avgSaturatedWaterMass;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_SSD_MASS")
    private String avgSaturatedSsdMass;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_VOLUME")
    private String avgSaturatedVolume;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_VOL_ABSORB_WATER")
    private String avgSaturatedVolAbsorbWater;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_PCT_SATURATION")
    private String avgSaturatedPctSaturation;
    @Size(max = 50)
    @Column(name = "AVG_SATURATED_PCT_SWELL")
    private String avgSaturatedPctSwell;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_HEIGHT")
    private String avgFreezeHeight;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_WATER_MASS")
    private String avgFreezeWaterMass;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_MASS_AT_SSD")
    private String avgFreezeMassAtSsd;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_VOLUME")
    private String avgFreezeVolume;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_VOL_ABSORB_WATER")
    private String avgFreezeVolAbsorbWater;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_LOAD")
    private String avgFreezeLoad;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_WET_STRENGTH")
    private String avgFreezeWetStrength;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_PCT_SATURATION")
    private String avgFreezePctSaturation;
    @Size(max = 50)
    @Column(name = "AVG_FREEZE_PCT_SWELL")
    private String avgFreezePctSwell;
    @Size(max = 50)
    @Column(name = "AVG_WATER_DAMAGE")
    private String avgWaterDamage;
    @Size(max = 50)
    @Column(name = "AVG_AGG_DAMAGE")
    private String avgAggDamage;
    @Size(max = 50)
    @Column(name = "TSR")
    private String tsr;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 20)
    @Column(name = "TRIAL_NO")
    private String trialNo;
    @Size(max = 50)
    @Column(name = "SPECIMENNO")
    private String specimenno;
    @Size(max = 50)
    @Column(name = "HEIGHT")
    private String height;
    @Size(max = 50)
    @Column(name = "WTAIR")
    private String wtair;
    @Size(max = 50)
    @Column(name = "WTSUBMERGED")
    private String wtsubmerged;
    @Size(max = 50)
    @Column(name = "SSDWT")
    private String ssdwt;
    @Size(max = 50)
    @Column(name = "THEOMAXSPGR")
    private String theomaxspgr;
    @Size(max = 50)
    @Column(name = "LOADING")
    private String loading;
    @Size(max = 50)
    @Column(name = "BULKSPECGRAV")
    private String bulkspecgrav;
    @Size(max = 50)
    @Column(name = "PERVOID")
    private String pervoid;
    @Size(max = 50)
    @Column(name = "TENSSTR")
    private String tensstr;
    @Size(max = 50)
    @Column(name = "VOLUME")
    private String volume;
    @Size(max = 50)
    @Column(name = "VOIDS_VOLUME")
    private String voidsVolume;
    @Size(max = 50)
    @Column(name = "SATURATED_WATER_MASS")
    private String saturatedWaterMass;
    @Size(max = 50)
    @Column(name = "SATURATED_SSD_MASS")
    private String saturatedSsdMass;
    @Size(max = 50)
    @Column(name = "SATURATED_VOLUME")
    private String saturatedVolume;
    @Size(max = 50)
    @Column(name = "SATURATED_VOL_ABSORBED_WATER")
    private String saturatedVolAbsorbedWater;
    @Size(max = 50)
    @Column(name = "SATURATED_PCT_SATURATION")
    private String saturatedPctSaturation;
    @Size(max = 50)
    @Column(name = "SATURATED_PCT_SWELL")
    private String saturatedPctSwell;
    @Size(max = 50)
    @Column(name = "FREEZE_HEIGHT")
    private String freezeHeight;
    @Size(max = 50)
    @Column(name = "FREEZE_WATER_MASS")
    private String freezeWaterMass;
    @Size(max = 50)
    @Column(name = "FREEZE_MASS_AT_SSD")
    private String freezeMassAtSsd;
    @Size(max = 50)
    @Column(name = "FREEZE_VOLUME")
    private String freezeVolume;
    @Size(max = 50)
    @Column(name = "FREEZE_VOL_ABSORBED_WATER")
    private String freezeVolAbsorbedWater;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
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
    @Size(max = 331)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 92)
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
    @Column(name = "COMPMETHOD")
    private String compmethod;
    @Size(max = 50)
    @Column(name = "AC")
    private String ac;
    @Size(max = 50)
    @Column(name = "AC_ADDITIVE")
    private String acAdditive;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "TESTEDBY")
    private String testedby;
    @Size(max = 50)
    @Column(name = "RETTENSTR")
    private String rettenstr;
    @Size(max = 50)
    @Column(name = "AVGCONTROL")
    private String avgcontrol;
    @Size(max = 50)
    @Column(name = "AVGCONDITION")
    private String avgcondition;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 250)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "MIX_DESIGNATION")
    private String mixDesignation;
    @Size(max = 50)
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "HEIGHT_VACUUM")
    private String heightVacuum;
    @Size(max = 50)
    @Column(name = "SATURATION_TIME")
    private String saturationTime;
    @Size(max = 50)
    @Column(name = "AVG_DRY_HEIGHT")
    private String avgDryHeight;
    @Size(max = 50)
    @Column(name = "AVG_DRY_WTAIR")
    private String avgDryWtair;

    public DotTsrT283() {
    }

    public String getFreezeLoad() {
        return freezeLoad;
    }

    public void setFreezeLoad(String freezeLoad) {
        this.freezeLoad = freezeLoad;
    }

    public String getFreezeWetStrength() {
        return freezeWetStrength;
    }

    public void setFreezeWetStrength(String freezeWetStrength) {
        this.freezeWetStrength = freezeWetStrength;
    }

    public String getFreezePctSaturation() {
        return freezePctSaturation;
    }

    public void setFreezePctSaturation(String freezePctSaturation) {
        this.freezePctSaturation = freezePctSaturation;
    }

    public String getFreezePctSwell() {
        return freezePctSwell;
    }

    public void setFreezePctSwell(String freezePctSwell) {
        this.freezePctSwell = freezePctSwell;
    }

    public String getWaterDamage() {
        return waterDamage;
    }

    public void setWaterDamage(String waterDamage) {
        this.waterDamage = waterDamage;
    }

    public String getAggDamage() {
        return aggDamage;
    }

    public void setAggDamage(String aggDamage) {
        this.aggDamage = aggDamage;
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

    public String getAvgDryWtsubmerged() {
        return avgDryWtsubmerged;
    }

    public void setAvgDryWtsubmerged(String avgDryWtsubmerged) {
        this.avgDryWtsubmerged = avgDryWtsubmerged;
    }

    public String getAvgDrySsdwt() {
        return avgDrySsdwt;
    }

    public void setAvgDrySsdwt(String avgDrySsdwt) {
        this.avgDrySsdwt = avgDrySsdwt;
    }

    public String getAvgDryVolume() {
        return avgDryVolume;
    }

    public void setAvgDryVolume(String avgDryVolume) {
        this.avgDryVolume = avgDryVolume;
    }

    public String getAvgDryBulkspecgrav() {
        return avgDryBulkspecgrav;
    }

    public void setAvgDryBulkspecgrav(String avgDryBulkspecgrav) {
        this.avgDryBulkspecgrav = avgDryBulkspecgrav;
    }

    public String getAvgDryPervoid() {
        return avgDryPervoid;
    }

    public void setAvgDryPervoid(String avgDryPervoid) {
        this.avgDryPervoid = avgDryPervoid;
    }

    public String getAvgDryVoidsVolume() {
        return avgDryVoidsVolume;
    }

    public void setAvgDryVoidsVolume(String avgDryVoidsVolume) {
        this.avgDryVoidsVolume = avgDryVoidsVolume;
    }

    public String getAvgDryLoading() {
        return avgDryLoading;
    }

    public void setAvgDryLoading(String avgDryLoading) {
        this.avgDryLoading = avgDryLoading;
    }

    public String getAvgDryTensstr() {
        return avgDryTensstr;
    }

    public void setAvgDryTensstr(String avgDryTensstr) {
        this.avgDryTensstr = avgDryTensstr;
    }

    public String getAvgWetHeight() {
        return avgWetHeight;
    }

    public void setAvgWetHeight(String avgWetHeight) {
        this.avgWetHeight = avgWetHeight;
    }

    public String getAvgWetWtair() {
        return avgWetWtair;
    }

    public void setAvgWetWtair(String avgWetWtair) {
        this.avgWetWtair = avgWetWtair;
    }

    public String getAvgWetWtsubmerged() {
        return avgWetWtsubmerged;
    }

    public void setAvgWetWtsubmerged(String avgWetWtsubmerged) {
        this.avgWetWtsubmerged = avgWetWtsubmerged;
    }

    public String getAvgWetSsdwt() {
        return avgWetSsdwt;
    }

    public void setAvgWetSsdwt(String avgWetSsdwt) {
        this.avgWetSsdwt = avgWetSsdwt;
    }

    public String getAvgWetVolume() {
        return avgWetVolume;
    }

    public void setAvgWetVolume(String avgWetVolume) {
        this.avgWetVolume = avgWetVolume;
    }

    public String getAvgWetBulkspecgrav() {
        return avgWetBulkspecgrav;
    }

    public void setAvgWetBulkspecgrav(String avgWetBulkspecgrav) {
        this.avgWetBulkspecgrav = avgWetBulkspecgrav;
    }

    public String getAvgWetPervoid() {
        return avgWetPervoid;
    }

    public void setAvgWetPervoid(String avgWetPervoid) {
        this.avgWetPervoid = avgWetPervoid;
    }

    public String getAvgWetVoidsVolume() {
        return avgWetVoidsVolume;
    }

    public void setAvgWetVoidsVolume(String avgWetVoidsVolume) {
        this.avgWetVoidsVolume = avgWetVoidsVolume;
    }

    public String getAvgSaturatedWaterMass() {
        return avgSaturatedWaterMass;
    }

    public void setAvgSaturatedWaterMass(String avgSaturatedWaterMass) {
        this.avgSaturatedWaterMass = avgSaturatedWaterMass;
    }

    public String getAvgSaturatedSsdMass() {
        return avgSaturatedSsdMass;
    }

    public void setAvgSaturatedSsdMass(String avgSaturatedSsdMass) {
        this.avgSaturatedSsdMass = avgSaturatedSsdMass;
    }

    public String getAvgSaturatedVolume() {
        return avgSaturatedVolume;
    }

    public void setAvgSaturatedVolume(String avgSaturatedVolume) {
        this.avgSaturatedVolume = avgSaturatedVolume;
    }

    public String getAvgSaturatedVolAbsorbWater() {
        return avgSaturatedVolAbsorbWater;
    }

    public void setAvgSaturatedVolAbsorbWater(String avgSaturatedVolAbsorbWater) {
        this.avgSaturatedVolAbsorbWater = avgSaturatedVolAbsorbWater;
    }

    public String getAvgSaturatedPctSaturation() {
        return avgSaturatedPctSaturation;
    }

    public void setAvgSaturatedPctSaturation(String avgSaturatedPctSaturation) {
        this.avgSaturatedPctSaturation = avgSaturatedPctSaturation;
    }

    public String getAvgSaturatedPctSwell() {
        return avgSaturatedPctSwell;
    }

    public void setAvgSaturatedPctSwell(String avgSaturatedPctSwell) {
        this.avgSaturatedPctSwell = avgSaturatedPctSwell;
    }

    public String getAvgFreezeHeight() {
        return avgFreezeHeight;
    }

    public void setAvgFreezeHeight(String avgFreezeHeight) {
        this.avgFreezeHeight = avgFreezeHeight;
    }

    public String getAvgFreezeWaterMass() {
        return avgFreezeWaterMass;
    }

    public void setAvgFreezeWaterMass(String avgFreezeWaterMass) {
        this.avgFreezeWaterMass = avgFreezeWaterMass;
    }

    public String getAvgFreezeMassAtSsd() {
        return avgFreezeMassAtSsd;
    }

    public void setAvgFreezeMassAtSsd(String avgFreezeMassAtSsd) {
        this.avgFreezeMassAtSsd = avgFreezeMassAtSsd;
    }

    public String getAvgFreezeVolume() {
        return avgFreezeVolume;
    }

    public void setAvgFreezeVolume(String avgFreezeVolume) {
        this.avgFreezeVolume = avgFreezeVolume;
    }

    public String getAvgFreezeVolAbsorbWater() {
        return avgFreezeVolAbsorbWater;
    }

    public void setAvgFreezeVolAbsorbWater(String avgFreezeVolAbsorbWater) {
        this.avgFreezeVolAbsorbWater = avgFreezeVolAbsorbWater;
    }

    public String getAvgFreezeLoad() {
        return avgFreezeLoad;
    }

    public void setAvgFreezeLoad(String avgFreezeLoad) {
        this.avgFreezeLoad = avgFreezeLoad;
    }

    public String getAvgFreezeWetStrength() {
        return avgFreezeWetStrength;
    }

    public void setAvgFreezeWetStrength(String avgFreezeWetStrength) {
        this.avgFreezeWetStrength = avgFreezeWetStrength;
    }

    public String getAvgFreezePctSaturation() {
        return avgFreezePctSaturation;
    }

    public void setAvgFreezePctSaturation(String avgFreezePctSaturation) {
        this.avgFreezePctSaturation = avgFreezePctSaturation;
    }

    public String getAvgFreezePctSwell() {
        return avgFreezePctSwell;
    }

    public void setAvgFreezePctSwell(String avgFreezePctSwell) {
        this.avgFreezePctSwell = avgFreezePctSwell;
    }

    public String getAvgWaterDamage() {
        return avgWaterDamage;
    }

    public void setAvgWaterDamage(String avgWaterDamage) {
        this.avgWaterDamage = avgWaterDamage;
    }

    public String getAvgAggDamage() {
        return avgAggDamage;
    }

    public void setAvgAggDamage(String avgAggDamage) {
        this.avgAggDamage = avgAggDamage;
    }

    public String getTsr() {
        return tsr;
    }

    public void setTsr(String tsr) {
        this.tsr = tsr;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getTrialNo() {
        return trialNo;
    }

    public void setTrialNo(String trialNo) {
        this.trialNo = trialNo;
    }

    public String getSpecimenno() {
        return specimenno;
    }

    public void setSpecimenno(String specimenno) {
        this.specimenno = specimenno;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWtair() {
        return wtair;
    }

    public void setWtair(String wtair) {
        this.wtair = wtair;
    }

    public String getWtsubmerged() {
        return wtsubmerged;
    }

    public void setWtsubmerged(String wtsubmerged) {
        this.wtsubmerged = wtsubmerged;
    }

    public String getSsdwt() {
        return ssdwt;
    }

    public void setSsdwt(String ssdwt) {
        this.ssdwt = ssdwt;
    }

    public String getTheomaxspgr() {
        return theomaxspgr;
    }

    public void setTheomaxspgr(String theomaxspgr) {
        this.theomaxspgr = theomaxspgr;
    }

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public String getBulkspecgrav() {
        return bulkspecgrav;
    }

    public void setBulkspecgrav(String bulkspecgrav) {
        this.bulkspecgrav = bulkspecgrav;
    }

    public String getPervoid() {
        return pervoid;
    }

    public void setPervoid(String pervoid) {
        this.pervoid = pervoid;
    }

    public String getTensstr() {
        return tensstr;
    }

    public void setTensstr(String tensstr) {
        this.tensstr = tensstr;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVoidsVolume() {
        return voidsVolume;
    }

    public void setVoidsVolume(String voidsVolume) {
        this.voidsVolume = voidsVolume;
    }

    public String getSaturatedWaterMass() {
        return saturatedWaterMass;
    }

    public void setSaturatedWaterMass(String saturatedWaterMass) {
        this.saturatedWaterMass = saturatedWaterMass;
    }

    public String getSaturatedSsdMass() {
        return saturatedSsdMass;
    }

    public void setSaturatedSsdMass(String saturatedSsdMass) {
        this.saturatedSsdMass = saturatedSsdMass;
    }

    public String getSaturatedVolume() {
        return saturatedVolume;
    }

    public void setSaturatedVolume(String saturatedVolume) {
        this.saturatedVolume = saturatedVolume;
    }

    public String getSaturatedVolAbsorbedWater() {
        return saturatedVolAbsorbedWater;
    }

    public void setSaturatedVolAbsorbedWater(String saturatedVolAbsorbedWater) {
        this.saturatedVolAbsorbedWater = saturatedVolAbsorbedWater;
    }

    public String getSaturatedPctSaturation() {
        return saturatedPctSaturation;
    }

    public void setSaturatedPctSaturation(String saturatedPctSaturation) {
        this.saturatedPctSaturation = saturatedPctSaturation;
    }

    public String getSaturatedPctSwell() {
        return saturatedPctSwell;
    }

    public void setSaturatedPctSwell(String saturatedPctSwell) {
        this.saturatedPctSwell = saturatedPctSwell;
    }

    public String getFreezeHeight() {
        return freezeHeight;
    }

    public void setFreezeHeight(String freezeHeight) {
        this.freezeHeight = freezeHeight;
    }

    public String getFreezeWaterMass() {
        return freezeWaterMass;
    }

    public void setFreezeWaterMass(String freezeWaterMass) {
        this.freezeWaterMass = freezeWaterMass;
    }

    public String getFreezeMassAtSsd() {
        return freezeMassAtSsd;
    }

    public void setFreezeMassAtSsd(String freezeMassAtSsd) {
        this.freezeMassAtSsd = freezeMassAtSsd;
    }

    public String getFreezeVolume() {
        return freezeVolume;
    }

    public void setFreezeVolume(String freezeVolume) {
        this.freezeVolume = freezeVolume;
    }

    public String getFreezeVolAbsorbedWater() {
        return freezeVolAbsorbedWater;
    }

    public void setFreezeVolAbsorbedWater(String freezeVolAbsorbedWater) {
        this.freezeVolAbsorbedWater = freezeVolAbsorbedWater;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public String getCompmethod() {
        return compmethod;
    }

    public void setCompmethod(String compmethod) {
        this.compmethod = compmethod;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAcAdditive() {
        return acAdditive;
    }

    public void setAcAdditive(String acAdditive) {
        this.acAdditive = acAdditive;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestedby() {
        return testedby;
    }

    public void setTestedby(String testedby) {
        this.testedby = testedby;
    }

    public String getRettenstr() {
        return rettenstr;
    }

    public void setRettenstr(String rettenstr) {
        this.rettenstr = rettenstr;
    }

    public String getAvgcontrol() {
        return avgcontrol;
    }

    public void setAvgcontrol(String avgcontrol) {
        this.avgcontrol = avgcontrol;
    }

    public String getAvgcondition() {
        return avgcondition;
    }

    public void setAvgcondition(String avgcondition) {
        this.avgcondition = avgcondition;
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

    public String getMixDesignation() {
        return mixDesignation;
    }

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getHeightVacuum() {
        return heightVacuum;
    }

    public void setHeightVacuum(String heightVacuum) {
        this.heightVacuum = heightVacuum;
    }

    public String getSaturationTime() {
        return saturationTime;
    }

    public void setSaturationTime(String saturationTime) {
        this.saturationTime = saturationTime;
    }

    public String getAvgDryHeight() {
        return avgDryHeight;
    }

    public void setAvgDryHeight(String avgDryHeight) {
        this.avgDryHeight = avgDryHeight;
    }

    public String getAvgDryWtair() {
        return avgDryWtair;
    }

    public void setAvgDryWtair(String avgDryWtair) {
        this.avgDryWtair = avgDryWtair;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
