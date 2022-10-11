/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_MATERIAL_USE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientMaterialUse.findAll", query = "SELECT g FROM GlobClientMaterialUse g"),
    @NamedQuery(name = "GlobClientMaterialUse.findById", query = "SELECT g FROM GlobClientMaterialUse g WHERE g.id = :id")})
public class GlobClientMaterialUse implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_client_material_us_ID_SEQ", sequenceName = "glob_client_material_us_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_client_material_us_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "SECTION", length = 255)
    private String section;
    @Size(max = 255)
    @Column(name = "MATERIAL_USE", length = 255)
    private String materialUse;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobClientMaterialUse() {
    }

    public GlobClientMaterialUse(BigDecimal id) {
        this.id = id;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getMaterialUse() {
        return materialUse;
    }

    public void setMaterialUse(String materialUse) {
        this.materialUse = materialUse;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.clientId);
        hash = 37 * hash + Objects.hashCode(this.section);
        hash = 37 * hash + Objects.hashCode(this.materialUse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GlobClientMaterialUse other = (GlobClientMaterialUse) obj;
        if (!Objects.equals(this.section, other.section)) {
            return false;
        }
        if (!Objects.equals(this.materialUse, other.materialUse)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GlobClientMaterialUse{" + "id=" + id + ", clientId=" + clientId + ", section=" + section + ", materialUse=" + materialUse + '}';
    }
}
