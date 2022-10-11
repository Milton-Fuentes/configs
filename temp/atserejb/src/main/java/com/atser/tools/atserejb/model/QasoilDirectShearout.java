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
@NamedQuery(name = "QasoilDirectShearout.findByTestId", query = "SELECT q FROM QasoilDirectShearout q WHERE q.testId = :testId"),
    @NamedQuery(name = "QasoilDirectShearout.findBySpecimenNo", query = "SELECT q FROM QasoilDirectShearout q WHERE q.specimenNo = :specimenNo"),
    @NamedQuery(name = "QasoilDirectShearout.findByBoringNo", query = "SELECT q FROM QasoilDirectShearout q WHERE q.boringNo = :boringNo"),
    @NamedQuery(name = "QasoilDirectShearout.findByDepth", query = "SELECT q FROM QasoilDirectShearout q WHERE q.depth = :depth"),
    @NamedQuery(name = "QasoilDirectShearout.findByDescription", query = "SELECT q FROM QasoilDirectShearout q WHERE q.description = :description"),
    @NamedQuery(name = "QasoilDirectShearout.findByDateTest", query = "SELECT q FROM QasoilDirectShearout q WHERE q.dateTest = :dateTest"),
    @NamedQuery(name = "QasoilDirectShearout.findBySpecimenType", query = "SELECT q FROM QasoilDirectShearout q WHERE q.specimenType = :specimenType"),
    @NamedQuery(name = "QasoilDirectShearout.findByPrep", query = "SELECT q FROM QasoilDirectShearout q WHERE q.prep = :prep"),
    @NamedQuery(name = "QasoilDirectShearout.findBySpecificGravity", query = "SELECT q FROM QasoilDirectShearout q WHERE q.specificGravity = :specificGravity"),
    @NamedQuery(name = "QasoilDirectShearout.findByUscsClass", query = "SELECT q FROM QasoilDirectShearout q WHERE q.uscsClass = :uscsClass"),
    @NamedQuery(name = "QasoilDirectShearout.findByAashtoClass", query = "SELECT q FROM QasoilDirectShearout q WHERE q.aashtoClass = :aashtoClass"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestDiameter", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestDiameter = :beforeTestDiameter"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestHeight", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestHeight = :beforeTestHeight"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestWaterContent", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestWaterContent = :beforeTestWaterContent"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestArea", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestArea = :beforeTestArea"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestVolume", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestVolume = :beforeTestVolume"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestWetDensity", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestWetDensity = :beforeTestWetDensity"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestDryDensity", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestDryDensity = :beforeTestDryDensity"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestVolumeSolids", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestVolumeSolids = :beforeTestVolumeSolids"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestVoidRatio", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestVoidRatio = :beforeTestVoidRatio"),
    @NamedQuery(name = "QasoilDirectShearout.findByBeforeTestSaturation", query = "SELECT q FROM QasoilDirectShearout q WHERE q.beforeTestSaturation = :beforeTestSaturation"),
    @NamedQuery(name = "QasoilDirectShearout.findByConsolidationNoStages", query = "SELECT q FROM QasoilDirectShearout q WHERE q.consolidationNoStages = :consolidationNoStages"),
    @NamedQuery(name = "QasoilDirectShearout.findByConsolidationSettlement", query = "SELECT q FROM QasoilDirectShearout q WHERE q.consolidationSettlement = :consolidationSettlement"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearNoStages", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearNoStages = :shearNoStages"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearAvgNormalStress", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearAvgNormalStress = :shearAvgNormalStress"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearMaxShearStress", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearMaxShearStress = :shearMaxShearStress"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearMaxShearForce", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearMaxShearForce = :shearMaxShearForce"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearMaxDisplacement", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearMaxDisplacement = :shearMaxDisplacement"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearTravel", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearTravel = :shearTravel"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearAvgRate", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearAvgRate = :shearAvgRate"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearHeightChange", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearHeightChange = :shearHeightChange"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearFinalHeight", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearFinalHeight = :shearFinalHeight"),
    @NamedQuery(name = "QasoilDirectShearout.findByShearFinalVolume", query = "SELECT q FROM QasoilDirectShearout q WHERE q.shearFinalVolume = :shearFinalVolume"),
    @NamedQuery(name = "QasoilDirectShearout.findByAfterTestWaterContent", query = "SELECT q FROM QasoilDirectShearout q WHERE q.afterTestWaterContent = :afterTestWaterContent"),
    @NamedQuery(name = "QasoilDirectShearout.findByAfterTestDryDensity", query = "SELECT q FROM QasoilDirectShearout q WHERE q.afterTestDryDensity = :afterTestDryDensity"),
    @NamedQuery(name = "QasoilDirectShearout.findByAfterTestWetDensity", query = "SELECT q FROM QasoilDirectShearout q WHERE q.afterTestWetDensity = :afterTestWetDensity"),
    @NamedQuery(name = "QasoilDirectShearout.findByAfterTestVoidRatio", query = "SELECT q FROM QasoilDirectShearout q WHERE q.afterTestVoidRatio = :afterTestVoidRatio"),
    @NamedQuery(name = "QasoilDirectShearout.findByAfterTestSaturation", query = "SELECT q FROM QasoilDirectShearout q WHERE q.afterTestSaturation = :afterTestSaturation"),
    @NamedQuery(name = "QasoilDirectShearout.findByActive", query = "SELECT q FROM QasoilDirectShearout q WHERE q.active = :active"),
    @NamedQuery(name = "QasoilDirectShearout.findByLastModBy", query = "SELECT q FROM QasoilDirectShearout q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QasoilDirectShearout.findByLastModIp", query = "SELECT q FROM QasoilDirectShearout q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QasoilDirectShearout.findByLastMod", query = "SELECT q FROM QasoilDirectShearout q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QasoilDirectShearout.findByCreateBy", query = "SELECT q FROM QasoilDirectShearout q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QasoilDirectShearout.findByCreateByIp", query = "SELECT q FROM QasoilDirectShearout q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QasoilDirectShearout.findByCreateDate", query = "SELECT q FROM QasoilDirectShearout q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QasoilDirectShearout.findByVersion", query = "SELECT q FROM QasoilDirectShearout q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QASOIL_DIRECT_SHEAROUT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QASOIL_DIRECT_SHEAROUT SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QasoilDirectShearout.findAll", query = "SELECT q FROM QasoilDirectShearout q"),
    @NamedQuery(name = "QasoilDirectShearout.findById", query = "SELECT q FROM QasoilDirectShearout q WHERE q.id = :id")})
