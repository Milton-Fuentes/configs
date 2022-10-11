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
    @NamedQuery(name = "QaPlistPhoto.findByItemId", query = "SELECT q FROM QaPlistPhoto q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaPlistPhoto.findByNote1", query = "SELECT q FROM QaPlistPhoto q WHERE q.note1 = :note1"),
    @NamedQuery(name = "QaPlistPhoto.findByImgFilename", query = "SELECT q FROM QaPlistPhoto q WHERE q.imgFilename = :imgFilename"),
    @NamedQuery(name = "QaPlistPhoto.findByTag1", query = "SELECT q FROM QaPlistPhoto q WHERE q.tag1 = :tag1"),
    @NamedQuery(name = "QaPlistPhoto.findByField1", query = "SELECT q FROM QaPlistPhoto q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaPlistPhoto.findByField2", query = "SELECT q FROM QaPlistPhoto q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaPlistPhoto.findByField3", query = "SELECT q FROM QaPlistPhoto q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaPlistPhoto.findByField4", query = "SELECT q FROM QaPlistPhoto q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaPlistPhoto.findByField5", query = "SELECT q FROM QaPlistPhoto q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaPlistPhoto.findByField6", query = "SELECT q FROM QaPlistPhoto q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaPlistPhoto.findByField7", query = "SELECT q FROM QaPlistPhoto q WHERE q.field7 = :field7"),
    @NamedQuery(name = "QaPlistPhoto.findByField8", query = "SELECT q FROM QaPlistPhoto q WHERE q.field8 = :field8")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_PLIST_PHOTO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPlistPhoto.findAll", query = "SELECT q FROM QaPlistPhoto q"),
    @NamedQuery(name = "QaPlistPhoto.findById", query = "SELECT q FROM QaPlistPhoto q WHERE q.id = :id")})
public class QaPlistPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Size(max = 4000)
    @Column(name = "NOTE1")
    private String note1;
    @Size(max = 200)
    @Column(name = "IMG_FILENAME")
    private String imgFilename;
    @Size(max = 50)
    @Column(name = "TAG1")
    private String tag1;
    @Size(max = 2000)
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
    private Double field5;
    @Column(name = "FIELD6")
    private Double field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;

    public QaPlistPhoto() {
    }

    public QaPlistPhoto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getImgFilename() {
        return imgFilename;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
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

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Double getField6() {
        return field6;
    }

    public void setField6(Double field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
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
        if (!(object instanceof QaPlistPhoto)) {
            return false;
        }
        QaPlistPhoto other = (QaPlistPhoto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaPlistPhoto[ id=" + id + " ]";
    }
    
}
