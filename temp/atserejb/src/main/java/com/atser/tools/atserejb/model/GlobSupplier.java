/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.NotAudited;

/*
    @NamedQuery(name = "GlobSupplier.findByClientId", query = "SELECT g FROM GlobSupplier g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobSupplier.findBySupplier", query = "SELECT g FROM GlobSupplier g WHERE g.supplier = :supplier"),
    @NamedQuery(name = "GlobSupplier.findByService", query = "SELECT g FROM GlobSupplier g WHERE g.service = :service"),
    @NamedQuery(name = "GlobSupplier.findByContactName", query = "SELECT g FROM GlobSupplier g WHERE g.contactName = :contactName"),
    @NamedQuery(name = "GlobSupplier.findByContactTitle", query = "SELECT g FROM GlobSupplier g WHERE g.contactTitle = :contactTitle"),
    @NamedQuery(name = "GlobSupplier.findByAddress", query = "SELECT g FROM GlobSupplier g WHERE g.address = :address"),
    @NamedQuery(name = "GlobSupplier.findByCity", query = "SELECT g FROM GlobSupplier g WHERE g.city = :city"),
    @NamedQuery(name = "GlobSupplier.findByState", query = "SELECT g FROM GlobSupplier g WHERE g.state = :state"),
    @NamedQuery(name = "GlobSupplier.findByZip", query = "SELECT g FROM GlobSupplier g WHERE g.zip = :zip"),
    @NamedQuery(name = "GlobSupplier.findByPhone", query = "SELECT g FROM GlobSupplier g WHERE g.phone = :phone"),
    @NamedQuery(name = "GlobSupplier.findByCell", query = "SELECT g FROM GlobSupplier g WHERE g.cell = :cell"),
    @NamedQuery(name = "GlobSupplier.findByFax", query = "SELECT g FROM GlobSupplier g WHERE g.fax = :fax"),
    @NamedQuery(name = "GlobSupplier.findByEmail", query = "SELECT g FROM GlobSupplier g WHERE g.email = :email"),
    @NamedQuery(name = "GlobSupplier.findByActive", query = "SELECT g FROM GlobSupplier g WHERE g.active = :active"),
    @NamedQuery(name = "GlobSupplier.findByLastMod", query = "SELECT g FROM GlobSupplier g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSupplier.findByLastModBy", query = "SELECT g FROM GlobSupplier g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSupplier.findByLastModIp", query = "SELECT g FROM GlobSupplier g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSupplier.findByCreateDate", query = "SELECT g FROM GlobSupplier g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobSupplier.findByCreateBy", query = "SELECT g FROM GlobSupplier g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobSupplier.findByCreateByIp", query = "SELECT g FROM GlobSupplier g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobSupplier.findByVersion", query = "SELECT g FROM GlobSupplier g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
//@Audited
@SQLDelete(sql = "UPDATE GLOB_SUPPLIER SET ACTIVE = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ACTIVE = 'Y'")
@Table(name = "GLOB_SUPPLIER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSupplier.findAll", query = "SELECT g FROM GlobSupplier g"),
    @NamedQuery(name = "GlobSupplier.findById", query = "SELECT g FROM GlobSupplier g WHERE g.id = :id"),
    @NamedQuery(name = "GlobSupplier.findByImpCode", query = "SELECT g FROM GlobSupplier g WHERE g.impCode = :impCode")})
public class GlobSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_SUPPLIER_ID_SEQ", sequenceName = "GLOB_SUPPLIER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SUPPLIER_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Size(max = 255)
    @Column(name = "SERVICE")
    private String service;
    /*@Size(max = 255)
    @Column(name = "SERVICE")
    private String service;*/
    @Size(max = 255)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Size(max = 255)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 15)
    @Column(name = "STATE")
    private String state;
    @Size(max = 20)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CELL")
    private String cell;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @JsonIgnore
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
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
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Size(max = 250)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 150)
    @Column(name = "IMP_CODE")
    private String impCode;
    @Size(max = 255)
    @Column(name = "IMP_VENDORID")
    private String impVendorId;
    @NotAudited
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId", orphanRemoval = true)
    private List<GlobSupplierPersonnel> globSupplierPersonnelList;
    @NotAudited
    @OneToMany(mappedBy = "supplierId")
    private List<GlobProjectSupplier> globProjectSupplierList;
    @NotAudited
    @OneToMany(mappedBy = "supplierId")
    private List<GlobBinderSupplier> globBinderSupplierList;

    public GlobSupplier() {
    }

    public GlobSupplier(BigInteger clientId, String matCatg, String createdBy, String createdByIp, SupplierDef elem) {
        this.clientId = clientId;
        this.supplier = elem.getSupplier() + " [ " + elem.getImpCode() + " ] ";
        this.service = matCatg;
        this.address = elem.getAddress();
        this.impCode = elem.getImpCode();
        this.impVendorId = elem.getImpVendorId();
        this.location = elem.getLocation();
        this.active = elem.getActive();
        this.createBy = createdBy;
        this.createByIp = createdByIp;
        this.createDate = new Date();
    }

    public GlobSupplier(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public String getImpCode() {
        return impCode;
    }

    public void setImpCode(String impCode) {
        this.impCode = impCode;
    }

    public String getImpVendorId() {
        return impVendorId;
    }

    public void setImpVendorId(String impVendorId) {
        this.impVendorId = impVendorId;
    }

    @XmlTransient
    public List<GlobSupplierPersonnel> getGlobSupplierPersonnelList() {
        return globSupplierPersonnelList;
    }

    public void setQmSupplierPersonnelList(List<GlobSupplierPersonnel> qmSupplierPersonnelList) {
        this.globSupplierPersonnelList = qmSupplierPersonnelList;
    }

    @XmlTransient
    public List<GlobProjectSupplier> getGlobProjectSupplierList() {
        return globProjectSupplierList;
    }

    public void setGlobProjectSupplierList(List<GlobProjectSupplier> globProjectSupplierList) {
        this.globProjectSupplierList = globProjectSupplierList;
    }

    public void addQmSupplierPersonnelList(GlobSupplierPersonnel qmPersonnel) {
        globSupplierPersonnelList.add(qmPersonnel);
        qmPersonnel.setSupplierId(this);
    }

    public void removeQmSupplierPersonnelList(GlobSupplierPersonnel qmPersonnel) {
        globSupplierPersonnelList.remove(qmPersonnel);
        qmPersonnel.setSupplierId(null);
    }

    public void buildReferences() {
        if (globSupplierPersonnelList != null && !globSupplierPersonnelList.isEmpty()) {
            globSupplierPersonnelList.forEach(p -> {
                p.setSupplierId(this);
            });
        }
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
        if (!(object instanceof GlobSupplier)) {
            return false;
        }
        GlobSupplier other = (GlobSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSupplier[ id=" + id + " ]";
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public List<GlobBinderSupplier> getGlobBinderSupplierList() {
        return globBinderSupplierList;
    }

    public void setGlobBinderSupplierList(List<GlobBinderSupplier> globBinderSupplierList) {
        this.globBinderSupplierList = globBinderSupplierList;
    }

    public GlobSupplierTO generateTo() {
        GlobSupplierTO obj = new GlobSupplierTO();
        obj.setService(this.getService());
        obj.setSupplier(this.getSupplier());
        obj.setLocation(this.getLocation());
        obj.setContactName(this.getContactName());
        obj.setContactTitle(this.getContactTitle());
        obj.setEmail(this.getEmail());
        obj.setPhone(this.getPhone());
        obj.setCell(this.getCell());
        obj.setAddress(this.getAddress());
        obj.setCity(this.getCity());
        obj.setZip(this.getZip());
        obj.setDueDate(DateSupport.formatDate(this.getDueDate(), DateSupport.FORMAT_US));
        return obj;
    }

}
