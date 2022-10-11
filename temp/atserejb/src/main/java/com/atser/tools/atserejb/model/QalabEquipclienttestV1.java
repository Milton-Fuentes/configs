/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QALAB_EQUIPCLIENTTEST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquipclienttestV1.findAll", query = "SELECT q FROM QalabEquipclienttestV1 q")
    , @NamedQuery(name = "QalabEquipclienttestV1.findById", query = "SELECT q FROM QalabEquipclienttestV1 q WHERE q.id = :id")
    , @NamedQuery(name = "QalabEquipclienttestV1.findByClienttestid", query = "SELECT q FROM QalabEquipclienttestV1 q WHERE q.clienttestid = :clienttestid")})
public class QalabEquipclienttestV1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QALAB_EQUIPCLIENTTEST_SEQ", sequenceName = "QALAB_EQUIPCLIENTTEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_EQUIPCLIENTTEST_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTTESTID")
    private BigInteger clienttestid;
    @JoinColumn(name = "EQUIPINFOID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @JsonBackReference
    private QalabEquipinfoV1 equipinfoid;

    public QalabEquipclienttestV1() {
    }

    public QalabEquipclienttestV1(BigDecimal id) {
        this.id = id;
    }

    public QalabEquipclienttestV1(BigDecimal id, BigInteger clienttestid) {
        this.id = id;
        this.clienttestid = clienttestid;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClienttestid() {
        return clienttestid;
    }

    public void setClienttestid(BigInteger clienttestid) {
        this.clienttestid = clienttestid;
    }

    public QalabEquipinfoV1 getEquipinfoid() {
        return equipinfoid;
    }

    public void setEquipinfoid(QalabEquipinfoV1 equipinfoid) {
        this.equipinfoid = equipinfoid;
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
        if (!(object instanceof QalabEquipclienttestV1)) {
            return false;
        }
        QalabEquipclienttestV1 other = (QalabEquipclienttestV1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabEquipclienttestV1[ id=" + id + " ]";
    }

}
