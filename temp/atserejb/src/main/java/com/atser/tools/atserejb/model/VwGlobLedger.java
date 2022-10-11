/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobLedgerTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

/**
 *
 * @author mfuentes
 */
@Entity
@Getter
@Immutable
@NoArgsConstructor
@Table(name = "VW_GLOB_LEDGER", catalog = "", schema = "ORACLE")
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwGlobLedger.findAll", query = "SELECT a FROM VwGlobLedger a")})
public class VwGlobLedger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Column(name = "PROJECT_ID")
    private BigDecimal projectId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pnumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pname;
    @Column(name = "INSPECTOR")
    private String inspector;
    @Column(name = "INSPECTOR_ID")
    private BigDecimal inspectorId;
    @Column(name = "FOLDER_ID")
    private BigDecimal folderId;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "OPERATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date operationDate;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "INCOME")
    private BigDecimal income;
    @Column(name = "EXPENSE")
    private BigDecimal expense;
    @Column(name = "MILES")
    private BigDecimal miles;
    @Column(name = "MILEAGE_EXPENSE")
    private BigDecimal mileageExpense;
    @EqualsAndHashCode.Include
    @Column(name = "TOTAL_EXPENSE")
    private BigDecimal totalExpense;
    @Column(name = "BALANCE")
    private BigDecimal balance;
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
