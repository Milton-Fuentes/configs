/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
, @NamedQuery(name = "CmPersoninfo.findByCompanyId", query = "SELECT c FROM CmPersoninfo c WHERE c.companyId = :companyId")
    , @NamedQuery(name = "CmPersoninfo.findByFirstname", query = "SELECT c FROM CmPersoninfo c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "CmPersoninfo.findByLastname", query = "SELECT c FROM CmPersoninfo c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "CmPersoninfo.findByTitle", query = "SELECT c FROM CmPersoninfo c WHERE c.title = :title")
    , @NamedQuery(name = "CmPersoninfo.findByStreet", query = "SELECT c FROM CmPersoninfo c WHERE c.street = :street")
    , @NamedQuery(name = "CmPersoninfo.findByCity", query = "SELECT c FROM CmPersoninfo c WHERE c.city = :city")
    , @NamedQuery(name = "CmPersoninfo.findByState", query = "SELECT c FROM CmPersoninfo c WHERE c.state = :state")
    , @NamedQuery(name = "CmPersoninfo.findByZip", query = "SELECT c FROM CmPersoninfo c WHERE c.zip = :zip")
    , @NamedQuery(name = "CmPersoninfo.findByPhone", query = "SELECT c FROM CmPersoninfo c WHERE c.phone = :phone")
    , @NamedQuery(name = "CmPersoninfo.findByCellphone", query = "SELECT c FROM CmPersoninfo c WHERE c.cellphone = :cellphone")
    , @NamedQuery(name = "CmPersoninfo.findByFax", query = "SELECT c FROM CmPersoninfo c WHERE c.fax = :fax")
    , @NamedQuery(name = "CmPersoninfo.findByEmail", query = "SELECT c FROM CmPersoninfo c WHERE c.email = :email")
    , @NamedQuery(name = "CmPersoninfo.findByField1", query = "SELECT c FROM CmPersoninfo c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmPersoninfo.findByField2", query = "SELECT c FROM CmPersoninfo c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmPersoninfo.findByField3", query = "SELECT c FROM CmPersoninfo c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmPersoninfo.findByField4", query = "SELECT c FROM CmPersoninfo c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmPersoninfo.findByField5", query = "SELECT c FROM CmPersoninfo c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmPersoninfo.findByField6", query = "SELECT c FROM CmPersoninfo c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmPersoninfo.findByField7", query = "SELECT c FROM CmPersoninfo c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmPersoninfo.findByField8", query = "SELECT c FROM CmPersoninfo c WHERE c.field8 = :field8")
    , @NamedQuery(name = "CmPersoninfo.findByFirm", query = "SELECT c FROM CmPersoninfo c WHERE c.firm = :firm")
    , @NamedQuery(name = "CmPersoninfo.findByPager", query = "SELECT c FROM CmPersoninfo c WHERE c.pager = :pager")
    , @NamedQuery(name = "CmPersoninfo.findByPersoninfoTypeId", query = "SELECT c FROM CmPersoninfo c WHERE c.personinfoTypeId = :personinfoTypeId")
    , @NamedQuery(name = "CmPersoninfo.findByProgramId", query = "SELECT c FROM CmPersoninfo c WHERE c.programId = :programId")
    , @NamedQuery(name = "CmPersoninfo.findByActive", query = "SELECT c FROM CmPersoninfo c WHERE c.active = :active")
    , @NamedQuery(name = "CmPersoninfo.findByClientId", query = "SELECT c FROM CmPersoninfo c WHERE c.clientId = :clientId")
    , @NamedQuery(name = "CmPersoninfo.findByOwner", query = "SELECT c FROM CmPersoninfo c WHERE c.owner = :owner")
    , @NamedQuery(name = "CmPersoninfo.findByOwnerFk", query = "SELECT c FROM CmPersoninfo c WHERE c.ownerFk = :ownerFk")
    , @NamedQuery(name = "CmPersoninfo.findByMiddlename", query = "SELECT c FROM CmPersoninfo c WHERE c.middlename = :middlename")
    , @NamedQuery(name = "CmPersoninfo.findByLastMod", query = "SELECT c FROM CmPersoninfo c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmPersoninfo.findByLastModBy", query = "SELECT c FROM CmPersoninfo c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmPersoninfo.findByLastModIp", query = "SELECT c FROM CmPersoninfo c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmPersoninfo.findByCreateDate", query = "SELECT c FROM CmPersoninfo c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CmPersoninfo.findByCreateBy", query = "SELECT c FROM CmPersoninfo c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmPersoninfo.findByCreateByIp", query = "SELECT c FROM CmPersoninfo c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmPersoninfo.findByVersion", query = "SELECT c FROM CmPersoninfo c WHERE c.version = :version")
    , @NamedQuery(name = "CmPersoninfo.findByAuditInitials", query = "SELECT c FROM CmPersoninfo c WHERE c.auditInitials = :auditInitials")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_PERSONINFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmPersoninfo.findAll", query = "SELECT c FROM CmPersoninfo c")
    , @NamedQuery(name = "CmPersoninfo.findById", query = "SELECT c FROM CmPersoninfo c WHERE c.id = :id")})
