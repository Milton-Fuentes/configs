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

/*
@NamedQuery(name = "CmFormSpecs.findByProjectId", query = "SELECT c FROM CmFormSpecs c WHERE c.projectId = :projectId"),
    @NamedQuery(name = "CmFormSpecs.findBySpecNo", query = "SELECT c FROM CmFormSpecs c WHERE c.specNo = :specNo"),
    @NamedQuery(name = "CmFormSpecs.findBySpecName", query = "SELECT c FROM CmFormSpecs c WHERE c.specName = :specName")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_SPECS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormSpecs.findAll", query = "SELECT c FROM CmFormSpecs c"),
    @NamedQuery(name = "CmFormSpecs.findById", query = "SELECT c FROM CmFormSpecs c WHERE c.id = :id")})
public class CmFormSpecs implements Serializable {

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
    @Column(name = "SPEC_NO")
    private String specNo;
    @Size(max = 255)
    @Column(name = "SPEC_NAME")
    private String specName;

    public CmFormSpecs() {
    }

    public CmFormSpecs(BigDecimal id) {
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

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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
        if (!(object instanceof CmFormSpecs)) {
            return false;
        }
        CmFormSpecs other = (CmFormSpecs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormSpecs[ id=" + id + " ]";
    }
    
}
