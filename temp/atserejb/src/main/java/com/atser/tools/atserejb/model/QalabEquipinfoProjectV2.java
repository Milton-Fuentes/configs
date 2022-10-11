/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QALAB_EQUIPINFO_PROJECT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquipinfoProjectV2.findAll", query = "SELECT q FROM QalabEquipinfoProjectV2 q"),
    @NamedQuery(name = "QalabEquipinfoProjectV2.findById", query = "SELECT q FROM QalabEquipinfoProjectV2 q WHERE q.id = :id")})
public class QalabEquipinfoProjectV2 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "QALAB_EQUIPINFO_PROJECT_SEQ", sequenceName = "QALAB_EQUIPINFO_PROJECT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_EQUIPINFO_PROJECT_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "EQUIP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QalabEquipinfoV2 equipId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

    public QalabEquipinfoProjectV2() {
    }

    public QalabEquipinfoProjectV2(QalabEquipinfoV2 equipId, BigInteger projectId) {
        this.equipId = equipId;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QalabEquipinfoV2 getEquipId() {
        return equipId;
    }

    public void setEquipId(QalabEquipinfoV2 equipId) {
        this.equipId = equipId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.equipId);
        hash = 89 * hash + Objects.hashCode(this.projectId);
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
        final QalabEquipinfoProjectV2 other = (QalabEquipinfoProjectV2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.equipId, other.equipId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "QalabEquipinfoProjectV2{" + "id=" + id + '}';
    }
    
}
