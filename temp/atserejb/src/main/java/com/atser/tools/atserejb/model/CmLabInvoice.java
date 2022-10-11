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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "CmLabInvoice.findByContractId", query = "SELECT c FROM CmLabInvoice c WHERE c.contractId = :contractId")
    , @NamedQuery(name = "CmLabInvoice.findByLabpoNo", query = "SELECT c FROM CmLabInvoice c WHERE c.labpoNo = :labpoNo")
    , @NamedQuery(name = "CmLabInvoice.findByLabpoAmount", query = "SELECT c FROM CmLabInvoice c WHERE c.labpoAmount = :labpoAmount")
    , @NamedQuery(name = "CmLabInvoice.findByTotalinvTodate", query = "SELECT c FROM CmLabInvoice c WHERE c.totalinvTodate = :totalinvTodate")
    , @NamedQuery(name = "CmLabInvoice.findByPercentInv", query = "SELECT c FROM CmLabInvoice c WHERE c.percentInv = :percentInv")
    , @NamedQuery(name = "CmLabInvoice.findByLastinvDate", query = "SELECT c FROM CmLabInvoice c WHERE c.lastinvDate = :lastinvDate")
    , @NamedQuery(name = "CmLabInvoice.findByComments", query = "SELECT c FROM CmLabInvoice c WHERE c.comments = :comments")
    , @NamedQuery(name = "CmLabInvoice.findByCreateBy", query = "SELECT c FROM CmLabInvoice c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmLabInvoice.findByCreateByIp", query = "SELECT c FROM CmLabInvoice c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmLabInvoice.findByLastModBy", query = "SELECT c FROM CmLabInvoice c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmLabInvoice.findByLastMod", query = "SELECT c FROM CmLabInvoice c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmLabInvoice.findByLastModIp", query = "SELECT c FROM CmLabInvoice c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmLabInvoice.findByVersion", query = "SELECT c FROM CmLabInvoice c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_LAB_INVOICE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmLabInvoice.findAll", query = "SELECT c FROM CmLabInvoice c")
    , @NamedQuery(name = "CmLabInvoice.findById", query = "SELECT c FROM CmLabInvoice c WHERE c.id = :id")})
public class CmLabInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Size(max = 100)
    @Column(name = "LABPO_NO")
    private String labpoNo;
    @Column(name = "LABPO_AMOUNT")
    private Double labpoAmount;
    @Column(name = "TOTALINV_TODATE")
    private Double totalinvTodate;
    @Size(max = 50)
    @Column(name = "PERCENT_INV")
    private String percentInv;
    @Column(name = "LASTINV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastinvDate;
    @Size(max = 1000)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public CmLabInvoice() {
    }

    public CmLabInvoice(BigDecimal id) {
        this.id = id;
    }

    public CmLabInvoice(BigDecimal id, BigInteger contractId) {
        this.id = id;
        this.contractId = contractId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public String getLabpoNo() {
        return labpoNo;
    }

    public void setLabpoNo(String labpoNo) {
        this.labpoNo = labpoNo;
    }

    public Double getLabpoAmount() {
        return labpoAmount;
    }

    public void setLabpoAmount(Double labpoAmount) {
        this.labpoAmount = labpoAmount;
    }

    public Double getTotalinvTodate() {
        return totalinvTodate;
    }

    public void setTotalinvTodate(Double totalinvTodate) {
        this.totalinvTodate = totalinvTodate;
    }

    public String getPercentInv() {
        return percentInv;
    }

    public void setPercentInv(String percentInv) {
        this.percentInv = percentInv;
    }

    public Date getLastinvDate() {
        return lastinvDate;
    }

    public void setLastinvDate(Date lastinvDate) {
        this.lastinvDate = lastinvDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmLabInvoice)) {
            return false;
        }
        CmLabInvoice other = (CmLabInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmLabInvoice[ id=" + id + " ]";
    }
    
}
