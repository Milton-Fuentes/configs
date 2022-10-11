/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobCertificationTest.findByQualificationId", query = "SELECT g FROM GlobCertificationTest g WHERE g.qualificationId = :qualificationId")
    , @NamedQuery(name = "GlobCertificationTest.findByTestId", query = "SELECT g FROM GlobCertificationTest g WHERE g.testId = :testId")
    , @NamedQuery(name = "GlobCertificationTest.findByLastModBy", query = "SELECT g FROM GlobCertificationTest g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobCertificationTest.findByLastModIp", query = "SELECT g FROM GlobCertificationTest g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobCertificationTest.findByLastMod", query = "SELECT g FROM GlobCertificationTest g WHERE g.lastMod = :lastMod")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CERTIFICATION_TEST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCertificationTest.findAll", query = "SELECT g FROM GlobCertificationTest g"),
    @NamedQuery(name = "GlobCertificationTest.findById", query = "SELECT g FROM GlobCertificationTest g WHERE g.id = :id")})
public class GlobCertificationTest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_certification_test_id_seq", sequenceName = "glob_certification_test_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_certification_test_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @JoinColumn(name = "QUALIFICATION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobCertification qualificationId;
    @NotNull
    @JoinColumn(name = "TEST_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaTestMethods testId;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;

    public GlobCertificationTest() {
    }

    public GlobCertificationTest(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobCertification getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(GlobCertification qualificationId) {
        this.qualificationId = qualificationId;
    }

    public QaTestMethods getTestId() {
        return testId;
    }

    public void setTestId(QaTestMethods testId) {
        this.testId = testId;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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
        if (!(object instanceof GlobCertificationTest)) {
            return false;
        }
        GlobCertificationTest other = (GlobCertificationTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCertificationTest[ id=" + id + " ]";
    }

}
