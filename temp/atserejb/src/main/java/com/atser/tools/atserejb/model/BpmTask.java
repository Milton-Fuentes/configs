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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author dperez
 */
@Entity
@Table(name = "BPM_TASK", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE BPM_TASK SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpmTask.findAll", query = "SELECT q FROM BpmTask q"),
    @NamedQuery(name = "BpmTask.findById", query = "SELECT q FROM BpmTask q WHERE q.id = :id")})
public class BpmTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "BPM_TASK_SEQ", sequenceName = "BPM_TASK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPM_TASK_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    @Size(max = 50)
    @Column(name = "CODE")
    private String code;

    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    @Size(max = 255)
    @Column(name = "REQUIRED_RESP_DAYS")
    private Integer requiredRespDays;

    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;

    @Size(max = 50)
    @Column(name = "PAGE_URL")
    private String pageUrl;

    @Column(name = "IS_MULTI_USER_TASK")
    private Short isMultiUserTask;

    @Size(max = 255)
    @Column(name = "MULTI_USER_TASK_SRC")
    private String multiUserTaskSrc;

    @Size(max = 255)
    @Column(name = "TASK_NOTIFICATION_NEW")
    private Short taskNotificationNew;

    @Size(max = 255)
    @Column(name = "TASK_NOTIFICATION_OTHER")
    private Short taskNotificationOther;

    @Size(max = 255)
    @Column(name = "TASK_NTF_TMPL")
    private String taskNtfTmpl;

    @Size(max = 255)
    @Column(name = "TASK_NTF_TMPL_CODE")
    private String taskNtfTmplCode;

    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BpmProcess processId;

    @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobRoles actorId;

    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false)
    private String deleted;

    @Size(max = 10)
    @Column(name = "ACTIVE", insertable = false)
    private String active;

    @Column(name = "CREATED", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;

    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;

    @Column(name = "LAST_MOD", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;

    @Size(max = 150)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;

    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_BY_IP")
    private String lastModByIp;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskId")
    private List<BpmCondition> bpmConditionList;

    public BpmTask() {
    }

    public BpmTask(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getRequiredRespDays() {
        return requiredRespDays;
    }

    public void setRequiredRespDays(Integer requiredRespDays) {
        this.requiredRespDays = requiredRespDays;
    }

    public Short getTaskNotificationNew() {
        return taskNotificationNew;
    }

    public void setTaskNotificationNew(Short taskNotificationNew) {
        this.taskNotificationNew = taskNotificationNew;
    }

    public Short getTaskNotificationOther() {
        return taskNotificationOther;
    }

    public void setTaskNotificationOther(Short taskNotificationOther) {
        this.taskNotificationOther = taskNotificationOther;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Short getIsMultiUserTask() {
        return isMultiUserTask;
    }

    public void setIsMultiUserTask(Short isMultiUserTask) {
        this.isMultiUserTask = isMultiUserTask;
    }

    public String getMultiUserTaskSrc() {
        return multiUserTaskSrc;
    }

    public void setMultiUserTaskSrc(String multiUserTaskSrc) {
        this.multiUserTaskSrc = multiUserTaskSrc;
    }

    public String getTaskNtfTmpl() {
        return taskNtfTmpl;
    }

    public void setTaskNtfTmpl(String taskNtfTmpl) {
        this.taskNtfTmpl = taskNtfTmpl;
    }

    public String getTaskNtfTmplCode() {
        return taskNtfTmplCode;
    }

    public void setTaskNtfTmplCode(String taskNtfTmplCode) {
        this.taskNtfTmplCode = taskNtfTmplCode;
    }

    public BpmProcess getProcessId() {
        return processId;
    }

    public void setProcessId(BpmProcess processId) {
        this.processId = processId;
    }

    public GlobRoles getActorId() {
        return actorId;
    }

    public void setActorId(GlobRoles actorId) {
        this.actorId = actorId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModByIp() {
        return lastModByIp;
    }

    public void setLastModByIp(String lastModByIp) {
        this.lastModByIp = lastModByIp;
    }

    public List<BpmCondition> getBpmConditionList() {
        return bpmConditionList;
    }

    public void setBpmConditionList(List<BpmCondition> bpmConditionList) {
        this.bpmConditionList = bpmConditionList;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.BpmTask[ id=" + id + " ]";
    }
}
