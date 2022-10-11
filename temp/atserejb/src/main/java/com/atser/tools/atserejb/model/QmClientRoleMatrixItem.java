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
@NamedQuery(name = "QmClientRoleMatrixItem.findByItemName", query = "SELECT q FROM QmClientRoleMatrixItem q WHERE q.itemName = :itemName"),
    @NamedQuery(name = "QmClientRoleMatrixItem.findByItemCaption", query = "SELECT q FROM QmClientRoleMatrixItem q WHERE q.itemCaption = :itemCaption"),
    @NamedQuery(name = "QmClientRoleMatrixItem.findByItemType", query = "SELECT q FROM QmClientRoleMatrixItem q WHERE q.itemType = :itemType"),
    @NamedQuery(name = "QmClientRoleMatrixItem.findByItemOrder", query = "SELECT q FROM QmClientRoleMatrixItem q WHERE q.itemOrder = :itemOrder")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QM_CLIENT_ROLE_MATRIX_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmClientRoleMatrixItem.findAll", query = "SELECT q FROM QmClientRoleMatrixItem q"),
    @NamedQuery(name = "QmClientRoleMatrixItem.findById", query = "SELECT q FROM QmClientRoleMatrixItem q WHERE q.id = :id")})
public class QmClientRoleMatrixItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Size(max = 500)
    @Column(name = "ITEM_CAPTION")
    private String itemCaption;
    @Size(max = 50)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Column(name = "ITEM_ORDER")
    private BigInteger itemOrder;

    public QmClientRoleMatrixItem() {
    }

    public QmClientRoleMatrixItem(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCaption() {
        return itemCaption;
    }

    public void setItemCaption(String itemCaption) {
        this.itemCaption = itemCaption;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigInteger getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(BigInteger itemOrder) {
        this.itemOrder = itemOrder;
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
        if (!(object instanceof QmClientRoleMatrixItem)) {
            return false;
        }
        QmClientRoleMatrixItem other = (QmClientRoleMatrixItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmClientRoleMatrixItem[ id=" + id + " ]";
    }
    
}
