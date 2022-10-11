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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobServicesField.findByServiceAbbrev", query = "SELECT g FROM GlobServicesField g WHERE g.serviceAbbrev = :serviceAbbrev")
    , @NamedQuery(name = "GlobServicesField.findByServiceLong", query = "SELECT g FROM GlobServicesField g WHERE g.serviceLong = :serviceLong")
    , @NamedQuery(name = "GlobServicesField.findByClientId", query = "SELECT g FROM GlobServicesField g WHERE g.clientId = :clientId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SERVICES_FIELD", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobServicesField.findAll", query = "SELECT g FROM GlobServicesField g")
    , @NamedQuery(name = "GlobServicesField.findById", query = "SELECT g FROM GlobServicesField g WHERE g.id = :id")})
public class GlobServicesField implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_SERVICES_FIELD_ID_SEQ", sequenceName = "GLOB_SERVICES_FIELD_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SERVICES_FIELD_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "SERVICE_ABBREV")
    private String serviceAbbrev;
    @Size(max = 4000)
    @Column(name = "SERVICE_LONG")
    private String serviceLong;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "FIELD_ORDER")
    private Integer fieldOrder;
    @Column(name = "TEST_METHOD_ID")
    private Integer testMethodId;  
    
    public GlobServicesField() {
    }

    public GlobServicesField(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getServiceAbbrev() {
        return serviceAbbrev;
    }

    public void setServiceAbbrev(String serviceAbbrev) {
        this.serviceAbbrev = serviceAbbrev;
    }

    public String getServiceLong() {
        return serviceLong;
    }

    public void setServiceLong(String serviceLong) {
        this.serviceLong = serviceLong;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public String getServiceFullName() {
        return "[ " + this.serviceAbbrev + " ] " + this.serviceLong;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
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
        if (!(object instanceof GlobServicesField)) {
            return false;
        }
        GlobServicesField other = (GlobServicesField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobServicesField[ id=" + id + " ]";
    }

    /**
     * @return the testMethodId
     */
    public Integer getTestMethodId() {
        return testMethodId;
    }

    /**
     * @param testMethodId the testMethodId to set
     */
    public void setTestMethodId(Integer testMethodId) {
        this.testMethodId = testMethodId;
    }
    
}
