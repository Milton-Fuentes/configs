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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "GlobProjectInsptestItem.findByTestId", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.testId = :testId"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByMethodId", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.methodId = :methodId"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByUnit", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.unit = :unit"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByPlanQty", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.planQty = :planQty"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByActualQty", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.actualQty = :actualQty"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByTestFreq", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.testFreq = :testFreq"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByPlanTests", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.planTests = :planTests"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByReqTests", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.reqTests = :reqTests"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByPrefTests", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.prefTests = :prefTests"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByDiffTests", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.diffTests = :diffTests"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByComments", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.comments = :comments"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByCreateBy", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByCreateByIp", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByLastModBy", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByLastMod", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByLastModIp", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByVersion", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_INSPTEST_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectInsptestItem.findAll", query = "SELECT g FROM GlobProjectInsptestItem g"),
    @NamedQuery(name = "GlobProjectInsptestItem.findById", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.id = :id"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByInsptestId", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.insptestId = :insptestId"),
    @NamedQuery(name = "GlobProjectInsptestItem.findByItemNo", query = "SELECT g FROM GlobProjectInsptestItem g WHERE g.itemNo = :itemNo")
})
public class GlobProjectInsptestItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "project_insptest_item_id_seq", sequenceName = "project_insptest_item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_insptest_item_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSPTEST_ID", nullable = false)
    private BigInteger insptestId;
    @Size(max = 30)
    @Column(name = "ITEM_NO", length = 30)
    private String itemNo;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "METHOD_ID")
    private BigInteger methodId;
    @Size(max = 30)
    @Column(name = "UNIT", length = 30)
    private String unit;
    @Column(name = "PLAN_QTY", precision = 126)
    private Double planQty;
    @Column(name = "ACTUAL_QTY", precision = 126)
    private Double actualQty;
    @Column(name = "TEST_FREQ", precision = 126)
    private Double testFreq;
    @Column(name = "PLAN_TESTS", precision = 126)
    private Double planTests;
    @Column(name = "REQ_TESTS", precision = 126)
    private Double reqTests;
    @Column(name = "PREF_TESTS", precision = 126)
    private Double prefTests;
    @Column(name = "DIFF_TESTS", precision = 126)
    private Double diffTests;
    @Size(max = 1000)
    @Column(name = "COMMENTS", length = 1000)
    private String comments;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD", length = 20)
    private String lastMod;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;

    public GlobProjectInsptestItem() {
    }

    public GlobProjectInsptestItem(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectInsptestItem(BigDecimal id, BigInteger insptestId) {
        this.id = id;
        this.insptestId = insptestId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getInsptestId() {
        return insptestId;
    }

    public void setInsptestId(BigInteger insptestId) {
        this.insptestId = insptestId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getMethodId() {
        return methodId;
    }

    public void setMethodId(BigInteger methodId) {
        this.methodId = methodId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Double planQty) {
        this.planQty = planQty;
    }

    public Double getActualQty() {
        return actualQty;
    }

    public void setActualQty(Double actualQty) {
        this.actualQty = actualQty;
    }

    public Double getTestFreq() {
        return testFreq;
    }

    public void setTestFreq(Double testFreq) {
        this.testFreq = testFreq;
    }

    public Double getPlanTests() {
        return planTests;
    }

    public void setPlanTests(Double planTests) {
        this.planTests = planTests;
    }

    public Double getReqTests() {
        return reqTests;
    }

    public void setReqTests(Double reqTests) {
        this.reqTests = reqTests;
    }

    public Double getPrefTests() {
        return prefTests;
    }

    public void setPrefTests(Double prefTests) {
        this.prefTests = prefTests;
    }

    public Double getDiffTests() {
        return diffTests;
    }

    public void setDiffTests(Double diffTests) {
        this.diffTests = diffTests;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof GlobProjectInsptestItem)) {
            return false;
        }
        GlobProjectInsptestItem other = (GlobProjectInsptestItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectInsptestItem[ id=" + id + " ]";
    }
    
}
