/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
, @NamedQuery(name = "CmContractManagement.findByItemnumber", query = "SELECT c FROM CmContractManagement c WHERE c.itemnumber = :itemnumber")
    , @NamedQuery(name = "CmContractManagement.findByCategory", query = "SELECT c FROM CmContractManagement c WHERE c.category = :category")
    , @NamedQuery(name = "CmContractManagement.findByRequirement", query = "SELECT c FROM CmContractManagement c WHERE c.requirement = :requirement")
    , @NamedQuery(name = "CmContractManagement.findByNotes", query = "SELECT c FROM CmContractManagement c WHERE c.notes = :notes")
    , @NamedQuery(name = "CmContractManagement.findByCompanyid", query = "SELECT c FROM CmContractManagement c WHERE c.companyid = :companyid")
    , @NamedQuery(name = "CmContractManagement.findByCompany", query = "SELECT c FROM CmContractManagement c WHERE c.company = :company")
    , @NamedQuery(name = "CmContractManagement.findByContactperson", query = "SELECT c FROM CmContractManagement c WHERE c.contactperson = :contactperson")
    , @NamedQuery(name = "CmContractManagement.findByContactaddress", query = "SELECT c FROM CmContractManagement c WHERE c.contactaddress = :contactaddress")
    , @NamedQuery(name = "CmContractManagement.findByLastsubmitdate", query = "SELECT c FROM CmContractManagement c WHERE c.lastsubmitdate = :lastsubmitdate")
    , @NamedQuery(name = "CmContractManagement.findByValidfrom", query = "SELECT c FROM CmContractManagement c WHERE c.validfrom = :validfrom")
    , @NamedQuery(name = "CmContractManagement.findByValidto", query = "SELECT c FROM CmContractManagement c WHERE c.validto = :validto")
    , @NamedQuery(name = "CmContractManagement.findByFileattached", query = "SELECT c FROM CmContractManagement c WHERE c.fileattached = :fileattached")
    , @NamedQuery(name = "CmContractManagement.findByNotificationto", query = "SELECT c FROM CmContractManagement c WHERE c.notificationto = :notificationto")
    , @NamedQuery(name = "CmContractManagement.findByStatus", query = "SELECT c FROM CmContractManagement c WHERE c.status = :status")
    , @NamedQuery(name = "CmContractManagement.findByCreateBy", query = "SELECT c FROM CmContractManagement c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmContractManagement.findByCreateByIp", query = "SELECT c FROM CmContractManagement c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmContractManagement.findByLastModBy", query = "SELECT c FROM CmContractManagement c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmContractManagement.findByLastMod", query = "SELECT c FROM CmContractManagement c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmContractManagement.findByLastModIp", query = "SELECT c FROM CmContractManagement c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmContractManagement.findByVersion", query = "SELECT c FROM CmContractManagement c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_CONTRACT_MANAGEMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmContractManagement.findAll", query = "SELECT c FROM CmContractManagement c")
    , @NamedQuery(name = "CmContractManagement.findById", query = "SELECT c FROM CmContractManagement c WHERE c.id = :id")})
public class CmContractManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ITEMNUMBER")
    private Long itemnumber;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 255)
    @Column(name = "REQUIREMENT")
    private String requirement;
    @Size(max = 255)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 255)
    @Column(name = "COMPANYID")
    private String companyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 255)
    @Column(name = "CONTACTPERSON")
    private String contactperson;
    @Size(max = 255)
    @Column(name = "CONTACTADDRESS")
    private String contactaddress;
    @Column(name = "LASTSUBMITDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastsubmitdate;
    @Column(name = "VALIDFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "VALIDTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @Size(max = 255)
    @Column(name = "FILEATTACHED")
    private String fileattached;
    @Size(max = 255)
    @Column(name = "NOTIFICATIONTO")
    private String notificationto;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 100)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public CmContractManagement() {
    }

    public CmContractManagement(Long id) {
        this.id = id;
    }

    public CmContractManagement(Long id, String company) {
        this.id = id;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemnumber() {
        return itemnumber;
    }

    public void setItemnumber(Long itemnumber) {
        this.itemnumber = itemnumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContactaddress() {
        return contactaddress;
    }

    public void setContactaddress(String contactaddress) {
        this.contactaddress = contactaddress;
    }

    public Date getLastsubmitdate() {
        return lastsubmitdate;
    }

    public void setLastsubmitdate(Date lastsubmitdate) {
        this.lastsubmitdate = lastsubmitdate;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public String getFileattached() {
        return fileattached;
    }

    public void setFileattached(String fileattached) {
        this.fileattached = fileattached;
    }

    public String getNotificationto() {
        return notificationto;
    }

    public void setNotificationto(String notificationto) {
        this.notificationto = notificationto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof CmContractManagement)) {
            return false;
        }
        CmContractManagement other = (CmContractManagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmContractManagement[ id=" + id + " ]";
    }
    
}
