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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByJmfId", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.jmfId = :jmfId"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findBySieveId", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.sieveId = :sieveId"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByOrdering", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.ordering = :ordering"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByJmfPercPassing", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.jmfPercPassing = :jmfPercPassing"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField1", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField2", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField3", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField4", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField5", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField6", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField7", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField8", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField9", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByField10", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByCreateDate", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByCreateBy", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByCreateByIp", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByLastMod", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByLastModBy", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByLastModIp", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findByVersion", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QAASPM_MIXDESIGNS_JMF_SIEVES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findAll", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q"),
    @NamedQuery(name = "QaaspmMixdesignsJmfSieves.findById", query = "SELECT q FROM QaaspmMixdesignsJmfSieves q WHERE q.id = :id")})
public class QaaspmMixdesignsJmfSieves implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qaaspm_mixdesig_jmf_sie_ID_SEQ", sequenceName = "qaaspm_mixdesig_jmf_sie_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qaaspm_mixdesig_jmf_sie_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "JMF_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaaspmMixdesignsJmf jmfId;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Column(name = "ORDERING")
    private BigInteger ordering;
    @Column(name = "JMF_PERC_PASSING")
    private Double jmfPercPassing;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 255)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 255)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 255)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 255)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "FIELD7")
    private BigInteger field7;
    @Column(name = "FIELD8")
    private BigInteger field8;
    @Size(max = 50)
    @Column(name = "FIELD9")
    private String field9;
    @Size(max = 50)
    @Column(name = "FIELD10")
    private String field10;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public QaaspmMixdesignsJmfSieves() {
    }

    public QaaspmMixdesignsJmfSieves(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignsJmf getJmfId() {
        return jmfId;
    }

    public void setJmfId(QaaspmMixdesignsJmf jmfId) {
        this.jmfId = jmfId;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
    }

    public Double getJmfPercPassing() {
        return jmfPercPassing;
    }

    public void setJmfPercPassing(Double jmfPercPassing) {
        this.jmfPercPassing = jmfPercPassing;
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

    public BigInteger getField7() {
        return field7;
    }

    public void setField7(BigInteger field7) {
        this.field7 = field7;
    }

    public BigInteger getField8() {
        return field8;
    }

    public void setField8(BigInteger field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof QaaspmMixdesignsJmfSieves)) {
            return false;
        }
        QaaspmMixdesignsJmfSieves other = (QaaspmMixdesignsJmfSieves) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignsJmfSieves[ id=" + id + " ]";
    }
    
}
