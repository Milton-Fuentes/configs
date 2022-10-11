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
@NamedQuery(name = "GlobSpecSoilClass.findBySpecificationId", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.specificationId = :specificationId"),
    @NamedQuery(name = "GlobSpecSoilClass.findByClassName", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.className = :className"),
    @NamedQuery(name = "GlobSpecSoilClass.findBySubclassName", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.subclassName = :subclassName"),
    @NamedQuery(name = "GlobSpecSoilClass.findByPp60Min", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.pp60Min = :pp60Min"),
    @NamedQuery(name = "GlobSpecSoilClass.findByPp60Max", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.pp60Max = :pp60Max"),
    @NamedQuery(name = "GlobSpecSoilClass.findByPp200Min", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.pp200Min = :pp200Min"),
    @NamedQuery(name = "GlobSpecSoilClass.findByPp200Max", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.pp200Max = :pp200Max"),
    @NamedQuery(name = "GlobSpecSoilClass.findByClayMin", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.clayMin = :clayMin"),
    @NamedQuery(name = "GlobSpecSoilClass.findByClayMax", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.clayMax = :clayMax"),
    @NamedQuery(name = "GlobSpecSoilClass.findByVolchangeMin", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.volchangeMin = :volchangeMin"),
    @NamedQuery(name = "GlobSpecSoilClass.findByVolchangeMax", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.volchangeMax = :volchangeMax"),
    @NamedQuery(name = "GlobSpecSoilClass.findByMaxdrydensity", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.maxdrydensity = :maxdrydensity"),
    @NamedQuery(name = "GlobSpecSoilClass.findByActive", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.active = :active"),
    @NamedQuery(name = "GlobSpecSoilClass.findByLastMod", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSpecSoilClass.findByLastModBy", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSpecSoilClass.findByLastModIp", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSpecSoilClass.findByCreateDate", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobSpecSoilClass.findByCreateBy", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSpecSoilClass.findByCreateByIp", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSpecSoilClass.findByVersion", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_SOIL_CLASS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecSoilClass.findAll", query = "SELECT g FROM GlobSpecSoilClass g"),
    @NamedQuery(name = "GlobSpecSoilClass.findById", query = "SELECT g FROM GlobSpecSoilClass g WHERE g.id = :id")})
public class GlobSpecSoilClass implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SPECIFICATION_ID")
    private BigInteger specificationId;
    @Size(max = 50)
    @Column(name = "CLASS_NAME")
    private String className;
    @Size(max = 50)
    @Column(name = "SUBCLASS_NAME")
    private String subclassName;
    @Size(max = 50)
    @Column(name = "PP60_MIN")
    private String pp60Min;
    @Size(max = 50)
    @Column(name = "PP60_MAX")
    private String pp60Max;
    @Size(max = 50)
    @Column(name = "PP200_MIN")
    private String pp200Min;
    @Size(max = 50)
    @Column(name = "PP200_MAX")
    private String pp200Max;
    @Size(max = 50)
    @Column(name = "CLAY_MIN")
    private String clayMin;
    @Size(max = 50)
    @Column(name = "CLAY_MAX")
    private String clayMax;
    @Size(max = 50)
    @Column(name = "VOLCHANGE_MIN")
    private String volchangeMin;
    @Size(max = 50)
    @Column(name = "VOLCHANGE_MAX")
    private String volchangeMax;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSITY")
    private String maxdrydensity;
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
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public GlobSpecSoilClass() {
    }

    public GlobSpecSoilClass(BigDecimal id) {
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public String getPp60Min() {
        return pp60Min;
    }

    public void setPp60Min(String pp60Min) {
        this.pp60Min = pp60Min;
    }

    public String getPp60Max() {
        return pp60Max;
    }

    public void setPp60Max(String pp60Max) {
        this.pp60Max = pp60Max;
    }

    public String getPp200Min() {
        return pp200Min;
    }

    public void setPp200Min(String pp200Min) {
        this.pp200Min = pp200Min;
    }

    public String getPp200Max() {
        return pp200Max;
    }

    public void setPp200Max(String pp200Max) {
        this.pp200Max = pp200Max;
    }

    public String getClayMin() {
        return clayMin;
    }

    public void setClayMin(String clayMin) {
        this.clayMin = clayMin;
    }

    public String getClayMax() {
        return clayMax;
    }

    public void setClayMax(String clayMax) {
        this.clayMax = clayMax;
    }

    public String getVolchangeMin() {
        return volchangeMin;
    }

    public void setVolchangeMin(String volchangeMin) {
        this.volchangeMin = volchangeMin;
    }

    public String getVolchangeMax() {
        return volchangeMax;
    }

    public void setVolchangeMax(String volchangeMax) {
        this.volchangeMax = volchangeMax;
    }

    public String getMaxdrydensity() {
        return maxdrydensity;
    }

    public void setMaxdrydensity(String maxdrydensity) {
        this.maxdrydensity = maxdrydensity;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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
        if (!(object instanceof GlobSpecSoilClass)) {
            return false;
        }
        GlobSpecSoilClass other = (GlobSpecSoilClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecSoilClass[ id=" + id + " ]";
    }
    
}
