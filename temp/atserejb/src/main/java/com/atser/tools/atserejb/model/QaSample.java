/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "QaSample.findByContractId", query = "SELECT q FROM QaSample q WHERE q.contractId = :contractId"),
    @NamedQuery(name = "QaSample.findByProjectId", query = "SELECT q FROM QaSample q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaSample.findBySampleNo", query = "SELECT q FROM QaSample q WHERE q.sampleNo = :sampleNo"),
    @NamedQuery(name = "QaSample.findBySampleCatgId", query = "SELECT q FROM QaSample q WHERE q.sampleCatgId = :sampleCatgId"),
    @NamedQuery(name = "QaSample.findBySegmentId", query = "SELECT q FROM QaSample q WHERE q.segmentId = :segmentId"),
    @NamedQuery(name = "QaSample.findByStation", query = "SELECT q FROM QaSample q WHERE q.station = :station"),
    @NamedQuery(name = "QaSample.findByLot", query = "SELECT q FROM QaSample q WHERE q.lot = :lot"),
    @NamedQuery(name = "QaSample.findBySublot", query = "SELECT q FROM QaSample q WHERE q.sublot = :sublot"),
    @NamedQuery(name = "QaSample.findByLocation", query = "SELECT q FROM QaSample q WHERE q.location = :location"),
    @NamedQuery(name = "QaSample.findByLongt", query = "SELECT q FROM QaSample q WHERE q.longt = :longt"),
    @NamedQuery(name = "QaSample.findByLat", query = "SELECT q FROM QaSample q WHERE q.lat = :lat"),
    @NamedQuery(name = "QaSample.findByWoNo", query = "SELECT q FROM QaSample q WHERE q.woNo = :woNo"),
    @NamedQuery(name = "QaSample.findByFunction", query = "SELECT q FROM QaSample q WHERE q.function = :function"),
    @NamedQuery(name = "QaSample.findByStatus", query = "SELECT q FROM QaSample q WHERE q.status = :status"),
    @NamedQuery(name = "QaSample.findByRetest", query = "SELECT q FROM QaSample q WHERE q.retest = :retest"),
    @NamedQuery(name = "QaSample.findByFieldusr", query = "SELECT q FROM QaSample q WHERE q.fieldusr = :fieldusr"),
    @NamedQuery(name = "QaSample.findByPdaId", query = "SELECT q FROM QaSample q WHERE q.pdaId = :pdaId"),
    @NamedQuery(name = "QaSample.findByCrossrefSamples", query = "SELECT q FROM QaSample q WHERE q.crossrefSamples = :crossrefSamples"),
    @NamedQuery(name = "QaSample.findByCollectionTime", query = "SELECT q FROM QaSample q WHERE q.collectionTime = :collectionTime"),
    @NamedQuery(name = "QaSample.findByReceivedBy", query = "SELECT q FROM QaSample q WHERE q.receivedBy = :receivedBy"),
    @NamedQuery(name = "QaSample.findByDescription", query = "SELECT q FROM QaSample q WHERE q.description = :description"),
    @NamedQuery(name = "QaSample.findByApprovalSig", query = "SELECT q FROM QaSample q WHERE q.approvalSig = :approvalSig"),
    @NamedQuery(name = "QaSample.findByRejectReason", query = "SELECT q FROM QaSample q WHERE q.rejectReason = :rejectReason"),
    @NamedQuery(name = "QaSample.findByActive", query = "SELECT q FROM QaSample q WHERE q.active = :active"),
    @NamedQuery(name = "QaSample.findByLastModBy", query = "SELECT q FROM QaSample q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSample.findByLastModIp", query = "SELECT q FROM QaSample q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSample.findByCreateBy", query = "SELECT q FROM QaSample q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSample.findByCreateByIp", query = "SELECT q FROM QaSample q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSample.findByReportNo", query = "SELECT q FROM QaSample q WHERE q.reportNo = :reportNo"),
    @NamedQuery(name = "QaSample.findByLabId", query = "SELECT q FROM QaSample q WHERE q.labId = :labId"),
    @NamedQuery(name = "QaSample.findByInfoId", query = "SELECT q FROM QaSample q WHERE q.infoId = :infoId"),
    @NamedQuery(name = "QaSample.findByVersion", query = "SELECT q FROM QaSample q WHERE q.version = :version"),
    @NamedQuery(name = "QaSample.findByClassId", query = "SELECT q FROM QaSample q WHERE q.classId = :classId"),
    @NamedQuery(name = "QaSample.findByItemId", query = "SELECT q FROM QaSample q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaSample.findByPitname", query = "SELECT q FROM QaSample q WHERE q.pitname = :pitname"),
    @NamedQuery(name = "QaSample.findBySupplierId", query = "SELECT q FROM QaSample q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaSample.findByContractorId", query = "SELECT q FROM QaSample q WHERE q.contractorId = :contractorId"),
    @NamedQuery(name = "QaSample.findByCtypeId", query = "SELECT q FROM QaSample q WHERE q.ctypeId = :ctypeId"),
    @NamedQuery(name = "QaSample.findByPrevUsed", query = "SELECT q FROM QaSample q WHERE q.prevUsed = :prevUsed"),
    @NamedQuery(name = "QaSample.findByComments", query = "SELECT q FROM QaSample q WHERE q.comments = :comments"),
    @NamedQuery(name = "QaSample.findBySpecProv", query = "SELECT q FROM QaSample q WHERE q.specProv = :specProv"),
    @NamedQuery(name = "QaSample.findBySampleSubmt", query = "SELECT q FROM QaSample q WHERE q.sampleSubmt = :sampleSubmt"),
    @NamedQuery(name = "QaSample.findBySourceId", query = "SELECT q FROM QaSample q WHERE q.sourceId = :sourceId"),
    @NamedQuery(name = "QaSample.findByShipTo", query = "SELECT q FROM QaSample q WHERE q.shipTo = :shipTo"),
    @NamedQuery(name = "QaSample.findByVia", query = "SELECT q FROM QaSample q WHERE q.via = :via"),
    @NamedQuery(name = "QaSample.findByQtyUnit", query = "SELECT q FROM QaSample q WHERE q.qtyUnit = :qtyUnit"),
    @NamedQuery(name = "QaSample.findByQtyRep", query = "SELECT q FROM QaSample q WHERE q.qtyRep = :qtyRep"),
    @NamedQuery(name = "QaSample.findByQtyPrev", query = "SELECT q FROM QaSample q WHERE q.qtyPrev = :qtyPrev"),
    @NamedQuery(name = "QaSample.findByQtyTotal", query = "SELECT q FROM QaSample q WHERE q.qtyTotal = :qtyTotal"),
    @NamedQuery(name = "QaSample.findByMetricUnit", query = "SELECT q FROM QaSample q WHERE q.metricUnit = :metricUnit"),
    @NamedQuery(name = "QaSample.findBySupervisor", query = "SELECT q FROM QaSample q WHERE q.supervisor = :supervisor"),
    @NamedQuery(name = "QaSample.findBySupervisorTitle", query = "SELECT q FROM QaSample q WHERE q.supervisorTitle = :supervisorTitle"),
    @NamedQuery(name = "QaSample.findBySupervisorAddress", query = "SELECT q FROM QaSample q WHERE q.supervisorAddress = :supervisorAddress"),
    @NamedQuery(name = "QaSample.findByFieldusrTitle", query = "SELECT q FROM QaSample q WHERE q.fieldusrTitle = :fieldusrTitle"),
    @NamedQuery(name = "QaSample.findByLabPhone", query = "SELECT q FROM QaSample q WHERE q.labPhone = :labPhone"),
    @NamedQuery(name = "QaSample.findByGyration", query = "SELECT q FROM QaSample q WHERE q.gyration = :gyration"),
    @NamedQuery(name = "QaSample.findByBinder", query = "SELECT q FROM QaSample q WHERE q.binder = :binder"),
    @NamedQuery(name = "QaSample.findByGrading", query = "SELECT q FROM QaSample q WHERE q.grading = :grading"),
    @NamedQuery(name = "QaSample.findByHrutter", query = "SELECT q FROM QaSample q WHERE q.hrutter = :hrutter"),
    @NamedQuery(name = "QaSample.findByFrutter", query = "SELECT q FROM QaSample q WHERE q.frutter = :frutter"),
    @NamedQuery(name = "QaSample.findByAcBeltCut", query = "SELECT q FROM QaSample q WHERE q.acBeltCut = :acBeltCut"),
    @NamedQuery(name = "QaSample.findByFieldtestno", query = "SELECT q FROM QaSample q WHERE q.fieldtestno = :fieldtestno"),
    @NamedQuery(name = "QaSample.findByNbcansubmtClab", query = "SELECT q FROM QaSample q WHERE q.nbcansubmtClab = :nbcansubmtClab"),
    @NamedQuery(name = "QaSample.findByNbcansubmtRlab", query = "SELECT q FROM QaSample q WHERE q.nbcansubmtRlab = :nbcansubmtRlab"),
    @NamedQuery(name = "QaSample.findByForm43No", query = "SELECT q FROM QaSample q WHERE q.form43No = :form43No"),
    @NamedQuery(name = "QaSample.findByFieldriceSpgr", query = "SELECT q FROM QaSample q WHERE q.fieldriceSpgr = :fieldriceSpgr"),
    @NamedQuery(name = "QaSample.findByCollectionDateTmp", query = "SELECT q FROM QaSample q WHERE q.collectionDateTmp = :collectionDateTmp"),
    @NamedQuery(name = "QaSample.findByReceivedDateTmp", query = "SELECT q FROM QaSample q WHERE q.receivedDateTmp = :receivedDateTmp"),
    @NamedQuery(name = "QaSample.findByDueDateTmp", query = "SELECT q FROM QaSample q WHERE q.dueDateTmp = :dueDateTmp"),
    @NamedQuery(name = "QaSample.findByCompletedDateTmp", query = "SELECT q FROM QaSample q WHERE q.completedDateTmp = :completedDateTmp"),
    @NamedQuery(name = "QaSample.findByApprovalDateTmp", query = "SELECT q FROM QaSample q WHERE q.approvalDateTmp = :approvalDateTmp"),
    @NamedQuery(name = "QaSample.findByLastModTmp", query = "SELECT q FROM QaSample q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QaSample.findByTempTmp", query = "SELECT q FROM QaSample q WHERE q.tempTmp = :tempTmp"),
    @NamedQuery(name = "QaSample.findByCreateDateTmp", query = "SELECT q FROM QaSample q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QaSample.findByShipDateTmp", query = "SELECT q FROM QaSample q WHERE q.shipDateTmp = :shipDateTmp"),
    @NamedQuery(name = "QaSample.findByForm43DateTmp", query = "SELECT q FROM QaSample q WHERE q.form43DateTmp = :form43DateTmp"),
    @NamedQuery(name = "QaSample.findByCollectionDate", query = "SELECT q FROM QaSample q WHERE q.collectionDate = :collectionDate"),
    @NamedQuery(name = "QaSample.findByReceivedDate", query = "SELECT q FROM QaSample q WHERE q.receivedDate = :receivedDate"),
    @NamedQuery(name = "QaSample.findByDueDate", query = "SELECT q FROM QaSample q WHERE q.dueDate = :dueDate"),
    @NamedQuery(name = "QaSample.findByCompletedDate", query = "SELECT q FROM QaSample q WHERE q.completedDate = :completedDate"),
    @NamedQuery(name = "QaSample.findByApprovalDate", query = "SELECT q FROM QaSample q WHERE q.approvalDate = :approvalDate"),
    @NamedQuery(name = "QaSample.findByLastMod", query = "SELECT q FROM QaSample q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSample.findByTemp", query = "SELECT q FROM QaSample q WHERE q.temp = :temp"),
    @NamedQuery(name = "QaSample.findByCreateDate", query = "SELECT q FROM QaSample q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSample.findByShipDate", query = "SELECT q FROM QaSample q WHERE q.shipDate = :shipDate"),
    @NamedQuery(name = "QaSample.findByForm43Date", query = "SELECT q FROM QaSample q WHERE q.form43Date = :form43Date"),
    @NamedQuery(name = "QaSample.findByMatId", query = "SELECT q FROM QaSample q WHERE q.matId = :matId"),
    @NamedQuery(name = "QaSample.findByTmpItem", query = "SELECT q FROM QaSample q WHERE q.tmpItem = :tmpItem"),
    @NamedQuery(name = "QaSample.findByTmpClass", query = "SELECT q FROM QaSample q WHERE q.tmpClass = :tmpClass"),
    @NamedQuery(name = "QaSample.findByActivityNumber", query = "SELECT q FROM QaSample q WHERE q.activityNumber = :activityNumber"),
    @NamedQuery(name = "QaSample.findByInspector", query = "SELECT q FROM QaSample q WHERE q.inspector = :inspector"),
    @NamedQuery(name = "QaSample.findByNbcans", query = "SELECT q FROM QaSample q WHERE q.nbcans = :nbcans"),
    @NamedQuery(name = "QaSample.findByViaClab", query = "SELECT q FROM QaSample q WHERE q.viaClab = :viaClab"),
    @NamedQuery(name = "QaSample.findByShipDateClab", query = "SELECT q FROM QaSample q WHERE q.shipDateClab = :shipDateClab"),
    @NamedQuery(name = "QaSample.findByDepth", query = "SELECT q FROM QaSample q WHERE q.depth = :depth"),
    @NamedQuery(name = "QaSample.findByActivityName", query = "SELECT q FROM QaSample q WHERE q.activityName = :activityName"),
    @NamedQuery(name = "QaSample.findBySampledById", query = "SELECT q FROM QaSample q WHERE q.sampledById = :sampledById"),
    @NamedQuery(name = "QaSample.findBySupervisorId", query = "SELECT q FROM QaSample q WHERE q.supervisorId = :supervisorId"),
    @NamedQuery(name = "QaSample.findByUomId", query = "SELECT q FROM QaSample q WHERE q.uomId = :uomId"),
    @NamedQuery(name = "QaSample.findBySoilDensityCtrlNumber", query = "SELECT q FROM QaSample q WHERE q.soilDensityCtrlNumber = :soilDensityCtrlNumber"),
    @NamedQuery(name = "QaSample.findByRvalue", query = "SELECT q FROM QaSample q WHERE q.rvalue = :rvalue"),
    @NamedQuery(name = "QaSample.findBySoilClassificationId", query = "SELECT q FROM QaSample q WHERE q.soilClassificationId = :soilClassificationId"),
    @NamedQuery(name = "QaSample.findByShippedByRlabId", query = "SELECT q FROM QaSample q WHERE q.shippedByRlabId = :shippedByRlabId"),
    @NamedQuery(name = "QaSample.findByShippedByClabId", query = "SELECT q FROM QaSample q WHERE q.shippedByClabId = :shippedByClabId"),
    @NamedQuery(name = "QaSample.findByMixDesignId", query = "SELECT q FROM QaSample q WHERE q.mixDesignId = :mixDesignId"),
    @NamedQuery(name = "QaSample.findByAsphaltcement", query = "SELECT q FROM QaSample q WHERE q.asphaltcement = :asphaltcement"),
    @NamedQuery(name = "QaSample.findByRegionId", query = "SELECT q FROM QaSample q WHERE q.regionId = :regionId"),
    @NamedQuery(name = "QaSample.findByAdditive", query = "SELECT q FROM QaSample q WHERE q.additive = :additive"),
    @NamedQuery(name = "QaSample.findByContractName", query = "SELECT q FROM QaSample q WHERE q.contractName = :contractName"),
    @NamedQuery(name = "QaSample.findByMaterialSource", query = "SELECT q FROM QaSample q WHERE q.materialSource = :materialSource"),
    @NamedQuery(name = "QaSample.findByMaterialDescription", query = "SELECT q FROM QaSample q WHERE q.materialDescription = :materialDescription"),
    @NamedQuery(name = "QaSample.findByFieldTestNumber", query = "SELECT q FROM QaSample q WHERE q.fieldTestNumber = :fieldTestNumber"),
    @NamedQuery(name = "QaSample.findBySoilClassification", query = "SELECT q FROM QaSample q WHERE q.soilClassification = :soilClassification"),
    @NamedQuery(name = "QaSample.findByContractor", query = "SELECT q FROM QaSample q WHERE q.contractor = :contractor"),
    @NamedQuery(name = "QaSample.findBySupplier", query = "SELECT q FROM QaSample q WHERE q.supplier = :supplier"),
    @NamedQuery(name = "QaSample.findBySplitSampleNumber", query = "SELECT q FROM QaSample q WHERE q.splitSampleNumber = :splitSampleNumber"),
    @NamedQuery(name = "QaSample.findBySplitSample", query = "SELECT q FROM QaSample q WHERE q.splitSample = :splitSample"),
    @NamedQuery(name = "QaSample.findBySampledByTitle", query = "SELECT q FROM QaSample q WHERE q.sampledByTitle = :sampledByTitle"),
    @NamedQuery(name = "QaSample.findByMatDensityCtrlNumber", query = "SELECT q FROM QaSample q WHERE q.matDensityCtrlNumber = :matDensityCtrlNumber"),
    @NamedQuery(name = "QaSample.findByMatDensityFieldTestNumber", query = "SELECT q FROM QaSample q WHERE q.matDensityFieldTestNumber = :matDensityFieldTestNumber"),
    @NamedQuery(name = "QaSample.findBySampledFrom", query = "SELECT q FROM QaSample q WHERE q.sampledFrom = :sampledFrom"),
    @NamedQuery(name = "QaSample.findByGroupSymbol", query = "SELECT q FROM QaSample q WHERE q.groupSymbol = :groupSymbol"),
    @NamedQuery(name = "QaSample.findByContractorMixDesign", query = "SELECT q FROM QaSample q WHERE q.contractorMixDesign = :contractorMixDesign"),
    @NamedQuery(name = "QaSample.findByF28", query = "SELECT q FROM QaSample q WHERE q.f28 = :f28"),
    @NamedQuery(name = "QaSample.findByF7", query = "SELECT q FROM QaSample q WHERE q.f7 = :f7"),
    @NamedQuery(name = "QaSample.findBySuperintendentId", query = "SELECT q FROM QaSample q WHERE q.superintendentId = :superintendentId"),
    @NamedQuery(name = "QaSample.findByForemanId", query = "SELECT q FROM QaSample q WHERE q.foremanId = :foremanId"),
    @NamedQuery(name = "QaSample.findByBidItemNumber", query = "SELECT q FROM QaSample q WHERE q.bidItemNumber = :bidItemNumber"),
    @NamedQuery(name = "QaSample.findByApplicationId", query = "SELECT q FROM QaSample q WHERE q.applicationId = :applicationId"),
    @NamedQuery(name = "QaSample.findByDbSection", query = "SELECT q FROM QaSample q WHERE q.dbSection = :dbSection"),
    @NamedQuery(name = "QaSample.findByDesignMethod", query = "SELECT q FROM QaSample q WHERE q.designMethod = :designMethod"),
    @NamedQuery(name = "QaSample.findBySampleReferenceNo", query = "SELECT q FROM QaSample q WHERE q.sampleReferenceNo = :sampleReferenceNo"),
    @NamedQuery(name = "QaSample.findBySampleReportNo", query = "SELECT q FROM QaSample q WHERE q.sampleReportNo = :sampleReportNo"),
    @NamedQuery(name = "QaSample.findByOffset", query = "SELECT q FROM QaSample q WHERE q.offset = :offset"),
    @NamedQuery(name = "QaSample.findByElevation", query = "SELECT q FROM QaSample q WHERE q.elevation = :elevation"),
    @NamedQuery(name = "QaSample.findBySampleType", query = "SELECT q FROM QaSample q WHERE q.sampleType = :sampleType"),
    @NamedQuery(name = "QaSample.findByLatGps", query = "SELECT q FROM QaSample q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QaSample.findByLonGps", query = "SELECT q FROM QaSample q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QaSample.findByAltGps", query = "SELECT q FROM QaSample q WHERE q.altGps = :altGps"),
    @NamedQuery(name = "QaSample.findBySampleType2", query = "SELECT q FROM QaSample q WHERE q.sampleType2 = :sampleType2"),
    @NamedQuery(name = "QaSample.findByStructureNo", query = "SELECT q FROM QaSample q WHERE q.structureNo = :structureNo"),
    @NamedQuery(name = "QaSample.findByTraceNo", query = "SELECT q FROM QaSample q WHERE q.traceNo = :traceNo"),
    @NamedQuery(name = "QaSample.findByReportType", query = "SELECT q FROM QaSample q WHERE q.reportType = :reportType"),
    @NamedQuery(name = "QaSample.findBySection", query = "SELECT q FROM QaSample q WHERE q.section = :section"),
    @NamedQuery(name = "QaSample.findByDirection", query = "SELECT q FROM QaSample q WHERE q.direction = :direction"),
    @NamedQuery(name = "QaSample.findByRoadway", query = "SELECT q FROM QaSample q WHERE q.roadway = :roadway"),
    @NamedQuery(name = "QaSample.findByCurrentJmfNo", query = "SELECT q FROM QaSample q WHERE q.currentJmfNo = :currentJmfNo"),
    @NamedQuery(name = "QaSample.findByHasRoadwayRice", query = "SELECT q FROM QaSample q WHERE q.hasRoadwayRice = :hasRoadwayRice"),
    @NamedQuery(name = "QaSample.findByPlantNo", query = "SELECT q FROM QaSample q WHERE q.plantNo = :plantNo"),
    @NamedQuery(name = "QaSample.findByMixType", query = "SELECT q FROM QaSample q WHERE q.mixType = :mixType"),
    @NamedQuery(name = "QaSample.findByLevelName", query = "SELECT q FROM QaSample q WHERE q.levelName = :levelName"),
    @NamedQuery(name = "QaSample.findByBlend", query = "SELECT q FROM QaSample q WHERE q.blend = :blend"),
    @NamedQuery(name = "QaSample.findByTypeCourse", query = "SELECT q FROM QaSample q WHERE q.typeCourse = :typeCourse"),
    @NamedQuery(name = "QaSample.findByAcSource", query = "SELECT q FROM QaSample q WHERE q.acSource = :acSource"),
    @NamedQuery(name = "QaSample.findByCorrectedCopy", query = "SELECT q FROM QaSample q WHERE q.correctedCopy = :correctedCopy"),
    @NamedQuery(name = "QaSample.findByCompletedCopy", query = "SELECT q FROM QaSample q WHERE q.completedCopy = :completedCopy"),
    @NamedQuery(name = "QaSample.findByHydLime", query = "SELECT q FROM QaSample q WHERE q.hydLime = :hydLime"),
    @NamedQuery(name = "QaSample.findByVoidSpec", query = "SELECT q FROM QaSample q WHERE q.voidSpec = :voidSpec"),
    @NamedQuery(name = "QaSample.findByMaxPracAirVoid", query = "SELECT q FROM QaSample q WHERE q.maxPracAirVoid = :maxPracAirVoid"),
    @NamedQuery(name = "QaSample.findBySpecimenLength", query = "SELECT q FROM QaSample q WHERE q.specimenLength = :specimenLength"),
    @NamedQuery(name = "QaSample.findBySampleNoSeq", query = "SELECT q FROM QaSample q WHERE q.sampleNoSeq = :sampleNoSeq"),
    @NamedQuery(name = "QaSample.findByMaterialLocation", query = "SELECT q FROM QaSample q WHERE q.materialLocation = :materialLocation"),
    @NamedQuery(name = "QaSample.findByReceivedLocation", query = "SELECT q FROM QaSample q WHERE q.receivedLocation = :receivedLocation"),
    @NamedQuery(name = "QaSample.findByReceivedCity", query = "SELECT q FROM QaSample q WHERE q.receivedCity = :receivedCity"),
    @NamedQuery(name = "QaSample.findByWeather", query = "SELECT q FROM QaSample q WHERE q.weather = :weather"),
    @NamedQuery(name = "QaSample.findByMaterialComments", query = "SELECT q FROM QaSample q WHERE q.materialComments = :materialComments"),
    @NamedQuery(name = "QaSample.findByNoSpecimens", query = "SELECT q FROM QaSample q WHERE q.noSpecimens = :noSpecimens"),
    @NamedQuery(name = "QaSample.findByNoAssets", query = "SELECT q FROM QaSample q WHERE q.noAssets = :noAssets")
 */
