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
@Table(name = "DOT_CONCRETE_SAMPLE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConcreteSample.findAll", query = "SELECT a FROM DotConcreteSample a")})
public class DotConcreteSample implements Serializable {

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
    @Column(name = "PROJECT_ACTIVE")
    private Character projectActive;
    @Column(name = "CONTRACTUAL")
    private Character contractual;
    @Size(max = 2)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 8)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "COLLECTION_DATE")
    private Date collectionDate;
    @Column(name = "ESTM_QTY")
    private BigDecimal estmQty;
    @Column(name = "SUBBIDITEM_ID")
    private Integer subbiditemId;
    @Column(name = "QTY_REP")
    private Integer qtyRep;
    @Column(name = "SUBITEM_ESTM_QTY")
    private Integer subitemEstmQty;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "TECH_ID")
    private Integer techId;
    @Column(name = "FUNCTION_ID")
    private Integer functionId;
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;
    @Column(name = "MIX_DESIGN_ID")
    private Integer mixDesignId;
    @Column(name = "SAMPLED_BY_ID")
    private Integer sampledById;
    @Column(name = "INFO_ID")
    private Integer infoId;
    @Column(name = "BIDITEM_ID")
    private Integer biditemId;
    @Column(name = "LAB_ID")
    private Integer labId;
    @Column(name = "TEST_ID")
    private Integer testId;
    @Column(name = "SAMPLE_NO_SEQ")
    private Integer sampleNoSeq;
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Size(max = 10)
    @Column(name = "NTP_DATE")
    private String ntpDate;
    @Size(max = 10)
    @Column(name = "COMP_DATE")
    private String compDate;
    @Size(max = 10)
    @Column(name = "SUBLOT")
    private String sublot;
    @Size(max = 100)
    @Column(name = "DESIGN_STRENGTH")
    private String designStrength;
    @Size(max = 100)
    @Column(name = "LOGGED_BY")
    private String loggedBy;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 100)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 100)
    @Column(name = "SUBITEM_UNIT")
    private String subitemUnit;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 100)
    @Column(name = "TICKET_NO")
    private String ticketNo;
    @Size(max = 1000)
    @Column(name = "MAT_SPEC")
    private String matSpec;
    @Size(max = 1000)
    @Column(name = "SUBITEM_MAT_SPEC")
    private String subitemMatSpec;
    @Size(max = 103)
    @Column(name = "CUR_RANGE_TEMP")
    private String curRangeTemp;
    @Size(max = 12)
    @Column(name = "TRUCK_NO")
    private String truckNo;
    @Size(max = 12)
    @Column(name = "WATER_ADDED")
    private String waterAdded;
    @Size(max = 12)
    @Column(name = "BATCH_SIZE")
    private String batchSize;
    @Size(max = 128)
    @Column(name = "COST_ACC_NO")
    private String costAccNo;
    @Size(max = 15)
    @Column(name = "SAMPLE_TIME")
    private String sampleTime;
    @Size(max = 15)
    @Column(name = "TOTAL_DISCHARGE_TIME")
    private String totalDischargeTime;
    @JsonSkipXssSerialization
    @Size(max = 183)
    @Column(name = "SAMPLENO_LINK")
    private String testNoLink;
    @Size(max = 200)
    @Column(name = "PROPOSED_USE")
    private String proposedUse;
    @Size(max = 200)
    @Column(name = "RMS_NO")
    private String rmsNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "FED_AID")
    private String fedAid;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 250)
    @Column(name = "PRODUCER_LOCATION")
    private String producerLocation;
    @Size(max = 250)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Size(max = 255)
    @Column(name = "PRODUCED_BY")
    private String producedBy;
    @Size(max = 255)
    @Column(name = "CITY_TOWN")
    private String cityTown;
    @Size(max = 255)
    @Column(name = "STATION")
    private String station;
    @Size(max = 255)
    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 359)
    @Column(name = "RESIDENT_ENG")
    private String residentEng;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 359)
    @Column(name = "DME_ENG")
    private String dmeEng;
    @Size(max = 4000)
    @Column(name = "PROJECT_CITY_TOWN")
    private String projectCityTown;
    @Size(max = 4000)
    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;
    @Size(max = 4000)
    @Column(name = "ADD_INFO")
    private String addInfo;
    @Size(max = 50)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 50)
    @Column(name = "CURING_MAXTEMP")
    private String curingMaxtemp;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 50)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 50)
    @Column(name = "LOGGED_DATE")
    private String loggedDate;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "DISTRICT")
    private String district;
    @Size(max = 50)
    @Column(name = "CURING_MINTEMP")
    private String curingMintemp;
    @Size(max = 50)
    @Column(name = "CURING_METHOD")
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "SPECIMEN_COVERED")
    private String specimenCovered;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 50)
    @Column(name = "SAMPLE_CATG_ID")
    private String sampleCatgId;
    @Size(max = 50)
    @Column(name = "ARRIVAL_TIME")
    private String arrivalTime;
    @Size(max = 50)
    @Column(name = "OFFSET")
    private String offset;
    @Size(max = 50)
    @Column(name = "LOT")
    private String lot;
    @Size(max = 50)
    @Column(name = "RANDOM_SAMPLE")
    private String randomSample;
    @Size(max = 50)
    @Column(name = "RANDOM_NO")
    private String randomNo;
    @Size(max = 50)
    @Column(name = "QTY_UNIT")
    private String qtyUnit;
    @Size(max = 50)
    @Column(name = "SAMPLED_BY_TITLE")
    private String sampledByTitle;
    @Size(max = 50)
    @Column(name = "LOADNO")
    private String loadno;
    @Size(max = 50)
    @Column(name = "LABPREP_OTHER")
    private String labprepOther;
    @Size(max = 50)
    @Column(name = "MIX_TYPE")
    private String mixType;
    @Size(max = 50)
    @Column(name = "SAMPLE_TYPE")
    private String sampleType;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 50)
    @Column(name = "MATERIAL_LOCATION")
    private String materialLocation;
    @Size(max = 50)
    @Column(name = "AIR_TEMPERATURE")
    private String airTemperature;
    @Size(max = 50)
    @Column(name = "AGG_SIZE")
    private String aggSize;
    @Size(max = 50)
    @Column(name = "TOTAL_CEMENTITIOUS")
    private String totalCementitious;
    @Size(max = 50)
    @Column(name = "BATCHWEIGHT")
    private String batchweight;
    @Size(max = 50)
    @Column(name = "ADDITIONAL_ADMIXTURE")
    private String additionalAdmixtureF;
    @Size(max = 50)
    @Column(name = "BATCH_START_TIME")
    private String batchStartTime;
    @Size(max = 50)
    @Column(name = "BATCH_END_TIME")
    private String batchEndTime;
    @Size(max = 50)
    @Column(name = "SPECIMEN_SHAPE")
    private String specimenShape;
    @Size(max = 50)
    @Column(name = "DISCHARGE_END_TIME")
    private String dischargeEndTime;
    @Size(max = 500)
    @Column(name = "SPEC_PREP_METHOD")
    private String specPrepMethod;
    @Size(max = 500)
    @Column(name = "SAMPLE_PREP_METHOD")
    private String samplePrepMethod;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 8)
    @Column(name = "PROJECT_STATUS")
    private String projectStatus;

    public DotConcreteSample() {
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

    public Character getProjectActive() {
        return projectActive;
    }

    public void setProjectActive(Character projectActive) {
        this.projectActive = projectActive;
    }

    public Character getContractual() {
        return contractual;
    }

    public void setContractual(Character contractual) {
        this.contractual = contractual;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public BigDecimal getEstmQty() {
        return estmQty;
    }

    public void setEstmQty(BigDecimal estmQty) {
        this.estmQty = estmQty;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(Integer subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public Integer getQtyRep() {
        return qtyRep;
    }

    public void setQtyRep(Integer qtyRep) {
        this.qtyRep = qtyRep;
    }

    public Integer getSubitemEstmQty() {
        return subitemEstmQty;
    }

    public void setSubitemEstmQty(Integer subitemEstmQty) {
        this.subitemEstmQty = subitemEstmQty;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(Integer mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public Integer getSampledById() {
        return sampledById;
    }

    public void setSampledById(Integer sampledById) {
        this.sampledById = sampledById;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(Integer biditemId) {
        this.biditemId = biditemId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getSampleNoSeq() {
        return sampleNoSeq;
    }

    public void setSampleNoSeq(Integer sampleNoSeq) {
        this.sampleNoSeq = sampleNoSeq;
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

    public String getSublot() {
        return sublot;
    }

    public void setSublot(String sublot) {
        this.sublot = sublot;
    }

    public String getDesignStrength() {
        return designStrength;
    }

    public void setDesignStrength(String designStrength) {
        this.designStrength = designStrength;
    }

    public String getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(String loggedBy) {
        this.loggedBy = loggedBy;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSubitemUnit() {
        return subitemUnit;
    }

    public void setSubitemUnit(String subitemUnit) {
        this.subitemUnit = subitemUnit;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getMatSpec() {
        return matSpec;
    }

    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    public String getSubitemMatSpec() {
        return subitemMatSpec;
    }

    public void setSubitemMatSpec(String subitemMatSpec) {
        this.subitemMatSpec = subitemMatSpec;
    }

    public String getCurRangeTemp() {
        return curRangeTemp;
    }

    public void setCurRangeTemp(String curRangeTemp) {
        this.curRangeTemp = curRangeTemp;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getWaterAdded() {
        return waterAdded;
    }

    public void setWaterAdded(String waterAdded) {
        this.waterAdded = waterAdded;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getCostAccNo() {
        return costAccNo;
    }

    public void setCostAccNo(String costAccNo) {
        this.costAccNo = costAccNo;
    }

    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getTotalDischargeTime() {
        return totalDischargeTime;
    }

    public void setTotalDischargeTime(String totalDischargeTime) {
        this.totalDischargeTime = totalDischargeTime;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getProposedUse() {
        return proposedUse;
    }

    public void setProposedUse(String proposedUse) {
        this.proposedUse = proposedUse;
    }

    public String getRmsNo() {
        return rmsNo;
    }

    public void setRmsNo(String rmsNo) {
        this.rmsNo = rmsNo;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
    }

    public String getFedAid() {
        return fedAid;
    }

    public void setFedAid(String fedAid) {
        this.fedAid = fedAid;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getProducerLocation() {
        return producerLocation;
    }

    public void setProducerLocation(String producerLocation) {
        this.producerLocation = producerLocation;
    }

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getResidentEng() {
        return residentEng;
    }

    public void setResidentEng(String residentEng) {
        this.residentEng = residentEng;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getDmeEng() {
        return dmeEng;
    }

    public void setDmeEng(String dmeEng) {
        this.dmeEng = dmeEng;
    }

    public String getProjectCityTown() {
        return projectCityTown;
    }

    public void setProjectCityTown(String projectCityTown) {
        this.projectCityTown = projectCityTown;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getCuringMaxtemp() {
        return curingMaxtemp;
    }

    public void setCuringMaxtemp(String curingMaxtemp) {
        this.curingMaxtemp = curingMaxtemp;
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

    public String getLoggedDate() {
        return loggedDate;
    }

    public void setLoggedDate(String loggedDate) {
        this.loggedDate = loggedDate;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCuringMintemp() {
        return curingMintemp;
    }

    public void setCuringMintemp(String curingMintemp) {
        this.curingMintemp = curingMintemp;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public String getQtyUnit() {
        return qtyUnit;
    }

    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit;
    }

    public String getSampledByTitle() {
        return sampledByTitle;
    }

    public void setSampledByTitle(String sampledByTitle) {
        this.sampledByTitle = sampledByTitle;
    }

    public String getLoadno() {
        return loadno;
    }

    public void setLoadno(String loadno) {
        this.loadno = loadno;
    }

    public String getLabprepOther() {
        return labprepOther;
    }

    public void setLabprepOther(String labprepOther) {
        this.labprepOther = labprepOther;
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

    public String getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(String airTemperature) {
        this.airTemperature = airTemperature;
    }

    public String getAggSize() {
        return aggSize;
    }

    public void setAggSize(String aggSize) {
        this.aggSize = aggSize;
    }

    public String getTotalCementitious() {
        return totalCementitious;
    }

    public void setTotalCementitious(String totalCementitious) {
        this.totalCementitious = totalCementitious;
    }

    public String getBatchweight() {
        return batchweight;
    }

    public void setBatchweight(String batchweight) {
        this.batchweight = batchweight;
    }

    public String getAdditionalAdmixtureF() {
        return additionalAdmixtureF;
    }

    public void setAdditionalAdmixtureF(String additionalAdmixtureF) {
        this.additionalAdmixtureF = additionalAdmixtureF;
    }

    public String getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(String batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public String getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(String batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    public String getSpecimenShape() {
        return specimenShape;
    }

    public void setSpecimenShape(String specimenShape) {
        this.specimenShape = specimenShape;
    }

    public String getDischargeEndTime() {
        return dischargeEndTime;
    }

    public void setDischargeEndTime(String dischargeEndTime) {
        this.dischargeEndTime = dischargeEndTime;
    }

    public String getSpecPrepMethod() {
        return specPrepMethod;
    }

    public void setSpecPrepMethod(String specPrepMethod) {
        this.specPrepMethod = specPrepMethod;
    }

    public String getSamplePrepMethod() {
        return samplePrepMethod;
    }

    public void setSamplePrepMethod(String samplePrepMethod) {
        this.samplePrepMethod = samplePrepMethod;
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

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
