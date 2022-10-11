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
@NamedQuery(name = "GlobBiditemsubMaster.findByClientId", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRangeItemNo", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.rangeItemNo = :rangeItemNo"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySubItemDescript", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.subItemDescript = :subItemDescript"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByUnit", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.unit = :unit"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByPType", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.pType = :pType"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByDefType", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.defType = :defType"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByIaType", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.iaType = :iaType"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByAccFreq", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.accFreq = :accFreq"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRms1", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.rms1 = :rms1"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRms2", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.rms2 = :rms2"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRms3", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.rms3 = :rms3"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRmsD", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.rmsD = :rmsD"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByCertc", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.certc = :certc"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByOtherNote", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.otherNote = :otherNote"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySeeDme", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.seeDme = :seeDme"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySpecNo", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.specNo = :specNo"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByFinalized", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.finalized = :finalized"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByRemarks", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByActive", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.active = :active"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField1", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField2", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField3", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field3 = :field3"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField4", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field4 = :field4"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField5", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field5 = :field5"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByField6", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.field6 = :field6"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByCreateBy", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByCreateByIp", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByLastModBy", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByLastMod", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByLastModIp", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByVersion", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.version = :version"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByItemType", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.itemType = :itemType"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySpecPid", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.specPid = :specPid"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByMatSpec", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.matSpec = :matSpec"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByConstSect", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.constSect = :constSect"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByMatCatg", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.matCatg = :matCatg"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySampleSize", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.sampleSize = :sampleSize"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByPointSample", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.pointSample = :pointSample"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByAccLotSize", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.accLotSize = :accLotSize"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByAccSublotSize", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.accSublotSize = :accSublotSize"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByQcLotSize", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.qcLotSize = :qcLotSize"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByQcSublotSize", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.qcSublotSize = :qcSublotSize"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByQcFreq", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.qcFreq = :qcFreq"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySamplePrepMethod", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.samplePrepMethod = :samplePrepMethod"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySpecPrepMethod", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.specPrepMethod = :specPrepMethod"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByTestMethod", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.testMethod = :testMethod"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByInspection", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.inspection = :inspection"),
    @NamedQuery(name = "GlobBiditemsubMaster.findBySourceVerf", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.sourceVerf = :sourceVerf"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByTestMethod1", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.testMethod1 = :testMethod1"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByTestMethod2", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.testMethod2 = :testMethod2"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByTestMethod3", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.testMethod3 = :testMethod3"),
    @NamedQuery(name = "GlobBiditemsubMaster.findByIaCatgId", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.iaCatgId = :iaCatgId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_BIDITEMSUB_MASTER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobBiditemsubMaster.findAll", query = "SELECT g FROM GlobBiditemsubMaster g"),
    @NamedQuery(name = "GlobBiditemsubMaster.findById", query = "SELECT g FROM GlobBiditemsubMaster g WHERE g.id = :id")})
