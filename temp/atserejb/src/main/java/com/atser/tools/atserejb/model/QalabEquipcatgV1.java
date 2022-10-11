/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_EQUIPCATG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquipcatgV1.findAll", query = "SELECT q FROM QalabEquipcatgV1 q")
    , @NamedQuery(name = "QalabEquipcatgV1.findById", query = "SELECT q FROM QalabEquipcatgV1 q WHERE q.id = :id")
    , @NamedQuery(name = "QalabEquipcatgV1.findByCategory", query = "SELECT q FROM QalabEquipcatgV1 q WHERE q.category = :category")})
public class QalabEquipcatgV1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD5")
    private BigInteger field5;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD6")
    private BigInteger field6;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @NotAudited
    @Size(max = 50)
    @Column(name = "SAMPLE_CATG_NAME")
    private String sampleCatgName;
    @NotAudited
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catgId", fetch = FetchType.LAZY)
    private List<QalabEquiptypeV1> qalabEquiptypeList;

    public QalabEquipcatgV1() {
    }

    public QalabEquipcatgV1(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public BigInteger getField5() {
        return field5;
    }

    public void setField5(BigInteger field5) {
        this.field5 = field5;
    }

    public BigInteger getField6() {
        return field6;
    }

    public void setField6(BigInteger field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getSampleCatgName() {
        return sampleCatgName;
    }

    public void setSampleCatgName(String sampleCatgName) {
        this.sampleCatgName = sampleCatgName;
    }

    @XmlTransient
    public List<QalabEquiptypeV1> getQalabEquiptypeList() {
        return qalabEquiptypeList;
    }

    public void setQalabEquiptypeList(List<QalabEquiptypeV1> qalabEquiptypeList) {
        this.qalabEquiptypeList = qalabEquiptypeList;
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
        if (!(object instanceof QalabEquipcatgV1)) {
            return false;
        }
        QalabEquipcatgV1 other = (QalabEquipcatgV1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabEquipcatgV1[ id=" + id + " ]";
    }
    
}
