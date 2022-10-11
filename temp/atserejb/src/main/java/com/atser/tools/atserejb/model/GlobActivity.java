/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "GlobActivity.findByProjectId", query = "SELECT g FROM GlobActivity g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobActivity.findBySegmentId", query = "SELECT g FROM GlobActivity g WHERE g.segmentId = :segmentId")
    , @NamedQuery(name = "GlobActivity.findByName", query = "SELECT g FROM GlobActivity g WHERE g.name = :name")
    , @NamedQuery(name = "GlobActivity.findByDescription", query = "SELECT g FROM GlobActivity g WHERE g.description = :description")
    , @NamedQuery(name = "GlobActivity.findByAreaofwork", query = "SELECT g FROM GlobActivity g WHERE g.areaofwork = :areaofwork")
    , @NamedQuery(name = "GlobActivity.findByStageofwork", query = "SELECT g FROM GlobActivity g WHERE g.stageofwork = :stageofwork")
    , @NamedQuery(name = "GlobActivity.findByPhase", query = "SELECT g FROM GlobActivity g WHERE g.phase = :phase")
    , @NamedQuery(name = "GlobActivity.findByEstimatedCost", query = "SELECT g FROM GlobActivity g WHERE g.estimatedCost = :estimatedCost")
    , @NamedQuery(name = "GlobActivity.findByContact", query = "SELECT g FROM GlobActivity g WHERE g.contact = :contact")
    , @NamedQuery(name = "GlobActivity.findByPhone", query = "SELECT g FROM GlobActivity g WHERE g.phone = :phone")
    , @NamedQuery(name = "GlobActivity.findByCell", query = "SELECT g FROM GlobActivity g WHERE g.cell = :cell")
    , @NamedQuery(name = "GlobActivity.findByFax", query = "SELECT g FROM GlobActivity g WHERE g.fax = :fax")
    , @NamedQuery(name = "GlobActivity.findByEmail", query = "SELECT g FROM GlobActivity g WHERE g.email = :email")
    , @NamedQuery(name = "GlobActivity.findByLocation", query = "SELECT g FROM GlobActivity g WHERE g.location = :location")
    , @NamedQuery(name = "GlobActivity.findByStartDate", query = "SELECT g FROM GlobActivity g WHERE g.startDate = :startDate")
    , @NamedQuery(name = "GlobActivity.findByEndDate", query = "SELECT g FROM GlobActivity g WHERE g.endDate = :endDate")
    , @NamedQuery(name = "GlobActivity.findByPicture", query = "SELECT g FROM GlobActivity g WHERE g.picture = :picture")
    , @NamedQuery(name = "GlobActivity.findByActualStart", query = "SELECT g FROM GlobActivity g WHERE g.actualStart = :actualStart")
    , @NamedQuery(name = "GlobActivity.findByActualEnd", query = "SELECT g FROM GlobActivity g WHERE g.actualEnd = :actualEnd")
    , @NamedQuery(name = "GlobActivity.findByActive", query = "SELECT g FROM GlobActivity g WHERE g.active = :active")
    , @NamedQuery(name = "GlobActivity.findByLastMod", query = "SELECT g FROM GlobActivity g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobActivity.findByStartDateTmp", query = "SELECT g FROM GlobActivity g WHERE g.startDateTmp = :startDateTmp")
    , @NamedQuery(name = "GlobActivity.findByEndDateTmp", query = "SELECT g FROM GlobActivity g WHERE g.endDateTmp = :endDateTmp")
    , @NamedQuery(name = "GlobActivity.findByLastModTmp", query = "SELECT g FROM GlobActivity g WHERE g.lastModTmp = :lastModTmp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_ACTIVITY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobActivity.findAll", query = "SELECT g FROM GlobActivity g"),
    @NamedQuery(name = "GlobActivity.findById", query = "SELECT g FROM GlobActivity g WHERE g.id = :id")})
public class GlobActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "SEGMENT_ID")
    private BigInteger segmentId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "AREAOFWORK")
    private String areaofwork;
    @Size(max = 50)
    @Column(name = "STAGEOFWORK")
    private String stageofwork;
    @Size(max = 50)
    @Column(name = "PHASE")
    private String phase;
    @Size(max = 20)
    @Column(name = "ESTIMATED_COST")
    private String estimatedCost;
    @Size(max = 50)
    @Column(name = "CONTACT")
    private String contact;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "CELL")
    private String cell;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 4000)
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "ACTUAL_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStart;
    @Column(name = "ACTUAL_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEnd;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 4000)
    @Column(name = "START_DATE_TMP")
    private String startDateTmp;
    @Size(max = 4000)
    @Column(name = "END_DATE_TMP")
    private String endDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @OneToMany(mappedBy = "activityId")
    private List<GlobActivityInspection> globActivityInspectionList;

    public GlobActivity() {
    }

    public GlobActivity(BigDecimal id) {
        this.id = id;
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

    public BigInteger getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(BigInteger segmentId) {
        this.segmentId = segmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAreaofwork() {
        return areaofwork;
    }

    public void setAreaofwork(String areaofwork) {
        this.areaofwork = areaofwork;
    }

    public String getStageofwork() {
        return stageofwork;
    }

    public void setStageofwork(String stageofwork) {
        this.stageofwork = stageofwork;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getActualStart() {
        return actualStart;
    }

    public void setActualStart(Date actualStart) {
        this.actualStart = actualStart;
    }

    public Date getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(Date actualEnd) {
        this.actualEnd = actualEnd;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getStartDateTmp() {
        return startDateTmp;
    }

    public void setStartDateTmp(String startDateTmp) {
        this.startDateTmp = startDateTmp;
    }

    public String getEndDateTmp() {
        return endDateTmp;
    }

    public void setEndDateTmp(String endDateTmp) {
        this.endDateTmp = endDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    @XmlTransient
    public List<GlobActivityInspection> getGlobActivityInspectionList() {
        return globActivityInspectionList;
    }

    public void setGlobActivityInspectionList(List<GlobActivityInspection> globActivityInspectionList) {
        this.globActivityInspectionList = globActivityInspectionList;
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
        if (!(object instanceof GlobActivity)) {
            return false;
        }
        GlobActivity other = (GlobActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobActivity[ id=" + id + " ]";
    }

}
