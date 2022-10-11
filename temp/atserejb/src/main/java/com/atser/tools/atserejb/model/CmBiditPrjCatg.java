/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeNoDesignatorDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeNoDesignatorSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
@NamedQuery(name = "CmBiditPrjCatg.findByClientId", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "CmBiditPrjCatg.findByProjectId", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.projectId = :projectId"),
    @NamedQuery(name = "CmBiditPrjCatg.findBySpattern", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.spattern = :spattern"),
    @NamedQuery(name = "CmBiditPrjCatg.findBySno", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.sno = :sno"),
    @NamedQuery(name = "CmBiditPrjCatg.findByBpcn", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.bpcn = :bpcn"),
    @NamedQuery(name = "CmBiditPrjCatg.findByBidNo", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.bidNo = :bidNo"),
    @NamedQuery(name = "CmBiditPrjCatg.findByDescription", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.description = :description"),
    @NamedQuery(name = "CmBiditPrjCatg.findByBidIssueDate", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.bidIssueDate = :bidIssueDate"),
    @NamedQuery(name = "CmBiditPrjCatg.findByBidClosingDate", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.bidClosingDate = :bidClosingDate"),
    @NamedQuery(name = "CmBiditPrjCatg.findByHasAddendum", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.hasAddendum = :hasAddendum"),
    @NamedQuery(name = "CmBiditPrjCatg.findByFolderId", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.folderId = :folderId"),
    @NamedQuery(name = "CmBiditPrjCatg.findByStatusId", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.statusId = :statusId"),
    @NamedQuery(name = "CmBiditPrjCatg.findByCreated", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditPrjCatg.findByCreatedBy", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditPrjCatg.findByCreatedById", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.createdById = :createdById"),
    @NamedQuery(name = "CmBiditPrjCatg.findByCreatedByIp", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditPrjCatg.findByLastMod", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditPrjCatg.findByLastModIp", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditPrjCatg.findByLastModBy", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditPrjCatg.findByDeleted", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditPrjCatg.findByActive", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditPrjCatg.findByVersion", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded=true)
@Table(name = "CM_BIDIT_PRJ_CATG", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_PRJ_CATG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditPrjCatg.findAll", query = "SELECT c FROM CmBiditPrjCatg c"),
    @NamedQuery(name = "CmBiditPrjCatg.findById", query = "SELECT c FROM CmBiditPrjCatg c WHERE c.id = :id")})
public class CmBiditPrjCatg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "CM_BIDIT_PRJ_CATG_SEQ", sequenceName = "CM_BIDIT_PRJ_CATG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_PRJ_CATG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @ToString.Include
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @EqualsAndHashCode.Include
    @Column(name = "PROJECT_ID")
    @ToString.Include
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN")
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "BPCN")
    private String bpcn;
    @ToString.Include
    @Size(max = 150)
    @Column(name = "BID_NO")
    private String bidNo;
    @EqualsAndHashCode.Include
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @EqualsAndHashCode.Include
    @Column(name = "BID_ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date bidIssueDate;
    @JsonSerialize(using = JsonDateTimeNoDesignatorSerializer.class)
    @JsonDeserialize(using = JsonDateTimeNoDesignatorDeserialize.class)
    @EqualsAndHashCode.Include
    @Column(name = "BID_CLOSING_DATE")
    @Temporal(TemporalType.DATE)
    private Date bidClosingDate;
    @EqualsAndHashCode.Include
    @Column(name = "BID_CLOSED")
    private Character bidClosed;
    @JsonSerialize(using = JsonDateTimeNoDesignatorSerializer.class)
    @JsonDeserialize(using = JsonDateTimeNoDesignatorDeserialize.class)
    @EqualsAndHashCode.Include
    @Column(name = "BID_PUBLISH_DATE")
    @Temporal(TemporalType.DATE)
    private Date bidPublishDate;
    @EqualsAndHashCode.Include
    @Column(name = "BID_PUBLISHED")
    private Character bidPublished;
    @Column(name = "BID_ADDENDUM_REV")
    private BigInteger bidAddendumRev;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "STATUS_ID", insertable = false)
    private BigInteger statusId;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_BY_ID")
    private BigInteger createdById;
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
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;
    @JsonIgnore
    @OneToMany(mappedBy = "prjCatgId")
    private List<CmBiditPrjItems> cmBiditPrjItemsList;
    
    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }
}
