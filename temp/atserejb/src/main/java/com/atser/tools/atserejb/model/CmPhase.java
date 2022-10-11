/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@NamedQuery(name = "CmPhase.findByPType", query = "SELECT c FROM CmPhase c WHERE c.pType = :pType"),
    @NamedQuery(name = "CmPhase.findByPName", query = "SELECT c FROM CmPhase c WHERE c.pName = :pName"),
    @NamedQuery(name = "CmPhase.findByPLetter", query = "SELECT c FROM CmPhase c WHERE c.pLetter = :pLetter"),
    @NamedQuery(name = "CmPhase.findByRemarks", query = "SELECT c FROM CmPhase c WHERE c.remarks = :remarks"),
    @NamedQuery(name = "CmPhase.findByActive", query = "SELECT c FROM CmPhase c WHERE c.active = :active"),
    @NamedQuery(name = "CmPhase.findByLastMod", query = "SELECT c FROM CmPhase c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmPhase.findByLastModBy", query = "SELECT c FROM CmPhase c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmPhase.findByLastModIp", query = "SELECT c FROM CmPhase c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmPhase.findByCreateBy", query = "SELECT c FROM CmPhase c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmPhase.findByCreateByIp", query = "SELECT c FROM CmPhase c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmPhase.findByCreateDate", query = "SELECT c FROM CmPhase c WHERE c.createDate = :createDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_PHASE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmPhase.findAll", query = "SELECT c FROM CmPhase c"),
    @NamedQuery(name = "CmPhase.findById", query = "SELECT c FROM CmPhase c WHERE c.id = :id")})
public class CmPhase implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "P_TYPE")
    private String pType;
    @Size(max = 50)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 10)
    @Column(name = "P_LETTER")
    private String pLetter;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(mappedBy = "phaseId")
    private List<CmActivity> cmActivityList;

    public CmPhase() {
    }

    public CmPhase(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPLetter() {
        return pLetter;
    }

    public void setPLetter(String pLetter) {
        this.pLetter = pLetter;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    @XmlTransient
    public List<CmActivity> getCmActivityList() {
        return cmActivityList;
    }

    public void setCmActivityList(List<CmActivity> cmActivityList) {
        this.cmActivityList = cmActivityList;
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
        if (!(object instanceof CmPhase)) {
            return false;
        }
        CmPhase other = (CmPhase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmPhase[ id=" + id + " ]";
    }
    
}
