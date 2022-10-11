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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobLogos.findByClientId", query = "SELECT g FROM GlobLogos g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobLogos.findByProjectId", query = "SELECT g FROM GlobLogos g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobLogos.findByContractId", query = "SELECT g FROM GlobLogos g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobLogos.findByContractorId", query = "SELECT g FROM GlobLogos g WHERE g.contractorId = :contractorId")
    , @NamedQuery(name = "GlobLogos.findByLabId", query = "SELECT g FROM GlobLogos g WHERE g.labId = :labId")
    , @NamedQuery(name = "GlobLogos.findByFunctionId", query = "SELECT g FROM GlobLogos g WHERE g.functionId = :functionId")
    , @NamedQuery(name = "GlobLogos.findByDisciplineId", query = "SELECT g FROM GlobLogos g WHERE g.disciplineId = :disciplineId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_LOGOS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobLogos.findAll", query = "SELECT g FROM GlobLogos g")
    , @NamedQuery(name = "GlobLogos.findById", query = "SELECT g FROM GlobLogos g WHERE g.id = :id")})
public class GlobLogos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "DISCIPLINE_ID")
    private BigInteger disciplineId;
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;

    public GlobLogos() {
    }

    public GlobLogos(BigDecimal id) {
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public BigInteger getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(BigInteger disciplineId) {
        this.disciplineId = disciplineId;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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
        if (!(object instanceof GlobLogos)) {
            return false;
        }
        GlobLogos other = (GlobLogos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobLogos[ id=" + id + " ]";
    }

}
