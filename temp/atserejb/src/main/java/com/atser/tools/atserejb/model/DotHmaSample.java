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
@Table(name = "DOT_HMA_SAMPLE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotHmaSample.findAll", query = "SELECT a FROM DotHmaSample a")})
public class DotHmaSample implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "LOADNO")
    private String loadno;
    @Size(max = 50)
    @Column(name = "TRUCK_TEMPERATURE")
    private String truckTemperature;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigDecimal testId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigDecimal labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Size(max = 128)
    @Column(name = "COST_ACC_NO")
    private String costAccNo;
    @Size(max = 25)
    @Column(name = "FED_AID")
    private String fedAid;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Column(name = "PROJECT_ACTIVE")
    private Character projectActive;
    @Size(max = 8)
    @Column(name = "PROJECT_STATUS")
    private String projectStatus;
    @Size(max = 50)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 250)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Column(name = "CONTRACTUAL")
    private Character contractual;
    @Size(max = 50)
    @Column(name = "DISTRICT")
    private String district;
    @Size(max = 4000)
    @Column(name = "PROJECT_CITY_TOWN")
    private String projectCityTown;
    @Size(max = 10)
    @Column(name = "NTP_DATE")
    private String ntpDate;
    @Size(max = 10)
    @Column(name = "COMP_DATE")
    private String compDate;
    @Size(max = 359)
    @Column(name = "RESIDENT_ENG")
    private String residentEng;
    @Size(max = 359)
    @Column(name = "DME_ENG")
    private String dmeEng;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 50)
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "QTY_REP")
    private BigInteger qtyRep;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 100)
    @Column(name = "LOGGED_BY")
    private String loggedBy;
    @Size(max = 50)
    @Column(name = "LOGGED_DATE")
    private String loggedDate;
    @Size(max = 182)
    @Column(name = "SAMPLENO_LINK")
    private String samplenoLink;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Column(name = "MIX_DESIGN_ID")
    private BigDecimal mixDesignId;
    @Size(max = 30)
    @Column(name = "MIX_DESIGN_NO")
    private String mixDesignNo;
    @Size(max = 200)
    @Column(name = "PROPOSED_USE")
    private String proposedUse;
    @Size(max = 4000)
    @Column(name = "ADD_INFO")
    private String addInfo;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "TICKET_NO")
    private String ticketNo;
    @Size(max = 12)
    @Column(name = "TRUCK_NO")
    private String truckNo;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
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
    @Size(max = 500)
    @Column(name = "SAMPLE_PREP_METHOD")
    private String samplePrepMethod;
    @Size(max = 500)
    @Column(name = "SPEC_PREP_METHOD")
    private String specPrepMethod;
    @Size(max = 22)
    @Column(name = "ESTM_QTY")
    private String estmQty;
    @Size(max = 100)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 200)
    @Column(name = "RMS_NO")
    private String rmsNo;
    @Size(max = 1000)
    @Column(name = "MAT_SPEC")
    private String matSpec;
    @Column(name = "SUBITEM_ESTM_QTY")
    private BigInteger subitemEstmQty;
    @Size(max = 100)
    @Column(name = "SUBITEM_UNIT")
    private String subitemUnit;
    @Size(max = 1000)
    @Column(name = "SUBITEM_MAT_SPEC")
    private String subitemMatSpec;
    @Column(name = "EQUIP_LIST")
    @Size(max = 2)
    private String equipList;
    @Size(max = 8)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 50)
    @Column(name = "SAMPLE_CATG_ID")
    private String sampleCatgId;
    @Column(name = "COLLECTION_DATE")
    private Date collectionDate;
    @Size(max = 50)
    @Column(name = "ARRIVAL_TIME")
    private String arrivalTime;
    @Size(max = 255)
    @Column(name = "STATION")
    private String station;
    @Size(max = 50)
    @Column(name = "OFFSET")
    private String offset;
    @Size(max = 50)
    @Column(name = "LOT")
    private String lot;
    @Size(max = 50)
    @Column(name = "SUBLOT")
    private String sublot;
    @Size(max = 255)
    @Column(name = "CITY_TOWN")
    private String cityTown;
    @Column(name = "INFO_ID")
    private BigDecimal infoId;
    @Size(max = 50)
    @Column(name = "RANDOM_SAMPLE")
    private String randomSample;
    @Size(max = 50)
    @Column(name = "RANDOM_NO")
    private String randomNo;
    @Column(name = "SUPPLIER_ID")
    private BigDecimal supplierId;
    @Size(max = 255)
    @Column(name = "PRODUCED_BY")
    private String producedBy;
    @Size(max = 250)
    @Column(name = "PRODUCER_LOCATION")
    private String producerLocation;
    @Column(name = "BINDER_SUPPLIER_ID")
    private BigInteger binderSupplierId;
    @Size(max = 255)
    @Column(name = "BINDER_SUPPLIER")
    private String binderSupplier;
    @Size(max = 50)
    @Column(name = "BINDER_LOCATION")
    private String binderLocation;
    @Size(max = 250)
    @Column(name = "BINDER_SUPPLIER_LOCATION")
    private String binderSupplierLocation;
    @Column(name = "BINDER_GRADE_ID")
    private BigInteger binderGradeId;
    @Size(max = 20)
    @Column(name = "ASPHALTCEMENT")
    private String asphaltcement;
    @Size(max = 80)
    @Column(name = "ADDITIVE")
    private String additive;
    @Size(max = 4000)
    @Column(name = "ADD_INFO1")
    private String addInfo1;
    @Column(name = "SAMPLE_DATE")
    private Date sampleDate;
    @Size(max = 20)
    @Column(name = "QTY_SUBLOT")
    private String qtySublot;
    @Size(max = 50)
    @Column(name = "AIR_TEMPERATURE")
    private String airTemperature;
    @Size(max = 50)
    @Column(name = "HAS_RND_NO")
    private String hasRndNo;
    @Size(max = 50)
    @Column(name = "RND_NO")
    private String rndNo;
    @Size(max = 4000)
    @Column(name = "ADD_INFO2")
    private String addInfo2;
    @Size(max = 4000)
    @Column(name = "ADD_INFO3")
    private String addInfo3;
    @Size(max = 4000)
    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;
    @Size(max = 50)
    @Column(name = "QTY_UNIT")
    private String qtyUnit;
    @Column(name = "SAMPLED_BY_ID")
    private BigDecimal sampledById;
    @Size(max = 50)
    @Column(name = "SAMPLED_BY_TITLE")
    private String sampledByTitle;
    @Size(max = 50)
    @Column(name = "MIX_TYPE")
    private String mixType;
    @Size(max = 50)
    @Column(name = "SAMPLE_TYPE")
    private String sampleType;
    @Column(name = "SAMPLE_NO_SEQ")
    private BigDecimal sampleNoSeq;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 50)
    @Column(name = "MATERIAL_LOCATION")
    private String materialLocation;
    @Size(max = 50)
    @Column(name = "COMB_AGG_GSB")
    private String combAggGsb;
    @Size(max = 50)
    @Column(name = "NMAS")
    private String nmas;
    @Size(max = 20)
    @Column(name = "GYRATION")
    private String gyration;
    @Size(max = 50)
    @Column(name = "BINDER_LOT")
    private String binderLot;
    @Size(max = 50)
    @Column(name = "PAVED_BY")
    private String pavedBy;
    @Size(max = 50)
    @Column(name = "TARGET_CORE_THICKNESS")
    private String targetCoreThickness;
    @Size(max = 255)
    @Column(name = "SAMPLE_OF")
    private String sampleOf;
    @Size(max = 50)
    @Column(name = "SAMPLE_AT")
    private String sampleAt;
    @Size(max = 255)
    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;

    public DotHmaSample() {
    }

    public String getLoadno() {
        return loadno;
    }

    public void setLoadno(String loadno) {
        this.loadno = loadno;
    }

    public String getTruckTemperature() {
        return truckTemperature;
    }

    public void setTruckTemperature(String truckTemperature) {
        this.truckTemperature = truckTemperature;
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

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getCostAccNo() {
        return costAccNo;
    }

    public void setCostAccNo(String costAccNo) {
        this.costAccNo = costAccNo;
    }

    public String getFedAid() {
        return fedAid;
    }

    public void setFedAid(String fedAid) {
        this.fedAid = fedAid;
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

    public Character getProjectActive() {
        return projectActive;
    }

    public void setProjectActive(Character projectActive) {
        this.projectActive = projectActive;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }

    public Character getContractual() {
        return contractual;
    }

    public void setContractual(Character contractual) {
        this.contractual = contractual;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProjectCityTown() {
        return projectCityTown;
    }

    public void setProjectCityTown(String projectCityTown) {
        this.projectCityTown = projectCityTown;
    }

    public String getNtpDate() {
        return ntpDate;
    }

    public void setNtpDate(String ntpDate) {
        this.ntpDate = ntpDate;
    }

    public String getCompDate() {
        return compDate;
    }

    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }

    public String getResidentEng() {
        return residentEng;
    }

    public void setResidentEng(String residentEng) {
        this.residentEng = residentEng;
    }

    public String getDmeEng() {
        return dmeEng;
    }

    public void setDmeEng(String dmeEng) {
        this.dmeEng = dmeEng;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public BigInteger getQtyRep() {
        return qtyRep;
    }

    public void setQtyRep(BigInteger qtyRep) {
        this.qtyRep = qtyRep;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(String loggedBy) {
        this.loggedBy = loggedBy;
    }

    public String getLoggedDate() {
        return loggedDate;
    }

    public void setLoggedDate(String loggedDate) {
        this.loggedDate = loggedDate;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
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

    public String getProposedUse() {
        return proposedUse;
    }

    public void setProposedUse(String proposedUse) {
        this.proposedUse = proposedUse;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getLonGps() {
        return lonGps;
    }

    public void setLonGps(String lonGps) {
        this.lonGps = lonGps;
    }

    public String getAltGps() {
        return altGps;
    }

    public void setAltGps(String altGps) {
        this.altGps = altGps;
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

    public String getSamplePrepMethod() {
        return samplePrepMethod;
    }

    public void setSamplePrepMethod(String samplePrepMethod) {
        this.samplePrepMethod = samplePrepMethod;
    }

    public String getSpecPrepMethod() {
        return specPrepMethod;
    }

    public void setSpecPrepMethod(String specPrepMethod) {
        this.specPrepMethod = specPrepMethod;
    }

    public String getEstmQty() {
        return estmQty;
    }

    public void setEstmQty(String estmQty) {
        this.estmQty = estmQty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRmsNo() {
        return rmsNo;
    }

    public void setRmsNo(String rmsNo) {
        this.rmsNo = rmsNo;
    }

    public String getMatSpec() {
        return matSpec;
    }

    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    public BigInteger getSubitemEstmQty() {
        return subitemEstmQty;
    }

    public void setSubitemEstmQty(BigInteger subitemEstmQty) {
        this.subitemEstmQty = subitemEstmQty;
    }

    public String getSubitemUnit() {
        return subitemUnit;
    }

    public void setSubitemUnit(String subitemUnit) {
        this.subitemUnit = subitemUnit;
    }

    public String getSubitemMatSpec() {
        return subitemMatSpec;
    }

    public void setSubitemMatSpec(String subitemMatSpec) {
        this.subitemMatSpec = subitemMatSpec;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSampleCatgId() {
        return sampleCatgId;
    }

    public void setSampleCatgId(String sampleCatgId) {
        this.sampleCatgId = sampleCatgId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getSublot() {
        return sublot;
    }

    public void setSublot(String sublot) {
        this.sublot = sublot;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    public BigDecimal getInfoId() {
        return infoId;
    }

    public void setInfoId(BigDecimal infoId) {
        this.infoId = infoId;
    }

    public String getRandomSample() {
        return randomSample;
    }

    public void setRandomSample(String randomSample) {
        this.randomSample = randomSample;
    }

    public String getRandomNo() {
        return randomNo;
    }

    public void setRandomNo(String randomNo) {
        this.randomNo = randomNo;
    }

    public BigDecimal getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getProducerLocation() {
        return producerLocation;
    }

    public void setProducerLocation(String producerLocation) {
        this.producerLocation = producerLocation;
    }

    public BigInteger getBinderSupplierId() {
        return binderSupplierId;
    }

    public void setBinderSupplierId(BigInteger binderSupplierId) {
        this.binderSupplierId = binderSupplierId;
    }

    public String getBinderSupplier() {
        return binderSupplier;
    }

    public void setBinderSupplier(String binderSupplier) {
        this.binderSupplier = binderSupplier;
    }

    public String getBinderLocation() {
        return binderLocation;
    }

    public void setBinderLocation(String binderLocation) {
        this.binderLocation = binderLocation;
    }

    public String getBinderSupplierLocation() {
        return binderSupplierLocation;
    }

    public void setBinderSupplierLocation(String binderSupplierLocation) {
        this.binderSupplierLocation = binderSupplierLocation;
    }

    public BigInteger getBinderGradeId() {
        return binderGradeId;
    }

    public void setBinderGradeId(BigInteger binderGradeId) {
        this.binderGradeId = binderGradeId;
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

    public String getAddInfo1() {
        return addInfo1;
    }

    public void setAddInfo1(String addInfo1) {
        this.addInfo1 = addInfo1;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public String getQtySublot() {
        return qtySublot;
    }

    public void setQtySublot(String qtySublot) {
        this.qtySublot = qtySublot;
    }

    public String getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(String airTemperature) {
        this.airTemperature = airTemperature;
    }

    public String getHasRndNo() {
        return hasRndNo;
    }

    public void setHasRndNo(String hasRndNo) {
        this.hasRndNo = hasRndNo;
    }

    public String getRndNo() {
        return rndNo;
    }

    public void setRndNo(String rndNo) {
        this.rndNo = rndNo;
    }

    public String getAddInfo2() {
        return addInfo2;
    }

    public void setAddInfo2(String addInfo2) {
        this.addInfo2 = addInfo2;
    }

    public String getAddInfo3() {
        return addInfo3;
    }

    public void setAddInfo3(String addInfo3) {
        this.addInfo3 = addInfo3;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getQtyUnit() {
        return qtyUnit;
    }

    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit;
    }

    public BigDecimal getSampledById() {
        return sampledById;
    }

    public void setSampledById(BigDecimal sampledById) {
        this.sampledById = sampledById;
    }

    public String getSampledByTitle() {
        return sampledByTitle;
    }

    public void setSampledByTitle(String sampledByTitle) {
        this.sampledByTitle = sampledByTitle;
    }

    public String getMixType() {
        return mixType;
    }

    public void setMixType(String mixType) {
        this.mixType = mixType;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public BigDecimal getSampleNoSeq() {
        return sampleNoSeq;
    }

    public void setSampleNoSeq(BigDecimal sampleNoSeq) {
        this.sampleNoSeq = sampleNoSeq;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMaterialLocation() {
        return materialLocation;
    }

    public void setMaterialLocation(String materialLocation) {
        this.materialLocation = materialLocation;
    }

    public String getCombAggGsb() {
        return combAggGsb;
    }

    public void setCombAggGsb(String combAggGsb) {
        this.combAggGsb = combAggGsb;
    }

    public String getNmas() {
        return nmas;
    }

    public void setNmas(String nmas) {
        this.nmas = nmas;
    }

    public String getGyration() {
        return gyration;
    }

    public void setGyration(String gyration) {
        this.gyration = gyration;
    }

    public String getBinderLot() {
        return binderLot;
    }

    public void setBinderLot(String binderLot) {
        this.binderLot = binderLot;
    }

    public String getPavedBy() {
        return pavedBy;
    }

    public void setPavedBy(String pavedBy) {
        this.pavedBy = pavedBy;
    }

    public String getTargetCoreThickness() {
        return targetCoreThickness;
    }

    public void setTargetCoreThickness(String targetCoreThickness) {
        this.targetCoreThickness = targetCoreThickness;
    }

    public String getSampleOf() {
        return sampleOf;
    }

    public void setSampleOf(String sampleOf) {
        this.sampleOf = sampleOf;
    }

    public String getSampleAt() {
        return sampleAt;
    }

    public void setSampleAt(String sampleAt) {
        this.sampleAt = sampleAt;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    @JsonSkipXssSerialization
    public String getSamplenoLink() {
        if (StringSupport.isNotNullAndNotEmpty(samplenoLink) && samplenoLink.contains("../../")) {
            return samplenoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return samplenoLink;
    }
}
