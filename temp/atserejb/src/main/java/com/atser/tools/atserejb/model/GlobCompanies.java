/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "GlobCompanies.findByCompanyCode", query = "SELECT g FROM GlobCompanies g WHERE g.companyCode = :companyCode"),
    @NamedQuery(name = "GlobCompanies.findByShortdesc", query = "SELECT g FROM GlobCompanies g WHERE g.shortdesc = :shortdesc"),
    @NamedQuery(name = "GlobCompanies.findByDescription", query = "SELECT g FROM GlobCompanies g WHERE g.description = :description"),
    @NamedQuery(name = "GlobCompanies.findByActive", query = "SELECT g FROM GlobCompanies g WHERE g.active = :active"),
    @NamedQuery(name = "GlobCompanies.findByLastMod", query = "SELECT g FROM GlobCompanies g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobCompanies.findByLastModTmp", query = "SELECT g FROM GlobCompanies g WHERE g.lastModTmp = :lastModTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_COMPANIES", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCompanies.findAll", query = "SELECT g FROM GlobCompanies g"),
    @NamedQuery(name = "GlobCompanies.findById", query = "SELECT g FROM GlobCompanies g WHERE g.id = :id")})
public class GlobCompanies implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMPANY_CODE")
    private String companyCode;
    @Size(max = 50)
    @Column(name = "SHORTDESC")
    private String shortdesc;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @OneToMany(mappedBy = "companyId")
    private List<GlobClient> globClientList;
    @OneToMany(mappedBy = "companyId")
    private List<GlobProjectClient> globProjectClientList;

    public GlobCompanies() {
    }

    public GlobCompanies(BigDecimal id) {
        this.id = id;
    }

    public GlobCompanies(BigDecimal id, String companyCode) {
        this.id = id;
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    @XmlTransient
    public List<GlobClient> getGlobClientList() {
        return globClientList;
    }

    public void setGlobClientList(List<GlobClient> globClientList) {
        this.globClientList = globClientList;
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
        if (!(object instanceof GlobCompanies)) {
            return false;
        }
        GlobCompanies other = (GlobCompanies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCompanies[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobProjectClient> getGlobProjectClientList() {
        return globProjectClientList;
    }

    public void setGlobProjectClientList(List<GlobProjectClient> globProjectClientList) {
        this.globProjectClientList = globProjectClientList;
    }

}
