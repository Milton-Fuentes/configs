/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "WS_REPOSITORY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsRepository.findAll", query = "SELECT w FROM WsRepository w")
    , @NamedQuery(name = "WsRepository.findById", query = "SELECT w FROM WsRepository w WHERE w.id = :id")
    , @NamedQuery(name = "WsRepository.findByName", query = "SELECT w FROM WsRepository w WHERE w.name = :name")
    , @NamedQuery(name = "WsRepository.findByPath", query = "SELECT w FROM WsRepository w WHERE w.path = :path")
    , @NamedQuery(name = "WsRepository.findByHttpmethod", query = "SELECT w FROM WsRepository w WHERE w.httpmethod = :httpmethod")
    , @NamedQuery(name = "WsRepository.findByParameters", query = "SELECT w FROM WsRepository w WHERE w.parameters = :parameters")
    , @NamedQuery(name = "WsRepository.findByDescription", query = "SELECT w FROM WsRepository w WHERE w.description = :description")})
public class WsRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "WS_REPOSITORY_SEQ", sequenceName = "WS_REPOSITORY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_REPOSITORY_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PATH")
    private String path;
    @Size(max = 50)
    @Column(name = "HTTPMETHOD")
    private String httpmethod;
    @Size(max = 255)
    @Column(name = "PARAMETERS")
    private String parameters;
    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "REQUEST_EXAMPLE")
    private String requestExample;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid", fetch = FetchType.LAZY)
    private List<WsRigths> wsRigthsList;

    public WsRepository() {
    }

    public WsRepository(BigDecimal id) {
        this.id = id;
    }

    public WsRepository(BigDecimal id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpmethod() {
        return httpmethod;
    }

    public void setHttpmethod(String httpmethod) {
        this.httpmethod = httpmethod;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestExample() {
        return requestExample;
    }

    public void setRequestExample(String requestExample) {
        this.requestExample = requestExample;
    }

    @XmlTransient
    public List<WsRigths> getWsRigthsList() {
        return wsRigthsList;
    }

    public void setWsRigthsList(List<WsRigths> wsRigthsList) {
        this.wsRigthsList = wsRigthsList;
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
        if (!(object instanceof WsRepository)) {
            return false;
        }
        WsRepository other = (WsRepository) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsRepository[ id=" + id + " ]";
    }
    
}
