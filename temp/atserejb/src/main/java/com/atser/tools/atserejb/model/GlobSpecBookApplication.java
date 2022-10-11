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
@Table(name = "GLOB_SPEC_BOOK_APPLICATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookApplication.findAll", query = "SELECT g FROM GlobSpecBookApplication g"),
    @NamedQuery(name = "GlobSpecBookApplication.findById", query = "SELECT g FROM GlobSpecBookApplication g WHERE g.id = :id"),
    @NamedQuery(name = "GlobSpecBookApplication.findByApplication", query = "SELECT g FROM GlobSpecBookApplication g WHERE g.application = :application")})
public class GlobSpecBookApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "APPLICATION")
    private String application;

    public GlobSpecBookApplication() {
    }

    public GlobSpecBookApplication(BigDecimal id) {
        this.id = id;
    }

    public GlobSpecBookApplication(BigDecimal id, String application) {
        this.id = id;
        this.application = application;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
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
        if (!(object instanceof GlobSpecBookApplication)) {
            return false;
        }
        GlobSpecBookApplication other = (GlobSpecBookApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookApplication[ id=" + id + " ]";
    }
    
}
