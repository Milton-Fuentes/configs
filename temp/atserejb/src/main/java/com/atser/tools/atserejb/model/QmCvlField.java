/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
    //@NamedQuery(name = "QmCvlField.findBySectionId", query = "SELECT q FROM QmCvlField q WHERE q.sectionId = :sectionId"),
    @NamedQuery(name = "QmCvlField.findByFieldName", query = "SELECT q FROM QmCvlField q WHERE q.fieldName = :fieldName"),
    @NamedQuery(name = "QmCvlField.findByActive", query = "SELECT q FROM QmCvlField q WHERE q.active = :active"),
    @NamedQuery(name = "QmCvlField.findByLastMod", query = "SELECT q FROM QmCvlField q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QmCvlField.findByLastModBy", query = "SELECT q FROM QmCvlField q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QmCvlField.findByLastModIp", query = "SELECT q FROM QmCvlField q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QmCvlField.findByCreateDate", query = "SELECT q FROM QmCvlField q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QmCvlField.findByCreateBy", query = "SELECT q FROM QmCvlField q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QmCvlField.findByCreateByIp", query = "SELECT q FROM QmCvlField q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QmCvlField.findByVersion", query = "SELECT q FROM QmCvlField q WHERE q.version = :version"),
    @NamedQuery(name = "QmCvlField.findByFieldCode", query = "SELECT q FROM QmCvlField q WHERE q.fieldCode = :fieldCode")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QM_CVL_FIELD", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmCvlField.findAll", query = "SELECT q FROM QmCvlField q"),
    @NamedQuery(name = "QmCvlField.findById", query = "SELECT q FROM QmCvlField q WHERE q.id = :id")})
public class QmCvlField implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SECTION_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private QmCvlSection sectionId;
    @Size(max = 255)
    @Column(name = "FIELD_NAME")
    private String fieldName;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "FIELD_CODE")
    private String fieldCode;
    @OneToMany(mappedBy = "fieldId", fetch = FetchType.LAZY)
    private List<QmCvlFieldData> qmCvlFieldDataList;

    public QmCvlField() {
    }

    public QmCvlField(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QmCvlSection getSectionId() {
        return sectionId;
    }

    public void setSectionId(QmCvlSection sectionId) {
        this.sectionId = sectionId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    @XmlTransient
    public List<QmCvlFieldData> getQmCvlFieldDataList() {
        return qmCvlFieldDataList;
    }

    public void setQmCvlFieldDataList(List<QmCvlFieldData> qmCvlFieldDataList) {
        this.qmCvlFieldDataList = qmCvlFieldDataList;
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
        if (!(object instanceof QmCvlField)) {
            return false;
        }
        QmCvlField other = (QmCvlField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmCvlField[ id=" + id + " ]";
    }

}
