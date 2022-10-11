/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixdesignsTO;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
@NamedQuery(name = "QaconcMixdesigns.findByProjectId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaconcMixdesigns.findByConcreteClass", query = "SELECT q FROM QaconcMixdesigns q WHERE q.concreteClass = :concreteClass"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecSlumpMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specSlumpMin = :specSlumpMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecSlumpMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specSlumpMax = :specSlumpMax"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecAircontMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specAircontMin = :specAircontMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecAircontMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specAircontMax = :specAircontMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByCompstr28day", query = "SELECT q FROM QaconcMixdesigns q WHERE q.compstr28day = :compstr28day"),
    @NamedQuery(name = "QaconcMixdesigns.findByMaxWaterCmt", query = "SELECT q FROM QaconcMixdesigns q WHERE q.maxWaterCmt = :maxWaterCmt"),
    @NamedQuery(name = "QaconcMixdesigns.findByAggSource", query = "SELECT q FROM QaconcMixdesigns q WHERE q.aggSource = :aggSource"),
    @NamedQuery(name = "QaconcMixdesigns.findBySandSource", query = "SELECT q FROM QaconcMixdesigns q WHERE q.sandSource = :sandSource"),
    @NamedQuery(name = "QaconcMixdesigns.findByFlyAsh", query = "SELECT q FROM QaconcMixdesigns q WHERE q.flyAsh = :flyAsh"),
    @NamedQuery(name = "QaconcMixdesigns.findByActive", query = "SELECT q FROM QaconcMixdesigns q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcMixdesigns.findByStructure", query = "SELECT q FROM QaconcMixdesigns q WHERE q.structure = :structure"),
    @NamedQuery(name = "QaconcMixdesigns.findByMixDesign", query = "SELECT q FROM QaconcMixdesigns q WHERE q.mixDesign = :mixDesign"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecSlumpDesign", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specSlumpDesign = :specSlumpDesign"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecSlumpSuspension", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specSlumpSuspension = :specSlumpSuspension"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecSlumpAction", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specSlumpAction = :specSlumpAction"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecAircontDesign", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specAircontDesign = :specAircontDesign"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecAircontSuspension", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specAircontSuspension = :specAircontSuspension"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecAircontAction", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specAircontAction = :specAircontAction"),
    @NamedQuery(name = "QaconcMixdesigns.findByFlexstr28day", query = "SELECT q FROM QaconcMixdesigns q WHERE q.flexstr28day = :flexstr28day"),
    @NamedQuery(name = "QaconcMixdesigns.findByReqtk", query = "SELECT q FROM QaconcMixdesigns q WHERE q.reqtk = :reqtk"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecFlexAction", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specFlexAction = :specFlexAction"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecTkAction", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specTkAction = :specTkAction"),
    @NamedQuery(name = "QaconcMixdesigns.findByCompany", query = "SELECT q FROM QaconcMixdesigns q WHERE q.company = :company"),
    @NamedQuery(name = "QaconcMixdesigns.findByLastModTmp", query = "SELECT q FROM QaconcMixdesigns q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QaconcMixdesigns.findByLastMod", query = "SELECT q FROM QaconcMixdesigns q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcMixdesigns.findByCementAmount", query = "SELECT q FROM QaconcMixdesigns q WHERE q.cementAmount = :cementAmount"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecConcTempMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specConcTempMin = :specConcTempMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecConcTempMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specConcTempMax = :specConcTempMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByItemId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaconcMixdesigns.findByMatId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.matId = :matId"),
    @NamedQuery(name = "QaconcMixdesigns.findByClassId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.classId = :classId"),
    @NamedQuery(name = "QaconcMixdesigns.findBySupplierId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty1", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty1 = :admixtureQty1"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty2", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty2 = :admixtureQty2"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty3", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty3 = :admixtureQty3"),
    @NamedQuery(name = "QaconcMixdesigns.findBySuperplasticizer", query = "SELECT q FROM QaconcMixdesigns q WHERE q.superplasticizer = :superplasticizer"),
    @NamedQuery(name = "QaconcMixdesigns.findByCni", query = "SELECT q FROM QaconcMixdesigns q WHERE q.cni = :cni"),
    @NamedQuery(name = "QaconcMixdesigns.findByApplicationId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.applicationId = :applicationId"),
    @NamedQuery(name = "QaconcMixdesigns.findByCompstr56day", query = "SELECT q FROM QaconcMixdesigns q WHERE q.compstr56day = :compstr56day"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecResidualStrength1", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specResidualStrength1 = :specResidualStrength1"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecResidualStrength2", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specResidualStrength2 = :specResidualStrength2"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecResidualStrength3", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specResidualStrength3 = :specResidualStrength3"),
    @NamedQuery(name = "QaconcMixdesigns.findByMixType", query = "SELECT q FROM QaconcMixdesigns q WHERE q.mixType = :mixType"),
    @NamedQuery(name = "QaconcMixdesigns.findByLifting", query = "SELECT q FROM QaconcMixdesigns q WHERE q.lifting = :lifting"),
    @NamedQuery(name = "QaconcMixdesigns.findByBoiledabsorption28day", query = "SELECT q FROM QaconcMixdesigns q WHERE q.boiledabsorption28day = :boiledabsorption28day"),
    @NamedQuery(name = "QaconcMixdesigns.findByTensilestr28day", query = "SELECT q FROM QaconcMixdesigns q WHERE q.tensilestr28day = :tensilestr28day"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecResidualStrengthPeak", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specResidualStrengthPeak = :specResidualStrengthPeak"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecWater", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specWater = :specWater"),
    @NamedQuery(name = "QaconcMixdesigns.findByAvg7dayStrength", query = "SELECT q FROM QaconcMixdesigns q WHERE q.avg7dayStrength = :avg7dayStrength"),
    @NamedQuery(name = "QaconcMixdesigns.findByAvg28dayStrength", query = "SELECT q FROM QaconcMixdesigns q WHERE q.avg28dayStrength = :avg28dayStrength"),
    @NamedQuery(name = "QaconcMixdesigns.findByAciReq28dayStrength", query = "SELECT q FROM QaconcMixdesigns q WHERE q.aciReq28dayStrength = :aciReq28dayStrength"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty4", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty4 = :admixtureQty4"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty5", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty5 = :admixtureQty5"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType1", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType1 = :admixtureType1"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType2", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType2 = :admixtureType2"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType3", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType3 = :admixtureType3"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType4", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType4 = :admixtureType4"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType5", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType5 = :admixtureType5"),
    @NamedQuery(name = "QaconcMixdesigns.findByCreateDate", query = "SELECT q FROM QaconcMixdesigns q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaconcMixdesigns.findByCreateBy", query = "SELECT q FROM QaconcMixdesigns q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaconcMixdesigns.findByCreateByIp", query = "SELECT q FROM QaconcMixdesigns q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaconcMixdesigns.findByLastModBy", query = "SELECT q FROM QaconcMixdesigns q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaconcMixdesigns.findByLastModIp", query = "SELECT q FROM QaconcMixdesigns q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcMixdesigns.findByVersion", query = "SELECT q FROM QaconcMixdesigns q WHERE q.version = :version"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecFlexSuspension", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specFlexSuspension = :specFlexSuspension"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecTkSuspension", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specTkSuspension = :specTkSuspension"),
    @NamedQuery(name = "QaconcMixdesigns.findByMediumAgg", query = "SELECT q FROM QaconcMixdesigns q WHERE q.mediumAgg = :mediumAgg"),
    @NamedQuery(name = "QaconcMixdesigns.findByRemarks", query = "SELECT q FROM QaconcMixdesigns q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaconcMixdesigns.findByMaxAggSizeId", query = "SELECT q FROM QaconcMixdesigns q WHERE q.maxAggSizeId = :maxAggSizeId"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignCompstrAge", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designCompstrAge = :designCompstrAge"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignCompstrAgeUnit", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designCompstrAgeUnit = :designCompstrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignSlumpFlowScc", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designSlumpFlowScc = :designSlumpFlowScc"),
    @NamedQuery(name = "QaconcMixdesigns.findBySlag", query = "SELECT q FROM QaconcMixdesigns q WHERE q.slag = :slag"),
    @NamedQuery(name = "QaconcMixdesigns.findBySilicaFume", query = "SELECT q FROM QaconcMixdesigns q WHERE q.silicaFume = :silicaFume"),
    @NamedQuery(name = "QaconcMixdesigns.findByTotalCementMat", query = "SELECT q FROM QaconcMixdesigns q WHERE q.totalCementMat = :totalCementMat"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty6", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty6 = :admixtureQty6"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType6", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType6 = :admixtureType6"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty7", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty7 = :admixtureQty7"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType7", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType7 = :admixtureType7"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureQty8", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureQty8 = :admixtureQty8"),
    @NamedQuery(name = "QaconcMixdesigns.findByAdmixtureType8", query = "SELECT q FROM QaconcMixdesigns q WHERE q.admixtureType8 = :admixtureType8"),
    @NamedQuery(name = "QaconcMixdesigns.findByWaterCementRatio", query = "SELECT q FROM QaconcMixdesigns q WHERE q.waterCementRatio = :waterCementRatio"),
    @NamedQuery(name = "QaconcMixdesigns.findByTheoreticalAirContent", query = "SELECT q FROM QaconcMixdesigns q WHERE q.theoreticalAirContent = :theoreticalAirContent"),
    @NamedQuery(name = "QaconcMixdesigns.findByVolumenPaste", query = "SELECT q FROM QaconcMixdesigns q WHERE q.volumenPaste = :volumenPaste"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitSlumpMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitSlumpMin = :engLimitSlumpMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitSlumpMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitSlumpMax = :engLimitSlumpMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitAirContentMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitAirContentMin = :engLimitAirContentMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitAirContentMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitAirContentMax = :engLimitAirContentMax"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitCompstrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitCompstrMin = :specLimitCompstrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitCompstrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitCompstrMax = :specLimitCompstrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitCompstrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitCompstrMin = :engLimitCompstrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitCompstrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitCompstrMax = :engLimitCompstrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitSlumpFlowsccMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitSlumpFlowsccMin = :specLimitSlumpFlowsccMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitSlumpFlowsccMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitSlumpFlowsccMax = :specLimitSlumpFlowsccMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitSlumpFlowsccMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitSlumpFlowsccMin = :engLimitSlumpFlowsccMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitSlumpFlowsccMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitSlumpFlowsccMax = :engLimitSlumpFlowsccMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByTrialOverdesignCompstrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.trialOverdesignCompstrMin = :trialOverdesignCompstrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByTrialOverdesignCompstrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.trialOverdesignCompstrMax = :trialOverdesignCompstrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignTensileStrAge", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designTensileStrAge = :designTensileStrAge"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignTensileStrAgeUnit", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designTensileStrAgeUnit = :designTensileStrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignFlexStrAge", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designFlexStrAge = :designFlexStrAge"),
    @NamedQuery(name = "QaconcMixdesigns.findByDesignFlexStrAgeUnit", query = "SELECT q FROM QaconcMixdesigns q WHERE q.designFlexStrAgeUnit = :designFlexStrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitTensileStrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitTensileStrMin = :specLimitTensileStrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitTensileStrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitTensileStrMax = :specLimitTensileStrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitTensileStrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitTensileStrMin = :engLimitTensileStrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitTensileStrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitTensileStrMax = :engLimitTensileStrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitFlexStrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitFlexStrMin = :specLimitFlexStrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findBySpecLimitFlexStrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.specLimitFlexStrMax = :specLimitFlexStrMax"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitFlexStrMin", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitFlexStrMin = :engLimitFlexStrMin"),
    @NamedQuery(name = "QaconcMixdesigns.findByEngLimitFlexStrMax", query = "SELECT q FROM QaconcMixdesigns q WHERE q.engLimitFlexStrMax = :engLimitFlexStrMax")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QACONC_MIXDESIGNS", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QACONC_MIXDESIGNS SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcMixdesigns.findAll", query = "SELECT q FROM QaconcMixdesigns q"),
    @NamedQuery(name = "QaconcMixdesigns.findById", query = "SELECT q FROM QaconcMixdesigns q WHERE q.id = :id"),
    @NamedQuery(name = "QaconcMixdesigns.findByMixDesignNo", query = "SELECT q FROM QaconcMixdesigns q WHERE q.mixDesign = :mixDesign AND q.projectId = :projectId"),
    @NamedQuery(name = "QaconcMixdesigns.findByMasterRefAndProject", query = "SELECT q FROM QaconcMixdesigns q WHERE q.masterRefId = :masterRefId AND q.projectId = :projectId")})
