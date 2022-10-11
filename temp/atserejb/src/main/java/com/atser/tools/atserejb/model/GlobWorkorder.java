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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobWorkorder.findByWoNo", query = "SELECT g FROM GlobWorkorder g WHERE g.woNo = :woNo")
    , @NamedQuery(name = "GlobWorkorder.findByActivityId", query = "SELECT g FROM GlobWorkorder g WHERE g.activityId = :activityId")
    , @NamedQuery(name = "GlobWorkorder.findBySegmentId", query = "SELECT g FROM GlobWorkorder g WHERE g.segmentId = :segmentId")
    , @NamedQuery(name = "GlobWorkorder.findByServiceDate", query = "SELECT g FROM GlobWorkorder g WHERE g.serviceDate = :serviceDate")
    , @NamedQuery(name = "GlobWorkorder.findByDueDate", query = "SELECT g FROM GlobWorkorder g WHERE g.dueDate = :dueDate")
    , @NamedQuery(name = "GlobWorkorder.findByDepartment", query = "SELECT g FROM GlobWorkorder g WHERE g.department = :department")
    , @NamedQuery(name = "GlobWorkorder.findByContact", query = "SELECT g FROM GlobWorkorder g WHERE g.contact = :contact")
    , @NamedQuery(name = "GlobWorkorder.findByManager", query = "SELECT g FROM GlobWorkorder g WHERE g.manager = :manager")
    , @NamedQuery(name = "GlobWorkorder.findByDepartLabTime", query = "SELECT g FROM GlobWorkorder g WHERE g.departLabTime = :departLabTime")
    , @NamedQuery(name = "GlobWorkorder.findByArriveLabTime", query = "SELECT g FROM GlobWorkorder g WHERE g.arriveLabTime = :arriveLabTime")
    , @NamedQuery(name = "GlobWorkorder.findByEngServiceType", query = "SELECT g FROM GlobWorkorder g WHERE g.engServiceType = :engServiceType")
    , @NamedQuery(name = "GlobWorkorder.findByEngInstruction", query = "SELECT g FROM GlobWorkorder g WHERE g.engInstruction = :engInstruction")
    , @NamedQuery(name = "GlobWorkorder.findByEngNotes", query = "SELECT g FROM GlobWorkorder g WHERE g.engNotes = :engNotes")
    , @NamedQuery(name = "GlobWorkorder.findByFdService", query = "SELECT g FROM GlobWorkorder g WHERE g.fdService = :fdService")
    , @NamedQuery(name = "GlobWorkorder.findByFdDescription", query = "SELECT g FROM GlobWorkorder g WHERE g.fdDescription = :fdDescription")
    , @NamedQuery(name = "GlobWorkorder.findByFdInstruction", query = "SELECT g FROM GlobWorkorder g WHERE g.fdInstruction = :fdInstruction")
    , @NamedQuery(name = "GlobWorkorder.findByFdNotes", query = "SELECT g FROM GlobWorkorder g WHERE g.fdNotes = :fdNotes")
    , @NamedQuery(name = "GlobWorkorder.findByTestCategory", query = "SELECT g FROM GlobWorkorder g WHERE g.testCategory = :testCategory")
    , @NamedQuery(name = "GlobWorkorder.findByTestType", query = "SELECT g FROM GlobWorkorder g WHERE g.testType = :testType")
    , @NamedQuery(name = "GlobWorkorder.findByLabInstruction", query = "SELECT g FROM GlobWorkorder g WHERE g.labInstruction = :labInstruction")
    , @NamedQuery(name = "GlobWorkorder.findByLabNotes", query = "SELECT g FROM GlobWorkorder g WHERE g.labNotes = :labNotes")
    , @NamedQuery(name = "GlobWorkorder.findByTechName", query = "SELECT g FROM GlobWorkorder g WHERE g.techName = :techName")
    , @NamedQuery(name = "GlobWorkorder.findByTechDirections", query = "SELECT g FROM GlobWorkorder g WHERE g.techDirections = :techDirections")
    , @NamedQuery(name = "GlobWorkorder.findByTechNotes", query = "SELECT g FROM GlobWorkorder g WHERE g.techNotes = :techNotes")
    , @NamedQuery(name = "GlobWorkorder.findByActive", query = "SELECT g FROM GlobWorkorder g WHERE g.active = :active")
    , @NamedQuery(name = "GlobWorkorder.findByLastMod", query = "SELECT g FROM GlobWorkorder g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobWorkorder.findByCreateByIp", query = "SELECT g FROM GlobWorkorder g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobWorkorder.findByLastModTmp", query = "SELECT g FROM GlobWorkorder g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobWorkorder.findByDueDateTmp", query = "SELECT g FROM GlobWorkorder g WHERE g.dueDateTmp = :dueDateTmp")
    , @NamedQuery(name = "GlobWorkorder.findByServiceDateTmp", query = "SELECT g FROM GlobWorkorder g WHERE g.serviceDateTmp = :serviceDateTmp")
    , @NamedQuery(name = "GlobWorkorder.findByCancelled", query = "SELECT g FROM GlobWorkorder g WHERE g.cancelled = :cancelled")
    , @NamedQuery(name = "GlobWorkorder.findByCertification", query = "SELECT g FROM GlobWorkorder g WHERE g.certification = :certification")
    , @NamedQuery(name = "GlobWorkorder.findByDepartSiteTime", query = "SELECT g FROM GlobWorkorder g WHERE g.departSiteTime = :departSiteTime")
    , @NamedQuery(name = "GlobWorkorder.findByArriveSiteTime", query = "SELECT g FROM GlobWorkorder g WHERE g.arriveSiteTime = :arriveSiteTime")
    , @NamedQuery(name = "GlobWorkorder.findByContactTelephone", query = "SELECT g FROM GlobWorkorder g WHERE g.contactTelephone = :contactTelephone")
    , @NamedQuery(name = "GlobWorkorder.findByWoShort", query = "SELECT g FROM GlobWorkorder g WHERE g.woShort = :woShort")
    , @NamedQuery(name = "GlobWorkorder.findByWoLong", query = "SELECT g FROM GlobWorkorder g WHERE g.woLong = :woLong")
    , @NamedQuery(name = "GlobWorkorder.findByProjectId", query = "SELECT g FROM GlobWorkorder g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobWorkorder.findMaxWON", query = "SELECT MAX(g.woNo) AS MaxWON FROM GlobWorkorder g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobWorkorder.findByCreateDateTmp", query = "SELECT g FROM GlobWorkorder g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobWorkorder.findByCreateBy", query = "SELECT g FROM GlobWorkorder g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobWorkorder.findByLastModBy", query = "SELECT g FROM GlobWorkorder g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobWorkorder.findByCreateDate", query = "SELECT g FROM GlobWorkorder g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobWorkorder.findByLastModIp", query = "SELECT g FROM GlobWorkorder g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobWorkorder.getDistinctByActivityId", query = "SELECT DISTINCT g.activityId FROM GlobWorkorder g WHERE g.activityId IS NOT NULL AND g.cancelled = 'No' AND g.projectId = :projectId")
    , @NamedQuery(name = "GlobWorkorder.findByVersion", query = "SELECT g FROM GlobWorkorder g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
//@QmsOldVersion
@Entity
@Table(name = "GLOB_WORKORDER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobWorkorder.findAll", query = "SELECT g FROM GlobWorkorder g")
    , @NamedQuery(name = "GlobWorkorder.findById", query = "SELECT g FROM GlobWorkorder g WHERE g.id = :id")
    , @NamedQuery(name = "GlobWorkorder.findByWOToken", query = "SELECT g FROM GlobWorkorder g WHERE g.woToken = :woToken")
    , @NamedQuery(name = "GlobWorkorder.getDistinctByActivityId", query = "SELECT DISTINCT g.activityId FROM GlobWorkorder g WHERE g.activityId IS NOT NULL AND g.cancelled = 'No' AND g.projectId = :projectId")})
