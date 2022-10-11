/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
    , @NamedQuery(name = "GlobProject.findByDescription", query = "SELECT g FROM GlobProject g WHERE g.description = :description")
    , @NamedQuery(name = "GlobProject.findByEstimatedCost", query = "SELECT g FROM GlobProject g WHERE g.estimatedCost = :estimatedCost")
    , @NamedQuery(name = "GlobProject.findByContact", query = "SELECT g FROM GlobProject g WHERE g.contact = :contact")
    , @NamedQuery(name = "GlobProject.findByPhone", query = "SELECT g FROM GlobProject g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobProject.findByCell", query = "SELECT g FROM GlobProject g WHERE g.cell = :cell")
    , @NamedQuery(name = "GlobProject.findByFax", query = "SELECT g FROM GlobProject g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobProject.findByEmail", query = "SELECT g FROM GlobProject g WHERE g.email = :email")
    , @NamedQuery(name = "GlobProject.findByLocation", query = "SELECT g FROM GlobProject g WHERE g.location = :location")
    , @NamedQuery(name = "GlobProject.findByStatus", query = "SELECT g FROM GlobProject g WHERE g.status = :status")
    , @NamedQuery(name = "GlobProject.findByStartDate", query = "SELECT g FROM GlobProject g WHERE g.startDate = :startDate")
    , @NamedQuery(name = "GlobProject.findByEndDate", query = "SELECT g FROM GlobProject g WHERE g.endDate = :endDate")
    , @NamedQuery(name = "GlobProject.findByActive", query = "SELECT g FROM GlobProject g WHERE g.active = :active")
    , @NamedQuery(name = "GlobProject.findByLastModTemp", query = "SELECT g FROM GlobProject g WHERE g.lastModTemp = :lastModTemp")
    , @NamedQuery(name = "GlobProject.findByLastModBy", query = "SELECT g FROM GlobProject g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobProject.findByLastModIp", query = "SELECT g FROM GlobProject g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobProject.findByTemp", query = "SELECT g FROM GlobProject g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobProject.findByCreateBy", query = "SELECT g FROM GlobProject g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobProject.findByCreateByIp", query = "SELECT g FROM GlobProject g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobProject.findByCreateDate", query = "SELECT g FROM GlobProject g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobProject.findByCompanyId", query = "SELECT g FROM GlobProject g WHERE g.companyId = :companyId")
    , @NamedQuery(name = "GlobProject.findByPNumber", query = "SELECT g FROM GlobProject g WHERE g.pNumber = :pNumber")
    , @NamedQuery(name = "GlobProject.findByPName", query = "SELECT g FROM GlobProject g WHERE g.pName = :pName")
    , @NamedQuery(name = "GlobProject.findByPDate", query = "SELECT g FROM GlobProject g WHERE g.pDate = :pDate")
    , @NamedQuery(name = "GlobProject.findByPType", query = "SELECT g FROM GlobProject g WHERE g.pType = :pType")
    , @NamedQuery(name = "GlobProject.findByBidDate", query = "SELECT g FROM GlobProject g WHERE g.bidDate = :bidDate")
    , @NamedQuery(name = "GlobProject.findByFileNo", query = "SELECT g FROM GlobProject g WHERE g.fileNo = :fileNo")
    , @NamedQuery(name = "GlobProject.findByFundsNo", query = "SELECT g FROM GlobProject g WHERE g.fundsNo = :fundsNo")
    , @NamedQuery(name = "GlobProject.findByFundsSource", query = "SELECT g FROM GlobProject g WHERE g.fundsSource = :fundsSource")
    , @NamedQuery(name = "GlobProject.findByCouncilDist", query = "SELECT g FROM GlobProject g WHERE g.councilDist = :councilDist")
    , @NamedQuery(name = "GlobProject.findByAssistantDirectorId", query = "SELECT g FROM GlobProject g WHERE g.assistantDirectorId = :assistantDirectorId")
    , @NamedQuery(name = "GlobProject.findByChiefEngineerId", query = "SELECT g FROM GlobProject g WHERE g.chiefEngineerId = :chiefEngineerId")
    , @NamedQuery(name = "GlobProject.findBySeniorInspectorId", query = "SELECT g FROM GlobProject g WHERE g.seniorInspectorId = :seniorInspectorId")
    , @NamedQuery(name = "GlobProject.findByCuicNo", query = "SELECT g FROM GlobProject g WHERE g.cuicNo = :cuicNo")
    , @NamedQuery(name = "GlobProject.findByRecievedContracts", query = "SELECT g FROM GlobProject g WHERE g.recievedContracts = :recievedContracts")
    , @NamedQuery(name = "GlobProject.findByAwardOrdinanceNum", query = "SELECT g FROM GlobProject g WHERE g.awardOrdinanceNum = :awardOrdinanceNum")
    , @NamedQuery(name = "GlobProject.findByAwardOrdinanceDate", query = "SELECT g FROM GlobProject g WHERE g.awardOrdinanceDate = :awardOrdinanceDate")
    , @NamedQuery(name = "GlobProject.findByContactId", query = "SELECT g FROM GlobProject g WHERE g.contactId = :contactId")
    , @NamedQuery(name = "GlobProject.findByHomedirectory", query = "SELECT g FROM GlobProject g WHERE g.homedirectory = :homedirectory")
    , @NamedQuery(name = "GlobProject.findByPStatus", query = "SELECT g FROM GlobProject g WHERE g.pStatus = :pStatus")
    , @NamedQuery(name = "GlobProject.findByField1", query = "SELECT g FROM GlobProject g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobProject.findByField2", query = "SELECT g FROM GlobProject g WHERE g.field2 = :field2")
    , @NamedQuery(name = "GlobProject.findByField3", query = "SELECT g FROM GlobProject g WHERE g.field3 = :field3")
    , @NamedQuery(name = "GlobProject.findByField4", query = "SELECT g FROM GlobProject g WHERE g.field4 = :field4")
    , @NamedQuery(name = "GlobProject.findByField5", query = "SELECT g FROM GlobProject g WHERE g.field5 = :field5")
    , @NamedQuery(name = "GlobProject.findByField6", query = "SELECT g FROM GlobProject g WHERE g.field6 = :field6")
    , @NamedQuery(name = "GlobProject.findByField7", query = "SELECT g FROM GlobProject g WHERE g.field7 = :field7")
    , @NamedQuery(name = "GlobProject.findByField8", query = "SELECT g FROM GlobProject g WHERE g.field8 = :field8")
    , @NamedQuery(name = "GlobProject.findByProjectClientId", query = "SELECT g FROM GlobProject g WHERE g.projectClientId = :projectClientId")
    , @NamedQuery(name = "GlobProject.findByProjectTypeId", query = "SELECT g FROM GlobProject g WHERE g.projectTypeId = :projectTypeId")
    , @NamedQuery(name = "GlobProject.findByUsesDisciplines", query = "SELECT g FROM GlobProject g WHERE g.usesDisciplines = :usesDisciplines")
    , @NamedQuery(name = "GlobProject.findByUsesBuckets", query = "SELECT g FROM GlobProject g WHERE g.usesBuckets = :usesBuckets")
    , @NamedQuery(name = "GlobProject.findByPweDivision", query = "SELECT g FROM GlobProject g WHERE g.pweDivision = :pweDivision")
    , @NamedQuery(name = "GlobProject.findByPweBranch", query = "SELECT g FROM GlobProject g WHERE g.pweBranch = :pweBranch")
    , @NamedQuery(name = "GlobProject.findByPrimeCip", query = "SELECT g FROM GlobProject g WHERE g.primeCip = :primeCip")
    , @NamedQuery(name = "GlobProject.findBySecondCip", query = "SELECT g FROM GlobProject g WHERE g.secondCip = :secondCip")
    , @NamedQuery(name = "GlobProject.findBySecondGfs", query = "SELECT g FROM GlobProject g WHERE g.secondGfs = :secondGfs")
    , @NamedQuery(name = "GlobProject.findBySecondFunding", query = "SELECT g FROM GlobProject g WHERE g.secondFunding = :secondFunding")
    , @NamedQuery(name = "GlobProject.findByThirdCip", query = "SELECT g FROM GlobProject g WHERE g.thirdCip = :thirdCip")
    , @NamedQuery(name = "GlobProject.findByThirdGfs", query = "SELECT g FROM GlobProject g WHERE g.thirdGfs = :thirdGfs")
    , @NamedQuery(name = "GlobProject.findByThirdFunding", query = "SELECT g FROM GlobProject g WHERE g.thirdFunding = :thirdFunding")
    , @NamedQuery(name = "GlobProject.findByDesignConsultant", query = "SELECT g FROM GlobProject g WHERE g.designConsultant = :designConsultant")
    , @NamedQuery(name = "GlobProject.findByGimsMaps", query = "SELECT g FROM GlobProject g WHERE g.gimsMaps = :gimsMaps")
    , @NamedQuery(name = "GlobProject.findByPDescription", query = "SELECT g FROM GlobProject g WHERE g.pDescription = :pDescription")
    , @NamedQuery(name = "GlobProject.findByAppvChiefEngineer", query = "SELECT g FROM GlobProject g WHERE g.appvChiefEngineer = :appvChiefEngineer")
    , @NamedQuery(name = "GlobProject.findByAppvCopyTo", query = "SELECT g FROM GlobProject g WHERE g.appvCopyTo = :appvCopyTo")
    , @NamedQuery(name = "GlobProject.findByPersonDeputyDirector", query = "SELECT g FROM GlobProject g WHERE g.personDeputyDirector = :personDeputyDirector")
    , @NamedQuery(name = "GlobProject.findByPersonChiefEngineer", query = "SELECT g FROM GlobProject g WHERE g.personChiefEngineer = :personChiefEngineer")
    , @NamedQuery(name = "GlobProject.findByPersonAssistantDirector", query = "SELECT g FROM GlobProject g WHERE g.personAssistantDirector = :personAssistantDirector")
    , @NamedQuery(name = "GlobProject.findByTypeProject", query = "SELECT g FROM GlobProject g WHERE g.typeProject = :typeProject")
    , @NamedQuery(name = "GlobProject.findByCipId", query = "SELECT g FROM GlobProject g WHERE g.cipId = :cipId")
    , @NamedQuery(name = "GlobProject.findByDesignProjectId", query = "SELECT g FROM GlobProject g WHERE g.designProjectId = :designProjectId")
    , @NamedQuery(name = "GlobProject.findByTmpFundsource", query = "SELECT g FROM GlobProject g WHERE g.tmpFundsource = :tmpFundsource")
    , @NamedQuery(name = "GlobProject.findByOwnerId", query = "SELECT g FROM GlobProject g WHERE g.ownerId = :ownerId")
    , @NamedQuery(name = "GlobProject.findByPersonSeniorInspector", query = "SELECT g FROM GlobProject g WHERE g.personSeniorInspector = :personSeniorInspector")
    , @NamedQuery(name = "GlobProject.findByAddTotal", query = "SELECT g FROM GlobProject g WHERE g.addTotal = :addTotal")
    , @NamedQuery(name = "GlobProject.findByCurContractAmount", query = "SELECT g FROM GlobProject g WHERE g.curContractAmount = :curContractAmount")
    , @NamedQuery(name = "GlobProject.findBySupplements", query = "SELECT g FROM GlobProject g WHERE g.supplements = :supplements")
    , @NamedQuery(name = "GlobProject.findByPrimeFundAmount", query = "SELECT g FROM GlobProject g WHERE g.primeFundAmount = :primeFundAmount")
    , @NamedQuery(name = "GlobProject.findBySecondFundAmount", query = "SELECT g FROM GlobProject g WHERE g.secondFundAmount = :secondFundAmount")
    , @NamedQuery(name = "GlobProject.findByThirdFundAmount", query = "SELECT g FROM GlobProject g WHERE g.thirdFundAmount = :thirdFundAmount")
    , @NamedQuery(name = "GlobProject.findByFourthFundAmount", query = "SELECT g FROM GlobProject g WHERE g.fourthFundAmount = :fourthFundAmount")
    , @NamedQuery(name = "GlobProject.findByFifthFundAmount", query = "SELECT g FROM GlobProject g WHERE g.fifthFundAmount = :fifthFundAmount")
    , @NamedQuery(name = "GlobProject.findBySixthFundAmount", query = "SELECT g FROM GlobProject g WHERE g.sixthFundAmount = :sixthFundAmount")
    , @NamedQuery(name = "GlobProject.findByLegalFileNo", query = "SELECT g FROM GlobProject g WHERE g.legalFileNo = :legalFileNo")
    , @NamedQuery(name = "GlobProject.findByCipAmount", query = "SELECT g FROM GlobProject g WHERE g.cipAmount = :cipAmount")
    , @NamedQuery(name = "GlobProject.findByContactNo", query = "SELECT g FROM GlobProject g WHERE g.contactNo = :contactNo")
    , @NamedQuery(name = "GlobProject.findByContractAmount", query = "SELECT g FROM GlobProject g WHERE g.contractAmount = :contractAmount")
    , @NamedQuery(name = "GlobProject.findByContactDays", query = "SELECT g FROM GlobProject g WHERE g.contactDays = :contactDays")
    , @NamedQuery(name = "GlobProject.findByRcaTracking", query = "SELECT g FROM GlobProject g WHERE g.rcaTracking = :rcaTracking")
    , @NamedQuery(name = "GlobProject.findByMwbeGoal", query = "SELECT g FROM GlobProject g WHERE g.mwbeGoal = :mwbeGoal")
    , @NamedQuery(name = "GlobProject.findByBasicPhase1", query = "SELECT g FROM GlobProject g WHERE g.basicPhase1 = :basicPhase1")
    , @NamedQuery(name = "GlobProject.findByBasicPhase2", query = "SELECT g FROM GlobProject g WHERE g.basicPhase2 = :basicPhase2")
    , @NamedQuery(name = "GlobProject.findByBasicPhase3", query = "SELECT g FROM GlobProject g WHERE g.basicPhase3 = :basicPhase3")
    , @NamedQuery(name = "GlobProject.findByBasicTotal", query = "SELECT g FROM GlobProject g WHERE g.basicTotal = :basicTotal")
    , @NamedQuery(name = "GlobProject.findByAddGeotech", query = "SELECT g FROM GlobProject g WHERE g.addGeotech = :addGeotech")
    , @NamedQuery(name = "GlobProject.findByAddSurvey", query = "SELECT g FROM GlobProject g WHERE g.addSurvey = :addSurvey")
    , @NamedQuery(name = "GlobProject.findByAddEnviron", query = "SELECT g FROM GlobProject g WHERE g.addEnviron = :addEnviron")
    , @NamedQuery(name = "GlobProject.findByAddTraffic", query = "SELECT g FROM GlobProject g WHERE g.addTraffic = :addTraffic")
    , @NamedQuery(name = "GlobProject.findByAddSwppp", query = "SELECT g FROM GlobProject g WHERE g.addSwppp = :addSwppp")
    , @NamedQuery(name = "GlobProject.findByAddOther", query = "SELECT g FROM GlobProject g WHERE g.addOther = :addOther")
    , @NamedQuery(name = "GlobProject.findByFourthCip", query = "SELECT g FROM GlobProject g WHERE g.fourthCip = :fourthCip")
    , @NamedQuery(name = "GlobProject.findByFourthGfs", query = "SELECT g FROM GlobProject g WHERE g.fourthGfs = :fourthGfs")
    , @NamedQuery(name = "GlobProject.findByFourthFunding", query = "SELECT g FROM GlobProject g WHERE g.fourthFunding = :fourthFunding")
    , @NamedQuery(name = "GlobProject.findByFifthCip", query = "SELECT g FROM GlobProject g WHERE g.fifthCip = :fifthCip")
    , @NamedQuery(name = "GlobProject.findByFifthGfs", query = "SELECT g FROM GlobProject g WHERE g.fifthGfs = :fifthGfs")
    , @NamedQuery(name = "GlobProject.findByFifthFunding", query = "SELECT g FROM GlobProject g WHERE g.fifthFunding = :fifthFunding")
    , @NamedQuery(name = "GlobProject.findBySixthCip", query = "SELECT g FROM GlobProject g WHERE g.sixthCip = :sixthCip")
    , @NamedQuery(name = "GlobProject.findBySixthGfs", query = "SELECT g FROM GlobProject g WHERE g.sixthGfs = :sixthGfs")
    , @NamedQuery(name = "GlobProject.findBySixthFunding", query = "SELECT g FROM GlobProject g WHERE g.sixthFunding = :sixthFunding")
    , @NamedQuery(name = "GlobProject.findByComments", query = "SELECT g FROM GlobProject g WHERE g.comments = :comments")
    , @NamedQuery(name = "GlobProject.findByOfficeLocation", query = "SELECT g FROM GlobProject g WHERE g.officeLocation = :officeLocation")
    , @NamedQuery(name = "GlobProject.findByDepartmentId", query = "SELECT g FROM GlobProject g WHERE g.departmentId = :departmentId")
    , @NamedQuery(name = "GlobProject.findByProjectCode", query = "SELECT g FROM GlobProject g WHERE g.projectCode = :projectCode")
    , @NamedQuery(name = "GlobProject.findByProjectManager", query = "SELECT g FROM GlobProject g WHERE g.projectManager = :projectManager")
    , @NamedQuery(name = "GlobProject.findByDirections", query = "SELECT g FROM GlobProject g WHERE g.directions = :directions")
    , @NamedQuery(name = "GlobProject.findByKeymap", query = "SELECT g FROM GlobProject g WHERE g.keymap = :keymap")
    , @NamedQuery(name = "GlobProject.findByCertification", query = "SELECT g FROM GlobProject g WHERE g.certification = :certification")
    , @NamedQuery(name = "GlobProject.findByPoNumber", query = "SELECT g FROM GlobProject g WHERE g.poNumber = :poNumber")
    , @NamedQuery(name = "GlobProject.findByDistribution", query = "SELECT g FROM GlobProject g WHERE g.distribution = :distribution")
    , @NamedQuery(name = "GlobProject.findByContractor", query = "SELECT g FROM GlobProject g WHERE g.contractor = :contractor")
    , @NamedQuery(name = "GlobProject.findByHasFlags", query = "SELECT g FROM GlobProject g WHERE g.hasFlags = :hasFlags")
    , @NamedQuery(name = "GlobProject.findByFlagId", query = "SELECT g FROM GlobProject g WHERE g.flagId = :flagId")
    , @NamedQuery(name = "GlobProject.findByUsesSignature", query = "SELECT g FROM GlobProject g WHERE g.usesSignature = :usesSignature")
    , @NamedQuery(name = "GlobProject.findByApprovalLevel", query = "SELECT g FROM GlobProject g WHERE g.approvalLevel = :approvalLevel")
    , @NamedQuery(name = "GlobProject.findByPManagedBy", query = "SELECT g FROM GlobProject g WHERE g.pManagedBy = :pManagedBy")
    , @NamedQuery(name = "GlobProject.findByRegion", query = "SELECT g FROM GlobProject g WHERE g.region = :region")
    , @NamedQuery(name = "GlobProject.findByFunction", query = "SELECT g FROM GlobProject g WHERE g.function = :function")
    , @NamedQuery(name = "GlobProject.findByPartnering", query = "SELECT g FROM GlobProject g WHERE g.partnering = :partnering")
    , @NamedQuery(name = "GlobProject.findByFieldOfficeNumber", query = "SELECT g FROM GlobProject g WHERE g.fieldOfficeNumber = :fieldOfficeNumber")
    , @NamedQuery(name = "GlobProject.findByNotificationType", query = "SELECT g FROM GlobProject g WHERE g.notificationType = :notificationType")
    , @NamedQuery(name = "GlobProject.findByAmendments", query = "SELECT g FROM GlobProject g WHERE g.amendments = :amendments")
    , @NamedQuery(name = "GlobProject.findByProgramId", query = "SELECT g FROM GlobProject g WHERE g.programId = :programId")
    , @NamedQuery(name = "GlobProject.findByPersonProjectManager", query = "SELECT g FROM GlobProject g WHERE g.personProjectManager = :personProjectManager")
    , @NamedQuery(name = "GlobProject.findByZip", query = "SELECT g FROM GlobProject g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobProject.findByPhase", query = "SELECT g FROM GlobProject g WHERE g.phase = :phase")
    , @NamedQuery(name = "GlobProject.findByLocationCoordinates", query = "SELECT g FROM GlobProject g WHERE g.locationCoordinates = :locationCoordinates")
    , @NamedQuery(name = "GlobProject.findByLogoLink", query = "SELECT g FROM GlobProject g WHERE g.logoLink = :logoLink")
    , @NamedQuery(name = "GlobProject.findByContractorId", query = "SELECT g FROM GlobProject g WHERE g.contractorId = :contractorId")
    , @NamedQuery(name = "GlobProject.findByPersonChiefDiscEngineer", query = "SELECT g FROM GlobProject g WHERE g.personChiefDiscEngineer = :personChiefDiscEngineer")
    , @NamedQuery(name = "GlobProject.findByPersonEnvironmental", query = "SELECT g FROM GlobProject g WHERE g.personEnvironmental = :personEnvironmental")
    , @NamedQuery(name = "GlobProject.findByPersonLegal", query = "SELECT g FROM GlobProject g WHERE g.personLegal = :personLegal")
    , @NamedQuery(name = "GlobProject.findByWebcamLink", query = "SELECT g FROM GlobProject g WHERE g.webcamLink = :webcamLink")
    , @NamedQuery(name = "GlobProject.findByPersonDirector", query = "SELECT g FROM GlobProject g WHERE g.personDirector = :personDirector")
    , @NamedQuery(name = "GlobProject.findByScope", query = "SELECT g FROM GlobProject g WHERE g.scope = :scope")
    , @NamedQuery(name = "GlobProject.findByLimits", query = "SELECT g FROM GlobProject g WHERE g.limits = :limits")
    , @NamedQuery(name = "GlobProject.findByTitle", query = "SELECT g FROM GlobProject g WHERE g.title = :title")
    , @NamedQuery(name = "GlobProject.findByPhoneCell", query = "SELECT g FROM GlobProject g WHERE g.phoneCell = :phoneCell")
    , @NamedQuery(name = "GlobProject.findByCipProject", query = "SELECT g FROM GlobProject g WHERE g.cipProject = :cipProject")
    , @NamedQuery(name = "GlobProject.findByCipNo", query = "SELECT g FROM GlobProject g WHERE g.cipNo = :cipNo")
    , @NamedQuery(name = "GlobProject.findByPersonEngineer", query = "SELECT g FROM GlobProject g WHERE g.personEngineer = :personEngineer")
    , @NamedQuery(name = "GlobProject.findByPersonAdministrator", query = "SELECT g FROM GlobProject g WHERE g.personAdministrator = :personAdministrator")
    , @NamedQuery(name = "GlobProject.findByPersonProjectDirector", query = "SELECT g FROM GlobProject g WHERE g.personProjectDirector = :personProjectDirector")
    , @NamedQuery(name = "GlobProject.findByCityInspector", query = "SELECT g FROM GlobProject g WHERE g.cityInspector = :cityInspector")
    , @NamedQuery(name = "GlobProject.findByLocationKey", query = "SELECT g FROM GlobProject g WHERE g.locationKey = :locationKey")
    , @NamedQuery(name = "GlobProject.findByUnits", query = "SELECT g FROM GlobProject g WHERE g.units = :units")
    , @NamedQuery(name = "GlobProject.findByAddress", query = "SELECT g FROM GlobProject g WHERE g.address = :address")
    , @NamedQuery(name = "GlobProject.findBySegmentWorkareaType", query = "SELECT g FROM GlobProject g WHERE g.segmentWorkareaType = :segmentWorkareaType")
    , @NamedQuery(name = "GlobProject.findByCountry", query = "SELECT g FROM GlobProject g WHERE g.country = :country")
    , @NamedQuery(name = "GlobProject.findByAsphaltManagerId", query = "SELECT g FROM GlobProject g WHERE g.asphaltManagerId = :asphaltManagerId")
    , @NamedQuery(name = "GlobProject.findByContact2", query = "SELECT g FROM GlobProject g WHERE g.contact2 = :contact2")
    , @NamedQuery(name = "GlobProject.findByPhone2", query = "SELECT g FROM GlobProject g WHERE g.phone2 = :phone2")
    , @NamedQuery(name = "GlobProject.findByContact3", query = "SELECT g FROM GlobProject g WHERE g.contact3 = :contact3")
    , @NamedQuery(name = "GlobProject.findByPhone3", query = "SELECT g FROM GlobProject g WHERE g.phone3 = :phone3")
    , @NamedQuery(name = "GlobProject.findByCommentsEngineering", query = "SELECT g FROM GlobProject g WHERE g.commentsEngineering = :commentsEngineering")
    , @NamedQuery(name = "GlobProject.findByPdaType", query = "SELECT g FROM GlobProject g WHERE g.pdaType = :pdaType")
    , @NamedQuery(name = "GlobProject.findByCreditHold", query = "SELECT g FROM GlobProject g WHERE g.creditHold = :creditHold")
    , @NamedQuery(name = "GlobProject.findByFundSourceOther2", query = "SELECT g FROM GlobProject g WHERE g.fundSourceOther2 = :fundSourceOther2")
    , @NamedQuery(name = "GlobProject.findBySoilClassificationCatId", query = "SELECT g FROM GlobProject g WHERE g.soilClassificationCatId = :soilClassificationCatId")
    , @NamedQuery(name = "GlobProject.findByPhoneMain2", query = "SELECT g FROM GlobProject g WHERE g.phoneMain2 = :phoneMain2")
    , @NamedQuery(name = "GlobProject.findByPhoneMain3", query = "SELECT g FROM GlobProject g WHERE g.phoneMain3 = :phoneMain3")
    , @NamedQuery(name = "GlobProject.findByPriority", query = "SELECT g FROM GlobProject g WHERE g.priority = :priority")
    , @NamedQuery(name = "GlobProject.findByAddress2", query = "SELECT g FROM GlobProject g WHERE g.address2 = :address2")
    , @NamedQuery(name = "GlobProject.findByFundSourceOther1", query = "SELECT g FROM GlobProject g WHERE g.fundSourceOther1 = :fundSourceOther1")
    , @NamedQuery(name = "GlobProject.findByFundSourceOther3", query = "SELECT g FROM GlobProject g WHERE g.fundSourceOther3 = :fundSourceOther3")
    , @NamedQuery(name = "GlobProject.findByFundSourceOther4", query = "SELECT g FROM GlobProject g WHERE g.fundSourceOther4 = :fundSourceOther4")
    , @NamedQuery(name = "GlobProject.findByFundAmount0", query = "SELECT g FROM GlobProject g WHERE g.fundAmount0 = :fundAmount0")
    , @NamedQuery(name = "GlobProject.findByFundAmount1", query = "SELECT g FROM GlobProject g WHERE g.fundAmount1 = :fundAmount1")
    , @NamedQuery(name = "GlobProject.findByFundAmount2", query = "SELECT g FROM GlobProject g WHERE g.fundAmount2 = :fundAmount2")
    , @NamedQuery(name = "GlobProject.findByFundAmount3", query = "SELECT g FROM GlobProject g WHERE g.fundAmount3 = :fundAmount3")
    , @NamedQuery(name = "GlobProject.findByFundAmount4", query = "SELECT g FROM GlobProject g WHERE g.fundAmount4 = :fundAmount4")
    , @NamedQuery(name = "GlobProject.findByFundSourceEligible", query = "SELECT g FROM GlobProject g WHERE g.fundSourceEligible = :fundSourceEligible")
    , @NamedQuery(name = "GlobProject.findByStartDateTmp", query = "SELECT g FROM GlobProject g WHERE g.startDateTmp = :startDateTmp")
    , @NamedQuery(name = "GlobProject.findByAwardOrdinanceDateTmp", query = "SELECT g FROM GlobProject g WHERE g.awardOrdinanceDateTmp = :awardOrdinanceDateTmp")
    , @NamedQuery(name = "GlobProject.findByBidDateTmp", query = "SELECT g FROM GlobProject g WHERE g.bidDateTmp = :bidDateTmp")
    , @NamedQuery(name = "GlobProject.findByEndDateTmp", query = "SELECT g FROM GlobProject g WHERE g.endDateTmp = :endDateTmp")
    , @NamedQuery(name = "GlobProject.findByLastModTmp", query = "SELECT g FROM GlobProject g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobProject.findByTempTmp", query = "SELECT g FROM GlobProject g WHERE g.tempTmp = :tempTmp")
    , @NamedQuery(name = "GlobProject.findByCreateDateTmp", query = "SELECT g FROM GlobProject g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobProject.findByPDateTmp", query = "SELECT g FROM GlobProject g WHERE g.pDateTmp = :pDateTmp")
    , @NamedQuery(name = "GlobProject.findByRegionId", query = "SELECT g FROM GlobProject g WHERE g.regionId = :regionId")
    , @NamedQuery(name = "GlobProject.findByShowAnnualReview", query = "SELECT g FROM GlobProject g WHERE g.showAnnualReview = :showAnnualReview")
    , @NamedQuery(name = "GlobProject.findByBondFund", query = "SELECT g FROM GlobProject g WHERE g.bondFund = :bondFund")
    , @NamedQuery(name = "GlobProject.findByOldAccNo", query = "SELECT g FROM GlobProject g WHERE g.oldAccNo = :oldAccNo")
    , @NamedQuery(name = "GlobProject.findByAccNo", query = "SELECT g FROM GlobProject g WHERE g.accNo = :accNo")
    , @NamedQuery(name = "GlobProject.findByReqCompDate", query = "SELECT g FROM GlobProject g WHERE g.reqCompDate = :reqCompDate")
    , @NamedQuery(name = "GlobProject.findByEstStartDate", query = "SELECT g FROM GlobProject g WHERE g.estStartDate = :estStartDate")
    , @NamedQuery(name = "GlobProject.findByHasLab", query = "SELECT g FROM GlobProject g WHERE g.hasLab = :hasLab")
    , @NamedQuery(name = "GlobProject.findByCostToDate", query = "SELECT g FROM GlobProject g WHERE g.costToDate = :costToDate")
    , @NamedQuery(name = "GlobProject.findByPApinNo", query = "SELECT g FROM GlobProject g WHERE g.pApinNo = :pApinNo")
    , @NamedQuery(name = "GlobProject.findByPJobNo", query = "SELECT g FROM GlobProject g WHERE g.pJobNo = :pJobNo")
    , @NamedQuery(name = "GlobProject.findByPAc", query = "SELECT g FROM GlobProject g WHERE g.pAc = :pAc")
    , @NamedQuery(name = "GlobProject.findByPClass", query = "SELECT g FROM GlobProject g WHERE g.pClass = :pClass")
    , @NamedQuery(name = "GlobProject.findByPPhase", query = "SELECT g FROM GlobProject g WHERE g.pPhase = :pPhase")
    , @NamedQuery(name = "GlobProject.findByOwner", query = "SELECT g FROM GlobProject g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobProject.findByOwnerFk", query = "SELECT g FROM GlobProject g WHERE g.ownerFk = :ownerFk")
    , @NamedQuery(name = "GlobProject.findByPlanningProjectId", query = "SELECT g FROM GlobProject g WHERE g.planningProjectId = :planningProjectId")
    , @NamedQuery(name = "GlobProject.findByVersion", query = "SELECT g FROM GlobProject g WHERE g.version = :version")
    , @NamedQuery(name = "GlobProject.findByLastMod", query = "SELECT g FROM GlobProject g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobProject.findByTestlogShowacknowledge", query = "SELECT g FROM GlobProject g WHERE g.testlogShowacknowledge = :testlogShowacknowledge")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProject.findAll", query = "SELECT g FROM GlobProject g"),
    @NamedQuery(name = "GlobProject.findById", query = "SELECT g FROM GlobProject g WHERE g.id = :id"),
    @NamedQuery(name = "GlobProject.findByName", query = "SELECT g FROM GlobProject g WHERE g.name = :name"),
    @NamedQuery(name = "GlobProject.findByClientPNumber", query = "SELECT g FROM GlobProject g WHERE g.pNumber = :pNumber AND g.clientId.id = :clientId")})
