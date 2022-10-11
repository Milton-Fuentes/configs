/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PHASE_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobPhaseType.findAll", query = "SELECT g FROM GlobPhaseType g")
    , @NamedQuery(name = "GlobPhaseType.findById", query = "SELECT g FROM GlobPhaseType g WHERE g.id = :id")
    , @NamedQuery(name = "GlobPhaseType.findByType", query = "SELECT g FROM GlobPhaseType g WHERE g.type = :type")})
public class GlobPhaseType implements Serializable {

    @OneToMany(mappedBy = "phaseType")
    private List<GlobFirms> globFirmsList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobClient clientId;
    @OneToMany(mappedBy = "phaseType", fetch = FetchType.LAZY)
    private List<GlobContractor> globContractorList;

    public GlobPhaseType() {
    }

    public GlobPhaseType(Short id) {
        this.id = id;
    }

    public GlobPhaseType(Short id, String type) {
        this.id = id;
        this.type = type;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<GlobContractor> getGlobContractorList() {
        return globContractorList;
    }

    public void setGlobContractorList(List<GlobContractor> globContractorList) {
        this.globContractorList = globContractorList;
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
        if (!(object instanceof GlobPhaseType)) {
            return false;
        }
        GlobPhaseType other = (GlobPhaseType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobPhaseType[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobFirms> getGlobFirmsList() {
        return globFirmsList;
    }

    public void setGlobFirmsList(List<GlobFirms> globFirmsList) {
        this.globFirmsList = globFirmsList;
    }
    
}
