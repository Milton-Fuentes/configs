package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Where(clause = "deleted = 'N'")
@Table(name = "VW_QAASPM_MIXDJMF_MASTER_EXP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQaaspmMixdjmfMasterExp.findAll", query = "SELECT a FROM VwQaaspmMixdjmfMasterExp a")})
public class VwQaaspmMixdjmfMasterExp implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "JMF_NO")
    private BigInteger jmfNo;
    @JsonIgnore
    @Column(name = "MIX_ID")
    private BigInteger mixId;
    @Column(name = "TARGETAC")
    private BigDecimal targetac;
    @Column(name = "MINAC")
    private BigDecimal minac;
    @Column(name = "MAXAC")
    private BigDecimal maxac;
    @Column(name = "MINENGAC")
    private BigDecimal minengac;
    @Column(name = "MAXENGAC")
    private BigDecimal maxengac;
    @Column(name = "TARGETVTM")
    private BigDecimal targetvtm;
    @Column(name = "MINVTM")
    private BigDecimal minvtm;
    @Column(name = "MAXVTM")
    private BigDecimal maxvtm;
    @Column(name = "MINENGVTM")
    private BigDecimal minengvtm;
    @Column(name = "MAXENGVTM")
    private BigDecimal maxengvtm;
    @Column(name = "TARGETVMA")
    private BigDecimal targetvma;
    @Column(name = "MINVMA")
    private BigDecimal minvma;
    @Column(name = "MAXVMA")
    private BigDecimal maxvma;
    @Column(name = "MINENGVMA")
    private BigDecimal minengvma;
    @Column(name = "MAXENGVMA")
    private BigDecimal maxengvma;
    @Column(name = "TARGETVFA")
    private BigDecimal targetvfa;
    @Column(name = "MINVFA")
    private BigDecimal minvfa;
    @Column(name = "MAXVFA")
    private BigDecimal maxvfa;
    @Column(name = "MINENGVFA")
    private BigDecimal minengvfa;
    @Column(name = "MAXENGVFA")
    private BigDecimal maxengvfa;
    @Column(name = "TARGETDPBR")
    private BigDecimal targetdpbr;
    @Column(name = "MINDPBR")
    private BigDecimal mindpbr;
    @Column(name = "MAXDPBR")
    private BigDecimal maxdpbr;
    @Column(name = "MINENGDPBR")
    private BigDecimal minengdpbr;
    @Column(name = "MAXENGDPBR")
    private BigDecimal maxengdpbr;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Size(max = 20)
    @Column(name = "MAIN")
    private String main;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Transient
    private List<GradationPojo> sieveList;

    public VwQaaspmMixdjmfMasterExp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getJmfNo() {
        return jmfNo;
    }

    public void setJmfNo(BigInteger jmfNo) {
        this.jmfNo = jmfNo;
    }

    public BigInteger getMixId() {
        return mixId;
    }

    public void setMixId(BigInteger mixId) {
        this.mixId = mixId;
    }

    public BigDecimal getTargetac() {
        return targetac;
    }

    public void setTargetac(BigDecimal targetac) {
        this.targetac = targetac;
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

    public BigDecimal getTargetvtm() {
        return targetvtm;
    }

    public void setTargetvtm(BigDecimal targetvtm) {
        this.targetvtm = targetvtm;
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

    public BigDecimal getTargetvma() {
        return targetvma;
    }

    public void setTargetvma(BigDecimal targetvma) {
        this.targetvma = targetvma;
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

    public BigDecimal getTargetvfa() {
        return targetvfa;
    }

    public void setTargetvfa(BigDecimal targetvfa) {
        this.targetvfa = targetvfa;
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

    public BigDecimal getTargetdpbr() {
        return targetdpbr;
    }

    public void setTargetdpbr(BigDecimal targetdpbr) {
        this.targetdpbr = targetdpbr;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @JsonGetter(value = "sieveList")
    public List<GradationPojo> getSieveList() {
        return sieveList;
    }

    public void setSieveList(List<GradationPojo> sieveList) {
        this.sieveList = sieveList;
    }
}
