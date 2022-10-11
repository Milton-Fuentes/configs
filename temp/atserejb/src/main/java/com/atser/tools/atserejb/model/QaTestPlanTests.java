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

/*
    @NamedQuery(name = "QaTestPlanTests.findByItemTestId", query = "SELECT q FROM QaTestPlanTests q WHERE q.itemTestId = :itemTestId"),
    @NamedQuery(name = "QaTestPlanTests.findByTestMethodId", query = "SELECT q FROM QaTestPlanTests q WHERE q.testMethodId = :testMethodId"),
    @NamedQuery(name = "QaTestPlanTests.findByRmsNo", query = "SELECT q FROM QaTestPlanTests q WHERE q.rmsNo = :rmsNo"),
    @NamedQuery(name = "QaTestPlanTests.findByRmsCol", query = "SELECT q FROM QaTestPlanTests q WHERE q.rmsCol = :rmsCol"),
    @NamedQuery(name = "QaTestPlanTests.findByRemarks", query = "SELECT q FROM QaTestPlanTests q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaTestPlanTests.findByField1", query = "SELECT q FROM QaTestPlanTests q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaTestPlanTests.findByField2", query = "SELECT q FROM QaTestPlanTests q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaTestPlanTests.findByField3", query = "SELECT q FROM QaTestPlanTests q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaTestPlanTests.findByField4", query = "SELECT q FROM QaTestPlanTests q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaTestPlanTests.findByField5", query = "SELECT q FROM QaTestPlanTests q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaTestPlanTests.findByField6", query = "SELECT q FROM QaTestPlanTests q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaTestPlanTests.findByCreateBy", query = "SELECT q FROM QaTestPlanTests q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaTestPlanTests.findByCreateByIp", query = "SELECT q FROM QaTestPlanTests q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaTestPlanTests.findByLastModBy", query = "SELECT q FROM QaTestPlanTests q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaTestPlanTests.findByLastMod", query = "SELECT q FROM QaTestPlanTests q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaTestPlanTests.findByLastModIp", query = "SELECT q FROM QaTestPlanTests q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaTestPlanTests.findByVersion", query = "SELECT q FROM QaTestPlanTests q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TEST_PLAN_TESTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTestPlanTests.findAll", query = "SELECT q FROM QaTestPlanTests q"),
    @NamedQuery(name = "QaTestPlanTests.findById", query = "SELECT q FROM QaTestPlanTests q WHERE q.id = :id")})
public class QaTestPlanTests implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_test_plan_tests_id_seq", sequenceName = "qa_test_plan_tests_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_test_plan_tests_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_TEST_ID")
    private BigInteger itemTestId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEST_METHOD_ID")
    private BigInteger testMethodId;
    @Size(max = 200)
    @Column(name = "RMS_NO")
    private String rmsNo;
    @Size(max = 200)
    @Column(name = "RMS_COL")
    private String rmsCol;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public QaTestPlanTests() {
    }

    public QaTestPlanTests(BigDecimal id) {
        this.id = id;
    }

    public QaTestPlanTests(BigDecimal id, BigInteger itemTestId, BigInteger testMethodId) {
        this.id = id;
        this.itemTestId = itemTestId;
        this.testMethodId = testMethodId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getItemTestId() {
        return itemTestId;
    }

    public void setItemTestId(BigInteger itemTestId) {
        this.itemTestId = itemTestId;
    }

    public BigInteger getTestMethodId() {
        return testMethodId;
    }

    public void setTestMethodId(BigInteger testMethodId) {
        this.testMethodId = testMethodId;
    }

    public String getRmsNo() {
        return rmsNo;
    }

    public void setRmsNo(String rmsNo) {
        this.rmsNo = rmsNo;
    }

    public String getRmsCol() {
        return rmsCol;
    }

    public void setRmsCol(String rmsCol) {
        this.rmsCol = rmsCol;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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
        if (!(object instanceof QaTestPlanTests)) {
            return false;
        }
        QaTestPlanTests other = (QaTestPlanTests) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTestPlanTests[ id=" + id + " ]";
    }
    
}
