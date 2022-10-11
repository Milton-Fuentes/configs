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

/*
@NamedQuery(name = "QasoilDirectShear.findBySampletestId", query = "SELECT q FROM QasoilDirectShear q WHERE q.sampletestId = :sampletestId"),
    @NamedQuery(name = "QasoilDirectShear.findByTestReportNo", query = "SELECT q FROM QasoilDirectShear q WHERE q.testReportNo = :testReportNo"),
    @NamedQuery(name = "QasoilDirectShear.findByTestplanId", query = "SELECT q FROM QasoilDirectShear q WHERE q.testplanId = :testplanId"),
    @NamedQuery(name = "QasoilDirectShear.findByQuantity", query = "SELECT q FROM QasoilDirectShear q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QasoilDirectShear.findByWaterContentLl", query = "SELECT q FROM QasoilDirectShear q WHERE q.waterContentLl = :waterContentLl"),
    @NamedQuery(name = "QasoilDirectShear.findByWaterContentPl", query = "SELECT q FROM QasoilDirectShear q WHERE q.waterContentPl = :waterContentPl"),
    @NamedQuery(name = "QasoilDirectShear.findByWaterContentPi", query = "SELECT q FROM QasoilDirectShear q WHERE q.waterContentPi = :waterContentPi"),
    @NamedQuery(name = "QasoilDirectShear.findByFarSummary", query = "SELECT q FROM QasoilDirectShear q WHERE q.farSummary = :farSummary"),
    @NamedQuery(name = "QasoilDirectShear.findByRemarks", query = "SELECT q FROM QasoilDirectShear q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QasoilDirectShear.findByField1", query = "SELECT q FROM QasoilDirectShear q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QasoilDirectShear.findByField2", query = "SELECT q FROM QasoilDirectShear q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QasoilDirectShear.findByField3", query = "SELECT q FROM QasoilDirectShear q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QasoilDirectShear.findByField4", query = "SELECT q FROM QasoilDirectShear q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QasoilDirectShear.findByField5", query = "SELECT q FROM QasoilDirectShear q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QasoilDirectShear.findByField6", query = "SELECT q FROM QasoilDirectShear q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QasoilDirectShear.findByField7", query = "SELECT q FROM QasoilDirectShear q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QasoilDirectShear.findByField8", query = "SELECT q FROM QasoilDirectShear q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QasoilDirectShear.findByField9", query = "SELECT q FROM QasoilDirectShear q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QasoilDirectShear.findByField10", query = "SELECT q FROM QasoilDirectShear q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QasoilDirectShear.findByActive", query = "SELECT q FROM QasoilDirectShear q WHERE q.active = :active"),
    @NamedQuery(name = "QasoilDirectShear.findByLastModBy", query = "SELECT q FROM QasoilDirectShear q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QasoilDirectShear.findByLastModIp", query = "SELECT q FROM QasoilDirectShear q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QasoilDirectShear.findByLastMod", query = "SELECT q FROM QasoilDirectShear q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QasoilDirectShear.findByCreateBy", query = "SELECT q FROM QasoilDirectShear q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QasoilDirectShear.findByCreateByIp", query = "SELECT q FROM QasoilDirectShear q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QasoilDirectShear.findByCreateDate", query = "SELECT q FROM QasoilDirectShear q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QasoilDirectShear.findByVersion", query = "SELECT q FROM QasoilDirectShear q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QASOIL_DIRECT_SHEAR", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QasoilDirectShear.findAll", query = "SELECT q FROM QasoilDirectShear q"),
    @NamedQuery(name = "QasoilDirectShear.findById", query = "SELECT q FROM QasoilDirectShear q WHERE q.id = :id")})
public class QasoilDirectShear implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "TESTPLAN_ID")
    private BigInteger testplanId;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_LL")
    private String waterContentLl;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_PL")
    private String waterContentPl;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_PI")
    private String waterContentPi;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 255)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 255)
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
    @Size(max = 255)
    @Column(name = "FIELD7")
    private String field7;
    @Size(max = 255)
    @Column(name = "FIELD8")
    private String field8;
    @Size(max = 255)
    @Column(name = "FIELD9")
    private String field9;
    @Size(max = 255)
    @Column(name = "FIELD10")
    private String field10;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public QasoilDirectShear() {
    }

    public QasoilDirectShear(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getTestplanId() {
        return testplanId;
    }

    public void setTestplanId(BigInteger testplanId) {
        this.testplanId = testplanId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getWaterContentLl() {
        return waterContentLl;
    }

    public void setWaterContentLl(String waterContentLl) {
        this.waterContentLl = waterContentLl;
    }

    public String getWaterContentPl() {
        return waterContentPl;
    }

    public void setWaterContentPl(String waterContentPl) {
        this.waterContentPl = waterContentPl;
    }

    public String getWaterContentPi() {
        return waterContentPi;
    }

    public void setWaterContentPi(String waterContentPi) {
        this.waterContentPi = waterContentPi;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof QasoilDirectShear)) {
            return false;
        }
        QasoilDirectShear other = (QasoilDirectShear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QasoilDirectShear[ id=" + id + " ]";
    }
    
}
