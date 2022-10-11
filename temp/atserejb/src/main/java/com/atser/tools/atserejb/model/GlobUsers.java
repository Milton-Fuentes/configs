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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Where;

/*
    , @NamedQuery(name = "GlobUsers.findByUserid", query = "SELECT g FROM GlobUsers g WHERE g.userid = :userid")
    , @NamedQuery(name = "GlobUsers.findByPass", query = "SELECT g FROM GlobUsers g WHERE g.pass = :pass")
    , @NamedQuery(name = "GlobUsers.findByStation", query = "SELECT g FROM GlobUsers g WHERE g.station = :station")
    , @NamedQuery(name = "GlobUsers.findByUsergroup", query = "SELECT g FROM GlobUsers g WHERE g.usergroup = :usergroup")
    , @NamedQuery(name = "GlobUsers.findByActive", query = "SELECT g FROM GlobUsers g WHERE g.active = :active")
    , @NamedQuery(name = "GlobUsers.findByLastMod", query = "SELECT g FROM GlobUsers g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobUsers.findByLastModBy", query = "SELECT g FROM GlobUsers g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobUsers.findByLastModIp", query = "SELECT g FROM GlobUsers g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobUsers.findByTemp", query = "SELECT g FROM GlobUsers g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobUsers.findByCreateBy", query = "SELECT g FROM GlobUsers g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobUsers.findByCreateByIp", query = "SELECT g FROM GlobUsers g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobUsers.findByCreateDate", query = "SELECT g FROM GlobUsers g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobUsers.findByInactiveSince", query = "SELECT g FROM GlobUsers g WHERE g.inactiveSince = :inactiveSince")
    , @NamedQuery(name = "GlobUsers.findByDefaultProfile", query = "SELECT g FROM GlobUsers g WHERE g.defaultProfile = :defaultProfile")
    , @NamedQuery(name = "GlobUsers.findByPersoninfoId", query = "SELECT g FROM GlobUsers g WHERE g.personinfoId = :personinfoId")
    , @NamedQuery(name = "GlobUsers.findByPassBak", query = "SELECT g FROM GlobUsers g WHERE g.passBak = :passBak")
    , @NamedQuery(name = "GlobUsers.findByPassChangedOn", query = "SELECT g FROM GlobUsers g WHERE g.passChangedOn = :passChangedOn")
    , @NamedQuery(name = "GlobUsers.findByPassValidDays", query = "SELECT g FROM GlobUsers g WHERE g.passValidDays = :passValidDays")
    , @NamedQuery(name = "GlobUsers.findByDefaultProject", query = "SELECT g FROM GlobUsers g WHERE g.defaultProject = :defaultProject")
    , @NamedQuery(name = "GlobUsers.findByUserFilter", query = "SELECT g FROM GlobUsers g WHERE g.userFilter = :userFilter")
    , @NamedQuery(name = "GlobUsers.findByBookmark", query = "SELECT g FROM GlobUsers g WHERE g.bookmark = :bookmark")
    , @NamedQuery(name = "GlobUsers.findByResetPass", query = "SELECT g FROM GlobUsers g WHERE g.resetPass = :resetPass")
    , @NamedQuery(name = "GlobUsers.findByCreateDateTmp", query = "SELECT g FROM GlobUsers g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobUsers.findByTempTmp", query = "SELECT g FROM GlobUsers g WHERE g.tempTmp = :tempTmp")
    , @NamedQuery(name = "GlobUsers.findByLastModTmp", query = "SELECT g FROM GlobUsers g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobUsers.findByEmailSent", query = "SELECT g FROM GlobUsers g WHERE g.emailSent = :emailSent")
    , @NamedQuery(name = "GlobUsers.findByStatus", query = "SELECT g FROM GlobUsers g WHERE g.status = :status")
    , @NamedQuery(name = "GlobUsers.findByLastAction", query = "SELECT g FROM GlobUsers g WHERE g.lastAction = :lastAction")
    , @NamedQuery(name = "GlobUsers.findByLocalIp", query = "SELECT g FROM GlobUsers g WHERE g.localIp = :localIp")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_USERS", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobUsers.findAll", query = "SELECT g FROM GlobUsers g")
    , @NamedQuery(name = "GlobUsers.findById", query = "SELECT g FROM GlobUsers g WHERE g.id = :id")
    , @NamedQuery(name = "GlobUsers.findBySSO", query = "SELECT g FROM GlobUsers g WHERE g.userid = :userid AND g.active = :active")})
public class GlobUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_users_id_seq", sequenceName = "glob_users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_users_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERID")
    private String userid;
    @Size(max = 50)
    @Column(name = "PASS")
    private String pass;
    @Size(max = 50)
    @Column(name = "STATION", insertable = false)
    private String station;
    @Size(max = 50)
    @Column(name = "USERGROUP")
    private String usergroup;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "TEMP", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "INACTIVE_SINCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inactiveSince;
    @Column(name = "DEFAULT_PROFILE")
    private BigInteger defaultProfile;
    @JoinColumn(name = "PERSONINFO_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private CmPersoninfo personinfoId;
    @Size(max = 50)
    @Column(name = "PASS_BAK")
    private String passBak;
    @Column(name = "PASS_CHANGED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passChangedOn;
    @Column(name = "PASS_VALID_DAYS", insertable = false)
    private Short passValidDays;
    @Column(name = "DEFAULT_PROJECT")
    private BigInteger defaultProject;
    @Size(max = 5)
    @Column(name = "USER_FILTER", insertable = false)
    private String userFilter;
    @Size(max = 4000)
    @Column(name = "BOOKMARK", insertable = false, updatable = false)
    private String bookmark;
    @Column(name = "RESET_PASS", insertable = false)
    private Character resetPass;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 20)
    @Column(name = "EMAIL_SENT")
    private String emailSent;
    @Column(name = "STATUS", insertable = false)
    private Short status;
    @Column(name = "LAST_ACTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAction;
    @Size(max = 20)
    @Column(name = "LOCAL_IP")
    private String localIp;
    @Column(name = "BAD_AUTH_ATTEMPTS")
    private BigInteger badAuthAttempts;
    @Size(max = 1)
    @Column(name = "LOCKED")
    private String locked;
    @Column(name = "LOCKED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedTime;
    @JoinColumn(name = "CONTACTID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private GlobContact contactid;
    @ManyToMany(mappedBy = "globUsersList", fetch = FetchType.LAZY)
    private List<CmEmGroup> cmEmGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserid")
    private List<CmEmEmail> cmEmEmailList;
    @OneToMany(mappedBy = "createdBy")
    private List<GlobCorrespd> globCorrespdList;
    @OneToMany(mappedBy = "proccesedBy")
    private List<GlobCorrespd> globCorrespdList1;
    @OneToMany(mappedBy = "approvedBy")
    private List<GlobCorrespd> globCorrespdList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriberId", fetch = FetchType.LAZY)
    private List<GlobFolderSubscribeAll> globFolderSubscribeAllList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriberId", fetch = FetchType.LAZY)
    private List<GlobFolderSubscribe> globFolderSubscribeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriberId", fetch = FetchType.LAZY)
    private List<GlobFileSubscribe> globFileSubscribeList;

    public GlobUsers() {
    }

    public GlobUsers(BigDecimal id) {
        this.id = id;
    }

    public GlobUsers(BigDecimal id, String userid) {
        this.id = id;
        this.userid = userid;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getInactiveSince() {
        return inactiveSince;
    }

    public void setInactiveSince(Date inactiveSince) {
        this.inactiveSince = inactiveSince;
    }

    public BigInteger getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(BigInteger defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public CmPersoninfo getPersoninfoId() {
        return personinfoId;
    }

    public void setPersoninfoId(CmPersoninfo personinfoId) {
        this.personinfoId = personinfoId;
    }

    public String getPassBak() {
        return passBak;
    }

    public void setPassBak(String passBak) {
        this.passBak = passBak;
    }

    public Date getPassChangedOn() {
        return passChangedOn;
    }

    public void setPassChangedOn(Date passChangedOn) {
        this.passChangedOn = passChangedOn;
    }

    public Short getPassValidDays() {
        return passValidDays;
    }

    public void setPassValidDays(Short passValidDays) {
        this.passValidDays = passValidDays;
    }

    public BigInteger getDefaultProject() {
        return defaultProject;
    }

    public void setDefaultProject(BigInteger defaultProject) {
        this.defaultProject = defaultProject;
    }

    public String getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public Character getResetPass() {
        return resetPass;
    }

    public void setResetPass(Character resetPass) {
        this.resetPass = resetPass;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(String emailSent) {
        this.emailSent = emailSent;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getLastAction() {
        return lastAction;
    }

    public void setLastAction(Date lastAction) {
        this.lastAction = lastAction;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public BigInteger getBadAuthAttempts() {
        return badAuthAttempts;
    }

    public void setBadAuthAttempts(BigInteger badAuthAttempts) {
        this.badAuthAttempts = badAuthAttempts;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Date getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }

    @XmlTransient
    public List<CmEmGroup> getCmEmGroupList() {
        return cmEmGroupList;
    }

    public void setCmEmGroupList(List<CmEmGroup> cmEmGroupList) {
        this.cmEmGroupList = cmEmGroupList;
    }

    @XmlTransient
    public List<CmEmEmail> getCmEmEmailList() {
        return cmEmEmailList;
    }

    public void setCmEmEmailList(List<CmEmEmail> cmEmEmailList) {
        this.cmEmEmailList = cmEmEmailList;
    }

    public GlobContact getContactid() {
        return contactid;
    }

    public void setContactid(GlobContact contactid) {
        this.contactid = contactid;
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
        if (!(object instanceof GlobUsers)) {
            return false;
        }
        GlobUsers other = (GlobUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobUsers[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobFolderSubscribeAll> getGlobFolderSubscribeAllList() {
        return globFolderSubscribeAllList;
    }

    public void setGlobFolderSubscribeAllList(List<GlobFolderSubscribeAll> globFolderSubscribeAllList) {
        this.globFolderSubscribeAllList = globFolderSubscribeAllList;
    }

    @XmlTransient
    public List<GlobFolderSubscribe> getGlobFolderSubscribeList() {
        return globFolderSubscribeList;
    }

    public void setGlobFolderSubscribeList(List<GlobFolderSubscribe> globFolderSubscribeList) {
        this.globFolderSubscribeList = globFolderSubscribeList;
    }

    @XmlTransient
    public List<GlobFileSubscribe> getGlobFileSubscribeList() {
        return globFileSubscribeList;
    }

    public void setGlobFileSubscribeList(List<GlobFileSubscribe> globFileSubscribeList) {
        this.globFileSubscribeList = globFileSubscribeList;
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList() {
        return globCorrespdList;
    }

    public void setGlobCorrespdList(List<GlobCorrespd> globCorrespdList) {
        this.globCorrespdList = globCorrespdList;
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList1() {
        return globCorrespdList1;
    }

    public void setGlobCorrespdList1(List<GlobCorrespd> globCorrespdList1) {
        this.globCorrespdList1 = globCorrespdList1;
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList2() {
        return globCorrespdList2;
    }

    public void setGlobCorrespdList2(List<GlobCorrespd> globCorrespdList2) {
        this.globCorrespdList2 = globCorrespdList2;
    }

}
