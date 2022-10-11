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
    @NamedQuery(name = "QasoilDensityout.findByTestId", query = "SELECT q FROM QasoilDensityout q WHERE q.testId = :testId"),
    @NamedQuery(name = "QasoilDensityout.findByTestNo", query = "SELECT q FROM QasoilDensityout q WHERE q.testNo = :testNo"),
    @NamedQuery(name = "QasoilDensityout.findByLocation", query = "SELECT q FROM QasoilDensityout q WHERE q.location = :location"),
    @NamedQuery(name = "QasoilDensityout.findByElevdepth", query = "SELECT q FROM QasoilDensityout q WHERE q.elevdepth = :elevdepth"),
    @NamedQuery(name = "QasoilDensityout.findByMaxdrydensity", query = "SELECT q FROM QasoilDensityout q WHERE q.maxdrydensity = :maxdrydensity"),
    @NamedQuery(name = "QasoilDensityout.findByOptmoisture", query = "SELECT q FROM QasoilDensityout q WHERE q.optmoisture = :optmoisture"),
    @NamedQuery(name = "QasoilDensityout.findByWetdensity", query = "SELECT q FROM QasoilDensityout q WHERE q.wetdensity = :wetdensity"),
    @NamedQuery(name = "QasoilDensityout.findByDrydensity", query = "SELECT q FROM QasoilDensityout q WHERE q.drydensity = :drydensity"),
    @NamedQuery(name = "QasoilDensityout.findByMoisturecontent", query = "SELECT q FROM QasoilDensityout q WHERE q.moisturecontent = :moisturecontent"),
    @NamedQuery(name = "QasoilDensityout.findByCompaction", query = "SELECT q FROM QasoilDensityout q WHERE q.compaction = :compaction"),
    @NamedQuery(name = "QasoilDensityout.findByPassfail", query = "SELECT q FROM QasoilDensityout q WHERE q.passfail = :passfail"),
    @NamedQuery(name = "QasoilDensityout.findByRetest", query = "SELECT q FROM QasoilDensityout q WHERE q.retest = :retest"),
    @NamedQuery(name = "QasoilDensityout.findByRetestSampletestId", query = "SELECT q FROM QasoilDensityout q WHERE q.retestSampletestId = :retestSampletestId"),
    @NamedQuery(name = "QasoilDensityout.findByRetestTestId", query = "SELECT q FROM QasoilDensityout q WHERE q.retestTestId = :retestTestId"),
    @NamedQuery(name = "QasoilDensityout.findByReport", query = "SELECT q FROM QasoilDensityout q WHERE q.report = :report"),
    @NamedQuery(name = "QasoilDensityout.findByRemarks", query = "SELECT q FROM QasoilDensityout q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QasoilDensityout.findByActive", query = "SELECT q FROM QasoilDensityout q WHERE q.active = :active"),
    @NamedQuery(name = "QasoilDensityout.findByLastModBy", query = "SELECT q FROM QasoilDensityout q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QasoilDensityout.findByLastModIp", query = "SELECT q FROM QasoilDensityout q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QasoilDensityout.findByCreateBy", query = "SELECT q FROM QasoilDensityout q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QasoilDensityout.findByCreateByIp", query = "SELECT q FROM QasoilDensityout q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QasoilDensityout.findByVersion", query = "SELECT q FROM QasoilDensityout q WHERE q.version = :version"),
    @NamedQuery(name = "QasoilDensityout.findByWd1", query = "SELECT q FROM QasoilDensityout q WHERE q.wd1 = :wd1"),
    @NamedQuery(name = "QasoilDensityout.findByWd2", query = "SELECT q FROM QasoilDensityout q WHERE q.wd2 = :wd2"),
    @NamedQuery(name = "QasoilDensityout.findByWd3", query = "SELECT q FROM QasoilDensityout q WHERE q.wd3 = :wd3"),
    @NamedQuery(name = "QasoilDensityout.findByWd4", query = "SELECT q FROM QasoilDensityout q WHERE q.wd4 = :wd4"),
    @NamedQuery(name = "QasoilDensityout.findByDd1", query = "SELECT q FROM QasoilDensityout q WHERE q.dd1 = :dd1"),
    @NamedQuery(name = "QasoilDensityout.findByDd2", query = "SELECT q FROM QasoilDensityout q WHERE q.dd2 = :dd2"),
    @NamedQuery(name = "QasoilDensityout.findByDd3", query = "SELECT q FROM QasoilDensityout q WHERE q.dd3 = :dd3"),
    @NamedQuery(name = "QasoilDensityout.findByDd4", query = "SELECT q FROM QasoilDensityout q WHERE q.dd4 = :dd4"),
    @NamedQuery(name = "QasoilDensityout.findByFieldTestno", query = "SELECT q FROM QasoilDensityout q WHERE q.fieldTestno = :fieldTestno"),
    @NamedQuery(name = "QasoilDensityout.findByRefLine", query = "SELECT q FROM QasoilDensityout q WHERE q.refLine = :refLine"),
    @NamedQuery(name = "QasoilDensityout.findBySoilSource", query = "SELECT q FROM QasoilDensityout q WHERE q.soilSource = :soilSource"),
    @NamedQuery(name = "QasoilDensityout.findBySoilClass", query = "SELECT q FROM QasoilDensityout q WHERE q.soilClass = :soilClass"),
    @NamedQuery(name = "QasoilDensityout.findByPctMatl", query = "SELECT q FROM QasoilDensityout q WHERE q.pctMatl = :pctMatl"),
    @NamedQuery(name = "QasoilDensityout.findByField11", query = "SELECT q FROM QasoilDensityout q WHERE q.field11 = :field11"),
    @NamedQuery(name = "QasoilDensityout.findByOnePointNum", query = "SELECT q FROM QasoilDensityout q WHERE q.onePointNum = :onePointNum"),
    @NamedQuery(name = "QasoilDensityout.findByLiftThick", query = "SELECT q FROM QasoilDensityout q WHERE q.liftThick = :liftThick"),
    @NamedQuery(name = "QasoilDensityout.findByBegStat", query = "SELECT q FROM QasoilDensityout q WHERE q.begStat = :begStat"),
    @NamedQuery(name = "QasoilDensityout.findByEndStat", query = "SELECT q FROM QasoilDensityout q WHERE q.endStat = :endStat"),
    @NamedQuery(name = "QasoilDensityout.findByRandom1", query = "SELECT q FROM QasoilDensityout q WHERE q.random1 = :random1"),
    @NamedQuery(name = "QasoilDensityout.findByRandom2", query = "SELECT q FROM QasoilDensityout q WHERE q.random2 = :random2"),
    @NamedQuery(name = "QasoilDensityout.findByTestStation", query = "SELECT q FROM QasoilDensityout q WHERE q.testStation = :testStation"),
    @NamedQuery(name = "QasoilDensityout.findByTestOffset", query = "SELECT q FROM QasoilDensityout q WHERE q.testOffset = :testOffset"),
    @NamedQuery(name = "QasoilDensityout.findByOffset1", query = "SELECT q FROM QasoilDensityout q WHERE q.offset1 = :offset1"),
    @NamedQuery(name = "QasoilDensityout.findByOffset2", query = "SELECT q FROM QasoilDensityout q WHERE q.offset2 = :offset2"),
    @NamedQuery(name = "QasoilDensityout.findByOnePointTaken", query = "SELECT q FROM QasoilDensityout q WHERE q.onePointTaken = :onePointTaken"),
    @NamedQuery(name = "QasoilDensityout.findBySuperceded", query = "SELECT q FROM QasoilDensityout q WHERE q.superceded = :superceded"),
    @NamedQuery(name = "QasoilDensityout.findByRetestremarks", query = "SELECT q FROM QasoilDensityout q WHERE q.retestremarks = :retestremarks"),
    @NamedQuery(name = "QasoilDensityout.findByMoistureTol", query = "SELECT q FROM QasoilDensityout q WHERE q.moistureTol = :moistureTol"),
    @NamedQuery(name = "QasoilDensityout.findByTestMethod", query = "SELECT q FROM QasoilDensityout q WHERE q.testMethod = :testMethod"),
    @NamedQuery(name = "QasoilDensityout.findByProctorNo", query = "SELECT q FROM QasoilDensityout q WHERE q.proctorNo = :proctorNo"),
    @NamedQuery(name = "QasoilDensityout.findBySampleid", query = "SELECT q FROM QasoilDensityout q WHERE q.sampleid = :sampleid"),
    @NamedQuery(name = "QasoilDensityout.findByLastModTmp", query = "SELECT q FROM QasoilDensityout q WHERE q.lastModTmp = :lastModTmp"),
    @NamedQuery(name = "QasoilDensityout.findByTempTmp", query = "SELECT q FROM QasoilDensityout q WHERE q.tempTmp = :tempTmp"),
    @NamedQuery(name = "QasoilDensityout.findByCreateDateTmp", query = "SELECT q FROM QasoilDensityout q WHERE q.createDateTmp = :createDateTmp"),
    @NamedQuery(name = "QasoilDensityout.findByTemp", query = "SELECT q FROM QasoilDensityout q WHERE q.temp = :temp"),
    @NamedQuery(name = "QasoilDensityout.findByLastMod", query = "SELECT q FROM QasoilDensityout q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QasoilDensityout.findByCreateDate", query = "SELECT q FROM QasoilDensityout q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QasoilDensityout.findByMoistureratio", query = "SELECT q FROM QasoilDensityout q WHERE q.moistureratio = :moistureratio"),
    @NamedQuery(name = "QasoilDensityout.findByDensityratio", query = "SELECT q FROM QasoilDensityout q WHERE q.densityratio = :densityratio"),
    @NamedQuery(name = "QasoilDensityout.findByWetdensity2", query = "SELECT q FROM QasoilDensityout q WHERE q.wetdensity2 = :wetdensity2"),
    @NamedQuery(name = "QasoilDensityout.findByPoundswater", query = "SELECT q FROM QasoilDensityout q WHERE q.poundswater = :poundswater"),
    @NamedQuery(name = "QasoilDensityout.findByDrydensity2", query = "SELECT q FROM QasoilDensityout q WHERE q.drydensity2 = :drydensity2"),
    @NamedQuery(name = "QasoilDensityout.findByBulkspgrav", query = "SELECT q FROM QasoilDensityout q WHERE q.bulkspgrav = :bulkspgrav"),
    @NamedQuery(name = "QasoilDensityout.findByAbsorption", query = "SELECT q FROM QasoilDensityout q WHERE q.absorption = :absorption"),
    @NamedQuery(name = "QasoilDensityout.findByPctMatlMinus", query = "SELECT q FROM QasoilDensityout q WHERE q.pctMatlMinus = :pctMatlMinus"),
    @NamedQuery(name = "QasoilDensityout.findByCorrectedmaxdrydensity", query = "SELECT q FROM QasoilDensityout q WHERE q.correctedmaxdrydensity = :correctedmaxdrydensity"),
    @NamedQuery(name = "QasoilDensityout.findByCorrectedoptmoist", query = "SELECT q FROM QasoilDensityout q WHERE q.correctedoptmoist = :correctedoptmoist"),
    @NamedQuery(name = "QasoilDensityout.findByLatGps", query = "SELECT q FROM QasoilDensityout q WHERE q.latGps = :latGps"),
    @NamedQuery(name = "QasoilDensityout.findByLonGps", query = "SELECT q FROM QasoilDensityout q WHERE q.lonGps = :lonGps"),
    @NamedQuery(name = "QasoilDensityout.findByAltGps", query = "SELECT q FROM QasoilDensityout q WHERE q.altGps = :altGps"),
    @NamedQuery(name = "QasoilDensityout.findByDensityCount", query = "SELECT q FROM QasoilDensityout q WHERE q.densityCount = :densityCount"),
    @NamedQuery(name = "QasoilDensityout.findByMoistCount", query = "SELECT q FROM QasoilDensityout q WHERE q.moistCount = :moistCount"),
    @NamedQuery(name = "QasoilDensityout.findByRecordDensity", query = "SELECT q FROM QasoilDensityout q WHERE q.recordDensity = :recordDensity"),
    @NamedQuery(name = "QasoilDensityout.findBySampleType", query = "SELECT q FROM QasoilDensityout q WHERE q.sampleType = :sampleType"),
    @NamedQuery(name = "QasoilDensityout.findByEngDecision", query = "SELECT q FROM QasoilDensityout q WHERE q.engDecision = :engDecision"),
    @NamedQuery(name = "QasoilDensityout.findBySplitSampleNumber", query = "SELECT q FROM QasoilDensityout q WHERE q.splitSampleNumber = :splitSampleNumber"),
    @NamedQuery(name = "QasoilDensityout.findByInactiveTestId", query = "SELECT q FROM QasoilDensityout q WHERE q.inactiveTestId = :inactiveTestId"),
    @NamedQuery(name = "QasoilDensityout.findByWetdensityGauge", query = "SELECT q FROM QasoilDensityout q WHERE q.wetdensityGauge = :wetdensityGauge"),
    @NamedQuery(name = "QasoilDensityout.findByMoisture", query = "SELECT q FROM QasoilDensityout q WHERE q.moisture = :moisture"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWetMass", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWetMass = :dryBackWetMass"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackDryMass", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackDryMass = :dryBackDryMass"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackMoisturecontent", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackMoisturecontent = :dryBackMoisturecontent"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWtMoldMat", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWtMoldMat = :dryBackWtMoldMat"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWtMold", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWtMold = :dryBackWtMold"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWtMat", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWtMat = :dryBackWtMat"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackCorrFactor", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackCorrFactor = :dryBackCorrFactor"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWetdensity", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWetdensity = :dryBackWetdensity"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackDrydensity", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackDrydensity = :dryBackDrydensity"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackWetMass2", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackWetMass2 = :dryBackWetMass2"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackDryMass2", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackDryMass2 = :dryBackDryMass2"),
    @NamedQuery(name = "QasoilDensityout.findByDryBackMoisturecontent2", query = "SELECT q FROM QasoilDensityout q WHERE q.dryBackMoisturecontent2 = :dryBackMoisturecontent2"),
    @NamedQuery(name = "QasoilDensityout.findByWtMoldMat", query = "SELECT q FROM QasoilDensityout q WHERE q.wtMoldMat = :wtMoldMat"),
    @NamedQuery(name = "QasoilDensityout.findByWtMold", query = "SELECT q FROM QasoilDensityout q WHERE q.wtMold = :wtMold"),
    @NamedQuery(name = "QasoilDensityout.findByWtMat", query = "SELECT q FROM QasoilDensityout q WHERE q.wtMat = :wtMat"),
    @NamedQuery(name = "QasoilDensityout.findByCorrFactor", query = "SELECT q FROM QasoilDensityout q WHERE q.corrFactor = :corrFactor"),
    @NamedQuery(name = "QasoilDensityout.findByManualMaxdrydensity", query = "SELECT q FROM QasoilDensityout q WHERE q.manualMaxdrydensity = :manualMaxdrydensity"),
    @NamedQuery(name = "QasoilDensityout.findByManualOptmoisture", query = "SELECT q FROM QasoilDensityout q WHERE q.manualOptmoisture = :manualOptmoisture"),
    @NamedQuery(name = "QasoilDensityout.findByWetdensityGaugeTotal", query = "SELECT q FROM QasoilDensityout q WHERE q.wetdensityGaugeTotal = :wetdensityGaugeTotal"),
    @NamedQuery(name = "QasoilDensityout.findByMoistureGaugeTotal", query = "SELECT q FROM QasoilDensityout q WHERE q.moistureGaugeTotal = :moistureGaugeTotal"),
    @NamedQuery(name = "QasoilDensityout.findByDepthCheckReq", query = "SELECT q FROM QasoilDensityout q WHERE q.depthCheckReq = :depthCheckReq"),
    @NamedQuery(name = "QasoilDensityout.findByDepthCheckActual", query = "SELECT q FROM QasoilDensityout q WHERE q.depthCheckActual = :depthCheckActual"),
    @NamedQuery(name = "QasoilDensityout.findByMaxdrydensover", query = "SELECT q FROM QasoilDensityout q WHERE q.maxdrydensover = :maxdrydensover"),
    @NamedQuery(name = "QasoilDensityout.findByCormoistcontentover", query = "SELECT q FROM QasoilDensityout q WHERE q.cormoistcontentover = :cormoistcontentover")
