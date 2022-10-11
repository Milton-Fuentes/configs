/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.JmfMasterPojo;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/*
@NamedQuery(name = "QaaspmMixdesignJmfMaster.findByMixId", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.mixId = :mixId"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByJmfNo", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.jmfNo = :jmfNo"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByJmfAc", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.jmfAc = :jmfAc"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByCreated", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.created = :created"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByCreatedBy", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByCreatedByIp", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByLastMod", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByLastModIp", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByLastModBy", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByDeleted", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByActive", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.active = :active"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findByVersion", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QAASPM_MIX_JMF_MASTER_AUD")
@Table(name = "QAASPM_MIXDESIGN_JMF_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QAASPM_MIXDESIGN_JMF_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findAll", query = "SELECT q FROM QaaspmMixdesignJmfMaster q"),
    @NamedQuery(name = "QaaspmMixdesignJmfMaster.findById", query = "SELECT q FROM QaaspmMixdesignJmfMaster q WHERE q.id = :id")})
public class QaaspmMixdesignJmfMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QAASPM_MIX_JMF_MASTER_SEQ", sequenceName = "QAASPM_MIX_JMF_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QAASPM_MIX_JMF_MASTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "MIX_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaaspmMixdesignMaster mixId;
    @Column(name = "JMF_NO")
    private BigInteger jmfNo;
    @Column(name = "JMF_AC")
    private BigDecimal jmfAc;
    @Column(name = "DESAC")
    private BigDecimal desac;
    @Column(name = "MINAC")
    private BigDecimal minac;
    @Column(name = "MAXAC")
    private BigDecimal maxac;
    @Column(name = "MINENGAC")
    private BigDecimal minengac;
    @Column(name = "MAXENGAC")
    private BigDecimal maxengac;
    @Column(name = "PCT_ABSORPTION")
    private BigDecimal pctAbsorption;
    @Column(name = "DESVTM")
    private BigDecimal desvtm;
    @Column(name = "MINVTM")
    private BigDecimal minvtm;
    @Column(name = "MAXVTM")
    private BigDecimal maxvtm;
    @Column(name = "MINENGVTM")
    private BigDecimal minengvtm;
    @Column(name = "MAXENGVTM")
    private BigDecimal maxengvtm;
    @Column(name = "DESVMA")
    private BigDecimal desvma;
    @Column(name = "MINVMA")
    private BigDecimal minvma;
    @Column(name = "MAXVMA")
    private BigDecimal maxvma;
    @Column(name = "MINENGVMA")
    private BigDecimal minengvma;
    @Column(name = "MAXENGVMA")
    private BigDecimal maxengvma;
    @Column(name = "DESVFA")
    private BigDecimal desvfa;
    @Column(name = "MINVFA")
    private BigDecimal minvfa;
    @Column(name = "MAXVFA")
    private BigDecimal maxvfa;
    @Column(name = "MINENGVFA")
    private BigDecimal minengvfa;
    @Column(name = "MAXENGVFA")
    private BigDecimal maxengvfa;
    @Column(name = "DESDPBR")
    private BigDecimal desdpbr;
    @Column(name = "MINDPBR")
    private BigDecimal mindpbr;
    @Column(name = "MAXDPBR")
    private BigDecimal maxdpbr;
    @Column(name = "MINENGDPBR")
    private BigDecimal minengdpbr;
    @Column(name = "MAXENGDPBR")
    private BigDecimal maxengdpbr;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Size(max = 20)
    @Column(name = "MAIN")
    private String main;
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
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @Version
    @Column(name = "VERSION")
    private Long version;
    @NotAudited
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jmfId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaaspmMixdesignJmfsvMaster> qaaspmMixdesignJmfsvMasterList;

    public QaaspmMixdesignJmfMaster() {
    }

    public QaaspmMixdesignJmfMaster(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignMaster getMixId() {
        return mixId;
    }

    public void setMixId(QaaspmMixdesignMaster mixId) {
        this.mixId = mixId;
    }

    public BigDecimal getPctAbsorption() {
        return pctAbsorption;
    }

    public void setPctAbsorption(BigDecimal pctAbsorption) {
        this.pctAbsorption = pctAbsorption;
    }

    public BigInteger getJmfNo() {
        return jmfNo;
    }

    public void setJmfNo(BigInteger jmfNo) {
        this.jmfNo = jmfNo;
    }

    public BigDecimal getJmfAc() {
        return jmfAc;
    }

    public void setJmfAc(BigDecimal jmfAc) {
        this.jmfAc = jmfAc;
    }

    public BigDecimal getDesac() {
        return desac;
    }

    public void setDesac(BigDecimal desac) {
        this.desac = desac;
    }

    public BigDecimal getMinac() {
        return minac;
    }

    public void setMinac(BigDecimal minac) {
        this.minac = minac;
    }

    public BigDecimal getMaxac() {
        return maxac;
    }

    public void setMaxac(BigDecimal maxac) {
        this.maxac = maxac;
    }

    public BigDecimal getMinengac() {
        return minengac;
    }

    public void setMinengac(BigDecimal minengac) {
        this.minengac = minengac;
    }

    public BigDecimal getMaxengac() {
        return maxengac;
    }

    public void setMaxengac(BigDecimal maxengac) {
        this.maxengac = maxengac;
    }

    public BigDecimal getDesvtm() {
        return desvtm;
    }

    public void setDesvtm(BigDecimal desvtm) {
        this.desvtm = desvtm;
    }

    public BigDecimal getMinvtm() {
        return minvtm;
    }

    public void setMinvtm(BigDecimal minvtm) {
        this.minvtm = minvtm;
    }

    public BigDecimal getMaxvtm() {
        return maxvtm;
    }

    public void setMaxvtm(BigDecimal maxvtm) {
        this.maxvtm = maxvtm;
    }

    public BigDecimal getMinengvtm() {
        return minengvtm;
    }

    public void setMinengvtm(BigDecimal minengvtm) {
        this.minengvtm = minengvtm;
    }

    public BigDecimal getMaxengvtm() {
        return maxengvtm;
    }

    public void setMaxengvtm(BigDecimal maxengvtm) {
        this.maxengvtm = maxengvtm;
    }

    public BigDecimal getDesvma() {
        return desvma;
    }

    public void setDesvma(BigDecimal desvma) {
        this.desvma = desvma;
    }

    public BigDecimal getMinvma() {
        return minvma;
    }

    public void setMinvma(BigDecimal minvma) {
        this.minvma = minvma;
    }

    public BigDecimal getMaxvma() {
        return maxvma;
    }

    public void setMaxvma(BigDecimal maxvma) {
        this.maxvma = maxvma;
    }

    public BigDecimal getMinengvma() {
        return minengvma;
    }

    public void setMinengvma(BigDecimal minengvma) {
        this.minengvma = minengvma;
    }

    public BigDecimal getMaxengvma() {
        return maxengvma;
    }

    public void setMaxengvma(BigDecimal maxengvma) {
        this.maxengvma = maxengvma;
    }

    public BigDecimal getDesvfa() {
        return desvfa;
    }

    public void setDesvfa(BigDecimal desvfa) {
        this.desvfa = desvfa;
    }

    public BigDecimal getMinvfa() {
        return minvfa;
    }

    public void setMinvfa(BigDecimal minvfa) {
        this.minvfa = minvfa;
    }

    public BigDecimal getMaxvfa() {
        return maxvfa;
    }

    public void setMaxvfa(BigDecimal maxvfa) {
        this.maxvfa = maxvfa;
    }

    public BigDecimal getMinengvfa() {
        return minengvfa;
    }

    public void setMinengvfa(BigDecimal minengvfa) {
        this.minengvfa = minengvfa;
    }

    public BigDecimal getMaxengvfa() {
        return maxengvfa;
    }

    public void setMaxengvfa(BigDecimal maxengvfa) {
        this.maxengvfa = maxengvfa;
    }

    public BigDecimal getDesdpbr() {
        return desdpbr;
    }

    public void setDesdpbr(BigDecimal desdpbr) {
        this.desdpbr = desdpbr;
    }

    public BigDecimal getMindpbr() {
        return mindpbr;
    }

    public void setMindpbr(BigDecimal mindpbr) {
        this.mindpbr = mindpbr;
    }

    public BigDecimal getMaxdpbr() {
        return maxdpbr;
    }

    public void setMaxdpbr(BigDecimal maxdpbr) {
        this.maxdpbr = maxdpbr;
    }

    public BigDecimal getMinengdpbr() {
        return minengdpbr;
    }

    public void setMinengdpbr(BigDecimal minengdpbr) {
        this.minengdpbr = minengdpbr;
    }

    public BigDecimal getMaxengdpbr() {
        return maxengdpbr;
    }

    public void setMaxengdpbr(BigDecimal maxengdpbr) {
        this.maxengdpbr = maxengdpbr;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @XmlTransient
    public List<QaaspmMixdesignJmfsvMaster> getQaaspmMixdesignJmfsvMasterList() {
        return qaaspmMixdesignJmfsvMasterList;
    }

    public void setQaaspmMixdesignJmfsvMasterList(List<QaaspmMixdesignJmfsvMaster> qaaspmMixdesignJmfsvMasterList) {
        this.qaaspmMixdesignJmfsvMasterList = qaaspmMixdesignJmfsvMasterList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(jmfNo)
                .append(jmfAc)
                .append(desac)
                .append(minac)
                .append(maxac)
                .append(minengac)
                .append(maxengac)
                .append(desvtm)
                .append(minvtm)
                .append(maxvtm)
                .append(minengvtm)
                .append(maxengvtm)
                .append(desvma)
                .append(minvma)
                .append(maxvma)
                .append(minengvma)
                .append(maxengvma)
                .append(desvfa)
                .append(minvfa)
                .append(maxvfa)
                .append(minengvfa)
                .append(maxengvfa)
                .append(desdpbr)
                .append(mindpbr)
                .append(maxdpbr)
                .append(minengdpbr)
                .append(maxengdpbr)
                .append(approvedDate)
                .append(pctAbsorption)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaaspmMixdesignJmfMaster)) {
            return false;
        }
        QaaspmMixdesignJmfMaster other = (QaaspmMixdesignJmfMaster) object;

        return new EqualsBuilder()
                .append(this.jmfNo, other.jmfNo)
                .append(this.jmfAc, other.jmfAc)
                .append(this.desac, other.desac)
                .append(this.minac, other.minac)
                .append(this.maxac, other.maxac)
                .append(this.minengac, other.minengac)
                .append(this.maxengac, other.maxengac)
                .append(this.desvtm, other.desvtm)
                .append(this.minvtm, other.minvtm)
                .append(this.maxvtm, other.maxvtm)
                .append(this.minengvtm, other.minengvtm)
                .append(this.maxengvtm, other.maxengvtm)
                .append(this.desvma, other.desvma)
                .append(this.minvma, other.minvma)
                .append(this.maxvma, other.maxvma)
                .append(this.minengvma, other.minengvma)
                .append(this.maxengvma, other.maxengvma)
                .append(this.desvfa, other.desvfa)
                .append(this.minvfa, other.minvfa)
                .append(this.maxvfa, other.maxvfa)
                .append(this.minengvfa, other.minengvfa)
                .append(this.maxengvfa, other.maxengvfa)
                .append(this.desdpbr, other.desdpbr)
                .append(this.mindpbr, other.mindpbr)
                .append(this.maxdpbr, other.maxdpbr)
                .append(this.minengdpbr, other.minengdpbr)
                .append(this.maxengdpbr, other.maxengdpbr)
                .append(this.approvedDate, other.approvedDate)
                .append(this.pctAbsorption, other.pctAbsorption)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster[ id=" + id + " ]";
    }

    public JmfMasterPojo generateJmfMasterPojo() {
        JmfMasterPojo obj = new JmfMasterPojo();
        obj.setJmfNo(StringSupport.getString(getJmfNo()));
        obj.setJmfAc(StringSupport.getString(getJmfAc()));
        obj.setDesac(StringSupport.getString(getDesac()));
        obj.setMinac(StringSupport.getString(getMinac()));
        obj.setMaxac(StringSupport.getString(getMaxac()));
        obj.setMinengac(StringSupport.getString(getMinengac()));
        obj.setMaxengac(StringSupport.getString(getMaxengac()));
        obj.setDesvtm(StringSupport.getString(getDesvtm()));
        obj.setMinvtm(StringSupport.getString(getMinvtm()));
        obj.setMaxvtm(StringSupport.getString(getMaxengvtm()));
        obj.setMinengvtm(StringSupport.getString(getMinengvtm()));
        obj.setMaxengvtm(StringSupport.getString(getMaxengvtm()));
        obj.setDesvma(StringSupport.getString(getDesvma()));
        obj.setMinvma(StringSupport.getString(getMinvma()));
        obj.setMaxvma(StringSupport.getString(getMaxvma()));
        obj.setMinengvma(StringSupport.getString(getMinengvma()));
        obj.setMaxengvma(StringSupport.getString(getMaxengvma()));
        obj.setDesvfa(StringSupport.getString(getDesvfa()));
        obj.setMinvfa(StringSupport.getString(getMinvfa()));
        obj.setMaxvfa(StringSupport.getString(getMaxengvfa()));
        obj.setMinengvfa(StringSupport.getString(getMinengvfa()));
        obj.setMaxengvfa(StringSupport.getString(getMaxengvfa()));
        obj.setDesdpbr(StringSupport.getString(getDesdpbr()));
        obj.setMindpbr(StringSupport.getString(getMindpbr()));
        obj.setMaxdpbr(StringSupport.getString(getMaxdpbr()));
        obj.setMinengdpbr(StringSupport.getString(getMinengdpbr()));
        obj.setMaxengdpbr(StringSupport.getString(getMaxengdpbr()));
        obj.setApprovedDate(DateSupport.formatDate(getApprovedDate(), DateSupport.FORMAT_US));
        obj.setMain(getMain());
        return obj;
    }
}
