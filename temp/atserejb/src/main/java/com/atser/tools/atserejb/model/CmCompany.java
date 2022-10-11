/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "CmCompany.findByCpName", query = "SELECT c FROM CmCompany c WHERE c.cpName = :cpName")
    , @NamedQuery(name = "CmCompany.findByField1", query = "SELECT c FROM CmCompany c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmCompany.findByField2", query = "SELECT c FROM CmCompany c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmCompany.findByField3", query = "SELECT c FROM CmCompany c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmCompany.findByField4", query = "SELECT c FROM CmCompany c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmCompany.findByField5", query = "SELECT c FROM CmCompany c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmCompany.findByField6", query = "SELECT c FROM CmCompany c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmCompany.findByField7", query = "SELECT c FROM CmCompany c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmCompany.findByField8", query = "SELECT c FROM CmCompany c WHERE c.field8 = :field8")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_COMPANY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmCompany.findAll", query = "SELECT c FROM CmCompany c")
    , @NamedQuery(name = "CmCompany.findById", query = "SELECT c FROM CmCompany c WHERE c.id = :id")})
public class CmCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CP_NAME")
    private String cpName;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 50)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 50)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private List<CmProject> cmProjectList;

    public CmCompany() {
    }

    public CmCompany(BigDecimal id) {
        this.id = id;
    }

    public CmCompany(BigDecimal id, String cpName) {
        this.id = id;
        this.cpName = cpName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
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

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
    }

    @XmlTransient
    public List<CmProject> getCmProjectList() {
        return cmProjectList;
    }

    public void setCmProjectList(List<CmProject> cmProjectList) {
        this.cmProjectList = cmProjectList;
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
        if (!(object instanceof CmCompany)) {
            return false;
        }
        CmCompany other = (CmCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmCompany[ id=" + id + " ]";
    }
    
}
