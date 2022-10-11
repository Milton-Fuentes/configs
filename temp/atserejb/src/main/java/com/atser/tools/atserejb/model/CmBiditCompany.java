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

/*
    @NamedQuery(name = "CmBiditCompany.findByCompanyName", query = "SELECT c FROM CmBiditCompany c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyAddr", query = "SELECT c FROM CmBiditCompany c WHERE c.companyAddr = :companyAddr"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyAddrDetail", query = "SELECT c FROM CmBiditCompany c WHERE c.companyAddrDetail = :companyAddrDetail"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyCity", query = "SELECT c FROM CmBiditCompany c WHERE c.companyCity = :companyCity"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyState", query = "SELECT c FROM CmBiditCompany c WHERE c.companyState = :companyState"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyZip", query = "SELECT c FROM CmBiditCompany c WHERE c.companyZip = :companyZip"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyWebsite", query = "SELECT c FROM CmBiditCompany c WHERE c.companyWebsite = :companyWebsite"),
    @NamedQuery(name = "CmBiditCompany.findByCompanyDescription", query = "SELECT c FROM CmBiditCompany c WHERE c.companyDescription = :companyDescription"),
    @NamedQuery(name = "CmBiditCompany.findByCreated", query = "SELECT c FROM CmBiditCompany c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditCompany.findByCreatedBy", query = "SELECT c FROM CmBiditCompany c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditCompany.findByCreatedByIp", query = "SELECT c FROM CmBiditCompany c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditCompany.findByLastMod", query = "SELECT c FROM CmBiditCompany c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditCompany.findByLastModIp", query = "SELECT c FROM CmBiditCompany c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditCompany.findByLastModBy", query = "SELECT c FROM CmBiditCompany c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditCompany.findByDeleted", query = "SELECT c FROM CmBiditCompany c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditCompany.findByActive", query = "SELECT c FROM CmBiditCompany c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditCompany.findByVersion", query = "SELECT c FROM CmBiditCompany c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CM_BIDIT_COMPANY", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_COMPANY SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditCompany.findAll", query = "SELECT c FROM CmBiditCompany c"),
    @NamedQuery(name = "CmBiditCompany.findById", query = "SELECT c FROM CmBiditCompany c WHERE c.id = :id")})
public class CmBiditCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "CM_BIDIT_COMPANY_SEQ", sequenceName = "CM_BIDIT_COMPANY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_COMPANY_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ToString.Include
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @ToString.Include
    @Column(name = "USER_ID")
    private BigInteger userId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 50)
    @Column(name = "COMPANY_TIN")
    private String companyTin;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 1024)
    @Column(name = "COMPANY_ADDR")
    private String companyAddr;
    @EqualsAndHashCode.Include
    @JoinColumn(name = "COMPANY_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private QmCvlFieldData companyTypeId;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "COMPANY_ADDR_DETAIL")
    private String companyAddrDetail;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "COMPANY_CITY")
    private String companyCity;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "COMPANY_STATE")
    private String companyState;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 25)
    @Column(name = "COMPANY_ZIP")
    private String companyZip;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 255)
    @Column(name = "COMPANY_WEBSITE")
    private String companyWebsite;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Size(max = 1024)
    @Column(name = "COMPANY_DESCRIPTION")
    private String companyDescription;
    @Column(name = "ENGINEER_ESTIMATE", insertable = false)
    private Character engineerEstimate;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
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
