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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    , @NamedQuery(name = "MgmtGanttResource.findByFirstName", query = "SELECT m FROM MgmtGanttResource m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "MgmtGanttResource.findByLastName", query = "SELECT m FROM MgmtGanttResource m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "MgmtGanttResource.findByTitle", query = "SELECT m FROM MgmtGanttResource m WHERE m.title = :title")
    , @NamedQuery(name = "MgmtGanttResource.findByStatus", query = "SELECT m FROM MgmtGanttResource m WHERE m.status = :status")
    , @NamedQuery(name = "MgmtGanttResource.findByLastMod", query = "SELECT m FROM MgmtGanttResource m WHERE m.lastMod = :lastMod")
    , @NamedQuery(name = "MgmtGanttResource.findByLastModBy", query = "SELECT m FROM MgmtGanttResource m WHERE m.lastModBy = :lastModBy")
    , @NamedQuery(name = "MgmtGanttResource.findByLastModIp", query = "SELECT m FROM MgmtGanttResource m WHERE m.lastModIp = :lastModIp")
    , @NamedQuery(name = "MgmtGanttResource.findByCreated", query = "SELECT m FROM MgmtGanttResource m WHERE m.created = :created")
    , @NamedQuery(name = "MgmtGanttResource.findByCreateBy", query = "SELECT m FROM MgmtGanttResource m WHERE m.createBy = :createBy")
    , @NamedQuery(name = "MgmtGanttResource.findByProjectId", query = "SELECT m FROM MgmtGanttResource m WHERE m.projectId = :projectId")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE MGMT_GANTT_RESOURCE SET status = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 0")
@Table(name = "MGMT_GANTT_RESOURCE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgmtGanttResource.findAll", query = "SELECT m FROM MgmtGanttResource m")
    , @NamedQuery(name = "MgmtGanttResource.findById", query = "SELECT m FROM MgmtGanttResource m WHERE m.id = :id")
    , @NamedQuery(name = "MgmtGanttResource.findByCode", query = "SELECT m FROM MgmtGanttResource m WHERE m.code = :code")
    , @NamedQuery(name = "MgmtGanttResource.checkExistByCode", query = "SELECT COUNT(m) FROM MgmtGanttResource m WHERE m.code = :code and m.projectId = :projectId")})
public class MgmtGanttResource implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "MGMT_GANTT_RESOURCE_SEQ", sequenceName = "MGMT_GANTT_RESOURCE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MGMT_GANTT_RESOURCE_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS", nullable = false, insertable = false)
    private Short status;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    public MgmtGanttResource() {
    }

    public MgmtGanttResource(BigDecimal id) {
        this.id = id;
    }
    
    public MgmtGanttResource(String code, String firstname, String lastname, String title, Date created, String createBy, String createByIp, BigInteger projectId) {
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.created = created;
        this.createBy = createBy;
        this.createByIp = createByIp;
        this.projectId = projectId;
    }

    public MgmtGanttResource(BigDecimal id, String code, String firstname, String lastname, String title, String description, Short status, String lastMod, String lastModBy, String lastModIp, Date created, String createBy, String createByIp, BigInteger projectId) {
        this.id = id;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.description = description;
        this.status = status;
        this.lastMod = lastMod;
        this.lastModBy = lastModBy;
        this.lastModIp = lastModIp;
        this.created = created;
        this.createBy = createBy;
        this.createByIp = createByIp;
        this.projectId = projectId;
    }

    public MgmtGanttResource(BigDecimal id, String code, String firstname, String lastname, String title, Date created, BigInteger projectId) {
        this.id = id;
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.created = created;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }
    
    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
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
        if (!(object instanceof MgmtGanttResource)) {
            return false;
        }
        MgmtGanttResource other = (MgmtGanttResource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.MgmtGanttResource[ id=" + id + " ]";
    }
    
}
