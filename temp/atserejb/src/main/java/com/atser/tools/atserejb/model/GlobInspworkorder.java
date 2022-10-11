/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobInspworkorder.findByWonumber", query = "SELECT g FROM GlobInspworkorder g WHERE g.wonumber = :wonumber")
    , @NamedQuery(name = "GlobInspworkorder.findByServiceDate", query = "SELECT g FROM GlobInspworkorder g WHERE g.serviceDate = :serviceDate")
    , @NamedQuery(name = "GlobInspworkorder.findByInspector", query = "SELECT g FROM GlobInspworkorder g WHERE g.inspector = :inspector")
    , @NamedQuery(name = "GlobInspworkorder.findByTimeatoffice", query = "SELECT g FROM GlobInspworkorder g WHERE g.timeatoffice = :timeatoffice")
    , @NamedQuery(name = "GlobInspworkorder.findByTimeatsite", query = "SELECT g FROM GlobInspworkorder g WHERE g.timeatsite = :timeatsite")
    , @NamedQuery(name = "GlobInspworkorder.findByHours", query = "SELECT g FROM GlobInspworkorder g WHERE g.hours = :hours")
    , @NamedQuery(name = "GlobInspworkorder.findByContactrefid", query = "SELECT g FROM GlobInspworkorder g WHERE g.contactrefid = :contactrefid")
    , @NamedQuery(name = "GlobInspworkorder.findByContactPerson", query = "SELECT g FROM GlobInspworkorder g WHERE g.contactPerson = :contactPerson")
    , @NamedQuery(name = "GlobInspworkorder.findByContactTelephone", query = "SELECT g FROM GlobInspworkorder g WHERE g.contactTelephone = :contactTelephone")
    , @NamedQuery(name = "GlobInspworkorder.findByPaperworkReceived", query = "SELECT g FROM GlobInspworkorder g WHERE g.paperworkReceived = :paperworkReceived")
    , @NamedQuery(name = "GlobInspworkorder.findByAssignment", query = "SELECT g FROM GlobInspworkorder g WHERE g.assignment = :assignment")
    , @NamedQuery(name = "GlobInspworkorder.findByCancelled", query = "SELECT g FROM GlobInspworkorder g WHERE g.cancelled = :cancelled")
    , @NamedQuery(name = "GlobInspworkorder.findByActivityId", query = "SELECT g FROM GlobInspworkorder g WHERE g.activityId = :activityId")
    , @NamedQuery(name = "GlobInspworkorder.findByInfoId", query = "SELECT g FROM GlobInspworkorder g WHERE g.infoId = :infoId")
    , @NamedQuery(name = "GlobInspworkorder.findByInspRefid", query = "SELECT g FROM GlobInspworkorder g WHERE g.inspRefid = :inspRefid")
    , @NamedQuery(name = "GlobInspworkorder.findByInspectionFuncid", query = "SELECT g FROM GlobInspworkorder g WHERE g.inspectionFuncid = :inspectionFuncid")
    , @NamedQuery(name = "GlobInspworkorder.findByDecisionflag", query = "SELECT g FROM GlobInspworkorder g WHERE g.decisionflag = :decisionflag")
    , @NamedQuery(name = "GlobInspworkorder.findByProjectId", query = "SELECT g FROM GlobInspworkorder g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobInspworkorder.findByLastMod", query = "SELECT g FROM GlobInspworkorder g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobInspworkorder.findByLastModBy", query = "SELECT g FROM GlobInspworkorder g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobInspworkorder.findByLastModIp", query = "SELECT g FROM GlobInspworkorder g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobInspworkorder.findByCreateDate", query = "SELECT g FROM GlobInspworkorder g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobInspworkorder.findByCreateBy", query = "SELECT g FROM GlobInspworkorder g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobInspworkorder.findByCreateByIp", query = "SELECT g FROM GlobInspworkorder g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobInspworkorder.findByActive", query = "SELECT g FROM GlobInspworkorder g WHERE g.active = :active")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_INSPWORKORDER", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobInspworkorder.findAll", query = "SELECT g FROM GlobInspworkorder g"),
    @NamedQuery(name = "GlobInspworkorder.findById", query = "SELECT g FROM GlobInspworkorder g WHERE g.id = :id"),
    @NamedQuery(name = "GlobInspworkorder.findByProjectIDAndNotCancelled", query = "SELECT g FROM GlobInspworkorder g WHERE g.projectId = :projectId AND g.cancelled = 'No'"),
    @NamedQuery(name = "GlobInspworkorder.findByWOIDAndNotCancelled", query = "SELECT g FROM GlobInspworkorder g WHERE g.id = :id AND g.cancelled = 'No'"),
    @NamedQuery(name = "GlobInspworkorder.getDistinctByActivityId", query = "SELECT DISTINCT g.activityId FROM GlobInspworkorder g WHERE g.activityId IS NOT NULL AND g.cancelled = 'No' AND g.projectId = :projectId"),
    @NamedQuery(name = "GlobInspworkorder.findByInspDispatchID", query = "SELECT g FROM GlobInspworkorder g WHERE g.inspdispatchid.persistenceid = :id"),
    @NamedQuery(name = "GlobInspworkorder.findByWotoken", query = "SELECT g FROM GlobInspworkorder g WHERE g.wotoken = :wotoken"),
    @NamedQuery(name = "GlobInspworkorder.findByVersion", query = "SELECT g FROM GlobInspworkorder g WHERE g.version = :version")})