*/

/**
 *
 * @author droldan
 */
@Entity
@QmsOldVersion
@Table(name = "QASOIL_DENSITYOUT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QasoilDensityout.findAll", query = "SELECT q FROM QasoilDensityout q"),
    @NamedQuery(name = "QasoilDensityout.findById", query = "SELECT q FROM QasoilDensityout q WHERE q.id = :id"),
    @NamedQuery(name = "QasoilDensityout.findByTestIdAndNo", query = "SELECT q FROM QasoilDensityout q WHERE q.testId = :testId AND q.testNo = :testNo")})
public class QasoilDensityout implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QASOIL_DENSITYOUT_ID_SEQ", sequenceName = "QASOIL_DENSITYOUT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QASOIL_DENSITYOUT_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 50)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 255)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 100)
    @Column(name = "ELEVDEPTH")
    private String elevdepth;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSITY")
    private String maxdrydensity;
    @Size(max = 50)
    @Column(name = "OPTMOISTURE")
    private String optmoisture;
    @Size(max = 50)
    @Column(name = "WETDENSITY")
    private String wetdensity;
    @Size(max = 50)
    @Column(name = "DRYDENSITY")
    private String drydensity;
    @Size(max = 50)
    @Column(name = "MOISTURECONTENT")
    private String moisturecontent;
    @Size(max = 50)
    @Column(name = "COMPACTION")
    private String compaction;
    @Size(max = 10)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 10)
    @Column(name = "RETEST")
    private String retest;
    @Size(max = 10)
    @Column(name = "RETEST_SAMPLETEST_ID")
    private String retestSampletestId;
    @Size(max = 20)
    @Column(name = "RETEST_TEST_ID")
    private String retestTestId;
    @Size(max = 50)
    @Column(name = "REPORT")
    private String report;
    @Size(max = 255)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 4000)
    @Column(name = "WD_1")
    private String wd1;
    @Size(max = 4000)
    @Column(name = "WD_2")
    private String wd2;
    @Size(max = 4000)
    @Column(name = "WD_3")
    private String wd3;
    @Size(max = 4000)
    @Column(name = "WD_4")
    private String wd4;
    @Size(max = 4000)
    @Column(name = "DD_1")
    private String dd1;
    @Size(max = 4000)
    @Column(name = "DD_2")
    private String dd2;
    @Size(max = 4000)
    @Column(name = "DD_3")
    private String dd3;
    @Size(max = 4000)
    @Column(name = "DD_4")
    private String dd4;
    @Size(max = 4000)
    @Column(name = "FIELD_TESTNO")
    private String fieldTestno;
    @Size(max = 4000)
    @Column(name = "REF_LINE")
    private String refLine;
    @Size(max = 4000)
    @Column(name = "SOIL_SOURCE")
    private String soilSource;
    @Size(max = 4000)
    @Column(name = "SOIL_CLASS")
    private String soilClass;
    @Size(max = 4000)
    @Column(name = "PCT_MATL")
    private String pctMatl;
    @Column(name = "FIELD11")
    private Character field11;
    @Size(max = 4000)
    @Column(name = "ONE_POINT_NUM")
    private String onePointNum;
    @Size(max = 4000)
    @Column(name = "LIFT_THICK")
    private String liftThick;
    @Size(max = 4000)
    @Column(name = "BEG_STAT")
    private String begStat;
    @Size(max = 4000)
    @Column(name = "END_STAT")
    private String endStat;
    @Size(max = 4000)
    @Column(name = "RANDOM_1")
    private String random1;
    @Size(max = 4000)
    @Column(name = "RANDOM_2")
    private String random2;
    @Size(max = 4000)
    @Column(name = "TEST_STATION")
    private String testStation;
    @Size(max = 4000)
    @Column(name = "TEST_OFFSET")
    private String testOffset;
    @Size(max = 4000)
    @Column(name = "OFFSET_1")
    private String offset1;
    @Size(max = 4000)
    @Column(name = "OFFSET_2")
    private String offset2;
    @Size(max = 10)
    @Column(name = "ONE_POINT_TAKEN")
    private String onePointTaken;
    @Column(name = "SUPERCEDED")
    private Character superceded;
    @Size(max = 4000)
    @Column(name = "RETESTREMARKS")
    private String retestremarks;
    @Size(max = 50)
    @Column(name = "MOISTURE_TOL")
    private String moistureTol;
    @Size(max = 255)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 50)
    @Column(name = "PROCTOR_NO")
    private String proctorNo;
    @Size(max = 4000)
    @Column(name = "SAMPLEID")
    private String sampleid;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 50)
    @Column(name = "MOISTURERATIO")
    private String moistureratio;
    @Size(max = 50)
    @Column(name = "DENSITYRATIO")
    private String densityratio;
    @Size(max = 50)
    @Column(name = "WETDENSITY2")
    private String wetdensity2;
    @Size(max = 50)
    @Column(name = "POUNDSWATER")
    private String poundswater;
    @Size(max = 50)
    @Column(name = "DRYDENSITY2")
    private String drydensity2;
    @Size(max = 50)
    @Column(name = "BULKSPGRAV")
    private String bulkspgrav;
    @Size(max = 50)
    @Column(name = "ABSORPTION")
    private String absorption;
    @Size(max = 50)
    @Column(name = "PCT_MATL_MINUS")
    private String pctMatlMinus;
    @Size(max = 50)
    @Column(name = "CORRECTEDMAXDRYDENSITY")
    private String correctedmaxdrydensity;
    @Size(max = 50)
    @Column(name = "CORRECTEDOPTMOIST")
    private String correctedoptmoist;
    @Size(max = 100)
    @Column(name = "LAT_GPS")
    private String latGps;
    @Size(max = 100)
    @Column(name = "LON_GPS")
    private String lonGps;
    @Size(max = 100)
    @Column(name = "ALT_GPS")
    private String altGps;
    @Size(max = 50)
    @Column(name = "DENSITY_COUNT")
    private String densityCount;
    @Size(max = 50)
    @Column(name = "MOIST_COUNT")
    private String moistCount;
    @Size(max = 50)
    @Column(name = "RECORD_DENSITY")
    private String recordDensity;
    @Size(max = 255)
    @Column(name = "SAMPLE_TYPE")
    private String sampleType;
    @Size(max = 10)
    @Column(name = "ENG_DECISION")
    private String engDecision;
    @Size(max = 50)
    @Column(name = "SPLIT_SAMPLE_NUMBER")
    private String splitSampleNumber;
    @Column(name = "INACTIVE_TEST_ID")
    private BigInteger inactiveTestId;
    @Size(max = 50)
    @Column(name = "WETDENSITY_GAUGE")
    private String wetdensityGauge;
    @Size(max = 50)
    @Column(name = "MOISTURE")
    private String moisture;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WET_MASS")
    private String dryBackWetMass;
    @Size(max = 50)
    @Column(name = "DRY_BACK_DRY_MASS")
    private String dryBackDryMass;
    @Size(max = 50)
    @Column(name = "DRY_BACK_MOISTURECONTENT")
    private String dryBackMoisturecontent;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WT_MOLD_MAT")
    private String dryBackWtMoldMat;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WT_MOLD")
    private String dryBackWtMold;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WT_MAT")
    private String dryBackWtMat;
    @Size(max = 50)
    @Column(name = "DRY_BACK_CORR_FACTOR")
    private String dryBackCorrFactor;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WETDENSITY")
    private String dryBackWetdensity;
    @Size(max = 50)
    @Column(name = "DRY_BACK_DRYDENSITY")
    private String dryBackDrydensity;
    @Size(max = 50)
    @Column(name = "DRY_BACK_WET_MASS2")
    private String dryBackWetMass2;
    @Size(max = 50)
    @Column(name = "DRY_BACK_DRY_MASS2")
    private String dryBackDryMass2;
    @Size(max = 50)
    @Column(name = "DRY_BACK_MOISTURECONTENT2")
    private String dryBackMoisturecontent2;
    @Size(max = 50)
    @Column(name = "WT_MOLD_MAT")
    private String wtMoldMat;
    @Size(max = 50)
    @Column(name = "WT_MOLD")
    private String wtMold;
    @Size(max = 50)
    @Column(name = "WT_MAT")
    private String wtMat;
    @Size(max = 50)
    @Column(name = "CORR_FACTOR")
    private String corrFactor;
    @Size(max = 50)
    @Column(name = "MANUAL_MAXDRYDENSITY")
    private String manualMaxdrydensity;
    @Size(max = 50)
    @Column(name = "MANUAL_OPTMOISTURE")
    private String manualOptmoisture;
    @Size(max = 50)
    @Column(name = "WETDENSITY_GAUGE_TOTAL")
    private String wetdensityGaugeTotal;
    @Size(max = 50)
    @Column(name = "MOISTURE_GAUGE_TOTAL")
    private String moistureGaugeTotal;
    @Size(max = 50)
    @Column(name = "DEPTH_CHECK_REQ")
    private String depthCheckReq;
    @Size(max = 50)
    @Column(name = "DEPTH_CHECK_ACTUAL")
    private String depthCheckActual;
    @Size(max = 50)
    @Column(name = "MAXDRYDENSOVER")
    private String maxdrydensover;
    @Size(max = 50)
    @Column(name = "CORMOISTCONTENTOVER")
    private String cormoistcontentover;

    public QasoilDensityout() {
    }

    public QasoilDensityout(BigDecimal id) {
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

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getElevdepth() {
        return elevdepth;
    }

    public void setElevdepth(String elevdepth) {
        this.elevdepth = elevdepth;
    }

    public String getMaxdrydensity() {
        return maxdrydensity;
    }

    public void setMaxdrydensity(String maxdrydensity) {
        this.maxdrydensity = maxdrydensity;
    }

    public String getOptmoisture() {
        return optmoisture;
    }

    public void setOptmoisture(String optmoisture) {
        this.optmoisture = optmoisture;
    }

    public String getWetdensity() {
        return wetdensity;
    }

    public void setWetdensity(String wetdensity) {
        this.wetdensity = wetdensity;
    }

    public String getDrydensity() {
        return drydensity;
    }

    public void setDrydensity(String drydensity) {
        this.drydensity = drydensity;
    }

    public String getMoisturecontent() {
        return moisturecontent;
    }

    public void setMoisturecontent(String moisturecontent) {
        this.moisturecontent = moisturecontent;
    }

    public String getCompaction() {
        return compaction;
    }

    public void setCompaction(String compaction) {
        this.compaction = compaction;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getRetest() {
        return retest;
    }

    public void setRetest(String retest) {
        this.retest = retest;
    }

    public String getRetestSampletestId() {
        return retestSampletestId;
    }

    public void setRetestSampletestId(String retestSampletestId) {
        this.retestSampletestId = retestSampletestId;
    }

    public String getRetestTestId() {
        return retestTestId;
    }

    public void setRetestTestId(String retestTestId) {
        this.retestTestId = retestTestId;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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

    public String getWd1() {
        return wd1;
    }

    public void setWd1(String wd1) {
        this.wd1 = wd1;
    }

    public String getWd2() {
        return wd2;
    }

    public void setWd2(String wd2) {
        this.wd2 = wd2;
    }

    public String getWd3() {
        return wd3;
    }

    public void setWd3(String wd3) {
        this.wd3 = wd3;
    }

    public String getWd4() {
        return wd4;
    }

    public void setWd4(String wd4) {
        this.wd4 = wd4;
    }

    public String getDd1() {
        return dd1;
    }

    public void setDd1(String dd1) {
        this.dd1 = dd1;
    }

    public String getDd2() {
        return dd2;
    }

    public void setDd2(String dd2) {
        this.dd2 = dd2;
    }

    public String getDd3() {
        return dd3;
    }

    public void setDd3(String dd3) {
        this.dd3 = dd3;
    }

    public String getDd4() {
        return dd4;
    }

    public void setDd4(String dd4) {
        this.dd4 = dd4;
    }

    public String getFieldTestno() {
        return fieldTestno;
    }

    public void setFieldTestno(String fieldTestno) {
        this.fieldTestno = fieldTestno;
    }

    public String getRefLine() {
        return refLine;
    }

    public void setRefLine(String refLine) {
        this.refLine = refLine;
    }

    public String getSoilSource() {
        return soilSource;
    }

    public void setSoilSource(String soilSource) {
        this.soilSource = soilSource;
    }

    public String getSoilClass() {
        return soilClass;
    }

    public void setSoilClass(String soilClass) {
        this.soilClass = soilClass;
    }

    public String getPctMatl() {
        return pctMatl;
    }

    public void setPctMatl(String pctMatl) {
        this.pctMatl = pctMatl;
    }

    public Character getField11() {
        return field11;
    }

    public void setField11(Character field11) {
        this.field11 = field11;
    }

    public String getOnePointNum() {
        return onePointNum;
    }

    public void setOnePointNum(String onePointNum) {
        this.onePointNum = onePointNum;
    }

    public String getLiftThick() {
        return liftThick;
    }

    public void setLiftThick(String liftThick) {
        this.liftThick = liftThick;
    }

    public String getBegStat() {
        return begStat;
    }

    public void setBegStat(String begStat) {
        this.begStat = begStat;
    }

    public String getEndStat() {
        return endStat;
    }

    public void setEndStat(String endStat) {
        this.endStat = endStat;
    }

    public String getRandom1() {
        return random1;
    }

    public void setRandom1(String random1) {
        this.random1 = random1;
    }

    public String getRandom2() {
        return random2;
    }

    public void setRandom2(String random2) {
        this.random2 = random2;
    }

    public String getTestStation() {
        return testStation;
    }

    public void setTestStation(String testStation) {
        this.testStation = testStation;
    }

    public String getTestOffset() {
        return testOffset;
    }

    public void setTestOffset(String testOffset) {
        this.testOffset = testOffset;
    }

    public String getOffset1() {
        return offset1;
    }

    public void setOffset1(String offset1) {
        this.offset1 = offset1;
    }

    public String getOffset2() {
        return offset2;
    }

    public void setOffset2(String offset2) {
        this.offset2 = offset2;
    }

    public String getOnePointTaken() {
        return onePointTaken;
    }

    public void setOnePointTaken(String onePointTaken) {
        this.onePointTaken = onePointTaken;
    }

    public Character getSuperceded() {
        return superceded;
    }

    public void setSuperceded(Character superceded) {
        this.superceded = superceded;
    }

    public String getRetestremarks() {
        return retestremarks;
    }

    public void setRetestremarks(String retestremarks) {
        this.retestremarks = retestremarks;
    }

    public String getMoistureTol() {
        return moistureTol;
    }

    public void setMoistureTol(String moistureTol) {
        this.moistureTol = moistureTol;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getProctorNo() {
        return proctorNo;
    }

    public void setProctorNo(String proctorNo) {
        this.proctorNo = proctorNo;
    }

    public String getSampleid() {
        return sampleid;
    }

    public void setSampleid(String sampleid) {
        this.sampleid = sampleid;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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

    public String getMoistureratio() {
        return moistureratio;
    }

    public void setMoistureratio(String moistureratio) {
        this.moistureratio = moistureratio;
    }

    public String getDensityratio() {
        return densityratio;
    }

    public void setDensityratio(String densityratio) {
        this.densityratio = densityratio;
    }

    public String getWetdensity2() {
        return wetdensity2;
    }

    public void setWetdensity2(String wetdensity2) {
        this.wetdensity2 = wetdensity2;
    }

    public String getPoundswater() {
        return poundswater;
    }

    public void setPoundswater(String poundswater) {
        this.poundswater = poundswater;
    }

    public String getDrydensity2() {
        return drydensity2;
    }

    public void setDrydensity2(String drydensity2) {
        this.drydensity2 = drydensity2;
    }

    public String getBulkspgrav() {
        return bulkspgrav;
    }

    public void setBulkspgrav(String bulkspgrav) {
        this.bulkspgrav = bulkspgrav;
    }

    public String getAbsorption() {
        return absorption;
    }

    public void setAbsorption(String absorption) {
        this.absorption = absorption;
    }

    public String getPctMatlMinus() {
        return pctMatlMinus;
    }

    public void setPctMatlMinus(String pctMatlMinus) {
        this.pctMatlMinus = pctMatlMinus;
    }

    public String getCorrectedmaxdrydensity() {
        return correctedmaxdrydensity;
    }

    public void setCorrectedmaxdrydensity(String correctedmaxdrydensity) {
        this.correctedmaxdrydensity = correctedmaxdrydensity;
    }

    public String getCorrectedoptmoist() {
        return correctedoptmoist;
    }

    public void setCorrectedoptmoist(String correctedoptmoist) {
        this.correctedoptmoist = correctedoptmoist;
    }

    public String getLatGps() {
        return latGps;
    }

    public void setLatGps(String latGps) {
        this.latGps = latGps;
    }

    public String getLonGps() {
        return lonGps;
    }

    public void setLonGps(String lonGps) {
        this.lonGps = lonGps;
    }

    public String getAltGps() {
        return altGps;
    }

    public void setAltGps(String altGps) {
        this.altGps = altGps;
    }

    public String getDensityCount() {
        return densityCount;
    }

    public void setDensityCount(String densityCount) {
        this.densityCount = densityCount;
    }

    public String getMoistCount() {
        return moistCount;
    }

    public void setMoistCount(String moistCount) {
        this.moistCount = moistCount;
    }

    public String getRecordDensity() {
        return recordDensity;
    }

    public void setRecordDensity(String recordDensity) {
        this.recordDensity = recordDensity;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getEngDecision() {
        return engDecision;
    }

    public void setEngDecision(String engDecision) {
        this.engDecision = engDecision;
    }

    public String getSplitSampleNumber() {
        return splitSampleNumber;
    }

    public void setSplitSampleNumber(String splitSampleNumber) {
        this.splitSampleNumber = splitSampleNumber;
    }

    public BigInteger getInactiveTestId() {
        return inactiveTestId;
    }

    public void setInactiveTestId(BigInteger inactiveTestId) {
        this.inactiveTestId = inactiveTestId;
    }

    public String getWetdensityGauge() {
        return wetdensityGauge;
    }

    public void setWetdensityGauge(String wetdensityGauge) {
        this.wetdensityGauge = wetdensityGauge;
    }

    public String getMoisture() {
        return moisture;
    }

    public void setMoisture(String moisture) {
        this.moisture = moisture;
    }

    public String getDryBackWetMass() {
        return dryBackWetMass;
    }

    public void setDryBackWetMass(String dryBackWetMass) {
        this.dryBackWetMass = dryBackWetMass;
    }

    public String getDryBackDryMass() {
        return dryBackDryMass;
    }

    public void setDryBackDryMass(String dryBackDryMass) {
        this.dryBackDryMass = dryBackDryMass;
    }

    public String getDryBackMoisturecontent() {
        return dryBackMoisturecontent;
    }

    public void setDryBackMoisturecontent(String dryBackMoisturecontent) {
        this.dryBackMoisturecontent = dryBackMoisturecontent;
    }

    public String getDryBackWtMoldMat() {
        return dryBackWtMoldMat;
    }

    public void setDryBackWtMoldMat(String dryBackWtMoldMat) {
        this.dryBackWtMoldMat = dryBackWtMoldMat;
    }

    public String getDryBackWtMold() {
        return dryBackWtMold;
    }

    public void setDryBackWtMold(String dryBackWtMold) {
        this.dryBackWtMold = dryBackWtMold;
    }

    public String getDryBackWtMat() {
        return dryBackWtMat;
    }

    public void setDryBackWtMat(String dryBackWtMat) {
        this.dryBackWtMat = dryBackWtMat;
    }

    public String getDryBackCorrFactor() {
        return dryBackCorrFactor;
    }

    public void setDryBackCorrFactor(String dryBackCorrFactor) {
        this.dryBackCorrFactor = dryBackCorrFactor;
    }

    public String getDryBackWetdensity() {
        return dryBackWetdensity;
    }

    public void setDryBackWetdensity(String dryBackWetdensity) {
        this.dryBackWetdensity = dryBackWetdensity;
    }

    public String getDryBackDrydensity() {
        return dryBackDrydensity;
    }

    public void setDryBackDrydensity(String dryBackDrydensity) {
        this.dryBackDrydensity = dryBackDrydensity;
    }

    public String getDryBackWetMass2() {
        return dryBackWetMass2;
    }

    public void setDryBackWetMass2(String dryBackWetMass2) {
        this.dryBackWetMass2 = dryBackWetMass2;
    }

    public String getDryBackDryMass2() {
        return dryBackDryMass2;
    }

    public void setDryBackDryMass2(String dryBackDryMass2) {
        this.dryBackDryMass2 = dryBackDryMass2;
    }

    public String getDryBackMoisturecontent2() {
        return dryBackMoisturecontent2;
    }

    public void setDryBackMoisturecontent2(String dryBackMoisturecontent2) {
        this.dryBackMoisturecontent2 = dryBackMoisturecontent2;
    }

    public String getWtMoldMat() {
        return wtMoldMat;
    }

    public void setWtMoldMat(String wtMoldMat) {
        this.wtMoldMat = wtMoldMat;
    }

    public String getWtMold() {
        return wtMold;
    }

    public void setWtMold(String wtMold) {
        this.wtMold = wtMold;
    }

    public String getWtMat() {
        return wtMat;
    }

    public void setWtMat(String wtMat) {
        this.wtMat = wtMat;
    }

    public String getCorrFactor() {
        return corrFactor;
    }

    public void setCorrFactor(String corrFactor) {
        this.corrFactor = corrFactor;
    }

    public String getManualMaxdrydensity() {
        return manualMaxdrydensity;
    }

    public void setManualMaxdrydensity(String manualMaxdrydensity) {
        this.manualMaxdrydensity = manualMaxdrydensity;
    }

    public String getManualOptmoisture() {
        return manualOptmoisture;
    }

    public void setManualOptmoisture(String manualOptmoisture) {
        this.manualOptmoisture = manualOptmoisture;
    }

    public String getWetdensityGaugeTotal() {
        return wetdensityGaugeTotal;
    }

    public void setWetdensityGaugeTotal(String wetdensityGaugeTotal) {
        this.wetdensityGaugeTotal = wetdensityGaugeTotal;
    }

    public String getMoistureGaugeTotal() {
        return moistureGaugeTotal;
    }

    public void setMoistureGaugeTotal(String moistureGaugeTotal) {
        this.moistureGaugeTotal = moistureGaugeTotal;
    }

    public String getDepthCheckReq() {
        return depthCheckReq;
    }

    public void setDepthCheckReq(String depthCheckReq) {
        this.depthCheckReq = depthCheckReq;
    }

    public String getDepthCheckActual() {
        return depthCheckActual;
    }

    public void setDepthCheckActual(String depthCheckActual) {
        this.depthCheckActual = depthCheckActual;
    }

    public String getMaxdrydensover() {
        return maxdrydensover;
    }

    public void setMaxdrydensover(String maxdrydensover) {
        this.maxdrydensover = maxdrydensover;
    }

    public String getCormoistcontentover() {
        return cormoistcontentover;
    }

    public void setCormoistcontentover(String cormoistcontentover) {
        this.cormoistcontentover = cormoistcontentover;
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
        if (!(object instanceof QasoilDensityout)) {
            return false;
        }
        QasoilDensityout other = (QasoilDensityout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QasoilDensityout[ id=" + id + " ]";
    }
    
}
