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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "BPM_TASK_MATRIX", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE BPM_TASK_MATRIX SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpmTaskMatrix.findAll", query = "SELECT q FROM BpmTaskMatrix q"),
    @NamedQuery(name = "BpmTaskMatrix.findById", query = "SELECT q FROM BpmTaskMatrix q WHERE q.id = :id")})
public class BpmTaskMatrix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "BPM_TASK_MATRIX_SEQ", sequenceName = "BPM_TASK_MATRIX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPM_TASK_MATRIX_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "ORG_TASK_ID")
    private BigDecimal orgTaskId;

    @Column(name = "TRG_TASK_ID")
    private BigDecimal trgTaskId;

    @Column(name = "PROCESS_ID")
    private BigDecimal processId;

    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;

    @Size(max = 255)
    @Column(name = "CONDITION")
    private String condition;

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

    public BpmTaskMatrix() {
    }

    public BpmTaskMatrix(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getOrgTaskId() {
        return orgTaskId;
    }

    public void setOrgTaskId(BigDecimal orgTaskId) {
        this.orgTaskId = orgTaskId;
    }

    public BigDecimal getTrgTaskId() {
        return trgTaskId;
    }

    public void setTrgTaskId(BigDecimal trgTaskId) {
        this.trgTaskId = trgTaskId;
    }

    public BigDecimal getProcessId() {
        return processId;
    }

    public void setProcessId(BigDecimal processId) {
        this.processId = processId;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
