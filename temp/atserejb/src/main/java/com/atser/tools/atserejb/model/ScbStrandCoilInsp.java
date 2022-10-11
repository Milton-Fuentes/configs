/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "SCB_STRAND_COIL_INSP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbStrandCoilInsp.findAll", query = "SELECT a FROM ScbStrandCoilInsp a")})
public class ScbStrandCoilInsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "TEST_NO")
    private BigInteger testNo;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Size(max = 255)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Column(name = "NUM_POINTS")
    private BigInteger numPoints;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Size(max = 50)
    @Column(name = "DELIVERY_DATE")
    private String deliveryDate;
    @Size(max = 50)
    @Column(name = "MATERIAL_TYPE")
    private String materialType;
    @Size(max = 50)
    @Column(name = "TESTMETHOD")
    private String testMethod;
    @Size(max = 50)
    @Column(name = "DESIGN_DIAMETER")
    private String designDiameter;
    @Size(max = 50)
    @Column(name = "DESIGN_AREA")
    private String designArea;
    @Size(max = 50)
    @Column(name = "DESIGN_TOL_PLUS")
    private String designTolPlus;
    @Size(max = 50)
    @Column(name = "DESIGN_TOL_MINUS")
    private String designTolMinus;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 255)
    @Column(name = "GRADE")
    private String grade;
    @JsonSkipXssSerialization
    @Size(max = 190)
    @Column(name = "TESTNO_LINK")
    private String testNoLink;
    @Size(max = 175)
    @Column(name = "HASPHOTO")
    private String hasPhoto;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 142)
    @Column(name = "TESTNO")
    private String testNo1;
    @Size(max = 50)
    @Column(name = "NO")
    private String no;
    @Size(max = 50)
    @Column(name = "COIL_NO")
    private String coilNo;
    @Size(max = 50)
    @Column(name = "HEAT_NO")
    private String heatNo;
    @Size(max = 50)
    @Column(name = "DIAMETER")
    private String diameter;
    @Size(max = 50)
    @Column(name = "AREA_ACTUAL")
    private String areaActual;
    @Size(max = 50)
    @Column(name = "EMOD_ACTUAL")
    private String emodActual;
    @Size(max = 50)
    @Column(name = "COIL_TEST_REPORT")
    private String coilTestReport;
    @Size(max = 50)
    @Column(name = "PROD_NO")
    private String prodNo;
    @Size(max = 50)
    @Column(name = "LENGTH")
    private String length;
    @Size(max = 50)
    @Column(name = "REJECTED")
    private String rejected;
    @Size(max = 50)
    @Column(name = "NOTICE")
    private String notice;
    @Transient
    private String hasPhotoStr;

    public ScbStrandCoilInsp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getTestNo() {
        return testNo;
    }

    public void setTestNo(BigInteger testNo) {
        this.testNo = testNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BigInteger getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(BigInteger numPoints) {
        this.numPoints = numPoints;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getDesignDiameter() {
        return designDiameter;
    }

    public void setDesignDiameter(String designDiameter) {
        this.designDiameter = designDiameter;
    }

    public String getDesignArea() {
        return designArea;
    }

    public void setDesignArea(String designArea) {
        this.designArea = designArea;
    }

    public String getDesignTolPlus() {
        return designTolPlus;
    }

    public void setDesignTolPlus(String designTolPlus) {
        this.designTolPlus = designTolPlus;
    }

    public String getDesignTolMinus() {
        return designTolMinus;
    }

    public void setDesignTolMinus(String designTolMinus) {
        this.designTolMinus = designTolMinus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(String hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getTestNo1() {
        return testNo1;
    }

    public void setTestNo1(String testNo1) {
        this.testNo1 = testNo1;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCoilNo() {
        return coilNo;
    }

    public void setCoilNo(String coilNo) {
        this.coilNo = coilNo;
    }

    public String getHeatNo() {
        return heatNo;
    }

    public void setHeatNo(String heatNo) {
        this.heatNo = heatNo;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getAreaActual() {
        return areaActual;
    }

    public void setAreaActual(String areaActual) {
        this.areaActual = areaActual;
    }

    public String getEmodActual() {
        return emodActual;
    }

    public void setEmodActual(String emodActual) {
        this.emodActual = emodActual;
    }

    public String getCoilTestReport() {
        return coilTestReport;
    }

    public void setCoilTestReport(String coilTestReport) {
        this.coilTestReport = coilTestReport;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @JsonGetter(value = "hasPhotoStr")
    public String getHasPhotoStr() {
        if (StringSupport.isNotNullAndNotEmpty(getHasPhoto()) && getHasPhoto().length() > 2) {
            return "Yes";
        }
        return "No";
    }

    public void setHasPhotoStr(String hasPhotoStr) {
        this.hasPhotoStr = hasPhotoStr;
    }
}
