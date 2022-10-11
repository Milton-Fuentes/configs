/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
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
, @NamedQuery(name = "GlobEmployee.findByEmployeeNo", query = "SELECT g FROM GlobEmployee g WHERE g.employeeNo = :employeeNo")
    , @NamedQuery(name = "GlobEmployee.findByRate", query = "SELECT g FROM GlobEmployee g WHERE g.rate = :rate")
    , @NamedQuery(name = "GlobEmployee.findByLastMod", query = "SELECT g FROM GlobEmployee g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobEmployee.findByLastModBy", query = "SELECT g FROM GlobEmployee g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobEmployee.findByLastModIp", query = "SELECT g FROM GlobEmployee g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobEmployee.findByCreateDate", query = "SELECT g FROM GlobEmployee g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobEmployee.findByCreateBy", query = "SELECT g FROM GlobEmployee g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobEmployee.findByCreateByIp", query = "SELECT g FROM GlobEmployee g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobEmployee.findByTemp", query = "SELECT g FROM GlobEmployee g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobEmployee.findByVersion", query = "SELECT g FROM GlobEmployee g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_EMPLOYEE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobEmployee.findAll", query = "SELECT g FROM GlobEmployee g")
    , @NamedQuery(name = "GlobEmployee.findById", query = "SELECT g FROM GlobEmployee g WHERE g.id = :id")})
public class GlobEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "EMPLOYEE_NO")
    private String employeeNo;
    @Column(name = "RATE")
    private Double rate;
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

    public GlobEmployee() {
    }

    public GlobEmployee(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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
        if (!(object instanceof GlobEmployee)) {
            return false;
        }
        GlobEmployee other = (GlobEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobEmployee[ id=" + id + " ]";
    }
    
}
