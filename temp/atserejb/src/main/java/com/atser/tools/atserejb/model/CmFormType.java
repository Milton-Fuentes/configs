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

/*
@NamedQuery(name = "CmFormType.findByExhibitNo", query = "SELECT c FROM CmFormType c WHERE c.exhibitNo = :exhibitNo"),
    @NamedQuery(name = "CmFormType.findByFName", query = "SELECT c FROM CmFormType c WHERE c.fName = :fName"),
    @NamedQuery(name = "CmFormType.findByDescription", query = "SELECT c FROM CmFormType c WHERE c.description = :description"),
    @NamedQuery(name = "CmFormType.findByParentId", query = "SELECT c FROM CmFormType c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "CmFormType.findByJspName", query = "SELECT c FROM CmFormType c WHERE c.jspName = :jspName"),
    @NamedQuery(name = "CmFormType.findByFType", query = "SELECT c FROM CmFormType c WHERE c.fType = :fType"),
    @NamedQuery(name = "CmFormType.findByFFormat", query = "SELECT c FROM CmFormType c WHERE c.fFormat = :fFormat"),
    @NamedQuery(name = "CmFormType.findByMaxRec", query = "SELECT c FROM CmFormType c WHERE c.maxRec = :maxRec"),
    @NamedQuery(name = "CmFormType.findByFOrder", query = "SELECT c FROM CmFormType c WHERE c.fOrder = :fOrder"),
    @NamedQuery(name = "CmFormType.findByScreenName", query = "SELECT c FROM CmFormType c WHERE c.screenName = :screenName"),
    @NamedQuery(name = "CmFormType.findByMultiple", query = "SELECT c FROM CmFormType c WHERE c.multiple = :multiple"),
    @NamedQuery(name = "CmFormType.findByFFormType", query = "SELECT c FROM CmFormType c WHERE c.fFormType = :fFormType")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormType.findAll", query = "SELECT c FROM CmFormType c"),
    @NamedQuery(name = "CmFormType.findById", query = "SELECT c FROM CmFormType c WHERE c.id = :id")})
public class CmFormType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "EXHIBIT_NO")
    private String exhibitNo;
    @Size(max = 4000)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Size(max = 150)
    @Column(name = "JSP_NAME")
    private String jspName;
    @Size(max = 250)
    @Column(name = "F_TYPE")
    private String fType;
    @Size(max = 250)
    @Column(name = "F_FORMAT")
    private String fFormat;
    @Column(name = "MAX_REC")
    private BigInteger maxRec;
    @Column(name = "F_ORDER")
    private BigInteger fOrder;
    @Size(max = 250)
    @Column(name = "SCREEN_NAME")
    private String screenName;
    @Column(name = "MULTIPLE")
    private Character multiple;
    @Size(max = 100)
    @Column(name = "F_FORM_TYPE")
    private String fFormType;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private CmActivity activityId;

    public CmFormType() {
    }

    public CmFormType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExhibitNo() {
        return exhibitNo;
    }

    public void setExhibitNo(String exhibitNo) {
        this.exhibitNo = exhibitNo;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getJspName() {
        return jspName;
    }

    public void setJspName(String jspName) {
        this.jspName = jspName;
    }

    public String getFType() {
        return fType;
    }

    public void setFType(String fType) {
        this.fType = fType;
    }

    public String getFFormat() {
        return fFormat;
    }

    public void setFFormat(String fFormat) {
        this.fFormat = fFormat;
    }

    public BigInteger getMaxRec() {
        return maxRec;
    }

    public void setMaxRec(BigInteger maxRec) {
        this.maxRec = maxRec;
    }

    public BigInteger getFOrder() {
        return fOrder;
    }

    public void setFOrder(BigInteger fOrder) {
        this.fOrder = fOrder;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Character getMultiple() {
        return multiple;
    }

    public void setMultiple(Character multiple) {
        this.multiple = multiple;
    }

    public String getFFormType() {
        return fFormType;
    }

    public void setFFormType(String fFormType) {
        this.fFormType = fFormType;
    }

    public CmActivity getActivityId() {
        return activityId;
    }

    public void setActivityId(CmActivity activityId) {
        this.activityId = activityId;
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
        if (!(object instanceof CmFormType)) {
            return false;
        }
        CmFormType other = (CmFormType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormType[ id=" + id + " ]";
    }
    
}
