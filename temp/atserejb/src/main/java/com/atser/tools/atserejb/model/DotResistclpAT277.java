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
@Table(name = "DOT_RESISTCLP_A_T277", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotResistclpAT277.findAll", query = "SELECT a FROM DotResistclpAT277 a")})
public class DotResistclpAT277 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 50)
    @Column(name = "CONDITIONING_START_DATE")
    private String conditioningStartDate;
    @Size(max = 50)
    @Column(name = "ALLOW_DRY_AIR_FROM")
    private String allowDryAirFrom;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "ALLOW_DRY_AIR_TO")
    private String allowDryAirTo;
    @Size(max = 50)
    @Column(name = "RAPID_COATING_FROM")
    private String rapidCoatingFrom;
    @Size(max = 50)
    @Column(name = "RAPID_COATING_TO")
    private String rapidCoatingTo;
    @Size(max = 50)
    @Column(name = "BEAKER_VACUUM_FROM")
    private String beakerVacuumFrom;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "BEAKER_VACUUM_TO")
    private String beakerVacuumTo;
    @Size(max = 50)
    @Column(name = "VACUUM_COVER_FROM")
    private String vacuumCoverFrom;
    @Size(max = 50)
    @Column(name = "CYLINDER_1_SUM")
    private String cylinder1Sum;
    @Size(max = 50)
    @Column(name = "VACUUM_COVER_TO")
    private String vacuumCoverTo;
    @Size(max = 50)
    @Column(name = "CYLINDER_2_SUM")
    private String cylinder2Sum;
    @Size(max = 50)
    @Column(name = "SOAK_UNDER_WATER_FROM")
    private String soakUnderWaterFrom;
    @Size(max = 50)
    @Column(name = "CYLINDER_3_SUM")
    private String cylinder3Sum;
    @Size(max = 50)
    @Column(name = "SOAK_UNDER_WATER_TO")
    private String soakUnderWaterTo;
    @Size(max = 50)
    @Column(name = "SET_AVERAGE")
    private String setAverage;
    @Size(max = 50)
    @Column(name = "CORR_DIAMETER")
    private String corrDiameter;
    @Size(max = 50)
    @Column(name = "CORR_CHARGE")
    private String corrCharge;
    @Size(max = 50)
    @Column(name = "AGE_DAYS")
    private String ageDays;
    @Size(max = 50)
    @Column(name = "PENETRABILITY")
    private String penetrability;
    @Size(max = 50)
    @Column(name = "CURING_METHOD")
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "CYLINDER_1_SPECIMEN_NO")
    private String cylinder1SpecimenNo;
    @Size(max = 50)
    @Column(name = "CYLINDER_2_SPECIMEN_NO")
    private String cylinder2SpecimenNo;
    @Size(max = 50)
    @Column(name = "CYLINDER_3_SPECIMEN_NO")
    private String cylinder3SpecimenNo;
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
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 327)
    @Column(name = "TESTNO")
    private String testno;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 50)
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

    public DotResistclpAT277() {
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

    public String getConditioningStartDate() {
        return conditioningStartDate;
    }

    public void setConditioningStartDate(String conditioningStartDate) {
        this.conditioningStartDate = conditioningStartDate;
    }

    public String getAllowDryAirFrom() {
        return allowDryAirFrom;
    }

    public void setAllowDryAirFrom(String allowDryAirFrom) {
        this.allowDryAirFrom = allowDryAirFrom;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAllowDryAirTo() {
        return allowDryAirTo;
    }

    public void setAllowDryAirTo(String allowDryAirTo) {
        this.allowDryAirTo = allowDryAirTo;
    }

    public String getRapidCoatingFrom() {
        return rapidCoatingFrom;
    }

    public void setRapidCoatingFrom(String rapidCoatingFrom) {
        this.rapidCoatingFrom = rapidCoatingFrom;
    }

    public String getRapidCoatingTo() {
        return rapidCoatingTo;
    }

    public void setRapidCoatingTo(String rapidCoatingTo) {
        this.rapidCoatingTo = rapidCoatingTo;
    }

    public String getBeakerVacuumFrom() {
        return beakerVacuumFrom;
    }

    public void setBeakerVacuumFrom(String beakerVacuumFrom) {
        this.beakerVacuumFrom = beakerVacuumFrom;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getBeakerVacuumTo() {
        return beakerVacuumTo;
    }

    public void setBeakerVacuumTo(String beakerVacuumTo) {
        this.beakerVacuumTo = beakerVacuumTo;
    }

    public String getVacuumCoverFrom() {
        return vacuumCoverFrom;
    }

    public void setVacuumCoverFrom(String vacuumCoverFrom) {
        this.vacuumCoverFrom = vacuumCoverFrom;
    }

    public String getCylinder1Sum() {
        return cylinder1Sum;
    }

    public void setCylinder1Sum(String cylinder1Sum) {
        this.cylinder1Sum = cylinder1Sum;
    }

    public String getVacuumCoverTo() {
        return vacuumCoverTo;
    }

    public void setVacuumCoverTo(String vacuumCoverTo) {
        this.vacuumCoverTo = vacuumCoverTo;
    }

    public String getCylinder2Sum() {
        return cylinder2Sum;
    }

    public void setCylinder2Sum(String cylinder2Sum) {
        this.cylinder2Sum = cylinder2Sum;
    }

    public String getSoakUnderWaterFrom() {
        return soakUnderWaterFrom;
    }

    public void setSoakUnderWaterFrom(String soakUnderWaterFrom) {
        this.soakUnderWaterFrom = soakUnderWaterFrom;
    }

    public String getCylinder3Sum() {
        return cylinder3Sum;
    }

    public void setCylinder3Sum(String cylinder3Sum) {
        this.cylinder3Sum = cylinder3Sum;
    }

    public String getSoakUnderWaterTo() {
        return soakUnderWaterTo;
    }

    public void setSoakUnderWaterTo(String soakUnderWaterTo) {
        this.soakUnderWaterTo = soakUnderWaterTo;
    }

    public String getSetAverage() {
        return setAverage;
    }

    public void setSetAverage(String setAverage) {
        this.setAverage = setAverage;
    }

    public String getCorrDiameter() {
        return corrDiameter;
    }

    public void setCorrDiameter(String corrDiameter) {
        this.corrDiameter = corrDiameter;
    }

    public String getCorrCharge() {
        return corrCharge;
    }

    public void setCorrCharge(String corrCharge) {
        this.corrCharge = corrCharge;
    }

    public String getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(String ageDays) {
        this.ageDays = ageDays;
    }

    public String getPenetrability() {
        return penetrability;
    }

    public void setPenetrability(String penetrability) {
        this.penetrability = penetrability;
    }

    public String getCuringMethod() {
        return curingMethod;
    }

    public void setCuringMethod(String curingMethod) {
        this.curingMethod = curingMethod;
    }

    public String getCylinder1SpecimenNo() {
        return cylinder1SpecimenNo;
    }

    public void setCylinder1SpecimenNo(String cylinder1SpecimenNo) {
        this.cylinder1SpecimenNo = cylinder1SpecimenNo;
    }

    public String getCylinder2SpecimenNo() {
        return cylinder2SpecimenNo;
    }

    public void setCylinder2SpecimenNo(String cylinder2SpecimenNo) {
        this.cylinder2SpecimenNo = cylinder2SpecimenNo;
    }

    public String getCylinder3SpecimenNo() {
        return cylinder3SpecimenNo;
    }

    public void setCylinder3SpecimenNo(String cylinder3SpecimenNo) {
        this.cylinder3SpecimenNo = cylinder3SpecimenNo;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
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

    @JsonSkipXssSerialization
    public String getTestno() {
        if (StringSupport.isNotNullAndNotEmpty(testno) && testno.contains("../../")) {
            return testno.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testno;
    }
}