public class QaconcMixdesigns implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_MIXDESIGNS_ID_SEQ", sequenceName = "QACONC_MIXDESIGNS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_MIXDESIGNS_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 100)
    @Column(name = "CONCRETE_CLASS")
    private String concreteClass;
    @Column(name = "SPEC_SLUMP_MIN")
    private BigDecimal specSlumpMin;
    @Column(name = "SPEC_SLUMP_MAX")
    private BigDecimal specSlumpMax;
    @Column(name = "SPEC_AIRCONT_MIN")
    private BigDecimal specAircontMin;
    @Column(name = "SPEC_AIRCONT_MAX")
    private BigDecimal specAircontMax;
    @Column(name = "COMPSTR28DAY")
    private BigDecimal compstr28day;
    @Size(max = 11)
    @Column(name = "MAX_WATER_CMT")
    private String maxWaterCmt;
    @Size(max = 50)
    @Column(name = "AGG_SOURCE")
    private String aggSource;
    @Size(max = 50)
    @Column(name = "AGG_SOURCE1")
    private String aggSource1;
    @Size(max = 50)
    @Column(name = "AGG_SOURCE2")
    private String aggSource2;
    @Size(max = 50)
    @Column(name = "SAND_SOURCE")
    private String sandSource;
    @Size(max = 50)
    @Column(name = "SAND_SOURCE1")
    private String sandSource1;
    @Size(max = 50)
    @Column(name = "SAND_SOURCE2")
    private String sandSource2;
    @Size(max = 50)
    @Column(name = "FLY_ASH")
    private String flyAsh;
    @Column(name = "ACTIVE", insertable = false, updatable = false)
    private Character active;
    @Size(max = 255)
    @Column(name = "STRUCTURE")
    private String structure;
    @Size(max = 50)
    @Column(name = "MIX_DESIGN")
    private String mixDesign;
    @Column(name = "SPEC_SLUMP_DESIGN")
    private BigDecimal specSlumpDesign;
    @Column(name = "SPEC_SLUMP_SUSPENSION")
    private BigDecimal specSlumpSuspension;
    @Column(name = "SPEC_SLUMP_ACTION")
    private BigDecimal specSlumpAction;
    @Column(name = "SPEC_AIRCONT_DESIGN")
    private BigDecimal specAircontDesign;
    @Column(name = "SPEC_AIRCONT_SUSPENSION")
    private BigDecimal specAircontSuspension;
    @Column(name = "SPEC_AIRCONT_ACTION")
    private BigDecimal specAircontAction;
    @Column(name = "FLEXSTR28DAY")
    private BigDecimal flexstr28day;
    @Column(name = "REQTK")
    private BigDecimal reqtk;
    @Column(name = "SPEC_FLEX_ACTION")
    private BigDecimal specFlexAction;
    @Column(name = "SPEC_TK_ACTION")
    private BigDecimal specTkAction;
    @Size(max = 255)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "CEMENT_AMOUNT")
    private BigDecimal cementAmount;
    @Column(name = "SPEC_CONC_TEMP_MIN")
    private BigInteger specConcTempMin;
    @Column(name = "SPEC_CONC_TEMP_MAX")
    private BigInteger specConcTempMax;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "CLASS_ID")
    private BigInteger classId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(optional = false)
    private GlobSupplier supplierId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_LOC_ID")
    @ManyToOne(optional = true)
    private GlobSupplierAddress supplierLocId;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_1")
    private String admixtureQty1;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_2")
    private String admixtureQty2;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_3")
    private String admixtureQty3;
    @Size(max = 50)
    @Column(name = "SUPERPLASTICIZER")
    private String superplasticizer;
    @Size(max = 50)
    @Column(name = "CNI")
    private String cni;
    @Column(name = "APPLICATION_ID")
    private BigInteger applicationId;
    @Column(name = "COMPSTR56DAY")
    private BigDecimal compstr56day;
    @Column(name = "SPEC_RESIDUAL_STRENGTH1")
    private BigDecimal specResidualStrength1;
    @Column(name = "SPEC_RESIDUAL_STRENGTH2")
    private BigDecimal specResidualStrength2;
    @Column(name = "SPEC_RESIDUAL_STRENGTH3")
    private BigDecimal specResidualStrength3;
    @Size(max = 50)
    @Column(name = "MIX_TYPE")
    private String mixType;
    @Column(name = "LIFTING")
    private BigDecimal lifting;
    @Column(name = "BOILEDABSORPTION28DAY")
    private BigDecimal boiledabsorption28day;
    @Column(name = "TENSILESTR28DAY")
    private BigDecimal tensilestr28day;
    @Column(name = "SPEC_RESIDUAL_STRENGTH_PEAK")
    private BigDecimal specResidualStrengthPeak;
    @Size(max = 50)
    @Column(name = "SPEC_WATER")
    private String specWater;
    @Column(name = "AVG7DAY_STRENGTH")
    private BigDecimal avg7dayStrength;
    @Column(name = "AVG28DAY_STRENGTH")
    private BigDecimal avg28dayStrength;
    @Column(name = "ACI_REQ28DAY_STRENGTH")
    private BigDecimal aciReq28dayStrength;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_4")
    private String admixtureQty4;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY_5")
    private String admixtureQty5;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_1")
    private String admixtureType1;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_2")
    private String admixtureType2;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_3")
    private String admixtureType3;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_4")
    private String admixtureType4;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE_5")
    private String admixtureType5;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "SPEC_FLEX_SUSPENSION")
    private BigDecimal specFlexSuspension;
    @Column(name = "SPEC_TK_SUSPENSION")
    private BigDecimal specTkSuspension;
    @Size(max = 50)
    @Column(name = "MEDIUM_AGG")
    private String mediumAgg;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Lob
    @Column(name = "MIXDESIGN_DESCRIPTION")
    private String mixdesignDescription;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "MAX_AGG_SIZE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData maxAggSizeId;
    @Column(name = "DESIGN_COMPSTR_AGE")
    private BigInteger designCompstrAge;
    @Size(max = 50)
    @Column(name = "DESIGN_COMPSTR_AGE_UNIT")
    private String designCompstrAgeUnit;
    @Column(name = "DESIGN_SLUMP_FLOW_SCC")
    private BigDecimal designSlumpFlowScc;
    @Column(name = "SLAG")
    private BigDecimal slag;
    @Column(name = "SILICA_FUME")
    private BigDecimal silicaFume;
    @Column(name = "TOTAL_CEMENT_MAT")
    private BigDecimal totalCementMat;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY6")
    private String admixtureQty6;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE6")
    private String admixtureType6;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY7")
    private String admixtureQty7;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE7")
    private String admixtureType7;
    @Size(max = 12)
    @Column(name = "ADMIXTURE_QTY8")
    private String admixtureQty8;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE8")
    private String admixtureType8;
    @Column(name = "WATER_CEMENT_RATIO")
    private BigDecimal waterCementRatio;
    @Column(name = "THEORETICAL_AIR_CONTENT")
    private BigDecimal theoreticalAirContent;
    @Column(name = "VOLUMEN_PASTE")
    private BigDecimal volumenPaste;
    @Column(name = "ENG_LIMIT_SLUMP_MIN")
    private BigDecimal engLimitSlumpMin;
    @Column(name = "ENG_LIMIT_SLUMP_MAX")
    private BigDecimal engLimitSlumpMax;
    @Column(name = "ENG_LIMIT_AIR_CONTENT_MIN")
    private BigDecimal engLimitAirContentMin;
    @Column(name = "ENG_LIMIT_AIR_CONTENT_MAX")
    private BigDecimal engLimitAirContentMax;
    @Column(name = "SPEC_LIMIT_COMPSTR_MIN")
    private BigDecimal specLimitCompstrMin;
    @Column(name = "SPEC_LIMIT_COMPSTR_MAX")
    private BigDecimal specLimitCompstrMax;
    @Column(name = "ENG_LIMIT_COMPSTR_MIN")
    private BigDecimal engLimitCompstrMin;
    @Column(name = "ENG_LIMIT_COMPSTR_MAX")
    private BigDecimal engLimitCompstrMax;
    @Column(name = "SPEC_LIMIT_SLUMP_FLOWSCC_MIN")
    private BigDecimal specLimitSlumpFlowsccMin;
    @Column(name = "SPEC_LIMIT_SLUMP_FLOWSCC_MAX")
    private BigDecimal specLimitSlumpFlowsccMax;
    @Column(name = "ENG_LIMIT_SLUMP_FLOWSCC_MIN")
    private BigDecimal engLimitSlumpFlowsccMin;
    @Column(name = "ENG_LIMIT_SLUMP_FLOWSCC_MAX")
    private BigDecimal engLimitSlumpFlowsccMax;
    @Column(name = "TRIAL_OVERDESIGN_COMPSTR_MIN")
    private BigDecimal trialOverdesignCompstrMin;
    @Column(name = "TRIAL_OVERDESIGN_COMPSTR_MAX")
    private BigDecimal trialOverdesignCompstrMax;
    @Column(name = "DESIGN_TENSILE_STR_AGE")
    private BigInteger designTensileStrAge;
    @Size(max = 50)
    @Column(name = "DESIGN_TENSILE_STR_AGE_UNIT")
    private String designTensileStrAgeUnit;
    @Column(name = "DESIGN_FLEX_STR_AGE")
    private BigInteger designFlexStrAge;
    @Size(max = 50)
    @Column(name = "DESIGN_FLEX_STR_AGE_UNIT")
    private String designFlexStrAgeUnit;
    @Column(name = "SPEC_LIMIT_TENSILE_STR_MIN")
    private BigDecimal specLimitTensileStrMin;
    @Column(name = "SPEC_LIMIT_TENSILE_STR_MAX")
    private BigDecimal specLimitTensileStrMax;
    @Column(name = "ENG_LIMIT_TENSILE_STR_MIN")
    private BigDecimal engLimitTensileStrMin;
    @Column(name = "ENG_LIMIT_TENSILE_STR_MAX")
    private BigDecimal engLimitTensileStrMax;
    @Column(name = "SPEC_LIMIT_FLEX_STR_MIN")
    private BigDecimal specLimitFlexStrMin;
    @Column(name = "SPEC_LIMIT_FLEX_STR_MAX")
    private BigDecimal specLimitFlexStrMax;
    @Column(name = "ENG_LIMIT_FLEX_STR_MIN")
    private BigDecimal engLimitFlexStrMin;
    @Column(name = "ENG_LIMIT_FLEX_STR_MAX")
    private BigDecimal engLimitFlexStrMax;
    @Column(name = "MASTERREFID")
    private BigInteger masterRefId;
    @Transient
    @JsonProperty("canBeDeleted")
    private String canbeDeleted;

    public QaconcMixdesigns() {
        canbeDeleted = "true";
    }

    public QaconcMixdesigns(BigDecimal id) {
        canbeDeleted = "true";
        this.id = id;
    }

    public QaconcMixdesigns(BigDecimal id, BigInteger projectId) {
        canbeDeleted = "true";
        this.id = id;
        this.projectId = projectId;
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

    public String getConcreteClass() {
        return concreteClass;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
    }

    public BigDecimal getSpecSlumpMin() {
        return specSlumpMin;
    }

    public void setSpecSlumpMin(BigDecimal specSlumpMin) {
        this.specSlumpMin = specSlumpMin;
    }

    public BigDecimal getSpecSlumpMax() {
        return specSlumpMax;
    }

    public void setSpecSlumpMax(BigDecimal specSlumpMax) {
        this.specSlumpMax = specSlumpMax;
    }

    public BigDecimal getSpecAircontMin() {
        return specAircontMin;
    }

    public void setSpecAircontMin(BigDecimal specAircontMin) {
        this.specAircontMin = specAircontMin;
    }

    public BigDecimal getSpecAircontMax() {
        return specAircontMax;
    }

    public void setSpecAircontMax(BigDecimal specAircontMax) {
        this.specAircontMax = specAircontMax;
    }

    public BigDecimal getCompstr28day() {
        return compstr28day;
    }

    public void setCompstr28day(BigDecimal compstr28day) {
        this.compstr28day = compstr28day;
    }

    public String getMaxWaterCmt() {
        return maxWaterCmt;
    }

    public void setMaxWaterCmt(String maxWaterCmt) {
        this.maxWaterCmt = maxWaterCmt;
    }

    public String getAggSource() {
        return aggSource;
    }

    public void setAggSource(String aggSource) {
        this.aggSource = aggSource;
    }

    public String getSandSource() {
        return sandSource;
    }

    public void setSandSource(String sandSource) {
        this.sandSource = sandSource;
    }

    public String getFlyAsh() {
        return flyAsh;
    }

    public void setFlyAsh(String flyAsh) {
        this.flyAsh = flyAsh;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getMixDesign() {
        return mixDesign;
    }

    public void setMixDesign(String mixDesign) {
        this.mixDesign = mixDesign;
    }

    public BigDecimal getSpecSlumpDesign() {
        return specSlumpDesign;
    }

    public void setSpecSlumpDesign(BigDecimal specSlumpDesign) {
        this.specSlumpDesign = specSlumpDesign;
    }

    public BigDecimal getSpecSlumpSuspension() {
        return specSlumpSuspension;
    }

    public void setSpecSlumpSuspension(BigDecimal specSlumpSuspension) {
        this.specSlumpSuspension = specSlumpSuspension;
    }

    public BigDecimal getSpecSlumpAction() {
        return specSlumpAction;
    }

    public void setSpecSlumpAction(BigDecimal specSlumpAction) {
        this.specSlumpAction = specSlumpAction;
    }

    public BigDecimal getSpecAircontDesign() {
        return specAircontDesign;
    }

    public void setSpecAircontDesign(BigDecimal specAircontDesign) {
        this.specAircontDesign = specAircontDesign;
    }

    public BigDecimal getSpecAircontSuspension() {
        return specAircontSuspension;
    }

    public void setSpecAircontSuspension(BigDecimal specAircontSuspension) {
        this.specAircontSuspension = specAircontSuspension;
    }

    public BigDecimal getSpecAircontAction() {
        return specAircontAction;
    }

    public void setSpecAircontAction(BigDecimal specAircontAction) {
        this.specAircontAction = specAircontAction;
    }

    public BigDecimal getFlexstr28day() {
        return flexstr28day;
    }

    public void setFlexstr28day(BigDecimal flexstr28day) {
        this.flexstr28day = flexstr28day;
    }

    public BigDecimal getReqtk() {
        return reqtk;
    }

    public void setReqtk(BigDecimal reqtk) {
        this.reqtk = reqtk;
    }

    public BigDecimal getSpecFlexAction() {
        return specFlexAction;
    }

    public void setSpecFlexAction(BigDecimal specFlexAction) {
        this.specFlexAction = specFlexAction;
    }

    public BigDecimal getSpecTkAction() {
        return specTkAction;
    }

    public void setSpecTkAction(BigDecimal specTkAction) {
        this.specTkAction = specTkAction;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public BigDecimal getCementAmount() {
        return cementAmount;
    }

    public void setCementAmount(BigDecimal cementAmount) {
        this.cementAmount = cementAmount;
    }

    public BigInteger getSpecConcTempMin() {
        return specConcTempMin;
    }

    public void setSpecConcTempMin(BigInteger specConcTempMin) {
        this.specConcTempMin = specConcTempMin;
    }

    public BigInteger getSpecConcTempMax() {
        return specConcTempMax;
    }

    public void setSpecConcTempMax(BigInteger specConcTempMax) {
        this.specConcTempMax = specConcTempMax;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public BigInteger getMatId() {
        return matId;
    }

    public void setMatId(BigInteger matId) {
        this.matId = matId;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public GlobSupplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(GlobSupplier supplierId) {
        this.supplierId = supplierId;
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

    public BigInteger getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigInteger applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getCompstr56day() {
        return compstr56day;
    }

    public void setCompstr56day(BigDecimal compstr56day) {
        this.compstr56day = compstr56day;
    }

    public BigDecimal getSpecResidualStrength1() {
        return specResidualStrength1;
    }

    public void setSpecResidualStrength1(BigDecimal specResidualStrength1) {
        this.specResidualStrength1 = specResidualStrength1;
    }

    public BigDecimal getSpecResidualStrength2() {
        return specResidualStrength2;
    }

    public void setSpecResidualStrength2(BigDecimal specResidualStrength2) {
        this.specResidualStrength2 = specResidualStrength2;
    }

    public BigDecimal getSpecResidualStrength3() {
        return specResidualStrength3;
    }

    public void setSpecResidualStrength3(BigDecimal specResidualStrength3) {
        this.specResidualStrength3 = specResidualStrength3;
    }

    public String getMixType() {
        return mixType;
    }

    public void setMixType(String mixType) {
        this.mixType = mixType;
    }

    public BigDecimal getLifting() {
        return lifting;
    }

    public void setLifting(BigDecimal lifting) {
        this.lifting = lifting;
    }

    public BigDecimal getBoiledabsorption28day() {
        return boiledabsorption28day;
    }

    public void setBoiledabsorption28day(BigDecimal boiledabsorption28day) {
        this.boiledabsorption28day = boiledabsorption28day;
    }

    public BigDecimal getTensilestr28day() {
        return tensilestr28day;
    }

    public void setTensilestr28day(BigDecimal tensilestr28day) {
        this.tensilestr28day = tensilestr28day;
    }

    public BigDecimal getSpecResidualStrengthPeak() {
        return specResidualStrengthPeak;
    }

    public void setSpecResidualStrengthPeak(BigDecimal specResidualStrengthPeak) {
        this.specResidualStrengthPeak = specResidualStrengthPeak;
    }

    public String getSpecWater() {
        return specWater;
    }

    public void setSpecWater(String specWater) {
        this.specWater = specWater;
    }

    public BigDecimal getAvg7dayStrength() {
        return avg7dayStrength;
    }

    public void setAvg7dayStrength(BigDecimal avg7dayStrength) {
        this.avg7dayStrength = avg7dayStrength;
    }

    public BigDecimal getAvg28dayStrength() {
        return avg28dayStrength;
    }

    public void setAvg28dayStrength(BigDecimal avg28dayStrength) {
        this.avg28dayStrength = avg28dayStrength;
    }

    public BigDecimal getAciReq28dayStrength() {
        return aciReq28dayStrength;
    }

    public void setAciReq28dayStrength(BigDecimal aciReq28dayStrength) {
        this.aciReq28dayStrength = aciReq28dayStrength;
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

    public String getAdmixtureType1() {
        return admixtureType1;
    }

    public void setAdmixtureType1(String admixtureType1) {
        this.admixtureType1 = admixtureType1;
    }

    public String getAdmixtureType2() {
        return admixtureType2;
    }

    public void setAdmixtureType2(String admixtureType2) {
        this.admixtureType2 = admixtureType2;
    }

    public String getAdmixtureType3() {
        return admixtureType3;
    }

    public void setAdmixtureType3(String admixtureType3) {
        this.admixtureType3 = admixtureType3;
    }

    public String getAdmixtureType4() {
        return admixtureType4;
    }

    public void setAdmixtureType4(String admixtureType4) {
        this.admixtureType4 = admixtureType4;
    }

    public String getAdmixtureType5() {
        return admixtureType5;
    }

    public void setAdmixtureType5(String admixtureType5) {
        this.admixtureType5 = admixtureType5;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getSpecFlexSuspension() {
        return specFlexSuspension;
    }

    public void setSpecFlexSuspension(BigDecimal specFlexSuspension) {
        this.specFlexSuspension = specFlexSuspension;
    }

    public BigDecimal getSpecTkSuspension() {
        return specTkSuspension;
    }

    public void setSpecTkSuspension(BigDecimal specTkSuspension) {
        this.specTkSuspension = specTkSuspension;
    }

    public String getMediumAgg() {
        return mediumAgg;
    }

    public void setMediumAgg(String mediumAgg) {
        this.mediumAgg = mediumAgg;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMixdesignDescription() {
        return mixdesignDescription;
    }

    public void setMixdesignDescription(String mixdesignDescription) {
        this.mixdesignDescription = mixdesignDescription;
    }

    public QmCvlFieldData getMaxAggSizeId() {
        return maxAggSizeId;
    }

    public void setMaxAggSizeId(QmCvlFieldData maxAggSizeId) {
        this.maxAggSizeId = maxAggSizeId;
    }

    public BigInteger getDesignCompstrAge() {
        return designCompstrAge;
    }

    public void setDesignCompstrAge(BigInteger designCompstrAge) {
        this.designCompstrAge = designCompstrAge;
    }

    public String getDesignCompstrAgeUnit() {
        return designCompstrAgeUnit;
    }

    public void setDesignCompstrAgeUnit(String designCompstrAgeUnit) {
        this.designCompstrAgeUnit = designCompstrAgeUnit;
    }

    public BigDecimal getDesignSlumpFlowScc() {
        return designSlumpFlowScc;
    }

    public void setDesignSlumpFlowScc(BigDecimal designSlumpFlowScc) {
        this.designSlumpFlowScc = designSlumpFlowScc;
    }

    public BigDecimal getSlag() {
        return slag;
    }

    public void setSlag(BigDecimal slag) {
        this.slag = slag;
    }

    public BigDecimal getSilicaFume() {
        return silicaFume;
    }

    public void setSilicaFume(BigDecimal silicaFume) {
        this.silicaFume = silicaFume;
    }

    public BigDecimal getTotalCementMat() {
        return totalCementMat;
    }

    public void setTotalCementMat(BigDecimal totalCementMat) {
        this.totalCementMat = totalCementMat;
    }

    public String getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(String admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public String getAdmixtureType6() {
        return admixtureType6;
    }

    public void setAdmixtureType6(String admixtureType6) {
        this.admixtureType6 = admixtureType6;
    }

    public String getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(String admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public String getAdmixtureType7() {
        return admixtureType7;
    }

    public void setAdmixtureType7(String admixtureType7) {
        this.admixtureType7 = admixtureType7;
    }

    public String getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(String admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
    }

    public String getAdmixtureType8() {
        return admixtureType8;
    }

    public void setAdmixtureType8(String admixtureType8) {
        this.admixtureType8 = admixtureType8;
    }

    public BigDecimal getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(BigDecimal waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public BigDecimal getTheoreticalAirContent() {
        return theoreticalAirContent;
    }

    public void setTheoreticalAirContent(BigDecimal theoreticalAirContent) {
        this.theoreticalAirContent = theoreticalAirContent;
    }

    public BigDecimal getVolumenPaste() {
        return volumenPaste;
    }

    public void setVolumenPaste(BigDecimal volumenPaste) {
        this.volumenPaste = volumenPaste;
    }

    public BigDecimal getEngLimitSlumpMin() {
        return engLimitSlumpMin;
    }

    public void setEngLimitSlumpMin(BigDecimal engLimitSlumpMin) {
        this.engLimitSlumpMin = engLimitSlumpMin;
    }

    public BigDecimal getEngLimitSlumpMax() {
        return engLimitSlumpMax;
    }

    public void setEngLimitSlumpMax(BigDecimal engLimitSlumpMax) {
        this.engLimitSlumpMax = engLimitSlumpMax;
    }

    public BigDecimal getEngLimitAirContentMin() {
        return engLimitAirContentMin;
    }

    public void setEngLimitAirContentMin(BigDecimal engLimitAirContentMin) {
        this.engLimitAirContentMin = engLimitAirContentMin;
    }

    public BigDecimal getEngLimitAirContentMax() {
        return engLimitAirContentMax;
    }

    public void setEngLimitAirContentMax(BigDecimal engLimitAirContentMax) {
        this.engLimitAirContentMax = engLimitAirContentMax;
    }

    public BigDecimal getSpecLimitCompstrMin() {
        return specLimitCompstrMin;
    }

    public void setSpecLimitCompstrMin(BigDecimal specLimitCompstrMin) {
        this.specLimitCompstrMin = specLimitCompstrMin;
    }

    public BigDecimal getSpecLimitCompstrMax() {
        return specLimitCompstrMax;
    }

    public void setSpecLimitCompstrMax(BigDecimal specLimitCompstrMax) {
        this.specLimitCompstrMax = specLimitCompstrMax;
    }

    public BigDecimal getEngLimitCompstrMin() {
        return engLimitCompstrMin;
    }

    public void setEngLimitCompstrMin(BigDecimal engLimitCompstrMin) {
        this.engLimitCompstrMin = engLimitCompstrMin;
    }

    public BigDecimal getEngLimitCompstrMax() {
        return engLimitCompstrMax;
    }

    public void setEngLimitCompstrMax(BigDecimal engLimitCompstrMax) {
        this.engLimitCompstrMax = engLimitCompstrMax;
    }

    public BigDecimal getSpecLimitSlumpFlowsccMin() {
        return specLimitSlumpFlowsccMin;
    }

    public void setSpecLimitSlumpFlowsccMin(BigDecimal specLimitSlumpFlowsccMin) {
        this.specLimitSlumpFlowsccMin = specLimitSlumpFlowsccMin;
    }

    public BigDecimal getSpecLimitSlumpFlowsccMax() {
        return specLimitSlumpFlowsccMax;
    }

    public void setSpecLimitSlumpFlowsccMax(BigDecimal specLimitSlumpFlowsccMax) {
        this.specLimitSlumpFlowsccMax = specLimitSlumpFlowsccMax;
    }

    public BigDecimal getEngLimitSlumpFlowsccMin() {
        return engLimitSlumpFlowsccMin;
    }

    public void setEngLimitSlumpFlowsccMin(BigDecimal engLimitSlumpFlowsccMin) {
        this.engLimitSlumpFlowsccMin = engLimitSlumpFlowsccMin;
    }

    public BigDecimal getEngLimitSlumpFlowsccMax() {
        return engLimitSlumpFlowsccMax;
    }

    public void setEngLimitSlumpFlowsccMax(BigDecimal engLimitSlumpFlowsccMax) {
        this.engLimitSlumpFlowsccMax = engLimitSlumpFlowsccMax;
    }

    public BigDecimal getTrialOverdesignCompstrMin() {
        return trialOverdesignCompstrMin;
    }

    public void setTrialOverdesignCompstrMin(BigDecimal trialOverdesignCompstrMin) {
        this.trialOverdesignCompstrMin = trialOverdesignCompstrMin;
    }

    public BigDecimal getTrialOverdesignCompstrMax() {
        return trialOverdesignCompstrMax;
    }

    public void setTrialOverdesignCompstrMax(BigDecimal trialOverdesignCompstrMax) {
        this.trialOverdesignCompstrMax = trialOverdesignCompstrMax;
    }

    public BigInteger getDesignTensileStrAge() {
        return designTensileStrAge;
    }

    public void setDesignTensileStrAge(BigInteger designTensileStrAge) {
        this.designTensileStrAge = designTensileStrAge;
    }

    public String getDesignTensileStrAgeUnit() {
        return designTensileStrAgeUnit;
    }

    public void setDesignTensileStrAgeUnit(String designTensileStrAgeUnit) {
        this.designTensileStrAgeUnit = designTensileStrAgeUnit;
    }

    public BigInteger getDesignFlexStrAge() {
        return designFlexStrAge;
    }

    public void setDesignFlexStrAge(BigInteger designFlexStrAge) {
        this.designFlexStrAge = designFlexStrAge;
    }

    public String getDesignFlexStrAgeUnit() {
        return designFlexStrAgeUnit;
    }

    public void setDesignFlexStrAgeUnit(String designFlexStrAgeUnit) {
        this.designFlexStrAgeUnit = designFlexStrAgeUnit;
    }

    public BigDecimal getSpecLimitTensileStrMin() {
        return specLimitTensileStrMin;
    }

    public void setSpecLimitTensileStrMin(BigDecimal specLimitTensileStrMin) {
        this.specLimitTensileStrMin = specLimitTensileStrMin;
    }

    public BigDecimal getSpecLimitTensileStrMax() {
        return specLimitTensileStrMax;
    }

    public void setSpecLimitTensileStrMax(BigDecimal specLimitTensileStrMax) {
        this.specLimitTensileStrMax = specLimitTensileStrMax;
    }

    public BigDecimal getEngLimitTensileStrMin() {
        return engLimitTensileStrMin;
    }

    public void setEngLimitTensileStrMin(BigDecimal engLimitTensileStrMin) {
        this.engLimitTensileStrMin = engLimitTensileStrMin;
    }

    public BigDecimal getEngLimitTensileStrMax() {
        return engLimitTensileStrMax;
    }

    public void setEngLimitTensileStrMax(BigDecimal engLimitTensileStrMax) {
        this.engLimitTensileStrMax = engLimitTensileStrMax;
    }

    public BigDecimal getSpecLimitFlexStrMin() {
        return specLimitFlexStrMin;
    }

    public void setSpecLimitFlexStrMin(BigDecimal specLimitFlexStrMin) {
        this.specLimitFlexStrMin = specLimitFlexStrMin;
    }

    public BigDecimal getSpecLimitFlexStrMax() {
        return specLimitFlexStrMax;
    }

    public void setSpecLimitFlexStrMax(BigDecimal specLimitFlexStrMax) {
        this.specLimitFlexStrMax = specLimitFlexStrMax;
    }

    public BigDecimal getEngLimitFlexStrMin() {
        return engLimitFlexStrMin;
    }

    public void setEngLimitFlexStrMin(BigDecimal engLimitFlexStrMin) {
        this.engLimitFlexStrMin = engLimitFlexStrMin;
    }

    public BigDecimal getEngLimitFlexStrMax() {
        return engLimitFlexStrMax;
    }

    public void setEngLimitFlexStrMax(BigDecimal engLimitFlexStrMax) {
        this.engLimitFlexStrMax = engLimitFlexStrMax;
    }

    public BigInteger getMasterRefId() {
        return masterRefId;
    }

    public void setMasterRefId(BigInteger masterRefId) {
        this.masterRefId = masterRefId;
    }

    public String getCanbeDeleted() {
        return canbeDeleted;
    }

    public void setCanbeDeleted(String canbeDeleted) {
        this.canbeDeleted = canbeDeleted;
    }

    public GlobSupplierAddress getSupplierLocId() {
        return supplierLocId;
    }

    public void setSupplierLocId(GlobSupplierAddress supplierLocId) {
        this.supplierLocId = supplierLocId;
    }

    public String getAggSource1() {
        return aggSource1;
    }

    public void setAggSource1(String aggSource1) {
        this.aggSource1 = aggSource1;
    }

    public String getAggSource2() {
        return aggSource2;
    }

    public void setAggSource2(String aggSource2) {
        this.aggSource2 = aggSource2;
    }

    public String getSandSource1() {
        return sandSource1;
    }

    public void setSandSource1(String sandSource1) {
        this.sandSource1 = sandSource1;
    }

    public String getSandSource2() {
        return sandSource2;
    }

    public void setSandSource2(String sandSource2) {
        this.sandSource2 = sandSource2;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(maxAggSizeId)
                .append(concreteClass)
                .append(specSlumpMin)
                .append(specSlumpMax)
                .append(specAircontMin)
                .append(specAircontMax)
                .append(compstr28day)
                .append(maxWaterCmt)
                .append(aggSource)
                .append(aggSource1)
                .append(aggSource2)
                .append(sandSource)
                .append(sandSource1)
                .append(sandSource2)
                .append(flyAsh)
                .append(specSlumpDesign)
                .append(specSlumpSuspension)
                .append(specSlumpAction)
                .append(specAircontDesign)
                .append(specAircontSuspension)
                .append(specAircontAction)
                .append(flexstr28day)
                .append(reqtk)
                .append(specFlexAction)
                .append(specTkAction)
                .append(cementAmount)
                .append(specConcTempMin)
                .append(specConcTempMax)
                .append(admixtureQty1)
                .append(admixtureQty2)
                .append(admixtureQty3)
                .append(superplasticizer)
                .append(compstr56day)
                .append(specResidualStrength1)
                .append(specResidualStrength2)
                .append(specResidualStrength3)
                .append(lifting)
                .append(boiledabsorption28day)
                .append(tensilestr28day)
                .append(specResidualStrengthPeak)
                .append(specWater)
                .append(avg7dayStrength)
                .append(avg28dayStrength)
                .append(aciReq28dayStrength)
                .append(admixtureQty4)
                .append(admixtureQty5)
                .append(admixtureType1)
                .append(admixtureType2)
                .append(admixtureType3)
                .append(admixtureType4)
                .append(admixtureType5)
                .append(specFlexSuspension)
                .append(specTkSuspension)
                .append(mediumAgg)
                .append(designCompstrAge)
                .append(designCompstrAgeUnit)
                .append(designSlumpFlowScc)
                .append(slag)
                .append(silicaFume)
                .append(totalCementMat)
                .append(admixtureQty6)
                .append(admixtureType6)
                .append(admixtureQty7)
                .append(admixtureType7)
                .append(admixtureQty8)
                .append(admixtureType8)
                .append(waterCementRatio)
                .append(theoreticalAirContent)
                .append(volumenPaste)
                .append(engLimitSlumpMin)
                .append(engLimitSlumpMax)
                .append(engLimitAirContentMin)
                .append(engLimitAirContentMax)
                .append(specLimitCompstrMin)
                .append(specLimitCompstrMax)
                .append(engLimitCompstrMin)
                .append(engLimitCompstrMax)
                .append(specLimitSlumpFlowsccMin)
                .append(specLimitSlumpFlowsccMax)
                .append(engLimitSlumpFlowsccMin)
                .append(engLimitSlumpFlowsccMax)
                .append(trialOverdesignCompstrMin)
                .append(trialOverdesignCompstrMax)
                .append(designTensileStrAge)
                .append(designTensileStrAgeUnit)
                .append(designFlexStrAge)
                .append(designFlexStrAgeUnit)
                .append(specLimitTensileStrMin)
                .append(specLimitTensileStrMax)
                .append(engLimitTensileStrMin)
                .append(engLimitTensileStrMax)
                .append(specLimitFlexStrMin)
                .append(specLimitFlexStrMax)
                .append(engLimitFlexStrMin)
                .append(engLimitFlexStrMax)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaconcMixdesigns)) {
            return false;
        }
        QaconcMixdesigns other = (QaconcMixdesigns) object;
        return new EqualsBuilder()
                .append(this.maxAggSizeId, other.maxAggSizeId)
                .append(this.concreteClass, other.concreteClass)
                .append(this.specSlumpMin, other.specSlumpMin)
                .append(this.specSlumpMax, other.specSlumpMax)
                .append(this.specAircontMin, other.specAircontMin)
                .append(this.specAircontMax, other.specAircontMax)
                .append(this.compstr28day, other.compstr28day)
                .append(this.maxWaterCmt, other.maxWaterCmt)
                .append(this.aggSource, other.aggSource)
                .append(this.aggSource1, other.aggSource1)
                .append(this.aggSource2, other.aggSource2)
                .append(this.sandSource, other.sandSource)
                .append(this.sandSource1, other.sandSource1)
                .append(this.sandSource2, other.sandSource2)
                .append(this.flyAsh, other.flyAsh)
                .append(this.specSlumpDesign, other.specSlumpDesign)
                .append(this.specSlumpSuspension, other.specSlumpSuspension)
                .append(this.specSlumpAction, other.specSlumpAction)
                .append(this.specAircontDesign, other.specAircontDesign)
                .append(this.specAircontSuspension, other.specAircontSuspension)
                .append(this.specAircontAction, other.specAircontAction)
                .append(this.flexstr28day, other.flexstr28day)
                .append(this.reqtk, other.reqtk)
                .append(this.specFlexAction, other.specFlexAction)
                .append(this.specTkAction, other.specTkAction)
                .append(this.cementAmount, other.cementAmount)
                .append(this.specConcTempMin, other.specConcTempMin)
                .append(this.specConcTempMax, other.specConcTempMax)
                .append(this.admixtureQty1, other.admixtureQty1)
                .append(this.admixtureQty2, other.admixtureQty2)
                .append(this.admixtureQty3, other.admixtureQty3)
                .append(this.superplasticizer, other.superplasticizer)
                .append(this.compstr56day, other.compstr56day)
                .append(this.specResidualStrength1, other.specResidualStrength1)
                .append(this.specResidualStrength2, other.specResidualStrength2)
                .append(this.specResidualStrength3, other.specResidualStrength3)
                .append(this.lifting, other.lifting)
                .append(this.boiledabsorption28day, other.boiledabsorption28day)
                .append(this.tensilestr28day, other.tensilestr28day)
                .append(this.specResidualStrengthPeak, other.specResidualStrengthPeak)
                .append(this.specWater, other.specWater)
                .append(this.avg7dayStrength, other.avg7dayStrength)
                .append(this.avg28dayStrength, other.avg28dayStrength)
                .append(this.aciReq28dayStrength, other.aciReq28dayStrength)
                .append(this.admixtureQty4, other.admixtureQty4)
                .append(this.admixtureQty5, other.admixtureQty5)
                .append(this.admixtureType1, other.admixtureType1)
                .append(this.admixtureType2, other.admixtureType2)
                .append(this.admixtureType3, other.admixtureType3)
                .append(this.admixtureType4, other.admixtureType4)
                .append(this.admixtureType5, other.admixtureType5)
                .append(this.specFlexSuspension, other.specFlexSuspension)
                .append(this.specTkSuspension, other.specTkSuspension)
                .append(this.mediumAgg, other.mediumAgg)
                .append(this.designCompstrAge, other.designCompstrAge)
                .append(this.designCompstrAgeUnit, other.designCompstrAgeUnit)
                .append(this.designSlumpFlowScc, other.designSlumpFlowScc)
                .append(this.slag, other.slag)
                .append(this.silicaFume, other.silicaFume)
                .append(this.totalCementMat, other.totalCementMat)
                .append(this.admixtureQty6, other.admixtureQty6)
                .append(this.admixtureType6, other.admixtureType6)
                .append(this.admixtureQty7, other.admixtureQty7)
                .append(this.admixtureType7, other.admixtureType7)
                .append(this.admixtureQty8, other.admixtureQty8)
                .append(this.admixtureType8, other.admixtureType8)
                .append(this.waterCementRatio, other.waterCementRatio)
                .append(this.theoreticalAirContent, other.theoreticalAirContent)
                .append(this.volumenPaste, other.volumenPaste)
                .append(this.engLimitSlumpMin, other.engLimitSlumpMin)
                .append(this.engLimitSlumpMax, other.engLimitSlumpMax)
                .append(this.engLimitAirContentMin, other.engLimitAirContentMin)
                .append(this.engLimitAirContentMax, other.engLimitAirContentMax)
                .append(this.specLimitCompstrMin, other.specLimitCompstrMin)
                .append(this.specLimitCompstrMax, other.specLimitCompstrMax)
                .append(this.engLimitCompstrMin, other.engLimitCompstrMin)
                .append(this.engLimitCompstrMax, other.engLimitCompstrMax)
                .append(this.specLimitSlumpFlowsccMin, other.specLimitSlumpFlowsccMin)
                .append(this.specLimitSlumpFlowsccMax, other.specLimitSlumpFlowsccMax)
                .append(this.engLimitSlumpFlowsccMin, other.engLimitSlumpFlowsccMin)
                .append(this.engLimitSlumpFlowsccMax, other.engLimitSlumpFlowsccMax)
                .append(this.trialOverdesignCompstrMin, other.trialOverdesignCompstrMin)
                .append(this.trialOverdesignCompstrMax, other.trialOverdesignCompstrMax)
                .append(this.designTensileStrAge, other.designTensileStrAge)
                .append(this.designTensileStrAgeUnit, other.designTensileStrAgeUnit)
                .append(this.designFlexStrAge, other.designFlexStrAge)
                .append(this.designFlexStrAgeUnit, other.designFlexStrAgeUnit)
                .append(this.specLimitTensileStrMin, other.specLimitTensileStrMin)
                .append(this.specLimitTensileStrMax, other.specLimitTensileStrMax)
                .append(this.engLimitTensileStrMin, other.engLimitTensileStrMin)
                .append(this.engLimitTensileStrMax, other.engLimitTensileStrMax)
                .append(this.specLimitFlexStrMin, other.specLimitFlexStrMin)
                .append(this.specLimitFlexStrMax, other.specLimitFlexStrMax)
                .append(this.engLimitFlexStrMin, other.engLimitFlexStrMin)
                .append(this.engLimitFlexStrMax, other.engLimitFlexStrMax)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcMixdesigns[ id=" + id + " ]";
    }
    
    public QaconcMixdesignsTO generateTO() {
        QaconcMixdesignsTO to = new QaconcMixdesignsTO();
        to.setMixdesignNo(getMixDesign());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier(): "");
        to.setSupplierLoc(getSupplierLocId() != null ? getSupplierLocId().getLocation(): "");
        to.setMixdesignType(getMixType());
        to.setMixdesignDescription(getMixdesignDescription());
        to.setMixdesignRemark(getRemarks());
        to.setMaxAggSizeId(getMaxAggSizeId() != null ? getMaxAggSizeId().getValue(): "");
        to.setDesignCompstr(StringSupport.getString(getAvg28dayStrength()));
        to.setDesignCompstrAge(StringSupport.getString(getDesignCompstrAge()));
        to.setDesignCompstrAgeUnit(getDesignCompstrAgeUnit());
        to.setDesignSlump(StringSupport.getString(getSpecSlumpDesign()) );
        to.setDesignSlumpFlowScc(StringSupport.getString(getDesignSlumpFlowScc()));
        to.setDesignAirContent(StringSupport.getString(getSpecAircontDesign()));
        to.setTotalCoarseAgg(StringSupport.getString(getAggSource()));
        to.setCoarseAgg1(StringSupport.getString(getAggSource1()));
        to.setCoarseAgg2(StringSupport.getString(getAggSource2()));
        to.setTotalFineAgg(StringSupport.getString(getSandSource()));
        to.setFineAgg1(StringSupport.getString(getSandSource1()));
        to.setFineAgg2(StringSupport.getString(getSandSource2()));
        to.setCement(StringSupport.getString(getCementAmount()));
        to.setFlyAsh(StringSupport.getString(getFlyAsh()));
        to.setSlag(StringSupport.getString(getSlag()));
        to.setSilicaFume(StringSupport.getString(getSilicaFume()));
        to.setTotalCementMat(StringSupport.getString(getTotalCementMat()));
        to.setWater(StringSupport.getString(getSpecWater()));
        to.setAdmixtureQty1(StringSupport.getString(getAdmixtureQty1()));
        to.setAdmixtureType1(getAdmixtureType1());
        to.setAdmixtureQty2(StringSupport.getString(getAdmixtureQty2()));
        to.setAdmixtureType2(getAdmixtureType2());
        to.setAdmixtureQty3(StringSupport.getString(getAdmixtureQty3()));
        to.setAdmixtureType3(getAdmixtureType3());
        to.setAdmixtureQty4(StringSupport.getString(getAdmixtureQty4()));
        to.setAdmixtureType4(getAdmixtureType4());
        to.setAdmixtureQty5(StringSupport.getString(getAdmixtureQty5()));
        to.setAdmixtureType5(getAdmixtureType5());
        to.setAdmixtureQty6(StringSupport.getString(getAdmixtureQty6()));
        to.setAdmixtureType6(getAdmixtureType6());
        to.setAdmixtureQty7(StringSupport.getString(getAdmixtureQty7()));
        to.setAdmixtureType7(getAdmixtureType7());
        to.setAdmixtureQty8(StringSupport.getString(getAdmixtureQty8()));
        to.setAdmixtureType8(getAdmixtureType8());
        to.setWaterCementRatio(StringSupport.getString(getWaterCementRatio()));
        to.setWaterCementMax(StringSupport.getString(getMaxWaterCmt()));
        to.setTheoreticalAirContent(StringSupport.getString(getTheoreticalAirContent()));
        to.setVolumenPaste(StringSupport.getString(getVolumenPaste()));
        to.setSpecLimitSlumpMin(StringSupport.getString(getSpecSlumpMin()));
        to.setSpecLimitSlumpMax(StringSupport.getString(getSpecSlumpMax()));
        to.setEngLimitSlumpMin(StringSupport.getString(getEngLimitSlumpMin()));
        to.setEngLimitSlumpMax(StringSupport.getString(getEngLimitSlumpMax()));
        to.setSpecLimitAirContentMin(StringSupport.getString(getSpecAircontMin()));
        to.setSpecLimitAirContentMax(StringSupport.getString(getSpecAircontMax()));
        to.setEngLimitAirContentMin(StringSupport.getString(getEngLimitAirContentMin()));
        to.setEngLimitAirContentMax(StringSupport.getString(getEngLimitAirContentMax()));
        to.setSpecLimitCompstrMin(StringSupport.getString(getSpecLimitCompstrMin()));
        to.setSpecLimitCompstrMax(StringSupport.getString(getSpecLimitCompstrMax()));
        to.setEngLimitCompstrMin(StringSupport.getString(getEngLimitCompstrMin()));
        to.setEngLimitCompstrMax(StringSupport.getString(getEngLimitCompstrMax()));
        to.setSpecLimitSlumpFlowsccMin(StringSupport.getString(getSpecLimitSlumpFlowsccMin()));
        to.setSpecLimitSlumpFlowsccMax(StringSupport.getString(getSpecLimitSlumpFlowsccMax()));
        to.setEngLimitSlumpFlowsccMin(StringSupport.getString(getEngLimitSlumpFlowsccMin()));
        to.setEngLimitSlumpFlowsccMax(StringSupport.getString(getEngLimitSlumpFlowsccMax()));
        to.setTrialOverdesignCompstrMin(StringSupport.getString(getTrialOverdesignCompstrMin()));
        to.setTrialOverdesignCompstrMax(StringSupport.getString(getTrialOverdesignCompstrMax()));
        to.setDesignTensileStr(StringSupport.getString(getTensilestr28day()));
        to.setDesignTensileStrAge(StringSupport.getString(getDesignTensileStrAge()));
        to.setDesignTensileStrAgeUnit(getDesignTensileStrAgeUnit());
        to.setDesignFlexStr(StringSupport.getString(getFlexstr28day()));
        to.setDesignFlexStrAge(StringSupport.getString(getDesignFlexStrAge()));
        to.setDesignFlexStrAgeUnit(getDesignFlexStrAgeUnit());
        to.setSpecLimitTensileStrMin(StringSupport.getString(getSpecLimitTensileStrMin()));
        to.setSpecLimitTensileStrMax(StringSupport.getString(getSpecLimitTensileStrMax()));
        to.setEngLimitTensileStrMin(StringSupport.getString(getEngLimitTensileStrMin()));
        to.setEngLimitTensileStrMax(StringSupport.getString(getEngLimitTensileStrMax()));
        to.setSpecLimitFlexStrMin(StringSupport.getString(getSpecLimitFlexStrMin()));
        to.setSpecLimitFlexStrMax(StringSupport.getString(getSpecLimitFlexStrMax()));
        to.setEngLimitFlexStrMin(StringSupport.getString(getEngLimitFlexStrMin()));
        to.setEngLimitFlexStrMax(StringSupport.getString(getEngLimitFlexStrMax()));
        to.setConcreteClass(getConcreteClass());
        to.setSpecSlumpSuspension(StringSupport.getString(getSpecSlumpSuspension()));
        to.setSpecSlumpAction(StringSupport.getString(getSpecSlumpAction()));
        to.setSpecAircontentSuspension(StringSupport.getString(getSpecAircontSuspension()));
        to.setSpecAircontentAction(StringSupport.getString(getSpecAircontAction()));
        to.setReqtk(StringSupport.getString(getReqtk()));
        to.setSpecFlexSuspension(StringSupport.getString(getSpecFlexSuspension()));
        to.setSpecFlexAction(StringSupport.getString(getSpecFlexAction()));
        to.setSpecTkSuspension(StringSupport.getString(getSpecTkSuspension()));
        to.setSpecTkAction(StringSupport.getString(getSpecTkAction()));
        to.setSpecConcTempMin(StringSupport.getString(getSpecConcTempMin()));
        to.setSpecConcTempMax(StringSupport.getString(getSpecConcTempMax()));
        to.setSpecResidualStr1(StringSupport.getString(getSpecResidualStrength1()));
        to.setSpecResidualStr2(StringSupport.getString(getSpecResidualStrength2()));
        to.setSpecResidualStr3(StringSupport.getString(getSpecResidualStrength3()));
        to.setSpecResidualStrPeak(StringSupport.getString(getSpecResidualStrengthPeak()));
        to.setBoiledabsorption(StringSupport.getString(getBoiledabsorption28day()));
        return to;
    }
    
    public QaconcMixDesignsLogTO generateLogTO() {
        QaconcMixDesignsLogTO to = new QaconcMixDesignsLogTO();
        to.setMixdesignNo(getMixDesign());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier(): "");
        to.setLocation(getSupplierLocId() != null ? getSupplierLocId().getLocation(): "");
        to.setMixdesignType(getMixType());
        to.setCreated(getCreateDate());
        to.setStatus(getActive() != null && getActive() == 'Y' ? "ACTIVE": "INACTIVE");
        return to;
    }

}
