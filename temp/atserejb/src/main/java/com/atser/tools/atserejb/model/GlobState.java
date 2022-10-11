/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author droldan
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "GLOB_STATE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobState.findAll", query = "SELECT g FROM GlobState g"),
    @NamedQuery(name = "GlobState.findByShortName", query = "SELECT g FROM GlobState g WHERE g.shortName = :shortName"),
    @NamedQuery(name = "GlobState.findByName", query = "SELECT g FROM GlobState g WHERE g.name = :name"),
    @NamedQuery(name = "GlobState.findByCountry", query = "SELECT g FROM GlobState g WHERE g.country = :country")})
public class GlobState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "COUNTRY")
    private String country;

    public GlobState() {
    }

    public GlobState(String shortName) {
        this.shortName = shortName;
    }

    public GlobState(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullStateName() {
        if (StringSupport.isNotNullAndNotEmpty(this.shortName)) {
            return this.name + " ( " + this.shortName + " )";
        }
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shortName != null ? shortName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobState)) {
            return false;
        }
        GlobState other = (GlobState) object;
        if ((this.shortName == null && other.shortName != null) || (this.shortName != null && !this.shortName.equals(other.shortName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobState[ shortName=" + shortName + " ]";
    }

}
