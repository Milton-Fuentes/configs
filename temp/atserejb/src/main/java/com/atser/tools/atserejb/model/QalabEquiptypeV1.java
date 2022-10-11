/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
    , @NamedQuery(name = "QalabEquiptypeV1.findByCatgId", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.catgId.id = :catgId")
    , @NamedQuery(name = "QalabEquiptypeV1.findByItem", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.item = :item")
    , @NamedQuery(name = "QalabEquiptypeV1.findByIntervalM", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.intervalM = :intervalM")
    , @NamedQuery(name = "QalabEquiptypeV1.findByComments", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.comments = :comments")
    , @NamedQuery(name = "QalabEquiptypeV1.findByProcedure", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.procedure = :procedure")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_EQUIPTYPE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_EQUIPTYPE SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquiptypeV1.findAll", query = "SELECT q FROM QalabEquiptypeV1 q")
    , @NamedQuery(name = "QalabEquiptypeV1.findById", query = "SELECT q FROM QalabEquiptypeV1 q WHERE q.id = :id")})
public class QalabEquiptypeV1 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QALAB_EQUIPTYPE_ID_SEQ", sequenceName = "QALAB_EQUIPTYPE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_EQUIPTYPE_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "CATG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QalabEquipcatgV1 catgId;
    @Size(max = 255)
    @Column(name = "ITEM")
    private String item;
    @Column(name = "INTERVAL_M")
    private BigInteger intervalM;
    @Size(max = 255)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 255)
    @Column(name = "PROCEDURE")
    private String procedure;
    @NotAudited
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "FIELD1")
    private String field1;
    @NotAudited
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "FIELD2")
    private String field2;
    @NotAudited
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "FIELD3")
    private String field3;
    @NotAudited
    @JsonIgnore
    @Size(max = 255)
    @Column(name = "FIELD4")
    private String field4;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD5")
    private BigInteger field5;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD6")
    private BigInteger field6;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 10)
    @Column(name = "ACTIVE")
    private String active;
    @Size(max = 512)
    @Column(name = "CALIB_METHOD")
    private String calibMethod;
    @Where(clause = "deleted = 'N'")
    //@JsonManagedReference
    @NotAudited
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equiptypeid", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QalabMainttypeV1> qalabMainttypeList;
    @NotAudited
    @Where(clause = "deleted = 'N'")
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "equipId", fetch = FetchType.LAZY)
    private List<QalabEquipinfoV1> qalabEquipInfoList;
    @Transient
    @JsonProperty("canBeDeleted")
    private String canbeDeleted;
    @NotAudited
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    
    public QalabEquiptypeV1() {
        canbeDeleted = "true";
    }
    
    public QalabEquiptypeV1(BigDecimal id) {
        this.id = id;
        canbeDeleted = "true";
    }
    
    public BigDecimal getId() {
        return id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    public QalabEquipcatgV1 getCatgId() {
        return catgId;
    }
    
    public void setCatgId(QalabEquipcatgV1 catgId) {
        this.catgId = catgId;
    }
    
    public String getItem() {
        return item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }
    
    public BigInteger getIntervalM() {
        return intervalM;
    }
    
    public void setIntervalM(BigInteger intervalM) {
        this.intervalM = intervalM;
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getProcedure() {
        return procedure;
    }
    
    public void setProcedure(String procedure) {
        this.procedure = procedure;
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
    
    public BigInteger getField5() {
        return field5;
    }
    
    public void setField5(BigInteger field5) {
        this.field5 = field5;
    }
    
    public BigInteger getField6() {
        return field6;
    }
    
    public void setField6(BigInteger field6) {
        this.field6 = field6;
    }
    
    public String getField7() {
        return field7;
    }
    
    public void setField7(String field7) {
        this.field7 = field7;
    }
    
    public String getField8() {
        return field8;
    }
    
    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
    
    public String getCalibMethod() {
        return calibMethod;
    }
    
    public void setCalibMethod(String calibMethod) {
        this.calibMethod = calibMethod;
    }

    public String getCanbeDeleted() {
        return canbeDeleted;
    }

    public void setCanbeDeleted(String canbeDeleted) {
        this.canbeDeleted = canbeDeleted;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @XmlTransient
    public List<QalabEquipinfoV1> getQalabEquipInfoList() {
        return qalabEquipInfoList;
    }

    public void setQalabEquipInfoList(List<QalabEquipinfoV1> qalabEquipInfoList) {
        this.qalabEquipInfoList = qalabEquipInfoList;
    }
    
    @XmlTransient
    public List<QalabMainttypeV1> getQalabMainttypeList() {
        return qalabMainttypeList;
    }
    
    public void setQalabMainttypeList(List<QalabMainttypeV1> qalabMainttypeList) {
        this.qalabMainttypeList = qalabMainttypeList;
    }
    
    public void addQalabMainttypeList(QalabMainttypeV1 qalabMainttype) {
        qalabMainttypeList.add(qalabMainttype);
        qalabMainttype.setEquiptypeid(this);
    }
    
    public void removeQalabMainttypeList(QalabMainttypeV1 qalabMainttype) {
        qalabMainttypeList.remove(qalabMainttype);
        qalabMainttype.setEquiptypeid(null);
    }
    
    public void buildReferences() {
        if (qalabMainttypeList != null && !qalabMainttypeList.isEmpty()) {
            qalabMainttypeList.forEach(p -> {
                p.setEquiptypeid(this);
            });
        }
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
        if (!(object instanceof QalabEquiptypeV1)) {
            return false;
        }
        QalabEquiptypeV1 other = (QalabEquiptypeV1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabEquiptypeV1[ id=" + id + " ]";
    }
    
}
