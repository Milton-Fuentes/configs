/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "GlobBillingCode.findByBillingCategoryId", query = "SELECT g FROM GlobBillingCode g WHERE g.billingCategoryId = :billingCategoryId"),
    @NamedQuery(name = "GlobBillingCode.findByStandarditem", query = "SELECT g FROM GlobBillingCode g WHERE g.standarditem = :standarditem"),
    @NamedQuery(name = "GlobBillingCode.findByUnitofmeasure", query = "SELECT g FROM GlobBillingCode g WHERE g.unitofmeasure = :unitofmeasure"),
    @NamedQuery(name = "GlobBillingCode.findByDescription", query = "SELECT g FROM GlobBillingCode g WHERE g.description = :description"),
    @NamedQuery(name = "GlobBillingCode.findByCostPlus", query = "SELECT g FROM GlobBillingCode g WHERE g.costPlus = :costPlus"),
    @NamedQuery(name = "GlobBillingCode.findByByQuotation", query = "SELECT g FROM GlobBillingCode g WHERE g.byQuotation = :byQuotation")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_BILLING_CODE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobBillingCode.findAll", query = "SELECT g FROM GlobBillingCode g"),
    @NamedQuery(name = "GlobBillingCode.findById", query = "SELECT g FROM GlobBillingCode g WHERE g.id = :id")})
public class GlobBillingCode implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "BILLING_CATEGORY_ID")
    private BigInteger billingCategoryId;
    @Column(name = "MATERIAL_USE_ID")
    private BigInteger materialUseId;
    @Size(max = 20)
    @Column(name = "STANDARDITEM")
    private String standarditem;
    @Size(max = 20)
    @Column(name = "UNITOFMEASURE")
    private String unitofmeasure;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "COST_PLUS")
    private Character costPlus;
    @Column(name = "BY_QUOTATION")
    private Character byQuotation;

    public GlobBillingCode() {
    }

    public GlobBillingCode(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getBillingCategoryId() {
        return billingCategoryId;
    }

    public void setBillingCategoryId(BigInteger billingCategoryId) {
        this.billingCategoryId = billingCategoryId;
    }

    public BigInteger getMaterialUseId() {
        return materialUseId;
    }

    public void setMaterialUseId(BigInteger materialUseId) {
        this.materialUseId = materialUseId;
    }

    public String getStandarditem() {
        return standarditem;
    }

    public void setStandarditem(String standarditem) {
        this.standarditem = standarditem;
    }

    public String getUnitofmeasure() {
        return unitofmeasure;
    }

    public void setUnitofmeasure(String unitofmeasure) {
        this.unitofmeasure = unitofmeasure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCostPlus() {
        return costPlus;
    }

    public void setCostPlus(Character costPlus) {
        this.costPlus = costPlus;
    }

    public Character getByQuotation() {
        return byQuotation;
    }

    public void setByQuotation(Character byQuotation) {
        this.byQuotation = byQuotation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobBillingCode)) {
            return false;
        }
        GlobBillingCode other = (GlobBillingCode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobBillingCode[ id=" + id + " ]";
    }

}
