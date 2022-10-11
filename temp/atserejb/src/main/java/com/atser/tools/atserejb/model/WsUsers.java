/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "UPDATE WS_USERS SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "WS_USERS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsUsers.findAll", query = "SELECT w FROM WsUsers w"),
    @NamedQuery(name = "WsUsers.findById", query = "SELECT w FROM WsUsers w WHERE w.id = :id"),
    @NamedQuery(name = "WsUsers.findByUsername", query = "SELECT w FROM WsUsers w WHERE w.username = :username"),
    @NamedQuery(name = "WsUsers.findBySSO", query = "SELECT w FROM WsUsers w WHERE w.username = :username AND w.active = :active"),
    @NamedQuery(name = "WsUsers.findByEmail", query = "SELECT w FROM WsUsers w WHERE w.email = :email")})
@NamedEntityGraphs({
    @NamedEntityGraph(name = "wsRigthsList", attributeNodes = {
        @NamedAttributeNode("wsRigthsList")}),
    @NamedEntityGraph(name = "wsOauthList", attributeNodes = {
        @NamedAttributeNode("wsOauthList")})
})
public class WsUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @SequenceGenerator(name = "WS_USERS_SEQ", sequenceName = "WS_USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WS_USERS_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ToString.Include
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SALT")
    private String salt;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @EqualsAndHashCode.Include
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "EMAIL")
    private String email;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "LAST_LOGIN_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Column(name = "COOKIE_XTIME")
    private Integer cookie_xtime;
    @Column(name = "BAD_AUTH_ATTEMPTS", insertable = false)
    private BigInteger badAuthAttempts;
    @EqualsAndHashCode.Include
    @Column(name = "LOCKED")
    private Character locked;
    @Column(name = "LOCKED_TIME")
    @Temporal(TemporalType.DATE)
    private Date lockedTime;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "ACTIVE")
    private Character active;
    @JsonIgnore
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid", fetch = FetchType.LAZY)
    private List<WsRigths> wsRigthsList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid", fetch = FetchType.LAZY)
    private List<WsOauth> wsOauthList;

    public WsUsers(BigDecimal id, String username, String password, String salt, Character active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.active = active;
    }
}
