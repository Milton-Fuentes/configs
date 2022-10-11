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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobNotfUserModel.findByUserId", query = "SELECT g FROM GlobNotfUserModel g WHERE g.userId = :userId"),
    @NamedQuery(name = "GlobNotfUserModel.findByModelId", query = "SELECT g FROM GlobNotfUserModel g WHERE g.modelId = :modelId"),
    @NamedQuery(name = "GlobNotfUserModel.findByClientId", query = "SELECT g FROM GlobNotfUserModel g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobNotfUserModel.findByModule", query = "SELECT g FROM GlobNotfUserModel g WHERE g.module = :module"),
    @NamedQuery(name = "GlobNotfUserModel.findByFunctionality", query = "SELECT g FROM GlobNotfUserModel g WHERE g.functionality = :functionality"),
    @NamedQuery(name = "GlobNotfUserModel.findByNtfType", query = "SELECT g FROM GlobNotfUserModel g WHERE g.ntfType = :ntfType"),
    @NamedQuery(name = "GlobNotfUserModel.findByStatus", query = "SELECT g FROM GlobNotfUserModel g WHERE g.status = :status")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_NOTF_USER_MODEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobNotfUserModel.findAll", query = "SELECT g FROM GlobNotfUserModel g"),
    @NamedQuery(name = "GlobNotfUserModel.findById", query = "SELECT g FROM GlobNotfUserModel g WHERE g.id = :id")})
public class GlobNotfUserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_NOTF_USER_MODEL_SEQ", sequenceName = "GLOB_NOTF_USER_MODEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_NOTF_USER_MODEL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JsonBackReference
    @NotNull
    @JoinColumn(name = "USER_ID")
    @ManyToOne(optional = false)
    private GlobNotfUser userId;
    @NotNull
    @JoinColumn(name = "MODEL_ID")
    @ManyToOne(optional = false)
    private GlobNotfModel modelId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "MODULE")
    private String module;
    @Size(max = 255)
    @Column(name = "FUNCTIONALITY")
    private String functionality;
    @Size(max = 50)
    @Column(name = "NTF_TYPE")
    private String ntfType;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;

    public GlobNotfUserModel() {
    }

    public GlobNotfUserModel(BigDecimal id) {
        this.id = id;
    }

    public GlobNotfUserModel(BigDecimal id, GlobNotfUser userId, GlobNotfModel modelId) {
        this.id = id;
        this.userId = userId;
        this.modelId = modelId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobNotfUser getUserId() {
        return userId;
    }

    public void setUserId(GlobNotfUser userId) {
        this.userId = userId;
    }

    public GlobNotfModel getModelId() {
        return modelId;
    }

    public void setModelId(GlobNotfModel modelId) {
        this.modelId = modelId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getNtfType() {
        return ntfType;
    }

    public void setNtfType(String ntfType) {
        this.ntfType = ntfType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof GlobNotfUserModel)) {
            return false;
        }
        GlobNotfUserModel other = (GlobNotfUserModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobNotfUserModel[ id=" + id + " ]";
    }

}
