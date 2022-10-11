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
@Table(name = "DOT_WC_T318", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotWcT318.findAll", query = "SELECT a FROM DotWcT318 a")})
public class DotWcT318 implements Serializable {

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
    @Size(max = 12)
    @Column(name = "BATCH_SIZE")
    private String batchSize;
    @Size(max = 12)
    @Column(name = "FINE_AGG")
    private String fineAgg;
    @Size(max = 12)
    @Column(name = "FINE_AGG_MOIST")
    private String fineAggMoist;
    @Size(max = 12)
    @Column(name = "COARSE_AGG")
    private String coarseAgg;
    @Size(max = 12)
    @Column(name = "COARSE_AGG_MOIST")
    private String coarseAggMoist;
    @Size(max = 12)
    @Column(name = "UNIT_WEIGHT")
    private String unitWeight;
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
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 315)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "EST_MIXING_WATER_CONTENT")
    private String estMixingWaterContent;
    @Size(max = 50)
    @Column(name = "EST_ABSORBED_WATER_CONTENT")
    private String estAbsorbedWaterContent;
    @Size(max = 50)
    @Column(name = "TECH_ID")
    private String techId;
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
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TRAY_CLOTH_WET_SAMPLE")
    private String trayClothWetSample;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 50)
    @Column(name = "SAMPLE_TRAY_CLOTH_DRY_SAMPLE")
    private String sampleTrayClothDrySample;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT1")
    private String sampleWeight1;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT2")
    private String sampleWeight2;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT3")
    private String sampleWeight3;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT4")
    private String sampleWeight4;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT5")
    private String sampleWeight5;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT6")
    private String sampleWeight6;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT7")
    private String sampleWeight7;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT8")
    private String sampleWeight8;
    @Size(max = 50)
    @Column(name = "SAMPLE_WEIGHT9")
    private String sampleWeight9;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "TOTAL_MEAS_WATER_CONTENT")
    private String totalMeasWaterContent;
    @Size(max = 50)
    @Column(name = "TRAY_CLOTH")
    private String trayCloth;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotWcT318() {
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

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getFineAgg() {
        return fineAgg;
    }

    public void setFineAgg(String fineAgg) {
        this.fineAgg = fineAgg;
    }

    public String getFineAggMoist() {
        return fineAggMoist;
    }

    public void setFineAggMoist(String fineAggMoist) {
        this.fineAggMoist = fineAggMoist;
    }

    public String getCoarseAgg() {
        return coarseAgg;
    }

    public void setCoarseAgg(String coarseAgg) {
        this.coarseAgg = coarseAgg;
    }

    public String getCoarseAggMoist() {
        return coarseAggMoist;
    }

    public void setCoarseAggMoist(String coarseAggMoist) {
        this.coarseAggMoist = coarseAggMoist;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
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

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
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

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getEstMixingWaterContent() {
        return estMixingWaterContent;
    }

    public void setEstMixingWaterContent(String estMixingWaterContent) {
        this.estMixingWaterContent = estMixingWaterContent;
    }

    public String getEstAbsorbedWaterContent() {
        return estAbsorbedWaterContent;
    }

    public void setEstAbsorbedWaterContent(String estAbsorbedWaterContent) {
        this.estAbsorbedWaterContent = estAbsorbedWaterContent;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
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

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getTrayClothWetSample() {
        return trayClothWetSample;
    }

    public void setTrayClothWetSample(String trayClothWetSample) {
        this.trayClothWetSample = trayClothWetSample;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSampleTrayClothDrySample() {
        return sampleTrayClothDrySample;
    }

    public void setSampleTrayClothDrySample(String sampleTrayClothDrySample) {
        this.sampleTrayClothDrySample = sampleTrayClothDrySample;
    }

    public String getSampleWeight1() {
        return sampleWeight1;
    }

    public void setSampleWeight1(String sampleWeight1) {
        this.sampleWeight1 = sampleWeight1;
    }

    public String getSampleWeight2() {
        return sampleWeight2;
    }

    public void setSampleWeight2(String sampleWeight2) {
        this.sampleWeight2 = sampleWeight2;
    }

    public String getSampleWeight3() {
        return sampleWeight3;
    }

    public void setSampleWeight3(String sampleWeight3) {
        this.sampleWeight3 = sampleWeight3;
    }

    public String getSampleWeight4() {
        return sampleWeight4;
    }

    public void setSampleWeight4(String sampleWeight4) {
        this.sampleWeight4 = sampleWeight4;
    }

    public String getSampleWeight5() {
        return sampleWeight5;
    }

    public void setSampleWeight5(String sampleWeight5) {
        this.sampleWeight5 = sampleWeight5;
    }

    public String getSampleWeight6() {
        return sampleWeight6;
    }

    public void setSampleWeight6(String sampleWeight6) {
        this.sampleWeight6 = sampleWeight6;
    }

    public String getSampleWeight7() {
        return sampleWeight7;
    }

    public void setSampleWeight7(String sampleWeight7) {
        this.sampleWeight7 = sampleWeight7;
    }

    public String getSampleWeight8() {
        return sampleWeight8;
    }

    public void setSampleWeight8(String sampleWeight8) {
        this.sampleWeight8 = sampleWeight8;
    }

    public String getSampleWeight9() {
        return sampleWeight9;
    }

    public void setSampleWeight9(String sampleWeight9) {
        this.sampleWeight9 = sampleWeight9;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getTotalMeasWaterContent() {
        return totalMeasWaterContent;
    }

    public void setTotalMeasWaterContent(String totalMeasWaterContent) {
        this.totalMeasWaterContent = totalMeasWaterContent;
    }

    public String getTrayCloth() {
        return trayCloth;
    }

    public void setTrayCloth(String trayCloth) {
        this.trayCloth = trayCloth;
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
