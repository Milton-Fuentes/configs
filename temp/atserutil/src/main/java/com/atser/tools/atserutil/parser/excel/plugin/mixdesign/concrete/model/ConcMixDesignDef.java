/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.SectionConcMixDesign;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.nysdot.SectionNysDOTImportConcMixDesign;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author droldan
 */
public class ConcMixDesignDef implements Serializable {

    @Expose
    private String mixdesignNo;
    @Expose
    private String producedBy;
    @Expose
    private String plantLocation;
    @Expose
    private String mixdesignType;
    @Expose
    private String mixStatus;
    @Expose
    private Date expirationDate;
    @Expose
    private String maxAggSize;
    @Expose
    private Double designCompstr;
    @Expose
    private Integer designCompstrAge;
    @Expose
    private String designCompstrAgeUnit;
    @Expose
    private Double designSlump;
    @Expose
    private Double designSlumpFlowScc;
    @Expose
    private Double designAirContent;
    @Expose
    private Double totalCoarseAgg;
    @Expose
    private Double totalFineAgg;
    @Expose
    private Double cement;
    @Expose
    private Double flyAsh;
    @Expose
    private Double slag;
    @Expose
    private Double silicaFume;
    @Expose
    private Double totalCementMat;
    @Expose
    private Double water;
    @Expose
    private Double admixtureQty1;
    private String admixtureType1;
    @Expose
    private Double admixtureQty2;
    private String admixtureType2;
    @Expose
    private Double admixtureQty3;
    private String admixtureType3;
    @Expose
    private Double admixtureQty4;
    private String admixtureType4;
    @Expose
    private Double admixtureQty5;
    private String admixtureType5;
    @Expose
    private Double admixtureQty6;
    private String admixtureType6;
    @Expose
    private Double admixtureQty7;
    private String admixtureType7;
    @Expose
    private Double admixtureQty8;
    private String admixtureType8;
    @Expose
    private Double waterCementRatio;
    private Double waterCementMax;
    @Expose
    private Double theoreticalAirContent;
    @Expose
    private Double volumenPaste;
    @Expose
    private Double specLimitSlumpMin;
    @Expose
    private Double specLimitSlumpMax;
    @Expose
    private Double engLimitSlumpMin;
    @Expose
    private Double engLimitSlumpMax;
    @Expose
    private Double specLimitAirContentMin;
    @Expose
    private Double specLimitAirContentMax;
    @Expose
    private Double engLimitAirContentMin;
    @Expose
    private Double engLimitAirContentMax;
    @Expose
    private Double specLimitCompstrMin;
    @Expose
    private Double specLimitCompstrMax;
    @Expose
    private Double engLimitCompstrMin;
    @Expose
    private Double engLimitCompstrMax;
    @Expose
    private Double specLimitSlumpFlowsccMin;
    @Expose
    private Double specLimitSlumpFlowsccMax;
    @Expose
    private Double engLimitSlumpFlowsccMin;
    @Expose
    private Double engLimitSlumpFlowsccMax;
    @Expose
    private Double trialOverdesignCompstrMin;
    @Expose
    private Double trialOverdesignCompstrMax;
    @Expose
    private Double designTensileStr;
    @Expose
    private Integer designTensileStrAge;
    @Expose
    private String designTensileStrAgeUnit;
    @Expose
    private Double designFlexStr;
    @Expose
    private Integer designFlexStrAge;
    @Expose
    private String designFlexStrAgeUnit;
    @Expose
    private Double specLimitTensileStrMin;
    @Expose
    private Double specLimitTensileStrMax;
    @Expose
    private Double engLimitTensileStrMin;
    @Expose
    private Double engLimitTensileStrMax;
    @Expose
    private Double specLimitFlexStrMin;
    @Expose
    private Double specLimitFlexStrMax;
    @Expose
    private Double engLimitFlexStrMin;
    @Expose
    private Double engLimitFlexStrMax;
    private String concreteClass;
    private Double specSlumpSuspension;
    private Double specSlumpAction;
    private Double specAircontentSuspension;
    private Double specAircontentAction;
    private Double reqtk;
    private Double specFlexSuspension;
    private Double specFlexAction;
    private Double specTkSuspension;
    private Double specTkAction;
    private Integer specConcTempMin;
    private Integer specConcTempMax;
    private Double specResidualStr1;
    private Double specResidualStr2;
    private Double specResidualStr3;
    private Double specResidualStrPeak;
    private Double boiledabsorption;
    private Date approvedDate;
    @Expose
    private String status;

