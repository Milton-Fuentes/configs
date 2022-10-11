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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobFirms.findByName", query = "SELECT g FROM GlobFirms g WHERE g.name = :name")
    , @NamedQuery(name = "GlobFirms.findByCity", query = "SELECT g FROM GlobFirms g WHERE g.city = :city")
    , @NamedQuery(name = "GlobFirms.findByState", query = "SELECT g FROM GlobFirms g WHERE g.state = :state")
    , @NamedQuery(name = "GlobFirms.findByCountry", query = "SELECT g FROM GlobFirms g WHERE g.country = :country")
    , @NamedQuery(name = "GlobFirms.findByStreet", query = "SELECT g FROM GlobFirms g WHERE g.street = :street")
    , @NamedQuery(name = "GlobFirms.findByZip", query = "SELECT g FROM GlobFirms g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobFirms.findByPhone", query = "SELECT g FROM GlobFirms g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobFirms.findByFax", query = "SELECT g FROM GlobFirms g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobFirms.findByEmail", query = "SELECT g FROM GlobFirms g WHERE g.email = :email")
    , @NamedQuery(name = "GlobFirms.findByContactName", query = "SELECT g FROM GlobFirms g WHERE g.contactName = :contactName")
    , @NamedQuery(name = "GlobFirms.findByCategory", query = "SELECT g FROM GlobFirms g WHERE g.category = :category")
    , @NamedQuery(name = "GlobFirms.findByCompanyId", query = "SELECT g FROM GlobFirms g WHERE g.companyId = :companyId")
    , @NamedQuery(name = "GlobFirms.findByCapability", query = "SELECT g FROM GlobFirms g WHERE g.capability = :capability")
    , @NamedQuery(name = "GlobFirms.findByUrl", query = "SELECT g FROM GlobFirms g WHERE g.url = :url")
    , @NamedQuery(name = "GlobFirms.findByExpire", query = "SELECT g FROM GlobFirms g WHERE g.expire = :expire")
    , @NamedQuery(name = "GlobFirms.findByIsMwbe", query = "SELECT g FROM GlobFirms g WHERE g.isMwbe = :isMwbe")
    , @NamedQuery(name = "GlobFirms.findByField1", query = "SELECT g FROM GlobFirms g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobFirms.findByField2", query = "SELECT g FROM GlobFirms g WHERE g.field2 = :field2")
    , @NamedQuery(name = "GlobFirms.findByField3", query = "SELECT g FROM GlobFirms g WHERE g.field3 = :field3")
    , @NamedQuery(name = "GlobFirms.findByField4", query = "SELECT g FROM GlobFirms g WHERE g.field4 = :field4")
    , @NamedQuery(name = "GlobFirms.findByField5", query = "SELECT g FROM GlobFirms g WHERE g.field5 = :field5")
    , @NamedQuery(name = "GlobFirms.findByField6", query = "SELECT g FROM GlobFirms g WHERE g.field6 = :field6")
    , @NamedQuery(name = "GlobFirms.findByField7", query = "SELECT g FROM GlobFirms g WHERE g.field7 = :field7")
    , @NamedQuery(name = "GlobFirms.findByField8", query = "SELECT g FROM GlobFirms g WHERE g.field8 = :field8")
    , @NamedQuery(name = "GlobFirms.findByApplicantType", query = "SELECT g FROM GlobFirms g WHERE g.applicantType = :applicantType")
    , @NamedQuery(name = "GlobFirms.findByClientId", query = "SELECT g FROM GlobFirms g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobFirms.findByServiceType", query = "SELECT g FROM GlobFirms g WHERE g.serviceType = :serviceType")
    , @NamedQuery(name = "GlobFirms.findByContractDate", query = "SELECT g FROM GlobFirms g WHERE g.contractDate = :contractDate")
    , @NamedQuery(name = "GlobFirms.findByContractAmount", query = "SELECT g FROM GlobFirms g WHERE g.contractAmount = :contractAmount")
    , @NamedQuery(name = "GlobFirms.findByIsSbe", query = "SELECT g FROM GlobFirms g WHERE g.isSbe = :isSbe")
    , @NamedQuery(name = "GlobFirms.findByMinority", query = "SELECT g FROM GlobFirms g WHERE g.minority = :minority")
    , @NamedQuery(name = "GlobFirms.findByCertificationDate", query = "SELECT g FROM GlobFirms g WHERE g.certificationDate = :certificationDate")
    , @NamedQuery(name = "GlobFirms.findByScopeOfWork", query = "SELECT g FROM GlobFirms g WHERE g.scopeOfWork = :scopeOfWork")
    , @NamedQuery(name = "GlobFirms.findByPhoneCell", query = "SELECT g FROM GlobFirms g WHERE g.phoneCell = :phoneCell")
    , @NamedQuery(name = "GlobFirms.findByContactTitle", query = "SELECT g FROM GlobFirms g WHERE g.contactTitle = :contactTitle")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FIRMS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFirms.findAll", query = "SELECT g FROM GlobFirms g")
    , @NamedQuery(name = "GlobFirms.findById", query = "SELECT g FROM GlobFirms g WHERE g.id = :id")})
public class GlobFirms implements Serializable {

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
    @Size(max = 5)
    @Column(name = "APPLICANT_TYPE")
    private String applicantType;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 100)
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    @Column(name = "CONTRACT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractDate;
    @Column(name = "CONTRACT_AMOUNT")
    private Double contractAmount;
    @Column(name = "IS_SBE")
    private Character isSbe;
    @Size(max = 100)
    @Column(name = "MINORITY")
    private String minority;
    @Column(name = "CERTIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certificationDate;
    @Size(max = 100)
    @Column(name = "SCOPE_OF_WORK")
    private String scopeOfWork;
    @Size(max = 256)
    @Column(name = "PHONE_CELL")
    private String phoneCell;
    @Size(max = 256)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @JoinColumn(name = "PHASE_TYPE", referencedColumnName = "ID")
    @ManyToOne
    private GlobPhaseType phaseType;

    public GlobFirms() {
    }

    public GlobFirms(BigDecimal id) {
        this.id = id;
    }

    public GlobFirms(BigDecimal id, String name, Character isMwbe) {
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

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Character getIsSbe() {
        return isSbe;
    }

    public void setIsSbe(Character isSbe) {
        this.isSbe = isSbe;
    }

    public String getMinority() {
        return minority;
    }

    public void setMinority(String minority) {
        this.minority = minority;
    }

    public Date getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(Date certificationDate) {
        this.certificationDate = certificationDate;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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
        if (!(object instanceof GlobFirms)) {
            return false;
        }
        GlobFirms other = (GlobFirms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFirms[ id=" + id + " ]";
    }
    
}
