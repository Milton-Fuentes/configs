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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    , @NamedQuery(name = "MgmtExcel.findByName", query = "SELECT m FROM MgmtExcel m WHERE m.name = :name")
    , @NamedQuery(name = "MgmtExcel.findByDescription", query = "SELECT m FROM MgmtExcel m WHERE m.description = :description")
    , @NamedQuery(name = "MgmtExcel.findByStatus", query = "SELECT m FROM MgmtExcel m WHERE m.status = :status")
    , @NamedQuery(name = "MgmtExcel.findByOpen", query = "SELECT m FROM MgmtExcel m WHERE m.open = :open")
    , @NamedQuery(name = "MgmtExcel.findByOpenBy", query = "SELECT m FROM MgmtExcel m WHERE m.openBy = :openBy")
    , @NamedQuery(name = "MgmtExcel.findByLastMod", query = "SELECT m FROM MgmtExcel m WHERE m.lastMod = :lastMod")
    , @NamedQuery(name = "MgmtExcel.findByLastModBy", query = "SELECT m FROM MgmtExcel m WHERE m.lastModBy = :lastModBy")
    , @NamedQuery(name = "MgmtExcel.findByLastModIp", query = "SELECT m FROM MgmtExcel m WHERE m.lastModIp = :lastModIp")
    , @NamedQuery(name = "MgmtExcel.findByCreated", query = "SELECT m FROM MgmtExcel m WHERE m.created = :created")
    , @NamedQuery(name = "MgmtExcel.findByCreateBy", query = "SELECT m FROM MgmtExcel m WHERE m.createBy = :createBy")
    , @NamedQuery(name = "MgmtExcel.findByCreateByIp", query = "SELECT m FROM MgmtExcel m WHERE m.createByIp = :createByIp")
    , @NamedQuery(name = "MgmtExcel.findByClientId", query = "SELECT m FROM MgmtExcel m WHERE m.clientId = :clientId")
    , @NamedQuery(name = "MgmtExcel.findByProjectId", query = "SELECT m FROM MgmtExcel m WHERE m.projectId = :projectId")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE MGMT_EXCEL SET status = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 0")
@Table(name = "MGMT_EXCEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgmtExcel.findAll", query = "SELECT m FROM MgmtExcel m")
    , @NamedQuery(name = "MgmtExcel.findById", query = "SELECT m FROM MgmtExcel m WHERE m.id = :id")})
public class MgmtExcel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "MGMT_EXCEL_SEQ", sequenceName = "MGMT_EXCEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MGMT_EXCEL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "DATA")
    @Basic(fetch = FetchType.LAZY)
    private String data;
    @Column(name = "STATUS", nullable = false, insertable = false)
    private Short status;
    @Column(name = "OPEN", nullable = false, insertable = false)
    private Short open;
    @Size(max = 100)
    @Column(name = "OPEN_BY")
    private String openBy;
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
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    public MgmtExcel() {
    }

    public MgmtExcel(BigDecimal id, String name, String description, Short status, Short open, String openBy, String lastMod, String lastModBy, String lastModIp, Date created, String createBy, String createByIp, BigInteger clientId, BigInteger projectId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.open = open;
        this.openBy = openBy;
        this.lastMod = lastMod;
        this.lastModBy = lastModBy;
        this.lastModIp = lastModIp;
        this.created = created;
        this.createBy = createBy;
        this.createByIp = createByIp;
        this.clientId = clientId;
        this.projectId = projectId;
    }

    public MgmtExcel(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getOpen() {
        return open;
    }

    public void setOpen(Short open) {
        this.open = open;
    }

    public String getOpenBy() {
        return openBy;
    }

    public void setOpenBy(String openBy) {
        this.openBy = openBy;
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

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof MgmtExcel)) {
            return false;
        }
        MgmtExcel other = (MgmtExcel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return "com.atser.tools.model.MgmtExcel[ name=" + name + " " + "description=" + description + " " + "date=" + created + "  ]";
    }
    
}
