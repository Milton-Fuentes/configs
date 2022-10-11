/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.objects.to.jasper.glob.GlobContractorTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJ_CONTR_PERSONNEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjContrPersonnel.findAll", query = "SELECT g FROM GlobProjContrPersonnel g"),
    @NamedQuery(name = "GlobProjContrPersonnel.findById", query = "SELECT g FROM GlobProjContrPersonnel g WHERE g.id = :id"),
    @NamedQuery(name = "GlobProjContrPersonnel.findByProjectId", query = "SELECT g FROM GlobProjContrPersonnel g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobProjContrPersonnel.findByContractorPersonnelId", query = "SELECT g FROM GlobProjContrPersonnel g WHERE g.contractorPersonnelId = :contractorPersonnelId")})
public class GlobProjContrPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PROJ_CONTR_PERSNNL_ID_SEQ", sequenceName = "GLOB_PROJ_CONTR_PERSNNL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJ_CONTR_PERSNNL_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projContrPersId")
    private List<QmProjContrPers> qmProjContrPersList;
    @JoinColumn(name = "CONTRACTOR_PERSONNEL_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobContractorPersonnel contractorPersonnelId;
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobProject projectId;
    @JoinColumn(name = "CONTRACTOR_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private QmCvlFieldData contractorTypeId;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;

    public GlobProjContrPersonnel() {
    }

    public GlobProjContrPersonnel(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @XmlTransient
    public List<QmProjContrPers> getQmProjContrPersList() {
        return qmProjContrPersList;
    }

    public void setQmProjContrPersList(List<QmProjContrPers> qmProjContrPersList) {
        this.qmProjContrPersList = qmProjContrPersList;
    }

    public GlobContractorPersonnel getContractorPersonnelId() {
        return contractorPersonnelId;
    }

    public void setContractorPersonnelId(GlobContractorPersonnel contractorPersonnelId) {
        this.contractorPersonnelId = contractorPersonnelId;
    }

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
    }

    public QmCvlFieldData getContractorTypeId() {
        return contractorTypeId;
    }

    public void setContractorTypeId(QmCvlFieldData contractorTypeId) {
        this.contractorTypeId = contractorTypeId;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
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
        if (!(object instanceof GlobProjContrPersonnel)) {
            return false;
        }
        GlobProjContrPersonnel other = (GlobProjContrPersonnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjContrPersonnel[ id=" + id + " ]";
    }

    public GlobContractorTO generateTo() {
        GlobContractorTO obj = new GlobContractorTO();
        obj.setId(this.getContractorPersonnelId().getId().toString());
        obj.setClientId(this.getContractorPersonnelId().getClientId().toString());
        obj.setContractor(this.getContractorPersonnelId().getContractor());
        obj.setFirstname(this.getContractorPersonnelId().getFirstname());
        obj.setLastname(this.getContractorPersonnelId().getLastname());
        obj.setTitle(this.getContractorPersonnelId().getTitle());
        obj.setAddress(this.getContractorPersonnelId().getAddress());
        obj.setCity(this.getContractorPersonnelId().getCity());
        obj.setState(this.getContractorPersonnelId().getState());
        obj.setZip(this.getContractorPersonnelId().getZip());
        obj.setPhone(this.getContractorPersonnelId().getPhone());
        obj.setCell(this.getContractorPersonnelId().getCell());
        obj.setFax(this.getContractorPersonnelId().getFax());
        obj.setEmail(this.getContractorPersonnelId().getEmail());
        obj.setActive(this.getContractorPersonnelId().getActive().toString());
        obj.setContractorCode(this.getContractorPersonnelId().getContractorCode());
        obj.setDataProvider(this.getContractorPersonnelId().getDataProvider());
        obj.setEnabled(this.getContractorPersonnelId().getEnabled());
        return obj;
    }

}
