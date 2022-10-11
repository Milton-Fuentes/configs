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
    @NamedQuery(name = "QaconcResistivityout.findByTestId", query = "SELECT q FROM QaconcResistivityout q WHERE q.testId = :testId"),
    @NamedQuery(name = "QaconcResistivityout.findByCylinderNo", query = "SELECT q FROM QaconcResistivityout q WHERE q.cylinderNo = :cylinderNo"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle1", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle1 = :angle1"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle2", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle2 = :angle2"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle3", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle3 = :angle3"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle4", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle4 = :angle4"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle5", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle5 = :angle5"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle6", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle6 = :angle6"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle7", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle7 = :angle7"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle8", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle8 = :angle8"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle1Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle1Repeat = :angle1Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle2Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle2Repeat = :angle2Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle3Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle3Repeat = :angle3Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle4Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle4Repeat = :angle4Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle5Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle5Repeat = :angle5Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle6Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle6Repeat = :angle6Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle7Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle7Repeat = :angle7Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAngle8Repeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.angle8Repeat = :angle8Repeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAverageFirst", query = "SELECT q FROM QaconcResistivityout q WHERE q.averageFirst = :averageFirst"),
    @NamedQuery(name = "QaconcResistivityout.findByAverageRepeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.averageRepeat = :averageRepeat"),
    @NamedQuery(name = "QaconcResistivityout.findByPercRsdFirst", query = "SELECT q FROM QaconcResistivityout q WHERE q.percRsdFirst = :percRsdFirst"),
    @NamedQuery(name = "QaconcResistivityout.findByPercRsdRepeat", query = "SELECT q FROM QaconcResistivityout q WHERE q.percRsdRepeat = :percRsdRepeat"),
    @NamedQuery(name = "QaconcResistivityout.findByAverage16", query = "SELECT q FROM QaconcResistivityout q WHERE q.average16 = :average16"),
    @NamedQuery(name = "QaconcResistivityout.findByAverage", query = "SELECT q FROM QaconcResistivityout q WHERE q.average = :average"),
    @NamedQuery(name = "QaconcResistivityout.findByActive", query = "SELECT q FROM QaconcResistivityout q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcResistivityout.findByLastMod", query = "SELECT q FROM QaconcResistivityout q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcResistivityout.findByLastModBy", query = "SELECT q FROM QaconcResistivityout q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaconcResistivityout.findByLastModIp", query = "SELECT q FROM QaconcResistivityout q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcResistivityout.findByCreateDate", query = "SELECT q FROM QaconcResistivityout q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaconcResistivityout.findByCreateBy", query = "SELECT q FROM QaconcResistivityout q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaconcResistivityout.findByCreateByIp", query = "SELECT q FROM QaconcResistivityout q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaconcResistivityout.findByVersion", query = "SELECT q FROM QaconcResistivityout q WHERE q.version = :version"),
    @NamedQuery(name = "QaconcResistivityout.findBySpecimenNo", query = "SELECT q FROM QaconcResistivityout q WHERE q.specimenNo = :specimenNo"),
    @NamedQuery(name = "QaconcResistivityout.findByTestage", query = "SELECT q FROM QaconcResistivityout q WHERE q.testage = :testage"),
    @NamedQuery(name = "QaconcResistivityout.findByTestBy", query = "SELECT q FROM QaconcResistivityout q WHERE q.testBy = :testBy")
 */
/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QACONC_RESISTIVITYOUT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QACONC_RESISTIVITYOUT SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcResistivityout.findAll", query = "SELECT q FROM QaconcResistivityout q"),
    @NamedQuery(name = "QaconcResistivityout.findById", query = "SELECT q FROM QaconcResistivityout q WHERE q.id = :id")})
