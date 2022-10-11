/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "QaSampleConcInfo.findByPlant", query = "SELECT q FROM QaSampleConcInfo q WHERE q.plant = :plant"),
    @NamedQuery(name = "QaSampleConcInfo.findByTicketNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.ticketNo = :ticketNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByTruckNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.truckNo = :truckNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByTimeBatched", query = "SELECT q FROM QaSampleConcInfo q WHERE q.timeBatched = :timeBatched"),
    @NamedQuery(name = "QaSampleConcInfo.findByBatchSize", query = "SELECT q FROM QaSampleConcInfo q WHERE q.batchSize = :batchSize"),
    @NamedQuery(name = "QaSampleConcInfo.findByCement", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cement = :cement"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAsh", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAsh = :flyAsh"),
    @NamedQuery(name = "QaSampleConcInfo.findByWater", query = "SELECT q FROM QaSampleConcInfo q WHERE q.water = :water"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterAdded", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterAdded = :waterAdded"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAgg", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAgg = :fineAgg"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggMoist", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggMoist = :fineAggMoist"),
    @NamedQuery(name = "QaSampleConcInfo.findByMediumAgg", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mediumAgg = :mediumAgg"),
    @NamedQuery(name = "QaSampleConcInfo.findByMediumAggMoist", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mediumAggMoist = :mediumAggMoist"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg = :coarseAgg"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggMoist", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggMoist = :coarseAggMoist"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterReducer", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterReducer = :waterReducer"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirEntrainment", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airEntrainment = :airEntrainment"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType1", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType1 = :admixtureType1"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty1", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty1 = :admixtureQty1"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType2 = :admixtureType2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty2 = :admixtureQty2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType3 = :admixtureType3"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty3 = :admixtureQty3"),
    @NamedQuery(name = "QaSampleConcInfo.findByMixTemperature", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mixTemperature = :mixTemperature"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirTemperature", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airTemperature = :airTemperature"),
    @NamedQuery(name = "QaSampleConcInfo.findByUnitWeight", query = "SELECT q FROM QaSampleConcInfo q WHERE q.unitWeight = :unitWeight"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlump", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slump = :slump"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirContent", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airContent = :airContent"),
    @NamedQuery(name = "QaSampleConcInfo.findByCastBy", query = "SELECT q FROM QaSampleConcInfo q WHERE q.castBy = :castBy"),
    @NamedQuery(name = "QaSampleConcInfo.findByTimeCast", query = "SELECT q FROM QaSampleConcInfo q WHERE q.timeCast = :timeCast"),
    @NamedQuery(name = "QaSampleConcInfo.findByElapsedTime", query = "SELECT q FROM QaSampleConcInfo q WHERE q.elapsedTime = :elapsedTime"),
    @NamedQuery(name = "QaSampleConcInfo.findByDay28StrSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.day28StrSpec = :day28StrSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlumpSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slumpSpec = :slumpSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirPctgContentSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airPctgContentSpec = :airPctgContentSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByConcClass", query = "SELECT q FROM QaSampleConcInfo q WHERE q.concClass = :concClass"),
    @NamedQuery(name = "QaSampleConcInfo.findByPlacementStrength", query = "SELECT q FROM QaSampleConcInfo q WHERE q.placementStrength = :placementStrength"),
    @NamedQuery(name = "QaSampleConcInfo.findByAccumNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.accumNo = :accumNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByTotalYd3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.totalYd3 = :totalYd3"),
    @NamedQuery(name = "QaSampleConcInfo.findBySetnumber", query = "SELECT q FROM QaSampleConcInfo q WHERE q.setnumber = :setnumber"),
    @NamedQuery(name = "QaSampleConcInfo.findBySetnumberof", query = "SELECT q FROM QaSampleConcInfo q WHERE q.setnumberof = :setnumberof"),
    @NamedQuery(name = "QaSampleConcInfo.findByLoadno", query = "SELECT q FROM QaSampleConcInfo q WHERE q.loadno = :loadno"),
    @NamedQuery(name = "QaSampleConcInfo.findBySuperplasticizer", query = "SELECT q FROM QaSampleConcInfo q WHERE q.superplasticizer = :superplasticizer"),
    @NamedQuery(name = "QaSampleConcInfo.findByCni", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cni = :cni"),
    @NamedQuery(name = "QaSampleConcInfo.findByYield", query = "SELECT q FROM QaSampleConcInfo q WHERE q.yield = :yield"),
    @NamedQuery(name = "QaSampleConcInfo.findByBatchweight", query = "SELECT q FROM QaSampleConcInfo q WHERE q.batchweight = :batchweight"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterCementRatio", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterCementRatio = :waterCementRatio"),
    @NamedQuery(name = "QaSampleConcInfo.findByTempSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.tempSpec = :tempSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByMaxWaterCementRatio", query = "SELECT q FROM QaSampleConcInfo q WHERE q.maxWaterCementRatio = :maxWaterCementRatio"),
    @NamedQuery(name = "QaSampleConcInfo.findByPumpNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.pumpNo = :pumpNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByClientMixDesign", query = "SELECT q FROM QaSampleConcInfo q WHERE q.clientMixDesign = :clientMixDesign"),
    @NamedQuery(name = "QaSampleConcInfo.findByDay28FlexStrSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.day28FlexStrSpec = :day28FlexStrSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByDay56StrSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.day56StrSpec = :day56StrSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByLifting", query = "SELECT q FROM QaSampleConcInfo q WHERE q.lifting = :lifting"),
    @NamedQuery(name = "QaSampleConcInfo.findByBoiledabsorption28day", query = "SELECT q FROM QaSampleConcInfo q WHERE q.boiledabsorption28day = :boiledabsorption28day"),
    @NamedQuery(name = "QaSampleConcInfo.findByTensilestr28day", query = "SELECT q FROM QaSampleConcInfo q WHERE q.tensilestr28day = :tensilestr28day"),
    @NamedQuery(name = "QaSampleConcInfo.findBySampleLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.sampleLocation = :sampleLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByFieldWaterCementRatio", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fieldWaterCementRatio = :fieldWaterCementRatio"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlump2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slump2 = :slump2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirContent2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airContent2 = :airContent2"),
    @NamedQuery(name = "QaSampleConcInfo.findByRevCount", query = "SELECT q FROM QaSampleConcInfo q WHERE q.revCount = :revCount"),
    @NamedQuery(name = "QaSampleConcInfo.findByElementName", query = "SELECT q FROM QaSampleConcInfo q WHERE q.elementName = :elementName"),
    @NamedQuery(name = "QaSampleConcInfo.findByStartTime", query = "SELECT q FROM QaSampleConcInfo q WHERE q.startTime = :startTime"),
    @NamedQuery(name = "QaSampleConcInfo.findByEndTime", query = "SELECT q FROM QaSampleConcInfo q WHERE q.endTime = :endTime"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirMeterType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airMeterType = :airMeterType"),
    @NamedQuery(name = "QaSampleConcInfo.findByThermometerNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.thermometerNo = :thermometerNo"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlumpConeNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slumpConeNo = :slumpConeNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirMeterNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airMeterNo = :airMeterNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType4", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType4 = :admixtureType4"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty4", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty4 = :admixtureQty4"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType5", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType5 = :admixtureType5"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty5", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty5 = :admixtureQty5"),
    @NamedQuery(name = "QaSampleConcInfo.findByAggSize", query = "SELECT q FROM QaSampleConcInfo q WHERE q.aggSize = :aggSize"),
    @NamedQuery(name = "QaSampleConcInfo.findByAggCorrectionFactor", query = "SELECT q FROM QaSampleConcInfo q WHERE q.aggCorrectionFactor = :aggCorrectionFactor"),
    @NamedQuery(name = "QaSampleConcInfo.findByCorrectedAirContent", query = "SELECT q FROM QaSampleConcInfo q WHERE q.correctedAirContent = :correctedAirContent"),
    @NamedQuery(name = "QaSampleConcInfo.findByDesignWater", query = "SELECT q FROM QaSampleConcInfo q WHERE q.designWater = :designWater"),
    @NamedQuery(name = "QaSampleConcInfo.findByPlacementAir", query = "SELECT q FROM QaSampleConcInfo q WHERE q.placementAir = :placementAir"),
    @NamedQuery(name = "QaSampleConcInfo.findByPlacementSlump", query = "SELECT q FROM QaSampleConcInfo q WHERE q.placementSlump = :placementSlump"),
    @NamedQuery(name = "QaSampleConcInfo.findByPumpAirLoss", query = "SELECT q FROM QaSampleConcInfo q WHERE q.pumpAirLoss = :pumpAirLoss"),
    @NamedQuery(name = "QaSampleConcInfo.findByPumpSlumpLoss", query = "SELECT q FROM QaSampleConcInfo q WHERE q.pumpSlumpLoss = :pumpSlumpLoss"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg2 = :coarseAgg2"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggMoist2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggMoist2 = :coarseAggMoist2"),
    @NamedQuery(name = "QaSampleConcInfo.findByRevCountFinal", query = "SELECT q FROM QaSampleConcInfo q WHERE q.revCountFinal = :revCountFinal"),
    @NamedQuery(name = "QaSampleConcInfo.findByCementCode", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cementCode = :cementCode"),
    @NamedQuery(name = "QaSampleConcInfo.findByCementType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cementType = :cementType"),
    @NamedQuery(name = "QaSampleConcInfo.findByCementSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cementSpecgrav = :cementSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAshCode", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAshCode = :flyAshCode"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAshType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAshType = :flyAshType"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAshSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAshSpecgrav = :flyAshSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggCode", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggCode = :fineAggCode"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggType = :fineAggType"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggSpecgrav = :fineAggSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByMediumAggCode", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mediumAggCode = :mediumAggCode"),
    @NamedQuery(name = "QaSampleConcInfo.findByMediumAggType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mediumAggType = :mediumAggType"),
    @NamedQuery(name = "QaSampleConcInfo.findByMediumAggSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mediumAggSpecgrav = :mediumAggSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggCode", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggCode = :coarseAggCode"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggType = :coarseAggType"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggSize", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggSize = :coarseAggSize"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggSpecgrav = :coarseAggSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg2Code", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg2Code = :coarseAgg2Code"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg2Type", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg2Type = :coarseAgg2Type"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg2Size", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg2Size = :coarseAgg2Size"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAgg2Specgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAgg2Specgrav = :coarseAgg2Specgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByEmptyTime", query = "SELECT q FROM QaSampleConcInfo q WHERE q.emptyTime = :emptyTime"),
    @NamedQuery(name = "QaSampleConcInfo.findByAggType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.aggType = :aggType"),
    @NamedQuery(name = "QaSampleConcInfo.findByTotalCementitious", query = "SELECT q FROM QaSampleConcInfo q WHERE q.totalCementitious = :totalCementitious"),
    @NamedQuery(name = "QaSampleConcInfo.findByVolumePaste", query = "SELECT q FROM QaSampleConcInfo q WHERE q.volumePaste = :volumePaste"),
    @NamedQuery(name = "QaSampleConcInfo.findByVolumeConcrete", query = "SELECT q FROM QaSampleConcInfo q WHERE q.volumeConcrete = :volumeConcrete"),
    @NamedQuery(name = "QaSampleConcInfo.findByVolumePastePct", query = "SELECT q FROM QaSampleConcInfo q WHERE q.volumePastePct = :volumePastePct"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggSource = :coarseAggSource"),
    @NamedQuery(name = "QaSampleConcInfo.findByCoarseAggLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.coarseAggLocation = :coarseAggLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggSource = :fineAggSource"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggLocation = :fineAggLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByCementSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cementSource = :cementSource"),
    @NamedQuery(name = "QaSampleConcInfo.findByCementLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.cementLocation = :cementLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAshSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAshSource = :flyAshSource"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlyAshLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flyAshLocation = :flyAshLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlag", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slag = :slag"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlagType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slagType = :slagType"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlagSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slagSpecgrav = :slagSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlagSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slagSource = :slagSource"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlagLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slagLocation = :slagLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findBySilicaFume", query = "SELECT q FROM QaSampleConcInfo q WHERE q.silicaFume = :silicaFume"),
    @NamedQuery(name = "QaSampleConcInfo.findBySilicaFumeType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.silicaFumeType = :silicaFumeType"),
    @NamedQuery(name = "QaSampleConcInfo.findBySilicaFumeSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.silicaFumeSpecgrav = :silicaFumeSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findBySilicaFumeSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.silicaFumeSource = :silicaFumeSource"),
    @NamedQuery(name = "QaSampleConcInfo.findBySilicaFumeLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.silicaFumeLocation = :silicaFumeLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterType", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterType = :waterType"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterSpecgrav", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterSpecgrav = :waterSpecgrav"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterSource", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterSource = :waterSource"),
    @NamedQuery(name = "QaSampleConcInfo.findByWaterLocation", query = "SELECT q FROM QaSampleConcInfo q WHERE q.waterLocation = :waterLocation"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav1", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav1 = :admixtureSpecgrav1"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource1", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource1 = :admixtureSource1"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct1", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct1 = :admixtureProduct1"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav2 = :admixtureSpecgrav2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource2 = :admixtureSource2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct2", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct2 = :admixtureProduct2"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav3 = :admixtureSpecgrav3"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource3 = :admixtureSource3"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct3", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct3 = :admixtureProduct3"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav4", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav4 = :admixtureSpecgrav4"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource4", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource4 = :admixtureSource4"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct4", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct4 = :admixtureProduct4"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav5", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav5 = :admixtureSpecgrav5"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource5", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource5 = :admixtureSource5"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct5", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct5 = :admixtureProduct5"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType6", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType6 = :admixtureType6"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty6", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty6 = :admixtureQty6"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav6", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav6 = :admixtureSpecgrav6"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource6", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource6 = :admixtureSource6"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct6", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct6 = :admixtureProduct6"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType7", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType7 = :admixtureType7"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty7", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty7 = :admixtureQty7"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav7", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav7 = :admixtureSpecgrav7"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource7", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource7 = :admixtureSource7"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct7", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct7 = :admixtureProduct7"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureType8", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureType8 = :admixtureType8"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureQty8", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureQty8 = :admixtureQty8"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSpecgrav8", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSpecgrav8 = :admixtureSpecgrav8"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureSource8", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureSource8 = :admixtureSource8"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdmixtureProduct8", query = "SELECT q FROM QaSampleConcInfo q WHERE q.admixtureProduct8 = :admixtureProduct8"),
    @NamedQuery(name = "QaSampleConcInfo.findByFormTemperature", query = "SELECT q FROM QaSampleConcInfo q WHERE q.formTemperature = :formTemperature"),
    @NamedQuery(name = "QaSampleConcInfo.findByAdditionalAdmixture", query = "SELECT q FROM QaSampleConcInfo q WHERE q.additionalAdmixture = :additionalAdmixture"),
    @NamedQuery(name = "QaSampleConcInfo.findBySlumpTestMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.slumpTestMethod = :slumpTestMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findByAirContentTestMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.airContentTestMethod = :airContentTestMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findByTempTestMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.tempTestMethod = :tempTestMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findByUnitWeightSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.unitWeightSpec = :unitWeightSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByUnitWeightTestMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.unitWeightTestMethod = :unitWeightTestMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findByScaleNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.scaleNo = :scaleNo"),
    @NamedQuery(name = "QaSampleConcInfo.findBySuperAirMeter", query = "SELECT q FROM QaSampleConcInfo q WHERE q.superAirMeter = :superAirMeter"),
    @NamedQuery(name = "QaSampleConcInfo.findBySuperAirMeterSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.superAirMeterSpec = :superAirMeterSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findBySuperAirMeterTestMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.superAirMeterTestMethod = :superAirMeterTestMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findBySuperAirMeterNo", query = "SELECT q FROM QaSampleConcInfo q WHERE q.superAirMeterNo = :superAirMeterNo"),
    @NamedQuery(name = "QaSampleConcInfo.findByFineAggSize", query = "SELECT q FROM QaSampleConcInfo q WHERE q.fineAggSize = :fineAggSize"),
    @NamedQuery(name = "QaSampleConcInfo.findBySpecimenShape", query = "SELECT q FROM QaSampleConcInfo q WHERE q.specimenShape = :specimenShape"),
    @NamedQuery(name = "QaSampleConcInfo.findBySpecimenCovered", query = "SELECT q FROM QaSampleConcInfo q WHERE q.specimenCovered = :specimenCovered"),
    @NamedQuery(name = "QaSampleConcInfo.findByCuringMethod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.curingMethod = :curingMethod"),
    @NamedQuery(name = "QaSampleConcInfo.findByCuringMintemp", query = "SELECT q FROM QaSampleConcInfo q WHERE q.curingMintemp = :curingMintemp"),
    @NamedQuery(name = "QaSampleConcInfo.findByCuringMaxtemp", query = "SELECT q FROM QaSampleConcInfo q WHERE q.curingMaxtemp = :curingMaxtemp"),
    @NamedQuery(name = "QaSampleConcInfo.findByLabprepOther", query = "SELECT q FROM QaSampleConcInfo q WHERE q.labprepOther = :labprepOther"),
    @NamedQuery(name = "QaSampleConcInfo.findByLabprepComments", query = "SELECT q FROM QaSampleConcInfo q WHERE q.labprepComments = :labprepComments"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlowAfterMix", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flowAfterMix = :flowAfterMix"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlowAfter30min", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flowAfter30min = :flowAfter30min"),
    @NamedQuery(name = "QaSampleConcInfo.findByWetDensity", query = "SELECT q FROM QaSampleConcInfo q WHERE q.wetDensity = :wetDensity"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlowAfterMixSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flowAfterMixSpec = :flowAfterMixSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByFlowAfter30minSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.flowAfter30minSpec = :flowAfter30minSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByWetDensitySpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.wetDensitySpec = :wetDensitySpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByDay7StrSpec", query = "SELECT q FROM QaSampleConcInfo q WHERE q.day7StrSpec = :day7StrSpec"),
    @NamedQuery(name = "QaSampleConcInfo.findByIce", query = "SELECT q FROM QaSampleConcInfo q WHERE q.ice = :ice"),
    @NamedQuery(name = "QaSampleConcInfo.findByTotalWater", query = "SELECT q FROM QaSampleConcInfo q WHERE q.totalWater = :totalWater"),
    @NamedQuery(name = "QaSampleConcInfo.findByCreateByIp", query = "SELECT q FROM QaSampleConcInfo q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleConcInfo.findByCreateDate", query = "SELECT q FROM QaSampleConcInfo q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSampleConcInfo.findByLastModBy", query = "SELECT q FROM QaSampleConcInfo q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleConcInfo.findByLastModIp", query = "SELECT q FROM QaSampleConcInfo q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleConcInfo.findByLastMod", query = "SELECT q FROM QaSampleConcInfo q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleConcInfo.findByVersion", query = "SELECT q FROM QaSampleConcInfo q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleConcInfo.findByActive", query = "SELECT q FROM QaSampleConcInfo q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleConcInfo.findByCuringBoxOnSiteCondition", query = "SELECT q FROM QaSampleConcInfo q WHERE q.curingBoxOnSiteCondition = :curingBoxOnSiteCondition"),
    @NamedQuery(name = "QaSampleConcInfo.findBySubContractor", query = "SELECT q FROM QaSampleConcInfo q WHERE q.subContractor = :subContractor"),
    @NamedQuery(name = "QaSampleConcInfo.findBySubContractorName", query = "SELECT q FROM QaSampleConcInfo q WHERE q.subContractorName = :subContractorName"),
    @NamedQuery(name = "QaSampleConcInfo.findByMixDesignOnSite", query = "SELECT q FROM QaSampleConcInfo q WHERE q.mixDesignOnSite = :mixDesignOnSite"),
    @NamedQuery(name = "QaSampleConcInfo.findByCreateBy", query = "SELECT q FROM QaSampleConcInfo q WHERE q.createBy = :createBy")
*/

/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QA_SAMPLE_CONC_INFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleConcInfo.findAll", query = "SELECT q FROM QaSampleConcInfo q"),
    @NamedQuery(name = "QaSampleConcInfo.findBySampleId", query = "SELECT q FROM QaSampleConcInfo q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaSampleConcInfo.findById", query = "SELECT q FROM QaSampleConcInfo q WHERE q.id = :id")
    })
public class QaSampleConcInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAMPLE_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal sampleId;
    @Size(max = 100)
    @Column(name = "PLANT", length = 100)
    private String plant;
    @Size(max = 100)
    @Column(name = "TICKET_NO", length = 100)
    private String ticketNo;
    @Size(max = 12)
    @Column(name = "TRUCK_NO", length = 12)
    private String truckNo;
    @Size(max = 15)
    @Column(name = "TIME_BATCHED", length = 15)
    private String timeBatched;
    @Size(max = 12)
    @Column(name = "BATCH_SIZE", length = 12)
    private String batchSize;
    @Size(max = 12)
    @Column(name = "CEMENT", length = 12)
    private String cement;
    @Size(max = 12)
    @Column(name = "FLY_ASH", length = 12)
    private String flyAsh;
    @Size(max = 12)
    @Column(name = "WATER", length = 12)
    private String water;
    @Size(max = 12)
    @Column(name = "WATER_ADDED", length = 12)
    private String waterAdded;
    @Size(max = 12)
    @Column(name = "FINE_AGG", length = 12)
    private String fineAgg;
    @Size(max = 12)
    @Column(name = "FINE_AGG_MOIST", length = 12)
    private String fineAggMoist;
    @Size(max = 12)
    @Column(name = "MEDIUM_AGG", length = 12)
    private String mediumAgg;
    @Size(max = 12)
    @Column(name = "MEDIUM_AGG_MOIST", length = 12)
    private String mediumAggMoist;
    @Size(max = 12)
    @Column(name = "COARSE_AGG", length = 12)
    private String coarseAgg;
    @Size(max = 12)
    @Column(name = "COARSE_AGG_MOIST", length = 12)
    private String coarseAggMoist;
    @Size(max = 12)
    @Column(name = "WATER_REDUCER", length = 12)
    private String waterReducer;
    @Size(max = 12)
    @Column(name = "AIR_ENTRAINMENT", length = 12)
    private String airEntrainment;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_1", length = 100)
    private String admixtureType1;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_1", length = 12)
    private String admixtureQty1;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_2", length = 100)
    private String admixtureType2;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_2", length = 12)
    private String admixtureQty2;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_3", length = 100)
    private String admixtureType3;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_3", length = 12)
    private String admixtureQty3;
    @Size(max = 12)
    @Column(name = "MIX_TEMPERATURE", length = 12)
    private String mixTemperature;
    @Size(max = 50)
    @Column(name = "AIR_TEMPERATURE", length = 50)
    private String airTemperature;
    @Size(max = 12)
    @Column(name = "UNIT_WEIGHT", length = 12)
    private String unitWeight;
    @Size(max = 50)
    @Column(name = "SLUMP", length = 50)
    private String slump;
    @Size(max = 50)
    @Column(name = "AIR_CONTENT", length = 50)
    private String airContent;
    @Size(max = 100)
    @Column(name = "CAST_BY", length = 100)
    private String castBy;
    @Size(max = 15)
    @Column(name = "TIME_CAST", length = 15)
    private String timeCast;
    @Size(max = 15)
    @Column(name = "ELAPSED_TIME", length = 15)
    private String elapsedTime;
    @Size(max = 15)
    @Column(name = "DAY28_STR_SPEC", length = 15)
    private String day28StrSpec;
    @Size(max = 15)
    @Column(name = "SLUMP_SPEC", length = 15)
    private String slumpSpec;
    @Size(max = 15)
    @Column(name = "AIR_PCTG_CONTENT_SPEC", length = 15)
    private String airPctgContentSpec;
    @Size(max = 100)
    @Column(name = "CONC_CLASS", length = 100)
    private String concClass;
    @Size(max = 100)
    @Column(name = "PLACEMENT_STRENGTH", length = 100)
    private String placementStrength;
    @Size(max = 15)
    @Column(name = "ACCUM_NO", length = 15)
    private String accumNo;
    @Size(max = 15)
    @Column(name = "TOTAL_YD3", length = 15)
    private String totalYd3;
    @Size(max = 15)
    @Column(name = "SETNUMBER", length = 15)
    private String setnumber;
    @Size(max = 15)
    @Column(name = "SETNUMBEROF", length = 15)
    private String setnumberof;
    @Size(max = 50)
    @Column(name = "LOADNO", length = 50)
    private String loadno;
    @Size(max = 50)
    @Column(name = "SUPERPLASTICIZER", length = 50)
    private String superplasticizer;
    @Size(max = 50)
    @Column(name = "CNI", length = 50)
    private String cni;
    @Size(max = 50)
    @Column(name = "YIELD", length = 50)
    private String yield;
    @Size(max = 50)
    @Column(name = "BATCHWEIGHT", length = 50)
    private String batchweight;
    @Size(max = 50)
    @Column(name = "WATER_CEMENT_RATIO", length = 50)
    private String waterCementRatio;
    @Size(max = 20)
    @Column(name = "TEMP_SPEC", length = 20)
    private String tempSpec;
    @Size(max = 20)
    @Column(name = "MAX_WATER_CEMENT_RATIO", length = 20)
    private String maxWaterCementRatio;
    @Size(max = 100)
    @Column(name = "PUMP_NO", length = 100)
    private String pumpNo;
    @Size(max = 100)
    @Column(name = "CLIENT_MIX_DESIGN", length = 100)
    private String clientMixDesign;
    @Size(max = 15)
    @Column(name = "DAY28_FLEX_STR_SPEC", length = 15)
    private String day28FlexStrSpec;
    @Size(max = 15)
    @Column(name = "DAY56_STR_SPEC", length = 15)
    private String day56StrSpec;
    @Column(name = "LIFTING")
    private BigInteger lifting;
    @Column(name = "BOILEDABSORPTION28DAY")
    private BigInteger boiledabsorption28day;
    @Column(name = "TENSILESTR28DAY")
    private BigInteger tensilestr28day;
    @Size(max = 255)
    @Column(name = "SAMPLE_LOCATION", length = 255)
    private String sampleLocation;
    @Size(max = 50)
    @Column(name = "FIELD_WATER_CEMENT_RATIO", length = 50)
    private String fieldWaterCementRatio;
    @Size(max = 50)
    @Column(name = "SLUMP2", length = 50)
    private String slump2;
    @Size(max = 50)
    @Column(name = "AIR_CONTENT2", length = 50)
    private String airContent2;
    @Size(max = 50)
    @Column(name = "REV_COUNT", length = 50)
    private String revCount;
    @Size(max = 50)
    @Column(name = "ELEMENT_NAME", length = 50)
    private String elementName;
    @Size(max = 50)
    @Column(name = "START_TIME", length = 50)
    private String startTime;
    @Size(max = 50)
    @Column(name = "END_TIME", length = 50)
    private String endTime;
    @Size(max = 50)
    @Column(name = "AIR_METER_TYPE", length = 50)
    private String airMeterType;
    @Size(max = 50)
    @Column(name = "THERMOMETER_NO", length = 50)
    private String thermometerNo;
    @Size(max = 50)
    @Column(name = "SLUMP_CONE_NO", length = 50)
    private String slumpConeNo;
    @Size(max = 50)
    @Column(name = "AIR_METER_NO", length = 50)
    private String airMeterNo;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_4", length = 100)
    private String admixtureType4;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_4", length = 12)
    private String admixtureQty4;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_5", length = 100)
    private String admixtureType5;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_5", length = 12)
    private String admixtureQty5;
    @Size(max = 50)
    @Column(name = "AGG_SIZE", length = 50)
    private String aggSize;
    @Size(max = 50)
    @Column(name = "AGG_CORRECTION_FACTOR", length = 50)
    private String aggCorrectionFactor;
    @Size(max = 50)
    @Column(name = "CORRECTED_AIR_CONTENT", length = 50)
    private String correctedAirContent;
    @Size(max = 50)
    @Column(name = "DESIGN_WATER", length = 50)
    private String designWater;
    @Size(max = 50)
    @Column(name = "PLACEMENT_AIR", length = 50)
    private String placementAir;
    @Size(max = 50)
    @Column(name = "PLACEMENT_SLUMP", length = 50)
    private String placementSlump;
    @Size(max = 50)
    @Column(name = "PUMP_AIR_LOSS", length = 50)
    private String pumpAirLoss;
    @Size(max = 50)
    @Column(name = "PUMP_SLUMP_LOSS", length = 50)
    private String pumpSlumpLoss;
    @Size(max = 12)
    @Column(name = "COARSE_AGG2", length = 12)
    private String coarseAgg2;
    @Size(max = 12)
    @Column(name = "COARSE_AGG_MOIST2", length = 12)
    private String coarseAggMoist2;
    @Size(max = 50)
    @Column(name = "REV_COUNT_FINAL", length = 50)
    private String revCountFinal;
    @Size(max = 50)
    @Column(name = "CEMENT_CODE", length = 50)
    private String cementCode;
    @Size(max = 50)
    @Column(name = "CEMENT_TYPE", length = 50)
    private String cementType;
    @Size(max = 50)
    @Column(name = "CEMENT_SPECGRAV", length = 50)
    private String cementSpecgrav;
    @Size(max = 50)
    @Column(name = "FLY_ASH_CODE", length = 50)
    private String flyAshCode;
    @Size(max = 50)
    @Column(name = "FLY_ASH_TYPE", length = 50)
    private String flyAshType;
    @Size(max = 50)
    @Column(name = "FLY_ASH_SPECGRAV", length = 50)
    private String flyAshSpecgrav;
    @Size(max = 50)
    @Column(name = "FINE_AGG_CODE", length = 50)
    private String fineAggCode;
    @Size(max = 50)
    @Column(name = "FINE_AGG_TYPE", length = 50)
    private String fineAggType;
    @Size(max = 50)
    @Column(name = "FINE_AGG_SPECGRAV", length = 50)
    private String fineAggSpecgrav;
    @Size(max = 50)
    @Column(name = "MEDIUM_AGG_CODE", length = 50)
    private String mediumAggCode;
    @Size(max = 50)
    @Column(name = "MEDIUM_AGG_TYPE", length = 50)
    private String mediumAggType;
    @Size(max = 50)
    @Column(name = "MEDIUM_AGG_SPECGRAV", length = 50)
    private String mediumAggSpecgrav;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_CODE", length = 50)
    private String coarseAggCode;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_TYPE", length = 50)
    private String coarseAggType;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_SIZE", length = 50)
    private String coarseAggSize;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_SPECGRAV", length = 50)
    private String coarseAggSpecgrav;
    @Size(max = 50)
    @Column(name = "COARSE_AGG2_CODE", length = 50)
    private String coarseAgg2Code;
    @Size(max = 50)
    @Column(name = "COARSE_AGG2_TYPE", length = 50)
    private String coarseAgg2Type;
    @Size(max = 50)
    @Column(name = "COARSE_AGG2_SIZE", length = 50)
    private String coarseAgg2Size;
    @Size(max = 50)
    @Column(name = "COARSE_AGG2_SPECGRAV", length = 50)
    private String coarseAgg2Specgrav;
    @Size(max = 50)
    @Column(name = "EMPTY_TIME", length = 50)
    private String emptyTime;
    @Size(max = 50)
    @Column(name = "AGG_TYPE", length = 50)
    private String aggType;
    @Size(max = 50)
    @Column(name = "TOTAL_CEMENTITIOUS", length = 50)
    private String totalCementitious;
    @Size(max = 50)
    @Column(name = "VOLUME_PASTE", length = 50)
    private String volumePaste;
    @Size(max = 50)
    @Column(name = "VOLUME_CONCRETE", length = 50)
    private String volumeConcrete;
    @Size(max = 50)
    @Column(name = "VOLUME_PASTE_PCT", length = 50)
    private String volumePastePct;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_SOURCE", length = 50)
    private String coarseAggSource;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_LOCATION", length = 50)
    private String coarseAggLocation;
    @Size(max = 50)
    @Column(name = "FINE_AGG_SOURCE", length = 50)
    private String fineAggSource;
    @Size(max = 50)
    @Column(name = "FINE_AGG_LOCATION", length = 50)
    private String fineAggLocation;
    @Size(max = 50)
    @Column(name = "CEMENT_SOURCE", length = 50)
    private String cementSource;
    @Size(max = 50)
    @Column(name = "CEMENT_LOCATION", length = 50)
    private String cementLocation;
    @Size(max = 50)
    @Column(name = "FLY_ASH_SOURCE", length = 50)
    private String flyAshSource;
    @Size(max = 50)
    @Column(name = "FLY_ASH_LOCATION", length = 50)
    private String flyAshLocation;
    @Size(max = 50)
    @Column(name = "SLAG", length = 50)
    private String slag;
    @Size(max = 50)
    @Column(name = "SLAG_TYPE", length = 50)
    private String slagType;
    @Size(max = 50)
    @Column(name = "SLAG_SPECGRAV", length = 50)
    private String slagSpecgrav;
    @Size(max = 50)
    @Column(name = "SLAG_SOURCE", length = 50)
    private String slagSource;
    @Size(max = 50)
    @Column(name = "SLAG_LOCATION", length = 50)
    private String slagLocation;
    @Size(max = 50)
    @Column(name = "SILICA_FUME", length = 50)
    private String silicaFume;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_TYPE", length = 50)
    private String silicaFumeType;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_SPECGRAV", length = 50)
    private String silicaFumeSpecgrav;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_SOURCE", length = 50)
    private String silicaFumeSource;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_LOCATION", length = 50)
    private String silicaFumeLocation;
    @Size(max = 50)
    @Column(name = "WATER_TYPE", length = 50)
    private String waterType;
    @Size(max = 50)
    @Column(name = "WATER_SPECGRAV", length = 50)
    private String waterSpecgrav;
    @Size(max = 50)
    @Column(name = "WATER_SOURCE", length = 50)
    private String waterSource;
    @Size(max = 50)
    @Column(name = "WATER_LOCATION", length = 50)
    private String waterLocation;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_1", length = 50)
    private String admixtureSpecgrav1;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_1", length = 50)
    private String admixtureSource1;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_1", length = 50)
    private String admixtureProduct1;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_2", length = 50)
    private String admixtureSpecgrav2;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_2", length = 50)
    private String admixtureSource2;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_2", length = 50)
    private String admixtureProduct2;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_3", length = 50)
    private String admixtureSpecgrav3;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_3", length = 50)
    private String admixtureSource3;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_3", length = 50)
    private String admixtureProduct3;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_4", length = 50)
    private String admixtureSpecgrav4;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_4", length = 50)
    private String admixtureSource4;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_4", length = 50)
    private String admixtureProduct4;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_5", length = 50)
    private String admixtureSpecgrav5;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_5", length = 50)
    private String admixtureSource5;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_5", length = 50)
    private String admixtureProduct5;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_TYPE_6", length = 50)
    private String admixtureType6;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_QTY_6", length = 50)
    private String admixtureQty6;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_6", length = 50)
    private String admixtureSpecgrav6;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_6", length = 50)
    private String admixtureSource6;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_6", length = 50)
    private String admixtureProduct6;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_TYPE_7", length = 50)
    private String admixtureType7;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_QTY_7", length = 50)
    private String admixtureQty7;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_7", length = 50)
    private String admixtureSpecgrav7;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_7", length = 50)
    private String admixtureSource7;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_7", length = 50)
    private String admixtureProduct7;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_TYPE_8", length = 50)
    private String admixtureType8;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_QTY_8", length = 50)
    private String admixtureQty8;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SPECGRAV_8", length = 50)
    private String admixtureSpecgrav8;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_SOURCE_8", length = 50)
    private String admixtureSource8;
    @Size(max = 50)
    @Column(name = "ADMIXTURE_PRODUCT_8", length = 50)
    private String admixtureProduct8;
    @Size(max = 50)
    @Column(name = "FORM_TEMPERATURE", length = 50)
    private String formTemperature;
    @Size(max = 50)
    @Column(name = "ADDITIONAL_ADMIXTURE", length = 50)
    private String additionalAdmixture;
    @Size(max = 50)
    @Column(name = "SLUMP_TEST_METHOD", length = 50)
    private String slumpTestMethod;
    @Size(max = 50)
    @Column(name = "AIR_CONTENT_TEST_METHOD", length = 50)
    private String airContentTestMethod;
    @Size(max = 50)
    @Column(name = "TEMP_TEST_METHOD", length = 50)
    private String tempTestMethod;
    @Size(max = 50)
    @Column(name = "UNIT_WEIGHT_SPEC", length = 50)
    private String unitWeightSpec;
    @Size(max = 50)
    @Column(name = "UNIT_WEIGHT_TEST_METHOD", length = 50)
    private String unitWeightTestMethod;
    @Size(max = 50)
    @Column(name = "SCALE_NO", length = 50)
    private String scaleNo;
    @Size(max = 50)
    @Column(name = "SUPER_AIR_METER", length = 50)
    private String superAirMeter;
    @Size(max = 50)
    @Column(name = "SUPER_AIR_METER_SPEC", length = 50)
    private String superAirMeterSpec;
    @Size(max = 50)
    @Column(name = "SUPER_AIR_METER_TEST_METHOD", length = 50)
    private String superAirMeterTestMethod;
    @Size(max = 50)
    @Column(name = "SUPER_AIR_METER_NO", length = 50)
    private String superAirMeterNo;
    @Size(max = 50)
    @Column(name = "FINE_AGG_SIZE", length = 50)
    private String fineAggSize;
    @Size(max = 50)
    @Column(name = "SPECIMEN_SHAPE", length = 50)
    private String specimenShape;
    @Size(max = 50)
    @Column(name = "SPECIMEN_COVERED", length = 50)
    private String specimenCovered;
    @Size(max = 50)
    @Column(name = "CURING_METHOD", length = 50)
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "CURING_MINTEMP", length = 50)
    private String curingMintemp;
    @Size(max = 50)
    @Column(name = "CURING_MAXTEMP", length = 50)
    private String curingMaxtemp;
    @Size(max = 50)
    @Column(name = "LABPREP_OTHER", length = 50)
    private String labprepOther;
    @Size(max = 4000)
    @Column(name = "LABPREP_COMMENTS", length = 4000)
    private String labprepComments;
    @Size(max = 50)
    @Column(name = "FLOW_AFTER_MIX", length = 50)
    private String flowAfterMix;
    @Size(max = 50)
    @Column(name = "FLOW_AFTER_30MIN", length = 50)
    private String flowAfter30min;
    @Size(max = 50)
    @Column(name = "WET_DENSITY", length = 50)
    private String wetDensity;
    @Size(max = 50)
    @Column(name = "FLOW_AFTER_MIX_SPEC", length = 50)
    private String flowAfterMixSpec;
    @Size(max = 50)
    @Column(name = "FLOW_AFTER_30MIN_SPEC", length = 50)
    private String flowAfter30minSpec;
    @Size(max = 50)
    @Column(name = "WET_DENSITY_SPEC", length = 50)
    private String wetDensitySpec;
    @Size(max = 50)
    @Column(name = "DAY7_STR_SPEC", length = 50)
    private String day7StrSpec;
    @Size(max = 50)
    @Column(name = "ICE", length = 50)
    private String ice;
    @Size(max = 50)
    @Column(name = "TOTAL_WATER", length = 50)
    private String totalWater;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE", length = 50)
    private String createDate;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD", length = 50)
    private String lastMod;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "ID")
    private BigInteger id;
    @Size(max = 30)
    @Column(name = "CURING_BOX_ON_SITE_CONDITION", length = 30)
    private String curingBoxOnSiteCondition;
    @Size(max = 255)
    @Column(name = "SUB_CONTRACTOR", length = 255)
    private String subContractor;
    @Size(max = 255)
    @Column(name = "SUB_CONTRACTOR_NAME", length = 255)
    private String subContractorName;
    @Column(name = "MIX_DESIGN_ON_SITE")
    private Character mixDesignOnSite;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;

    public QaSampleConcInfo() {
    }

    public QaSampleConcInfo(BigDecimal sampleId) {
        this.sampleId = sampleId;
        this.id = sampleId.toBigInteger();
    }

    public BigDecimal getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigDecimal sampleId) {
        this.sampleId = sampleId;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
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

    public String getTimeBatched() {
        return timeBatched;
    }

    public void setTimeBatched(String timeBatched) {
        this.timeBatched = timeBatched;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getFlyAsh() {
        return flyAsh;
    }

    public void setFlyAsh(String flyAsh) {
        this.flyAsh = flyAsh;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWaterAdded() {
        return waterAdded;
    }

    public void setWaterAdded(String waterAdded) {
        this.waterAdded = waterAdded;
    }

    public String getFineAgg() {
        return fineAgg;
    }

    public void setFineAgg(String fineAgg) {
        this.fineAgg = fineAgg;
    }

    public String getFineAggMoist() {
        return fineAggMoist;
    }

    public void setFineAggMoist(String fineAggMoist) {
        this.fineAggMoist = fineAggMoist;
    }

    public String getMediumAgg() {
        return mediumAgg;
    }

    public void setMediumAgg(String mediumAgg) {
        this.mediumAgg = mediumAgg;
    }

    public String getMediumAggMoist() {
        return mediumAggMoist;
    }

    public void setMediumAggMoist(String mediumAggMoist) {
        this.mediumAggMoist = mediumAggMoist;
    }

    public String getCoarseAgg() {
        return coarseAgg;
    }

    public void setCoarseAgg(String coarseAgg) {
        this.coarseAgg = coarseAgg;
    }

    public String getCoarseAggMoist() {
        return coarseAggMoist;
    }

    public void setCoarseAggMoist(String coarseAggMoist) {
        this.coarseAggMoist = coarseAggMoist;
    }

    public String getWaterReducer() {
        return waterReducer;
    }

    public void setWaterReducer(String waterReducer) {
        this.waterReducer = waterReducer;
    }

    public String getAirEntrainment() {
        return airEntrainment;
    }

    public void setAirEntrainment(String airEntrainment) {
        this.airEntrainment = airEntrainment;
    }

    public String getAdmixtureType1() {
        return admixtureType1;
    }

    public void setAdmixtureType1(String admixtureType1) {
        this.admixtureType1 = admixtureType1;
    }

    public String getAdmixtureQty1() {
        return admixtureQty1;
    }

    public void setAdmixtureQty1(String admixtureQty1) {
        this.admixtureQty1 = admixtureQty1;
    }

    public String getAdmixtureType2() {
        return admixtureType2;
    }

    public void setAdmixtureType2(String admixtureType2) {
        this.admixtureType2 = admixtureType2;
    }

    public String getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(String admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public String getAdmixtureType3() {
        return admixtureType3;
    }

    public void setAdmixtureType3(String admixtureType3) {
        this.admixtureType3 = admixtureType3;
    }

    public String getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(String admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public String getMixTemperature() {
        return mixTemperature;
    }

    public void setMixTemperature(String mixTemperature) {
        this.mixTemperature = mixTemperature;
    }

    public String getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(String airTemperature) {
        this.airTemperature = airTemperature;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getAirContent() {
        return airContent;
    }

    public void setAirContent(String airContent) {
        this.airContent = airContent;
    }

    public String getCastBy() {
        return castBy;
    }

    public void setCastBy(String castBy) {
        this.castBy = castBy;
    }

    public String getTimeCast() {
        return timeCast;
    }

    public void setTimeCast(String timeCast) {
        this.timeCast = timeCast;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getDay28StrSpec() {
        return day28StrSpec;
    }

    public void setDay28StrSpec(String day28StrSpec) {
        this.day28StrSpec = day28StrSpec;
    }

    public String getSlumpSpec() {
        return slumpSpec;
    }

    public void setSlumpSpec(String slumpSpec) {
        this.slumpSpec = slumpSpec;
    }

    public String getAirPctgContentSpec() {
        return airPctgContentSpec;
    }

    public void setAirPctgContentSpec(String airPctgContentSpec) {
        this.airPctgContentSpec = airPctgContentSpec;
    }

    public String getConcClass() {
        return concClass;
    }

    public void setConcClass(String concClass) {
        this.concClass = concClass;
    }

    public String getPlacementStrength() {
        return placementStrength;
    }

    public void setPlacementStrength(String placementStrength) {
        this.placementStrength = placementStrength;
    }

    public String getAccumNo() {
        return accumNo;
    }

    public void setAccumNo(String accumNo) {
        this.accumNo = accumNo;
    }

    public String getTotalYd3() {
        return totalYd3;
    }

    public void setTotalYd3(String totalYd3) {
        this.totalYd3 = totalYd3;
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

    public String getLoadno() {
        return loadno;
    }

    public void setLoadno(String loadno) {
        this.loadno = loadno;
    }

    public String getSuperplasticizer() {
        return superplasticizer;
    }

    public void setSuperplasticizer(String superplasticizer) {
        this.superplasticizer = superplasticizer;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public String getBatchweight() {
        return batchweight;
    }

    public void setBatchweight(String batchweight) {
        this.batchweight = batchweight;
    }

    public String getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(String waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public String getTempSpec() {
        return tempSpec;
    }

    public void setTempSpec(String tempSpec) {
        this.tempSpec = tempSpec;
    }

    public String getMaxWaterCementRatio() {
        return maxWaterCementRatio;
    }

    public void setMaxWaterCementRatio(String maxWaterCementRatio) {
        this.maxWaterCementRatio = maxWaterCementRatio;
    }

    public String getPumpNo() {
        return pumpNo;
    }

    public void setPumpNo(String pumpNo) {
        this.pumpNo = pumpNo;
    }

    public String getClientMixDesign() {
        return clientMixDesign;
    }

    public void setClientMixDesign(String clientMixDesign) {
        this.clientMixDesign = clientMixDesign;
    }

    public String getDay28FlexStrSpec() {
        return day28FlexStrSpec;
    }

    public void setDay28FlexStrSpec(String day28FlexStrSpec) {
        this.day28FlexStrSpec = day28FlexStrSpec;
    }

    public String getDay56StrSpec() {
        return day56StrSpec;
    }

    public void setDay56StrSpec(String day56StrSpec) {
        this.day56StrSpec = day56StrSpec;
    }

    public BigInteger getLifting() {
        return lifting;
    }

    public void setLifting(BigInteger lifting) {
        this.lifting = lifting;
    }

    public BigInteger getBoiledabsorption28day() {
        return boiledabsorption28day;
    }

    public void setBoiledabsorption28day(BigInteger boiledabsorption28day) {
        this.boiledabsorption28day = boiledabsorption28day;
    }

    public BigInteger getTensilestr28day() {
        return tensilestr28day;
    }

    public void setTensilestr28day(BigInteger tensilestr28day) {
        this.tensilestr28day = tensilestr28day;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getFieldWaterCementRatio() {
        return fieldWaterCementRatio;
    }

    public void setFieldWaterCementRatio(String fieldWaterCementRatio) {
        this.fieldWaterCementRatio = fieldWaterCementRatio;
    }

    public String getSlump2() {
        return slump2;
    }

    public void setSlump2(String slump2) {
        this.slump2 = slump2;
    }

    public String getAirContent2() {
        return airContent2;
    }

    public void setAirContent2(String airContent2) {
        this.airContent2 = airContent2;
    }

    public String getRevCount() {
        return revCount;
    }

    public void setRevCount(String revCount) {
        this.revCount = revCount;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAirMeterType() {
        return airMeterType;
    }

    public void setAirMeterType(String airMeterType) {
        this.airMeterType = airMeterType;
    }

    public String getThermometerNo() {
        return thermometerNo;
    }

    public void setThermometerNo(String thermometerNo) {
        this.thermometerNo = thermometerNo;
    }

    public String getSlumpConeNo() {
        return slumpConeNo;
    }

    public void setSlumpConeNo(String slumpConeNo) {
        this.slumpConeNo = slumpConeNo;
    }

    public String getAirMeterNo() {
        return airMeterNo;
    }

    public void setAirMeterNo(String airMeterNo) {
        this.airMeterNo = airMeterNo;
    }

    public String getAdmixtureType4() {
        return admixtureType4;
    }

    public void setAdmixtureType4(String admixtureType4) {
        this.admixtureType4 = admixtureType4;
    }

    public String getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(String admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public String getAdmixtureType5() {
        return admixtureType5;
    }

    public void setAdmixtureType5(String admixtureType5) {
        this.admixtureType5 = admixtureType5;
    }

    public String getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(String admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public String getAggSize() {
        return aggSize;
    }

    public void setAggSize(String aggSize) {
        this.aggSize = aggSize;
    }

    public String getAggCorrectionFactor() {
        return aggCorrectionFactor;
    }

    public void setAggCorrectionFactor(String aggCorrectionFactor) {
        this.aggCorrectionFactor = aggCorrectionFactor;
    }

    public String getCorrectedAirContent() {
        return correctedAirContent;
    }

    public void setCorrectedAirContent(String correctedAirContent) {
        this.correctedAirContent = correctedAirContent;
    }

    public String getDesignWater() {
        return designWater;
    }

    public void setDesignWater(String designWater) {
        this.designWater = designWater;
    }

    public String getPlacementAir() {
        return placementAir;
    }

    public void setPlacementAir(String placementAir) {
        this.placementAir = placementAir;
    }

    public String getPlacementSlump() {
        return placementSlump;
    }

    public void setPlacementSlump(String placementSlump) {
        this.placementSlump = placementSlump;
    }

    public String getPumpAirLoss() {
        return pumpAirLoss;
    }

    public void setPumpAirLoss(String pumpAirLoss) {
        this.pumpAirLoss = pumpAirLoss;
    }

    public String getPumpSlumpLoss() {
        return pumpSlumpLoss;
    }

    public void setPumpSlumpLoss(String pumpSlumpLoss) {
        this.pumpSlumpLoss = pumpSlumpLoss;
    }

    public String getCoarseAgg2() {
        return coarseAgg2;
    }

    public void setCoarseAgg2(String coarseAgg2) {
        this.coarseAgg2 = coarseAgg2;
    }

    public String getCoarseAggMoist2() {
        return coarseAggMoist2;
    }

    public void setCoarseAggMoist2(String coarseAggMoist2) {
        this.coarseAggMoist2 = coarseAggMoist2;
    }

    public String getRevCountFinal() {
        return revCountFinal;
    }

    public void setRevCountFinal(String revCountFinal) {
        this.revCountFinal = revCountFinal;
    }

    public String getCementCode() {
        return cementCode;
    }

    public void setCementCode(String cementCode) {
        this.cementCode = cementCode;
    }

    public String getCementType() {
        return cementType;
    }

    public void setCementType(String cementType) {
        this.cementType = cementType;
    }

    public String getCementSpecgrav() {
        return cementSpecgrav;
    }

    public void setCementSpecgrav(String cementSpecgrav) {
        this.cementSpecgrav = cementSpecgrav;
    }

    public String getFlyAshCode() {
        return flyAshCode;
    }

    public void setFlyAshCode(String flyAshCode) {
        this.flyAshCode = flyAshCode;
    }

    public String getFlyAshType() {
        return flyAshType;
    }

    public void setFlyAshType(String flyAshType) {
        this.flyAshType = flyAshType;
    }

    public String getFlyAshSpecgrav() {
        return flyAshSpecgrav;
    }

    public void setFlyAshSpecgrav(String flyAshSpecgrav) {
        this.flyAshSpecgrav = flyAshSpecgrav;
    }

    public String getFineAggCode() {
        return fineAggCode;
    }

    public void setFineAggCode(String fineAggCode) {
        this.fineAggCode = fineAggCode;
    }

    public String getFineAggType() {
        return fineAggType;
    }

    public void setFineAggType(String fineAggType) {
        this.fineAggType = fineAggType;
    }

    public String getFineAggSpecgrav() {
        return fineAggSpecgrav;
    }

    public void setFineAggSpecgrav(String fineAggSpecgrav) {
        this.fineAggSpecgrav = fineAggSpecgrav;
    }

    public String getMediumAggCode() {
        return mediumAggCode;
    }

    public void setMediumAggCode(String mediumAggCode) {
        this.mediumAggCode = mediumAggCode;
    }

    public String getMediumAggType() {
        return mediumAggType;
    }

    public void setMediumAggType(String mediumAggType) {
        this.mediumAggType = mediumAggType;
    }

    public String getMediumAggSpecgrav() {
        return mediumAggSpecgrav;
    }

    public void setMediumAggSpecgrav(String mediumAggSpecgrav) {
        this.mediumAggSpecgrav = mediumAggSpecgrav;
    }

    public String getCoarseAggCode() {
        return coarseAggCode;
    }

    public void setCoarseAggCode(String coarseAggCode) {
        this.coarseAggCode = coarseAggCode;
    }

    public String getCoarseAggType() {
        return coarseAggType;
    }

    public void setCoarseAggType(String coarseAggType) {
        this.coarseAggType = coarseAggType;
    }

    public String getCoarseAggSize() {
        return coarseAggSize;
    }

    public void setCoarseAggSize(String coarseAggSize) {
        this.coarseAggSize = coarseAggSize;
    }

    public String getCoarseAggSpecgrav() {
        return coarseAggSpecgrav;
    }

    public void setCoarseAggSpecgrav(String coarseAggSpecgrav) {
        this.coarseAggSpecgrav = coarseAggSpecgrav;
    }

    public String getCoarseAgg2Code() {
        return coarseAgg2Code;
    }

    public void setCoarseAgg2Code(String coarseAgg2Code) {
        this.coarseAgg2Code = coarseAgg2Code;
    }

    public String getCoarseAgg2Type() {
        return coarseAgg2Type;
    }

    public void setCoarseAgg2Type(String coarseAgg2Type) {
        this.coarseAgg2Type = coarseAgg2Type;
    }

    public String getCoarseAgg2Size() {
        return coarseAgg2Size;
    }

    public void setCoarseAgg2Size(String coarseAgg2Size) {
        this.coarseAgg2Size = coarseAgg2Size;
    }

    public String getCoarseAgg2Specgrav() {
        return coarseAgg2Specgrav;
    }

    public void setCoarseAgg2Specgrav(String coarseAgg2Specgrav) {
        this.coarseAgg2Specgrav = coarseAgg2Specgrav;
    }

    public String getEmptyTime() {
        return emptyTime;
    }

    public void setEmptyTime(String emptyTime) {
        this.emptyTime = emptyTime;
    }

    public String getAggType() {
        return aggType;
    }

    public void setAggType(String aggType) {
        this.aggType = aggType;
    }

    public String getTotalCementitious() {
        return totalCementitious;
    }

    public void setTotalCementitious(String totalCementitious) {
        this.totalCementitious = totalCementitious;
    }

    public String getVolumePaste() {
        return volumePaste;
    }

    public void setVolumePaste(String volumePaste) {
        this.volumePaste = volumePaste;
    }

    public String getVolumeConcrete() {
        return volumeConcrete;
    }

    public void setVolumeConcrete(String volumeConcrete) {
        this.volumeConcrete = volumeConcrete;
    }

    public String getVolumePastePct() {
        return volumePastePct;
    }

    public void setVolumePastePct(String volumePastePct) {
        this.volumePastePct = volumePastePct;
    }

    public String getCoarseAggSource() {
        return coarseAggSource;
    }

    public void setCoarseAggSource(String coarseAggSource) {
        this.coarseAggSource = coarseAggSource;
    }

    public String getCoarseAggLocation() {
        return coarseAggLocation;
    }

    public void setCoarseAggLocation(String coarseAggLocation) {
        this.coarseAggLocation = coarseAggLocation;
    }

    public String getFineAggSource() {
        return fineAggSource;
    }

    public void setFineAggSource(String fineAggSource) {
        this.fineAggSource = fineAggSource;
    }

    public String getFineAggLocation() {
        return fineAggLocation;
    }

    public void setFineAggLocation(String fineAggLocation) {
        this.fineAggLocation = fineAggLocation;
    }

    public String getCementSource() {
        return cementSource;
    }

    public void setCementSource(String cementSource) {
        this.cementSource = cementSource;
    }

    public String getCementLocation() {
        return cementLocation;
    }

    public void setCementLocation(String cementLocation) {
        this.cementLocation = cementLocation;
    }

    public String getFlyAshSource() {
        return flyAshSource;
    }

    public void setFlyAshSource(String flyAshSource) {
        this.flyAshSource = flyAshSource;
    }

    public String getFlyAshLocation() {
        return flyAshLocation;
    }

    public void setFlyAshLocation(String flyAshLocation) {
        this.flyAshLocation = flyAshLocation;
    }

    public String getSlag() {
        return slag;
    }

    public void setSlag(String slag) {
        this.slag = slag;
    }

    public String getSlagType() {
        return slagType;
    }

    public void setSlagType(String slagType) {
        this.slagType = slagType;
    }

    public String getSlagSpecgrav() {
        return slagSpecgrav;
    }

    public void setSlagSpecgrav(String slagSpecgrav) {
        this.slagSpecgrav = slagSpecgrav;
    }

    public String getSlagSource() {
        return slagSource;
    }

    public void setSlagSource(String slagSource) {
        this.slagSource = slagSource;
    }

    public String getSlagLocation() {
        return slagLocation;
    }

    public void setSlagLocation(String slagLocation) {
        this.slagLocation = slagLocation;
    }

    public String getSilicaFume() {
        return silicaFume;
    }

    public void setSilicaFume(String silicaFume) {
        this.silicaFume = silicaFume;
    }

    public String getSilicaFumeType() {
        return silicaFumeType;
    }

    public void setSilicaFumeType(String silicaFumeType) {
        this.silicaFumeType = silicaFumeType;
    }

    public String getSilicaFumeSpecgrav() {
        return silicaFumeSpecgrav;
    }

    public void setSilicaFumeSpecgrav(String silicaFumeSpecgrav) {
        this.silicaFumeSpecgrav = silicaFumeSpecgrav;
    }

    public String getSilicaFumeSource() {
        return silicaFumeSource;
    }

    public void setSilicaFumeSource(String silicaFumeSource) {
        this.silicaFumeSource = silicaFumeSource;
    }

    public String getSilicaFumeLocation() {
        return silicaFumeLocation;
    }

    public void setSilicaFumeLocation(String silicaFumeLocation) {
        this.silicaFumeLocation = silicaFumeLocation;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public String getWaterSpecgrav() {
        return waterSpecgrav;
    }

    public void setWaterSpecgrav(String waterSpecgrav) {
        this.waterSpecgrav = waterSpecgrav;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public String getWaterLocation() {
        return waterLocation;
    }

    public void setWaterLocation(String waterLocation) {
        this.waterLocation = waterLocation;
    }

    public String getAdmixtureSpecgrav1() {
        return admixtureSpecgrav1;
    }

    public void setAdmixtureSpecgrav1(String admixtureSpecgrav1) {
        this.admixtureSpecgrav1 = admixtureSpecgrav1;
    }

    public String getAdmixtureSource1() {
        return admixtureSource1;
    }

    public void setAdmixtureSource1(String admixtureSource1) {
        this.admixtureSource1 = admixtureSource1;
    }

    public String getAdmixtureProduct1() {
        return admixtureProduct1;
    }

    public void setAdmixtureProduct1(String admixtureProduct1) {
        this.admixtureProduct1 = admixtureProduct1;
    }

    public String getAdmixtureSpecgrav2() {
        return admixtureSpecgrav2;
    }

    public void setAdmixtureSpecgrav2(String admixtureSpecgrav2) {
        this.admixtureSpecgrav2 = admixtureSpecgrav2;
    }

    public String getAdmixtureSource2() {
        return admixtureSource2;
    }

    public void setAdmixtureSource2(String admixtureSource2) {
        this.admixtureSource2 = admixtureSource2;
    }

    public String getAdmixtureProduct2() {
        return admixtureProduct2;
    }

    public void setAdmixtureProduct2(String admixtureProduct2) {
        this.admixtureProduct2 = admixtureProduct2;
    }

    public String getAdmixtureSpecgrav3() {
        return admixtureSpecgrav3;
    }

    public void setAdmixtureSpecgrav3(String admixtureSpecgrav3) {
        this.admixtureSpecgrav3 = admixtureSpecgrav3;
    }

    public String getAdmixtureSource3() {
        return admixtureSource3;
    }

    public void setAdmixtureSource3(String admixtureSource3) {
        this.admixtureSource3 = admixtureSource3;
    }

    public String getAdmixtureProduct3() {
        return admixtureProduct3;
    }

    public void setAdmixtureProduct3(String admixtureProduct3) {
        this.admixtureProduct3 = admixtureProduct3;
    }

    public String getAdmixtureSpecgrav4() {
        return admixtureSpecgrav4;
    }

    public void setAdmixtureSpecgrav4(String admixtureSpecgrav4) {
        this.admixtureSpecgrav4 = admixtureSpecgrav4;
    }

    public String getAdmixtureSource4() {
        return admixtureSource4;
    }

    public void setAdmixtureSource4(String admixtureSource4) {
        this.admixtureSource4 = admixtureSource4;
    }

    public String getAdmixtureProduct4() {
        return admixtureProduct4;
    }

    public void setAdmixtureProduct4(String admixtureProduct4) {
        this.admixtureProduct4 = admixtureProduct4;
    }

    public String getAdmixtureSpecgrav5() {
        return admixtureSpecgrav5;
    }

    public void setAdmixtureSpecgrav5(String admixtureSpecgrav5) {
        this.admixtureSpecgrav5 = admixtureSpecgrav5;
    }

    public String getAdmixtureSource5() {
        return admixtureSource5;
    }

    public void setAdmixtureSource5(String admixtureSource5) {
        this.admixtureSource5 = admixtureSource5;
    }

    public String getAdmixtureProduct5() {
        return admixtureProduct5;
    }

    public void setAdmixtureProduct5(String admixtureProduct5) {
        this.admixtureProduct5 = admixtureProduct5;
    }

    public String getAdmixtureType6() {
        return admixtureType6;
    }

    public void setAdmixtureType6(String admixtureType6) {
        this.admixtureType6 = admixtureType6;
    }

    public String getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(String admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public String getAdmixtureSpecgrav6() {
        return admixtureSpecgrav6;
    }

    public void setAdmixtureSpecgrav6(String admixtureSpecgrav6) {
        this.admixtureSpecgrav6 = admixtureSpecgrav6;
    }

    public String getAdmixtureSource6() {
        return admixtureSource6;
    }

    public void setAdmixtureSource6(String admixtureSource6) {
        this.admixtureSource6 = admixtureSource6;
    }

    public String getAdmixtureProduct6() {
        return admixtureProduct6;
    }

    public void setAdmixtureProduct6(String admixtureProduct6) {
        this.admixtureProduct6 = admixtureProduct6;
    }

    public String getAdmixtureType7() {
        return admixtureType7;
    }

    public void setAdmixtureType7(String admixtureType7) {
        this.admixtureType7 = admixtureType7;
    }

    public String getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(String admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public String getAdmixtureSpecgrav7() {
        return admixtureSpecgrav7;
    }

    public void setAdmixtureSpecgrav7(String admixtureSpecgrav7) {
        this.admixtureSpecgrav7 = admixtureSpecgrav7;
    }

    public String getAdmixtureSource7() {
        return admixtureSource7;
    }

    public void setAdmixtureSource7(String admixtureSource7) {
        this.admixtureSource7 = admixtureSource7;
    }

    public String getAdmixtureProduct7() {
        return admixtureProduct7;
    }

    public void setAdmixtureProduct7(String admixtureProduct7) {
        this.admixtureProduct7 = admixtureProduct7;
    }

    public String getAdmixtureType8() {
        return admixtureType8;
    }

    public void setAdmixtureType8(String admixtureType8) {
        this.admixtureType8 = admixtureType8;
    }

    public String getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(String admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
    }

    public String getAdmixtureSpecgrav8() {
        return admixtureSpecgrav8;
    }

    public void setAdmixtureSpecgrav8(String admixtureSpecgrav8) {
        this.admixtureSpecgrav8 = admixtureSpecgrav8;
    }

    public String getAdmixtureSource8() {
        return admixtureSource8;
    }

    public void setAdmixtureSource8(String admixtureSource8) {
        this.admixtureSource8 = admixtureSource8;
    }

    public String getAdmixtureProduct8() {
        return admixtureProduct8;
    }

    public void setAdmixtureProduct8(String admixtureProduct8) {
        this.admixtureProduct8 = admixtureProduct8;
    }

    public String getFormTemperature() {
        return formTemperature;
    }

    public void setFormTemperature(String formTemperature) {
        this.formTemperature = formTemperature;
    }

    public String getAdditionalAdmixture() {
        return additionalAdmixture;
    }

    public void setAdditionalAdmixture(String additionalAdmixture) {
        this.additionalAdmixture = additionalAdmixture;
    }

    public String getSlumpTestMethod() {
        return slumpTestMethod;
    }

    public void setSlumpTestMethod(String slumpTestMethod) {
        this.slumpTestMethod = slumpTestMethod;
    }

    public String getAirContentTestMethod() {
        return airContentTestMethod;
    }

    public void setAirContentTestMethod(String airContentTestMethod) {
        this.airContentTestMethod = airContentTestMethod;
    }

    public String getTempTestMethod() {
        return tempTestMethod;
    }

    public void setTempTestMethod(String tempTestMethod) {
        this.tempTestMethod = tempTestMethod;
    }

    public String getUnitWeightSpec() {
        return unitWeightSpec;
    }

    public void setUnitWeightSpec(String unitWeightSpec) {
        this.unitWeightSpec = unitWeightSpec;
    }

    public String getUnitWeightTestMethod() {
        return unitWeightTestMethod;
    }

    public void setUnitWeightTestMethod(String unitWeightTestMethod) {
        this.unitWeightTestMethod = unitWeightTestMethod;
    }

    public String getScaleNo() {
        return scaleNo;
    }

    public void setScaleNo(String scaleNo) {
        this.scaleNo = scaleNo;
    }

    public String getSuperAirMeter() {
        return superAirMeter;
    }

    public void setSuperAirMeter(String superAirMeter) {
        this.superAirMeter = superAirMeter;
    }

    public String getSuperAirMeterSpec() {
        return superAirMeterSpec;
    }

    public void setSuperAirMeterSpec(String superAirMeterSpec) {
        this.superAirMeterSpec = superAirMeterSpec;
    }

    public String getSuperAirMeterTestMethod() {
        return superAirMeterTestMethod;
    }

    public void setSuperAirMeterTestMethod(String superAirMeterTestMethod) {
        this.superAirMeterTestMethod = superAirMeterTestMethod;
    }

    public String getSuperAirMeterNo() {
        return superAirMeterNo;
    }

    public void setSuperAirMeterNo(String superAirMeterNo) {
        this.superAirMeterNo = superAirMeterNo;
    }

    public String getFineAggSize() {
        return fineAggSize;
    }

    public void setFineAggSize(String fineAggSize) {
        this.fineAggSize = fineAggSize;
    }

    public String getSpecimenShape() {
        return specimenShape;
    }

    public void setSpecimenShape(String specimenShape) {
        this.specimenShape = specimenShape;
    }

    public String getSpecimenCovered() {
        return specimenCovered;
    }

    public void setSpecimenCovered(String specimenCovered) {
        this.specimenCovered = specimenCovered;
    }

    public String getCuringMethod() {
        return curingMethod;
    }

    public void setCuringMethod(String curingMethod) {
        this.curingMethod = curingMethod;
    }

    public String getCuringMintemp() {
        return curingMintemp;
    }

    public void setCuringMintemp(String curingMintemp) {
        this.curingMintemp = curingMintemp;
    }

    public String getCuringMaxtemp() {
        return curingMaxtemp;
    }

    public void setCuringMaxtemp(String curingMaxtemp) {
        this.curingMaxtemp = curingMaxtemp;
    }

    public String getLabprepOther() {
        return labprepOther;
    }

    public void setLabprepOther(String labprepOther) {
        this.labprepOther = labprepOther;
    }

    public String getLabprepComments() {
        return labprepComments;
    }

    public void setLabprepComments(String labprepComments) {
        this.labprepComments = labprepComments;
    }

    public String getFlowAfterMix() {
        return flowAfterMix;
    }

    public void setFlowAfterMix(String flowAfterMix) {
        this.flowAfterMix = flowAfterMix;
    }

    public String getFlowAfter30min() {
        return flowAfter30min;
    }

    public void setFlowAfter30min(String flowAfter30min) {
        this.flowAfter30min = flowAfter30min;
    }

    public String getWetDensity() {
        return wetDensity;
    }

    public void setWetDensity(String wetDensity) {
        this.wetDensity = wetDensity;
    }

    public String getFlowAfterMixSpec() {
        return flowAfterMixSpec;
    }

    public void setFlowAfterMixSpec(String flowAfterMixSpec) {
        this.flowAfterMixSpec = flowAfterMixSpec;
    }

    public String getFlowAfter30minSpec() {
        return flowAfter30minSpec;
    }

    public void setFlowAfter30minSpec(String flowAfter30minSpec) {
        this.flowAfter30minSpec = flowAfter30minSpec;
    }

    public String getWetDensitySpec() {
        return wetDensitySpec;
    }

    public void setWetDensitySpec(String wetDensitySpec) {
        this.wetDensitySpec = wetDensitySpec;
    }

    public String getDay7StrSpec() {
        return day7StrSpec;
    }

    public void setDay7StrSpec(String day7StrSpec) {
        this.day7StrSpec = day7StrSpec;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(String totalWater) {
        this.totalWater = totalWater;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCuringBoxOnSiteCondition() {
        return curingBoxOnSiteCondition;
    }

    public void setCuringBoxOnSiteCondition(String curingBoxOnSiteCondition) {
        this.curingBoxOnSiteCondition = curingBoxOnSiteCondition;
    }

    public String getSubContractor() {
        return subContractor;
    }

    public void setSubContractor(String subContractor) {
        this.subContractor = subContractor;
    }

    public String getSubContractorName() {
        return subContractorName;
    }

    public void setSubContractorName(String subContractorName) {
        this.subContractorName = subContractorName;
    }

    public Character getMixDesignOnSite() {
        return mixDesignOnSite;
    }

    public void setMixDesignOnSite(Character mixDesignOnSite) {
        this.mixDesignOnSite = mixDesignOnSite;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sampleId != null ? sampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaSampleConcInfo)) {
            return false;
        }
        QaSampleConcInfo other = (QaSampleConcInfo) object;
        if ((this.sampleId == null && other.sampleId != null) || (this.sampleId != null && !this.sampleId.equals(other.sampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleConcInfo[ sampleId=" + sampleId + " ]";
    }
    
}
