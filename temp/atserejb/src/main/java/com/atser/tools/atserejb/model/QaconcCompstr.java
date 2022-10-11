/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "QaconcCompstr.findByContractor", query = "SELECT q FROM QaconcCompstr q WHERE q.contractor = :contractor"),
    @NamedQuery(name = "QaconcCompstr.findByTimecast", query = "SELECT q FROM QaconcCompstr q WHERE q.timecast = :timecast"),
    @NamedQuery(name = "QaconcCompstr.findBySlump", query = "SELECT q FROM QaconcCompstr q WHERE q.slump = :slump"),
    @NamedQuery(name = "QaconcCompstr.findByAircontent", query = "SELECT q FROM QaconcCompstr q WHERE q.aircontent = :aircontent"),
    @NamedQuery(name = "QaconcCompstr.findByMixtemp", query = "SELECT q FROM QaconcCompstr q WHERE q.mixtemp = :mixtemp"),
    @NamedQuery(name = "QaconcCompstr.findByAirtemp", query = "SELECT q FROM QaconcCompstr q WHERE q.airtemp = :airtemp"),
    @NamedQuery(name = "QaconcCompstr.findByUnitweight", query = "SELECT q FROM QaconcCompstr q WHERE q.unitweight = :unitweight"),
    @NamedQuery(name = "QaconcCompstr.findByMaterial", query = "SELECT q FROM QaconcCompstr q WHERE q.material = :material"),
    @NamedQuery(name = "QaconcCompstr.findByCategory", query = "SELECT q FROM QaconcCompstr q WHERE q.category = :category"),
    @NamedQuery(name = "QaconcCompstr.findByConcClass", query = "SELECT q FROM QaconcCompstr q WHERE q.concClass = :concClass"),
    @NamedQuery(name = "QaconcCompstr.findBySamplecastby", query = "SELECT q FROM QaconcCompstr q WHERE q.samplecastby = :samplecastby"),
    @NamedQuery(name = "QaconcCompstr.findBySetnumber", query = "SELECT q FROM QaconcCompstr q WHERE q.setnumber = :setnumber"),
    @NamedQuery(name = "QaconcCompstr.findBySetnumberof", query = "SELECT q FROM QaconcCompstr q WHERE q.setnumberof = :setnumberof"),
    @NamedQuery(name = "QaconcCompstr.findBySamplesperset", query = "SELECT q FROM QaconcCompstr q WHERE q.samplesperset = :samplesperset"),
    @NamedQuery(name = "QaconcCompstr.findByField11", query = "SELECT q FROM QaconcCompstr q WHERE q.field11 = :field11"),
    @NamedQuery(name = "QaconcCompstr.findByField12", query = "SELECT q FROM QaconcCompstr q WHERE q.field12 = :field12"),
    @NamedQuery(name = "QaconcCompstr.findBySupplier", query = "SELECT q FROM QaconcCompstr q WHERE q.supplier = :supplier"),
    @NamedQuery(name = "QaconcCompstr.findByMixdesignno", query = "SELECT q FROM QaconcCompstr q WHERE q.mixdesignno = :mixdesignno"),
    @NamedQuery(name = "QaconcCompstr.findBySlumpspec", query = "SELECT q FROM QaconcCompstr q WHERE q.slumpspec = :slumpspec"),
    @NamedQuery(name = "QaconcCompstr.findByAircontentspec", query = "SELECT q FROM QaconcCompstr q WHERE q.aircontentspec = :aircontentspec"),
    @NamedQuery(name = "QaconcCompstr.findBySpecifiedstrength", query = "SELECT q FROM QaconcCompstr q WHERE q.specifiedstrength = :specifiedstrength"),
    @NamedQuery(name = "QaconcCompstr.findByTicketno", query = "SELECT q FROM QaconcCompstr q WHERE q.ticketno = :ticketno"),
    @NamedQuery(name = "QaconcCompstr.findByTruckno", query = "SELECT q FROM QaconcCompstr q WHERE q.truckno = :truckno"),
    @NamedQuery(name = "QaconcCompstr.findByBatchtime", query = "SELECT q FROM QaconcCompstr q WHERE q.batchtime = :batchtime"),
    @NamedQuery(name = "QaconcCompstr.findByCement", query = "SELECT q FROM QaconcCompstr q WHERE q.cement = :cement"),
    @NamedQuery(name = "QaconcCompstr.findByFlayash", query = "SELECT q FROM QaconcCompstr q WHERE q.flayash = :flayash"),
    @NamedQuery(name = "QaconcCompstr.findByWater", query = "SELECT q FROM QaconcCompstr q WHERE q.water = :water"),
    @NamedQuery(name = "QaconcCompstr.findByWateradded", query = "SELECT q FROM QaconcCompstr q WHERE q.wateradded = :wateradded"),
    @NamedQuery(name = "QaconcCompstr.findByFineagg", query = "SELECT q FROM QaconcCompstr q WHERE q.fineagg = :fineagg"),
    @NamedQuery(name = "QaconcCompstr.findByCoarseagg", query = "SELECT q FROM QaconcCompstr q WHERE q.coarseagg = :coarseagg"),
    @NamedQuery(name = "QaconcCompstr.findByAdmix", query = "SELECT q FROM QaconcCompstr q WHERE q.admix = :admix"),
    @NamedQuery(name = "QaconcCompstr.findByAdmix2", query = "SELECT q FROM QaconcCompstr q WHERE q.admix2 = :admix2"),
    @NamedQuery(name = "QaconcCompstr.findByAdmix3", query = "SELECT q FROM QaconcCompstr q WHERE q.admix3 = :admix3"),
    @NamedQuery(name = "QaconcCompstr.findByBatchsize", query = "SELECT q FROM QaconcCompstr q WHERE q.batchsize = :batchsize"),
    @NamedQuery(name = "QaconcCompstr.findByAccumno", query = "SELECT q FROM QaconcCompstr q WHERE q.accumno = :accumno"),
    @NamedQuery(name = "QaconcCompstr.findByAccumtotal", query = "SELECT q FROM QaconcCompstr q WHERE q.accumtotal = :accumtotal"),
    @NamedQuery(name = "QaconcCompstr.findByAccumtotal2", query = "SELECT q FROM QaconcCompstr q WHERE q.accumtotal2 = :accumtotal2"),
    @NamedQuery(name = "QaconcCompstr.findBySampledat", query = "SELECT q FROM QaconcCompstr q WHERE q.sampledat = :sampledat"),
    @NamedQuery(name = "QaconcCompstr.findByAvg28days", query = "SELECT q FROM QaconcCompstr q WHERE q.avg28days = :avg28days"),
    @NamedQuery(name = "QaconcCompstr.findByUnitconcp", query = "SELECT q FROM QaconcCompstr q WHERE q.unitconcp = :unitconcp"),
    @NamedQuery(name = "QaconcCompstr.findByFlagadjcpmm", query = "SELECT q FROM QaconcCompstr q WHERE q.flagadjcpmm = :flagadjcpmm"),
    @NamedQuery(name = "QaconcCompstr.findByFlagadjslumpmm", query = "SELECT q FROM QaconcCompstr q WHERE q.flagadjslumpmm = :flagadjslumpmm"),
    @NamedQuery(name = "QaconcCompstr.findByFlagadjcomcomp", query = "SELECT q FROM QaconcCompstr q WHERE q.flagadjcomcomp = :flagadjcomcomp"),
    @NamedQuery(name = "QaconcCompstr.findByMolding", query = "SELECT q FROM QaconcCompstr q WHERE q.molding = :molding"),
    @NamedQuery(name = "QaconcCompstr.findBySampleplumb", query = "SELECT q FROM QaconcCompstr q WHERE q.sampleplumb = :sampleplumb"),
    @NamedQuery(name = "QaconcCompstr.findByMintemp", query = "SELECT q FROM QaconcCompstr q WHERE q.mintemp = :mintemp"),
    @NamedQuery(name = "QaconcCompstr.findByMaxtemp", query = "SELECT q FROM QaconcCompstr q WHERE q.maxtemp = :maxtemp"),
    @NamedQuery(name = "QaconcCompstr.findByAgetransport", query = "SELECT q FROM QaconcCompstr q WHERE q.agetransport = :agetransport"),
    @NamedQuery(name = "QaconcCompstr.findByPage", query = "SELECT q FROM QaconcCompstr q WHERE q.page = :page"),
    @NamedQuery(name = "QaconcCompstr.findByReport", query = "SELECT q FROM QaconcCompstr q WHERE q.report = :report"),
    @NamedQuery(name = "QaconcCompstr.findByField1", query = "SELECT q FROM QaconcCompstr q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaconcCompstr.findByField2", query = "SELECT q FROM QaconcCompstr q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaconcCompstr.findByField3", query = "SELECT q FROM QaconcCompstr q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaconcCompstr.findByField4", query = "SELECT q FROM QaconcCompstr q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaconcCompstr.findByField5", query = "SELECT q FROM QaconcCompstr q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaconcCompstr.findByField6", query = "SELECT q FROM QaconcCompstr q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaconcCompstr.findByField7", query = "SELECT q FROM QaconcCompstr q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaconcCompstr.findByField8", query = "SELECT q FROM QaconcCompstr q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QaconcCompstr.findByField9", query = "SELECT q FROM QaconcCompstr q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QaconcCompstr.findByField10", query = "SELECT q FROM QaconcCompstr q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QaconcCompstr.findByActive", query = "SELECT q FROM QaconcCompstr q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcCompstr.findByLastModBy", query = "SELECT q FROM QaconcCompstr q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaconcCompstr.findByLastModIp", query = "SELECT q FROM QaconcCompstr q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcCompstr.findByCreateBy", query = "SELECT q FROM QaconcCompstr q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaconcCompstr.findByCreateByIp", query = "SELECT q FROM QaconcCompstr q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaconcCompstr.findByPlant", query = "SELECT q FROM QaconcCompstr q WHERE q.plant = :plant"),
    @NamedQuery(name = "QaconcCompstr.findByVersion", query = "SELECT q FROM QaconcCompstr q WHERE q.version = :version"),
    @NamedQuery(name = "QaconcCompstr.findByFieldTestno", query = "SELECT q FROM QaconcCompstr q WHERE q.fieldTestno = :fieldTestno"),
    @NamedQuery(name = "QaconcCompstr.findByFineaggMstpct", query = "SELECT q FROM QaconcCompstr q WHERE q.fineaggMstpct = :fineaggMstpct"),
    @NamedQuery(name = "QaconcCompstr.findByMedagg", query = "SELECT q FROM QaconcCompstr q WHERE q.medagg = :medagg"),
    @NamedQuery(name = "QaconcCompstr.findByMedaggMstpct", query = "SELECT q FROM QaconcCompstr q WHERE q.medaggMstpct = :medaggMstpct"),
    @NamedQuery(name = "QaconcCompstr.findByCoarseaggMstpct", query = "SELECT q FROM QaconcCompstr q WHERE q.coarseaggMstpct = :coarseaggMstpct"),
    @NamedQuery(name = "QaconcCompstr.findByPlacementlocation", query = "SELECT q FROM QaconcCompstr q WHERE q.placementlocation = :placementlocation"),
    @NamedQuery(name = "QaconcCompstr.findBySamplelocation", query = "SELECT q FROM QaconcCompstr q WHERE q.samplelocation = :samplelocation"),
    @NamedQuery(name = "QaconcCompstr.findByInstallingcompany", query = "SELECT q FROM QaconcCompstr q WHERE q.installingcompany = :installingcompany"),
    @NamedQuery(name = "QaconcCompstr.findByInspectingcompany", query = "SELECT q FROM QaconcCompstr q WHERE q.inspectingcompany = :inspectingcompany"),
    @NamedQuery(name = "QaconcCompstr.findByQccompany", query = "SELECT q FROM QaconcCompstr q WHERE q.qccompany = :qccompany"),
    @NamedQuery(name = "QaconcCompstr.findByAcceptingcompany", query = "SELECT q FROM QaconcCompstr q WHERE q.acceptingcompany = :acceptingcompany"),
    @NamedQuery(name = "QaconcCompstr.findByTano", query = "SELECT q FROM QaconcCompstr q WHERE q.tano = :tano"),
    @NamedQuery(name = "QaconcCompstr.findByActualstarttime", query = "SELECT q FROM QaconcCompstr q WHERE q.actualstarttime = :actualstarttime"),
    @NamedQuery(name = "QaconcCompstr.findByActualfinishtime", query = "SELECT q FROM QaconcCompstr q WHERE q.actualfinishtime = :actualfinishtime"),
    @NamedQuery(name = "QaconcCompstr.findByAircontentmethod", query = "SELECT q FROM QaconcCompstr q WHERE q.aircontentmethod = :aircontentmethod"),
    @NamedQuery(name = "QaconcCompstr.findByTimebatched", query = "SELECT q FROM QaconcCompstr q WHERE q.timebatched = :timebatched"),
    @NamedQuery(name = "QaconcCompstr.findByTimesampled", query = "SELECT q FROM QaconcCompstr q WHERE q.timesampled = :timesampled"),
    @NamedQuery(name = "QaconcCompstr.findByConformingnotes", query = "SELECT q FROM QaconcCompstr q WHERE q.conformingnotes = :conformingnotes"),
    @NamedQuery(name = "QaconcCompstr.findByNonconformingnotes", query = "SELECT q FROM QaconcCompstr q WHERE q.nonconformingnotes = :nonconformingnotes"),
    @NamedQuery(name = "QaconcCompstr.findByNotes", query = "SELECT q FROM QaconcCompstr q WHERE q.notes = :notes"),
    @NamedQuery(name = "QaconcCompstr.findByPlacementstrength", query = "SELECT q FROM QaconcCompstr q WHERE q.placementstrength = :placementstrength"),
    @NamedQuery(name = "QaconcCompstr.findByInspector", query = "SELECT q FROM QaconcCompstr q WHERE q.inspector = :inspector"),
    @NamedQuery(name = "QaconcCompstr.findByPlantno", query = "SELECT q FROM QaconcCompstr q WHERE q.plantno = :plantno"),
    @NamedQuery(name = "QaconcCompstr.findByStructname", query = "SELECT q FROM QaconcCompstr q WHERE q.structname = :structname"),
    @NamedQuery(name = "QaconcCompstr.findByYield", query = "SELECT q FROM QaconcCompstr q WHERE q.yield = :yield"),
    @NamedQuery(name = "QaconcCompstr.findByTncpump", query = "SELECT q FROM QaconcCompstr q WHERE q.tncpump = :tncpump"),
    @NamedQuery(name = "QaconcCompstr.findByLoadno", query = "SELECT q FROM QaconcCompstr q WHERE q.loadno = :loadno"),
    @NamedQuery(name = "QaconcCompstr.findBySpecsection", query = "SELECT q FROM QaconcCompstr q WHERE q.specsection = :specsection"),
    @NamedQuery(name = "QaconcCompstr.findByBatchweight", query = "SELECT q FROM QaconcCompstr q WHERE q.batchweight = :batchweight"),
    @NamedQuery(name = "QaconcCompstr.findByAvgdays", query = "SELECT q FROM QaconcCompstr q WHERE q.avgdays = :avgdays"),
    @NamedQuery(name = "QaconcCompstr.findByTestingmachine", query = "SELECT q FROM QaconcCompstr q WHERE q.testingmachine = :testingmachine"),
    @NamedQuery(name = "QaconcCompstr.findByCaliper", query = "SELECT q FROM QaconcCompstr q WHERE q.caliper = :caliper"),
    @NamedQuery(name = "QaconcCompstr.findByRetainingring", query = "SELECT q FROM QaconcCompstr q WHERE q.retainingring = :retainingring"),
    @NamedQuery(name = "QaconcCompstr.findByRemarks", query = "SELECT q FROM QaconcCompstr q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaconcCompstr.findByFarSummary", query = "SELECT q FROM QaconcCompstr q WHERE q.farSummary = :farSummary"),
    @NamedQuery(name = "QaconcCompstr.findByLotNo", query = "SELECT q FROM QaconcCompstr q WHERE q.lotNo = :lotNo"),
    @NamedQuery(name = "QaconcCompstr.findBySublotNo", query = "SELECT q FROM QaconcCompstr q WHERE q.sublotNo = :sublotNo"),
    @NamedQuery(name = "QaconcCompstr.findBySpecifiedstrength56days", query = "SELECT q FROM QaconcCompstr q WHERE q.specifiedstrength56days = :specifiedstrength56days"),
    @NamedQuery(name = "QaconcCompstr.findByAvg56days", query = "SELECT q FROM QaconcCompstr q WHERE q.avg56days = :avg56days"),
    @NamedQuery(name = "QaconcCompstr.findBySplitno", query = "SELECT q FROM QaconcCompstr q WHERE q.splitno = :splitno"),
    @NamedQuery(name = "QaconcCompstr.findBySplitsample", query = "SELECT q FROM QaconcCompstr q WHERE q.splitsample = :splitsample"),
    @NamedQuery(name = "QaconcCompstr.findByLastModTmp", query = "SELECT q FROM QaconcCompstr q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QaconcCompstr.findByTempTmp", query = "SELECT q FROM QaconcCompstr q WHERE q.tempTmp = :tempTmp"),
    @NamedQuery(name = "QaconcCompstr.findByCreateDateTmp", query = "SELECT q FROM QaconcCompstr q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QaconcCompstr.findByPlacementdateTmp", query = "SELECT q FROM QaconcCompstr q WHERE q.placementdateTmp = :placementdateTmp"),
    @NamedQuery(name = "QaconcCompstr.findByLastMod", query = "SELECT q FROM QaconcCompstr q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcCompstr.findByTemp", query = "SELECT q FROM QaconcCompstr q WHERE q.temp = :temp"),
    @NamedQuery(name = "QaconcCompstr.findByPlacementdate", query = "SELECT q FROM QaconcCompstr q WHERE q.placementdate = :placementdate"),
    @NamedQuery(name = "QaconcCompstr.findByCreateDate", query = "SELECT q FROM QaconcCompstr q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaconcCompstr.findByContractName", query = "SELECT q FROM QaconcCompstr q WHERE q.contractName = :contractName"),
    @NamedQuery(name = "QaconcCompstr.findByAdmix4", query = "SELECT q FROM QaconcCompstr q WHERE q.admix4 = :admix4"),
    @NamedQuery(name = "QaconcCompstr.findByWaterCementRatio", query = "SELECT q FROM QaconcCompstr q WHERE q.waterCementRatio = :waterCementRatio"),
    @NamedQuery(name = "QaconcCompstr.findByTestplanId", query = "SELECT q FROM QaconcCompstr q WHERE q.testplanId = :testplanId"),
    @NamedQuery(name = "QaconcCompstr.findByQuantity", query = "SELECT q FROM QaconcCompstr q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QaconcCompstr.findByMachineStopped", query = "SELECT q FROM QaconcCompstr q WHERE q.machineStopped = :machineStopped"),
    @NamedQuery(name = "QaconcCompstr.findByRejected", query = "SELECT q FROM QaconcCompstr q WHERE q.rejected = :rejected"),
    @NamedQuery(name = "QaconcCompstr.findByPotentialActualSubmitReview", query = "SELECT q FROM QaconcCompstr q WHERE q.potentialActualSubmitReview = :potentialActualSubmitReview"),
    @NamedQuery(name = "QaconcCompstr.findByDepartLab", query = "SELECT q FROM QaconcCompstr q WHERE q.departLab = :departLab"),
    @NamedQuery(name = "QaconcCompstr.findByArriveSite", query = "SELECT q FROM QaconcCompstr q WHERE q.arriveSite = :arriveSite"),
    @NamedQuery(name = "QaconcCompstr.findByLunchHours", query = "SELECT q FROM QaconcCompstr q WHERE q.lunchHours = :lunchHours"),
    @NamedQuery(name = "QaconcCompstr.findByLunchMins", query = "SELECT q FROM QaconcCompstr q WHERE q.lunchMins = :lunchMins"),
    @NamedQuery(name = "QaconcCompstr.findByDepartSite", query = "SELECT q FROM QaconcCompstr q WHERE q.departSite = :departSite"),
    @NamedQuery(name = "QaconcCompstr.findByArriveLab", query = "SELECT q FROM QaconcCompstr q WHERE q.arriveLab = :arriveLab"),
    @NamedQuery(name = "QaconcCompstr.findByTotalHours", query = "SELECT q FROM QaconcCompstr q WHERE q.totalHours = :totalHours"),
    @NamedQuery(name = "QaconcCompstr.findByTechnicianHoursOvertime", query = "SELECT q FROM QaconcCompstr q WHERE q.technicianHoursOvertime = :technicianHoursOvertime"),
    @NamedQuery(name = "QaconcCompstr.findByTestReportNo", query = "SELECT q FROM QaconcCompstr q WHERE q.testReportNo = :testReportNo"),
    @NamedQuery(name = "QaconcCompstr.findByAvg7days", query = "SELECT q FROM QaconcCompstr q WHERE q.avg7days = :avg7days"),
    @NamedQuery(name = "QaconcCompstr.findByCuringMethod", query = "SELECT q FROM QaconcCompstr q WHERE q.curingMethod = :curingMethod"),
    @NamedQuery(name = "QaconcCompstr.findBySpecimenCovered", query = "SELECT q FROM QaconcCompstr q WHERE q.specimenCovered = :specimenCovered"),
    @NamedQuery(name = "QaconcCompstr.findByLabPrep", query = "SELECT q FROM QaconcCompstr q WHERE q.labPrep = :labPrep"),
    @NamedQuery(name = "QaconcCompstr.findByVariationCoefficient", query = "SELECT q FROM QaconcCompstr q WHERE q.variationCoefficient = :variationCoefficient"),
    @NamedQuery(name = "QaconcCompstr.findByMaterialMetRequirements", query = "SELECT q FROM QaconcCompstr q WHERE q.materialMetRequirements = :materialMetRequirements"),
    @NamedQuery(name = "QaconcCompstr.findByMaterialUnderRequirements", query = "SELECT q FROM QaconcCompstr q WHERE q.materialUnderRequirements = :materialUnderRequirements"),
    @NamedQuery(name = "QaconcCompstr.findByAdditionalComments", query = "SELECT q FROM QaconcCompstr q WHERE q.additionalComments = :additionalComments"),
    @NamedQuery(name = "QaconcCompstr.findBySpecConcreteTempMin", query = "SELECT q FROM QaconcCompstr q WHERE q.specConcreteTempMin = :specConcreteTempMin"),
    @NamedQuery(name = "QaconcCompstr.findBySpecConcreteTempMax", query = "SELECT q FROM QaconcCompstr q WHERE q.specConcreteTempMax = :specConcreteTempMax"),
    @NamedQuery(name = "QaconcCompstr.findByCurringMethod", query = "SELECT q FROM QaconcCompstr q WHERE q.curringMethod = :curringMethod"),
    @NamedQuery(name = "QaconcCompstr.findByMileage", query = "SELECT q FROM QaconcCompstr q WHERE q.mileage = :mileage"),
    @NamedQuery(name = "QaconcCompstr.findByPreviosYardage", query = "SELECT q FROM QaconcCompstr q WHERE q.previosYardage = :previosYardage"),
    @NamedQuery(name = "QaconcCompstr.findByCurrentYardage", query = "SELECT q FROM QaconcCompstr q WHERE q.currentYardage = :currentYardage"),
    @NamedQuery(name = "QaconcCompstr.findByTestedYardage", query = "SELECT q FROM QaconcCompstr q WHERE q.testedYardage = :testedYardage"),
    @NamedQuery(name = "QaconcCompstr.findByYardageToDate", query = "SELECT q FROM QaconcCompstr q WHERE q.yardageToDate = :yardageToDate"),
    @NamedQuery(name = "QaconcCompstr.findByUseSeal", query = "SELECT q FROM QaconcCompstr q WHERE q.useSeal = :useSeal"),
    @NamedQuery(name = "QaconcCompstr.findByBrick", query = "SELECT q FROM QaconcCompstr q WHERE q.brick = :brick"),
    @NamedQuery(name = "QaconcCompstr.findByTerracotta", query = "SELECT q FROM QaconcCompstr q WHERE q.terracotta = :terracotta"),
    @NamedQuery(name = "QaconcCompstr.findByReinforced", query = "SELECT q FROM QaconcCompstr q WHERE q.reinforced = :reinforced"),
    @NamedQuery(name = "QaconcCompstr.findByFlashingUsed", query = "SELECT q FROM QaconcCompstr q WHERE q.flashingUsed = :flashingUsed"),
    @NamedQuery(name = "QaconcCompstr.findByHandMix", query = "SELECT q FROM QaconcCompstr q WHERE q.handMix = :handMix"),
    @NamedQuery(name = "QaconcCompstr.findByTruck", query = "SELECT q FROM QaconcCompstr q WHERE q.truck = :truck"),
    @NamedQuery(name = "QaconcCompstr.findByCmuBlock", query = "SELECT q FROM QaconcCompstr q WHERE q.cmuBlock = :cmuBlock"),
    @NamedQuery(name = "QaconcCompstr.findByCopingStone", query = "SELECT q FROM QaconcCompstr q WHERE q.copingStone = :copingStone"),
    @NamedQuery(name = "QaconcCompstr.findByUnreinforced", query = "SELECT q FROM QaconcCompstr q WHERE q.unreinforced = :unreinforced"),
    @NamedQuery(name = "QaconcCompstr.findByRefactoryBrickMotar", query = "SELECT q FROM QaconcCompstr q WHERE q.refactoryBrickMotar = :refactoryBrickMotar"),
    @NamedQuery(name = "QaconcCompstr.findByPremix", query = "SELECT q FROM QaconcCompstr q WHERE q.premix = :premix"),
    @NamedQuery(name = "QaconcCompstr.findByOther", query = "SELECT q FROM QaconcCompstr q WHERE q.other = :other"),
    @NamedQuery(name = "QaconcCompstr.findByOtherInput", query = "SELECT q FROM QaconcCompstr q WHERE q.otherInput = :otherInput"),
    @NamedQuery(name = "QaconcCompstr.findByS1800", query = "SELECT q FROM QaconcCompstr q WHERE q.s1800 = :s1800"),
    @NamedQuery(name = "QaconcCompstr.findByN750", query = "SELECT q FROM QaconcCompstr q WHERE q.n750 = :n750"),
    @NamedQuery(name = "QaconcCompstr.findByO350", query = "SELECT q FROM QaconcCompstr q WHERE q.o350 = :o350"),
    @NamedQuery(name = "QaconcCompstr.findByM2500", query = "SELECT q FROM QaconcCompstr q WHERE q.m2500 = :m2500"),
    @NamedQuery(name = "QaconcCompstr.findByOtherAstm", query = "SELECT q FROM QaconcCompstr q WHERE q.otherAstm = :otherAstm"),
    @NamedQuery(name = "QaconcCompstr.findByOtherAstmInput", query = "SELECT q FROM QaconcCompstr q WHERE q.otherAstmInput = :otherAstmInput"),
    @NamedQuery(name = "QaconcCompstr.findByTypeAndNumber", query = "SELECT q FROM QaconcCompstr q WHERE q.typeAndNumber = :typeAndNumber")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QACONC_COMPSTR", catalog = "", schema = "ORACLE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"SAMPLETEST_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcCompstr.findAll", query = "SELECT q FROM QaconcCompstr q"),
    @NamedQuery(name = "QaconcCompstr.findById", query = "SELECT q FROM QaconcCompstr q WHERE q.id = :id"),
    @NamedQuery(name = "QaconcCompstr.findBySampletestId", query = "SELECT q FROM QaconcCompstr q WHERE q.sampletestId = :sampletestId")})
