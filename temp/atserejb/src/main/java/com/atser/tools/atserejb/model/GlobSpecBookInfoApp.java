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
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobSpecBookInfoApp.findBySpecBookId", query = "SELECT g FROM GlobSpecBookInfoApp g WHERE g.specBookId = :specBookId"),
    @NamedQuery(name = "GlobSpecBookInfoApp.findByApplicationId", query = "SELECT g FROM GlobSpecBookInfoApp g WHERE g.applicationId = :applicationId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_BOOK_INFO_APP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookInfoApp.findAll", query = "SELECT g FROM GlobSpecBookInfoApp g"),
    @NamedQuery(name = "GlobSpecBookInfoApp.findById", query = "SELECT g FROM GlobSpecBookInfoApp g WHERE g.id = :id")})
public class GlobSpecBookInfoApp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPEC_BOOK_ID")
    private BigInteger specBookId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPLICATION_ID")
    private BigInteger applicationId;

    public GlobSpecBookInfoApp() {
    }

    public GlobSpecBookInfoApp(BigDecimal id) {
        this.id = id;
    }

    public GlobSpecBookInfoApp(BigDecimal id, BigInteger specBookId, BigInteger applicationId) {
        this.id = id;
        this.specBookId = specBookId;
        this.applicationId = applicationId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecBookId() {
        return specBookId;
    }

    public void setSpecBookId(BigInteger specBookId) {
        this.specBookId = specBookId;
    }

    public BigInteger getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigInteger applicationId) {
        this.applicationId = applicationId;
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
        if (!(object instanceof GlobSpecBookInfoApp)) {
            return false;
        }
        GlobSpecBookInfoApp other = (GlobSpecBookInfoApp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookInfoApp[ id=" + id + " ]";
    }
    
}
