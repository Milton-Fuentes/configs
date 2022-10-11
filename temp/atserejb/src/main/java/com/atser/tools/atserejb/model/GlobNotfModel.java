/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_NOTF_MODEL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobNotfModel.findAll", query = "SELECT g FROM GlobNotfModel g"),
    @NamedQuery(name = "GlobNotfModel.findById", query = "SELECT g FROM GlobNotfModel g WHERE g.id = :id"),
    @NamedQuery(name = "GlobNotfModel.findByRefId", query = "SELECT g FROM GlobNotfModel g WHERE g.refId = :refId"),
    @NamedQuery(name = "GlobNotfModel.findByClientId", query = "SELECT g FROM GlobNotfModel g WHERE g.clientId = :clientId")})
public class GlobNotfModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_NOTF_MODEL_SEQ", sequenceName = "GLOB_NOTF_MODEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_NOTF_MODEL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "REF_ID")
    private BigInteger refId;
    @Size(max = 255)
    @Column(name = "MODEL_TYPE")
    private String modelType;
    @JsonSkipXssSerialization
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public GlobNotfModel() {
    }

    public GlobNotfModel(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRefId() {
        return refId;
    }

    public void setRefId(BigInteger refId) {
        this.refId = refId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if (!(object instanceof GlobNotfModel)) {
            return false;
        }
        GlobNotfModel other = (GlobNotfModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobNotfModel[ id=" + id + " ]";
    }

}
