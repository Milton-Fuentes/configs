/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserejb.common.converter.BooleanCharacterConverter;
import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Immutable
@Table(name = "VW_CM_BIDIT_PRJ_ITEMS_CO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCmBiditPrjItemsCo.findAll", query = "SELECT a FROM VwCmBiditPrjItemsCo a"),
    @NamedQuery(name = "VwCmBiditPrjItemsCo.findById", query = "SELECT q FROM VwCmBiditPrjItemsCo q WHERE q.id = :id")})
public class VwCmBiditPrjItemsCo implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PRJ_ITEM_ID")
    private BigInteger prjItemId;
    @Column(name = "PROFILE_ID")
    private BigInteger profileId;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Convert(converter = BooleanCharacterConverter.class)
    @Column(name = "ISPARENT")
    private Boolean isParent;
    @Column(name = "PRJ_CATG_ID")
    private BigInteger prjCatgId;
    @ToString.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Column(name = "CATEGORY_ID")
    private BigInteger categoryId;
    @ToString.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 255)
    @Column(name = "SPEC_NO")
    private String specNo;
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "UNIT_ID")
    private BigInteger unitId;
    @ToString.Include
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 50)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    @Convert(converter = BooleanCharacterConverter.class)
    @Column(name = "IS_QTY_EDITABLE")
    private Boolean isQtyEditable;
    @Column(name = "DEFAULT_QTY")
    private BigDecimal defaultQty;
    @Column(name = "USER_QTY")
    private BigDecimal userQty;
    @Column(name = "FINAL_QTY")
    private BigDecimal finalQty;
    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @Column(name = "ITEM_ADDENDUM_REV")
    private BigInteger itemAddendumRev;
    @Column(name = "COMPANY_ID")
    private BigInteger companyId;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Column(name = "PRJ_ITEMS_ACTIVE")
    private Character prjItemsActive;
}
