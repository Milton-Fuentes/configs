/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "CmFormData.findByInt41", query = "SELECT c FROM CmFormData c WHERE c.int41 = :int41"),
    @NamedQuery(name = "CmFormData.findByInt42", query = "SELECT c FROM CmFormData c WHERE c.int42 = :int42"),
    @NamedQuery(name = "CmFormData.findByInt43", query = "SELECT c FROM CmFormData c WHERE c.int43 = :int43"),
    @NamedQuery(name = "CmFormData.findByInt44", query = "SELECT c FROM CmFormData c WHERE c.int44 = :int44"),
    @NamedQuery(name = "CmFormData.findByInt45", query = "SELECT c FROM CmFormData c WHERE c.int45 = :int45"),
    @NamedQuery(name = "CmFormData.findByInt46", query = "SELECT c FROM CmFormData c WHERE c.int46 = :int46"),
    @NamedQuery(name = "CmFormData.findByInt47", query = "SELECT c FROM CmFormData c WHERE c.int47 = :int47"),
    @NamedQuery(name = "CmFormData.findByInt48", query = "SELECT c FROM CmFormData c WHERE c.int48 = :int48"),
    @NamedQuery(name = "CmFormData.findByFloat41", query = "SELECT c FROM CmFormData c WHERE c.float41 = :float41"),
    @NamedQuery(name = "CmFormData.findByFloat42", query = "SELECT c FROM CmFormData c WHERE c.float42 = :float42"),
    @NamedQuery(name = "CmFormData.findByFloat43", query = "SELECT c FROM CmFormData c WHERE c.float43 = :float43"),
    @NamedQuery(name = "CmFormData.findByFloat44", query = "SELECT c FROM CmFormData c WHERE c.float44 = :float44"),
    @NamedQuery(name = "CmFormData.findByFloat45", query = "SELECT c FROM CmFormData c WHERE c.float45 = :float45"),
    @NamedQuery(name = "CmFormData.findByFloat46", query = "SELECT c FROM CmFormData c WHERE c.float46 = :float46"),
    @NamedQuery(name = "CmFormData.findByFloat47", query = "SELECT c FROM CmFormData c WHERE c.float47 = :float47"),
    @NamedQuery(name = "CmFormData.findByFloat48", query = "SELECT c FROM CmFormData c WHERE c.float48 = :float48"),
    @NamedQuery(name = "CmFormData.findByVarchar1", query = "SELECT c FROM CmFormData c WHERE c.varchar1 = :varchar1"),
    @NamedQuery(name = "CmFormData.findByVarchar2", query = "SELECT c FROM CmFormData c WHERE c.varchar2 = :varchar2"),
    @NamedQuery(name = "CmFormData.findByVarchar3", query = "SELECT c FROM CmFormData c WHERE c.varchar3 = :varchar3"),
    @NamedQuery(name = "CmFormData.findByVarchar4", query = "SELECT c FROM CmFormData c WHERE c.varchar4 = :varchar4"),
    @NamedQuery(name = "CmFormData.findByVarchar5", query = "SELECT c FROM CmFormData c WHERE c.varchar5 = :varchar5"),
    @NamedQuery(name = "CmFormData.findByVarchar6", query = "SELECT c FROM CmFormData c WHERE c.varchar6 = :varchar6"),
    @NamedQuery(name = "CmFormData.findByVarchar7", query = "SELECT c FROM CmFormData c WHERE c.varchar7 = :varchar7"),
    @NamedQuery(name = "CmFormData.findByVarchar8", query = "SELECT c FROM CmFormData c WHERE c.varchar8 = :varchar8"),
    @NamedQuery(name = "CmFormData.findByVarchar9", query = "SELECT c FROM CmFormData c WHERE c.varchar9 = :varchar9"),
    @NamedQuery(name = "CmFormData.findByVarchar10", query = "SELECT c FROM CmFormData c WHERE c.varchar10 = :varchar10"),
    @NamedQuery(name = "CmFormData.findByVarchar11", query = "SELECT c FROM CmFormData c WHERE c.varchar11 = :varchar11"),
    @NamedQuery(name = "CmFormData.findByVarchar12", query = "SELECT c FROM CmFormData c WHERE c.varchar12 = :varchar12"),
    @NamedQuery(name = "CmFormData.findByVarchar13", query = "SELECT c FROM CmFormData c WHERE c.varchar13 = :varchar13"),
    @NamedQuery(name = "CmFormData.findByVarchar14", query = "SELECT c FROM CmFormData c WHERE c.varchar14 = :varchar14"),
    @NamedQuery(name = "CmFormData.findByVarchar15", query = "SELECT c FROM CmFormData c WHERE c.varchar15 = :varchar15"),
    @NamedQuery(name = "CmFormData.findByVarchar16", query = "SELECT c FROM CmFormData c WHERE c.varchar16 = :varchar16"),
    @NamedQuery(name = "CmFormData.findByVarchar17", query = "SELECT c FROM CmFormData c WHERE c.varchar17 = :varchar17"),
    @NamedQuery(name = "CmFormData.findByVarchar18", query = "SELECT c FROM CmFormData c WHERE c.varchar18 = :varchar18"),
    @NamedQuery(name = "CmFormData.findByVarchar19", query = "SELECT c FROM CmFormData c WHERE c.varchar19 = :varchar19"),
    @NamedQuery(name = "CmFormData.findByVarchar20", query = "SELECT c FROM CmFormData c WHERE c.varchar20 = :varchar20"),
    @NamedQuery(name = "CmFormData.findByText1", query = "SELECT c FROM CmFormData c WHERE c.text1 = :text1"),
    @NamedQuery(name = "CmFormData.findByText2", query = "SELECT c FROM CmFormData c WHERE c.text2 = :text2"),
    @NamedQuery(name = "CmFormData.findByText3", query = "SELECT c FROM CmFormData c WHERE c.text3 = :text3"),
    @NamedQuery(name = "CmFormData.findByText4", query = "SELECT c FROM CmFormData c WHERE c.text4 = :text4"),
    @NamedQuery(name = "CmFormData.findByText5", query = "SELECT c FROM CmFormData c WHERE c.text5 = :text5"),
    @NamedQuery(name = "CmFormData.findByText6", query = "SELECT c FROM CmFormData c WHERE c.text6 = :text6"),
    @NamedQuery(name = "CmFormData.findByText7", query = "SELECT c FROM CmFormData c WHERE c.text7 = :text7"),
    @NamedQuery(name = "CmFormData.findByText8", query = "SELECT c FROM CmFormData c WHERE c.text8 = :text8"),
    @NamedQuery(name = "CmFormData.findByDate1", query = "SELECT c FROM CmFormData c WHERE c.date1 = :date1"),
    @NamedQuery(name = "CmFormData.findByDate2", query = "SELECT c FROM CmFormData c WHERE c.date2 = :date2"),
    @NamedQuery(name = "CmFormData.findByDate3", query = "SELECT c FROM CmFormData c WHERE c.date3 = :date3"),
    @NamedQuery(name = "CmFormData.findByDate4", query = "SELECT c FROM CmFormData c WHERE c.date4 = :date4"),
    @NamedQuery(name = "CmFormData.findByDate5", query = "SELECT c FROM CmFormData c WHERE c.date5 = :date5"),
    @NamedQuery(name = "CmFormData.findByDate6", query = "SELECT c FROM CmFormData c WHERE c.date6 = :date6"),
    @NamedQuery(name = "CmFormData.findByDate7", query = "SELECT c FROM CmFormData c WHERE c.date7 = :date7"),
    @NamedQuery(name = "CmFormData.findByDate8", query = "SELECT c FROM CmFormData c WHERE c.date8 = :date8"),
    @NamedQuery(name = "CmFormData.findByTime1", query = "SELECT c FROM CmFormData c WHERE c.time1 = :time1"),
    @NamedQuery(name = "CmFormData.findByTime2", query = "SELECT c FROM CmFormData c WHERE c.time2 = :time2"),
    @NamedQuery(name = "CmFormData.findByTime3", query = "SELECT c FROM CmFormData c WHERE c.time3 = :time3"),
    @NamedQuery(name = "CmFormData.findByTime4", query = "SELECT c FROM CmFormData c WHERE c.time4 = :time4"),
    @NamedQuery(name = "CmFormData.findByTime5", query = "SELECT c FROM CmFormData c WHERE c.time5 = :time5"),
    @NamedQuery(name = "CmFormData.findByTime6", query = "SELECT c FROM CmFormData c WHERE c.time6 = :time6"),
    @NamedQuery(name = "CmFormData.findByTime7", query = "SELECT c FROM CmFormData c WHERE c.time7 = :time7"),
    @NamedQuery(name = "CmFormData.findByTime8", query = "SELECT c FROM CmFormData c WHERE c.time8 = :time8"),
    @NamedQuery(name = "CmFormData.findByBool1", query = "SELECT c FROM CmFormData c WHERE c.bool1 = :bool1"),
    @NamedQuery(name = "CmFormData.findByBool2", query = "SELECT c FROM CmFormData c WHERE c.bool2 = :bool2"),
    @NamedQuery(name = "CmFormData.findByBool3", query = "SELECT c FROM CmFormData c WHERE c.bool3 = :bool3"),
    @NamedQuery(name = "CmFormData.findByBool4", query = "SELECT c FROM CmFormData c WHERE c.bool4 = :bool4"),
    @NamedQuery(name = "CmFormData.findByBool5", query = "SELECT c FROM CmFormData c WHERE c.bool5 = :bool5"),
    @NamedQuery(name = "CmFormData.findByBool6", query = "SELECT c FROM CmFormData c WHERE c.bool6 = :bool6"),
    @NamedQuery(name = "CmFormData.findByBool7", query = "SELECT c FROM CmFormData c WHERE c.bool7 = :bool7"),
    @NamedQuery(name = "CmFormData.findByBool8", query = "SELECT c FROM CmFormData c WHERE c.bool8 = :bool8"),
    @NamedQuery(name = "CmFormData.findByText9", query = "SELECT c FROM CmFormData c WHERE c.text9 = :text9"),
    @NamedQuery(name = "CmFormData.findByText10", query = "SELECT c FROM CmFormData c WHERE c.text10 = :text10"),
    @NamedQuery(name = "CmFormData.findByText11", query = "SELECT c FROM CmFormData c WHERE c.text11 = :text11"),
    @NamedQuery(name = "CmFormData.findByText12", query = "SELECT c FROM CmFormData c WHERE c.text12 = :text12"),
    @NamedQuery(name = "CmFormData.findByText13", query = "SELECT c FROM CmFormData c WHERE c.text13 = :text13"),
    @NamedQuery(name = "CmFormData.findByText14", query = "SELECT c FROM CmFormData c WHERE c.text14 = :text14"),
    @NamedQuery(name = "CmFormData.findByText15", query = "SELECT c FROM CmFormData c WHERE c.text15 = :text15"),
    @NamedQuery(name = "CmFormData.findByRadio1", query = "SELECT c FROM CmFormData c WHERE c.radio1 = :radio1"),
    @NamedQuery(name = "CmFormData.findByRadio2", query = "SELECT c FROM CmFormData c WHERE c.radio2 = :radio2"),
    @NamedQuery(name = "CmFormData.findByRadio3", query = "SELECT c FROM CmFormData c WHERE c.radio3 = :radio3"),
    @NamedQuery(name = "CmFormData.findByRadio4", query = "SELECT c FROM CmFormData c WHERE c.radio4 = :radio4"),
    @NamedQuery(name = "CmFormData.findByRadio5", query = "SELECT c FROM CmFormData c WHERE c.radio5 = :radio5"),
    @NamedQuery(name = "CmFormData.findByRadio6", query = "SELECT c FROM CmFormData c WHERE c.radio6 = :radio6"),
    @NamedQuery(name = "CmFormData.findByRadio7", query = "SELECT c FROM CmFormData c WHERE c.radio7 = :radio7"),
    @NamedQuery(name = "CmFormData.findByRadio8", query = "SELECT c FROM CmFormData c WHERE c.radio8 = :radio8"),
    @NamedQuery(name = "CmFormData.findByVersion", query = "SELECT c FROM CmFormData c WHERE c.version = :version"),
    @NamedQuery(name = "CmFormData.findByVersionNo", query = "SELECT c FROM CmFormData c WHERE c.versionNo = :versionNo"),
    @NamedQuery(name = "CmFormData.findByActive", query = "SELECT c FROM CmFormData c WHERE c.active = :active"),
    @NamedQuery(name = "CmFormData.findByLastMod", query = "SELECT c FROM CmFormData c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "CmFormData.findByLastModBy", query = "SELECT c FROM CmFormData c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "CmFormData.findByLastModIp", query = "SELECT c FROM CmFormData c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "CmFormData.findByCreateBy", query = "SELECT c FROM CmFormData c WHERE c.createBy = :createBy"),
    @NamedQuery(name = "CmFormData.findByCreateByIp", query = "SELECT c FROM CmFormData c WHERE c.createByIp = :createByIp"),
    @NamedQuery(name = "CmFormData.findByCreateDate", query = "SELECT c FROM CmFormData c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "CmFormData.findByDate9", query = "SELECT c FROM CmFormData c WHERE c.date9 = :date9"),
    @NamedQuery(name = "CmFormData.findByDate10", query = "SELECT c FROM CmFormData c WHERE c.date10 = :date10"),
    @NamedQuery(name = "CmFormData.findByDate11", query = "SELECT c FROM CmFormData c WHERE c.date11 = :date11"),
    @NamedQuery(name = "CmFormData.findByDate12", query = "SELECT c FROM CmFormData c WHERE c.date12 = :date12"),
    @NamedQuery(name = "CmFormData.findByDate13", query = "SELECT c FROM CmFormData c WHERE c.date13 = :date13"),
    @NamedQuery(name = "CmFormData.findByDate14", query = "SELECT c FROM CmFormData c WHERE c.date14 = :date14")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_DATA", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormData.findAll", query = "SELECT c FROM CmFormData c"),
    @NamedQuery(name = "CmFormData.findById", query = "SELECT c FROM CmFormData c WHERE c.id = :id")})
