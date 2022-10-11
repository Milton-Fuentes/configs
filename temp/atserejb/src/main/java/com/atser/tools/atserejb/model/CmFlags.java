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
@Table(name = "CM_FLAGS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFlags.findAll", query = "SELECT c FROM CmFlags c"),
    @NamedQuery(name = "CmFlags.findById", query = "SELECT c FROM CmFlags c WHERE c.id = :id"),
    @NamedQuery(name = "CmFlags.findByFlagName", query = "SELECT c FROM CmFlags c WHERE c.flagName = :flagName"),
    @NamedQuery(name = "CmFlags.findByDescription", query = "SELECT c FROM CmFlags c WHERE c.description = :description"),
    @NamedQuery(name = "CmFlags.findByDefaultValue", query = "SELECT c FROM CmFlags c WHERE c.defaultValue = :defaultValue")})
public class CmFlags implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "FLAG_NAME")
    private String flagName;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DEFAULT_VALUE")
    private Character defaultValue;

    public CmFlags() {
    }

    public CmFlags(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getDefaultValue() {
        return defaultValue;
    }

    public Boolean getDefaultValueAsBoolean() {
        if (StringSupport.isNullOrEmpty(defaultValue)) {
            return Boolean.FALSE;
        }
        return defaultValue == 'Y' ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setDefaultValue(Character defaultValue) {
        this.defaultValue = defaultValue;
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
        if (!(object instanceof CmFlags)) {
            return false;
        }
        CmFlags other = (CmFlags) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFlags[ id=" + id + " ]";
    }

}
