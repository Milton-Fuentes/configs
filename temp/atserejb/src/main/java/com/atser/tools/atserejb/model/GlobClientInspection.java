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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_INSPECTION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientInspection.findAll", query = "SELECT g FROM GlobClientInspection g")
    , @NamedQuery(name = "GlobClientInspection.findById", query = "SELECT g FROM GlobClientInspection g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientInspection.findByClientId", query = "SELECT g FROM GlobClientInspection g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientInspection.findByInspectionId", query = "SELECT g FROM GlobClientInspection g WHERE g.inspectionId = :inspectionId")
    , @NamedQuery(name = "GlobClientInspection.findByInspectionTitle", query = "SELECT g FROM GlobClientInspection g WHERE g.inspectionTitle = :inspectionTitle")})
public class GlobClientInspection implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "INSPECTION_ID")
    private BigInteger inspectionId;
    @Size(max = 255)
    @Column(name = "INSPECTION_TITLE")
    private String inspectionTitle;

    public GlobClientInspection() {
    }

    public GlobClientInspection(BigDecimal id) {
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

    public BigInteger getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(BigInteger inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getInspectionTitle() {
        return inspectionTitle;
    }

    public void setInspectionTitle(String inspectionTitle) {
        this.inspectionTitle = inspectionTitle;
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
        if (!(object instanceof GlobClientInspection)) {
            return false;
        }
        GlobClientInspection other = (GlobClientInspection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientInspection[ id=" + id + " ]";
    }
    
}
