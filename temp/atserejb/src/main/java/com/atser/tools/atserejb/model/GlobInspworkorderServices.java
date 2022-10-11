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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobInspworkorderServices.findByServiceId", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.serviceId = :serviceId")
    , @NamedQuery(name = "GlobInspworkorderServices.findByService", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.service = :service")
    , @NamedQuery(name = "GlobInspworkorderServices.findByType", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.type = :type")
    , @NamedQuery(name = "GlobInspworkorderServices.findByLastMod", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobInspworkorderServices.findByLastModBy", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobInspworkorderServices.findByLastModIp", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.lastModIp = :lastModIp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_INSPWORKORDER_SERVICES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobInspworkorderServices.findAll", query = "SELECT g FROM GlobInspworkorderServices g"),
    @NamedQuery(name = "GlobInspworkorderServices.findById", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.id = :id"),
    @NamedQuery(name = "GlobInspworkorderServices.findByIwoId", query = "SELECT g FROM GlobInspworkorderServices g WHERE g.iwoId = :iwoId")})
public class GlobInspworkorderServices implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_INSPWORKORDER_SERVICES_S", sequenceName = "GLOB_INSPWORKORDER_SERVICES_S", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_INSPWORKORDER_SERVICES_S")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "IWO_ID")
    private BigInteger iwoId;
    @Column(name = "SERVICE_ID")
    private BigInteger serviceId;
    @Size(max = 20)
    @Column(name = "SERVICE")
    private String service;
    @Lob
    @Column(name = "SERVICE_DESCRIPTION")
    private String serviceDescription;
    @Size(max = 1024)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 512)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;

    public GlobInspworkorderServices() {
    }

    public GlobInspworkorderServices(BigInteger iwoId, BigInteger serviceId, String service, String serviceDescription, String type, String lastMod, String lastModBy, String lastModIp) {
        this.iwoId = iwoId;
        this.serviceId = serviceId;
        this.service = service;
        this.serviceDescription = serviceDescription;
        this.type = type;
        this.lastMod = lastMod;
        this.lastModBy = lastModBy;
        this.lastModIp = lastModIp;
    }

    public GlobInspworkorderServices(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIwoId() {
        return iwoId;
    }

    public void setIwoId(BigInteger iwoId) {
        this.iwoId = iwoId;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
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
        if (!(object instanceof GlobInspworkorderServices)) {
            return false;
        }
        GlobInspworkorderServices other = (GlobInspworkorderServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobInspworkorderServices[ id=" + id + " ]";
    }

}
