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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_DEPARTMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobDepartment.findAll", query = "SELECT g FROM GlobDepartment g")
    , @NamedQuery(name = "GlobDepartment.findById", query = "SELECT g FROM GlobDepartment g WHERE g.id = :id")
    , @NamedQuery(name = "GlobDepartment.findByDepartmentId", query = "SELECT g FROM GlobDepartment g WHERE g.departmentId = :departmentId")
    , @NamedQuery(name = "GlobDepartment.findByDepartmentName", query = "SELECT g FROM GlobDepartment g WHERE g.departmentName = :departmentName")
    , @NamedQuery(name = "GlobDepartment.findByClientId", query = "SELECT g FROM GlobDepartment g WHERE g.clientId = :clientId")})
public class GlobDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 10)
    @Column(name = "DEPARTMENT_ID")
    private String departmentId;
    @Size(max = 4000)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public GlobDepartment() {
    }

    public GlobDepartment(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobDepartment)) {
            return false;
        }
        GlobDepartment other = (GlobDepartment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobDepartment[ id=" + id + " ]";
    }
    
}
