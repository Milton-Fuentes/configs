/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/*
@Table(name = "AGGSIEVE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aggsieve.findAll", query = "SELECT a FROM Aggsieve a"),
    @NamedQuery(name = "Aggsieve.findByTestid", query = "SELECT a FROM Aggsieve a WHERE a.testid = :testid"),
    @NamedQuery(name = "Aggsieve.findByTesttype", query = "SELECT a FROM Aggsieve a WHERE a.testtype = :testtype"),
    @NamedQuery(name = "Aggsieve.findBySampletestId", query = "SELECT a FROM Aggsieve a WHERE a.sampletestId = :sampletestId"),
    @NamedQuery(name = "Aggsieve.findByTestno", query = "SELECT a FROM Aggsieve a WHERE a.testno = :testno"),
    @NamedQuery(name = "Aggsieve.findBySegment", query = "SELECT a FROM Aggsieve a WHERE a.segment = :segment"),
    @NamedQuery(name = "Aggsieve.findByAppvd", query = "SELECT a FROM Aggsieve a WHERE a.appvd = :appvd"),
    @NamedQuery(name = "Aggsieve.findByFunction", query = "SELECT a FROM Aggsieve a WHERE a.function = :function"),
    @NamedQuery(name = "Aggsieve.findByTraceNo", query = "SELECT a FROM Aggsieve a WHERE a.traceNo = :traceNo"),
    @NamedQuery(name = "Aggsieve.findByActive", query = "SELECT a FROM Aggsieve a WHERE a.active = :active"),
    @NamedQuery(name = "Aggsieve.findByActvno", query = "SELECT a FROM Aggsieve a WHERE a.actvno = :actvno"),
    @NamedQuery(name = "Aggsieve.findByTechname", query = "SELECT a FROM Aggsieve a WHERE a.techname = :techname"),
    @NamedQuery(name = "Aggsieve.findByFm", query = "SELECT a FROM Aggsieve a WHERE a.fm = :fm"),
    @NamedQuery(name = "Aggsieve.findBySampletestid", query = "SELECT a FROM Aggsieve a WHERE a.sampletestid = :sampletestid"),
    @NamedQuery(name = "Aggsieve.findByClientId", query = "SELECT a FROM Aggsieve a WHERE a.clientId = :clientId"),
    @NamedQuery(name = "Aggsieve.findByName", query = "SELECT a FROM Aggsieve a WHERE a.name = :name"),
    @NamedQuery(name = "Aggsieve.findByCompanyid", query = "SELECT a FROM Aggsieve a WHERE a.companyid = :companyid"),
    @NamedQuery(name = "Aggsieve.findByProjectNo", query = "SELECT a FROM Aggsieve a WHERE a.projectNo = :projectNo"),
    @NamedQuery(name = "Aggsieve.findByLotno", query = "SELECT a FROM Aggsieve a WHERE a.lotno = :lotno"),
    @NamedQuery(name = "Aggsieve.findByTestnum", query = "SELECT a FROM Aggsieve a WHERE a.testnum = :testnum"),
    @NamedQuery(name = "Aggsieve.findByTestdate", query = "SELECT a FROM Aggsieve a WHERE a.testdate = :testdate"),
    @NamedQuery(name = "Aggsieve.findByLabid", query = "SELECT a FROM Aggsieve a WHERE a.labid = :labid"),
    @NamedQuery(name = "Aggsieve.findByLabname", query = "SELECT a FROM Aggsieve a WHERE a.labname = :labname"),
    @NamedQuery(name = "Aggsieve.findBySetName", query = "SELECT a FROM Aggsieve a WHERE a.setName = :setName"),
    @NamedQuery(name = "Aggsieve.findByCatg", query = "SELECT a FROM Aggsieve a WHERE a.catg = :catg"),
    @NamedQuery(name = "Aggsieve.findBySetId", query = "SELECT a FROM Aggsieve a WHERE a.setId = :setId"),
    @NamedQuery(name = "Aggsieve.findBySieveId", query = "SELECT a FROM Aggsieve a WHERE a.sieveId = :sieveId"),
    @NamedQuery(name = "Aggsieve.findByMtype", query = "SELECT a FROM Aggsieve a WHERE a.mtype = :mtype"),
    @NamedQuery(name = "Aggsieve.findByCommonName", query = "SELECT a FROM Aggsieve a WHERE a.commonName = :commonName"),
    @NamedQuery(name = "Aggsieve.findByOrdering", query = "SELECT a FROM Aggsieve a WHERE a.ordering = :ordering"),
    @NamedQuery(name = "Aggsieve.findByPercentpass1", query = "SELECT a FROM Aggsieve a WHERE a.percentpass1 = :percentpass1")})
 */
