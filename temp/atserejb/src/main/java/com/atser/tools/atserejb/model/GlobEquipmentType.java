/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_EQUIPMENT_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobEquipmentType.findAll", query = "SELECT g FROM GlobEquipmentType g")
    , @NamedQuery(name = "GlobEquipmentType.findById", query = "SELECT g FROM GlobEquipmentType g WHERE g.id = :id")
    , @NamedQuery(name = "GlobEquipmentType.findByEquipType", query = "SELECT g FROM GlobEquipmentType g WHERE g.equipType = :equipType")
    , @NamedQuery(name = "GlobEquipmentType.findByDescription", query = "SELECT g FROM GlobEquipmentType g WHERE g.description = :description")})
public class GlobEquipmentType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "EQUIP_TYPE")
    private String equipType;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;

    public GlobEquipmentType() {
    }

    public GlobEquipmentType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof GlobEquipmentType)) {
            return false;
        }
        GlobEquipmentType other = (GlobEquipmentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobEquipmentType[ id=" + id + " ]";
    }
    
}
