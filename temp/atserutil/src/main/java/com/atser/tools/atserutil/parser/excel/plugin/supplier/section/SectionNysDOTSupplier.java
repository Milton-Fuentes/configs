/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 2, end = 5000)
public class SectionNysDOTSupplier {

    @ExcelField(position = 1)
    private String prodrSuppCd;
    @ExcelField(position = 2)
    private String addrId;
    @ExcelField(position = 3)
    private String vendId;
    @ExcelField(position = 4)
    private String rmrksId;
    @ExcelField(position = 5)
    private String prodrSuppT;
    @ExcelField(position = 6)
    private String prodrSuppNm;
    @ExcelField(position = 7)
    private String dbeT;
    @ExcelField(position = 8)
    private String actvtyStatT;
    @ExcelField(position = 9)
    private String statDt;
    @ExcelField(position = 10)
    private String apprLevT;
    @ExcelField(position = 11)
    private String geogAreaT;
    @ExcelField(position = 12)
    private String locT;
    @ExcelField(position = 13)
    private String locDesc1;
    @ExcelField(position = 14)
    private String contactNm;
    @ExcelField(position = 15)
    private String lastModfdUid;
    @ExcelField(position = 16)
    private String lastModfdDt;

    public String getProdrSuppCd() {
        return prodrSuppCd;
    }

    public void setProdrSuppCd(String prodrSuppCd) {
        this.prodrSuppCd = prodrSuppCd;
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public String getVendId() {
        return vendId;
    }

    public void setVendId(String vendId) {
        this.vendId = vendId;
    }

    public String getRmrksId() {
        return rmrksId;
    }

    public void setRmrksId(String rmrksId) {
        this.rmrksId = rmrksId;
    }

    public String getProdrSuppT() {
        return prodrSuppT;
    }

    public void setProdrSuppT(String prodrSuppT) {
        this.prodrSuppT = prodrSuppT;
    }

    public String getProdrSuppNm() {
        return prodrSuppNm;
    }

    public void setProdrSuppNm(String prodrSuppNm) {
        this.prodrSuppNm = prodrSuppNm;
    }

    public String getDbeT() {
        return dbeT;
    }

    public void setDbeT(String dbeT) {
        this.dbeT = dbeT;
    }

    public String getActvtyStatT() {
        return actvtyStatT;
    }

    public void setActvtyStatT(String actvtyStatT) {
        this.actvtyStatT = actvtyStatT;
    }

    public String getStatDt() {
        return statDt;
    }

    public void setStatDt(String statDt) {
        this.statDt = statDt;
    }

    public String getApprLevT() {
        return apprLevT;
    }

    public void setApprLevT(String apprLevT) {
        this.apprLevT = apprLevT;
    }

    public String getGeogAreaT() {
        return geogAreaT;
    }

    public void setGeogAreaT(String geogAreaT) {
        this.geogAreaT = geogAreaT;
    }

    public String getLocT() {
        return locT;
    }

    public void setLocT(String locT) {
        this.locT = locT;
    }

    public String getLocDesc1() {
        return locDesc1;
    }

    public void setLocDesc1(String locDesc1) {
        this.locDesc1 = locDesc1;
    }

    public String getContactNm() {
        return contactNm;
    }

    public void setContactNm(String contactNm) {
        this.contactNm = contactNm;
    }

    public String getLastModfdUid() {
        return lastModfdUid;
    }

    public void setLastModfdUid(String lastModfdUid) {
        this.lastModfdUid = lastModfdUid;
    }

    public String getLastModfdDt() {
        return lastModfdDt;
    }

    public void setLastModfdDt(String lastModfdDt) {
        this.lastModfdDt = lastModfdDt;
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
