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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "CmEmEmail.findByRespEmailId", query = "SELECT c FROM CmEmEmail c WHERE c.respEmailId = :respEmailId")
    , @NamedQuery(name = "CmEmEmail.findByEmailNo", query = "SELECT c FROM CmEmEmail c WHERE c.emailNo = :emailNo")
    , @NamedQuery(name = "CmEmEmail.findByEmailSubject", query = "SELECT c FROM CmEmEmail c WHERE c.emailSubject = :emailSubject")
    , @NamedQuery(name = "CmEmEmail.findByEmailBody", query = "SELECT c FROM CmEmEmail c WHERE c.emailBody = :emailBody")
    , @NamedQuery(name = "CmEmEmail.findByRequiredAction", query = "SELECT c FROM CmEmEmail c WHERE c.requiredAction = :requiredAction")
    , @NamedQuery(name = "CmEmEmail.findByActionDeadline", query = "SELECT c FROM CmEmEmail c WHERE c.actionDeadline = :actionDeadline")
    , @NamedQuery(name = "CmEmEmail.findByEmailDate", query = "SELECT c FROM CmEmEmail c WHERE c.emailDate = :emailDate")
    , @NamedQuery(name = "CmEmEmail.findByStatus", query = "SELECT c FROM CmEmEmail c WHERE c.status = :status")
    , @NamedQuery(name = "CmEmEmail.findByContentType", query = "SELECT c FROM CmEmEmail c WHERE c.contentType = :contentType")
    , @NamedQuery(name = "CmEmEmail.findByLastMod", query = "SELECT c FROM CmEmEmail c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmEmEmail.findByLastModBy", query = "SELECT c FROM CmEmEmail c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmEmEmail.findByLastModIp", query = "SELECT c FROM CmEmEmail c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmEmEmail.findByCreateBy", query = "SELECT c FROM CmEmEmail c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmEmEmail.findByCreateByIp", query = "SELECT c FROM CmEmEmail c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmEmEmail.findByCreateDate", query = "SELECT c FROM CmEmEmail c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CmEmEmail.findByTemp", query = "SELECT c FROM CmEmEmail c WHERE c.temp = :temp")
    , @NamedQuery(name = "CmEmEmail.findByVersion", query = "SELECT c FROM CmEmEmail c WHERE c.version = :version")
    , @NamedQuery(name = "CmEmEmail.findByEmpriority", query = "SELECT c FROM CmEmEmail c WHERE c.empriority = :empriority")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_EM_EMAIL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmEmEmail.findAll", query = "SELECT c FROM CmEmEmail c")
    , @NamedQuery(name = "CmEmEmail.findById", query = "SELECT c FROM CmEmEmail c WHERE c.id = :id")})
public class CmEmEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RESP_EMAIL_ID")
    private BigInteger respEmailId;
    @Size(max = 50)
    @Column(name = "EMAIL_NO")
    private String emailNo;
    @Size(max = 200)
    @Column(name = "EMAIL_SUBJECT")
    private String emailSubject;
    @Size(max = 4000)
    @Column(name = "EMAIL_BODY")
    private String emailBody;
    @Size(max = 50)
    @Column(name = "REQUIRED_ACTION")
    private String requiredAction;
    @Column(name = "ACTION_DEADLINE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDeadline;
    @Column(name = "EMAIL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailDate;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 100)
    @Column(name = "CONTENT_TYPE")
    private String contentType;
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
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "TEMP", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "EMPRIORITY")
    private Short empriority;
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobProject projectId;
    @JoinColumn(name = "FROM_USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobUsers fromUserid;

    public CmEmEmail() {
    }

    public CmEmEmail(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRespEmailId() {
        return respEmailId;
    }

    public void setRespEmailId(BigInteger respEmailId) {
        this.respEmailId = respEmailId;
    }

    public String getEmailNo() {
        return emailNo;
    }

    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getRequiredAction() {
        return requiredAction;
    }

    public void setRequiredAction(String requiredAction) {
        this.requiredAction = requiredAction;
    }

    public Date getActionDeadline() {
        return actionDeadline;
    }

    public void setActionDeadline(Date actionDeadline) {
        this.actionDeadline = actionDeadline;
    }

    public Date getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(Date emailDate) {
        this.emailDate = emailDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Short getEmpriority() {
        return empriority;
    }

    public void setEmpriority(Short empriority) {
        this.empriority = empriority;
    }

    public GlobProject getProjectId() {
        return projectId;
    }

    public void setProjectId(GlobProject projectId) {
        this.projectId = projectId;
    }

    public GlobUsers getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(GlobUsers fromUserid) {
        this.fromUserid = fromUserid;
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
        if (!(object instanceof CmEmEmail)) {
            return false;
        }
        CmEmEmail other = (CmEmEmail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmEmEmail[ id=" + id + " ]";
    }
    
}
