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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_PROGRAM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectProgram.findAll", query = "SELECT g FROM GlobProjectProgram g"),
    @NamedQuery(name = "GlobProjectProgram.findById", query = "SELECT g FROM GlobProjectProgram g WHERE g.id = :id")})
public class GlobProjectProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROG_ID")
    private BigInteger progId;
    @Size(max = 100)
    @Column(name = "PROGRAM_NAME")
    private String programName;
    @Size(max = 100)
    @Column(name = "SUB_NAME")
    private String subName;
    @Size(max = 255)
    @Column(name = "SUB_CAPTION")
    private String subCaption;
    @Column(name = "PROGRAM_ORDER")
    private BigInteger programOrder;
    @Column(name = "ACTIVE")
    private Character active;
    

    public GlobProjectProgram() {
    }

    public GlobProjectProgram(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectProgram(BigDecimal id, BigInteger progId) {
        this.id = id;
        this.progId = progId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProgId() {
        return progId;
    }

    public void setProgId(BigInteger progId) {
        this.progId = progId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubCaption() {
        return subCaption;
    }

    public void setSubCaption(String subCaption) {
        this.subCaption = subCaption;
    }

    public BigInteger getProgramOrder() {
        return programOrder;
    }

    public void setProgramOrder(BigInteger programOrder) {
        this.programOrder = programOrder;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobProjectProgram)) {
            return false;
        }
        GlobProjectProgram other = (GlobProjectProgram) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectProgram[ id=" + id + " ]";
    }
    
}
