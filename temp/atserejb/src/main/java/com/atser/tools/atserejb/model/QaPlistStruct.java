/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfuentes
 */
@Entity
@Table(name = "QA_PLIST_STRUCT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPlistStruct.findAll", query = "SELECT q FROM QaPlistStruct q"),
    @NamedQuery(name = "QaPlistStruct.findById", query = "SELECT q FROM QaPlistStruct q WHERE q.id = :id")})
public class QaPlistStruct implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ITEM_TYPE_ID")
    private Integer itemTypeId;
    @Size(max = 200)
    @Column(name = "STRUCT_TYPE")
    private String structType;
    @Size(max = 200)
    @Column(name = "DESCRIPT")
    private String descript;
    @JsonIgnore
    @OneToMany(mappedBy = "structId", fetch = FetchType.LAZY)
    private List<QaPlist> qaPlist;

    public QaPlistStruct() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getStructType() {
        return structType;
    }

    public void setStructType(String structType) {
        this.structType = structType;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.itemTypeId);
        hash = 13 * hash + Objects.hashCode(this.structType);
        hash = 13 * hash + Objects.hashCode(this.descript);
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
        final QaPlistStruct other = (QaPlistStruct) obj;
        if (!Objects.equals(this.structType, other.structType)) {
            return false;
        }
        if (!Objects.equals(this.descript, other.descript)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.itemTypeId, other.itemTypeId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QaPlistStruct{" + "id=" + id + ", itemTypeId=" + itemTypeId + ", structType=" + structType + ", descript=" + descript + '}';
    }
    

}
