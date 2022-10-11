/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

/*
, @NamedQuery(name = "GlobFileType.findByExtension", query = "SELECT g FROM GlobFileType g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobFileType.findByIcon1", query = "SELECT g FROM GlobFileType g WHERE g.icon1 = :icon1")
    , @NamedQuery(name = "GlobFileType.findByAlt1", query = "SELECT g FROM GlobFileType g WHERE g.alt1 = :alt1")
    , @NamedQuery(name = "GlobFileType.findByDesc1", query = "SELECT g FROM GlobFileType g WHERE g.desc1 = :desc1")
    , @NamedQuery(name = "GlobFileType.findByIcon2", query = "SELECT g FROM GlobFileType g WHERE g.icon2 = :icon2")
    , @NamedQuery(name = "GlobFileType.findByAlt2", query = "SELECT g FROM GlobFileType g WHERE g.alt2 = :alt2")
    , @NamedQuery(name = "GlobFileType.findByDesc2", query = "SELECT g FROM GlobFileType g WHERE g.desc2 = :desc2")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileType.findAll", query = "SELECT g FROM GlobFileType g")
    , @NamedQuery(name = "GlobFileType.findById", query = "SELECT g FROM GlobFileType g WHERE g.id = :id")})
public class GlobFileType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 20)
    @Column(name = "ICON_1")
    private String icon1;
    @Size(max = 50)
    @Column(name = "ALT_1")
    private String alt1;
    @Size(max = 50)
    @Column(name = "DESC_1")
    private String desc1;
    @Size(max = 20)
    @Column(name = "ICON_2")
    private String icon2;
    @Size(max = 50)
    @Column(name = "ALT_2")
    private String alt2;
    @Size(max = 50)
    @Column(name = "DESC_2")
    private String desc2;

    public GlobFileType() {
    }

    public GlobFileType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public String getAlt1() {
        return alt1;
    }

    public void setAlt1(String alt1) {
        this.alt1 = alt1;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public String getAlt2() {
        return alt2;
    }

    public void setAlt2(String alt2) {
        this.alt2 = alt2;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
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
        if (!(object instanceof GlobFileType)) {
            return false;
        }
        GlobFileType other = (GlobFileType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileType[ id=" + id + " ]";
    }
    
}
