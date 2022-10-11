/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;
import java.util.Date;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 6, end = 5000)
public class SectionAspmMixDesign {

    @ExcelField(position = 1)
    private String mixdesignNo;
    @ExcelField(position = 2)
    private String supplier;
    @ExcelField(position = 3)
    private String supplierLoc;
    @ExcelField(position = 4)
    private String nmasId;
    @ExcelField(position = 5)
    private String gyrationsId;
    @ExcelField(position = 6)
    private String mixdesignType;
    @ExcelField(position = 7)
    private String trafficLevelId;
    @ExcelField(position = 8)
    private String pgBinderGradeId;
    @ExcelField(position = 9)
    private String pgBinderAdditiveId;
    @ExcelField(position = 10)
    private Double additivePct;
    @ExcelField(position = 11)
    private String recycleTypeId;
    @ExcelField(position = 12)
    private Double rapPct;
    @ExcelField(position = 13)
    private String wmaTechtypeId;
    @ExcelField(position = 14)
    private String wmaTechnologyId;
    @ExcelField(position = 15)
    private Double techPct;
    @ExcelField(position = 16)
    private Double gsb;
    @ExcelField(position = 17)
    private Double bulkSgGmb;
    @ExcelField(position = 18)
    private Double gmm;
    @ExcelField(position = 19)
    private Double desac;
    @ExcelField(position = 20)
    private Double tolminac;
    @ExcelField(position = 21)
    private Double tolminengac;
    @ExcelField(position = 22)
    private Double desvtm;
    @ExcelField(position = 23)
    private Double tolminvtm;
    @ExcelField(position = 24)
    private Double tolminengvtm;
    @ExcelField(position = 25)
    private Double desvma;
    @ExcelField(position = 26)
    private Double tolminvma;
    @ExcelField(position = 27)
    private Double tolminengvma;
    @ExcelField(position = 28)
    private Double desvfa;
    @ExcelField(position = 29)
    private Double tolminvfa;
    @ExcelField(position = 30)
    private Double tolminengvfa;
    @ExcelField(position = 31)
    private Double desdpbr;
    @ExcelField(position = 32)
    private Double tolmindpbr;
    @ExcelField(position = 33)
    private Double tolminengdpbr;
    @ExcelField(position = 34)
    private Double gse;
    @ExcelField(position = 35)
    private Double gasp;
    @ExcelField(position = 36)
    private Double pba;
    @ExcelField(position = 37)
    private Double pbe;
    @ExcelField(position = 38)
    private Date ltmfDate;
    @ExcelField(position = 39)
    private Date approvedDate;
    @ExcelField(position = 40)
    private Date expirationDate;
    @ExcelField(position = 42)
    private Double gtc1;
    @ExcelField(position = 43)
    private Double gtc2;
    @ExcelField(position = 44)
    private Double gtc3;
    @ExcelField(position = 45)
    private Double gtc4;
    @ExcelField(position = 46)
    private Double gtc5;
    @ExcelField(position = 47)
    private Double gtc6;
    @ExcelField(position = 48)
    private Double gtc7;
    @ExcelField(position = 49)
    private Double gtc8;
    @ExcelField(position = 50)
    private Double gtc9;
    @ExcelField(position = 51)
    private Double gtc10;
    @ExcelField(position = 52)
    private Double gtc11;
    @ExcelField(position = 53)
    private Double gtc12;
    @ExcelField(position = 54)
    private Double gtc13;
    @ExcelField(position = 55)
    private Double gtc14;
    @ExcelField(position = 56)
    private Double gtc15;
    @ExcelField(position = 57)
    private Double gtc16;
    @ExcelField(position = 58)
    private Double gtc17;
    @ExcelField(position = 59)
    private Double gtc18;
    @ExcelField(position = 60)
    private Double gtc19;
    @ExcelField(position = 61)
    private Double gtc20;
    @ExcelField(position = 62)
    private Double gtc21;
    @ExcelField(position = 63)
    private Double gtc22;
    @ExcelField(position = 64)
    private Double gtc23;
    @ExcelField(position = 65)
    private Double gtc24;
    @ExcelField(position = 66)
    private Double gtc25;
    @ExcelField(position = 67)
    private Double gtc26;
    @ExcelField(position = 68)
    private Double gtc27;
    @ExcelField(position = 69)
    private Double gtc28;
    @ExcelField(position = 70)
    private Double gtc29;
    @ExcelField(position = 71)
    private Double gtc30;
    @ExcelField(position = 72)
    private Double gtc31;
    @ExcelField(position = 73)
    private Double gtc32;
    @ExcelField(position = 74)
    private Double gtc33;
    @ExcelField(position = 75)
    private Double gtc34;
    @ExcelField(position = 76)
    private Double gtc35;
    @ExcelField(position = 77)
    private Double gtc36;
    @ExcelField(position = 78)
    private Double gtc37;
    @ExcelField(position = 79)
    private Double gtc38;
    @ExcelField(position = 80)
    private Double gtc39;
    @ExcelField(position = 81)
    private Double gtc40;
    @ExcelField(position = 82)
    private Double gtc41;
    @ExcelField(position = 83)
    private Double gtc42;
    @ExcelField(position = 84)
    private Double gtc43;
    @ExcelField(position = 85)
    private Double gtc44;
    @ExcelField(position = 86)
    private Double gtc45;
    @ExcelField(position = 87)
    private Double gtc46;
    @ExcelField(position = 88)
    private Double gtc47;
    @ExcelField(position = 89)
    private Double gtc48;
    @ExcelField(position = 90)
    private Double gtc49;
    @ExcelField(position = 91)
    private Double gtc50;
    @ExcelField(position = 92)
    private Double gtc51;
    @ExcelField(position = 93)
    private Double gtc52;
    @ExcelField(position = 94)
    private Double gtc53;
    @ExcelField(position = 95)
    private Double gtc54;
    @ExcelField(position = 96)
    private Double gtc55;
    @ExcelField(position = 97)
    private Double gtc56;
    @ExcelField(position = 98)
    private Double gtc57;
    @ExcelField(position = 99)
    private Double gtc58;
    @ExcelField(position = 100)
    private Double gtc59;
    @ExcelField(position = 101)
    private Double gtc60;
    @ExcelField(position = 102)
    private Double gtc61;
    @ExcelField(position = 103)
    private Double gtc62;
    @ExcelField(position = 104)
    private Double gtc63;
    @ExcelField(position = 105)
    private Double gtc64;
    @ExcelField(position = 106)
    private Double gtc65;

