/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.enumerator;

/**
 *
 * @author droldan
 */
public enum eLabSpecification implements BaseEnum {
    AASHTO_T104("Aggregate", "AASHTO_T104", "Aggregate Soundness"),
    AASHTO_T11("Aggregate", "AASHTO_T11", "Aggregate Finer Than #200 Sieve by Washing"),
    AASHTO_T112("Aggregate", "AASHTO_T112", "Aggregate Clay Lumps and Friable Particles"),
    AASHTO_T176("Aggregate", "AASHTO_T176", "Aggregates Sand Equivalent Test"),
    AASHTO_T21("Aggregate", "AASHTO_T21", "Organic Impurities in Sands for Concrete"),
    AASHTO_T27("Aggregate", "AASHTO_T27", "Sieve Analysis of Fine and Coarse Aggregate"),
    AASHTO_T84("Aggregate", "AASHTO_T84", "Fine Aggregate Specific Gravity and Absorption"),
    AASHTO_T85("Aggregate", "AASHTO_T85", "Coarse Aggregate Specific Gravity and Absorption"),
    AASHTO_T96("Aggregate", "AASHTO_T96", "Aggregate LA Abrasion"),
    AASHTO_R28("Asphalt Binder", "AASHTO_R28", "Asphalt Binder Pressure Aging Vessel"),
    AASHTO_T228("Asphalt Binder", "AASHTO_T228", "Asphalt Binde Specific Gravity"),
    AASHTO_T240("Asphalt Binder", "AASHTO_T240", "Asphalt Binder Rolling Thin Film Oven Test"),
    AASHTO_T313("Asphalt Binder", "AASHTO_T313", "Asphalt Binder Bending Beam Rheometer Testing"),
    AASHTO_T315("Asphalt Binder", "AASHTO_T315", "Asphalt Binder Dynamic Shear Rheometer Testing"),
    AASHTO_T316("Asphalt Binder", "AASHTO_T316", "Asphalt Binder Rotational Viscometer Testing"),
    AASHTO_T49("Asphalt Binder", "AASHTO_T49", "Asphalt Binder Penetration Test"),
    AASHTO_T350("Asphalt Binder", "AASHTO_T350", "Multiple Stress Creep Recovery (MSCR) Test Using Dynamic Shear Rheometer (DSR)"),
    ASTM_D2041("Asphalt Mixture", "ASTM_D2041", "HMA Theoretical Maximum Specific Gravity and Density"),
    AASHTO_R79("Asphalt Mixture", "AASHTO_R79", "HMA Vacuum Drying Compacted Asphalt Specimens"),
    AASHTO_T164("Asphalt Mixture", "AASHTO_T164", "HMA Quantitative Extraction"),
    AASHTO_T166("Asphalt Mixture", "AASHTO_T166", "HMA Bulk Specific Gravity"),
    AASHTO_T209("Asphalt Mixture", "AASHTO_T209", "HMA Theoretical Maximum Specific Gravity and Density"),
    AASHTO_T269("Asphalt Mixture", "AASHTO_T269", "HMA Air Voids in Dense and Open Bituminous Paving Mixtures"),
    AASHTO_T30("Asphalt Mixture", "AASHTO_T30", "HMA Extracted Sieve Analysis"),
    AASHTO_T308("Asphalt Mixture", "AASHTO_T308", "HMA Asphalt Binder Content by the Ignition Method"),
    AASHTO_T312("Asphalt Mixture", "AASHTO_T312", "HMA Density by Gyratory Compactor"),
    AASHTO_T329("Asphalt Mixture", "AASHTO_T329", "HMA Moisture Content by Oven Method"),
    AASHTO_T331("Asphalt Mixture", "AASHTO_T331", "HMA Bulk Specific Gravity Using Vacuum Sealing Method"),
    AASHTO_T245("Asphalt Mixture", "AASHTO_T245", "HMA Marshall Resistance to Plastic Flow"),
    AASHTO_TP124("Asphalt Mixture", "AASHTO_TP124", "Determining the Fracture Potential of Asphalt Mixtures Using Semicircular Bend Geometry (SCB) at Intermediate Temperature"),
    AASHTO_T106("Cement – Physical Tests", "AASHTO_T106", "Cement Mortar Compressive Strength"),
    AASHTO_T137("Cement – Physical Tests", "AASHTO_T137", "Cement Mortar Air Content"),
    AASHTO_T309("Concrete", "AASHTO_T309", "Fresh Mixed Concrete Temperature"),
    ASTM_C1231("Concrete", "ASTM_C1231", "Concrete Compressive Strength with Unbonded Caps"),
    AASHTO_R60("Concrete", "AASHTO_R60", "Sampling Freshly Mixed Concrete"),
    AASHTO_T119("Concrete", "AASHTO_T119", "Concrete Slump"),
    AASHTO_T121("Concrete", "AASHTO_T121", "Concrete Unit Weight, Yield & Air Content (Gravimetric)"),
    AASHTO_T24("Concrete", "AASHTO_T24", "Drilled Cores and Sawed Concrete Beams Testing"),
    AASHTO_T152("Concrete", "AASHTO_T152", "Fresh Concrete Air Content (Pressure Method)"),
    AASHTO_T196("Concrete", "AASHTO_T196", "Fresh Concrete Air Content (Volumetric Method)"),
    AASHTO_T22("Concrete", "AASHTO_T22", "Concrete Compressive Strength"),
    AASHTO_T23("Concrete", "AASHTO_T23", "Making and Curing Concrete Cylinders in Field"),
    AASHTO_T231("Concrete", "AASHTO_T231", "Capping Cylindrical Concrete"),
    AASHTO_T277("Concrete", "AASHTO_T277", "Concrete Resist Chloride Ion Penetration - Electrical Indication"),
    AASHTO_T358("Concrete", "AASHTO_T358", "Concrete Resist Chloride Ion Penetration - Surface Resistivity Indication"),
    AASHTO_T347("Concrete", "AASHTO_T347", "Slump Flow of Self-Consolidating Concrete"),
    AASHTO_T97("Concrete", "AASHTO_T97", "Concrete Flexural Strength (Third-Point Loading)"),
    AASHTO_T285("Concrete", "AASHTO_T285", "Bend Test for Bars for Concrete Reinforcement"),
    AASHTO_T59("Emulsified Asphalt", "AASHTO_T59", "Emulsion Residue by Distillation, Residue by Evaporation, Saybolt Viscosity at 25º and 50° C"),
    ASTM_D1140("Soil", "ASTM_D1140", "Soil Finer than the No. 200 Sieve"),
    ASTM_D2488("Soil", "ASTM_D2488", "Soil Identification (Visual-Manual Procedure)"),
    ASTM_D4972("Soil", "ASTM_D4972", "Soil pH"),
    ASTM_D6913("Soil", "ASTM_D6913", "Soil Sieve Analysis"),
    AASHTO_T100("Soil", "AASHTO_T100", "Soil Specific Gravity"),
    AASHTO_T180("Soil", "AASHTO_T180", "Soil Moisture Density Using 10 lb. Rammer"),
    AASHTO_T265("Soil", "AASHTO_T265", "Soil Moisture Content"),
    AASHTO_T267("Soil", "AASHTO_T267", "Soil Organic Content by Loss of Ignition"),
    AASHTO_T88("Soil", "AASHTO_T88", "Soil Particle Size Analysis"),
    AASHTO_T89("Soil", "AASHTO_T89", "Soil Liquid Limit"),
    AASHTO_T90("Soil", "AASHTO_T90", "Soil Plastic Limit and Plasticity Index"),
    AASHTO_T99("Soil", "AASHTO_T99", "Soil Moisture Density Using 5.5 lb. Rammer"),
    AASHTO_T310("Soil", "AASHTO_T310", "Soil Density and Moisture Content of Soil and Soil Aggregate by Nuclear Methods"),
    AASHTO_T236("Soil", "AASHTO_T236", "Test Method for Direct Shear Test of Soils Under Consolidated Drained Conditions"),
    ASTM_E8_CASTIRON("Metallic Materials", "ASTM_E8_CASTIRON", "Tension Testing of Cast Iron / Ductile Iron (Diameter, Load, Tensile)"),
    ASTM_E8_CHAINLINK("Metallic Materials", "ASTM_E8_CHAINLINK", "Tension Testing of Chain Link Fence (Diameter, Load, Tensile)"),
    ASTM_E8_ALUMINUMWIRE("Metallic Materials", "ASTM_E8_ALUMINUMWIRE", "Tension Testing of Chain Link Fence Fabric (Aluminum Alloy) (Diameter, Load, Tensile)"),
    ASTM_E8_TENSIONWIRE("Metallic Materials", "ASTM_E8_TENSIONWIRE", "Tension Testing of Tension Wire (Diameter, Load, Tensile)"),
    ASTM_E8_WELDEDWIRE("Metallic Materials", "ASTM_E8_WELDEDWIRE", "Tension Testing of Welded Wire Reinforcement (Horizontal Diameter, Vertical Diameter, Tensile, Reduction, Mesh Size)"),
    ASTM_E8_REBAR("Metallic Materials", "ASTM_E8_REBAR", "Tension Testing of Steel Reinforcing Bars (Yield, Tensile, Elongation, Unit Weight, Unit Weight %Difference)"),
    ASTM_A1061("Metallic Materials", "ASTM_A1061", "Multi-Wire Steel Prestressing Strand (Size, Ultimate Strength, Break Location, Elongation, Yield)"),
    ASTM_D412("Miscellaneous", "ASTM_D412", "Standard Test Methods for Vulcanized Rubber and Thermoplastic Elastomers - Tension"),
    ASTM_D573("Miscellaneous", "ASTM_D573", "Rubber Deterioration in an Air Oven"),
    ASTM_D638("Miscellaneous", "ASTM_D638", "Standard Test Method for Tensile Properties of Plastics");

    private final String name;
    private final String value;
    private final String description;

    private eLabSpecification(String s, String value, String description) {
        this.name = s;
        this.value = value;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public boolean equalsName(eLabSpecification otherName) {
        return (otherName == null) ? false : name.equals(otherName.name);
    }

    public static eLabSpecification getEnum(String value) {
        for (eLabSpecification v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return name;
    }
}
