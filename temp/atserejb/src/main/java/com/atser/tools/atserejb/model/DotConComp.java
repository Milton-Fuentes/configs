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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "DOT_CONCOMP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConComp.findAll", query = "SELECT a FROM DotConComp a")})
public class DotConComp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 50)
    @Column(name = "SAMPLEIDNO")
    private String sampleidno;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 50)
    @Column(name = "SAMPLESPERSET")
    private String samplesperset;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "CURING_METHOD")
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "SPECIMEN_COVERED")
    private String specimenCovered;
    @Size(max = 255)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Column(name = "MINTEMP")
    private BigDecimal mintemp;
    @Column(name = "MAXTEMP")
    private BigDecimal maxtemp;
    @Size(max = 50)
    @Column(name = "CYLINDER_NO")
    private String cylinderNo;
    @Size(max = 50)
    @Column(name = "LAB_STAMP_NO")
    private String labStampNo;
    @Column(name = "TESTAGE")
    private BigDecimal testage;
    @Column(name = "TESTAGE_HOURS")
    private BigDecimal testageHours;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 50)
    @Column(name = "DIAMETER")
    private String diameter;
    @Size(max = 50)
    @Column(name = "WEIGHT")
    private String weight;
    @Size(max = 50)
    @Column(name = "AREA")
    private String area;
    @Column(name = "MAXIMUMLOAD")
    private BigDecimal maximumload;
    @Column(name = "LIFTING")
    private BigDecimal lifting;
    @Size(max = 50)
    @Column(name = "TYPEOFFRACTURE")
    private String typeoffracture;
    @Size(max = 50)
    @Column(name = "TECH")
    private String tech;
    @Column(name = "COMPRESSIVESTRENGTH")
    private BigDecimal compressivestrength;
    @Size(max = 50)
    @Column(name = "BREAK_LOCATION")
    private String breakLocation;
    @Size(max = 50)
    @Column(name = "REQUIREDSTRENGTH")
    private String requiredstrength;
    @Column(name = "DISCARD_REQUIRED")
    private Character discardRequired;
    @Column(name = "DISCARD_COMPLETED")
    private Character discardCompleted;
    @Size(max = 1)
    @Column(name = "DISCARD")
    private String discard;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "RESULT_TESTAGE")
    private String resultTestage;
    @Size(max = 50)
    @Column(name = "RESULT_TESTAGE_HOURS")
    private String resultTestageHours;
    @Size(max = 50)
    @Column(name = "RESULT_SPEC_MIN")
    private String resultSpecMin;
    @Size(max = 50)
    @Column(name = "RESULT_SPEC_MAX")
    private String resultSpecMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 50)
    @Column(name = "REPORT_STAMP_TYPE")
    private String reportStampType;
    @Size(max = 50)
    @Column(name = "RESULT_AVERAGE")
    private String resultAverage;
    @Size(max = 409)
    @Column(name = "COMPLETED_BY")
    private String completedBy;
    @Size(max = 409)
    @Column(name = "REVIEW_BY")
    private String reviewBy;
    @Size(max = 409)
    @Column(name = "SIGNOFF_BY")
    private String signoffBy;
    @Size(max = 255)
    @Column(name = "DRAFT")
    private String draft;
    @Size(max = 173)
    @Column(name = "HASPHOTO")
    private String hasPhoto;
    @Column(name = "SPECIFIEDSTRENGTH")
    private BigInteger specifiedstrength;
    @JsonSkipXssSerialization
    @Size(max = 236)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 50)
    @Column(name = "APPVD")
    private String appvd;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN_SP")
    private String sampleTcnSp;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigInteger qaSampleId;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "CLASS_ID")
    private BigInteger classId;
    @Size(max = 50)
    @Column(name = "LAB_FUNCTION")
    private String labFunction;
    @Size(max = 250)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 250)
    @Column(name = "ITEM_MAT")
    private String itemMat;
    @Size(max = 250)
    @Column(name = "ITEM_CLASS")
    private String itemClass;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 12)
    @Column(name = "BATCH_SIZE")
    private String batchSize;
    @Size(max = 100)
    @Column(name = "CONCRETE_CLASS")
    private String concreteClass;
    @Column(name = "COMPSTR28DAY")
    private BigInteger compstr28day;
    @Column(name = "AVG28DAY_STRENGTH")
    private BigInteger avg28dayStrength;
    @Size(max = 20)
    @Column(name = "TESTCONTROL")
    private String testcontrol;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "LOTNO")
    private BigInteger lotno;
    @Column(name = "SUBLOTNO")
    private BigInteger sublotno;
    @Size(max = 100)
    @Column(name = "TICKET_NO")
    private String ticketno;
    @Size(max = 4000)
    @Column(name = "STATION")
    private String station;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "SAMPLENO")
    private String sampleno;
    @Column(name = "REPORTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportdate;
    @Column(name = "TESTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testdate;
    @Size(max = 50)
    @Column(name = "SETNUMBER")
    private String setnumber;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 50)
    @Column(name = "COMPANYID")
    private String companyid;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "LABID")
    private String labid;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "BIDITEM_ID")
    private BigInteger biditemId;
    @Column(name = "SUBBIDITEM_ID")
    private BigInteger subbiditemId;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;

    public DotConComp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getSampleidno() {
        return sampleidno;
    }

    public void setSampleidno(String sampleidno) {
        this.sampleidno = sampleidno;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getSamplesperset() {
        return samplesperset;
    }

    public void setSamplesperset(String samplesperset) {
        this.samplesperset = samplesperset;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCuringMethod() {
        return curingMethod;
    }

    public void setCuringMethod(String curingMethod) {
        this.curingMethod = curingMethod;
    }

    public String getSpecimenCovered() {
        return specimenCovered;
    }

    public void setSpecimenCovered(String specimenCovered) {
        this.specimenCovered = specimenCovered;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public BigDecimal getMintemp() {
        return mintemp;
    }

    public void setMintemp(BigDecimal mintemp) {
        this.mintemp = mintemp;
    }

    public BigDecimal getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(BigDecimal maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getCylinderNo() {
        return cylinderNo;
    }

    public void setCylinderNo(String cylinderNo) {
        this.cylinderNo = cylinderNo;
    }

    public String getLabStampNo() {
        return labStampNo;
    }

    public void setLabStampNo(String labStampNo) {
        this.labStampNo = labStampNo;
    }

    public BigDecimal getTestage() {
        return testage;
    }

    public void setTestage(BigDecimal testage) {
        this.testage = testage;
    }

    public BigDecimal getTestageHours() {
        return testageHours;
    }

    public void setTestageHours(BigDecimal testageHours) {
        this.testageHours = testageHours;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getMaximumload() {
        return maximumload;
    }

    public void setMaximumload(BigDecimal maximumload) {
        this.maximumload = maximumload;
    }

    public BigDecimal getLifting() {
        return lifting;
    }

    public void setLifting(BigDecimal lifting) {
        this.lifting = lifting;
    }

    public String getTypeoffracture() {
        return typeoffracture;
    }

    public void setTypeoffracture(String typeoffracture) {
        this.typeoffracture = typeoffracture;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public BigDecimal getCompressivestrength() {
        return compressivestrength;
    }

    public void setCompressivestrength(BigDecimal compressivestrength) {
        this.compressivestrength = compressivestrength;
    }

    public String getBreakLocation() {
        return breakLocation;
    }

    public void setBreakLocation(String breakLocation) {
        this.breakLocation = breakLocation;
    }

    public String getRequiredstrength() {
        return requiredstrength;
    }

    public void setRequiredstrength(String requiredstrength) {
        this.requiredstrength = requiredstrength;
    }

    public Character getDiscardRequired() {
        return discardRequired;
    }

    public void setDiscardRequired(Character discardRequired) {
        this.discardRequired = discardRequired;
    }

    public Character getDiscardCompleted() {
        return discardCompleted;
    }

    public void setDiscardCompleted(Character discardCompleted) {
        this.discardCompleted = discardCompleted;
    }

    public String getDiscard() {
        return discard;
    }

    public void setDiscard(String discard) {
        this.discard = discard;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getResultTestage() {
        return resultTestage;
    }

    public void setResultTestage(String resultTestage) {
        this.resultTestage = resultTestage;
    }

    public String getResultTestageHours() {
        return resultTestageHours;
    }

    public void setResultTestageHours(String resultTestageHours) {
        this.resultTestageHours = resultTestageHours;
    }

    public String getResultSpecMin() {
        return resultSpecMin;
    }

    public void setResultSpecMin(String resultSpecMin) {
        this.resultSpecMin = resultSpecMin;
    }

    public String getResultSpecMax() {
        return resultSpecMax;
    }

    public void setResultSpecMax(String resultSpecMax) {
        this.resultSpecMax = resultSpecMax;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReportStampType() {
        return reportStampType;
    }

    public void setReportStampType(String reportStampType) {
        this.reportStampType = reportStampType;
    }

    public String getResultAverage() {
        return resultAverage;
    }

    public void setResultAverage(String resultAverage) {
        this.resultAverage = resultAverage;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(String reviewBy) {
        this.reviewBy = reviewBy;
    }

    public String getSignoffBy() {
        return signoffBy;
    }

    public void setSignoffBy(String signoffBy) {
        this.signoffBy = signoffBy;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(String hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public BigInteger getSpecifiedstrength() {
        return specifiedstrength;
    }

    public void setSpecifiedstrength(BigInteger specifiedstrength) {
        this.specifiedstrength = specifiedstrength;
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

    public String getAppvd() {
        return appvd;
    }

    public void setAppvd(String appvd) {
        this.appvd = appvd;
    }

    public String getSampleTcnSp() {
        return sampleTcnSp;
    }

    public void setSampleTcnSp(String sampleTcnSp) {
        this.sampleTcnSp = sampleTcnSp;
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(BigInteger qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public BigInteger getMatId() {
        return matId;
    }

    public void setMatId(BigInteger matId) {
        this.matId = matId;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemMat() {
        return itemMat;
    }

    public void setItemMat(String itemMat) {
        this.itemMat = itemMat;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getConcreteClass() {
        return concreteClass;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
    }

    public BigInteger getCompstr28day() {
        return compstr28day;
    }

    public void setCompstr28day(BigInteger compstr28day) {
        this.compstr28day = compstr28day;
    }

    public BigInteger getAvg28dayStrength() {
        return avg28dayStrength;
    }

    public void setAvg28dayStrength(BigInteger avg28dayStrength) {
        this.avg28dayStrength = avg28dayStrength;
    }

    public String getTestcontrol() {
        return testcontrol;
    }

    public void setTestcontrol(String testcontrol) {
        this.testcontrol = testcontrol;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public BigInteger getLotno() {
        return lotno;
    }

    public void setLotno(BigInteger lotno) {
        this.lotno = lotno;
    }

    public BigInteger getSublotno() {
        return sublotno;
    }

    public void setSublotno(BigInteger sublotno) {
        this.sublotno = sublotno;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getSampleno() {
        return sampleno;
    }

    public void setSampleno(String sampleno) {
        this.sampleno = sampleno;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public String getSetnumber() {
        return setnumber;
    }

    public void setSetnumber(String setnumber) {
        this.setnumber = setnumber;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public BigInteger getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigInteger biditemId) {
        this.biditemId = biditemId;
    }

    public BigInteger getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(BigInteger subbiditemId) {
        this.subbiditemId = subbiditemId;
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

}
