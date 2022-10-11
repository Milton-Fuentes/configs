/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserejb.common.converter.BooleanCharacterConverter;
import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
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
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "CmBiditPrjItems.findByParentId", query = "SELECT c FROM CmBiditPrjItems c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmBiditPrjItems.findByIsparent", query = "SELECT c FROM CmBiditPrjItems c WHERE c.isparent = :isparent"),
    @NamedQuery(name = "CmBiditPrjItems.findByItemNo", query = "SELECT c FROM CmBiditPrjItems c WHERE c.itemNo = :itemNo"),
    @NamedQuery(name = "CmBiditPrjItems.findByCategory", query = "SELECT c FROM CmBiditPrjItems c WHERE c.category = :category"),
    @NamedQuery(name = "CmBiditPrjItems.findBySpecNo", query = "SELECT c FROM CmBiditPrjItems c WHERE c.specNo = :specNo"),
    @NamedQuery(name = "CmBiditPrjItems.findByDescription", query = "SELECT c FROM CmBiditPrjItems c WHERE c.description = :description"),
    @NamedQuery(name = "CmBiditPrjItems.findByUnit", query = "SELECT c FROM CmBiditPrjItems c WHERE c.unit = :unit"),
    @NamedQuery(name = "CmBiditPrjItems.findByItemType", query = "SELECT c FROM CmBiditPrjItems c WHERE c.itemType = :itemType"),
    @NamedQuery(name = "CmBiditPrjItems.findByCreated", query = "SELECT c FROM CmBiditPrjItems c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditPrjItems.findByCreatedBy", query = "SELECT c FROM CmBiditPrjItems c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditPrjItems.findByCreatedByIp", query = "SELECT c FROM CmBiditPrjItems c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditPrjItems.findByLastMod", query = "SELECT c FROM CmBiditPrjItems c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditPrjItems.findByLastModIp", query = "SELECT c FROM CmBiditPrjItems c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditPrjItems.findByLastModBy", query = "SELECT c FROM CmBiditPrjItems c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditPrjItems.findByDeleted", query = "SELECT c FROM CmBiditPrjItems c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditPrjItems.findByActive", query = "SELECT c FROM CmBiditPrjItems c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditPrjItems.findByVersion", query = "SELECT c FROM CmBiditPrjItems c WHERE c.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "CM_BIDIT_PRJ_ITEMS", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_PRJ_ITEMS SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditPrjItems.findAll", query = "SELECT c FROM CmBiditPrjItems c"),
    @NamedQuery(name = "CmBiditPrjItems.findById", query = "SELECT c FROM CmBiditPrjItems c WHERE c.id = :id")})
public class CmBiditPrjItems implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "CM_BIDIT_PRJ_ITEMS_SEQ", sequenceName = "CM_BIDIT_PRJ_ITEMS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_PRJ_ITEMS_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @EqualsAndHashCode.Include
    @Column(name = "PRJ_CATG_ID")
    private BigInteger prjCatgId;    
    @EqualsAndHashCode.Include
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Convert(converter = BooleanCharacterConverter.class)
    @Column(name = "ISPARENT")
    private Boolean isParent;
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
    @JoinColumn(name = "UNIT")
    @ManyToOne(optional = false)
    private QmCvlFieldData unit;
    @EqualsAndHashCode.Include
    @Size(max = 50)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @EqualsAndHashCode.Include
    @Column(name = "ITEM_REF_ID")
    private BigInteger itemRefId;
    @EqualsAndHashCode.Include
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    @Convert(converter = BooleanCharacterConverter.class)
    @Column(name = "IS_QTY_EDITABLE")
    private Boolean isQtyEditable;
    @EqualsAndHashCode.Include
    @Column(name = "DEFAULT_QTY")
    private BigDecimal defaultQty;
    @Column(name = "ITEM_ADDENDUM_REV")
    private BigInteger itemAddendumRev;
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
    @JsonIgnore
    @OneToMany(mappedBy = "prjItemId")
    private List<CmBiditPrjItemsCo> cmBiditPrjItemsCoList;
}
