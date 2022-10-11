/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

/*
    , @NamedQuery(name = "JobRecords.findByJobname", query = "SELECT j FROM JobRecords j WHERE j.jobname = :jobname")
    , @NamedQuery(name = "JobRecords.findByJobdescription", query = "SELECT j FROM JobRecords j WHERE j.jobdescription = :jobdescription")
    , @NamedQuery(name = "JobRecords.findByStatus", query = "SELECT j FROM JobRecords j WHERE j.status = :status")
    , @NamedQuery(name = "JobRecords.findByCreated", query = "SELECT j FROM JobRecords j WHERE j.created = :created")
    , @NamedQuery(name = "JobRecords.findByCreateBy", query = "SELECT j FROM JobRecords j WHERE j.createBy = :createBy")
    , @NamedQuery(name = "JobRecords.findByJobtitle", query = "SELECT j FROM JobRecords j WHERE j.jobtitle = :jobtitle")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE JOB_RECORDS SET status = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Table(name = "JOB_RECORDS", catalog = "", schema = "ORACLE")
@Where(clause = "status <> 0")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobRecords.findAll", query = "SELECT j FROM JobRecords j")
    , @NamedQuery(name = "JobRecords.findById", query = "SELECT j FROM JobRecords j WHERE j.id = :id")})
public class JobRecords implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "JOB_RECORDS_SEQ", sequenceName = "JOB_RECORDS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_RECORDS_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "JOBNAME")
    private String jobname;
    @Size(max = 500)
    @Column(name = "JOBDESCRIPTION")
    private String jobdescription;
    @JsonSkipXssSerialization
    @Lob
    @Column(name = "PARAMETERS")
    private String parameters;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false, insertable = false)
    private short status;
    @Basic(optional = false)
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 150)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Basic(optional = false)
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "VISIBLE")
    private Character visible;

    public JobRecords() {
    }

    public JobRecords(BigDecimal id) {
        this.id = id;
    }

    public JobRecords(BigDecimal id, String jobname, short status, Date created, String jobtitle) {
        this.id = id;
        this.jobname = jobname;
        this.status = status;
        this.created = created;
        this.jobtitle = jobtitle;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Character getVisible() {
        return visible;
    }

    public void setVisible(Character visible) {
        this.visible = visible;
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
        if (!(object instanceof JobRecords)) {
            return false;
        }
        JobRecords other = (JobRecords) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.JobRecords[ id=" + id + " ]";
    }

}
