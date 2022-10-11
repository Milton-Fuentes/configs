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
, @NamedQuery(name = "GlobProjectAlertType.findByAlertType", query = "SELECT g FROM GlobProjectAlertType g WHERE g.alertType = :alertType")
    , @NamedQuery(name = "GlobProjectAlertType.findByAlertCaption", query = "SELECT g FROM GlobProjectAlertType g WHERE g.alertCaption = :alertCaption")
    , @NamedQuery(name = "GlobProjectAlertType.findByCreateDate", query = "SELECT g FROM GlobProjectAlertType g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobProjectAlertType.findByCreateBy", query = "SELECT g FROM GlobProjectAlertType g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobProjectAlertType.findByCreateByIp", query = "SELECT g FROM GlobProjectAlertType g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobProjectAlertType.findByLastMod", query = "SELECT g FROM GlobProjectAlertType g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobProjectAlertType.findByLastModBy", query = "SELECT g FROM GlobProjectAlertType g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobProjectAlertType.findByLastModIp", query = "SELECT g FROM GlobProjectAlertType g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobProjectAlertType.findByActive", query = "SELECT g FROM GlobProjectAlertType g WHERE g.active = :active")
    , @NamedQuery(name = "GlobProjectAlertType.findByAlertDefault", query = "SELECT g FROM GlobProjectAlertType g WHERE g.alertDefault = :alertDefault")
    , @NamedQuery(name = "GlobProjectAlertType.findByAlertValueType", query = "SELECT g FROM GlobProjectAlertType g WHERE g.alertValueType = :alertValueType")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_ALERT_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectAlertType.findAll", query = "SELECT g FROM GlobProjectAlertType g")
    , @NamedQuery(name = "GlobProjectAlertType.findById", query = "SELECT g FROM GlobProjectAlertType g WHERE g.id = :id")})
public class GlobProjectAlertType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "ALERT_TYPE")
    private String alertType;
    @Size(max = 50)
    @Column(name = "ALERT_CAPTION")
    private String alertCaption;
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
    @Column(name = "ALERT_DEFAULT")
    private BigInteger alertDefault;
    @Size(max = 50)
    @Column(name = "ALERT_VALUE_TYPE")
    private String alertValueType;

    public GlobProjectAlertType() {
    }

    public GlobProjectAlertType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertCaption() {
        return alertCaption;
    }

    public void setAlertCaption(String alertCaption) {
        this.alertCaption = alertCaption;
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

    public BigInteger getAlertDefault() {
        return alertDefault;
    }

    public void setAlertDefault(BigInteger alertDefault) {
        this.alertDefault = alertDefault;
    }

    public String getAlertValueType() {
        return alertValueType;
    }

    public void setAlertValueType(String alertValueType) {
        this.alertValueType = alertValueType;
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
        if (!(object instanceof GlobProjectAlertType)) {
            return false;
        }
        GlobProjectAlertType other = (GlobProjectAlertType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectAlertType[ id=" + id + " ]";
    }
    
}
