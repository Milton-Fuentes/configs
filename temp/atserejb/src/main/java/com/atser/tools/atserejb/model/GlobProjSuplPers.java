/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "GlobProjSuplPers.findBySupplierPersonnelId", query = "SELECT q FROM GlobProjSuplPers q WHERE q.supplierPersonnelId = :supplierPersonnelId"),
    @NamedQuery(name = "GlobProjSuplPers.findByProjSuplPersId", query = "SELECT q FROM GlobProjSuplPers q WHERE q.projSuplPersId = :projSuplPersId"),
    @NamedQuery(name = "GlobProjSuplPers.findByCreateDate", query = "SELECT q FROM GlobProjSuplPers q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "GlobProjSuplPers.findByLastModDate", query = "SELECT q FROM GlobProjSuplPers q WHERE q.lastModDate = :lastModDate"),
    @NamedQuery(name = "GlobProjSuplPers.findByVersion", query = "SELECT q FROM GlobProjSuplPers q WHERE q.version = :version"),
    @NamedQuery(name = "GlobProjSuplPers.findByDeleted", query = "SELECT q FROM GlobProjSuplPers q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "GlobProjSuplPers.findByActive", query = "SELECT q FROM GlobProjSuplPers q WHERE q.active = :active")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE GLOB_PROJ_SUPL_PERS SET DELETED = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "DELETED = 'N'")
@Table(name = "GLOB_PROJ_SUPL_PERS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjSuplPers.findAll", query = "SELECT q FROM GlobProjSuplPers q"),
    @NamedQuery(name = "GlobProjSuplPers.findById", query = "SELECT q FROM GlobProjSuplPers q WHERE q.id = :id")})
public class GlobProjSuplPers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PROJ_SUPL_PERS_SEQ", sequenceName = "GLOB_PROJ_SUPL_PERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJ_SUPL_PERS_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SUPPLIER_PERSONNEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSupplierPersonnel supplierPersonnelId;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "LAST_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDate;
    @Column(name = "VERSION")
    private BigInteger version;
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "MAIN")
    private Character main;
    @JoinColumn(name = "PROJ_SUPPL_ADDR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobProjSupplAddr projSupplAddrId;
    

    public GlobProjSuplPers() {
    }

    public GlobProjSuplPers(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
    }

    public GlobProjSupplAddr getProjSupplAddrId() {
        return projSupplAddrId;
    }

    public void setProjSupplAddrId(GlobProjSupplAddr projSupplAddrId) {
        this.projSupplAddrId = projSupplAddrId;
    }

    public GlobSupplierPersonnel getSupplierPersonnelId() {
        return supplierPersonnelId;
    }

    public void setSupplierPersonnelId(GlobSupplierPersonnel supplierPersonnelId) {
        this.supplierPersonnelId = supplierPersonnelId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
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
        if (!(object instanceof GlobProjSuplPers)) {
            return false;
        }
        GlobProjSuplPers other = (GlobProjSuplPers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjSuplPers[ id=" + id + " ]";
    }
    
}
