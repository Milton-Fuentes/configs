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
@NamedQuery(name = "CmFormItem.findByCmFormId", query = "SELECT c FROM CmFormItem c WHERE c.cmFormId = :cmFormId"),
    @NamedQuery(name = "CmFormItem.findByItemNo", query = "SELECT c FROM CmFormItem c WHERE c.itemNo = :itemNo"),
    @NamedQuery(name = "CmFormItem.findByItemDesc", query = "SELECT c FROM CmFormItem c WHERE c.itemDesc = :itemDesc"),
    @NamedQuery(name = "CmFormItem.findByActive", query = "SELECT c FROM CmFormItem c WHERE c.active = :active"),
    @NamedQuery(name = "CmFormItem.findByCreateDate", query = "SELECT c FROM CmFormItem c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CmFormItem.findByCreateBy", query = "SELECT c FROM CmFormItem c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmFormItem.findByCreateByIp", query = "SELECT c FROM CmFormItem c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmFormItem.findByLastMod", query = "SELECT c FROM CmFormItem c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmFormItem.findByLastModBy", query = "SELECT c FROM CmFormItem c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmFormItem.findByLastModIp", query = "SELECT c FROM CmFormItem c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmFormItem.findByVersion", query = "SELECT c FROM CmFormItem c WHERE c.version = :version"),
    @NamedQuery(name = "CmFormItem.findByNoCopies", query = "SELECT c FROM CmFormItem c WHERE c.noCopies = :noCopies")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormItem.findAll", query = "SELECT c FROM CmFormItem c"),
    @NamedQuery(name = "CmFormItem.findById", query = "SELECT c FROM CmFormItem c WHERE c.id = :id")})
public class CmFormItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CM_FORM_ID")
    private BigInteger cmFormId;
    @Size(max = 255)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 4000)
    @Column(name = "ITEM_DESC")
    private String itemDesc;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 50)
    @Column(name = "NO_COPIES")
    private String noCopies;

    public CmFormItem() {
    }

    public CmFormItem(BigDecimal id) {
        this.id = id;
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

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getNoCopies() {
        return noCopies;
    }

    public void setNoCopies(String noCopies) {
        this.noCopies = noCopies;
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
        if (!(object instanceof CmFormItem)) {
            return false;
        }
        CmFormItem other = (CmFormItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormItem[ id=" + id + " ]";
    }
    
}
