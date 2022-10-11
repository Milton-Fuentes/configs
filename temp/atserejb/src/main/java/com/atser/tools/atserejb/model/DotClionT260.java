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
@Table(name = "DOT_CLION_T260", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotClionT260.findAll", query = "SELECT a FROM DotClionT260 a")})
public class DotClionT260 implements Serializable {

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
    @Column(name = "SUBBIDITEM_ID")
    private Integer subbiditemId;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "MIX_DESIGN_ID")
    private Integer mixDesignId;
    @Column(name = "TEST_ID")
    private Integer testId;
    @Column(name = "LAB_ID")
    private Integer labId;
    @Column(name = "QA_SAMPLE_ID")
    private Integer qaSampleId;
    @Column(name = "BIDITEM_ID")
    private Integer biditemId;
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 24)
    @Column(name = "METHOD_CHOOSEN_NAME")
    private String methodChoosenName;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 313)
    @Column(name = "TESTNO")
    private String testNoLink;
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
    @Column(name = "AA_CL")
    private String aaCl;
    @Size(max = 50)
    @Column(name = "AA_CL_PCT")
    private String aaClPct;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
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
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "METHOD_CHOOSEN")
    private String methodChoosen;
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
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "N1")
    private String n1;
    @Size(max = 50)
    @Column(name = "N13")
    private String n13;
    @Size(max = 50)
    @Column(name = "W_MASS")
    private String wMass;
    @Size(max = 50)
    @Column(name = "V1")
    private String v1;
    @Size(max = 50)
    @Column(name = "N2")
    private String n2;
    @Size(max = 50)
    @Column(name = "V2")
    private String v2;
    @Size(max = 50)
    @Column(name = "PERCENT_CL")
    private String percentCl;
    @Size(max = 50)
    @Column(name = "GP_END_POINT_FROM_GRAPH")
    private String gpEndPointFromGraph;
    @Size(max = 50)
    @Column(name = "GP_MASS_OF_SOLUTION")
    private String gpMassOfSolution;
    @Size(max = 50)
    @Column(name = "GP_MASS_SAMPLE")
    private String gpMassSample;
    @Size(max = 50)
    @Column(name = "GP_NORMALITY_SOLUTION")
    private String gpNormalitySolution;
    @Size(max = 50)
    @Column(name = "GP_ACTUAL_END_POINT")
    private String gpActualEndPoint;
    @Size(max = 50)
    @Column(name = "PT_NORMALITY")
    private String ptNormality;
    @Size(max = 50)
    @Column(name = "PT_MASS_ORIGINAL_SAMPLE")
    private String ptMassOriginalSample;
    @Size(max = 50)
    @Column(name = "PT_END_POINT")
    private String ptEndPoint;
    @Size(max = 50)
    @Column(name = "PT_VOLUME_SOLUTION_ADDED")
    private String ptVolumeSolutionAdded;
    @Size(max = 50)
    @Column(name = "PT_NORMALITY_SOLUTION")
    private String ptNormalitySolution;
    @Size(max = 50)
    @Column(name = "PT_CL_PCT")
    private String ptClPct;
    @Size(max = 50)
    @Column(name = "AT_NORMALITY")
    private String atNormality;
    @Size(max = 50)
    @Column(name = "AT_MASS_ORIGINAL_SAMPLE")
    private String atMassOriginalSample;
    @Size(max = 50)
    @Column(name = "AT_END_POINT")
    private String atEndPoint;
    @Size(max = 50)
    @Column(name = "AT_VOLUME_SOLUTION_ADDED")
    private String atVolumeSolutionAdded;
    @Size(max = 50)
    @Column(name = "AT_NORMALITY_SOLUTION")
    private String atNormalitySolution;
    @Size(max = 50)
    @Column(name = "AT_CL_PCT")
    private String atClPct;
    @Size(max = 50)
    @Column(name = "GP_CL_PCT")
    private String gpClPct;
    @Size(max = 50)
    @Column(name = "CL_PCT")
    private String clPct;
    @Size(max = 50)
    @Column(name = "UNIT_MASS")
    private String unitMass;
    @Size(max = 50)
    @Column(name = "CL")
    private String cl;
    @Size(max = 50)
    @Column(name = "AA_VOLUME_OF_ALIQUOT")
    private String aaVolumeOfAliquot;
    @Size(max = 50)
    @Column(name = "AA_MASS_ORIGINAL_SAMPLE")
    private String aaMassOriginalSample;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotClionT260() {
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

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(Integer qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public Integer getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(Integer biditemId) {
        this.biditemId = biditemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getMethodChoosenName() {
        return methodChoosenName;
    }

    public void setMethodChoosenName(String methodChoosenName) {
        this.methodChoosenName = methodChoosenName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
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

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
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

    public String getAaCl() {
        return aaCl;
    }

    public void setAaCl(String aaCl) {
        this.aaCl = aaCl;
    }

    public String getAaClPct() {
        return aaClPct;
    }

    public void setAaClPct(String aaClPct) {
        this.aaClPct = aaClPct;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
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

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getMethodChoosen() {
        return methodChoosen;
    }

    public void setMethodChoosen(String methodChoosen) {
        this.methodChoosen = methodChoosen;
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

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public String getN13() {
        return n13;
    }

    public void setN13(String n13) {
        this.n13 = n13;
    }

    public String getwMass() {
        return wMass;
    }

    public void setwMass(String wMass) {
        this.wMass = wMass;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getN2() {
        return n2;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getPercentCl() {
        return percentCl;
    }

    public void setPercentCl(String percentCl) {
        this.percentCl = percentCl;
    }

    public String getGpEndPointFromGraph() {
        return gpEndPointFromGraph;
    }

    public void setGpEndPointFromGraph(String gpEndPointFromGraph) {
        this.gpEndPointFromGraph = gpEndPointFromGraph;
    }

    public String getGpMassOfSolution() {
        return gpMassOfSolution;
    }

    public void setGpMassOfSolution(String gpMassOfSolution) {
        this.gpMassOfSolution = gpMassOfSolution;
    }

    public String getGpMassSample() {
        return gpMassSample;
    }

    public void setGpMassSample(String gpMassSample) {
        this.gpMassSample = gpMassSample;
    }

    public String getGpNormalitySolution() {
        return gpNormalitySolution;
    }

    public void setGpNormalitySolution(String gpNormalitySolution) {
        this.gpNormalitySolution = gpNormalitySolution;
    }

    public String getGpActualEndPoint() {
        return gpActualEndPoint;
    }

    public void setGpActualEndPoint(String gpActualEndPoint) {
        this.gpActualEndPoint = gpActualEndPoint;
    }

    public String getPtNormality() {
        return ptNormality;
    }

    public void setPtNormality(String ptNormality) {
        this.ptNormality = ptNormality;
    }

    public String getPtMassOriginalSample() {
        return ptMassOriginalSample;
    }

    public void setPtMassOriginalSample(String ptMassOriginalSample) {
        this.ptMassOriginalSample = ptMassOriginalSample;
    }

    public String getPtEndPoint() {
        return ptEndPoint;
    }

    public void setPtEndPoint(String ptEndPoint) {
        this.ptEndPoint = ptEndPoint;
    }

    public String getPtVolumeSolutionAdded() {
        return ptVolumeSolutionAdded;
    }

    public void setPtVolumeSolutionAdded(String ptVolumeSolutionAdded) {
        this.ptVolumeSolutionAdded = ptVolumeSolutionAdded;
    }

    public String getPtNormalitySolution() {
        return ptNormalitySolution;
    }

    public void setPtNormalitySolution(String ptNormalitySolution) {
        this.ptNormalitySolution = ptNormalitySolution;
    }

    public String getPtClPct() {
        return ptClPct;
    }

    public void setPtClPct(String ptClPct) {
        this.ptClPct = ptClPct;
    }

    public String getAtNormality() {
        return atNormality;
    }

    public void setAtNormality(String atNormality) {
        this.atNormality = atNormality;
    }

    public String getAtMassOriginalSample() {
        return atMassOriginalSample;
    }

    public void setAtMassOriginalSample(String atMassOriginalSample) {
        this.atMassOriginalSample = atMassOriginalSample;
    }

    public String getAtEndPoint() {
        return atEndPoint;
    }

    public void setAtEndPoint(String atEndPoint) {
        this.atEndPoint = atEndPoint;
    }

    public String getAtVolumeSolutionAdded() {
        return atVolumeSolutionAdded;
    }

    public void setAtVolumeSolutionAdded(String atVolumeSolutionAdded) {
        this.atVolumeSolutionAdded = atVolumeSolutionAdded;
    }

    public String getAtNormalitySolution() {
        return atNormalitySolution;
    }

    public void setAtNormalitySolution(String atNormalitySolution) {
        this.atNormalitySolution = atNormalitySolution;
    }

    public String getAtClPct() {
        return atClPct;
    }

    public void setAtClPct(String atClPct) {
        this.atClPct = atClPct;
    }

    public String getGpClPct() {
        return gpClPct;
    }

    public void setGpClPct(String gpClPct) {
        this.gpClPct = gpClPct;
    }

    public String getClPct() {
        return clPct;
    }

    public void setClPct(String clPct) {
        this.clPct = clPct;
    }

    public String getUnitMass() {
        return unitMass;
    }

    public void setUnitMass(String unitMass) {
        this.unitMass = unitMass;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getAaVolumeOfAliquot() {
        return aaVolumeOfAliquot;
    }

    public void setAaVolumeOfAliquot(String aaVolumeOfAliquot) {
        this.aaVolumeOfAliquot = aaVolumeOfAliquot;
    }

    public String getAaMassOriginalSample() {
        return aaMassOriginalSample;
    }

    public void setAaMassOriginalSample(String aaMassOriginalSample) {
        this.aaMassOriginalSample = aaMassOriginalSample;
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
