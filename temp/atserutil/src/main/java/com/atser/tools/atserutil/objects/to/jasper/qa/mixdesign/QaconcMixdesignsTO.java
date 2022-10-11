/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign;

import com.atser.tools.atserutil.annotation.ReportColumnDef;
import com.atser.tools.atserutil.annotation.ReportColumnMapping;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
public class QaconcMixdesignsTO {

    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Mix Design No.")})
    private String mixdesignNo;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Produced By", width = 325)})
    private String supplier;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Plant Location", width = 350)})
    private String supplierLoc;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Mix Design Type", width = 250)})
    private String mixdesignType;
    private String mixdesignDescription;
    private String mixdesignRemark;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Maximum Aggregate Size (in)")})
    private String maxAggSizeId;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Compressive Strength, f'c (psi)")})
    private String designCompstr;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "f'c Age")})
    private String designCompstrAge;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "f'c Age Units")})
    private String designCompstrAgeUnit;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Slump (in.)")})
    private String designSlump;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Slump Flow for SCC (in.)")})
    private String designSlumpFlowScc;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Air Content (%)")})
    private String designAirContent;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Total Coarse Aggregate (lbs)")})
    private String totalCoarseAgg;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Coarse Aggregate 1 (lbs)", ignore = true)})
    private String coarseAgg1;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Coarse Aggregate 2 (lbs)", ignore = true)})
    private String coarseAgg2;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Total Fine Aggregate (lbs)")})
    private String totalFineAgg;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Fine Aggregate 1 (lbs)", ignore = true)})
    private String fineAgg1;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Fine Aggregate 2 (lbs)", ignore = true)})
    private String fineAgg2;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Cement (lbs)")})
    private String cement;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Flyash (lbs)")})
    private String flyAsh;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Slag (lbs)")})
    private String slag;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Silica Fume (lbs)")})
    private String silicaFume;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Total Cementitious Material (lbs)")})
    private String totalCementMat;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Water (gal)")})
    private String water;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 1 (oz)")})
    private String admixtureQty1;
    private String admixtureType1;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 2 (oz)")})
    private String admixtureQty2;
    private String admixtureType2;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 3 (oz)")})
    private String admixtureQty3;
    private String admixtureType3;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 4 (oz)")})
    private String admixtureQty4;
    private String admixtureType4;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 5 (oz)")})
    private String admixtureQty5;
    private String admixtureType5;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 6 (oz)")})
    private String admixtureQty6;
    private String admixtureType6;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 7 (oz)")})
    private String admixtureQty7;
    private String admixtureType7;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Admixture 8 (oz)")})
    private String admixtureQty8;
    private String admixtureType8;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "W/C")})
    private String waterCementRatio;
    private String waterCementMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Theoretical Air Content (%)")})
    private String theoreticalAirContent;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Volume of Paste (%)")})
    private String volumenPaste;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min Slump (in.)")})
    private String specLimitSlumpMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max Slump (in.)")})
    private String specLimitSlumpMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min Slump (in.)")})
    private String engLimitSlumpMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max Slump (in.)")})
    private String engLimitSlumpMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min Air Content (%)")})
    private String specLimitAirContentMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max Air Content (%)")})
    private String specLimitAirContentMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min Air Content (%)")})
    private String engLimitAirContentMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max Air Content (%)")})
    private String engLimitAirContentMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min f'c Compressive Strength (psi)")})
    private String specLimitCompstrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max f'c Compressive Strength (psi)")})
    private String specLimitCompstrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min f'c Compressive Strength (psi)")})
    private String engLimitCompstrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max f'c Compressive Strength (psi)")})
    private String engLimitCompstrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min Slump Flow for SCC (in.)")})
    private String specLimitSlumpFlowsccMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max Slump Flow for SCC (in.)")})
    private String specLimitSlumpFlowsccMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min Slump Flow for SCC (in.)")})
    private String engLimitSlumpFlowsccMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max Slump Flow for SCC (in.)")})
    private String engLimitSlumpFlowsccMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Trial Min Overdesign Compressive Strength, f'cr (psi)")})
    private String trialOverdesignCompstrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Trial Max Overdesign Compressive Strength, f'cr (psi)")})
    private String trialOverdesignCompstrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Tensile Strength (psi)")})
    private String designTensileStr;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Tensile Strength Age")})
    private String designTensileStrAge;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Tensile Strength Age Units")})
    private String designTensileStrAgeUnit;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Flexural Strength (psi)")})
    private String designFlexStr;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Flexural Strength Age")})
    private String designFlexStrAge;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Design Flexural Strength Age Units")})
    private String designFlexStrAgeUnit;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min Tensile Strength (psi)")})
    private String specLimitTensileStrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max Tensile Strength (psi)")})
    private String specLimitTensileStrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min Tensile Strength (psi)")})
    private String engLimitTensileStrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max Tensile Strength (psi)")})
    private String engLimitTensileStrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Min Flexural Strength (psi)")})
    private String specLimitFlexStrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Spec. Max Flexural Strength (psi)")})
    private String specLimitFlexStrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Min Flexural Strength (psi)")})
    private String engLimitFlexStrMin;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Eng. Max Flexural Strength (psi)")})
    private String engLimitFlexStrMax;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Concrete Class", ignore = true)})
    private String concreteClass;
    private String specSlumpSuspension;
    private String specSlumpAction;
    private String specAircontentSuspension;
    private String specAircontentAction;
    private String reqtk;
    private String specFlexSuspension;
    private String specFlexAction;
    private String specTkSuspension;
    private String specTkAction;
    private String specConcTempMin;
    private String specConcTempMax;
    private String specResidualStr1;
    private String specResidualStr2;
    private String specResidualStr3;
    private String specResidualStrPeak;
    private String boiledabsorption;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Expiration Date")})
    private String expirationDate;
    private String created;
    private String status;
    private String mixStatus;
    @ReportColumnMapping(column = {@ReportColumnDef(caption = "Contract No", ignore = true)})
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String pNumber;

    public QaconcMixdesignsTO() {
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }
    
}
