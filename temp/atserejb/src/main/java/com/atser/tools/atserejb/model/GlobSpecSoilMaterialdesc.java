/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NamedQuery(name = "GlobSpecSoilMaterialdesc.findBySpecificationId", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.specificationId = :specificationId"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByMaterialdesc", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.materialdesc = :materialdesc"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByChartType", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.chartType = :chartType"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByActive", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.active = :active"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByLastMod", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByLastModBy", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByLastModIp", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByCreateDate", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByCreateBy", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByCreateByIp", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findByVersion", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_SOIL_MATERIALDESC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findAll", query = "SELECT g FROM GlobSpecSoilMaterialdesc g"),
    @NamedQuery(name = "GlobSpecSoilMaterialdesc.findById", query = "SELECT g FROM GlobSpecSoilMaterialdesc g WHERE g.id = :id")})
public class GlobSpecSoilMaterialdesc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SPECIFICATION_ID")
    private BigInteger specificationId;
    @Size(max = 255)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 25)
    @Column(name = "CHART_TYPE")
    private String chartType;
    @Column(name = "ACTIVE")
    private Character active;
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
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public GlobSpecSoilMaterialdesc() {
    }

    public GlobSpecSoilMaterialdesc(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(BigInteger specificationId) {
        this.specificationId = specificationId;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof GlobSpecSoilMaterialdesc)) {
            return false;
        }
        GlobSpecSoilMaterialdesc other = (GlobSpecSoilMaterialdesc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecSoilMaterialdesc[ id=" + id + " ]";
    }
    
}