public class GlobWorkorder implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_WORKORDER_ID_SEQ", sequenceName = "GLOB_WORKORDER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_WORKORDER_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "WO_NO")
    private String woNo;
    @Column(name = "ACTIVITY_ID")
    private BigInteger activityId;
    @Size(max = 50)
    @Column(name = "SEGMENT_ID")
    private String segmentId;
    @Column(name = "SERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDate;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Size(max = 50)
    @Column(name = "DEPARTMENT")
    private String department;
    @Size(max = 50)
    @Column(name = "CONTACT")
    private String contact;
    @Size(max = 50)
    @Column(name = "MANAGER")
    private String manager;
    @Size(max = 50)
    @Column(name = "DEPART_LAB_TIME")
    private String departLabTime;
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB_TIME")
    private String arriveLabTime;
    @Size(max = 50)
    @Column(name = "ENG_SERVICE_TYPE")
    private String engServiceType;
    @Size(max = 255)
    @Column(name = "ENG_INSTRUCTION")
    private String engInstruction;
    @Size(max = 255)
    @Column(name = "ENG_NOTES")
    private String engNotes;
    @Size(max = 50)
    @Column(name = "FD_SERVICE")
    private String fdService;
    @Size(max = 255)
    @Column(name = "FD_DESCRIPTION")
    private String fdDescription;
    @Size(max = 255)
    @Column(name = "FD_INSTRUCTION")
    private String fdInstruction;
    @Size(max = 255)
    @Column(name = "FD_NOTES")
    private String fdNotes;
    @Size(max = 50)
    @Column(name = "TEST_CATEGORY")
    private String testCategory;
    @Size(max = 50)
    @Column(name = "TEST_TYPE")
    private String testType;
    @Size(max = 255)
    @Column(name = "LAB_INSTRUCTION")
    private String labInstruction;
    @Size(max = 255)
    @Column(name = "LAB_NOTES")
    private String labNotes;
    @Size(max = 50)
    @Column(name = "TECH_NAME")
    private String techName;
    @Size(max = 255)
    @Column(name = "TECH_DIRECTIONS")
    private String techDirections;
    @Size(max = 255)
    @Column(name = "TECH_NOTES")
    private String techNotes;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "DUE_DATE_TMP")
    private String dueDateTmp;
    @Size(max = 4000)
    @Column(name = "SERVICE_DATE_TMP")
    private String serviceDateTmp;
    @Size(max = 3)
    @Column(name = "CANCELLED")
    private String cancelled;
    @Size(max = 4000)
    @Column(name = "CERTIFICATION")
    private String certification;
    @Size(max = 50)
    @Column(name = "DEPART_SITE_TIME")
    private String departSiteTime;
    @Size(max = 50)
    @Column(name = "ARRIVE_SITE_TIME")
    private String arriveSiteTime;
    @Size(max = 4000)
    @Column(name = "CONTACT_TELEPHONE")
    private String contactTelephone;
    @Column(name = "WO_SHORT")
    private BigInteger woShort;
    @Size(max = 4000)
    @Column(name = "WO_LONG")
    private String woLong;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "CONTACTREF_ID")
    private BigInteger contactRefId;
    @Size(max = 255)
    @Column(name = "WOTOKEN")
    private String woToken;
    @Column(name = "WO_COMPLETED", insertable = false)
    private Character woCompleted;
    @Size(max = 255)
    @Column(name = "TRAVEL_TIME")
    private String travelTime;
    @Column(name = "MATERIAL_USE_ID")
    private BigInteger materialUseId;

    public GlobWorkorder() {
    }

    public GlobWorkorder(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getWoNo() {
        return woNo;
    }

    public void setWoNo(String woNo) {
        this.woNo = woNo;
    }

    public BigInteger getActivityId() {
        return activityId;
    }

    public String getWoToken() {
        return woToken;
    }

    public void setWoToken(String woToken) {
        this.woToken = woToken;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigInteger getContactRefId() {
        return contactRefId;
    }

    public void setContactRefId(BigInteger contactRefId) {
        this.contactRefId = contactRefId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDepartLabTime() {
        return departLabTime;
    }

    public void setDepartLabTime(String departLabTime) {
        this.departLabTime = departLabTime;
    }

    public String getArriveLabTime() {
        return arriveLabTime;
    }

    public void setArriveLabTime(String arriveLabTime) {
        this.arriveLabTime = arriveLabTime;
    }

    public String getEngServiceType() {
        return engServiceType;
    }

    public void setEngServiceType(String engServiceType) {
        this.engServiceType = engServiceType;
    }

    public String getEngInstruction() {
        return engInstruction;
    }

    public void setEngInstruction(String engInstruction) {
        this.engInstruction = engInstruction;
    }

    public String getEngNotes() {
        return engNotes;
    }

    public void setEngNotes(String engNotes) {
        this.engNotes = engNotes;
    }

    public String getFdService() {
        return fdService;
    }

    public void setFdService(String fdService) {
        this.fdService = fdService;
    }

    public String getFdDescription() {
        return fdDescription;
    }

    public void setFdDescription(String fdDescription) {
        this.fdDescription = fdDescription;
    }

    public String getFdInstruction() {
        return fdInstruction;
    }

    public void setFdInstruction(String fdInstruction) {
        this.fdInstruction = fdInstruction;
    }

    public String getFdNotes() {
        return fdNotes;
    }

    public void setFdNotes(String fdNotes) {
        this.fdNotes = fdNotes;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getLabInstruction() {
        return labInstruction;
    }

    public void setLabInstruction(String labInstruction) {
        this.labInstruction = labInstruction;
    }

    public String getLabNotes() {
        return labNotes;
    }

    public void setLabNotes(String labNotes) {
        this.labNotes = labNotes;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getTechDirections() {
        return techDirections;
    }

    public void setTechDirections(String techDirections) {
        this.techDirections = techDirections;
    }

    public String getTechNotes() {
        return techNotes;
    }

    public void setTechNotes(String techNotes) {
        this.techNotes = techNotes;
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

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getDueDateTmp() {
        return dueDateTmp;
    }

    public void setDueDateTmp(String dueDateTmp) {
        this.dueDateTmp = dueDateTmp;
    }

    public String getServiceDateTmp() {
        return serviceDateTmp;
    }

    public void setServiceDateTmp(String serviceDateTmp) {
        this.serviceDateTmp = serviceDateTmp;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getCertification() {
        if(certification == null || certification.isEmpty()) {
            return "N/A";
        }
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getDepartSiteTime() {
        return departSiteTime;
    }

    public void setDepartSiteTime(String departSiteTime) {
        this.departSiteTime = departSiteTime;
    }

    public String getArriveSiteTime() {
        return arriveSiteTime;
    }

    public void setArriveSiteTime(String arriveSiteTime) {
        this.arriveSiteTime = arriveSiteTime;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public BigInteger getWoShort() {
        return woShort;
    }

    public void setWoShort(BigInteger woShort) {
        this.woShort = woShort;
    }

    public String getWoLong() {
        return woLong;
    }

    public void setWoLong(String woLong) {
        this.woLong = woLong;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Character getWoCompleted() {
        return woCompleted;
    }

    public void setWoCompleted(Character woCompleted) {
        this.woCompleted = woCompleted;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public BigInteger getMaterialUseId() {
        return materialUseId;
    }

    public void setMaterialUseId(BigInteger materialUseId) {
        this.materialUseId = materialUseId;
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
        if (!(object instanceof GlobWorkorder)) {
            return false;
        }
        GlobWorkorder other = (GlobWorkorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobWorkorder[ id=" + id + " ]";
    }

    @Override
    public GlobWorkorder clone() {
        try {
            return (GlobWorkorder) super.clone();
        } catch (CloneNotSupportedException e) {
            return new GlobWorkorder(this.getId());
        }
    }    
}
