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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "VW_QAASPM_MIXDESG_MASTER", catalog = "", schema = "ORACLE")
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQaaspmMixDesgMaster.findAll", query = "SELECT a FROM VwQaaspmMixDesgMaster a")})
public class VwQaaspmMixDesgMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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
    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(optional = false)
    private GlobSupplier supplierId;
    @JoinColumn(name = "SUPPLIER_LOC_ID")
    @ManyToOne(optional = true)
    private GlobSupplierAddress supplierLocId;
    @JoinColumn(name = "MIXDESIGN_TYPE")
    @ManyToOne(optional = false)
    private QmCvlFieldData mixdesignType;
    @Size(max = 4000)
    @Column(name = "MIXDESIGN_DESCRIPTION")
    private String mixdesignDescription;
    @Size(max = 500)
    @Column(name = "MIXDESIGN_REMARK")
    private String mixdesignRemark;
    @JoinColumn(name = "NMAS_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData nmasId;
    @JoinColumn(name = "GYRATIONS_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData gyrationsId;
    @JoinColumn(name = "TRAFFIC_LEVEL_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData trafficLevelId;
    @JoinColumn(name = "PG_BINDER_GRADE_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData pgBinderGradeId;
    @JoinColumn(name = "PG_BINDER_ADDITIVE_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData pgBinderAdditiveId;
    @Column(name = "ADDITIVE_PCT")
    private BigDecimal additivePct;
    @JoinColumn(name = "RECYCLE_TYPE_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData recycleTypeId;
    @JoinColumn(name = "WMA_TECHTYPE_ID")
    @ManyToOne(optional = false)
    private QmCvlFieldData wmaTechtypeId;
    @JoinColumn(name = "WMA_TECHNOLOGY_ID")
    @ManyToOne(optional = false)
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
    @JoinColumn(name = "SET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSieveSetsInfo setId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
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
    @Column(name = "DELETED")
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "VERSION")
    private Long version;
    @Column(name = "JMFAPPROVEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jmfApprovedDate;

    public VwQaaspmMixDesgMaster() {
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
    public Date getJmfApprovedDate() {
        return jmfApprovedDate;
    }

    public void setJmfApprovedDate(Date jmfApprovedDate) {
        this.jmfApprovedDate = jmfApprovedDate;
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

    public QaaspmMixDesignsLogTO generateTO() {
        QaaspmMixDesignsLogTO obj = new QaaspmMixDesignsLogTO();
        if (getSupplierId() != null) {
            obj.setSupplier(getSupplierId().getSupplier());
        }
        if (getSupplierLocId() != null) {
            obj.setLocation(getSupplierLocId().getLocation());
        }
        if (getNmasId() != null) {
            obj.setNmasId(getNmasId().getValue());
        }
        if (getGyrationsId() != null) {
            obj.setGyrationsId(getGyrationsId().getValue());
        }
        if (getMixdesignType() != null) {
            obj.setMixdesignType(getMixdesignType().getValue());
        }
        obj.setMixdesignNo(getMixdesignNo());
        obj.setCreated(DateSupport.formatDate(getCreated(), DateSupport.FORMAT_MMDDYY_HHMMSS_24SLASH));
        obj.setJmfApprovedDate(DateSupport.formatDate(getJmfApprovedDate(), DateSupport.FORMAT_US));
        obj.setExpirationDate(DateSupport.formatDate(getExpirationDate(), DateSupport.FORMAT_US));
        return obj;
    }

}
