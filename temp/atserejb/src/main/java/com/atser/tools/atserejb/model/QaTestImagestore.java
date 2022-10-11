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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QaTestImagestore.findByClientId", query = "SELECT q FROM QaTestImagestore q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaTestImagestore.findBySampleid", query = "SELECT q FROM QaTestImagestore q WHERE q.sampleid = :sampleid"),
    @NamedQuery(name = "QaTestImagestore.findBySampletestId", query = "SELECT q FROM QaTestImagestore q WHERE q.sampletestId = :sampletestId"),
    @NamedQuery(name = "QaTestImagestore.findByRefId", query = "SELECT q FROM QaTestImagestore q WHERE q.refId = :refId"),
    @NamedQuery(name = "QaTestImagestore.findBySourceName", query = "SELECT q FROM QaTestImagestore q WHERE q.sourceName = :sourceName"),
    @NamedQuery(name = "QaTestImagestore.findByServerPath", query = "SELECT q FROM QaTestImagestore q WHERE q.serverPath = :serverPath"),
    @NamedQuery(name = "QaTestImagestore.findByFName", query = "SELECT q FROM QaTestImagestore q WHERE q.fName = :fName"),
    @NamedQuery(name = "QaTestImagestore.findByFSize", query = "SELECT q FROM QaTestImagestore q WHERE q.fSize = :fSize"),
    @NamedQuery(name = "QaTestImagestore.findByFNote", query = "SELECT q FROM QaTestImagestore q WHERE q.fNote = :fNote"),
    @NamedQuery(name = "QaTestImagestore.findByExtension", query = "SELECT q FROM QaTestImagestore q WHERE q.extension = :extension"),
    @NamedQuery(name = "QaTestImagestore.findByStandard", query = "SELECT q FROM QaTestImagestore q WHERE q.standard = :standard"),
    @NamedQuery(name = "QaTestImagestore.findBySpec", query = "SELECT q FROM QaTestImagestore q WHERE q.spec = :spec"),
    @NamedQuery(name = "QaTestImagestore.findByDeleted", query = "SELECT q FROM QaTestImagestore q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaTestImagestore.findByActive", query = "SELECT q FROM QaTestImagestore q WHERE q.active = :active"),
    @NamedQuery(name = "QaTestImagestore.findByCreated", query = "SELECT q FROM QaTestImagestore q WHERE q.created = :created"),
    @NamedQuery(name = "QaTestImagestore.findByCreatedBy", query = "SELECT q FROM QaTestImagestore q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaTestImagestore.findByCreatedByIp", query = "SELECT q FROM QaTestImagestore q WHERE q.createdByIp = :createdByIp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TEST_IMAGESTORE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_TEST_IMAGESTORE SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTestImagestore.findAll", query = "SELECT q FROM QaTestImagestore q"),
    @NamedQuery(name = "QaTestImagestore.findById", query = "SELECT q FROM QaTestImagestore q WHERE q.id = :id")})
public class QaTestImagestore implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_TEST_IMAGESTORE_SEQ", sequenceName = "QA_TEST_IMAGESTORE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_TEST_IMAGESTORE_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @Column(name = "SAMPLEID")
    private BigInteger sampleid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Column(name = "REF_ID")
    private BigInteger refId;
    @Size(max = 255)
    @Column(name = "SOURCE_NAME")
    private String sourceName;
    @Size(max = 1024)
    @Column(name = "SERVER_PATH")
    private String serverPath;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "F_SIZE")
    private BigInteger fSize;
    @Size(max = 1024)
    @Column(name = "F_NOTE")
    private String fNote;
    @Size(max = 50)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 20)
    @Column(name = "STANDARD")
    private String standard;
    @Size(max = 20)
    @Column(name = "SPEC")
    private String spec;
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
    @Transient
    private String openUrl;
    @Column(name = "TOTAL_PAGES")
    private Integer totalPages;
    @Lob
    @Column(name = "METADATA")
    private String metadata;
    @Column(name = "WIDTH")
    private Integer width;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "REPORT_STATUS")
    private Character reportStatus;
    @Column(name = "DOC_TYPE")
    private String docType;

    public QaTestImagestore() {
    }

    public QaTestImagestore(BigDecimal id) {
        this.id = id;
    }

    public QaTestImagestore(BigDecimal id, BigInteger clientId, BigInteger sampleid, BigInteger sampletestId) {
        this.id = id;
        this.clientId = clientId;
        this.sampleid = sampleid;
        this.sampletestId = sampletestId;
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

    public BigInteger getSampleid() {
        return sampleid;
    }

    public void setSampleid(BigInteger sampleid) {
        this.sampleid = sampleid;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public BigInteger getRefId() {
        return refId;
    }

    public void setRefId(BigInteger refId) {
        this.refId = refId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public BigInteger getFSize() {
        return fSize;
    }

    public void setFSize(BigInteger fSize) {
        this.fSize = fSize;
    }

    public String getFNote() {
        return fNote;
    }

    public void setFNote(String fNote) {
        this.fNote = fNote;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeidht() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Character getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Character reportStatus) {
        this.reportStatus = reportStatus;
    }
    

    @JsonGetter(value = "openUrl")
    public String getOpenUrl() {
        return "/ws/rs/qa/testimagestore/download/image?fid=" + this.id;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
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
        if (!(object instanceof QaTestImagestore)) {
            return false;
        }
        QaTestImagestore other = (QaTestImagestore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTestImagestore[ id=" + id + " ]";
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}
