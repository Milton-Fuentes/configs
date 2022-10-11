/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
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

/**
 *
 * @author dperez
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "PLAN_PROJECTS_LOCATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanProjectsLocation.findAll", query = "SELECT p FROM PlanProjectsLocation p"),
    @NamedQuery(name = "PlanProjectsLocation.findByLocationKey", query = "SELECT p FROM PlanProjectsLocation p WHERE p.locationKey = :locationKey")})
public class PlanProjectsLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "LOCATION_KEY")
    private String locationKey;
    @Size(max = 4000)
    @Column(name = "LOCATION_NAME")
    private String locationName;
    @Size(max = 4000)
    @Column(name = "GROUP_KEY")
    private String groupKey;
    @Size(max = 255)
    @Column(name = "L_NUMBER")
    private String lNumber;
    @Column(name = "LOC_SEQUENCE")
    private BigInteger locSequence;
    @Column(name = "LOC_VISIBLE")
    private BigInteger locVisible;
    @Size(max = 4000)
    @Column(name = "GROUP_NAME")
    private String groupName;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
}
