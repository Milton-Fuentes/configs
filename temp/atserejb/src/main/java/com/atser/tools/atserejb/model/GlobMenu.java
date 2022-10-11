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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobMenu.findByShortName", query = "SELECT g FROM GlobMenu g WHERE g.shortName = :shortName")
    , @NamedQuery(name = "GlobMenu.findByCaption", query = "SELECT g FROM GlobMenu g WHERE g.caption = :caption")
    , @NamedQuery(name = "GlobMenu.findByHyperlink", query = "SELECT g FROM GlobMenu g WHERE g.hyperlink = :hyperlink")
    , @NamedQuery(name = "GlobMenu.findByParentId", query = "SELECT g FROM GlobMenu g WHERE g.parentId = :parentId")
    , @NamedQuery(name = "GlobMenu.findBySubNo", query = "SELECT g FROM GlobMenu g WHERE g.subNo = :subNo")
    , @NamedQuery(name = "GlobMenu.findByTabImageType", query = "SELECT g FROM GlobMenu g WHERE g.tabImageType = :tabImageType")
    , @NamedQuery(name = "GlobMenu.findByCondition", query = "SELECT g FROM GlobMenu g WHERE g.condition = :condition")
    , @NamedQuery(name = "GlobMenu.findByAreaName", query = "SELECT g FROM GlobMenu g WHERE g.areaName = :areaName")
    , @NamedQuery(name = "GlobMenu.findByItemType", query = "SELECT g FROM GlobMenu g WHERE g.itemType = :itemType")
    , @NamedQuery(name = "GlobMenu.findByTabOrder", query = "SELECT g FROM GlobMenu g WHERE g.tabOrder = :tabOrder")
    , @NamedQuery(name = "GlobMenu.findByModuleId", query = "SELECT g FROM GlobMenu g WHERE g.moduleId = :moduleId")
    , @NamedQuery(name = "GlobMenu.findByPhaseId", query = "SELECT g FROM GlobMenu g WHERE g.phaseId = :phaseId")
    , @NamedQuery(name = "GlobMenu.findByVisible", query = "SELECT g FROM GlobMenu g WHERE g.visible = :visible")
    , @NamedQuery(name = "GlobMenu.findByTarget", query = "SELECT g FROM GlobMenu g WHERE g.target = :target")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_MENU", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobMenu.findAll", query = "SELECT g FROM GlobMenu g")
    , @NamedQuery(name = "GlobMenu.findById", query = "SELECT g FROM GlobMenu g WHERE g.id = :id")})
public class GlobMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Size(max = 255)
    @Column(name = "CAPTION")
    private String caption;
    @Size(max = 4000)
    @Column(name = "HYPERLINK")
    private String hyperlink;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Size(max = 30)
    @Column(name = "SUB_NO")
    private String subNo;
    @Size(max = 4000)
    @Column(name = "TAB_IMAGE_TYPE")
    private String tabImageType;
    @Size(max = 500)
    @Column(name = "CONDITION")
    private String condition;
    @Size(max = 100)
    @Column(name = "AREA_NAME")
    private String areaName;
    @Size(max = 100)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Column(name = "TAB_ORDER")
    private BigInteger tabOrder;
    @Column(name = "MODULE_ID")
    private BigInteger moduleId;
    @Column(name = "PHASE_ID")
    private BigInteger phaseId;
    @Column(name = "VISIBLE")
    private BigInteger visible;
    @Size(max = 256)
    @Column(name = "TARGET")
    private String target;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public GlobMenu() {
    }

    public GlobMenu(BigDecimal id) {
        this.id = id;
    }

    public GlobMenu(BigDecimal id, String shortName) {
        this.id = id;
        this.shortName = shortName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getTabImageType() {
        return tabImageType;
    }

    public void setTabImageType(String tabImageType) {
        this.tabImageType = tabImageType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigInteger getTabOrder() {
        return tabOrder;
    }

    public void setTabOrder(BigInteger tabOrder) {
        this.tabOrder = tabOrder;
    }

    public BigInteger getModuleId() {
        return moduleId;
    }

    public void setModuleId(BigInteger moduleId) {
        this.moduleId = moduleId;
    }

    public BigInteger getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(BigInteger phaseId) {
        this.phaseId = phaseId;
    }

    public BigInteger getVisible() {
        return visible;
    }

    public void setVisible(BigInteger visible) {
        this.visible = visible;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobMenu)) {
            return false;
        }
        GlobMenu other = (GlobMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobMenu[ id=" + id + " ]";
    }
    
}
