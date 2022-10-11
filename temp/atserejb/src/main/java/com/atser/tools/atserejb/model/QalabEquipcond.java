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
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;


/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_EQUIPCOND", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquipcond.findAll", query = "SELECT q FROM QalabEquipcond q")
    , @NamedQuery(name = "QalabEquipcond.findById", query = "SELECT q FROM QalabEquipcond q WHERE q.id = :id")
    , @NamedQuery(name = "QalabEquipcond.findByCondition", query = "SELECT q FROM QalabEquipcond q WHERE q.condition = :condition")})
public class QalabEquipcond implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CONDITION")
    private String condition;
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

    public QalabEquipcond() {
    }

    public QalabEquipcond(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QalabEquipcond)) {
            return false;
        }
        QalabEquipcond other = (QalabEquipcond) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabEquipcond[ id=" + id + " ]";
    }
    
}
