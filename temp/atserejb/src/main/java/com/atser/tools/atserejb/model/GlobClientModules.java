/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GLOB_CLIENT_MODULES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientModules.findAll", query = "SELECT g FROM GlobClientModules g")
    , @NamedQuery(name = "GlobClientModules.findById", query = "SELECT g FROM GlobClientModules g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientModules.findByModuleTitle", query = "SELECT g FROM GlobClientModules g WHERE g.moduleTitle = :moduleTitle")
    , @NamedQuery(name = "GlobClientModules.findByClientAndModuleName", query = "SELECT g FROM GlobClientModules g WHERE g.customerId.id = :clientId AND g.moduleId.moduleName = :moduleName")
    , @NamedQuery(name = "GlobClientModules.findByModuleStartPage", query = "SELECT g FROM GlobClientModules g WHERE g.moduleStartPage = :moduleStartPage")})
public class GlobClientModules implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "MODULE_TITLE")
    private String moduleTitle;
    @Size(max = 50)
    @Column(name = "MODULE_START_PAGE")
    private String moduleStartPage;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobClient customerId;
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobModule moduleId;

    public GlobClientModules() {
    }

    public GlobClientModules(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getModuleTitle() {
        if(StringSupport.isNullOrEmpty(moduleTitle)) {
            return moduleId.getModuleName();
        }
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleStartPage() {
        return moduleStartPage;
    }

    public void setModuleStartPage(String moduleStartPage) {
        this.moduleStartPage = moduleStartPage;
    }

    public GlobClient getCustomerId() {
        return customerId;
    }

    public void setCustomerId(GlobClient customerId) {
        this.customerId = customerId;
    }

    public GlobModule getModuleId() {
        return moduleId;
    }

    public void setModuleId(GlobModule moduleId) {
        this.moduleId = moduleId;
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
        if (!(object instanceof GlobClientModules)) {
            return false;
        }
        GlobClientModules other = (GlobClientModules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientModules[ id=" + id + " ]";
    }
    
}