public class CmPersoninfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "cm_personinfo_id_seq", sequenceName = "cm_personinfo_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cm_personinfo_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPANY_ID")
    private BigInteger companyId;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "STREET")
    private String street;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
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
    @Column(name = "CELLPHONE")
    private String cellphone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @JsonIgnore
    @Column(name = "FIELD5")
    private Double field5;
    @JsonIgnore
    @Column(name = "FIELD6")
    private Double field6;
    @JsonIgnore
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @JsonIgnore
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Size(max = 200)
    @Column(name = "FIRM")
    private String firm;
    @Size(max = 20)
    @Column(name = "PAGER")
    private String pager;
    @Column(name = "PERSONINFO_TYPE_ID")
    private BigInteger personinfoTypeId;
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "OWNER_FK")
    private BigInteger ownerFk;
    @Size(max = 50)
    @Column(name = "MIDDLENAME")
    private String middlename;
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
    @Column(name = "VERSION", insertable = false)
    private String version;
    @Size(max = 25)
    @Column(name = "AUDIT_INITIALS")
    private String auditInitials;

    public CmPersoninfo() {
    }

    public CmPersoninfo(BigDecimal id) {
        this.id = id;
    }

    public CmPersoninfo(BigDecimal id, BigInteger companyId) {
        this.id = id;
        this.companyId = companyId;
    }
    
    public CmPersoninfo(GlobContact ct, BigInteger companyId, BigInteger clientId, String cmFirm, String cmTitle, BigInteger personinfoTypeId  ) {
        this.companyId = companyId;
        this.firstname = ct.getFirstname();
        this.middlename = ct.getMiddlename();
        this.lastname = ct.getLastname();
        this.title = cmTitle;        
        this.street = ct.getAddress();
        this.city = ct.getCity();
        this.state = ct.getState();
        this.zip = ct.getZip();
        this.phone = ct.getPhone();
        this.cellphone = ct.getCell();
        this.email = ct.getEmail();
        this.firm = cmFirm;
        this.personinfoTypeId = personinfoTypeId;
        this.clientId = clientId;
        this.active = 'Y';
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public BigInteger getPersoninfoTypeId() {
        return personinfoTypeId;
    }

    public void setPersoninfoTypeId(BigInteger personinfoTypeId) {
        this.personinfoTypeId = personinfoTypeId;
    }

    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigInteger getOwnerFk() {
        return ownerFk;
    }

    public void setOwnerFk(BigInteger ownerFk) {
        this.ownerFk = ownerFk;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
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

    public String getAuditInitials() {
        return auditInitials;
    }

    public void setAuditInitials(String auditInitials) {
        this.auditInitials = auditInitials;
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
        if (!(object instanceof CmPersoninfo)) {
            return false;
        }
        CmPersoninfo other = (CmPersoninfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmPersoninfo[ id=" + id + " ]";
    }
    
}
