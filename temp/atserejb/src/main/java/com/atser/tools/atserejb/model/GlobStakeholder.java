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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "GlobStakeholder.findByProjectId", query = "SELECT g FROM GlobStakeholder g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobStakeholder.findByFirstname", query = "SELECT g FROM GlobStakeholder g WHERE g.firstname = :firstname")
    , @NamedQuery(name = "GlobStakeholder.findByMiddlename", query = "SELECT g FROM GlobStakeholder g WHERE g.middlename = :middlename")
    , @NamedQuery(name = "GlobStakeholder.findByLastname", query = "SELECT g FROM GlobStakeholder g WHERE g.lastname = :lastname")
    , @NamedQuery(name = "GlobStakeholder.findByPhone", query = "SELECT g FROM GlobStakeholder g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobStakeholder.findByEmail", query = "SELECT g FROM GlobStakeholder g WHERE g.email = :email")
    , @NamedQuery(name = "GlobStakeholder.findByActive", query = "SELECT g FROM GlobStakeholder g WHERE g.active = :active")
    , @NamedQuery(name = "GlobStakeholder.findByLastMod", query = "SELECT g FROM GlobStakeholder g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobStakeholder.findByLastModBy", query = "SELECT g FROM GlobStakeholder g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobStakeholder.findByLastModIp", query = "SELECT g FROM GlobStakeholder g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobStakeholder.findByCreateBy", query = "SELECT g FROM GlobStakeholder g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobStakeholder.findByCreateByIp", query = "SELECT g FROM GlobStakeholder g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobStakeholder.findByCreateDate", query = "SELECT g FROM GlobStakeholder g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobStakeholder.findByVersion", query = "SELECT g FROM GlobStakeholder g WHERE g.version = :version")
    , @NamedQuery(name = "GlobStakeholder.findByTitle", query = "SELECT g FROM GlobStakeholder g WHERE g.title = :title")
    , @NamedQuery(name = "GlobStakeholder.findByClientId", query = "SELECT g FROM GlobStakeholder g WHERE g.clientId = :clientId")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_STAKEHOLDER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobStakeholder.findAll", query = "SELECT g FROM GlobStakeholder g"),
    @NamedQuery(name = "GlobStakeholder.findById", query = "SELECT g FROM GlobStakeholder g WHERE g.id = :id")})
public class GlobStakeholder implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_STAKEHOLDER_SEQ", sequenceName = "GLOB_STAKEHOLDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_STAKEHOLDER_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
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
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ACTIVE")
    private Short active;
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
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "REF_CODE")
    private String refCode;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "COMPANY_TYPE")
    private BigInteger companyType;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(mappedBy = "globStakeholderList", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<GlobStakeholderGroup> globStakeholderGroupList;

    public GlobStakeholder() {
    }

    public GlobStakeholder(BigDecimal id) {
        this.id = id;
    }

    public GlobStakeholder(BigDecimal id, BigInteger projectId, String email) {
        this.id = id;
        this.projectId = projectId;
        this.email = email;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigInteger getCompanyType() {
        return companyType;
    }

    public void setCompanyType(BigInteger companyType) {
        this.companyType = companyType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @XmlTransient
//    public List<GlobStakeholderGroup> getGlobStakeholderGroupList() {
//        return globStakeholderGroupList;
//    }
//
//    public void setGlobStakeholderGroupList(List<GlobStakeholderGroup> globStakeholderGroupList) {
//        this.globStakeholderGroupList = globStakeholderGroupList;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.projectId);
        hash = 89 * hash + Objects.hashCode(this.firstname);
        hash = 89 * hash + Objects.hashCode(this.middlename);
        hash = 89 * hash + Objects.hashCode(this.lastname);
        hash = 89 * hash + Objects.hashCode(this.phone);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.clientId);
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.role);
        hash = 89 * hash + Objects.hashCode(this.companyName);
        hash = 89 * hash + Objects.hashCode(this.companyType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GlobStakeholder other = (GlobStakeholder) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.middlename, other.middlename)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        if (!Objects.equals(this.companyType, other.companyType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobStakeholder[ id=" + id + " ]";
    }

}
