/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

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

/*
@NamedQuery(name = "GlobProjectInsptplanDetails.findByItemId", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.itemId = :itemId"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByFromDate", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.fromDate = :fromDate"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByToDate", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.toDate = :toDate"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByPlanQty", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.planQty = :planQty"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByPlaceQty", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.placeQty = :placeQty"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByAppvQty", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.appvQty = :appvQty"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByCreateBy", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByCreateByIp", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByLastModBy", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByLastMod", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByLastModIp", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findByVersion", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_INSPTPLAN_DETAILS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectInsptplanDetails.findAll", query = "SELECT g FROM GlobProjectInsptplanDetails g"),
    @NamedQuery(name = "GlobProjectInsptplanDetails.findById", query = "SELECT g FROM GlobProjectInsptplanDetails g WHERE g.id = :id")})
public class GlobProjectInsptplanDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID", nullable = false)
    private BigInteger itemId;
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Column(name = "PLAN_QTY", precision = 126)
    private Double planQty;
    @Column(name = "PLACE_QTY", precision = 126)
    private Double placeQty;
    @Column(name = "APPV_QTY", precision = 126)
    private Double appvQty;
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

    public GlobProjectInsptplanDetails() {
    }

    public GlobProjectInsptplanDetails(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectInsptplanDetails(BigDecimal id, BigInteger itemId) {
        this.id = id;
        this.itemId = itemId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Double getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Double planQty) {
        this.planQty = planQty;
    }

    public Double getPlaceQty() {
        return placeQty;
    }

    public void setPlaceQty(Double placeQty) {
        this.placeQty = placeQty;
    }

    public Double getAppvQty() {
        return appvQty;
    }

    public void setAppvQty(Double appvQty) {
        this.appvQty = appvQty;
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
        if (!(object instanceof GlobProjectInsptplanDetails)) {
            return false;
        }
        GlobProjectInsptplanDetails other = (GlobProjectInsptplanDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectInsptplanDetails[ id=" + id + " ]";
    }
    
}
