/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
, @NamedQuery(name = "CmContractor.findByName", query = "SELECT c FROM CmContractor c WHERE c.name = :name")
    , @NamedQuery(name = "CmContractor.findByCity", query = "SELECT c FROM CmContractor c WHERE c.city = :city")
    , @NamedQuery(name = "CmContractor.findByState", query = "SELECT c FROM CmContractor c WHERE c.state = :state")
    , @NamedQuery(name = "CmContractor.findByCountry", query = "SELECT c FROM CmContractor c WHERE c.country = :country")
    , @NamedQuery(name = "CmContractor.findByStreet", query = "SELECT c FROM CmContractor c WHERE c.street = :street")
    , @NamedQuery(name = "CmContractor.findByZip", query = "SELECT c FROM CmContractor c WHERE c.zip = :zip")
    , @NamedQuery(name = "CmContractor.findByPhone", query = "SELECT c FROM CmContractor c WHERE c.phone = :phone")
    , @NamedQuery(name = "CmContractor.findByFax", query = "SELECT c FROM CmContractor c WHERE c.fax = :fax")
    , @NamedQuery(name = "CmContractor.findByEmail", query = "SELECT c FROM CmContractor c WHERE c.email = :email")
    , @NamedQuery(name = "CmContractor.findByContactName", query = "SELECT c FROM CmContractor c WHERE c.contactName = :contactName")
    , @NamedQuery(name = "CmContractor.findByCategory", query = "SELECT c FROM CmContractor c WHERE c.category = :category")
    , @NamedQuery(name = "CmContractor.findByField1", query = "SELECT c FROM CmContractor c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmContractor.findByField2", query = "SELECT c FROM CmContractor c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmContractor.findByField3", query = "SELECT c FROM CmContractor c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmContractor.findByField4", query = "SELECT c FROM CmContractor c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmContractor.findByField5", query = "SELECT c FROM CmContractor c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmContractor.findByField6", query = "SELECT c FROM CmContractor c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmContractor.findByField7", query = "SELECT c FROM CmContractor c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmContractor.findByField8", query = "SELECT c FROM CmContractor c WHERE c.field8 = :field8")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_CONTRACTOR", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContractor.findAll", query = "SELECT c FROM CmContractor c")
    , @NamedQuery(name = "CmContractor.findById", query = "SELECT c FROM CmContractor c WHERE c.id = :id")})
public class CmContractor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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
    @Size(max = 50)
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

    public CmContractor() {
    }

    public CmContractor(BigDecimal id) {
        this.id = id;
    }

    public CmContractor(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmContractor)) {
            return false;
        }
        CmContractor other = (CmContractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContractor[ id=" + id + " ]";
    }
    
}