public class QaconcResistivityout implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_RESISTIVITYOUT_id_seq", sequenceName = "QACONC_RESISTIVITYOUT_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_RESISTIVITYOUT_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 50)
    @Column(name = "CYLINDER_NO")
    private String cylinderNo;
    @Size(max = 50)
    @Column(name = "ANGLE_1")
    private String angle1;
    @Size(max = 50)
    @Column(name = "ANGLE_2")
    private String angle2;
    @Size(max = 50)
    @Column(name = "ANGLE_3")
    private String angle3;
    @Size(max = 50)
    @Column(name = "ANGLE_4")
    private String angle4;
    @Size(max = 50)
    @Column(name = "ANGLE_5")
    private String angle5;
    @Size(max = 50)
    @Column(name = "ANGLE_6")
    private String angle6;
    @Size(max = 50)
    @Column(name = "ANGLE_7")
    private String angle7;
    @Size(max = 50)
    @Column(name = "ANGLE_8")
    private String angle8;
    @Size(max = 50)
    @Column(name = "ANGLE_1_REPEAT")
    private String angle1Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_2_REPEAT")
    private String angle2Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_3_REPEAT")
    private String angle3Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_4_REPEAT")
    private String angle4Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_5_REPEAT")
    private String angle5Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_6_REPEAT")
    private String angle6Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_7_REPEAT")
    private String angle7Repeat;
    @Size(max = 50)
    @Column(name = "ANGLE_8_REPEAT")
    private String angle8Repeat;
    @Size(max = 50)
    @Column(name = "AVERAGE_FIRST")
    private String averageFirst;
    @Size(max = 50)
    @Column(name = "AVERAGE_REPEAT")
    private String averageRepeat;
    @Size(max = 50)
    @Column(name = "PERC_RSD_FIRST")
    private String percRsdFirst;
    @Size(max = 50)
    @Column(name = "PERC_RSD_REPEAT")
    private String percRsdRepeat;
    @Size(max = 50)
    @Column(name = "AVERAGE_16")
    private String average16;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
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
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "TESTAGE")
    private String testage;
    @Size(max = 50)
    @Column(name = "TEST_BY")
    private String testBy;

    public QaconcResistivityout() {
    }

    public QaconcResistivityout(BigDecimal id) {
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

    public String getCylinderNo() {
        return cylinderNo;
    }

    public void setCylinderNo(String cylinderNo) {
        this.cylinderNo = cylinderNo;
    }

    public String getAngle1() {
        return angle1;
    }

    public void setAngle1(String angle1) {
        this.angle1 = angle1;
    }

    public String getAngle2() {
        return angle2;
    }

    public void setAngle2(String angle2) {
        this.angle2 = angle2;
    }

    public String getAngle3() {
        return angle3;
    }

    public void setAngle3(String angle3) {
        this.angle3 = angle3;
    }

    public String getAngle4() {
        return angle4;
    }

    public void setAngle4(String angle4) {
        this.angle4 = angle4;
    }

    public String getAngle5() {
        return angle5;
    }

    public void setAngle5(String angle5) {
        this.angle5 = angle5;
    }

    public String getAngle6() {
        return angle6;
    }

    public void setAngle6(String angle6) {
        this.angle6 = angle6;
    }

    public String getAngle7() {
        return angle7;
    }

    public void setAngle7(String angle7) {
        this.angle7 = angle7;
    }

    public String getAngle8() {
        return angle8;
    }

    public void setAngle8(String angle8) {
        this.angle8 = angle8;
    }

    public String getAngle1Repeat() {
        return angle1Repeat;
    }

    public void setAngle1Repeat(String angle1Repeat) {
        this.angle1Repeat = angle1Repeat;
    }

    public String getAngle2Repeat() {
        return angle2Repeat;
    }

    public void setAngle2Repeat(String angle2Repeat) {
        this.angle2Repeat = angle2Repeat;
    }

    public String getAngle3Repeat() {
        return angle3Repeat;
    }

    public void setAngle3Repeat(String angle3Repeat) {
        this.angle3Repeat = angle3Repeat;
    }

    public String getAngle4Repeat() {
        return angle4Repeat;
    }

    public void setAngle4Repeat(String angle4Repeat) {
        this.angle4Repeat = angle4Repeat;
    }

    public String getAngle5Repeat() {
        return angle5Repeat;
    }

    public void setAngle5Repeat(String angle5Repeat) {
        this.angle5Repeat = angle5Repeat;
    }

    public String getAngle6Repeat() {
        return angle6Repeat;
    }

    public void setAngle6Repeat(String angle6Repeat) {
        this.angle6Repeat = angle6Repeat;
    }

    public String getAngle7Repeat() {
        return angle7Repeat;
    }

    public void setAngle7Repeat(String angle7Repeat) {
        this.angle7Repeat = angle7Repeat;
    }

    public String getAngle8Repeat() {
        return angle8Repeat;
    }

    public void setAngle8Repeat(String angle8Repeat) {
        this.angle8Repeat = angle8Repeat;
    }

    public String getAverageFirst() {
        return averageFirst;
    }

    public void setAverageFirst(String averageFirst) {
        this.averageFirst = averageFirst;
    }

    public String getAverageRepeat() {
        return averageRepeat;
    }

    public void setAverageRepeat(String averageRepeat) {
        this.averageRepeat = averageRepeat;
    }

    public String getPercRsdFirst() {
        return percRsdFirst;
    }

    public void setPercRsdFirst(String percRsdFirst) {
        this.percRsdFirst = percRsdFirst;
    }

    public String getPercRsdRepeat() {
        return percRsdRepeat;
    }

    public void setPercRsdRepeat(String percRsdRepeat) {
        this.percRsdRepeat = percRsdRepeat;
    }

    public String getAverage16() {
        return average16;
    }

    public void setAverage16(String average16) {
        this.average16 = average16;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
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

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getTestage() {
        return testage;
    }

    public void setTestage(String testage) {
        this.testage = testage;
    }

    public String getTestBy() {
        return testBy;
    }

    public void setTestBy(String testBy) {
        this.testBy = testBy;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(angle1)
                .append(angle2)
                .append(angle3)
                .append(angle4)
                .append(angle5)
                .append(angle6)
                .append(angle7)
                .append(angle8)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaconcResistivityout)) {
            return false;
        }
        QaconcResistivityout other = (QaconcResistivityout) object;
        return new EqualsBuilder()
                .append(this.angle1, other.angle1)
                .append(this.angle2, other.angle2)
                .append(this.angle3, other.angle3)
                .append(this.angle4, other.angle4)
                .append(this.angle5, other.angle5)
                .append(this.angle6, other.angle6)
                .append(this.angle7, other.angle7)
                .append(this.angle8, other.angle8)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcResistivityout[ id=" + id + " ]";
    }

}
