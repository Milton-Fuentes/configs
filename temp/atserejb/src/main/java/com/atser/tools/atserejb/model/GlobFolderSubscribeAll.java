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
@Table(name = "GLOB_FOLDER_SUBSCRIBE_ALL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderSubscribeAll.findAll", query = "SELECT g FROM GlobFolderSubscribeAll g"),
    @NamedQuery(name = "GlobFolderSubscribeAll.findById", query = "SELECT g FROM GlobFolderSubscribeAll g WHERE g.id = :id"),
    @NamedQuery(name = "GlobFolderSubscribeAll.findByFolderId", query = "SELECT g FROM GlobFolderSubscribeAll g WHERE g.folderId = :folderId")})
public class GlobFolderSubscribeAll implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_FOLDER_SUBSCRIBE_A_ID_SEQ", sequenceName = "GLOB_FOLDER_SUBSCRIBE_A_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_FOLDER_SUBSCRIBE_A_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "FOLDER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobFolder folderId;
    @JoinColumn(name = "SUBSCRIBER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobUsers subscriberId;

    public GlobFolderSubscribeAll() {
    }

    public GlobFolderSubscribeAll(BigDecimal id) {
        this.id = id;
    }

    public GlobFolderSubscribeAll(BigDecimal id, GlobFolder folderId) {
        this.id = id;
        this.folderId = folderId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobFolder getFolderId() {
        return folderId;
    }

    public void setFolderId(GlobFolder folderId) {
        this.folderId = folderId;
    }

    public GlobUsers getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(GlobUsers subscriberId) {
        this.subscriberId = subscriberId;
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
        if (!(object instanceof GlobFolderSubscribeAll)) {
            return false;
        }
        GlobFolderSubscribeAll other = (GlobFolderSubscribeAll) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderSubscribeAll[ id=" + id + " ]";
    }

}
