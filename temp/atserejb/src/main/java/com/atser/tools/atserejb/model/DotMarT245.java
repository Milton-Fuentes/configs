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
@Table(name = "DOT_MAR_T245", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotMarT245.findAll", query = "SELECT a FROM DotMarT245 a")})
public class DotMarT245 implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "METHOD")
    private String method;
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 255)
    @Column(name = "SEGMENT")
    private String segment;
    @Size(max = 255)
    @Column(name = "STATION_NO")
    private String stationNo;
    @Size(max = 255)
    @Column(name = "MIX_DESIGNATION")
    private String mixDesignation;
    @Column(name = "LOT_NO")
    private BigDecimal lotNo;
    @Column(name = "NB_BLOWS")
    private BigDecimal nbBlows;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "DEPART_LAB")
    private String departLab;
    @Size(max = 50)
    @Column(name = "ARRIVE_SITE")
    private String arriveSite;
    @Size(max = 50)
    @Column(name = "LUNCH_HOURS")
    private String lunchHours;
    @Size(max = 50)
    @Column(name = "LUNCH_MINS")
    private String lunchMins;
    @Size(max = 50)
    @Column(name = "DEPART_SITE")
    private String departSite;
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB")
    private String arriveLab;
    @Size(max = 50)
    @Column(name = "TOTAL_HOURS")
    private String totalHours;
    @Column(name = "TECHNICIAN_HOURS_OVERTIME")
    private BigInteger technicianHoursOvertime;
    @Column(name = "AC_TEST_ID")
    private BigDecimal acTestId;
    @Size(max = 50)
    @Column(name = "TRIAL_NO")
    private String trialNo;
    @Size(max = 50)
    @Column(name = "THICKNESS")
    private String thickness;
    @Size(max = 50)
    @Column(name = "STAB")
    private String stab;
    @Size(max = 50)
    @Column(name = "FLOW")
    private String flow;
    @Size(max = 50)
    @Column(name = "CORFACTOR")
    private String corfactor;
    @Size(max = 50)
    @Column(name = "STABCOR")
    private String stabcor;
    @Size(max = 50)
    @Column(name = "VOLM")
    private String volm;
    @Size(max = 50)
    @Column(name = "TEST_TEMPERATURE")
    private String testTemperature;
    @Size(max = 50)
    @Column(name = "MAXIMUM_LOAD_DIAL_READING")
    private String maximumLoadDialReading;
    @Size(max = 50)
    @Column(name = "AC")
    private String ac;
    @Column(name = "SUBLOT_NO")
    private BigDecimal sublotNo;
    @Size(max = 50)
    @Column(name = "AVGSTAB")
    private String avgstab;
    @Size(max = 50)
    @Column(name = "AVGFLOW")
    private String avgflow;
    @Size(max = 50)
    @Column(name = "BEARINGCAP")
    private String bearingcap;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 50)
    @Column(name = "FLOW_SPEC_MIN")
    private String flowSpecMin;
    @Size(max = 50)
    @Column(name = "FLOW_SPEC_MAX")
    private String flowSpecMax;
    @Size(max = 50)
    @Column(name = "FLOW_RESULT")
    private String flowResult;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
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
    @Size(max = 354)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;

    public DotMarT245() {
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUnitengmet() {
        return unitengmet;
    }

    public void setUnitengmet(String unitengmet) {
        this.unitengmet = unitengmet;
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

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public BigDecimal getLotNo() {
        return lotNo;
    }

    public void setLotNo(BigDecimal lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getNbBlows() {
        return nbBlows;
    }

    public void setNbBlows(BigDecimal nbBlows) {
        this.nbBlows = nbBlows;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDepartLab() {
        return departLab;
    }

    public void setDepartLab(String departLab) {
        this.departLab = departLab;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    public void setArriveSite(String arriveSite) {
        this.arriveSite = arriveSite;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public String getLunchMins() {
        return lunchMins;
    }

    public void setLunchMins(String lunchMins) {
        this.lunchMins = lunchMins;
    }

    public String getDepartSite() {
        return departSite;
    }

    public void setDepartSite(String departSite) {
        this.departSite = departSite;
    }

    public String getArriveLab() {
        return arriveLab;
    }

    public void setArriveLab(String arriveLab) {
        this.arriveLab = arriveLab;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public BigInteger getTechnicianHoursOvertime() {
        return technicianHoursOvertime;
    }

    public void setTechnicianHoursOvertime(BigInteger technicianHoursOvertime) {
        this.technicianHoursOvertime = technicianHoursOvertime;
    }

    public BigDecimal getAcTestId() {
        return acTestId;
    }

    public void setAcTestId(BigDecimal acTestId) {
        this.acTestId = acTestId;
    }

    public String getTrialNo() {
        return trialNo;
    }

    public void setTrialNo(String trialNo) {
        this.trialNo = trialNo;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getStab() {
        return stab;
    }

    public void setStab(String stab) {
        this.stab = stab;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getCorfactor() {
        return corfactor;
    }

    public void setCorfactor(String corfactor) {
        this.corfactor = corfactor;
    }

    public String getStabcor() {
        return stabcor;
    }

    public void setStabcor(String stabcor) {
        this.stabcor = stabcor;
    }

    public String getVolm() {
        return volm;
    }

    public void setVolm(String volm) {
        this.volm = volm;
    }

    public String getTestTemperature() {
        return testTemperature;
    }

    public void setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
    }

    public String getMaximumLoadDialReading() {
        return maximumLoadDialReading;
    }

    public void setMaximumLoadDialReading(String maximumLoadDialReading) {
        this.maximumLoadDialReading = maximumLoadDialReading;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public BigDecimal getSublotNo() {
        return sublotNo;
    }

    public void setSublotNo(BigDecimal sublotNo) {
        this.sublotNo = sublotNo;
    }

    public String getAvgstab() {
        return avgstab;
    }

    public void setAvgstab(String avgstab) {
        this.avgstab = avgstab;
    }

    public String getAvgflow() {
        return avgflow;
    }

    public void setAvgflow(String avgflow) {
        this.avgflow = avgflow;
    }

    public String getBearingcap() {
        return bearingcap;
    }

    public void setBearingcap(String bearingcap) {
        this.bearingcap = bearingcap;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFlowSpecMin() {
        return flowSpecMin;
    }

    public void setFlowSpecMin(String flowSpecMin) {
        this.flowSpecMin = flowSpecMin;
    }

    public String getFlowSpecMax() {
        return flowSpecMax;
    }

    public void setFlowSpecMax(String flowSpecMax) {
        this.flowSpecMax = flowSpecMax;
    }

    public String getFlowResult() {
        return flowResult;
    }

    public void setFlowResult(String flowResult) {
        this.flowResult = flowResult;
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
