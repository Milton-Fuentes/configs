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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
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
@Table(name = "QASTEEL_MAGNETIC_PART", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QASTEEL_MAGNETIC_PART SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QasteelMagneticPart.findAll", query = "SELECT a FROM QasteelMagneticPart a"),
    @NamedQuery(name = "QasteelMagneticPart.findById", query = "SELECT a FROM QasteelMagneticPart a WHERE a.id = :id"),
    @NamedQuery(name = "QasteelMagneticPart.findBySampletestId", query = "SELECT q FROM QasteelMagneticPart q WHERE q.sampletestId = :sampletestId")
})
public class QasteelMagneticPart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "QASTEEL_MAGNETIC_PART_SEQ", sequenceName = "QASTEEL_MAGNETIC_PART_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QASTEEL_MAGNETIC_PART_SEQ")
    @EqualsAndHashCode.Include
    @ToString.Include
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    //--------------------------------------------------------------------------
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
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    //--------------------------------------------------------------------------
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Column(name = "ACTIVE")
    private Character active;
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
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "LOCATION_VENDOR")
    private String locationVendor;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "DATE_VENDOR")
    private String dateVendor;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "PO_NO")
    private String poNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "RELEASE_NO")
    private String releaseNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "JOB_NO")
    private String jobNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 3000)
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 3000)
    @Column(name = "MATERIAL_FURNISHED")
    private String materialFurnished;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 3000)
    @Column(name = "EQUIPMENT_FURNISHED")
    private String equipmentFurnished;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 3000)
    @Column(name = "WORK_DESCRIPTION")
    private String workDescription;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "INSPECTION_CLIENT")
    private String inspectionClient;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "INSPECTION_DATE")
    private String inspectionDate;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 1000)
    @Column(name = "INSPECTION_PROJECT")
    private String inspectionProject;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 1000)
    @Column(name = "INSPECTION_CREW")
    private String inspectionCrew;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "EQUIPMENT")
    private String equipment;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "MANUFACTURER1")
    private String manufacturer1;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "CALIBRATION_DATE")
    private String calibrationDate;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "MEDIA")
    private String media;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "MANUFACTURER2")
    private String manufacturer2;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "METHOD")
    private String method;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "YOKE")
    private String yoke;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "ILONG")
    private String ilong;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "DRY")
    private String dry;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "PROD")
    private String prod;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "COIL")
    private String coil;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "CIR")
    private String cir;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "FLUORESCENT")
    private String fluorescent;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "PROCEDURE")
    private String procedure;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 100)
    @Column(name = "ACCEPTABLE_CRITERIA")
    private String acceptableCriteria;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 300)
    @Column(name = "COMMENTS")
    private String comments;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "DEPART_LAB")
    private String departLab;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB")
    private String arriveLab;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QasteelMagneticPartout> qasteelMagneticPartoutList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QasteelMagneticPartoutv> qasteelMagneticPartoutvList;

    public QasteelMagneticPart() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
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

    public String getLocationVendor() {
        return locationVendor;
    }

    public void setLocationVendor(String locationVendor) {
        this.locationVendor = locationVendor;
    }

    public String getDateVendor() {
        return dateVendor;
    }

    public void setDateVendor(String dateVendor) {
        this.dateVendor = dateVendor;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getReleaseNo() {
        return releaseNo;
    }

    public void setReleaseNo(String releaseNo) {
        this.releaseNo = releaseNo;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMaterialFurnished() {
        return materialFurnished;
    }

    public void setMaterialFurnished(String materialFurnished) {
        this.materialFurnished = materialFurnished;
    }

    public String getEquipmentFurnished() {
        return equipmentFurnished;
    }

    public void setEquipmentFurnished(String equipmentFurnished) {
        this.equipmentFurnished = equipmentFurnished;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getInspectionClient() {
        return inspectionClient;
    }

    public void setInspectionClient(String inspectionClient) {
        this.inspectionClient = inspectionClient;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionProject() {
        return inspectionProject;
    }

    public void setInspectionProject(String inspectionProject) {
        this.inspectionProject = inspectionProject;
    }

    public String getInspectionCrew() {
        return inspectionCrew;
    }

    public void setInspectionCrew(String inspectionCrew) {
        this.inspectionCrew = inspectionCrew;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getManufacturer1() {
        return manufacturer1;
    }

    public void setManufacturer1(String manufacturer1) {
        this.manufacturer1 = manufacturer1;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(String calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getManufacturer2() {
        return manufacturer2;
    }

    public void setManufacturer2(String manufacturer2) {
        this.manufacturer2 = manufacturer2;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getYoke() {
        return yoke;
    }

    public void setYoke(String yoke) {
        this.yoke = yoke;
    }

    public String getIlong() {
        return ilong;
    }

    public void setIlong(String ilong) {
        this.ilong = ilong;
    }

    public String getDry() {
        return dry;
    }

    public void setDry(String dry) {
        this.dry = dry;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getCoil() {
        return coil;
    }

    public void setCoil(String coil) {
        this.coil = coil;
    }

    public String getCir() {
        return cir;
    }

    public void setCir(String cir) {
        this.cir = cir;
    }

    public String getFluorescent() {
        return fluorescent;
    }

    public void setFluorescent(String fluorescent) {
        this.fluorescent = fluorescent;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getAcceptableCriteria() {
        return acceptableCriteria;
    }

    public void setAcceptableCriteria(String acceptableCriteria) {
        this.acceptableCriteria = acceptableCriteria;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDepartLab() {
        return departLab;
    }

    public void setDepartLab(String departLab) {
        this.departLab = departLab;
    }

    public String getArriveLab() {
        return arriveLab;
    }

    public void setArriveLab(String arriveLab) {
        this.arriveLab = arriveLab;
    }

    public List<QasteelMagneticPartout> getQasteelMagneticPartoutList() {
        return qasteelMagneticPartoutList;
    }

    public void setQasteelMagneticPartoutList(List<QasteelMagneticPartout> qasteelMagneticPartoutList) {
        this.qasteelMagneticPartoutList = qasteelMagneticPartoutList;
    }

    public List<QasteelMagneticPartoutv> getQasteelMagneticPartoutvList() {
        return qasteelMagneticPartoutvList;
    }

    public void setQasteelMagneticPartoutvList(List<QasteelMagneticPartoutv> qasteelMagneticPartoutvList) {
        this.qasteelMagneticPartoutvList = qasteelMagneticPartoutvList;
    }
    
}
