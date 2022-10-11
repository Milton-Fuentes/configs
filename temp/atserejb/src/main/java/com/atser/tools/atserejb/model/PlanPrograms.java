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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author droldan
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "PLAN_PROGRAMS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanPrograms.findAll", query = "SELECT c FROM PlanPrograms c"),
    @NamedQuery(name = "PlanPrograms.findById", query = "SELECT c FROM PlanPrograms c WHERE c.id = :id")})
public class PlanPrograms implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @SequenceGenerator(name = "plan_programs_id_seq", sequenceName = "plan_programs_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_programs_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @ToString.Include
    @EqualsAndHashCode.Include
    @Size(max = 200)
    @Column(name = "DEPT_CODE")
    private String deptCode;
    @ToString.Include
    @EqualsAndHashCode.Include
    @Size(max = 200)
    @Column(name = "PROG_NAME")
    private String progName;
    @EqualsAndHashCode.Include
    @Size(max = 500)
    @Column(name = "DESCRIPT")
    private String descript;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private BigInteger field5;
    @Column(name = "FIELD6")
    private BigInteger field6;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "FIELD7")
    @Temporal(TemporalType.DATE)
    private Date field7;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @Column(name = "FIELD8")
    @Temporal(TemporalType.DATE)
    private Date field8;
}
