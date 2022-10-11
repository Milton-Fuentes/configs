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
, @NamedQuery(name = "CmPersoninfoSecondary.findByPersonId", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.personId = :personId")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByTitle", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.title = :title")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByPersoninfoTypeId", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.personinfoTypeId = :personinfoTypeId")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByFirm", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.firm = :firm")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField1", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField2", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField3", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField4", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField5", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField6", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField7", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByField8", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.field8 = :field8")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByCreateDate", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByCreateBy", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.createBy = :createBy")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByCreateByIp", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.createByIp = :createByIp")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByLastMod", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.lastMod = :lastMod")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByLastModBy", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.lastModBy = :lastModBy")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByLastModIp", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.lastModIp = :lastModIp")
    , @NamedQuery(name = "CmPersoninfoSecondary.findByActive", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.active = :active")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_PERSONINFO_SECONDARY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmPersoninfoSecondary.findAll", query = "SELECT c FROM CmPersoninfoSecondary c")
    , @NamedQuery(name = "CmPersoninfoSecondary.findById", query = "SELECT c FROM CmPersoninfoSecondary c WHERE c.id = :id")})
public class CmPersoninfoSecondary implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSON_ID")
    private BigInteger personId;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONINFO_TYPE_ID")
    private BigInteger personinfoTypeId;
    @Size(max = 200)
    @Column(name = "FIRM")
    private String firm;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    private Double field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
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
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "ACTIVE")
    private Character active;

    public CmPersoninfoSecondary() {
    }

    public CmPersoninfoSecondary(BigDecimal id) {
        this.id = id;
    }

    public CmPersoninfoSecondary(BigDecimal id, BigInteger personId, BigInteger personinfoTypeId) {
        this.id = id;
        this.personId = personId;
        this.personinfoTypeId = personinfoTypeId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPersonId() {
        return personId;
    }

    public void setPersonId(BigInteger personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getPersoninfoTypeId() {
        return personinfoTypeId;
    }

    public void setPersoninfoTypeId(BigInteger personinfoTypeId) {
        this.personinfoTypeId = personinfoTypeId;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
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

    public Double getField6() {
        return field6;
    }

    public void setField6(Double field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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
        if (!(object instanceof CmPersoninfoSecondary)) {
            return false;
        }
        CmPersoninfoSecondary other = (CmPersoninfoSecondary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmPersoninfoSecondary[ id=" + id + " ]";
    }
    
}