public class CmFormData implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "INT4_1")
    private BigInteger int41;
    @Column(name = "INT4_2")
    private BigInteger int42;
    @Column(name = "INT4_3")
    private BigInteger int43;
    @Column(name = "INT4_4")
    private BigInteger int44;
    @Column(name = "INT4_5")
    private BigInteger int45;
    @Column(name = "INT4_6")
    private BigInteger int46;
    @Column(name = "INT4_7")
    private BigInteger int47;
    @Column(name = "INT4_8")
    private BigInteger int48;
    @Column(name = "FLOAT4_1")
    private BigInteger float41;
    @Column(name = "FLOAT4_2")
    private BigInteger float42;
    @Column(name = "FLOAT4_3")
    private BigInteger float43;
    @Column(name = "FLOAT4_4")
    private BigInteger float44;
    @Column(name = "FLOAT4_5")
    private BigInteger float45;
    @Column(name = "FLOAT4_6")
    private BigInteger float46;
    @Column(name = "FLOAT4_7")
    private BigInteger float47;
    @Column(name = "FLOAT4_8")
    private BigInteger float48;
    @Size(max = 255)
    @Column(name = "VARCHAR_1")
    private String varchar1;
    @Size(max = 255)
    @Column(name = "VARCHAR_2")
    private String varchar2;
    @Size(max = 255)
    @Column(name = "VARCHAR_3")
    private String varchar3;
    @Size(max = 255)
    @Column(name = "VARCHAR_4")
    private String varchar4;
    @Size(max = 255)
    @Column(name = "VARCHAR_5")
    private String varchar5;
    @Size(max = 255)
    @Column(name = "VARCHAR_6")
    private String varchar6;
    @Size(max = 255)
    @Column(name = "VARCHAR_7")
    private String varchar7;
    @Size(max = 255)
    @Column(name = "VARCHAR_8")
    private String varchar8;
    @Size(max = 255)
    @Column(name = "VARCHAR_9")
    private String varchar9;
    @Size(max = 255)
    @Column(name = "VARCHAR_10")
    private String varchar10;
    @Size(max = 255)
    @Column(name = "VARCHAR_11")
    private String varchar11;
    @Size(max = 255)
    @Column(name = "VARCHAR_12")
    private String varchar12;
    @Size(max = 255)
    @Column(name = "VARCHAR_13")
    private String varchar13;
    @Size(max = 255)
    @Column(name = "VARCHAR_14")
    private String varchar14;
    @Size(max = 255)
    @Column(name = "VARCHAR_15")
    private String varchar15;
    @Size(max = 255)
    @Column(name = "VARCHAR_16")
    private String varchar16;
    @Size(max = 255)
    @Column(name = "VARCHAR_17")
    private String varchar17;
    @Size(max = 255)
    @Column(name = "VARCHAR_18")
    private String varchar18;
    @Size(max = 255)
    @Column(name = "VARCHAR_19")
    private String varchar19;
    @Size(max = 255)
    @Column(name = "VARCHAR_20")
    private String varchar20;
    @Size(max = 4000)
    @Column(name = "TEXT_1")
    private String text1;
    @Size(max = 4000)
    @Column(name = "TEXT_2")
    private String text2;
    @Size(max = 4000)
    @Column(name = "TEXT_3")
    private String text3;
    @Size(max = 4000)
    @Column(name = "TEXT_4")
    private String text4;
    @Size(max = 4000)
    @Column(name = "TEXT_5")
    private String text5;
    @Size(max = 4000)
    @Column(name = "TEXT_6")
    private String text6;
    @Size(max = 4000)
    @Column(name = "TEXT_7")
    private String text7;
    @Size(max = 4000)
    @Column(name = "TEXT_8")
    private String text8;
    @Column(name = "DATE_1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;
    @Column(name = "DATE_2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date2;
    @Column(name = "DATE_3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date3;
    @Column(name = "DATE_4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date4;
    @Column(name = "DATE_5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date5;
    @Column(name = "DATE_6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date6;
    @Column(name = "DATE_7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date7;
    @Column(name = "DATE_8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date8;
    @Size(max = 8)
    @Column(name = "TIME_1")
    private String time1;
    @Size(max = 8)
    @Column(name = "TIME_2")
    private String time2;
    @Size(max = 8)
    @Column(name = "TIME_3")
    private String time3;
    @Size(max = 8)
    @Column(name = "TIME_4")
    private String time4;
    @Size(max = 8)
    @Column(name = "TIME_5")
    private String time5;
    @Size(max = 8)
    @Column(name = "TIME_6")
    private String time6;
    @Size(max = 8)
    @Column(name = "TIME_7")
    private String time7;
    @Size(max = 8)
    @Column(name = "TIME_8")
    private String time8;
    @Column(name = "BOOL_1")
    private Character bool1;
    @Column(name = "BOOL_2")
    private Character bool2;
    @Column(name = "BOOL_3")
    private Character bool3;
    @Column(name = "BOOL_4")
    private Character bool4;
    @Column(name = "BOOL_5")
    private Character bool5;
    @Column(name = "BOOL_6")
    private Character bool6;
    @Column(name = "BOOL_7")
    private Character bool7;
    @Column(name = "BOOL_8")
    private Character bool8;
    @Size(max = 4000)
    @Column(name = "TEXT_9")
    private String text9;
    @Size(max = 4000)
    @Column(name = "TEXT_10")
    private String text10;
    @Size(max = 4000)
    @Column(name = "TEXT_11")
    private String text11;
    @Size(max = 4000)
    @Column(name = "TEXT_12")
    private String text12;
    @Size(max = 4000)
    @Column(name = "TEXT_13")
    private String text13;
    @Size(max = 4000)
    @Column(name = "TEXT_14")
    private String text14;
    @Size(max = 4000)
    @Column(name = "TEXT_15")
    private String text15;
    @Size(max = 250)
    @Column(name = "RADIO_1")
    private String radio1;
    @Size(max = 250)
    @Column(name = "RADIO_2")
    private String radio2;
    @Size(max = 250)
    @Column(name = "RADIO_3")
    private String radio3;
    @Size(max = 250)
    @Column(name = "RADIO_4")
    private String radio4;
    @Size(max = 250)
    @Column(name = "RADIO_5")
    private String radio5;
    @Size(max = 250)
    @Column(name = "RADIO_6")
    private String radio6;
    @Size(max = 250)
    @Column(name = "RADIO_7")
    private String radio7;
    @Size(max = 250)
    @Column(name = "RADIO_8")
    private String radio8;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 20)
    @Column(name = "VERSION_NO")
    private String versionNo;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
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
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "DATE_9")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date9;
    @Column(name = "DATE_10")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date10;
    @Column(name = "DATE_11")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date11;
    @Column(name = "DATE_12")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date12;
    @Column(name = "DATE_13")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date13;
    @Column(name = "DATE_14")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date14;
    @JoinColumn(name = "CM_FORM_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CmForm cmFormId;

    public CmFormData() {
    }

    public CmFormData(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getInt41() {
        return int41;
    }

    public void setInt41(BigInteger int41) {
        this.int41 = int41;
    }

    public BigInteger getInt42() {
        return int42;
    }

    public void setInt42(BigInteger int42) {
        this.int42 = int42;
    }

    public BigInteger getInt43() {
        return int43;
    }

    public void setInt43(BigInteger int43) {
        this.int43 = int43;
    }

    public BigInteger getInt44() {
        return int44;
    }

    public void setInt44(BigInteger int44) {
        this.int44 = int44;
    }

    public BigInteger getInt45() {
        return int45;
    }

    public void setInt45(BigInteger int45) {
        this.int45 = int45;
    }

    public BigInteger getInt46() {
        return int46;
    }

    public void setInt46(BigInteger int46) {
        this.int46 = int46;
    }

    public BigInteger getInt47() {
        return int47;
    }

    public void setInt47(BigInteger int47) {
        this.int47 = int47;
    }

    public BigInteger getInt48() {
        return int48;
    }

    public void setInt48(BigInteger int48) {
        this.int48 = int48;
    }

    public BigInteger getFloat41() {
        return float41;
    }

    public void setFloat41(BigInteger float41) {
        this.float41 = float41;
    }

    public BigInteger getFloat42() {
        return float42;
    }

    public void setFloat42(BigInteger float42) {
        this.float42 = float42;
    }

    public BigInteger getFloat43() {
        return float43;
    }

    public void setFloat43(BigInteger float43) {
        this.float43 = float43;
    }

    public BigInteger getFloat44() {
        return float44;
    }

    public void setFloat44(BigInteger float44) {
        this.float44 = float44;
    }

    public BigInteger getFloat45() {
        return float45;
    }

    public void setFloat45(BigInteger float45) {
        this.float45 = float45;
    }

    public BigInteger getFloat46() {
        return float46;
    }

    public void setFloat46(BigInteger float46) {
        this.float46 = float46;
    }

    public BigInteger getFloat47() {
        return float47;
    }

    public void setFloat47(BigInteger float47) {
        this.float47 = float47;
    }

    public BigInteger getFloat48() {
        return float48;
    }

    public void setFloat48(BigInteger float48) {
        this.float48 = float48;
    }

    public String getVarchar1() {
        return varchar1;
    }

    public void setVarchar1(String varchar1) {
        this.varchar1 = varchar1;
    }

    public String getVarchar2() {
        return varchar2;
    }

    public void setVarchar2(String varchar2) {
        this.varchar2 = varchar2;
    }

    public String getVarchar3() {
        return varchar3;
    }

    public void setVarchar3(String varchar3) {
        this.varchar3 = varchar3;
    }

    public String getVarchar4() {
        return varchar4;
    }

    public void setVarchar4(String varchar4) {
        this.varchar4 = varchar4;
    }

    public String getVarchar5() {
        return varchar5;
    }

    public void setVarchar5(String varchar5) {
        this.varchar5 = varchar5;
    }

    public String getVarchar6() {
        return varchar6;
    }

    public void setVarchar6(String varchar6) {
        this.varchar6 = varchar6;
    }

    public String getVarchar7() {
        return varchar7;
    }

    public void setVarchar7(String varchar7) {
        this.varchar7 = varchar7;
    }

    public String getVarchar8() {
        return varchar8;
    }

    public void setVarchar8(String varchar8) {
        this.varchar8 = varchar8;
    }

    public String getVarchar9() {
        return varchar9;
    }

    public void setVarchar9(String varchar9) {
        this.varchar9 = varchar9;
    }

    public String getVarchar10() {
        return varchar10;
    }

    public void setVarchar10(String varchar10) {
        this.varchar10 = varchar10;
    }

    public String getVarchar11() {
        return varchar11;
    }

    public void setVarchar11(String varchar11) {
        this.varchar11 = varchar11;
    }

    public String getVarchar12() {
        return varchar12;
    }

    public void setVarchar12(String varchar12) {
        this.varchar12 = varchar12;
    }

    public String getVarchar13() {
        return varchar13;
    }

    public void setVarchar13(String varchar13) {
        this.varchar13 = varchar13;
    }

    public String getVarchar14() {
        return varchar14;
    }

    public void setVarchar14(String varchar14) {
        this.varchar14 = varchar14;
    }

    public String getVarchar15() {
        return varchar15;
    }

    public void setVarchar15(String varchar15) {
        this.varchar15 = varchar15;
    }

    public String getVarchar16() {
        return varchar16;
    }

    public void setVarchar16(String varchar16) {
        this.varchar16 = varchar16;
    }

    public String getVarchar17() {
        return varchar17;
    }

    public void setVarchar17(String varchar17) {
        this.varchar17 = varchar17;
    }

    public String getVarchar18() {
        return varchar18;
    }

    public void setVarchar18(String varchar18) {
        this.varchar18 = varchar18;
    }

    public String getVarchar19() {
        return varchar19;
    }

    public void setVarchar19(String varchar19) {
        this.varchar19 = varchar19;
    }

    public String getVarchar20() {
        return varchar20;
    }

    public void setVarchar20(String varchar20) {
        this.varchar20 = varchar20;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getText7() {
        return text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getText8() {
        return text8;
    }

    public void setText8(String text8) {
        this.text8 = text8;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public Date getDate5() {
        return date5;
    }

    public void setDate5(Date date5) {
        this.date5 = date5;
    }

    public Date getDate6() {
        return date6;
    }

    public void setDate6(Date date6) {
        this.date6 = date6;
    }

    public Date getDate7() {
        return date7;
    }

    public void setDate7(Date date7) {
        this.date7 = date7;
    }

    public Date getDate8() {
        return date8;
    }

    public void setDate8(Date date8) {
        this.date8 = date8;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public String getTime5() {
        return time5;
    }

    public void setTime5(String time5) {
        this.time5 = time5;
    }

    public String getTime6() {
        return time6;
    }

    public void setTime6(String time6) {
        this.time6 = time6;
    }

    public String getTime7() {
        return time7;
    }

    public void setTime7(String time7) {
        this.time7 = time7;
    }

    public String getTime8() {
        return time8;
    }

    public void setTime8(String time8) {
        this.time8 = time8;
    }

    public Character getBool1() {
        return bool1;
    }

    public void setBool1(Character bool1) {
        this.bool1 = bool1;
    }

    public Character getBool2() {
        return bool2;
    }

    public void setBool2(Character bool2) {
        this.bool2 = bool2;
    }

    public Character getBool3() {
        return bool3;
    }

    public void setBool3(Character bool3) {
        this.bool3 = bool3;
    }

    public Character getBool4() {
        return bool4;
    }

    public void setBool4(Character bool4) {
        this.bool4 = bool4;
    }

    public Character getBool5() {
        return bool5;
    }

    public void setBool5(Character bool5) {
        this.bool5 = bool5;
    }

    public Character getBool6() {
        return bool6;
    }

    public void setBool6(Character bool6) {
        this.bool6 = bool6;
    }

    public Character getBool7() {
        return bool7;
    }

    public void setBool7(Character bool7) {
        this.bool7 = bool7;
    }

    public Character getBool8() {
        return bool8;
    }

    public void setBool8(Character bool8) {
        this.bool8 = bool8;
    }

    public String getText9() {
        return text9;
    }

    public void setText9(String text9) {
        this.text9 = text9;
    }

    public String getText10() {
        return text10;
    }

    public void setText10(String text10) {
        this.text10 = text10;
    }

    public String getText11() {
        return text11;
    }

    public void setText11(String text11) {
        this.text11 = text11;
    }

    public String getText12() {
        return text12;
    }

    public void setText12(String text12) {
        this.text12 = text12;
    }

    public String getText13() {
        return text13;
    }

    public void setText13(String text13) {
        this.text13 = text13;
    }

    public String getText14() {
        return text14;
    }

    public void setText14(String text14) {
        this.text14 = text14;
    }

    public String getText15() {
        return text15;
    }

    public void setText15(String text15) {
        this.text15 = text15;
    }

    public String getRadio1() {
        return radio1;
    }

    public void setRadio1(String radio1) {
        this.radio1 = radio1;
    }

    public String getRadio2() {
        return radio2;
    }

    public void setRadio2(String radio2) {
        this.radio2 = radio2;
    }

    public String getRadio3() {
        return radio3;
    }

    public void setRadio3(String radio3) {
        this.radio3 = radio3;
    }

    public String getRadio4() {
        return radio4;
    }

    public void setRadio4(String radio4) {
        this.radio4 = radio4;
    }

    public String getRadio5() {
        return radio5;
    }

    public void setRadio5(String radio5) {
        this.radio5 = radio5;
    }

    public String getRadio6() {
        return radio6;
    }

    public void setRadio6(String radio6) {
        this.radio6 = radio6;
    }

    public String getRadio7() {
        return radio7;
    }

    public void setRadio7(String radio7) {
        this.radio7 = radio7;
    }

    public String getRadio8() {
        return radio8;
    }

    public void setRadio8(String radio8) {
        this.radio8 = radio8;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDate9() {
        return date9;
    }

    public void setDate9(Date date9) {
        this.date9 = date9;
    }

    public Date getDate10() {
        return date10;
    }

    public void setDate10(Date date10) {
        this.date10 = date10;
    }

    public Date getDate11() {
        return date11;
    }

    public void setDate11(Date date11) {
        this.date11 = date11;
    }

    public Date getDate12() {
        return date12;
    }

    public void setDate12(Date date12) {
        this.date12 = date12;
    }

    public Date getDate13() {
        return date13;
    }

    public void setDate13(Date date13) {
        this.date13 = date13;
    }

    public Date getDate14() {
        return date14;
    }

    public void setDate14(Date date14) {
        this.date14 = date14;
    }

    public CmForm getCmFormId() {
        return cmFormId;
    }

    public void setCmFormId(CmForm cmFormId) {
        this.cmFormId = cmFormId;
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
        if (!(object instanceof CmFormData)) {
            return false;
        }
        CmFormData other = (CmFormData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormData[ id=" + id + " ]";
    }
    
}