/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QA_SAMPLE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_SAMPLE SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSample.findAll", query = "SELECT q FROM QaSample q"),
    @NamedQuery(name = "QaSample.findById", query = "SELECT q FROM QaSample q WHERE q.id = :id")})
public class QaSample implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_SAMPLE_ID_SEQ", sequenceName = "QA_SAMPLE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_SAMPLE_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "SAMPLE_CATG_ID")
    private String sampleCatgId;
    @Size(max = 50)
    @Column(name = "SEGMENT_ID")
    private String segmentId;
    @Size(max = 255)
    @Column(name = "STATION")
    private String station;
    @Size(max = 50)
    @Column(name = "LOT")
    private String lot;
    @Size(max = 10)
    @Column(name = "SUBLOT")
    private String sublot;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 50)
    @Column(name = "LONGT")
    private String longt;
    @Size(max = 50)
    @Column(name = "LAT")
    private String lat;
    @Column(name = "WO_NO")
    private BigInteger woNo;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "RETEST")
    private Character retest;
    @Size(max = 512)
    @Column(name = "FIELDUSR")
    private String fieldusr;
    @Size(max = 50)
    @Column(name = "PDA_ID")
    private String pdaId;
    @Size(max = 50)
    @Column(name = "CROSSREF_SAMPLES")
    private String crossrefSamples;
    @Size(max = 50)
    @Column(name = "COLLECTION_TIME")
    private String collectionTime;
    @Size(max = 50)
    @Column(name = "RECEIVED_BY")
    private String receivedBy;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "APPROVAL_SIG")
    private String approvalSig;
    @Size(max = 255)
    @Column(name = "REJECT_REASON")
    private String rejectReason;
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
    @Size(max = 4000)
    @Column(name = "REPORT_NO")
    private String reportNo;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "CLASS_ID")
    private BigInteger classId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Size(max = 200)
    @Column(name = "PITNAME")
    private String pitname;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "CTYPE_ID")
    private BigInteger ctypeId;
    @Size(max = 255)
    @Column(name = "PREV_USED")
    private String prevUsed;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 20)
    @Column(name = "SPEC_PROV")
    private String specProv;
    @Size(max = 20)
    @Column(name = "SAMPLE_SUBMT")
    private String sampleSubmt;
    @Column(name = "SOURCE_ID")
    private BigInteger sourceId;
    @Size(max = 200)
    @Column(name = "SHIP_TO")
    private String shipTo;
    @Size(max = 20)
    @Column(name = "VIA")
    private String via;
    @Size(max = 50)
    @Column(name = "QTY_UNIT")
    private String qtyUnit;
    @Size(max = 20)
    @Column(name = "QTY_REP")
    private String qtyRep;
    @Size(max = 20)
    @Column(name = "QTY_PREV")
    private String qtyPrev;
    @Size(max = 20)
    @Column(name = "QTY_TOTAL")
    private String qtyTotal;
    @Size(max = 20)
    @Column(name = "METRIC_UNIT")
    private String metricUnit;
    @Size(max = 50)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Size(max = 50)
    @Column(name = "SUPERVISOR_TITLE")
    private String supervisorTitle;
    @Size(max = 200)
    @Column(name = "SUPERVISOR_ADDRESS")
    private String supervisorAddress;
    @Size(max = 50)
    @Column(name = "FIELDUSR_TITLE")
    private String fieldusrTitle;
    @Size(max = 50)
    @Column(name = "LAB_PHONE")
    private String labPhone;
    @Size(max = 20)
    @Column(name = "GYRATION")
    private String gyration;
    @Size(max = 20)
    @Column(name = "BINDER")
    private String binder;
    @Size(max = 100)
    @Column(name = "GRADING")
    private String grading;
    @Size(max = 20)
    @Column(name = "HRUTTER")
    private String hrutter;
    @Size(max = 20)
    @Column(name = "FRUTTER")
    private String frutter;
    @Size(max = 20)
    @Column(name = "AC_BELT_CUT")
    private String acBeltCut;
    @Size(max = 50)
    @Column(name = "FIELDTESTNO")
    private String fieldtestno;
    @Size(max = 50)
    @Column(name = "NBCANSUBMT_CLAB")
    private String nbcansubmtClab;
    @Size(max = 50)
    @Column(name = "NBCANSUBMT_RLAB")
    private String nbcansubmtRlab;
    @Size(max = 50)
    @Column(name = "FORM43_NO")
    private String form43No;
    @Size(max = 50)
    @Column(name = "FIELDRICE_SPGR")
    private String fieldriceSpgr;
    @Size(max = 4000)
    @Column(name = "COLLECTION_DATE_TMP")
    private String collectionDateTmp;
    @Size(max = 4000)
    @Column(name = "RECEIVED_DATE_TMP")
    private String receivedDateTmp;
    @Size(max = 4000)
    @Column(name = "DUE_DATE_TMP")
    private String dueDateTmp;
    @Size(max = 4000)
    @Column(name = "COMPLETED_DATE_TMP")
    private String completedDateTmp;
    @Size(max = 4000)
    @Column(name = "APPROVAL_DATE_TMP")
    private String approvalDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "SHIP_DATE_TMP")
    private String shipDateTmp;
    @Size(max = 4000)
    @Column(name = "FORM43_DATE_TMP")
    private String form43DateTmp;
    @Column(name = "COLLECTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date collectionDate;
    @Column(name = "RECEIVED_DATE")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "COMPLETED_DATE")
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    @Column(name = "APPROVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "TEMP")
    @Temporal(TemporalType.DATE)
    private Date temp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Column(name = "SHIP_DATE")
    @Temporal(TemporalType.DATE)
    private Date shipDate;
    @Column(name = "FORM43_DATE")
    @Temporal(TemporalType.DATE)
    private Date form43Date;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "TMP_ITEM")
    private BigInteger tmpItem;
    @Column(name = "TMP_CLASS")
    private BigInteger tmpClass;
    @Size(max = 50)
    @Column(name = "ACTIVITY_NUMBER")
    private String activityNumber;
    @Size(max = 50)
    @Column(name = "INSPECTOR")
    private String inspector;
    @Size(max = 50)
    @Column(name = "NBCANS")
    private String nbcans;
    @Size(max = 20)
    @Column(name = "VIA_CLAB")
    private String viaClab;
    @Column(name = "SHIP_DATE_CLAB")
    @Temporal(TemporalType.DATE)
    private Date shipDateClab;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 255)
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
    @Column(name = "SAMPLED_BY_ID")
    private BigInteger sampledById;
    @Column(name = "SUPERVISOR_ID")
    private BigInteger supervisorId;
    @Column(name = "UOM_ID")
    private BigInteger uomId;
    @Size(max = 50)
    @Column(name = "SOIL_DENSITY_CTRL_NUMBER")
    private String soilDensityCtrlNumber;
    @Size(max = 50)
    @Column(name = "RVALUE")
    private String rvalue;
    @Column(name = "SOIL_CLASSIFICATION_ID")
    private BigInteger soilClassificationId;
    @Column(name = "SHIPPED_BY_RLAB_ID")
    private BigInteger shippedByRlabId;
    @Column(name = "SHIPPED_BY_CLAB_ID")
    private BigInteger shippedByClabId;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Size(max = 20)
    @Column(name = "ASPHALTCEMENT")
    private String asphaltcement;
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Size(max = 80)
    @Column(name = "ADDITIVE")
    private String additive;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Size(max = 100)
    @Column(name = "MATERIAL_SOURCE")
    private String materialSource;
    @Size(max = 200)
    @Column(name = "MATERIAL_DESCRIPTION")
    private String materialDescription;
    @Size(max = 50)
    @Column(name = "FIELD_TEST_NUMBER")
    private String fieldTestNumber;
    @Size(max = 50)
    @Column(name = "SOIL_CLASSIFICATION")
    private String soilClassification;
    @Size(max = 50)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 50)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Size(max = 50)
    @Column(name = "SPLIT_SAMPLE_NUMBER")
    private String splitSampleNumber;
    @Size(max = 1)
    @Column(name = "SPLIT_SAMPLE")
    private String splitSample;
    @Size(max = 50)
    @Column(name = "SAMPLED_BY_TITLE")
    private String sampledByTitle;
    @Size(max = 50)
    @Column(name = "MAT_DENSITY_CTRL_NUMBER")
    private String matDensityCtrlNumber;
    @Size(max = 50)
    @Column(name = "MAT_DENSITY_FIELD_TEST_NUMBER")
    private String matDensityFieldTestNumber;
    @Size(max = 50)
    @Column(name = "SAMPLED_FROM")
    private String sampledFrom;
    @Size(max = 50)
    @Column(name = "GROUP_SYMBOL")
    private String groupSymbol;
    @Size(max = 100)
    @Column(name = "CONTRACTOR_MIX_DESIGN")
    private String contractorMixDesign;
    @Column(name = "F_28")
    private BigInteger f28;
    @Column(name = "F_7")
    private BigInteger f7;
    @Column(name = "SUPERINTENDENT_ID")
    private BigInteger superintendentId;
    @Column(name = "FOREMAN_ID")
    private BigInteger foremanId;
    @Size(max = 255)
    @Column(name = "BID_ITEM_NUMBER")
    private String bidItemNumber;
    @Column(name = "APPLICATION_ID")
    private BigInteger applicationId;
    @Size(max = 255)
    @Column(name = "DB_SECTION")
    private String dbSection;
    @Size(max = 50)
    @Column(name = "DESIGN_METHOD")
    private String designMethod;
    @Size(max = 50)
    @Column(name = "SAMPLE_REFERENCE_NO")
    private String sampleReferenceNo;
    @Size(max = 50)
    @Column(name = "SAMPLE_REPORT_NO")
    private String sampleReportNo;
    @Size(max = 50)
    @Column(name = "OFFSET")
    private String offset;
    @Size(max = 50)
    @Column(name = "ELEVATION")
    private String elevation;
    @Size(max = 50)
    @Column(name = "SAMPLE_TYPE")
    private String sampleType;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 50)
    @Column(name = "SAMPLE_TYPE2")
    private String sampleType2;
    @Size(max = 50)
    @Column(name = "STRUCTURE_NO")
    private String structureNo;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Size(max = 255)
    @Column(name = "SECTION")
    private String section;
    @Size(max = 255)
    @Column(name = "DIRECTION")
    private String direction;
    @Size(max = 255)
    @Column(name = "ROADWAY")
    private String roadway;
    @Column(name = "CURRENT_JMF_NO")
    private BigInteger currentJmfNo;
    @Column(name = "HAS_ROADWAY_RICE")
    private Character hasRoadwayRice;
    @Size(max = 50)
    @Column(name = "PLANT_NO")
    private String plantNo;
    @Size(max = 50)
    @Column(name = "MIX_TYPE")
    private String mixType;
    @Size(max = 50)
    @Column(name = "LEVEL_NAME")
    private String levelName;
    @Size(max = 50)
    @Column(name = "BLEND")
    private String blend;
    @Size(max = 50)
    @Column(name = "TYPE_COURSE")
    private String typeCourse;
    @Size(max = 50)
    @Column(name = "AC_SOURCE")
    private String acSource;
    @Column(name = "CORRECTED_COPY")
    private Character correctedCopy;
    @Column(name = "COMPLETED_COPY")
    private Character completedCopy;
    @Column(name = "HYD_LIME")
    private Character hydLime;
    @Column(name = "VOID_SPEC")
    private Character voidSpec;
    @Size(max = 50)
    @Column(name = "MAX_PRAC_AIR_VOID")
    private String maxPracAirVoid;
    @Size(max = 50)
    @Column(name = "SPECIMEN_LENGTH")
    private String specimenLength;
    @Column(name = "SAMPLE_NO_SEQ")
    private BigInteger sampleNoSeq;
    @Size(max = 50)
    @Column(name = "MATERIAL_LOCATION")
    private String materialLocation;
    @Size(max = 50)
    @Column(name = "RECEIVED_LOCATION")
    private String receivedLocation;
    @Size(max = 50)
    @Column(name = "RECEIVED_CITY")
    private String receivedCity;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 50)
    @Column(name = "MATERIAL_COMMENTS")
    private String materialComments;
    @Size(max = 50)
    @Column(name = "NO_SPECIMENS")
    private String noSpecimens;
    @Size(max = 50)
    @Column(name = "NO_ASSETS")
    private String noAssets;
    @Column(name = "SUMMARY_REPORT_FILE_ID")
    private BigInteger summaryReportFileId;
    @Size(max = 20)
    @Column(name = "SAMPLING_METHOD_ID")
    private String samplingMethodId;
    @Size(max = 50)
    @Column(name = "SOURCE_VALUE")
    private String sourceValue;
    @Size(max = 50)
    @Column(name = "COMB_AGG_GSB")
    private String combAggGsb;
    @Size(max = 50)
    @Column(name = "BINDER_LOT")
    private String binderLot;
    @Size(max = 50)
    @Column(name = "PAVED_BY")
    private String pavedBy;
    @Size(max = 50)
    @Column(name = "TARGET_CORE_THICKNESS")
    private String targetCoreThickness;
    @Size(max = 50)
    @Column(name = "LAB_COMP_TEMP")
    private String labCompTemp;
    @Size(max = 50)
    @Column(name = "AGG_CORR_FACTOR")
    private String aggCorrFactor;
    @Size(max = 50)
    @Column(name = "GYRATION_WT")
    private String gyrationWt;
    @Size(max = 50)
    @Column(name = "NMAS")
    private String nmas;
    @Size(max = 50)
    @Column(name = "EMULSION_TYPE")
    private String emulsionType;
    @Column(name = "BINDER_SUPPLIER_ID")
    private BigInteger binderSupplierId;
    @Size(max = 50)
    @Column(name = "BINDER_LOCATION")
    private String binderLocation;
    @Column(name = "CEMENT_PRODUCER")
    private BigInteger cementProducer;
    @Column(name = "FINE_AGG_PRODUCER")
    private BigInteger fineAggProducer;
    @Column(name = "COARSE_AGG_PRODUCER")
    private BigInteger coarseAggProducer;
    @Size(max = 50)
    @Column(name = "MILL_CERT_INCLUDED")
    private String millCertIncluded;
    @Size(max = 255)
    @Column(name = "MILL_CERT_NO")
    private String millCertNo;
    @Size(max = 50)
    @Column(name = "POZZOLAN_TYPE")
    private String pozzolanType;
    @Size(max = 30)
    @Column(name = "CURING_BOX_ON_SITE_CONDITION")
    private String curingBoxOnSiteCondition;
    @Column(name = "MIX_DESIGN_ON_SITE")
    private Character mixDesignOnSite;
    @Size(max = 25)
    @Column(name = "CREATE_YEAR")
    private String createYear;
    @Size(max = 50)
    @Column(name = "RANDOM_SAMPLE")
    private String randomSample;

    public QaSample() {
    }

    public QaSample(BigDecimal id) {
        this.id = id;
    }

    public QaSample(BigDecimal id, String sampleNo, BigInteger infoId) {
        this.id = id;
        this.sampleNo = sampleNo;
        this.infoId = infoId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getSampleCatgId() {
        return sampleCatgId;
    }

    public void setSampleCatgId(String sampleCatgId) {
        this.sampleCatgId = sampleCatgId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public BigInteger getWoNo() {
        return woNo;
    }

    public void setWoNo(BigInteger woNo) {
        this.woNo = woNo;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getRetest() {
        return retest;
    }

    public void setRetest(Character retest) {
        this.retest = retest;
    }

    public String getFieldusr() {
        return fieldusr;
    }

    public void setFieldusr(String fieldusr) {
        this.fieldusr = fieldusr;
    }

    public String getPdaId() {
        return pdaId;
    }

    public void setPdaId(String pdaId) {
        this.pdaId = pdaId;
    }

    public String getCrossrefSamples() {
        return crossrefSamples;
    }

    public void setCrossrefSamples(String crossrefSamples) {
        this.crossrefSamples = crossrefSamples;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApprovalSig() {
        return approvalSig;
    }

    public void setApprovalSig(String approvalSig) {
        this.approvalSig = approvalSig;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
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

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getPitname() {
        return pitname;
    }

    public void setPitname(String pitname) {
        this.pitname = pitname;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public BigInteger getContractorId() {
        return contractorId;
    }

    public void setContractorId(BigInteger contractorId) {
        this.contractorId = contractorId;
    }

    public BigInteger getCtypeId() {
        return ctypeId;
    }

    public void setCtypeId(BigInteger ctypeId) {
        this.ctypeId = ctypeId;
    }

    public String getPrevUsed() {
        return prevUsed;
    }

    public void setPrevUsed(String prevUsed) {
        this.prevUsed = prevUsed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSpecProv() {
        return specProv;
    }

    public void setSpecProv(String specProv) {
        this.specProv = specProv;
    }

    public String getSampleSubmt() {
        return sampleSubmt;
    }

    public void setSampleSubmt(String sampleSubmt) {
        this.sampleSubmt = sampleSubmt;
    }

    public BigInteger getSourceId() {
        return sourceId;
    }

    public void setSourceId(BigInteger sourceId) {
        this.sourceId = sourceId;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getQtyUnit() {
        return qtyUnit;
    }

    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit;
    }

    public String getQtyRep() {
        return qtyRep;
    }

    public void setQtyRep(String qtyRep) {
        this.qtyRep = qtyRep;
    }

    public String getQtyPrev() {
        return qtyPrev;
    }

    public void setQtyPrev(String qtyPrev) {
        this.qtyPrev = qtyPrev;
    }

    public String getQtyTotal() {
        return qtyTotal;
    }

    public void setQtyTotal(String qtyTotal) {
        this.qtyTotal = qtyTotal;
    }

    public String getMetricUnit() {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit) {
        this.metricUnit = metricUnit;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisorTitle() {
        return supervisorTitle;
    }

    public void setSupervisorTitle(String supervisorTitle) {
        this.supervisorTitle = supervisorTitle;
    }

    public String getSupervisorAddress() {
        return supervisorAddress;
    }

    public void setSupervisorAddress(String supervisorAddress) {
        this.supervisorAddress = supervisorAddress;
    }

    public String getFieldusrTitle() {
        return fieldusrTitle;
    }

    public void setFieldusrTitle(String fieldusrTitle) {
        this.fieldusrTitle = fieldusrTitle;
    }

    public String getLabPhone() {
        return labPhone;
    }

    public void setLabPhone(String labPhone) {
        this.labPhone = labPhone;
    }

    public String getGyration() {
        return gyration;
    }

    public void setGyration(String gyration) {
        this.gyration = gyration;
    }

    public String getBinder() {
        return binder;
    }

    public void setBinder(String binder) {
        this.binder = binder;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getHrutter() {
        return hrutter;
    }

    public void setHrutter(String hrutter) {
        this.hrutter = hrutter;
    }

    public String getFrutter() {
        return frutter;
    }

    public void setFrutter(String frutter) {
        this.frutter = frutter;
    }

    public String getAcBeltCut() {
        return acBeltCut;
    }

    public void setAcBeltCut(String acBeltCut) {
        this.acBeltCut = acBeltCut;
    }

    public String getFieldtestno() {
        return fieldtestno;
    }

    public void setFieldtestno(String fieldtestno) {
        this.fieldtestno = fieldtestno;
    }

    public String getNbcansubmtClab() {
        return nbcansubmtClab;
    }

    public void setNbcansubmtClab(String nbcansubmtClab) {
        this.nbcansubmtClab = nbcansubmtClab;
    }

    public String getNbcansubmtRlab() {
        return nbcansubmtRlab;
    }

    public void setNbcansubmtRlab(String nbcansubmtRlab) {
        this.nbcansubmtRlab = nbcansubmtRlab;
    }

    public String getForm43No() {
        return form43No;
    }

    public void setForm43No(String form43No) {
        this.form43No = form43No;
    }

    public String getFieldriceSpgr() {
        return fieldriceSpgr;
    }

    public void setFieldriceSpgr(String fieldriceSpgr) {
        this.fieldriceSpgr = fieldriceSpgr;
    }

    public String getCollectionDateTmp() {
        return collectionDateTmp;
    }

    public void setCollectionDateTmp(String collectionDateTmp) {
        this.collectionDateTmp = collectionDateTmp;
    }

    public String getReceivedDateTmp() {
        return receivedDateTmp;
    }

    public void setReceivedDateTmp(String receivedDateTmp) {
        this.receivedDateTmp = receivedDateTmp;
    }

    public String getDueDateTmp() {
        return dueDateTmp;
    }

    public void setDueDateTmp(String dueDateTmp) {
        this.dueDateTmp = dueDateTmp;
    }

    public String getCompletedDateTmp() {
        return completedDateTmp;
    }

    public void setCompletedDateTmp(String completedDateTmp) {
        this.completedDateTmp = completedDateTmp;
    }

    public String getApprovalDateTmp() {
        return approvalDateTmp;
    }

    public void setApprovalDateTmp(String approvalDateTmp) {
        this.approvalDateTmp = approvalDateTmp;
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

    public String getShipDateTmp() {
        return shipDateTmp;
    }

    public void setShipDateTmp(String shipDateTmp) {
        this.shipDateTmp = shipDateTmp;
    }

    public String getForm43DateTmp() {
        return form43DateTmp;
    }

    public void setForm43DateTmp(String form43DateTmp) {
        this.form43DateTmp = form43DateTmp;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

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

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getForm43Date() {
        return form43Date;
    }

    public void setForm43Date(Date form43Date) {
        this.form43Date = form43Date;
    }

    public BigInteger getMatId() {
        return matId;
    }

    public void setMatId(BigInteger matId) {
        this.matId = matId;
    }

    public BigInteger getTmpItem() {
        return tmpItem;
    }

    public void setTmpItem(BigInteger tmpItem) {
        this.tmpItem = tmpItem;
    }

    public BigInteger getTmpClass() {
        return tmpClass;
    }

    public void setTmpClass(BigInteger tmpClass) {
        this.tmpClass = tmpClass;
    }

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getNbcans() {
        return nbcans;
    }

    public void setNbcans(String nbcans) {
        this.nbcans = nbcans;
    }

    public String getViaClab() {
        return viaClab;
    }

    public void setViaClab(String viaClab) {
        this.viaClab = viaClab;
    }

    public Date getShipDateClab() {
        return shipDateClab;
    }

    public void setShipDateClab(Date shipDateClab) {
        this.shipDateClab = shipDateClab;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public BigInteger getSampledById() {
        return sampledById;
    }

    public void setSampledById(BigInteger sampledById) {
        this.sampledById = sampledById;
    }

    public BigInteger getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(BigInteger supervisorId) {
        this.supervisorId = supervisorId;
    }

    public BigInteger getUomId() {
        return uomId;
    }

    public void setUomId(BigInteger uomId) {
        this.uomId = uomId;
    }

    public String getSoilDensityCtrlNumber() {
        return soilDensityCtrlNumber;
    }

    public void setSoilDensityCtrlNumber(String soilDensityCtrlNumber) {
        this.soilDensityCtrlNumber = soilDensityCtrlNumber;
    }

    public String getRvalue() {
        return rvalue;
    }

    public void setRvalue(String rvalue) {
        this.rvalue = rvalue;
    }

    public BigInteger getSoilClassificationId() {
        return soilClassificationId;
    }

    public void setSoilClassificationId(BigInteger soilClassificationId) {
        this.soilClassificationId = soilClassificationId;
    }

    public BigInteger getShippedByRlabId() {
        return shippedByRlabId;
    }

    public void setShippedByRlabId(BigInteger shippedByRlabId) {
        this.shippedByRlabId = shippedByRlabId;
    }

    public BigInteger getShippedByClabId() {
        return shippedByClabId;
    }

    public void setShippedByClabId(BigInteger shippedByClabId) {
        this.shippedByClabId = shippedByClabId;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigInteger mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getAsphaltcement() {
        return asphaltcement;
    }

    public void setAsphaltcement(String asphaltcement) {
        this.asphaltcement = asphaltcement;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getMaterialSource() {
        return materialSource;
    }

    public void setMaterialSource(String materialSource) {
        this.materialSource = materialSource;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getFieldTestNumber() {
        return fieldTestNumber;
    }

    public void setFieldTestNumber(String fieldTestNumber) {
        this.fieldTestNumber = fieldTestNumber;
    }

    public String getSoilClassification() {
        return soilClassification;
    }

    public void setSoilClassification(String soilClassification) {
        this.soilClassification = soilClassification;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSplitSampleNumber() {
        return splitSampleNumber;
    }

    public void setSplitSampleNumber(String splitSampleNumber) {
        this.splitSampleNumber = splitSampleNumber;
    }

    public String getSplitSample() {
        return splitSample;
    }

    public void setSplitSample(String splitSample) {
        this.splitSample = splitSample;
    }

    public String getSampledByTitle() {
        return sampledByTitle;
    }

    public void setSampledByTitle(String sampledByTitle) {
        this.sampledByTitle = sampledByTitle;
    }

    public String getMatDensityCtrlNumber() {
        return matDensityCtrlNumber;
    }

    public void setMatDensityCtrlNumber(String matDensityCtrlNumber) {
        this.matDensityCtrlNumber = matDensityCtrlNumber;
    }

    public String getMatDensityFieldTestNumber() {
        return matDensityFieldTestNumber;
    }

    public void setMatDensityFieldTestNumber(String matDensityFieldTestNumber) {
        this.matDensityFieldTestNumber = matDensityFieldTestNumber;
    }

    public String getSampledFrom() {
        return sampledFrom;
    }

    public void setSampledFrom(String sampledFrom) {
        this.sampledFrom = sampledFrom;
    }

    public String getGroupSymbol() {
        return groupSymbol;
    }

    public void setGroupSymbol(String groupSymbol) {
        this.groupSymbol = groupSymbol;
    }

    public String getContractorMixDesign() {
        return contractorMixDesign;
    }

    public void setContractorMixDesign(String contractorMixDesign) {
        this.contractorMixDesign = contractorMixDesign;
    }

    public BigInteger getF28() {
        return f28;
    }

    public void setF28(BigInteger f28) {
        this.f28 = f28;
    }

    public BigInteger getF7() {
        return f7;
    }

    public void setF7(BigInteger f7) {
        this.f7 = f7;
    }

    public BigInteger getSuperintendentId() {
        return superintendentId;
    }

    public void setSuperintendentId(BigInteger superintendentId) {
        this.superintendentId = superintendentId;
    }

    public BigInteger getForemanId() {
        return foremanId;
    }

    public void setForemanId(BigInteger foremanId) {
        this.foremanId = foremanId;
    }

    public String getBidItemNumber() {
        return bidItemNumber;
    }

    public void setBidItemNumber(String bidItemNumber) {
        this.bidItemNumber = bidItemNumber;
    }

    public BigInteger getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigInteger applicationId) {
        this.applicationId = applicationId;
    }

    public String getDbSection() {
        return dbSection;
    }

    public void setDbSection(String dbSection) {
        this.dbSection = dbSection;
    }

    public String getDesignMethod() {
        return designMethod;
    }

    public void setDesignMethod(String designMethod) {
        this.designMethod = designMethod;
    }

    public String getSampleReferenceNo() {
        return sampleReferenceNo;
    }

    public void setSampleReferenceNo(String sampleReferenceNo) {
        this.sampleReferenceNo = sampleReferenceNo;
    }

    public String getSampleReportNo() {
        return sampleReportNo;
    }

    public void setSampleReportNo(String sampleReportNo) {
        this.sampleReportNo = sampleReportNo;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
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

    public String getSampleType2() {
        return sampleType2;
    }

    public void setSampleType2(String sampleType2) {
        this.sampleType2 = sampleType2;
    }

    public String getStructureNo() {
        return structureNo;
    }

    public void setStructureNo(String structureNo) {
        this.structureNo = structureNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRoadway() {
        return roadway;
    }

    public void setRoadway(String roadway) {
        this.roadway = roadway;
    }

    public BigInteger getCurrentJmfNo() {
        return currentJmfNo;
    }

    public void setCurrentJmfNo(BigInteger currentJmfNo) {
        this.currentJmfNo = currentJmfNo;
    }

    public Character getHasRoadwayRice() {
        return hasRoadwayRice;
    }

    public void setHasRoadwayRice(Character hasRoadwayRice) {
        this.hasRoadwayRice = hasRoadwayRice;
    }

    public String getPlantNo() {
        return plantNo;
    }

    public void setPlantNo(String plantNo) {
        this.plantNo = plantNo;
    }

    public String getMixType() {
        return mixType;
    }

    public void setMixType(String mixType) {
        this.mixType = mixType;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getBlend() {
        return blend;
    }

    public void setBlend(String blend) {
        this.blend = blend;
    }

    public String getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(String typeCourse) {
        this.typeCourse = typeCourse;
    }

    public String getAcSource() {
        return acSource;
    }

    public void setAcSource(String acSource) {
        this.acSource = acSource;
    }

    public Character getCorrectedCopy() {
        return correctedCopy;
    }

    public void setCorrectedCopy(Character correctedCopy) {
        this.correctedCopy = correctedCopy;
    }

    public Character getCompletedCopy() {
        return completedCopy;
    }

    public void setCompletedCopy(Character completedCopy) {
        this.completedCopy = completedCopy;
    }

    public Character getHydLime() {
        return hydLime;
    }

    public void setHydLime(Character hydLime) {
        this.hydLime = hydLime;
    }

    public Character getVoidSpec() {
        return voidSpec;
    }

    public void setVoidSpec(Character voidSpec) {
        this.voidSpec = voidSpec;
    }

    public String getMaxPracAirVoid() {
        return maxPracAirVoid;
    }

    public void setMaxPracAirVoid(String maxPracAirVoid) {
        this.maxPracAirVoid = maxPracAirVoid;
    }

    public String getSpecimenLength() {
        return specimenLength;
    }

    public void setSpecimenLength(String specimenLength) {
        this.specimenLength = specimenLength;
    }

    public BigInteger getSampleNoSeq() {
        return sampleNoSeq;
    }

    public void setSampleNoSeq(BigInteger sampleNoSeq) {
        this.sampleNoSeq = sampleNoSeq;
    }

    public String getMaterialLocation() {
        return materialLocation;
    }

    public void setMaterialLocation(String materialLocation) {
        this.materialLocation = materialLocation;
    }

    public String getReceivedLocation() {
        return receivedLocation;
    }

    public void setReceivedLocation(String receivedLocation) {
        this.receivedLocation = receivedLocation;
    }

    public String getReceivedCity() {
        return receivedCity;
    }

    public void setReceivedCity(String receivedCity) {
        this.receivedCity = receivedCity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMaterialComments() {
        return materialComments;
    }

    public void setMaterialComments(String materialComments) {
        this.materialComments = materialComments;
    }

    public String getNoSpecimens() {
        return noSpecimens;
    }

    public void setNoSpecimens(String noSpecimens) {
        this.noSpecimens = noSpecimens;
    }

    public String getNoAssets() {
        return noAssets;
    }

    public void setNoAssets(String noAssets) {
        this.noAssets = noAssets;
    }

    public BigInteger getSummaryReportFileId() {
        return summaryReportFileId;
    }

    public void setSummaryReportFileId(BigInteger summaryReportFileId) {
        this.summaryReportFileId = summaryReportFileId;
    }

    public String getSamplingMethodId() {
        return samplingMethodId;
    }

    public void setSamplingMethodId(String samplingMethodId) {
        this.samplingMethodId = samplingMethodId;
    }

    public String getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
    }

    public String getCombAggGsb() {
        return combAggGsb;
    }

    public void setCombAggGsb(String combAggGsb) {
        this.combAggGsb = combAggGsb;
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

    public String getLabCompTemp() {
        return labCompTemp;
    }

    public void setLabCompTemp(String labCompTemp) {
        this.labCompTemp = labCompTemp;
    }

    public String getAggCorrFactor() {
        return aggCorrFactor;
    }

    public void setAggCorrFactor(String aggCorrFactor) {
        this.aggCorrFactor = aggCorrFactor;
    }

    public String getGyrationWt() {
        return gyrationWt;
    }

    public void setGyrationWt(String gyrationWt) {
        this.gyrationWt = gyrationWt;
    }

    public String getNmas() {
        return nmas;
    }

    public void setNmas(String nmas) {
        this.nmas = nmas;
    }

    public String getEmulsionType() {
        return emulsionType;
    }

    public void setEmulsionType(String emulsionType) {
        this.emulsionType = emulsionType;
    }

    public BigInteger getBinderSupplierId() {
        return binderSupplierId;
    }

    public void setBinderSupplierId(BigInteger binderSupplierId) {
        this.binderSupplierId = binderSupplierId;
    }

    public String getBinderLocation() {
        return binderLocation;
    }

    public void setBinderLocation(String binderLocation) {
        this.binderLocation = binderLocation;
    }

    public BigInteger getCementProducer() {
        return cementProducer;
    }

    public void setCementProducer(BigInteger cementProducer) {
        this.cementProducer = cementProducer;
    }

    public BigInteger getFineAggProducer() {
        return fineAggProducer;
    }

    public void setFineAggProducer(BigInteger fineAggProducer) {
        this.fineAggProducer = fineAggProducer;
    }

    public BigInteger getCoarseAggProducer() {
        return coarseAggProducer;
    }

    public void setCoarseAggProducer(BigInteger coarseAggProducer) {
        this.coarseAggProducer = coarseAggProducer;
    }

    public String getMillCertIncluded() {
        return millCertIncluded;
    }

    public void setMillCertIncluded(String millCertIncluded) {
        this.millCertIncluded = millCertIncluded;
    }

    public String getMillCertNo() {
        return millCertNo;
    }

    public void setMillCertNo(String millCertNo) {
        this.millCertNo = millCertNo;
    }

    public String getPozzolanType() {
        return pozzolanType;
    }

    public void setPozzolanType(String pozzolanType) {
        this.pozzolanType = pozzolanType;
    }

    public String getCuringBoxOnSiteCondition() {
        return curingBoxOnSiteCondition;
    }

    public void setCuringBoxOnSiteCondition(String curingBoxOnSiteCondition) {
        this.curingBoxOnSiteCondition = curingBoxOnSiteCondition;
    }

    public Character getMixDesignOnSite() {
        return mixDesignOnSite;
    }

    public void setMixDesignOnSite(Character mixDesignOnSite) {
        this.mixDesignOnSite = mixDesignOnSite;
    }

    public String getCreateYear() {
        return createYear;
    }

    public void setCreateYear(String createYear) {
        this.createYear = createYear;
    }

    public String getRandomSample() {
        return randomSample;
    }

    public void setRandomSample(String randomSample) {
        this.randomSample = randomSample;
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
        if (!(object instanceof QaSample)) {
            return false;
        }
        QaSample other = (QaSample) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSample[ id=" + id + " ]";
    }

}