    public ConcMixDesignDef() {
        this.status = "PENDING";
    }

    public ConcMixDesignDef(final SectionConcMixDesign elem) {
        this.mixdesignNo = elem.getMixdesignNo();
        this.producedBy = elem.getProducedBy();
        this.plantLocation = elem.getPlantLocation();
        this.mixdesignType = elem.getMixdesignType();
        this.mixStatus = elem.getMixStatus();
        this.expirationDate = elem.getExpirationDate();
        this.maxAggSize = elem.getMaxAggSize();
        this.designCompstr = elem.getDesignCompstr();
        this.designCompstrAge = elem.getDesignCompstrAge();
        this.designCompstrAgeUnit = elem.getDesignCompstrAgeUnit();
        this.designSlump = elem.getDesignSlump();
        this.designSlumpFlowScc = elem.getDesignSlumpFlowScc();
        this.designAirContent = elem.getDesignAirContent();
        this.totalCoarseAgg = elem.getTotalCoarseAgg();
        this.totalFineAgg = elem.getTotalFineAgg();
        this.cement = elem.getCement();
        this.flyAsh = elem.getFlyAsh();
        this.slag = elem.getSlag();
        this.silicaFume = elem.getSilicaFume();
        this.totalCementMat = elem.getTotalCementMat();
        this.water = elem.getWater();
        this.admixtureQty1 = elem.getAdmixtureQty1();
        this.admixtureQty2 = elem.getAdmixtureQty2();
        this.admixtureQty3 = elem.getAdmixtureQty3();
        this.admixtureQty4 = elem.getAdmixtureQty4();
        this.admixtureQty5 = elem.getAdmixtureQty5();
        this.admixtureQty6 = elem.getAdmixtureQty6();
        this.admixtureQty7 = elem.getAdmixtureQty7();
        this.admixtureQty8 = elem.getAdmixtureQty8();
        this.waterCementRatio = elem.getWaterCementRatio();
        this.theoreticalAirContent = elem.getTheoreticalAirContent();
        this.volumenPaste = elem.getVolumenPaste();
        this.specLimitSlumpMin = elem.getSpecLimitSlumpMin();
        this.specLimitSlumpMax = elem.getSpecLimitSlumpMax();
        this.engLimitSlumpMin = elem.getEngLimitSlumpMin();
        this.engLimitSlumpMax = elem.getEngLimitSlumpMax();
        this.specLimitAirContentMin = elem.getSpecLimitAirContentMin();
        this.specLimitAirContentMax = elem.getSpecLimitAirContentMax();
        this.engLimitAirContentMin = elem.getEngLimitAirContentMin();
        this.engLimitAirContentMax = elem.getEngLimitAirContentMax();
        this.specLimitCompstrMin = elem.getSpecLimitCompstrMin();
        this.specLimitCompstrMax = elem.getSpecLimitCompstrMax();
        this.engLimitCompstrMin = elem.getEngLimitCompstrMin();
        this.engLimitCompstrMax = elem.getEngLimitCompstrMax();
        this.specLimitSlumpFlowsccMin = elem.getSpecLimitSlumpFlowsccMin();
        this.specLimitSlumpFlowsccMax = elem.getSpecLimitSlumpFlowsccMax();
        this.engLimitSlumpFlowsccMin = elem.getEngLimitSlumpFlowsccMin();
        this.engLimitSlumpFlowsccMax = elem.getEngLimitSlumpFlowsccMax();
        this.trialOverdesignCompstrMin = elem.getTrialOverdesignCompstrMin();
        this.trialOverdesignCompstrMax = elem.getTrialOverdesignCompstrMax();
        this.designTensileStr = elem.getDesignTensileStr();
        this.designTensileStrAge = elem.getDesignTensileStrAge();
        this.designTensileStrAgeUnit = elem.getDesignTensileStrAgeUnit();
        this.designFlexStr = elem.getDesignFlexStr();
        this.designFlexStrAge = elem.getDesignFlexStrAge();
        this.designFlexStrAgeUnit = elem.getDesignFlexStrAgeUnit();
        this.specLimitTensileStrMin = elem.getSpecLimitTensileStrMin();
        this.specLimitTensileStrMax = elem.getSpecLimitTensileStrMax();
        this.engLimitTensileStrMin = elem.getEngLimitTensileStrMin();
        this.engLimitTensileStrMax = elem.getEngLimitTensileStrMax();
        this.specLimitFlexStrMin = elem.getSpecLimitFlexStrMin();
        this.specLimitFlexStrMax = elem.getSpecLimitFlexStrMax();
        this.engLimitFlexStrMin = elem.getEngLimitFlexStrMin();
        this.engLimitFlexStrMax = elem.getEngLimitFlexStrMax();
        this.status = "PENDING";
    }

