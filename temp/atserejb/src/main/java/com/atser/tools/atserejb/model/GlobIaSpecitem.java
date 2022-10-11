/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobIaSpecitem.findBySpecId", query = "SELECT g FROM GlobIaSpecitem g WHERE g.specId = :specId"),
    @NamedQuery(name = "GlobIaSpecitem.findByIaTypeId", query = "SELECT g FROM GlobIaSpecitem g WHERE g.iaTypeId = :iaTypeId"),
    @NamedQuery(name = "GlobIaSpecitem.findByDescription", query = "SELECT g FROM GlobIaSpecitem g WHERE g.description = :description"),
    @NamedQuery(name = "GlobIaSpecitem.findByAccMinAmount", query = "SELECT g FROM GlobIaSpecitem g WHERE g.accMinAmount = :accMinAmount"),
    @NamedQuery(name = "GlobIaSpecitem.findByAccFreqInterval", query = "SELECT g FROM GlobIaSpecitem g WHERE g.accFreqInterval = :accFreqInterval"),
    @NamedQuery(name = "GlobIaSpecitem.findByQcMinAmount", query = "SELECT g FROM GlobIaSpecitem g WHERE g.qcMinAmount = :qcMinAmount"),
    @NamedQuery(name = "GlobIaSpecitem.findByQcFreqInterval", query = "SELECT g FROM GlobIaSpecitem g WHERE g.qcFreqInterval = :qcFreqInterval"),
    @NamedQuery(name = "GlobIaSpecitem.findByWAccMinAmount", query = "SELECT g FROM GlobIaSpecitem g WHERE g.wAccMinAmount = :wAccMinAmount"),
    @NamedQuery(name = "GlobIaSpecitem.findByWAccFreqInterval", query = "SELECT g FROM GlobIaSpecitem g WHERE g.wAccFreqInterval = :wAccFreqInterval"),
    @NamedQuery(name = "GlobIaSpecitem.findByWQcMinAmount", query = "SELECT g FROM GlobIaSpecitem g WHERE g.wQcMinAmount = :wQcMinAmount"),
    @NamedQuery(name = "GlobIaSpecitem.findByWQcFreqInterval", query = "SELECT g FROM GlobIaSpecitem g WHERE g.wQcFreqInterval = :wQcFreqInterval"),
    @NamedQuery(name = "GlobIaSpecitem.findByListOrder", query = "SELECT g FROM GlobIaSpecitem g WHERE g.listOrder = :listOrder"),
    @NamedQuery(name = "GlobIaSpecitem.findByCreateBy", query = "SELECT g FROM GlobIaSpecitem g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobIaSpecitem.findByCreateByIp", query = "SELECT g FROM GlobIaSpecitem g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobIaSpecitem.findByLastModBy", query = "SELECT g FROM GlobIaSpecitem g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobIaSpecitem.findByLastMod", query = "SELECT g FROM GlobIaSpecitem g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobIaSpecitem.findByLastModIp", query = "SELECT g FROM GlobIaSpecitem g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobIaSpecitem.findByVersion", query = "SELECT g FROM GlobIaSpecitem g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_IA_SPECITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobIaSpecitem.findAll", query = "SELECT g FROM GlobIaSpecitem g"),
    @NamedQuery(name = "GlobIaSpecitem.findById", query = "SELECT g FROM GlobIaSpecitem g WHERE g.id = :id")})
public class GlobIaSpecitem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPEC_ID", nullable = false)
    private BigInteger specId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IA_TYPE_ID", nullable = false)
    private BigInteger iaTypeId;
    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    @Column(name = "ACC_MIN_AMOUNT", precision = 126)
    private Double accMinAmount;
    @Column(name = "ACC_FREQ_INTERVAL", precision = 126)
    private Double accFreqInterval;
    @Column(name = "QC_MIN_AMOUNT", precision = 126)
    private Double qcMinAmount;
    @Column(name = "QC_FREQ_INTERVAL", precision = 126)
    private Double qcFreqInterval;
    @Column(name = "W_ACC_MIN_AMOUNT", precision = 126)
    private Double wAccMinAmount;
    @Column(name = "W_ACC_FREQ_INTERVAL", precision = 126)
    private Double wAccFreqInterval;
    @Column(name = "W_QC_MIN_AMOUNT", precision = 126)
    private Double wQcMinAmount;
    @Column(name = "W_QC_FREQ_INTERVAL", precision = 126)
    private Double wQcFreqInterval;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD", length = 20)
    private String lastMod;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;

    public GlobIaSpecitem() {
    }

    public GlobIaSpecitem(BigDecimal id) {
        this.id = id;
    }

    public GlobIaSpecitem(BigDecimal id, BigInteger specId, BigInteger iaTypeId) {
        this.id = id;
        this.specId = specId;
        this.iaTypeId = iaTypeId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecId() {
        return specId;
    }

    public void setSpecId(BigInteger specId) {
        this.specId = specId;
    }

    public BigInteger getIaTypeId() {
        return iaTypeId;
    }

    public void setIaTypeId(BigInteger iaTypeId) {
        this.iaTypeId = iaTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAccMinAmount() {
        return accMinAmount;
    }

    public void setAccMinAmount(Double accMinAmount) {
        this.accMinAmount = accMinAmount;
    }

    public Double getAccFreqInterval() {
        return accFreqInterval;
    }

    public void setAccFreqInterval(Double accFreqInterval) {
        this.accFreqInterval = accFreqInterval;
    }

    public Double getQcMinAmount() {
        return qcMinAmount;
    }

    public void setQcMinAmount(Double qcMinAmount) {
        this.qcMinAmount = qcMinAmount;
    }

    public Double getQcFreqInterval() {
        return qcFreqInterval;
    }

    public void setQcFreqInterval(Double qcFreqInterval) {
        this.qcFreqInterval = qcFreqInterval;
    }

    public Double getWAccMinAmount() {
        return wAccMinAmount;
    }

    public void setWAccMinAmount(Double wAccMinAmount) {
        this.wAccMinAmount = wAccMinAmount;
    }

    public Double getWAccFreqInterval() {
        return wAccFreqInterval;
    }

    public void setWAccFreqInterval(Double wAccFreqInterval) {
        this.wAccFreqInterval = wAccFreqInterval;
    }

    public Double getWQcMinAmount() {
        return wQcMinAmount;
    }

    public void setWQcMinAmount(Double wQcMinAmount) {
        this.wQcMinAmount = wQcMinAmount;
    }

    public Double getWQcFreqInterval() {
        return wQcFreqInterval;
    }

    public void setWQcFreqInterval(Double wQcFreqInterval) {
        this.wQcFreqInterval = wQcFreqInterval;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
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
        if (!(object instanceof GlobIaSpecitem)) {
            return false;
        }
        GlobIaSpecitem other = (GlobIaSpecitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobIaSpecitem[ id=" + id + " ]";
    }
    
}
