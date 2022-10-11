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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "CmEmDocument.findByDocId", query = "SELECT c FROM CmEmDocument c WHERE c.docId = :docId")
    , @NamedQuery(name = "CmEmDocument.findByLastRevisionDate", query = "SELECT c FROM CmEmDocument c WHERE c.lastRevisionDate = :lastRevisionDate")
    , @NamedQuery(name = "CmEmDocument.findByTitle", query = "SELECT c FROM CmEmDocument c WHERE c.title = :title")
    , @NamedQuery(name = "CmEmDocument.findByStatus", query = "SELECT c FROM CmEmDocument c WHERE c.status = :status")
    , @NamedQuery(name = "CmEmDocument.findByLocation", query = "SELECT c FROM CmEmDocument c WHERE c.location = :location")
    , @NamedQuery(name = "CmEmDocument.findByCreateBy", query = "SELECT c FROM CmEmDocument c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmEmDocument.findByCreateByIp", query = "SELECT c FROM CmEmDocument c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmEmDocument.findByLastModBy", query = "SELECT c FROM CmEmDocument c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmEmDocument.findByLastMod", query = "SELECT c FROM CmEmDocument c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmEmDocument.findByLastModIp", query = "SELECT c FROM CmEmDocument c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmEmDocument.findByVersion", query = "SELECT c FROM CmEmDocument c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_EM_DOCUMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmEmDocument.findAll", query = "SELECT c FROM CmEmDocument c")
    , @NamedQuery(name = "CmEmDocument.findById", query = "SELECT c FROM CmEmDocument c WHERE c.id = :id")})
public class CmEmDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOC_ID")
    private BigInteger docId;
    @Column(name = "LAST_REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRevisionDate;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;
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
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobProject projectId;

    public CmEmDocument() {
    }

    public CmEmDocument(BigDecimal id) {
        this.id = id;
    }

    public CmEmDocument(BigDecimal id, BigInteger docId) {
        this.id = id;
        this.docId = docId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getDocId() {
        return docId;
    }

    public void setDocId(BigInteger docId) {
        this.docId = docId;
    }

    public Date getLastRevisionDate() {
        return lastRevisionDate;
    }

    public void setLastRevisionDate(Date lastRevisionDate) {
        this.lastRevisionDate = lastRevisionDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
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
        if (!(object instanceof CmEmDocument)) {
            return false;
        }
        CmEmDocument other = (CmEmDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmEmDocument[ id=" + id + " ]";
    }
    
}
