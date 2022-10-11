/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;
import java.util.Date;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 4, end = 5000)
public class SectionConcMixDesign {

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
    private Date expirationDate;
    @ExcelField(position = 7)
    private String maxAggSize;
    @ExcelField(position = 8)
    private Double designCompstr;
    @ExcelField(position = 9)
    private Integer designCompstrAge;
    @ExcelField(position = 10)
    private String designCompstrAgeUnit;
    @ExcelField(position = 11)
    private Double designSlump;
    @ExcelField(position = 12)
    private Double designSlumpFlowScc;
    @ExcelField(position = 13)
    private Double designAirContent;
    @ExcelField(position = 14)
    private Double totalCoarseAgg;
    @ExcelField(position = 15)
    private Double totalFineAgg;
    @ExcelField(position = 16)
    private Double cement;
    @ExcelField(position = 17)
    private Double flyAsh;
    @ExcelField(position = 18)
    private Double slag;
    @ExcelField(position = 19)
    private Double silicaFume;
    @ExcelField(position = 20)
    private Double totalCementMat;
    @ExcelField(position = 21)
    private Double water;
    @ExcelField(position = 22)
    private Double admixtureQty1;
    @ExcelField(position = 23)
    private Double admixtureQty2;
    @ExcelField(position = 24)
    private Double admixtureQty3;
    @ExcelField(position = 25)
    private Double admixtureQty4;
    @ExcelField(position = 26)
    private Double admixtureQty5;
    @ExcelField(position = 27)
    private Double admixtureQty6;
    @ExcelField(position = 28)
    private Double admixtureQty7;
    @ExcelField(position = 29)
    private Double admixtureQty8;
    @ExcelField(position = 30)
    private Double waterCementRatio;
    @ExcelField(position = 31)
    private Double theoreticalAirContent;
    @ExcelField(position = 32)
    private Double volumenPaste;
    @ExcelField(position = 33)
    private Double specLimitSlumpMin;
    @ExcelField(position = 34)
    private Double specLimitSlumpMax;
    @ExcelField(position = 35)
    private Double engLimitSlumpMin;
    @ExcelField(position = 36)
    private Double engLimitSlumpMax;
    @ExcelField(position = 37)
    private Double specLimitAirContentMin;
    @ExcelField(position = 38)
    private Double specLimitAirContentMax;
    @ExcelField(position = 39)
    private Double engLimitAirContentMin;
    @ExcelField(position = 40)
    private Double engLimitAirContentMax;
    @ExcelField(position = 41)
    private Double specLimitCompstrMin;
    @ExcelField(position = 42)
    private Double specLimitCompstrMax;
    @ExcelField(position = 43)
    private Double engLimitCompstrMin;
    @ExcelField(position = 44)
    private Double engLimitCompstrMax;
    @ExcelField(position = 45)
    private Double specLimitSlumpFlowsccMin;
    @ExcelField(position = 46)
    private Double specLimitSlumpFlowsccMax;
    @ExcelField(position = 47)
    private Double engLimitSlumpFlowsccMin;
    @ExcelField(position = 48)
    private Double engLimitSlumpFlowsccMax;
    @ExcelField(position = 49)
    private Double trialOverdesignCompstrMin;
    @ExcelField(position = 50)
    private Double trialOverdesignCompstrMax;
    @ExcelField(position = 51)
    private Double designTensileStr;
    @ExcelField(position = 52)
    private Integer designTensileStrAge;
    @ExcelField(position = 53)
    private String designTensileStrAgeUnit;
    @ExcelField(position = 54)
    private Double designFlexStr;
    @ExcelField(position = 55)
    private Integer designFlexStrAge;
    @ExcelField(position = 56)
    private String designFlexStrAgeUnit;
    @ExcelField(position = 57)
    private Double specLimitTensileStrMin;
    @ExcelField(position = 58)
    private Double specLimitTensileStrMax;
    @ExcelField(position = 59)
    private Double engLimitTensileStrMin;
    @ExcelField(position = 60)
    private Double engLimitTensileStrMax;
    @ExcelField(position = 61)
    private Double specLimitFlexStrMin;
    @ExcelField(position = 62)
    private Double specLimitFlexStrMax;
    @ExcelField(position = 63)
    private Double engLimitFlexStrMin;
    @ExcelField(position = 64)
    private Double engLimitFlexStrMax;

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

    public Double getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(Double admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public Double getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(Double admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public Double getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(Double admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public Double getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(Double admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public Double getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(Double admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public Double getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(Double admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public Double getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(Double admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
    }

    public Double getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(Double waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
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
    
    public Boolean detectXmlBomb() {
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(this) != null && StringSupport.getString(field.get(this)).length() > ZipSecureFile.getMaxTextSize()) {
                    return Boolean.TRUE;
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
