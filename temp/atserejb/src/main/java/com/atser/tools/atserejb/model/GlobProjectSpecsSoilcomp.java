/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
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
@NamedQuery(name = "GlobProjectSpecsSoilcomp.findByProjectId", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByTypeMaterial", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.typeMaterial = :typeMaterial"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByCompaction", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.compaction = :compaction"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByAstmProctor", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.astmProctor = :astmProctor"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByMoistureReq", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.moistureReq = :moistureReq"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByListOrder", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.listOrder = :listOrder"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByCategory", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.category = :category"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findBySpecDesc", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.specDesc = :specDesc"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByItemId", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.itemId = :itemId"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByMatId", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.matId = :matId"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByPiType", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.piType = :piType"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByPiMin", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.piMin = :piMin"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByPiMax", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.piMax = :piMax"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByCompspecMin", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.compspecMin = :compspecMin"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByCompspecMax", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.compspecMax = :compspecMax"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByMoistTolReq", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.moistTolReq = :moistTolReq"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByMoistTolReqPlus", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.moistTolReqPlus = :moistTolReqPlus"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findByMoistTolReqMinus", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.moistTolReqMinus = :moistTolReqMinus")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_SPECS_SOILCOMP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findAll", query = "SELECT g FROM GlobProjectSpecsSoilcomp g"),
    @NamedQuery(name = "GlobProjectSpecsSoilcomp.findById", query = "SELECT g FROM GlobProjectSpecsSoilcomp g WHERE g.id = :id")})
public class GlobProjectSpecsSoilcomp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "TYPE_MATERIAL")
    private String typeMaterial;
    @Size(max = 50)
    @Column(name = "COMPACTION")
    private String compaction;
    @Size(max = 20)
    @Column(name = "ASTM_PROCTOR")
    private String astmProctor;
    @Size(max = 50)
    @Column(name = "MOISTURE_REQ")
    private String moistureReq;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 255)
    @Column(name = "SPEC_DESC")
    private String specDesc;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "MAT_ID")
    private BigInteger matId;
    @Size(max = 255)
    @Column(name = "PI_TYPE")
    private String piType;
    @Size(max = 255)
    @Column(name = "PI_MIN")
    private String piMin;
    @Size(max = 255)
    @Column(name = "PI_MAX")
    private String piMax;
    @Size(max = 255)
    @Column(name = "COMPSPEC_MIN")
    private String compspecMin;
    @Size(max = 255)
    @Column(name = "COMPSPEC_MAX")
    private String compspecMax;
    @Size(max = 255)
    @Column(name = "MOIST_TOL_REQ")
    private String moistTolReq;
    @Size(max = 255)
    @Column(name = "MOIST_TOL_REQ_PLUS")
    private String moistTolReqPlus;
    @Size(max = 255)
    @Column(name = "MOIST_TOL_REQ_MINUS")
    private String moistTolReqMinus;

    public GlobProjectSpecsSoilcomp() {
    }

    public GlobProjectSpecsSoilcomp(BigDecimal id) {
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

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    public String getCompaction() {
        return compaction;
    }

    public void setCompaction(String compaction) {
        this.compaction = compaction;
    }

    public String getAstmProctor() {
        return astmProctor;
    }

    public void setAstmProctor(String astmProctor) {
        this.astmProctor = astmProctor;
    }

    public String getMoistureReq() {
        return moistureReq;
    }

    public void setMoistureReq(String moistureReq) {
        this.moistureReq = moistureReq;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
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

    public String getPiType() {
        return piType;
    }

    public void setPiType(String piType) {
        this.piType = piType;
    }

    public String getPiMin() {
        return piMin;
    }

    public void setPiMin(String piMin) {
        this.piMin = piMin;
    }

    public String getPiMax() {
        return piMax;
    }

    public void setPiMax(String piMax) {
        this.piMax = piMax;
    }

    public String getCompspecMin() {
        return compspecMin;
    }

    public void setCompspecMin(String compspecMin) {
        this.compspecMin = compspecMin;
    }

    public String getCompspecMax() {
        return compspecMax;
    }

    public void setCompspecMax(String compspecMax) {
        this.compspecMax = compspecMax;
    }

    public String getMoistTolReq() {
        return moistTolReq;
    }

    public void setMoistTolReq(String moistTolReq) {
        this.moistTolReq = moistTolReq;
    }

    public String getMoistTolReqPlus() {
        return moistTolReqPlus;
    }

    public void setMoistTolReqPlus(String moistTolReqPlus) {
        this.moistTolReqPlus = moistTolReqPlus;
    }

    public String getMoistTolReqMinus() {
        return moistTolReqMinus;
    }

    public void setMoistTolReqMinus(String moistTolReqMinus) {
        this.moistTolReqMinus = moistTolReqMinus;
    }

    public String getMaterial() {
        if (StringSupport.isNotNullAndNotEmpty(this.category)) {
            return this.category + ": " + this.typeMaterial;
        }
        return typeMaterial;
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
        if (!(object instanceof GlobProjectSpecsSoilcomp)) {
            return false;
        }
        GlobProjectSpecsSoilcomp other = (GlobProjectSpecsSoilcomp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectSpecsSoilcomp[ id=" + id + " ]";
    }

}
