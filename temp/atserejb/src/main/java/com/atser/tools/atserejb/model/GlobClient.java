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
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobClient.findByCompanyName", query = "SELECT g FROM GlobClient g WHERE g.companyName = :companyName")
    , @NamedQuery(name = "GlobClient.findByName", query = "SELECT g FROM GlobClient g WHERE g.name = :name")
    , @NamedQuery(name = "GlobClient.findByDescription", query = "SELECT g FROM GlobClient g WHERE g.description = :description")
    , @NamedQuery(name = "GlobClient.findByAddress", query = "SELECT g FROM GlobClient g WHERE g.address = :address")
    , @NamedQuery(name = "GlobClient.findByCity", query = "SELECT g FROM GlobClient g WHERE g.city = :city")
    , @NamedQuery(name = "GlobClient.findByState", query = "SELECT g FROM GlobClient g WHERE g.state = :state")
    , @NamedQuery(name = "GlobClient.findByZip", query = "SELECT g FROM GlobClient g WHERE g.zip = :zip")
    , @NamedQuery(name = "GlobClient.findByContact", query = "SELECT g FROM GlobClient g WHERE g.contact = :contact")
    , @NamedQuery(name = "GlobClient.findByPhone", query = "SELECT g FROM GlobClient g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobClient.findByCell", query = "SELECT g FROM GlobClient g WHERE g.cell = :cell")
    , @NamedQuery(name = "GlobClient.findByFax", query = "SELECT g FROM GlobClient g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobClient.findByEmail", query = "SELECT g FROM GlobClient g WHERE g.email = :email")
    , @NamedQuery(name = "GlobClient.findByActive", query = "SELECT g FROM GlobClient g WHERE g.active = :active")
    , @NamedQuery(name = "GlobClient.findByLastMod", query = "SELECT g FROM GlobClient g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobClient.findByKeyBase", query = "SELECT g FROM GlobClient g WHERE g.keyBase = :keyBase")
    , @NamedQuery(name = "GlobClient.findByHasFlags", query = "SELECT g FROM GlobClient g WHERE g.hasFlags = :hasFlags")
    , @NamedQuery(name = "GlobClient.findByFlagId", query = "SELECT g FROM GlobClient g WHERE g.flagId = :flagId")
    , @NamedQuery(name = "GlobClient.findByManagedBy", query = "SELECT g FROM GlobClient g WHERE g.managedBy = :managedBy")
    , @NamedQuery(name = "GlobClient.findByLastModTmp", query = "SELECT g FROM GlobClient g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobClient.findBySystemName", query = "SELECT g FROM GlobClient g WHERE g.systemName = :systemName")
    , @NamedQuery(name = "GlobClient.findByDefaultLanguage", query = "SELECT g FROM GlobClient g WHERE g.defaultLanguage = :defaultLanguage")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClient.findAll", query = "SELECT g FROM GlobClient g"),
    @NamedQuery(name = "GlobClient.findById", query = "SELECT g FROM GlobClient g WHERE g.id = :id"), 
    @NamedQuery(name = "GlobClient.showBidITList", query = "SELECT g FROM GlobClient g WHERE g.active = :active AND g.showBidit = :showbidit") 
})
public class GlobClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
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
    @Size(max = 20)
    @Column(name = "KEY_BASE")
    private String keyBase;
    @Column(name = "HAS_FLAGS")
    private Character hasFlags;
    @Column(name = "FLAG_ID")
    private BigInteger flagId;
    @Size(max = 255)
    @Column(name = "MANAGED_BY")
    private String managedBy;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 100)
    @Column(name = "SYSTEM_NAME")
    private String systemName;
    @Size(max = 10)
    @Column(name = "GLOBAL_DCN")
    private String useGlobalDCN;
    @Column(name = "HAS_BPM")
    private Character hasBpm;
    @Size(max = 50)
    @Column(name = "DEFAULT_LANGUAGE")
    private String defaultLanguage;
    @Size(max = 255)
    @Column(name = "EMAIL_FROM")
    private String emailFrom;
    @JsonIgnore
    @Lob
    @Column(name = "CLIENT_CONFIG")
    private String clientConfig;
    @Column(name = "SHOW_BIDIT")
    private Character showBidit;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobCompanies companyId;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobProject> globProjectList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobFolderType> globFolderTypeList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobPhaseType> globPhaseTypeList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobProfiles> globProfilesList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<CmChangerequest> cmChangerequestList;
    @OneToMany(mappedBy = "customerId")
    private List<GlobProjectClient> globProjectClientList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobMenu> globMenuList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private Set<GlobClientTest> globClientTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<GlobClientModules> globClientModulesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobClientRoles> globClientRolesList;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private List<GlobFileArchive> globFileArchiveList;
    @OneToMany(mappedBy = "clientId")
    private List<GlobCorrespd> globCorrespdList;

    public GlobClient() {
    }

    public GlobClient(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Character getHasBpm() {
        return hasBpm;
    }

    public void setHasBpm(Character hasBpm) {
        this.hasBpm = hasBpm;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getKeyBase() {
        return keyBase;
    }

    public void setKeyBase(String keyBase) {
        this.keyBase = keyBase;
    }

    public Character getHasFlags() {
        return hasFlags;
    }

    public void setHasFlags(Character hasFlags) {
        this.hasFlags = hasFlags;
    }

    public BigInteger getFlagId() {
        return flagId;
    }

    public void setFlagId(BigInteger flagId) {
        this.flagId = flagId;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public GlobCompanies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(GlobCompanies companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public List<GlobProject> getGlobProjectList() {
        return globProjectList;
    }

    public void setGlobProjectList(List<GlobProject> globProjectList) {
        this.globProjectList = globProjectList;
    }

    public Set<GlobClientTest> getGlobClientTest() {
        return globClientTest;
    }

    public void setGlobClientTest(Set<GlobClientTest> globClientTest) {
        this.globClientTest = globClientTest;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getClientConfig() {
        return clientConfig;
    }

    public void setClientConfig(String clientConfig) {
        this.clientConfig = clientConfig;
    }

    public Character getShowBidit() {
        return showBidit;
    }

    public void setShowBidit(Character showBidit) {
        this.showBidit = showBidit;
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
        if (!(object instanceof GlobClient)) {
            return false;
        }
        GlobClient other = (GlobClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClient[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobMenu> getGlobMenuList() {
        return globMenuList;
    }

    public void setGlobMenuList(List<GlobMenu> globMenuList) {
        this.globMenuList = globMenuList;
    }

    @XmlTransient
    public List<GlobFolderType> getGlobFolderTypeList() {
        return globFolderTypeList;
    }

    public void setGlobFolderTypeList(List<GlobFolderType> globFolderTypeList) {
        this.globFolderTypeList = globFolderTypeList;
    }

    @XmlTransient
    public List<GlobPhaseType> getGlobPhaseTypeList() {
        return globPhaseTypeList;
    }

    public void setGlobPhaseTypeList(List<GlobPhaseType> globPhaseTypeList) {
        this.globPhaseTypeList = globPhaseTypeList;
    }

    @XmlTransient
    public List<GlobProfiles> getGlobProfilesList() {
        return globProfilesList;
    }

    public void setGlobProfilesList(List<GlobProfiles> globProfilesList) {
        this.globProfilesList = globProfilesList;
    }

    public String getUseGlobalDCN() {
        return useGlobalDCN;
    }

    public void setUseGlobalDCN(String useGlobalDCN) {
        this.useGlobalDCN = useGlobalDCN;
    }

    @XmlTransient
    public List<GlobClientModules> getGlobClientModulesList() {
        return globClientModulesList;
    }

    public void setGlobClientModulesList(List<GlobClientModules> globClientModulesList) {
        this.globClientModulesList = globClientModulesList;
    }

    @XmlTransient
    public List<GlobClientRoles> getGlobClientRolesList() {
        return globClientRolesList;
    }

    public void setGlobClientRolesList(List<GlobClientRoles> globClientRolesList) {
        this.globClientRolesList = globClientRolesList;
    }

    @XmlTransient
    public List<GlobFileArchive> getGlobFileArchiveList() {
        return globFileArchiveList;
    }

    public void setGlobFileArchiveList(List<GlobFileArchive> globFileArchiveList) {
        this.globFileArchiveList = globFileArchiveList;
    }

    @XmlTransient
    public List<CmChangerequest> getCmChangerequestList() {
        return cmChangerequestList;
    }

    public void setCmChangerequestList(List<CmChangerequest> cmChangerequestList) {
        this.cmChangerequestList = cmChangerequestList;
    }

    @XmlTransient
    public List<GlobProjectClient> getGlobProjectClientList() {
        return globProjectClientList;
    }

    public void setGlobProjectClientList(List<GlobProjectClient> globProjectClientList) {
        this.globProjectClientList = globProjectClientList;
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList() {
        return globCorrespdList;
    }

    public void setGlobCorrespdList(List<GlobCorrespd> globCorrespdList) {
        this.globCorrespdList = globCorrespdList;
    }
}
