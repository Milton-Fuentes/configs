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
@NamedQuery(name = "GlobIaCatg.findByIaTypeId", query = "SELECT g FROM GlobIaCatg g WHERE g.iaTypeId = :iaTypeId"),
    @NamedQuery(name = "GlobIaCatg.findByIaCatg", query = "SELECT g FROM GlobIaCatg g WHERE g.iaCatg = :iaCatg"),
    @NamedQuery(name = "GlobIaCatg.findByDescription", query = "SELECT g FROM GlobIaCatg g WHERE g.description = :description"),
    @NamedQuery(name = "GlobIaCatg.findByListOrder", query = "SELECT g FROM GlobIaCatg g WHERE g.listOrder = :listOrder")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_IA_CATG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobIaCatg.findAll", query = "SELECT g FROM GlobIaCatg g"),
    @NamedQuery(name = "GlobIaCatg.findById", query = "SELECT g FROM GlobIaCatg g WHERE g.id = :id"),
    @NamedQuery(name = "GlobIaCatg.findByClientId", query = "SELECT g FROM GlobIaCatg g WHERE g.clientId = :clientId")})
public class GlobIaCatg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID", nullable = false)
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IA_TYPE_ID", nullable = false)
    private BigInteger iaTypeId;
    @Size(max = 255)
    @Column(name = "IA_CATG", length = 255)
    private String iaCatg;
    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobIaCatg() {
    }

    public GlobIaCatg(BigDecimal id) {
        this.id = id;
    }

    public GlobIaCatg(BigDecimal id, BigInteger clientId, BigInteger iaTypeId) {
        this.id = id;
        this.clientId = clientId;
        this.iaTypeId = iaTypeId;
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

    public BigInteger getIaTypeId() {
        return iaTypeId;
    }

    public void setIaTypeId(BigInteger iaTypeId) {
        this.iaTypeId = iaTypeId;
    }

    public String getIaCatg() {
        return iaCatg;
    }

    public void setIaCatg(String iaCatg) {
        this.iaCatg = iaCatg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
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
        if (!(object instanceof GlobIaCatg)) {
            return false;
        }
        GlobIaCatg other = (GlobIaCatg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobIaCatg[ id=" + id + " ]";
    }
    
}
