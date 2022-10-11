/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "GlobLabsMaster.findByClientId", query = "SELECT g FROM GlobLabsMaster g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobLabsMaster.findByLabName", query = "SELECT g FROM GlobLabsMaster g WHERE g.labName = :labName"),
    @NamedQuery(name = "GlobLabsMaster.findByName", query = "SELECT g FROM GlobLabsMaster g WHERE g.name = :name"),
    @NamedQuery(name = "GlobLabsMaster.findByAddress", query = "SELECT g FROM GlobLabsMaster g WHERE g.address = :address"),
    @NamedQuery(name = "GlobLabsMaster.findByCity", query = "SELECT g FROM GlobLabsMaster g WHERE g.city = :city"),
    @NamedQuery(name = "GlobLabsMaster.findByState", query = "SELECT g FROM GlobLabsMaster g WHERE g.state = :state"),
    @NamedQuery(name = "GlobLabsMaster.findByContact", query = "SELECT g FROM GlobLabsMaster g WHERE g.contact = :contact"),
    @NamedQuery(name = "GlobLabsMaster.findByPhone", query = "SELECT g FROM GlobLabsMaster g WHERE g.phone = :phone"),
    @NamedQuery(name = "GlobLabsMaster.findByCell", query = "SELECT g FROM GlobLabsMaster g WHERE g.cell = :cell"),
    @NamedQuery(name = "GlobLabsMaster.findByFax", query = "SELECT g FROM GlobLabsMaster g WHERE g.fax = :fax"),
    @NamedQuery(name = "GlobLabsMaster.findByZip", query = "SELECT g FROM GlobLabsMaster g WHERE g.zip = :zip"),
    @NamedQuery(name = "GlobLabsMaster.findByEmail", query = "SELECT g FROM GlobLabsMaster g WHERE g.email = :email"),
    @NamedQuery(name = "GlobLabsMaster.findByLocation", query = "SELECT g FROM GlobLabsMaster g WHERE g.location = :location"),
    @NamedQuery(name = "GlobLabsMaster.findByLabType", query = "SELECT g FROM GlobLabsMaster g WHERE g.labType = :labType"),
    @NamedQuery(name = "GlobLabsMaster.findByTbpeRegistrationNo", query = "SELECT g FROM GlobLabsMaster g WHERE g.tbpeRegistrationNo = :tbpeRegistrationNo"),
    @NamedQuery(name = "GlobLabsMaster.findByCreated", query = "SELECT g FROM GlobLabsMaster g WHERE g.created = :created"),
    @NamedQuery(name = "GlobLabsMaster.findByCreatedBy", query = "SELECT g FROM GlobLabsMaster g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobLabsMaster.findByCreatedByIp", query = "SELECT g FROM GlobLabsMaster g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobLabsMaster.findByLastMod", query = "SELECT g FROM GlobLabsMaster g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobLabsMaster.findByLastModIp", query = "SELECT g FROM GlobLabsMaster g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobLabsMaster.findByLastModBy", query = "SELECT g FROM GlobLabsMaster g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobLabsMaster.findByFolderId", query = "SELECT g FROM GlobLabsMaster g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobLabsMaster.findByDeleted", query = "SELECT g FROM GlobLabsMaster g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobLabsMaster.findByActive", query = "SELECT g FROM GlobLabsMaster g WHERE g.active = :active"),
    @NamedQuery(name = "GlobLabsMaster.findByVersion", query = "SELECT g FROM GlobLabsMaster g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_LABS_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_LABS_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobLabsMaster.findAll", query = "SELECT g FROM GlobLabsMaster g"),
    @NamedQuery(name = "GlobLabsMaster.findById", query = "SELECT g FROM GlobLabsMaster g WHERE g.id = :id")})
public class GlobLabsMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_LABS_MASTER_SEQ", sequenceName = "GLOB_LABS_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_LABS_MASTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LAB_NAME")
    private String labName;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 255)
    @Column(name = "CONTACT")
    private String contact;
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
    @Size(max = 25)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 255)
    @Column(name = "LAB_TYPE")
    private String labType;
    @Size(max = 255)
    @Column(name = "TBPE_REGISTRATION_NO")
    private String tbpeRegistrationNo;
    @Column(name = "CREATED", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @Version
    @Column(name = "VERSION")
    private Long version;
    @OneToMany(mappedBy = "masterlabId", fetch = FetchType.LAZY)
    private List<GlobLabs> globLabsList;
    @Transient
    @JsonProperty("canBeEdited")
    private String canBeEdited;

    public GlobLabsMaster() {
        canBeEdited = "true";
    }

    public GlobLabsMaster(BigDecimal id) {
        canBeEdited = "true";
        this.id = id;
    }

    public GlobLabsMaster(BigDecimal id, BigInteger clientId, String labName) {
        canBeEdited = "true";
        this.id = id;
        this.clientId = clientId;
        this.labName = labName;
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

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLabType() {
        return labType;
    }

    public void setLabType(String labType) {
        this.labType = labType;
    }

    public String getTbpeRegistrationNo() {
        return tbpeRegistrationNo;
    }

    public void setTbpeRegistrationNo(String tbpeRegistrationNo) {
        this.tbpeRegistrationNo = tbpeRegistrationNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @XmlTransient
    public List<GlobLabs> getGlobLabsList() {
        return globLabsList;
    }

    public void setGlobLabsList(List<GlobLabs> globLabsList) {
        this.globLabsList = globLabsList;
    }

    public String getCanBeEdited() {
        return canBeEdited;
    }

    public void setCanBeEdited(String canBeEdited) {
        this.canBeEdited = canBeEdited;
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
        if (!(object instanceof GlobLabsMaster)) {
            return false;
        }
        GlobLabsMaster other = (GlobLabsMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobLabsMaster[ id=" + id + " ]";
    }

}
