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
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "CmBiditPrjItemsCo.findByPrice", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.price = :price"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByQty", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.qty = :qty"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByCreated", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.created = :created"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByCreatedBy", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByCreatedByIp", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByLastMod", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByLastModIp", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByLastModBy", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByDeleted", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByActive", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.active = :active"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findByVersion", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "CM_BIDIT_PRJ_ITEMS_CO", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE CM_BIDIT_PRJ_ITEMS_CO SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditPrjItemsCo.findAll", query = "SELECT c FROM CmBiditPrjItemsCo c"),
    @NamedQuery(name = "CmBiditPrjItemsCo.findById", query = "SELECT c FROM CmBiditPrjItemsCo c WHERE c.id = :id")})
public class CmBiditPrjItemsCo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "CM_BIDIT_PRJ_ITEMS_CO_SEQ", sequenceName = "CM_BIDIT_PRJ_ITEMS_CO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_PRJ_ITEMS_CO_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @EqualsAndHashCode.Include
    @Column(name = "PRJ_ITEM_ID")
    private BigInteger prjItemId;
    @EqualsAndHashCode.Include
    @Column(name = "PROFILE_ID")
    private BigInteger profileId;    
    @EqualsAndHashCode.Include
    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;
    @EqualsAndHashCode.Include
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @EqualsAndHashCode.Include
    @Column(name = "QTY")
    private BigDecimal qty;
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
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version; 

    public CmBiditPrjItemsCo(BigInteger prjItemId, BigInteger profileId) {
        this.prjItemId = prjItemId;
        this.profileId = profileId;
    }
}
