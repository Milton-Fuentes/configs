/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
    @NamedQuery(name = "GlobSupplierPersonnel.findByContactName", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.contactName = :contactName"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByPhone", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.phone = :phone"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByCell", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.cell = :cell"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByFax", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.fax = :fax"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByAddress", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.address = :address"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByCity", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.city = :city"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByState", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.state = :state"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByZip", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.zip = :zip"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByEmail", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.email = :email"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByContactTitle", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.contactTitle = :contactTitle"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByMain", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.main = :main"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByCreateDate", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByLastModDate", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.lastModDate = :lastModDate"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByVersion", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.version = :version"),
    @NamedQuery(name = "GlobSupplierPersonnel.findByActive", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.active = :active")
*/

/**
 *
 * @author droldan
 */
@Entity
//@Audited
@SQLDelete(sql = "UPDATE GLOB_SUPPLIER_PERSONNEL SET active = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'N'")
@Table(name = "GLOB_SUPPLIER_PERSONNEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSupplierPersonnel.findAll", query = "SELECT q FROM GlobSupplierPersonnel q"),
    @NamedQuery(name = "GlobSupplierPersonnel.findById", query = "SELECT q FROM GlobSupplierPersonnel q WHERE q.id = :id")})
public class GlobSupplierPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_SUPPLIER_PERSONNEL_SEQ", sequenceName = "GLOB_SUPPLIER_PERSONNEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SUPPLIER_PERSONNEL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 50)
    @Column(name = "CELL")
    private String cell;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Column(name = "MAIN")
    private Character main;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "LAST_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDate;
    @Column(name = "VERSION")
    private BigInteger version;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JsonBackReference
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSupplier supplierId;
    @Column(name = "ENABLED", insertable = false)
    private Character enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierPersonnelId")
    private List<GlobProjSuplPers> globProjSuplPersList;

    public GlobSupplierPersonnel() {
    }

    public GlobSupplierPersonnel(BigDecimal id) {
        this.id = id;
    }

    public GlobSupplierPersonnel(BigDecimal id, String contactTitle) {
        this.id = id;
        this.contactTitle = contactTitle;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public GlobSupplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(GlobSupplier supplierId) {
        this.supplierId = supplierId;
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
        if (!(object instanceof GlobSupplierPersonnel)) {
            return false;
        }
        GlobSupplierPersonnel other = (GlobSupplierPersonnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSupplierPersonnel[ id=" + id + " ]";
    }
    
    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    public List<GlobProjSuplPers> getGlobProjSuplPersList() {
        return globProjSuplPersList;
    }

    public void setGlobProjSuplPersList(List<GlobProjSuplPers> globProjSuplPersList) {
        this.globProjSuplPersList = globProjSuplPersList;
    }
    
}
