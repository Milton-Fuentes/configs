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
@NamedQuery(name = "GlobIaType.findByClientId", query = "SELECT g FROM GlobIaType g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobIaType.findByIaShortname", query = "SELECT g FROM GlobIaType g WHERE g.iaShortname = :iaShortname"),
    @NamedQuery(name = "GlobIaType.findByIaType", query = "SELECT g FROM GlobIaType g WHERE g.iaType = :iaType"),
    @NamedQuery(name = "GlobIaType.findByDescription", query = "SELECT g FROM GlobIaType g WHERE g.description = :description"),
    @NamedQuery(name = "GlobIaType.findByListOrder", query = "SELECT g FROM GlobIaType g WHERE g.listOrder = :listOrder")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_IA_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobIaType.findAll", query = "SELECT g FROM GlobIaType g"),
    @NamedQuery(name = "GlobIaType.findById", query = "SELECT g FROM GlobIaType g WHERE g.id = :id")})
public class GlobIaType implements Serializable {

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
    @Size(max = 255)
    @Column(name = "IA_SHORTNAME", length = 255)
    private String iaShortname;
    @Size(max = 255)
    @Column(name = "IA_TYPE", length = 255)
    private String iaType;
    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobIaType() {
    }

    public GlobIaType(BigDecimal id) {
        this.id = id;
    }

    public GlobIaType(BigDecimal id, BigInteger clientId) {
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

    public String getIaShortname() {
        return iaShortname;
    }

    public void setIaShortname(String iaShortname) {
        this.iaShortname = iaShortname;
    }

    public String getIaType() {
        return iaType;
    }

    public void setIaType(String iaType) {
        this.iaType = iaType;
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
        if (!(object instanceof GlobIaType)) {
            return false;
        }
        GlobIaType other = (GlobIaType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobIaType[ id=" + id + " ]";
    }
    
}
