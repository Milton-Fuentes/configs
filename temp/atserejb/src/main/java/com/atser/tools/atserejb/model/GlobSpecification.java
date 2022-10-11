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
import javax.persistence.Basic;
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

/*
, @NamedQuery(name = "GlobSpecification.findByTestMethodId", query = "SELECT g FROM GlobSpecification g WHERE g.testMethodId = :testMethodId")
    , @NamedQuery(name = "GlobSpecification.findBySName", query = "SELECT g FROM GlobSpecification g WHERE g.sName = :sName")
    , @NamedQuery(name = "GlobSpecification.findByDescription", query = "SELECT g FROM GlobSpecification g WHERE g.description = :description")
    , @NamedQuery(name = "GlobSpecification.findBySpecVersion", query = "SELECT g FROM GlobSpecification g WHERE g.specVersion = :specVersion")
    , @NamedQuery(name = "GlobSpecification.findByActive", query = "SELECT g FROM GlobSpecification g WHERE g.active = :active")
    , @NamedQuery(name = "GlobSpecification.findByLastMod", query = "SELECT g FROM GlobSpecification g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobSpecification.findByLastModBy", query = "SELECT g FROM GlobSpecification g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobSpecification.findByLastModIp", query = "SELECT g FROM GlobSpecification g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobSpecification.findByTemp", query = "SELECT g FROM GlobSpecification g WHERE g.temp = :temp")
    , @NamedQuery(name = "GlobSpecification.findByCreateBy", query = "SELECT g FROM GlobSpecification g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobSpecification.findByCreateByIp", query = "SELECT g FROM GlobSpecification g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobSpecification.findByCreateDate", query = "SELECT g FROM GlobSpecification g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobSpecification.findByInternalSpec", query = "SELECT g FROM GlobSpecification g WHERE g.internalSpec = :internalSpec")
    , @NamedQuery(name = "GlobSpecification.findByTempTmp", query = "SELECT g FROM GlobSpecification g WHERE g.tempTmp = :tempTmp")
    , @NamedQuery(name = "GlobSpecification.findByCreateDateTmp", query = "SELECT g FROM GlobSpecification g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobSpecification.findByLastModTmp", query = "SELECT g FROM GlobSpecification g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobSpecification.findByDefaultNoRows", query = "SELECT g FROM GlobSpecification g WHERE g.defaultNoRows = :defaultNoRows")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPECIFICATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecification.findAll", query = "SELECT g FROM GlobSpecification g")
    , @NamedQuery(name = "GlobSpecification.findById", query = "SELECT g FROM GlobSpecification g WHERE g.id = :id")})
public class GlobSpecification implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_METHOD_ID")
    private BigInteger testMethodId;
    @Size(max = 4000)
    @Column(name = "S_NAME")
    private String sName;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "SPEC_VERSION")
    private String specVersion;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "INTERNAL_SPEC")
    private Character internalSpec;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Column(name = "DEFAULT_NO_ROWS")
    private BigInteger defaultNoRows;
    @JoinColumn(name = "ORIGINATOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobOriginator originatorId;

    public GlobSpecification() {
    }

    public GlobSpecification(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestMethodId() {
        return testMethodId;
    }

    public void setTestMethodId(BigInteger testMethodId) {
        this.testMethodId = testMethodId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(String specVersion) {
        this.specVersion = specVersion;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

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

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getInternalSpec() {
        return internalSpec;
    }

    public void setInternalSpec(Character internalSpec) {
        this.internalSpec = internalSpec;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public BigInteger getDefaultNoRows() {
        return defaultNoRows;
    }

    public void setDefaultNoRows(BigInteger defaultNoRows) {
        this.defaultNoRows = defaultNoRows;
    }

    public GlobOriginator getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(GlobOriginator originatorId) {
        this.originatorId = originatorId;
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
        if (!(object instanceof GlobSpecification)) {
            return false;
        }
        GlobSpecification other = (GlobSpecification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecification[ id=" + id + " ]";
    }
    
}
