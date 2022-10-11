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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QaconcResistivity.findBySampletestId", query = "SELECT q FROM QaconcResistivity q WHERE q.sampletestId = :sampletestId"),
    @NamedQuery(name = "QaconcResistivity.findByReport", query = "SELECT q FROM QaconcResistivity q WHERE q.report = :report"),
    @NamedQuery(name = "QaconcResistivity.findByTestplanId", query = "SELECT q FROM QaconcResistivity q WHERE q.testplanId = :testplanId"),
    @NamedQuery(name = "QaconcResistivity.findByQuantity", query = "SELECT q FROM QaconcResistivity q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QaconcResistivity.findByTestReportNo", query = "SELECT q FROM QaconcResistivity q WHERE q.testReportNo = :testReportNo"),
    @NamedQuery(name = "QaconcResistivity.findBySublotNo", query = "SELECT q FROM QaconcResistivity q WHERE q.sublotNo = :sublotNo"),
    @NamedQuery(name = "QaconcResistivity.findByWeather", query = "SELECT q FROM QaconcResistivity q WHERE q.weather = :weather"),
    @NamedQuery(name = "QaconcResistivity.findByWeatherTemp", query = "SELECT q FROM QaconcResistivity q WHERE q.weatherTemp = :weatherTemp"),
    @NamedQuery(name = "QaconcResistivity.findByMintemp", query = "SELECT q FROM QaconcResistivity q WHERE q.mintemp = :mintemp"),
    @NamedQuery(name = "QaconcResistivity.findByMaxtemp", query = "SELECT q FROM QaconcResistivity q WHERE q.maxtemp = :maxtemp"),
    @NamedQuery(name = "QaconcResistivity.findByCuringMethod", query = "SELECT q FROM QaconcResistivity q WHERE q.curingMethod = :curingMethod"),
    @NamedQuery(name = "QaconcResistivity.findBySpecimenCovered", query = "SELECT q FROM QaconcResistivity q WHERE q.specimenCovered = :specimenCovered"),
    @NamedQuery(name = "QaconcResistivity.findByCuringCorr", query = "SELECT q FROM QaconcResistivity q WHERE q.curingCorr = :curingCorr"),
    @NamedQuery(name = "QaconcResistivity.findBySetAverage", query = "SELECT q FROM QaconcResistivity q WHERE q.setAverage = :setAverage"),
    @NamedQuery(name = "QaconcResistivity.findByPenetrability", query = "SELECT q FROM QaconcResistivity q WHERE q.penetrability = :penetrability"),
    @NamedQuery(name = "QaconcResistivity.findByFarSummary", query = "SELECT q FROM QaconcResistivity q WHERE q.farSummary = :farSummary"),
    @NamedQuery(name = "QaconcResistivity.findByRemarks", query = "SELECT q FROM QaconcResistivity q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaconcResistivity.findByActive", query = "SELECT q FROM QaconcResistivity q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcResistivity.findByField1", query = "SELECT q FROM QaconcResistivity q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaconcResistivity.findByField2", query = "SELECT q FROM QaconcResistivity q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaconcResistivity.findByField3", query = "SELECT q FROM QaconcResistivity q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaconcResistivity.findByField4", query = "SELECT q FROM QaconcResistivity q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaconcResistivity.findByField5", query = "SELECT q FROM QaconcResistivity q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaconcResistivity.findByField6", query = "SELECT q FROM QaconcResistivity q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaconcResistivity.findByField7", query = "SELECT q FROM QaconcResistivity q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaconcResistivity.findByField8", query = "SELECT q FROM QaconcResistivity q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QaconcResistivity.findByField9", query = "SELECT q FROM QaconcResistivity q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QaconcResistivity.findByField10", query = "SELECT q FROM QaconcResistivity q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QaconcResistivity.findByLastMod", query = "SELECT q FROM QaconcResistivity q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcResistivity.findByLastModBy", query = "SELECT q FROM QaconcResistivity q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaconcResistivity.findByLastModIp", query = "SELECT q FROM QaconcResistivity q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcResistivity.findByCreateDate", query = "SELECT q FROM QaconcResistivity q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaconcResistivity.findByCreateBy", query = "SELECT q FROM QaconcResistivity q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaconcResistivity.findByCreateByIp", query = "SELECT q FROM QaconcResistivity q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaconcResistivity.findByVersion", query = "SELECT q FROM QaconcResistivity q WHERE q.version = :version"),
    @NamedQuery(name = "QaconcResistivity.findBySpecMin", query = "SELECT q FROM QaconcResistivity q WHERE q.specMin = :specMin"),
    @NamedQuery(name = "QaconcResistivity.findBySpecMax", query = "SELECT q FROM QaconcResistivity q WHERE q.specMax = :specMax"),
    @NamedQuery(name = "QaconcResistivity.findByResult", query = "SELECT q FROM QaconcResistivity q WHERE q.result = :result"),
    @NamedQuery(name = "QaconcResistivity.findByLabPrep", query = "SELECT q FROM QaconcResistivity q WHERE q.labPrep = :labPrep")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QACONC_RESISTIVITY", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QACONC_RESISTIVITY SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcResistivity.findAll", query = "SELECT q FROM QaconcResistivity q"),
    @NamedQuery(name = "QaconcResistivity.findById", query = "SELECT q FROM QaconcResistivity q WHERE q.id = :id")})
