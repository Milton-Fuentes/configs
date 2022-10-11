/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "QaconcCompstrout.findByTestage", query = "SELECT q FROM QaconcCompstrout q WHERE q.testage = :testage"),
    @NamedQuery(name = "QaconcCompstrout.findBySamplesize", query = "SELECT q FROM QaconcCompstrout q WHERE q.samplesize = :samplesize"),
    @NamedQuery(name = "QaconcCompstrout.findByMaximumload", query = "SELECT q FROM QaconcCompstrout q WHERE q.maximumload = :maximumload"),
    @NamedQuery(name = "QaconcCompstrout.findByArea", query = "SELECT q FROM QaconcCompstrout q WHERE q.area = :area"),
    @NamedQuery(name = "QaconcCompstrout.findByCompressStrength", query = "SELECT q FROM QaconcCompstrout q WHERE q.compressStrength = :compressStrength"),
    @NamedQuery(name = "QaconcCompstrout.findByTypeoffracture", query = "SELECT q FROM QaconcCompstrout q WHERE q.typeoffracture = :typeoffracture"),
    @NamedQuery(name = "QaconcCompstrout.findByTech", query = "SELECT q FROM QaconcCompstrout q WHERE q.tech = :tech"),
    @NamedQuery(name = "QaconcCompstrout.findByWon", query = "SELECT q FROM QaconcCompstrout q WHERE q.won = :won"),
    @NamedQuery(name = "QaconcCompstrout.findByReport", query = "SELECT q FROM QaconcCompstrout q WHERE q.report = :report"),
    @NamedQuery(name = "QaconcCompstrout.findByActive", query = "SELECT q FROM QaconcCompstrout q WHERE q.active = :active"),
    @NamedQuery(name = "QaconcCompstrout.findByLastModBy", query = "SELECT q FROM QaconcCompstrout q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaconcCompstrout.findByLastModIp", query = "SELECT q FROM QaconcCompstrout q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaconcCompstrout.findByCreateBy", query = "SELECT q FROM QaconcCompstrout q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaconcCompstrout.findByCreateByIp", query = "SELECT q FROM QaconcCompstrout q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaconcCompstrout.findByVersion", query = "SELECT q FROM QaconcCompstrout q WHERE q.version = :version"),
    @NamedQuery(name = "QaconcCompstrout.findBySpecsection", query = "SELECT q FROM QaconcCompstrout q WHERE q.specsection = :specsection"),
    @NamedQuery(name = "QaconcCompstrout.findByDatetestTmp", query = "SELECT q FROM QaconcCompstrout q WHERE q.datetestTmp = :datetestTmp"),
    @NamedQuery(name = "QaconcCompstrout.findByLastModTmp", query = "SELECT q FROM QaconcCompstrout q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QaconcCompstrout.findByCreateDateTmp", query = "SELECT q FROM QaconcCompstrout q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QaconcCompstrout.findByLastMod", query = "SELECT q FROM QaconcCompstrout q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaconcCompstrout.findByCreateDate", query = "SELECT q FROM QaconcCompstrout q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaconcCompstrout.findByDatetest", query = "SELECT q FROM QaconcCompstrout q WHERE q.datetest = :datetest"),
    @NamedQuery(name = "QaconcCompstrout.findByRequiredstrength", query = "SELECT q FROM QaconcCompstrout q WHERE q.requiredstrength = :requiredstrength"),
    @NamedQuery(name = "QaconcCompstrout.findByLifting", query = "SELECT q FROM QaconcCompstrout q WHERE q.lifting = :lifting"),
    @NamedQuery(name = "QaconcCompstrout.findByLabStampNo", query = "SELECT q FROM QaconcCompstrout q WHERE q.labStampNo = :labStampNo"),
    @NamedQuery(name = "QaconcCompstrout.findByMachinceUsed", query = "SELECT q FROM QaconcCompstrout q WHERE q.machinceUsed = :machinceUsed"),
    @NamedQuery(name = "QaconcCompstrout.findByWeight", query = "SELECT q FROM QaconcCompstrout q WHERE q.weight = :weight"),
    @NamedQuery(name = "QaconcCompstrout.findByTestageHours", query = "SELECT q FROM QaconcCompstrout q WHERE q.testageHours = :testageHours"),
    @NamedQuery(name = "QaconcCompstrout.findByDiscard", query = "SELECT q FROM QaconcCompstrout q WHERE q.discard = :discard"),
    @NamedQuery(name = "QaconcCompstrout.findByDiameter", query = "SELECT q FROM QaconcCompstrout q WHERE q.diameter = :diameter"),
    @NamedQuery(name = "QaconcCompstrout.findByBreakLocation", query = "SELECT q FROM QaconcCompstrout q WHERE q.breakLocation = :breakLocation"),
    @NamedQuery(name = "QaconcCompstrout.findByDiameter1", query = "SELECT q FROM QaconcCompstrout q WHERE q.diameter1 = :diameter1"),
    @NamedQuery(name = "QaconcCompstrout.findByDiameter2", query = "SELECT q FROM QaconcCompstrout q WHERE q.diameter2 = :diameter2"),
    @NamedQuery(name = "QaconcCompstrout.findByDiameter3", query = "SELECT q FROM QaconcCompstrout q WHERE q.diameter3 = :diameter3"),
    @NamedQuery(name = "QaconcCompstrout.findByHeight1", query = "SELECT q FROM QaconcCompstrout q WHERE q.height1 = :height1"),
    @NamedQuery(name = "QaconcCompstrout.findByHeight2", query = "SELECT q FROM QaconcCompstrout q WHERE q.height2 = :height2"),
    @NamedQuery(name = "QaconcCompstrout.findByHeight3", query = "SELECT q FROM QaconcCompstrout q WHERE q.height3 = :height3"),
    @NamedQuery(name = "QaconcCompstrout.findByHeight", query = "SELECT q FROM QaconcCompstrout q WHERE q.height = :height"),
    @NamedQuery(name = "QaconcCompstrout.findByDiscardCompleted", query = "SELECT q FROM QaconcCompstrout q WHERE q.discardCompleted = :discardCompleted"),
    @NamedQuery(name = "QaconcCompstrout.findByDiscardRequired", query = "SELECT q FROM QaconcCompstrout q WHERE q.discardRequired = :discardRequired"),
    @NamedQuery(name = "QaconcCompstrout.findByWidth", query = "SELECT q FROM QaconcCompstrout q WHERE q.width = :width"),
    @NamedQuery(name = "QaconcCompstrout.findByWidth1", query = "SELECT q FROM QaconcCompstrout q WHERE q.width1 = :width1"),
    @NamedQuery(name = "QaconcCompstrout.findByWidth2", query = "SELECT q FROM QaconcCompstrout q WHERE q.width2 = :width2"),
    @NamedQuery(name = "QaconcCompstrout.findByWidth3", query = "SELECT q FROM QaconcCompstrout q WHERE q.width3 = :width3"),
    @NamedQuery(name = "QaconcCompstrout.findByLength", query = "SELECT q FROM QaconcCompstrout q WHERE q.length = :length"),
    @NamedQuery(name = "QaconcCompstrout.findByLength1", query = "SELECT q FROM QaconcCompstrout q WHERE q.length1 = :length1"),
    @NamedQuery(name = "QaconcCompstrout.findByLength2", query = "SELECT q FROM QaconcCompstrout q WHERE q.length2 = :length2"),
    @NamedQuery(name = "QaconcCompstrout.findByLength3", query = "SELECT q FROM QaconcCompstrout q WHERE q.length3 = :length3")
