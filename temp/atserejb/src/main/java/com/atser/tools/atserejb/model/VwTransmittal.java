/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "VW_TRANSMITTAL", catalog = "", schema = "ORACLE")
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTransmittal.findAll", query = "SELECT a FROM VwTransmittal a")})
public class VwTransmittal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Column(name = "PROJECT_ID")
    private BigDecimal projectId;
    @Column(name = "NAME")
    private String name;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pnumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pname;
    @Column(name = "FOLDER_ID")
    private BigDecimal folderId;
    @Column(name = "SNO")
    private Integer sno;
    @Column(name = "SPNO")
    private Integer spno;
    @Size(max = 255)
    @Column(name = "TRANSMITTAL_NO")
    private String transmittalNo;
    @Size(max = 255)
    @Column(name = "TRANSMITTED_BY")
    private String transmittedBy;
    @Size(max = 255)
    @Column(name = "TRANSMITTED_BY_COMPANY")
    private String transmittedByCompany;
    @Size(max = 255)
    @Column(name = "ATTENTION")
    private String attention;
    @Size(max = 255)
    @Column(name = "ATTENTION_COMPANY")
    private String attentionCompany;

    @Column(name = "TRANSMITTED_FOR")
    private Integer transmittedFor;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;

    @Column(name = "ATTACHMENT")
    private Integer attachment;

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
