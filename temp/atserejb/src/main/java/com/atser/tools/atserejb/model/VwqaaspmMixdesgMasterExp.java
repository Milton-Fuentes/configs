/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Where(clause = "deleted = 'N'")
@Table(name = "VW_QAASPM_MIXDESG_MASTER_EXP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwqaaspmMixdesgMasterExp.findAll", query = "SELECT a FROM VwqaaspmMixdesgMasterExp a")})
public class VwqaaspmMixdesgMasterExp implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JsonIgnore
    @Column(name = "SET_ID")
    BigInteger setId;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "MIXDESIGN_NO")
    private String mixdesignNo;
    @Size(max = 255)
    @Column(name = "PARENT_MIXDESIGN_NO")
    private String parentMixdesignNo;
    @Column(name = "RAP_PCT")
    private BigDecimal rapPct;
    @Size(max = 255)
    @Column(name = "PRODUCED_BY")
    private String producedBy;
    @Size(max = 250)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 255)
    @Column(name = "NMAS")
    private String nmas;
    @Size(max = 255)
    @Column(name = "GYRATIONS")
    private String gyrations;
    @Size(max = 255)
    @Column(name = "MIXDESIGN_TYPE")
    private String mixdesignType;
    @Size(max = 255)
    @Column(name = "TRAFFIC_LEVEL")
    private String trafficLevel;
    @Size(max = 255)
    @Column(name = "PG_BINDER_GRADE")
    private String pgBinderGrade;
    @Size(max = 255)
    @Column(name = "PG_BINDER_ADDITIVE")
    private String pgBinderAdditive;
    @Column(name = "ADDITIVE_PCT")
    private BigDecimal additivePct;
    @Size(max = 255)
    @Column(name = "RECYCLE_TYPE")
    private String recycleType;
    @Size(max = 255)
    @Column(name = "WMA_TECH_TYPE")
    private String wmaTechType;
    @Size(max = 255)
    @Column(name = "WMA_TECHNOLOGY")
    private String wmaTechnology;
    @Column(name = "TECH_PCT")
    private BigDecimal techPct;
    @Size(max = 100)
    @Column(name = "MIX_STATUS")
    private String mixStatus;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Column(name = "LTMF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ltmfDate;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "GSB")
    private BigDecimal gsb;
    @Column(name = "BULK_SG_GMB")
    private BigDecimal bulkSgGmb;
    @Column(name = "GMM")
    private BigDecimal gmm;
    @Column(name = "TOLMINAC")
    private BigDecimal tolminac;
    @Column(name = "TOLMAXAC")
    private BigDecimal tolmaxac;
    @Column(name = "TOLMINENGAC")
    private BigDecimal tolminengac;
    @Column(name = "TOLMAXENGAC")
    private BigDecimal tolmaxengac;
    @Column(name = "TOLMINVTM")
    private BigDecimal tolminvtm;
    @Column(name = "TOLMAXVTM")
    private BigDecimal tolmaxvtm;
    @Column(name = "TOLMINENGVTM")
    private BigDecimal tolminengvtm;
    @Column(name = "TOLMAXENGVTM")
    private BigDecimal tolmaxengvtm;
    @Column(name = "TOLMINVMA")
    private BigDecimal tolminvma;
    @Column(name = "TOLMAXVMA")
    private BigDecimal tolmaxvma;
    @Column(name = "TOLMINENGVMA")
    private BigDecimal tolminengvma;
    @Column(name = "TOLMAXENGVMA")
    private BigDecimal tolmaxengvma;
    @Column(name = "TOLMINVFA")
    private BigDecimal tolminvfa;
    @Column(name = "TOLMAXVFA")
    private BigDecimal tolmaxvfa;
    @Column(name = "TOLMINENGVFA")
    private BigDecimal tolminengvfa;
    @Column(name = "TOLMAXENGVFA")
    private BigDecimal tolmaxengvfa;
    @Column(name = "TOLMINDPBR")
    private BigDecimal tolmindpbr;
    @Column(name = "TOLMAXDPBR")
    private BigDecimal tolmaxdpbr;
    @Column(name = "TOLMINENGDPBR")
    private BigDecimal tolminengdpbr;
    @Column(name = "TOLMAXENGDPBR")
    private BigDecimal tolmaxengdpbr;
    @Column(name = "GSE")
    private BigDecimal gse;
    @Column(name = "GASP")
    private BigDecimal gasp;
    @Column(name = "PBA")
    private BigDecimal pba;
    @Column(name = "PBE")
    private BigDecimal pbe;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Where(clause = "main = 'Y'")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mixId", fetch = FetchType.EAGER)
    private List<VwQaaspmMixdjmfMasterExp> jmfList;

    public VwqaaspmMixdesgMasterExp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
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

    public BigDecimal getRapPct() {
        return rapPct;
    }

    public void setRapPct(BigDecimal rapPct) {
        this.rapPct = rapPct;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNmas() {
        return nmas;
    }

    public void setNmas(String nmas) {
        this.nmas = nmas;
    }

    public String getGyrations() {
        return gyrations;
    }

    public void setGyrations(String gyrations) {
        this.gyrations = gyrations;
    }

    public String getMixdesignType() {
        return mixdesignType;
    }

    public void setMixdesignType(String mixdesignType) {
        this.mixdesignType = mixdesignType;
    }

    public String getTrafficLevel() {
        return trafficLevel;
    }

    public void setTrafficLevel(String trafficLevel) {
        this.trafficLevel = trafficLevel;
    }

    public String getPgBinderGrade() {
        return pgBinderGrade;
    }

    public void setPgBinderGrade(String pgBinderGrade) {
        this.pgBinderGrade = pgBinderGrade;
    }

    public String getPgBinderAdditive() {
        return pgBinderAdditive;
    }

    public void setPgBinderAdditive(String pgBinderAdditive) {
        this.pgBinderAdditive = pgBinderAdditive;
    }

    public BigDecimal getAdditivePct() {
        return additivePct;
    }

    public void setAdditivePct(BigDecimal additivePct) {
        this.additivePct = additivePct;
    }

    public String getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(String recycleType) {
        this.recycleType = recycleType;
    }

    public String getWmaTechType() {
        return wmaTechType;
    }

    public void setWmaTechType(String wmaTechType) {
        this.wmaTechType = wmaTechType;
    }

    public String getWmaTechnology() {
        return wmaTechnology;
    }

    public void setWmaTechnology(String wmaTechnology) {
        this.wmaTechnology = wmaTechnology;
    }

    public BigDecimal getTechPct() {
        return techPct;
    }

    public void setTechPct(BigDecimal techPct) {
        this.techPct = techPct;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLtmfDate() {
        return ltmfDate;
    }

    public void setLtmfDate(Date ltmfDate) {
        this.ltmfDate = ltmfDate;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public List<VwQaaspmMixdjmfMasterExp> getJmfList() {
        return jmfList;
    }

    public void setJmfList(List<VwQaaspmMixdjmfMasterExp> jmfList) {
        this.jmfList = jmfList;
    }
}
