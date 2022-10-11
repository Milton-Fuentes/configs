/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "GLOB_USERS_APPROVAL", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_USERS_APPROVAL SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobUsersApproval.findAll", query = "SELECT c FROM GlobUsersApproval c"),
    @NamedQuery(name = "GlobUsersApproval.findById", query = "SELECT c FROM GlobUsersApproval c WHERE c.id = :id"), 
    @NamedQuery(name = "GlobUsersApproval.findByUsername", query = "SELECT c FROM GlobUsersApproval c WHERE c.username = :username AND c.approved = 'Y' AND c.active = 'Y'")
})
public class GlobUsersApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "GLOB_USERS_APPROVAL_SEQ", sequenceName = "GLOB_USERS_APPROVAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_USERS_APPROVAL_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ToString.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "MODULE_NAME")
    private String moduleName;
    @ToString.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Basic(optional = false)
    @Column(name = "REQUESTED_CLIENT_ID")
    private BigInteger requestedClientId;
    @ToString.Include
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "UNIQUE_TOKEN")
    private String uniqueToken;
    @Column(name = "APPROVED")
    private Character approved;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "APPROVED_BY")
    private String approvedBy;
    @Basic(optional = false)
    @Column(name = "APPROVED_BY_CLIENT_ID")
    private BigInteger approvedByClientId;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
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
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;
}
