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
@NamedQuery(name = "GlobIaSpec.findByClientId", query = "SELECT g FROM GlobIaSpec g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobIaSpec.findBySpecNo", query = "SELECT g FROM GlobIaSpec g WHERE g.specNo = :specNo"),
    @NamedQuery(name = "GlobIaSpec.findBySpecName", query = "SELECT g FROM GlobIaSpec g WHERE g.specName = :specName"),
    @NamedQuery(name = "GlobIaSpec.findBySpecType", query = "SELECT g FROM GlobIaSpec g WHERE g.specType = :specType"),
    @NamedQuery(name = "GlobIaSpec.findBySpecDate", query = "SELECT g FROM GlobIaSpec g WHERE g.specDate = :specDate"),
    @NamedQuery(name = "GlobIaSpec.findByCopyfromId", query = "SELECT g FROM GlobIaSpec g WHERE g.copyfromId = :copyfromId"),
    @NamedQuery(name = "GlobIaSpec.findByCreateBy", query = "SELECT g FROM GlobIaSpec g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobIaSpec.findByCreateByIp", query = "SELECT g FROM GlobIaSpec g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobIaSpec.findByLastModBy", query = "SELECT g FROM GlobIaSpec g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobIaSpec.findByLastMod", query = "SELECT g FROM GlobIaSpec g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobIaSpec.findByLastModIp", query = "SELECT g FROM GlobIaSpec g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobIaSpec.findByVersion", query = "SELECT g FROM GlobIaSpec g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_IA_SPEC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobIaSpec.findAll", query = "SELECT g FROM GlobIaSpec g"),
    @NamedQuery(name = "GlobIaSpec.findById", query = "SELECT g FROM GlobIaSpec g WHERE g.id = :id")})
public class GlobIaSpec implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SPEC_NO")
    private String specNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SPEC_NAME")
    private String specName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SPEC_TYPE")
    private String specType;
    @Column(name = "SPEC_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date specDate;
    @Column(name = "COPYFROM_ID")
    private BigInteger copyfromId;
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

    public GlobIaSpec() {
    }

    public GlobIaSpec(BigDecimal id) {
        this.id = id;
    }

    public GlobIaSpec(BigDecimal id, BigInteger clientId, String specNo, String specName, String specType) {
        this.id = id;
        this.clientId = clientId;
        this.specNo = specNo;
        this.specName = specName;
        this.specType = specType;
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

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType;
    }

    public Date getSpecDate() {
        return specDate;
    }

    public void setSpecDate(Date specDate) {
        this.specDate = specDate;
    }

    public BigInteger getCopyfromId() {
        return copyfromId;
    }

    public void setCopyfromId(BigInteger copyfromId) {
        this.copyfromId = copyfromId;
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
        if (!(object instanceof GlobIaSpec)) {
            return false;
        }
        GlobIaSpec other = (GlobIaSpec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobIaSpec[ id=" + id + " ]";
    }

}
