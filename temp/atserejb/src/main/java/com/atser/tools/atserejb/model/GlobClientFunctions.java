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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobClientFunctions.findByClientId", query = "SELECT g FROM GlobClientFunctions g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientFunctions.findByTypeProject", query = "SELECT g FROM GlobClientFunctions g WHERE g.typeProject = :typeProject"),
    @NamedQuery(name = "GlobClientFunctions.findByFunctionName", query = "SELECT g FROM GlobClientFunctions g WHERE g.functionName = :functionName"),
    @NamedQuery(name = "GlobClientFunctions.findByFunctionOrder", query = "SELECT g FROM GlobClientFunctions g WHERE g.functionOrder = :functionOrder"),
    @NamedQuery(name = "GlobClientFunctions.findByActive", query = "SELECT g FROM GlobClientFunctions g WHERE g.active = :active"),
    @NamedQuery(name = "GlobClientFunctions.findByLastMod", query = "SELECT g FROM GlobClientFunctions g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobClientFunctions.findByLastModBy", query = "SELECT g FROM GlobClientFunctions g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobClientFunctions.findByLastModIp", query = "SELECT g FROM GlobClientFunctions g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobClientFunctions.findByCreateDate", query = "SELECT g FROM GlobClientFunctions g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobClientFunctions.findByCreateBy", query = "SELECT g FROM GlobClientFunctions g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobClientFunctions.findByCreateByIp", query = "SELECT g FROM GlobClientFunctions g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobClientFunctions.findByVersion", query = "SELECT g FROM GlobClientFunctions g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_FUNCTIONS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientFunctions.findAll", query = "SELECT g FROM GlobClientFunctions g"),
    @NamedQuery(name = "GlobClientFunctions.findById", query = "SELECT g FROM GlobClientFunctions g WHERE g.id = :id")})
public class GlobClientFunctions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "TYPE_PROJECT")
    private String typeProject;
    @Size(max = 50)
    @Column(name = "FUNCTION_NAME")
    private String functionName;
    @Column(name = "FUNCTION_ORDER")
    private BigInteger functionOrder;
    @Column(name = "ACTIVE")
    private Character active;
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
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public GlobClientFunctions() {
    }

    public GlobClientFunctions(BigDecimal id) {
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

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public BigInteger getFunctionOrder() {
        return functionOrder;
    }

    public void setFunctionOrder(BigInteger functionOrder) {
        this.functionOrder = functionOrder;
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
        if (!(object instanceof GlobClientFunctions)) {
            return false;
        }
        GlobClientFunctions other = (GlobClientFunctions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientFunctions[ id=" + id + " ]";
    }
    
}
