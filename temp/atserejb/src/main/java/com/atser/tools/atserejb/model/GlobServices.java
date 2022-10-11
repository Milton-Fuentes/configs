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

/*
, @NamedQuery(name = "GlobServices.findByServiceName", query = "SELECT g FROM GlobServices g WHERE g.serviceName = :serviceName")
    , @NamedQuery(name = "GlobServices.findByServiceTableName", query = "SELECT g FROM GlobServices g WHERE g.serviceTableName = :serviceTableName")
    , @NamedQuery(name = "GlobServices.findByServiceNameAbbr", query = "SELECT g FROM GlobServices g WHERE g.serviceNameAbbr = :serviceNameAbbr")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SERVICES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobServices.findAll", query = "SELECT g FROM GlobServices g")
    , @NamedQuery(name = "GlobServices.findById", query = "SELECT g FROM GlobServices g WHERE g.id = :id")})
public class GlobServices implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Size(max = 30)
    @Column(name = "SERVICE_TABLE_NAME")
    private String serviceTableName;
    @Size(max = 50)
    @Column(name = "SERVICE_NAME_ABBR")
    private String serviceNameAbbr;

    public GlobServices() {
    }

    public GlobServices(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceTableName() {
        return serviceTableName;
    }

    public void setServiceTableName(String serviceTableName) {
        this.serviceTableName = serviceTableName;
    }

    public String getServiceNameAbbr() {
        return serviceNameAbbr;
    }

    public void setServiceNameAbbr(String serviceNameAbbr) {
        this.serviceNameAbbr = serviceNameAbbr;
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
        if (!(object instanceof GlobServices)) {
            return false;
        }
        GlobServices other = (GlobServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobServices[ id=" + id + " ]";
    }
    
}
