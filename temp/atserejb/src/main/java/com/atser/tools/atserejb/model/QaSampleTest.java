/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QaSampleTest.findBySampleId", query = "SELECT q FROM QaSampleTest q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaSampleTest.findByTestId", query = "SELECT q FROM QaSampleTest q WHERE q.testId = :testId"),
    @NamedQuery(name = "QaSampleTest.findByLabId", query = "SELECT q FROM QaSampleTest q WHERE q.labId = :labId"),
    @NamedQuery(name = "QaSampleTest.findByDescription", query = "SELECT q FROM QaSampleTest q WHERE q.description = :description"),
    @NamedQuery(name = "QaSampleTest.findByStatus", query = "SELECT q FROM QaSampleTest q WHERE q.status = :status"),
    @NamedQuery(name = "QaSampleTest.findByTestBy", query = "SELECT q FROM QaSampleTest q WHERE q.testBy = :testBy"),
    @NamedQuery(name = "QaSampleTest.findByApprovedby", query = "SELECT q FROM QaSampleTest q WHERE q.approvedby = :approvedby"),
    @NamedQuery(name = "QaSampleTest.findByActive", query = "SELECT q FROM QaSampleTest q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleTest.findByLastModBy", query = "SELECT q FROM QaSampleTest q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleTest.findByLastModIp", query = "SELECT q FROM QaSampleTest q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleTest.findByCreateBy", query = "SELECT q FROM QaSampleTest q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSampleTest.findByCreateByIp", query = "SELECT q FROM QaSampleTest q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleTest.findByPassfail", query = "SELECT q FROM QaSampleTest q WHERE q.passfail = :passfail"),
    @NamedQuery(name = "QaSampleTest.findByDisciplineId", query = "SELECT q FROM QaSampleTest q WHERE q.disciplineId = :disciplineId"),
    @NamedQuery(name = "QaSampleTest.findByReportNo", query = "SELECT q FROM QaSampleTest q WHERE q.reportNo = :reportNo"),
    @NamedQuery(name = "QaSampleTest.findByWorkorderId", query = "SELECT q FROM QaSampleTest q WHERE q.workorderId = :workorderId"),
    @NamedQuery(name = "QaSampleTest.findByReason", query = "SELECT q FROM QaSampleTest q WHERE q.reason = :reason"),
    @NamedQuery(name = "QaSampleTest.findByVersion", query = "SELECT q FROM QaSampleTest q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleTest.findByUnapproved", query = "SELECT q FROM QaSampleTest q WHERE q.unapproved = :unapproved"),
    @NamedQuery(name = "QaSampleTest.findByActivityId", query = "SELECT q FROM QaSampleTest q WHERE q.activityId = :activityId"),
    @NamedQuery(name = "QaSampleTest.findByUnapprovedBy", query = "SELECT q FROM QaSampleTest q WHERE q.unapprovedBy = :unapprovedBy"),
    @NamedQuery(name = "QaSampleTest.findByTestFunc", query = "SELECT q FROM QaSampleTest q WHERE q.testFunc = :testFunc"),
    @NamedQuery(name = "QaSampleTest.findByItem", query = "SELECT q FROM QaSampleTest q WHERE q.item = :item"),
    @NamedQuery(name = "QaSampleTest.findByElement", query = "SELECT q FROM QaSampleTest q WHERE q.element = :element"),
    @NamedQuery(name = "QaSampleTest.findByClassification", query = "SELECT q FROM QaSampleTest q WHERE q.classification = :classification"),
    @NamedQuery(name = "QaSampleTest.findByTestNo", query = "SELECT q FROM QaSampleTest q WHERE q.testNo = :testNo"),
    @NamedQuery(name = "QaSampleTest.findByInfoId", query = "SELECT q FROM QaSampleTest q WHERE q.infoId = :infoId"),
    @NamedQuery(name = "QaSampleTest.findByPendingapproved", query = "SELECT q FROM QaSampleTest q WHERE q.pendingapproved = :pendingapproved"),
    @NamedQuery(name = "QaSampleTest.findByPendingapprovedBy", query = "SELECT q FROM QaSampleTest q WHERE q.pendingapprovedBy = :pendingapprovedBy"),
    @NamedQuery(name = "QaSampleTest.findByTestDateTmp", query = "SELECT q FROM QaSampleTest q WHERE q.testDateTmp = :testDateTmp"),
    @NamedQuery(name = "QaSampleTest.findByApproveDateTmp", query = "SELECT q FROM QaSampleTest q WHERE q.approveDateTmp = :approveDateTmp"),
    @NamedQuery(name = "QaSampleTest.findByDateCompletedTmp", query = "SELECT q FROM QaSampleTest q WHERE q.dateCompletedTmp = :dateCompletedTmp"),
    @NamedQuery(name = "QaSampleTest.findByLastModTmp", query = "SELECT q FROM QaSampleTest q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QaSampleTest.findByTempTmp", query = "SELECT q FROM QaSampleTest q WHERE q.tempTmp = :tempTmp"),
    @NamedQuery(name = "QaSampleTest.findByCreateDateTmp", query = "SELECT q FROM QaSampleTest q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QaSampleTest.findByTestDate", query = "SELECT q FROM QaSampleTest q WHERE q.testDate = :testDate"),
    @NamedQuery(name = "QaSampleTest.findByApproveDate", query = "SELECT q FROM QaSampleTest q WHERE q.approveDate = :approveDate"),
    @NamedQuery(name = "QaSampleTest.findByDateCompleted", query = "SELECT q FROM QaSampleTest q WHERE q.dateCompleted = :dateCompleted"),
    @NamedQuery(name = "QaSampleTest.findByLastMod", query = "SELECT q FROM QaSampleTest q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleTest.findByTemp", query = "SELECT q FROM QaSampleTest q WHERE q.temp = :temp"),
    @NamedQuery(name = "QaSampleTest.findByCreateDate", query = "SELECT q FROM QaSampleTest q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSampleTest.findByReviewed", query = "SELECT q FROM QaSampleTest q WHERE q.reviewed = :reviewed"),
    @NamedQuery(name = "QaSampleTest.findByReviewedBy", query = "SELECT q FROM QaSampleTest q WHERE q.reviewedBy = :reviewedBy"),
    @NamedQuery(name = "QaSampleTest.findByTestPrefs", query = "SELECT q FROM QaSampleTest q WHERE q.testPrefs = :testPrefs"),
    @NamedQuery(name = "QaSampleTest.findByRejected", query = "SELECT q FROM QaSampleTest q WHERE q.rejected = :rejected"),
    @NamedQuery(name = "QaSampleTest.findByRejectedBy", query = "SELECT q FROM QaSampleTest q WHERE q.rejectedBy = :rejectedBy"),
    @NamedQuery(name = "QaSampleTest.findByPeReview", query = "SELECT q FROM QaSampleTest q WHERE q.peReview = :peReview"),
    @NamedQuery(name = "QaSampleTest.findByTestClosed", query = "SELECT q FROM QaSampleTest q WHERE q.testClosed = :testClosed"),
    @NamedQuery(name = "QaSampleTest.findByAcknowledgedby", query = "SELECT q FROM QaSampleTest q WHERE q.acknowledgedby = :acknowledgedby"),
    @NamedQuery(name = "QaSampleTest.findByAcknowledgedDate", query = "SELECT q FROM QaSampleTest q WHERE q.acknowledgedDate = :acknowledgedDate"),
    @NamedQuery(name = "QaSampleTest.findByAlerted", query = "SELECT q FROM QaSampleTest q WHERE q.alerted = :alerted"),
    @NamedQuery(name = "QaSampleTest.findByAlertedBy", query = "SELECT q FROM QaSampleTest q WHERE q.alertedBy = :alertedBy"),
    @NamedQuery(name = "QaSampleTest.findByReportKey", query = "SELECT q FROM QaSampleTest q WHERE q.reportKey = :reportKey"),
    @NamedQuery(name = "QaSampleTest.findByReviewedDate", query = "SELECT q FROM QaSampleTest q WHERE q.reviewedDate = :reviewedDate"),
    @NamedQuery(name = "QaSampleTest.findByReviewedTimestamp", query = "SELECT q FROM QaSampleTest q WHERE q.reviewedTimestamp = :reviewedTimestamp"),
    @NamedQuery(name = "QaSampleTest.findByCompletedBy", query = "SELECT q FROM QaSampleTest q WHERE q.completedBy = :completedBy"),
    @NamedQuery(name = "QaSampleTest.findByCompletedTimestamp", query = "SELECT q FROM QaSampleTest q WHERE q.completedTimestamp = :completedTimestamp"),
    @NamedQuery(name = "QaSampleTest.findByApprovedTimestamp", query = "SELECT q FROM QaSampleTest q WHERE q.approvedTimestamp = :approvedTimestamp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_SAMPLE_TEST", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_SAMPLE_TEST SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleTest.findAll", query = "SELECT q FROM QaSampleTest q"),
    @NamedQuery(name = "QaSampleTest.findById", query = "SELECT q FROM QaSampleTest q WHERE q.id = :id")})
