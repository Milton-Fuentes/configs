/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QAASPM_MIXDESIGN_MASTERPROJECT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignMasterproject.findAll", query = "SELECT q FROM QaaspmMixdesignMasterproject q"),
    @NamedQuery(name = "QaaspmMixdesignMasterproject.findById", query = "SELECT q FROM QaaspmMixdesignMasterproject q WHERE q.id = :id"),
    @NamedQuery(name = "QaaspmMixdesignMasterproject.findByProjectId", query = "SELECT q FROM QaaspmMixdesignMasterproject q WHERE q.projectId = :projectId")})
public class QaaspmMixdesignMasterproject implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QAASPM_MIXDESIGN_MASTERPROJEC", sequenceName = "QAASPM_MIXDESIGN_MASTERPROJEC", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QAASPM_MIXDESIGN_MASTERPROJEC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @JsonBackReference
    @JoinColumn(name = "MIXDESIGN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaaspmMixdesignMaster mixDesignId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    public QaaspmMixdesignMasterproject() {
    }

    public QaaspmMixdesignMasterproject(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignMasterproject(BigDecimal id, QaaspmMixdesignMaster mixdesignId, BigInteger projectId) {
        this.id = id;
        this.mixDesignId = mixdesignId;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignMaster getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(QaaspmMixdesignMaster mixdesignId) {
        this.mixDesignId = mixdesignId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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
        if (!(object instanceof QaaspmMixdesignMasterproject)) {
            return false;
        }
        QaaspmMixdesignMasterproject other = (QaaspmMixdesignMasterproject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignMasterproject[ id=" + id + " ]";
    }
    
}
