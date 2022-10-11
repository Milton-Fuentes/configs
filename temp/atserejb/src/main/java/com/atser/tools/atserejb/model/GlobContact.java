/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "GlobContact.findByAddress", query = "SELECT g FROM GlobContact g WHERE g.address = :address")
    , @NamedQuery(name = "GlobContact.findByCity", query = "SELECT g FROM GlobContact g WHERE g.city = :city")
    , @NamedQuery(name = "GlobContact.findByState", query = "SELECT g FROM GlobContact g WHERE g.state = :state")
    , @NamedQuery(name = "GlobContact.findByZip", query = "SELECT g FROM GlobContact g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobContact.findByPhone", query = "SELECT g FROM GlobContact g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobContact.findByCell", query = "SELECT g FROM GlobContact g WHERE g.cell = :cell")
    , @NamedQuery(name = "GlobContact.findByPager", query = "SELECT g FROM GlobContact g WHERE g.pager = :pager")
    , @NamedQuery(name = "GlobContact.findByFax", query = "SELECT g FROM GlobContact g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobContact.findByEmail", query = "SELECT g FROM GlobContact g WHERE g.email = :email")
    , @NamedQuery(name = "GlobContact.findByTitle", query = "SELECT g FROM GlobContact g WHERE g.title = :title")
    , @NamedQuery(name = "GlobContact.findByFirstname", query = "SELECT g FROM GlobContact g WHERE g.firstname = :firstname")
    , @NamedQuery(name = "GlobContact.findByMiddlename", query = "SELECT g FROM GlobContact g WHERE g.middlename = :middlename")
    , @NamedQuery(name = "GlobContact.findByLastname", query = "SELECT g FROM GlobContact g WHERE g.lastname = :lastname")
    , @NamedQuery(name = "GlobContact.findBySuffix", query = "SELECT g FROM GlobContact g WHERE g.suffix = :suffix")
    , @NamedQuery(name = "GlobContact.findByActive", query = "SELECT g FROM GlobContact g WHERE g.active = :active")
    , @NamedQuery(name = "GlobContact.findByDepartmentId", query = "SELECT g FROM GlobContact g WHERE g.departmentId = :departmentId")
    , @NamedQuery(name = "GlobContact.findByClientId", query = "SELECT g FROM GlobContact g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobContact.findByCompanyName", query = "SELECT g FROM GlobContact g WHERE g.companyName = :companyName")
    , @NamedQuery(name = "GlobContact.findByCompanyLink", query = "SELECT g FROM GlobContact g WHERE g.companyLink = :companyLink")
    , @NamedQuery(name = "GlobContact.findByProjectId", query = "SELECT g FROM GlobContact g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobContact.findByEmployer", query = "SELECT g FROM GlobContact g WHERE g.employer = :employer")
    , @NamedQuery(name = "GlobContact.findByRegionId", query = "SELECT g FROM GlobContact g WHERE g.regionId = :regionId")
    , @NamedQuery(name = "GlobContact.findByTechnicianId", query = "SELECT g FROM GlobContact g WHERE g.technicianId = :technicianId")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTACT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContact.findAll", query = "SELECT g FROM GlobContact g"),
    @NamedQuery(name = "GlobContact.findById", query = "SELECT g FROM GlobContact g WHERE g.id = :id")})