public class GlobProject implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "GLOB_PROJECT_ID_SEQ", sequenceName = "GLOB_PROJECT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJECT_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "ESTIMATED_COST")
    private String estimatedCost;
    @Size(max = 50)
    @Column(name = "CONTACT")
    private String contact;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CELL")
    private String cell;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 4000)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "ACTIVE")
    private Character active;
    @JsonIgnore
    @Column(name = "LAST_MOD_TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModTemp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @JsonIgnore
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "COMPANY_ID")
    private BigInteger companyId;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "P_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pDate;
    @Size(max = 15)
    @Column(name = "P_TYPE")
    private String pType;
    @Column(name = "BID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDate;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FILE_NO")
    private String fileNo;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUNDS_NO")
    private String fundsNo;
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FUNDS_SOURCE")
    private String fundsSource;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "COUNCIL_DIST")
    private String councilDist;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "ASSISTANT_DIRECTOR_ID")
    private String assistantDirectorId;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CHIEF_ENGINEER_ID")
    private String chiefEngineerId;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "SENIOR_INSPECTOR_ID")
    private String seniorInspectorId;
    @Size(max = 25)
    @Column(name = "CUIC_NO")
    private String cuicNo;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "RECIEVED_CONTRACTS")
    private String recievedContracts;
    @JsonIgnore
    @Size(max = 25)
    @Column(name = "AWARD_ORDINANCE_NUM")
    private String awardOrdinanceNum;
    @JsonIgnore
    @Column(name = "AWARD_ORDINANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date awardOrdinanceDate;
    @Size(max = 50)
    @Column(name = "CONTACT_ID")
    private String contactId;
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "HOMEDIRECTORY")
    private String homedirectory;
    @Size(max = 50)
    @Column(name = "P_STATUS")
    private String pStatus;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD5")
    private String field5;
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD6")
    private String field6;
    @JsonIgnore
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @JsonIgnore
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Column(name = "PROJECT_CLIENT_ID")
    private BigInteger projectClientId;
    @Column(name = "PROJECT_TYPE_ID")
    private BigInteger projectTypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USES_DISCIPLINES")
    private Character usesDisciplines;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USES_BUCKETS")
    private Character usesBuckets;
    @JsonIgnore
    @Size(max = 150)
    @Column(name = "PWE_DIVISION")
    private String pweDivision;
    @JsonIgnore
    @Size(max = 150)
    @Column(name = "PWE_BRANCH")
    private String pweBranch;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "PRIME_CIP")
    private String primeCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "SECOND_CIP")
    private String secondCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "SECOND_GFS")
    private String secondGfs;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "SECOND_FUNDING")
    private String secondFunding;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "THIRD_CIP")
    private String thirdCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "THIRD_GFS")
    private String thirdGfs;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "THIRD_FUNDING")
    private String thirdFunding;
    @JsonIgnore
    @Column(name = "DESIGN_CONSULTANT")
    private BigInteger designConsultant;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "GIMS_MAPS")
    private String gimsMaps;
    @Size(max = 4000)
    @Column(name = "P_DESCRIPTION")
    private String pDescription;
    @Column(name = "APPV_CHIEF_ENGINEER")
    private BigInteger appvChiefEngineer;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "APPV_COPY_TO")
    private String appvCopyTo;
    @JsonIgnore
    @Column(name = "PERSON_DEPUTY_DIRECTOR")
    private BigInteger personDeputyDirector;
    @JsonIgnore
    @Column(name = "PERSON_CHIEF_ENGINEER")
    private BigInteger personChiefEngineer;
    @JsonIgnore
    @Column(name = "PERSON_ASSISTANT_DIRECTOR")
    private BigInteger personAssistantDirector;
    @Size(max = 250)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Column(name = "CIP_ID")
    private BigInteger cipId;
    @Column(name = "DESIGN_PROJECT_ID")
    private BigInteger designProjectId;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "TMP_FUNDSOURCE")
    private String tmpFundsource;
    @JsonIgnore
    @Column(name = "OWNER_ID")
    private BigInteger ownerId;
    @Column(name = "PERSON_SENIOR_INSPECTOR")
    private BigInteger personSeniorInspector;
    @Column(name = "ADD_TOTAL")
    private Double addTotal;
    @Column(name = "CUR_CONTRACT_AMOUNT")
    private Double curContractAmount;
    @JsonIgnore
    @Column(name = "SUPPLEMENTS")
    private Double supplements;
    @JsonIgnore
    @Column(name = "PRIME_FUND_AMOUNT")
    private Double primeFundAmount;
    @JsonIgnore
    @Column(name = "SECOND_FUND_AMOUNT")
    private Double secondFundAmount;
    @JsonIgnore
    @Column(name = "THIRD_FUND_AMOUNT")
    private Double thirdFundAmount;
    @JsonIgnore
    @Column(name = "FOURTH_FUND_AMOUNT")
    private Double fourthFundAmount;
    @JsonIgnore
    @Column(name = "FIFTH_FUND_AMOUNT")
    private Double fifthFundAmount;
    @JsonIgnore
    @Column(name = "SIXTH_FUND_AMOUNT")
    private Double sixthFundAmount;
    @JsonIgnore
    @Size(max = 150)
    @Column(name = "LEGAL_FILE_NO")
    private String legalFileNo;
    @JsonIgnore
    @Column(name = "CIP_AMOUNT")
    private Double cipAmount;
    @Size(max = 150)
    @Column(name = "CONTACT_NO")
    private String contactNo;
    @Column(name = "CONTRACT_AMOUNT")
    private Double contractAmount;
    @Column(name = "CONTACT_DAYS")
    private BigInteger contactDays;
    @JsonIgnore
    @Size(max = 150)
    @Column(name = "RCA_TRACKING")
    private String rcaTracking;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "MWBE_GOAL")
    private String mwbeGoal;
    @JsonIgnore
    @Column(name = "BASIC_PHASE1")
    private Double basicPhase1;
    @JsonIgnore
    @Column(name = "BASIC_PHASE2")
    private Double basicPhase2;
    @JsonIgnore
    @Column(name = "BASIC_PHASE3")
    private Double basicPhase3;
    @JsonIgnore
    @Column(name = "BASIC_TOTAL")
    private Double basicTotal;
    @JsonIgnore
    @Column(name = "ADD_GEOTECH")
    private Double addGeotech;
    @JsonIgnore
    @Column(name = "ADD_SURVEY")
    private Double addSurvey;
    @JsonIgnore
    @Column(name = "ADD_ENVIRON")
    private Double addEnviron;
    @JsonIgnore
    @Column(name = "ADD_TRAFFIC")
    private Double addTraffic;
    @JsonIgnore
    @Column(name = "ADD_SWPPP")
    private Double addSwppp;
    @JsonIgnore
    @Column(name = "ADD_OTHER")
    private Double addOther;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "FOURTH_CIP")
    private String fourthCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "FOURTH_GFS")
    private String fourthGfs;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "FOURTH_FUNDING")
    private String fourthFunding;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "FIFTH_CIP")
    private String fifthCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "FIFTH_GFS")
    private String fifthGfs;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "FIFTH_FUNDING")
    private String fifthFunding;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "SIXTH_CIP")
    private String sixthCip;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "SIXTH_GFS")
    private String sixthGfs;
    @JsonIgnore
    @Size(max = 250)
    @Column(name = "SIXTH_FUNDING")
    private String sixthFunding;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumn(name = "OFFICE_LOCATION", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private GlobClientOfficeLocation officeLocation;
    /*@Size(max = 10)
    @Column(name = "OFFICE_LOCATION")
    private String officeLocation;*/
    @Size(max = 10)
    @Column(name = "DEPARTMENT_ID")
    private String departmentId;
    @Size(max = 50)
    @Column(name = "PROJECT_CODE")
    private String projectCode;
    @Size(max = 4000)
    @Column(name = "PROJECT_MANAGER")
    private String projectManager;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "DIRECTIONS")
    private String directions;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "KEYMAP")
    private String keymap;
    @Size(max = 1)
    @Column(name = "CERTIFICATION")
    private String certification;
    @Size(max = 50)
    @Column(name = "PO_NUMBER")
    private String poNumber;
    @Size(max = 4000)
    @Column(name = "DISTRIBUTION")
    private String distribution;
    @Size(max = 4000)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Column(name = "HAS_FLAGS")
    private Character hasFlags;
    @Column(name = "FLAG_ID")
    private BigInteger flagId;
    @Column(name = "USES_SIGNATURE")
    private Character usesSignature;
    @Column(name = "APPROVAL_LEVEL")
    private BigInteger approvalLevel;
    @Size(max = 250)
    @Column(name = "P_MANAGED_BY")
    private String pManagedBy;
    @Size(max = 100)
    @Column(name = "REGION")
    private String region;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "PARTNERING")
    private Character partnering;
    @Size(max = 20)
    @Column(name = "FIELD_OFFICE_NUMBER")
    private String fieldOfficeNumber;
    @Size(max = 255)
    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;
    @Column(name = "AMENDMENTS")
    private Double amendments;
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Column(name = "PERSON_PROJECT_MANAGER")
    private BigInteger personProjectManager;
    @Column(name = "ZIP")
    private Integer zip;
    @Size(max = 50)
    @Column(name = "PHASE")
    private String phase;
    @Size(max = 50)
    @Column(name = "LOCATION_COORDINATES")
    private String locationCoordinates;
    @Size(max = 512)
    @Column(name = "LOGO_LINK")
    private String logoLink;
    @JoinColumn(name = "CONTRACTOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private GlobContractorPersonnel contractorId;
    @Column(name = "PERSON_CHIEF_DISC_ENGINEER")
    private BigInteger personChiefDiscEngineer;
    @Size(max = 100)
    @Column(name = "PERSON_ENVIRONMENTAL")
    private String personEnvironmental;
    @Size(max = 100)
    @Column(name = "PERSON_LEGAL")
    private String personLegal;
    @JsonIgnore
    @Size(max = 512)
    @Column(name = "WEBCAM_LINK")
    private String webcamLink;
    @Column(name = "PERSON_DIRECTOR")
    private BigInteger personDirector;
    @JsonIgnore
    @Size(max = 256)
    @Column(name = "SCOPE")
    private String scope;
    @JsonIgnore
    @Size(max = 256)
    @Column(name = "LIMITS")
    private String limits;
    @Size(max = 256)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 256)
    @Column(name = "PHONE_CELL")
    private String phoneCell;
    @Size(max = 256)
    @Column(name = "CIP_PROJECT")
    private String cipProject;
    @Size(max = 256)
    @Column(name = "CIP_NO")
    private String cipNo;
    @Column(name = "PERSON_ENGINEER")
    private BigInteger personEngineer;
    @Column(name = "PERSON_ADMINISTRATOR")
    private BigInteger personAdministrator;
    @Column(name = "PERSON_PROJECT_DIRECTOR")
    private BigInteger personProjectDirector;
    @Size(max = 255)
    @Column(name = "CITY_INSPECTOR")
    private String cityInspector;
    @Size(max = 255)
    @Column(name = "LOCATION_KEY")
    private String locationKey;
    @Size(max = 50)
    @Column(name = "UNITS")
    private String units;
    @Size(max = 4000)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "SEGMENT_WORKAREA_TYPE")
    private String segmentWorkareaType;
    @Size(max = 255)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ASPHALT_MANAGER_ID")
    private BigInteger asphaltManagerId;
    @Size(max = 50)
    @Column(name = "CONTACT2")
    private String contact2;
    @Size(max = 50)
    @Column(name = "PHONE2")
    private String phone2;
    @Size(max = 50)
    @Column(name = "CONTACT3")
    private String contact3;
    @Size(max = 50)
    @Column(name = "PHONE3")
    private String phone3;
    @Size(max = 4000)
    @Column(name = "COMMENTS_ENGINEERING")
    private String commentsEngineering;
    @Size(max = 50)
    @Column(name = "PDA_TYPE")
    private String pdaType;
    @Column(name = "CREDIT_HOLD")
    private Character creditHold;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER2")
    private String fundSourceOther2;
    @Column(name = "SOIL_CLASSIFICATION_CAT_ID")
    private BigInteger soilClassificationCatId;
    @Size(max = 50)
    @Column(name = "PHONE_MAIN2")
    private String phoneMain2;
    @Size(max = 50)
    @Column(name = "PHONE_MAIN3")
    private String phoneMain3;
    @Size(max = 255)
    @Column(name = "PRIORITY")
    private String priority;
    @Size(max = 4000)
    @Column(name = "ADDRESS2")
    private String address2;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER1")
    private String fundSourceOther1;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER3")
    private String fundSourceOther3;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_OTHER4")
    private String fundSourceOther4;
    @JsonIgnore
    @Column(name = "FUND_AMOUNT0")
    private BigInteger fundAmount0;
    @JsonIgnore
    @Column(name = "FUND_AMOUNT1")
    private BigInteger fundAmount1;
    @JsonIgnore
    @Column(name = "FUND_AMOUNT2")
    private BigInteger fundAmount2;
    @JsonIgnore
    @Column(name = "FUND_AMOUNT3")
    private BigInteger fundAmount3;
    @JsonIgnore
    @Column(name = "FUND_AMOUNT4")
    private BigInteger fundAmount4;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FUND_SOURCE_ELIGIBLE")
    private String fundSourceEligible;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "START_DATE_TMP")
    private String startDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "AWARD_ORDINANCE_DATE_TMP")
    private String awardOrdinanceDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "BID_DATE_TMP")
    private String bidDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "END_DATE_TMP")
    private String endDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "P_DATE_TMP")
    private String pDateTmp;
    @JoinColumn(name = "REGION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private GlobClientRegions regionId;
    @JsonIgnore
    @Size(max = 1)
    @Column(name = "SHOW_ANNUAL_REVIEW")
    private String showAnnualReview;
    @JsonIgnore
    @Size(max = 128)
    @Column(name = "BOND_FUND")
    private String bondFund;
    @JsonIgnore
    @Size(max = 128)
    @Column(name = "OLD_ACC_NO")
    private String oldAccNo;
    @Size(max = 128)
    @Column(name = "ACC_NO")
    private String accNo;
    @Column(name = "REQ_COMP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reqCompDate;
    @Column(name = "EST_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estStartDate;
    @Column(name = "HAS_LAB")
    private Character hasLab;
    @Column(name = "COST_TO_DATE")
    private Double costToDate;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "P_APIN_NO")
    private String pApinNo;
    @Size(max = 256)
    @Column(name = "P_JOB_NO")
    private String pJobNo;
    @JsonIgnore
    @Column(name = "P_AC")
    private Double pAc;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "P_CLASS")
    private String pClass;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "P_PHASE")
    private String pPhase;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "OWNER")
    private String owner;
    @JsonIgnore
    @Column(name = "OWNER_FK")
    private BigInteger ownerFk;
    @JsonIgnore
    @Column(name = "PLANNING_PROJECT_ID")
    private BigInteger planningProjectId;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 50)
    @Column(name = "PROPOSAL_NUMBER")
    private String proposalNumber;
    @Column(name = "TESTLOG_SHOWACKNOWLEDGE")
    private Character testlogShowacknowledge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<CmEmEmail> cmEmEmailList;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobClient clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<CmEmDocument> cmEmDocumentList;
    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<GlobCorrespd> globCorrespdList;

    /*@OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<GlobProjectSupplier> globProjectSupplierList;
    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<GlobProjContrPersonnel> globProjContrPersonnelList;*/
    
    @Column(name = "OTHER_CONTACT_NAME_1")
    private String otherContactName1;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Column(name = "OTHER_CONTACT_TELEPHONE_1")
    private String otherContactTelephone1;
    public GlobProject() {
    }

    public GlobProject(BigDecimal id) {
        this.id = id;
    }

    public GlobProject(BigDecimal id, String name, String description, String estimatedCost, String contact, String phone, String cell, String fax, String email, String location, Date startDate, Date endDate, Date createDate, BigInteger companyId, String pNumber, String pName, String pType, Character usesDisciplines, Character usesBuckets, String version, String lastMod) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.contact = contact;
        this.phone = phone;
        this.cell = cell;
        this.fax = fax;
        this.email = email;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.companyId = companyId;
        this.pNumber = pNumber;
        this.pName = pName;
        this.pType = pType;
        this.usesDisciplines = usesDisciplines;
        this.usesBuckets = usesBuckets;
        this.version = version;
        this.lastMod = lastMod;
    }

    public GlobProject(BigDecimal id, Character usesDisciplines, Character usesBuckets) {
        this.id = id;
        this.usesDisciplines = usesDisciplines;
        this.usesBuckets = usesBuckets;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastModTemp() {
        return lastModTemp;
    }

    public void setLastModTemp(Date lastModTemp) {
        this.lastModTemp = lastModTemp;
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigInteger getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigInteger companyId) {
        this.companyId = companyId;
    }

    @JsonProperty("pNumber")
    public String getPNumber() {
        return pNumber;
    }

    public void setPNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getPDate() {
        return pDate;
    }

    public void setPDate(Date pDate) {
        this.pDate = pDate;
    }

    @JsonProperty("pType")
    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getFundsNo() {
        return fundsNo;
    }

    public void setFundsNo(String fundsNo) {
        this.fundsNo = fundsNo;
    }

    public String getFundsSource() {
        return fundsSource;
    }

    public void setFundsSource(String fundsSource) {
        this.fundsSource = fundsSource;
    }

    public String getCouncilDist() {
        return councilDist;
    }

    public void setCouncilDist(String councilDist) {
        this.councilDist = councilDist;
    }

    public String getAssistantDirectorId() {
        return assistantDirectorId;
    }

    public void setAssistantDirectorId(String assistantDirectorId) {
        this.assistantDirectorId = assistantDirectorId;
    }

    public String getChiefEngineerId() {
        return chiefEngineerId;
    }

    public void setChiefEngineerId(String chiefEngineerId) {
        this.chiefEngineerId = chiefEngineerId;
    }

    public String getSeniorInspectorId() {
        return seniorInspectorId;
    }

    public void setSeniorInspectorId(String seniorInspectorId) {
        this.seniorInspectorId = seniorInspectorId;
    }

    public String getCuicNo() {
        return cuicNo;
    }

    public void setCuicNo(String cuicNo) {
        this.cuicNo = cuicNo;
    }

    public String getRecievedContracts() {
        return recievedContracts;
    }

    public void setRecievedContracts(String recievedContracts) {
        this.recievedContracts = recievedContracts;
    }

    public String getAwardOrdinanceNum() {
        return awardOrdinanceNum;
    }

    public void setAwardOrdinanceNum(String awardOrdinanceNum) {
        this.awardOrdinanceNum = awardOrdinanceNum;
    }

    public Date getAwardOrdinanceDate() {
        return awardOrdinanceDate;
    }

    public void setAwardOrdinanceDate(Date awardOrdinanceDate) {
        this.awardOrdinanceDate = awardOrdinanceDate;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getHomedirectory() {
        return homedirectory;
    }

    public void setHomedirectory(String homedirectory) {
        this.homedirectory = homedirectory;
    }

    public String getPStatus() {
        return pStatus;
    }

    public void setPStatus(String pStatus) {
        this.pStatus = pStatus;
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

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
    }

    public BigInteger getProjectClientId() {
        return projectClientId;
    }

    public void setProjectClientId(BigInteger projectClientId) {
        this.projectClientId = projectClientId;
    }

    public BigInteger getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(BigInteger projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public Character getUsesDisciplines() {
        return usesDisciplines;
    }

    public void setUsesDisciplines(Character usesDisciplines) {
        this.usesDisciplines = usesDisciplines;
    }

    public Character getUsesBuckets() {
        return usesBuckets;
    }

    public void setUsesBuckets(Character usesBuckets) {
        this.usesBuckets = usesBuckets;
    }

    public String getPweDivision() {
        return pweDivision;
    }

    public void setPweDivision(String pweDivision) {
        this.pweDivision = pweDivision;
    }

    public String getPweBranch() {
        return pweBranch;
    }

    public void setPweBranch(String pweBranch) {
        this.pweBranch = pweBranch;
    }

    public String getPrimeCip() {
        return primeCip;
    }

    public void setPrimeCip(String primeCip) {
        this.primeCip = primeCip;
    }

    public String getSecondCip() {
        return secondCip;
    }

    public void setSecondCip(String secondCip) {
        this.secondCip = secondCip;
    }

    public String getSecondGfs() {
        return secondGfs;
    }

    public void setSecondGfs(String secondGfs) {
        this.secondGfs = secondGfs;
    }

    public String getSecondFunding() {
        return secondFunding;
    }

    public void setSecondFunding(String secondFunding) {
        this.secondFunding = secondFunding;
    }

    public String getThirdCip() {
        return thirdCip;
    }

    public void setThirdCip(String thirdCip) {
        this.thirdCip = thirdCip;
    }

    public String getThirdGfs() {
        return thirdGfs;
    }

    public void setThirdGfs(String thirdGfs) {
        this.thirdGfs = thirdGfs;
    }

    public String getThirdFunding() {
        return thirdFunding;
    }

    public void setThirdFunding(String thirdFunding) {
        this.thirdFunding = thirdFunding;
    }

    public BigInteger getDesignConsultant() {
        return designConsultant;
    }

    public void setDesignConsultant(BigInteger designConsultant) {
        this.designConsultant = designConsultant;
    }

    public String getGimsMaps() {
        return gimsMaps;
    }

    public void setGimsMaps(String gimsMaps) {
        this.gimsMaps = gimsMaps;
    }

    @JsonProperty("pDescription")
    public String getPDescription() {
        return pDescription;
    }

    public void setPDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public BigInteger getAppvChiefEngineer() {
        return appvChiefEngineer;
    }

    public void setAppvChiefEngineer(BigInteger appvChiefEngineer) {
        this.appvChiefEngineer = appvChiefEngineer;
    }

    public String getAppvCopyTo() {
        return appvCopyTo;
    }

    public void setAppvCopyTo(String appvCopyTo) {
        this.appvCopyTo = appvCopyTo;
    }

    public BigInteger getPersonDeputyDirector() {
        return personDeputyDirector;
    }

    public void setPersonDeputyDirector(BigInteger personDeputyDirector) {
        this.personDeputyDirector = personDeputyDirector;
    }

    public BigInteger getPersonChiefEngineer() {
        return personChiefEngineer;
    }

    public void setPersonChiefEngineer(BigInteger personChiefEngineer) {
        this.personChiefEngineer = personChiefEngineer;
    }

    public BigInteger getPersonAssistantDirector() {
        return personAssistantDirector;
    }

    public void setPersonAssistantDirector(BigInteger personAssistantDirector) {
        this.personAssistantDirector = personAssistantDirector;
    }

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }

    public BigInteger getCipId() {
        return cipId;
    }

    public void setCipId(BigInteger cipId) {
        this.cipId = cipId;
    }

    public BigInteger getDesignProjectId() {
        return designProjectId;
    }

    public void setDesignProjectId(BigInteger designProjectId) {
        this.designProjectId = designProjectId;
    }

    public String getTmpFundsource() {
        return tmpFundsource;
    }

    public void setTmpFundsource(String tmpFundsource) {
        this.tmpFundsource = tmpFundsource;
    }

    public BigInteger getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(BigInteger ownerId) {
        this.ownerId = ownerId;
    }

    public BigInteger getPersonSeniorInspector() {
        return personSeniorInspector;
    }

    public void setPersonSeniorInspector(BigInteger personSeniorInspector) {
        this.personSeniorInspector = personSeniorInspector;
    }

    public Double getAddTotal() {
        return addTotal;
    }

    public void setAddTotal(Double addTotal) {
        this.addTotal = addTotal;
    }

    public Double getCurContractAmount() {
        return curContractAmount;
    }

    public void setCurContractAmount(Double curContractAmount) {
        this.curContractAmount = curContractAmount;
    }

    public Double getSupplements() {
        return supplements;
    }

    public void setSupplements(Double supplements) {
        this.supplements = supplements;
    }

    public Double getPrimeFundAmount() {
        return primeFundAmount;
    }

    public void setPrimeFundAmount(Double primeFundAmount) {
        this.primeFundAmount = primeFundAmount;
    }

    public Double getSecondFundAmount() {
        return secondFundAmount;
    }

    public void setSecondFundAmount(Double secondFundAmount) {
        this.secondFundAmount = secondFundAmount;
    }

    public Double getThirdFundAmount() {
        return thirdFundAmount;
    }

    public void setThirdFundAmount(Double thirdFundAmount) {
        this.thirdFundAmount = thirdFundAmount;
    }

    public Double getFourthFundAmount() {
        return fourthFundAmount;
    }

    public void setFourthFundAmount(Double fourthFundAmount) {
        this.fourthFundAmount = fourthFundAmount;
    }

    public Double getFifthFundAmount() {
        return fifthFundAmount;
    }

    public void setFifthFundAmount(Double fifthFundAmount) {
        this.fifthFundAmount = fifthFundAmount;
    }

    public Double getSixthFundAmount() {
        return sixthFundAmount;
    }

    public void setSixthFundAmount(Double sixthFundAmount) {
        this.sixthFundAmount = sixthFundAmount;
    }

    public String getLegalFileNo() {
        return legalFileNo;
    }

    public void setLegalFileNo(String legalFileNo) {
        this.legalFileNo = legalFileNo;
    }

    public Double getCipAmount() {
        return cipAmount;
    }

    public void setCipAmount(Double cipAmount) {
        this.cipAmount = cipAmount;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public BigInteger getContactDays() {
        return contactDays;
    }

    public void setContactDays(BigInteger contactDays) {
        this.contactDays = contactDays;
    }

    public String getRcaTracking() {
        return rcaTracking;
    }

    public void setRcaTracking(String rcaTracking) {
        this.rcaTracking = rcaTracking;
    }

    public String getMwbeGoal() {
        return mwbeGoal;
    }

    public void setMwbeGoal(String mwbeGoal) {
        this.mwbeGoal = mwbeGoal;
    }

    public Double getBasicPhase1() {
        return basicPhase1;
    }

    public void setBasicPhase1(Double basicPhase1) {
        this.basicPhase1 = basicPhase1;
    }

    public Double getBasicPhase2() {
        return basicPhase2;
    }

    public void setBasicPhase2(Double basicPhase2) {
        this.basicPhase2 = basicPhase2;
    }

    public Double getBasicPhase3() {
        return basicPhase3;
    }

    public void setBasicPhase3(Double basicPhase3) {
        this.basicPhase3 = basicPhase3;
    }

    public Double getBasicTotal() {
        return basicTotal;
    }

    public void setBasicTotal(Double basicTotal) {
        this.basicTotal = basicTotal;
    }

    public Double getAddGeotech() {
        return addGeotech;
    }

    public void setAddGeotech(Double addGeotech) {
        this.addGeotech = addGeotech;
    }

    public Double getAddSurvey() {
        return addSurvey;
    }

    public void setAddSurvey(Double addSurvey) {
        this.addSurvey = addSurvey;
    }

    public Double getAddEnviron() {
        return addEnviron;
    }

    public void setAddEnviron(Double addEnviron) {
        this.addEnviron = addEnviron;
    }

    public Double getAddTraffic() {
        return addTraffic;
    }

    public void setAddTraffic(Double addTraffic) {
        this.addTraffic = addTraffic;
    }

    public Double getAddSwppp() {
        return addSwppp;
    }

    public void setAddSwppp(Double addSwppp) {
        this.addSwppp = addSwppp;
    }

    public Double getAddOther() {
        return addOther;
    }

    public void setAddOther(Double addOther) {
        this.addOther = addOther;
    }

    public String getFourthCip() {
        return fourthCip;
    }

    public void setFourthCip(String fourthCip) {
        this.fourthCip = fourthCip;
    }

    public String getFourthGfs() {
        return fourthGfs;
    }

    public void setFourthGfs(String fourthGfs) {
        this.fourthGfs = fourthGfs;
    }

    public String getFourthFunding() {
        return fourthFunding;
    }

    public void setFourthFunding(String fourthFunding) {
        this.fourthFunding = fourthFunding;
    }

    public String getFifthCip() {
        return fifthCip;
    }

    public void setFifthCip(String fifthCip) {
        this.fifthCip = fifthCip;
    }

    public String getFifthGfs() {
        return fifthGfs;
    }

    public void setFifthGfs(String fifthGfs) {
        this.fifthGfs = fifthGfs;
    }

    public String getFifthFunding() {
        return fifthFunding;
    }

    public void setFifthFunding(String fifthFunding) {
        this.fifthFunding = fifthFunding;
    }

    public String getSixthCip() {
        return sixthCip;
    }

    public void setSixthCip(String sixthCip) {
        this.sixthCip = sixthCip;
    }

    public String getSixthGfs() {
        return sixthGfs;
    }

    public void setSixthGfs(String sixthGfs) {
        this.sixthGfs = sixthGfs;
    }

    public String getSixthFunding() {
        return sixthFunding;
    }

    public void setSixthFunding(String sixthFunding) {
        this.sixthFunding = sixthFunding;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public GlobClientOfficeLocation getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(GlobClientOfficeLocation officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getKeymap() {
        return keymap;
    }

    public void setKeymap(String keymap) {
        this.keymap = keymap;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public Character getHasFlags() {
        return hasFlags;
    }

    public void setHasFlags(Character hasFlags) {
        this.hasFlags = hasFlags;
    }

    public BigInteger getFlagId() {
        return flagId;
    }

    public void setFlagId(BigInteger flagId) {
        this.flagId = flagId;
    }

    public Character getUsesSignature() {
        return usesSignature;
    }

    public void setUsesSignature(Character usesSignature) {
        this.usesSignature = usesSignature;
    }

    public BigInteger getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(BigInteger approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    public String getPManagedBy() {
        return pManagedBy;
    }

    public void setPManagedBy(String pManagedBy) {
        this.pManagedBy = pManagedBy;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Character getPartnering() {
        return partnering;
    }

    public void setPartnering(Character partnering) {
        this.partnering = partnering;
    }

    public String getFieldOfficeNumber() {
        return fieldOfficeNumber;
    }

    public void setFieldOfficeNumber(String fieldOfficeNumber) {
        this.fieldOfficeNumber = fieldOfficeNumber;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public Double getAmendments() {
        return amendments;
    }

    public void setAmendments(Double amendments) {
        this.amendments = amendments;
    }

    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    public BigInteger getPersonProjectManager() {
        return personProjectManager;
    }

    public void setPersonProjectManager(BigInteger personProjectManager) {
        this.personProjectManager = personProjectManager;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }

    public GlobContractorPersonnel getContractorId() {
        return contractorId;
    }

    public void setContractorId(GlobContractorPersonnel contractorId) {
        this.contractorId = contractorId;
    }

    public BigInteger getPersonChiefDiscEngineer() {
        return personChiefDiscEngineer;
    }

    public void setPersonChiefDiscEngineer(BigInteger personChiefDiscEngineer) {
        this.personChiefDiscEngineer = personChiefDiscEngineer;
    }

    public String getPersonEnvironmental() {
        return personEnvironmental;
    }

    public void setPersonEnvironmental(String personEnvironmental) {
        this.personEnvironmental = personEnvironmental;
    }

    public String getPersonLegal() {
        return personLegal;
    }

    public void setPersonLegal(String personLegal) {
        this.personLegal = personLegal;
    }

    public String getWebcamLink() {
        return webcamLink;
    }

    public void setWebcamLink(String webcamLink) {
        this.webcamLink = webcamLink;
    }

    public BigInteger getPersonDirector() {
        return personDirector;
    }

    public void setPersonDirector(BigInteger personDirector) {
        this.personDirector = personDirector;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public String getCipProject() {
        return cipProject;
    }

    public void setCipProject(String cipProject) {
        this.cipProject = cipProject;
    }

    public String getCipNo() {
        return cipNo;
    }

    public void setCipNo(String cipNo) {
        this.cipNo = cipNo;
    }

    public BigInteger getPersonEngineer() {
        return personEngineer;
    }

    public void setPersonEngineer(BigInteger personEngineer) {
        this.personEngineer = personEngineer;
    }

    public BigInteger getPersonAdministrator() {
        return personAdministrator;
    }

    public void setPersonAdministrator(BigInteger personAdministrator) {
        this.personAdministrator = personAdministrator;
    }

    public BigInteger getPersonProjectDirector() {
        return personProjectDirector;
    }

    public void setPersonProjectDirector(BigInteger personProjectDirector) {
        this.personProjectDirector = personProjectDirector;
    }

    public String getCityInspector() {
        return cityInspector;
    }

    public void setCityInspector(String cityInspector) {
        this.cityInspector = cityInspector;
    }

    public String getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(String locationKey) {
        this.locationKey = locationKey;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullProjectAddress() {
        if (StringSupport.isNotNullAndNotEmpty(this.getAddress()) && StringSupport.isNotNullAndNotEmpty(this.getAddress2())) {
            return this.getAddress() + " " + this.getAddress2();
        } else {
            if (StringSupport.isNotNullAndNotEmpty(this.getAddress())) {
                return this.getAddress();
            } else if (StringSupport.isNotNullAndNotEmpty(this.getAddress2())) {
                return this.getAddress2();
            }
        }
        return null;
    }

    public String getProjectFullName() {
        if (StringSupport.isNotNullAndNotEmpty(this.pNumber)) {
            if (StringSupport.isNotNullAndNotEmpty(this.pName)) {
                return "[ " + this.pNumber + " ] " + this.pName;
            } else {
                return "[ " + this.pNumber + " ] " + this.pDescription;
            }
        } else {
            if (StringSupport.isNotNullAndNotEmpty(this.pName)) {
                return this.pName;
            } else {
                return this.pDescription;
            }
        }
    }

    public String getSegmentWorkareaType() {
        return segmentWorkareaType;
    }

    public void setSegmentWorkareaType(String segmentWorkareaType) {
        this.segmentWorkareaType = segmentWorkareaType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getAsphaltManagerId() {
        return asphaltManagerId;
    }

    public void setAsphaltManagerId(BigInteger asphaltManagerId) {
        this.asphaltManagerId = asphaltManagerId;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getCommentsEngineering() {
        return commentsEngineering;
    }

    public void setCommentsEngineering(String commentsEngineering) {
        this.commentsEngineering = commentsEngineering;
    }

    public String getPdaType() {
        return pdaType;
    }

    public void setPdaType(String pdaType) {
        this.pdaType = pdaType;
    }

    public Character getCreditHold() {
        return creditHold;
    }

    public void setCreditHold(Character creditHold) {
        this.creditHold = creditHold;
    }

    public String getFundSourceOther2() {
        return fundSourceOther2;
    }

    public void setFundSourceOther2(String fundSourceOther2) {
        this.fundSourceOther2 = fundSourceOther2;
    }

    public BigInteger getSoilClassificationCatId() {
        return soilClassificationCatId;
    }

    public void setSoilClassificationCatId(BigInteger soilClassificationCatId) {
        this.soilClassificationCatId = soilClassificationCatId;
    }

    public String getPhoneMain2() {
        return phoneMain2;
    }

    public void setPhoneMain2(String phoneMain2) {
        this.phoneMain2 = phoneMain2;
    }

    public String getPhoneMain3() {
        return phoneMain3;
    }

    public void setPhoneMain3(String phoneMain3) {
        this.phoneMain3 = phoneMain3;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getFundSourceOther1() {
        return fundSourceOther1;
    }

    public void setFundSourceOther1(String fundSourceOther1) {
        this.fundSourceOther1 = fundSourceOther1;
    }

    public String getFundSourceOther3() {
        return fundSourceOther3;
    }

    public void setFundSourceOther3(String fundSourceOther3) {
        this.fundSourceOther3 = fundSourceOther3;
    }

    public String getFundSourceOther4() {
        return fundSourceOther4;
    }

    public void setFundSourceOther4(String fundSourceOther4) {
        this.fundSourceOther4 = fundSourceOther4;
    }

    public BigInteger getFundAmount0() {
        return fundAmount0;
    }

    public void setFundAmount0(BigInteger fundAmount0) {
        this.fundAmount0 = fundAmount0;
    }

    public BigInteger getFundAmount1() {
        return fundAmount1;
    }

    public void setFundAmount1(BigInteger fundAmount1) {
        this.fundAmount1 = fundAmount1;
    }

    public BigInteger getFundAmount2() {
        return fundAmount2;
    }

    public void setFundAmount2(BigInteger fundAmount2) {
        this.fundAmount2 = fundAmount2;
    }

    public BigInteger getFundAmount3() {
        return fundAmount3;
    }

    public void setFundAmount3(BigInteger fundAmount3) {
        this.fundAmount3 = fundAmount3;
    }

    public BigInteger getFundAmount4() {
        return fundAmount4;
    }

    public void setFundAmount4(BigInteger fundAmount4) {
        this.fundAmount4 = fundAmount4;
    }

    public String getFundSourceEligible() {
        return fundSourceEligible;
    }

    public void setFundSourceEligible(String fundSourceEligible) {
        this.fundSourceEligible = fundSourceEligible;
    }

    public String getStartDateTmp() {
        return startDateTmp;
    }

    public void setStartDateTmp(String startDateTmp) {
        this.startDateTmp = startDateTmp;
    }

    public String getAwardOrdinanceDateTmp() {
        return awardOrdinanceDateTmp;
    }

    public void setAwardOrdinanceDateTmp(String awardOrdinanceDateTmp) {
        this.awardOrdinanceDateTmp = awardOrdinanceDateTmp;
    }

    public String getBidDateTmp() {
        return bidDateTmp;
    }

    public void setBidDateTmp(String bidDateTmp) {
        this.bidDateTmp = bidDateTmp;
    }

    public String getEndDateTmp() {
        return endDateTmp;
    }

    public void setEndDateTmp(String endDateTmp) {
        this.endDateTmp = endDateTmp;
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

    public String getPDateTmp() {
        return pDateTmp;
    }

    public void setPDateTmp(String pDateTmp) {
        this.pDateTmp = pDateTmp;
    }

    public GlobClientRegions getRegionId() {
        return regionId;
    }

    public void setRegionId(GlobClientRegions regionId) {
        this.regionId = regionId;
    }

    public String getShowAnnualReview() {
        return showAnnualReview;
    }

    public void setShowAnnualReview(String showAnnualReview) {
        this.showAnnualReview = showAnnualReview;
    }

    public String getBondFund() {
        return bondFund;
    }

    public void setBondFund(String bondFund) {
        this.bondFund = bondFund;
    }

    public String getOldAccNo() {
        return oldAccNo;
    }

    public void setOldAccNo(String oldAccNo) {
        this.oldAccNo = oldAccNo;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Date getReqCompDate() {
        return reqCompDate;
    }

    public void setReqCompDate(Date reqCompDate) {
        this.reqCompDate = reqCompDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getEstStartDate() {
        return estStartDate;
    }

    public void setEstStartDate(Date estStartDate) {
        this.estStartDate = estStartDate;
    }

    public Character getHasLab() {
        return hasLab;
    }

    public void setHasLab(Character hasLab) {
        this.hasLab = hasLab;
    }

    public Double getCostToDate() {
        return costToDate;
    }

    public void setCostToDate(Double costToDate) {
        this.costToDate = costToDate;
    }

    public String getPApinNo() {
        return pApinNo;
    }

    public void setPApinNo(String pApinNo) {
        this.pApinNo = pApinNo;
    }

    @JsonProperty("pJobNo")
    public String getPJobNo() {
        return pJobNo;
    }

    public void setPJobNo(String pJobNo) {
        this.pJobNo = pJobNo;
    }

    public Double getPAc() {
        return pAc;
    }

    public void setPAc(Double pAc) {
        this.pAc = pAc;
    }

    public String getPClass() {
        return pClass;
    }

    public void setPClass(String pClass) {
        this.pClass = pClass;
    }

    public String getPPhase() {
        return pPhase;
    }

    public void setPPhase(String pPhase) {
        this.pPhase = pPhase;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigInteger getOwnerFk() {
        return ownerFk;
    }

    public void setOwnerFk(BigInteger ownerFk) {
        this.ownerFk = ownerFk;
    }

    public BigInteger getPlanningProjectId() {
        return planningProjectId;
    }

    public void setPlanningProjectId(BigInteger planningProjectId) {
        this.planningProjectId = planningProjectId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public Character getTestlogShowacknowledge() {
        return testlogShowacknowledge;
    }

    public void setTestlogShowacknowledge(Character testlogShowacknowledge) {
        this.testlogShowacknowledge = testlogShowacknowledge;
    }

    @XmlTransient
    public List<CmEmEmail> getCmEmEmailList() {
        return cmEmEmailList;
    }

    public void setCmEmEmailList(List<CmEmEmail> cmEmEmailList) {
        this.cmEmEmailList = cmEmEmailList;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<CmEmDocument> getCmEmDocumentList() {
        return cmEmDocumentList;
    }

    public void setCmEmDocumentList(List<CmEmDocument> cmEmDocumentList) {
        this.cmEmDocumentList = cmEmDocumentList;
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
        if (!(object instanceof GlobProject)) {
            return false;
        }
        GlobProject other = (GlobProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProject[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList() {
        return globCorrespdList;
    }

    public void setGlobCorrespdList(List<GlobCorrespd> globCorrespdList) {
        this.globCorrespdList = globCorrespdList;
    }

    /*@XmlTransient
    public List<GlobProjectSupplier> getGlobProjectSupplierList() {
        return globProjectSupplierList;
    }

    public void setGlobProjectSupplierList(List<GlobProjectSupplier> globProjectSupplierList) {
        this.globProjectSupplierList = globProjectSupplierList;
    }

    @XmlTransient
    public List<GlobProjContrPersonnel> getGlobProjContrPersonnelList() {
        return globProjContrPersonnelList;
    }

    public void setGlobProjContrPersonnelList(List<GlobProjContrPersonnel> globProjContrPersonnelList) {
        this.globProjContrPersonnelList = globProjContrPersonnelList;
    }*/
    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    /**
     * @return the otherContactName1
     */
    public String getOtherContactName1() {
        return otherContactName1;
    }

    /**
     * @param otherContactName1 the otherContactName1 to set
     */
    public void setOtherContactName1(String otherContactName1) {
        this.otherContactName1 = otherContactName1;
    }

    /**
     * @return the otherContactTelephone1
     */
    public String getOtherContactTelephone1() {
        return otherContactTelephone1;
    }

    /**
     * @param otherContactTelephone1 the otherContactTelephone1 to set
     */
    public void setOtherContactTelephone1(String otherContactTelephone1) {
        this.otherContactTelephone1 = otherContactTelephone1;
    }

}
