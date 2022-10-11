/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTRACTOR_CONTRACT", catalog = "", schema = "ORACLE")
@Where(clause = "lab_id IS NOT NULL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContractorContract.findAll", query = "SELECT g FROM GlobContractorContract g")
    , @NamedQuery(name = "GlobContractorContract.findById", query = "SELECT g FROM GlobContractorContract g WHERE g.id = :id")
    , @NamedQuery(name = "GlobContractorContract.findByContractId", query = "SELECT g FROM GlobContractorContract g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobContractorContract.findByContractorType", query = "SELECT g FROM GlobContractorContract g WHERE g.contractorType = :contractorType")
    , @NamedQuery(name = "GlobContractorContract.findByProjectId", query = "SELECT g FROM GlobContractorContract g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobContractorContract.findByLabId", query = "SELECT g FROM GlobContractorContract g WHERE g.labId.id = :labId")
    , @NamedQuery(name = "GlobContractorContract.findByFunctionId", query = "SELECT g FROM GlobContractorContract g WHERE g.functionId = :functionId")
    , @NamedQuery(name = "GlobContractorContract.findByDisciplineId", query = "SELECT g FROM GlobContractorContract g WHERE g.disciplineId = :disciplineId")})
@NamedEntityGraphs({
    @NamedEntityGraph(name = "projectId", attributeNodes = { @NamedAttributeNode("projectId") })
})
public class GlobContractorContract implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_contractor_contract_seq", sequenceName = "glob_contractor_contract_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_contractor_contract_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "CONTRACTOR_TYPE")
    private Character contractorType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private GlobProject projectId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LAB_ID", referencedColumnName = "ID")
    private GlobLabs labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "DISCIPLINE_ID")
    private BigInteger disciplineId;
    @JoinColumn(name = "CONTRACTOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobContractor contractorId;
    @OneToMany(mappedBy = "contractorContractId")
    private List<InReport> inReportList;

    public GlobContractorContract() {
    }

    public GlobContractorContract(BigDecimal id) {
        this.id = id;
    }

    public GlobContractorContract(GlobProject projectId, GlobLabs labId, BigInteger functionId) {
        this.projectId = projectId;
        this.labId = labId;
        this.functionId = functionId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public Character getContractorType() {
        return contractorType;
    }

    public void setContractorType(Character contractorType) {
        this.contractorType = contractorType;
    }

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
    }
    
    public GlobLabs getLabId() {
        return labId;
    }

    public void setLabId(GlobLabs labId) {
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

    public GlobContractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(GlobContractor contractorId) {
        this.contractorId = contractorId;
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
        if (!(object instanceof GlobContractorContract)) {
            return false;
        }
        GlobContractorContract other = (GlobContractorContract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContractorContract[ id=" + id + " ]";
    }

    @XmlTransient
    public List<InReport> getInReportList() {
        return inReportList;
    }

    public void setInReportList(List<InReport> inReportList) {
        this.inReportList = inReportList;
    }

}
