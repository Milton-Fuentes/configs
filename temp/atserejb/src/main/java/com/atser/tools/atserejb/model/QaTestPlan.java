/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

/*
    @NamedQuery(name = "QaTestPlan.findByProjectId", query = "SELECT q FROM QaTestPlan q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaTestPlan.findByTestPlanNo", query = "SELECT q FROM QaTestPlan q WHERE q.testPlanNo = :testPlanNo"),
    @NamedQuery(name = "QaTestPlan.findByTestPlan", query = "SELECT q FROM QaTestPlan q WHERE q.testPlan = :testPlan"),
    @NamedQuery(name = "QaTestPlan.findByFromDate", query = "SELECT q FROM QaTestPlan q WHERE q.fromDate = :fromDate"),
    @NamedQuery(name = "QaTestPlan.findByToDate", query = "SELECT q FROM QaTestPlan q WHERE q.toDate = :toDate"),
    @NamedQuery(name = "QaTestPlan.findByDistrict", query = "SELECT q FROM QaTestPlan q WHERE q.district = :district"),
    @NamedQuery(name = "QaTestPlan.findByCity", query = "SELECT q FROM QaTestPlan q WHERE q.city = :city"),
    @NamedQuery(name = "QaTestPlan.findByContractor", query = "SELECT q FROM QaTestPlan q WHERE q.contractor = :contractor"),
    @NamedQuery(name = "QaTestPlan.findByReEng", query = "SELECT q FROM QaTestPlan q WHERE q.reEng = :reEng"),
    @NamedQuery(name = "QaTestPlan.findByDmeEng", query = "SELECT q FROM QaTestPlan q WHERE q.dmeEng = :dmeEng"),
    @NamedQuery(name = "QaTestPlan.findByRmEng", query = "SELECT q FROM QaTestPlan q WHERE q.rmEng = :rmEng"),
    @NamedQuery(name = "QaTestPlan.findByNtpDate", query = "SELECT q FROM QaTestPlan q WHERE q.ntpDate = :ntpDate"),
    @NamedQuery(name = "QaTestPlan.findByDrDate", query = "SELECT q FROM QaTestPlan q WHERE q.drDate = :drDate"),
    @NamedQuery(name = "QaTestPlan.findByRmAppvDate", query = "SELECT q FROM QaTestPlan q WHERE q.rmAppvDate = :rmAppvDate"),
    @NamedQuery(name = "QaTestPlan.findByProjectDescript", query = "SELECT q FROM QaTestPlan q WHERE q.projectDescript = :projectDescript"),
    @NamedQuery(name = "QaTestPlan.findByQaConcreteQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaConcreteQty = :qaConcreteQty"),
    @NamedQuery(name = "QaTestPlan.findByQcConcreteQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcConcreteQty = :qcConcreteQty"),
    @NamedQuery(name = "QaTestPlan.findByQaHmaPlantQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaHmaPlantQty = :qaHmaPlantQty"),
    @NamedQuery(name = "QaTestPlan.findByQcHmaPlantQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcHmaPlantQty = :qcHmaPlantQty"),
    @NamedQuery(name = "QaTestPlan.findByQaHmaCoresQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaHmaCoresQty = :qaHmaCoresQty"),
    @NamedQuery(name = "QaTestPlan.findByQcHmaCoresQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcHmaCoresQty = :qcHmaCoresQty"),
    @NamedQuery(name = "QaTestPlan.findByQaGravelBorrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaGravelBorrowQty = :qaGravelBorrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQcGravelBorrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcGravelBorrowQty = :qcGravelBorrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQaDgcssubbaseQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaDgcssubbaseQty = :qaDgcssubbaseQty"),
    @NamedQuery(name = "QaTestPlan.findByQcDgcssubbaseQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcDgcssubbaseQty = :qcDgcssubbaseQty"),
    @NamedQuery(name = "QaTestPlan.findByQaOrdinaryborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaOrdinaryborrowQty = :qaOrdinaryborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQcOrdinaryborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcOrdinaryborrowQty = :qcOrdinaryborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQaSpecialborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaSpecialborrowQty = :qaSpecialborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQcSpecialborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcSpecialborrowQty = :qcSpecialborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQaReclaimedborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qaReclaimedborrowQty = :qaReclaimedborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQcReclaimedborrowQty", query = "SELECT q FROM QaTestPlan q WHERE q.qcReclaimedborrowQty = :qcReclaimedborrowQty"),
    @NamedQuery(name = "QaTestPlan.findByQaConcreteFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaConcreteFreq = :qaConcreteFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcConcreteFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcConcreteFreq = :qcConcreteFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaHmaPlantFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaHmaPlantFreq = :qaHmaPlantFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcHmaPlantFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcHmaPlantFreq = :qcHmaPlantFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaHmaCoresFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaHmaCoresFreq = :qaHmaCoresFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcHmaCoresFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcHmaCoresFreq = :qcHmaCoresFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaGravelBorrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaGravelBorrowFreq = :qaGravelBorrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcGravelBorrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcGravelBorrowFreq = :qcGravelBorrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaDgcssubbaseFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaDgcssubbaseFreq = :qaDgcssubbaseFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcDgcssubbaseFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcDgcssubbaseFreq = :qcDgcssubbaseFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaOrdinaryborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaOrdinaryborrowFreq = :qaOrdinaryborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcOrdinaryborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcOrdinaryborrowFreq = :qcOrdinaryborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaSpecialborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaSpecialborrowFreq = :qaSpecialborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcSpecialborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcSpecialborrowFreq = :qcSpecialborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQaReclaimedborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qaReclaimedborrowFreq = :qaReclaimedborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByQcReclaimedborrowFreq", query = "SELECT q FROM QaTestPlan q WHERE q.qcReclaimedborrowFreq = :qcReclaimedborrowFreq"),
    @NamedQuery(name = "QaTestPlan.findByTotalQtyIa", query = "SELECT q FROM QaTestPlan q WHERE q.totalQtyIa = :totalQtyIa"),
    @NamedQuery(name = "QaTestPlan.findByTotalQtyQc", query = "SELECT q FROM QaTestPlan q WHERE q.totalQtyQc = :totalQtyQc"),
    @NamedQuery(name = "QaTestPlan.findByReqDef", query = "SELECT q FROM QaTestPlan q WHERE q.reqDef = :reqDef"),
    @NamedQuery(name = "QaTestPlan.findByReqSp", query = "SELECT q FROM QaTestPlan q WHERE q.reqSp = :reqSp"),
    @NamedQuery(name = "QaTestPlan.findByItemCRe", query = "SELECT q FROM QaTestPlan q WHERE q.itemCRe = :itemCRe"),
    @NamedQuery(name = "QaTestPlan.findByPerCRe", query = "SELECT q FROM QaTestPlan q WHERE q.perCRe = :perCRe"),
    @NamedQuery(name = "QaTestPlan.findByItemVDme", query = "SELECT q FROM QaTestPlan q WHERE q.itemVDme = :itemVDme"),
    @NamedQuery(name = "QaTestPlan.findByPerVDme", query = "SELECT q FROM QaTestPlan q WHERE q.perVDme = :perVDme"),
    @NamedQuery(name = "QaTestPlan.findByStatus", query = "SELECT q FROM QaTestPlan q WHERE q.status = :status"),
    @NamedQuery(name = "QaTestPlan.findByComments", query = "SELECT q FROM QaTestPlan q WHERE q.comments = :comments"),
    @NamedQuery(name = "QaTestPlan.findByActive", query = "SELECT q FROM QaTestPlan q WHERE q.active = :active"),
    @NamedQuery(name = "QaTestPlan.findByField1", query = "SELECT q FROM QaTestPlan q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaTestPlan.findByField2", query = "SELECT q FROM QaTestPlan q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaTestPlan.findByField3", query = "SELECT q FROM QaTestPlan q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaTestPlan.findByField4", query = "SELECT q FROM QaTestPlan q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaTestPlan.findByField5", query = "SELECT q FROM QaTestPlan q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaTestPlan.findByField6", query = "SELECT q FROM QaTestPlan q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaTestPlan.findByCreateBy", query = "SELECT q FROM QaTestPlan q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaTestPlan.findByCreateByIp", query = "SELECT q FROM QaTestPlan q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaTestPlan.findByLastModBy", query = "SELECT q FROM QaTestPlan q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaTestPlan.findByLastMod", query = "SELECT q FROM QaTestPlan q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaTestPlan.findByLastModIp", query = "SELECT q FROM QaTestPlan q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaTestPlan.findByVersion", query = "SELECT q FROM QaTestPlan q WHERE q.version = :version"),
    @NamedQuery(name = "QaTestPlan.findBySpecFunction", query = "SELECT q FROM QaTestPlan q WHERE q.specFunction = :specFunction"),
    @NamedQuery(name = "QaTestPlan.findBySpecId", query = "SELECT q FROM QaTestPlan q WHERE q.specId = :specId"),
    @NamedQuery(name = "QaTestPlan.findByQcUsed", query = "SELECT q FROM QaTestPlan q WHERE q.qcUsed = :qcUsed"),
    @NamedQuery(name = "QaTestPlan.findByInitAppv", query = "SELECT q FROM QaTestPlan q WHERE q.initAppv = :initAppv"),
    @NamedQuery(name = "QaTestPlan.findBySupAppv", query = "SELECT q FROM QaTestPlan q WHERE q.supAppv = :supAppv"),
    @NamedQuery(name = "QaTestPlan.findByRmsAppv", query = "SELECT q FROM QaTestPlan q WHERE q.rmsAppv = :rmsAppv"),
    @NamedQuery(name = "QaTestPlan.findByRmsUnappv", query = "SELECT q FROM QaTestPlan q WHERE q.rmsUnappv = :rmsUnappv")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TEST_PLAN", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTestPlan.findAll", query = "SELECT q FROM QaTestPlan q"),
    @NamedQuery(name = "QaTestPlan.findById", query = "SELECT q FROM QaTestPlan q WHERE q.id = :id")})
public class QaTestPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_test_plan_id_seq", sequenceName = "qa_test_plan_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_test_plan_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "TEST_PLAN_NO")
    private String testPlanNo;
    @Size(max = 200)
    @Column(name = "TEST_PLAN")
    private String testPlan;
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Size(max = 100)
    @Column(name = "DISTRICT")
    private String district;
    @Size(max = 100)
    @Column(name = "CITY")
    private String city;
    @Size(max = 100)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 100)
    @Column(name = "RE_ENG")
    private String reEng;
    @Size(max = 100)
    @Column(name = "DME_ENG")
    private String dmeEng;
    @Size(max = 100)
    @Column(name = "RM_ENG")
    private String rmEng;
    @Column(name = "NTP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ntpDate;
    @Column(name = "DR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date drDate;
    @Column(name = "RM_APPV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmAppvDate;
    @Size(max = 500)
    @Column(name = "PROJECT_DESCRIPT")
    private String projectDescript;
    @Column(name = "QA_CONCRETE_QTY")
    private Double qaConcreteQty;
    @Column(name = "QC_CONCRETE_QTY")
    private Double qcConcreteQty;
    @Column(name = "QA_HMA_PLANT_QTY")
    private Double qaHmaPlantQty;
    @Column(name = "QC_HMA_PLANT_QTY")
    private Double qcHmaPlantQty;
    @Column(name = "QA_HMA_CORES_QTY")
    private Double qaHmaCoresQty;
    @Column(name = "QC_HMA_CORES_QTY")
    private Double qcHmaCoresQty;
    @Column(name = "QA_GRAVEL_BORROW_QTY")
    private Double qaGravelBorrowQty;
    @Column(name = "QC_GRAVEL_BORROW_QTY")
    private Double qcGravelBorrowQty;
    @Column(name = "QA_DGCSSUBBASE_QTY")
    private Double qaDgcssubbaseQty;
    @Column(name = "QC_DGCSSUBBASE_QTY")
    private Double qcDgcssubbaseQty;
    @Column(name = "QA_ORDINARYBORROW_QTY")
    private Double qaOrdinaryborrowQty;
    @Column(name = "QC_ORDINARYBORROW_QTY")
    private Double qcOrdinaryborrowQty;
    @Column(name = "QA_SPECIALBORROW_QTY")
    private Double qaSpecialborrowQty;
    @Column(name = "QC_SPECIALBORROW_QTY")
    private Double qcSpecialborrowQty;
    @Column(name = "QA_RECLAIMEDBORROW_QTY")
    private Double qaReclaimedborrowQty;
    @Column(name = "QC_RECLAIMEDBORROW_QTY")
    private Double qcReclaimedborrowQty;
    @Column(name = "QA_CONCRETE_FREQ")
    private Double qaConcreteFreq;
    @Column(name = "QC_CONCRETE_FREQ")
    private Double qcConcreteFreq;
    @Column(name = "QA_HMA_PLANT_FREQ")
    private Double qaHmaPlantFreq;
    @Column(name = "QC_HMA_PLANT_FREQ")
    private Double qcHmaPlantFreq;
    @Column(name = "QA_HMA_CORES_FREQ")
    private Double qaHmaCoresFreq;
    @Column(name = "QC_HMA_CORES_FREQ")
    private Double qcHmaCoresFreq;
    @Column(name = "QA_GRAVEL_BORROW_FREQ")
    private Double qaGravelBorrowFreq;
    @Column(name = "QC_GRAVEL_BORROW_FREQ")
    private Double qcGravelBorrowFreq;
    @Column(name = "QA_DGCSSUBBASE_FREQ")
    private Double qaDgcssubbaseFreq;
    @Column(name = "QC_DGCSSUBBASE_FREQ")
    private Double qcDgcssubbaseFreq;
    @Column(name = "QA_ORDINARYBORROW_FREQ")
    private Double qaOrdinaryborrowFreq;
    @Column(name = "QC_ORDINARYBORROW_FREQ")
    private Double qcOrdinaryborrowFreq;
    @Column(name = "QA_SPECIALBORROW_FREQ")
    private Double qaSpecialborrowFreq;
    @Column(name = "QC_SPECIALBORROW_FREQ")
    private Double qcSpecialborrowFreq;
    @Column(name = "QA_RECLAIMEDBORROW_FREQ")
    private Double qaReclaimedborrowFreq;
    @Column(name = "QC_RECLAIMEDBORROW_FREQ")
    private Double qcReclaimedborrowFreq;
    @Column(name = "TOTAL_QTY_IA")
    private Double totalQtyIa;
    @Column(name = "TOTAL_QTY_QC")
    private Double totalQtyQc;
    @Size(max = 100)
    @Column(name = "REQ_DEF")
    private String reqDef;
    @Size(max = 100)
    @Column(name = "REQ_SP")
    private String reqSp;
    @Column(name = "ITEM_C_RE")
    private Double itemCRe;
    @Size(max = 100)
    @Column(name = "PER_C_RE")
    private String perCRe;
    @Column(name = "ITEM_V_DME")
    private Double itemVDme;
    @Size(max = 100)
    @Column(name = "PER_V_DME")
    private String perVDme;
    @Size(max = 100)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 3000)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", insertable = false)
    private String version;
    @Size(max = 200)
    @Column(name = "SPEC_FUNCTION")
    private String specFunction;
    @Column(name = "SPEC_ID")
    private BigInteger specId;
    @Size(max = 200)
    @Column(name = "QC_USED", insertable = false)
    private String qcUsed;
    @Column(name = "INIT_APPV")
    private BigInteger initAppv;
    @Column(name = "SUP_APPV")
    private BigInteger supAppv;
    @Column(name = "RMS_APPV")
    private BigInteger rmsAppv;
    @Column(name = "RMS_UNAPPV")
    private BigInteger rmsUnappv;

    public QaTestPlan() {
    }

    public QaTestPlan(BigDecimal id) {
        this.id = id;
    }

    public QaTestPlan(BigDecimal id, BigInteger projectId) {
        this.id = id;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getTestPlanNo() {
        return testPlanNo;
    }

    public void setTestPlanNo(String testPlanNo) {
        this.testPlanNo = testPlanNo;
    }

    public String getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(String testPlan) {
        this.testPlan = testPlan;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getReEng() {
        return reEng;
    }

    public void setReEng(String reEng) {
        this.reEng = reEng;
    }

    public String getDmeEng() {
        return dmeEng;
    }

    public void setDmeEng(String dmeEng) {
        this.dmeEng = dmeEng;
    }

    public String getRmEng() {
        return rmEng;
    }

    public void setRmEng(String rmEng) {
        this.rmEng = rmEng;
    }

    public Date getNtpDate() {
        return ntpDate;
    }

    public void setNtpDate(Date ntpDate) {
        this.ntpDate = ntpDate;
    }

    public Date getDrDate() {
        return drDate;
    }

    public void setDrDate(Date drDate) {
        this.drDate = drDate;
    }

    public Date getRmAppvDate() {
        return rmAppvDate;
    }

    public void setRmAppvDate(Date rmAppvDate) {
        this.rmAppvDate = rmAppvDate;
    }

    public String getProjectDescript() {
        return projectDescript;
    }

    public void setProjectDescript(String projectDescript) {
        this.projectDescript = projectDescript;
    }

    public Double getQaConcreteQty() {
        return qaConcreteQty;
    }

    public void setQaConcreteQty(Double qaConcreteQty) {
        this.qaConcreteQty = qaConcreteQty;
    }

    public Double getQcConcreteQty() {
        return qcConcreteQty;
    }

    public void setQcConcreteQty(Double qcConcreteQty) {
        this.qcConcreteQty = qcConcreteQty;
    }

    public Double getQaHmaPlantQty() {
        return qaHmaPlantQty;
    }

    public void setQaHmaPlantQty(Double qaHmaPlantQty) {
        this.qaHmaPlantQty = qaHmaPlantQty;
    }

    public Double getQcHmaPlantQty() {
        return qcHmaPlantQty;
    }

    public void setQcHmaPlantQty(Double qcHmaPlantQty) {
        this.qcHmaPlantQty = qcHmaPlantQty;
    }

    public Double getQaHmaCoresQty() {
        return qaHmaCoresQty;
    }

    public void setQaHmaCoresQty(Double qaHmaCoresQty) {
        this.qaHmaCoresQty = qaHmaCoresQty;
    }

    public Double getQcHmaCoresQty() {
        return qcHmaCoresQty;
    }

    public void setQcHmaCoresQty(Double qcHmaCoresQty) {
        this.qcHmaCoresQty = qcHmaCoresQty;
    }

    public Double getQaGravelBorrowQty() {
        return qaGravelBorrowQty;
    }

    public void setQaGravelBorrowQty(Double qaGravelBorrowQty) {
        this.qaGravelBorrowQty = qaGravelBorrowQty;
    }

    public Double getQcGravelBorrowQty() {
        return qcGravelBorrowQty;
    }

    public void setQcGravelBorrowQty(Double qcGravelBorrowQty) {
        this.qcGravelBorrowQty = qcGravelBorrowQty;
    }

    public Double getQaDgcssubbaseQty() {
        return qaDgcssubbaseQty;
    }

    public void setQaDgcssubbaseQty(Double qaDgcssubbaseQty) {
        this.qaDgcssubbaseQty = qaDgcssubbaseQty;
    }

    public Double getQcDgcssubbaseQty() {
        return qcDgcssubbaseQty;
    }

    public void setQcDgcssubbaseQty(Double qcDgcssubbaseQty) {
        this.qcDgcssubbaseQty = qcDgcssubbaseQty;
    }

    public Double getQaOrdinaryborrowQty() {
        return qaOrdinaryborrowQty;
    }

    public void setQaOrdinaryborrowQty(Double qaOrdinaryborrowQty) {
        this.qaOrdinaryborrowQty = qaOrdinaryborrowQty;
    }

    public Double getQcOrdinaryborrowQty() {
        return qcOrdinaryborrowQty;
    }

    public void setQcOrdinaryborrowQty(Double qcOrdinaryborrowQty) {
        this.qcOrdinaryborrowQty = qcOrdinaryborrowQty;
    }

    public Double getQaSpecialborrowQty() {
        return qaSpecialborrowQty;
    }

    public void setQaSpecialborrowQty(Double qaSpecialborrowQty) {
        this.qaSpecialborrowQty = qaSpecialborrowQty;
    }

    public Double getQcSpecialborrowQty() {
        return qcSpecialborrowQty;
    }

    public void setQcSpecialborrowQty(Double qcSpecialborrowQty) {
        this.qcSpecialborrowQty = qcSpecialborrowQty;
    }

    public Double getQaReclaimedborrowQty() {
        return qaReclaimedborrowQty;
    }

    public void setQaReclaimedborrowQty(Double qaReclaimedborrowQty) {
        this.qaReclaimedborrowQty = qaReclaimedborrowQty;
    }

    public Double getQcReclaimedborrowQty() {
        return qcReclaimedborrowQty;
    }

    public void setQcReclaimedborrowQty(Double qcReclaimedborrowQty) {
        this.qcReclaimedborrowQty = qcReclaimedborrowQty;
    }

    public Double getQaConcreteFreq() {
        return qaConcreteFreq;
    }

    public void setQaConcreteFreq(Double qaConcreteFreq) {
        this.qaConcreteFreq = qaConcreteFreq;
    }

    public Double getQcConcreteFreq() {
        return qcConcreteFreq;
    }

    public void setQcConcreteFreq(Double qcConcreteFreq) {
        this.qcConcreteFreq = qcConcreteFreq;
    }

    public Double getQaHmaPlantFreq() {
        return qaHmaPlantFreq;
    }

    public void setQaHmaPlantFreq(Double qaHmaPlantFreq) {
        this.qaHmaPlantFreq = qaHmaPlantFreq;
    }

    public Double getQcHmaPlantFreq() {
        return qcHmaPlantFreq;
    }

    public void setQcHmaPlantFreq(Double qcHmaPlantFreq) {
        this.qcHmaPlantFreq = qcHmaPlantFreq;
    }

    public Double getQaHmaCoresFreq() {
        return qaHmaCoresFreq;
    }

    public void setQaHmaCoresFreq(Double qaHmaCoresFreq) {
        this.qaHmaCoresFreq = qaHmaCoresFreq;
    }

    public Double getQcHmaCoresFreq() {
        return qcHmaCoresFreq;
    }

    public void setQcHmaCoresFreq(Double qcHmaCoresFreq) {
        this.qcHmaCoresFreq = qcHmaCoresFreq;
    }

    public Double getQaGravelBorrowFreq() {
        return qaGravelBorrowFreq;
    }

    public void setQaGravelBorrowFreq(Double qaGravelBorrowFreq) {
        this.qaGravelBorrowFreq = qaGravelBorrowFreq;
    }

    public Double getQcGravelBorrowFreq() {
        return qcGravelBorrowFreq;
    }

    public void setQcGravelBorrowFreq(Double qcGravelBorrowFreq) {
        this.qcGravelBorrowFreq = qcGravelBorrowFreq;
    }

    public Double getQaDgcssubbaseFreq() {
        return qaDgcssubbaseFreq;
    }

    public void setQaDgcssubbaseFreq(Double qaDgcssubbaseFreq) {
        this.qaDgcssubbaseFreq = qaDgcssubbaseFreq;
    }

    public Double getQcDgcssubbaseFreq() {
        return qcDgcssubbaseFreq;
    }

    public void setQcDgcssubbaseFreq(Double qcDgcssubbaseFreq) {
        this.qcDgcssubbaseFreq = qcDgcssubbaseFreq;
    }

    public Double getQaOrdinaryborrowFreq() {
        return qaOrdinaryborrowFreq;
    }

    public void setQaOrdinaryborrowFreq(Double qaOrdinaryborrowFreq) {
        this.qaOrdinaryborrowFreq = qaOrdinaryborrowFreq;
    }

    public Double getQcOrdinaryborrowFreq() {
        return qcOrdinaryborrowFreq;
    }

    public void setQcOrdinaryborrowFreq(Double qcOrdinaryborrowFreq) {
        this.qcOrdinaryborrowFreq = qcOrdinaryborrowFreq;
    }

    public Double getQaSpecialborrowFreq() {
        return qaSpecialborrowFreq;
    }

    public void setQaSpecialborrowFreq(Double qaSpecialborrowFreq) {
        this.qaSpecialborrowFreq = qaSpecialborrowFreq;
    }

    public Double getQcSpecialborrowFreq() {
        return qcSpecialborrowFreq;
    }

    public void setQcSpecialborrowFreq(Double qcSpecialborrowFreq) {
        this.qcSpecialborrowFreq = qcSpecialborrowFreq;
    }

    public Double getQaReclaimedborrowFreq() {
        return qaReclaimedborrowFreq;
    }

    public void setQaReclaimedborrowFreq(Double qaReclaimedborrowFreq) {
        this.qaReclaimedborrowFreq = qaReclaimedborrowFreq;
    }

    public Double getQcReclaimedborrowFreq() {
        return qcReclaimedborrowFreq;
    }

    public void setQcReclaimedborrowFreq(Double qcReclaimedborrowFreq) {
        this.qcReclaimedborrowFreq = qcReclaimedborrowFreq;
    }

    public Double getTotalQtyIa() {
        return totalQtyIa;
    }

    public void setTotalQtyIa(Double totalQtyIa) {
        this.totalQtyIa = totalQtyIa;
    }

    public Double getTotalQtyQc() {
        return totalQtyQc;
    }

    public void setTotalQtyQc(Double totalQtyQc) {
        this.totalQtyQc = totalQtyQc;
    }

    public String getReqDef() {
        return reqDef;
    }

    public void setReqDef(String reqDef) {
        this.reqDef = reqDef;
    }

    public String getReqSp() {
        return reqSp;
    }

    public void setReqSp(String reqSp) {
        this.reqSp = reqSp;
    }

    public Double getItemCRe() {
        return itemCRe;
    }

    public void setItemCRe(Double itemCRe) {
        this.itemCRe = itemCRe;
    }

    public String getPerCRe() {
        return perCRe;
    }

    public void setPerCRe(String perCRe) {
        this.perCRe = perCRe;
    }

    public Double getItemVDme() {
        return itemVDme;
    }

    public void setItemVDme(Double itemVDme) {
        this.itemVDme = itemVDme;
    }

    public String getPerVDme() {
        return perVDme;
    }

    public void setPerVDme(String perVDme) {
        this.perVDme = perVDme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSpecFunction() {
        return specFunction;
    }

    public void setSpecFunction(String specFunction) {
        this.specFunction = specFunction;
    }

    public BigInteger getSpecId() {
        return specId;
    }

    public void setSpecId(BigInteger specId) {
        this.specId = specId;
    }

    public String getQcUsed() {
        return qcUsed;
    }

    public void setQcUsed(String qcUsed) {
        this.qcUsed = qcUsed;
    }

    public BigInteger getInitAppv() {
        return initAppv;
    }

    public void setInitAppv(BigInteger initAppv) {
        this.initAppv = initAppv;
    }

    public BigInteger getSupAppv() {
        return supAppv;
    }

    public void setSupAppv(BigInteger supAppv) {
        this.supAppv = supAppv;
    }

    public BigInteger getRmsAppv() {
        return rmsAppv;
    }

    public void setRmsAppv(BigInteger rmsAppv) {
        this.rmsAppv = rmsAppv;
    }

    public BigInteger getRmsUnappv() {
        return rmsUnappv;
    }

    public void setRmsUnappv(BigInteger rmsUnappv) {
        this.rmsUnappv = rmsUnappv;
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
        if (!(object instanceof QaTestPlan)) {
            return false;
        }
        QaTestPlan other = (QaTestPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTestPlan[ id=" + id + " ]";
    }

}
