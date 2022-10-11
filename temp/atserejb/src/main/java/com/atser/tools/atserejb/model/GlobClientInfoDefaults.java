/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mfuentes
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "GLOB_CLIENT_INFO_DEFAULTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientInfoDefaults.findAll", query = "SELECT g FROM GlobClientInfoDefaults g"),
    @NamedQuery(name = "GlobClientInfoDefaults.findByClient", query = "SELECT g FROM GlobClientInfoDefaults g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientInfoDefaults.findById", query = "SELECT g FROM GlobClientInfoDefaults g WHERE g.id = :id")})
public class GlobClientInfoDefaults implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_CLIENT_INFO_DEFLTS_ID_SEQ", sequenceName = "GLOB_CLIENT_INFO_DEFLTS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_CLIENT_INFO_DEFLTS_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "CONTRACTOR_ID")
    private BigInteger contractorId;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "DISCIPLINE_ID")
    private BigInteger disciplineId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;

}
