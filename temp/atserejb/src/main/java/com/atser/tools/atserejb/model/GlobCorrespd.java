/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
, @NamedQuery(name = "GlobCorrespd.findByStatus", query = "SELECT g FROM GlobCorrespd g WHERE g.status = :status")
    , @NamedQuery(name = "GlobCorrespd.findByType", query = "SELECT g FROM GlobCorrespd g WHERE g.type = :type")
    , @NamedQuery(name = "GlobCorrespd.findByActive", query = "SELECT g FROM GlobCorrespd g WHERE g.active = :active")
    , @NamedQuery(name = "GlobCorrespd.findByReceivedDate", query = "SELECT g FROM GlobCorrespd g WHERE g.receivedDate = :receivedDate")
    , @NamedQuery(name = "GlobCorrespd.findBySentDate", query = "SELECT g FROM GlobCorrespd g WHERE g.sentDate = :sentDate")
    , @NamedQuery(name = "GlobCorrespd.findByCreatedDate", query = "SELECT g FROM GlobCorrespd g WHERE g.createdDate = :createdDate")
    , @NamedQuery(name = "GlobCorrespd.findByApprovedDate", query = "SELECT g FROM GlobCorrespd g WHERE g.approvedDate = :approvedDate")
    , @NamedQuery(name = "GlobCorrespd.findByFromCompany", query = "SELECT g FROM GlobCorrespd g WHERE g.fromCompany = :fromCompany")
    , @NamedQuery(name = "GlobCorrespd.findByFromPerson", query = "SELECT g FROM GlobCorrespd g WHERE g.fromPerson = :fromPerson")
    , @NamedQuery(name = "GlobCorrespd.findByToCompany", query = "SELECT g FROM GlobCorrespd g WHERE g.toCompany = :toCompany")
    , @NamedQuery(name = "GlobCorrespd.findByToPerson", query = "SELECT g FROM GlobCorrespd g WHERE g.toPerson = :toPerson")
    , @NamedQuery(name = "GlobCorrespd.findByDescription", query = "SELECT g FROM GlobCorrespd g WHERE g.description = :description")
    , @NamedQuery(name = "GlobCorrespd.findByTitle", query = "SELECT g FROM GlobCorrespd g WHERE g.title = :title")
    , @NamedQuery(name = "GlobCorrespd.findByDcn", query = "SELECT g FROM GlobCorrespd g WHERE g.dcn = :dcn")
    , @NamedQuery(name = "GlobCorrespd.findBySubject", query = "SELECT g FROM GlobCorrespd g WHERE g.subject = :subject")
    , @NamedQuery(name = "GlobCorrespd.findByRelatedTo", query = "SELECT g FROM GlobCorrespd g WHERE g.relatedTo = :relatedTo")
    , @NamedQuery(name = "GlobCorrespd.findByTrackingNumber", query = "SELECT g FROM GlobCorrespd g WHERE g.trackingNumber = :trackingNumber")
    , @NamedQuery(name = "GlobCorrespd.findByVersion", query = "SELECT g FROM GlobCorrespd g WHERE g.version = :version")
    , @NamedQuery(name = "GlobCorrespd.findByCategory", query = "SELECT g FROM GlobCorrespd g WHERE g.category = :category")
    , @NamedQuery(name = "GlobCorrespd.findByDeliveryMethod", query = "SELECT g FROM GlobCorrespd g WHERE g.deliveryMethod = :deliveryMethod")
    , @NamedQuery(name = "GlobCorrespd.findByNotes", query = "SELECT g FROM GlobCorrespd g WHERE g.notes = :notes")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CORRESPD", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCorrespd.findAll", query = "SELECT g FROM GlobCorrespd g")
    , @NamedQuery(name = "GlobCorrespd.findById", query = "SELECT g FROM GlobCorrespd g WHERE g.id = :id")})
public class GlobCorrespd implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 1)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 1)
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "RECEIVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;
    @Column(name = "SENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Size(max = 255)
    @Column(name = "FROM_COMPANY")
    private String fromCompany;
    @Size(max = 255)
    @Column(name = "FROM_PERSON")
    private String fromPerson;
    @Size(max = 255)
    @Column(name = "TO_COMPANY")
    private String toCompany;
    @Size(max = 255)
    @Column(name = "TO_PERSON")
    private String toPerson;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 20)
    @Column(name = "DCN")
    private String dcn;
    @Size(max = 255)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 20)
    @Column(name = "RELATED_TO")
    private String relatedTo;
    @Size(max = 20)
    @Column(name = "TRACKING_NUMBER")
    private String trackingNumber;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 20)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 20)
    @Column(name = "DELIVERY_METHOD")
    private String deliveryMethod;
    @Size(max = 255)
    @Column(name = "NOTES")
    private String notes;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient clientId;
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFile fileId;
    @JoinColumn(name = "REQUESTED_FOLDER_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFolder requestedFolderId;
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobProject projectId;
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID")
    @ManyToOne
    private GlobUsers createdBy;
    @JoinColumn(name = "PROCCESED_BY", referencedColumnName = "ID")
    @ManyToOne
    private GlobUsers proccesedBy;
    @JoinColumn(name = "APPROVED_BY", referencedColumnName = "ID")
    @ManyToOne
    private GlobUsers approvedBy;
    @OneToMany(mappedBy = "correspdId")
    private List<GlobFile> globFileList;

    public GlobCorrespd() {
    }

    public GlobCorrespd(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public String getToCompany() {
        return toCompany;
    }

    public void setToCompany(String toCompany) {
        this.toCompany = toCompany;
    }

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDcn() {
        return dcn;
    }

    public void setDcn(String dcn) {
        this.dcn = dcn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    public GlobFile getFileId() {
        return fileId;
    }

    public void setFileId(GlobFile fileId) {
        this.fileId = fileId;
    }

    public GlobFolder getRequestedFolderId() {
        return requestedFolderId;
    }

    public void setRequestedFolderId(GlobFolder requestedFolderId) {
        this.requestedFolderId = requestedFolderId;
    }

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
    }

    public GlobUsers getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(GlobUsers createdBy) {
        this.createdBy = createdBy;
    }

    public GlobUsers getProccesedBy() {
        return proccesedBy;
    }

    public void setProccesedBy(GlobUsers proccesedBy) {
        this.proccesedBy = proccesedBy;
    }

    public GlobUsers getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(GlobUsers approvedBy) {
        this.approvedBy = approvedBy;
    }

    @XmlTransient
    public List<GlobFile> getGlobFileList() {
        return globFileList;
    }

    public void setGlobFileList(List<GlobFile> globFileList) {
        this.globFileList = globFileList;
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
        if (!(object instanceof GlobCorrespd)) {
            return false;
        }
        GlobCorrespd other = (GlobCorrespd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCorrespd[ id=" + id + " ]";
    }
    
}
