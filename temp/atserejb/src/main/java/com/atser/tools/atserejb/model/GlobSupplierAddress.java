/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "GlobSupplierAddress.findBySupplierId", query = "SELECT g FROM GlobSupplierAddress g WHERE g.supplierId = :supplierId"),
    @NamedQuery(name = "GlobSupplierAddress.findByMain", query = "SELECT g FROM GlobSupplierAddress g WHERE g.main = :main"),
    @NamedQuery(name = "GlobSupplierAddress.findByAddress", query = "SELECT g FROM GlobSupplierAddress g WHERE g.address = :address"),
    @NamedQuery(name = "GlobSupplierAddress.findByCity", query = "SELECT g FROM GlobSupplierAddress g WHERE g.city = :city"),
    @NamedQuery(name = "GlobSupplierAddress.findByState", query = "SELECT g FROM GlobSupplierAddress g WHERE g.state = :state"),
    @NamedQuery(name = "GlobSupplierAddress.findByZip", query = "SELECT g FROM GlobSupplierAddress g WHERE g.zip = :zip"),
    @NamedQuery(name = "GlobSupplierAddress.findByLastMod", query = "SELECT g FROM GlobSupplierAddress g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSupplierAddress.findByLastModBy", query = "SELECT g FROM GlobSupplierAddress g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSupplierAddress.findByLastModIp", query = "SELECT g FROM GlobSupplierAddress g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSupplierAddress.findByCreateDate", query = "SELECT g FROM GlobSupplierAddress g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobSupplierAddress.findByCreateBy", query = "SELECT g FROM GlobSupplierAddress g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSupplierAddress.findByCreateByIp", query = "SELECT g FROM GlobSupplierAddress g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSupplierAddress.findByVersion", query = "SELECT g FROM GlobSupplierAddress g WHERE g.version = :version"),
    @NamedQuery(name = "GlobSupplierAddress.findByEnabled", query = "SELECT g FROM GlobSupplierAddress g WHERE g.enabled = :enabled"),
    @NamedQuery(name = "GlobSupplierAddress.findByActive", query = "SELECT g FROM GlobSupplierAddress g WHERE g.active = :active")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SUPPLIER_ADDRESS", catalog = "", schema = "ORACLE")
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSupplierAddress.findAll", query = "SELECT g FROM GlobSupplierAddress g"),
    @NamedQuery(name = "GlobSupplierAddress.findById", query = "SELECT g FROM GlobSupplierAddress g WHERE g.id = :id")})
public class GlobSupplierAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
     @SequenceGenerator(name = "GLOB_SUPPLIER_ADDRESS_SEQ", sequenceName = "GLOB_SUPPLIER_ADDRESS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SUPPLIER_ADDRESS_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Column(name = "MAIN")
    private Character main;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 50)
    @Column(name = "ZIP")
    private String zip;
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
    @Column(name = "ENABLED", insertable = false)
    private String enabled;
    @JsonIgnore
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 250)
    @Column(name = "LOCATION")
    private String location;

    public GlobSupplierAddress() {
    }

    public GlobSupplierAddress(BigDecimal id) {
        this.id = id;
    }

    public GlobSupplierAddress(BigInteger supplierId, Character main, String address, String city, String state, String zip, BigInteger version, String location) {
        this.supplierId = supplierId;
        this.main = main;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.version = version;
        this.location = location;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
    
    public String getPartialAddress() {
        if(StringSupport.isNullOrEmpty(city)) {
            return "";
        }
        if(StringSupport.isNullOrEmpty(state)) {
            return this.city;
        }
        return this.city + ", " + this.state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        if (!(object instanceof GlobSupplierAddress)) {
            return false;
        }
        GlobSupplierAddress other = (GlobSupplierAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSupplierAddress[ id=" + id + " ]";
    }
    
}
