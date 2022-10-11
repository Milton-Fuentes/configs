/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import java.lang.reflect.Field;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 3, end = 3)
public class SectionDetectTplConcMixDesign {

    @ExcelField(position = 1)
    private String mixdesignNo;
    @ExcelField(position = 2)
    private String producedBy;
    @ExcelField(position = 3)
    private String plantLocation;
    @ExcelField(position = 4)
    private String mixdesignType;
    @ExcelField(position = 5)
    private String mixStatus;
    @ExcelField(position = 6)
    private String expirationDate;
    @ExcelField(position = 7)
    private String maxAggSize;
    @ExcelField(position = 8)
    private String designCompstr;
    @ExcelField(position = 9)
    private String designCompstrAge;
    @ExcelField(position = 10)
    private String designCompstrAgeUnit;
    @ExcelField(position = 11)
    private String designSlump;
    @ExcelField(position = 12)
    private String designSlumpFlowScc;
    @ExcelField(position = 13)
    private String designAirContent;
    @ExcelField(position = 14)
    private String totalCoarseAgg;
    @ExcelField(position = 15)
    private String totalFineAgg;
    @ExcelField(position = 16)
    private String cement;
    @ExcelField(position = 17)
    private String flyAsh;
    @ExcelField(position = 18)
    private String slag;
    @ExcelField(position = 19)
    private String silicaFume;
    @ExcelField(position = 20)
    private String totalCementMat;
    @ExcelField(position = 21)
    private String water;
    @ExcelField(position = 22)
    private String admixtureQty1;
    @ExcelField(position = 23)
    private String admixtureQty2;
    @ExcelField(position = 24)
    private String admixtureQty3;
    @ExcelField(position = 25)
    private String admixtureQty4;
    @ExcelField(position = 26)
    private String admixtureQty5;
    @ExcelField(position = 27)
    private String admixtureQty6;
    @ExcelField(position = 28)
    private String admixtureQty7;
    @ExcelField(position = 29)
    private String admixtureQty8;
    @ExcelField(position = 30)
    private String waterCementRatio;
    @ExcelField(position = 31)
    private String theoreticalAirContent;
    @ExcelField(position = 32)
    private String volumenPaste;
    @ExcelField(position = 33)
    private String specLimitSlumpMin;
    @ExcelField(position = 34)
    private String specLimitSlumpMax;
    @ExcelField(position = 35)
    private String engLimitSlumpMin;
    @ExcelField(position = 36)
    private String engLimitSlumpMax;
    @ExcelField(position = 37)
    private String specLimitAirContentMin;
    @ExcelField(position = 38)
    private String specLimitAirContentMax;
    @ExcelField(position = 39)
    private String engLimitAirContentMin;
    @ExcelField(position = 40)
    private String engLimitAirContentMax;
    @ExcelField(position = 41)
    private String specLimitCompstrMin;
    @ExcelField(position = 42)
    private String specLimitCompstrMax;
    @ExcelField(position = 43)
    private String engLimitCompstrMin;
    @ExcelField(position = 44)
    private String engLimitCompstrMax;
    @ExcelField(position = 45)
    private String specLimitSlumpFlowsccMin;
    @ExcelField(position = 46)
    private String specLimitSlumpFlowsccMax;
    @ExcelField(position = 47)
    private String engLimitSlumpFlowsccMin;
    @ExcelField(position = 48)
    private String engLimitSlumpFlowsccMax;
    @ExcelField(position = 49)
    private String trialOverdesignCompstrMin;
    @ExcelField(position = 50)
    private String trialOverdesignCompstrMax;
    @ExcelField(position = 51)
    private String designTensileStr;
    @ExcelField(position = 52)
    private String designTensileStrAge;
    @ExcelField(position = 53)
    private String designTensileStrAgeUnit;
    @ExcelField(position = 54)
    private String designFlexStr;
    @ExcelField(position = 55)
    private String designFlexStrAge;
    @ExcelField(position = 56)
    private String designFlexStrAgeUnit;
    @ExcelField(position = 57)
    private String specLimitTensileStrMin;
    @ExcelField(position = 58)
    private String specLimitTensileStrMax;
    @ExcelField(position = 59)
    private String engLimitTensileStrMin;
    @ExcelField(position = 60)
    private String engLimitTensileStrMax;
    @ExcelField(position = 61)
    private String specLimitFlexStrMin;
    @ExcelField(position = 62)
    private String specLimitFlexStrMax;
    @ExcelField(position = 63)
    private String engLimitFlexStrMin;
    @ExcelField(position = 64)
    private String engLimitFlexStrMax;

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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMaxAggSize() {
        return maxAggSize;
    }

