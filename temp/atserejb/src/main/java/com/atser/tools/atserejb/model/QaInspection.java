/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaInspection.findByClientId", query = "SELECT q FROM QaInspection q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaInspection.findByProjectId", query = "SELECT q FROM QaInspection q WHERE q.projectId = :projectId"),
    @NamedQuery(name = "QaInspection.findByLabId", query = "SELECT q FROM QaInspection q WHERE q.labId = :labId"),
    @NamedQuery(name = "QaInspection.findBySno", query = "SELECT q FROM QaInspection q WHERE q.sno = :sno"),
    @NamedQuery(name = "QaInspection.findByInspNo", query = "SELECT q FROM QaInspection q WHERE q.inspNo = :inspNo"),
    @NamedQuery(name = "QaInspection.findByIcn", query = "SELECT q FROM QaInspection q WHERE q.icn = :icn"),
    @NamedQuery(name = "QaInspection.findByRemarks", query = "SELECT q FROM QaInspection q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaInspection.findByFolderId", query = "SELECT q FROM QaInspection q WHERE q.folderId = :folderId"),
    @NamedQuery(name = "QaInspection.findByCreated", query = "SELECT q FROM QaInspection q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspection.findByCreatedBy", query = "SELECT q FROM QaInspection q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspection.findByCreatedByIp", query = "SELECT q FROM QaInspection q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspection.findByLastMod", query = "SELECT q FROM QaInspection q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspection.findByLastModIp", query = "SELECT q FROM QaInspection q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspection.findByLastModBy", query = "SELECT q FROM QaInspection q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspection.findByDeleted", query = "SELECT q FROM QaInspection q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspection.findByActive", query = "SELECT q FROM QaInspection q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspection.findByVersion", query = "SELECT q FROM QaInspection q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_AUD")
@Table(name = "QA_INSPECTION", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspection.findAll", query = "SELECT q FROM QaInspection q"),
    @NamedQuery(name = "QaInspection.findById", query = "SELECT q FROM QaInspection q WHERE q.id = :id")})
