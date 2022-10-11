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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobContract.findByProjectId", query = "SELECT g FROM GlobContract g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobContract.findByCNumber", query = "SELECT g FROM GlobContract g WHERE g.cNumber = :cNumber")
    , @NamedQuery(name = "GlobContract.findByCDate", query = "SELECT g FROM GlobContract g WHERE g.cDate = :cDate")
    , @NamedQuery(name = "GlobContract.findByCName", query = "SELECT g FROM GlobContract g WHERE g.cName = :cName")
    , @NamedQuery(name = "GlobContract.findByCAmount", query = "SELECT g FROM GlobContract g WHERE g.cAmount = :cAmount")
    , @NamedQuery(name = "GlobContract.findByCDays", query = "SELECT g FROM GlobContract g WHERE g.cDays = :cDays")
    , @NamedQuery(name = "GlobContract.findByStartingDate", query = "SELECT g FROM GlobContract g WHERE g.startingDate = :startingDate")
    , @NamedQuery(name = "GlobContract.findByCutoffDate", query = "SELECT g FROM GlobContract g WHERE g.cutoffDate = :cutoffDate")
    , @NamedQuery(name = "GlobContract.findByPManager", query = "SELECT g FROM GlobContract g WHERE g.pManager = :pManager")
    , @NamedQuery(name = "GlobContract.findByInspector", query = "SELECT g FROM GlobContract g WHERE g.inspector = :inspector")
    , @NamedQuery(name = "GlobContract.findByEstimator", query = "SELECT g FROM GlobContract g WHERE g.estimator = :estimator")
    , @NamedQuery(name = "GlobContract.findByKeyMap", query = "SELECT g FROM GlobContract g WHERE g.keyMap = :keyMap")
    , @NamedQuery(name = "GlobContract.findByDrawgNo", query = "SELECT g FROM GlobContract g WHERE g.drawgNo = :drawgNo")
    , @NamedQuery(name = "GlobContract.findByWmbe", query = "SELECT g FROM GlobContract g WHERE g.wmbe = :wmbe")
    , @NamedQuery(name = "GlobContract.findByDamagesPerDay", query = "SELECT g FROM GlobContract g WHERE g.damagesPerDay = :damagesPerDay")
    , @NamedQuery(name = "GlobContract.findByNtpLetterDate", query = "SELECT g FROM GlobContract g WHERE g.ntpLetterDate = :ntpLetterDate")
    , @NamedQuery(name = "GlobContract.findByPreConstructionMeetingDate", query = "SELECT g FROM GlobContract g WHERE g.preConstructionMeetingDate = :preConstructionMeetingDate")
    , @NamedQuery(name = "GlobContract.findByPreConstructionMeetingLoc", query = "SELECT g FROM GlobContract g WHERE g.preConstructionMeetingLoc = :preConstructionMeetingLoc")
    , @NamedQuery(name = "GlobContract.findBySubcompdate", query = "SELECT g FROM GlobContract g WHERE g.subcompdate = :subcompdate")
    , @NamedQuery(name = "GlobContract.findByInsurexpdate", query = "SELECT g FROM GlobContract g WHERE g.insurexpdate = :insurexpdate")
    , @NamedQuery(name = "GlobContract.findByDrugpdate", query = "SELECT g FROM GlobContract g WHERE g.drugpdate = :drugpdate")
    , @NamedQuery(name = "GlobContract.findByField1", query = "SELECT g FROM GlobContract g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobContract.findByField2", query = "SELECT g FROM GlobContract g WHERE g.field2 = :field2")
    , @NamedQuery(name = "GlobContract.findByField3", query = "SELECT g FROM GlobContract g WHERE g.field3 = :field3")
    , @NamedQuery(name = "GlobContract.findByField4", query = "SELECT g FROM GlobContract g WHERE g.field4 = :field4")
    , @NamedQuery(name = "GlobContract.findByField5", query = "SELECT g FROM GlobContract g WHERE g.field5 = :field5")
    , @NamedQuery(name = "GlobContract.findByField6", query = "SELECT g FROM GlobContract g WHERE g.field6 = :field6")
    , @NamedQuery(name = "GlobContract.findByField7", query = "SELECT g FROM GlobContract g WHERE g.field7 = :field7")
    , @NamedQuery(name = "GlobContract.findByField8", query = "SELECT g FROM GlobContract g WHERE g.field8 = :field8")
    , @NamedQuery(name = "GlobContract.findByCStatus", query = "SELECT g FROM GlobContract g WHERE g.cStatus = :cStatus")
    , @NamedQuery(name = "GlobContract.findBySystem", query = "SELECT g FROM GlobContract g WHERE g.system = :system")
    , @NamedQuery(name = "GlobContract.findByModulelistId", query = "SELECT g FROM GlobContract g WHERE g.modulelistId = :modulelistId")
    , @NamedQuery(name = "GlobContract.findByContactId", query = "SELECT g FROM GlobContract g WHERE g.contactId = :contactId")
    , @NamedQuery(name = "GlobContract.findByDesignConsultant", query = "SELECT g FROM GlobContract g WHERE g.designConsultant = :designConsultant")
    , @NamedQuery(name = "GlobContract.findByContactName", query = "SELECT g FROM GlobContract g WHERE g.contactName = :contactName")
    , @NamedQuery(name = "GlobContract.findByContactTitle", query = "SELECT g FROM GlobContract g WHERE g.contactTitle = :contactTitle")
    , @NamedQuery(name = "GlobContract.findByContactPhone", query = "SELECT g FROM GlobContract g WHERE g.contactPhone = :contactPhone")
    , @NamedQuery(name = "GlobContract.findByAwardOrdinanceNum", query = "SELECT g FROM GlobContract g WHERE g.awardOrdinanceNum = :awardOrdinanceNum")
    , @NamedQuery(name = "GlobContract.findByAwardOrdinanceDate", query = "SELECT g FROM GlobContract g WHERE g.awardOrdinanceDate = :awardOrdinanceDate")
    , @NamedQuery(name = "GlobContract.findByAwardOrdinanceAmount", query = "SELECT g FROM GlobContract g WHERE g.awardOrdinanceAmount = :awardOrdinanceAmount")
    , @NamedQuery(name = "GlobContract.findBySupplOrdinanceNum", query = "SELECT g FROM GlobContract g WHERE g.supplOrdinanceNum = :supplOrdinanceNum")
    , @NamedQuery(name = "GlobContract.findBySupplOrdinanceDate", query = "SELECT g FROM GlobContract g WHERE g.supplOrdinanceDate = :supplOrdinanceDate")
    , @NamedQuery(name = "GlobContract.findBySupplOrdinanceAmount", query = "SELECT g FROM GlobContract g WHERE g.supplOrdinanceAmount = :supplOrdinanceAmount")
    , @NamedQuery(name = "GlobContract.findByBasicPhase1", query = "SELECT g FROM GlobContract g WHERE g.basicPhase1 = :basicPhase1")
    , @NamedQuery(name = "GlobContract.findByBasicPhase2", query = "SELECT g FROM GlobContract g WHERE g.basicPhase2 = :basicPhase2")
    , @NamedQuery(name = "GlobContract.findByBasicPhase3", query = "SELECT g FROM GlobContract g WHERE g.basicPhase3 = :basicPhase3")
    , @NamedQuery(name = "GlobContract.findByBasicTotal", query = "SELECT g FROM GlobContract g WHERE g.basicTotal = :basicTotal")
    , @NamedQuery(name = "GlobContract.findByAddGeotech", query = "SELECT g FROM GlobContract g WHERE g.addGeotech = :addGeotech")
    , @NamedQuery(name = "GlobContract.findByAddSurvey", query = "SELECT g FROM GlobContract g WHERE g.addSurvey = :addSurvey")
    , @NamedQuery(name = "GlobContract.findByAddEnviron", query = "SELECT g FROM GlobContract g WHERE g.addEnviron = :addEnviron")
    , @NamedQuery(name = "GlobContract.findByAddOther", query = "SELECT g FROM GlobContract g WHERE g.addOther = :addOther")
    , @NamedQuery(name = "GlobContract.findByAddTotal", query = "SELECT g FROM GlobContract g WHERE g.addTotal = :addTotal")
    , @NamedQuery(name = "GlobContract.findByTmpEstimater", query = "SELECT g FROM GlobContract g WHERE g.tmpEstimater = :tmpEstimater")
    , @NamedQuery(name = "GlobContract.findByTmpInspector", query = "SELECT g FROM GlobContract g WHERE g.tmpInspector = :tmpInspector")
    , @NamedQuery(name = "GlobContract.findByPersonPManager", query = "SELECT g FROM GlobContract g WHERE g.personPManager = :personPManager")
    , @NamedQuery(name = "GlobContract.findByPersonInspector", query = "SELECT g FROM GlobContract g WHERE g.personInspector = :personInspector")
    , @NamedQuery(name = "GlobContract.findByPersonEstimator", query = "SELECT g FROM GlobContract g WHERE g.personEstimator = :personEstimator")
    , @NamedQuery(name = "GlobContract.findByFileNo", query = "SELECT g FROM GlobContract g WHERE g.fileNo = :fileNo")
    , @NamedQuery(name = "GlobContract.findByGimsMaps", query = "SELECT g FROM GlobContract g WHERE g.gimsMaps = :gimsMaps")
    , @NamedQuery(name = "GlobContract.findBySuperNeib", query = "SELECT g FROM GlobContract g WHERE g.superNeib = :superNeib")
    , @NamedQuery(name = "GlobContract.findByCouncilDist", query = "SELECT g FROM GlobContract g WHERE g.councilDist = :councilDist")
    , @NamedQuery(name = "GlobContract.findByAddTraffic", query = "SELECT g FROM GlobContract g WHERE g.addTraffic = :addTraffic")
    , @NamedQuery(name = "GlobContract.findByAddSwppp", query = "SELECT g FROM GlobContract g WHERE g.addSwppp = :addSwppp")
    , @NamedQuery(name = "GlobContract.findByProjCloseAmt", query = "SELECT g FROM GlobContract g WHERE g.projCloseAmt = :projCloseAmt")
    , @NamedQuery(name = "GlobContract.findByRoadBlockDirector", query = "SELECT g FROM GlobContract g WHERE g.roadBlockDirector = :roadBlockDirector")
    , @NamedQuery(name = "GlobContract.findByDirRptComments", query = "SELECT g FROM GlobContract g WHERE g.dirRptComments = :dirRptComments")
    , @NamedQuery(name = "GlobContract.findByPmComments", query = "SELECT g FROM GlobContract g WHERE g.pmComments = :pmComments")
    , @NamedQuery(name = "GlobContract.findByAgreedEstimate", query = "SELECT g FROM GlobContract g WHERE g.agreedEstimate = :agreedEstimate")
    , @NamedQuery(name = "GlobContract.findByEstConstCost", query = "SELECT g FROM GlobContract g WHERE g.estConstCost = :estConstCost")
    , @NamedQuery(name = "GlobContract.findByAdoptedConsAmt", query = "SELECT g FROM GlobContract g WHERE g.adoptedConsAmt = :adoptedConsAmt")
    , @NamedQuery(name = "GlobContract.findByAdoptedAcqAmt", query = "SELECT g FROM GlobContract g WHERE g.adoptedAcqAmt = :adoptedAcqAmt")
    , @NamedQuery(name = "GlobContract.findByEstConsCost", query = "SELECT g FROM GlobContract g WHERE g.estConsCost = :estConsCost")
    , @NamedQuery(name = "GlobContract.findByEstAcqCost", query = "SELECT g FROM GlobContract g WHERE g.estAcqCost = :estAcqCost")
    , @NamedQuery(name = "GlobContract.findByCmPManager", query = "SELECT g FROM GlobContract g WHERE g.cmPManager = :cmPManager")
    , @NamedQuery(name = "GlobContract.findByCmSrInspector", query = "SELECT g FROM GlobContract g WHERE g.cmSrInspector = :cmSrInspector")
    , @NamedQuery(name = "GlobContract.findByCmInspector", query = "SELECT g FROM GlobContract g WHERE g.cmInspector = :cmInspector")
    , @NamedQuery(name = "GlobContract.findByConstructionGfsNo", query = "SELECT g FROM GlobContract g WHERE g.constructionGfsNo = :constructionGfsNo")
    , @NamedQuery(name = "GlobContract.findByDesignProjectAmount", query = "SELECT g FROM GlobContract g WHERE g.designProjectAmount = :designProjectAmount")
    , @NamedQuery(name = "GlobContract.findByParcelsRequired", query = "SELECT g FROM GlobContract g WHERE g.parcelsRequired = :parcelsRequired")
    , @NamedQuery(name = "GlobContract.findByCFiscalYear", query = "SELECT g FROM GlobContract g WHERE g.cFiscalYear = :cFiscalYear")
    , @NamedQuery(name = "GlobContract.findByDFiscalYear", query = "SELECT g FROM GlobContract g WHERE g.dFiscalYear = :dFiscalYear")
    , @NamedQuery(name = "GlobContract.findByCAppAmountP", query = "SELECT g FROM GlobContract g WHERE g.cAppAmountP = :cAppAmountP")
    , @NamedQuery(name = "GlobContract.findByCAppAmountA", query = "SELECT g FROM GlobContract g WHERE g.cAppAmountA = :cAppAmountA")
    , @NamedQuery(name = "GlobContract.findByCLowBid", query = "SELECT g FROM GlobContract g WHERE g.cLowBid = :cLowBid")
    , @NamedQuery(name = "GlobContract.findByDFeeA", query = "SELECT g FROM GlobContract g WHERE g.dFeeA = :dFeeA")
    , @NamedQuery(name = "GlobContract.findByDOrdinance", query = "SELECT g FROM GlobContract g WHERE g.dOrdinance = :dOrdinance")
    , @NamedQuery(name = "GlobContract.findByPurchaseOrderNo", query = "SELECT g FROM GlobContract g WHERE g.purchaseOrderNo = :purchaseOrderNo")
    , @NamedQuery(name = "GlobContract.findByAccountNo", query = "SELECT g FROM GlobContract g WHERE g.accountNo = :accountNo")
    , @NamedQuery(name = "GlobContract.findByLabCAmount", query = "SELECT g FROM GlobContract g WHERE g.labCAmount = :labCAmount")
    , @NamedQuery(name = "GlobContract.findByLatitude", query = "SELECT g FROM GlobContract g WHERE g.latitude = :latitude")
    , @NamedQuery(name = "GlobContract.findByLongitude", query = "SELECT g FROM GlobContract g WHERE g.longitude = :longitude")
    , @NamedQuery(name = "GlobContract.findByCDescription", query = "SELECT g FROM GlobContract g WHERE g.cDescription = :cDescription")
    , @NamedQuery(name = "GlobContract.findByJobNo", query = "SELECT g FROM GlobContract g WHERE g.jobNo = :jobNo")
    , @NamedQuery(name = "GlobContract.findByComments", query = "SELECT g FROM GlobContract g WHERE g.comments = :comments")
    , @NamedQuery(name = "GlobContract.findByServiceType", query = "SELECT g FROM GlobContract g WHERE g.serviceType = :serviceType")
    , @NamedQuery(name = "GlobContract.findByAmendments", query = "SELECT g FROM GlobContract g WHERE g.amendments = :amendments")
    , @NamedQuery(name = "GlobContract.findBySupplements", query = "SELECT g FROM GlobContract g WHERE g.supplements = :supplements")
    , @NamedQuery(name = "GlobContract.findByPmContactPhoneNoCell", query = "SELECT g FROM GlobContract g WHERE g.pmContactPhoneNoCell = :pmContactPhoneNoCell")
    , @NamedQuery(name = "GlobContract.findByContractorId", query = "SELECT g FROM GlobContract g WHERE g.contractorId = :contractorId")
    , @NamedQuery(name = "GlobContract.findByLabId", query = "SELECT g FROM GlobContract g WHERE g.labId = :labId")
    , @NamedQuery(name = "GlobContract.findByPersonEngineerAdmin", query = "SELECT g FROM GlobContract g WHERE g.personEngineerAdmin = :personEngineerAdmin")
    , @NamedQuery(name = "GlobContract.findByPersonCoordinator", query = "SELECT g FROM GlobContract g WHERE g.personCoordinator = :personCoordinator")
    , @NamedQuery(name = "GlobContract.findByPersonAdministrator", query = "SELECT g FROM GlobContract g WHERE g.personAdministrator = :personAdministrator")
    , @NamedQuery(name = "GlobContract.findByStationBegin", query = "SELECT g FROM GlobContract g WHERE g.stationBegin = :stationBegin")
    , @NamedQuery(name = "GlobContract.findByStationEnd", query = "SELECT g FROM GlobContract g WHERE g.stationEnd = :stationEnd")
    , @NamedQuery(name = "GlobContract.findByLat", query = "SELECT g FROM GlobContract g WHERE g.lat = :lat")
    , @NamedQuery(name = "GlobContract.findByLon", query = "SELECT g FROM GlobContract g WHERE g.lon = :lon")
    , @NamedQuery(name = "GlobContract.findByManageFirmId", query = "SELECT g FROM GlobContract g WHERE g.manageFirmId = :manageFirmId")
    , @NamedQuery(name = "GlobContract.findByPersonCoordinatorUtility", query = "SELECT g FROM GlobContract g WHERE g.personCoordinatorUtility = :personCoordinatorUtility")
    , @NamedQuery(name = "GlobContract.findByPersonCoordinatorRow", query = "SELECT g FROM GlobContract g WHERE g.personCoordinatorRow = :personCoordinatorRow")
    , @NamedQuery(name = "GlobContract.findByCmFirmId", query = "SELECT g FROM GlobContract g WHERE g.cmFirmId = :cmFirmId")
    , @NamedQuery(name = "GlobContract.findByPersonSrInspector", query = "SELECT g FROM GlobContract g WHERE g.personSrInspector = :personSrInspector")
    , @NamedQuery(name = "GlobContract.findByPersonCmFirmContact", query = "SELECT g FROM GlobContract g WHERE g.personCmFirmContact = :personCmFirmContact")
    , @NamedQuery(name = "GlobContract.findByTimeSuspension", query = "SELECT g FROM GlobContract g WHERE g.timeSuspension = :timeSuspension")
    , @NamedQuery(name = "GlobContract.findByApprovedHolidays", query = "SELECT g FROM GlobContract g WHERE g.approvedHolidays = :approvedHolidays")
    , @NamedQuery(name = "GlobContract.findByBehindSchedule", query = "SELECT g FROM GlobContract g WHERE g.behindSchedule = :behindSchedule")
    , @NamedQuery(name = "GlobContract.findByPaidTodate", query = "SELECT g FROM GlobContract g WHERE g.paidTodate = :paidTodate")
    , @NamedQuery(name = "GlobContract.findByApinNo", query = "SELECT g FROM GlobContract g WHERE g.apinNo = :apinNo")
    , @NamedQuery(name = "GlobContract.findByIncentive", query = "SELECT g FROM GlobContract g WHERE g.incentive = :incentive")
    , @NamedQuery(name = "GlobContract.findByPersonSet", query = "SELECT g FROM GlobContract g WHERE g.personSet = :personSet")
    , @NamedQuery(name = "GlobContract.findByPersonManager", query = "SELECT g FROM GlobContract g WHERE g.personManager = :personManager")
    , @NamedQuery(name = "GlobContract.findByPersonChiefInspections", query = "SELECT g FROM GlobContract g WHERE g.personChiefInspections = :personChiefInspections")
    , @NamedQuery(name = "GlobContract.findByPersonContractorContact", query = "SELECT g FROM GlobContract g WHERE g.personContractorContact = :personContractorContact")
    , @NamedQuery(name = "GlobContract.findByPersonConsultantContact", query = "SELECT g FROM GlobContract g WHERE g.personConsultantContact = :personConsultantContact")
    , @NamedQuery(name = "GlobContract.findByPersonLabContact", query = "SELECT g FROM GlobContract g WHERE g.personLabContact = :personLabContact")
    , @NamedQuery(name = "GlobContract.findByCommentsManager", query = "SELECT g FROM GlobContract g WHERE g.commentsManager = :commentsManager")
    , @NamedQuery(name = "GlobContract.findByCommentsLeadInspector", query = "SELECT g FROM GlobContract g WHERE g.commentsLeadInspector = :commentsLeadInspector")
    , @NamedQuery(name = "GlobContract.findByCommentsInspector", query = "SELECT g FROM GlobContract g WHERE g.commentsInspector = :commentsInspector")
    , @NamedQuery(name = "GlobContract.findByCommentsSet", query = "SELECT g FROM GlobContract g WHERE g.commentsSet = :commentsSet")
    , @NamedQuery(name = "GlobContract.findByCommentsChiefInspections", query = "SELECT g FROM GlobContract g WHERE g.commentsChiefInspections = :commentsChiefInspections")
    , @NamedQuery(name = "GlobContract.findByInclementWeatherDays", query = "SELECT g FROM GlobContract g WHERE g.inclementWeatherDays = :inclementWeatherDays")
    , @NamedQuery(name = "GlobContract.findByIncentiveDays", query = "SELECT g FROM GlobContract g WHERE g.incentiveDays = :incentiveDays")
    , @NamedQuery(name = "GlobContract.findBySubcompInspectionDate", query = "SELECT g FROM GlobContract g WHERE g.subcompInspectionDate = :subcompInspectionDate")
    , @NamedQuery(name = "GlobContract.findByAuthorizedAmount", query = "SELECT g FROM GlobContract g WHERE g.authorizedAmount = :authorizedAmount")
    , @NamedQuery(name = "GlobContract.findByPoDate", query = "SELECT g FROM GlobContract g WHERE g.poDate = :poDate")
    , @NamedQuery(name = "GlobContract.findByContractorPoDate", query = "SELECT g FROM GlobContract g WHERE g.contractorPoDate = :contractorPoDate")
    , @NamedQuery(name = "GlobContract.findByConsultantPoDate", query = "SELECT g FROM GlobContract g WHERE g.consultantPoDate = :consultantPoDate")
    , @NamedQuery(name = "GlobContract.findByMatlLabPoDate", query = "SELECT g FROM GlobContract g WHERE g.matlLabPoDate = :matlLabPoDate")
    , @NamedQuery(name = "GlobContract.findByAnticipatedCompletionDate", query = "SELECT g FROM GlobContract g WHERE g.anticipatedCompletionDate = :anticipatedCompletionDate")
    , @NamedQuery(name = "GlobContract.findByGlKey", query = "SELECT g FROM GlobContract g WHERE g.glKey = :glKey")
    , @NamedQuery(name = "GlobContract.findByGlObj", query = "SELECT g FROM GlobContract g WHERE g.glObj = :glObj")
    , @NamedQuery(name = "GlobContract.findByJlKey", query = "SELECT g FROM GlobContract g WHERE g.jlKey = :jlKey")
    , @NamedQuery(name = "GlobContract.findByJlObj", query = "SELECT g FROM GlobContract g WHERE g.jlObj = :jlObj")
    , @NamedQuery(name = "GlobContract.findByGlObjRet", query = "SELECT g FROM GlobContract g WHERE g.glObjRet = :glObjRet")
    , @NamedQuery(name = "GlobContract.findBySubcompRoadbridgeDate", query = "SELECT g FROM GlobContract g WHERE g.subcompRoadbridgeDate = :subcompRoadbridgeDate")
    , @NamedQuery(name = "GlobContract.findByPersonEnvironEng", query = "SELECT g FROM GlobContract g WHERE g.personEnvironEng = :personEnvironEng")
    , @NamedQuery(name = "GlobContract.findByInsurexpdateTmp", query = "SELECT g FROM GlobContract g WHERE g.insurexpdateTmp = :insurexpdateTmp")
    , @NamedQuery(name = "GlobContract.findByCalendarId", query = "SELECT g FROM GlobContract g WHERE g.calendarId = :calendarId")
    , @NamedQuery(name = "GlobContract.findByLocationKey", query = "SELECT g FROM GlobContract g WHERE g.locationKey = :locationKey")
    , @NamedQuery(name = "GlobContract.findByPersonCmInspector", query = "SELECT g FROM GlobContract g WHERE g.personCmInspector = :personCmInspector")
    , @NamedQuery(name = "GlobContract.findByPersonCmSrInspector", query = "SELECT g FROM GlobContract g WHERE g.personCmSrInspector = :personCmSrInspector")
    , @NamedQuery(name = "GlobContract.findByPersonCmPManager", query = "SELECT g FROM GlobContract g WHERE g.personCmPManager = :personCmPManager")
    , @NamedQuery(name = "GlobContract.findByContractorType", query = "SELECT g FROM GlobContract g WHERE g.contractorType = :contractorType")
    , @NamedQuery(name = "GlobContract.findByOldAccountNo", query = "SELECT g FROM GlobContract g WHERE g.oldAccountNo = :oldAccountNo")
    , @NamedQuery(name = "GlobContract.findByMinuteNumber", query = "SELECT g FROM GlobContract g WHERE g.minuteNumber = :minuteNumber")
    , @NamedQuery(name = "GlobContract.findByCutoffDateTmp", query = "SELECT g FROM GlobContract g WHERE g.cutoffDateTmp = :cutoffDateTmp")
    , @NamedQuery(name = "GlobContract.findByAwardOrdinanceDateTmp", query = "SELECT g FROM GlobContract g WHERE g.awardOrdinanceDateTmp = :awardOrdinanceDateTmp")
    , @NamedQuery(name = "GlobContract.findByStartingDateTmp", query = "SELECT g FROM GlobContract g WHERE g.startingDateTmp = :startingDateTmp")
    , @NamedQuery(name = "GlobContract.findByRemarks", query = "SELECT g FROM GlobContract g WHERE g.remarks = :remarks")
    , @NamedQuery(name = "GlobContract.findByNtpLetterDateTmp", query = "SELECT g FROM GlobContract g WHERE g.ntpLetterDateTmp = :ntpLetterDateTmp")
    , @NamedQuery(name = "GlobContract.findBySubcompdateTmp", query = "SELECT g FROM GlobContract g WHERE g.subcompdateTmp = :subcompdateTmp")
    , @NamedQuery(name = "GlobContract.findByDrugpdateTmp", query = "SELECT g FROM GlobContract g WHERE g.drugpdateTmp = :drugpdateTmp")
    , @NamedQuery(name = "GlobContract.findBySupplOrdinanceDateTmp", query = "SELECT g FROM GlobContract g WHERE g.supplOrdinanceDateTmp = :supplOrdinanceDateTmp")
    , @NamedQuery(name = "GlobContract.findByCDateTmp", query = "SELECT g FROM GlobContract g WHERE g.cDateTmp = :cDateTmp")
    , @NamedQuery(name = "GlobContract.findByPersonEngineer", query = "SELECT g FROM GlobContract g WHERE g.personEngineer = :personEngineer")
    , @NamedQuery(name = "GlobContract.findByContractType", query = "SELECT g FROM GlobContract g WHERE g.contractType = :contractType")
    , @NamedQuery(name = "GlobContract.findByAlertCostexp", query = "SELECT g FROM GlobContract g WHERE g.alertCostexp = :alertCostexp")
    , @NamedQuery(name = "GlobContract.findByPersonCManager", query = "SELECT g FROM GlobContract g WHERE g.personCManager = :personCManager")
    , @NamedQuery(name = "GlobContract.findByPersonAManager", query = "SELECT g FROM GlobContract g WHERE g.personAManager = :personAManager")
    , @NamedQuery(name = "GlobContract.findByPersonAdmin", query = "SELECT g FROM GlobContract g WHERE g.personAdmin = :personAdmin")
    , @NamedQuery(name = "GlobContract.findByPersonAdminA", query = "SELECT g FROM GlobContract g WHERE g.personAdminA = :personAdminA")
    , @NamedQuery(name = "GlobContract.findByPersonCtSrpm", query = "SELECT g FROM GlobContract g WHERE g.personCtSrpm = :personCtSrpm")
    , @NamedQuery(name = "GlobContract.findByPersonCtPm", query = "SELECT g FROM GlobContract g WHERE g.personCtPm = :personCtPm")
    , @NamedQuery(name = "GlobContract.findByPersonCtSupt", query = "SELECT g FROM GlobContract g WHERE g.personCtSupt = :personCtSupt")
    , @NamedQuery(name = "GlobContract.findByPersonCtSuptA", query = "SELECT g FROM GlobContract g WHERE g.personCtSuptA = :personCtSuptA")
    , @NamedQuery(name = "GlobContract.findByPersonCnLeadc", query = "SELECT g FROM GlobContract g WHERE g.personCnLeadc = :personCnLeadc")
    , @NamedQuery(name = "GlobContract.findByPersonCnSubc", query = "SELECT g FROM GlobContract g WHERE g.personCnSubc = :personCnSubc")
    , @NamedQuery(name = "GlobContract.findByPersonCnInspector", query = "SELECT g FROM GlobContract g WHERE g.personCnInspector = :personCnInspector")
    , @NamedQuery(name = "GlobContract.findByPersonCtPmA", query = "SELECT g FROM GlobContract g WHERE g.personCtPmA = :personCtPmA")
    , @NamedQuery(name = "GlobContract.findByInsureTaxBenOnLabor", query = "SELECT g FROM GlobContract g WHERE g.insureTaxBenOnLabor = :insureTaxBenOnLabor")
    , @NamedQuery(name = "GlobContract.findByOverhead", query = "SELECT g FROM GlobContract g WHERE g.overhead = :overhead")
    , @NamedQuery(name = "GlobContract.findByBond", query = "SELECT g FROM GlobContract g WHERE g.bond = :bond")
    , @NamedQuery(name = "GlobContract.findByPmProblems", query = "SELECT g FROM GlobContract g WHERE g.pmProblems = :pmProblems")
    , @NamedQuery(name = "GlobContract.findByPersonContractorContact2", query = "SELECT g FROM GlobContract g WHERE g.personContractorContact2 = :personContractorContact2")
    , @NamedQuery(name = "GlobContract.findByDesignConsultant2", query = "SELECT g FROM GlobContract g WHERE g.designConsultant2 = :designConsultant2")
    , @NamedQuery(name = "GlobContract.findByPersonConsultantContact2", query = "SELECT g FROM GlobContract g WHERE g.personConsultantContact2 = :personConsultantContact2")
    , @NamedQuery(name = "GlobContract.findByPersonContractorNextel", query = "SELECT g FROM GlobContract g WHERE g.personContractorNextel = :personContractorNextel")
    , @NamedQuery(name = "GlobContract.findByPersonCmFirmNextel", query = "SELECT g FROM GlobContract g WHERE g.personCmFirmNextel = :personCmFirmNextel")
    , @NamedQuery(name = "GlobContract.findByPersonInspector2", query = "SELECT g FROM GlobContract g WHERE g.personInspector2 = :personInspector2")
    , @NamedQuery(name = "GlobContract.findByPersonConstrProjectManager", query = "SELECT g FROM GlobContract g WHERE g.personConstrProjectManager = :personConstrProjectManager")
    , @NamedQuery(name = "GlobContract.findByPersonPManager2", query = "SELECT g FROM GlobContract g WHERE g.personPManager2 = :personPManager2")
    , @NamedQuery(name = "GlobContract.findByPersonSrInspector2", query = "SELECT g FROM GlobContract g WHERE g.personSrInspector2 = :personSrInspector2")
    , @NamedQuery(name = "GlobContract.findByPersonInspector3", query = "SELECT g FROM GlobContract g WHERE g.personInspector3 = :personInspector3")
    , @NamedQuery(name = "GlobContract.findByPersonInspector4", query = "SELECT g FROM GlobContract g WHERE g.personInspector4 = :personInspector4")
    , @NamedQuery(name = "GlobContract.findByPersonInspector5", query = "SELECT g FROM GlobContract g WHERE g.personInspector5 = :personInspector5")
    , @NamedQuery(name = "GlobContract.findByPersonInspector6", query = "SELECT g FROM GlobContract g WHERE g.personInspector6 = :personInspector6")
    , @NamedQuery(name = "GlobContract.findByPersonInspector7", query = "SELECT g FROM GlobContract g WHERE g.personInspector7 = :personInspector7")
    , @NamedQuery(name = "GlobContract.findByPersonInspector8", query = "SELECT g FROM GlobContract g WHERE g.personInspector8 = :personInspector8")
    , @NamedQuery(name = "GlobContract.findByPersonInspector9", query = "SELECT g FROM GlobContract g WHERE g.personInspector9 = :personInspector9")
    , @NamedQuery(name = "GlobContract.findByPersonInspector10", query = "SELECT g FROM GlobContract g WHERE g.personInspector10 = :personInspector10")
    , @NamedQuery(name = "GlobContract.findByPersonInspector11", query = "SELECT g FROM GlobContract g WHERE g.personInspector11 = :personInspector11")
    , @NamedQuery(name = "GlobContract.findByPersonInspector12", query = "SELECT g FROM GlobContract g WHERE g.personInspector12 = :personInspector12")
    , @NamedQuery(name = "GlobContract.findByPersonInspector13", query = "SELECT g FROM GlobContract g WHERE g.personInspector13 = :personInspector13")
    , @NamedQuery(name = "GlobContract.findByPersonInspector14", query = "SELECT g FROM GlobContract g WHERE g.personInspector14 = :personInspector14")
    , @NamedQuery(name = "GlobContract.findByPersonInspector15", query = "SELECT g FROM GlobContract g WHERE g.personInspector15 = :personInspector15")
    , @NamedQuery(name = "GlobContract.findByPersonInspector16", query = "SELECT g FROM GlobContract g WHERE g.personInspector16 = :personInspector16")
    , @NamedQuery(name = "GlobContract.findByPersonInspector17", query = "SELECT g FROM GlobContract g WHERE g.personInspector17 = :personInspector17")
    , @NamedQuery(name = "GlobContract.findByPersonSrInspector3", query = "SELECT g FROM GlobContract g WHERE g.personSrInspector3 = :personSrInspector3")
    , @NamedQuery(name = "GlobContract.findByPersonLeadSupervisor", query = "SELECT g FROM GlobContract g WHERE g.personLeadSupervisor = :personLeadSupervisor")
    , @NamedQuery(name = "GlobContract.findByPersonDeputyDirector", query = "SELECT g FROM GlobContract g WHERE g.personDeputyDirector = :personDeputyDirector")
    , @NamedQuery(name = "GlobContract.findByPersonDeptManager", query = "SELECT g FROM GlobContract g WHERE g.personDeptManager = :personDeptManager")
    , @NamedQuery(name = "GlobContract.findByPersonFieldOpsManager", query = "SELECT g FROM GlobContract g WHERE g.personFieldOpsManager = :personFieldOpsManager")
    , @NamedQuery(name = "GlobContract.findByPersonSupervisor1", query = "SELECT g FROM GlobContract g WHERE g.personSupervisor1 = :personSupervisor1")
    , @NamedQuery(name = "GlobContract.findByPersonSupervisor2", query = "SELECT g FROM GlobContract g WHERE g.personSupervisor2 = :personSupervisor2")
    , @NamedQuery(name = "GlobContract.findByPersonPropertyManager", query = "SELECT g FROM GlobContract g WHERE g.personPropertyManager = :personPropertyManager")
    , @NamedQuery(name = "GlobContract.findByCType", query = "SELECT g FROM GlobContract g WHERE g.cType = :cType")
    , @NamedQuery(name = "GlobContract.findByOwner", query = "SELECT g FROM GlobContract g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobContract.findByOwnerFk", query = "SELECT g FROM GlobContract g WHERE g.ownerFk = :ownerFk")
    , @NamedQuery(name = "GlobContract.findByInclementWeatherDaysCur", query = "SELECT g FROM GlobContract g WHERE g.inclementWeatherDaysCur = :inclementWeatherDaysCur")
    , @NamedQuery(name = "GlobContract.findByLastMod", query = "SELECT g FROM GlobContract g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobContract.findByLastModBy", query = "SELECT g FROM GlobContract g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobContract.findByLastModIp", query = "SELECT g FROM GlobContract g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobContract.findByCreateDate", query = "SELECT g FROM GlobContract g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobContract.findByCreateBy", query = "SELECT g FROM GlobContract g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobContract.findByCreateByIp", query = "SELECT g FROM GlobContract g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobContract.findByVersion", query = "SELECT g FROM GlobContract g WHERE g.version = :version")
    , @NamedQuery(name = "GlobContract.findByMultipleDaily", query = "SELECT g FROM GlobContract g WHERE g.multipleDaily = :multipleDaily")
    , @NamedQuery(name = "GlobContract.findByPersonInspector18", query = "SELECT g FROM GlobContract g WHERE g.personInspector18 = :personInspector18")
    , @NamedQuery(name = "GlobContract.findByPersonInspector19", query = "SELECT g FROM GlobContract g WHERE g.personInspector19 = :personInspector19")
    , @NamedQuery(name = "GlobContract.findByPersonInspector20", query = "SELECT g FROM GlobContract g WHERE g.personInspector20 = :personInspector20")
    , @NamedQuery(name = "GlobContract.findByPersonInspector21", query = "SELECT g FROM GlobContract g WHERE g.personInspector21 = :personInspector21")
    , @NamedQuery(name = "GlobContract.findByHasIncWeather", query = "SELECT g FROM GlobContract g WHERE g.hasIncWeather = :hasIncWeather")
    , @NamedQuery(name = "GlobContract.findByDesignConsultant3", query = "SELECT g FROM GlobContract g WHERE g.designConsultant3 = :designConsultant3")
    , @NamedQuery(name = "GlobContract.findByPersonConsultantContact3", query = "SELECT g FROM GlobContract g WHERE g.personConsultantContact3 = :personConsultantContact3")
    , @NamedQuery(name = "GlobContract.findByPersonContractorContact3", query = "SELECT g FROM GlobContract g WHERE g.personContractorContact3 = :personContractorContact3")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTRACT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContract.findAll", query = "SELECT g FROM GlobContract g"),
    @NamedQuery(name = "GlobContract.findById", query = "SELECT g FROM GlobContract g WHERE g.id = :id")})
