/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author mfuentes
 */
@Entity
@Immutable
@Table(name = "dot_conc_field_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConcFieldTest.findAll", query = "SELECT q FROM DotConcFieldTest q")})
public class DotConcFieldTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "TEST_CLOSED")
    private String testClosed;
    @Column(name = "PE_REVIEW")
    private String peReview;
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigInteger qaSampleId;
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Column(name = "MIX_DESIGN_ID")
    private BigInteger mixDesignId;
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "TESTNO")
    private String testno;
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Column(name = "TECH_ID")
    private String techId;
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Column(name = "BIDITEM_ID")
    private BigInteger biditemId;
    @Column(name = "SUBBIDITEM_ID")
    private BigInteger subbiditemId;
    @Column(name = "WBS_ID")
    private BigInteger wbsId;
    @Column(name = "WBS_NO")
    private String wbsNo;
    @Column(name = "WBS_DESCRIPT")
    private String wbsDescript;
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Column(name = "REQ_AIRCONT_SPEC_MIN")
    private BigDecimal reqAircontSpecMin;
    @Column(name = "REQ_AIRCONT_SPEC_MAX")
    private BigDecimal reqAircontSpecMax;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "MIX_TEMPERATURE")
    private String mixTemperature;
    @Column(name = "THERMOMETER_NO")
    private String thermometerNo;
    @Column(name = "TEMP_SPEC_MIN")
    private String tempSpecMin;
    @Column(name = "TEMP_SPEC_MAX")
    private String tempSpecMax;
    @Column(name = "TEMP_PASSFAIL")
    private String tempPassfail;
    @Column(name = "SLUMP")
    private String slump;
    @Column(name = "SLUMP_SPEC_MIN")
    private String slumpSpecMin;
    @Column(name = "SLUMP_SPEC_MAX")
    private String slumpSpecMax;
    @Column(name = "SLUMP_PASSFAIL")
    private String slumpPassfail;
    @Column(name = "AIRCONTENT")
    private String aircontent;
    @Column(name = "CORR_FACTOR")
    private String corrFactor;
    @Column(name = "CORR_AIRCONTENT")
    private String corrAircontent;
    @Column(name = "AIRCONTENT_SPEC_MIN")
    private String aircontentSpecMin;
    @Column(name = "AIRCONTENT_SPEC_MAX")
    private String aircontentSpecMax;
    @Column(name = "AIRCONTENT_PASSFAIL")
    private String aircontentPassfail;
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Column(name = "STATUS")
    private String status;

    public DotConcFieldTest() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getId() {
        return id;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public String getTestClosed() {
        return testClosed;
    }

    public String getPeReview() {
        return peReview;
    }

    public String getpName() {
        return pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public String getLabname() {
        return labname;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public BigInteger getQaSampleId() {
        return qaSampleId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public String getEquipList() {
        return equipList;
    }

    public BigInteger getMixDesignId() {
        return mixDesignId;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public String getTestNo() {
        return testNo;
    }

    public String getActive() {
        return active;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public String getFunction() {
        return function;
    }

    public String getTestno() {
        return testno;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public String getTechId() {
        return techId;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public BigInteger getBiditemId() {
        return biditemId;
    }

    public BigInteger getSubbiditemId() {
        return subbiditemId;
    }

    public BigInteger getWbsId() {
        return wbsId;
    }

    public String getWbsNo() {
        return wbsNo;
    }

    public String getWbsDescript() {
        return wbsDescript;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public BigDecimal getReqAircontSpecMin() {
        return reqAircontSpecMin;
    }

    public BigDecimal getReqAircontSpecMax() {
        return reqAircontSpecMax;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getMixTemperature() {
        return mixTemperature;
    }

    public String getThermometerNo() {
        return thermometerNo;
    }

    public String getTempSpecMin() {
        return tempSpecMin;
    }

    public String getTempSpecMax() {
        return tempSpecMax;
    }

    public String getTempPassfail() {
        return tempPassfail;
    }

    public String getSlump() {
        return slump;
    }

    public String getSlumpSpecMin() {
        return slumpSpecMin;
    }

    public String getSlumpSpecMax() {
        return slumpSpecMax;
    }

    public String getSlumpPassfail() {
        return slumpPassfail;
    }

    public String getAircontent() {
        return aircontent;
    }

    public String getCorrFactor() {
        return corrFactor;
    }

    public String getCorrAircontent() {
        return corrAircontent;
    }

    public String getAircontentSpecMin() {
        return aircontentSpecMin;
    }

    public String getAircontentSpecMax() {
        return aircontentSpecMax;
    }

    public String getAircontentPassfail() {
        return aircontentPassfail;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getTestResults() {
        return testResults;
    }

    public String getStatus() {
        return status;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testno) && testno.contains("../../")) {
            return testno.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testno;

    }

}
