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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
 @NamedQuery(name = "WsSubreport.findByClientId", query = "SELECT w FROM WsSubreport w WHERE w.clientId = :clientId"),
    @NamedQuery(name = "WsSubreport.findBySubreportName", query = "SELECT w FROM WsSubreport w WHERE w.subreportName = :subreportName"),
    @NamedQuery(name = "WsSubreport.findBySubreportPath", query = "SELECT w FROM WsSubreport w WHERE w.subreportPath = :subreportPath"),
    @NamedQuery(name = "WsSubreport.findByActive", query = "SELECT w FROM WsSubreport w WHERE w.active = :active"),
    @NamedQuery(name = "WsSubreport.findByDeleted", query = "SELECT w FROM WsSubreport w WHERE w.deleted = :deleted"),
    @NamedQuery(name = "WsSubreport.findByCreated", query = "SELECT w FROM WsSubreport w WHERE w.created = :created"),
    @NamedQuery(name = "WsSubreport.findByCreatedBy", query = "SELECT w FROM WsSubreport w WHERE w.createdBy = :createdBy"),
    @NamedQuery(name = "WsSubreport.findByCreatedByIp", query = "SELECT w FROM WsSubreport w WHERE w.createdByIp = :createdByIp"),
    @NamedQuery(name = "WsSubreport.findByLastMod", query = "SELECT w FROM WsSubreport w WHERE w.lastMod = :lastMod"),
    @NamedQuery(name = "WsSubreport.findByLastModBy", query = "SELECT w FROM WsSubreport w WHERE w.lastModBy = :lastModBy"),
    @NamedQuery(name = "WsSubreport.findByLastModByIp", query = "SELECT w FROM WsSubreport w WHERE w.lastModByIp = :lastModByIp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "WS_SUBREPORT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE WS_REPORT SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsSubreport.findAll", query = "SELECT w FROM WsSubreport w"),
    @NamedQuery(name = "WsSubreport.findById", query = "SELECT w FROM WsSubreport w WHERE w.id = :id")})
public class WsSubreport implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "WS_SUBREPORT_SEQ", sequenceName = "WS_SUBREPORT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_SUBREPORT_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID", nullable = false)
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "SUBREPORT_NAME", length = 255)
    private String subreportName;
    @Size(max = 1024)
    @Column(name = "SUBREPORT_PATH", length = 1024)
    private String subreportPath;
    @Size(max = 10)
    @Column(name = "ACTIVE", length = 10)
    private String active;
    @JsonIgnore
    @Size(max = 10)
    @Column(name = "DELETED", length = 10, insertable = false, updatable = false)
    private String deleted;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 150)
    @Column(name = "CREATED_BY", length = 150)
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP", length = 50)
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 150)
    @Column(name = "LAST_MOD_BY", length = 150)
    private String lastModBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_BY_IP", length = 50)
    private String lastModByIp;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subReportList")
    private List<WsReport> reportList;

    public WsSubreport() {
    }

    public WsSubreport(BigDecimal id) {
        this.id = id;
    }

    public WsSubreport(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getSubreportName() {
        return subreportName;
    }

    public void setSubreportName(String subreportName) {
        this.subreportName = subreportName;
    }

    public String getSubreportPath() {
        return subreportPath;
    }

    public void setSubreportPath(String subreportPath) {
        this.subreportPath = subreportPath;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModByIp() {
        return lastModByIp;
    }

    public void setLastModByIp(String lastModByIp) {
        this.lastModByIp = lastModByIp;
    }

    @XmlTransient
    public List<WsReport> getReportList() {
        return reportList;
    }

    public void setReportList(List<WsReport> reportList) {
        this.reportList = reportList;
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
        if (!(object instanceof WsSubreport)) {
            return false;
        }
        WsSubreport other = (WsSubreport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsSubreport[ id=" + id + " ]";
    }

}
