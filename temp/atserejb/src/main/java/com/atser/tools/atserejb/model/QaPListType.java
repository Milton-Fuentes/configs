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
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author droldan
 */
@Entity
@Table(name = "QA_PLIST_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPListType.findAll", query = "SELECT q FROM QaPListType q"),
    @NamedQuery(name = "QaPListType.findById", query = "SELECT q FROM QaPListType q WHERE q.id = :id")})
public class QaPListType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 200)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Size(max = 200)
    @Column(name = "DESCRIPT")
    private String descript;
    @JsonIgnore
    @OneToMany(mappedBy = "itemTypeId", fetch = FetchType.LAZY)
    private List<QaPlist> qaPlist;

    public QaPListType() {
    }

    public QaPListType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescript() {
        return descript;
    }

    public List<QaPlist> getQaPlist() {
        return qaPlist;
    }

    public void setQaPlist(List<QaPlist> qaPlist) {
        this.qaPlist = qaPlist;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.clientId);
        hash = 59 * hash + Objects.hashCode(this.itemType);
        hash = 59 * hash + Objects.hashCode(this.descript);
        hash = 59 * hash + Objects.hashCode(this.qaPlist);
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
        final QaPListType other = (QaPListType) obj;
        if (!Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        if (!Objects.equals(this.descript, other.descript)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.qaPlist, other.qaPlist)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaPListType[ id=" + id + " ]";
    }
}
