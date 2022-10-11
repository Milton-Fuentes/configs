/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/*
    @NamedQuery(name = "QmPersonnel.findByFirstname", query = "SELECT q FROM QmPersonnel q WHERE q.firstname = :firstname"),
    @NamedQuery(name = "QmPersonnel.findByMiddlename", query = "SELECT q FROM QmPersonnel q WHERE q.middlename = :middlename"),
    @NamedQuery(name = "QmPersonnel.findByLastname", query = "SELECT q FROM QmPersonnel q WHERE q.lastname = :lastname"),
    @NamedQuery(name = "QmPersonnel.findByPhone", query = "SELECT q FROM QmPersonnel q WHERE q.phone = :phone"),
    @NamedQuery(name = "QmPersonnel.findByCell", query = "SELECT q FROM QmPersonnel q WHERE q.cell = :cell"),
    @NamedQuery(name = "QmPersonnel.findByAddress", query = "SELECT q FROM QmPersonnel q WHERE q.address = :address"),
    @NamedQuery(name = "QmPersonnel.findByCity", query = "SELECT q FROM QmPersonnel q WHERE q.city = :city"),
    @NamedQuery(name = "QmPersonnel.findByState", query = "SELECT q FROM QmPersonnel q WHERE q.state = :state"),
    @NamedQuery(name = "QmPersonnel.findByZip", query = "SELECT q FROM QmPersonnel q WHERE q.zip = :zip"),
    @NamedQuery(name = "QmPersonnel.findByTitle", query = "SELECT q FROM QmPersonnel q WHERE q.title = :title"),
    @NamedQuery(name = "QmPersonnel.findByEmail", query = "SELECT q FROM QmPersonnel q WHERE q.email = :email"),
    @NamedQuery(name = "QmPersonnel.findByMain", query = "SELECT q FROM QmPersonnel q WHERE q.main = :main"),
    @NamedQuery(name = "QmPersonnel.findByCreatedDate", query = "SELECT q FROM QmPersonnel q WHERE q.createdDate = :createdDate"),
    @NamedQuery(name = "QmPersonnel.findByLastModDate", query = "SELECT q FROM QmPersonnel q WHERE q.lastModDate = :lastModDate"),
    @NamedQuery(name = "QmPersonnel.findByDeleted", query = "SELECT q FROM QmPersonnel q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QmPersonnel.findByActive", query = "SELECT q FROM QmPersonnel q WHERE q.active = :active"),
    @NamedQuery(name = "QmPersonnel.findByFax", query = "SELECT q FROM QmPersonnel q WHERE q.fax = :fax")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QM_PERSONNEL", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QM_PERSONNEL SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmPersonnel.findAll", query = "SELECT q FROM QmPersonnel q"),
    @NamedQuery(name = "QmPersonnel.findById", query = "SELECT q FROM QmPersonnel q WHERE q.id = :id")})
public class QmPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QM_PERSONNEL_SEQ", sequenceName = "QM_PERSONNEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QM_PERSONNEL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 50)
    @Column(name = "CELL")
    private String cell;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITLE")
    private String title;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MAIN")
    private Character main;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "LAST_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDate;
    @Column(name = "VERSION")
    private BigInteger version;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    @NotAudited
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnelId", orphanRemoval = true)
    private List<QmProjContrPers> qmProjContrPersList;
    @NotAudited
    @Column(name = "CONTRACTOR_PERSONNEL_ID")
    private BigInteger contractorPersonnelId;

    public QmPersonnel() {
    }

    public QmPersonnel(BigDecimal id) {
        this.id = id;
    }

    public QmPersonnel(BigDecimal id, String title) {
        this.id = id;
        this.title = title;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlTransient
    public List<QmProjContrPers> getQmProjContrPersList() {
        return qmProjContrPersList;
    }

    public void setQmProjContrPersList(List<QmProjContrPers> qmProjContrPersList) {
        this.qmProjContrPersList = qmProjContrPersList;
    }
    
    public BigInteger getContractorPersonnelId() {
        return contractorPersonnelId;
    }

    public void setContractorPersonnelId(BigInteger contractorPersonnelId) {
        this.contractorPersonnelId = contractorPersonnelId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstname)
                .append(middlename)
                .append(lastname)
                .append(title)
                .append(address)
                .append(city)
                .append(state)
                .append(zip)
                .append(phone)
                .append(cell)
                .append(fax)
                .append(email)
                .append(main)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QmPersonnel)) {
            return false;
        }
        QmPersonnel other = (QmPersonnel) object;
        return new EqualsBuilder()
                .append(this.firstname, other.firstname)
                .append(this.middlename, other.middlename)
                .append(this.lastname, other.lastname)
                .append(this.title, other.title)
                .append(this.address, other.address)
                .append(this.city, other.city)
                .append(this.state, other.state)
                .append(this.zip, other.zip)
                .append(this.phone, other.phone)
                .append(this.cell, other.cell)
                .append(this.fax, other.fax)
                .append(this.email, other.email)
                .append(this.main, other.main)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmPersonnel[ id=" + id + " ]";
    }

}
