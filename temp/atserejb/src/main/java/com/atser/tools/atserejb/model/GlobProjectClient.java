/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobProjectClient.findByProjectClientName", query = "SELECT g FROM GlobProjectClient g WHERE g.projectClientName = :projectClientName")
    , @NamedQuery(name = "GlobProjectClient.findByContactName", query = "SELECT g FROM GlobProjectClient g WHERE g.contactName = :contactName")
    , @NamedQuery(name = "GlobProjectClient.findByCreditHold", query = "SELECT g FROM GlobProjectClient g WHERE g.creditHold = :creditHold")
    , @NamedQuery(name = "GlobProjectClient.findByProjectClientNo", query = "SELECT g FROM GlobProjectClient g WHERE g.projectClientNo = :projectClientNo")
    , @NamedQuery(name = "GlobProjectClient.findByZipcode", query = "SELECT g FROM GlobProjectClient g WHERE g.zipcode = :zipcode")
    , @NamedQuery(name = "GlobProjectClient.findByAddress4", query = "SELECT g FROM GlobProjectClient g WHERE g.address4 = :address4")
    , @NamedQuery(name = "GlobProjectClient.findByAddress3", query = "SELECT g FROM GlobProjectClient g WHERE g.address3 = :address3")
    , @NamedQuery(name = "GlobProjectClient.findByAddress2", query = "SELECT g FROM GlobProjectClient g WHERE g.address2 = :address2")
    , @NamedQuery(name = "GlobProjectClient.findByAddress1", query = "SELECT g FROM GlobProjectClient g WHERE g.address1 = :address1")
    , @NamedQuery(name = "GlobProjectClient.findByState", query = "SELECT g FROM GlobProjectClient g WHERE g.state = :state")
    , @NamedQuery(name = "GlobProjectClient.findByCity", query = "SELECT g FROM GlobProjectClient g WHERE g.city = :city")
    , @NamedQuery(name = "GlobProjectClient.findByPhone", query = "SELECT g FROM GlobProjectClient g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobProjectClient.findByEmail", query = "SELECT g FROM GlobProjectClient g WHERE g.email = :email")
    , @NamedQuery(name = "GlobProjectClient.findByPhone2", query = "SELECT g FROM GlobProjectClient g WHERE g.phone2 = :phone2")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_CLIENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectClient.findAll", query = "SELECT g FROM GlobProjectClient g")
    , @NamedQuery(name = "GlobProjectClient.findById", query = "SELECT g FROM GlobProjectClient g WHERE g.id = :id")})
public class GlobProjectClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "PROJECT_CLIENT_NAME")
    private String projectClientName;
    @Size(max = 255)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CREDIT_HOLD")
    private Character creditHold;
    @Size(max = 255)
    @Column(name = "PROJECT_CLIENT_NO")
    private String projectClientNo;
    @Size(max = 4000)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Size(max = 4000)
    @Column(name = "ADDRESS_4")
    private String address4;
    @Size(max = 4000)
    @Column(name = "ADDRESS_3")
    private String address3;
    @Size(max = 4000)
    @Column(name = "ADDRESS_2")
    private String address2;
    @Size(max = 4000)
    @Column(name = "ADDRESS_1")
    private String address1;
    @Size(max = 4000)
    @Column(name = "STATE")
    private String state;
    @Size(max = 4000)
    @Column(name = "CITY")
    private String city;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "PHONE2")
    private String phone2;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient customerId;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobCompanies companyId;

    public GlobProjectClient() {
    }

    public GlobProjectClient(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProjectClientName() {
        return projectClientName;
    }

    public void setProjectClientName(String projectClientName) {
        this.projectClientName = projectClientName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Character getCreditHold() {
        return creditHold;
    }

    public void setCreditHold(Character creditHold) {
        this.creditHold = creditHold;
    }

    public String getProjectClientNo() {
        return projectClientNo;
    }

    public void setProjectClientNo(String projectClientNo) {
        this.projectClientNo = projectClientNo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public GlobClient getCustomerId() {
        return customerId;
    }

    public void setCustomerId(GlobClient customerId) {
        this.customerId = customerId;
    }

    public GlobCompanies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(GlobCompanies companyId) {
        this.companyId = companyId;
    }
    
    public String getProjectClientFullName() {
        if(StringSupport.isNullOrEmpty(this.projectClientName)) {
            return this.projectClientNo;
        }
        return "[ " + this.projectClientNo + " ] " + this.projectClientName;
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
        if (!(object instanceof GlobProjectClient)) {
            return false;
        }
        GlobProjectClient other = (GlobProjectClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectClient[ id=" + id + " ]";
    }
    
}
