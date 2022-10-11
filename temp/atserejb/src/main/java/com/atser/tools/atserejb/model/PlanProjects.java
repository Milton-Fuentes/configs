/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
, @NamedQuery(name = "PlanProjects.findByProjectId", query = "SELECT p FROM PlanProjects p WHERE p.projectId = :projectId")
    , @NamedQuery(name = "PlanProjects.findByFiscalYear", query = "SELECT p FROM PlanProjects p WHERE p.fiscalYear = :fiscalYear")
    , @NamedQuery(name = "PlanProjects.findByPName", query = "SELECT p FROM PlanProjects p WHERE p.pName = :pName")
    , @NamedQuery(name = "PlanProjects.findByPPhase", query = "SELECT p FROM PlanProjects p WHERE p.pPhase = :pPhase")
    , @NamedQuery(name = "PlanProjects.findByPDescription", query = "SELECT p FROM PlanProjects p WHERE p.pDescription = :pDescription")
    , @NamedQuery(name = "PlanProjects.findByDateRecommended", query = "SELECT p FROM PlanProjects p WHERE p.dateRecommended = :dateRecommended")
    , @NamedQuery(name = "PlanProjects.findByCouncilDistFacility", query = "SELECT p FROM PlanProjects p WHERE p.councilDistFacility = :councilDistFacility")
    , @NamedQuery(name = "PlanProjects.findByCouncilDistService", query = "SELECT p FROM PlanProjects p WHERE p.councilDistService = :councilDistService")
    , @NamedQuery(name = "PlanProjects.findByFacilityArea", query = "SELECT p FROM PlanProjects p WHERE p.facilityArea = :facilityArea")
    , @NamedQuery(name = "PlanProjects.findByServiceArea", query = "SELECT p FROM PlanProjects p WHERE p.serviceArea = :serviceArea")
    , @NamedQuery(name = "PlanProjects.findByProposedBy", query = "SELECT p FROM PlanProjects p WHERE p.proposedBy = :proposedBy")
    , @NamedQuery(name = "PlanProjects.findByCountyPrecinct", query = "SELECT p FROM PlanProjects p WHERE p.countyPrecinct = :countyPrecinct")
    , @NamedQuery(name = "PlanProjects.findByKeyMap", query = "SELECT p FROM PlanProjects p WHERE p.keyMap = :keyMap")
    , @NamedQuery(name = "PlanProjects.findByCohContact", query = "SELECT p FROM PlanProjects p WHERE p.cohContact = :cohContact")
    , @NamedQuery(name = "PlanProjects.findByRefItem1", query = "SELECT p FROM PlanProjects p WHERE p.refItem1 = :refItem1")
    , @NamedQuery(name = "PlanProjects.findByRefItem2", query = "SELECT p FROM PlanProjects p WHERE p.refItem2 = :refItem2")
    , @NamedQuery(name = "PlanProjects.findByRefItem3", query = "SELECT p FROM PlanProjects p WHERE p.refItem3 = :refItem3")
    , @NamedQuery(name = "PlanProjects.findByRefItem4", query = "SELECT p FROM PlanProjects p WHERE p.refItem4 = :refItem4")
    , @NamedQuery(name = "PlanProjects.findByPossibleSolutions", query = "SELECT p FROM PlanProjects p WHERE p.possibleSolutions = :possibleSolutions")
    , @NamedQuery(name = "PlanProjects.findByNotesField", query = "SELECT p FROM PlanProjects p WHERE p.notesField = :notesField")
    , @NamedQuery(name = "PlanProjects.findByPCategory", query = "SELECT p FROM PlanProjects p WHERE p.pCategory = :pCategory")
    , @NamedQuery(name = "PlanProjects.findByStatus", query = "SELECT p FROM PlanProjects p WHERE p.status = :status")
    , @NamedQuery(name = "PlanProjects.findByStatusReasons", query = "SELECT p FROM PlanProjects p WHERE p.statusReasons = :statusReasons")
    , @NamedQuery(name = "PlanProjects.findByItemAssignedTo", query = "SELECT p FROM PlanProjects p WHERE p.itemAssignedTo = :itemAssignedTo")
    , @NamedQuery(name = "PlanProjects.findByDateAssigned", query = "SELECT p FROM PlanProjects p WHERE p.dateAssigned = :dateAssigned")
    , @NamedQuery(name = "PlanProjects.findByDueDate", query = "SELECT p FROM PlanProjects p WHERE p.dueDate = :dueDate")
    , @NamedQuery(name = "PlanProjects.findByStatusDate", query = "SELECT p FROM PlanProjects p WHERE p.statusDate = :statusDate")
    , @NamedQuery(name = "PlanProjects.findByStatusChangedBy", query = "SELECT p FROM PlanProjects p WHERE p.statusChangedBy = :statusChangedBy")
    , @NamedQuery(name = "PlanProjects.findByCombineWith", query = "SELECT p FROM PlanProjects p WHERE p.combineWith = :combineWith")
    , @NamedQuery(name = "PlanProjects.findByFundSourceEligible", query = "SELECT p FROM PlanProjects p WHERE p.fundSourceEligible = :fundSourceEligible")
    , @NamedQuery(name = "PlanProjects.findByFundSourceOther1", query = "SELECT p FROM PlanProjects p WHERE p.fundSourceOther1 = :fundSourceOther1")
    , @NamedQuery(name = "PlanProjects.findByFundSourceOther2", query = "SELECT p FROM PlanProjects p WHERE p.fundSourceOther2 = :fundSourceOther2")
    , @NamedQuery(name = "PlanProjects.findByFundSourceOther3", query = "SELECT p FROM PlanProjects p WHERE p.fundSourceOther3 = :fundSourceOther3")
    , @NamedQuery(name = "PlanProjects.findByFundSourceOther4", query = "SELECT p FROM PlanProjects p WHERE p.fundSourceOther4 = :fundSourceOther4")
    , @NamedQuery(name = "PlanProjects.findByTypeProject", query = "SELECT p FROM PlanProjects p WHERE p.typeProject = :typeProject")
    , @NamedQuery(name = "PlanProjects.findByProblemJust", query = "SELECT p FROM PlanProjects p WHERE p.problemJust = :problemJust")
    , @NamedQuery(name = "PlanProjects.findByEstStartDate", query = "SELECT p FROM PlanProjects p WHERE p.estStartDate = :estStartDate")
    , @NamedQuery(name = "PlanProjects.findByBenefit", query = "SELECT p FROM PlanProjects p WHERE p.benefit = :benefit")
    , @NamedQuery(name = "PlanProjects.findByBenCostRatio", query = "SELECT p FROM PlanProjects p WHERE p.benCostRatio = :benCostRatio")
    , @NamedQuery(name = "PlanProjects.findByCitizensAffect", query = "SELECT p FROM PlanProjects p WHERE p.citizensAffect = :citizensAffect")
    , @NamedQuery(name = "PlanProjects.findByInitEstAcq", query = "SELECT p FROM PlanProjects p WHERE p.initEstAcq = :initEstAcq")
    , @NamedQuery(name = "PlanProjects.findByCurrEstAcq", query = "SELECT p FROM PlanProjects p WHERE p.currEstAcq = :currEstAcq")
    , @NamedQuery(name = "PlanProjects.findByInitEstEng", query = "SELECT p FROM PlanProjects p WHERE p.initEstEng = :initEstEng")
    , @NamedQuery(name = "PlanProjects.findByCurrEstEng", query = "SELECT p FROM PlanProjects p WHERE p.currEstEng = :currEstEng")
    , @NamedQuery(name = "PlanProjects.findByInitEstCons", query = "SELECT p FROM PlanProjects p WHERE p.initEstCons = :initEstCons")
    , @NamedQuery(name = "PlanProjects.findByCurrEstCons", query = "SELECT p FROM PlanProjects p WHERE p.currEstCons = :currEstCons")
    , @NamedQuery(name = "PlanProjects.findByInitEstEquip", query = "SELECT p FROM PlanProjects p WHERE p.initEstEquip = :initEstEquip")
    , @NamedQuery(name = "PlanProjects.findByCurrEstEquip", query = "SELECT p FROM PlanProjects p WHERE p.currEstEquip = :currEstEquip")
    , @NamedQuery(name = "PlanProjects.findByFormAComments", query = "SELECT p FROM PlanProjects p WHERE p.formAComments = :formAComments")
    , @NamedQuery(name = "PlanProjects.findByEstPersonnel", query = "SELECT p FROM PlanProjects p WHERE p.estPersonnel = :estPersonnel")
    , @NamedQuery(name = "PlanProjects.findByEstCaptlOutlay", query = "SELECT p FROM PlanProjects p WHERE p.estCaptlOutlay = :estCaptlOutlay")
    , @NamedQuery(name = "PlanProjects.findByEstSupplies", query = "SELECT p FROM PlanProjects p WHERE p.estSupplies = :estSupplies")
    , @NamedQuery(name = "PlanProjects.findByEstOther", query = "SELECT p FROM PlanProjects p WHERE p.estOther = :estOther")
    , @NamedQuery(name = "PlanProjects.findByEstServiceChange", query = "SELECT p FROM PlanProjects p WHERE p.estServiceChange = :estServiceChange")
    , @NamedQuery(name = "PlanProjects.findByEstFtes", query = "SELECT p FROM PlanProjects p WHERE p.estFtes = :estFtes")
    , @NamedQuery(name = "PlanProjects.findByCipNo", query = "SELECT p FROM PlanProjects p WHERE p.cipNo = :cipNo")
    , @NamedQuery(name = "PlanProjects.findByGfsNo", query = "SELECT p FROM PlanProjects p WHERE p.gfsNo = :gfsNo")
    , @NamedQuery(name = "PlanProjects.findByProjName", query = "SELECT p FROM PlanProjects p WHERE p.projName = :projName")
    , @NamedQuery(name = "PlanProjects.findByReadyToApprove", query = "SELECT p FROM PlanProjects p WHERE p.readyToApprove = :readyToApprove")
    , @NamedQuery(name = "PlanProjects.findByReqCompDate", query = "SELECT p FROM PlanProjects p WHERE p.reqCompDate = :reqCompDate")
    , @NamedQuery(name = "PlanProjects.findByDeptId", query = "SELECT p FROM PlanProjects p WHERE p.deptId = :deptId")
    , @NamedQuery(name = "PlanProjects.findByNts", query = "SELECT p FROM PlanProjects p WHERE p.nts = :nts")
    , @NamedQuery(name = "PlanProjects.findBySubType", query = "SELECT p FROM PlanProjects p WHERE p.subType = :subType")
    , @NamedQuery(name = "PlanProjects.findByPNumber", query = "SELECT p FROM PlanProjects p WHERE p.pNumber = :pNumber")
    , @NamedQuery(name = "PlanProjects.findByLocationKey", query = "SELECT p FROM PlanProjects p WHERE p.locationKey = :locationKey")
