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
@Table(name = "GLOB_PROJECT_FREQ_RATIO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectFreqRatio.findAll", query = "SELECT g FROM GlobProjectFreqRatio g")
    , @NamedQuery(name = "GlobProjectFreqRatio.findById", query = "SELECT g FROM GlobProjectFreqRatio g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectFreqRatio.findByProjectId", query = "SELECT g FROM GlobProjectFreqRatio g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectFreqRatio.findByRatioName", query = "SELECT g FROM GlobProjectFreqRatio g WHERE g.ratioName = :ratioName")
    , @NamedQuery(name = "GlobProjectFreqRatio.findByRatioEquation", query = "SELECT g FROM GlobProjectFreqRatio g WHERE g.ratioEquation = :ratioEquation")
    , @NamedQuery(name = "GlobProjectFreqRatio.findByRatioOrder", query = "SELECT g FROM GlobProjectFreqRatio g WHERE g.ratioOrder = :ratioOrder")})
public class GlobProjectFreqRatio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "RATIO_NAME")
    private String ratioName;
    @Size(max = 255)
    @Column(name = "RATIO_EQUATION")
    private String ratioEquation;
    @Column(name = "RATIO_ORDER")
    private BigInteger ratioOrder;

    public GlobProjectFreqRatio() {
    }

    public GlobProjectFreqRatio(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
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

    public String getRatioName() {
        return ratioName;
    }

    public void setRatioName(String ratioName) {
        this.ratioName = ratioName;
    }

    public String getRatioEquation() {
        return ratioEquation;
    }

    public void setRatioEquation(String ratioEquation) {
        this.ratioEquation = ratioEquation;
    }

    public BigInteger getRatioOrder() {
        return ratioOrder;
    }

    public void setRatioOrder(BigInteger ratioOrder) {
        this.ratioOrder = ratioOrder;
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
        if (!(object instanceof GlobProjectFreqRatio)) {
            return false;
        }
        GlobProjectFreqRatio other = (GlobProjectFreqRatio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectFreqRatio[ id=" + id + " ]";
    }
    
}
