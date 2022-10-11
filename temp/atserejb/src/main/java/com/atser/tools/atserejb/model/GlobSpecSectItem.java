/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobSpecSectItem.findBySectionId", query = "SELECT g FROM GlobSpecSectItem g WHERE g.sectionId = :sectionId"),
    @NamedQuery(name = "GlobSpecSectItem.findByItemId", query = "SELECT g FROM GlobSpecSectItem g WHERE g.itemId = :itemId"),
    @NamedQuery(name = "GlobSpecSectItem.findByField1", query = "SELECT g FROM GlobSpecSectItem g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobSpecSectItem.findByField2", query = "SELECT g FROM GlobSpecSectItem g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobSpecSectItem.findByField3", query = "SELECT g FROM GlobSpecSectItem g WHERE g.field3 = :field3"),
    @NamedQuery(name = "GlobSpecSectItem.findByField4", query = "SELECT g FROM GlobSpecSectItem g WHERE g.field4 = :field4")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_SECT_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecSectItem.findAll", query = "SELECT g FROM GlobSpecSectItem g"),
    @NamedQuery(name = "GlobSpecSectItem.findById", query = "SELECT g FROM GlobSpecSectItem g WHERE g.id = :id")})
public class GlobSpecSectItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SECTION_ID")
    private BigInteger sectionId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Column(name = "FIELD3")
    private BigInteger field3;
    @Column(name = "FIELD4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field4;

    public GlobSpecSectItem() {
    }

    public GlobSpecSectItem(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSectionId() {
        return sectionId;
    }

    public void setSectionId(BigInteger sectionId) {
        this.sectionId = sectionId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public BigInteger getField3() {
        return field3;
    }

    public void setField3(BigInteger field3) {
        this.field3 = field3;
    }

    public Date getField4() {
        return field4;
    }

    public void setField4(Date field4) {
        this.field4 = field4;
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
        if (!(object instanceof GlobSpecSectItem)) {
            return false;
        }
        GlobSpecSectItem other = (GlobSpecSectItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecSectItem[ id=" + id + " ]";
    }
    
}
