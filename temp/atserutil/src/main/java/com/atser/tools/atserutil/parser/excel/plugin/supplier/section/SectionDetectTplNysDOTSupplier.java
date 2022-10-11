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

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 1, end = 1)
public class SectionDetectTplNysDOTSupplier {

    @ExcelField(position = 1)
    private String prodr_supp_cd;
    @ExcelField(position = 2)
    private String addr_id;
    @ExcelField(position = 3)
    private String vend_id;
    @ExcelField(position = 4)
    private String rmrks_id;
    @ExcelField(position = 5)
    private String prodr_supp_t;
    @ExcelField(position = 6)
    private String prodr_supp_nm;
    @ExcelField(position = 7)
    private String dbe_t;
    @ExcelField(position = 8)
    private String actvty_stat_t;
    @ExcelField(position = 9)
    private String stat_dt;
    @ExcelField(position = 10)
    private String appr_lev_t;
    @ExcelField(position = 11)
    private String geog_area_t;
    @ExcelField(position = 12)
    private String loc_t;
    @ExcelField(position = 13)
    private String loc_desc1;
    @ExcelField(position = 14)
    private String contact_nm;
    @ExcelField(position = 15)
    private String last_modfd_uid;
    @ExcelField(position = 16)
    private String last_modfd_dt;

    public String getProdr_supp_cd() {
        return prodr_supp_cd;
    }

    public void setProdr_supp_cd(String prodr_supp_cd) {
        this.prodr_supp_cd = prodr_supp_cd;
    }

    public String getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(String addr_id) {
        this.addr_id = addr_id;
    }

    public String getVend_id() {
        return vend_id;
    }

    public void setVend_id(String vend_id) {
        this.vend_id = vend_id;
    }

    public String getRmrks_id() {
        return rmrks_id;
    }

    public void setRmrks_id(String rmrks_id) {
        this.rmrks_id = rmrks_id;
    }

    public String getProdr_supp_t() {
        return prodr_supp_t;
    }

    public void setProdr_supp_t(String prodr_supp_t) {
        this.prodr_supp_t = prodr_supp_t;
    }

    public String getProdr_supp_nm() {
        return prodr_supp_nm;
    }

    public void setProdr_supp_nm(String prodr_supp_nm) {
        this.prodr_supp_nm = prodr_supp_nm;
    }

    public String getDbe_t() {
        return dbe_t;
    }

    public void setDbe_t(String dbe_t) {
        this.dbe_t = dbe_t;
    }

    public String getActvty_stat_t() {
        return actvty_stat_t;
    }

    public void setActvty_stat_t(String actvty_stat_t) {
        this.actvty_stat_t = actvty_stat_t;
    }

    public String getStat_dt() {
        return stat_dt;
    }

    public void setStat_dt(String stat_dt) {
        this.stat_dt = stat_dt;
    }

    public String getAppr_lev_t() {
        return appr_lev_t;
    }

    public void setAppr_lev_t(String appr_lev_t) {
        this.appr_lev_t = appr_lev_t;
    }

    public String getGeog_area_t() {
        return geog_area_t;
    }

    public void setGeog_area_t(String geog_area_t) {
        this.geog_area_t = geog_area_t;
    }

    public String getLoc_t() {
        return loc_t;
    }

    public void setLoc_t(String loc_t) {
        this.loc_t = loc_t;
    }

    public String getLoc_desc1() {
        return loc_desc1;
    }

    public void setLoc_desc1(String loc_desc1) {
        this.loc_desc1 = loc_desc1;
    }

    public String getContact_nm() {
        return contact_nm;
    }

    public void setContact_nm(String contact_nm) {
        this.contact_nm = contact_nm;
    }

    public String getLast_modfd_uid() {
        return last_modfd_uid;
    }

    public void setLast_modfd_uid(String last_modfd_uid) {
        this.last_modfd_uid = last_modfd_uid;
    }

    public String getLast_modfd_dt() {
        return last_modfd_dt;
    }

    public void setLast_modfd_dt(String last_modfd_dt) {
        this.last_modfd_dt = last_modfd_dt;
    }

    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        int count = 1;
        for (Field it : this.getClass().getDeclaredFields()) {
            if (it.get(this) == null) {
                return Boolean.FALSE;
            } else if (!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
            if (count++ == 6) {
                return Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }
}
