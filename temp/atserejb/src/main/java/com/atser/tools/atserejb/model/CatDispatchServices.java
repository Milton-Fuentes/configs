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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CAT_DISPATCH_SERVICES", catalog = "", schema = "ORACLE")
@Where(clause = "status = 'ENABLED'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatDispatchServices.findAll", query = "SELECT c FROM CatDispatchServices c")
    , @NamedQuery(name = "CatDispatchServices.findById", query = "SELECT c FROM CatDispatchServices c WHERE c.id = :id")
    , @NamedQuery(name = "CatDispatchServices.findByAbrv", query = "SELECT c FROM CatDispatchServices c WHERE c.abrv = :abrv")
    , @NamedQuery(name = "CatDispatchServices.findByCname", query = "SELECT c FROM CatDispatchServices c WHERE c.cname = :cname")
    , @NamedQuery(name = "CatDispatchServices.findByStatus", query = "SELECT c FROM CatDispatchServices c WHERE c.status = :status")
    , @NamedQuery(name = "CatDispatchServices.findByCorder", query = "SELECT c FROM CatDispatchServices c WHERE c.corder = :corder")})
public class CatDispatchServices implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CAT_DISPATCH_SERVICES_SEQ", sequenceName = "CAT_DISPATCH_SERVICES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_DISPATCH_SERVICES_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "ABRV")
    private String abrv;
    @Size(max = 150)
    @Column(name = "CNAME")
    private String cname;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPTION_TPL")
    private String descriptionTpl;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CORDER")
    private BigInteger corder;

    public CatDispatchServices() {
    }

    public CatDispatchServices(BigDecimal id) {
        this.id = id;
    }

    public CatDispatchServices(BigDecimal id, String descriptionTpl) {
        this.id = id;
        this.descriptionTpl = descriptionTpl;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAbrv() {
        return abrv;
    }

    public void setAbrv(String abrv) {
        this.abrv = abrv;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescriptionTpl() {
        return descriptionTpl;
    }

    public void setDescriptionTpl(String descriptionTpl) {
        this.descriptionTpl = descriptionTpl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getCorder() {
        return corder;
    }

    public void setCorder(BigInteger corder) {
        this.corder = corder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatDispatchServices)) {
            return false;
        }
        CatDispatchServices other = (CatDispatchServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CatDispatchServices[ id=" + id + " ]";
    }
    
}