public class GlobContract implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "C_NUMBER")
    private String cNumber;
    @Column(name = "C_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cDate;
    @Size(max = 255)
    @Column(name = "C_NAME")
    private String cName;
    @Column(name = "C_AMOUNT")
    private Double cAmount;
    @Column(name = "C_DAYS")
    private BigInteger cDays;
    @Column(name = "STARTING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;
    @Column(name = "CUTOFF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cutoffDate;
    @Size(max = 50)
    @Column(name = "P_MANAGER")
    private String pManager;
    @Size(max = 50)
    @Column(name = "INSPECTOR")
    private String inspector;
    @Size(max = 50)
    @Column(name = "ESTIMATOR")
    private String estimator;
    @Size(max = 4000)
    @Column(name = "KEY_MAP")
    private String keyMap;
    @Size(max = 50)
    @Column(name = "DRAWG_NO")
    private String drawgNo;
    @Size(max = 15)
    @Column(name = "WMBE")
    private String wmbe;
    @Column(name = "DAMAGES_PER_DAY")
    private Double damagesPerDay;
    @Column(name = "NTP_LETTER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ntpLetterDate;
    @Column(name = "PRE_CONSTRUCTION_MEETING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preConstructionMeetingDate;
    @Size(max = 250)
    @Column(name = "PRE_CONSTRUCTION_MEETING_LOC")
    private String preConstructionMeetingLoc;
    @Column(name = "SUBCOMPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subcompdate;
    @Column(name = "INSUREXPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insurexpdate;
    @Column(name = "DRUGPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date drugpdate;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 4000)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    private Double field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Size(max = 50)
    @Column(name = "C_STATUS")
    private String cStatus;
    @Column(name = "SYSTEM")
    private Character system;
    @Column(name = "MODULELIST_ID")
    private BigInteger modulelistId;
    @Column(name = "CONTACT_ID")
    private BigInteger contactId;
    @Column(name = "DESIGN_CONSULTANT")
    private BigInteger designConsultant;
    @Size(max = 150)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Size(max = 150)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Size(max = 150)
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;
    @Size(max = 50)
    @Column(name = "AWARD_ORDINANCE_NUM")
    private String awardOrdinanceNum;
    @Column(name = "AWARD_ORDINANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date awardOrdinanceDate;
    @Column(name = "AWARD_ORDINANCE_AMOUNT")
    private Double awardOrdinanceAmount;
    @Size(max = 50)
    @Column(name = "SUPPL_ORDINANCE_NUM")
    private String supplOrdinanceNum;
    @Column(name = "SUPPL_ORDINANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supplOrdinanceDate;
    @Column(name = "SUPPL_ORDINANCE_AMOUNT")
    private Double supplOrdinanceAmount;
    @Column(name = "BASIC_PHASE1")
    private Double basicPhase1;
    @Column(name = "BASIC_PHASE2")
    private Double basicPhase2;
    @Column(name = "BASIC_PHASE3")
    private Double basicPhase3;
    @Column(name = "BASIC_TOTAL")
    private Double basicTotal;
    @Column(name = "ADD_GEOTECH")
    private Double addGeotech;
    @Column(name = "ADD_SURVEY")
    private Double addSurvey;
    @Column(name = "ADD_ENVIRON")
    private Double addEnviron;
    @Column(name = "ADD_OTHER")
    private Double addOther;
    @Column(name = "ADD_TOTAL")
    private Double addTotal;
    @Size(max = 50)
    @Column(name = "TMP_ESTIMATER")
    private String tmpEstimater;
    @Size(max = 50)
    @Column(name = "TMP_INSPECTOR")
    private String tmpInspector;
    @Column(name = "PERSON_P_MANAGER")
    private BigInteger personPManager;
    @Column(name = "PERSON_INSPECTOR")
    private BigInteger personInspector;
    @Column(name = "PERSON_ESTIMATOR")
    private BigInteger personEstimator;
    @Size(max = 50)
    @Column(name = "FILE_NO")
    private String fileNo;
    @Size(max = 250)
    @Column(name = "GIMS_MAPS")
    private String gimsMaps;
    @Size(max = 250)
    @Column(name = "SUPER_NEIB")
    private String superNeib;
    @Size(max = 50)
    @Column(name = "COUNCIL_DIST")
    private String councilDist;
    @Column(name = "ADD_TRAFFIC")
    private Double addTraffic;
    @Column(name = "ADD_SWPPP")
    private Double addSwppp;
    @Column(name = "PROJ_CLOSE_AMT")
    private Double projCloseAmt;
    @Size(max = 200)
    @Column(name = "ROAD_BLOCK_DIRECTOR")
    private String roadBlockDirector;
    @Size(max = 4000)
    @Column(name = "DIR_RPT_COMMENTS")
    private String dirRptComments;
    @Size(max = 4000)
    @Column(name = "PM_COMMENTS")
    private String pmComments;
    @Column(name = "AGREED_ESTIMATE")
    private BigDecimal agreedEstimate;
    @Column(name = "EST_CONST_COST")
    private BigDecimal estConstCost;
    @Column(name = "ADOPTED_CONS_AMT")
    private BigDecimal adoptedConsAmt;
    @Column(name = "ADOPTED_ACQ_AMT")
    private BigDecimal adoptedAcqAmt;
    @Column(name = "EST_CONS_COST")
    private BigDecimal estConsCost;
    @Column(name = "EST_ACQ_COST")
    private BigDecimal estAcqCost;
    @Size(max = 50)
    @Column(name = "CM_P_MANAGER")
    private String cmPManager;
    @Size(max = 50)
    @Column(name = "CM_SR_INSPECTOR")
    private String cmSrInspector;
    @Size(max = 50)
    @Column(name = "CM_INSPECTOR")
    private String cmInspector;
    @Size(max = 255)
    @Column(name = "CONSTRUCTION_GFS_NO")
    private String constructionGfsNo;
    @Column(name = "DESIGN_PROJECT_AMOUNT")
    private BigDecimal designProjectAmount;
    @Column(name = "PARCELS_REQUIRED")
    private Integer parcelsRequired;
    @Column(name = "C_FISCAL_YEAR")
    private BigInteger cFiscalYear;
    @Column(name = "D_FISCAL_YEAR")
    private BigInteger dFiscalYear;
    @Column(name = "C_APP_AMOUNT_P")
    private BigDecimal cAppAmountP;
    @Column(name = "C_APP_AMOUNT_A")
    private BigDecimal cAppAmountA;
    @Column(name = "C_LOW_BID")
    private BigDecimal cLowBid;
    @Column(name = "D_FEE_A")
    private BigDecimal dFeeA;
    @Size(max = 250)
    @Column(name = "D_ORDINANCE")
    private String dOrdinance;
    @Size(max = 50)
    @Column(name = "PURCHASE_ORDER_NO")
    private String purchaseOrderNo;
    @Size(max = 50)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Column(name = "LAB_C_AMOUNT")
    private Double labCAmount;
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;
    @Size(max = 4000)
    @Column(name = "C_DESCRIPTION")
    private String cDescription;
    @Size(max = 256)
    @Column(name = "JOB_NO")
    private String jobNo;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 256)
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    @Column(name = "AMENDMENTS")
    private BigInteger amendments;
    @Column(name = "SUPPLEMENTS")
    private BigInteger supplements;
    @Size(max = 256)
    @Column(name = "PM_CONTACT_PHONE_NO_CELL")
    private String pmContactPhoneNoCell;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "PERSON_ENGINEER_ADMIN")
    private BigInteger personEngineerAdmin;
    @Column(name = "PERSON_COORDINATOR")
    private BigInteger personCoordinator;
    @Column(name = "PERSON_ADMINISTRATOR")
    private BigInteger personAdministrator;
    @Size(max = 256)
    @Column(name = "STATION_BEGIN")
    private String stationBegin;
    @Size(max = 256)
    @Column(name = "STATION_END")
    private String stationEnd;
    @Size(max = 256)
    @Column(name = "LAT")
    private String lat;
    @Size(max = 256)
    @Column(name = "LON")
    private String lon;
    @Column(name = "MANAGE_FIRM_ID")
    private BigInteger manageFirmId;
    @Column(name = "PERSON_COORDINATOR_UTILITY")
    private BigInteger personCoordinatorUtility;
    @Column(name = "PERSON_COORDINATOR_ROW")
    private BigInteger personCoordinatorRow;
    @Column(name = "CM_FIRM_ID")
    private BigInteger cmFirmId;
    @Column(name = "PERSON_SR_INSPECTOR")
    private BigInteger personSrInspector;
    @Column(name = "PERSON_CM_FIRM_CONTACT")
    private BigInteger personCmFirmContact;
    @Column(name = "TIME_SUSPENSION")
    private BigInteger timeSuspension;
    @Column(name = "APPROVED_HOLIDAYS")
    private BigInteger approvedHolidays;
    @Size(max = 10)
    @Column(name = "BEHIND_SCHEDULE")
    private String behindSchedule;
    @Column(name = "PAID_TODATE")
    private Double paidTodate;
    @Size(max = 50)
    @Column(name = "APIN_NO")
    private String apinNo;
    @Column(name = "INCENTIVE")
    private Double incentive;
    @Column(name = "PERSON_SET")
    private BigInteger personSet;
    @Column(name = "PERSON_MANAGER")
    private BigInteger personManager;
    @Column(name = "PERSON_CHIEF_INSPECTIONS")
    private BigInteger personChiefInspections;
    @Column(name = "PERSON_CONTRACTOR_CONTACT")
    private BigInteger personContractorContact;
    @Column(name = "PERSON_CONSULTANT_CONTACT")
    private BigInteger personConsultantContact;
    @Column(name = "PERSON_LAB_CONTACT")
    private BigInteger personLabContact;
    @Size(max = 4000)
    @Column(name = "COMMENTS_MANAGER")
    private String commentsManager;
    @Size(max = 4000)
    @Column(name = "COMMENTS_LEAD_INSPECTOR")
    private String commentsLeadInspector;
    @Size(max = 4000)
    @Column(name = "COMMENTS_INSPECTOR")
    private String commentsInspector;
    @Size(max = 4000)
    @Column(name = "COMMENTS_SET")
    private String commentsSet;
    @Size(max = 4000)
    @Column(name = "COMMENTS_CHIEF_INSPECTIONS")
    private String commentsChiefInspections;
    @Column(name = "INCLEMENT_WEATHER_DAYS")
    private BigInteger inclementWeatherDays;
    @Column(name = "INCENTIVE_DAYS")
    private BigInteger incentiveDays;
    @Column(name = "SUBCOMP_INSPECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subcompInspectionDate;
    @Column(name = "AUTHORIZED_AMOUNT")
    private Double authorizedAmount;
    @Column(name = "PO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date poDate;
    @Column(name = "CONTRACTOR_PO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractorPoDate;
    @Column(name = "CONSULTANT_PO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consultantPoDate;
    @Column(name = "MATL_LAB_PO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matlLabPoDate;
    @Column(name = "ANTICIPATED_COMPLETION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anticipatedCompletionDate;
    @Size(max = 200)
    @Column(name = "GL_KEY")
    private String glKey;
    @Size(max = 200)
    @Column(name = "GL_OBJ")
    private String glObj;
    @Size(max = 200)
    @Column(name = "JL_KEY")
    private String jlKey;
    @Size(max = 200)
    @Column(name = "JL_OBJ")
    private String jlObj;
    @Size(max = 200)
    @Column(name = "GL_OBJ_RET")
    private String glObjRet;
    @Column(name = "SUBCOMP_ROADBRIDGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subcompRoadbridgeDate;
    @Column(name = "PERSON_ENVIRON_ENG")
    private BigInteger personEnvironEng;
    @Size(max = 4000)
    @Column(name = "INSUREXPDATE_TMP")
    private String insurexpdateTmp;
    @Column(name = "CALENDAR_ID")
    private BigInteger calendarId;
    @Size(max = 255)
    @Column(name = "LOCATION_KEY")
    private String locationKey;
    @Column(name = "PERSON_CM_INSPECTOR")
    private BigInteger personCmInspector;
    @Column(name = "PERSON_CM_SR_INSPECTOR")
    private BigInteger personCmSrInspector;
    @Column(name = "PERSON_CM_P_MANAGER")
    private BigInteger personCmPManager;
    @Column(name = "CONTRACTOR_TYPE")
    private Character contractorType;
    @Size(max = 128)
    @Column(name = "OLD_ACCOUNT_NO")
    private String oldAccountNo;
    @Size(max = 128)
    @Column(name = "MINUTE_NUMBER")
    private String minuteNumber;
    @Size(max = 50)
    @Column(name = "CUTOFF_DATE_TMP")
    private String cutoffDateTmp;
    @Size(max = 4000)
    @Column(name = "AWARD_ORDINANCE_DATE_TMP")
    private String awardOrdinanceDateTmp;
    @Size(max = 50)
    @Column(name = "STARTING_DATE_TMP")
    private String startingDateTmp;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "NTP_LETTER_DATE_TMP")
    private String ntpLetterDateTmp;
    @Size(max = 4000)
    @Column(name = "SUBCOMPDATE_TMP")
    private String subcompdateTmp;
    @Size(max = 4000)
    @Column(name = "DRUGPDATE_TMP")
    private String drugpdateTmp;
    @Size(max = 4000)
    @Column(name = "SUPPL_ORDINANCE_DATE_TMP")
    private String supplOrdinanceDateTmp;
    @Size(max = 50)
    @Column(name = "C_DATE_TMP")
    private String cDateTmp;
    @Column(name = "PERSON_ENGINEER")
    private BigInteger personEngineer;
    @Size(max = 50)
    @Column(name = "CONTRACT_TYPE")
    private String contractType;
    @Size(max = 50)
    @Column(name = "ALERT_COSTEXP")
    private String alertCostexp;
    @Column(name = "PERSON_C_MANAGER")
    private BigInteger personCManager;
    @Column(name = "PERSON_A_MANAGER")
    private BigInteger personAManager;
    @Column(name = "PERSON_ADMIN")
    private BigInteger personAdmin;
    @Column(name = "PERSON_ADMIN_A")
    private BigInteger personAdminA;
    @Column(name = "PERSON_CT_SRPM")
    private BigInteger personCtSrpm;
    @Column(name = "PERSON_CT_PM")
    private BigInteger personCtPm;
    @Column(name = "PERSON_CT_SUPT")
    private BigInteger personCtSupt;
    @Column(name = "PERSON_CT_SUPT_A")
    private BigInteger personCtSuptA;
    @Column(name = "PERSON_CN_LEADC")
    private BigInteger personCnLeadc;
    @Column(name = "PERSON_CN_SUBC")
    private BigInteger personCnSubc;
    @Column(name = "PERSON_CN_INSPECTOR")
    private BigInteger personCnInspector;
    @Column(name = "PERSON_CT_PM_A")
    private BigInteger personCtPmA;
    @Column(name = "INSURE_TAX_BEN_ON_LABOR")
    private Double insureTaxBenOnLabor;
    @Column(name = "OVERHEAD")
    private Double overhead;
    @Column(name = "BOND")
    private Double bond;
    @Size(max = 4000)
    @Column(name = "PM_PROBLEMS")
    private String pmProblems;
    @Column(name = "PERSON_CONTRACTOR_CONTACT2")
    private BigInteger personContractorContact2;
    @Column(name = "DESIGN_CONSULTANT2")
    private BigInteger designConsultant2;
    @Column(name = "PERSON_CONSULTANT_CONTACT2")
    private BigInteger personConsultantContact2;
    @Size(max = 50)
    @Column(name = "PERSON_CONTRACTOR_NEXTEL")
    private String personContractorNextel;
    @Size(max = 50)
    @Column(name = "PERSON_CM_FIRM_NEXTEL")
    private String personCmFirmNextel;
    @Column(name = "PERSON_INSPECTOR2")
    private BigInteger personInspector2;
    @Column(name = "PERSON_CONSTR_PROJECT_MANAGER")
    private BigInteger personConstrProjectManager;
    @Column(name = "PERSON_P_MANAGER2")
    private BigInteger personPManager2;
    @Column(name = "PERSON_SR_INSPECTOR2")
    private BigInteger personSrInspector2;
    @Column(name = "PERSON_INSPECTOR3")
    private BigInteger personInspector3;
    @Column(name = "PERSON_INSPECTOR4")
    private BigInteger personInspector4;
    @Column(name = "PERSON_INSPECTOR5")
    private BigInteger personInspector5;
    @Column(name = "PERSON_INSPECTOR6")
    private BigInteger personInspector6;
    @Column(name = "PERSON_INSPECTOR7")
    private BigInteger personInspector7;
    @Column(name = "PERSON_INSPECTOR8")
    private BigInteger personInspector8;
    @Column(name = "PERSON_INSPECTOR9")
    private BigInteger personInspector9;
    @Column(name = "PERSON_INSPECTOR10")
    private BigInteger personInspector10;
    @Column(name = "PERSON_INSPECTOR11")
    private BigInteger personInspector11;
    @Column(name = "PERSON_INSPECTOR12")
    private BigInteger personInspector12;
    @Column(name = "PERSON_INSPECTOR13")
    private BigInteger personInspector13;
    @Column(name = "PERSON_INSPECTOR14")
    private BigInteger personInspector14;
    @Column(name = "PERSON_INSPECTOR15")
    private BigInteger personInspector15;
    @Column(name = "PERSON_INSPECTOR16")
    private BigInteger personInspector16;
    @Column(name = "PERSON_INSPECTOR17")
    private BigInteger personInspector17;
    @Column(name = "PERSON_SR_INSPECTOR3")
    private BigInteger personSrInspector3;
    @Column(name = "PERSON_LEAD_SUPERVISOR")
    private BigInteger personLeadSupervisor;
    @Column(name = "PERSON_DEPUTY_DIRECTOR")
    private BigInteger personDeputyDirector;
    @Column(name = "PERSON_DEPT_MANAGER")
    private BigInteger personDeptManager;
    @Column(name = "PERSON_FIELD_OPS_MANAGER")
    private BigInteger personFieldOpsManager;
    @Column(name = "PERSON_SUPERVISOR1")
    private BigInteger personSupervisor1;
    @Column(name = "PERSON_SUPERVISOR2")
    private BigInteger personSupervisor2;
    @Column(name = "PERSON_PROPERTY_MANAGER")
    private BigInteger personPropertyManager;
    @Size(max = 50)
    @Column(name = "C_TYPE")
    private String cType;
    @Size(max = 50)
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "OWNER_FK")
    private BigInteger ownerFk;
    @Column(name = "INCLEMENT_WEATHER_DAYS_CUR")
    private BigInteger inclementWeatherDaysCur;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 10)
    @Column(name = "MULTIPLE_DAILY")
    private String multipleDaily;
    @Column(name = "PERSON_INSPECTOR18")
    private BigInteger personInspector18;
    @Column(name = "PERSON_INSPECTOR19")
    private BigInteger personInspector19;
    @Column(name = "PERSON_INSPECTOR20")
    private BigInteger personInspector20;
    @Column(name = "PERSON_INSPECTOR21")
    private BigInteger personInspector21;
    @Size(max = 10)
    @Column(name = "HAS_INC_WEATHER")
    private String hasIncWeather;
    @Column(name = "DESIGN_CONSULTANT3")
    private BigInteger designConsultant3;
    @Column(name = "PERSON_CONSULTANT_CONTACT3")
    private BigInteger personConsultantContact3;
    @Column(name = "PERSON_CONTRACTOR_CONTACT3")
    private BigInteger personContractorContact3;

    public GlobContract() {
    }

    public GlobContract(BigDecimal id) {
        this.id = id;
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

    public String getCNumber() {
        return cNumber;
    }

    public void setCNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Double getCAmount() {
        return cAmount;
    }

    public void setCAmount(Double cAmount) {
        this.cAmount = cAmount;
    }

    public BigInteger getCDays() {
        return cDays;
    }

    public void setCDays(BigInteger cDays) {
        this.cDays = cDays;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(Date cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public String getPManager() {
        return pManager;
    }

    public void setPManager(String pManager) {
        this.pManager = pManager;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getEstimator() {
        return estimator;
    }

    public void setEstimator(String estimator) {
        this.estimator = estimator;
    }

    public String getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(String keyMap) {
        this.keyMap = keyMap;
    }

    public String getDrawgNo() {
        return drawgNo;
    }

    public void setDrawgNo(String drawgNo) {
        this.drawgNo = drawgNo;
    }

    public String getWmbe() {
        return wmbe;
    }

    public void setWmbe(String wmbe) {
        this.wmbe = wmbe;
    }

    public Double getDamagesPerDay() {
        return damagesPerDay;
    }

    public void setDamagesPerDay(Double damagesPerDay) {
        this.damagesPerDay = damagesPerDay;
    }

    public Date getNtpLetterDate() {
        return ntpLetterDate;
    }

    public void setNtpLetterDate(Date ntpLetterDate) {
        this.ntpLetterDate = ntpLetterDate;
    }

    public Date getPreConstructionMeetingDate() {
        return preConstructionMeetingDate;
    }

    public void setPreConstructionMeetingDate(Date preConstructionMeetingDate) {
        this.preConstructionMeetingDate = preConstructionMeetingDate;
    }

    public String getPreConstructionMeetingLoc() {
        return preConstructionMeetingLoc;
    }

    public void setPreConstructionMeetingLoc(String preConstructionMeetingLoc) {
        this.preConstructionMeetingLoc = preConstructionMeetingLoc;
    }

    public Date getSubcompdate() {
        return subcompdate;
    }

    public void setSubcompdate(Date subcompdate) {
        this.subcompdate = subcompdate;
    }

    public Date getInsurexpdate() {
        return insurexpdate;
    }

    public void setInsurexpdate(Date insurexpdate) {
        this.insurexpdate = insurexpdate;
    }

    public Date getDrugpdate() {
        return drugpdate;
    }

    public void setDrugpdate(Date drugpdate) {
        this.drugpdate = drugpdate;
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

    public Double getField6() {
        return field6;
    }

    public void setField6(Double field6) {
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

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public Character getSystem() {
        return system;
    }

    public void setSystem(Character system) {
        this.system = system;
    }

    public BigInteger getModulelistId() {
        return modulelistId;
    }

    public void setModulelistId(BigInteger modulelistId) {
        this.modulelistId = modulelistId;
    }

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public BigInteger getDesignConsultant() {
        return designConsultant;
    }

    public void setDesignConsultant(BigInteger designConsultant) {
        this.designConsultant = designConsultant;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

    public Double getAwardOrdinanceAmount() {
        return awardOrdinanceAmount;
    }

    public void setAwardOrdinanceAmount(Double awardOrdinanceAmount) {
        this.awardOrdinanceAmount = awardOrdinanceAmount;
    }

    public String getSupplOrdinanceNum() {
        return supplOrdinanceNum;
    }

    public void setSupplOrdinanceNum(String supplOrdinanceNum) {
        this.supplOrdinanceNum = supplOrdinanceNum;
    }

    public Date getSupplOrdinanceDate() {
        return supplOrdinanceDate;
    }

    public void setSupplOrdinanceDate(Date supplOrdinanceDate) {
        this.supplOrdinanceDate = supplOrdinanceDate;
    }

    public Double getSupplOrdinanceAmount() {
        return supplOrdinanceAmount;
    }

    public void setSupplOrdinanceAmount(Double supplOrdinanceAmount) {
        this.supplOrdinanceAmount = supplOrdinanceAmount;
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

    public Double getAddOther() {
        return addOther;
    }

    public void setAddOther(Double addOther) {
        this.addOther = addOther;
    }

    public Double getAddTotal() {
        return addTotal;
    }

    public void setAddTotal(Double addTotal) {
        this.addTotal = addTotal;
    }

    public String getTmpEstimater() {
        return tmpEstimater;
    }

    public void setTmpEstimater(String tmpEstimater) {
        this.tmpEstimater = tmpEstimater;
    }

    public String getTmpInspector() {
        return tmpInspector;
    }

    public void setTmpInspector(String tmpInspector) {
        this.tmpInspector = tmpInspector;
    }

    public BigInteger getPersonPManager() {
        return personPManager;
    }

    public void setPersonPManager(BigInteger personPManager) {
        this.personPManager = personPManager;
    }

    public BigInteger getPersonInspector() {
        return personInspector;
    }

    public void setPersonInspector(BigInteger personInspector) {
        this.personInspector = personInspector;
    }

    public BigInteger getPersonEstimator() {
        return personEstimator;
    }

    public void setPersonEstimator(BigInteger personEstimator) {
        this.personEstimator = personEstimator;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getGimsMaps() {
        return gimsMaps;
    }

    public void setGimsMaps(String gimsMaps) {
        this.gimsMaps = gimsMaps;
    }

    public String getSuperNeib() {
        return superNeib;
    }

    public void setSuperNeib(String superNeib) {
        this.superNeib = superNeib;
    }

    public String getCouncilDist() {
        return councilDist;
    }

    public void setCouncilDist(String councilDist) {
        this.councilDist = councilDist;
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

    public Double getProjCloseAmt() {
        return projCloseAmt;
    }

    public void setProjCloseAmt(Double projCloseAmt) {
        this.projCloseAmt = projCloseAmt;
    }

    public String getRoadBlockDirector() {
        return roadBlockDirector;
    }

    public void setRoadBlockDirector(String roadBlockDirector) {
        this.roadBlockDirector = roadBlockDirector;
    }

    public String getDirRptComments() {
        return dirRptComments;
    }

    public void setDirRptComments(String dirRptComments) {
        this.dirRptComments = dirRptComments;
    }

    public String getPmComments() {
        return pmComments;
    }

    public void setPmComments(String pmComments) {
        this.pmComments = pmComments;
    }

    public BigDecimal getAgreedEstimate() {
        return agreedEstimate;
    }

    public void setAgreedEstimate(BigDecimal agreedEstimate) {
        this.agreedEstimate = agreedEstimate;
    }

    public BigDecimal getEstConstCost() {
        return estConstCost;
    }

    public void setEstConstCost(BigDecimal estConstCost) {
        this.estConstCost = estConstCost;
    }

    public BigDecimal getAdoptedConsAmt() {
        return adoptedConsAmt;
    }

    public void setAdoptedConsAmt(BigDecimal adoptedConsAmt) {
        this.adoptedConsAmt = adoptedConsAmt;
    }

    public BigDecimal getAdoptedAcqAmt() {
        return adoptedAcqAmt;
    }

    public void setAdoptedAcqAmt(BigDecimal adoptedAcqAmt) {
        this.adoptedAcqAmt = adoptedAcqAmt;
    }

    public BigDecimal getEstConsCost() {
        return estConsCost;
    }

    public void setEstConsCost(BigDecimal estConsCost) {
        this.estConsCost = estConsCost;
    }

    public BigDecimal getEstAcqCost() {
        return estAcqCost;
    }

    public void setEstAcqCost(BigDecimal estAcqCost) {
        this.estAcqCost = estAcqCost;
    }

    public String getCmPManager() {
        return cmPManager;
    }

    public void setCmPManager(String cmPManager) {
        this.cmPManager = cmPManager;
    }

    public String getCmSrInspector() {
        return cmSrInspector;
    }

    public void setCmSrInspector(String cmSrInspector) {
        this.cmSrInspector = cmSrInspector;
    }

    public String getCmInspector() {
        return cmInspector;
    }

    public void setCmInspector(String cmInspector) {
        this.cmInspector = cmInspector;
    }

    public String getConstructionGfsNo() {
        return constructionGfsNo;
    }

    public void setConstructionGfsNo(String constructionGfsNo) {
        this.constructionGfsNo = constructionGfsNo;
    }

    public BigDecimal getDesignProjectAmount() {
        return designProjectAmount;
    }

    public void setDesignProjectAmount(BigDecimal designProjectAmount) {
        this.designProjectAmount = designProjectAmount;
    }

    public Integer getParcelsRequired() {
        return parcelsRequired;
    }

    public void setParcelsRequired(Integer parcelsRequired) {
        this.parcelsRequired = parcelsRequired;
    }

    public BigInteger getCFiscalYear() {
        return cFiscalYear;
    }

    public void setCFiscalYear(BigInteger cFiscalYear) {
        this.cFiscalYear = cFiscalYear;
    }

    public BigInteger getDFiscalYear() {
        return dFiscalYear;
    }

    public void setDFiscalYear(BigInteger dFiscalYear) {
        this.dFiscalYear = dFiscalYear;
    }

    public BigDecimal getCAppAmountP() {
        return cAppAmountP;
    }

    public void setCAppAmountP(BigDecimal cAppAmountP) {
        this.cAppAmountP = cAppAmountP;
    }

    public BigDecimal getCAppAmountA() {
        return cAppAmountA;
    }

    public void setCAppAmountA(BigDecimal cAppAmountA) {
        this.cAppAmountA = cAppAmountA;
    }

    public BigDecimal getCLowBid() {
        return cLowBid;
    }

    public void setCLowBid(BigDecimal cLowBid) {
        this.cLowBid = cLowBid;
    }

    public BigDecimal getDFeeA() {
        return dFeeA;
    }

    public void setDFeeA(BigDecimal dFeeA) {
        this.dFeeA = dFeeA;
    }

    public String getDOrdinance() {
        return dOrdinance;
    }

    public void setDOrdinance(String dOrdinance) {
        this.dOrdinance = dOrdinance;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getLabCAmount() {
        return labCAmount;
    }

    public void setLabCAmount(Double labCAmount) {
        this.labCAmount = labCAmount;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public BigInteger getAmendments() {
        return amendments;
    }

    public void setAmendments(BigInteger amendments) {
        this.amendments = amendments;
    }

    public BigInteger getSupplements() {
        return supplements;
    }

    public void setSupplements(BigInteger supplements) {
        this.supplements = supplements;
    }

    public String getPmContactPhoneNoCell() {
        return pmContactPhoneNoCell;
    }

    public void setPmContactPhoneNoCell(String pmContactPhoneNoCell) {
        this.pmContactPhoneNoCell = pmContactPhoneNoCell;
    }

    public BigInteger getContractorId() {
        return contractorId;
    }

    public void setContractorId(BigInteger contractorId) {
        this.contractorId = contractorId;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getPersonEngineerAdmin() {
        return personEngineerAdmin;
    }

    public void setPersonEngineerAdmin(BigInteger personEngineerAdmin) {
        this.personEngineerAdmin = personEngineerAdmin;
    }

    public BigInteger getPersonCoordinator() {
        return personCoordinator;
    }

    public void setPersonCoordinator(BigInteger personCoordinator) {
        this.personCoordinator = personCoordinator;
    }

    public BigInteger getPersonAdministrator() {
        return personAdministrator;
    }

    public void setPersonAdministrator(BigInteger personAdministrator) {
        this.personAdministrator = personAdministrator;
    }

    public String getStationBegin() {
        return stationBegin;
    }

    public void setStationBegin(String stationBegin) {
        this.stationBegin = stationBegin;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(String stationEnd) {
        this.stationEnd = stationEnd;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public BigInteger getManageFirmId() {
        return manageFirmId;
    }

    public void setManageFirmId(BigInteger manageFirmId) {
        this.manageFirmId = manageFirmId;
    }

    public BigInteger getPersonCoordinatorUtility() {
        return personCoordinatorUtility;
    }

    public void setPersonCoordinatorUtility(BigInteger personCoordinatorUtility) {
        this.personCoordinatorUtility = personCoordinatorUtility;
    }

    public BigInteger getPersonCoordinatorRow() {
        return personCoordinatorRow;
    }

    public void setPersonCoordinatorRow(BigInteger personCoordinatorRow) {
        this.personCoordinatorRow = personCoordinatorRow;
    }

    public BigInteger getCmFirmId() {
        return cmFirmId;
    }

    public void setCmFirmId(BigInteger cmFirmId) {
        this.cmFirmId = cmFirmId;
    }

    public BigInteger getPersonSrInspector() {
        return personSrInspector;
    }

    public void setPersonSrInspector(BigInteger personSrInspector) {
        this.personSrInspector = personSrInspector;
    }

    public BigInteger getPersonCmFirmContact() {
        return personCmFirmContact;
    }

    public void setPersonCmFirmContact(BigInteger personCmFirmContact) {
        this.personCmFirmContact = personCmFirmContact;
    }

    public BigInteger getTimeSuspension() {
        return timeSuspension;
    }

    public void setTimeSuspension(BigInteger timeSuspension) {
        this.timeSuspension = timeSuspension;
    }

    public BigInteger getApprovedHolidays() {
        return approvedHolidays;
    }

    public void setApprovedHolidays(BigInteger approvedHolidays) {
        this.approvedHolidays = approvedHolidays;
    }

    public String getBehindSchedule() {
        return behindSchedule;
    }

    public void setBehindSchedule(String behindSchedule) {
        this.behindSchedule = behindSchedule;
    }

    public Double getPaidTodate() {
        return paidTodate;
    }

    public void setPaidTodate(Double paidTodate) {
        this.paidTodate = paidTodate;
    }

    public String getApinNo() {
        return apinNo;
    }

    public void setApinNo(String apinNo) {
        this.apinNo = apinNo;
    }

    public Double getIncentive() {
        return incentive;
    }

    public void setIncentive(Double incentive) {
        this.incentive = incentive;
    }

    public BigInteger getPersonSet() {
        return personSet;
    }

    public void setPersonSet(BigInteger personSet) {
        this.personSet = personSet;
    }

    public BigInteger getPersonManager() {
        return personManager;
    }

    public void setPersonManager(BigInteger personManager) {
        this.personManager = personManager;
    }

    public BigInteger getPersonChiefInspections() {
        return personChiefInspections;
    }

    public void setPersonChiefInspections(BigInteger personChiefInspections) {
        this.personChiefInspections = personChiefInspections;
    }

    public BigInteger getPersonContractorContact() {
        return personContractorContact;
    }

    public void setPersonContractorContact(BigInteger personContractorContact) {
        this.personContractorContact = personContractorContact;
    }

    public BigInteger getPersonConsultantContact() {
        return personConsultantContact;
    }

    public void setPersonConsultantContact(BigInteger personConsultantContact) {
        this.personConsultantContact = personConsultantContact;
    }

    public BigInteger getPersonLabContact() {
        return personLabContact;
    }

    public void setPersonLabContact(BigInteger personLabContact) {
        this.personLabContact = personLabContact;
    }

    public String getCommentsManager() {
        return commentsManager;
    }

    public void setCommentsManager(String commentsManager) {
        this.commentsManager = commentsManager;
    }

    public String getCommentsLeadInspector() {
        return commentsLeadInspector;
    }

    public void setCommentsLeadInspector(String commentsLeadInspector) {
        this.commentsLeadInspector = commentsLeadInspector;
    }

    public String getCommentsInspector() {
        return commentsInspector;
    }

    public void setCommentsInspector(String commentsInspector) {
        this.commentsInspector = commentsInspector;
    }

    public String getCommentsSet() {
        return commentsSet;
    }

    public void setCommentsSet(String commentsSet) {
        this.commentsSet = commentsSet;
    }

    public String getCommentsChiefInspections() {
        return commentsChiefInspections;
    }

    public void setCommentsChiefInspections(String commentsChiefInspections) {
        this.commentsChiefInspections = commentsChiefInspections;
    }

    public BigInteger getInclementWeatherDays() {
        return inclementWeatherDays;
    }

    public void setInclementWeatherDays(BigInteger inclementWeatherDays) {
        this.inclementWeatherDays = inclementWeatherDays;
    }

    public BigInteger getIncentiveDays() {
        return incentiveDays;
    }

    public void setIncentiveDays(BigInteger incentiveDays) {
        this.incentiveDays = incentiveDays;
    }

    public Date getSubcompInspectionDate() {
        return subcompInspectionDate;
    }

    public void setSubcompInspectionDate(Date subcompInspectionDate) {
        this.subcompInspectionDate = subcompInspectionDate;
    }

    public Double getAuthorizedAmount() {
        return authorizedAmount;
    }

    public void setAuthorizedAmount(Double authorizedAmount) {
        this.authorizedAmount = authorizedAmount;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public Date getContractorPoDate() {
        return contractorPoDate;
    }

    public void setContractorPoDate(Date contractorPoDate) {
        this.contractorPoDate = contractorPoDate;
    }

    public Date getConsultantPoDate() {
        return consultantPoDate;
    }

    public void setConsultantPoDate(Date consultantPoDate) {
        this.consultantPoDate = consultantPoDate;
    }

    public Date getMatlLabPoDate() {
        return matlLabPoDate;
    }

    public void setMatlLabPoDate(Date matlLabPoDate) {
        this.matlLabPoDate = matlLabPoDate;
    }

    public Date getAnticipatedCompletionDate() {
        return anticipatedCompletionDate;
    }

    public void setAnticipatedCompletionDate(Date anticipatedCompletionDate) {
        this.anticipatedCompletionDate = anticipatedCompletionDate;
    }

    public String getGlKey() {
        return glKey;
    }

    public void setGlKey(String glKey) {
        this.glKey = glKey;
    }

    public String getGlObj() {
        return glObj;
    }

    public void setGlObj(String glObj) {
        this.glObj = glObj;
    }

    public String getJlKey() {
        return jlKey;
    }

    public void setJlKey(String jlKey) {
        this.jlKey = jlKey;
    }

    public String getJlObj() {
        return jlObj;
    }

    public void setJlObj(String jlObj) {
        this.jlObj = jlObj;
    }

    public String getGlObjRet() {
        return glObjRet;
    }

    public void setGlObjRet(String glObjRet) {
        this.glObjRet = glObjRet;
    }

    public Date getSubcompRoadbridgeDate() {
        return subcompRoadbridgeDate;
    }

    public void setSubcompRoadbridgeDate(Date subcompRoadbridgeDate) {
        this.subcompRoadbridgeDate = subcompRoadbridgeDate;
    }

    public BigInteger getPersonEnvironEng() {
        return personEnvironEng;
    }

    public void setPersonEnvironEng(BigInteger personEnvironEng) {
        this.personEnvironEng = personEnvironEng;
    }

    public String getInsurexpdateTmp() {
        return insurexpdateTmp;
    }

    public void setInsurexpdateTmp(String insurexpdateTmp) {
        this.insurexpdateTmp = insurexpdateTmp;
    }

    public BigInteger getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(BigInteger calendarId) {
        this.calendarId = calendarId;
    }

    public String getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(String locationKey) {
        this.locationKey = locationKey;
    }

    public BigInteger getPersonCmInspector() {
        return personCmInspector;
    }

    public void setPersonCmInspector(BigInteger personCmInspector) {
        this.personCmInspector = personCmInspector;
    }

    public BigInteger getPersonCmSrInspector() {
        return personCmSrInspector;
    }

    public void setPersonCmSrInspector(BigInteger personCmSrInspector) {
        this.personCmSrInspector = personCmSrInspector;
    }

    public BigInteger getPersonCmPManager() {
        return personCmPManager;
    }

    public void setPersonCmPManager(BigInteger personCmPManager) {
        this.personCmPManager = personCmPManager;
    }

    public Character getContractorType() {
        return contractorType;
    }

    public void setContractorType(Character contractorType) {
        this.contractorType = contractorType;
    }

    public String getOldAccountNo() {
        return oldAccountNo;
    }

    public void setOldAccountNo(String oldAccountNo) {
        this.oldAccountNo = oldAccountNo;
    }

    public String getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(String minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public String getCutoffDateTmp() {
        return cutoffDateTmp;
    }

    public void setCutoffDateTmp(String cutoffDateTmp) {
        this.cutoffDateTmp = cutoffDateTmp;
    }

    public String getAwardOrdinanceDateTmp() {
        return awardOrdinanceDateTmp;
    }

    public void setAwardOrdinanceDateTmp(String awardOrdinanceDateTmp) {
        this.awardOrdinanceDateTmp = awardOrdinanceDateTmp;
    }

    public String getStartingDateTmp() {
        return startingDateTmp;
    }

    public void setStartingDateTmp(String startingDateTmp) {
        this.startingDateTmp = startingDateTmp;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNtpLetterDateTmp() {
        return ntpLetterDateTmp;
    }

    public void setNtpLetterDateTmp(String ntpLetterDateTmp) {
        this.ntpLetterDateTmp = ntpLetterDateTmp;
    }

    public String getSubcompdateTmp() {
        return subcompdateTmp;
    }

    public void setSubcompdateTmp(String subcompdateTmp) {
        this.subcompdateTmp = subcompdateTmp;
    }

    public String getDrugpdateTmp() {
        return drugpdateTmp;
    }

    public void setDrugpdateTmp(String drugpdateTmp) {
        this.drugpdateTmp = drugpdateTmp;
    }

    public String getSupplOrdinanceDateTmp() {
        return supplOrdinanceDateTmp;
    }

    public void setSupplOrdinanceDateTmp(String supplOrdinanceDateTmp) {
        this.supplOrdinanceDateTmp = supplOrdinanceDateTmp;
    }

    public String getCDateTmp() {
        return cDateTmp;
    }

    public void setCDateTmp(String cDateTmp) {
        this.cDateTmp = cDateTmp;
    }

    public BigInteger getPersonEngineer() {
        return personEngineer;
    }

    public void setPersonEngineer(BigInteger personEngineer) {
        this.personEngineer = personEngineer;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getAlertCostexp() {
        return alertCostexp;
    }

    public void setAlertCostexp(String alertCostexp) {
        this.alertCostexp = alertCostexp;
    }

    public BigInteger getPersonCManager() {
        return personCManager;
    }

    public void setPersonCManager(BigInteger personCManager) {
        this.personCManager = personCManager;
    }

    public BigInteger getPersonAManager() {
        return personAManager;
    }

    public void setPersonAManager(BigInteger personAManager) {
        this.personAManager = personAManager;
    }

    public BigInteger getPersonAdmin() {
        return personAdmin;
    }

    public void setPersonAdmin(BigInteger personAdmin) {
        this.personAdmin = personAdmin;
    }

    public BigInteger getPersonAdminA() {
        return personAdminA;
    }

    public void setPersonAdminA(BigInteger personAdminA) {
        this.personAdminA = personAdminA;
    }

    public BigInteger getPersonCtSrpm() {
        return personCtSrpm;
    }

    public void setPersonCtSrpm(BigInteger personCtSrpm) {
        this.personCtSrpm = personCtSrpm;
    }

    public BigInteger getPersonCtPm() {
        return personCtPm;
    }

    public void setPersonCtPm(BigInteger personCtPm) {
        this.personCtPm = personCtPm;
    }

    public BigInteger getPersonCtSupt() {
        return personCtSupt;
    }

    public void setPersonCtSupt(BigInteger personCtSupt) {
        this.personCtSupt = personCtSupt;
    }

    public BigInteger getPersonCtSuptA() {
        return personCtSuptA;
    }

    public void setPersonCtSuptA(BigInteger personCtSuptA) {
        this.personCtSuptA = personCtSuptA;
    }

    public BigInteger getPersonCnLeadc() {
        return personCnLeadc;
    }

    public void setPersonCnLeadc(BigInteger personCnLeadc) {
        this.personCnLeadc = personCnLeadc;
    }

    public BigInteger getPersonCnSubc() {
        return personCnSubc;
    }

    public void setPersonCnSubc(BigInteger personCnSubc) {
        this.personCnSubc = personCnSubc;
    }

    public BigInteger getPersonCnInspector() {
        return personCnInspector;
    }

    public void setPersonCnInspector(BigInteger personCnInspector) {
        this.personCnInspector = personCnInspector;
    }

    public BigInteger getPersonCtPmA() {
        return personCtPmA;
    }

    public void setPersonCtPmA(BigInteger personCtPmA) {
        this.personCtPmA = personCtPmA;
    }

    public Double getInsureTaxBenOnLabor() {
        return insureTaxBenOnLabor;
    }

    public void setInsureTaxBenOnLabor(Double insureTaxBenOnLabor) {
        this.insureTaxBenOnLabor = insureTaxBenOnLabor;
    }

    public Double getOverhead() {
        return overhead;
    }

    public void setOverhead(Double overhead) {
        this.overhead = overhead;
    }

    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }

    public String getPmProblems() {
        return pmProblems;
    }

    public void setPmProblems(String pmProblems) {
        this.pmProblems = pmProblems;
    }

    public BigInteger getPersonContractorContact2() {
        return personContractorContact2;
    }

    public void setPersonContractorContact2(BigInteger personContractorContact2) {
        this.personContractorContact2 = personContractorContact2;
    }

    public BigInteger getDesignConsultant2() {
        return designConsultant2;
    }

    public void setDesignConsultant2(BigInteger designConsultant2) {
        this.designConsultant2 = designConsultant2;
    }

    public BigInteger getPersonConsultantContact2() {
        return personConsultantContact2;
    }

    public void setPersonConsultantContact2(BigInteger personConsultantContact2) {
        this.personConsultantContact2 = personConsultantContact2;
    }

    public String getPersonContractorNextel() {
        return personContractorNextel;
    }

    public void setPersonContractorNextel(String personContractorNextel) {
        this.personContractorNextel = personContractorNextel;
    }

    public String getPersonCmFirmNextel() {
        return personCmFirmNextel;
    }

    public void setPersonCmFirmNextel(String personCmFirmNextel) {
        this.personCmFirmNextel = personCmFirmNextel;
    }

    public BigInteger getPersonInspector2() {
        return personInspector2;
    }

    public void setPersonInspector2(BigInteger personInspector2) {
        this.personInspector2 = personInspector2;
    }

    public BigInteger getPersonConstrProjectManager() {
        return personConstrProjectManager;
    }

    public void setPersonConstrProjectManager(BigInteger personConstrProjectManager) {
        this.personConstrProjectManager = personConstrProjectManager;
    }

    public BigInteger getPersonPManager2() {
        return personPManager2;
    }

    public void setPersonPManager2(BigInteger personPManager2) {
        this.personPManager2 = personPManager2;
    }

    public BigInteger getPersonSrInspector2() {
        return personSrInspector2;
    }

    public void setPersonSrInspector2(BigInteger personSrInspector2) {
        this.personSrInspector2 = personSrInspector2;
    }

    public BigInteger getPersonInspector3() {
        return personInspector3;
    }

    public void setPersonInspector3(BigInteger personInspector3) {
        this.personInspector3 = personInspector3;
    }

    public BigInteger getPersonInspector4() {
        return personInspector4;
    }

    public void setPersonInspector4(BigInteger personInspector4) {
        this.personInspector4 = personInspector4;
    }

    public BigInteger getPersonInspector5() {
        return personInspector5;
    }

    public void setPersonInspector5(BigInteger personInspector5) {
        this.personInspector5 = personInspector5;
    }

    public BigInteger getPersonInspector6() {
        return personInspector6;
    }

    public void setPersonInspector6(BigInteger personInspector6) {
        this.personInspector6 = personInspector6;
    }

    public BigInteger getPersonInspector7() {
        return personInspector7;
    }

    public void setPersonInspector7(BigInteger personInspector7) {
        this.personInspector7 = personInspector7;
    }

    public BigInteger getPersonInspector8() {
        return personInspector8;
    }

    public void setPersonInspector8(BigInteger personInspector8) {
        this.personInspector8 = personInspector8;
    }

    public BigInteger getPersonInspector9() {
        return personInspector9;
    }

    public void setPersonInspector9(BigInteger personInspector9) {
        this.personInspector9 = personInspector9;
    }

    public BigInteger getPersonInspector10() {
        return personInspector10;
    }

    public void setPersonInspector10(BigInteger personInspector10) {
        this.personInspector10 = personInspector10;
    }

    public BigInteger getPersonInspector11() {
        return personInspector11;
    }

    public void setPersonInspector11(BigInteger personInspector11) {
        this.personInspector11 = personInspector11;
    }

    public BigInteger getPersonInspector12() {
        return personInspector12;
    }

    public void setPersonInspector12(BigInteger personInspector12) {
        this.personInspector12 = personInspector12;
    }

    public BigInteger getPersonInspector13() {
        return personInspector13;
    }

    public void setPersonInspector13(BigInteger personInspector13) {
        this.personInspector13 = personInspector13;
    }

    public BigInteger getPersonInspector14() {
        return personInspector14;
    }

    public void setPersonInspector14(BigInteger personInspector14) {
        this.personInspector14 = personInspector14;
    }

    public BigInteger getPersonInspector15() {
        return personInspector15;
    }

    public void setPersonInspector15(BigInteger personInspector15) {
        this.personInspector15 = personInspector15;
    }

    public BigInteger getPersonInspector16() {
        return personInspector16;
    }

    public void setPersonInspector16(BigInteger personInspector16) {
        this.personInspector16 = personInspector16;
    }

    public BigInteger getPersonInspector17() {
        return personInspector17;
    }

    public void setPersonInspector17(BigInteger personInspector17) {
        this.personInspector17 = personInspector17;
    }

    public BigInteger getPersonSrInspector3() {
        return personSrInspector3;
    }

    public void setPersonSrInspector3(BigInteger personSrInspector3) {
        this.personSrInspector3 = personSrInspector3;
    }

    public BigInteger getPersonLeadSupervisor() {
        return personLeadSupervisor;
    }

    public void setPersonLeadSupervisor(BigInteger personLeadSupervisor) {
        this.personLeadSupervisor = personLeadSupervisor;
    }

    public BigInteger getPersonDeputyDirector() {
        return personDeputyDirector;
    }

    public void setPersonDeputyDirector(BigInteger personDeputyDirector) {
        this.personDeputyDirector = personDeputyDirector;
    }

    public BigInteger getPersonDeptManager() {
        return personDeptManager;
    }

    public void setPersonDeptManager(BigInteger personDeptManager) {
        this.personDeptManager = personDeptManager;
    }

    public BigInteger getPersonFieldOpsManager() {
        return personFieldOpsManager;
    }

    public void setPersonFieldOpsManager(BigInteger personFieldOpsManager) {
        this.personFieldOpsManager = personFieldOpsManager;
    }

    public BigInteger getPersonSupervisor1() {
        return personSupervisor1;
    }

    public void setPersonSupervisor1(BigInteger personSupervisor1) {
        this.personSupervisor1 = personSupervisor1;
    }

    public BigInteger getPersonSupervisor2() {
        return personSupervisor2;
    }

    public void setPersonSupervisor2(BigInteger personSupervisor2) {
        this.personSupervisor2 = personSupervisor2;
    }

    public BigInteger getPersonPropertyManager() {
        return personPropertyManager;
    }

    public void setPersonPropertyManager(BigInteger personPropertyManager) {
        this.personPropertyManager = personPropertyManager;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
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

    public BigInteger getInclementWeatherDaysCur() {
        return inclementWeatherDaysCur;
    }

    public void setInclementWeatherDaysCur(BigInteger inclementWeatherDaysCur) {
        this.inclementWeatherDaysCur = inclementWeatherDaysCur;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMultipleDaily() {
        return multipleDaily;
    }

    public void setMultipleDaily(String multipleDaily) {
        this.multipleDaily = multipleDaily;
    }

    public BigInteger getPersonInspector18() {
        return personInspector18;
    }

    public void setPersonInspector18(BigInteger personInspector18) {
        this.personInspector18 = personInspector18;
    }

    public BigInteger getPersonInspector19() {
        return personInspector19;
    }

    public void setPersonInspector19(BigInteger personInspector19) {
        this.personInspector19 = personInspector19;
    }

    public BigInteger getPersonInspector20() {
        return personInspector20;
    }

    public void setPersonInspector20(BigInteger personInspector20) {
        this.personInspector20 = personInspector20;
    }

    public BigInteger getPersonInspector21() {
        return personInspector21;
    }

    public void setPersonInspector21(BigInteger personInspector21) {
        this.personInspector21 = personInspector21;
    }

    public String getHasIncWeather() {
        return hasIncWeather;
    }

    public void setHasIncWeather(String hasIncWeather) {
        this.hasIncWeather = hasIncWeather;
    }

    public BigInteger getDesignConsultant3() {
        return designConsultant3;
    }

    public void setDesignConsultant3(BigInteger designConsultant3) {
        this.designConsultant3 = designConsultant3;
    }

    public BigInteger getPersonConsultantContact3() {
        return personConsultantContact3;
    }

    public void setPersonConsultantContact3(BigInteger personConsultantContact3) {
        this.personConsultantContact3 = personConsultantContact3;
    }

    public BigInteger getPersonContractorContact3() {
        return personContractorContact3;
    }

    public void setPersonContractorContact3(BigInteger personContractorContact3) {
        this.personContractorContact3 = personContractorContact3;
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
        if (!(object instanceof GlobContract)) {
            return false;
        }
        GlobContract other = (GlobContract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContract[ id=" + id + " ]";
    }

}