*/

/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QACONC_COMPSTROUT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaconcCompstrout.findAll", query = "SELECT q FROM QaconcCompstrout q"),
    @NamedQuery(name = "QaconcCompstrout.findById", query = "SELECT q FROM QaconcCompstrout q WHERE q.id = :id"),
    @NamedQuery(name = "QaconcCompstrout.findByTestIdAndNo", query = "SELECT q FROM QaconcCompstrout q WHERE q.testId = :testId AND q.no = :no"),
    @NamedQuery(name = "QaconcCompstrout.findByTestId", query = "SELECT q FROM QaconcCompstrout q WHERE q.testId = :testId"),
    @NamedQuery(name = "QaconcCompstrout.findBySampleidno", query = "SELECT q FROM QaconcCompstrout q WHERE q.sampleidno = :sampleidno")})
public class QaconcCompstrout implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QACONC_COMPSTROUT_ID_SEQ", sequenceName = "QACONC_COMPSTROUT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QACONC_COMPSTROUT_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 50)
    @Column(name = "SAMPLEIDNO", length = 50)
    private String sampleidno;
    @Size(max = 50)
    @Column(name = "NO", length = 50)
    private String no;
    @Size(max = 50)
    @Column(name = "TESTAGE", length = 50)
    private String testage;
    @Size(max = 50)
    @Column(name = "SAMPLESIZE", length = 50)
    private String samplesize;
    @Size(max = 50)
    @Column(name = "MAXIMUMLOAD", length = 50)
    private String maximumload;
    @Size(max = 50)
    @Column(name = "AREA", length = 50)
    private String area;
    @Size(max = 50)
    @Column(name = "COMPRESS_STRENGTH", length = 50)
    private String compressStrength;
    @Size(max = 50)
    @Column(name = "TYPEOFFRACTURE", length = 50)
    private String typeoffracture;
    @Size(max = 50)
    @Column(name = "TECH", length = 50)
    private String tech;
    @Size(max = 50)
    @Column(name = "WON", length = 50)
    private String won;
    @Size(max = 50)
    @Column(name = "REPORT", length = 50)
    private String report;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;
    @Size(max = 4000)
    @Column(name = "SPECSECTION", length = 4000)
    private String specsection;
    @Size(max = 4000)
    @Column(name = "DATETEST_TMP", length = 4000)
    private String datetestTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP", length = 4000)
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP", length = 4000)
    private String createDateTmp;
    @Size(max = 50)
    @Column(name = "LAST_MOD", length = 50)
    private String lastMod;
    @Size(max = 50)
    @Column(name = "CREATE_DATE", length = 50)
    private String createDate;
    @Column(name = "DATETEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetest;
    @Size(max = 50)
    @Column(name = "REQUIREDSTRENGTH", length = 50)
    private String requiredstrength;
    @Column(name = "LIFTING")
    private BigInteger lifting;
    @Size(max = 50)
    @Column(name = "LAB_STAMP_NO", length = 50)
    private String labStampNo;
    @Size(max = 50)
    @Column(name = "MACHINCE_USED", length = 50)
    private String machinceUsed;
    @Size(max = 50)
    @Column(name = "WEIGHT", length = 50)
    private String weight;
    @Size(max = 50)
    @Column(name = "TESTAGE_HOURS", length = 50)
    private String testageHours;
    @Size(max = 1)
    @Column(name = "DISCARD", length = 1)
    private String discard;
    @Size(max = 50)
    @Column(name = "DIAMETER", length = 50)
    private String diameter;
    @Size(max = 50)
    @Column(name = "BREAK_LOCATION", length = 50)
    private String breakLocation;
    @Size(max = 50)
    @Column(name = "DIAMETER1", length = 50)
    private String diameter1;
    @Size(max = 50)
    @Column(name = "DIAMETER2", length = 50)
    private String diameter2;
    @Size(max = 50)
    @Column(name = "DIAMETER3", length = 50)
    private String diameter3;
    @Size(max = 50)
    @Column(name = "HEIGHT1", length = 50)
    private String height1;
    @Size(max = 50)
    @Column(name = "HEIGHT2", length = 50)
    private String height2;
    @Size(max = 50)
    @Column(name = "HEIGHT3", length = 50)
    private String height3;
    @Size(max = 50)
    @Column(name = "HEIGHT", length = 50)
    private String height;
    @Column(name = "DISCARD_COMPLETED")
    private Character discardCompleted;
    @Column(name = "DISCARD_REQUIRED")
    private Character discardRequired;
    @Size(max = 50)
    @Column(name = "WIDTH", length = 50)
    private String width;
    @Size(max = 50)
    @Column(name = "WIDTH1", length = 50)
    private String width1;
    @Size(max = 50)
    @Column(name = "WIDTH2", length = 50)
    private String width2;
    @Size(max = 50)
    @Column(name = "WIDTH3", length = 50)
    private String width3;
    @Size(max = 50)
    @Column(name = "LENGTH", length = 50)
    private String length;
    @Size(max = 50)
    @Column(name = "LENGTH1", length = 50)
    private String length1;
    @Size(max = 50)
    @Column(name = "LENGTH2", length = 50)
    private String length2;
    @Size(max = 50)
    @Column(name = "LENGTH3", length = 50)
    private String length3;

    public QaconcCompstrout() {
    }

    public QaconcCompstrout(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getSampleidno() {
        return sampleidno;
    }

    public void setSampleidno(String sampleidno) {
        this.sampleidno = sampleidno;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTestage() {
        return testage;
    }

    public void setTestage(String testage) {
        this.testage = testage;
    }

    public String getSamplesize() {
        return samplesize;
    }

    public void setSamplesize(String samplesize) {
        this.samplesize = samplesize;
    }

    public String getMaximumload() {
        return maximumload;
    }

    public void setMaximumload(String maximumload) {
        this.maximumload = maximumload;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompressStrength() {
        return compressStrength;
    }

    public void setCompressStrength(String compressStrength) {
        this.compressStrength = compressStrength;
    }

    public String getTypeoffracture() {
        return typeoffracture;
    }

    public void setTypeoffracture(String typeoffracture) {
        this.typeoffracture = typeoffracture;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSpecsection() {
        return specsection;
    }

    public void setSpecsection(String specsection) {
        this.specsection = specsection;
    }

    public String getDatetestTmp() {
        return datetestTmp;
    }

    public void setDatetestTmp(String datetestTmp) {
        this.datetestTmp = datetestTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getDatetest() {
        return datetest;
    }

    public void setDatetest(Date datetest) {
        this.datetest = datetest;
    }

    public String getRequiredstrength() {
        return requiredstrength;
    }

    public void setRequiredstrength(String requiredstrength) {
        this.requiredstrength = requiredstrength;
    }

    public BigInteger getLifting() {
        return lifting;
    }

    public void setLifting(BigInteger lifting) {
        this.lifting = lifting;
    }

    public String getLabStampNo() {
        return labStampNo;
    }

    public void setLabStampNo(String labStampNo) {
        this.labStampNo = labStampNo;
    }

    public String getMachinceUsed() {
        return machinceUsed;
    }

    public void setMachinceUsed(String machinceUsed) {
        this.machinceUsed = machinceUsed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTestageHours() {
        return testageHours;
    }

    public void setTestageHours(String testageHours) {
        this.testageHours = testageHours;
    }

    public String getDiscard() {
        return discard;
    }

    public void setDiscard(String discard) {
        this.discard = discard;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getBreakLocation() {
        return breakLocation;
    }

    public void setBreakLocation(String breakLocation) {
        this.breakLocation = breakLocation;
    }

    public String getDiameter1() {
        return diameter1;
    }

    public void setDiameter1(String diameter1) {
        this.diameter1 = diameter1;
    }

    public String getDiameter2() {
        return diameter2;
    }

    public void setDiameter2(String diameter2) {
        this.diameter2 = diameter2;
    }

    public String getDiameter3() {
        return diameter3;
    }

    public void setDiameter3(String diameter3) {
        this.diameter3 = diameter3;
    }

    public String getHeight1() {
        return height1;
    }

    public void setHeight1(String height1) {
        this.height1 = height1;
    }

    public String getHeight2() {
        return height2;
    }

    public void setHeight2(String height2) {
        this.height2 = height2;
    }

    public String getHeight3() {
        return height3;
    }

    public void setHeight3(String height3) {
        this.height3 = height3;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Character getDiscardCompleted() {
        return discardCompleted;
    }

    public void setDiscardCompleted(Character discardCompleted) {
        this.discardCompleted = discardCompleted;
    }

    public Character getDiscardRequired() {
        return discardRequired;
    }

    public void setDiscardRequired(Character discardRequired) {
        this.discardRequired = discardRequired;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWidth1() {
        return width1;
    }

    public void setWidth1(String width1) {
        this.width1 = width1;
    }

    public String getWidth2() {
        return width2;
    }

    public void setWidth2(String width2) {
        this.width2 = width2;
    }

    public String getWidth3() {
        return width3;
    }

    public void setWidth3(String width3) {
        this.width3 = width3;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLength1() {
        return length1;
    }

    public void setLength1(String length1) {
        this.length1 = length1;
    }

    public String getLength2() {
        return length2;
    }

    public void setLength2(String length2) {
        this.length2 = length2;
    }

    public String getLength3() {
        return length3;
    }

    public void setLength3(String length3) {
        this.length3 = length3;
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
        if (!(object instanceof QaconcCompstrout)) {
            return false;
        }
        QaconcCompstrout other = (QaconcCompstrout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaconcCompstrout[ id=" + id + " ]";
    }
    
}
