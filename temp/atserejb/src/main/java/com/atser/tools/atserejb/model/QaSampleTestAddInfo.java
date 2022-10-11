/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QaSampleTestAddInfo.findBySampleTestId", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.sampleTestId = :sampleTestId"),
    @NamedQuery(name = "QaSampleTestAddInfo.findBySampleType2", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.sampleType2 = :sampleType2"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByReportType", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.reportType = :reportType"),
    @NamedQuery(name = "QaSampleTestAddInfo.findBySection", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.section = :section"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByMaterialDescription", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.materialDescription = :materialDescription"),
    @NamedQuery(name = "QaSampleTestAddInfo.findBySpecProv", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.specProv = :specProv"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByStructureNo", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.structureNo = :structureNo"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByGrading", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.grading = :grading"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByLocation", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.location = :location"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByMaterialSource", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.materialSource = :materialSource"),
    @NamedQuery(name = "QaSampleTestAddInfo.findBySupplierId", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.supplierId = :supplierId"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByDepth", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.depth = :depth"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByDirection", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.direction = :direction"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByRoadway", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.roadway = :roadway"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByStation", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.station = :station"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByOffset", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.offset = :offset"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByDescription", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.description = :description"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByActive", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.active = :active"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByLastMod", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByLastModBy", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByLastModIp", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByCreateDateTmp", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByCreateBy", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByCreateByIp", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByVersion", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.version = :version"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByTraceNo", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.traceNo = :traceNo"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByEngDecision", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.engDecision = :engDecision"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByMaterialLocation", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.materialLocation = :materialLocation"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByMaterialComments", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.materialComments = :materialComments"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByDueDate", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.dueDate = :dueDate"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByReportStampType", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.reportStampType = :reportStampType"),
    @NamedQuery(name = "QaSampleTestAddInfo.findByCreateDate", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.createDate = :createDate")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_SAMPLE_TEST_ADD_INFO", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_SAMPLE_TEST_ADD_INFO SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleTestAddInfo.findAll", query = "SELECT q FROM QaSampleTestAddInfo q"),
    @NamedQuery(name = "QaSampleTestAddInfo.findById", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.id = :id"),
    @NamedQuery(name = "QaSampleTestAddInfo.findBySampleTestId", query = "SELECT q FROM QaSampleTestAddInfo q WHERE q.sampleTestId.id = :id")})
public class QaSampleTestAddInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_sample_test_add_info_id_seq", sequenceName = "qa_sample_test_add_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_sample_test_add_info_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SAMPLE_TEST_ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private QaSampleTest sampleTestId;
    /*@Column(name = "SAMPLE_TEST_ID")
    private BigInteger sampleTestId;*/
    @Size(max = 255)
    @Column(name = "SAMPLE_TYPE2")
    private String sampleType2;
    @Size(max = 255)
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Size(max = 255)
    @Column(name = "SECTION")
    private String section;
    @Size(max = 255)
    @Column(name = "MATERIAL_DESCRIPTION")
    private String materialDescription;
    @Size(max = 255)
    @Column(name = "SPEC_PROV")
    private String specProv;
    @Size(max = 255)
    @Column(name = "STRUCTURE_NO")
    private String structureNo;
    @Size(max = 255)
    @Column(name = "GRADING")
    private String grading;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 255)
    @Column(name = "MATERIAL_SOURCE")
    private String materialSource;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Size(max = 255)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 255)
    @Column(name = "DIRECTION")
    private String direction;
    @Size(max = 255)
    @Column(name = "ROADWAY")
    private String roadway;
    @Size(max = 255)
    @Column(name = "STATION")
    private String station;
    @Size(max = 255)
    @Column(name = "OFFSET")
    private String offset;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE")
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
    @Column(name = "CREATE_DATE_TMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTmp;
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
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 10)
    @Column(name = "ENG_DECISION")
    private String engDecision;
    @Size(max = 255)
    @Column(name = "MATERIAL_LOCATION")
    private String materialLocation;
    @Size(max = 255)
    @Column(name = "MATERIAL_COMMENTS")
    private String materialComments;
    @Size(max = 255)
    @Column(name = "DUE_DATE")
    private String dueDate;
    @Size(max = 50)
    @Column(name = "REPORT_STAMP_TYPE")
    private String reportStampType;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;

    /*@Size(max = 1)
    @Column(name = "MATERIAL_MET_REQUIREMENTS")
    private String materialMetRequirements;
    @Size(max = 1)
    @Column(name = "MATERIAL_UNDER_REQUIREMENTS")
    private String materialUnderRequirements;
    @Size(max = 1)
    @Column(name = "ADDITIONAL_COMMENTS")
    private String additionalComments;
    @Column(name = "DRAFT")
    private Character draft;*/

    public QaSampleTestAddInfo() {
    }

    public QaSampleTestAddInfo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaSampleTest getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(QaSampleTest sampleTestId) {
        this.sampleTestId = sampleTestId;
    }

    public String getSampleType2() {
        return sampleType2;
    }

    public void setSampleType2(String sampleType2) {
        this.sampleType2 = sampleType2;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getSpecProv() {
        return specProv;
    }

    public void setSpecProv(String specProv) {
        this.specProv = specProv;
    }

    public String getStructureNo() {
        return structureNo;
    }

    public void setStructureNo(String structureNo) {
        this.structureNo = structureNo;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterialSource() {
        return materialSource;
    }

    public void setMaterialSource(String materialSource) {
        this.materialSource = materialSource;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRoadway() {
        return roadway;
    }

    public void setRoadway(String roadway) {
        this.roadway = roadway;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(Date createDateTmp) {
        this.createDateTmp = createDateTmp;
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

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getEngDecision() {
        return engDecision;
    }

    public void setEngDecision(String engDecision) {
        this.engDecision = engDecision;
    }

    public String getMaterialLocation() {
        return materialLocation;
    }

    public void setMaterialLocation(String materialLocation) {
        this.materialLocation = materialLocation;
    }

    public String getMaterialComments() {
        return materialComments;
    }

    public void setMaterialComments(String materialComments) {
        this.materialComments = materialComments;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReportStampType() {
        return reportStampType;
    }

    public void setReportStampType(String reportStampType) {
        this.reportStampType = reportStampType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
        if (!(object instanceof QaSampleTestAddInfo)) {
            return false;
        }
        QaSampleTestAddInfo other = (QaSampleTestAddInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleTestAddInfo[ id=" + id + " ]";
    }

}