public class QaInspection implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_SEQ", sequenceName = "QA_INSPECTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Transient
    private String labName;
    @Column(name = "STATUS_ID", insertable = false)
    private BigInteger statusId;
    @Size(max = 150)
    @Column(name = "SPATTERN")
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 150)
    @Column(name = "INSP_NO")
    private String inspNo;
    @Size(max = 50)
    @Column(name = "ICN")
    private String icn;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Size(max = 255)
    @Column(name = "LOGGED_IN_BY")
    private String loggedInBy;
    @Size(max = 512)
    @Column(name = "LOGGED_IN_JOBTITLE")
    private String loggedInJobtitle;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;
    @JoinColumn(name = "INSPECTION_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private QaInspectionType inspectionTypeId;
    @JsonManagedReference
    @Where(clause = "deleted = false")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    private QaInspectionNotunused qaInspectionNotunused;
    @JsonManagedReference
    @Where(clause = "deleted = false")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    private QaInspectionQcml qaInspectionQcml;
    @JsonManagedReference
    @Where(clause = "deleted = false")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    private QaInspectionPrecaststress qaInspectionPrecaststress;
    @JsonManagedReference
    @Where(clause = "deleted = false")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    private QaInspectionVisual qaInspectionVisual;
    @JsonManagedReference
    @Where(clause = "deleted = false")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    private QaInspectionCertofsrc qaInspectionCertofsrc;
    @JoinColumn(name = "SIMPLECAT_ID", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private QaInspectionSimpleCat simplecatId;
    @Transient
    private String determinationDescript;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inspectionId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaInspectionSigninfo> qaInspectionSigninfoList;
    @JsonIgnore
    @Where(clause = "deleted = false")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inspectionId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaInspectionAsset> qaInspectionAssetList;
    @JsonIgnore
    @Where(clause = "deleted = false")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inspectionId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaInspectionSpecimen> qaInspectionSpecimenList;

    public QaInspection() {
    }

    public QaInspection(BigDecimal id) {
        this.id = id;
    }

    public QaInspection(BigDecimal id, BigInteger clientId, BigInteger projectId) {
        this.id = id;
        this.clientId = clientId;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    @JsonGetter(value = "labName")
    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public BigInteger getStatusId() {
        return statusId;
    }

    public void setStatusId(BigInteger statusId) {
        this.statusId = statusId;
    }

    public String getSpattern() {
        return spattern;
    }

    public void setSpattern(String spattern) {
        this.spattern = spattern;
    }

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
    }

    public String getInspNo() {
        return inspNo;
    }

    public void setInspNo(String inspNo) {
        this.inspNo = inspNo;
    }

    public String getIcn() {
        return icn;
    }

    public void setIcn(String icn) {
        this.icn = icn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getLoggedInBy() {
        return loggedInBy;
    }

    public void setLoggedInBy(String loggedInBy) {
        this.loggedInBy = loggedInBy;
    }

    public String getLoggedInJobtitle() {
        return loggedInJobtitle;
    }

    public void setLoggedInJobtitle(String loggedInJobtitle) {
        this.loggedInJobtitle = loggedInJobtitle;
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

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public QaInspectionSimpleCat getSimplecatId() {
        return simplecatId;
    }

    public void setSimplecatId(QaInspectionSimpleCat simplecatId) {
        this.simplecatId = simplecatId;
    }

    @JsonGetter(value = "determinationDescript")
    public String getDeterminationDescript() {
        return determinationDescript;
    }

    public void setDeterminationDescript(String determinationDescript) {
        this.determinationDescript = determinationDescript;
    }

    public QaInspectionType getInspectionTypeId() {
        return inspectionTypeId;
    }

    public void setInspectionTypeId(QaInspectionType inspectionTypeId) {
        this.inspectionTypeId = inspectionTypeId;
    }

    public QaInspectionNotunused getQaInspectionNotunused() {
        return qaInspectionNotunused;
    }

    public void setQaInspectionNotunused(QaInspectionNotunused qaInspectionNotunused) {
        this.qaInspectionNotunused = qaInspectionNotunused;
    }

    public QaInspectionQcml getQaInspectionQcml() {
        return qaInspectionQcml;
    }

    public void setQaInspectionQcml(QaInspectionQcml qaInspectionQcml) {
        this.qaInspectionQcml = qaInspectionQcml;
    }

    @XmlTransient
    public List<QaInspectionSigninfo> getQaInspectionSigninfoList() {
        return qaInspectionSigninfoList;
    }

    public void setQaInspectionSigninfoList(List<QaInspectionSigninfo> qaInspectionSigninfoList) {
        this.qaInspectionSigninfoList = qaInspectionSigninfoList;
    }

    public void addQaInspectionSigninfoList(QaInspectionSigninfo qaInspectionSigninfo) {
        if (this.qaInspectionSigninfoList == null) {
            this.qaInspectionSigninfoList = new ArrayList<>();
        }
        this.qaInspectionSigninfoList.add(qaInspectionSigninfo);
        qaInspectionSigninfo.setInspectionId(this);
    }

    public QaInspectionPrecaststress getQaInspectionPrecaststress() {
        return qaInspectionPrecaststress;
    }

    public void setQaInspectionPrecaststress(QaInspectionPrecaststress qaInspectionPrecaststress) {
        this.qaInspectionPrecaststress = qaInspectionPrecaststress;
    }

    public QaInspectionVisual getQaInspectionVisual() {
        return qaInspectionVisual;
    }

    public void setQaInspectionVisual(QaInspectionVisual qaInspectionVisual) {
        this.qaInspectionVisual = qaInspectionVisual;
    }

    public QaInspectionCertofsrc getQaInspectionCertofsrc() {
        return qaInspectionCertofsrc;
    }

    public void setQaInspectionCertofsrc(QaInspectionCertofsrc qaInspectionCertofsrc) {
        this.qaInspectionCertofsrc = qaInspectionCertofsrc;
    }

    @XmlTransient
    public List<QaInspectionAsset> getQaInspectionAssetList() {
        return qaInspectionAssetList;
    }

    public void setQaInspectionAssetList(List<QaInspectionAsset> qaInspectionAssetList) {
        this.qaInspectionAssetList = qaInspectionAssetList;
    }

    @XmlTransient
    public List<QaInspectionSpecimen> getQaInspectionSpecimenList() {
        return qaInspectionSpecimenList;
    }

    public void setQaInspectionSpecimenList(List<QaInspectionSpecimen> qaInspectionSpecimenList) {
        this.qaInspectionSpecimenList = qaInspectionSpecimenList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.remarks);
        hash = 67 * hash + Objects.hashCode(this.qaInspectionNotunused);
        hash = 67 * hash + Objects.hashCode(this.qaInspectionQcml);
        hash = 67 * hash + Objects.hashCode(this.qaInspectionPrecaststress);
        hash = 67 * hash + Objects.hashCode(this.qaInspectionVisual);
        hash = 67 * hash + Objects.hashCode(this.qaInspectionCertofsrc);
        hash = 67 * hash + Objects.hashCode(this.simplecatId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QaInspection other = (QaInspection) obj;
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.qaInspectionNotunused, other.qaInspectionNotunused)) {
            return false;
        }
        if (!Objects.equals(this.qaInspectionQcml, other.qaInspectionQcml)) {
            return false;
        }
        if (!Objects.equals(this.qaInspectionPrecaststress, other.qaInspectionPrecaststress)) {
            return false;
        }
        if (!Objects.equals(this.qaInspectionVisual, other.qaInspectionVisual)) {
            return false;
        }
        if (!Objects.equals(this.qaInspectionCertofsrc, other.qaInspectionCertofsrc)) {
            return false;
        }
        if (!Objects.equals(this.simplecatId, other.simplecatId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("Name", this.inspNo)
                .toString();
    }
}
