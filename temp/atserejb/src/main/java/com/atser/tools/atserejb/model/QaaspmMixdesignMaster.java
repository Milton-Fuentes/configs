/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsTO;
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
@NamedQuery(name = "QaaspmMixdesignMaster.findByClientId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMixdesignNo", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mixdesignNo = :mixdesignNo"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByParentMixdesignNo", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.parentMixdesignNo = :parentMixdesignNo"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByCatg", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.catg = :catg"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findBySupplierId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findBySupplierLocId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.supplierLocId = :supplierLocId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMixdesignType", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mixdesignType = :mixdesignType"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMixdesignDescription", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mixdesignDescription = :mixdesignDescription"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMixdesignRemark", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mixdesignRemark = :mixdesignRemark"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByNmasId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.nmasId = :nmasId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByGyrationsId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.gyrationsId = :gyrationsId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTrafficLevelId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.trafficLevelId = :trafficLevelId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPgBinderGradeId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pgBinderGradeId = :pgBinderGradeId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPgBinderAdditiveId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pgBinderAdditiveId = :pgBinderAdditiveId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByAdditivePct", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.additivePct = :additivePct"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByRecycleTypeId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.recycleTypeId = :recycleTypeId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByWmaTechtypeId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.wmaTechtypeId = :wmaTechtypeId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByWmaTechnologyId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.wmaTechnologyId = :wmaTechnologyId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTechPct", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.techPct = :techPct"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByGsb", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.gsb = :gsb"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByBulkSgGmb", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.bulkSgGmb = :bulkSgGmb"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByGmm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.gmm = :gmm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desac = :desac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minac = :minac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxac = :maxac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinengac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minengac = :minengac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxengac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxengac = :maxengac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesvtm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desvtm = :desvtm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinvtm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minvtm = :minvtm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxvtm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxvtm = :maxvtm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinengvtm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minengvtm = :minengvtm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxengvtm", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxengvtm = :maxengvtm"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesvma", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desvma = :desvma"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinvma", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minvma = :minvma"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxvma", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxvma = :maxvma"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinengvma", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minengvma = :minengvma"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxengvma", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxengvma = :maxengvma"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesvfa", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desvfa = :desvfa"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinvfa", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minvfa = :minvfa"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxvfa", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxvfa = :maxvfa"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinengvfa", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minengvfa = :minengvfa"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxengvfa", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxengvfa = :maxengvfa"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByGse", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.gse = :gse"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByGasp", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.gasp = :gasp"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPba", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pba = :pba"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPbe", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pbe = :pbe"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesdpbr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desdpbr = :desdpbr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMindpbr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mindpbr = :mindpbr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxdpbr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxdpbr = :maxdpbr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinengdpbr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minengdpbr = :minengdpbr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxengdpbr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxengdpbr = :maxengdpbr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMincompfd", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mincompfd = :mincompfd"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxcompfd", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxcompfd = :maxcompfd"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDescompfd", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.descompfd = :descompfd"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByBlows", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.blows = :blows"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minstability = :minstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxstability = :maxstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desstability = :desstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinflow", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minflow = :minflow"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxflow", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxflow = :maxflow"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesflow", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desflow = :desflow"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinjointden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minjointden = :minjointden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxjointden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxjointden = :maxjointden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesjointden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desjointden = :desjointden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinmatden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minmatden = :minmatden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxmatden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxmatden = :maxmatden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesmatden", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desmatden = :desmatden"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinhveemstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minhveemstability = :minhveemstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxhveemstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxhveemstability = :maxhveemstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDeshveemstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.deshveemstability = :deshveemstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMintsr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mintsr = :mintsr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxtsr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxtsr = :maxtsr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDestsr", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.destsr = :destsr"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDescompfdpcf", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.descompfdpcf = :descompfdpcf"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDesmaxtheodens", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.desmaxtheodens = :desmaxtheodens"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolminac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolminac = :tolminac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolmaxac", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolmaxac = :tolmaxac"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolminhveemstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolminhveemstability = :tolminhveemstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolmaxhveemstability", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolmaxhveemstability = :tolmaxhveemstability"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolmincompfd", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolmincompfd = :tolmincompfd"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolmaxcompfd", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolmaxcompfd = :tolmaxcompfd"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDessieve200", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.dessieve200 = :dessieve200"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMinsieve200", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.minsieve200 = :minsieve200"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMaxsieve200", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.maxsieve200 = :maxsieve200"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolminsieve200", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolminsieve200 = :tolminsieve200"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByTolmaxsieve200", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.tolmaxsieve200 = :tolmaxsieve200"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByCurrentJmfNo", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.currentJmfNo = :currentJmfNo"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPressCorrFactor", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pressCorrFactor = :pressCorrFactor"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByPressIdSerialNo", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.pressIdSerialNo = :pressIdSerialNo"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByG1SpecGravAsp", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.g1SpecGravAsp = :g1SpecGravAsp"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByAcCorrFactor", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.acCorrFactor = :acCorrFactor"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByLtmfDate", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.ltmfDate = :ltmfDate"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findBySetId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.setId = :setId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByItemId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMatId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.matId = :matId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByApprovedDate", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.approvedDate = :approvedDate"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByExpirationDate", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.expirationDate = :expirationDate"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByCreated", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.created = :created"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByCreatedBy", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByCreatedByIp", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByLastMod", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByLastModIp", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByLastModBy", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByFolderId", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.folderId = :folderId"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByIsglobal", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.isglobal = :isglobal"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByStatus", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.status = :status"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByMixStatus", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.mixStatus = :mixStatus"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByDeleted", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByActive", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.active = :active"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findByVersion", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QAASPM_MIXDESIGN_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QAASPM_MIXDESIGN_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignMaster.findAll", query = "SELECT q FROM QaaspmMixdesignMaster q"),
    @NamedQuery(name = "QaaspmMixdesignMaster.findById", query = "SELECT q FROM QaaspmMixdesignMaster q WHERE q.id = :id")})
