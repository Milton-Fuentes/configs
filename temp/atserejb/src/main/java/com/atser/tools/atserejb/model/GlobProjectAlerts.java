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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobProjectAlerts.findByProjectId", query = "SELECT g FROM GlobProjectAlerts g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectAlerts.findByAlertType", query = "SELECT g FROM GlobProjectAlerts g WHERE g.alertType = :alertType")
    , @NamedQuery(name = "GlobProjectAlerts.findByContactId", query = "SELECT g FROM GlobProjectAlerts g WHERE g.contactId = :contactId")
    , @NamedQuery(name = "GlobProjectAlerts.findByAlerted", query = "SELECT g FROM GlobProjectAlerts g WHERE g.alerted = :alerted")
    , @NamedQuery(name = "GlobProjectAlerts.findByCreateDate", query = "SELECT g FROM GlobProjectAlerts g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobProjectAlerts.findByCreateBy", query = "SELECT g FROM GlobProjectAlerts g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobProjectAlerts.findByCreateByIp", query = "SELECT g FROM GlobProjectAlerts g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobProjectAlerts.findByLastMod", query = "SELECT g FROM GlobProjectAlerts g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobProjectAlerts.findByLastModBy", query = "SELECT g FROM GlobProjectAlerts g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobProjectAlerts.findByLastModIp", query = "SELECT g FROM GlobProjectAlerts g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobProjectAlerts.findByActive", query = "SELECT g FROM GlobProjectAlerts g WHERE g.active = :active")
    , @NamedQuery(name = "GlobProjectAlerts.findByAlertDays", query = "SELECT g FROM GlobProjectAlerts g WHERE g.alertDays = :alertDays")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_ALERTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectAlerts.findAll", query = "SELECT g FROM GlobProjectAlerts g")
    , @NamedQuery(name = "GlobProjectAlerts.findById", query = "SELECT g FROM GlobProjectAlerts g WHERE g.id = :id")})
public class GlobProjectAlerts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "ALERT_TYPE")
    private String alertType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACT_ID")
    private BigInteger contactId;
    @Column(name = "ALERTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alerted;
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
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "ALERT_DAYS")
    private BigInteger alertDays;

    public GlobProjectAlerts() {
    }

    public GlobProjectAlerts(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectAlerts(BigDecimal id, BigInteger projectId, BigInteger contactId) {
        this.id = id;
        this.projectId = projectId;
        this.contactId = contactId;
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

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public Date getAlerted() {
        return alerted;
    }

    public void setAlerted(Date alerted) {
        this.alerted = alerted;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getAlertDays() {
        return alertDays;
    }

    public void setAlertDays(BigInteger alertDays) {
        this.alertDays = alertDays;
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
        if (!(object instanceof GlobProjectAlerts)) {
            return false;
        }
        GlobProjectAlerts other = (GlobProjectAlerts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectAlerts[ id=" + id + " ]";
    }
    
}
