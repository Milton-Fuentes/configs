/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "GLOB_DISCIPLINES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobDisciplines.findAll", query = "SELECT g FROM GlobDisciplines g")
    , @NamedQuery(name = "GlobDisciplines.findById", query = "SELECT g FROM GlobDisciplines g WHERE g.id = :id")
    , @NamedQuery(name = "GlobDisciplines.findByProjectId", query = "SELECT g FROM GlobDisciplines g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobDisciplines.findByName", query = "SELECT g FROM GlobDisciplines g WHERE g.name = :name")
    , @NamedQuery(name = "GlobDisciplines.findByDescription", query = "SELECT g FROM GlobDisciplines g WHERE g.description = :description")})
public class GlobDisciplines implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "disciplineId")
    private List<GlobProfiles> globProfilesList;

    public GlobDisciplines() {
    }

    public GlobDisciplines(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<GlobProfiles> getGlobProfilesList() {
        return globProfilesList;
    }

    public void setGlobProfilesList(List<GlobProfiles> globProfilesList) {
        this.globProfilesList = globProfilesList;
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
        if (!(object instanceof GlobDisciplines)) {
            return false;
        }
        GlobDisciplines other = (GlobDisciplines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobDisciplines[ id=" + id + " ]";
    }
    
}
