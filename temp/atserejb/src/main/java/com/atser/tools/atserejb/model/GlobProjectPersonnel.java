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
import javax.persistence.FetchType;
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
@Table(name = "GLOB_PROJECT_PERSONNEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectPersonnel.findAll", query = "SELECT g FROM GlobProjectPersonnel g")
    , @NamedQuery(name = "GlobProjectPersonnel.findById", query = "SELECT g FROM GlobProjectPersonnel g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectPersonnel.findByProjectId", query = "SELECT g FROM GlobProjectPersonnel g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectPersonnel.findByContactId", query = "SELECT g FROM GlobProjectPersonnel g WHERE g.contactId.id = :contactId")
    , @NamedQuery(name = "GlobProjectPersonnel.findByActive", query = "SELECT g FROM GlobProjectPersonnel g WHERE g.active = :active")})
public class GlobProjectPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PROJECT_PERSONNEL_ID_SEQ", sequenceName = "GLOB_PROJECT_PERSONNEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJECT_PERSONNEL_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobContact contactId;
    /*@Column(name = "CONTACT_ID")
    private BigInteger contactId;*/
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Column(name = "SHOW_DISPATCH", insertable = false)
    private Character showdispatch;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public GlobProjectPersonnel() {
    }

    public GlobProjectPersonnel(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public Character getActive() {
        return active;
    }

    public GlobContact getContactId() {
        return contactId;
    }

    public void setContactId(GlobContact contactId) {
        this.contactId = contactId;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getShowdispatch() {
        return showdispatch;
    }

    public void setShowdispatch(Character showdispatch) {
        this.showdispatch = showdispatch;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobProjectPersonnel)) {
            return false;
        }
        GlobProjectPersonnel other = (GlobProjectPersonnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectPersonnel[ id=" + id + " ]";
    }

}
