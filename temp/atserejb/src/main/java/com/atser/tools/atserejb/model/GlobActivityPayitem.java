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
, @NamedQuery(name = "GlobActivityPayitem.findByClientId", query = "SELECT g FROM GlobActivityPayitem g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobActivityPayitem.findByActivity", query = "SELECT g FROM GlobActivityPayitem g WHERE g.activity = :activity")
    , @NamedQuery(name = "GlobActivityPayitem.findByPayitem", query = "SELECT g FROM GlobActivityPayitem g WHERE g.payitem = :payitem")
    , @NamedQuery(name = "GlobActivityPayitem.findByDescription", query = "SELECT g FROM GlobActivityPayitem g WHERE g.description = :description")
    , @NamedQuery(name = "GlobActivityPayitem.findByUnit", query = "SELECT g FROM GlobActivityPayitem g WHERE g.unit = :unit")
    , @NamedQuery(name = "GlobActivityPayitem.findByMaintGroup", query = "SELECT g FROM GlobActivityPayitem g WHERE g.maintGroup = :maintGroup")
    , @NamedQuery(name = "GlobActivityPayitem.findByCreateBy", query = "SELECT g FROM GlobActivityPayitem g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobActivityPayitem.findByCreateByIp", query = "SELECT g FROM GlobActivityPayitem g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobActivityPayitem.findByLastModBy", query = "SELECT g FROM GlobActivityPayitem g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobActivityPayitem.findByLastMod", query = "SELECT g FROM GlobActivityPayitem g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobActivityPayitem.findByLastModIp", query = "SELECT g FROM GlobActivityPayitem g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobActivityPayitem.findByVersion", query = "SELECT g FROM GlobActivityPayitem g WHERE g.version = :version")
    , @NamedQuery(name = "GlobActivityPayitem.findByItemType", query = "SELECT g FROM GlobActivityPayitem g WHERE g.itemType = :itemType")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_ACTIVITY_PAYITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobActivityPayitem.findAll", query = "SELECT g FROM GlobActivityPayitem g"),
    @NamedQuery(name = "GlobActivityPayitem.findById", query = "SELECT g FROM GlobActivityPayitem g WHERE g.id = :id")})
public class GlobActivityPayitem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 200)
    @Column(name = "ACTIVITY")
    private String activity;
    @Size(max = 200)
    @Column(name = "PAYITEM")
    private String payitem;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 200)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 200)
    @Column(name = "MAINT_GROUP")
    private String maintGroup;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "ITEM_TYPE")
    private BigInteger itemType;

    public GlobActivityPayitem() {
    }

    public GlobActivityPayitem(BigDecimal id) {
        this.id = id;
    }

    public GlobActivityPayitem(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPayitem() {
        return payitem;
    }

    public void setPayitem(String payitem) {
        this.payitem = payitem;
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

    public String getMaintGroup() {
        return maintGroup;
    }

    public void setMaintGroup(String maintGroup) {
        this.maintGroup = maintGroup;
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

    public BigInteger getItemType() {
        return itemType;
    }

    public void setItemType(BigInteger itemType) {
        this.itemType = itemType;
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
        if (!(object instanceof GlobActivityPayitem)) {
            return false;
        }
        GlobActivityPayitem other = (GlobActivityPayitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobActivityPayitem[ id=" + id + " ]";
    }

}