public class QasoilDirectShearout implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qasoil_direct_shearout_ID_SEQ", sequenceName = "qasoil_direct_shearout_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qasoil_direct_shearout_ID_SEQ")
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
    @Column(name = "BORING_NO")
    private String boringNo;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "DATE_TEST")
    private String dateTest;
    @Size(max = 50)
    @Column(name = "SPECIMEN_TYPE")
    private String specimenType;
    @Size(max = 50)
    @Column(name = "PREP")
    private String prep;
    @Size(max = 50)
    @Column(name = "SPECIFIC_GRAVITY")
    private String specificGravity;
    @Size(max = 50)
    @Column(name = "USCS_CLASS")
    private String uscsClass;
    @Size(max = 50)
    @Column(name = "AASHTO_CLASS")
    private String aashtoClass;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_DIAMETER")
    private String beforeTestDiameter;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_HEIGHT")
    private String beforeTestHeight;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_WATER_CONTENT")
    private String beforeTestWaterContent;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_AREA")
    private String beforeTestArea;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOLUME")
    private String beforeTestVolume;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_WET_DENSITY")
    private String beforeTestWetDensity;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_DRY_DENSITY")
    private String beforeTestDryDensity;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOLUME_SOLIDS")
    private String beforeTestVolumeSolids;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOID_RATIO")
    private String beforeTestVoidRatio;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_SATURATION")
    private String beforeTestSaturation;
    @Size(max = 50)
    @Column(name = "CONSOLIDATION_NO_STAGES")
    private String consolidationNoStages;
    @Size(max = 50)
    @Column(name = "CONSOLIDATION_SETTLEMENT")
    private String consolidationSettlement;
    @Size(max = 50)
    @Column(name = "SHEAR_NO_STAGES")
    private String shearNoStages;
    @Size(max = 50)
    @Column(name = "SHEAR_AVG_NORMAL_STRESS")
    private String shearAvgNormalStress;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_SHEAR_STRESS")
    private String shearMaxShearStress;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_SHEAR_FORCE")
    private String shearMaxShearForce;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_DISPLACEMENT")
    private String shearMaxDisplacement;
    @Size(max = 50)
    @Column(name = "SHEAR_TRAVEL")
    private String shearTravel;
    @Size(max = 50)
    @Column(name = "SHEAR_AVG_RATE")
    private String shearAvgRate;
    @Size(max = 50)
    @Column(name = "SHEAR_HEIGHT_CHANGE")
    private String shearHeightChange;
    @Size(max = 50)
    @Column(name = "SHEAR_FINAL_HEIGHT")
    private String shearFinalHeight;
    @Size(max = 50)
    @Column(name = "SHEAR_FINAL_VOLUME")
    private String shearFinalVolume;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_WATER_CONTENT")
    private String afterTestWaterContent;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_DRY_DENSITY")
    private String afterTestDryDensity;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_WET_DENSITY")
    private String afterTestWetDensity;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_VOID_RATIO")
    private String afterTestVoidRatio;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_SATURATION")
    private String afterTestSaturation;
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

    public QasoilDirectShearout() {
    }

    public QasoilDirectShearout(BigDecimal id) {
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

    public String getBoringNo() {
        return boringNo;
    }

    public void setBoringNo(String boringNo) {
        this.boringNo = boringNo;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTest() {
        return dateTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(String specificGravity) {
        this.specificGravity = specificGravity;
    }

    public String getUscsClass() {
        return uscsClass;
    }

    public void setUscsClass(String uscsClass) {
        this.uscsClass = uscsClass;
    }

    public String getAashtoClass() {
        return aashtoClass;
    }

    public void setAashtoClass(String aashtoClass) {
        this.aashtoClass = aashtoClass;
    }

    public String getBeforeTestDiameter() {
        return beforeTestDiameter;
    }

    public void setBeforeTestDiameter(String beforeTestDiameter) {
        this.beforeTestDiameter = beforeTestDiameter;
    }

    public String getBeforeTestHeight() {
        return beforeTestHeight;
    }

    public void setBeforeTestHeight(String beforeTestHeight) {
        this.beforeTestHeight = beforeTestHeight;
    }

    public String getBeforeTestWaterContent() {
        return beforeTestWaterContent;
    }

    public void setBeforeTestWaterContent(String beforeTestWaterContent) {
        this.beforeTestWaterContent = beforeTestWaterContent;
    }

    public String getBeforeTestArea() {
        return beforeTestArea;
    }

    public void setBeforeTestArea(String beforeTestArea) {
        this.beforeTestArea = beforeTestArea;
    }

    public String getBeforeTestVolume() {
        return beforeTestVolume;
    }

    public void setBeforeTestVolume(String beforeTestVolume) {
        this.beforeTestVolume = beforeTestVolume;
    }

    public String getBeforeTestWetDensity() {
        return beforeTestWetDensity;
    }

    public void setBeforeTestWetDensity(String beforeTestWetDensity) {
        this.beforeTestWetDensity = beforeTestWetDensity;
    }

    public String getBeforeTestDryDensity() {
        return beforeTestDryDensity;
    }

    public void setBeforeTestDryDensity(String beforeTestDryDensity) {
        this.beforeTestDryDensity = beforeTestDryDensity;
    }

    public String getBeforeTestVolumeSolids() {
        return beforeTestVolumeSolids;
    }

    public void setBeforeTestVolumeSolids(String beforeTestVolumeSolids) {
        this.beforeTestVolumeSolids = beforeTestVolumeSolids;
    }

    public String getBeforeTestVoidRatio() {
        return beforeTestVoidRatio;
    }

    public void setBeforeTestVoidRatio(String beforeTestVoidRatio) {
        this.beforeTestVoidRatio = beforeTestVoidRatio;
    }

    public String getBeforeTestSaturation() {
        return beforeTestSaturation;
    }

    public void setBeforeTestSaturation(String beforeTestSaturation) {
        this.beforeTestSaturation = beforeTestSaturation;
    }

    public String getConsolidationNoStages() {
        return consolidationNoStages;
    }

    public void setConsolidationNoStages(String consolidationNoStages) {
        this.consolidationNoStages = consolidationNoStages;
    }

    public String getConsolidationSettlement() {
        return consolidationSettlement;
    }

    public void setConsolidationSettlement(String consolidationSettlement) {
        this.consolidationSettlement = consolidationSettlement;
    }

    public String getShearNoStages() {
        return shearNoStages;
    }

    public void setShearNoStages(String shearNoStages) {
        this.shearNoStages = shearNoStages;
    }

    public String getShearAvgNormalStress() {
        return shearAvgNormalStress;
    }

    public void setShearAvgNormalStress(String shearAvgNormalStress) {
        this.shearAvgNormalStress = shearAvgNormalStress;
    }

    public String getShearMaxShearStress() {
        return shearMaxShearStress;
    }

    public void setShearMaxShearStress(String shearMaxShearStress) {
        this.shearMaxShearStress = shearMaxShearStress;
    }

    public String getShearMaxShearForce() {
        return shearMaxShearForce;
    }

    public void setShearMaxShearForce(String shearMaxShearForce) {
        this.shearMaxShearForce = shearMaxShearForce;
    }

    public String getShearMaxDisplacement() {
        return shearMaxDisplacement;
    }

    public void setShearMaxDisplacement(String shearMaxDisplacement) {
        this.shearMaxDisplacement = shearMaxDisplacement;
    }

    public String getShearTravel() {
        return shearTravel;
    }

    public void setShearTravel(String shearTravel) {
        this.shearTravel = shearTravel;
    }

    public String getShearAvgRate() {
        return shearAvgRate;
    }

    public void setShearAvgRate(String shearAvgRate) {
        this.shearAvgRate = shearAvgRate;
    }

    public String getShearHeightChange() {
        return shearHeightChange;
    }

    public void setShearHeightChange(String shearHeightChange) {
        this.shearHeightChange = shearHeightChange;
    }

    public String getShearFinalHeight() {
        return shearFinalHeight;
    }

    public void setShearFinalHeight(String shearFinalHeight) {
        this.shearFinalHeight = shearFinalHeight;
    }

    public String getShearFinalVolume() {
        return shearFinalVolume;
    }

    public void setShearFinalVolume(String shearFinalVolume) {
        this.shearFinalVolume = shearFinalVolume;
    }

    public String getAfterTestWaterContent() {
        return afterTestWaterContent;
    }

    public void setAfterTestWaterContent(String afterTestWaterContent) {
        this.afterTestWaterContent = afterTestWaterContent;
    }

    public String getAfterTestDryDensity() {
        return afterTestDryDensity;
    }

    public void setAfterTestDryDensity(String afterTestDryDensity) {
        this.afterTestDryDensity = afterTestDryDensity;
    }

    public String getAfterTestWetDensity() {
        return afterTestWetDensity;
    }

    public void setAfterTestWetDensity(String afterTestWetDensity) {
        this.afterTestWetDensity = afterTestWetDensity;
    }

    public String getAfterTestVoidRatio() {
        return afterTestVoidRatio;
    }

    public void setAfterTestVoidRatio(String afterTestVoidRatio) {
        this.afterTestVoidRatio = afterTestVoidRatio;
    }

    public String getAfterTestSaturation() {
        return afterTestSaturation;
    }

    public void setAfterTestSaturation(String afterTestSaturation) {
        this.afterTestSaturation = afterTestSaturation;
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
                .append(consolidationNoStages)
                .append(consolidationSettlement)
                .append(beforeTestDiameter)
                .append(beforeTestHeight)
                .append(beforeTestWaterContent)
                .append(beforeTestArea)
                .append(beforeTestWetDensity)
                .append(beforeTestDryDensity)
                .append(beforeTestVoidRatio)
                .append(beforeTestSaturation)
                .append(shearNoStages)
                .append(shearMaxShearStress)
                .append(shearMaxShearForce)
                .append(shearMaxDisplacement)
                .append(shearTravel)
                .append(shearAvgRate)
                .append(shearHeightChange)
                .append(shearFinalHeight)
                .append(shearFinalVolume)
                .append(afterTestWaterContent)
                .append(afterTestDryDensity)
                .append(afterTestWetDensity)
                .append(afterTestVoidRatio)
                .append(afterTestSaturation)
                .append(boringNo)
                .append(depth)
                .append(description)
                .append(specificGravity)
                .append(prep)
                .append(specimenType)
                .append(shearAvgNormalStress)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QasoilDirectShearout)) {
            return false;
        }
        QasoilDirectShearout other = (QasoilDirectShearout) object;
        return new EqualsBuilder()
                .append(this.consolidationNoStages, other.consolidationNoStages)
                .append(this.consolidationSettlement, other.consolidationSettlement)
                .append(this.beforeTestDiameter, other.beforeTestDiameter)
                .append(this.beforeTestHeight, other.beforeTestHeight)
                .append(this.beforeTestWaterContent, other.beforeTestWaterContent)
                .append(this.beforeTestArea, other.beforeTestArea)
                .append(this.beforeTestWetDensity, other.beforeTestWetDensity)
                .append(this.beforeTestDryDensity, other.beforeTestDryDensity)
                .append(this.beforeTestVoidRatio, other.beforeTestVoidRatio)
                .append(this.beforeTestSaturation, other.beforeTestSaturation)
                .append(this.shearNoStages, other.shearNoStages)
                .append(this.shearMaxShearStress, other.shearMaxShearStress)
                .append(this.shearMaxShearForce, other.shearMaxShearForce)
                .append(this.shearMaxDisplacement, other.shearMaxDisplacement)
                .append(this.shearTravel, other.shearTravel)
                .append(this.shearAvgRate, other.shearAvgRate)
                .append(this.shearHeightChange, other.shearHeightChange)
                .append(this.shearFinalHeight, other.shearFinalHeight)
                .append(this.shearFinalVolume, other.shearFinalVolume)
                .append(this.afterTestWaterContent, other.afterTestWaterContent)
                .append(this.afterTestDryDensity, other.afterTestDryDensity)
                .append(this.afterTestWetDensity, other.afterTestWetDensity)
                .append(this.afterTestVoidRatio, other.afterTestVoidRatio)
                .append(this.afterTestSaturation, other.afterTestSaturation)
                .append(this.boringNo, other.boringNo)
                .append(this.depth, other.depth)
                .append(this.description, other.description)
                .append(this.specificGravity, other.specificGravity)
                .append(this.prep, other.prep)
                .append(this.specimenType, other.specimenType)
                .append(this.shearAvgNormalStress, other.shearAvgNormalStress)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QasoilDirectShearout[ id=" + id + " ]";
    }
    
}
