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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "CmManagementFirm.findByName", query = "SELECT c FROM CmManagementFirm c WHERE c.name = :name")
    , @NamedQuery(name = "CmManagementFirm.findByCity", query = "SELECT c FROM CmManagementFirm c WHERE c.city = :city")
    , @NamedQuery(name = "CmManagementFirm.findByState", query = "SELECT c FROM CmManagementFirm c WHERE c.state = :state")
    , @NamedQuery(name = "CmManagementFirm.findByCountry", query = "SELECT c FROM CmManagementFirm c WHERE c.country = :country")
    , @NamedQuery(name = "CmManagementFirm.findByStreet", query = "SELECT c FROM CmManagementFirm c WHERE c.street = :street")
    , @NamedQuery(name = "CmManagementFirm.findByZip", query = "SELECT c FROM CmManagementFirm c WHERE c.zip = :zip")
    , @NamedQuery(name = "CmManagementFirm.findByPhone", query = "SELECT c FROM CmManagementFirm c WHERE c.phone = :phone")
    , @NamedQuery(name = "CmManagementFirm.findByFax", query = "SELECT c FROM CmManagementFirm c WHERE c.fax = :fax")
    , @NamedQuery(name = "CmManagementFirm.findByEmail", query = "SELECT c FROM CmManagementFirm c WHERE c.email = :email")
    , @NamedQuery(name = "CmManagementFirm.findByContactName", query = "SELECT c FROM CmManagementFirm c WHERE c.contactName = :contactName")
    , @NamedQuery(name = "CmManagementFirm.findByCategory", query = "SELECT c FROM CmManagementFirm c WHERE c.category = :category")
    , @NamedQuery(name = "CmManagementFirm.findByField1", query = "SELECT c FROM CmManagementFirm c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmManagementFirm.findByField2", query = "SELECT c FROM CmManagementFirm c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmManagementFirm.findByField3", query = "SELECT c FROM CmManagementFirm c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmManagementFirm.findByField4", query = "SELECT c FROM CmManagementFirm c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmManagementFirm.findByField5", query = "SELECT c FROM CmManagementFirm c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmManagementFirm.findByField6", query = "SELECT c FROM CmManagementFirm c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmManagementFirm.findByField7", query = "SELECT c FROM CmManagementFirm c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmManagementFirm.findByField8", query = "SELECT c FROM CmManagementFirm c WHERE c.field8 = :field8")
    , @NamedQuery(name = "CmManagementFirm.findByCompanyId", query = "SELECT c FROM CmManagementFirm c WHERE c.companyId = :companyId")
    , @NamedQuery(name = "CmManagementFirm.findByPhaseType", query = "SELECT c FROM CmManagementFirm c WHERE c.phaseType = :phaseType")
    , @NamedQuery(name = "CmManagementFirm.findByCapability", query = "SELECT c FROM CmManagementFirm c WHERE c.capability = :capability")
    , @NamedQuery(name = "CmManagementFirm.findByUrl", query = "SELECT c FROM CmManagementFirm c WHERE c.url = :url")
    , @NamedQuery(name = "CmManagementFirm.findByExpire", query = "SELECT c FROM CmManagementFirm c WHERE c.expire = :expire")
    , @NamedQuery(name = "CmManagementFirm.findByIsMwbe", query = "SELECT c FROM CmManagementFirm c WHERE c.isMwbe = :isMwbe")
    , @NamedQuery(name = "CmManagementFirm.findByApplicantType", query = "SELECT c FROM CmManagementFirm c WHERE c.applicantType = :applicantType")
    , @NamedQuery(name = "CmManagementFirm.findByContactTitle", query = "SELECT c FROM CmManagementFirm c WHERE c.contactTitle = :contactTitle")
    , @NamedQuery(name = "CmManagementFirm.findByPhoneCell", query = "SELECT c FROM CmManagementFirm c WHERE c.phoneCell = :phoneCell")
    , @NamedQuery(name = "CmManagementFirm.findByClientId", query = "SELECT c FROM CmManagementFirm c WHERE c.clientId = :clientId")
    , @NamedQuery(name = "CmManagementFirm.findByLastMod", query = "SELECT c FROM CmManagementFirm c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmManagementFirm.findByLastModBy", query = "SELECT c FROM CmManagementFirm c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmManagementFirm.findByLastModIp", query = "SELECT c FROM CmManagementFirm c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmManagementFirm.findByCreateDate", query = "SELECT c FROM CmManagementFirm c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CmManagementFirm.findByCreateBy", query = "SELECT c FROM CmManagementFirm c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmManagementFirm.findByCreateByIp", query = "SELECT c FROM CmManagementFirm c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmManagementFirm.findByVersion", query = "SELECT c FROM CmManagementFirm c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_MANAGEMENT_FIRM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmManagementFirm.findAll", query = "SELECT c FROM CmManagementFirm c")
    , @NamedQuery(name = "CmManagementFirm.findById", query = "SELECT c FROM CmManagementFirm c WHERE c.id = :id")})
public class CmManagementFirm implements Serializable {

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
    @Size(max = 100)
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
    @Column(name = "PHASE_TYPE")
    private Short phaseType;
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

    public CmManagementFirm() {
    }

    public CmManagementFirm(BigDecimal id) {
        this.id = id;
    }

    public CmManagementFirm(BigDecimal id, String name, Character isMwbe) {
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

    public Short getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(Short phaseType) {
        this.phaseType = phaseType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmManagementFirm)) {
            return false;
        }
        CmManagementFirm other = (CmManagementFirm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmManagementFirm[ id=" + id + " ]";
    }
    
}
