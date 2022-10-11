/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author mfuentes
 */
@Entity
@QmsOldVersion
//@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "QASTEEL_MAGNETIC_PARTOUTV", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QASTEEL_MAGNETIC_PARTOUT SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@NamedQueries({
    @NamedQuery(name = "QasteelMagneticPartoutv.findAll", query = "SELECT a FROM QasteelMagneticPartoutv a"),
    @NamedQuery(name = "QasteelMagneticPartoutv.findById", query = "SELECT a FROM QasteelMagneticPartoutv a WHERE a.id = :id"),
    @NamedQuery(name = "QasteelMagneticPartoutv.findByTestId", query = "SELECT q FROM QasteelMagneticPartoutv q WHERE q.testId = :testId")
})
public class QasteelMagneticPartoutv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "QASTEEL_MAGNETIC_PARTOUTV_SEQ", sequenceName = "QASTEEL_MAGNETIC_PARTOUTV_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QASTEEL_MAGNETIC_PARTOUTV_SEQ")
    @EqualsAndHashCode.Include
    @ToString.Include
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    //--------------------------------------------------------------------------
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "TEST_NO")
    private String testNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD5")
    private String field5;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD6")
    private String field6;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "FIELD9")
    private String field9;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "FIELD10")
    private String field10;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "NOP")
    private String nop;
    //--------------------------------------------------------------------------
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "NO")
    private Integer no;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    //--------------------------------------------------------------------------
    //----Particular test-------------------------------------------------------
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "TIME_WORKED_FROM")
    private String timeWorkedFrom;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "TIME_WORKED_TO")
    private String timeWorkedTo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "HOURS_WORKED_STRAIGHT")
    private String hoursWorkedStraight;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "HOURS_WORKED_OVERTIME")
    private String hoursWorkedOvertime;

    public QasteelMagneticPartoutv() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
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

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeWorkedFrom() {
        return timeWorkedFrom;
    }

    public void setTimeWorkedFrom(String timeWorkedFrom) {
        this.timeWorkedFrom = timeWorkedFrom;
    }

    public String getTimeWorkedTo() {
        return timeWorkedTo;
    }

    public void setTimeWorkedTo(String timeWorkedTo) {
        this.timeWorkedTo = timeWorkedTo;
    }

    public String getHoursWorkedStraight() {
        return hoursWorkedStraight;
    }

    public void setHoursWorkedStraight(String hoursWorkedStraight) {
        this.hoursWorkedStraight = hoursWorkedStraight;
    }

    public String getHoursWorkedOvertime() {
        return hoursWorkedOvertime;
    }

    public void setHoursWorkedOvertime(String hoursWorkedOvertime) {
        this.hoursWorkedOvertime = hoursWorkedOvertime;
    }
    

}
