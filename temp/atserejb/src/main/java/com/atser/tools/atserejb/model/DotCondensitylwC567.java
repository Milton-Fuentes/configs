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
@Table(name = "DOT_CONDENSITYLW_C567", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotCondensitylwC567.findAll", query = "SELECT a FROM DotCondensitylwC567 a")})
public class DotCondensitylwC567 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "SUBBIDITEM_ID")
    private BigInteger subbiditemId;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "BIDITEM_ID")
    private BigInteger biditemId;
    @Column(name = "QA_SAMPLE_ID")
    private BigInteger qaSampleId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 327)
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
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "OD_CALC_EQUILIBRIUM_DENSITY")
    private String odCalcEquilibriumDensity;
    @Size(max = 50)
    @Column(name = "OD_CALC_OVEN_DRY_DENSITY")
    private String odCalcOvenDryDensity;
    @Size(max = 50)
    @Column(name = "OD_MASS_OVEN_DRIED_CYLINDER")
    private String odMassOvenDriedCylinder;
    @Size(max = 50)
    @Column(name = "OD_MASS_SAT_SURF_DRY_CYLINDER")
    private String odMassSatSurfDryCylinder;
    @Size(max = 50)
    @Column(name = "OD_MASS_SUSP_IMMERSED_CYLINDER")
    private String odMassSuspImmersedCylinder;
    @Size(max = 50)
    @Column(name = "EQ_MEASURED_OVEN_DRY_DENSITY")
    private String eqMeasuredOvenDryDensity;
    @Size(max = 50)
    @Column(name = "EQ_MASS_DRIED_CYLINDER")
    private String eqMassDriedCylinder;
    @Size(max = 50)
    @Column(name = "EQ_MASS_SAT_SURF_DRY_CYLINDER")
    private String eqMassSatSurfDryCylinder;
    @Size(max = 50)
    @Column(name = "EQ_MASS_SUSP_IMMERSED_CYLINDER")
    private String eqMassSuspImmersedCylinder;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
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
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotCondensitylwC567() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(BigInteger subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigInteger biditemId) {
        this.biditemId = biditemId;
    }

    public BigInteger getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(BigInteger qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
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

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getOdCalcEquilibriumDensity() {
        return odCalcEquilibriumDensity;
    }

    public void setOdCalcEquilibriumDensity(String odCalcEquilibriumDensity) {
        this.odCalcEquilibriumDensity = odCalcEquilibriumDensity;
    }

    public String getOdCalcOvenDryDensity() {
        return odCalcOvenDryDensity;
    }

    public void setOdCalcOvenDryDensity(String odCalcOvenDryDensity) {
        this.odCalcOvenDryDensity = odCalcOvenDryDensity;
    }

    public String getOdMassOvenDriedCylinder() {
        return odMassOvenDriedCylinder;
    }

    public void setOdMassOvenDriedCylinder(String odMassOvenDriedCylinder) {
        this.odMassOvenDriedCylinder = odMassOvenDriedCylinder;
    }

    public String getOdMassSatSurfDryCylinder() {
        return odMassSatSurfDryCylinder;
    }

    public void setOdMassSatSurfDryCylinder(String odMassSatSurfDryCylinder) {
        this.odMassSatSurfDryCylinder = odMassSatSurfDryCylinder;
    }

    public String getOdMassSuspImmersedCylinder() {
        return odMassSuspImmersedCylinder;
    }

    public void setOdMassSuspImmersedCylinder(String odMassSuspImmersedCylinder) {
        this.odMassSuspImmersedCylinder = odMassSuspImmersedCylinder;
    }

    public String getEqMeasuredOvenDryDensity() {
        return eqMeasuredOvenDryDensity;
    }

    public void setEqMeasuredOvenDryDensity(String eqMeasuredOvenDryDensity) {
        this.eqMeasuredOvenDryDensity = eqMeasuredOvenDryDensity;
    }

    public String getEqMassDriedCylinder() {
        return eqMassDriedCylinder;
    }

    public void setEqMassDriedCylinder(String eqMassDriedCylinder) {
        this.eqMassDriedCylinder = eqMassDriedCylinder;
    }

    public String getEqMassSatSurfDryCylinder() {
        return eqMassSatSurfDryCylinder;
    }

    public void setEqMassSatSurfDryCylinder(String eqMassSatSurfDryCylinder) {
        this.eqMassSatSurfDryCylinder = eqMassSatSurfDryCylinder;
    }

    public String getEqMassSuspImmersedCylinder() {
        return eqMassSuspImmersedCylinder;
    }

    public void setEqMassSuspImmersedCylinder(String eqMassSuspImmersedCylinder) {
        this.eqMassSuspImmersedCylinder = eqMassSuspImmersedCylinder;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
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

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
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
