/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

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
@NamedQuery(name = "GlobClientSpecBook.findByClientId", query = "SELECT g FROM GlobClientSpecBook g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientSpecBook.findBySpecBookId", query = "SELECT g FROM GlobClientSpecBook g WHERE g.specBookId = :specBookId"),
    @NamedQuery(name = "GlobClientSpecBook.findByActive", query = "SELECT g FROM GlobClientSpecBook g WHERE g.active = :active"),
    @NamedQuery(name = "GlobClientSpecBook.findByLastMod", query = "SELECT g FROM GlobClientSpecBook g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobClientSpecBook.findByLastModBy", query = "SELECT g FROM GlobClientSpecBook g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobClientSpecBook.findByLastModIp", query = "SELECT g FROM GlobClientSpecBook g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobClientSpecBook.findByCreateDate", query = "SELECT g FROM GlobClientSpecBook g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobClientSpecBook.findByCreateBy", query = "SELECT g FROM GlobClientSpecBook g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobClientSpecBook.findByCreateByIp", query = "SELECT g FROM GlobClientSpecBook g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobClientSpecBook.findByTemp", query = "SELECT g FROM GlobClientSpecBook g WHERE g.temp = :temp"),
    @NamedQuery(name = "GlobClientSpecBook.findByVersion", query = "SELECT g FROM GlobClientSpecBook g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_SPEC_BOOK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientSpecBook.findAll", query = "SELECT g FROM GlobClientSpecBook g"),
    @NamedQuery(name = "GlobClientSpecBook.findById", query = "SELECT g FROM GlobClientSpecBook g WHERE g.id = :id")})
public class GlobClientSpecBook implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "SPEC_BOOK_ID")
    private BigInteger specBookId;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD", length = 50)
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE", length = 50)
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;

    public GlobClientSpecBook() {
    }

    public GlobClientSpecBook(BigDecimal id) {
        this.id = id;
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

    public BigInteger getSpecBookId() {
        return specBookId;
    }

    public void setSpecBookId(BigInteger specBookId) {
        this.specBookId = specBookId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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
        if (!(object instanceof GlobClientSpecBook)) {
            return false;
        }
        GlobClientSpecBook other = (GlobClientSpecBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientSpecBook[ id=" + id + " ]";
    }
    
}
