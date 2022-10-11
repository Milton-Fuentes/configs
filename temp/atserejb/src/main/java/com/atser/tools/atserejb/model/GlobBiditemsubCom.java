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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobBiditemsubCom.findByItemId", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.itemId = :itemId"),
    @NamedQuery(name = "GlobBiditemsubCom.findBySubItemId", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.subItemId = :subItemId"),
    @NamedQuery(name = "GlobBiditemsubCom.findByRemarks", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField1", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField2", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField3", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field3 = :field3"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField4", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field4 = :field4"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField5", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field5 = :field5"),
    @NamedQuery(name = "GlobBiditemsubCom.findByField6", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.field6 = :field6"),
    @NamedQuery(name = "GlobBiditemsubCom.findByCreateBy", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobBiditemsubCom.findByCreateByIp", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobBiditemsubCom.findByLastModBy", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobBiditemsubCom.findByLastMod", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobBiditemsubCom.findByLastModIp", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobBiditemsubCom.findByVersion", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.version = :version"),
    @NamedQuery(name = "GlobBiditemsubCom.findBySpecPid", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.specPid = :specPid")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_BIDITEMSUB_COM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobBiditemsubCom.findAll", query = "SELECT g FROM GlobBiditemsubCom g"),
    @NamedQuery(name = "GlobBiditemsubCom.findById", query = "SELECT g FROM GlobBiditemsubCom g WHERE g.id = :id")})
public class GlobBiditemsubCom implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_biditemsub_com_id_seq", sequenceName = "glob_biditemsub_com_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_biditemsub_com_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_ITEM_ID")
    private BigInteger subItemId;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
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
    @Column(name = "SPEC_PID")
    private BigInteger specPid;

    public GlobBiditemsubCom() {
    }

    public GlobBiditemsubCom(BigDecimal id) {
        this.id = id;
    }

    public GlobBiditemsubCom(BigDecimal id, BigInteger itemId, BigInteger subItemId) {
        this.id = id;
        this.itemId = itemId;
        this.subItemId = subItemId;
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

    public BigInteger getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(BigInteger subItemId) {
        this.subItemId = subItemId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    public BigInteger getSpecPid() {
        return specPid;
    }

    public void setSpecPid(BigInteger specPid) {
        this.specPid = specPid;
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
        if (!(object instanceof GlobBiditemsubCom)) {
            return false;
        }
        GlobBiditemsubCom other = (GlobBiditemsubCom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobBiditemsubCom[ id=" + id + " ]";
    }
    
}
