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
@Table(name = "QACONC_MIXDESIGN_MASTERPROJECT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcMixdesignMasterproject.findAll", query = "SELECT q FROM QaconcMixdesignMasterproject q"),
    @NamedQuery(name = "QaconcMixdesignMasterproject.findById", query = "SELECT q FROM QaconcMixdesignMasterproject q WHERE q.id = :id"),
    @NamedQuery(name = "QaconcMixdesignMasterproject.findByProjectId", query = "SELECT q FROM QaconcMixdesignMasterproject q WHERE q.projectId = :projectId")})
public class QaconcMixdesignMasterproject implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_MIXDESIGN_MASTERPROJEC", sequenceName = "QACONC_MIXDESIGN_MASTERPROJEC", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_MIXDESIGN_MASTERPROJEC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @JsonBackReference
    @JoinColumn(name = "MIXDESIGN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaconcMixdesignMaster mixDesignId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    public QaconcMixdesignMasterproject() {
    }

    public QaconcMixdesignMasterproject(BigDecimal id) {
        this.id = id;
    }

    public QaconcMixdesignMasterproject(QaconcMixdesignMaster mixDesignId, BigInteger projectId) {
        this.mixDesignId = mixDesignId;
        this.projectId = projectId;
    }

    public QaconcMixdesignMasterproject(BigDecimal id, QaconcMixdesignMaster mixDesignId, BigInteger projectId) {
        this.id = id;
        this.mixDesignId = mixDesignId;
        this.projectId = projectId;
    }

    public QaconcMixdesignMasterproject(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public QaconcMixdesignMaster getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(QaconcMixdesignMaster mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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
        if (!(object instanceof QaconcMixdesignMasterproject)) {
            return false;
        }
        QaconcMixdesignMasterproject other = (QaconcMixdesignMasterproject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcMixdesignMasterproject[ id=" + id + " ]";
    }
    
}
