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
@Table(name = "VW_PROJECT_CD0T", catalog = "", schema = "ORACLE")
//@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProjectCdot.findAll", query = "SELECT a FROM VwProjectCdot a")})
public class VwProjectCdot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Size(max = 255)
    @Column(name = "PO_NUMBER")
    private String poNumber;
    @Size(max = 255)
    @Column(name = "P_NUMBER")
    private String pNumber;

    @Size(max = 256)
    @Column(name = "P_JOB_NO")
    private String pJobNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "OFFICE_LOCATION")
    private String officeLocation; 
    @Temporal(TemporalType.DATE)
    @Column(name = "P_DATE", insertable = false, updatable = false)
    private Date pDate;
    @Column(name = "CONTRACT_AMOUNT")
    private BigDecimal contractAmount;
    @Size(max = 400)
    @Column(name = "PROJECT_MANAGER")
    private String projectMabager;
    @Column(name = "CONTRACTOR_ID")
    private BigDecimal contractorId;
    @Size(max = 400)
    @Column(name = "CONTRACTOR")
    private String contractor;
    @Size(max = 20)
    @Column(name = "FIELD_OFFICE_NUMBER")
    private String fieldOfficeNumber;
    @Size(max = 50)
    @Column(name = "CONTACT_FIRSTNAME")
    private String contactFirstname;
    @Size(max = 50)
    @Column(name = "CONTACT_LASTNAME")
    private String contactLastname;
    @Size(max = 255)
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    @Size(max = 30)
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Size(max = 50)
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;
    @Column(name = "CONTACT_ID")
    private BigDecimal contactId;

    @Size(max = 400)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 400)
    @Column(name = "ADDRESS2")
    private String address2;


    @Column(name = "CREATE_DATE", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "LAST_MOD", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

}
