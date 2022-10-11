/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.hibernate.annotations.Immutable;
/**
 *
 * @author mdelabat
 */
@Entity
@Data
@Immutable
@Table(name = "VW_WORKORDER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwWorkOrder.findAll", query = "SELECT a FROM VwWorkOrder a")})
public class VwWorkOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "WO_ID", referencedColumnName = "ID")
    private GlobWorkorder woId;
    @Column(name = "HOURS")
    private Integer hours;
    @Column(name = "SPEC_INSTR")
    private String specInstr;
    @Column(name = "TECHREFID")
    private Integer techrefid;
    @Column(name = "TECHNICIAN")
    private String techFullName;
    @Column(name = "CANCELLED")
    private String cancelled;
    @Column(name = "DECISIONFLAG")
    private Integer decisionflag;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "SERVICE_DATE")
    private Date serviceDate;
    @Column(name = "PAPERWORK_RECEIVED")
    private String paperworkReceived;
    @Column(name = "ASSIGNMENT")
    private String assignment;
    @Column(name = "INFO_ID")
    private Integer infoId;
    @Column(name = "TIME_SITE")
    private String timeSite;
    @Column(name = "SERVICES_REQUESTED")
    private String serviceList;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "SUBMREPORT")
    private String submreport;
 
}