    public String getMixdesignNo() {
        return mixdesignNo;
    }

    public void setMixdesignNo(String mixdesignNo) {
        this.mixdesignNo = mixdesignNo;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierLoc() {
        return supplierLoc;
    }

    public void setSupplierLoc(String supplierLoc) {
        this.supplierLoc = supplierLoc;
    }

    public String getNmasId() {
        return nmasId;
    }

    public void setNmasId(String nmasId) {
        this.nmasId = nmasId;
    }

    public String getGyrationsId() {
        return gyrationsId;
    }

    public void setGyrationsId(String gyrationsId) {
        this.gyrationsId = gyrationsId;
    }

    public String getMixdesignType() {
        return mixdesignType;
    }

    public void setMixdesignType(String mixdesignType) {
        this.mixdesignType = mixdesignType;
    }

    public String getTrafficLevelId() {
        return trafficLevelId;
    }

    public void setTrafficLevelId(String trafficLevelId) {
        this.trafficLevelId = trafficLevelId;
    }

    public String getPgBinderGradeId() {
        return pgBinderGradeId;
    }

    public void setPgBinderGradeId(String pgBinderGradeId) {
        this.pgBinderGradeId = pgBinderGradeId;
    }

    public String getPgBinderAdditiveId() {
        return pgBinderAdditiveId;
    }

    public void setPgBinderAdditiveId(String pgBinderAdditiveId) {
        this.pgBinderAdditiveId = pgBinderAdditiveId;
    }

    public Double getAdditivePct() {
        return additivePct;
    }

    public void setAdditivePct(Double additivePct) {
        this.additivePct = additivePct;
    }

    public String getRecycleTypeId() {
        return recycleTypeId;
    }

    public void setRecycleTypeId(String recycleTypeId) {
        this.recycleTypeId = recycleTypeId;
    }

    public String getWmaTechtypeId() {
        return wmaTechtypeId;
    }

    public void setWmaTechtypeId(String wmaTechtypeId) {
        this.wmaTechtypeId = wmaTechtypeId;
    }

    public String getWmaTechnologyId() {
        return wmaTechnologyId;
    }

    public void setWmaTechnologyId(String wmaTechnologyId) {
        this.wmaTechnologyId = wmaTechnologyId;
    }

    public Double getTechPct() {
        return techPct;
    }

    public void setTechPct(Double techPct) {
        this.techPct = techPct;
    }

    public Double getGsb() {
        return gsb;
    }

    public void setGsb(Double gsb) {
        this.gsb = gsb;
    }

    public Double getBulkSgGmb() {
        return bulkSgGmb;
    }

    public void setBulkSgGmb(Double bulkSgGmb) {
        this.bulkSgGmb = bulkSgGmb;
    }

    public Double getGmm() {
        return gmm;
    }

    public void setGmm(Double gmm) {
        this.gmm = gmm;
    }

    public Double getDesac() {
        return desac;
    }

    public void setDesac(Double desac) {
        this.desac = desac;
    }

    public Double getTolminac() {
        return tolminac;
    }

    public void setTolminac(Double tolminac) {
        this.tolminac = tolminac;
    }

    public Double getTolminengac() {
        return tolminengac;
    }

    public void setTolminengac(Double tolminengac) {
        this.tolminengac = tolminengac;
    }

    public Double getDesvtm() {
        return desvtm;
    }

    public void setDesvtm(Double desvtm) {
        this.desvtm = desvtm;
    }

    public Double getTolminvtm() {
        return tolminvtm;
    }

    public void setTolminvtm(Double tolminvtm) {
        this.tolminvtm = tolminvtm;
    }

    public Double getTolminengvtm() {
        return tolminengvtm;
    }

    public void setTolminengvtm(Double tolminengvtm) {
        this.tolminengvtm = tolminengvtm;
    }

    public Double getDesvma() {
        return desvma;
    }

    public void setDesvma(Double desvma) {
        this.desvma = desvma;
    }

    public Double getTolminvma() {
        return tolminvma;
    }

    public void setTolminvma(Double tolminvma) {
        this.tolminvma = tolminvma;
    }

    public Double getTolminengvma() {
        return tolminengvma;
    }

    public void setTolminengvma(Double tolminengvma) {
        this.tolminengvma = tolminengvma;
    }

    public Double getDesvfa() {
        return desvfa;
    }

    public void setDesvfa(Double desvfa) {
        this.desvfa = desvfa;
    }

    public Double getTolminvfa() {
        return tolminvfa;
    }

    public void setTolminvfa(Double tolminvfa) {
        this.tolminvfa = tolminvfa;
    }

    public Double getTolminengvfa() {
        return tolminengvfa;
    }

    public void setTolminengvfa(Double tolminengvfa) {
        this.tolminengvfa = tolminengvfa;
    }

    public Double getDesdpbr() {
        return desdpbr;
    }

    public void setDesdpbr(Double desdpbr) {
        this.desdpbr = desdpbr;
    }

    public Double getTolmindpbr() {
        return tolmindpbr;
    }

    public void setTolmindpbr(Double tolmindpbr) {
        this.tolmindpbr = tolmindpbr;
    }

    public Double getTolminengdpbr() {
        return tolminengdpbr;
    }

    public void setTolminengdpbr(Double tolminengdpbr) {
        this.tolminengdpbr = tolminengdpbr;
    }

    public Double getGse() {
        return gse;
    }

    public void setGse(Double gse) {
        this.gse = gse;
    }

    public Double getGasp() {
        return gasp;
    }

    public void setGasp(Double gasp) {
        this.gasp = gasp;
    }

    public Double getPba() {
        return pba;
    }

    public void setPba(Double pba) {
        this.pba = pba;
    }

    public Double getPbe() {
        return pbe;
    }

    public void setPbe(Double pbe) {
        this.pbe = pbe;
    }

    public Date getLtmfDate() {
        return ltmfDate;
    }

    public void setLtmfDate(Date ltmfDate) {
        this.ltmfDate = ltmfDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getGtc1() {
        return gtc1;
    }

    public void setGtc1(Double gtc1) {
        this.gtc1 = gtc1;
    }

    public Double getGtc2() {
        return gtc2;
    }

    public void setGtc2(Double gtc2) {
        this.gtc2 = gtc2;
    }

    public Double getGtc3() {
        return gtc3;
    }

    public void setGtc3(Double gtc3) {
        this.gtc3 = gtc3;
    }

    public Double getGtc4() {
        return gtc4;
    }

    public void setGtc4(Double gtc4) {
        this.gtc4 = gtc4;
    }

    public Double getGtc5() {
        return gtc5;
    }

    public void setGtc5(Double gtc5) {
        this.gtc5 = gtc5;
    }

    public Double getGtc6() {
        return gtc6;
    }

    public void setGtc6(Double gtc6) {
        this.gtc6 = gtc6;
    }

    public Double getGtc7() {
        return gtc7;
    }

    public void setGtc7(Double gtc7) {
        this.gtc7 = gtc7;
    }

    public Double getGtc8() {
        return gtc8;
    }

    public void setGtc8(Double gtc8) {
        this.gtc8 = gtc8;
    }

    public Double getGtc9() {
        return gtc9;
    }

    public void setGtc9(Double gtc9) {
        this.gtc9 = gtc9;
    }

    public Double getGtc10() {
        return gtc10;
    }

    public void setGtc10(Double gtc10) {
        this.gtc10 = gtc10;
    }

    public Double getGtc11() {
        return gtc11;
    }

    public void setGtc11(Double gtc11) {
        this.gtc11 = gtc11;
    }

    public Double getGtc12() {
        return gtc12;
    }

    public void setGtc12(Double gtc12) {
        this.gtc12 = gtc12;
    }

    public Double getGtc13() {
        return gtc13;
    }

    public void setGtc13(Double gtc13) {
        this.gtc13 = gtc13;
    }

    public Double getGtc14() {
        return gtc14;
    }

    public void setGtc14(Double gtc14) {
        this.gtc14 = gtc14;
    }

    public Double getGtc15() {
        return gtc15;
    }

    public void setGtc15(Double gtc15) {
        this.gtc15 = gtc15;
    }

    public Double getGtc16() {
        return gtc16;
    }

    public void setGtc16(Double gtc16) {
        this.gtc16 = gtc16;
    }

    public Double getGtc17() {
        return gtc17;
    }

    public void setGtc17(Double gtc17) {
        this.gtc17 = gtc17;
    }

    public Double getGtc18() {
        return gtc18;
    }

    public void setGtc18(Double gtc18) {
        this.gtc18 = gtc18;
    }

    public Double getGtc19() {
        return gtc19;
    }

    public void setGtc19(Double gtc19) {
        this.gtc19 = gtc19;
    }

    public Double getGtc20() {
        return gtc20;
    }

    public void setGtc20(Double gtc20) {
        this.gtc20 = gtc20;
    }

    public Double getGtc21() {
        return gtc21;
    }

    public void setGtc21(Double gtc21) {
        this.gtc21 = gtc21;
    }

    public Double getGtc22() {
        return gtc22;
    }

    public void setGtc22(Double gtc22) {
        this.gtc22 = gtc22;
    }

    public Double getGtc23() {
        return gtc23;
    }

    public void setGtc23(Double gtc23) {
        this.gtc23 = gtc23;
    }

    public Double getGtc24() {
        return gtc24;
    }

    public void setGtc24(Double gtc24) {
        this.gtc24 = gtc24;
    }

    public Double getGtc25() {
        return gtc25;
    }

    public void setGtc25(Double gtc25) {
        this.gtc25 = gtc25;
    }

    public Double getGtc26() {
        return gtc26;
    }

    public void setGtc26(Double gtc26) {
        this.gtc26 = gtc26;
    }

    public Double getGtc27() {
        return gtc27;
    }

    public void setGtc27(Double gtc27) {
        this.gtc27 = gtc27;
    }

    public Double getGtc28() {
        return gtc28;
    }

    public void setGtc28(Double gtc28) {
        this.gtc28 = gtc28;
    }

    public Double getGtc29() {
        return gtc29;
    }

    public void setGtc29(Double gtc29) {
        this.gtc29 = gtc29;
    }

    public Double getGtc30() {
        return gtc30;
    }

    public void setGtc30(Double gtc30) {
        this.gtc30 = gtc30;
    }

    public Double getGtc31() {
        return gtc31;
    }

    public void setGtc31(Double gtc31) {
        this.gtc31 = gtc31;
    }

    public Double getGtc32() {
        return gtc32;
    }

    public void setGtc32(Double gtc32) {
        this.gtc32 = gtc32;
    }

    public Double getGtc33() {
        return gtc33;
    }

    public void setGtc33(Double gtc33) {
        this.gtc33 = gtc33;
    }

    public Double getGtc34() {
        return gtc34;
    }

    public void setGtc34(Double gtc34) {
        this.gtc34 = gtc34;
    }

    public Double getGtc35() {
        return gtc35;
    }

    public void setGtc35(Double gtc35) {
        this.gtc35 = gtc35;
    }

    public Double getGtc36() {
        return gtc36;
    }

    public void setGtc36(Double gtc36) {
        this.gtc36 = gtc36;
    }

    public Double getGtc37() {
        return gtc37;
    }

    public void setGtc37(Double gtc37) {
        this.gtc37 = gtc37;
    }

    public Double getGtc38() {
        return gtc38;
    }

    public void setGtc38(Double gtc38) {
        this.gtc38 = gtc38;
    }

    public Double getGtc39() {
        return gtc39;
    }

    public void setGtc39(Double gtc39) {
        this.gtc39 = gtc39;
    }

    public Double getGtc40() {
        return gtc40;
    }

    public void setGtc40(Double gtc40) {
        this.gtc40 = gtc40;
    }

    public Double getGtc41() {
        return gtc41;
    }

    public void setGtc41(Double gtc41) {
        this.gtc41 = gtc41;
    }

    public Double getGtc42() {
        return gtc42;
    }

    public void setGtc42(Double gtc42) {
        this.gtc42 = gtc42;
    }

    public Double getGtc43() {
        return gtc43;
    }

    public void setGtc43(Double gtc43) {
        this.gtc43 = gtc43;
    }

    public Double getGtc44() {
        return gtc44;
    }

    public void setGtc44(Double gtc44) {
        this.gtc44 = gtc44;
    }

    public Double getGtc45() {
        return gtc45;
    }

    public void setGtc45(Double gtc45) {
        this.gtc45 = gtc45;
    }

    public Double getGtc46() {
        return gtc46;
    }

    public void setGtc46(Double gtc46) {
        this.gtc46 = gtc46;
    }

    public Double getGtc47() {
        return gtc47;
    }

    public void setGtc47(Double gtc47) {
        this.gtc47 = gtc47;
    }

    public Double getGtc48() {
        return gtc48;
    }

    public void setGtc48(Double gtc48) {
        this.gtc48 = gtc48;
    }

    public Double getGtc49() {
        return gtc49;
    }

    public void setGtc49(Double gtc49) {
        this.gtc49 = gtc49;
    }

    public Double getGtc50() {
        return gtc50;
    }

    public void setGtc50(Double gtc50) {
        this.gtc50 = gtc50;
    }

    public Double getGtc51() {
        return gtc51;
    }

    public void setGtc51(Double gtc51) {
        this.gtc51 = gtc51;
    }

    public Double getGtc52() {
        return gtc52;
    }

    public void setGtc52(Double gtc52) {
        this.gtc52 = gtc52;
    }

    public Double getGtc53() {
        return gtc53;
    }

    public void setGtc53(Double gtc53) {
        this.gtc53 = gtc53;
    }

    public Double getGtc54() {
        return gtc54;
    }

    public void setGtc54(Double gtc54) {
        this.gtc54 = gtc54;
    }

    public Double getGtc55() {
        return gtc55;
    }

    public void setGtc55(Double gtc55) {
        this.gtc55 = gtc55;
    }

    public Double getGtc56() {
        return gtc56;
    }

    public void setGtc56(Double gtc56) {
        this.gtc56 = gtc56;
    }

    public Double getGtc57() {
        return gtc57;
    }

    public void setGtc57(Double gtc57) {
        this.gtc57 = gtc57;
    }

    public Double getGtc58() {
        return gtc58;
    }

    public void setGtc58(Double gtc58) {
        this.gtc58 = gtc58;
    }

    public Double getGtc59() {
        return gtc59;
    }

    public void setGtc59(Double gtc59) {
        this.gtc59 = gtc59;
    }

    public Double getGtc60() {
        return gtc60;
    }

    public void setGtc60(Double gtc60) {
        this.gtc60 = gtc60;
    }

    public Double getGtc61() {
        return gtc61;
    }

    public void setGtc61(Double gtc61) {
        this.gtc61 = gtc61;
    }

    public Double getGtc62() {
        return gtc62;
    }

    public void setGtc62(Double gtc62) {
        this.gtc62 = gtc62;
    }

    public Double getGtc63() {
        return gtc63;
    }

    public void setGtc63(Double gtc63) {
        this.gtc63 = gtc63;
    }

    public Double getGtc64() {
        return gtc64;
    }

    public void setGtc64(Double gtc64) {
        this.gtc64 = gtc64;
    }

    public Double getGtc65() {
        return gtc65;
    }

    public void setGtc65(Double gtc65) {
        this.gtc65 = gtc65;
    }

    public Double getRapPct() {
        return rapPct;
    }

    public void setRapPct(Double rapPct) {
        this.rapPct = rapPct;
    }
    
    public Boolean detectXmlBomb() {
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(this) != null && StringSupport.getString(field.get(this)).length() > ZipSecureFile.getMaxTextSize()) {
                    return Boolean.TRUE;
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
