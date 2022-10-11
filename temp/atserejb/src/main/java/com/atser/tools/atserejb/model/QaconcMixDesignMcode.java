/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE QACONC_MIXDESIGN_MCODE SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "QACONC_MIXDESIGN_MCODE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcMixDesignMcode.findAll", query = "SELECT q FROM QaconcMixDesignMcode q"),
    @NamedQuery(name = "QaconcMixDesignMcode.findById", query = "SELECT q FROM QaconcMixDesignMcode q WHERE q.id = :id")})
public class QaconcMixDesignMcode implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_MIXDESIGN_MCODE_SEQ", sequenceName = "QACONC_MIXDESIGN_MCODE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_MIXDESIGN_MCODE_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Column(name = "MIX_ID")
    private BigInteger mixId;
    @NotNull
    @JoinColumn(name = "MATERIAL_ID")
    @ManyToOne(optional = true )
    private QmCvlFieldData materialId;
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 150)
    @Column(name = "MCODE")
    private String mcode;
    @Size(max = 255)
    @Column(name = "MTYPE")
    private String mtype;
    @Column(name = "SPEC_GRAVITY")
    private BigDecimal specGravity;
    @Column(name = "PCT_ABSORPTION")
    private BigDecimal pctAbsorption;
    @Column(name = "FF")
    private BigDecimal ff;  
    @Column(name = "SSIZE")
    private BigDecimal ssize;  
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
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
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaconcMixDesignMcode() {
    }

    public QaconcMixDesignMcode(BigDecimal id, BigInteger mixId, QmCvlFieldData materialId) {
        this.id = id;
        this.mixId = mixId;
        this.materialId = materialId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getMixId() {
        return mixId;
    }

    public void setMixId(BigInteger mixId) {
        this.mixId = mixId;
    }

    public QmCvlFieldData getMaterialId() {
        return materialId;
    }

    public void setMaterialId(QmCvlFieldData materialId) {
        this.materialId = materialId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public BigDecimal getSpecGravity() {
        return specGravity;
    }

    public void setSpecGravity(BigDecimal specGravity) {
        this.specGravity = specGravity;
    }

    public BigDecimal getPctAbsorption() {
        return pctAbsorption;
    }

    public void setPctAbsorption(BigDecimal pctAbsorption) {
        this.pctAbsorption = pctAbsorption;
    }

    public BigDecimal getFf() {
        return ff;
    }

    public void setFf(BigDecimal ff) {
        this.ff = ff;
    }

    public BigDecimal getSsize() {
        return ssize;
    }

    public void setSsize(BigDecimal ssize) {
        this.ssize = ssize;
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

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.mixId);
        hash = 17 * hash + Objects.hashCode(this.materialId);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.mcode);
        hash = 17 * hash + Objects.hashCode(this.mtype);
        hash = 17 * hash + Objects.hashCode(this.specGravity);
        hash = 17 * hash + Objects.hashCode(this.pctAbsorption);
        hash = 17 * hash + Objects.hashCode(this.ssize);
        hash = 17 * hash + Objects.hashCode(this.ff);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QaconcMixDesignMcode other = (QaconcMixDesignMcode) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mcode, other.mcode)) {
            return false;
        }
        if (!Objects.equals(this.mtype, other.mtype)) {
            return false;
        }
        if (!Objects.equals(this.mixId, other.mixId)) {
            return false;
        }
        if (!Objects.equals(this.materialId, other.materialId)) {
            return false;
        }
        if (!Objects.equals(this.specGravity, other.specGravity)) {
            return false;
        }
        if (!Objects.equals(this.pctAbsorption, other.pctAbsorption)) {
            return false;
        }
        if (!Objects.equals(this.ssize, other.ssize)) {
            return false;
        }
        if (!Objects.equals(this.ff, other.ff)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QaconcMixDesignMcode{" + "id=" + id + ", mixId=" + mixId + ", materialId=" + materialId + '}';
    }

    @Override
    public QaconcMixDesignMcode clone() {
        try {
            return (QaconcMixDesignMcode) super.clone();
        } catch (CloneNotSupportedException e) {
            return new QaconcMixDesignMcode(this.getId(), this.getMixId(), this.getMaterialId());
        }
    }
    
    
}
