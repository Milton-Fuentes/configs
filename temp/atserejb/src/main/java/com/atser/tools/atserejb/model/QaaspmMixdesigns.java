/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsLogTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign.QaaspmMixDesignsTO;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "QaaspmMixdesigns.findByProjectId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMixdesign", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mixdesign = :mixdesign"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMixtype", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mixtype = :mixtype"),
    @NamedQuery(name = "QaaspmMixdesigns.findByCatg", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.catg = :catg"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinvtm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minvtm = :minvtm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxvtm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxvtm = :maxvtm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesvtm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desvtm = :desvtm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinvma", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minvma = :minvma"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxvma", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxvma = :maxvma"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesvma", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desvma = :desvma"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMincompfd", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mincompfd = :mincompfd"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxcompfd", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxcompfd = :maxcompfd"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDescompfd", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.descompfd = :descompfd"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minac = :minac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxac = :maxac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desac = :desac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByBlows", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.blows = :blows"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minstability = :minstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxstability = :maxstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desstability = :desstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinflow", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minflow = :minflow"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxflow", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxflow = :maxflow"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesflow", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desflow = :desflow"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinjointden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minjointden = :minjointden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxjointden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxjointden = :maxjointden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesjointden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desjointden = :desjointden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinmatden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minmatden = :minmatden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxmatden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxmatden = :maxmatden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesmatden", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desmatden = :desmatden"),
    @NamedQuery(name = "QaaspmMixdesigns.findByAspmixId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.aspmixId = :aspmixId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinhveemstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minhveemstability = :minhveemstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxhveemstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxhveemstability = :maxhveemstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDeshveemstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.deshveemstability = :deshveemstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinvfa", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minvfa = :minvfa"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxvfa", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxvfa = :maxvfa"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesvfa", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desvfa = :desvfa"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMintsr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mintsr = :mintsr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxtsr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxtsr = :maxtsr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDestsr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.destsr = :destsr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDescompfdpcf", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.descompfdpcf = :descompfdpcf"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesmaxtheodens", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desmaxtheodens = :desmaxtheodens"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolminac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolminac = :tolminac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolmaxac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolmaxac = :tolmaxac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolminhveemstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolminhveemstability = :tolminhveemstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolmaxhveemstability", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolmaxhveemstability = :tolmaxhveemstability"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolmincompfd", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolmincompfd = :tolmincompfd"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolmaxcompfd", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolmaxcompfd = :tolmaxcompfd"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDessieve200", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.dessieve200 = :dessieve200"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinsieve200", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minsieve200 = :minsieve200"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxsieve200", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxsieve200 = :maxsieve200"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolminsieve200", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolminsieve200 = :tolminsieve200"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTolmaxsieve200", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.tolmaxsieve200 = :tolmaxsieve200"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMixDate", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mixDate = :mixDate"),
    @NamedQuery(name = "QaaspmMixdesigns.findBySetId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.setId = :setId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByItemId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMatId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.matId = :matId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByGsb", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.gsb = :gsb"),
    @NamedQuery(name = "QaaspmMixdesigns.findByGmm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.gmm = :gmm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByGasp", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.gasp = :gasp"),
    @NamedQuery(name = "QaaspmMixdesigns.findBySupplier", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.supplier = :supplier"),
    @NamedQuery(name = "QaaspmMixdesigns.findByCurrentJmfNo", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.currentJmfNo = :currentJmfNo"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPressCorrFactor", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pressCorrFactor = :pressCorrFactor"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPressIdSerialNo", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pressIdSerialNo = :pressIdSerialNo"),
    @NamedQuery(name = "QaaspmMixdesigns.findByG1SpecGravAsp", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.g1SpecGravAsp = :g1SpecGravAsp"),
    @NamedQuery(name = "QaaspmMixdesigns.findByCreateDate", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaaspmMixdesigns.findByCreateBy", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaaspmMixdesigns.findByCreateByIp", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaaspmMixdesigns.findByLastMod", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesigns.findByLastModBy", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesigns.findByLastModIp", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesigns.findByVersion", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.version = :version"),
    @NamedQuery(name = "QaaspmMixdesigns.findByAcCorrFactor", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.acCorrFactor = :acCorrFactor"),
    @NamedQuery(name = "QaaspmMixdesigns.findBySupplierId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaaspmMixdesigns.findBySupplierLocId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.supplierLocId = :supplierLocId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMixdesignDescription", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mixdesignDescription = :mixdesignDescription"),
    @NamedQuery(name = "QaaspmMixdesigns.findByParentMixdesignNo", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.parentMixdesignNo = :parentMixdesignNo"),
    @NamedQuery(name = "QaaspmMixdesigns.findByNmasId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.nmasId = :nmasId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByGyrationsId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.gyrationsId = :gyrationsId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTrafficLevelId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.trafficLevelId = :trafficLevelId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPgBinderGradeId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pgBinderGradeId = :pgBinderGradeId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPgBinderAdditiveId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pgBinderAdditiveId = :pgBinderAdditiveId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByAdditivePct", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.additivePct = :additivePct"),
    @NamedQuery(name = "QaaspmMixdesigns.findByRecycleTypeId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.recycleTypeId = :recycleTypeId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByWmaTechtypeId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.wmaTechtypeId = :wmaTechtypeId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByWmaTechnologyId", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.wmaTechnologyId = :wmaTechnologyId"),
    @NamedQuery(name = "QaaspmMixdesigns.findByTechPct", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.techPct = :techPct"),
    @NamedQuery(name = "QaaspmMixdesigns.findByBulkSgGmb", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.bulkSgGmb = :bulkSgGmb"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinengac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minengac = :minengac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxengac", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxengac = :maxengac"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinengvtm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minengvtm = :minengvtm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxengvtm", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxengvtm = :maxengvtm"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinengvma", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minengvma = :minengvma"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxengvma", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxengvma = :maxengvma"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinengvfa", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minengvfa = :minengvfa"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxengvfa", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxengvfa = :maxengvfa"),
    @NamedQuery(name = "QaaspmMixdesigns.findByGse", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.gse = :gse"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPba", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pba = :pba"),
    @NamedQuery(name = "QaaspmMixdesigns.findByPbe", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.pbe = :pbe"),
    @NamedQuery(name = "QaaspmMixdesigns.findByDesdpbr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.desdpbr = :desdpbr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMindpbr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.mindpbr = :mindpbr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxdpbr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxdpbr = :maxdpbr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMinengdpbr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.minengdpbr = :minengdpbr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMaxengdpbr", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.maxengdpbr = :maxengdpbr"),
    @NamedQuery(name = "QaaspmMixdesigns.findByLtmfDate", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.ltmfDate = :ltmfDate"),
    @NamedQuery(name = "QaaspmMixdesigns.findByMasterrefid", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.masterrefid = :masterrefid")
 */
/**
 *
 * @author droldan
 */
@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "UPDATE QAASPM_MIXDESIGNS SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "QAASPM_MIXDESIGNS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesigns.findAll", query = "SELECT q FROM QaaspmMixdesigns q"),
    @NamedQuery(name = "QaaspmMixdesigns.findById", query = "SELECT q FROM QaaspmMixdesigns q WHERE q.id = :id")})
public class QaaspmMixdesigns implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QAASPM_MIXDESIGNS_id_seq", sequenceName = "QAASPM_MIXDESIGNS_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QAASPM_MIXDESIGNS_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "MIXDESIGN")
    private String mixdesign;
    @Size(max = 20)
    @Column(name = "MIXTYPE")
    private String mixtype;
    @Size(max = 255)
    @Column(name = "CATG")
    private String catg;
    @Column(name = "MINVTM")
    private BigDecimal minvtm;
    @Column(name = "MAXVTM")
    private BigDecimal maxvtm;
    @Column(name = "DESVTM")
    private BigDecimal desvtm;
    @Column(name = "MINVMA")
    private BigDecimal minvma;
    @Column(name = "MAXVMA")
    private BigDecimal maxvma;
    @Column(name = "DESVMA")
    private BigDecimal desvma;
    @Column(name = "MINCOMPFD")
    private BigDecimal mincompfd;
    @Column(name = "MAXCOMPFD")
    private BigDecimal maxcompfd;
    @Column(name = "DESCOMPFD")
    private BigDecimal descompfd;
    @Column(name = "MINAC")
    private BigDecimal minac;
    @Column(name = "MAXAC")
    private BigDecimal maxac;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "DESAC")
    private BigDecimal desac;
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
    @Column(name = "ASPMIX_ID")
    private BigInteger aspmixId;
    @Column(name = "MINHVEEMSTABILITY")
    private BigDecimal minhveemstability;
    @Column(name = "MAXHVEEMSTABILITY")
    private BigDecimal maxhveemstability;
    @Column(name = "DESHVEEMSTABILITY")
    private BigDecimal deshveemstability;
    @Column(name = "MINVFA")
    private BigDecimal minvfa;
    @Column(name = "MAXVFA")
    private BigDecimal maxvfa;
    @Column(name = "DESVFA")
    private BigDecimal desvfa;
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
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "MIX_DATE")
    @Temporal(TemporalType.TIMESTAMP)

    private Date mixDate;
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private GlobSieveSetsInfo setId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "GSB")
    private BigDecimal gsb;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "GMM")
    private BigDecimal gmm;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "GASP")
    private BigDecimal gasp;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "RAP_PCT")
    private BigDecimal rapPct;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 500)
    @Column(name = "SUPPLIER")
    private String supplier;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "CURRENT_JMF_NO")
    private String currentJmfNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "PRESS_CORR_FACTOR")
    private String pressCorrFactor;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "PRESS_ID_SERIAL_NO")
    private String pressIdSerialNo;
    @Column(name = "G1_SPEC_GRAV_ASP")
    private BigDecimal g1SpecGravAsp;
    //------------------------------
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
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
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
    //--------------------------
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "AC_CORR_FACTOR")
    private BigDecimal acCorrFactor;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(optional = true)
    private GlobSupplier supplierId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "SUPPLIER_LOC_ID")
    @ManyToOne(optional = true)
    private GlobSupplierAddress supplierLocId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 4000)
    @Column(name = "MIXDESIGN_DESCRIPTION")
    private String mixdesignDescription;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "PARENT_MIXDESIGN_NO")
    private String parentMixdesignNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "NMAS_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData nmasId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "GYRATIONS_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData gyrationsId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "TRAFFIC_LEVEL_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData trafficLevelId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "PG_BINDER_GRADE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData pgBinderGradeId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "PG_BINDER_ADDITIVE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData pgBinderAdditiveId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "ADDITIVE_PCT")
    private BigDecimal additivePct;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "RECYCLE_TYPE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData recycleTypeId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "WMA_TECHTYPE_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData wmaTechtypeId;
    @EqualsAndHashCode.Include
    @ToString.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "WMA_TECHNOLOGY_ID")
    @ManyToOne(optional = true)
    private QmCvlFieldData wmaTechnologyId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "TECH_PCT")
    private BigDecimal techPct;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "BULK_SG_GMB")
    private BigDecimal bulkSgGmb;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINENGAC")
    private BigDecimal minengac;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXENGAC")
    private BigDecimal maxengac;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINENGVTM")
    private BigDecimal minengvtm;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXENGVTM")
    private BigDecimal maxengvtm;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINENGVMA")
    private BigDecimal minengvma;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXENGVMA")
    private BigDecimal maxengvma;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINENGVFA")
    private BigDecimal minengvfa;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXENGVFA")
    private BigDecimal maxengvfa;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "GSE")
    private BigDecimal gse;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "PBA")
    private BigDecimal pba;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "PBE")
    private BigDecimal pbe;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "DESDPBR")
    private BigDecimal desdpbr;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINDPBR")
    private BigDecimal mindpbr;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXDPBR")
    private BigDecimal maxdpbr;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MINENGDPBR")
    private BigDecimal minengdpbr;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MAXENGDPBR")
    private BigDecimal maxengdpbr;
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "LTMF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ltmfDate;

    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "MASTERREFID")
    private BigInteger masterrefid;
    @Column(name = "ACTIVE", insertable = false, updatable = false)
    private Character active;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Transient
    @JsonProperty("canBeDeleted")
    private String canbeDeleted;

    public QaaspmMixdesigns() {
        canbeDeleted = "true";
    }

    public QaaspmMixdesigns(BigDecimal id) {
        canbeDeleted = "true";
        this.id = id;
    }

    public QaaspmMixdesigns(BigDecimal id, BigInteger projectId, String mixdesign) {
        this.id = id;
        this.projectId = projectId;
        this.mixdesign = mixdesign;
        canbeDeleted = "true";
    }

    public QaaspmMixDesignsTO generateTO() {
        QaaspmMixDesignsTO to = new QaaspmMixDesignsTO();
        to.setMixdesignNo(getMixdesign());
        to.setParentMixdesignNo(getParentMixdesignNo());
        to.setCatg(getCatg());
        to.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier() : "");
        to.setSupplierLoc(getSupplierLocId() != null ? getSupplierLocId().getLocation() : "");
        to.setMixdesignType(getMixtype());
        to.setMixdesignDescription(getMixdesignDescription());
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
        to.setRapPct(StringSupport.getString(getRapPct()));
        //to.setApprovedDate(DateSupport.formatDate(getApprovedDate(), DateSupport.FORMAT_US));
        //to.setExpirationDate(DateSupport.formatDate(getExpirationDate(), DateSupport.FORMAT_US));
        to.setSetId(getSetId() != null ? getSetId().getSetName() : "");
        return to;
    }

    public QaaspmMixDesignsLogTO generateLogTO() {
        QaaspmMixDesignsLogTO obj = new QaaspmMixDesignsLogTO();
        obj.setSupplier(getSupplierId() != null ? getSupplierId().getSupplier() : "");
        obj.setLocation(getSupplierLocId() != null ? getSupplierLocId().getLocation() : "");
        obj.setNmasId(getNmasId() != null ? getNmasId().getValue() : "");
        obj.setGyrationsId(getGyrationsId() != null ? getGyrationsId().getValue() : "");
        obj.setMixdesignType(getMixtype());
        obj.setMixdesignNo(getMixdesign());
        obj.setCreated(getCreateDate());
        //obj.setJmfApprovedDate(DateSupport.formatDate(getJmfApprovedDate(), DateSupport.FORMAT_US));
        //obj.setExpirationDate(DateSupport.formatDate(getExpirationDate(), DateSupport.FORMAT_US));
        return obj;
    }

}
