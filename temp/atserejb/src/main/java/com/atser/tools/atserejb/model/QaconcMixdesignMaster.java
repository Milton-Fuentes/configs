/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaconcMixdesignsTO;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
@NamedQuery(name = "QaconcMixdesignMaster.findByClientId", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByMixdesignNo", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.mixdesignNo = :mixdesignNo"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySupplierId", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByMixdesignType", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.mixdesignType = :mixdesignType"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByMixdesignRemark", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.mixdesignRemark = :mixdesignRemark"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByMaxAggSizeId", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.maxAggSizeId = :maxAggSizeId"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignCompstr", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designCompstr = :designCompstr"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignCompstrAge", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designCompstrAge = :designCompstrAge"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignCompstrAgeUnit", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designCompstrAgeUnit = :designCompstrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignSlump", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designSlump = :designSlump"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignSlumpFlowScc", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designSlumpFlowScc = :designSlumpFlowScc"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignAirContent", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designAirContent = :designAirContent"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTotalCoarseAgg", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.totalCoarseAgg = :totalCoarseAgg"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTotalFineAgg", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.totalFineAgg = :totalFineAgg"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByCement", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.cement = :cement"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByFlyAsh", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.flyAsh = :flyAsh"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySlag", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.slag = :slag"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySilicaFume", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.silicaFume = :silicaFume"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTotalCementMat", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.totalCementMat = :totalCementMat"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByWater", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.water = :water"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty1", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty1 = :admixtureQty1"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType1", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType1 = :admixtureType1"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty2", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty2 = :admixtureQty2"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType2", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType2 = :admixtureType2"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty3", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty3 = :admixtureQty3"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType3", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType3 = :admixtureType3"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty4", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty4 = :admixtureQty4"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType4", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType4 = :admixtureType4"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty5", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty5 = :admixtureQty5"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType5", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType5 = :admixtureType5"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty6", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty6 = :admixtureQty6"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType6", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType6 = :admixtureType6"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty7", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty7 = :admixtureQty7"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType7", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType7 = :admixtureType7"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureQty8", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureQty8 = :admixtureQty8"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByAdmixtureType8", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.admixtureType8 = :admixtureType8"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByWaterCementRatio", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.waterCementRatio = :waterCementRatio"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByWaterCementMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.waterCementMax = :waterCementMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTheoreticalAirContent", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.theoreticalAirContent = :theoreticalAirContent"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByVolumenPaste", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.volumenPaste = :volumenPaste"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitSlumpMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitSlumpMin = :specLimitSlumpMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitSlumpMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitSlumpMax = :specLimitSlumpMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitSlumpMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitSlumpMin = :engLimitSlumpMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitSlumpMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitSlumpMax = :engLimitSlumpMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitAirContentMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitAirContentMin = :specLimitAirContentMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitAirContentMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitAirContentMax = :specLimitAirContentMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitAirContentMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitAirContentMin = :engLimitAirContentMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitAirContentMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitAirContentMax = :engLimitAirContentMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitCompstrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitCompstrMin = :specLimitCompstrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitCompstrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitCompstrMax = :specLimitCompstrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitCompstrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitCompstrMin = :engLimitCompstrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitCompstrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitCompstrMax = :engLimitCompstrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitSlumpFlowsccMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitSlumpFlowsccMin = :specLimitSlumpFlowsccMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitSlumpFlowsccMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitSlumpFlowsccMax = :specLimitSlumpFlowsccMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitSlumpFlowsccMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitSlumpFlowsccMin = :engLimitSlumpFlowsccMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitSlumpFlowsccMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitSlumpFlowsccMax = :engLimitSlumpFlowsccMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTrialOverdesignCompstrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.trialOverdesignCompstrMin = :trialOverdesignCompstrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByTrialOverdesignCompstrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.trialOverdesignCompstrMax = :trialOverdesignCompstrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignTensileStr", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designTensileStr = :designTensileStr"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignTensileStrAge", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designTensileStrAge = :designTensileStrAge"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignTensileStrAgeUnit", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designTensileStrAgeUnit = :designTensileStrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignFlexStr", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designFlexStr = :designFlexStr"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignFlexStrAge", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designFlexStrAge = :designFlexStrAge"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDesignFlexStrAgeUnit", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.designFlexStrAgeUnit = :designFlexStrAgeUnit"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitTensileStrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitTensileStrMin = :specLimitTensileStrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitTensileStrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitTensileStrMax = :specLimitTensileStrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitTensileStrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitTensileStrMin = :engLimitTensileStrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitTensileStrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitTensileStrMax = :engLimitTensileStrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitFlexStrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitFlexStrMin = :specLimitFlexStrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecLimitFlexStrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specLimitFlexStrMax = :specLimitFlexStrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitFlexStrMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitFlexStrMin = :engLimitFlexStrMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByEngLimitFlexStrMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.engLimitFlexStrMax = :engLimitFlexStrMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByConcreteClass", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.concreteClass = :concreteClass"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecSlumpSuspension", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specSlumpSuspension = :specSlumpSuspension"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecSlumpAction", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specSlumpAction = :specSlumpAction"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecAircontentSuspension", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specAircontentSuspension = :specAircontentSuspension"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecAircontentAction", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specAircontentAction = :specAircontentAction"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByReqtk", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.reqtk = :reqtk"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecFlexSuspension", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specFlexSuspension = :specFlexSuspension"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecFlexAction", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specFlexAction = :specFlexAction"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecTkSuspension", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specTkSuspension = :specTkSuspension"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecTkAction", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specTkAction = :specTkAction"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecConcTempMin", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specConcTempMin = :specConcTempMin"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecConcTempMax", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specConcTempMax = :specConcTempMax"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecResidualStr1", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specResidualStr1 = :specResidualStr1"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecResidualStr2", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specResidualStr2 = :specResidualStr2"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecResidualStr3", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specResidualStr3 = :specResidualStr3"),
    @NamedQuery(name = "QaconcMixdesignMaster.findBySpecResidualStrPeak", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.specResidualStrPeak = :specResidualStrPeak"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByBoiledabsorption", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.boiledabsorption = :boiledabsorption"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByApprovedDate", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.approvedDate = :approvedDate"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByExpirationDate", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.expirationDate = :expirationDate"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByCreated", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.created = :created"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByCreatedBy", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByCreatedByIp", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByLastMod", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByLastModIp", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByFolderId", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.folderId = :folderId"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByStatus", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.status = :status"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByDeleted", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByActive", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByVersion", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QACONC_MIXDESIGN_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QACONC_MIXDESIGN_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcMixdesignMaster.findAll", query = "SELECT q FROM QaconcMixdesignMaster q"),
    @NamedQuery(name = "QaconcMixdesignMaster.findById", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.id = :id"),
    @NamedQuery(name = "QaconcMixdesignMaster.findByMixDesignNo", query = "SELECT q FROM QaconcMixdesignMaster q WHERE q.mixdesignNo = :mixdesignNo AND q.clientId = :clientId")})
public class QaconcMixdesignMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_MIXDESIGN_MASTER_SEQ", sequenceName = "QACONC_MIXDESIGN_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_MIXDESIGN_MASTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MIXDESIGN_NO")
    private String mixdesignNo;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(optional = false)
    private GlobSupplier supplierId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_LOC_ID")
    @ManyToOne(optional = true)
    private GlobSupplierAddress supplierLocId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "MIXDESIGN_TYPE")
    @ManyToOne(optional = false)
    private QmCvlFieldData mixdesignType;
    @Lob
    @Column(name = "MIXDESIGN_DESCRIPTION")
    private String mixdesignDescription;
    @Size(max = 500)
    @Column(name = "MIXDESIGN_REMARK")
    private String mixdesignRemark;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "MAX_AGG_SIZE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData maxAggSizeId;
    @Column(name = "DESIGN_COMPSTR")
    private BigDecimal designCompstr;
    @Column(name = "DESIGN_COMPSTR_AGE")
    private BigInteger designCompstrAge;
    @Size(max = 50)
    @Column(name = "DESIGN_COMPSTR_AGE_UNIT")
    private String designCompstrAgeUnit;
    @Column(name = "DESIGN_SLUMP")
    private BigDecimal designSlump;
    @Column(name = "DESIGN_SLUMP_FLOW_SCC")
    private BigDecimal designSlumpFlowScc;
    @Column(name = "DESIGN_AIR_CONTENT")
    private BigDecimal designAirContent;
    @Column(name = "COARSE_AGG1")
    private BigDecimal coarseAgg1;
    @Column(name = "COARSE_AGG2")
    private BigDecimal coarseAgg2;
    @Column(name = "TOTAL_COARSE_AGG")
    private BigDecimal totalCoarseAgg;
    @Column(name = "FINE_AGG1")
    private BigDecimal fineAgg1;
    @Column(name = "FINE_AGG2")
    private BigDecimal fineAgg2;
    @Column(name = "TOTAL_FINE_AGG")
    private BigDecimal totalFineAgg;
    @Column(name = "CEMENT")
    private BigDecimal cement;
    @Column(name = "FLY_ASH")
    private BigDecimal flyAsh;
    @Column(name = "SLAG")
    private BigDecimal slag;
    @Column(name = "SILICA_FUME")
    private BigDecimal silicaFume;
    @Column(name = "TOTAL_CEMENT_MAT")
    private BigDecimal totalCementMat;
    @Column(name = "WATER")
    private BigDecimal water;
    @Column(name = "ADMIXTURE_QTY1")
    private BigDecimal admixtureQty1;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE1")
    private String admixtureType1;
    @Column(name = "ADMIXTURE_QTY2")
    private BigDecimal admixtureQty2;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE2")
    private String admixtureType2;
    @Column(name = "ADMIXTURE_QTY3")
    private BigDecimal admixtureQty3;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE3")
    private String admixtureType3;
    @Column(name = "ADMIXTURE_QTY4")
    private BigDecimal admixtureQty4;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE4")
    private String admixtureType4;
    @Column(name = "ADMIXTURE_QTY5")
    private BigDecimal admixtureQty5;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE5")
    private String admixtureType5;
    @Column(name = "ADMIXTURE_QTY6")
    private BigDecimal admixtureQty6;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE6")
    private String admixtureType6;
    @Column(name = "ADMIXTURE_QTY7")
    private BigDecimal admixtureQty7;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE7")
    private String admixtureType7;
    @Column(name = "ADMIXTURE_QTY8")
    private BigDecimal admixtureQty8;
    @Size(max = 100)
    @Column(name = "ADMIXTURE_TYPE8")
    private String admixtureType8;
    @Column(name = "WATER_CEMENT_RATIO")
    private BigDecimal waterCementRatio;
    @Column(name = "WATER_CEMENT_MAX")
    private BigDecimal waterCementMax;
    @Column(name = "THEORETICAL_AIR_CONTENT")
    private BigDecimal theoreticalAirContent;
    @Column(name = "VOLUMEN_PASTE")
    private BigDecimal volumenPaste;
    @Column(name = "SPEC_LIMIT_SLUMP_MIN")
    private BigDecimal specLimitSlumpMin;
    @Column(name = "SPEC_LIMIT_SLUMP_MAX")
    private BigDecimal specLimitSlumpMax;
    @Column(name = "ENG_LIMIT_SLUMP_MIN")
    private BigDecimal engLimitSlumpMin;
    @Column(name = "ENG_LIMIT_SLUMP_MAX")
    private BigDecimal engLimitSlumpMax;
    @Column(name = "SPEC_LIMIT_AIR_CONTENT_MIN")
    private BigDecimal specLimitAirContentMin;
    @Column(name = "SPEC_LIMIT_AIR_CONTENT_MAX")
    private BigDecimal specLimitAirContentMax;
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
    @Column(name = "DESIGN_TENSILE_STR")
    private BigDecimal designTensileStr;
    @Column(name = "DESIGN_TENSILE_STR_AGE")
    private BigInteger designTensileStrAge;
    @Size(max = 50)
    @Column(name = "DESIGN_TENSILE_STR_AGE_UNIT")
    private String designTensileStrAgeUnit;
    @Column(name = "DESIGN_FLEX_STR")
    private BigDecimal designFlexStr;
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
    @Size(max = 100)
    @Column(name = "CONCRETE_CLASS")
    private String concreteClass;
    @Column(name = "SPEC_SLUMP_SUSPENSION")
    private BigDecimal specSlumpSuspension;
    @Column(name = "SPEC_SLUMP_ACTION")
    private BigDecimal specSlumpAction;
    @Column(name = "SPEC_AIRCONTENT_SUSPENSION")
    private BigDecimal specAircontentSuspension;
    @Column(name = "SPEC_AIRCONTENT_ACTION")
    private BigDecimal specAircontentAction;
    @Column(name = "REQTK")
    private BigDecimal reqtk;
    @Column(name = "SPEC_FLEX_SUSPENSION")
    private BigDecimal specFlexSuspension;
    @Column(name = "SPEC_FLEX_ACTION")
    private BigDecimal specFlexAction;
    @Column(name = "SPEC_TK_SUSPENSION")
    private BigDecimal specTkSuspension;
    @Column(name = "SPEC_TK_ACTION")
    private BigDecimal specTkAction;
    @Column(name = "SPEC_CONC_TEMP_MIN")
    private BigInteger specConcTempMin;
    @Column(name = "SPEC_CONC_TEMP_MAX")
    private BigInteger specConcTempMax;
    @Column(name = "SPEC_RESIDUAL_STR1")
    private BigDecimal specResidualStr1;
    @Column(name = "SPEC_RESIDUAL_STR2")
    private BigDecimal specResidualStr2;
    @Column(name = "SPEC_RESIDUAL_STR3")
    private BigDecimal specResidualStr3;
    @Column(name = "SPEC_RESIDUAL_STR_PEAK")
    private BigDecimal specResidualStrPeak;
    @Column(name = "BOILEDABSORPTION")
    private BigDecimal boiledabsorption;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Basic(optional = false)
    @Column(name = "CREATED", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Basic(optional = false)
    @Column(name = "LAST_MOD", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Size(max = 10)
    @Column(name = "ISGLOBAL")
    private String isGlobal;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 100)
    @Column(name = "MIX_STATUS")
    private String mixStatus;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @Version
    @Column(name = "VERSION")
    private Long version;
    @NotAudited
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mixDesignId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<QaconcMixdesignMasterproject> qaconcMixdesignMasterProjectList;

    public QaconcMixdesignMaster() {
    }

    public QaconcMixdesignMaster(BigDecimal id) {
        this.id = id;
    }

    public QaconcMixdesignMaster(BigDecimal id, BigInteger clientId, String mixdesignNo) {
        this.id = id;
        this.clientId = clientId;
        this.mixdesignNo = mixdesignNo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getMixdesignNo() {
        return mixdesignNo;
    }

    public void setMixdesignNo(String mixdesignNo) {
        this.mixdesignNo = mixdesignNo;
    }

    public GlobSupplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(GlobSupplier supplierId) {
        this.supplierId = supplierId;
    }

    public GlobSupplierAddress getSupplierLocId() {
        return supplierLocId;
    }

    public void setSupplierLocId(GlobSupplierAddress supplierLocId) {
        this.supplierLocId = supplierLocId;
    }

    public QmCvlFieldData getMixdesignType() {
        return mixdesignType;
    }

    public void setMixdesignType(QmCvlFieldData mixdesignType) {
        this.mixdesignType = mixdesignType;
    }

    public String getMixdesignDescription() {
        return mixdesignDescription;
    }

    public void setMixdesignDescription(String mixdesignDescription) {
        this.mixdesignDescription = mixdesignDescription;
    }

    public String getMixdesignRemark() {
        return mixdesignRemark;
    }

    public void setMixdesignRemark(String mixdesignRemark) {
        this.mixdesignRemark = mixdesignRemark;
    }

    public QmCvlFieldData getMaxAggSizeId() {
        return maxAggSizeId;
    }

    public void setMaxAggSizeId(QmCvlFieldData maxAggSizeId) {
        this.maxAggSizeId = maxAggSizeId;
    }

    public BigDecimal getDesignCompstr() {
        return designCompstr;
    }

    public void setDesignCompstr(BigDecimal designCompstr) {
        this.designCompstr = designCompstr;
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

    public BigDecimal getDesignSlump() {
        return designSlump;
    }

    public void setDesignSlump(BigDecimal designSlump) {
        this.designSlump = designSlump;
    }

    public BigDecimal getDesignSlumpFlowScc() {
        return designSlumpFlowScc;
    }

    public void setDesignSlumpFlowScc(BigDecimal designSlumpFlowScc) {
        this.designSlumpFlowScc = designSlumpFlowScc;
    }

    public BigDecimal getDesignAirContent() {
        return designAirContent;
    }

    public void setDesignAirContent(BigDecimal designAirContent) {
        this.designAirContent = designAirContent;
    }

    public BigDecimal getTotalCoarseAgg() {
        return totalCoarseAgg;
    }

    public void setTotalCoarseAgg(BigDecimal totalCoarseAgg) {
        this.totalCoarseAgg = totalCoarseAgg;
    }

    public BigDecimal getTotalFineAgg() {
        return totalFineAgg;
    }

    public void setTotalFineAgg(BigDecimal totalFineAgg) {
        this.totalFineAgg = totalFineAgg;
    }

    public BigDecimal getCement() {
        return cement;
    }

    public void setCement(BigDecimal cement) {
        this.cement = cement;
    }

    public BigDecimal getFlyAsh() {
        return flyAsh;
    }

    public void setFlyAsh(BigDecimal flyAsh) {
        this.flyAsh = flyAsh;
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

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(BigDecimal water) {
        this.water = water;
    }

    public BigDecimal getAdmixtureQty1() {
        return admixtureQty1;
    }

    public void setAdmixtureQty1(BigDecimal admixtureQty1) {
        this.admixtureQty1 = admixtureQty1;
    }

    public String getAdmixtureType1() {
        return admixtureType1;
    }

    public void setAdmixtureType1(String admixtureType1) {
        this.admixtureType1 = admixtureType1;
    }

    public BigDecimal getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(BigDecimal admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public String getAdmixtureType2() {
        return admixtureType2;
    }

    public void setAdmixtureType2(String admixtureType2) {
        this.admixtureType2 = admixtureType2;
    }

    public BigDecimal getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(BigDecimal admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public String getAdmixtureType3() {
        return admixtureType3;
    }

    public void setAdmixtureType3(String admixtureType3) {
        this.admixtureType3 = admixtureType3;
    }

    public BigDecimal getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(BigDecimal admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public String getAdmixtureType4() {
        return admixtureType4;
    }

    public void setAdmixtureType4(String admixtureType4) {
        this.admixtureType4 = admixtureType4;
    }

    public BigDecimal getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(BigDecimal admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public String getAdmixtureType5() {
        return admixtureType5;
    }

    public void setAdmixtureType5(String admixtureType5) {
        this.admixtureType5 = admixtureType5;
    }

    public BigDecimal getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(BigDecimal admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public String getAdmixtureType6() {
        return admixtureType6;
    }

    public void setAdmixtureType6(String admixtureType6) {
        this.admixtureType6 = admixtureType6;
    }

    public BigDecimal getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(BigDecimal admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public String getAdmixtureType7() {
        return admixtureType7;
    }

    public void setAdmixtureType7(String admixtureType7) {
        this.admixtureType7 = admixtureType7;
    }

    public BigDecimal getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(BigDecimal admixtureQty8) {
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

    public BigDecimal getWaterCementMax() {
        return waterCementMax;
    }

    public void setWaterCementMax(BigDecimal waterCementMax) {
        this.waterCementMax = waterCementMax;
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

    public BigDecimal getSpecLimitSlumpMin() {
        return specLimitSlumpMin;
    }

    public void setSpecLimitSlumpMin(BigDecimal specLimitSlumpMin) {
        this.specLimitSlumpMin = specLimitSlumpMin;
    }

    public BigDecimal getSpecLimitSlumpMax() {
        return specLimitSlumpMax;
    }

    public void setSpecLimitSlumpMax(BigDecimal specLimitSlumpMax) {
        this.specLimitSlumpMax = specLimitSlumpMax;
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

    public BigDecimal getSpecLimitAirContentMin() {
        return specLimitAirContentMin;
    }

    public void setSpecLimitAirContentMin(BigDecimal specLimitAirContentMin) {
        this.specLimitAirContentMin = specLimitAirContentMin;
    }

    public BigDecimal getSpecLimitAirContentMax() {
        return specLimitAirContentMax;
    }

    public void setSpecLimitAirContentMax(BigDecimal specLimitAirContentMax) {
        this.specLimitAirContentMax = specLimitAirContentMax;
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

    public BigDecimal getDesignTensileStr() {
        return designTensileStr;
    }

    public void setDesignTensileStr(BigDecimal designTensileStr) {
        this.designTensileStr = designTensileStr;
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

    public BigDecimal getDesignFlexStr() {
        return designFlexStr;
    }

    public void setDesignFlexStr(BigDecimal designFlexStr) {
        this.designFlexStr = designFlexStr;
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

    public String getConcreteClass() {
        return concreteClass;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
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

    public BigDecimal getSpecAircontentSuspension() {
        return specAircontentSuspension;
    }

    public void setSpecAircontentSuspension(BigDecimal specAircontentSuspension) {
        this.specAircontentSuspension = specAircontentSuspension;
    }

    public BigDecimal getSpecAircontentAction() {
        return specAircontentAction;
    }

    public void setSpecAircontentAction(BigDecimal specAircontentAction) {
        this.specAircontentAction = specAircontentAction;
    }

    public BigDecimal getReqtk() {
        return reqtk;
    }

    public void setReqtk(BigDecimal reqtk) {
        this.reqtk = reqtk;
    }

    public BigDecimal getSpecFlexSuspension() {
        return specFlexSuspension;
    }

    public void setSpecFlexSuspension(BigDecimal specFlexSuspension) {
        this.specFlexSuspension = specFlexSuspension;
    }

    public BigDecimal getSpecFlexAction() {
        return specFlexAction;
    }

    public void setSpecFlexAction(BigDecimal specFlexAction) {
        this.specFlexAction = specFlexAction;
    }

    public BigDecimal getSpecTkSuspension() {
        return specTkSuspension;
    }

    public void setSpecTkSuspension(BigDecimal specTkSuspension) {
        this.specTkSuspension = specTkSuspension;
    }

    public BigDecimal getSpecTkAction() {
        return specTkAction;
    }

    public void setSpecTkAction(BigDecimal specTkAction) {
        this.specTkAction = specTkAction;
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

    public BigDecimal getSpecResidualStr1() {
        return specResidualStr1;
    }

    public void setSpecResidualStr1(BigDecimal specResidualStr1) {
        this.specResidualStr1 = specResidualStr1;
    }

    public BigDecimal getSpecResidualStr2() {
        return specResidualStr2;
    }

    public void setSpecResidualStr2(BigDecimal specResidualStr2) {
        this.specResidualStr2 = specResidualStr2;
    }

    public BigDecimal getSpecResidualStr3() {
        return specResidualStr3;
    }

    public void setSpecResidualStr3(BigDecimal specResidualStr3) {
        this.specResidualStr3 = specResidualStr3;
    }

    public BigDecimal getSpecResidualStrPeak() {
        return specResidualStrPeak;
    }

    public void setSpecResidualStrPeak(BigDecimal specResidualStrPeak) {
        this.specResidualStrPeak = specResidualStrPeak;
    }

    public BigDecimal getBoiledabsorption() {
        return boiledabsorption;
    }

    public void setBoiledabsorption(BigDecimal boiledabsorption) {
        this.boiledabsorption = boiledabsorption;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(String isGlobal) {
        this.isGlobal = isGlobal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public BigDecimal getCoarseAgg1() {
        return coarseAgg1;
    }

    public void setCoarseAgg1(BigDecimal coarseAgg1) {
        this.coarseAgg1 = coarseAgg1;
    }

    public BigDecimal getCoarseAgg2() {
        return coarseAgg2;
    }

    public void setCoarseAgg2(BigDecimal coarseAgg2) {
        this.coarseAgg2 = coarseAgg2;
    }

    public BigDecimal getFineAgg1() {
        return fineAgg1;
    }

    public void setFineAgg1(BigDecimal fineAgg1) {
        this.fineAgg1 = fineAgg1;
    }

    public BigDecimal getFineAgg2() {
        return fineAgg2;
    }

    public void setFineAgg2(BigDecimal fineAgg2) {
        this.fineAgg2 = fineAgg2;
    }

    @XmlTransient
    public List<QaconcMixdesignMasterproject> getQaconcMixdesignMasterProjectList() {
        return qaconcMixdesignMasterProjectList;
    }

    public void setQaconcMixdesignMasterProjectList(List<QaconcMixdesignMasterproject> qaconcMixdesignMasterProjectList) {
        this.qaconcMixdesignMasterProjectList = qaconcMixdesignMasterProjectList;
    }

    public void addProjectList(QaconcMixdesignMasterproject item) {
        if (qaconcMixdesignMasterProjectList == null) {
            qaconcMixdesignMasterProjectList = new ArrayList<>();
        }
        qaconcMixdesignMasterProjectList.add(item);
        item.setMixDesignId(this);
    }

    public void removeProjectList(QaconcMixdesignMasterproject item) {
        qaconcMixdesignMasterProjectList.remove(item);
        item.setMixDesignId(null);
    }

    public void updateReferences(List<QaconcMixdesignMasterproject> items) {
        List<QaconcMixdesignMasterproject> currentList = new ArrayList<>();
        currentList.addAll(qaconcMixdesignMasterProjectList);
        currentList.forEach(it -> {
            removeProjectList(it);
        });

        if (items != null && !items.isEmpty()) {
            items.forEach(p -> {
                addProjectList(p);
            });
        }
    }

    public void buildReferences() {
        if (qaconcMixdesignMasterProjectList != null && !qaconcMixdesignMasterProjectList.isEmpty()) {
            qaconcMixdesignMasterProjectList.forEach(p -> {
                p.setMixDesignId(this);
            });
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(supplierId)
                .append(supplierLocId)
                .append(mixdesignType)
                .append(mixStatus)
                .append(expirationDate)
                .append(qaconcMixdesignMasterProjectList)
                .append(designCompstr)
                .append(designCompstrAge)
                .append(designCompstrAgeUnit)
                .append(designSlump)
                .append(designSlumpFlowScc)
                .append(designAirContent)
                .append(totalCoarseAgg)
                .append(coarseAgg1)
                .append(coarseAgg2)
                .append(totalFineAgg)
                .append(fineAgg1)
                .append(fineAgg2)
                .append(cement)
                .append(flyAsh)
                .append(slag)
                .append(silicaFume)
                .append(totalCementMat)
                .append(water)
                .append(admixtureQty1)
                .append(admixtureType1)
                .append(admixtureQty2)
                .append(admixtureType2)
                .append(admixtureQty3)
                .append(admixtureType3)
                .append(admixtureQty4)
                .append(admixtureType4)
                .append(admixtureQty5)
                .append(admixtureType5)
                .append(admixtureQty6)
                .append(admixtureType6)
                .append(admixtureQty7)
                .append(admixtureType7)
                .append(admixtureQty8)
                .append(admixtureType8)
                .append(waterCementRatio)
                .append(waterCementMax)
                .append(theoreticalAirContent)
                .append(volumenPaste)
                .append(specLimitSlumpMin)
                .append(specLimitSlumpMax)
                .append(engLimitSlumpMin)
                .append(engLimitSlumpMax)
                .append(specLimitAirContentMin)
                .append(specLimitAirContentMax)
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
                .append(designTensileStr)
                .append(designTensileStrAge)
                .append(designTensileStrAgeUnit)
                .append(designFlexStr)
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
                .append(concreteClass)
                .append(specSlumpSuspension)
                .append(specSlumpAction)
                .append(specAircontentSuspension)
                .append(specAircontentAction)
                .append(reqtk)
                .append(specFlexSuspension)
                .append(specFlexAction)
                .append(specTkSuspension)
                .append(specTkAction)
                .append(specConcTempMin)
                .append(specConcTempMax)
                .append(specResidualStr1)
                .append(specResidualStr2)
                .append(specResidualStr3)
                .append(specResidualStrPeak)
                .append(boiledabsorption)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaconcMixdesignMaster)) {
            return false;
        }
        QaconcMixdesignMaster other = (QaconcMixdesignMaster) object;

        return new EqualsBuilder()
                .append(this.mixdesignType, other.mixdesignType)
                .append(this.mixStatus, other.mixStatus)
                .append(this.expirationDate, other.expirationDate)
                .append(this.qaconcMixdesignMasterProjectList, other.qaconcMixdesignMasterProjectList)
                .append(this.supplierId, other.supplierId)
                .append(this.supplierLocId, other.supplierLocId)
                .append(this.designCompstr, other.designCompstr)
                .append(this.designCompstrAge, other.designCompstrAge)
                .append(this.designCompstrAgeUnit, other.designCompstrAgeUnit)
                .append(this.designSlump, other.designSlump)
                .append(this.designSlumpFlowScc, other.designSlumpFlowScc)
                .append(this.designAirContent, other.designAirContent)
                .append(this.totalCoarseAgg, other.totalCoarseAgg)
                .append(this.coarseAgg1, other.coarseAgg1)
                .append(this.coarseAgg2, other.coarseAgg2)
                .append(this.totalFineAgg, other.totalFineAgg)
                .append(this.fineAgg1, other.fineAgg1)
                .append(this.fineAgg2, other.fineAgg2)
                .append(this.cement, other.cement)
                .append(this.flyAsh, other.flyAsh)
                .append(this.slag, other.slag)
                .append(this.silicaFume, other.silicaFume)
                .append(this.totalCementMat, other.totalCementMat)
                .append(this.water, other.water)
                .append(this.admixtureQty1, other.admixtureQty1)
                .append(this.admixtureType1, other.admixtureType1)
                .append(this.admixtureQty2, other.admixtureQty2)
                .append(this.admixtureType2, other.admixtureType2)
                .append(this.admixtureQty3, other.admixtureQty3)
                .append(this.admixtureType3, other.admixtureType3)
                .append(this.admixtureQty4, other.admixtureQty4)
                .append(this.admixtureType4, other.admixtureType4)
                .append(this.admixtureQty5, other.admixtureQty5)
                .append(this.admixtureType5, other.admixtureType5)
                .append(this.admixtureQty6, other.admixtureQty6)
                .append(this.admixtureType6, other.admixtureType6)
                .append(this.admixtureQty7, other.admixtureQty7)
                .append(this.admixtureType7, other.admixtureType7)
                .append(this.admixtureQty8, other.admixtureQty8)
                .append(this.admixtureType8, other.admixtureType8)
                .append(this.waterCementRatio, other.waterCementRatio)
                .append(this.waterCementMax, other.waterCementMax)
                .append(this.theoreticalAirContent, other.theoreticalAirContent)
                .append(this.volumenPaste, other.volumenPaste)
                .append(this.specLimitSlumpMin, other.specLimitSlumpMin)
                .append(this.specLimitSlumpMax, other.specLimitSlumpMax)
                .append(this.engLimitSlumpMin, other.engLimitSlumpMin)
                .append(this.engLimitSlumpMax, other.engLimitSlumpMax)
                .append(this.specLimitAirContentMin, other.specLimitAirContentMin)
                .append(this.specLimitAirContentMax, other.specLimitAirContentMax)
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
                .append(this.designTensileStr, other.designTensileStr)
                .append(this.designTensileStrAge, other.designTensileStrAge)
                .append(this.designTensileStrAgeUnit, other.designTensileStrAgeUnit)
                .append(this.designFlexStr, other.designFlexStr)
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
                .append(this.concreteClass, other.concreteClass)
                .append(this.specSlumpSuspension, other.specSlumpSuspension)
                .append(this.specSlumpAction, other.specSlumpAction)
                .append(this.specAircontentSuspension, other.specAircontentSuspension)
                .append(this.specAircontentAction, other.specAircontentAction)
                .append(this.reqtk, other.reqtk)
                .append(this.specFlexSuspension, other.specFlexSuspension)
                .append(this.specFlexAction, other.specFlexAction)
                .append(this.specTkSuspension, other.specTkSuspension)
                .append(this.specTkAction, other.specTkAction)
                .append(this.specConcTempMin, other.specConcTempMin)
                .append(this.specConcTempMax, other.specConcTempMax)
                .append(this.specResidualStr1, other.specResidualStr1)
                .append(this.specResidualStr2, other.specResidualStr2)
                .append(this.specResidualStr3, other.specResidualStr3)
                .append(this.specResidualStrPeak, other.specResidualStrPeak)
                .append(this.boiledabsorption, other.boiledabsorption)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcMixdesignMaster[ id=" + id + " ]";
    }

    public QaconcMixdesignsTO generateTO() {
        QaconcMixdesignsTO to = new QaconcMixdesignsTO();
        to.setMixdesignNo(getMixdesignNo());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier() : "");
        to.setSupplierLoc(getSupplierLocId() != null ? getSupplierLocId().getLocation() : "");
        to.setMixdesignType(getMixdesignType() != null ? getMixdesignType().getValue() : "");
        to.setMixdesignDescription(getMixdesignDescription());
        to.setMixdesignRemark(getMixdesignRemark());
        to.setMaxAggSizeId(getMaxAggSizeId() != null ? getMaxAggSizeId().getValue() : "");
        to.setDesignCompstr(StringSupport.getString(getDesignCompstr()));
        to.setDesignCompstrAge(StringSupport.getString(getDesignCompstrAge()));
        to.setDesignCompstrAgeUnit(getDesignCompstrAgeUnit());
        to.setDesignSlump(StringSupport.getString(getDesignSlump()));
        to.setDesignSlumpFlowScc(StringSupport.getString(getDesignSlumpFlowScc()));
        to.setDesignAirContent(StringSupport.getString(getDesignAirContent()));
        to.setTotalCoarseAgg(StringSupport.getString(getTotalCoarseAgg()));
        to.setCoarseAgg1(StringSupport.getString(getCoarseAgg1()));
        to.setCoarseAgg2(StringSupport.getString(getCoarseAgg2()));
        to.setTotalFineAgg(StringSupport.getString(getTotalFineAgg()));
        to.setFineAgg1(StringSupport.getString(getFineAgg1()));
        to.setFineAgg2(StringSupport.getString(getFineAgg2()));
        to.setCement(StringSupport.getString(getCement()));
        to.setFlyAsh(StringSupport.getString(getFlyAsh()));
        to.setSlag(StringSupport.getString(getSlag()));
        to.setSilicaFume(StringSupport.getString(getSilicaFume()));
        to.setTotalCementMat(StringSupport.getString(getTotalCementMat()));
        to.setWater(StringSupport.getString(getWater()));
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
        to.setWaterCementMax(StringSupport.getString(getWaterCementMax()));
        to.setTheoreticalAirContent(StringSupport.getString(getTheoreticalAirContent()));
        to.setVolumenPaste(StringSupport.getString(getVolumenPaste()));
        to.setSpecLimitSlumpMin(StringSupport.getString(getSpecLimitSlumpMin()));
        to.setSpecLimitSlumpMax(StringSupport.getString(getSpecLimitSlumpMax()));
        to.setEngLimitSlumpMin(StringSupport.getString(getEngLimitSlumpMin()));
        to.setEngLimitSlumpMax(StringSupport.getString(getEngLimitSlumpMax()));
        to.setSpecLimitAirContentMin(StringSupport.getString(getSpecLimitAirContentMin()));
        to.setSpecLimitAirContentMax(StringSupport.getString(getSpecLimitAirContentMax()));
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
        to.setDesignTensileStr(StringSupport.getString(getDesignTensileStr()));
        to.setDesignTensileStrAge(StringSupport.getString(getDesignTensileStrAge()));
        to.setDesignTensileStrAgeUnit(getDesignTensileStrAgeUnit());
        to.setDesignFlexStr(StringSupport.getString(getDesignFlexStr()));
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
        to.setSpecAircontentSuspension(StringSupport.getString(getSpecAircontentSuspension()));
        to.setSpecAircontentAction(StringSupport.getString(getSpecAircontentAction()));
        to.setReqtk(StringSupport.getString(getReqtk()));
        to.setSpecFlexSuspension(StringSupport.getString(getSpecFlexSuspension()));
        to.setSpecFlexAction(StringSupport.getString(getSpecFlexAction()));
        to.setSpecTkSuspension(StringSupport.getString(getSpecTkSuspension()));
        to.setSpecTkAction(StringSupport.getString(getSpecTkAction()));
        to.setSpecConcTempMin(StringSupport.getString(getSpecConcTempMin()));
        to.setSpecConcTempMax(StringSupport.getString(getSpecConcTempMax()));
        to.setSpecResidualStr1(StringSupport.getString(getSpecResidualStr1()));
        to.setSpecResidualStr2(StringSupport.getString(getSpecResidualStr2()));
        to.setSpecResidualStr3(StringSupport.getString(getSpecResidualStr3()));
        to.setSpecResidualStrPeak(StringSupport.getString(getSpecResidualStrPeak()));
        to.setBoiledabsorption(StringSupport.getString(getBoiledabsorption()));
        to.setExpirationDate(StringSupport.getString(getExpirationDate()));
        to.setMixStatus(getMixStatus());
        return to;
    }

    public QaconcMixDesignsLogTO generateLogTO() {
        QaconcMixDesignsLogTO to = new QaconcMixDesignsLogTO();
        to.setMixdesignNo(getMixdesignNo());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier() : "");
        to.setLocation(getSupplierLocId() != null ? getSupplierLocId().getLocation() : "");
        to.setMixdesignType(getMixdesignType() != null ? getMixdesignType().getValue() : "");
        to.setCreated(DateSupport.formatDate(getCreated(), DateSupport.FORMAT_US));
        to.setMixStatus(getMixStatus() != null && getMixStatus().equals("approvedmix") ? "Approved Mix" : "Pending");
        to.setExpirationDate(DateSupport.formatDate(getExpirationDate(), DateSupport.FORMAT_US));
        return to;
    }

}
