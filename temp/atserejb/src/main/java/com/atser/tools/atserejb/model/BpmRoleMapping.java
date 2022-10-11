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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPM_ROLE_MAPPING", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpmRoleMapping.findAll", query = "SELECT b FROM BpmRoleMapping b")
    , @NamedQuery(name = "BpmRoleMapping.findById", query = "SELECT b FROM BpmRoleMapping b WHERE b.id = :id")
    , @NamedQuery(name = "BpmRoleMapping.findByBpmRoleName", query = "SELECT b FROM BpmRoleMapping b WHERE b.bpmRoleName = :bpmRoleName")
    , @NamedQuery(name = "BpmRoleMapping.findByManageitRoleName", query = "SELECT b FROM BpmRoleMapping b WHERE b.manageitRoleName = :manageitRoleName")
    , @NamedQuery(name = "BpmRoleMapping.findByManageitRoleNameAndClient", query = "SELECT b FROM BpmRoleMapping b WHERE b.manageitRoleName = :manageitRoleName AND  b.clientId = :clientId")
    , @NamedQuery(name = "BpmRoleMapping.findByBpmGroupName", query = "SELECT b FROM BpmRoleMapping b WHERE b.bpmGroupName = :bpmGroupName")
    , @NamedQuery(name = "BpmRoleMapping.findByClientId", query = "SELECT b FROM BpmRoleMapping b WHERE b.clientId = :clientId")
    , @NamedQuery(name = "BpmRoleMapping.findByIsadmin", query = "SELECT b FROM BpmRoleMapping b WHERE b.isadmin = :isadmin")})
public class BpmRoleMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 150)
    @Column(name = "BPM_ROLE_NAME")
    private String bpmRoleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MANAGEIT_ROLE_NAME")
    private String manageitRoleName;
    @Size(max = 150)
    @Column(name = "BPM_GROUP_NAME")
    private String bpmGroupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISADMIN")
    private Character isadmin;

    public BpmRoleMapping() {
    }

    public BpmRoleMapping(BigDecimal id) {
        this.id = id;
    }

    public BpmRoleMapping(BigDecimal id, String manageitRoleName, BigInteger clientId, Character isadmin) {
        this.id = id;
        this.manageitRoleName = manageitRoleName;
        this.clientId = clientId;
        this.isadmin = isadmin;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getBpmRoleName() {
        return bpmRoleName;
    }

    public void setBpmRoleName(String bpmRoleName) {
        this.bpmRoleName = bpmRoleName;
    }

    public String getManageitRoleName() {
        return manageitRoleName;
    }

    public void setManageitRoleName(String manageitRoleName) {
        this.manageitRoleName = manageitRoleName;
    }

    public String getBpmGroupName() {
        return bpmGroupName;
    }

    public void setBpmGroupName(String bpmGroupName) {
        this.bpmGroupName = bpmGroupName;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Character getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Character isadmin) {
        this.isadmin = isadmin;
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
        if (!(object instanceof BpmRoleMapping)) {
            return false;
        }
        BpmRoleMapping other = (BpmRoleMapping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.BpmRoleMapping[ id=" + id + " ]";
    }
    
}
