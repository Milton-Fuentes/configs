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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "GlobContractor.findByName", query = "SELECT g FROM GlobContractor g WHERE g.name = :name")
    , @NamedQuery(name = "GlobContractor.findByCity", query = "SELECT g FROM GlobContractor g WHERE g.city = :city")
    , @NamedQuery(name = "GlobContractor.findByState", query = "SELECT g FROM GlobContractor g WHERE g.state = :state")
    , @NamedQuery(name = "GlobContractor.findByCountry", query = "SELECT g FROM GlobContractor g WHERE g.country = :country")
    , @NamedQuery(name = "GlobContractor.findByStreet", query = "SELECT g FROM GlobContractor g WHERE g.street = :street")
    , @NamedQuery(name = "GlobContractor.findByZip", query = "SELECT g FROM GlobContractor g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobContractor.findByPhone", query = "SELECT g FROM GlobContractor g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobContractor.findByFax", query = "SELECT g FROM GlobContractor g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobContractor.findByEmail", query = "SELECT g FROM GlobContractor g WHERE g.email = :email")
    , @NamedQuery(name = "GlobContractor.findByContactName", query = "SELECT g FROM GlobContractor g WHERE g.contactName = :contactName")
    , @NamedQuery(name = "GlobContractor.findByCategory", query = "SELECT g FROM GlobContractor g WHERE g.category = :category")
    , @NamedQuery(name = "GlobContractor.findByField1", query = "SELECT g FROM GlobContractor g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobContractor.findByField2", query = "SELECT g FROM GlobContractor g WHERE g.field2 = :field2")
    , @NamedQuery(name = "GlobContractor.findByField3", query = "SELECT g FROM GlobContractor g WHERE g.field3 = :field3")
    , @NamedQuery(name = "GlobContractor.findByField4", query = "SELECT g FROM GlobContractor g WHERE g.field4 = :field4")
    , @NamedQuery(name = "GlobContractor.findByField5", query = "SELECT g FROM GlobContractor g WHERE g.field5 = :field5")
    , @NamedQuery(name = "GlobContractor.findByField6", query = "SELECT g FROM GlobContractor g WHERE g.field6 = :field6")
    , @NamedQuery(name = "GlobContractor.findByField7", query = "SELECT g FROM GlobContractor g WHERE g.field7 = :field7")
    , @NamedQuery(name = "GlobContractor.findByField8", query = "SELECT g FROM GlobContractor g WHERE g.field8 = :field8")
    , @NamedQuery(name = "GlobContractor.findByCompanyId", query = "SELECT g FROM GlobContractor g WHERE g.companyId = :companyId")
    , @NamedQuery(name = "GlobContractor.findByCapability", query = "SELECT g FROM GlobContractor g WHERE g.capability = :capability")
    , @NamedQuery(name = "GlobContractor.findByUrl", query = "SELECT g FROM GlobContractor g WHERE g.url = :url")
    , @NamedQuery(name = "GlobContractor.findByExpire", query = "SELECT g FROM GlobContractor g WHERE g.expire = :expire")
    , @NamedQuery(name = "GlobContractor.findByIsMwbe", query = "SELECT g FROM GlobContractor g WHERE g.isMwbe = :isMwbe")
    , @NamedQuery(name = "GlobContractor.findByApplicantType", query = "SELECT g FROM GlobContractor g WHERE g.applicantType = :applicantType")
    , @NamedQuery(name = "GlobContractor.findByContactTitle", query = "SELECT g FROM GlobContractor g WHERE g.contactTitle = :contactTitle")
    , @NamedQuery(name = "GlobContractor.findByPhoneCell", query = "SELECT g FROM GlobContractor g WHERE g.phoneCell = :phoneCell")
    , @NamedQuery(name = "GlobContractor.findByClientId", query = "SELECT g FROM GlobContractor g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobContractor.findByField9", query = "SELECT g FROM GlobContractor g WHERE g.field9 = :field9")
    , @NamedQuery(name = "GlobContractor.findByOwner", query = "SELECT g FROM GlobContractor g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobContractor.findByOwnerFk", query = "SELECT g FROM GlobContractor g WHERE g.ownerFk = :ownerFk")
    , @NamedQuery(name = "GlobContractor.findByLastMod", query = "SELECT g FROM GlobContractor g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobContractor.findByLastModBy", query = "SELECT g FROM GlobContractor g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobContractor.findByLastModIp", query = "SELECT g FROM GlobContractor g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobContractor.findByCreateDate", query = "SELECT g FROM GlobContractor g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobContractor.findByCreateBy", query = "SELECT g FROM GlobContractor g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobContractor.findByCreateByIp", query = "SELECT g FROM GlobContractor g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobContractor.findByVersion", query = "SELECT g FROM GlobContractor g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTRACTOR", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContractor.findAll", query = "SELECT g FROM GlobContractor g")
    , @NamedQuery(name = "GlobContractor.findById", query = "SELECT g FROM GlobContractor g WHERE g.id = :id")})
public class GlobContractor implements Serializable {

    @OneToMany(mappedBy = "contractorId")
    private List<GlobContractorContract> globContractorContractList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "CITY")
    private String city;
    @Size(max = 20)
    @Column(name = "STATE")
    private String state;
    @Size(max = 20)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 60)
    @Column(name = "STREET")
    private String street;
    @Size(max = 20)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Size(max = 4000)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    private Double field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Column(name = "COMPANY_ID")
    private BigInteger companyId;
    @Size(max = 250)
    @Column(name = "CAPABILITY")
    private String capability;
    @Size(max = 100)
    @Column(name = "URL")
    private String url;
    @Column(name = "EXPIRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_MWBE")
    private Character isMwbe;
    @Size(max = 5)
    @Column(name = "APPLICANT_TYPE")
    private String applicantType;
    @Size(max = 255)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Size(max = 256)
    @Column(name = "PHONE_CELL")
    private String phoneCell;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "FIELD9")
    private BigInteger field9;
    @Size(max = 50)
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "OWNER_FK")
    private BigInteger ownerFk;
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
    @Column(name = "VERSION")
    private String version;
    @JoinColumn(name = "PHASE_TYPE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobPhaseType phaseType;

    public GlobContractor() {
    }

    public GlobContractor(BigDecimal id) {
        this.id = id;
    }

    public GlobContractor(BigDecimal id, String name, Character isMwbe) {
        this.id = id;
        this.name = name;
        this.isMwbe = isMwbe;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Double getField6() {
        return field6;
    }

    public void setField6(Double field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
    }

    public BigInteger getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigInteger companyId) {
        this.companyId = companyId;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Character getIsMwbe() {
        return isMwbe;
    }

    public void setIsMwbe(Character isMwbe) {
        this.isMwbe = isMwbe;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getField9() {
        return field9;
    }

    public void setField9(BigInteger field9) {
        this.field9 = field9;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigInteger getOwnerFk() {
        return ownerFk;
    }

    public void setOwnerFk(BigInteger ownerFk) {
        this.ownerFk = ownerFk;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    public GlobPhaseType getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(GlobPhaseType phaseType) {
        this.phaseType = phaseType;
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
        if (!(object instanceof GlobContractor)) {
            return false;
        }
        GlobContractor other = (GlobContractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContractor[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobContractorContract> getGlobContractorContractList() {
        return globContractorContractList;
    }

    public void setGlobContractorContractList(List<GlobContractorContract> globContractorContractList) {
        this.globContractorContractList = globContractorContractList;
    }
    
}
