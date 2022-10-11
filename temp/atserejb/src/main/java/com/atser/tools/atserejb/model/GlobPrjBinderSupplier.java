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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "GlobPrjBinderSupplier.findByProjectId", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByLastMod", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByLastModBy", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByLastModIp", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByCreateDate", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByCreateBy", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByCreateByIp", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByVersion", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.version = :version"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByEnabled", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.enabled = :enabled"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findByActive", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.active = :active")
 */
/**
 *
 * @author dperez
 */
@Entity
@Table(name = "GLOB_PRJ_BINDER_SUPPLIER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_PRJ_BINDER_SUPPLIER SET ACTIVE = 'N' WHERE ID = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobPrjBinderSupplier.findAll", query = "SELECT g FROM GlobPrjBinderSupplier g"),
    @NamedQuery(name = "GlobPrjBinderSupplier.findById", query = "SELECT g FROM GlobPrjBinderSupplier g WHERE g.id = :id")})
public class GlobPrjBinderSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_PRJ_BINDER_SUPPLIER_SEQ", sequenceName = "GLOB_PRJ_BINDER_SUPPLIER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PRJ_BINDER_SUPPLIER_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION", insertable = false)
    private String version;
    @Column(name = "ENABLED", insertable = false)
    private Character enabled;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @JoinColumn(name = "BINDER_SUPPLIER_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobBinderSupplier binderSupplierId;

    public GlobPrjBinderSupplier() {
    }

    public GlobPrjBinderSupplier(BigDecimal id) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public GlobBinderSupplier getBinderSupplierId() {
        return binderSupplierId;
    }

    public void setBinderSupplierId(GlobBinderSupplier binderSupplierId) {
        this.binderSupplierId = binderSupplierId;
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
        if (!(object instanceof GlobPrjBinderSupplier)) {
            return false;
        }
        GlobPrjBinderSupplier other = (GlobPrjBinderSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobPrjBinderSupplier[ id=" + id + " ]";
    }

    public GlobSupplierTO generateTo() {
        GlobSupplierTO obj = new GlobSupplierTO();
        obj.setService(this.getBinderSupplierId().getSupplierId().getService());
        obj.setService(this.getBinderSupplierId().getSupplierId().getService());
        obj.setSupplier(this.getBinderSupplierId().getSupplierId().getSupplier());
        obj.setLocation(this.getBinderSupplierId().getSupplierId().getLocation());
        obj.setContactName(this.getBinderSupplierId().getSupplierId().getContactName());
        obj.setContactTitle(this.getBinderSupplierId().getSupplierId().getContactTitle());
        obj.setEmail(this.getBinderSupplierId().getSupplierId().getEmail());
        obj.setPhone(this.getBinderSupplierId().getSupplierId().getPhone());
        obj.setCell(this.getBinderSupplierId().getSupplierId().getCell());
        obj.setAddress(this.getBinderSupplierId().getSupplierId().getAddress());
        obj.setCity(this.getBinderSupplierId().getSupplierId().getCity());
        obj.setZip(this.getBinderSupplierId().getSupplierId().getZip());
        obj.setDueDate(DateSupport.formatDate(this.getBinderSupplierId().getSupplierId().getDueDate(), DateSupport.FORMAT_US));
        return obj;
    }

}
