/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
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

/*
    @NamedQuery(name = "QaSampleTestDaysSpec.findByTestage", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.testage = :testage"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByTestageHours", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.testageHours = :testageHours"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findBySpecMin", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.specMin = :specMin"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findBySpecMax", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.specMax = :specMax"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByResult", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.result = :result"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByActive", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByLastMod", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByLastModBy", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByLastModIp", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByCreateDate", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByCreateBy", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByCreateByIp", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByVersion", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByAverage", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.average = :average"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByReportStampType", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.reportStampType = :reportStampType"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByRangeBetween", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.rangeBetween = :rangeBetween"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByRangeSpec", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.rangeSpec = :rangeSpec"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findByRetestRequired", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.retestRequired = :retestRequired")
*/

/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QA_SAMPLE_TEST_DAYS_SPEC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleTestDaysSpec.findAll", query = "SELECT q FROM QaSampleTestDaysSpec q"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findById", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.id = :id"),
    @NamedQuery(name = "QaSampleTestDaysSpec.findBySampleTestId", query = "SELECT q FROM QaSampleTestDaysSpec q WHERE q.sampleTestId = :sampleTestId")})
public class QaSampleTestDaysSpec implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_sample_test_day_spec_id_seq", sequenceName = "qa_sample_test_day_spec_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_sample_test_day_spec_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAMPLE_TEST_ID")
    private BigInteger sampleTestId;
    @Size(max = 50)
    @Column(name = "TESTAGE")
    private String testage;
    @Size(max = 50)
    @Column(name = "TESTAGE_HOURS")
    private String testageHours;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Size(max = 50)
    @Column(name = "REPORT_STAMP_TYPE")
    private String reportStampType;
    @Size(max = 50)
    @Column(name = "RANGE_BETWEEN")
    private String rangeBetween;
    @Size(max = 50)
    @Column(name = "RANGE_SPEC")
    private String rangeSpec;
    @Size(max = 50)
    @Column(name = "RETEST_REQUIRED")
    private String retestRequired;

    public QaSampleTestDaysSpec() {
    }

    public QaSampleTestDaysSpec(BigDecimal id) {
        this.id = id;
    }

    public QaSampleTestDaysSpec(BigDecimal id, BigInteger sampleTestId) {
        this.id = id;
        this.sampleTestId = sampleTestId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(BigInteger sampleTestId) {
        this.sampleTestId = sampleTestId;
    }

    public String getTestage() {
        return testage;
    }

    public void setTestage(String testage) {
        this.testage = testage;
    }

    public String getTestageHours() {
        return testageHours;
    }

    public void setTestageHours(String testageHours) {
        this.testageHours = testageHours;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getReportStampType() {
        return reportStampType;
    }

    public void setReportStampType(String reportStampType) {
        this.reportStampType = reportStampType;
    }

    public String getRangeBetween() {
        return rangeBetween;
    }

    public void setRangeBetween(String rangeBetween) {
        this.rangeBetween = rangeBetween;
    }

    public String getRangeSpec() {
        return rangeSpec;
    }

    public void setRangeSpec(String rangeSpec) {
        this.rangeSpec = rangeSpec;
    }

    public String getRetestRequired() {
        return retestRequired;
    }

    public void setRetestRequired(String retestRequired) {
        this.retestRequired = retestRequired;
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
        if (!(object instanceof QaSampleTestDaysSpec)) {
            return false;
        }
        QaSampleTestDaysSpec other = (QaSampleTestDaysSpec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleTestDaysSpec[ id=" + id + " ]";
    }
    
}