public class QaconcCompstr implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_COMPSTR_ID_SEQ", sequenceName = "QACONC_COMPSTR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_COMPSTR_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Size(max = 50)
    @Column(name = "CONTRACTOR", length = 50)
    private String contractor;
    @Size(max = 50)
    @Column(name = "TIMECAST", length = 50)
    private String timecast;
    @Size(max = 50)
    @Column(name = "SLUMP", length = 50)
    private String slump;
    @Size(max = 50)
    @Column(name = "AIRCONTENT", length = 50)
    private String aircontent;
    @Size(max = 50)
    @Column(name = "MIXTEMP", length = 50)
    private String mixtemp;
    @Size(max = 50)
    @Column(name = "AIRTEMP", length = 50)
    private String airtemp;
    @Size(max = 50)
    @Column(name = "UNITWEIGHT", length = 50)
    private String unitweight;
    @Size(max = 50)
    @Column(name = "MATERIAL", length = 50)
    private String material;
    @Size(max = 50)
    @Column(name = "CATEGORY", length = 50)
    private String category;
    @Size(max = 50)
    @Column(name = "CONC_CLASS", length = 50)
    private String concClass;
    @Size(max = 50)
    @Column(name = "SAMPLECASTBY", length = 50)
    private String samplecastby;
    @Size(max = 50)
    @Column(name = "SETNUMBER", length = 50)
    private String setnumber;
    @Size(max = 50)
    @Column(name = "SETNUMBEROF", length = 50)
    private String setnumberof;
    @Size(max = 50)
    @Column(name = "SAMPLESPERSET", length = 50)
    private String samplesperset;
    @Size(max = 50)
    @Column(name = "FIELD11", length = 50)
    private String field11;
    @Size(max = 50)
    @Column(name = "FIELD12", length = 50)
    private String field12;
    @Size(max = 50)
    @Column(name = "SUPPLIER", length = 50)
    private String supplier;
    @Size(max = 255)
    @Column(name = "MIXDESIGNNO", length = 255)
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "SLUMPSPEC", length = 50)
    private String slumpspec;
    @Size(max = 50)
    @Column(name = "AIRCONTENTSPEC", length = 50)
    private String aircontentspec;
    @Size(max = 50)
    @Column(name = "SPECIFIEDSTRENGTH", length = 50)
    private String specifiedstrength;
    @Size(max = 50)
    @Column(name = "TICKETNO", length = 50)
    private String ticketno;
    @Size(max = 50)
    @Column(name = "TRUCKNO", length = 50)
    private String truckno;
    @Size(max = 50)
    @Column(name = "BATCHTIME", length = 50)
    private String batchtime;
    @Size(max = 50)
    @Column(name = "CEMENT", length = 50)
    private String cement;
    @Size(max = 50)
    @Column(name = "FLAYASH", length = 50)
    private String flayash;
    @Size(max = 50)
    @Column(name = "WATER", length = 50)
    private String water;
    @Size(max = 50)
    @Column(name = "WATERADDED", length = 50)
    private String wateradded;
    @Size(max = 50)
    @Column(name = "FINEAGG", length = 50)
    private String fineagg;
    @Size(max = 50)
    @Column(name = "COARSEAGG", length = 50)
    private String coarseagg;
    @Size(max = 50)
    @Column(name = "ADMIX", length = 50)
    private String admix;
    @Size(max = 50)
    @Column(name = "ADMIX2", length = 50)
    private String admix2;
    @Size(max = 50)
    @Column(name = "ADMIX3", length = 50)
    private String admix3;
    @Size(max = 50)
    @Column(name = "BATCHSIZE", length = 50)
    private String batchsize;
    @Size(max = 50)
    @Column(name = "ACCUMNO", length = 50)
    private String accumno;
    @Size(max = 50)
    @Column(name = "ACCUMTOTAL", length = 50)
    private String accumtotal;
    @Size(max = 50)
    @Column(name = "ACCUMTOTAL2", length = 50)
    private String accumtotal2;
    @Size(max = 50)
    @Column(name = "SAMPLEDAT", length = 50)
    private String sampledat;
    @Size(max = 50)
    @Column(name = "AVG28DAYS", length = 50)
    private String avg28days;
    @Size(max = 50)
    @Column(name = "UNITCONCP", length = 50)
    private String unitconcp;
    @Size(max = 50)
    @Column(name = "FLAGADJCPMM", length = 50)
    private String flagadjcpmm;
    @Size(max = 50)
    @Column(name = "FLAGADJSLUMPMM", length = 50)
    private String flagadjslumpmm;
    @Size(max = 50)
    @Column(name = "FLAGADJCOMCOMP", length = 50)
    private String flagadjcomcomp;
    @Size(max = 50)
    @Column(name = "MOLDING", length = 50)
    private String molding;
    @Size(max = 50)
    @Column(name = "SAMPLEPLUMB", length = 50)
    private String sampleplumb;
    @Size(max = 50)
    @Column(name = "MINTEMP", length = 50)
    private String mintemp;
    @Size(max = 50)
    @Column(name = "MAXTEMP", length = 50)
    private String maxtemp;
    @Size(max = 50)
    @Column(name = "AGETRANSPORT", length = 50)
    private String agetransport;
    @Size(max = 50)
    @Column(name = "PAGE", length = 50)
    private String page;
    @Size(max = 50)
    @Column(name = "REPORT", length = 50)
    private String report;
    @Size(max = 255)
    @Column(name = "FIELD1", length = 255)
    private String field1;
    @Size(max = 255)
    @Column(name = "FIELD2", length = 255)
    private String field2;
    @Size(max = 255)
    @Column(name = "FIELD3", length = 255)
    private String field3;
    @Size(max = 255)
    @Column(name = "FIELD4", length = 255)
    private String field4;
    @Size(max = 255)
    @Column(name = "FIELD5", length = 255)
    private String field5;
    @Size(max = 255)
    @Column(name = "FIELD6", length = 255)
    private String field6;
    @Size(max = 255)
    @Column(name = "FIELD7", length = 255)
    private String field7;
    @Size(max = 255)
    @Column(name = "FIELD8", length = 255)
    private String field8;
    @Size(max = 255)
    @Column(name = "FIELD9", length = 255)
    private String field9;
    @Size(max = 255)
    @Column(name = "FIELD10", length = 255)
    private String field10;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 100)
    @Column(name = "PLANT", length = 100)
    private String plant;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;
    @Size(max = 4000)
    @Column(name = "FIELD_TESTNO", length = 4000)
    private String fieldTestno;
    @Size(max = 4000)
    @Column(name = "FINEAGG_MSTPCT", length = 4000)
    private String fineaggMstpct;
    @Size(max = 4000)
    @Column(name = "MEDAGG", length = 4000)
    private String medagg;
    @Size(max = 4000)
    @Column(name = "MEDAGG_MSTPCT", length = 4000)
    private String medaggMstpct;
    @Size(max = 4000)
    @Column(name = "COARSEAGG_MSTPCT", length = 4000)
    private String coarseaggMstpct;
    @Size(max = 4000)
    @Column(name = "PLACEMENTLOCATION", length = 4000)
    private String placementlocation;
    @Size(max = 4000)
    @Column(name = "SAMPLELOCATION", length = 4000)
    private String samplelocation;
    @Size(max = 150)
    @Column(name = "INSTALLINGCOMPANY", length = 150)
    private String installingcompany;
    @Size(max = 150)
    @Column(name = "INSPECTINGCOMPANY", length = 150)
    private String inspectingcompany;
    @Size(max = 150)
    @Column(name = "QCCOMPANY", length = 150)
    private String qccompany;
    @Size(max = 150)
    @Column(name = "ACCEPTINGCOMPANY", length = 150)
    private String acceptingcompany;
    @Size(max = 150)
    @Column(name = "TANO", length = 150)
    private String tano;
    @Size(max = 50)
    @Column(name = "ACTUALSTARTTIME", length = 50)
    private String actualstarttime;
    @Size(max = 50)
    @Column(name = "ACTUALFINISHTIME", length = 50)
    private String actualfinishtime;
    @Size(max = 50)
    @Column(name = "AIRCONTENTMETHOD", length = 50)
    private String aircontentmethod;
    @Size(max = 50)
    @Column(name = "TIMEBATCHED", length = 50)
    private String timebatched;
    @Size(max = 50)
    @Column(name = "TIMESAMPLED", length = 50)
    private String timesampled;
    @Size(max = 4000)
    @Column(name = "CONFORMINGNOTES", length = 4000)
    private String conformingnotes;
    @Size(max = 4000)
    @Column(name = "NONCONFORMINGNOTES", length = 4000)
    private String nonconformingnotes;
    @Size(max = 4000)
    @Column(name = "NOTES", length = 4000)
    private String notes;
    @Size(max = 4000)
    @Column(name = "PLACEMENTSTRENGTH", length = 4000)
    private String placementstrength;
    @Size(max = 4000)
    @Column(name = "INSPECTOR", length = 4000)
    private String inspector;
    @Size(max = 4000)
    @Column(name = "PLANTNO", length = 4000)
    private String plantno;
    @Size(max = 4000)
    @Column(name = "STRUCTNAME", length = 4000)
    private String structname;
    @Size(max = 4000)
    @Column(name = "YIELD", length = 4000)
    private String yield;
    @Size(max = 4000)
    @Column(name = "TNCPUMP", length = 4000)
    private String tncpump;
    @Size(max = 4000)
    @Column(name = "LOADNO", length = 4000)
    private String loadno;
    @Size(max = 4000)
    @Column(name = "SPECSECTION", length = 4000)
    private String specsection;
    @Size(max = 50)
    @Column(name = "BATCHWEIGHT", length = 50)
    private String batchweight;
    @Size(max = 10)
    @Column(name = "AVGDAYS", length = 10)
    private String avgdays;
    @Size(max = 255)
    @Column(name = "TESTINGMACHINE", length = 255)
    private String testingmachine;
    @Size(max = 255)
    @Column(name = "CALIPER", length = 255)
    private String caliper;
    @Size(max = 255)
    @Column(name = "RETAININGRING", length = 255)
    private String retainingring;
    @Size(max = 4000)
    @Column(name = "REMARKS", length = 4000)
    private String remarks;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY", length = 4000)
    private String farSummary;
    @Column(name = "LOT_NO")
    private BigInteger lotNo;
    @Column(name = "SUBLOT_NO")
    private BigInteger sublotNo;
    @Size(max = 50)
    @Column(name = "SPECIFIEDSTRENGTH56DAYS", length = 50)
    private String specifiedstrength56days;
    @Size(max = 50)
    @Column(name = "AVG56DAYS", length = 50)
    private String avg56days;
    @Size(max = 50)
    @Column(name = "SPLITNO", length = 50)
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP", length = 4000)
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP", length = 4000)
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP", length = 4000)
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "PLACEMENTDATE_TMP", length = 4000)
    private String placementdateTmp;
    @Size(max = 50)
    @Column(name = "LAST_MOD", length = 50)
    private String lastMod;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Column(name = "PLACEMENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placementdate;
    @Size(max = 50)
    @Column(name = "CREATE_DATE", length = 50)
    private String createDate;
    @Size(max = 50)
    @Column(name = "CONTRACT_NAME", length = 50)
    private String contractName;
    @Size(max = 50)
    @Column(name = "ADMIX4", length = 50)
    private String admix4;
    @Size(max = 50)
    @Column(name = "WATER_CEMENT_RATIO", length = 50)
    private String waterCementRatio;
    @Column(name = "TESTPLAN_ID")
    private BigInteger testplanId;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Column(name = "MACHINE_STOPPED")
    private Character machineStopped;
    @Column(name = "REJECTED")
    private Character rejected;
    @Column(name = "POTENTIAL_ACTUAL_SUBMIT_REVIEW")
    private Character potentialActualSubmitReview;
    @Size(max = 50)
    @Column(name = "DEPART_LAB", length = 50)
    private String departLab;
    @Size(max = 50)
    @Column(name = "ARRIVE_SITE", length = 50)
    private String arriveSite;
    @Size(max = 50)
    @Column(name = "LUNCH_HOURS", length = 50)
    private String lunchHours;
    @Size(max = 50)
    @Column(name = "LUNCH_MINS", length = 50)
    private String lunchMins;
    @Size(max = 50)
    @Column(name = "DEPART_SITE", length = 50)
    private String departSite;
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB", length = 50)
    private String arriveLab;
    @Size(max = 50)
    @Column(name = "TOTAL_HOURS", length = 50)
    private String totalHours;
    @Column(name = "TECHNICIAN_HOURS_OVERTIME")
    private BigInteger technicianHoursOvertime;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO", length = 50)
    private String testReportNo;
    @Size(max = 50)
    @Column(name = "AVG7DAYS", length = 50)
    private String avg7days;
    @Size(max = 50)
    @Column(name = "CURING_METHOD", length = 50)
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "SPECIMEN_COVERED", length = 50)
    private String specimenCovered;
    @Size(max = 255)
    @Column(name = "LAB_PREP", length = 255)
    private String labPrep;
    @Size(max = 20)
    @Column(name = "VARIATION_COEFFICIENT", length = 20)
    private String variationCoefficient;
    @Size(max = 1)
    @Column(name = "MATERIAL_MET_REQUIREMENTS", length = 1)
    private String materialMetRequirements;
    @Size(max = 1)
    @Column(name = "MATERIAL_UNDER_REQUIREMENTS", length = 1)
    private String materialUnderRequirements;
    @Size(max = 1)
    @Column(name = "ADDITIONAL_COMMENTS", length = 1)
    private String additionalComments;
    @Size(max = 20)
    @Column(name = "SPEC_CONCRETE_TEMP_MIN", length = 20)
    private String specConcreteTempMin;
    @Size(max = 20)
    @Column(name = "SPEC_CONCRETE_TEMP_MAX", length = 20)
    private String specConcreteTempMax;
    @Size(max = 20)
    @Column(name = "CURRING_METHOD", length = 20)
    private String curringMethod;
    @Size(max = 100)
    @Column(name = "MILEAGE", length = 100)
    private String mileage;
    @Column(name = "PREVIOS_YARDAGE")
    private BigInteger previosYardage;
    @Column(name = "CURRENT_YARDAGE")
    private BigInteger currentYardage;
    @Column(name = "TESTED_YARDAGE")
    private BigInteger testedYardage;
    @Column(name = "YARDAGE_TO_DATE")
    private BigInteger yardageToDate;
    @Column(name = "USE_SEAL")
    private Character useSeal;
    @Column(name = "BRICK")
    private Character brick;
    @Column(name = "TERRACOTTA")
    private Character terracotta;
    @Column(name = "REINFORCED")
    private Character reinforced;
    @Column(name = "FLASHING_USED")
    private Character flashingUsed;
    @Column(name = "HAND_MIX")
    private Character handMix;
    @Column(name = "TRUCK")
    private Character truck;
    @Column(name = "CMU_BLOCK")
    private Character cmuBlock;
    @Column(name = "COPING_STONE")
    private Character copingStone;
    @Column(name = "UNREINFORCED")
    private Character unreinforced;
    @Column(name = "REFACTORY_BRICK_MOTAR")
    private Character refactoryBrickMotar;
    @Column(name = "PREMIX")
    private Character premix;
    @Column(name = "OTHER")
    private Character other;
    @Size(max = 255)
    @Column(name = "OTHER_INPUT", length = 255)
    private String otherInput;
    @Column(name = "S1800")
    private Character s1800;
    @Column(name = "N750")
    private Character n750;
    @Column(name = "O350")
    private Character o350;
    @Column(name = "M2500")
    private Character m2500;
    @Column(name = "OTHER_ASTM")
    private Character otherAstm;
    @Size(max = 255)
    @Column(name = "OTHER_ASTM_INPUT", length = 255)
    private String otherAstmInput;
    @Size(max = 10)
    @Column(name = "TYPE_AND_NUMBER", length = 10)
    private String typeAndNumber;

    public QaconcCompstr() {
    }

    public QaconcCompstr(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getTimecast() {
        return timecast;
    }

    public void setTimecast(String timecast) {
        this.timecast = timecast;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getAircontent() {
        return aircontent;
    }

    public void setAircontent(String aircontent) {
        this.aircontent = aircontent;
    }

    public String getMixtemp() {
        return mixtemp;
    }

    public void setMixtemp(String mixtemp) {
        this.mixtemp = mixtemp;
    }

    public String getAirtemp() {
        return airtemp;
    }

    public void setAirtemp(String airtemp) {
        this.airtemp = airtemp;
    }

    public String getUnitweight() {
        return unitweight;
    }

    public void setUnitweight(String unitweight) {
        this.unitweight = unitweight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getConcClass() {
        return concClass;
    }

    public void setConcClass(String concClass) {
        this.concClass = concClass;
    }

    public String getSamplecastby() {
        return samplecastby;
    }

    public void setSamplecastby(String samplecastby) {
        this.samplecastby = samplecastby;
    }

    public String getSetnumber() {
        return setnumber;
    }

    public void setSetnumber(String setnumber) {
        this.setnumber = setnumber;
    }

    public String getSetnumberof() {
        return setnumberof;
    }

    public void setSetnumberof(String setnumberof) {
        this.setnumberof = setnumberof;
    }

    public String getSamplesperset() {
        return samplesperset;
    }

    public void setSamplesperset(String samplesperset) {
        this.samplesperset = samplesperset;
    }

    public String getField11() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11 = field11;
    }

    public String getField12() {
        return field12;
    }

    public void setField12(String field12) {
        this.field12 = field12;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getSlumpspec() {
        return slumpspec;
    }

    public void setSlumpspec(String slumpspec) {
        this.slumpspec = slumpspec;
    }

    public String getAircontentspec() {
        return aircontentspec;
    }

    public void setAircontentspec(String aircontentspec) {
        this.aircontentspec = aircontentspec;
    }

    public String getSpecifiedstrength() {
        return specifiedstrength;
    }

    public void setSpecifiedstrength(String specifiedstrength) {
        this.specifiedstrength = specifiedstrength;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getTruckno() {
        return truckno;
    }

    public void setTruckno(String truckno) {
        this.truckno = truckno;
    }

    public String getBatchtime() {
        return batchtime;
    }

    public void setBatchtime(String batchtime) {
        this.batchtime = batchtime;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getFlayash() {
        return flayash;
    }

    public void setFlayash(String flayash) {
        this.flayash = flayash;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWateradded() {
        return wateradded;
    }

    public void setWateradded(String wateradded) {
        this.wateradded = wateradded;
    }

    public String getFineagg() {
        return fineagg;
    }

    public void setFineagg(String fineagg) {
        this.fineagg = fineagg;
    }

    public String getCoarseagg() {
        return coarseagg;
    }

    public void setCoarseagg(String coarseagg) {
        this.coarseagg = coarseagg;
    }

    public String getAdmix() {
        return admix;
    }

    public void setAdmix(String admix) {
        this.admix = admix;
    }

    public String getAdmix2() {
        return admix2;
    }

    public void setAdmix2(String admix2) {
        this.admix2 = admix2;
    }

    public String getAdmix3() {
        return admix3;
    }

    public void setAdmix3(String admix3) {
        this.admix3 = admix3;
    }

    public String getBatchsize() {
        return batchsize;
    }

    public void setBatchsize(String batchsize) {
        this.batchsize = batchsize;
    }

    public String getAccumno() {
        return accumno;
    }

    public void setAccumno(String accumno) {
        this.accumno = accumno;
    }

    public String getAccumtotal() {
        return accumtotal;
    }

    public void setAccumtotal(String accumtotal) {
        this.accumtotal = accumtotal;
    }

    public String getAccumtotal2() {
        return accumtotal2;
    }

    public void setAccumtotal2(String accumtotal2) {
        this.accumtotal2 = accumtotal2;
    }

    public String getSampledat() {
        return sampledat;
    }

    public void setSampledat(String sampledat) {
        this.sampledat = sampledat;
    }

    public String getAvg28days() {
        return avg28days;
    }

    public void setAvg28days(String avg28days) {
        this.avg28days = avg28days;
    }

    public String getUnitconcp() {
        return unitconcp;
    }

    public void setUnitconcp(String unitconcp) {
        this.unitconcp = unitconcp;
    }

    public String getFlagadjcpmm() {
        return flagadjcpmm;
    }

    public void setFlagadjcpmm(String flagadjcpmm) {
        this.flagadjcpmm = flagadjcpmm;
    }

    public String getFlagadjslumpmm() {
        return flagadjslumpmm;
    }

    public void setFlagadjslumpmm(String flagadjslumpmm) {
        this.flagadjslumpmm = flagadjslumpmm;
    }

    public String getFlagadjcomcomp() {
        return flagadjcomcomp;
    }

    public void setFlagadjcomcomp(String flagadjcomcomp) {
        this.flagadjcomcomp = flagadjcomcomp;
    }

    public String getMolding() {
        return molding;
    }

    public void setMolding(String molding) {
        this.molding = molding;
    }

    public String getSampleplumb() {
        return sampleplumb;
    }

    public void setSampleplumb(String sampleplumb) {
        this.sampleplumb = sampleplumb;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getAgetransport() {
        return agetransport;
    }

    public void setAgetransport(String agetransport) {
        this.agetransport = agetransport;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
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

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFieldTestno() {
        return fieldTestno;
    }

    public void setFieldTestno(String fieldTestno) {
        this.fieldTestno = fieldTestno;
    }

    public String getFineaggMstpct() {
        return fineaggMstpct;
    }

    public void setFineaggMstpct(String fineaggMstpct) {
        this.fineaggMstpct = fineaggMstpct;
    }

    public String getMedagg() {
        return medagg;
    }

    public void setMedagg(String medagg) {
        this.medagg = medagg;
    }

    public String getMedaggMstpct() {
        return medaggMstpct;
    }

    public void setMedaggMstpct(String medaggMstpct) {
        this.medaggMstpct = medaggMstpct;
    }

    public String getCoarseaggMstpct() {
        return coarseaggMstpct;
    }

    public void setCoarseaggMstpct(String coarseaggMstpct) {
        this.coarseaggMstpct = coarseaggMstpct;
    }

    public String getPlacementlocation() {
        return placementlocation;
    }

    public void setPlacementlocation(String placementlocation) {
        this.placementlocation = placementlocation;
    }

    public String getSamplelocation() {
        return samplelocation;
    }

    public void setSamplelocation(String samplelocation) {
        this.samplelocation = samplelocation;
    }

    public String getInstallingcompany() {
        return installingcompany;
    }

    public void setInstallingcompany(String installingcompany) {
        this.installingcompany = installingcompany;
    }

    public String getInspectingcompany() {
        return inspectingcompany;
    }

    public void setInspectingcompany(String inspectingcompany) {
        this.inspectingcompany = inspectingcompany;
    }

    public String getQccompany() {
        return qccompany;
    }

    public void setQccompany(String qccompany) {
        this.qccompany = qccompany;
    }

    public String getAcceptingcompany() {
        return acceptingcompany;
    }

    public void setAcceptingcompany(String acceptingcompany) {
        this.acceptingcompany = acceptingcompany;
    }

    public String getTano() {
        return tano;
    }

    public void setTano(String tano) {
        this.tano = tano;
    }

    public String getActualstarttime() {
        return actualstarttime;
    }

    public void setActualstarttime(String actualstarttime) {
        this.actualstarttime = actualstarttime;
    }

    public String getActualfinishtime() {
        return actualfinishtime;
    }

    public void setActualfinishtime(String actualfinishtime) {
        this.actualfinishtime = actualfinishtime;
    }

    public String getAircontentmethod() {
        return aircontentmethod;
    }

    public void setAircontentmethod(String aircontentmethod) {
        this.aircontentmethod = aircontentmethod;
    }

    public String getTimebatched() {
        return timebatched;
    }

    public void setTimebatched(String timebatched) {
        this.timebatched = timebatched;
    }

    public String getTimesampled() {
        return timesampled;
    }

    public void setTimesampled(String timesampled) {
        this.timesampled = timesampled;
    }

    public String getConformingnotes() {
        return conformingnotes;
    }

    public void setConformingnotes(String conformingnotes) {
        this.conformingnotes = conformingnotes;
    }

    public String getNonconformingnotes() {
        return nonconformingnotes;
    }

    public void setNonconformingnotes(String nonconformingnotes) {
        this.nonconformingnotes = nonconformingnotes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPlacementstrength() {
        return placementstrength;
    }

    public void setPlacementstrength(String placementstrength) {
        this.placementstrength = placementstrength;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getPlantno() {
        return plantno;
    }

    public void setPlantno(String plantno) {
        this.plantno = plantno;
    }

    public String getStructname() {
        return structname;
    }

    public void setStructname(String structname) {
        this.structname = structname;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public String getTncpump() {
        return tncpump;
    }

    public void setTncpump(String tncpump) {
        this.tncpump = tncpump;
    }

    public String getLoadno() {
        return loadno;
    }

    public void setLoadno(String loadno) {
        this.loadno = loadno;
    }

    public String getSpecsection() {
        return specsection;
    }

    public void setSpecsection(String specsection) {
        this.specsection = specsection;
    }

    public String getBatchweight() {
        return batchweight;
    }

    public void setBatchweight(String batchweight) {
        this.batchweight = batchweight;
    }

    public String getAvgdays() {
        return avgdays;
    }

    public void setAvgdays(String avgdays) {
        this.avgdays = avgdays;
    }

    public String getTestingmachine() {
        return testingmachine;
    }

    public void setTestingmachine(String testingmachine) {
        this.testingmachine = testingmachine;
    }

    public String getCaliper() {
        return caliper;
    }

    public void setCaliper(String caliper) {
        this.caliper = caliper;
    }

    public String getRetainingring() {
        return retainingring;
    }

    public void setRetainingring(String retainingring) {
        this.retainingring = retainingring;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public BigInteger getLotNo() {
        return lotNo;
    }

    public void setLotNo(BigInteger lotNo) {
        this.lotNo = lotNo;
    }

    public BigInteger getSublotNo() {
        return sublotNo;
    }

    public void setSublotNo(BigInteger sublotNo) {
        this.sublotNo = sublotNo;
    }

    public String getSpecifiedstrength56days() {
        return specifiedstrength56days;
    }

    public void setSpecifiedstrength56days(String specifiedstrength56days) {
        this.specifiedstrength56days = specifiedstrength56days;
    }

    public String getAvg56days() {
        return avg56days;
    }

    public void setAvg56days(String avg56days) {
        this.avg56days = avg56days;
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

    public String getPlacementdateTmp() {
        return placementdateTmp;
    }

    public void setPlacementdateTmp(String placementdateTmp) {
        this.placementdateTmp = placementdateTmp;
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

    public Date getPlacementdate() {
        return placementdate;
    }

    public void setPlacementdate(Date placementdate) {
        this.placementdate = placementdate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getAdmix4() {
        return admix4;
    }

    public void setAdmix4(String admix4) {
        this.admix4 = admix4;
    }

    public String getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(String waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public BigInteger getTestplanId() {
        return testplanId;
    }

    public void setTestplanId(BigInteger testplanId) {
        this.testplanId = testplanId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Character getMachineStopped() {
        return machineStopped;
    }

    public void setMachineStopped(Character machineStopped) {
        this.machineStopped = machineStopped;
    }

    public Character getRejected() {
        return rejected;
    }

    public void setRejected(Character rejected) {
        this.rejected = rejected;
    }

    public Character getPotentialActualSubmitReview() {
        return potentialActualSubmitReview;
    }

    public void setPotentialActualSubmitReview(Character potentialActualSubmitReview) {
        this.potentialActualSubmitReview = potentialActualSubmitReview;
    }

    public String getDepartLab() {
        return departLab;
    }

    public void setDepartLab(String departLab) {
        this.departLab = departLab;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    public void setArriveSite(String arriveSite) {
        this.arriveSite = arriveSite;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public String getLunchMins() {
        return lunchMins;
    }

    public void setLunchMins(String lunchMins) {
        this.lunchMins = lunchMins;
    }

    public String getDepartSite() {
        return departSite;
    }

    public void setDepartSite(String departSite) {
        this.departSite = departSite;
    }

    public String getArriveLab() {
        return arriveLab;
    }

    public void setArriveLab(String arriveLab) {
        this.arriveLab = arriveLab;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public BigInteger getTechnicianHoursOvertime() {
        return technicianHoursOvertime;
    }

    public void setTechnicianHoursOvertime(BigInteger technicianHoursOvertime) {
        this.technicianHoursOvertime = technicianHoursOvertime;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public String getAvg7days() {
        return avg7days;
    }

    public void setAvg7days(String avg7days) {
        this.avg7days = avg7days;
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

    public String getVariationCoefficient() {
        return variationCoefficient;
    }

    public void setVariationCoefficient(String variationCoefficient) {
        this.variationCoefficient = variationCoefficient;
    }

    public String getMaterialMetRequirements() {
        return materialMetRequirements;
    }

    public void setMaterialMetRequirements(String materialMetRequirements) {
        this.materialMetRequirements = materialMetRequirements;
    }

    public String getMaterialUnderRequirements() {
        return materialUnderRequirements;
    }

    public void setMaterialUnderRequirements(String materialUnderRequirements) {
        this.materialUnderRequirements = materialUnderRequirements;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getSpecConcreteTempMin() {
        return specConcreteTempMin;
    }

    public void setSpecConcreteTempMin(String specConcreteTempMin) {
        this.specConcreteTempMin = specConcreteTempMin;
    }

    public String getSpecConcreteTempMax() {
        return specConcreteTempMax;
    }

    public void setSpecConcreteTempMax(String specConcreteTempMax) {
        this.specConcreteTempMax = specConcreteTempMax;
    }

    public String getCurringMethod() {
        return curringMethod;
    }

    public void setCurringMethod(String curringMethod) {
        this.curringMethod = curringMethod;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public BigInteger getPreviosYardage() {
        return previosYardage;
    }

    public void setPreviosYardage(BigInteger previosYardage) {
        this.previosYardage = previosYardage;
    }

    public BigInteger getCurrentYardage() {
        return currentYardage;
    }

    public void setCurrentYardage(BigInteger currentYardage) {
        this.currentYardage = currentYardage;
    }

    public BigInteger getTestedYardage() {
        return testedYardage;
    }

    public void setTestedYardage(BigInteger testedYardage) {
        this.testedYardage = testedYardage;
    }

    public BigInteger getYardageToDate() {
        return yardageToDate;
    }

    public void setYardageToDate(BigInteger yardageToDate) {
        this.yardageToDate = yardageToDate;
    }

    public Character getUseSeal() {
        return useSeal;
    }

    public void setUseSeal(Character useSeal) {
        this.useSeal = useSeal;
    }

    public Character getBrick() {
        return brick;
    }

    public void setBrick(Character brick) {
        this.brick = brick;
    }

    public Character getTerracotta() {
        return terracotta;
    }

    public void setTerracotta(Character terracotta) {
        this.terracotta = terracotta;
    }

    public Character getReinforced() {
        return reinforced;
    }

    public void setReinforced(Character reinforced) {
        this.reinforced = reinforced;
    }

    public Character getFlashingUsed() {
        return flashingUsed;
    }

    public void setFlashingUsed(Character flashingUsed) {
        this.flashingUsed = flashingUsed;
    }

    public Character getHandMix() {
        return handMix;
    }

    public void setHandMix(Character handMix) {
        this.handMix = handMix;
    }

    public Character getTruck() {
        return truck;
    }

    public void setTruck(Character truck) {
        this.truck = truck;
    }

    public Character getCmuBlock() {
        return cmuBlock;
    }

    public void setCmuBlock(Character cmuBlock) {
        this.cmuBlock = cmuBlock;
    }

    public Character getCopingStone() {
        return copingStone;
    }

    public void setCopingStone(Character copingStone) {
        this.copingStone = copingStone;
    }

    public Character getUnreinforced() {
        return unreinforced;
    }

    public void setUnreinforced(Character unreinforced) {
        this.unreinforced = unreinforced;
    }

    public Character getRefactoryBrickMotar() {
        return refactoryBrickMotar;
    }

    public void setRefactoryBrickMotar(Character refactoryBrickMotar) {
        this.refactoryBrickMotar = refactoryBrickMotar;
    }

    public Character getPremix() {
        return premix;
    }

    public void setPremix(Character premix) {
        this.premix = premix;
    }

    public Character getOther() {
        return other;
    }

    public void setOther(Character other) {
        this.other = other;
    }

    public String getOtherInput() {
        return otherInput;
    }

    public void setOtherInput(String otherInput) {
        this.otherInput = otherInput;
    }

    public Character getS1800() {
        return s1800;
    }

    public void setS1800(Character s1800) {
        this.s1800 = s1800;
    }

    public Character getN750() {
        return n750;
    }

    public void setN750(Character n750) {
        this.n750 = n750;
    }

    public Character getO350() {
        return o350;
    }

    public void setO350(Character o350) {
        this.o350 = o350;
    }

    public Character getM2500() {
        return m2500;
    }

    public void setM2500(Character m2500) {
        this.m2500 = m2500;
    }

    public Character getOtherAstm() {
        return otherAstm;
    }

    public void setOtherAstm(Character otherAstm) {
        this.otherAstm = otherAstm;
    }

    public String getOtherAstmInput() {
        return otherAstmInput;
    }

    public void setOtherAstmInput(String otherAstmInput) {
        this.otherAstmInput = otherAstmInput;
    }

    public String getTypeAndNumber() {
        return typeAndNumber;
    }

    public void setTypeAndNumber(String typeAndNumber) {
        this.typeAndNumber = typeAndNumber;
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
        if (!(object instanceof QaconcCompstr)) {
            return false;
        }
        QaconcCompstr other = (QaconcCompstr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcCompstr[ id=" + id + " ]";
    }

}