public class GlobBiditemsubMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 500)
    @Column(name = "RANGE_ITEM_NO")
    private String rangeItemNo;
    @Size(max = 500)
    @Column(name = "SUB_ITEM_DESCRIPT")
    private String subItemDescript;
    @Size(max = 100)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 100)
    @Column(name = "P_TYPE")
    private String pType;
    @Size(max = 100)
    @Column(name = "DEF_TYPE")
    private String defType;
    @Size(max = 100)
    @Column(name = "IA_TYPE")
    private String iaType;
    @Size(max = 500)
    @Column(name = "ACC_FREQ")
    private String accFreq;
    @Size(max = 200)
    @Column(name = "RMS_1")
    private String rms1;
    @Size(max = 200)
    @Column(name = "RMS_2")
    private String rms2;
    @Size(max = 200)
    @Column(name = "RMS_3")
    private String rms3;
    @Size(max = 200)
    @Column(name = "RMS_D")
    private String rmsD;
    @Size(max = 100)
    @Column(name = "CERTC")
    private String certc;
    @Size(max = 1000)
    @Column(name = "OTHER_NOTE")
    private String otherNote;
    @Size(max = 500)
    @Column(name = "SEE_DME")
    private String seeDme;
    @Size(max = 500)
    @Column(name = "SPEC_NO")
    private String specNo;
    @Size(max = 500)
    @Column(name = "FINALIZED")
    private String finalized;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 100)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Column(name = "SPEC_PID")
    private BigInteger specPid;
    @Size(max = 1000)
    @Column(name = "MAT_SPEC")
    private String matSpec;
    @Size(max = 100)
    @Column(name = "CONST_SECT")
    private String constSect;
    @Size(max = 100)
    @Column(name = "MAT_CATG")
    private String matCatg;
    @Size(max = 200)
    @Column(name = "SAMPLE_SIZE")
    private String sampleSize;
    @Size(max = 1000)
    @Column(name = "POINT_SAMPLE")
    private String pointSample;
    @Size(max = 500)
    @Column(name = "ACC_LOT_SIZE")
    private String accLotSize;
    @Size(max = 100)
    @Column(name = "ACC_SUBLOT_SIZE")
    private String accSublotSize;
    @Size(max = 100)
    @Column(name = "QC_LOT_SIZE")
    private String qcLotSize;
    @Size(max = 100)
    @Column(name = "QC_SUBLOT_SIZE")
    private String qcSublotSize;
    @Size(max = 500)
    @Column(name = "QC_FREQ")
    private String qcFreq;
    @Size(max = 500)
    @Column(name = "SAMPLE_PREP_METHOD")
    private String samplePrepMethod;
    @Size(max = 500)
    @Column(name = "SPEC_PREP_METHOD")
    private String specPrepMethod;
    @Size(max = 500)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 500)
    @Column(name = "INSPECTION")
    private String inspection;
    @Size(max = 500)
    @Column(name = "SOURCE_VERF")
    private String sourceVerf;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_1")
    private String testMethod1;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_2")
    private String testMethod2;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_3")
    private String testMethod3;
    @Column(name = "IA_CATG_ID")
    private BigInteger iaCatgId;

    public GlobBiditemsubMaster() {
    }

    public GlobBiditemsubMaster(BigDecimal id) {
        this.id = id;
    }

    public GlobBiditemsubMaster(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getRangeItemNo() {
        return rangeItemNo;
    }

    public void setRangeItemNo(String rangeItemNo) {
        this.rangeItemNo = rangeItemNo;
    }

    public String getSubItemDescript() {
        return subItemDescript;
    }

    public void setSubItemDescript(String subItemDescript) {
        this.subItemDescript = subItemDescript;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getDefType() {
        return defType;
    }

    public void setDefType(String defType) {
        this.defType = defType;
    }

    public String getIaType() {
        return iaType;
    }

    public void setIaType(String iaType) {
        this.iaType = iaType;
    }

    public String getAccFreq() {
        return accFreq;
    }

    public void setAccFreq(String accFreq) {
        this.accFreq = accFreq;
    }

    public String getRms1() {
        return rms1;
    }

    public void setRms1(String rms1) {
        this.rms1 = rms1;
    }

    public String getRms2() {
        return rms2;
    }

    public void setRms2(String rms2) {
        this.rms2 = rms2;
    }

    public String getRms3() {
        return rms3;
    }

    public void setRms3(String rms3) {
        this.rms3 = rms3;
    }

    public String getRmsD() {
        return rmsD;
    }

    public void setRmsD(String rmsD) {
        this.rmsD = rmsD;
    }

    public String getCertc() {
        return certc;
    }

    public void setCertc(String certc) {
        this.certc = certc;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote;
    }

    public String getSeeDme() {
        return seeDme;
    }

    public void setSeeDme(String seeDme) {
        this.seeDme = seeDme;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public String getFinalized() {
        return finalized;
    }

    public void setFinalized(String finalized) {
        this.finalized = finalized;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigInteger getSpecPid() {
        return specPid;
    }

    public void setSpecPid(BigInteger specPid) {
        this.specPid = specPid;
    }

    public String getMatSpec() {
        return matSpec;
    }

    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    public String getConstSect() {
        return constSect;
    }

    public void setConstSect(String constSect) {
        this.constSect = constSect;
    }

    public String getMatCatg() {
        return matCatg;
    }

    public void setMatCatg(String matCatg) {
        this.matCatg = matCatg;
    }

    public String getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(String sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getPointSample() {
        return pointSample;
    }

    public void setPointSample(String pointSample) {
        this.pointSample = pointSample;
    }

    public String getAccLotSize() {
        return accLotSize;
    }

    public void setAccLotSize(String accLotSize) {
        this.accLotSize = accLotSize;
    }

    public String getAccSublotSize() {
        return accSublotSize;
    }

    public void setAccSublotSize(String accSublotSize) {
        this.accSublotSize = accSublotSize;
    }

    public String getQcLotSize() {
        return qcLotSize;
    }

    public void setQcLotSize(String qcLotSize) {
        this.qcLotSize = qcLotSize;
    }

    public String getQcSublotSize() {
        return qcSublotSize;
    }

    public void setQcSublotSize(String qcSublotSize) {
        this.qcSublotSize = qcSublotSize;
    }

    public String getQcFreq() {
        return qcFreq;
    }

    public void setQcFreq(String qcFreq) {
        this.qcFreq = qcFreq;
    }

    public String getSamplePrepMethod() {
        return samplePrepMethod;
    }

    public void setSamplePrepMethod(String samplePrepMethod) {
        this.samplePrepMethod = samplePrepMethod;
    }

    public String getSpecPrepMethod() {
        return specPrepMethod;
    }

    public void setSpecPrepMethod(String specPrepMethod) {
        this.specPrepMethod = specPrepMethod;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getSourceVerf() {
        return sourceVerf;
    }

    public void setSourceVerf(String sourceVerf) {
        this.sourceVerf = sourceVerf;
    }

    public String getTestMethod1() {
        return testMethod1;
    }

    public void setTestMethod1(String testMethod1) {
        this.testMethod1 = testMethod1;
    }

    public String getTestMethod2() {
        return testMethod2;
    }

    public void setTestMethod2(String testMethod2) {
        this.testMethod2 = testMethod2;
    }

    public String getTestMethod3() {
        return testMethod3;
    }

    public void setTestMethod3(String testMethod3) {
        this.testMethod3 = testMethod3;
    }

    public BigInteger getIaCatgId() {
        return iaCatgId;
    }

    public void setIaCatgId(BigInteger iaCatgId) {
        this.iaCatgId = iaCatgId;
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
        if (!(object instanceof GlobBiditemsubMaster)) {
            return false;
        }
        GlobBiditemsubMaster other = (GlobBiditemsubMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobBiditemsubMaster[ id=" + id + " ]";
    }
    
}