    public ConcMixDesignDef(final SectionNysDOTImportConcMixDesign elem) {
        this.mixdesignNo = elem.getMix_id();
        this.mixdesignType = elem.getMatl_cd();
        this.concreteClass = elem.getConc_clas_t();
        this.producedBy = elem.getProdr_supp_cd();
        try {
            if (StringSupport.isNotNullAndNotEmpty(elem.getTerm_dt()) && !elem.getTerm_dt().equals("0")) {
                this.expirationDate = DateSupport.parseString(elem.getTerm_dt(), DateSupport.factorySimpleDateFormat("yyyyMMdd"));
            } else {
                this.expirationDate = null;
            }
        } catch (ParseException ex) {
            this.expirationDate = null;
        }
        this.specLimitCompstrMin = NumberSupport.getDouble(elem.getMin_avg_strgh_rqrd());
        this.designCompstr = NumberSupport.getDouble(elem.getDsn_strgh_spc());
        this.waterCementRatio = NumberSupport.getDouble(elem.getH2o_cem_ratio());
        this.theoreticalAirContent = NumberSupport.getDouble(elem.getAir_cntnt_m());
        this.designSlump = NumberSupport.getDouble(elem.getSlmp_m());
        this.mixStatus = "approvedmix";
        this.status = "PENDING";
    }

    public String getMixdesignNo() {
        return mixdesignNo;
    }

