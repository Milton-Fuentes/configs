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
@NamedQuery(name = "GlobProjectInsptplanItem.findByInsptplanId", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.insptplanId = :insptplanId"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByItemNo", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.itemNo = :itemNo"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByDescription", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.description = :description"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByUnit", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.unit = :unit"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByPlan", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.plan = :plan"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByCreateBy", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByCreateByIp", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByLastModBy", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByLastMod", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByLastModIp", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findByVersion", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_INSPTPLAN_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectInsptplanItem.findAll", query = "SELECT g FROM GlobProjectInsptplanItem g"),
    @NamedQuery(name = "GlobProjectInsptplanItem.findById", query = "SELECT g FROM GlobProjectInsptplanItem g WHERE g.id = :id")})
public class GlobProjectInsptplanItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSPTPLAN_ID", nullable = false)
    private BigInteger insptplanId;
    @Size(max = 30)
    @Column(name = "ITEM_NO", length = 30)
    private String itemNo;
    @Size(max = 500)
    @Column(name = "DESCRIPTION", length = 500)
    private String description;
    @Size(max = 30)
    @Column(name = "UNIT", length = 30)
    private String unit;
    @Column(name = "PLAN", precision = 126)
    private Double plan;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD", length = 20)
    private String lastMod;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;

    public GlobProjectInsptplanItem() {
    }

    public GlobProjectInsptplanItem(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectInsptplanItem(BigDecimal id, BigInteger insptplanId) {
        this.id = id;
        this.insptplanId = insptplanId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getInsptplanId() {
        return insptplanId;
    }

    public void setInsptplanId(BigInteger insptplanId) {
        this.insptplanId = insptplanId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPlan() {
        return plan;
    }

    public void setPlan(Double plan) {
        this.plan = plan;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobProjectInsptplanItem)) {
            return false;
        }
        GlobProjectInsptplanItem other = (GlobProjectInsptplanItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectInsptplanItem[ id=" + id + " ]";
    }
    
}
