/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
    @NamedQuery(name = "QmCvlFieldData.findByFieldId", query = "SELECT q FROM QmCvlFieldData q WHERE q.fieldId = :fieldId"),
    @NamedQuery(name = "QmCvlFieldData.findByValue", query = "SELECT q FROM QmCvlFieldData q WHERE q.value = :value"),
    @NamedQuery(name = "QmCvlFieldData.findByActive", query = "SELECT q FROM QmCvlFieldData q WHERE q.active = :active"),
    @NamedQuery(name = "QmCvlFieldData.findByLastMod", query = "SELECT q FROM QmCvlFieldData q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QmCvlFieldData.findByLastModBy", query = "SELECT q FROM QmCvlFieldData q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QmCvlFieldData.findByLastModIp", query = "SELECT q FROM QmCvlFieldData q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QmCvlFieldData.findByCreateDate", query = "SELECT q FROM QmCvlFieldData q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QmCvlFieldData.findByCreateBy", query = "SELECT q FROM QmCvlFieldData q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QmCvlFieldData.findByCreateByIp", query = "SELECT q FROM QmCvlFieldData q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QmCvlFieldData.findByVersion", query = "SELECT q FROM QmCvlFieldData q WHERE q.version = :version"),
    @NamedQuery(name = "QmCvlFieldData.findByFieldOrder", query = "SELECT q FROM QmCvlFieldData q WHERE q.fieldOrder = :fieldOrder"),
    @NamedQuery(name = "QmCvlFieldData.findByCode", query = "SELECT q FROM QmCvlFieldData q WHERE q.code = :code")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QM_CVL_FIELD_DATA", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmCvlFieldData.findAll", query = "SELECT q FROM QmCvlFieldData q"),
    @NamedQuery(name = "QmCvlFieldData.findById", query = "SELECT q FROM QmCvlFieldData q WHERE q.id = :id")})
public class QmCvlFieldData implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QM_CVL_FIELD_DATA_ID_SEQ", sequenceName = "QM_CVL_FIELD_DATA_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QM_CVL_FIELD_DATA_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "FIELD_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private QmCvlField fieldId;
    @Size(max = 255)
    @Column(name = "VALUE")
    private String value;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
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
    @Column(name = "VERSION", insertable = false)
    private String version;
    @Column(name = "FIELD_ORDER")
    private BigInteger fieldOrder;
    @Size(max = 20)
    @Column(name = "CODE")
    private String code;
    @JsonIgnore
    @OneToMany(mappedBy = "contractorTypeId", fetch = FetchType.LAZY)
    private List<GlobProjContrPersonnel> globProjContrPersonnelList;

    public QmCvlFieldData() {
    }

    public QmCvlFieldData(QmCvlField fieldId, String value, String createBy, String createByIp, BigInteger fieldOrder, String code) {
        this.fieldId = fieldId;
        this.value = value;
        this.createBy = createBy;
        this.createByIp = createByIp;
        this.fieldOrder = fieldOrder;
        this.code = code;
    }
    
    

    public QmCvlFieldData(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QmCvlField getFieldId() {
        return fieldId;
    }

    public void setFieldId(QmCvlField fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public BigInteger getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(BigInteger fieldOrder) {
        this.fieldOrder = fieldOrder;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public List<GlobProjContrPersonnel> getGlobProjContrPersonnelList() {
        return globProjContrPersonnelList;
    }

    public void setGlobProjContrPersonnelList(List<GlobProjContrPersonnel> globProjContrPersonnelList) {
        this.globProjContrPersonnelList = globProjContrPersonnelList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.fieldId);
        hash = 23 * hash + Objects.hashCode(this.value);
        hash = 23 * hash + Objects.hashCode(this.code);
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
        final QmCvlFieldData other = (QmCvlFieldData) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.fieldId, other.fieldId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmCvlFieldData[ id=" + id + " ]";
    }

}
