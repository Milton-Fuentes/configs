/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

/*
, @NamedQuery(name = "CmChangerequest.findByAmendmentNumber", query = "SELECT c FROM CmChangerequest c WHERE c.amendmentNumber = :amendmentNumber")
    , @NamedQuery(name = "CmChangerequest.findByTitle", query = "SELECT c FROM CmChangerequest c WHERE c.title = :title")
    , @NamedQuery(name = "CmChangerequest.findByDescription", query = "SELECT c FROM CmChangerequest c WHERE c.description = :description")
    , @NamedQuery(name = "CmChangerequest.findByStatus", query = "SELECT c FROM CmChangerequest c WHERE c.status = :status")
    , @NamedQuery(name = "CmChangerequest.findByRejectreason", query = "SELECT c FROM CmChangerequest c WHERE c.rejectreason = :rejectreason")
    , @NamedQuery(name = "CmChangerequest.findByClosenote", query = "SELECT c FROM CmChangerequest c WHERE c.closenote = :closenote")
    , @NamedQuery(name = "CmChangerequest.findByCreated", query = "SELECT c FROM CmChangerequest c WHERE c.created = :created")
    , @NamedQuery(name = "CmChangerequest.findByCreateBy", query = "SELECT c FROM CmChangerequest c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmChangerequest.findByInternalApprovedBy", query = "SELECT c FROM CmChangerequest c WHERE c.internalApprovedBy = :internalApprovedBy")
    , @NamedQuery(name = "CmChangerequest.findByInternalApprovedDate", query = "SELECT c FROM CmChangerequest c WHERE c.internalApprovedDate = :internalApprovedDate")
    , @NamedQuery(name = "CmChangerequest.findByApprovedBy", query = "SELECT c FROM CmChangerequest c WHERE c.approvedBy = :approvedBy")
    , @NamedQuery(name = "CmChangerequest.findByApprovedDate", query = "SELECT c FROM CmChangerequest c WHERE c.approvedDate = :approvedDate")
    , @NamedQuery(name = "CmChangerequest.findByParentId", query = "SELECT c FROM CmChangerequest c WHERE c.parentId = :parentId")
    , @NamedQuery(name = "CmChangerequest.findByCancreaterevision", query = "SELECT c FROM CmChangerequest c WHERE c.cancreaterevision = :cancreaterevision")
    , @NamedQuery(name = "CmChangerequest.findByVersion", query = "SELECT c FROM CmChangerequest c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_CHANGEREQUEST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmChangerequest.findAll", query = "SELECT c FROM CmChangerequest c")
    , @NamedQuery(name = "CmChangerequest.findById", query = "SELECT c FROM CmChangerequest c WHERE c.id = :id")})
public class CmChangerequest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "AMENDMENT_NUMBER")
    private String amendmentNumber;
    @Size(max = 150)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "REJECTREASON")
    private String rejectreason;
    @Size(max = 255)
    @Column(name = "CLOSENOTE")
    private String closenote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "INTERNAL_APPROVED_BY")
    private BigInteger internalApprovedBy;
    @Column(name = "INTERNAL_APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date internalApprovedDate;
    @Column(name = "APPROVED_BY")
    private BigInteger approvedBy;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "CANCREATEREVISION")
    private Short cancreaterevision;
    @Column(name = "VERSION")
    private BigInteger version;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobClient clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crid")
    private List<CmChangerequestTask> cmChangerequestTaskList;

    public CmChangerequest() {
    }

    public CmChangerequest(BigDecimal id) {
        this.id = id;
    }

    public CmChangerequest(BigDecimal id, String status, Date created) {
        this.id = id;
        this.status = status;
        this.created = created;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAmendmentNumber() {
        return amendmentNumber;
    }

    public void setAmendmentNumber(String amendmentNumber) {
        this.amendmentNumber = amendmentNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public String getClosenote() {
        return closenote;
    }

    public void setClosenote(String closenote) {
        this.closenote = closenote;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public BigInteger getInternalApprovedBy() {
        return internalApprovedBy;
    }

    public void setInternalApprovedBy(BigInteger internalApprovedBy) {
        this.internalApprovedBy = internalApprovedBy;
    }

    public Date getInternalApprovedDate() {
        return internalApprovedDate;
    }

    public void setInternalApprovedDate(Date internalApprovedDate) {
        this.internalApprovedDate = internalApprovedDate;
    }

    public BigInteger getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(BigInteger approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public Short getCancreaterevision() {
        return cancreaterevision;
    }

    public void setCancreaterevision(Short cancreaterevision) {
        this.cancreaterevision = cancreaterevision;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<CmChangerequestTask> getCmChangerequestTaskList() {
        return cmChangerequestTaskList;
    }

    public void setCmChangerequestTaskList(List<CmChangerequestTask> cmChangerequestTaskList) {
        this.cmChangerequestTaskList = cmChangerequestTaskList;
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
        if (!(object instanceof CmChangerequest)) {
            return false;
        }
        CmChangerequest other = (CmChangerequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmChangerequest[ id=" + id + " ]";
    }
    
}
