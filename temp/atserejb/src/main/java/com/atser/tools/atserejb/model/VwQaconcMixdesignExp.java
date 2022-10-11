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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
//@JsonFilter(value = "VwQaconcMixdesignExpFilter")
@Entity
@Immutable
@Where(clause = "deleted = 'N'")
@Table(name = "VW_QACONC_MIXDESIGN_EXP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQaconcMixdesignExp.findAll", query = "SELECT a FROM VwQaconcMixdesignExp a")})
public class VwQaconcMixdesignExp implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "MIXDESIGN_NO")
    private String mixdesignNo;
    @Size(max = 25)
    @Column(name = "CONTRACT_NO")
    private String contractNo;
    @Size(max = 255)
    @Column(name = "PRODUCED_BY")
    private String producedBy;
    @Size(max = 250)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 255)
    @Column(name = "MIX_DESIGN_TYPE")
    private String mixDesignType;
    @Size(max = 255)
    @Column(name = "MIX_STATUS")
    private String mixStatus;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Size(max = 255)
    @Column(name = "MAX_AGGR_SIZE")
    private String maxAggrSize;
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
    @Column(name = "TOTAL_COARSE_AGG")
    private BigDecimal totalCoarseAgg;
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
    @Column(name = "WATER_CEMENT_RATIO")
    private BigDecimal waterCementRatio;
    @Column(name = "ADMIXTURE_QTY_1")
    private BigDecimal admixtureQty1;
    @Column(name = "ADMIXTURE_QTY_2")
    private BigDecimal admixtureQty2;
    @Column(name = "ADMIXTURE_QTY_3")
    private BigDecimal admixtureQty3;
    @Column(name = "ADMIXTURE_QTY_4")
    private BigDecimal admixtureQty4;
    @Column(name = "ADMIXTURE_QTY_5")
    private BigDecimal admixtureQty5;
    @Column(name = "ADMIXTURE_QTY6")
    private BigDecimal admixtureQty6;
    @Column(name = "ADMIXTURE_QTY7")
    private BigDecimal admixtureQty7;
    @Column(name = "ADMIXTURE_QTY8")
    private BigDecimal admixtureQty8;
    @Column(name = "THEORETICAL_AIR_CONTENT")
    private BigDecimal theoreticalAirContent;
    @Column(name = "VOLUMEN_PASTE")
    private BigDecimal volumenPaste;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED")
    private String deleted;
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public VwQaconcMixdesignExp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMixdesignNo() {
        return mixdesignNo;
    }

    public void setMixdesignNo(String mixdesignNo) {
        this.mixdesignNo = mixdesignNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public String getMixDesignType() {
        return mixDesignType;
    }

    public void setMixDesignType(String mixDesignType) {
        this.mixDesignType = mixDesignType;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMaxAggrSize() {
        return maxAggrSize;
    }

    public void setMaxAggrSize(String maxAggrSize) {
        this.maxAggrSize = maxAggrSize;
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

    public BigDecimal getWaterCementRatio() {
        return waterCementRatio;
    }

    public void setWaterCementRatio(BigDecimal waterCementRatio) {
        this.waterCementRatio = waterCementRatio;
    }

    public BigDecimal getAdmixtureQty1() {
        return admixtureQty1;
    }

    public void setAdmixtureQty1(BigDecimal admixtureQty1) {
        this.admixtureQty1 = admixtureQty1;
    }

    public BigDecimal getAdmixtureQty2() {
        return admixtureQty2;
    }

    public void setAdmixtureQty2(BigDecimal admixtureQty2) {
        this.admixtureQty2 = admixtureQty2;
    }

    public BigDecimal getAdmixtureQty3() {
        return admixtureQty3;
    }

    public void setAdmixtureQty3(BigDecimal admixtureQty3) {
        this.admixtureQty3 = admixtureQty3;
    }

    public BigDecimal getAdmixtureQty4() {
        return admixtureQty4;
    }

    public void setAdmixtureQty4(BigDecimal admixtureQty4) {
        this.admixtureQty4 = admixtureQty4;
    }

    public BigDecimal getAdmixtureQty5() {
        return admixtureQty5;
    }

    public void setAdmixtureQty5(BigDecimal admixtureQty5) {
        this.admixtureQty5 = admixtureQty5;
    }

    public BigDecimal getAdmixtureQty6() {
        return admixtureQty6;
    }

    public void setAdmixtureQty6(BigDecimal admixtureQty6) {
        this.admixtureQty6 = admixtureQty6;
    }

    public BigDecimal getAdmixtureQty7() {
        return admixtureQty7;
    }

    public void setAdmixtureQty7(BigDecimal admixtureQty7) {
        this.admixtureQty7 = admixtureQty7;
    }

    public BigDecimal getAdmixtureQty8() {
        return admixtureQty8;
    }

    public void setAdmixtureQty8(BigDecimal admixtureQty8) {
        this.admixtureQty8 = admixtureQty8;
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

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }
    
    
}