public class GlobContact implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_CONTACT_ID_SEQ", sequenceName = "GLOB_CONTACT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_CONTACT_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 10)
    @Column(name = "STATE")
    private String state;
    @Size(max = 50)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CELL")
    private String cell;
    @Size(max = 20)
    @Column(name = "PAGER")
    private String pager;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 10)
    @Column(name = "SUFFIX")
    private String suffix;
    @Column(name = "ACTIVE",insertable = false)
    private Character active;
    @Column(name = "DEPARTMENT_ID")
    private BigInteger departmentId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Size(max = 1024)
    @Column(name = "COMPANY_LINK")
    private String companyLink;
    @Column(name = "PROJECT_ID", insertable = false)
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "EMPLOYER")
    private String employer;
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Size(max = 50)
    @Column(name = "TECHNICIAN_ID")
    private String technicianId;
    @Size(max = 255)
    @Column(name = "HRTITLE")
    private String hrTitle;
    @Size(max = 50)
    @Column(name = "UNITCODE")
    private String unitCode;
    @Size(max = 512)
    @Column(name = "UNITDESCRIPTION")
    private String unitDescription;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 255)
    @Column(name = "PRINTEDSIGN")
    private String printedSign;
    @Column(name = "DESIGNLAB")
    private BigInteger designLab;
    @Size(max = 50)
    @Column(name = "NOTF_PHONE")
    private String notfPhone;
    @Size(max = 255)
    @Column(name = "NOTF_MCARRIER")
    private String notfMCarrier;
    @Column(name = "NOTF_SMS_ACTIVE",insertable = false)
    private Character notfSmsActive;
    @OneToMany(mappedBy = "contactid", fetch = FetchType.LAZY)
    private List<GlobUsers> globUsersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId", fetch = FetchType.LAZY)
    private List<GlobProjectRole> globProjectRoleList;
    @OneToMany(mappedBy = "contactId", fetch = FetchType.LAZY)
    private List<GlobProjectPersonnel> globProjectPersonnelList;

    public GlobContact() {
    }

    public GlobContact(BigDecimal id) {
        this.id = id;
    }

    public String getFullNameWithTitle() {
        if (getTitle() == null || getTitle().isEmpty()) {
            return getFirstname() + " " + getLastname() + " ( - )";
        }
        return getFirstname() + " " + getLastname() + " ( " + getTitle() + " )";
    }

    public String getFullName() {
        return StringSupport.emptyOnNull(getFirstname()) + " " + StringSupport.emptyOnNull(getLastname());
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(BigInteger departmentId) {
        this.departmentId = departmentId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getHrTitle() {
        return hrTitle;
    }

    public void setHrTitle(String hrTitle) {
        this.hrTitle = hrTitle;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrintedSign() {
        return printedSign;
    }

    public void setPrintedSign(String printedSign) {
        this.printedSign = printedSign;
    }

    public BigInteger getDesignLab() {
        return designLab;
    }

    public void setDesignLab(BigInteger designLab) {
        this.designLab = designLab;
    }

    public String getNotfPhone() {
        return notfPhone;
    }

    public void setNotfPhone(String notfPhone) {
        this.notfPhone = notfPhone;
    }

    public String getNotfMCarrier() {
        return notfMCarrier;
    }

    public void setNotfMCarrier(String notfMCarrier) {
        this.notfMCarrier = notfMCarrier;
    }

    public Character getNotfSmsActive() {
        return notfSmsActive;
    }

    public void setNotfSmsActive(Character notfSmsActive) {
        this.notfSmsActive = notfSmsActive;
    }

    @XmlTransient
    public List<GlobUsers> getGlobUsersList() {
        return globUsersList;
    }

    public void setGlobUsersList(List<GlobUsers> globUsersList) {
        this.globUsersList = globUsersList;
    }

    @XmlTransient
    public List<GlobProjectPersonnel> getGlobProjectPersonnelList() {
        return globProjectPersonnelList;
    }

    public void setGlobProjectPersonnelList(List<GlobProjectPersonnel> globProjectPersonnelList) {
        this.globProjectPersonnelList = globProjectPersonnelList;
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
        if (!(object instanceof GlobContact)) {
            return false;
        }
        GlobContact other = (GlobContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContact[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobProjectRole> getGlobProjectRoleList() {
        return globProjectRoleList;
    }

    public void setGlobProjectRoleList(List<GlobProjectRole> globProjectRoleList) {
        this.globProjectRoleList = globProjectRoleList;
    }

}
