/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "GLOB_MODULE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobModule.findAll", query = "SELECT g FROM GlobModule g")
    , @NamedQuery(name = "GlobModule.findById", query = "SELECT g FROM GlobModule g WHERE g.id = :id")
    , @NamedQuery(name = "GlobModule.findByModuleName", query = "SELECT g FROM GlobModule g WHERE g.moduleName = :moduleName")
    , @NamedQuery(name = "GlobModule.findByFolder", query = "SELECT g FROM GlobModule g WHERE g.folder = :folder")
    , @NamedQuery(name = "GlobModule.findByStartPage", query = "SELECT g FROM GlobModule g WHERE g.startPage = :startPage")})
public class GlobModule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "MODULE_NAME")
    private String moduleName;
    @Size(max = 4000)
    @Column(name = "FOLDER")
    private String folder;
    @Size(max = 50)
    @Column(name = "START_PAGE")
    private String startPage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId", fetch = FetchType.LAZY)
    private List<GlobClientModules> globClientModulesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId", fetch = FetchType.LAZY)
    private List<GlobClientRoles> globClientRolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId", fetch = FetchType.LAZY)
    private List<GlobFlagsModule> globFlagsModuleList;

    public GlobModule() {
    }

    public GlobModule(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
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
        if (!(object instanceof GlobModule)) {
            return false;
        }
        GlobModule other = (GlobModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobModule[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobClientModules> getGlobClientModulesList() {
        return globClientModulesList;
    }

    public void setGlobClientModulesList(List<GlobClientModules> globClientModulesList) {
        this.globClientModulesList = globClientModulesList;
    }

    @XmlTransient
    public List<GlobClientRoles> getGlobClientRolesList() {
        return globClientRolesList;
    }

    public void setGlobClientRolesList(List<GlobClientRoles> globClientRolesList) {
        this.globClientRolesList = globClientRolesList;
    }

    @XmlTransient
    public List<GlobFlagsModule> getGlobFlagsModuleList() {
        return globFlagsModuleList;
    }

    public void setGlobFlagsModuleList(List<GlobFlagsModule> globFlagsModuleList) {
        this.globFlagsModuleList = globFlagsModuleList;
    }
    
}
