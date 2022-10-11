/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author dperez
 */
@Entity
@Immutable
@Table(name = "VW_BPM_RFI_ALL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBpmRfiAll.findById", query = "SELECT v FROM VwBpmRfiAll v WHERE v.persistenceid = :persistenceid"),
    @NamedQuery(name = "VwBpmRfiAll.findAll", query = "SELECT v FROM VwBpmRfiAll v")})
public class VwBpmRfiAll implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;

    @Column(name = "PROJECTID")
    private BigDecimal projectId;

    @Column(name = "CLIENTID")
    private BigDecimal clientId;

    @Column(name = "RFINUMBER")
    private String rfinumber;

    @Column(name = "RFINAME")
    private String rfiname;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneDate;

    @Column(name = "RESPONSE_DUE_DATE")
    private String responseDueDate;

    @Column(name = "PRIORITYCODE")
    private String prioritycode;

    @Column(name = "CHECK_WORK_IMPACT")
    private Character checkWorkImpact;

    @Column(name = "CHECK_SCHEDULE_IMPACT")
    private Character checkScheduleImpact;

    @Column(name = "CHECK_COST_IMPACT")
    private Character checkCostImpact;

    @JoinColumn(name = "DC_DATA_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne
    private Bpmrfimetadata dcDataPid;

    public VwBpmRfiAll() {
    }

    public VwBpmRfiAll(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
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

    public String getRfinumber() {
        return rfinumber;
    }

    public void setRfinumber(String rfinumber) {
        this.rfinumber = rfinumber;
    }

    public String getRfiname() {
        return rfiname;
    }

    public void setRfiname(String rfiname) {
        this.rfiname = rfiname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinaldisposition() {
        return finaldisposition;
    }

    public void setFinaldisposition(String finaldisposition) {
        this.finaldisposition = finaldisposition;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public String getResponseDueDate() {
        return responseDueDate;
    }

    public void setResponseDueDate(String responseDueDate) {
        this.responseDueDate = responseDueDate;
    }

    public String getPrioritycode() {
        return prioritycode;
    }

    public void setPrioritycode(String prioritycode) {
        this.prioritycode = prioritycode;
    }

    public Character getCheckWorkImpact() {
        return checkWorkImpact;
    }

    public void setCheckWorkImpact(Character checkWorkImpact) {
        this.checkWorkImpact = checkWorkImpact;
    }

    public Character getCheckScheduleImpact() {
        return checkScheduleImpact;
    }

    public void setCheckScheduleImpact(Character checkScheduleImpact) {
        this.checkScheduleImpact = checkScheduleImpact;
    }

    public Character getCheckCostImpact() {
        return checkCostImpact;
    }

    public void setCheckCostImpact(Character checkCostImpact) {
        this.checkCostImpact = checkCostImpact;
    }

    public Bpmrfimetadata getDcDataPid() {
        return dcDataPid;
    }

    public void setDcDataPid(Bpmrfimetadata dcDataPid) {
        this.dcDataPid = dcDataPid;
    }

}
