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
@NamedQuery(name = "GlobProjectSpecsConcslump.findByProjectId", query = "SELECT g FROM GlobProjectSpecsConcslump g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobProjectSpecsConcslump.findBySlump", query = "SELECT g FROM GlobProjectSpecsConcslump g WHERE g.slump = :slump"),
    @NamedQuery(name = "GlobProjectSpecsConcslump.findByListOrder", query = "SELECT g FROM GlobProjectSpecsConcslump g WHERE g.listOrder = :listOrder"),
    @NamedQuery(name = "GlobProjectSpecsConcslump.findByCategory", query = "SELECT g FROM GlobProjectSpecsConcslump g WHERE g.category = :category")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_SPECS_CONCSLUMP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectSpecsConcslump.findAll", query = "SELECT g FROM GlobProjectSpecsConcslump g"),
    @NamedQuery(name = "GlobProjectSpecsConcslump.findById", query = "SELECT g FROM GlobProjectSpecsConcslump g WHERE g.id = :id")})
public class GlobProjectSpecsConcslump implements Serializable {

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
    @Column(name = "SLUMP")
    private String slump;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;

    public GlobProjectSpecsConcslump() {
    }

    public GlobProjectSpecsConcslump(BigDecimal id) {
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

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        if (!(object instanceof GlobProjectSpecsConcslump)) {
            return false;
        }
        GlobProjectSpecsConcslump other = (GlobProjectSpecsConcslump) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectSpecsConcslump[ id=" + id + " ]";
    }
    
}
