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
, @NamedQuery(name = "GlobEquipment.findByClientId", query = "SELECT g FROM GlobEquipment g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobEquipment.findByEquipment", query = "SELECT g FROM GlobEquipment g WHERE g.equipment = :equipment")
    , @NamedQuery(name = "GlobEquipment.findByDescription", query = "SELECT g FROM GlobEquipment g WHERE g.description = :description")
    , @NamedQuery(name = "GlobEquipment.findByInvtQuantity", query = "SELECT g FROM GlobEquipment g WHERE g.invtQuantity = :invtQuantity")
    , @NamedQuery(name = "GlobEquipment.findByTableOrder", query = "SELECT g FROM GlobEquipment g WHERE g.tableOrder = :tableOrder")
    , @NamedQuery(name = "GlobEquipment.findByCreateBy", query = "SELECT g FROM GlobEquipment g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobEquipment.findByCreateByIp", query = "SELECT g FROM GlobEquipment g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobEquipment.findByLastModBy", query = "SELECT g FROM GlobEquipment g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobEquipment.findByLastMod", query = "SELECT g FROM GlobEquipment g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobEquipment.findByLastModIp", query = "SELECT g FROM GlobEquipment g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobEquipment.findByVersion", query = "SELECT g FROM GlobEquipment g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_EQUIPMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobEquipment.findAll", query = "SELECT g FROM GlobEquipment g")
    , @NamedQuery(name = "GlobEquipment.findById", query = "SELECT g FROM GlobEquipment g WHERE g.id = :id")})
public class GlobEquipment implements Serializable {

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
    @Size(max = 100)
    @Column(name = "EQUIPMENT")
    private String equipment;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "INVT_QUANTITY")
    private Double invtQuantity;
    @Column(name = "TABLE_ORDER")
    private BigInteger tableOrder;
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

    public GlobEquipment() {
    }

    public GlobEquipment(BigDecimal id) {
        this.id = id;
    }

    public GlobEquipment(BigDecimal id, BigInteger clientId) {
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInvtQuantity() {
        return invtQuantity;
    }

    public void setInvtQuantity(Double invtQuantity) {
        this.invtQuantity = invtQuantity;
    }

    public BigInteger getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(BigInteger tableOrder) {
        this.tableOrder = tableOrder;
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
        if (!(object instanceof GlobEquipment)) {
            return false;
        }
        GlobEquipment other = (GlobEquipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobEquipment[ id=" + id + " ]";
    }
    
}
