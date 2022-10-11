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
import java.util.List;
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
import javax.persistence.Transient;
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
@Table(name = "VW_BPM_SUBMITTAL_ALL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwBpmSubmittalAll.findById", query = "SELECT v FROM VwBpmSubmittalAll v WHERE v.persistenceid = :persistenceid"),
    @NamedQuery(name = "VwBpmSubmittalAll.findAll", query = "SELECT v FROM VwBpmSubmittalAll v")})
public class VwBpmSubmittalAll implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;

    @Column(name = "PROJECTID")
    private BigDecimal projectId;

    @Column(name = "CLIENTID")
    private BigDecimal clientId;

    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    @Size(max = 255)
    @Column(name = "SUBNUMBER")
    private String subnumber;

    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;

    @Size(max = 255)
    @Column(name = "FINALDISPOSITION")
    private String finaldisposition;

    @Size(max = 255)
    @Column(name = "REQUESTED_DUE_DATE")
    private String requestedDueDate;

    @Size(max = 255)
    @Column(name = "SOURCE")
    private String source;

    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneDate;

    @Transient
    private BpmTaskInstance taskInstanceCurrent;

    @Transient
    private List<BpmTaskInstance> taskInstanceList;

    @JoinColumn(name = "DC_DATA_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne
    private Bpmsubmittalmetadata dcDataPid;

    public VwBpmSubmittalAll() {
    }

    public VwBpmSubmittalAll(BigDecimal persistenceid) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubnumber() {
        return subnumber;
    }

    public void setSubnumber(String subnumber) {
        this.subnumber = subnumber;
    }

    public String getRequestedDueDate() {
        return requestedDueDate;
    }

    public void setRequestedDueDate(String requestedDueDate) {
        this.requestedDueDate = requestedDueDate;
    }

    public BpmTaskInstance getTaskInstanceCurrent() {
        return taskInstanceCurrent;
    }

    public void setTaskInstanceCurrent(BpmTaskInstance taskInstanceCurrent) {
        this.taskInstanceCurrent = taskInstanceCurrent;
    }

    public List<BpmTaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<BpmTaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
    }

    public Bpmsubmittalmetadata getDcDataPid() {
        return dcDataPid;
    }

    public void setDcDataPid(Bpmsubmittalmetadata dcDataPid) {
        this.dcDataPid = dcDataPid;
    }

}
