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
    @NamedQuery(name = "QaaspmFractureScb.findBySampletestId", query = "SELECT q FROM QaaspmFractureScb q WHERE q.sampletestId = :sampletestId"),
    @NamedQuery(name = "QaaspmFractureScb.findByTestReportNo", query = "SELECT q FROM QaaspmFractureScb q WHERE q.testReportNo = :testReportNo"),
    @NamedQuery(name = "QaaspmFractureScb.findByTestplanId", query = "SELECT q FROM QaaspmFractureScb q WHERE q.testplanId = :testplanId"),
    @NamedQuery(name = "QaaspmFractureScb.findByQuantity", query = "SELECT q FROM QaaspmFractureScb q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QaaspmFractureScb.findByAveragePeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.averagePeakLoad = :averagePeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByCoeffVariationPeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.coeffVariationPeakLoad = :coeffVariationPeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgRecordedTimePeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgRecordedTimePeakLoad = :avgRecordedTimePeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovRecordedTimePeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covRecordedTimePeakLoad = :covRecordedTimePeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgLoadLineDisplPeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgLoadLineDisplPeakLoad = :avgLoadLineDisplPeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovLoadLineDisplPeakLoad", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covLoadLineDisplPeakLoad = :covLoadLineDisplPeakLoad"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgCriticalDisplacement", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgCriticalDisplacement = :avgCriticalDisplacement"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovCriticalDisplacement", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covCriticalDisplacement = :covCriticalDisplacement"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgPostPeakSlope", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgPostPeakSlope = :avgPostPeakSlope"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovPostPeakSlope", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covPostPeakSlope = :covPostPeakSlope"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgFractureEnergy", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgFractureEnergy = :avgFractureEnergy"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovFractureEnergy", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covFractureEnergy = :covFractureEnergy"),
    @NamedQuery(name = "QaaspmFractureScb.findByAvgFlexibilityIndex", query = "SELECT q FROM QaaspmFractureScb q WHERE q.avgFlexibilityIndex = :avgFlexibilityIndex"),
    @NamedQuery(name = "QaaspmFractureScb.findByCovFlexibilityIndex", query = "SELECT q FROM QaaspmFractureScb q WHERE q.covFlexibilityIndex = :covFlexibilityIndex"),
    @NamedQuery(name = "QaaspmFractureScb.findBySpecMin", query = "SELECT q FROM QaaspmFractureScb q WHERE q.specMin = :specMin"),
    @NamedQuery(name = "QaaspmFractureScb.findBySpecMax", query = "SELECT q FROM QaaspmFractureScb q WHERE q.specMax = :specMax"),
    @NamedQuery(name = "QaaspmFractureScb.findByResult", query = "SELECT q FROM QaaspmFractureScb q WHERE q.result = :result"),
    @NamedQuery(name = "QaaspmFractureScb.findByFarSummary", query = "SELECT q FROM QaaspmFractureScb q WHERE q.farSummary = :farSummary"),
    @NamedQuery(name = "QaaspmFractureScb.findByRemarks", query = "SELECT q FROM QaaspmFractureScb q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaaspmFractureScb.findByField1", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaaspmFractureScb.findByField2", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaaspmFractureScb.findByField3", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaaspmFractureScb.findByField4", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaaspmFractureScb.findByField5", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaaspmFractureScb.findByField6", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaaspmFractureScb.findByField7", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaaspmFractureScb.findByField8", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QaaspmFractureScb.findByField9", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QaaspmFractureScb.findByField10", query = "SELECT q FROM QaaspmFractureScb q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QaaspmFractureScb.findByActive", query = "SELECT q FROM QaaspmFractureScb q WHERE q.active = :active"),
    @NamedQuery(name = "QaaspmFractureScb.findByLastModBy", query = "SELECT q FROM QaaspmFractureScb q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmFractureScb.findByLastModIp", query = "SELECT q FROM QaaspmFractureScb q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmFractureScb.findByLastMod", query = "SELECT q FROM QaaspmFractureScb q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmFractureScb.findByCreateBy", query = "SELECT q FROM QaaspmFractureScb q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaaspmFractureScb.findByCreateByIp", query = "SELECT q FROM QaaspmFractureScb q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaaspmFractureScb.findByCreateDate", query = "SELECT q FROM QaaspmFractureScb q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaaspmFractureScb.findByVersion", query = "SELECT q FROM QaaspmFractureScb q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QAASPM_FRACTURE_SCB", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QAASPM_FRACTURE_SCB SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmFractureScb.findAll", query = "SELECT q FROM QaaspmFractureScb q"),
    @NamedQuery(name = "QaaspmFractureScb.findById", query = "SELECT q FROM QaaspmFractureScb q WHERE q.id = :id")})
public class QaaspmFractureScb implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qaaspm_fracture_scb_ID_SEQ", sequenceName = "qaaspm_fracture_scb_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qaaspm_fracture_scb_ID_SEQ")
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
    @Column(name = "AVERAGE_PEAK_LOAD")
    private String averagePeakLoad;
    @Size(max = 50)
    @Column(name = "COEFF_VARIATION_PEAK_LOAD")
    private String coeffVariationPeakLoad;
    @Size(max = 50)
    @Column(name = "AVG_RECORDED_TIME_PEAK_LOAD")
    private String avgRecordedTimePeakLoad;
    @Size(max = 50)
    @Column(name = "COV_RECORDED_TIME_PEAK_LOAD")
    private String covRecordedTimePeakLoad;
    @Size(max = 50)
    @Column(name = "AVG_LOAD_LINE_DISPL_PEAK_LOAD")
    private String avgLoadLineDisplPeakLoad;
    @Size(max = 50)
    @Column(name = "COV_LOAD_LINE_DISPL_PEAK_LOAD")
    private String covLoadLineDisplPeakLoad;
    @Size(max = 50)
    @Column(name = "AVG_CRITICAL_DISPLACEMENT")
    private String avgCriticalDisplacement;
    @Size(max = 50)
    @Column(name = "COV_CRITICAL_DISPLACEMENT")
    private String covCriticalDisplacement;
    @Size(max = 50)
    @Column(name = "AVG_POST_PEAK_SLOPE")
    private String avgPostPeakSlope;
    @Size(max = 50)
    @Column(name = "COV_POST_PEAK_SLOPE")
    private String covPostPeakSlope;
    @Size(max = 50)
    @Column(name = "AVG_FRACTURE_ENERGY")
    private String avgFractureEnergy;
    @Size(max = 50)
    @Column(name = "COV_FRACTURE_ENERGY")
    private String covFractureEnergy;
    @Size(max = 50)
    @Column(name = "AVG_FLEXIBILITY_INDEX")
    private String avgFlexibilityIndex;
    @Size(max = 50)
    @Column(name = "COV_FLEXIBILITY_INDEX")
    private String covFlexibilityIndex;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
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
    @Column(name = "ACTIVE", insertable = false)
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

    public QaaspmFractureScb() {
    }

    public QaaspmFractureScb(BigDecimal id) {
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

    public String getAveragePeakLoad() {
        return averagePeakLoad;
    }

    public void setAveragePeakLoad(String averagePeakLoad) {
        this.averagePeakLoad = averagePeakLoad;
    }

    public String getCoeffVariationPeakLoad() {
        return coeffVariationPeakLoad;
    }

    public void setCoeffVariationPeakLoad(String coeffVariationPeakLoad) {
        this.coeffVariationPeakLoad = coeffVariationPeakLoad;
    }

    public String getAvgRecordedTimePeakLoad() {
        return avgRecordedTimePeakLoad;
    }

    public void setAvgRecordedTimePeakLoad(String avgRecordedTimePeakLoad) {
        this.avgRecordedTimePeakLoad = avgRecordedTimePeakLoad;
    }

    public String getCovRecordedTimePeakLoad() {
        return covRecordedTimePeakLoad;
    }

    public void setCovRecordedTimePeakLoad(String covRecordedTimePeakLoad) {
        this.covRecordedTimePeakLoad = covRecordedTimePeakLoad;
    }

    public String getAvgLoadLineDisplPeakLoad() {
        return avgLoadLineDisplPeakLoad;
    }

    public void setAvgLoadLineDisplPeakLoad(String avgLoadLineDisplPeakLoad) {
        this.avgLoadLineDisplPeakLoad = avgLoadLineDisplPeakLoad;
    }

    public String getCovLoadLineDisplPeakLoad() {
        return covLoadLineDisplPeakLoad;
    }

    public void setCovLoadLineDisplPeakLoad(String covLoadLineDisplPeakLoad) {
        this.covLoadLineDisplPeakLoad = covLoadLineDisplPeakLoad;
    }

    public String getAvgCriticalDisplacement() {
        return avgCriticalDisplacement;
    }

    public void setAvgCriticalDisplacement(String avgCriticalDisplacement) {
        this.avgCriticalDisplacement = avgCriticalDisplacement;
    }

    public String getCovCriticalDisplacement() {
        return covCriticalDisplacement;
    }

    public void setCovCriticalDisplacement(String covCriticalDisplacement) {
        this.covCriticalDisplacement = covCriticalDisplacement;
    }

    public String getAvgPostPeakSlope() {
        return avgPostPeakSlope;
    }

    public void setAvgPostPeakSlope(String avgPostPeakSlope) {
        this.avgPostPeakSlope = avgPostPeakSlope;
    }

    public String getCovPostPeakSlope() {
        return covPostPeakSlope;
    }

    public void setCovPostPeakSlope(String covPostPeakSlope) {
        this.covPostPeakSlope = covPostPeakSlope;
    }

    public String getAvgFractureEnergy() {
        return avgFractureEnergy;
    }

    public void setAvgFractureEnergy(String avgFractureEnergy) {
        this.avgFractureEnergy = avgFractureEnergy;
    }

    public String getCovFractureEnergy() {
        return covFractureEnergy;
    }

    public void setCovFractureEnergy(String covFractureEnergy) {
        this.covFractureEnergy = covFractureEnergy;
    }

    public String getAvgFlexibilityIndex() {
        return avgFlexibilityIndex;
    }

    public void setAvgFlexibilityIndex(String avgFlexibilityIndex) {
        this.avgFlexibilityIndex = avgFlexibilityIndex;
    }

    public String getCovFlexibilityIndex() {
        return covFlexibilityIndex;
    }

    public void setCovFlexibilityIndex(String covFlexibilityIndex) {
        this.covFlexibilityIndex = covFlexibilityIndex;
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
        if (!(object instanceof QaaspmFractureScb)) {
            return false;
        }
        QaaspmFractureScb other = (QaaspmFractureScb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmFractureScb[ id=" + id + " ]";
    }

}
