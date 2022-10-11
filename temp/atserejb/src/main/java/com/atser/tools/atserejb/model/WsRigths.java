/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author droldan
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "WS_RIGTHS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsRigths.findAll", query = "SELECT w FROM WsRigths w")
    , @NamedQuery(name = "WsRigths.findById", query = "SELECT w FROM WsRigths w WHERE w.id = :id")
    , @NamedQuery(name = "WsRigths.findByCidr", query = "SELECT w FROM WsRigths w WHERE w.cidr = :cidr")
    , @NamedQuery(name = "WsRigths.findByRmode", query = "SELECT w FROM WsRigths w WHERE w.rmode = :rmode")})
public class WsRigths implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "WS_RIGTHS_SEQ", sequenceName = "WS_RIGTHS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_RIGTHS_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CIDR")
    private String cidr;
    @Size(max = 50)
    @Column(name = "RMODE")
    private String rmode;
    @JoinColumn(name = "SERVICEID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private WsRepository serviceid;
    @JsonIgnore
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private WsUsers userid;

    public WsRigths() {
    }

    public WsRigths(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getRmode() {
        return rmode;
    }

    public void setRmode(String rmode) {
        this.rmode = rmode;
    }

    public WsRepository getServiceid() {
        return serviceid;
    }

    public void setServiceid(WsRepository serviceid) {
        this.serviceid = serviceid;
    }

    public WsUsers getUserid() {
        return userid;
    }

    public void setUserid(WsUsers userid) {
        this.userid = userid;
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
        if (!(object instanceof WsRigths)) {
            return false;
        }
        WsRigths other = (WsRigths) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsRigths[ id=" + id + " ]";
    }
    
}
