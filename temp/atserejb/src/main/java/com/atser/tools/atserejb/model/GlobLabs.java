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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobLabs.findByLabName", query = "SELECT g FROM GlobLabs g WHERE g.labName = :labName"),
    @NamedQuery(name = "GlobLabs.findByName", query = "SELECT g FROM GlobLabs g WHERE g.name = :name"),
    @NamedQuery(name = "GlobLabs.findByAddress", query = "SELECT g FROM GlobLabs g WHERE g.address = :address"),
    @NamedQuery(name = "GlobLabs.findByCity", query = "SELECT g FROM GlobLabs g WHERE g.city = :city"),
    @NamedQuery(name = "GlobLabs.findByState", query = "SELECT g FROM GlobLabs g WHERE g.state = :state"),
    @NamedQuery(name = "GlobLabs.findByContact", query = "SELECT g FROM GlobLabs g WHERE g.contact = :contact"),
    @NamedQuery(name = "GlobLabs.findByPhone", query = "SELECT g FROM GlobLabs g WHERE g.phone = :phone"),
    @NamedQuery(name = "GlobLabs.findByCell", query = "SELECT g FROM GlobLabs g WHERE g.cell = :cell"),
    @NamedQuery(name = "GlobLabs.findByFax", query = "SELECT g FROM GlobLabs g WHERE g.fax = :fax"),
    @NamedQuery(name = "GlobLabs.findByEmail", query = "SELECT g FROM GlobLabs g WHERE g.email = :email"),
    @NamedQuery(name = "GlobLabs.findByActive", query = "SELECT g FROM GlobLabs g WHERE g.active = :active"),
    @NamedQuery(name = "GlobLabs.findByLastMod", query = "SELECT g FROM GlobLabs g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobLabs.findByCompanyId", query = "SELECT g FROM GlobLabs g WHERE g.companyId = :companyId"),
    @NamedQuery(name = "GlobLabs.findByLocation", query = "SELECT g FROM GlobLabs g WHERE g.location = :location"),
    @NamedQuery(name = "GlobLabs.findByClientsLabid", query = "SELECT g FROM GlobLabs g WHERE g.clientsLabid = :clientsLabid"),
    @NamedQuery(name = "GlobLabs.findByClientId", query = "SELECT g FROM GlobLabs g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobLabs.findByLastModTmp", query = "SELECT g FROM GlobLabs g WHERE g.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "GlobLabs.findBySampleCatgId", query = "SELECT g FROM GlobLabs g WHERE g.sampleCatgId = :sampleCatgId"),
    @NamedQuery(name = "GlobLabs.findByPhysicalLabName", query = "SELECT g FROM GlobLabs g WHERE g.physicalLabName = :physicalLabName"),
    @NamedQuery(name = "GlobLabs.findByLabType", query = "SELECT g FROM GlobLabs g WHERE g.labType = :labType"),
    @NamedQuery(name = "GlobLabs.findByZip", query = "SELECT g FROM GlobLabs g WHERE g.zip = :zip"),
    @NamedQuery(name = "GlobLabs.findByTbpeRegistrationNo", query = "SELECT g FROM GlobLabs g WHERE g.tbpeRegistrationNo = :tbpeRegistrationNo"),
    @NamedQuery(name = "GlobLabs.findByUploadI2ms", query = "SELECT g FROM GlobLabs g WHERE g.uploadI2ms = :uploadI2ms")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_LABS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobLabs.findAll", query = "SELECT g FROM GlobLabs g"),
    @NamedQuery(name = "GlobLabs.findById", query = "SELECT g FROM GlobLabs g WHERE g.id = :id")})
public class GlobLabs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LAB_NAME")
    private String labName;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
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
    @Column(name = "CONTACT")
    private String contact;
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
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_labs_seq", sequenceName = "glob_labs_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_labs_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "COMPANY_ID")
    private BigInteger companyId;
    @Size(max = 4000)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 255)
    @Column(name = "CLIENTS_LABID")
    private String clientsLabid;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 20)
    @Column(name = "SAMPLE_CATG_ID")
    private String sampleCatgId;
    @Size(max = 255)
    @Column(name = "PHYSICAL_LAB_NAME")
    private String physicalLabName;
    @Size(max = 50)
    @Column(name = "LAB_TYPE")
    private String labType;
    @Size(max = 20)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 50)
    @Column(name = "TBPE_REGISTRATION_NO")
    private String tbpeRegistrationNo;
    @Column(name = "UPLOAD_I2MS")
    private Character uploadI2ms;
    @Column(name = "CONTRACTOR_CONTRACT_ID")
    private BigInteger contractorContractId;
    @JoinColumn(name = "FUNCTION_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFunctions functionId;
    @JoinColumn(name = "MASTERLABID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private GlobLabsMaster masterlabId;

    public GlobLabs() {
    }

    public GlobLabs(BigDecimal id) {
        this.id = id;
    }

    public GlobLabs(BigDecimal id, String labName) {
        this.id = id;
        this.labName = labName;
    }

    public String getLabName() {
        return labName;
    }

    public String getFullLabName() {
        if (getFunctionId() != null) {
            return getLabName() + " ( " + getFunctionId().getFName() + " )";
        }
        return getLabName();
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

    public String getFullAddress() {
        StringBuilder finalAddress = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(this.getAddress())) {
            finalAddress.append(this.getAddress());
        }
        if (StringSupport.isNotNullAndNotEmpty(this.getCity())) {
            finalAddress.append(" ").append(this.getCity());
        }
        if (StringSupport.isNotNullAndNotEmpty(this.getState())) {
            finalAddress.append(", ").append(this.getState());
        }
        return finalAddress.toString();
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

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigInteger companyId) {
        this.companyId = companyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientsLabid() {
        return clientsLabid;
    }

    public void setClientsLabid(String clientsLabid) {
        this.clientsLabid = clientsLabid;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getSampleCatgId() {
        return sampleCatgId;
    }

    public void setSampleCatgId(String sampleCatgId) {
        this.sampleCatgId = sampleCatgId;
    }

    public String getPhysicalLabName() {
        return physicalLabName;
    }

    public void setPhysicalLabName(String physicalLabName) {
        this.physicalLabName = physicalLabName;
    }

    public String getLabType() {
        return labType;
    }

    public void setLabType(String labType) {
        this.labType = labType;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTbpeRegistrationNo() {
        return tbpeRegistrationNo;
    }

    public void setTbpeRegistrationNo(String tbpeRegistrationNo) {
        this.tbpeRegistrationNo = tbpeRegistrationNo;
    }

    public Character getUploadI2ms() {
        return uploadI2ms;
    }

    public void setUploadI2ms(Character uploadI2ms) {
        this.uploadI2ms = uploadI2ms;
    }

    public BigInteger getContractorContractId() {
        return contractorContractId;
    }

    public void setContractorContractId(BigInteger contractorContractId) {
        this.contractorContractId = contractorContractId;
    }

    public GlobFunctions getFunctionId() {
        return functionId;
    }

    public void setFunctionId(GlobFunctions functionId) {
        this.functionId = functionId;
    }

    public GlobLabsMaster getMasterlabId() {
        return masterlabId;
    }

    public void setMasterlabId(GlobLabsMaster masterlabId) {
        this.masterlabId = masterlabId;
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
        if (!(object instanceof GlobLabs)) {
            return false;
        }
        GlobLabs other = (GlobLabs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobLabsV2[ id=" + id + " ]";
    }

}
