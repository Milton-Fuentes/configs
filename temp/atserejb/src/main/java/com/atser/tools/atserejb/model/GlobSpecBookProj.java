/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
@NamedQuery(name = "GlobSpecBookProj.findByProjectId", query = "SELECT g FROM GlobSpecBookProj g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobSpecBookProj.findByField1", query = "SELECT g FROM GlobSpecBookProj g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobSpecBookProj.findByField2", query = "SELECT g FROM GlobSpecBookProj g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobSpecBookProj.findByField3", query = "SELECT g FROM GlobSpecBookProj g WHERE g.field3 = :field3"),
    @NamedQuery(name = "GlobSpecBookProj.findByField4", query = "SELECT g FROM GlobSpecBookProj g WHERE g.field4 = :field4"),
    @NamedQuery(name = "GlobSpecBookProj.findBySpecBookId", query = "SELECT g FROM GlobSpecBookProj g WHERE g.specBookId = :specBookId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_BOOK_PROJ", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookProj.findAll", query = "SELECT g FROM GlobSpecBookProj g"),
    @NamedQuery(name = "GlobSpecBookProj.findById", query = "SELECT g FROM GlobSpecBookProj g WHERE g.id = :id")})
public class GlobSpecBookProj implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    //GLOB_SPEC_BOOK_PROJ_id_seq
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "GLOB_SPEC_BOOK_PROJ_id_seq", sequenceName = "GLOB_SPEC_BOOK_PROJ_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SPEC_BOOK_PROJ_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Column(name = "FIELD3")
    private BigInteger field3;
    @Column(name = "FIELD4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field4;
    @Column(name = "SPEC_BOOK_ID")
    private BigInteger specBookId;

    public GlobSpecBookProj() {
    }

    public GlobSpecBookProj(BigDecimal id) {
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

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public BigInteger getField3() {
        return field3;
    }

    public void setField3(BigInteger field3) {
        this.field3 = field3;
    }

    public Date getField4() {
        return field4;
    }

    public void setField4(Date field4) {
        this.field4 = field4;
    }

    public BigInteger getSpecBookId() {
        return specBookId;
    }

    public void setSpecBookId(BigInteger specBookId) {
        this.specBookId = specBookId;
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
        if (!(object instanceof GlobSpecBookProj)) {
            return false;
        }
        GlobSpecBookProj other = (GlobSpecBookProj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookProj[ id=" + id + " ]";
    }
    
}
