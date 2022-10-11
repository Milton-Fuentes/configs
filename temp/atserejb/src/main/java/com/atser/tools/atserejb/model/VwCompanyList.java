/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author dperez
 */
@Entity
@Data
@Immutable
@Table(name = "VW_COMPANY_LIST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCompanyList.findAll", query = "SELECT a FROM VwCompanyList a")})
public class VwCompanyList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private String id;

    @Column(name = "CO_ID")
    private BigInteger coId;

    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "FIRM")
    private String firm;

    @Column(name = "NAME")
    private String name;

}
