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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobPerson.findByClientId", query = "SELECT g FROM GlobPerson g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobPerson.findByFirstName", query = "SELECT g FROM GlobPerson g WHERE g.firstName = :firstName")
    , @NamedQuery(name = "GlobPerson.findByLastName", query = "SELECT g FROM GlobPerson g WHERE g.lastName = :lastName")
    , @NamedQuery(name = "GlobPerson.findByPersonTitle", query = "SELECT g FROM GlobPerson g WHERE g.personTitle = :personTitle")
    , @NamedQuery(name = "GlobPerson.findByPersonType", query = "SELECT g FROM GlobPerson g WHERE g.personType = :personType")
    , @NamedQuery(name = "GlobPerson.findByCompanyName", query = "SELECT g FROM GlobPerson g WHERE g.companyName = :companyName")
    , @NamedQuery(name = "GlobPerson.findByHireDate", query = "SELECT g FROM GlobPerson g WHERE g.hireDate = :hireDate")
    , @NamedQuery(name = "GlobPerson.findByTermDate", query = "SELECT g FROM GlobPerson g WHERE g.termDate = :termDate")
    , @NamedQuery(name = "GlobPerson.findByRateReg", query = "SELECT g FROM GlobPerson g WHERE g.rateReg = :rateReg")
    , @NamedQuery(name = "GlobPerson.findByRateOvt", query = "SELECT g FROM GlobPerson g WHERE g.rateOvt = :rateOvt")
    , @NamedQuery(name = "GlobPerson.findByFingerprintFile", query = "SELECT g FROM GlobPerson g WHERE g.fingerprintFile = :fingerprintFile")
    , @NamedQuery(name = "GlobPerson.findByPhotoFile", query = "SELECT g FROM GlobPerson g WHERE g.photoFile = :photoFile")
    , @NamedQuery(name = "GlobPerson.findByImageTimestamp", query = "SELECT g FROM GlobPerson g WHERE g.imageTimestamp = :imageTimestamp")
    , @NamedQuery(name = "GlobPerson.findByStreet", query = "SELECT g FROM GlobPerson g WHERE g.street = :street")
    , @NamedQuery(name = "GlobPerson.findByCity", query = "SELECT g FROM GlobPerson g WHERE g.city = :city")
    , @NamedQuery(name = "GlobPerson.findByState", query = "SELECT g FROM GlobPerson g WHERE g.state = :state")
    , @NamedQuery(name = "GlobPerson.findByZip", query = "SELECT g FROM GlobPerson g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobPerson.findByPhone", query = "SELECT g FROM GlobPerson g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobPerson.findByEmail", query = "SELECT g FROM GlobPerson g WHERE g.email = :email")
    , @NamedQuery(name = "GlobPerson.findByNotes", query = "SELECT g FROM GlobPerson g WHERE g.notes = :notes")
    , @NamedQuery(name = "GlobPerson.findByCreateBy", query = "SELECT g FROM GlobPerson g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobPerson.findByCreateByIp", query = "SELECT g FROM GlobPerson g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobPerson.findByLastModBy", query = "SELECT g FROM GlobPerson g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobPerson.findByLastMod", query = "SELECT g FROM GlobPerson g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobPerson.findByLastModIp", query = "SELECT g FROM GlobPerson g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobPerson.findByVersion", query = "SELECT g FROM GlobPerson g WHERE g.version = :version")
    , @NamedQuery(name = "GlobPerson.findByPersonNo", query = "SELECT g FROM GlobPerson g WHERE g.personNo = :personNo")
    , @NamedQuery(name = "GlobPerson.findByActive", query = "SELECT g FROM GlobPerson g WHERE g.active = :active")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PERSON", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobPerson.findAll", query = "SELECT g FROM GlobPerson g")
    , @NamedQuery(name = "GlobPerson.findById", query = "SELECT g FROM GlobPerson g WHERE g.id = :id")})
public class GlobPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 200)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 200)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 200)
    @Column(name = "PERSON_TITLE")
    private String personTitle;
    @Size(max = 200)
    @Column(name = "PERSON_TYPE")
    private String personType;
    @Size(max = 200)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Column(name = "TERM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDate;
    @Column(name = "RATE_REG")
    private Double rateReg;
    @Column(name = "RATE_OVT")
    private Double rateOvt;
    @Size(max = 200)
    @Column(name = "FINGERPRINT_FILE")
    private String fingerprintFile;
    @Size(max = 200)
    @Column(name = "PHOTO_FILE")
    private String photoFile;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Lob
    @Column(name = "PHOTO_DATA")
    private Serializable photoData;
    @Lob
    @Column(name = "FINGERPRINT_DATA")
    private Serializable fingerprintData;
    @Size(max = 100)
    @Column(name = "STREET")
    private String street;
    @Size(max = 100)
    @Column(name = "CITY")
    private String city;
    @Size(max = 100)
    @Column(name = "STATE")
    private String state;
    @Size(max = 100)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 2000)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 100)
    @Column(name = "PERSON_NO")
    private String personNo;
    @Column(name = "ACTIVE")
    private Character active;

    public GlobPerson() {
    }

    public GlobPerson(BigDecimal id) {
        this.id = id;
    }

    public GlobPerson(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonTitle() {
        return personTitle;
    }

    public void setPersonTitle(String personTitle) {
        this.personTitle = personTitle;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getTermDate() {
        return termDate;
    }

    public void setTermDate(Date termDate) {
        this.termDate = termDate;
    }

    public Double getRateReg() {
        return rateReg;
    }

    public void setRateReg(Double rateReg) {
        this.rateReg = rateReg;
    }

    public Double getRateOvt() {
        return rateOvt;
    }

    public void setRateOvt(Double rateOvt) {
        this.rateOvt = rateOvt;
    }

    public String getFingerprintFile() {
        return fingerprintFile;
    }

    public void setFingerprintFile(String fingerprintFile) {
        this.fingerprintFile = fingerprintFile;
    }

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public Date getImageTimestamp() {
        return imageTimestamp;
    }

    public void setImageTimestamp(Date imageTimestamp) {
        this.imageTimestamp = imageTimestamp;
    }

    public Serializable getPhotoData() {
        return photoData;
    }

    public void setPhotoData(Serializable photoData) {
        this.photoData = photoData;
    }

    public Serializable getFingerprintData() {
        return fingerprintData;
    }

    public void setFingerprintData(Serializable fingerprintData) {
        this.fingerprintData = fingerprintData;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
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
        if (!(object instanceof GlobPerson)) {
            return false;
        }
        GlobPerson other = (GlobPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobPerson[ id=" + id + " ]";
    }
    
}