    public void setMaxAggSize(String maxAggSize) {
        this.maxAggSize = maxAggSize;
    }

    public String getDesignCompstr() {
        return designCompstr;
    }

    public void setDesignCompstr(String designCompstr) {
        this.designCompstr = designCompstr;
    }

    public String getDesignCompstrAge() {
        return designCompstrAge;
    }

    public void setDesignCompstrAge(String designCompstrAge) {
        this.designCompstrAge = designCompstrAge;
    }

    public String getDesignCompstrAgeUnit() {
        return designCompstrAgeUnit;
    }

    public void setDesignCompstrAgeUnit(String designCompstrAgeUnit) {
        this.designCompstrAgeUnit = designCompstrAgeUnit;
    }

    public String getDesignSlump() {
        return designSlump;
    }

    public void setDesignSlump(String designSlump) {
        this.designSlump = designSlump;
    }

    public String getDesignSlumpFlowScc() {
        return designSlumpFlowScc;
    }

    public void setDesignSlumpFlowScc(String designSlumpFlowScc) {
        this.designSlumpFlowScc = designSlumpFlowScc;
    }

    public String getDesignAirContent() {
        return designAirContent;
    }

    public void setDesignAirContent(String designAirContent) {
        this.designAirContent = designAirContent;
    }

    public String getTotalCoarseAgg() {
        return totalCoarseAgg;
    }

    public void setTotalCoarseAgg(String totalCoarseAgg) {
        this.totalCoarseAgg = totalCoarseAgg;
    }

    public String getTotalFineAgg() {
        return totalFineAgg;
    }

