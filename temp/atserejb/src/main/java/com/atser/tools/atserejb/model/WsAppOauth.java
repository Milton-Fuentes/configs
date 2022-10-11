/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "WS_APP_OAUTH", catalog = "", schema = "ORACLE")
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsAppOauth.findAll", query = "SELECT w FROM WsAppOauth w"),
    @NamedQuery(name = "WsAppOauth.findById", query = "SELECT w FROM WsAppOauth w WHERE w.id = :id"),
    @NamedQuery(name = "WsAppOauth.findByAccessToken", query = "SELECT w FROM WsAppOauth w WHERE w.accessToken = :accessToken"),
    @NamedQuery(name = "WsAppOauth.findByRefreshToken", query = "SELECT w FROM WsAppOauth w WHERE w.refreshToken = :refreshToken"),
    @NamedQuery(name = "WsAppOauth.findByCreated", query = "SELECT w FROM WsAppOauth w WHERE w.created = :created"),
    @NamedQuery(name = "WsAppOauth.findByExpiryDate", query = "SELECT w FROM WsAppOauth w WHERE w.expiryDate = :expiryDate"),
    @NamedQuery(name = "WsAppOauth.findByWebServerRedirect", query = "SELECT w FROM WsAppOauth w WHERE w.webServerRedirect = :webServerRedirect"),
    @NamedQuery(name = "WsAppOauth.findByActive", query = "SELECT w FROM WsAppOauth w WHERE w.active = :active"),
    @NamedQuery(name = "WsAppOauth.findByClientId", query = "SELECT w FROM WsAppOauth w WHERE w.clientId = :clientId")})
public class WsAppOauth implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "WS_APP_OAUTH_SEQ", sequenceName = "WS_APP_OAUTH_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_APP_OAUTH_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACCESS_TOKEN")
    private String accessToken;
    @Size(max = 255)
    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;
    @Basic(optional = false)
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @Size(max = 512)
    @Column(name = "WEB_SERVER_REDIRECT")
    private String webServerRedirect;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GlobUsers userid;

    public WsAppOauth() {
    }

    public WsAppOauth(BigDecimal id) {
        this.id = id;
    }

    public WsAppOauth(BigDecimal id, String accessToken, Date created) {
        this.id = id;
        this.accessToken = accessToken;
        this.created = created;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getWebServerRedirect() {
        return webServerRedirect;
    }

    public void setWebServerRedirect(String webServerRedirect) {
        this.webServerRedirect = webServerRedirect;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public GlobUsers getUserid() {
        return userid;
    }

    public void setUserid(GlobUsers userid) {
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
        if (!(object instanceof WsAppOauth)) {
            return false;
        }
        WsAppOauth other = (WsAppOauth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.WsAppOauth[ id=" + id + " ]";
    }

}
