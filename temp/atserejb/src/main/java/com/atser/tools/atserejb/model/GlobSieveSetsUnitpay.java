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
@NamedQuery(name = "GlobSieveSetsUnitpay.findByProjectId", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findBySetId", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.setId = :setId"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByUnitprice", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.unitprice = :unitprice"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByUnit", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.unit = :unit"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByRemarks", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByField1", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByField2", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByMixunitprice", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.mixunitprice = :mixunitprice"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByAcunitprice", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.acunitprice = :acunitprice"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByUnitpriceFactor", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.unitpriceFactor = :unitpriceFactor"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findByMixId", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.mixId = :mixId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SIEVE_SETS_UNITPAY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSieveSetsUnitpay.findAll", query = "SELECT g FROM GlobSieveSetsUnitpay g"),
    @NamedQuery(name = "GlobSieveSetsUnitpay.findById", query = "SELECT g FROM GlobSieveSetsUnitpay g WHERE g.id = :id")})
public class GlobSieveSetsUnitpay implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Column(name = "UNITPRICE")
    private BigInteger unitprice;
    @Size(max = 50)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 200)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Column(name = "MIXUNITPRICE")
    private BigInteger mixunitprice;
    @Column(name = "ACUNITPRICE")
    private BigInteger acunitprice;
    @Column(name = "UNITPRICE_FACTOR")
    private BigInteger unitpriceFactor;
    @Column(name = "MIX_ID")
    private BigInteger mixId;

    public GlobSieveSetsUnitpay() {
    }

    public GlobSieveSetsUnitpay(BigDecimal id) {
        this.id = id;
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

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public BigInteger getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigInteger unitprice) {
        this.unitprice = unitprice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public BigInteger getMixunitprice() {
        return mixunitprice;
    }

    public void setMixunitprice(BigInteger mixunitprice) {
        this.mixunitprice = mixunitprice;
    }

    public BigInteger getAcunitprice() {
        return acunitprice;
    }

    public void setAcunitprice(BigInteger acunitprice) {
        this.acunitprice = acunitprice;
    }

    public BigInteger getUnitpriceFactor() {
        return unitpriceFactor;
    }

    public void setUnitpriceFactor(BigInteger unitpriceFactor) {
        this.unitpriceFactor = unitpriceFactor;
    }

    public BigInteger getMixId() {
        return mixId;
    }

    public void setMixId(BigInteger mixId) {
        this.mixId = mixId;
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
        if (!(object instanceof GlobSieveSetsUnitpay)) {
            return false;
        }
        GlobSieveSetsUnitpay other = (GlobSieveSetsUnitpay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSieveSetsUnitpay[ id=" + id + " ]";
    }
    
}
