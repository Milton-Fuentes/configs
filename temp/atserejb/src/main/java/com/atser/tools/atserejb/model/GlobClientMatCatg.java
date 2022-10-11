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
@NamedQuery(name = "GlobClientMatCatg.findByClientId", query = "SELECT g FROM GlobClientMatCatg g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientMatCatg.findByMatcatgId", query = "SELECT g FROM GlobClientMatCatg g WHERE g.matcatgId = :matcatgId"),
    @NamedQuery(name = "GlobClientMatCatg.findByMatcatgTitle", query = "SELECT g FROM GlobClientMatCatg g WHERE g.matcatgTitle = :matcatgTitle"),
    @NamedQuery(name = "GlobClientMatCatg.findByVisible", query = "SELECT g FROM GlobClientMatCatg g WHERE g.visible = :visible"),
    @NamedQuery(name = "GlobClientMatCatg.findByCorder", query = "SELECT g FROM GlobClientMatCatg g WHERE g.corder = :corder")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_MAT_CATG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientMatCatg.findAll", query = "SELECT g FROM GlobClientMatCatg g"),
    @NamedQuery(name = "GlobClientMatCatg.findById", query = "SELECT g FROM GlobClientMatCatg g WHERE g.id = :id")})
public class GlobClientMatCatg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "MATCATG_ID")
    private BigInteger matcatgId;
    @Size(max = 255)
    @Column(name = "MATCATG_TITLE", length = 255)
    private String matcatgTitle;
    @Size(max = 5)
    @Column(name = "VISIBLE", length = 5)
    private String visible;
    @Column(name = "CORDER")
    private BigInteger corder;

    public GlobClientMatCatg() {
    }

    public GlobClientMatCatg(BigDecimal id) {
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

    public BigInteger getMatcatgId() {
        return matcatgId;
    }

    public void setMatcatgId(BigInteger matcatgId) {
        this.matcatgId = matcatgId;
    }

    public String getMatcatgTitle() {
        return matcatgTitle;
    }

    public void setMatcatgTitle(String matcatgTitle) {
        this.matcatgTitle = matcatgTitle;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public BigInteger getCorder() {
        return corder;
    }

    public void setCorder(BigInteger corder) {
        this.corder = corder;
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
        if (!(object instanceof GlobClientMatCatg)) {
            return false;
        }
        GlobClientMatCatg other = (GlobClientMatCatg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientMatCatg[ id=" + id + " ]";
    }
    
}
