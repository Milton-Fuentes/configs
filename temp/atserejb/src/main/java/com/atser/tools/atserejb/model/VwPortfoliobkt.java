/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "VW_PORTFOLIOBKT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPortfoliobkt.findAll", query = "SELECT a FROM VwPortfoliobkt a"),
    @NamedQuery(name = "VwPortfoliobkt.findById", query = "SELECT q FROM VwPortfoliobkt q WHERE q.id = :id")})
public class VwPortfoliobkt implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PORTFOLIO_ID")
    private BigInteger portfolioId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 19)
    @Column(name = "P_TYPE")
    private String pType;
    
    public String getProjectFullName() {
        if (StringSupport.isNotNullAndNotEmpty(this.pNumber)) {
            if (StringSupport.isNotNullAndNotEmpty(this.pName)) {
                return "[ " + this.pNumber + " ] " + this.pName;
            } else {
                return "[ " + this.pNumber + " ] " + this.description;
            }
        } else {
            if (StringSupport.isNotNullAndNotEmpty(this.pName)) {
                return this.pName;
            } else {
                return this.description;
            }
        }
    }

}
