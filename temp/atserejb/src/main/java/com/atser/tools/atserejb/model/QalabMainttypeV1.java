/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    , @NamedQuery(name = "QalabMainttypeV1.findByEquippartName", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.equippartName = :equippartName")
    , @NamedQuery(name = "QalabMainttypeV1.findByProcedure", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.procedure = :procedure")
    , @NamedQuery(name = "QalabMainttypeV1.findByIntervalM", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.intervalM = :intervalM")
    , @NamedQuery(name = "QalabMainttypeV1.findByEquiptypeid", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.equiptypeid = :equiptypeid")
    , @NamedQuery(name = "QalabMainttypeV1.findByDeleted", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.deleted = :deleted")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_MAINTTYPE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_MAINTTYPE SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabMainttypeV1.findAll", query = "SELECT q FROM QalabMainttypeV1 q")
    , @NamedQuery(name = "QalabMainttypeV1.findById", query = "SELECT q FROM QalabMainttypeV1 q WHERE q.id = :id")})
public class QalabMainttypeV1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QALAB_MAINTTYPE_SEQ", sequenceName = "QALAB_MAINTTYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_MAINTTYPE_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "EQUIPPART_NAME")
    private String equippartName;
    @Size(max = 512)
    @Column(name = "PROCEDURE")
    private String procedure;
    @Column(name = "INTERVAL_M")
    private BigInteger intervalM;
    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "EQUIPTYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private QalabEquiptypeV1 equiptypeid;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @NotAudited
    @Where(clause = "deleted = 'N'")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipMaintTypeid", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QalabMaintlogV1> qalabMaintlogList;

    public QalabMainttypeV1() {
    }

    public QalabMainttypeV1(BigDecimal id) {
        this.id = id;
    }

    public QalabMainttypeV1(BigDecimal id, QalabEquiptypeV1 equiptypeid) {
        this.id = id;
        this.equiptypeid = equiptypeid;
    }

    public QalabMainttypeV1(String equippartName, String procedure, BigInteger intervalM) {
        this.equippartName = equippartName;
        this.procedure = procedure;
        this.intervalM = intervalM;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEquippartName() {
        return equippartName;
    }

    public void setEquippartName(String equippartName) {
        this.equippartName = equippartName;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public BigInteger getIntervalM() {
        return intervalM;
    }

    public void setIntervalM(BigInteger intervalM) {
        this.intervalM = intervalM;
    }

    public QalabEquiptypeV1 getEquiptypeid() {
        return equiptypeid;
    }

    public void setEquiptypeid(QalabEquiptypeV1 equiptypeid) {
        this.equiptypeid = equiptypeid;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public List<QalabMaintlogV1> getQalabMaintlogList() {
        return qalabMaintlogList;
    }

    public void setQalabMaintlogList(List<QalabMaintlogV1> qalabMaintlogList) {
        this.qalabMaintlogList = qalabMaintlogList;
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
        if (!(object instanceof QalabMainttypeV1)) {
            return false;
        }
        QalabMainttypeV1 other = (QalabMainttypeV1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabMainttypeV1[ id=" + id + " ]";
    }

}
