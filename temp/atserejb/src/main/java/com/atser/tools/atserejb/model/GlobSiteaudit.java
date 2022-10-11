/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dperez
 */
@Entity
@Table(name = "GLOB_SITEAUDIT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSiteaudit.findAll", query = "SELECT q FROM GlobSiteaudit q"),
    @NamedQuery(name = "GlobSiteaudit.findById", query = "SELECT q FROM GlobSiteaudit q WHERE q.id = :id")})
public class GlobSiteaudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "GLOB_SITEAUDIT_ID_SEQ", sequenceName = "GLOB_SITEAUDIT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SITEAUDIT_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobUsers userId;

    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;

    @Column(name = "ACTION_TIME", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionTime;

    @Size(max = 20)
    @Column(name = "ACTED_ON_TYPE")
    private String actedOnType;

    @Column(name = "ACTED_ON_ID")
    private BigInteger actedOnId;

    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;

    @Size(max = 4000)
    @Column(name = "ACTION")
    private String action;

    @Size(max = 255)
    @Column(name = "ACTED_ON_NAME")
    private String actedOnName;

    @Column(name = "PARENT_ID")
    private BigInteger parentId;

    @Column(name = "NOTIFIED")
    private Character notified;

    public GlobSiteaudit() {
    }

    public GlobSiteaudit(BigDecimal id) {
        this.id = id;
    }

    public GlobSiteaudit(GlobUsers userId, Date actionTime, String actedOnType, BigInteger actedOnId, BigInteger projectId, BigInteger contractId, String action, String actedOnName, BigInteger parentId, Character notified) {
        this.userId = userId;
        this.actionTime = actionTime;
        this.actedOnType = actedOnType;
        this.actedOnId = actedOnId;
        this.projectId = projectId;
        this.contractId = contractId;
        this.action = action;
        this.actedOnName = actedOnName;
        this.parentId = parentId;
        this.notified = notified;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobUsers getUserId() {
        return userId;
    }

    public void setUserId(GlobUsers userId) {
        this.userId = userId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @JsonGetter("actionTime")
    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getActedOnType() {
        return actedOnType;
    }

    public void setActedOnType(String actedOnType) {
        this.actedOnType = actedOnType;
    }

    public BigInteger getActedOnId() {
        return actedOnId;
    }

    public void setActedOnId(BigInteger actedOnId) {
        this.actedOnId = actedOnId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActedOnName() {
        return actedOnName;
    }

    public void setActedOnName(String actedOnName) {
        this.actedOnName = actedOnName;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public Character getNotified() {
        return notified;
    }

    public void setNotified(Character notified) {
        this.notified = notified;
    }

}
