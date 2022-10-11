/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeUSDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeUSSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author dperez
 */
@Entity
@Immutable
@Table(name = "VW_BPM_TASK_INSTANCE_BO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBpmTaskInstanceBo.findById", query = "SELECT v FROM VwBpmTaskInstanceBo v WHERE v.id = :id"),
    @NamedQuery(name = "VwBpmTaskInstanceBo.findAll", query = "SELECT v FROM VwBpmTaskInstanceBo v")})
public class VwBpmTaskInstanceBo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "REF_ID")
    private BigDecimal refId;

    @Column(name = "PROJECT_ID")
    private BigDecimal projectId;

    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;

    @Size(max = 255)
    @Column(name = "MODEL_NUMBER")
    private String modelNumber;

    @Size(max = 255)
    @Column(name = "ROLE")
    private String role;

    @Size(max = 255)
    @Column(name = "TASK_NAME")
    private String taskName;

    @Size(max = 255)
    @Column(name = "USER_NAME")
    private String userName;

    @Size(max = 50)
    @Column(name = "STATE")
    private String state;

    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;

    @Size(max = 50)
    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

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

    @Size(max = 10)
    @Column(name = "ACTIVE", insertable = false)
    private String active;

    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false)
    private String deleted;

    @JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private BpmTask taskId;

    @JoinColumn(name = "PROCESS_INSTANCE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private BpmProcessInstance processInstanceId;

    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobUsers userId;

    public VwBpmTaskInstanceBo() {
    }

    public VwBpmTaskInstanceBo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getRefId() {
        return refId;
    }

    public void setRefId(BigDecimal refId) {
        this.refId = refId;
    }

    public BigDecimal getProjectId() {
        return projectId;
    }

    public void setProjectId(BigDecimal projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @JsonSerialize(using = JsonDateTimeUSSerializer.class)
    @JsonDeserialize(using = JsonDateTimeUSDeserialize.class)
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

    @JsonSerialize(using = JsonDateTimeUSSerializer.class)
    @JsonDeserialize(using = JsonDateTimeUSDeserialize.class)
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

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }
    
    public BpmTask getTaskId() {
        return taskId;
    }

    public void setTaskId(BpmTask taskId) {
        this.taskId = taskId;
    }

    public BpmProcessInstance getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(BpmProcessInstance processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public GlobUsers getUserId() {
        return userId;
    }

    public void setUserId(GlobUsers userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.VwBpmTaskInstanceBo[ id=" + id + " ]";
    }

}