public class GlobInspworkorder implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_INSPWORKORDER_SEQ", sequenceName = "GLOB_INSPWORKORDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_INSPWORKORDER_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "WONUMBER")
    private String wonumber;
    @Column(name = "SERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDate;
    @Lob
    @Column(name = "SERVICES_REQUESTED")
    private String servicesRequested;
    @Size(max = 1024)
    @Column(name = "INSPECTOR")
    private String inspector;
    @Size(max = 100)
    @Column(name = "TIMEATOFFICE")
    private String timeatoffice;
    @Size(max = 100)
    @Column(name = "TIMEATSITE")
    private String timeatsite;
    @Column(name = "HOURS")
    private BigDecimal hours;
    @Column(name = "CONTACTREFID")
    private BigInteger contactrefid;
    @Size(max = 512)
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Size(max = 50)
    @Column(name = "CONTACT_TELEPHONE")
    private String contactTelephone;
    @Lob
    @Column(name = "SPEC_INSTR")
    private String specInstr;
    @Lob
    @Column(name = "INSP_NOTES")
    private String inspNotes;
    @Column(name = "PAPERWORK_RECEIVED")
    private Character paperworkReceived;
    @Size(max = 255)
    @Column(name = "ASSIGNMENT")
    private String assignment;
    @Size(max = 20)
    @Column(name = "CANCELLED")
    private String cancelled;
    @Column(name = "ACTIVITY_ID")
    private BigInteger activityId;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "INSP_REFID")
    private BigInteger inspRefid;
    @Column(name = "INSPECTION_FUNCID")
    private BigInteger inspectionFuncid;
    @Column(name = "DECISIONFLAG")
    private BigInteger decisionflag;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "WOTOKEN")
    private String wotoken;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 512)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 512)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "INSPDISPATCHID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne(optional = false)
    private Bpminspectordispatchbo inspdispatchid;

    public GlobInspworkorder() {
    }

    public GlobInspworkorder(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getWonumber() {
        return wonumber;
    }

    public void setWonumber(String wonumber) {
        this.wonumber = wonumber;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(String servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getTimeatoffice() {
        return timeatoffice;
    }

    public void setTimeatoffice(String timeatoffice) {
        this.timeatoffice = timeatoffice;
    }

    public String getTimeatsite() {
        return timeatsite;
    }

    public void setTimeatsite(String timeatsite) {
        this.timeatsite = timeatsite;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigInteger getContactrefid() {
        return contactrefid;
    }

    public void setContactrefid(BigInteger contactrefid) {
        this.contactrefid = contactrefid;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getSpecInstr() {
        return specInstr;
    }

    public void setSpecInstr(String specInstr) {
        this.specInstr = specInstr;
    }

    public String getInspNotes() {
        return inspNotes;
    }

    public void setInspNotes(String inspNotes) {
        this.inspNotes = inspNotes;
    }

    public Character getPaperworkReceived() {
        return paperworkReceived;
    }

    public void setPaperworkReceived(Character paperworkReceived) {
        this.paperworkReceived = paperworkReceived;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public BigInteger getInspRefid() {
        return inspRefid;
    }

    public void setInspRefid(BigInteger inspRefid) {
        this.inspRefid = inspRefid;
    }

    public BigInteger getInspectionFuncid() {
        return inspectionFuncid;
    }

    public void setInspectionFuncid(BigInteger inspectionFuncid) {
        this.inspectionFuncid = inspectionFuncid;
    }

    public BigInteger getDecisionflag() {
        return decisionflag;
    }

    public void setDecisionflag(BigInteger decisionflag) {
        this.decisionflag = decisionflag;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getWotoken() {
        return wotoken;
    }

    public void setWotoken(String wotoken) {
        this.wotoken = wotoken;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public Bpminspectordispatchbo getInspdispatchid() {
        return inspdispatchid;
    }

    public void setInspdispatchid(Bpminspectordispatchbo inspdispatchid) {
        this.inspdispatchid = inspdispatchid;
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
        if (!(object instanceof GlobInspworkorder)) {
            return false;
        }
        GlobInspworkorder other = (GlobInspworkorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobInspworkorder[ id=" + id + " ]";
    }

}