public class QaconcResistivity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_RESISTIVITY_id_seq", sequenceName = "QACONC_RESISTIVITY_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_RESISTIVITY_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Size(max = 50)
    @Column(name = "REPORT")
    private String report;
    @Column(name = "TESTPLAN_ID")
    private BigInteger testplanId;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "SUBLOT_NO")
    private BigInteger sublotNo;
    @Size(max = 50)
    @Column(name = "WEATHER")
    private String weather;
    @Size(max = 50)
    @Column(name = "WEATHER_TEMP")
    private String weatherTemp;
    @Size(max = 50)
    @Column(name = "MINTEMP")
    private String mintemp;
    @Size(max = 50)
    @Column(name = "MAXTEMP")
    private String maxtemp;
    @Size(max = 50)
    @Column(name = "CURING_METHOD")
    private String curingMethod;
    @Size(max = 50)
    @Column(name = "SPECIMEN_COVERED")
    private String specimenCovered;
    @Size(max = 50)
    @Column(name = "CURING_CORR")
    private String curingCorr;
    @Size(max = 50)
    @Column(name = "SET_AVERAGE")
    private String setAverage;
    @Size(max = 50)
    @Column(name = "PENETRABILITY")
    private String penetrability;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
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
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @Size(max = 50)
    @Column(name = "FIELD9")
    private String field9;
    @Size(max = 255)
    @Column(name = "FIELD10")
    private String field10;
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
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;

    public QaconcResistivity() {
    }

    public QaconcResistivity(BigDecimal id) {
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

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getSublotNo() {
        return sublotNo;
    }

    public void setSublotNo(BigInteger sublotNo) {
        this.sublotNo = sublotNo;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherTemp() {
        return weatherTemp;
    }

    public void setWeatherTemp(String weatherTemp) {
        this.weatherTemp = weatherTemp;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getCuringMethod() {
        return curingMethod;
    }

    public void setCuringMethod(String curingMethod) {
        this.curingMethod = curingMethod;
    }

    public String getSpecimenCovered() {
        return specimenCovered;
    }

    public void setSpecimenCovered(String specimenCovered) {
        this.specimenCovered = specimenCovered;
    }

    public String getCuringCorr() {
        return curingCorr;
    }

    public void setCuringCorr(String curingCorr) {
        this.curingCorr = curingCorr;
    }

    public String getSetAverage() {
        return setAverage;
    }

    public void setSetAverage(String setAverage) {
        this.setAverage = setAverage;
    }

    public String getPenetrability() {
        return penetrability;
    }

    public void setPenetrability(String penetrability) {
        this.penetrability = penetrability;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
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
        if (!(object instanceof QaconcResistivity)) {
            return false;
        }
        QaconcResistivity other = (QaconcResistivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcResistivity[ id=" + id + " ]";
    }
    
}
