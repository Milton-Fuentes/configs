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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobDispatchcallServices.findByServiceId", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.serviceId = :serviceId")
    , @NamedQuery(name = "GlobDispatchcallServices.findByService", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.service = :service")
    , @NamedQuery(name = "GlobDispatchcallServices.findByServiceDesc", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.serviceDesc = :serviceDesc")
    , @NamedQuery(name = "GlobDispatchcallServices.findByType", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.type = :type")
    , @NamedQuery(name = "GlobDispatchcallServices.findByLastModBy", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobDispatchcallServices.findByLastModIp", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobDispatchcallServices.findByLastModTmp", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobDispatchcallServices.findByLastMod", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobDispatchcallServices.findByAssetId", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.assetId = :assetId")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_DISPATCHCALL_SERVICES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobDispatchcallServices.findAll", query = "SELECT g FROM GlobDispatchcallServices g"),
    @NamedQuery(name = "GlobDispatchcallServices.findById", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.id = :id"),
    @NamedQuery(name = "GlobDispatchcallServices.findByCallLogId", query = "SELECT g FROM GlobDispatchcallServices g WHERE g.callLogId = :callLogId")})
public class GlobDispatchcallServices implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_DISPATCHCALL_SERV_ID_SEQ", sequenceName = "GLOB_DISPATCHCALL_SERV_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_DISPATCHCALL_SERV_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CALL_LOG_ID")
    private BigInteger callLogId;
    @Column(name = "SERVICE_ID")
    private BigInteger serviceId;
    @Size(max = 10)
    @Column(name = "SERVICE")
    private String service;
    @Size(max = 4000)
    @Column(name = "SERVICE_DESC")
    private String serviceDesc;
    @Size(max = 4000)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "ASSET_ID")
    private BigInteger assetId;

    public GlobDispatchcallServices() {
    }

    public GlobDispatchcallServices(BigInteger callLogId, BigInteger serviceId, String service, String serviceDesc, String type, String lastModBy, String lastModIp, String lastMod) {
        this.callLogId = callLogId;
        this.serviceId = serviceId;
        this.service = service;
        this.serviceDesc = serviceDesc;
        this.type = type;
        this.lastModBy = lastModBy;
        this.lastModIp = lastModIp;
        this.lastMod = lastMod;
    }

    public GlobDispatchcallServices(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(BigInteger callLogId) {
        this.callLogId = callLogId;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public BigInteger getAssetId() {
        return assetId;
    }

    public void setAssetId(BigInteger assetId) {
        this.assetId = assetId;
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
        if (!(object instanceof GlobDispatchcallServices)) {
            return false;
        }
        GlobDispatchcallServices other = (GlobDispatchcallServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobDispatchcallServices[ id=" + id + " ]";
    }

}
