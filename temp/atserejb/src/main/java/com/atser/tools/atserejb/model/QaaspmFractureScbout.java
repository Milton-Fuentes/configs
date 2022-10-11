/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QaaspmFractureScbout.findByTestId", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.testId = :testId"),
    @NamedQuery(name = "QaaspmFractureScbout.findBySpecimenNo", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.specimenNo = :specimenNo"),
    @NamedQuery(name = "QaaspmFractureScbout.findByThicknessLeftNotch", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.thicknessLeftNotch = :thicknessLeftNotch"),
    @NamedQuery(name = "QaaspmFractureScbout.findByThicknessRightNotch", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.thicknessRightNotch = :thicknessRightNotch"),
    @NamedQuery(name = "QaaspmFractureScbout.findByThicknessAcrossFromNotch", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.thicknessAcrossFromNotch = :thicknessAcrossFromNotch"),
    @NamedQuery(name = "QaaspmFractureScbout.findByAverageThickness", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.averageThickness = :averageThickness"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLigamentLengthFace1", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.ligamentLengthFace1 = :ligamentLengthFace1"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLigamentLengthFace2", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.ligamentLengthFace2 = :ligamentLengthFace2"),
    @NamedQuery(name = "QaaspmFractureScbout.findByAverageLigamentLength", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.averageLigamentLength = :averageLigamentLength"),
    @NamedQuery(name = "QaaspmFractureScbout.findByNotchDepthFace1", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.notchDepthFace1 = :notchDepthFace1"),
    @NamedQuery(name = "QaaspmFractureScbout.findByNotchDepthFace2", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.notchDepthFace2 = :notchDepthFace2"),
    @NamedQuery(name = "QaaspmFractureScbout.findByAverageNotchDepth", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.averageNotchDepth = :averageNotchDepth"),
    @NamedQuery(name = "QaaspmFractureScbout.findByPeakLoad", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.peakLoad = :peakLoad"),
    @NamedQuery(name = "QaaspmFractureScbout.findByRecordedTimePeakLoad", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.recordedTimePeakLoad = :recordedTimePeakLoad"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLoadLineDisplacePeakLoad", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.loadLineDisplacePeakLoad = :loadLineDisplacePeakLoad"),
    @NamedQuery(name = "QaaspmFractureScbout.findByCriticalDisplacement", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.criticalDisplacement = :criticalDisplacement"),
    @NamedQuery(name = "QaaspmFractureScbout.findByPostPeakSlope", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.postPeakSlope = :postPeakSlope"),
    @NamedQuery(name = "QaaspmFractureScbout.findByFractureEnergy", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.fractureEnergy = :fractureEnergy"),
    @NamedQuery(name = "QaaspmFractureScbout.findByFlexibilityIndex", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.flexibilityIndex = :flexibilityIndex"),
    @NamedQuery(name = "QaaspmFractureScbout.findByActive", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.active = :active"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLastModBy", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLastModIp", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmFractureScbout.findByLastMod", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmFractureScbout.findByCreateBy", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaaspmFractureScbout.findByCreateByIp", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaaspmFractureScbout.findByCreateDate", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaaspmFractureScbout.findByVersion", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QAASPM_FRACTURE_SCBOUT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QAASPM_FRACTURE_SCBOUT SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmFractureScbout.findAll", query = "SELECT q FROM QaaspmFractureScbout q"),
    @NamedQuery(name = "QaaspmFractureScbout.findById", query = "SELECT q FROM QaaspmFractureScbout q WHERE q.id = :id")})
public class QaaspmFractureScbout implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qaaspm_fracture_scbout_ID_SEQ", sequenceName = "qaaspm_fracture_scbout_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qaaspm_fracture_scbout_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "THICKNESS_LEFT_NOTCH")
    private String thicknessLeftNotch;
    @Size(max = 50)
    @Column(name = "THICKNESS_RIGHT_NOTCH")
    private String thicknessRightNotch;
    @Size(max = 50)
    @Column(name = "THICKNESS_ACROSS_FROM_NOTCH")
    private String thicknessAcrossFromNotch;
    @Size(max = 50)
    @Column(name = "AVERAGE_THICKNESS")
    private String averageThickness;
    @Size(max = 50)
    @Column(name = "LIGAMENT_LENGTH_FACE_1")
    private String ligamentLengthFace1;
    @Size(max = 50)
    @Column(name = "LIGAMENT_LENGTH_FACE_2")
    private String ligamentLengthFace2;
    @Size(max = 50)
    @Column(name = "AVERAGE_LIGAMENT_LENGTH")
    private String averageLigamentLength;
    @Size(max = 50)
    @Column(name = "NOTCH_DEPTH_FACE_1")
    private String notchDepthFace1;
    @Size(max = 50)
    @Column(name = "NOTCH_DEPTH_FACE_2")
    private String notchDepthFace2;
    @Size(max = 50)
    @Column(name = "AVERAGE_NOTCH_DEPTH")
    private String averageNotchDepth;
    @Size(max = 50)
    @Column(name = "PEAK_LOAD")
    private String peakLoad;
    @Size(max = 50)
    @Column(name = "RECORDED_TIME_PEAK_LOAD")
    private String recordedTimePeakLoad;
    @Size(max = 50)
    @Column(name = "LOAD_LINE_DISPLACE_PEAK_LOAD")
    private String loadLineDisplacePeakLoad;
    @Size(max = 50)
    @Column(name = "CRITICAL_DISPLACEMENT")
    private String criticalDisplacement;
    @Size(max = 50)
    @Column(name = "POST_PEAK_SLOPE")
    private String postPeakSlope;
    @Size(max = 50)
    @Column(name = "FRACTURE_ENERGY")
    private String fractureEnergy;
    @Size(max = 50)
    @Column(name = "FLEXIBILITY_INDEX")
    private String flexibilityIndex;
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

    public QaaspmFractureScbout() {
    }

    public QaaspmFractureScbout(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getThicknessLeftNotch() {
        return thicknessLeftNotch;
    }

    public void setThicknessLeftNotch(String thicknessLeftNotch) {
        this.thicknessLeftNotch = thicknessLeftNotch;
    }

    public String getThicknessRightNotch() {
        return thicknessRightNotch;
    }

    public void setThicknessRightNotch(String thicknessRightNotch) {
        this.thicknessRightNotch = thicknessRightNotch;
    }

    public String getThicknessAcrossFromNotch() {
        return thicknessAcrossFromNotch;
    }

    public void setThicknessAcrossFromNotch(String thicknessAcrossFromNotch) {
        this.thicknessAcrossFromNotch = thicknessAcrossFromNotch;
    }

    public String getAverageThickness() {
        return averageThickness;
    }

    public void setAverageThickness(String averageThickness) {
        this.averageThickness = averageThickness;
    }

    public String getLigamentLengthFace1() {
        return ligamentLengthFace1;
    }

    public void setLigamentLengthFace1(String ligamentLengthFace1) {
        this.ligamentLengthFace1 = ligamentLengthFace1;
    }

    public String getLigamentLengthFace2() {
        return ligamentLengthFace2;
    }

    public void setLigamentLengthFace2(String ligamentLengthFace2) {
        this.ligamentLengthFace2 = ligamentLengthFace2;
    }

    public String getAverageLigamentLength() {
        return averageLigamentLength;
    }

    public void setAverageLigamentLength(String averageLigamentLength) {
        this.averageLigamentLength = averageLigamentLength;
    }

    public String getNotchDepthFace1() {
        return notchDepthFace1;
    }

    public void setNotchDepthFace1(String notchDepthFace1) {
        this.notchDepthFace1 = notchDepthFace1;
    }

    public String getNotchDepthFace2() {
        return notchDepthFace2;
    }

    public void setNotchDepthFace2(String notchDepthFace2) {
        this.notchDepthFace2 = notchDepthFace2;
    }

    public String getAverageNotchDepth() {
        return averageNotchDepth;
    }

    public void setAverageNotchDepth(String averageNotchDepth) {
        this.averageNotchDepth = averageNotchDepth;
    }

    public String getPeakLoad() {
        return peakLoad;
    }

    public void setPeakLoad(String peakLoad) {
        this.peakLoad = peakLoad;
    }

    public String getRecordedTimePeakLoad() {
        return recordedTimePeakLoad;
    }

    public void setRecordedTimePeakLoad(String recordedTimePeakLoad) {
        this.recordedTimePeakLoad = recordedTimePeakLoad;
    }

    public String getLoadLineDisplacePeakLoad() {
        return loadLineDisplacePeakLoad;
    }

    public void setLoadLineDisplacePeakLoad(String loadLineDisplacePeakLoad) {
        this.loadLineDisplacePeakLoad = loadLineDisplacePeakLoad;
    }

    public String getCriticalDisplacement() {
        return criticalDisplacement;
    }

    public void setCriticalDisplacement(String criticalDisplacement) {
        this.criticalDisplacement = criticalDisplacement;
    }

    public String getPostPeakSlope() {
        return postPeakSlope;
    }

    public void setPostPeakSlope(String postPeakSlope) {
        this.postPeakSlope = postPeakSlope;
    }

    public String getFractureEnergy() {
        return fractureEnergy;
    }

    public void setFractureEnergy(String fractureEnergy) {
        this.fractureEnergy = fractureEnergy;
    }

    public String getFlexibilityIndex() {
        return flexibilityIndex;
    }

    public void setFlexibilityIndex(String flexibilityIndex) {
        this.flexibilityIndex = flexibilityIndex;
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
        return new HashCodeBuilder(17, 37)
                .append(peakLoad)
                .append(recordedTimePeakLoad)
                .append(loadLineDisplacePeakLoad)
                .append(criticalDisplacement)
                .append(postPeakSlope)
                .append(fractureEnergy)
                .append(flexibilityIndex)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaaspmFractureScbout)) {
            return false;
        }
        QaaspmFractureScbout other = (QaaspmFractureScbout) object;
        return new EqualsBuilder()
                .append(this.peakLoad, other.peakLoad)
                .append(this.recordedTimePeakLoad, other.recordedTimePeakLoad)
                .append(this.loadLineDisplacePeakLoad, other.loadLineDisplacePeakLoad)
                .append(this.criticalDisplacement, other.criticalDisplacement)
                .append(this.postPeakSlope, other.postPeakSlope)
                .append(this.fractureEnergy, other.fractureEnergy)
                .append(this.flexibilityIndex, other.flexibilityIndex)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmFractureScbout[ id=" + id + " ]";
    }

}
