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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "QmProjContrPers.findByCreatedDate", query = "SELECT q FROM QmProjContrPers q WHERE q.createdDate = :createdDate"),
    @NamedQuery(name = "QmProjContrPers.findByLastModDate", query = "SELECT q FROM QmProjContrPers q WHERE q.lastModDate = :lastModDate"),
    @NamedQuery(name = "QmProjContrPers.findByVersion", query = "SELECT q FROM QmProjContrPers q WHERE q.version = :version"),
    @NamedQuery(name = "QmProjContrPers.findByDeleted", query = "SELECT q FROM QmProjContrPers q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QmProjContrPers.findByActive", query = "SELECT q FROM QmProjContrPers q WHERE q.active = :active")
 */
/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE QM_PROJ_CONTR_PERS SET DELETED = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "DELETED = 'N'")
@Table(name = "QM_PROJ_CONTR_PERS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmProjContrPers.findAll", query = "SELECT q FROM QmProjContrPers q"),
    @NamedQuery(name = "QmProjContrPers.findById", query = "SELECT q FROM QmProjContrPers q WHERE q.id = :id")})
public class QmProjContrPers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QM_PROJ_CONTR_PERS_SEQ", sequenceName = "QM_PROJ_CONTR_PERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QM_PROJ_CONTR_PERS_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "LAST_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDate;
    @Column(name = "VERSION")
    private BigInteger version;
    @JsonIgnore
    @Column(name = "DELETED", insertable = false, updatable = false)
    private Character deleted;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Column(name = "MAIN")
    private Character main;
    @JoinColumn(name = "PROJ_CONTR_PERS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobProjContrPersonnel projContrPersId;
    @JoinColumn(name = "PERSONNEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QmPersonnel personnelId;

    public QmProjContrPers() {
    }

    public QmProjContrPers(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public GlobProjContrPersonnel getProjContrPersId() {
        return projContrPersId;
    }

    public void setProjContrPersId(GlobProjContrPersonnel projContrPersId) {
        this.projContrPersId = projContrPersId;
    }

    public QmPersonnel getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(QmPersonnel personnelId) {
        this.personnelId = personnelId;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
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
        if (!(object instanceof QmProjContrPers)) {
            return false;
        }
        QmProjContrPers other = (QmProjContrPers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmProjContrPers[ id=" + id + " ]";
    }

}
