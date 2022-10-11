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
@Table(name = "dot_camisc_t27", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotCamiscT27.findAll", query = "SELECT a FROM DotCamiscT27 a")})
public class DotCamiscT27 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "PERCENTPASS")
    private String percentpass;
    @Size(max = 50)
    @Column(name = "COMBPCT")
    private String combpct;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
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
    @Column(name = "PERCENTRET")
    private BigDecimal percentret;
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
    @Size(max = 190)
    @Column(name = "TESTNO")
    private String testNoLink;
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
    @Column(name = "SET_ID")
    private BigDecimal setId;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Size(max = 50)
    @Column(name = "INITDRYWT")
    private String initdrywt;
    @Size(max = 50)
    @Column(name = "TAREWTT1")
    private String tarewtt1;
    @Size(max = 50)
    @Column(name = "WTAFTERWASH")
    private String wtafterwash;
    @Size(max = 50)
    @Column(name = "TAREWTT2")
    private String tarewtt2;
    @Size(max = 50)
    @Column(name = "WTPRIORWASH")
    private String wtpriorwash;
    @Size(max = 50)
    @Column(name = "WTAFTERWASH200")
    private String wtafterwash200;
    @Size(max = 50)
    @Column(name = "WASHLOSS")
    private String washloss;
    @Size(max = 50)
    @Column(name = "TOTALPERCENTPASS")
    private String totalpercentpass;
    @Size(max = 50)
    @Column(name = "PAN")
    private String pan;
    @Size(max = 50)
    @Column(name = "TOTAL")
    private String total;
    @Size(max = 50)
    @Column(name = "FINEWT")
    private String finewt;
    @Size(max = 50)
    @Column(name = "FINEMODE")
    private String finemode;
    @Column(name = "ISCOMB")
    private Character iscomb;
    @Size(max = 50)
    @Column(name = "UNITENGMET")
    private String unitengmet;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "SIEVESHAKER")
    private String sieveshaker;
    @Size(max = 255)
    @Column(name = "BALANCE")
    private String balance;
    @Size(max = 255)
    @Column(name = "OVEN")
    private String oven;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "SOAK_TIME")
    private String soakTime;
    @Size(max = 50)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 100)
    @Column(name = "SOILCLASS")
    private String soilclass;
    @Size(max = 50)
    @Column(name = "NRESULTS")
    private String nresults;
    @Size(max = 50)
    @Column(name = "PERCENT_LOSS")
    private String percentLoss;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "COARSE_FACTOR")
    private String coarseFactor;
    @Size(max = 50)
    @Column(name = "FINE_FACTOR")
    private String fineFactor;
    @Size(max = 50)
    @Column(name = "SPLIT_WT")
    private String splitWt;
    @Size(max = 50)
    @Column(name = "PAN_CA")
    private String panCa;
    @Size(max = 50)
    @Column(name = "TOTAL_CA")
    private String totalCa;
    @Size(max = 50)
    @Column(name = "AMOUNT_LOSS_SIEVE")
    private String amountLossSieve;
    @Size(max = 50)
    @Column(name = "CORR_ORIG_MASS")
    private String corrOrigMass;
    @Size(max = 50)
    @Column(name = "PERCENT_LOSS_SPEC")
    private String percentLossSpec;
    @Size(max = 50)
    @Column(name = "PERCENT_LOSS_RESULT")
    private String percentLossResult;
    @Size(max = 50)
    @Column(name = "PERCENT_LOSS_SIEVE")
    private String percentLossSieve;
    @Size(max = 50)
    @Column(name = "PAN_PR")
    private String panPr;
    @Size(max = 50)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Size(max = 50)
    @Column(name = "FINEMODE_PROJREQUIRE")
    private String finemodeProjrequire;
    @Size(max = 50)
    @Column(name = "FINEMODE_RESULT")
    private String finemodeResult;
    @Column(name = "RUN_NO")
    private BigInteger runNo;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Size(max = 50)
    @Column(name = "WTRET")
    private String wtret;
    @Size(max = 50)
    @Column(name = "ACCUMWTRET")
    private String accumwtret;

    public DotCamiscT27() {
    }

    public String getPercentpass() {
        return percentpass;
    }

    public void setPercentpass(String percentpass) {
        this.percentpass = percentpass;
    }

    public String getCombpct() {
        return combpct;
    }

    public void setCombpct(String combpct) {
        this.combpct = combpct;
    }

    public String getProjrequire() {
        return projrequire;
    }

    public void setProjrequire(String projrequire) {
        this.projrequire = projrequire;
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

    public BigDecimal getPercentret() {
        return percentret;
    }

    public void setPercentret(BigDecimal percentret) {
        this.percentret = percentret;
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

    public BigDecimal getSetId() {
        return setId;
    }

    public void setSetId(BigDecimal setId) {
        this.setId = setId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getInitdrywt() {
        return initdrywt;
    }

    public void setInitdrywt(String initdrywt) {
        this.initdrywt = initdrywt;
    }

    public String getTarewtt1() {
        return tarewtt1;
    }

    public void setTarewtt1(String tarewtt1) {
        this.tarewtt1 = tarewtt1;
    }

    public String getWtafterwash() {
        return wtafterwash;
    }

    public void setWtafterwash(String wtafterwash) {
        this.wtafterwash = wtafterwash;
    }

    public String getTarewtt2() {
        return tarewtt2;
    }

    public void setTarewtt2(String tarewtt2) {
        this.tarewtt2 = tarewtt2;
    }

    public String getWtpriorwash() {
        return wtpriorwash;
    }

    public void setWtpriorwash(String wtpriorwash) {
        this.wtpriorwash = wtpriorwash;
    }

    public String getWtafterwash200() {
        return wtafterwash200;
    }

    public void setWtafterwash200(String wtafterwash200) {
        this.wtafterwash200 = wtafterwash200;
    }

    public String getWashloss() {
        return washloss;
    }

    public void setWashloss(String washloss) {
        this.washloss = washloss;
    }

    public String getTotalpercentpass() {
        return totalpercentpass;
    }

    public void setTotalpercentpass(String totalpercentpass) {
        this.totalpercentpass = totalpercentpass;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFinewt() {
        return finewt;
    }

    public void setFinewt(String finewt) {
        this.finewt = finewt;
    }

    public String getFinemode() {
        return finemode;
    }

    public void setFinemode(String finemode) {
        this.finemode = finemode;
    }

    public Character getIscomb() {
        return iscomb;
    }

    public void setIscomb(Character iscomb) {
        this.iscomb = iscomb;
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

    public String getSieveshaker() {
        return sieveshaker;
    }

    public void setSieveshaker(String sieveshaker) {
        this.sieveshaker = sieveshaker;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOven() {
        return oven;
    }

    public void setOven(String oven) {
        this.oven = oven;
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

    public String getSoakTime() {
        return soakTime;
    }

    public void setSoakTime(String soakTime) {
        this.soakTime = soakTime;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getSoilclass() {
        return soilclass;
    }

    public void setSoilclass(String soilclass) {
        this.soilclass = soilclass;
    }

    public String getNresults() {
        return nresults;
    }

    public void setNresults(String nresults) {
        this.nresults = nresults;
    }

    public String getPercentLoss() {
        return percentLoss;
    }

    public void setPercentLoss(String percentLoss) {
        this.percentLoss = percentLoss;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCoarseFactor() {
        return coarseFactor;
    }

    public void setCoarseFactor(String coarseFactor) {
        this.coarseFactor = coarseFactor;
    }

    public String getFineFactor() {
        return fineFactor;
    }

    public void setFineFactor(String fineFactor) {
        this.fineFactor = fineFactor;
    }

    public String getSplitWt() {
        return splitWt;
    }

    public void setSplitWt(String splitWt) {
        this.splitWt = splitWt;
    }

    public String getPanCa() {
        return panCa;
    }

    public void setPanCa(String panCa) {
        this.panCa = panCa;
    }

    public String getTotalCa() {
        return totalCa;
    }

    public void setTotalCa(String totalCa) {
        this.totalCa = totalCa;
    }

    public String getAmountLossSieve() {
        return amountLossSieve;
    }

    public void setAmountLossSieve(String amountLossSieve) {
        this.amountLossSieve = amountLossSieve;
    }

    public String getCorrOrigMass() {
        return corrOrigMass;
    }

    public void setCorrOrigMass(String corrOrigMass) {
        this.corrOrigMass = corrOrigMass;
    }

    public String getPercentLossSpec() {
        return percentLossSpec;
    }

    public void setPercentLossSpec(String percentLossSpec) {
        this.percentLossSpec = percentLossSpec;
    }

    public String getPercentLossResult() {
        return percentLossResult;
    }

    public void setPercentLossResult(String percentLossResult) {
        this.percentLossResult = percentLossResult;
    }

    public String getPercentLossSieve() {
        return percentLossSieve;
    }

    public void setPercentLossSieve(String percentLossSieve) {
        this.percentLossSieve = percentLossSieve;
    }

    public String getPanPr() {
        return panPr;
    }

    public void setPanPr(String panPr) {
        this.panPr = panPr;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getFinemodeProjrequire() {
        return finemodeProjrequire;
    }

    public void setFinemodeProjrequire(String finemodeProjrequire) {
        this.finemodeProjrequire = finemodeProjrequire;
    }

    public String getFinemodeResult() {
        return finemodeResult;
    }

    public void setFinemodeResult(String finemodeResult) {
        this.finemodeResult = finemodeResult;
    }

    public BigInteger getRunNo() {
        return runNo;
    }

    public void setRunNo(BigInteger runNo) {
        this.runNo = runNo;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public String getSieveName() {
        return sieveName;
    }

    public void setSieveName(String sieveName) {
        this.sieveName = sieveName;
    }

    public String getWtret() {
        return wtret;
    }

    public void setWtret(String wtret) {
        this.wtret = wtret;
    }

    public String getAccumwtret() {
        return accumwtret;
    }

    public void setAccumwtret(String accumwtret) {
        this.accumwtret = accumwtret;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
