/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "CmFormTrace.findByCmFormId", query = "SELECT c FROM CmFormTrace c WHERE c.cmFormId = :cmFormId"),
    @NamedQuery(name = "CmFormTrace.findByTraceNo", query = "SELECT c FROM CmFormTrace c WHERE c.traceNo = :traceNo"),
    @NamedQuery(name = "CmFormTrace.findByAaId", query = "SELECT c FROM CmFormTrace c WHERE c.aaId = :aaId"),
    @NamedQuery(name = "CmFormTrace.findByBbId", query = "SELECT c FROM CmFormTrace c WHERE c.bbId = :bbId"),
    @NamedQuery(name = "CmFormTrace.findByBbNo", query = "SELECT c FROM CmFormTrace c WHERE c.bbNo = :bbNo"),
    @NamedQuery(name = "CmFormTrace.findByCcId", query = "SELECT c FROM CmFormTrace c WHERE c.ccId = :ccId"),
    @NamedQuery(name = "CmFormTrace.findByDdId", query = "SELECT c FROM CmFormTrace c WHERE c.ddId = :ddId"),
    @NamedQuery(name = "CmFormTrace.findByEeId", query = "SELECT c FROM CmFormTrace c WHERE c.eeId = :eeId"),
    @NamedQuery(name = "CmFormTrace.findByFfId", query = "SELECT c FROM CmFormTrace c WHERE c.ffId = :ffId"),
    @NamedQuery(name = "CmFormTrace.findByGgId", query = "SELECT c FROM CmFormTrace c WHERE c.ggId = :ggId"),
    @NamedQuery(name = "CmFormTrace.findByHhTrace", query = "SELECT c FROM CmFormTrace c WHERE c.hhTrace = :hhTrace"),
    @NamedQuery(name = "CmFormTrace.findByMmId", query = "SELECT c FROM CmFormTrace c WHERE c.mmId = :mmId"),
    @NamedQuery(name = "CmFormTrace.findByNnId", query = "SELECT c FROM CmFormTrace c WHERE c.nnId = :nnId"),
    @NamedQuery(name = "CmFormTrace.findByPpId", query = "SELECT c FROM CmFormTrace c WHERE c.ppId = :ppId"),
    @NamedQuery(name = "CmFormTrace.findByLastMod", query = "SELECT c FROM CmFormTrace c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmFormTrace.findByLastModBy", query = "SELECT c FROM CmFormTrace c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmFormTrace.findByLastModIp", query = "SELECT c FROM CmFormTrace c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmFormTrace.findByCreateDate", query = "SELECT c FROM CmFormTrace c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CmFormTrace.findByCreateBy", query = "SELECT c FROM CmFormTrace c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmFormTrace.findByCreateByIp", query = "SELECT c FROM CmFormTrace c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmFormTrace.findByVersion", query = "SELECT c FROM CmFormTrace c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_TRACE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormTrace.findAll", query = "SELECT c FROM CmFormTrace c"),
    @NamedQuery(name = "CmFormTrace.findById", query = "SELECT c FROM CmFormTrace c WHERE c.id = :id")})
public class CmFormTrace implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CM_FORM_ID")
    private BigInteger cmFormId;
    @Size(max = 500)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Column(name = "AA_ID")
    private BigInteger aaId;
    @Column(name = "BB_ID")
    private BigInteger bbId;
    @Size(max = 100)
    @Column(name = "BB_NO")
    private String bbNo;
    @Column(name = "CC_ID")
    private BigInteger ccId;
    @Column(name = "DD_ID")
    private BigInteger ddId;
    @Column(name = "EE_ID")
    private BigInteger eeId;
    @Column(name = "FF_ID")
    private BigInteger ffId;
    @Column(name = "GG_ID")
    private BigInteger ggId;
    @Size(max = 100)
    @Column(name = "HH_TRACE")
    private String hhTrace;
    @Column(name = "MM_ID")
    private BigInteger mmId;
    @Column(name = "NN_ID")
    private BigInteger nnId;
    @Column(name = "PP_ID")
    private BigInteger ppId;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 30)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public CmFormTrace() {
    }

    public CmFormTrace(BigDecimal id) {
        this.id = id;
    }

    public CmFormTrace(BigDecimal id, BigInteger cmFormId) {
        this.id = id;
        this.cmFormId = cmFormId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCmFormId() {
        return cmFormId;
    }

    public void setCmFormId(BigInteger cmFormId) {
        this.cmFormId = cmFormId;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public BigInteger getAaId() {
        return aaId;
    }

    public void setAaId(BigInteger aaId) {
        this.aaId = aaId;
    }

    public BigInteger getBbId() {
        return bbId;
    }

    public void setBbId(BigInteger bbId) {
        this.bbId = bbId;
    }

    public String getBbNo() {
        return bbNo;
    }

    public void setBbNo(String bbNo) {
        this.bbNo = bbNo;
    }

    public BigInteger getCcId() {
        return ccId;
    }

    public void setCcId(BigInteger ccId) {
        this.ccId = ccId;
    }

    public BigInteger getDdId() {
        return ddId;
    }

    public void setDdId(BigInteger ddId) {
        this.ddId = ddId;
    }

    public BigInteger getEeId() {
        return eeId;
    }

    public void setEeId(BigInteger eeId) {
        this.eeId = eeId;
    }

    public BigInteger getFfId() {
        return ffId;
    }

    public void setFfId(BigInteger ffId) {
        this.ffId = ffId;
    }

    public BigInteger getGgId() {
        return ggId;
    }

    public void setGgId(BigInteger ggId) {
        this.ggId = ggId;
    }

    public String getHhTrace() {
        return hhTrace;
    }

    public void setHhTrace(String hhTrace) {
        this.hhTrace = hhTrace;
    }

    public BigInteger getMmId() {
        return mmId;
    }

    public void setMmId(BigInteger mmId) {
        this.mmId = mmId;
    }

    public BigInteger getNnId() {
        return nnId;
    }

    public void setNnId(BigInteger nnId) {
        this.nnId = nnId;
    }

    public BigInteger getPpId() {
        return ppId;
    }

    public void setPpId(BigInteger ppId) {
        this.ppId = ppId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof CmFormTrace)) {
            return false;
        }
        CmFormTrace other = (CmFormTrace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormTrace[ id=" + id + " ]";
    }
    
}
