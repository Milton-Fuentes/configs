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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobProfiles.findByProjectId", query = "SELECT g FROM GlobProfiles g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProfiles.findByReadonly", query = "SELECT g FROM GlobProfiles g WHERE g.readonly = :readonly")
    , @NamedQuery(name = "GlobProfiles.findByLabId", query = "SELECT g FROM GlobProfiles g WHERE g.labId = :labId")
    , @NamedQuery(name = "GlobProfiles.findByContractorContractId", query = "SELECT g FROM GlobProfiles g WHERE g.contractorContractId = :contractorContractId")
    , @NamedQuery(name = "GlobProfiles.findByContractId", query = "SELECT g FROM GlobProfiles g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobProfiles.findByContractorId", query = "SELECT g FROM GlobProfiles g WHERE g.contractorId = :contractorId")
    , @NamedQuery(name = "GlobProfiles.findByModuleId", query = "SELECT g FROM GlobProfiles g WHERE g.moduleId = :moduleId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROFILES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProfiles.findAll", query = "SELECT g FROM GlobProfiles g")
    , @NamedQuery(name = "GlobProfiles.findById", query = "SELECT g FROM GlobProfiles g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProfiles.findByUserId", query = "SELECT g FROM GlobProfiles g WHERE g.userId = :userId")})
public class GlobProfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PROFILES_ID_SEQ", sequenceName = "GLOB_PROFILES_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROFILES_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @JoinColumn(name = "DISCIPLINE_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobDisciplines disciplineId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobRoles roleId;
    @JoinColumn(name = "FUNCTION_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFunctions functionId;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "READONLY")
    private Character readonly;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "CONTRACTOR_CONTRACT_ID")
    private BigInteger contractorContractId;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "MODULE_ID")
    private BigInteger moduleId;
    @Column(name = "ISPREFERRED", insertable = false)
    private String isPreferred;
    
    public GlobProfiles() {
    }

    public GlobProfiles(BigDecimal id) {
        this.id = id;
    }

    public GlobProfiles(BigDecimal id, Character readonly) {
        this.id = id;
        this.readonly = readonly;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public Character getReadonly() {
        return readonly;
    }

    public void setReadonly(Character readonly) {
        this.readonly = readonly;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getContractorContractId() {
        return contractorContractId;
    }

    public void setContractorContractId(BigInteger contractorContractId) {
        this.contractorContractId = contractorContractId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public BigInteger getContractorId() {
        return contractorId;
    }

    public void setContractorId(BigInteger contractorId) {
        this.contractorId = contractorId;
    }

    public BigInteger getModuleId() {
        return moduleId;
    }

    public void setModuleId(BigInteger moduleId) {
        this.moduleId = moduleId;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    public GlobDisciplines getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(GlobDisciplines disciplineId) {
        this.disciplineId = disciplineId;
    }

    public GlobFunctions getFunctionId() {
        return functionId;
    }

    public void setFunctionId(GlobFunctions functionId) {
        this.functionId = functionId;
    }

    public GlobRoles getRoleId() {
        return roleId;
    }

    public void setRoleId(GlobRoles roleId) {
        this.roleId = roleId;
    }

    public String getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(String isPreferred) {
        this.isPreferred = isPreferred;
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
        if (!(object instanceof GlobProfiles)) {
            return false;
        }
        GlobProfiles other = (GlobProfiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProfiles[ id=" + id + " ]";
    }
    
}
