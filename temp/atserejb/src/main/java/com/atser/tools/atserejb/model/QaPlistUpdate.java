/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.jasper.qa.punchlist.QaPunchUpdateTO;
import com.atser.tools.atserutil.string.StringSupport;
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
@NamedQuery(name = "QaPlistUpdate.findByItemId", query = "SELECT q FROM QaPlistUpdate q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaPlistUpdate.findByUpdateNo", query = "SELECT q FROM QaPlistUpdate q WHERE q.updateNo = :updateNo"),
    @NamedQuery(name = "QaPlistUpdate.findByUpdateDate", query = "SELECT q FROM QaPlistUpdate q WHERE q.updateDate = :updateDate"),
    @NamedQuery(name = "QaPlistUpdate.findByUpdateBy", query = "SELECT q FROM QaPlistUpdate q WHERE q.updateBy = :updateBy"),
    @NamedQuery(name = "QaPlistUpdate.findByDescription", query = "SELECT q FROM QaPlistUpdate q WHERE q.description = :description"),
    @NamedQuery(name = "QaPlistUpdate.findByItemPhoto", query = "SELECT q FROM QaPlistUpdate q WHERE q.itemPhoto = :itemPhoto"),
    @NamedQuery(name = "QaPlistUpdate.findByLastMod", query = "SELECT q FROM QaPlistUpdate q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaPlistUpdate.findByLastModBy", query = "SELECT q FROM QaPlistUpdate q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaPlistUpdate.findByLastModIp", query = "SELECT q FROM QaPlistUpdate q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaPlistUpdate.findByCreateBy", query = "SELECT q FROM QaPlistUpdate q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaPlistUpdate.findByCreateByIp", query = "SELECT q FROM QaPlistUpdate q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaPlistUpdate.findByCreateDate", query = "SELECT q FROM QaPlistUpdate q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaPlistUpdate.findByVersion", query = "SELECT q FROM QaPlistUpdate q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_PLIST_UPDATE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPlistUpdate.findAll", query = "SELECT q FROM QaPlistUpdate q"),
    @NamedQuery(name = "QaPlistUpdate.findById", query = "SELECT q FROM QaPlistUpdate q WHERE q.id = :id")})
public class QaPlistUpdate implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Size(max = 200)
    @Column(name = "UPDATE_NO")
    private String updateNo;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 200)
    @Column(name = "UPDATE_BY")
    private String updateBy;
    @Size(max = 3000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 200)
    @Column(name = "ITEM_PHOTO")
    private String itemPhoto;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
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
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public QaPlistUpdate() {
    }

    public QaPlistUpdate(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public QaPunchUpdateTO convertToQaPunchUpdateTO() {
        QaPunchUpdateTO obj = new QaPunchUpdateTO();
        obj.setUpdateNo(StringSupport.emptyOnNull(this.getUpdateNo()));
        obj.setUpdateDate(DateSupport.formatDate(this.getUpdateDate(), DateSupport.FORMAT_US));
        obj.setUpdateBy(StringSupport.emptyOnNull(this.getUpdateBy()));
        obj.setDescription(StringSupport.emptyOnNull(this.getDescription()));
        return obj;
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
        if (!(object instanceof QaPlistUpdate)) {
            return false;
        }
        QaPlistUpdate other = (QaPlistUpdate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaPlistUpdate[ id=" + id + " ]";
    }

}
