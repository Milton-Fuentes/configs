/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserejb.common.converter.BooleanCharacterConverter;
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
import javax.persistence.Convert;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "CmBiditItemMaster.findByParentId", query = "SELECT c FROM CmBiditItemMaster c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmBiditItemMaster.findByItemNo", query = "SELECT c FROM CmBiditItemMaster c WHERE c.itemNo = :itemNo"),
    @NamedQuery(name = "CmBiditItemMaster.findByCategory", query = "SELECT c FROM CmBiditItemMaster c WHERE c.category = :category"),
    @NamedQuery(name = "CmBiditItemMaster.findBySpecNo", query = "SELECT c FROM CmBiditItemMaster c WHERE c.specNo = :specNo"),
    @NamedQuery(name = "CmBiditItemMaster.findByDescription", query = "SELECT c FROM CmBiditItemMaster c WHERE c.description = :description"),
    @NamedQuery(name = "CmBiditItemMaster.findByUnit", query = "SELECT c FROM CmBiditItemMaster c WHERE c.unit = :unit"),
    @NamedQuery(name = "CmBiditItemMaster.findByItemType", query = "SELECT c FROM CmBiditItemMaster c WHERE c.itemType = :itemType"),
    @NamedQuery(name = "CmBiditItemMaster.findByCreated", query = "SELECT c FROM CmBiditItemMaster c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditItemMaster.findByCreatedBy", query = "SELECT c FROM CmBiditItemMaster c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditItemMaster.findByCreatedByIp", query = "SELECT c FROM CmBiditItemMaster c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditItemMaster.findByLastMod", query = "SELECT c FROM CmBiditItemMaster c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditItemMaster.findByLastModIp", query = "SELECT c FROM CmBiditItemMaster c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditItemMaster.findByLastModBy", query = "SELECT c FROM CmBiditItemMaster c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditItemMaster.findByDeleted", query = "SELECT c FROM CmBiditItemMaster c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditItemMaster.findByActive", query = "SELECT c FROM CmBiditItemMaster c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditItemMaster.findByVersion", query = "SELECT c FROM CmBiditItemMaster c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded=true)
@Table(name = "CM_BIDIT_ITEM_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_ITEM_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditItemMaster.findAll", query = "SELECT c FROM CmBiditItemMaster c"),
    @NamedQuery(name = "CmBiditItemMaster.findById", query = "SELECT c FROM CmBiditItemMaster c WHERE c.id = :id")})
public class CmBiditItemMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "CM_BIDIT_ITEM_MASTER_SEQ", sequenceName = "CM_BIDIT_ITEM_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_ITEM_MASTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Convert(converter = BooleanCharacterConverter.class)
    @Column(name = "ISPARENT", insertable = false)
    private Boolean isParent;
    @EqualsAndHashCode.Include
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @ToString.Include
    @EqualsAndHashCode.Include
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @EqualsAndHashCode.Include
    @JoinColumn(name = "CATEGORY")
    @ManyToOne(optional = true)
    private QmCvlFieldData category;
    @EqualsAndHashCode.Include
    @Size(max = 255)
    @Column(name = "SPEC_NO")
    private String specNo;
    @EqualsAndHashCode.Include
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @EqualsAndHashCode.Include
    //@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "UNIT")
    @ManyToOne(optional = false)
    private QmCvlFieldData unit;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Getter(AccessLevel.NONE)
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
    @Getter(AccessLevel.NONE)
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

    
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }
    
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }    
}