    public void setTotalFineAgg(String totalFineAgg) {
        this.totalFineAgg = totalFineAgg;
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

    public String getSlag() {
        return slag;
    }

    public void setSlag(String slag) {
        this.slag = slag;
    }

    public String getSilicaFume() {
        return silicaFume;
    }

    public void setSilicaFume(String silicaFume) {
        this.silicaFume = silicaFume;
    }

    public String getTotalCementMat() {
        return totalCementMat;
    }

    public void setTotalCementMat(String totalCementMat) {
        this.totalCementMat = totalCementMat;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getAdmixtureQty1() {
        return admixtureQty1;
    }

    public void setAdmixtureQty1(String admixtureQty1) {
        this.admixtureQty1 = admixtureQty1;
    }

    public String getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(String admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public String getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(String admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public String getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(String admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public String getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(String admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public String getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(String admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public String getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(String admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public String getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(String admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
    }

    public String getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(String waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public String getTheoreticalAirContent() {
        return theoreticalAirContent;
    }

    public void setTheoreticalAirContent(String theoreticalAirContent) {
        this.theoreticalAirContent = theoreticalAirContent;
    }

    public String getVolumenPaste() {
        return volumenPaste;
    }

    public void setVolumenPaste(String volumenPaste) {
        this.volumenPaste = volumenPaste;
    }

    public String getSpecLimitSlumpMin() {
        return specLimitSlumpMin;
    }

    public void setSpecLimitSlumpMin(String specLimitSlumpMin) {
        this.specLimitSlumpMin = specLimitSlumpMin;
    }

    public String getSpecLimitSlumpMax() {
        return specLimitSlumpMax;
    }

    public void setSpecLimitSlumpMax(String specLimitSlumpMax) {
        this.specLimitSlumpMax = specLimitSlumpMax;
    }

    public String getEngLimitSlumpMin() {
        return engLimitSlumpMin;
    }

    public void setEngLimitSlumpMin(String engLimitSlumpMin) {
        this.engLimitSlumpMin = engLimitSlumpMin;
    }

    public String getEngLimitSlumpMax() {
        return engLimitSlumpMax;
    }

    public void setEngLimitSlumpMax(String engLimitSlumpMax) {
        this.engLimitSlumpMax = engLimitSlumpMax;
    }

    public String getSpecLimitAirContentMin() {
        return specLimitAirContentMin;
    }

    public void setSpecLimitAirContentMin(String specLimitAirContentMin) {
        this.specLimitAirContentMin = specLimitAirContentMin;
    }

    public String getSpecLimitAirContentMax() {
        return specLimitAirContentMax;
    }

    public void setSpecLimitAirContentMax(String specLimitAirContentMax) {
        this.specLimitAirContentMax = specLimitAirContentMax;
    }

    public String getEngLimitAirContentMin() {
        return engLimitAirContentMin;
    }

    public void setEngLimitAirContentMin(String engLimitAirContentMin) {
        this.engLimitAirContentMin = engLimitAirContentMin;
    }

    public String getEngLimitAirContentMax() {
        return engLimitAirContentMax;
    }

    public void setEngLimitAirContentMax(String engLimitAirContentMax) {
        this.engLimitAirContentMax = engLimitAirContentMax;
    }

    public String getSpecLimitCompstrMin() {
        return specLimitCompstrMin;
    }

    public void setSpecLimitCompstrMin(String specLimitCompstrMin) {
        this.specLimitCompstrMin = specLimitCompstrMin;
    }

    public String getSpecLimitCompstrMax() {
        return specLimitCompstrMax;
    }

    public void setSpecLimitCompstrMax(String specLimitCompstrMax) {
        this.specLimitCompstrMax = specLimitCompstrMax;
    }

    public String getEngLimitCompstrMin() {
        return engLimitCompstrMin;
    }

    public void setEngLimitCompstrMin(String engLimitCompstrMin) {
        this.engLimitCompstrMin = engLimitCompstrMin;
    }

    public String getEngLimitCompstrMax() {
        return engLimitCompstrMax;
    }

    public void setEngLimitCompstrMax(String engLimitCompstrMax) {
        this.engLimitCompstrMax = engLimitCompstrMax;
    }

    public String getSpecLimitSlumpFlowsccMin() {
        return specLimitSlumpFlowsccMin;
    }

    public void setSpecLimitSlumpFlowsccMin(String specLimitSlumpFlowsccMin) {
        this.specLimitSlumpFlowsccMin = specLimitSlumpFlowsccMin;
    }

    public String getSpecLimitSlumpFlowsccMax() {
        return specLimitSlumpFlowsccMax;
    }

    public void setSpecLimitSlumpFlowsccMax(String specLimitSlumpFlowsccMax) {
        this.specLimitSlumpFlowsccMax = specLimitSlumpFlowsccMax;
    }

    public String getEngLimitSlumpFlowsccMin() {
        return engLimitSlumpFlowsccMin;
    }

    public void setEngLimitSlumpFlowsccMin(String engLimitSlumpFlowsccMin) {
        this.engLimitSlumpFlowsccMin = engLimitSlumpFlowsccMin;
    }

    public String getEngLimitSlumpFlowsccMax() {
        return engLimitSlumpFlowsccMax;
    }

    public void setEngLimitSlumpFlowsccMax(String engLimitSlumpFlowsccMax) {
        this.engLimitSlumpFlowsccMax = engLimitSlumpFlowsccMax;
    }

    public String getTrialOverdesignCompstrMin() {
        return trialOverdesignCompstrMin;
    }

    public void setTrialOverdesignCompstrMin(String trialOverdesignCompstrMin) {
        this.trialOverdesignCompstrMin = trialOverdesignCompstrMin;
    }

    public String getTrialOverdesignCompstrMax() {
        return trialOverdesignCompstrMax;
    }

    public void setTrialOverdesignCompstrMax(String trialOverdesignCompstrMax) {
        this.trialOverdesignCompstrMax = trialOverdesignCompstrMax;
    }

    public String getDesignTensileStr() {
        return designTensileStr;
    }

    public void setDesignTensileStr(String designTensileStr) {
        this.designTensileStr = designTensileStr;
    }

    public String getDesignTensileStrAge() {
        return designTensileStrAge;
    }

    public void setDesignTensileStrAge(String designTensileStrAge) {
        this.designTensileStrAge = designTensileStrAge;
    }

    public String getDesignTensileStrAgeUnit() {
        return designTensileStrAgeUnit;
    }

    public void setDesignTensileStrAgeUnit(String designTensileStrAgeUnit) {
        this.designTensileStrAgeUnit = designTensileStrAgeUnit;
    }

    public String getDesignFlexStr() {
        return designFlexStr;
    }

    public void setDesignFlexStr(String designFlexStr) {
        this.designFlexStr = designFlexStr;
    }

    public String getDesignFlexStrAge() {
        return designFlexStrAge;
    }

    public void setDesignFlexStrAge(String designFlexStrAge) {
        this.designFlexStrAge = designFlexStrAge;
    }

    public String getDesignFlexStrAgeUnit() {
        return designFlexStrAgeUnit;
    }

    public void setDesignFlexStrAgeUnit(String designFlexStrAgeUnit) {
        this.designFlexStrAgeUnit = designFlexStrAgeUnit;
    }

    public String getSpecLimitTensileStrMin() {
        return specLimitTensileStrMin;
    }

    public void setSpecLimitTensileStrMin(String specLimitTensileStrMin) {
        this.specLimitTensileStrMin = specLimitTensileStrMin;
    }

    public String getSpecLimitTensileStrMax() {
        return specLimitTensileStrMax;
    }

    public void setSpecLimitTensileStrMax(String specLimitTensileStrMax) {
        this.specLimitTensileStrMax = specLimitTensileStrMax;
    }

    public String getEngLimitTensileStrMin() {
        return engLimitTensileStrMin;
    }

    public void setEngLimitTensileStrMin(String engLimitTensileStrMin) {
        this.engLimitTensileStrMin = engLimitTensileStrMin;
    }

    public String getEngLimitTensileStrMax() {
        return engLimitTensileStrMax;
    }

    public void setEngLimitTensileStrMax(String engLimitTensileStrMax) {
        this.engLimitTensileStrMax = engLimitTensileStrMax;
    }

    public String getSpecLimitFlexStrMin() {
        return specLimitFlexStrMin;
    }

    public void setSpecLimitFlexStrMin(String specLimitFlexStrMin) {
        this.specLimitFlexStrMin = specLimitFlexStrMin;
    }

    public String getSpecLimitFlexStrMax() {
        return specLimitFlexStrMax;
    }

    public void setSpecLimitFlexStrMax(String specLimitFlexStrMax) {
        this.specLimitFlexStrMax = specLimitFlexStrMax;
    }

    public String getEngLimitFlexStrMin() {
        return engLimitFlexStrMin;
    }

    public void setEngLimitFlexStrMin(String engLimitFlexStrMin) {
        this.engLimitFlexStrMin = engLimitFlexStrMin;
    }

    public String getEngLimitFlexStrMax() {
        return engLimitFlexStrMax;
    }

    public void setEngLimitFlexStrMax(String engLimitFlexStrMax) {
        this.engLimitFlexStrMax = engLimitFlexStrMax;
    }
    
    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        int count = 1;
        for(Field it : this.getClass().getDeclaredFields()) {
            if(it.get(this) == null) {
                return Boolean.FALSE;
            } else if(!it.getName().toLowerCase().equals(sanitizeString(it.get(this).toString()))) {
                return Boolean.FALSE;
            }
            if(count++ == 6) {
                return Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }
    
    private String sanitizeString(String value) {
        String response = value.replaceAll("\\s+", "");
        return response.toLowerCase();
    }
}
