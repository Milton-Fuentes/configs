/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
    @NamedQuery(name = "GlobProjSupplAddr.findBySupplierAddressId", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.supplierAddressId = :supplierAddressId"),
    @NamedQuery(name = "GlobProjSupplAddr.findByProjectSupplierId", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.projectSupplierId = :projectSupplierId"),
    @NamedQuery(name = "GlobProjSupplAddr.findByMain", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.main = :main"),
    @NamedQuery(name = "GlobProjSupplAddr.findByLastMod", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobProjSupplAddr.findByLastModBy", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobProjSupplAddr.findByLastModIp", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobProjSupplAddr.findByCreateDate", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobProjSupplAddr.findByCreateBy", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobProjSupplAddr.findByCreateByIp", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobProjSupplAddr.findByVersion", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.version = :version"),
    @NamedQuery(name = "GlobProjSupplAddr.findByEnabled", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.enabled = :enabled"),
    @NamedQuery(name = "GlobProjSupplAddr.findByActive", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.active = :active")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJ_SUPPL_ADDR", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjSupplAddr.findAll", query = "SELECT g FROM GlobProjSupplAddr g"),
    @NamedQuery(name = "GlobProjSupplAddr.findById", query = "SELECT g FROM GlobProjSupplAddr g WHERE g.id = :id")})
public class GlobProjSupplAddr implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SUPPLIER_ADDRESS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSupplierAddress supplierAddressId;
    /*@Column(name = "SUPPLIER_ADDRESS_ID")
    private BigInteger supplierAddressId;*/
    @Column(name = "PROJECT_SUPPLIER_ID")
    private BigInteger projectSupplierId;
    @Column(name = "MAIN")
    private Character main;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 20)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 20)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "VERSION")
    private BigInteger version;
    @Size(max = 1)
    @Column(name = "ENABLED")
    private String enabled;
    @Column(name = "ACTIVE")
    private Character active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projSupplAddrId")
    private List<GlobProjSuplPers> globProjSuplPersList;

    public GlobProjSupplAddr() {
    }

    public GlobProjSupplAddr(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobSupplierAddress getSupplierAddressId() {
        return supplierAddressId;
    }

    public void setSupplierAddressId(GlobSupplierAddress supplierAddressId) {
        this.supplierAddressId = supplierAddressId;
    }

    public BigInteger getProjectSupplierId() {
        return projectSupplierId;
    }

    public void setProjectSupplierId(BigInteger projectSupplierId) {
        this.projectSupplierId = projectSupplierId;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
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

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    @XmlTransient
    public List<GlobProjSuplPers> getGlobProjSuplPersList() {
        return globProjSuplPersList;
    }

    public void setGlobProjSuplPersList(List<GlobProjSuplPers> globProjSuplPersList) {
        this.globProjSuplPersList = globProjSuplPersList;
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
        if (!(object instanceof GlobProjSupplAddr)) {
            return false;
        }
        GlobProjSupplAddr other = (GlobProjSupplAddr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjSupplAddr[ id=" + id + " ]";
    }

}