public class QaaspmMixdesignMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QAASPM_MIXDESIGN_MASTER_SEQ", sequenceName = "QAASPM_MIXDESIGN_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QAASPM_MIXDESIGN_MASTER_SEQ")
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
    @Size(max = 255)
    @Column(name = "PARENT_MIXDESIGN_NO")
    private String parentMixdesignNo;
    @Size(max = 255)
    @Column(name = "CATG")
    private String catg;
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
    @ManyToOne(optional = true)
    private QmCvlFieldData mixdesignType;
    @Size(max = 4000)
    @Column(name = "MIXDESIGN_DESCRIPTION")
    private String mixdesignDescription;
    @Size(max = 500)
    @Column(name = "MIXDESIGN_REMARK")
    private String mixdesignRemark;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "NMAS_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData nmasId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "GYRATIONS_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData gyrationsId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "TRAFFIC_LEVEL_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData trafficLevelId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "PG_BINDER_GRADE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData pgBinderGradeId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "PG_BINDER_ADDITIVE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData pgBinderAdditiveId;
    @Column(name = "ADDITIVE_PCT")
    private BigDecimal additivePct;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "RECYCLE_TYPE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData recycleTypeId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "WMA_TECHTYPE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData wmaTechtypeId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "WMA_TECHNOLOGY_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData wmaTechnologyId;
    @Column(name = "TECH_PCT")
    private BigDecimal techPct;
    @Column(name = "GSB")
    private BigDecimal gsb;
    @Column(name = "BULK_SG_GMB")
    private BigDecimal bulkSgGmb;
    @Column(name = "GMM")
    private BigDecimal gmm;
    @Column(name = "DESAC")
    private BigDecimal desac;
    @Column(name = "MINAC")
    private BigDecimal minac;
    @Column(name = "MAXAC")
    private BigDecimal maxac;
    @Column(name = "MINENGAC")
    private BigDecimal minengac;
    @Column(name = "MAXENGAC")
    private BigDecimal maxengac;
    @Column(name = "DESVTM")
    private BigDecimal desvtm;
    @Column(name = "MINVTM")
    private BigDecimal minvtm;
    @Column(name = "MAXVTM")
    private BigDecimal maxvtm;
    @Column(name = "MINENGVTM")
    private BigDecimal minengvtm;
    @Column(name = "MAXENGVTM")
    private BigDecimal maxengvtm;
    @Column(name = "DESVMA")
    private BigDecimal desvma;
    @Column(name = "MINVMA")
    private BigDecimal minvma;
    @Column(name = "MAXVMA")
    private BigDecimal maxvma;
    @Column(name = "MINENGVMA")
    private BigDecimal minengvma;
    @Column(name = "MAXENGVMA")
    private BigDecimal maxengvma;
    @Column(name = "DESVFA")
    private BigDecimal desvfa;
    @Column(name = "MINVFA")
    private BigDecimal minvfa;
    @Column(name = "MAXVFA")
    private BigDecimal maxvfa;
    @Column(name = "MINENGVFA")
    private BigDecimal minengvfa;
    @Column(name = "MAXENGVFA")
    private BigDecimal maxengvfa;
    @Column(name = "GSE")
    private BigDecimal gse;
    @Column(name = "GASP")
    private BigDecimal gasp;
    @Column(name = "PBA")
    private BigDecimal pba;
    @Column(name = "PBE")
    private BigDecimal pbe;
    @Column(name = "DESDPBR")
    private BigDecimal desdpbr;
    @Column(name = "MINDPBR")
    private BigDecimal mindpbr;
    @Column(name = "MAXDPBR")
    private BigDecimal maxdpbr;
    @Column(name = "MINENGDPBR")
    private BigDecimal minengdpbr;
    @Column(name = "MAXENGDPBR")
    private BigDecimal maxengdpbr;
    @Column(name = "MINCOMPFD")
    private BigDecimal mincompfd;
    @Column(name = "MAXCOMPFD")
    private BigDecimal maxcompfd;
    @Column(name = "DESCOMPFD")
    private BigDecimal descompfd;
    @Column(name = "BLOWS")
    private BigDecimal blows;
    @Column(name = "MINSTABILITY")
    private BigDecimal minstability;
    @Column(name = "MAXSTABILITY")
    private BigDecimal maxstability;
    @Column(name = "DESSTABILITY")
    private BigDecimal desstability;
    @Column(name = "MINFLOW")
    private BigDecimal minflow;
    @Column(name = "MAXFLOW")
    private BigDecimal maxflow;
    @Column(name = "DESFLOW")
    private BigDecimal desflow;
    @Column(name = "MINJOINTDEN")
    private BigDecimal minjointden;
    @Column(name = "MAXJOINTDEN")
    private BigDecimal maxjointden;
    @Column(name = "DESJOINTDEN")
    private BigDecimal desjointden;
    @Column(name = "MINMATDEN")
    private BigDecimal minmatden;
    @Column(name = "MAXMATDEN")
    private BigDecimal maxmatden;
    @Column(name = "DESMATDEN")
    private BigDecimal desmatden;
    @Column(name = "MINHVEEMSTABILITY")
    private BigDecimal minhveemstability;
    @Column(name = "MAXHVEEMSTABILITY")
    private BigDecimal maxhveemstability;
    @Column(name = "DESHVEEMSTABILITY")
    private BigDecimal deshveemstability;
    @Column(name = "MINTSR")
    private BigDecimal mintsr;
    @Column(name = "MAXTSR")
    private BigDecimal maxtsr;
    @Column(name = "DESTSR")
    private BigDecimal destsr;
    @Column(name = "DESCOMPFDPCF")
    private BigDecimal descompfdpcf;
    @Column(name = "DESMAXTHEODENS")
    private BigDecimal desmaxtheodens;
    @Column(name = "TOLMINAC")
    private BigDecimal tolminac;
    @Column(name = "TOLMAXAC")
    private BigDecimal tolmaxac;
    @Column(name = "TOLMINVTM")
    private BigDecimal tolminvtm;
    @Column(name = "TOLMAXVTM")
    private BigDecimal tolmaxvtm;
    @Column(name = "TOLMINVMA")
    private BigDecimal tolminvma;
    @Column(name = "TOLMAXVMA")
    private BigDecimal tolmaxvma;
    @Column(name = "TOLMINVFA")
    private BigDecimal tolminvfa;
    @Column(name = "TOLMAXVFA")
    private BigDecimal tolmaxvfa;
    @Column(name = "TOLMINDPBR")
    private BigDecimal tolmindpbr;
    @Column(name = "TOLMAXDPBR")
    private BigDecimal tolmaxdpbr;
    @Column(name = "TOLMINENGAC")
    private BigDecimal tolminengac;
    @Column(name = "TOLMAXENGAC")
    private BigDecimal tolmaxengac;
    @Column(name = "TOLMINENGVTM")
    private BigDecimal tolminengvtm;
    @Column(name = "TOLMAXENGVTM")
    private BigDecimal tolmaxengvtm;
    @Column(name = "TOLMINENGVMA")
    private BigDecimal tolminengvma;
    @Column(name = "TOLMAXENGVMA")
    private BigDecimal tolmaxengvma;
    @Column(name = "TOLMINENGVFA")
    private BigDecimal tolminengvfa;
    @Column(name = "TOLMAXENGVFA")
    private BigDecimal tolmaxengvfa;
    @Column(name = "TOLMINENGDPBR")
    private BigDecimal tolminengdpbr;
    @Column(name = "TOLMAXENGDPBR")
    private BigDecimal tolmaxengdpbr;
    @Column(name = "TOLMINHVEEMSTABILITY")
    private BigDecimal tolminhveemstability;
    @Column(name = "TOLMAXHVEEMSTABILITY")
    private BigDecimal tolmaxhveemstability;
    @Column(name = "TOLMINCOMPFD")
    private BigDecimal tolmincompfd;
    @Column(name = "TOLMAXCOMPFD")
    private BigDecimal tolmaxcompfd;
    @Column(name = "DESSIEVE200")
    private BigDecimal dessieve200;
    @Column(name = "MINSIEVE200")
    private BigDecimal minsieve200;
    @Column(name = "MAXSIEVE200")
    private BigDecimal maxsieve200;
    @Column(name = "TOLMINSIEVE200")
    private BigDecimal tolminsieve200;
    @Column(name = "TOLMAXSIEVE200")
    private BigDecimal tolmaxsieve200;
    @Size(max = 50)
    @Column(name = "CURRENT_JMF_NO")
    private String currentJmfNo;
    @Size(max = 50)
    @Column(name = "PRESS_CORR_FACTOR")
    private String pressCorrFactor;
    @Size(max = 50)
    @Column(name = "PRESS_ID_SERIAL_NO")
    private String pressIdSerialNo;
    @Column(name = "G1_SPEC_GRAV_ASP")
    private BigDecimal g1SpecGravAsp;
    @Column(name = "AC_CORR_FACTOR")
    private BigDecimal acCorrFactor;
    @Column(name = "LTMF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ltmfDate;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSieveSetsInfo setId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "RAP_PCT")
    private BigDecimal rapPct;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
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
    private List<QaaspmMixdesignMasterproject> qaaspmMixdesignMasterProjectList;

    public QaaspmMixdesignMaster() {
    }

    public QaaspmMixdesignMaster(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignMaster(BigDecimal id, BigInteger clientId, String mixdesignNo) {
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

    public String getParentMixdesignNo() {
        return parentMixdesignNo;
    }

    public void setParentMixdesignNo(String parentMixdesignNo) {
        this.parentMixdesignNo = parentMixdesignNo;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
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

    public QmCvlFieldData getNmasId() {
        return nmasId;
    }

    public void setNmasId(QmCvlFieldData nmasId) {
        this.nmasId = nmasId;
    }

    public QmCvlFieldData getGyrationsId() {
        return gyrationsId;
    }

    public void setGyrationsId(QmCvlFieldData gyrationsId) {
        this.gyrationsId = gyrationsId;
    }

    public QmCvlFieldData getTrafficLevelId() {
        return trafficLevelId;
    }

    public void setTrafficLevelId(QmCvlFieldData trafficLevelId) {
        this.trafficLevelId = trafficLevelId;
    }

    public QmCvlFieldData getPgBinderGradeId() {
        return pgBinderGradeId;
    }

    public void setPgBinderGradeId(QmCvlFieldData pgBinderGradeId) {
        this.pgBinderGradeId = pgBinderGradeId;
    }

    public QmCvlFieldData getPgBinderAdditiveId() {
        return pgBinderAdditiveId;
    }

    public void setPgBinderAdditiveId(QmCvlFieldData pgBinderAdditiveId) {
        this.pgBinderAdditiveId = pgBinderAdditiveId;
    }

    public BigDecimal getAdditivePct() {
        return additivePct;
    }

    public void setAdditivePct(BigDecimal additivePct) {
        this.additivePct = additivePct;
    }

    public QmCvlFieldData getRecycleTypeId() {
        return recycleTypeId;
    }

    public void setRecycleTypeId(QmCvlFieldData recycleTypeId) {
        this.recycleTypeId = recycleTypeId;
    }

    public QmCvlFieldData getWmaTechtypeId() {
        return wmaTechtypeId;
    }

    public void setWmaTechtypeId(QmCvlFieldData wmaTechtypeId) {
        this.wmaTechtypeId = wmaTechtypeId;
    }

    public QmCvlFieldData getWmaTechnologyId() {
        return wmaTechnologyId;
    }

    public void setWmaTechnologyId(QmCvlFieldData wmaTechnologyId) {
        this.wmaTechnologyId = wmaTechnologyId;
    }

    public BigDecimal getTechPct() {
        return techPct;
    }

    public void setTechPct(BigDecimal techPct) {
        this.techPct = techPct;
    }

    public BigDecimal getGsb() {
        return gsb;
    }

    public void setGsb(BigDecimal gsb) {
        this.gsb = gsb;
    }

    public BigDecimal getBulkSgGmb() {
        return bulkSgGmb;
    }

    public void setBulkSgGmb(BigDecimal bulkSgGmb) {
        this.bulkSgGmb = bulkSgGmb;
    }

    public BigDecimal getGmm() {
        return gmm;
    }

    public void setGmm(BigDecimal gmm) {
        this.gmm = gmm;
    }

    public BigDecimal getDesac() {
        return desac;
    }

    public void setDesac(BigDecimal desac) {
        this.desac = desac;
    }

    public BigDecimal getMinac() {
        return minac;
    }

    public void setMinac(BigDecimal minac) {
        this.minac = minac;
    }

    public BigDecimal getMaxac() {
        return maxac;
    }

    public void setMaxac(BigDecimal maxac) {
        this.maxac = maxac;
    }

    public BigDecimal getMinengac() {
        return minengac;
    }

    public void setMinengac(BigDecimal minengac) {
        this.minengac = minengac;
    }

    public BigDecimal getMaxengac() {
        return maxengac;
    }

    public void setMaxengac(BigDecimal maxengac) {
        this.maxengac = maxengac;
    }

    public BigDecimal getDesvtm() {
        return desvtm;
    }

    public void setDesvtm(BigDecimal desvtm) {
        this.desvtm = desvtm;
    }

    public BigDecimal getMinvtm() {
        return minvtm;
    }

    public void setMinvtm(BigDecimal minvtm) {
        this.minvtm = minvtm;
    }

    public BigDecimal getMaxvtm() {
        return maxvtm;
    }

    public void setMaxvtm(BigDecimal maxvtm) {
        this.maxvtm = maxvtm;
    }

    public BigDecimal getMinengvtm() {
        return minengvtm;
    }

    public void setMinengvtm(BigDecimal minengvtm) {
        this.minengvtm = minengvtm;
    }

    public BigDecimal getMaxengvtm() {
        return maxengvtm;
    }

    public void setMaxengvtm(BigDecimal maxengvtm) {
        this.maxengvtm = maxengvtm;
    }

    public BigDecimal getDesvma() {
        return desvma;
    }

    public void setDesvma(BigDecimal desvma) {
        this.desvma = desvma;
    }

    public BigDecimal getMinvma() {
        return minvma;
    }

    public void setMinvma(BigDecimal minvma) {
        this.minvma = minvma;
    }

    public BigDecimal getMaxvma() {
        return maxvma;
    }

    public void setMaxvma(BigDecimal maxvma) {
        this.maxvma = maxvma;
    }

    public BigDecimal getMinengvma() {
        return minengvma;
    }

    public void setMinengvma(BigDecimal minengvma) {
        this.minengvma = minengvma;
    }

    public BigDecimal getMaxengvma() {
        return maxengvma;
    }

    public void setMaxengvma(BigDecimal maxengvma) {
        this.maxengvma = maxengvma;
    }

    public BigDecimal getDesvfa() {
        return desvfa;
    }

    public void setDesvfa(BigDecimal desvfa) {
        this.desvfa = desvfa;
    }

    public BigDecimal getMinvfa() {
        return minvfa;
    }

    public void setMinvfa(BigDecimal minvfa) {
        this.minvfa = minvfa;
    }

    public BigDecimal getMaxvfa() {
        return maxvfa;
    }

    public void setMaxvfa(BigDecimal maxvfa) {
        this.maxvfa = maxvfa;
    }

    public BigDecimal getMinengvfa() {
        return minengvfa;
    }

    public void setMinengvfa(BigDecimal minengvfa) {
        this.minengvfa = minengvfa;
    }

    public BigDecimal getMaxengvfa() {
        return maxengvfa;
    }

    public void setMaxengvfa(BigDecimal maxengvfa) {
        this.maxengvfa = maxengvfa;
    }

    public BigDecimal getGse() {
        return gse;
    }

    public void setGse(BigDecimal gse) {
        this.gse = gse;
    }

    public BigDecimal getGasp() {
        return gasp;
    }

    public void setGasp(BigDecimal gasp) {
        this.gasp = gasp;
    }

    public BigDecimal getPba() {
        return pba;
    }

    public void setPba(BigDecimal pba) {
        this.pba = pba;
    }

    public BigDecimal getPbe() {
        return pbe;
    }

    public void setPbe(BigDecimal pbe) {
        this.pbe = pbe;
    }

    public BigDecimal getDesdpbr() {
        return desdpbr;
    }

    public void setDesdpbr(BigDecimal desdpbr) {
        this.desdpbr = desdpbr;
    }

    public BigDecimal getMindpbr() {
        return mindpbr;
    }

    public void setMindpbr(BigDecimal mindpbr) {
        this.mindpbr = mindpbr;
    }

    public BigDecimal getMaxdpbr() {
        return maxdpbr;
    }

    public void setMaxdpbr(BigDecimal maxdpbr) {
        this.maxdpbr = maxdpbr;
    }

    public BigDecimal getMinengdpbr() {
        return minengdpbr;
    }

    public void setMinengdpbr(BigDecimal minengdpbr) {
        this.minengdpbr = minengdpbr;
    }

    public BigDecimal getMaxengdpbr() {
        return maxengdpbr;
    }

    public void setMaxengdpbr(BigDecimal maxengdpbr) {
        this.maxengdpbr = maxengdpbr;
    }

    public BigDecimal getMincompfd() {
        return mincompfd;
    }

    public void setMincompfd(BigDecimal mincompfd) {
        this.mincompfd = mincompfd;
    }

    public BigDecimal getMaxcompfd() {
        return maxcompfd;
    }

    public void setMaxcompfd(BigDecimal maxcompfd) {
        this.maxcompfd = maxcompfd;
    }

    public BigDecimal getDescompfd() {
        return descompfd;
    }

    public void setDescompfd(BigDecimal descompfd) {
        this.descompfd = descompfd;
    }

    public BigDecimal getBlows() {
        return blows;
    }

    public void setBlows(BigDecimal blows) {
        this.blows = blows;
    }

    public BigDecimal getMinstability() {
        return minstability;
    }

    public void setMinstability(BigDecimal minstability) {
        this.minstability = minstability;
    }

    public BigDecimal getMaxstability() {
        return maxstability;
    }

    public void setMaxstability(BigDecimal maxstability) {
        this.maxstability = maxstability;
    }

    public BigDecimal getDesstability() {
        return desstability;
    }

    public void setDesstability(BigDecimal desstability) {
        this.desstability = desstability;
    }

    public BigDecimal getMinflow() {
        return minflow;
    }

    public void setMinflow(BigDecimal minflow) {
        this.minflow = minflow;
    }

    public BigDecimal getMaxflow() {
        return maxflow;
    }

    public void setMaxflow(BigDecimal maxflow) {
        this.maxflow = maxflow;
    }

    public BigDecimal getDesflow() {
        return desflow;
    }

    public void setDesflow(BigDecimal desflow) {
        this.desflow = desflow;
    }

    public BigDecimal getMinjointden() {
        return minjointden;
    }

    public void setMinjointden(BigDecimal minjointden) {
        this.minjointden = minjointden;
    }

    public BigDecimal getMaxjointden() {
        return maxjointden;
    }

    public void setMaxjointden(BigDecimal maxjointden) {
        this.maxjointden = maxjointden;
    }

    public BigDecimal getDesjointden() {
        return desjointden;
    }

    public void setDesjointden(BigDecimal desjointden) {
        this.desjointden = desjointden;
    }

    public BigDecimal getMinmatden() {
        return minmatden;
    }

    public void setMinmatden(BigDecimal minmatden) {
        this.minmatden = minmatden;
    }

    public BigDecimal getMaxmatden() {
        return maxmatden;
    }

    public void setMaxmatden(BigDecimal maxmatden) {
        this.maxmatden = maxmatden;
    }

    public BigDecimal getDesmatden() {
        return desmatden;
    }

    public void setDesmatden(BigDecimal desmatden) {
        this.desmatden = desmatden;
    }

    public BigDecimal getMinhveemstability() {
        return minhveemstability;
    }

    public void setMinhveemstability(BigDecimal minhveemstability) {
        this.minhveemstability = minhveemstability;
    }

    public BigDecimal getMaxhveemstability() {
        return maxhveemstability;
    }

    public void setMaxhveemstability(BigDecimal maxhveemstability) {
        this.maxhveemstability = maxhveemstability;
    }

    public BigDecimal getDeshveemstability() {
        return deshveemstability;
    }

    public void setDeshveemstability(BigDecimal deshveemstability) {
        this.deshveemstability = deshveemstability;
    }

    public BigDecimal getMintsr() {
        return mintsr;
    }

    public void setMintsr(BigDecimal mintsr) {
        this.mintsr = mintsr;
    }

    public BigDecimal getMaxtsr() {
        return maxtsr;
    }

    public void setMaxtsr(BigDecimal maxtsr) {
        this.maxtsr = maxtsr;
    }

    public BigDecimal getDestsr() {
        return destsr;
    }

    public void setDestsr(BigDecimal destsr) {
        this.destsr = destsr;
    }

    public BigDecimal getDescompfdpcf() {
        return descompfdpcf;
    }

    public void setDescompfdpcf(BigDecimal descompfdpcf) {
        this.descompfdpcf = descompfdpcf;
    }

    public BigDecimal getDesmaxtheodens() {
        return desmaxtheodens;
    }

    public void setDesmaxtheodens(BigDecimal desmaxtheodens) {
        this.desmaxtheodens = desmaxtheodens;
    }

    public BigDecimal getTolminac() {
        return tolminac;
    }

    public void setTolminac(BigDecimal tolminac) {
        this.tolminac = tolminac;
    }

    public BigDecimal getTolmaxac() {
        return tolmaxac;
    }

    public void setTolmaxac(BigDecimal tolmaxac) {
        this.tolmaxac = tolmaxac;
    }

    public BigDecimal getTolminvtm() {
        return tolminvtm;
    }

    public void setTolminvtm(BigDecimal tolminvtm) {
        this.tolminvtm = tolminvtm;
    }

    public BigDecimal getTolmaxvtm() {
        return tolmaxvtm;
    }

    public void setTolmaxvtm(BigDecimal tolmaxvtm) {
        this.tolmaxvtm = tolmaxvtm;
    }

    public BigDecimal getTolminvma() {
        return tolminvma;
    }

    public void setTolminvma(BigDecimal tolminvma) {
        this.tolminvma = tolminvma;
    }

    public BigDecimal getTolmaxvma() {
        return tolmaxvma;
    }

    public void setTolmaxvma(BigDecimal tolmaxvma) {
        this.tolmaxvma = tolmaxvma;
    }

    public BigDecimal getTolminvfa() {
        return tolminvfa;
    }

    public void setTolminvfa(BigDecimal tolminvfa) {
        this.tolminvfa = tolminvfa;
    }

    public BigDecimal getTolmaxvfa() {
        return tolmaxvfa;
    }

    public void setTolmaxvfa(BigDecimal tolmaxvfa) {
        this.tolmaxvfa = tolmaxvfa;
    }

    public BigDecimal getTolmindpbr() {
        return tolmindpbr;
    }

    public void setTolmindpbr(BigDecimal tolmindpbr) {
        this.tolmindpbr = tolmindpbr;
    }

    public BigDecimal getTolmaxdpbr() {
        return tolmaxdpbr;
    }

    public void setTolmaxdpbr(BigDecimal tolmaxdpbr) {
        this.tolmaxdpbr = tolmaxdpbr;
    }

    public BigDecimal getTolminengac() {
        return tolminengac;
    }

    public void setTolminengac(BigDecimal tolminengac) {
        this.tolminengac = tolminengac;
    }

    public BigDecimal getTolmaxengac() {
        return tolmaxengac;
    }

    public void setTolmaxengac(BigDecimal tolmaxengac) {
        this.tolmaxengac = tolmaxengac;
    }

    public BigDecimal getTolminengvtm() {
        return tolminengvtm;
    }

    public void setTolminengvtm(BigDecimal tolminengvtm) {
        this.tolminengvtm = tolminengvtm;
    }

    public BigDecimal getTolmaxengvtm() {
        return tolmaxengvtm;
    }

    public void setTolmaxengvtm(BigDecimal tolmaxengvtm) {
        this.tolmaxengvtm = tolmaxengvtm;
    }

    public BigDecimal getTolminengvma() {
        return tolminengvma;
    }

    public void setTolminengvma(BigDecimal tolminengvma) {
        this.tolminengvma = tolminengvma;
    }

    public BigDecimal getTolmaxengvma() {
        return tolmaxengvma;
    }

    public void setTolmaxengvma(BigDecimal tolmaxengvma) {
        this.tolmaxengvma = tolmaxengvma;
    }

    public BigDecimal getTolminengvfa() {
        return tolminengvfa;
    }

    public void setTolminengvfa(BigDecimal tolminengvfa) {
        this.tolminengvfa = tolminengvfa;
    }

    public BigDecimal getTolmaxengvfa() {
        return tolmaxengvfa;
    }

    public void setTolmaxengvfa(BigDecimal tolmaxengvfa) {
        this.tolmaxengvfa = tolmaxengvfa;
    }

    public BigDecimal getTolminengdpbr() {
        return tolminengdpbr;
    }

    public void setTolminengdpbr(BigDecimal tolminengdpbr) {
        this.tolminengdpbr = tolminengdpbr;
    }

    public BigDecimal getTolmaxengdpbr() {
        return tolmaxengdpbr;
    }

    public void setTolmaxengdpbr(BigDecimal tolmaxengdpbr) {
        this.tolmaxengdpbr = tolmaxengdpbr;
    }

    public BigDecimal getTolminhveemstability() {
        return tolminhveemstability;
    }

    public void setTolminhveemstability(BigDecimal tolminhveemstability) {
        this.tolminhveemstability = tolminhveemstability;
    }

    public BigDecimal getTolmaxhveemstability() {
        return tolmaxhveemstability;
    }

    public void setTolmaxhveemstability(BigDecimal tolmaxhveemstability) {
        this.tolmaxhveemstability = tolmaxhveemstability;
    }

    public BigDecimal getTolmincompfd() {
        return tolmincompfd;
    }

    public void setTolmincompfd(BigDecimal tolmincompfd) {
        this.tolmincompfd = tolmincompfd;
    }

    public BigDecimal getTolmaxcompfd() {
        return tolmaxcompfd;
    }

    public void setTolmaxcompfd(BigDecimal tolmaxcompfd) {
        this.tolmaxcompfd = tolmaxcompfd;
    }

    public BigDecimal getDessieve200() {
        return dessieve200;
    }

    public void setDessieve200(BigDecimal dessieve200) {
        this.dessieve200 = dessieve200;
    }

    public BigDecimal getMinsieve200() {
        return minsieve200;
    }

    public void setMinsieve200(BigDecimal minsieve200) {
        this.minsieve200 = minsieve200;
    }

    public BigDecimal getMaxsieve200() {
        return maxsieve200;
    }

    public void setMaxsieve200(BigDecimal maxsieve200) {
        this.maxsieve200 = maxsieve200;
    }

    public BigDecimal getTolminsieve200() {
        return tolminsieve200;
    }

    public void setTolminsieve200(BigDecimal tolminsieve200) {
        this.tolminsieve200 = tolminsieve200;
    }

    public BigDecimal getTolmaxsieve200() {
        return tolmaxsieve200;
    }

    public void setTolmaxsieve200(BigDecimal tolmaxsieve200) {
        this.tolmaxsieve200 = tolmaxsieve200;
    }

    public String getCurrentJmfNo() {
        return currentJmfNo;
    }

    public void setCurrentJmfNo(String currentJmfNo) {
        this.currentJmfNo = currentJmfNo;
    }

    public String getPressCorrFactor() {
        return pressCorrFactor;
    }

    public void setPressCorrFactor(String pressCorrFactor) {
        this.pressCorrFactor = pressCorrFactor;
    }

    public String getPressIdSerialNo() {
        return pressIdSerialNo;
    }

    public void setPressIdSerialNo(String pressIdSerialNo) {
        this.pressIdSerialNo = pressIdSerialNo;
    }

    public BigDecimal getG1SpecGravAsp() {
        return g1SpecGravAsp;
    }

    public void setG1SpecGravAsp(BigDecimal g1SpecGravAsp) {
        this.g1SpecGravAsp = g1SpecGravAsp;
    }

    public BigDecimal getAcCorrFactor() {
        return acCorrFactor;
    }

    public void setAcCorrFactor(BigDecimal acCorrFactor) {
        this.acCorrFactor = acCorrFactor;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLtmfDate() {
        return ltmfDate;
    }

    public void setLtmfDate(Date ltmfDate) {
        this.ltmfDate = ltmfDate;
    }

    public GlobSieveSetsInfo getSetId() {
        return setId;
    }

    public void setSetId(GlobSieveSetsInfo setId) {
        this.setId = setId;
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

    public void setIsGlobal(String isglobal) {
        this.isGlobal = isglobal;
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

    public BigDecimal getRapPct() {
        return rapPct;
    }

    public void setRapPct(BigDecimal rapPct) {
        this.rapPct = rapPct;
    }

    @XmlTransient
    public List<QaaspmMixdesignMasterproject> getQaaspmMixdesignMasterProjectList() {
        return qaaspmMixdesignMasterProjectList;
    }

    public void setQaaspmMixdesignMasterProjectList(List<QaaspmMixdesignMasterproject> qaaspmMixdesignMasterProjectList) {
        this.qaaspmMixdesignMasterProjectList = qaaspmMixdesignMasterProjectList;
    }

    public void addProjectList(QaaspmMixdesignMasterproject item) {
        qaaspmMixdesignMasterProjectList.add(item);
        item.setMixDesignId(this);
    }

    public void removeProjectList(QaaspmMixdesignMasterproject item) {
        qaaspmMixdesignMasterProjectList.remove(item);
        item.setMixDesignId(null);
    }

    public void updateReferences(List<QaaspmMixdesignMasterproject> items) {
        List<QaaspmMixdesignMasterproject> currentList = new ArrayList<>();
        currentList.addAll(qaaspmMixdesignMasterProjectList);
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
        if (qaaspmMixdesignMasterProjectList != null && !qaaspmMixdesignMasterProjectList.isEmpty()) {
            qaaspmMixdesignMasterProjectList.forEach(p -> {
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
                .append(nmasId)
                .append(gyrationsId)
                .append(trafficLevelId)
                .append(pgBinderGradeId)
                .append(pgBinderAdditiveId)
                .append(additivePct)
                .append(recycleTypeId)
                .append(wmaTechtypeId)
                .append(wmaTechnologyId)
                .append(techPct)
                .append(gsb)
                .append(bulkSgGmb)
                .append(gmm)
                .append(desac)
                .append(minac)
                .append(maxac)
                .append(minengac)
                .append(maxengac)
                .append(desvtm)
                .append(minvtm)
                .append(maxvtm)
                .append(minengvtm)
                .append(maxengvtm)
                .append(desvma)
                .append(minvma)
                .append(maxvma)
                .append(minengvma)
                .append(maxengvma)
                .append(desvfa)
                .append(minvfa)
                .append(maxvfa)
                .append(minengvfa)
                .append(maxengvfa)
                .append(gse)
                .append(gasp)
                .append(pba)
                .append(pbe)
                .append(desdpbr)
                .append(mindpbr)
                .append(maxdpbr)
                .append(minengdpbr)
                .append(maxengdpbr)
                .append(mincompfd)
                .append(maxcompfd)
                .append(descompfd)
                .append(blows)
                .append(minstability)
                .append(maxstability)
                .append(desstability)
                .append(minflow)
                .append(maxflow)
                .append(desflow)
                .append(minjointden)
                .append(maxjointden)
                .append(desjointden)
                .append(minmatden)
                .append(maxmatden)
                .append(desmatden)
                .append(minhveemstability)
                .append(maxhveemstability)
                .append(deshveemstability)
                .append(mintsr)
                .append(maxtsr)
                .append(destsr)
                .append(descompfdpcf)
                .append(desmaxtheodens)
                .append(tolminac)
                .append(tolmaxac)
                .append(tolminvtm)
                .append(tolmaxvtm)
                .append(tolminvma)
                .append(tolmaxvma)
                .append(tolminvfa)
                .append(tolmaxvfa)
                .append(tolmindpbr)
                .append(tolmaxdpbr)
                .append(tolminengac)
                .append(tolmaxengac)
                .append(tolminengvtm)
                .append(tolmaxengvtm)
                .append(tolminengvma)
                .append(tolmaxengvma)
                .append(tolminengvfa)
                .append(tolmaxengvfa)
                .append(tolminengdpbr)
                .append(tolmaxengdpbr)
                .append(tolminhveemstability)
                .append(tolmaxhveemstability)
                .append(tolmincompfd)
                .append(tolmaxcompfd)
                .append(dessieve200)
                .append(minsieve200)
                .append(maxsieve200)
                .append(tolminsieve200)
                .append(tolmaxsieve200)
                .append(currentJmfNo)
                .append(pressCorrFactor)
                .append(pressIdSerialNo)
                .append(g1SpecGravAsp)
                .append(acCorrFactor)
                .append(approvedDate)
                .append(ltmfDate)
                .append(setId)
                .append(itemId)
                .append(matId)
                .append(rapPct)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaaspmMixdesignMaster)) {
            return false;
        }
        QaaspmMixdesignMaster other = (QaaspmMixdesignMaster) object;

        return new EqualsBuilder()
                .append(this.supplierId, other.supplierId)
                .append(this.supplierLocId, other.supplierLocId)
                .append(this.mixdesignType, other.mixdesignType)
                .append(this.mixStatus, other.mixStatus)
                .append(this.expirationDate, other.expirationDate)
                .append(this.nmasId, other.nmasId)
                .append(this.gyrationsId, other.gyrationsId)
                .append(this.trafficLevelId, other.trafficLevelId)
                .append(this.pgBinderGradeId, other.pgBinderGradeId)
                .append(this.pgBinderAdditiveId, other.pgBinderAdditiveId)
                .append(this.additivePct, other.additivePct)
                .append(this.recycleTypeId, other.recycleTypeId)
                .append(this.wmaTechtypeId, other.wmaTechtypeId)
                .append(this.wmaTechnologyId, other.wmaTechnologyId)
                .append(this.techPct, other.techPct)
                .append(this.gsb, other.gsb)
                .append(this.bulkSgGmb, other.bulkSgGmb)
                .append(this.gmm, other.gmm)
                .append(this.desac, other.desac)
                .append(this.minac, other.minac)
                .append(this.maxac, other.maxac)
                .append(this.minengac, other.minengac)
                .append(this.maxengac, other.maxengac)
                .append(this.desvtm, other.desvtm)
                .append(this.minvtm, other.minvtm)
                .append(this.maxvtm, other.maxvtm)
                .append(this.minengvtm, other.minengvtm)
                .append(this.maxengvtm, other.maxengvtm)
                .append(this.desvma, other.desvma)
                .append(this.minvma, other.minvma)
                .append(this.maxvma, other.maxvma)
                .append(this.minengvma, other.minengvma)
                .append(this.maxengvma, other.maxengvma)
                .append(this.desvfa, other.desvfa)
                .append(this.minvfa, other.minvfa)
                .append(this.maxvfa, other.maxvfa)
                .append(this.minengvfa, other.minengvfa)
                .append(this.maxengvfa, other.maxengvfa)
                .append(this.gse, other.gse)
                .append(this.gasp, other.gasp)
                .append(this.pba, other.pba)
                .append(this.pbe, other.pbe)
                .append(this.desdpbr, other.desdpbr)
                .append(this.mindpbr, other.mindpbr)
                .append(this.maxdpbr, other.maxdpbr)
                .append(this.minengdpbr, other.minengdpbr)
                .append(this.maxengdpbr, other.maxengdpbr)
                .append(this.mincompfd, other.mincompfd)
                .append(this.maxcompfd, other.maxcompfd)
                .append(this.descompfd, other.descompfd)
                .append(this.blows, other.blows)
                .append(this.minstability, other.minstability)
                .append(this.maxstability, other.maxstability)
                .append(this.desstability, other.desstability)
                .append(this.minflow, other.minflow)
                .append(this.maxflow, other.maxflow)
                .append(this.desflow, other.desflow)
                .append(this.minjointden, other.minjointden)
                .append(this.maxjointden, other.maxjointden)
                .append(this.desjointden, other.desjointden)
                .append(this.minmatden, other.minmatden)
                .append(this.maxmatden, other.maxmatden)
                .append(this.desmatden, other.desmatden)
                .append(this.minhveemstability, other.minhveemstability)
                .append(this.maxhveemstability, other.maxhveemstability)
                .append(this.deshveemstability, other.deshveemstability)
                .append(this.mintsr, other.mintsr)
                .append(this.maxtsr, other.maxtsr)
                .append(this.destsr, other.destsr)
                .append(this.descompfdpcf, other.descompfdpcf)
                .append(this.desmaxtheodens, other.desmaxtheodens)
                .append(this.tolminac, other.tolminac)
                .append(this.tolmaxac, other.tolmaxac)
                .append(this.tolminvtm, other.tolminvtm)
                .append(this.tolmaxvtm, other.tolmaxvtm)
                .append(this.tolminvma, other.tolminvma)
                .append(this.tolmaxvma, other.tolmaxvma)
                .append(this.tolminvfa, other.tolminvfa)
                .append(this.tolmaxvfa, other.tolmaxvfa)
                .append(this.tolmindpbr, other.tolmindpbr)
                .append(this.tolmaxdpbr, other.tolmaxdpbr)
                .append(this.tolminengac, other.tolminengac)
                .append(this.tolmaxengac, other.tolmaxengac)
                .append(this.tolminengvtm, other.tolminengvtm)
                .append(this.tolmaxengvtm, other.tolmaxengvtm)
                .append(this.tolminengvma, other.tolminengvma)
                .append(this.tolmaxengvma, other.tolmaxengvma)
                .append(this.tolminengvfa, other.tolminengvfa)
                .append(this.tolmaxengvfa, other.tolmaxengvfa)
                .append(this.tolminengdpbr, other.tolminengdpbr)
                .append(this.tolmaxengdpbr, other.tolmaxengdpbr)
                .append(this.tolminhveemstability, other.tolminhveemstability)
                .append(this.tolmaxhveemstability, other.tolmaxhveemstability)
                .append(this.tolmincompfd, other.tolmincompfd)
                .append(this.tolmaxcompfd, other.tolmaxcompfd)
                .append(this.dessieve200, other.dessieve200)
                .append(this.minsieve200, other.minsieve200)
                .append(this.maxsieve200, other.maxsieve200)
                .append(this.tolminsieve200, other.tolminsieve200)
                .append(this.tolmaxsieve200, other.tolmaxsieve200)
                .append(this.currentJmfNo, other.currentJmfNo)
                .append(this.pressCorrFactor, other.pressCorrFactor)
                .append(this.pressIdSerialNo, other.pressIdSerialNo)
                .append(this.g1SpecGravAsp, other.g1SpecGravAsp)
                .append(this.acCorrFactor, other.acCorrFactor)
                .append(this.approvedDate, other.approvedDate)
                .append(this.ltmfDate, other.ltmfDate)
                .append(this.setId, other.setId)
                .append(this.itemId, other.itemId)
                .append(this.matId, other.matId)
                .append(this.rapPct, other.rapPct)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignMaster[ id=" + id + " ]";
    }

    public QaaspmMixDesignsTO generateQaaspmMixDesignsTO() {
        QaaspmMixDesignsTO to = new QaaspmMixDesignsTO();
        to.setMixdesignNo(getMixdesignNo());
        to.setParentMixdesignNo(getParentMixdesignNo());
        to.setCatg(getCatg());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier() : "");
        to.setSupplierLoc(getSupplierLocId() != null ? getSupplierLocId().getLocation() : "");
        to.setMixdesignType(getMixdesignType() != null ? getMixdesignType().getValue() : "");
        to.setMixdesignDescription(getMixdesignDescription());
        to.setMixdesignRemark(getMixdesignRemark());
        to.setNmasId(getNmasId() != null ? getNmasId().getValue() : "");
        to.setGyrationsId(getGyrationsId() != null ? getGyrationsId().getValue() : "");
        to.setTrafficLevelId(getTrafficLevelId() != null ? getTrafficLevelId().getValue() : "");
        to.setPgBinderGradeId(getPgBinderGradeId() != null ? getPgBinderGradeId().getValue() : "");
        to.setPgBinderAdditiveId(getPgBinderAdditiveId() != null ? getPgBinderAdditiveId().getValue() : "");
        to.setAdditivePct(StringSupport.getString(getAdditivePct()));
        to.setRecycleTypeId(getRecycleTypeId() != null ? getRecycleTypeId().getValue() : "");
        to.setWmaTechtypeId(getWmaTechtypeId() != null ? getWmaTechtypeId().getValue() : "");
        to.setWmaTechnologyId(getWmaTechnologyId() != null ? getWmaTechnologyId().getValue() : "");
        to.setTechPct(StringSupport.getString(getTechPct()));
        to.setGsb(StringSupport.getString(getGsb()));
        to.setBulkSgGmb(StringSupport.getString(getBulkSgGmb()));
        to.setGmm(StringSupport.getString(getGmm()));
        to.setDesac(StringSupport.getString(getDesac()));
        to.setMinac(StringSupport.getString(getMinac()));
        to.setMaxac(StringSupport.getString(getMaxac()));
        to.setMinengac(StringSupport.getString(getMinengac()));
        to.setMaxengac(StringSupport.getString(getMaxengac()));
        to.setDesvtm(StringSupport.getString(getDesvtm()));
        to.setMinvtm(StringSupport.getString(getMinvtm()));
        to.setMaxvtm(StringSupport.getString(getMaxvtm()));
        to.setMinengvtm(StringSupport.getString(getMinengvtm()));
        to.setMaxengvtm(StringSupport.getString(getMaxengvtm()));
        to.setDesvma(StringSupport.getString(getDesvma()));
        to.setMinvma(StringSupport.getString(getMinvma()));
        to.setMaxvma(StringSupport.getString(getMaxvma()));
        to.setMinengvma(StringSupport.getString(getMinengvma()));
        to.setDesvfa(StringSupport.getString(getDesvfa()));
        to.setMinvfa(StringSupport.getString(getMinvfa()));
        to.setMaxvfa(StringSupport.getString(getMaxvfa()));
        to.setMinengvfa(StringSupport.getString(getMinengvfa()));
        to.setMaxengvfa(StringSupport.getString(getMaxengvfa()));
        to.setGse(StringSupport.getString(getGse()));
        to.setGasp(StringSupport.getString(getGasp()));
        to.setPba(StringSupport.getString(getPba()));
        to.setPbe(StringSupport.getString(getPbe()));
        to.setDesdpbr(StringSupport.getString(getDesdpbr()));
        to.setMindpbr(StringSupport.getString(getMindpbr()));
        to.setMaxdpbr(StringSupport.getString(getMaxdpbr()));
        to.setMinengdpbr(StringSupport.getString(getMinengdpbr()));
        to.setMaxengdpbr(StringSupport.getString(getMaxengdpbr()));
        to.setMincompfd(StringSupport.getString(getMincompfd()));
        to.setMaxcompfd(StringSupport.getString(getMaxcompfd()));
        to.setDescompfd(StringSupport.getString(getDescompfd()));
        to.setBlows(StringSupport.getString(getBlows()));
        to.setMinstability(StringSupport.getString(getMinstability()));
        to.setMaxstability(StringSupport.getString(getMaxstability()));
        to.setDesstability(StringSupport.getString(getDesstability()));
        to.setMinflow(StringSupport.getString(getMinflow()));
        to.setMaxflow(StringSupport.getString(getMaxflow()));
        to.setDesflow(StringSupport.getString(getDesflow()));
        to.setMinjointden(StringSupport.getString(getMinjointden()));
        to.setMaxjointden(StringSupport.getString(getMaxjointden()));
        to.setDesjointden(StringSupport.getString(getDesjointden()));
        to.setMinmatden(StringSupport.getString(getMinmatden()));
        to.setMaxmatden(StringSupport.getString(getMaxmatden()));
        to.setDesmatden(StringSupport.getString(getDesmatden()));
        to.setMinhveemstability(StringSupport.getString(getMinhveemstability()));
        to.setMaxhveemstability(StringSupport.getString(getMaxhveemstability()));
        to.setDeshveemstability(StringSupport.getString(getDeshveemstability()));
        to.setMintsr(StringSupport.getString(getMintsr()));
        to.setMaxtsr(StringSupport.getString(getMaxtsr()));
        to.setDestsr(StringSupport.getString(getDestsr()));
        to.setDescompfdpcf(StringSupport.getString(getDescompfdpcf()));
        to.setDesmaxtheodens(StringSupport.getString(getDesmaxtheodens()));
        to.setTolminac(StringSupport.getString(getTolminac()));
        to.setTolmaxac(StringSupport.getString(getTolmaxac()));
        to.setTolminvtm(StringSupport.getString(getTolminvtm()));
        to.setTolmaxvtm(StringSupport.getString(getTolmaxvtm()));
        to.setTolminvma(StringSupport.getString(getTolminvma()));
        to.setTolmaxvma(StringSupport.getString(getTolmaxvma()));
        to.setTolminvfa(StringSupport.getString(getTolminvfa()));
        to.setTolmaxvfa(StringSupport.getString(getTolmaxvfa()));
        to.setTolmindpbr(StringSupport.getString(getTolmindpbr()));
        to.setTolmaxdpbr(StringSupport.getString(getTolmaxdpbr()));
        to.setTolminengac(StringSupport.getString(getTolminengac()));
        to.setTolmaxengac(StringSupport.getString(getTolmaxengac()));
        to.setTolminengvtm(StringSupport.getString(getTolminengvtm()));
        to.setTolmaxengvtm(StringSupport.getString(getTolmaxengvtm()));
        to.setTolminengvma(StringSupport.getString(getTolminengvma()));
        to.setTolmaxengvma(StringSupport.getString(getTolmaxengvma()));
        to.setTolminengvfa(StringSupport.getString(getTolminengvfa()));
        to.setTolmaxengvfa(StringSupport.getString(getTolmaxengvfa()));
        to.setTolminengdpbr(StringSupport.getString(getTolminengdpbr()));
        to.setTolmaxengdpbr(StringSupport.getString(getTolmaxengdpbr()));
        to.setTolminhveemstability(StringSupport.getString(getTolminhveemstability()));
        to.setTolmaxhveemstability(StringSupport.getString(getTolmaxhveemstability()));
        to.setTolmincompfd(StringSupport.getString(getTolmincompfd()));
        to.setTolmaxcompfd(StringSupport.getString(getTolmaxcompfd()));
        to.setDessieve200(StringSupport.getString(getDessieve200()));
        to.setMinsieve200(StringSupport.getString(getMinsieve200()));
        to.setMaxsieve200(StringSupport.getString(getMaxsieve200()));
        to.setTolminsieve200(StringSupport.getString(getTolminsieve200()));
        to.setTolmaxsieve200(StringSupport.getString(getTolmaxsieve200()));
        to.setCurrentJmfNo(getCurrentJmfNo());
        to.setPressCorrFactor(getPressCorrFactor());
        to.setPressIdSerialNo(getPressIdSerialNo());
        to.setG1SpecGravAsp(StringSupport.getString(getG1SpecGravAsp()));
        to.setAcCorrFactor(StringSupport.getString(getAcCorrFactor()));
        to.setLtmfDate(DateSupport.formatDate(getLtmfDate(), DateSupport.FORMAT_US));
        to.setApprovedDate(DateSupport.formatDate(getApprovedDate(), DateSupport.FORMAT_US));
        to.setExpirationDate(DateSupport.formatDate(getExpirationDate(), DateSupport.FORMAT_US));
        to.setMixStatus(getMixStatus());
        to.setSetId(getSetId() != null ? getSetId().getSetName() : "");
        to.setRapPct(StringSupport.getString(getRapPct()));
        return to;
    }
}
