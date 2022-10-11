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
, @NamedQuery(name = "GlobWorkorderTime.findByWorkorderId", query = "SELECT g FROM GlobWorkorderTime g WHERE g.workorderId = :workorderId")
    , @NamedQuery(name = "GlobWorkorderTime.findByArrivelabin", query = "SELECT g FROM GlobWorkorderTime g WHERE g.arrivelabin = :arrivelabin")
    , @NamedQuery(name = "GlobWorkorderTime.findByDepartlabin", query = "SELECT g FROM GlobWorkorderTime g WHERE g.departlabin = :departlabin")
    , @NamedQuery(name = "GlobWorkorderTime.findByArrivesite", query = "SELECT g FROM GlobWorkorderTime g WHERE g.arrivesite = :arrivesite")
    , @NamedQuery(name = "GlobWorkorderTime.findByDepartsite", query = "SELECT g FROM GlobWorkorderTime g WHERE g.departsite = :departsite")
    , @NamedQuery(name = "GlobWorkorderTime.findByArrivelabout", query = "SELECT g FROM GlobWorkorderTime g WHERE g.arrivelabout = :arrivelabout")
    , @NamedQuery(name = "GlobWorkorderTime.findByDepartlabout", query = "SELECT g FROM GlobWorkorderTime g WHERE g.departlabout = :departlabout")
    , @NamedQuery(name = "GlobWorkorderTime.findByLunchstart", query = "SELECT g FROM GlobWorkorderTime g WHERE g.lunchstart = :lunchstart")
    , @NamedQuery(name = "GlobWorkorderTime.findByLunchstop", query = "SELECT g FROM GlobWorkorderTime g WHERE g.lunchstop = :lunchstop")
    , @NamedQuery(name = "GlobWorkorderTime.findByTotalhours", query = "SELECT g FROM GlobWorkorderTime g WHERE g.totalhours = :totalhours")
    , @NamedQuery(name = "GlobWorkorderTime.findByLastMod", query = "SELECT g FROM GlobWorkorderTime g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobWorkorderTime.findByLastModBy", query = "SELECT g FROM GlobWorkorderTime g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobWorkorderTime.findByLastModIp", query = "SELECT g FROM GlobWorkorderTime g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobWorkorderTime.findByCreateDate", query = "SELECT g FROM GlobWorkorderTime g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobWorkorderTime.findByCreateBy", query = "SELECT g FROM GlobWorkorderTime g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobWorkorderTime.findByCreateByIp", query = "SELECT g FROM GlobWorkorderTime g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobWorkorderTime.findByTemp", query = "SELECT g FROM GlobWorkorderTime g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobWorkorderTime.findByVersion", query = "SELECT g FROM GlobWorkorderTime g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_WORKORDER_TIME", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobWorkorderTime.findAll", query = "SELECT g FROM GlobWorkorderTime g")
    , @NamedQuery(name = "GlobWorkorderTime.findById", query = "SELECT g FROM GlobWorkorderTime g WHERE g.id = :id")})
public class GlobWorkorderTime implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORKORDER_ID")
    private BigInteger workorderId;
    @Size(max = 50)
    @Column(name = "ARRIVELABIN")
    private String arrivelabin;
    @Size(max = 50)
    @Column(name = "DEPARTLABIN")
    private String departlabin;
    @Size(max = 50)
    @Column(name = "ARRIVESITE")
    private String arrivesite;
    @Size(max = 50)
    @Column(name = "DEPARTSITE")
    private String departsite;
    @Size(max = 50)
    @Column(name = "ARRIVELABOUT")
    private String arrivelabout;
    @Size(max = 50)
    @Column(name = "DEPARTLABOUT")
    private String departlabout;
    @Size(max = 50)
    @Column(name = "LUNCHSTART")
    private String lunchstart;
    @Size(max = 50)
    @Column(name = "LUNCHSTOP")
    private String lunchstop;
    @Size(max = 50)
    @Column(name = "TOTALHOURS")
    private String totalhours;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public GlobWorkorderTime() {
    }

    public GlobWorkorderTime(BigDecimal id) {
        this.id = id;
    }

    public GlobWorkorderTime(BigDecimal id, BigInteger workorderId) {
        this.id = id;
        this.workorderId = workorderId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(BigInteger workorderId) {
        this.workorderId = workorderId;
    }

    public String getArrivelabin() {
        return arrivelabin;
    }

    public void setArrivelabin(String arrivelabin) {
        this.arrivelabin = arrivelabin;
    }

    public String getDepartlabin() {
        return departlabin;
    }

    public void setDepartlabin(String departlabin) {
        this.departlabin = departlabin;
    }

    public String getArrivesite() {
        return arrivesite;
    }

    public void setArrivesite(String arrivesite) {
        this.arrivesite = arrivesite;
    }

    public String getDepartsite() {
        return departsite;
    }

    public void setDepartsite(String departsite) {
        this.departsite = departsite;
    }

    public String getArrivelabout() {
        return arrivelabout;
    }

    public void setArrivelabout(String arrivelabout) {
        this.arrivelabout = arrivelabout;
    }

    public String getDepartlabout() {
        return departlabout;
    }

    public void setDepartlabout(String departlabout) {
        this.departlabout = departlabout;
    }

    public String getLunchstart() {
        return lunchstart;
    }

    public void setLunchstart(String lunchstart) {
        this.lunchstart = lunchstart;
    }

    public String getLunchstop() {
        return lunchstop;
    }

    public void setLunchstop(String lunchstop) {
        this.lunchstop = lunchstop;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
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
        if (!(object instanceof GlobWorkorderTime)) {
            return false;
        }
        GlobWorkorderTime other = (GlobWorkorderTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobWorkorderTime[ id=" + id + " ]";
    }
    
}