public class QaSampleTest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_SAMPLE_TEST_ID_SEQ", sequenceName = "QA_SAMPLE_TEST_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_SAMPLE_TEST_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLE_ID")
    private BigInteger sampleId;
    @Size(max = 50)
    @Column(name = "TEST_ID")
    private String testId;
    @Size(max = 50)
    @Column(name = "LAB_ID")
    private String labId;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "TEST_BY")
    private String testBy;
    @Size(max = 50)
    @Column(name = "APPROVEDBY")
    private String approvedby;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Column(name = "DISCIPLINE_ID")
    private BigInteger disciplineId;
    @Size(max = 4000)
    @Column(name = "REPORT_NO")
    private String reportNo;
    @Column(name = "WORKORDER_ID")
    private BigInteger workorderId;
    @Size(max = 4000)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "UNAPPROVED")
    private Character unapproved;
    @Column(name = "ACTIVITY_ID")
    private BigInteger activityId;
    @Size(max = 50)
    @Column(name = "UNAPPROVED_BY")
    private String unapprovedBy;
    @Size(max = 50)
    @Column(name = "TEST_FUNC")
    private String testFunc;
    @Size(max = 255)
    @Column(name = "ITEM")
    private String item;
    @Size(max = 255)
    @Column(name = "ELEMENT")
    private String element;
    @Size(max = 255)
    @Column(name = "CLASSIFICATION")
    private String classification;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "PENDINGAPPROVED")
    private Character pendingapproved;
    @Size(max = 50)
    @Column(name = "PENDINGAPPROVED_BY")
    private String pendingapprovedBy;
    @Size(max = 4000)
    @Column(name = "TEST_DATE_TMP")
    private String testDateTmp;
    @Size(max = 4000)
    @Column(name = "APPROVE_DATE_TMP")
    private String approveDateTmp;
    @Size(max = 4000)
    @Column(name = "DATE_COMPLETED_TMP")
    private String dateCompletedTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Column(name = "TEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testDate;
    @Column(name = "APPROVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approveDate;
    @Column(name = "DATE_COMPLETED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCompleted;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Column(name = "REVIEWED")
    private Character reviewed;
    @Size(max = 50)
    @Column(name = "REVIEWED_BY")
    private String reviewedBy;
    @Size(max = 100)
    @Column(name = "TEST_PREFS")
    private String testPrefs;
    @Column(name = "REJECTED")
    private Character rejected;
    @Size(max = 50)
    @Column(name = "REJECTED_BY")
    private String rejectedBy;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Size(max = 50)
    @Column(name = "ACKNOWLEDGEDBY")
    private String acknowledgedby;
    @Column(name = "ACKNOWLEDGED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acknowledgedDate;
    @Column(name = "ALERTED")
    private Character alerted;
    @Size(max = 50)
    @Column(name = "ALERTED_BY")
    private String alertedBy;
    @Size(max = 50)
    @Column(name = "REPORT_KEY")
    private String reportKey;
    @Column(name = "REVIEWED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewedDate;
    @Size(max = 50)
    @Column(name = "REVIEWED_TIMESTAMP")
    private String reviewedTimestamp;
    @Size(max = 50)
    @Column(name = "COMPLETED_BY")
    private String completedBy;
    @Size(max = 50)
    @Column(name = "COMPLETED_TIMESTAMP")
    private String completedTimestamp;
    @Size(max = 50)
    @Column(name = "APPROVED_TIMESTAMP")
    private String approvedTimestamp;
    @Column(name = "FROM_MOBILE")
    private Character fromMobile;
    
    public QaSampleTest() {
    }

    public QaSampleTest(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigInteger sampleId) {
        this.sampleId = sampleId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestBy() {
        return testBy;
    }

    public void setTestBy(String testBy) {
        this.testBy = testBy;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public BigInteger getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(BigInteger disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public BigInteger getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(BigInteger workorderId) {
        this.workorderId = workorderId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Character getUnapproved() {
        return unapproved;
    }

    public void setUnapproved(Character unapproved) {
        this.unapproved = unapproved;
    }

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public String getUnapprovedBy() {
        return unapprovedBy;
    }

    public void setUnapprovedBy(String unapprovedBy) {
        this.unapprovedBy = unapprovedBy;
    }

    public String getTestFunc() {
        return testFunc;
    }

    public void setTestFunc(String testFunc) {
        this.testFunc = testFunc;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public Character getPendingapproved() {
        return pendingapproved;
    }

    public void setPendingapproved(Character pendingapproved) {
        this.pendingapproved = pendingapproved;
    }

    public String getPendingapprovedBy() {
        return pendingapprovedBy;
    }

    public void setPendingapprovedBy(String pendingapprovedBy) {
        this.pendingapprovedBy = pendingapprovedBy;
    }

    public String getTestDateTmp() {
        return testDateTmp;
    }

    public void setTestDateTmp(String testDateTmp) {
        this.testDateTmp = testDateTmp;
    }

    public String getApproveDateTmp() {
        return approveDateTmp;
    }

    public void setApproveDateTmp(String approveDateTmp) {
        this.approveDateTmp = approveDateTmp;
    }

    public String getDateCompletedTmp() {
        return dateCompletedTmp;
    }

    public void setDateCompletedTmp(String dateCompletedTmp) {
        this.dateCompletedTmp = dateCompletedTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Character getReviewed() {
        return reviewed;
    }

    public void setReviewed(Character reviewed) {
        this.reviewed = reviewed;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getTestPrefs() {
        return testPrefs;
    }

    public void setTestPrefs(String testPrefs) {
        this.testPrefs = testPrefs;
    }

    public Character getRejected() {
        return rejected;
    }

    public void setRejected(Character rejected) {
        this.rejected = rejected;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
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

    public String getAcknowledgedby() {
        return acknowledgedby;
    }

    public void setAcknowledgedby(String acknowledgedby) {
        this.acknowledgedby = acknowledgedby;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getAcknowledgedDate() {
        return acknowledgedDate;
    }

    public void setAcknowledgedDate(Date acknowledgedDate) {
        this.acknowledgedDate = acknowledgedDate;
    }

    public Character getAlerted() {
        return alerted;
    }

    public void setAlerted(Character alerted) {
        this.alerted = alerted;
    }

    public String getAlertedBy() {
        return alertedBy;
    }

    public void setAlertedBy(String alertedBy) {
        this.alertedBy = alertedBy;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String reportKey) {
        this.reportKey = reportKey;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getReviewedDate() {
        return reviewedDate;
    }

    public void setReviewedDate(Date reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public String getReviewedTimestamp() {
        return reviewedTimestamp;
    }

    public void setReviewedTimestamp(String reviewedTimestamp) {
        this.reviewedTimestamp = reviewedTimestamp;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getCompletedTimestamp() {
        return completedTimestamp;
    }

    public void setCompletedTimestamp(String completedTimestamp) {
        this.completedTimestamp = completedTimestamp;
    }

    public String getApprovedTimestamp() {
        return approvedTimestamp;
    }

    public void setApprovedTimestamp(String approvedTimestamp) {
        this.approvedTimestamp = approvedTimestamp;
    }

    public Character getFromMobile() {
        return fromMobile;
    }

    public void setFromMobile(Character fromMobile) {
        this.fromMobile = fromMobile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaSampleTest)) {
            return false;
        }
        QaSampleTest other = (QaSampleTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleTest[ id=" + id + " ]";
    }
    
}
