/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.objects.to.jasper.glob.GlobContractorTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/*
@NamedQuery(name = "GlobContractorPersonnel.findByClientId", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobContractorPersonnel.findByContractor", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.contractor = :contractor"),
    @NamedQuery(name = "GlobContractorPersonnel.findByFirstname", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "GlobContractorPersonnel.findByLastname", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GlobContractorPersonnel.findByTitle", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.title = :title"),
    @NamedQuery(name = "GlobContractorPersonnel.findByAddress", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.address = :address"),
    @NamedQuery(name = "GlobContractorPersonnel.findByCity", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.city = :city"),
    @NamedQuery(name = "GlobContractorPersonnel.findByState", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.state = :state"),
    @NamedQuery(name = "GlobContractorPersonnel.findByZip", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.zip = :zip"),
    @NamedQuery(name = "GlobContractorPersonnel.findByPhone", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.phone = :phone"),
    @NamedQuery(name = "GlobContractorPersonnel.findByCell", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.cell = :cell"),
    @NamedQuery(name = "GlobContractorPersonnel.findByFax", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.fax = :fax"),
    @NamedQuery(name = "GlobContractorPersonnel.findByEmail", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.email = :email"),
    @NamedQuery(name = "GlobContractorPersonnel.findByActive", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.active = :active"),
    @NamedQuery(name = "GlobContractorPersonnel.findByContractorCode", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.contractorCode = :contractorCode")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_CONTRACTOR_PERSONNEL SET ACTIVE = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ACTIVE = 'Y'")
@Table(name = "GLOB_CONTRACTOR_PERSONNEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContractorPersonnel.findAll", query = "SELECT g FROM GlobContractorPersonnel g"),
    @NamedQuery(name = "GlobContractorPersonnel.findById", query = "SELECT g FROM GlobContractorPersonnel g WHERE g.id = :id")})
public class GlobContractorPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_CONTR_PERSONNEL_ID_SEQ", sequenceName = "GLOB_CONTR_PERSONNEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_CONTR_PERSONNEL_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 15)
    @Column(name = "STATE")
    private String state;
    @Size(max = 20)
    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CELL")
    private String cell;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @JsonIgnore
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 50)
    @Column(name = "CONTRACTOR_CODE")
    private String contractorCode;
    @Size(max = 50)
    @Column(name = "DATA_PROVIDER")
    private String dataProvider;
    @Size(max = 1)
    @Column(name = "ENABLED", insertable = false)
    private String enabled;
    @NotAudited
    @Where(clause = "deleted = 'N'")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractorPersonnelId", fetch = FetchType.LAZY)
    private List<QmPersonnel> qmPersonnelList;
    @NotAudited
    @OneToMany(mappedBy = "contractorPersonnelId")
    private List<GlobProjContrPersonnel> globProjContrPersonnelList;

    public GlobContractorPersonnel() {
    }

    public GlobContractorPersonnel(BigDecimal id) {
        this.id = id;
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

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public void setContractorCode(String contractorCode) {
        this.contractorCode = contractorCode;
    }

    public String getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(contractor)
                .append(firstname)
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
                .append(contractorCode)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobContractorPersonnel)) {
            return false;
        }
        GlobContractorPersonnel other = (GlobContractorPersonnel) object;
        return new EqualsBuilder()
                .append(this.contractor, other.contractor)
                .append(this.firstname, other.firstname)
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
                .append(this.contractorCode, other.contractorCode)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContractorPersonnel[ id=" + id + " ]";
    }

    @XmlTransient
    public List<QmPersonnel> getQmPersonnelList() {
        return qmPersonnelList;
    }

    public void setQmPersonnelList(List<QmPersonnel> qmPersonnelList) {
        this.qmPersonnelList = qmPersonnelList;
    }

    @XmlTransient
    public List<GlobProjContrPersonnel> getGlobProjContrPersonnelList() {
        return globProjContrPersonnelList;
    }

    public void setGlobProjContrPersonnelList(List<GlobProjContrPersonnel> globProjContrPersonnelList) {
        this.globProjContrPersonnelList = globProjContrPersonnelList;
    }

    public GlobContractorTO generateTo() {
        GlobContractorTO obj = new GlobContractorTO();        
        obj.setClientId(this.getClientId().toString());
        obj.setContractor(this.getContractor());
        obj.setFirstname(this.getFirstname());
        obj.setLastname(this.getLastname());
        obj.setTitle(this.getTitle());
        obj.setAddress(this.getAddress());
        obj.setCity(this.getCity());
        obj.setState(this.getState());
        obj.setZip(this.getZip());
        obj.setPhone(this.getPhone());
        obj.setCell(this.getCell());
        obj.setFax(this.getFax());
        obj.setEmail(this.getEmail());
        obj.setActive(this.getActive().toString());
        obj.setContractorCode(this.getContractorCode());
        obj.setDataProvider(this.getDataProvider());
        obj.setEnabled(this.getEnabled());
        return obj;
    }

    /*public void addQmPersonnelList(QmPersonnel qmPersonnel) {
        qmPersonnelList.add(qmPersonnel);
        qmPersonnel.setContractorPersonnelId(this.id.toBigInteger());
    }

    public void removeQmPersonnelList(QmPersonnel qmPersonnel) {
        qmPersonnelList.remove(qmPersonnel);
        qmPersonnel.setContractorPersonnelId(null);
    }

    public void buildReferences() {
        if (qmPersonnelList != null && !qmPersonnelList.isEmpty()) {
            qmPersonnelList.forEach(p -> {
                p.setContractorPersonnelId(this.id.toBigInteger());
            });
        }
    }*/
}