, @NamedQuery(name = "PlanProjects.findByBidDate", query = "SELECT p FROM PlanProjects p WHERE p.bidDate = :bidDate")
    , @NamedQuery(name = "PlanProjects.findByComponent", query = "SELECT p FROM PlanProjects p WHERE p.component = :component")
    , @NamedQuery(name = "PlanProjects.findByActivity", query = "SELECT p FROM PlanProjects p WHERE p.activity = :activity")
    , @NamedQuery(name = "PlanProjects.findByStage", query = "SELECT p FROM PlanProjects p WHERE p.stage = :stage")
    , @NamedQuery(name = "PlanProjects.findByCompany", query = "SELECT p FROM PlanProjects p WHERE p.company = :company")
    , @NamedQuery(name = "PlanProjects.findByLName", query = "SELECT p FROM PlanProjects p WHERE p.lName = :lName")
    , @NamedQuery(name = "PlanProjects.findByRequestCat", query = "SELECT p FROM PlanProjects p WHERE p.requestCat = :requestCat")
    , @NamedQuery(name = "PlanProjects.findByAssetType", query = "SELECT p FROM PlanProjects p WHERE p.assetType = :assetType")
    , @NamedQuery(name = "PlanProjects.findByProperty", query = "SELECT p FROM PlanProjects p WHERE p.property = :property")
    , @NamedQuery(name = "PlanProjects.findByLNumber", query = "SELECT p FROM PlanProjects p WHERE p.lNumber = :lNumber")
    , @NamedQuery(name = "PlanProjects.findByCipStatus", query = "SELECT p FROM PlanProjects p WHERE p.cipStatus = :cipStatus")
    , @NamedQuery(name = "PlanProjects.findByApprovedDate", query = "SELECT p FROM PlanProjects p WHERE p.approvedDate = :approvedDate")
    , @NamedQuery(name = "PlanProjects.findByApprovedAmount", query = "SELECT p FROM PlanProjects p WHERE p.approvedAmount = :approvedAmount")
    , @NamedQuery(name = "PlanProjects.findByBudgetAmount", query = "SELECT p FROM PlanProjects p WHERE p.budgetAmount = :budgetAmount")
    , @NamedQuery(name = "PlanProjects.findByTagNo", query = "SELECT p FROM PlanProjects p WHERE p.tagNo = :tagNo")
    , @NamedQuery(name = "PlanProjects.findByUsefulLife", query = "SELECT p FROM PlanProjects p WHERE p.usefulLife = :usefulLife")
    , @NamedQuery(name = "PlanProjects.findByGlAcct", query = "SELECT p FROM PlanProjects p WHERE p.glAcct = :glAcct")
    , @NamedQuery(name = "PlanProjects.findBySubAcct", query = "SELECT p FROM PlanProjects p WHERE p.subAcct = :subAcct")
    , @NamedQuery(name = "PlanProjects.findByBudgetSource", query = "SELECT p FROM PlanProjects p WHERE p.budgetSource = :budgetSource")
    , @NamedQuery(name = "PlanProjects.findByVendor", query = "SELECT p FROM PlanProjects p WHERE p.vendor = :vendor")
    , @NamedQuery(name = "PlanProjects.findByMinuteNo", query = "SELECT p FROM PlanProjects p WHERE p.minuteNo = :minuteNo")
    , @NamedQuery(name = "PlanProjects.findByDeprAmt", query = "SELECT p FROM PlanProjects p WHERE p.deprAmt = :deprAmt")
    , @NamedQuery(name = "PlanProjects.findByAmortizableAmt", query = "SELECT p FROM PlanProjects p WHERE p.amortizableAmt = :amortizableAmt")
    , @NamedQuery(name = "PlanProjects.findByExpAmt", query = "SELECT p FROM PlanProjects p WHERE p.expAmt = :expAmt")
    , @NamedQuery(name = "PlanProjects.findByReimbursableAmt", query = "SELECT p FROM PlanProjects p WHERE p.reimbursableAmt = :reimbursableAmt")
    , @NamedQuery(name = "PlanProjects.findByFundingSource", query = "SELECT p FROM PlanProjects p WHERE p.fundingSource = :fundingSource")
    , @NamedQuery(name = "PlanProjects.findByFundAmount0", query = "SELECT p FROM PlanProjects p WHERE p.fundAmount0 = :fundAmount0")
    , @NamedQuery(name = "PlanProjects.findByFundAmount1", query = "SELECT p FROM PlanProjects p WHERE p.fundAmount1 = :fundAmount1")
    , @NamedQuery(name = "PlanProjects.findByFundAmount2", query = "SELECT p FROM PlanProjects p WHERE p.fundAmount2 = :fundAmount2")
    , @NamedQuery(name = "PlanProjects.findByFundAmount3", query = "SELECT p FROM PlanProjects p WHERE p.fundAmount3 = :fundAmount3")
    , @NamedQuery(name = "PlanProjects.findByFundAmount4", query = "SELECT p FROM PlanProjects p WHERE p.fundAmount4 = :fundAmount4")
    , @NamedQuery(name = "PlanProjects.findByComments", query = "SELECT p FROM PlanProjects p WHERE p.comments = :comments")
    , @NamedQuery(name = "PlanProjects.findByCommitted", query = "SELECT p FROM PlanProjects p WHERE p.committed = :committed")
    , @NamedQuery(name = "PlanProjects.findByProjectIdOld", query = "SELECT p FROM PlanProjects p WHERE p.projectIdOld = :projectIdOld")
    , @NamedQuery(name = "PlanProjects.findByDeprAmtStartDate", query = "SELECT p FROM PlanProjects p WHERE p.deprAmtStartDate = :deprAmtStartDate")
    , @NamedQuery(name = "PlanProjects.findByReadyForDesign", query = "SELECT p FROM PlanProjects p WHERE p.readyForDesign = :readyForDesign")
    , @NamedQuery(name = "PlanProjects.findByPoNumber", query = "SELECT p FROM PlanProjects p WHERE p.poNumber = :poNumber")
    , @NamedQuery(name = "PlanProjects.findByReadyForConstruction", query = "SELECT p FROM PlanProjects p WHERE p.readyForConstruction = :readyForConstruction")
    , @NamedQuery(name = "PlanProjects.findByClass1", query = "SELECT p FROM PlanProjects p WHERE p.class1 = :class1")
    , @NamedQuery(name = "PlanProjects.findByTier", query = "SELECT p FROM PlanProjects p WHERE p.tier = :tier")
    , @NamedQuery(name = "PlanProjects.findByDepartmentPriority", query = "SELECT p FROM PlanProjects p WHERE p.departmentPriority = :departmentPriority")
    , @NamedQuery(name = "PlanProjects.findByPhaPriority", query = "SELECT p FROM PlanProjects p WHERE p.phaPriority = :phaPriority")
    , @NamedQuery(name = "PlanProjects.findByClientId", query = "SELECT p FROM PlanProjects p WHERE p.clientId = :clientId")
    , @NamedQuery(name = "PlanProjects.findByStatusId", query = "SELECT p FROM PlanProjects p WHERE p.statusId = :statusId")
    , @NamedQuery(name = "PlanProjects.findByStreet", query = "SELECT p FROM PlanProjects p WHERE p.street = :street")
    , @NamedQuery(name = "PlanProjects.findByCity", query = "SELECT p FROM PlanProjects p WHERE p.city = :city")
    , @NamedQuery(name = "PlanProjects.findByState", query = "SELECT p FROM PlanProjects p WHERE p.state = :state")
    , @NamedQuery(name = "PlanProjects.findByZipcode", query = "SELECT p FROM PlanProjects p WHERE p.zipcode = :zipcode")
    , @NamedQuery(name = "PlanProjects.findByCounty", query = "SELECT p FROM PlanProjects p WHERE p.county = :county")
    , @NamedQuery(name = "PlanProjects.findByGeoLat", query = "SELECT p FROM PlanProjects p WHERE p.geoLat = :geoLat")
    , @NamedQuery(name = "PlanProjects.findByGeoLong", query = "SELECT p FROM PlanProjects p WHERE p.geoLong = :geoLong")
    , @NamedQuery(name = "PlanProjects.findByPhone", query = "SELECT p FROM PlanProjects p WHERE p.phone = :phone")
    , @NamedQuery(name = "PlanProjects.findByFax", query = "SELECT p FROM PlanProjects p WHERE p.fax = :fax")
    , @NamedQuery(name = "PlanProjects.findByDescription", query = "SELECT p FROM PlanProjects p WHERE p.description = :description")
    , @NamedQuery(name = "PlanProjects.findByProjectManager", query = "SELECT p FROM PlanProjects p WHERE p.projectManager = :projectManager")
    , @NamedQuery(name = "PlanProjects.findByProjectValue", query = "SELECT p FROM PlanProjects p WHERE p.projectValue = :projectValue")
    , @NamedQuery(name = "PlanProjects.findByProjectType", query = "SELECT p FROM PlanProjects p WHERE p.projectType = :projectType")
    , @NamedQuery(name = "PlanProjects.findByDeliveryType", query = "SELECT p FROM PlanProjects p WHERE p.deliveryType = :deliveryType")
    , @NamedQuery(name = "PlanProjects.findByBidType", query = "SELECT p FROM PlanProjects p WHERE p.bidType = :bidType")
    , @NamedQuery(name = "PlanProjects.findByNotes", query = "SELECT p FROM PlanProjects p WHERE p.notes = :notes")
    , @NamedQuery(name = "PlanProjects.findByLastMod", query = "SELECT p FROM PlanProjects p WHERE p.lastMod = :lastMod")
    , @NamedQuery(name = "PlanProjects.findByLastModBy", query = "SELECT p FROM PlanProjects p WHERE p.lastModBy = :lastModBy")
    , @NamedQuery(name = "PlanProjects.findByLastModIp", query = "SELECT p FROM PlanProjects p WHERE p.lastModIp = :lastModIp")
    , @NamedQuery(name = "PlanProjects.findByCreateBy", query = "SELECT p FROM PlanProjects p WHERE p.createBy = :createBy")
    , @NamedQuery(name = "PlanProjects.findByCreateByIp", query = "SELECT p FROM PlanProjects p WHERE p.createByIp = :createByIp")
    , @NamedQuery(name = "PlanProjects.findByCreateDate", query = "SELECT p FROM PlanProjects p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "PlanProjects.findByVersion", query = "SELECT p FROM PlanProjects p WHERE p.version = :version")
    , @NamedQuery(name = "PlanProjects.findByPriority", query = "SELECT p FROM PlanProjects p WHERE p.priority = :priority")
    , @NamedQuery(name = "PlanProjects.findByActionItem", query = "SELECT p FROM PlanProjects p WHERE p.actionItem = :actionItem")
    , @NamedQuery(name = "PlanProjects.findByActionStatus", query = "SELECT p FROM PlanProjects p WHERE p.actionStatus = :actionStatus")
    , @NamedQuery(name = "PlanProjects.findByEstmConstructionDays", query = "SELECT p FROM PlanProjects p WHERE p.estmConstructionDays = :estmConstructionDays")
    , @NamedQuery(name = "PlanProjects.findByProjectProgId", query = "SELECT p FROM PlanProjects p WHERE p.projectProgId = :projectProgId")
 */
/**
 *
 * @author dperez
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "PLAN_PROJECTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanProjects.findAll", query = "SELECT p FROM PlanProjects p"),
    @NamedQuery(name = "PlanProjects.findById", query = "SELECT p FROM PlanProjects p WHERE p.id = :id")})
public class PlanProjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 15)
    @Column(name = "PROJECT_ID")
    private String projectId;
    @Column(name = "FISCAL_YEAR")
    private Short fiscalYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 15)
    @Column(name = "P_PHASE")
    private String pPhase;
    @Size(max = 1000)
    @Column(name = "P_DESCRIPTION")
    private String pDescription;
    @Column(name = "DATE_RECOMMENDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecommended;
    @Size(max = 50)
    @Column(name = "COUNCIL_DIST_FACILITY")
    private String councilDistFacility;
    @Size(max = 50)
    @Column(name = "COUNCIL_DIST_SERVICE")
    private String councilDistService;
    @Size(max = 50)
    @Column(name = "FACILITY_AREA")
    private String facilityArea;
    @Size(max = 50)
    @Column(name = "SERVICE_AREA")
    private String serviceArea;
    @Size(max = 50)
    @Column(name = "PROPOSED_BY")
    private String proposedBy;
    @Size(max = 50)
    @Column(name = "COUNTY_PRECINCT")
    private String countyPrecinct;
    @Size(max = 250)
    @Column(name = "KEY_MAP")
    private String keyMap;
    @Column(name = "COH_CONTACT")
    private BigInteger cohContact;
    @Size(max = 100)
    @Column(name = "REF_ITEM1")
    private String refItem1;
    @Size(max = 100)
    @Column(name = "REF_ITEM2")
    private String refItem2;
    @Size(max = 100)
    @Column(name = "REF_ITEM3")
    private String refItem3;
    @Size(max = 100)
    @Column(name = "REF_ITEM4")
    private String refItem4;
    @Size(max = 2000)
    @Column(name = "POSSIBLE_SOLUTIONS")
    private String possibleSolutions;
    @Size(max = 250)
    @Column(name = "NOTES_FIELD")
    private String notesField;
    @Size(max = 50)
    @Column(name = "P_CATEGORY")
    private String pCategory;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 250)
    @Column(name = "STATUS_REASONS")
    private String statusReasons;
    @Column(name = "ITEM_ASSIGNED_TO")
    private BigInteger itemAssignedTo;
    @Column(name = "DATE_ASSIGNED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAssigned;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @Size(max = 50)
    @Column(name = "STATUS_CHANGED_BY")
    private String statusChangedBy;
    @Size(max = 15)
    @Column(name = "COMBINE_WITH")
    private String combineWith;
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_ELIGIBLE")
    private String fundSourceEligible;
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER1")
    private String fundSourceOther1;
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER2")
    private String fundSourceOther2;
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER3")
    private String fundSourceOther3;
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER4")
    private String fundSourceOther4;
    @Size(max = 250)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Size(max = 1000)
    @Column(name = "PROBLEM_JUST")
    private String problemJust;
    @Column(name = "EST_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estStartDate;
    @Size(max = 1000)
    @Column(name = "BENEFIT")
    private String benefit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BEN_COST_RATIO")
    private BigDecimal benCostRatio;
    @Column(name = "CITIZENS_AFFECT")
    private BigInteger citizensAffect;
    @Column(name = "INIT_EST_ACQ")
    private BigDecimal initEstAcq;
    @Column(name = "CURR_EST_ACQ")
    private BigDecimal currEstAcq;
    @Column(name = "INIT_EST_ENG")
    private BigDecimal initEstEng;
    @Column(name = "CURR_EST_ENG")
    private BigDecimal currEstEng;
    @Column(name = "INIT_EST_CONS")
    private BigDecimal initEstCons;
    @Column(name = "CURR_EST_CONS")
    private BigDecimal currEstCons;
    @Column(name = "INIT_EST_EQUIP")
    private BigDecimal initEstEquip;
    @Column(name = "CURR_EST_EQUIP")
    private BigDecimal currEstEquip;
    @Size(max = 4000)
    @Column(name = "FORM_A_COMMENTS")
    private String formAComments;
    @Column(name = "EST_PERSONNEL")
    private BigDecimal estPersonnel;
    @Column(name = "EST_CAPTL_OUTLAY")
    private BigDecimal estCaptlOutlay;
    @Column(name = "EST_SUPPLIES")
    private BigDecimal estSupplies;
    @Column(name = "EST_OTHER")
    private BigDecimal estOther;
    @Column(name = "EST_SERVICE_CHANGE")
    private BigDecimal estServiceChange;
    @Column(name = "EST_FTES")
    private BigDecimal estFtes;
    @Size(max = 15)
    @Column(name = "CIP_NO")
    private String cipNo;
    @Size(max = 15)
    @Column(name = "GFS_NO")
    private String gfsNo;
    @Size(max = 250)
    @Column(name = "PROJ_NAME")
    private String projName;
    @Size(max = 3)
    @Column(name = "READY_TO_APPROVE")
    private String readyToApprove;
    @Column(name = "REQ_COMP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqCompDate;
    @Column(name = "DEPT_ID")
    private Integer deptId;
    @Size(max = 3)
    @Column(name = "NTS")
    private String nts;
    @Size(max = 10)
    @Column(name = "SUB_TYPE")
    private String subType;
    @Size(max = 4)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "LOCATION_KEY")
    private String locationKey;
    @Column(name = "BID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDate;
    @Size(max = 255)
    @Column(name = "COMPONENT")
    private String component;
    @Size(max = 255)
    @Column(name = "ACTIVITY")
    private String activity;
    @Size(max = 255)
    @Column(name = "STAGE")
    private String stage;
    @Size(max = 255)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 255)
    @Column(name = "L_NAME")
    private String lName;
    @Size(max = 255)
    @Column(name = "REQUEST_CAT")
    private String requestCat;
    @Size(max = 255)
    @Column(name = "ASSET_TYPE")
    private String assetType;
    @Size(max = 255)
    @Column(name = "PROPERTY")
    private String property;
    @Size(max = 255)
    @Column(name = "L_NUMBER")
    private String lNumber;
    @Size(max = 255)
    @Column(name = "CIP_STATUS")
    private String cipStatus;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "APPROVED_AMOUNT")
    private BigInteger approvedAmount;
    @Column(name = "BUDGET_AMOUNT")
    private BigInteger budgetAmount;
    @Size(max = 255)
    @Column(name = "TAG_NO")
    private String tagNo;
    @Size(max = 255)
    @Column(name = "USEFUL_LIFE")
    private String usefulLife;
    @Size(max = 255)
    @Column(name = "GL_ACCT")
    private String glAcct;
    @Size(max = 255)
    @Column(name = "SUB_ACCT")
    private String subAcct;
    @Size(max = 255)
    @Column(name = "BUDGET_SOURCE")
    private String budgetSource;
    @Size(max = 255)
    @Column(name = "VENDOR")
    private String vendor;
    @Size(max = 255)
    @Column(name = "MINUTE_NO")
    private String minuteNo;
    @Column(name = "DEPR_AMT")
    private BigInteger deprAmt;
    @Column(name = "AMORTIZABLE_AMT")
    private BigInteger amortizableAmt;
    @Column(name = "EXP_AMT")
    private BigInteger expAmt;
    @Column(name = "REIMBURSABLE_AMT")
    private BigInteger reimbursableAmt;
    @Size(max = 255)
    @Column(name = "FUNDING_SOURCE")
    private String fundingSource;
    @Column(name = "FUND_AMOUNT0")
    private BigInteger fundAmount0;
    @Column(name = "FUND_AMOUNT1")
    private BigInteger fundAmount1;
    @Column(name = "FUND_AMOUNT2")
    private BigInteger fundAmount2;
    @Column(name = "FUND_AMOUNT3")
    private BigInteger fundAmount3;
    @Column(name = "FUND_AMOUNT4")
    private BigInteger fundAmount4;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "COMMITTED")
    private BigInteger committed;
    @Size(max = 255)
    @Column(name = "PROJECT_ID_OLD")
    private String projectIdOld;
    @Column(name = "DEPR_AMT_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deprAmtStartDate;
    @Size(max = 256)
    @Column(name = "READY_FOR_DESIGN")
    private String readyForDesign;
    @Size(max = 256)
    @Column(name = "PO_NUMBER")
    private String poNumber;
    @Size(max = 256)
    @Column(name = "READY_FOR_CONSTRUCTION")
    private String readyForConstruction;
    @Size(max = 50)
    @Column(name = "CLASS")
    private String class1;
    @Size(max = 50)
    @Column(name = "TIER")
    private String tier;
    @Size(max = 50)
    @Column(name = "DEPARTMENT_PRIORITY")
    private String departmentPriority;
    @Size(max = 50)
    @Column(name = "PHA_PRIORITY")
    private String phaPriority;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "STATUS_ID")
    private BigInteger statusId;
    @Size(max = 200)
    @Column(name = "STREET")
    private String street;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 50)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Size(max = 50)
    @Column(name = "COUNTY")
    private String county;
    @Size(max = 50)
    @Column(name = "GEO_LAT")
    private String geoLat;
    @Size(max = 50)
    @Column(name = "GEO_LONG")
    private String geoLong;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "PROJECT_MANAGER")
    private String projectManager;
    @Column(name = "PROJECT_VALUE")
    private Double projectValue;
    @Column(name = "PROJECT_TYPE")
    private BigInteger projectType;
    @Column(name = "DELIVERY_TYPE")
    private BigInteger deliveryType;
    @Column(name = "BID_TYPE")
    private BigInteger bidType;
    @Size(max = 2000)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "PRIORITY")
    private String priority;
    @Size(max = 2000)
    @Column(name = "ACTION_ITEM")
    private String actionItem;
    @Size(max = 50)
    @Column(name = "ACTION_STATUS")
    private String actionStatus;
    @Column(name = "ESTM_CONSTRUCTION_DAYS")
    private Double estmConstructionDays;
    @Column(name = "PROJECT_PROG_ID")
    private BigInteger projectProgId;
    
    public String getProjectFullName() {
        if (StringSupport.isNotNullAndNotEmpty(this.gfsNo)) {
            return "[ " + this.gfsNo + " ] " + this.pName;
        } else {
            if (StringSupport.isNotNullAndNotEmpty(this.pName)) {
                return this.pName;
            } else {
                return this.projectId;
            }
        }
    }
}