    public void setMixdesignNo(String mixdesignNo) {
        this.mixdesignNo = mixdesignNo;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getPlantLocation() {
        return plantLocation;
    }

    public void setPlantLocation(String plantLocation) {
        this.plantLocation = plantLocation;
    }

    public String getMixdesignType() {
        return mixdesignType;
    }

    public void setMixdesignType(String mixdesignType) {
        this.mixdesignType = mixdesignType;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMaxAggSize() {
        return maxAggSize;
    }

    public void setMaxAggSize(String maxAggSize) {
        this.maxAggSize = maxAggSize;
    }

    public Double getDesignCompstr() {
        return designCompstr;
    }

    public void setDesignCompstr(Double designCompstr) {
        this.designCompstr = designCompstr;
    }

    public Integer getDesignCompstrAge() {
        return designCompstrAge;
    }

    public void setDesignCompstrAge(Integer designCompstrAge) {
        this.designCompstrAge = designCompstrAge;
    }

    public String getDesignCompstrAgeUnit() {
        return designCompstrAgeUnit;
    }

    public void setDesignCompstrAgeUnit(String designCompstrAgeUnit) {
        this.designCompstrAgeUnit = designCompstrAgeUnit;
    }

    public Double getDesignSlump() {
        return designSlump;
    }

    public void setDesignSlump(Double designSlump) {
        this.designSlump = designSlump;
    }

    public Double getDesignSlumpFlowScc() {
        return designSlumpFlowScc;
    }

    public void setDesignSlumpFlowScc(Double designSlumpFlowScc) {
        this.designSlumpFlowScc = designSlumpFlowScc;
    }

    public Double getDesignAirContent() {
        return designAirContent;
    }

    public void setDesignAirContent(Double designAirContent) {
        this.designAirContent = designAirContent;
    }

    public Double getTotalCoarseAgg() {
        return totalCoarseAgg;
    }

    public void setTotalCoarseAgg(Double totalCoarseAgg) {
        this.totalCoarseAgg = totalCoarseAgg;
    }

    public Double getTotalFineAgg() {
        return totalFineAgg;
    }

    public void setTotalFineAgg(Double totalFineAgg) {
        this.totalFineAgg = totalFineAgg;
    }

    public Double getCement() {
        return cement;
    }

    public void setCement(Double cement) {
        this.cement = cement;
    }

    public Double getFlyAsh() {
        return flyAsh;
    }

    public void setFlyAsh(Double flyAsh) {
        this.flyAsh = flyAsh;
    }

    public Double getSlag() {
        return slag;
    }

    public void setSlag(Double slag) {
        this.slag = slag;
    }

    public Double getSilicaFume() {
        return silicaFume;
    }

    public void setSilicaFume(Double silicaFume) {
        this.silicaFume = silicaFume;
    }

    public Double getTotalCementMat() {
        return totalCementMat;
    }

    public void setTotalCementMat(Double totalCementMat) {
        this.totalCementMat = totalCementMat;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getAdmixtureQty1() {
        return admixtureQty1;
    }

    public void setAdmixtureQty1(Double admixtureQty1) {
        this.admixtureQty1 = admixtureQty1;
    }

    public String getAdmixtureType1() {
        return admixtureType1;
    }

    public void setAdmixtureType1(String admixtureType1) {
        this.admixtureType1 = admixtureType1;
    }

    public Double getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(Double admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public String getAdmixtureType2() {
        return admixtureType2;
    }

    public void setAdmixtureType2(String admixtureType2) {
        this.admixtureType2 = admixtureType2;
    }

    public Double getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(Double admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public String getAdmixtureType3() {
        return admixtureType3;
    }

    public void setAdmixtureType3(String admixtureType3) {
        this.admixtureType3 = admixtureType3;
    }

    public Double getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(Double admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public String getAdmixtureType4() {
        return admixtureType4;
    }

    public void setAdmixtureType4(String admixtureType4) {
        this.admixtureType4 = admixtureType4;
    }

    public Double getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(Double admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public String getAdmixtureType5() {
        return admixtureType5;
    }

    public void setAdmixtureType5(String admixtureType5) {
        this.admixtureType5 = admixtureType5;
    }

    public Double getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(Double admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public String getAdmixtureType6() {
        return admixtureType6;
    }

    public void setAdmixtureType6(String admixtureType6) {
        this.admixtureType6 = admixtureType6;
    }

    public Double getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(Double admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public String getAdmixtureType7() {
        return admixtureType7;
    }

    public void setAdmixtureType7(String admixtureType7) {
        this.admixtureType7 = admixtureType7;
    }

    public Double getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(Double admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
    }

    public String getAdmixtureType8() {
        return admixtureType8;
    }

    public void setAdmixtureType8(String admixtureType8) {
        this.admixtureType8 = admixtureType8;
    }

    public Double getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(Double waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public Double getWaterCementMax() {
        return waterCementMax;
    }

    public void setWaterCementMax(Double waterCementMax) {
        this.waterCementMax = waterCementMax;
    }

    public Double getTheoreticalAirContent() {
        return theoreticalAirContent;
    }

    public void setTheoreticalAirContent(Double theoreticalAirContent) {
        this.theoreticalAirContent = theoreticalAirContent;
    }

    public Double getVolumenPaste() {
        return volumenPaste;
    }

    public void setVolumenPaste(Double volumenPaste) {
        this.volumenPaste = volumenPaste;
    }

    public Double getSpecLimitSlumpMin() {
        return specLimitSlumpMin;
    }

    public void setSpecLimitSlumpMin(Double specLimitSlumpMin) {
        this.specLimitSlumpMin = specLimitSlumpMin;
    }

    public Double getSpecLimitSlumpMax() {
        return specLimitSlumpMax;
    }

    public void setSpecLimitSlumpMax(Double specLimitSlumpMax) {
        this.specLimitSlumpMax = specLimitSlumpMax;
    }

    public Double getEngLimitSlumpMin() {
        return engLimitSlumpMin;
    }

    public void setEngLimitSlumpMin(Double engLimitSlumpMin) {
        this.engLimitSlumpMin = engLimitSlumpMin;
    }

    public Double getEngLimitSlumpMax() {
        return engLimitSlumpMax;
    }

    public void setEngLimitSlumpMax(Double engLimitSlumpMax) {
        this.engLimitSlumpMax = engLimitSlumpMax;
    }

    public Double getSpecLimitAirContentMin() {
        return specLimitAirContentMin;
    }

    public void setSpecLimitAirContentMin(Double specLimitAirContentMin) {
        this.specLimitAirContentMin = specLimitAirContentMin;
    }

    public Double getSpecLimitAirContentMax() {
        return specLimitAirContentMax;
    }

    public void setSpecLimitAirContentMax(Double specLimitAirContentMax) {
        this.specLimitAirContentMax = specLimitAirContentMax;
    }

    public Double getEngLimitAirContentMin() {
        return engLimitAirContentMin;
    }

    public void setEngLimitAirContentMin(Double engLimitAirContentMin) {
        this.engLimitAirContentMin = engLimitAirContentMin;
    }

    public Double getEngLimitAirContentMax() {
        return engLimitAirContentMax;
    }

    public void setEngLimitAirContentMax(Double engLimitAirContentMax) {
        this.engLimitAirContentMax = engLimitAirContentMax;
    }

    public Double getSpecLimitCompstrMin() {
        return specLimitCompstrMin;
    }

    public void setSpecLimitCompstrMin(Double specLimitCompstrMin) {
        this.specLimitCompstrMin = specLimitCompstrMin;
    }

    public Double getSpecLimitCompstrMax() {
        return specLimitCompstrMax;
    }

    public void setSpecLimitCompstrMax(Double specLimitCompstrMax) {
        this.specLimitCompstrMax = specLimitCompstrMax;
    }

    public Double getEngLimitCompstrMin() {
        return engLimitCompstrMin;
    }

    public void setEngLimitCompstrMin(Double engLimitCompstrMin) {
        this.engLimitCompstrMin = engLimitCompstrMin;
    }

    public Double getEngLimitCompstrMax() {
        return engLimitCompstrMax;
    }

    public void setEngLimitCompstrMax(Double engLimitCompstrMax) {
        this.engLimitCompstrMax = engLimitCompstrMax;
    }

    public Double getSpecLimitSlumpFlowsccMin() {
        return specLimitSlumpFlowsccMin;
    }

    public void setSpecLimitSlumpFlowsccMin(Double specLimitSlumpFlowsccMin) {
        this.specLimitSlumpFlowsccMin = specLimitSlumpFlowsccMin;
    }

    public Double getSpecLimitSlumpFlowsccMax() {
        return specLimitSlumpFlowsccMax;
    }

    public void setSpecLimitSlumpFlowsccMax(Double specLimitSlumpFlowsccMax) {
        this.specLimitSlumpFlowsccMax = specLimitSlumpFlowsccMax;
    }

    public Double getEngLimitSlumpFlowsccMin() {
        return engLimitSlumpFlowsccMin;
    }

    public void setEngLimitSlumpFlowsccMin(Double engLimitSlumpFlowsccMin) {
        this.engLimitSlumpFlowsccMin = engLimitSlumpFlowsccMin;
    }

    public Double getEngLimitSlumpFlowsccMax() {
        return engLimitSlumpFlowsccMax;
    }

    public void setEngLimitSlumpFlowsccMax(Double engLimitSlumpFlowsccMax) {
        this.engLimitSlumpFlowsccMax = engLimitSlumpFlowsccMax;
    }

    public Double getTrialOverdesignCompstrMin() {
        return trialOverdesignCompstrMin;
    }

    public void setTrialOverdesignCompstrMin(Double trialOverdesignCompstrMin) {
        this.trialOverdesignCompstrMin = trialOverdesignCompstrMin;
    }

    public Double getTrialOverdesignCompstrMax() {
        return trialOverdesignCompstrMax;
    }

    public void setTrialOverdesignCompstrMax(Double trialOverdesignCompstrMax) {
        this.trialOverdesignCompstrMax = trialOverdesignCompstrMax;
    }

    public Double getDesignTensileStr() {
        return designTensileStr;
    }

    public void setDesignTensileStr(Double designTensileStr) {
        this.designTensileStr = designTensileStr;
    }

    public Integer getDesignTensileStrAge() {
        return designTensileStrAge;
    }

    public void setDesignTensileStrAge(Integer designTensileStrAge) {
        this.designTensileStrAge = designTensileStrAge;
    }

    public String getDesignTensileStrAgeUnit() {
        return designTensileStrAgeUnit;
    }

    public void setDesignTensileStrAgeUnit(String designTensileStrAgeUnit) {
        this.designTensileStrAgeUnit = designTensileStrAgeUnit;
    }

    public Double getDesignFlexStr() {
        return designFlexStr;
    }

    public void setDesignFlexStr(Double designFlexStr) {
        this.designFlexStr = designFlexStr;
    }

    public Integer getDesignFlexStrAge() {
        return designFlexStrAge;
    }

    public void setDesignFlexStrAge(Integer designFlexStrAge) {
        this.designFlexStrAge = designFlexStrAge;
    }

    public String getDesignFlexStrAgeUnit() {
        return designFlexStrAgeUnit;
    }

    public void setDesignFlexStrAgeUnit(String designFlexStrAgeUnit) {
        this.designFlexStrAgeUnit = designFlexStrAgeUnit;
    }

    public Double getSpecLimitTensileStrMin() {
        return specLimitTensileStrMin;
    }

    public void setSpecLimitTensileStrMin(Double specLimitTensileStrMin) {
        this.specLimitTensileStrMin = specLimitTensileStrMin;
    }

    public Double getSpecLimitTensileStrMax() {
        return specLimitTensileStrMax;
    }

    public void setSpecLimitTensileStrMax(Double specLimitTensileStrMax) {
        this.specLimitTensileStrMax = specLimitTensileStrMax;
    }

    public Double getEngLimitTensileStrMin() {
        return engLimitTensileStrMin;
    }

    public void setEngLimitTensileStrMin(Double engLimitTensileStrMin) {
        this.engLimitTensileStrMin = engLimitTensileStrMin;
    }

    public Double getEngLimitTensileStrMax() {
        return engLimitTensileStrMax;
    }

    public void setEngLimitTensileStrMax(Double engLimitTensileStrMax) {
        this.engLimitTensileStrMax = engLimitTensileStrMax;
    }

    public Double getSpecLimitFlexStrMin() {
        return specLimitFlexStrMin;
    }

    public void setSpecLimitFlexStrMin(Double specLimitFlexStrMin) {
        this.specLimitFlexStrMin = specLimitFlexStrMin;
    }

    public Double getSpecLimitFlexStrMax() {
        return specLimitFlexStrMax;
    }

    public void setSpecLimitFlexStrMax(Double specLimitFlexStrMax) {
        this.specLimitFlexStrMax = specLimitFlexStrMax;
    }

    public Double getEngLimitFlexStrMin() {
        return engLimitFlexStrMin;
    }

    public void setEngLimitFlexStrMin(Double engLimitFlexStrMin) {
        this.engLimitFlexStrMin = engLimitFlexStrMin;
    }

    public Double getEngLimitFlexStrMax() {
        return engLimitFlexStrMax;
    }

    public void setEngLimitFlexStrMax(Double engLimitFlexStrMax) {
        this.engLimitFlexStrMax = engLimitFlexStrMax;
    }

    public String getConcreteClass() {
        return concreteClass;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
    }

    public Double getSpecSlumpSuspension() {
        return specSlumpSuspension;
    }

    public void setSpecSlumpSuspension(Double specSlumpSuspension) {
        this.specSlumpSuspension = specSlumpSuspension;
    }

    public Double getSpecSlumpAction() {
        return specSlumpAction;
    }

    public void setSpecSlumpAction(Double specSlumpAction) {
        this.specSlumpAction = specSlumpAction;
    }

    public Double getSpecAircontentSuspension() {
        return specAircontentSuspension;
    }

    public void setSpecAircontentSuspension(Double specAircontentSuspension) {
        this.specAircontentSuspension = specAircontentSuspension;
    }

    public Double getSpecAircontentAction() {
        return specAircontentAction;
    }

    public void setSpecAircontentAction(Double specAircontentAction) {
        this.specAircontentAction = specAircontentAction;
    }

    public Double getReqtk() {
        return reqtk;
    }

    public void setReqtk(Double reqtk) {
        this.reqtk = reqtk;
    }

    public Double getSpecFlexSuspension() {
        return specFlexSuspension;
    }

    public void setSpecFlexSuspension(Double specFlexSuspension) {
        this.specFlexSuspension = specFlexSuspension;
    }

    public Double getSpecFlexAction() {
        return specFlexAction;
    }

    public void setSpecFlexAction(Double specFlexAction) {
        this.specFlexAction = specFlexAction;
    }

    public Double getSpecTkSuspension() {
        return specTkSuspension;
    }

    public void setSpecTkSuspension(Double specTkSuspension) {
        this.specTkSuspension = specTkSuspension;
    }

    public Double getSpecTkAction() {
        return specTkAction;
    }

    public void setSpecTkAction(Double specTkAction) {
        this.specTkAction = specTkAction;
    }

    public Integer getSpecConcTempMin() {
        return specConcTempMin;
    }

    public void setSpecConcTempMin(Integer specConcTempMin) {
        this.specConcTempMin = specConcTempMin;
    }

    public Integer getSpecConcTempMax() {
        return specConcTempMax;
    }

    public void setSpecConcTempMax(Integer specConcTempMax) {
        this.specConcTempMax = specConcTempMax;
    }

    public Double getSpecResidualStr1() {
        return specResidualStr1;
    }

    public void setSpecResidualStr1(Double specResidualStr1) {
        this.specResidualStr1 = specResidualStr1;
    }

    public Double getSpecResidualStr2() {
        return specResidualStr2;
    }

    public void setSpecResidualStr2(Double specResidualStr2) {
        this.specResidualStr2 = specResidualStr2;
    }

    public Double getSpecResidualStr3() {
        return specResidualStr3;
    }

    public void setSpecResidualStr3(Double specResidualStr3) {
        this.specResidualStr3 = specResidualStr3;
    }

    public Double getSpecResidualStrPeak() {
        return specResidualStrPeak;
    }

    public void setSpecResidualStrPeak(Double specResidualStrPeak) {
        this.specResidualStrPeak = specResidualStrPeak;
    }

    public Double getBoiledabsorption() {
        return boiledabsorption;
    }

    public void setBoiledabsorption(Double boiledabsorption) {
        this.boiledabsorption = boiledabsorption;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
