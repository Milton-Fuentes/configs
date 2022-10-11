/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_SUPPLIER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectSupplier.findAll", query = "SELECT g FROM GlobProjectSupplier g"),
    @NamedQuery(name = "GlobProjectSupplier.findById", query = "SELECT g FROM GlobProjectSupplier g WHERE g.id = :id")})
public class GlobProjectSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PROJECT_SUPPLIER_ID_SEQ", sequenceName = "GLOB_PROJECT_SUPPLIER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJECT_SUPPLIER_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne
    @JsonIgnore
    private GlobProject projectId;
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobSupplier supplierId;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "ENABLED", insertable = false)
    private Character enabled;
    @JsonIgnore
    @Column(name = "ACTIVE", insertable = false)
    private Character active;

    public GlobProjectSupplier() {
    }

    public GlobProjectSupplier(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectSupplier(GlobProject projectId, GlobSupplier supplierId) {
        this.projectId = projectId;
        this.supplierId = supplierId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
    }

    public GlobSupplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(GlobSupplier supplierId) {
        this.supplierId = supplierId;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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
        if (!(object instanceof GlobProjectSupplier)) {
            return false;
        }
        GlobProjectSupplier other = (GlobProjectSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectSupplier[ id=" + id + " ]";
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }
    
    public GlobSupplierTO generateTo() {
        GlobSupplierTO obj = new GlobSupplierTO();
        obj.setService(this.getSupplierId().getService());
        obj.setSupplier(this.getSupplierId().getSupplier());
        obj.setLocation(this.getSupplierId().getLocation());
        obj.setContactName(this.getSupplierId().getContactName());
        obj.setContactTitle(this.getSupplierId().getContactTitle());
        obj.setEmail(this.getSupplierId().getEmail());
        obj.setPhone(this.getSupplierId().getPhone());
        obj.setCell(this.getSupplierId().getCell());
        obj.setAddress(this.getSupplierId().getAddress());
        obj.setCity(this.getSupplierId().getCity());
        obj.setZip(this.getSupplierId().getZip());
        obj.setDueDate(DateSupport.formatDate(this.getSupplierId().getDueDate(), DateSupport.FORMAT_US));
        return obj;
    }


}
