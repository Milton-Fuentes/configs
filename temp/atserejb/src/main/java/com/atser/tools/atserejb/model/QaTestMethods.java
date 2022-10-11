/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    , @NamedQuery(name = "QaTestMethods.findByName", query = "SELECT q FROM QaTestMethods q WHERE q.name = :name")
    , @NamedQuery(name = "QaTestMethods.findByCatgId", query = "SELECT q FROM QaTestMethods q WHERE q.catgId = :catgId")
    , @NamedQuery(name = "QaTestMethods.findByDescription", query = "SELECT q FROM QaTestMethods q WHERE q.description = :description")
    , @NamedQuery(name = "QaTestMethods.findByReference", query = "SELECT q FROM QaTestMethods q WHERE q.reference = :reference")
    , @NamedQuery(name = "QaTestMethods.findByJspPage", query = "SELECT q FROM QaTestMethods q WHERE q.jspPage = :jspPage")
    , @NamedQuery(name = "QaTestMethods.findByTestTable", query = "SELECT q FROM QaTestMethods q WHERE q.testTable = :testTable")
    , @NamedQuery(name = "QaTestMethods.findByActive", query = "SELECT q FROM QaTestMethods q WHERE q.active = :active")
    , @NamedQuery(name = "QaTestMethods.findByUseSampleid", query = "SELECT q FROM QaTestMethods q WHERE q.useSampleid = :useSampleid")
    , @NamedQuery(name = "QaTestMethods.findByLastModTmp", query = "SELECT q FROM QaTestMethods q WHERE q.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "QaTestMethods.findByLastMod", query = "SELECT q FROM QaTestMethods q WHERE q.lastMod = :lastMod")
    , @NamedQuery(name = "QaTestMethods.findByMobile", query = "SELECT q FROM QaTestMethods q WHERE q.mobile = :mobile")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TEST_METHODS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTestMethods.findAll", query = "SELECT q FROM QaTestMethods q"),
    @NamedQuery(name = "QaTestMethods.findById", query = "SELECT q FROM QaTestMethods q WHERE q.id = :id")})
public class QaTestMethods implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATG_ID")
    private BigInteger catgId;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "REFERENCE")
    private String reference;
    @Size(max = 50)
    @Column(name = "JSP_PAGE")
    private String jspPage;
    @Size(max = 50)
    @Column(name = "TEST_TABLE")
    private String testTable;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "USE_SAMPLEID")
    private Character useSampleid;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "MOBILE")
    private BigInteger mobile;
    @Size(max = 255)
    @Column(name = "WS_PATH")
    private String wsPath;
    @OneToMany(mappedBy = "testId", fetch = FetchType.LAZY)
    private Set<GlobClientTest> globClientTest;

    public QaTestMethods() {
    }

    public QaTestMethods(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCatgId() {
        return catgId;
    }

    public void setCatgId(BigInteger catgId) {
        this.catgId = catgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getJspPage() {
        return jspPage;
    }

    public void setJspPage(String jspPage) {
        this.jspPage = jspPage;
    }

    public String getTestTable() {
        return testTable;
    }

    public void setTestTable(String testTable) {
        this.testTable = testTable;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getUseSampleid() {
        return useSampleid;
    }

    public void setUseSampleid(Character useSampleid) {
        this.useSampleid = useSampleid;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public String getWsPath() {
        return wsPath;
    }

    public void setWsPath(String wsPath) {
        this.wsPath = wsPath;
    }

    public Set<GlobClientTest> getGlobClientTest() {
        return globClientTest;
    }

    public void setGlobClientTest(Set<GlobClientTest> globClientTest) {
        this.globClientTest = globClientTest;
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
        if (!(object instanceof QaTestMethods)) {
            return false;
        }
        QaTestMethods other = (QaTestMethods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTestMethods[ id=" + id + " ]";
    }

}
