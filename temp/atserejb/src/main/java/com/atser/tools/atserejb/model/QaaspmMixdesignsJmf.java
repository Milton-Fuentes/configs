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
import java.util.ArrayList;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/*
@NamedQuery(name = "QaaspmMixdesignsJmf.findByMixDesignId", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.mixDesignId = :mixDesignId"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByJmfNo", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.jmfNo = :jmfNo"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByJmfAc", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.jmfAc = :jmfAc"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField1", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField2", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField3", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField4", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField5", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField6", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField7", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField8", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field8 = :field8"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField9", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field9 = :field9"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByField10", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.field10 = :field10"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByCreateDate", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByCreateBy", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByCreateByIp", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByLastMod", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByLastModBy", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByLastModIp", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findByVersion", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QAASPM_MIXDESIGNS_JMF", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignsJmf.findAll", query = "SELECT q FROM QaaspmMixdesignsJmf q"),
    @NamedQuery(name = "QaaspmMixdesignsJmf.findById", query = "SELECT q FROM QaaspmMixdesignsJmf q WHERE q.id = :id")})
public class QaaspmMixdesignsJmf implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qaaspm_mixdesigns_jmf_ID_SEQ", sequenceName = "qaaspm_mixdesigns_jmf_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qaaspm_mixdesigns_jmf_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "MIX_DESIGN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaaspmMixdesigns mixDesignId;    
    @Column(name = "PCT_ABSORPTION")
    private BigDecimal pctAbsorption;
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
    @Size(max = 20)
    @Column(name = "MAIN")
    private String main;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 255)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 255)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 255)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 255)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "FIELD7")
    private BigInteger field7;
    @Column(name = "FIELD8")
    private BigInteger field8;
    @Size(max = 50)
    @Column(name = "FIELD9")
    private String field9;
    @Size(max = 50)
    @Column(name = "FIELD10")
    private String field10;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
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
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    //@NotAudited
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jmfId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QaaspmMixdesignsJmfSieves> qaaspmMixdesignsJmfSievesList;

    public QaaspmMixdesignsJmf() {
    }

    public QaaspmMixdesignsJmf(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesigns getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(QaaspmMixdesigns mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public BigInteger getJmfNo() {
        return jmfNo;
    }

    public BigDecimal getPctAbsorption() {
        return pctAbsorption;
    }

    public void setPctAbsorption(BigDecimal pctAbsorption) {
        this.pctAbsorption = pctAbsorption;
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

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public BigInteger getField7() {
        return field7;
    }

    public void setField7(BigInteger field7) {
        this.field7 = field7;
    }

    public BigInteger getField8() {
        return field8;
    }

    public void setField8(BigInteger field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    @XmlTransient
    public List<QaaspmMixdesignsJmfSieves> getQaaspmMixdesignsJmfSievesList() {
        return qaaspmMixdesignsJmfSievesList;
    }

    public void setQaaspmMixdesignsJmfSievesList(List<QaaspmMixdesignsJmfSieves> qaaspmMixdesignsJmfSievesList) {
        this.qaaspmMixdesignsJmfSievesList = qaaspmMixdesignsJmfSievesList;
    }

    public void addAspmMixdesignsJmfSievesList(QaaspmMixdesignsJmfSieves item) {
        if (qaaspmMixdesignsJmfSievesList == null) {
            qaaspmMixdesignsJmfSievesList = new ArrayList<>();
        }
        qaaspmMixdesignsJmfSievesList.add(item);
        item.setJmfId(this);
    }

    public void removeAspmMixdesignsJmfSievesList(QaaspmMixdesignsJmfSieves item) {
        if (qaaspmMixdesignsJmfSievesList != null && qaaspmMixdesignsJmfSievesList.size() > 0) {
            qaaspmMixdesignsJmfSievesList.remove(item);
            item.setJmfId(this);
        }
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
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaaspmMixdesignsJmf)) {
            return false;
        }
        QaaspmMixdesignsJmf other = (QaaspmMixdesignsJmf) object;

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
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignsJmf[ id=" + id + " ]";
    }
    
     public JmfMasterPojo generatePojo() {
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