/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "AGGSIEVE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aggsieve.findAll", query = "SELECT a FROM Aggsieve a")})
public class Aggsieve implements Serializable {

    private static final long serialVersionUID = 1L;
    //@Column(columnDefinition = "BINARY(16)")
    //private UUID uuid;
    @Id
    @Column(name = "TESTID")
    private BigInteger testid;
    @Size(max = 15)
    @Column(name = "TESTTYPE")
    private String testtype;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestId;
    @Size(max = 71)
    @Column(name = "TESTNO")
    private String testno;
    @Column(name = "SEGMENT")
    private BigInteger segment;
    @Size(max = 50)
    @Column(name = "APPVD")
    private String appvd;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "ACTVNO")
    private String actvno;
    @Size(max = 50)
    @Column(name = "TECHNAME")
    private String techname;
    @Size(max = 50)
    @Column(name = "FM")
    private String fm;
    @Column(name = "SAMPLETESTID")
    private BigInteger sampletestid;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "COMPANYID")
    private String companyid;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Column(name = "LOTNO")
    private Character lotno;
    @Size(max = 81)
    @Column(name = "TESTNUM")
    private String testnum;
    @Column(name = "TESTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testdate;
    @Size(max = 255)
    @Column(name = "LABID")
    private String labid;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Column(name = "CATG")
    private BigInteger catg;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Column(name = "MTYPE")
    private Character mtype;
    @Size(max = 50)
    @Column(name = "COMMON_NAME")
    private String commonName;
    @Column(name = "ORDERING")
    private BigInteger ordering;
    @Column(name = "PERCENTPASS1")
    private BigInteger percentpass1;

    public Aggsieve() {
    }

    public BigInteger getTestid() {
        return testid;
    }

    public void setTestid(BigInteger testid) {
        this.testid = testid;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public BigInteger getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigInteger sampletestId) {
        this.sampletestId = sampletestId;
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno;
    }

    public BigInteger getSegment() {
        return segment;
    }

    public void setSegment(BigInteger segment) {
        this.segment = segment;
    }

    public String getAppvd() {
        return appvd;
    }

    public void setAppvd(String appvd) {
        this.appvd = appvd;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getActvno() {
        return actvno;
    }

    public void setActvno(String actvno) {
        this.actvno = actvno;
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public BigInteger getSampletestid() {
        return sampletestid;
    }

    public void setSampletestid(BigInteger sampletestid) {
        this.sampletestid = sampletestid;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Character getLotno() {
        return lotno;
    }

    public void setLotno(Character lotno) {
        this.lotno = lotno;
    }

    public String getTestnum() {
        return testnum;
    }

    public void setTestnum(String testnum) {
        this.testnum = testnum;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public BigInteger getCatg() {
        return catg;
    }

    public void setCatg(BigInteger catg) {
        this.catg = catg;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public Character getMtype() {
        return mtype;
    }

    public void setMtype(Character mtype) {
        this.mtype = mtype;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
    }

    public BigInteger getPercentpass1() {
        return percentpass1;
    }

    public void setPercentpass1(BigInteger percentpass1) {
        this.percentpass1 = percentpass1;
    }

}
