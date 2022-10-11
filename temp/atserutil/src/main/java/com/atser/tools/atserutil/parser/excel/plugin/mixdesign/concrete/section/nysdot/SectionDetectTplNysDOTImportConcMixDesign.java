/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.nysdot;

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
public class SectionDetectTplNysDOTImportConcMixDesign {

    @ExcelField(position = 1)
    private String mix_id;
    @ExcelField(position = 2)
    private String dsn_t;
    @ExcelField(position = 3)
    private String rmrks_id;
    @ExcelField(position = 4)
    private String matl_cd;
    @ExcelField(position = 5)
    private String prodr_supp_cd;
    @ExcelField(position = 6)
    private String effdt;
    @ExcelField(position = 7)
    private String term_dt;
    @ExcelField(position = 8)
    private String dsnr_nm;
    @ExcelField(position = 9)
    private String apprd_dt;
    @ExcelField(position = 10)
    private String apprd_by_uid;
    @ExcelField(position = 11)
    private String conc_clas_t;
    @ExcelField(position = 12)
    private String min_avg_strgh_rqrd;
    @ExcelField(position = 13)
    private String dsn_strgh_spc;
    @ExcelField(position = 14)
    private String h2o_cem_ratio;
    @ExcelField(position = 15)
    private String unt_wt_m;
    @ExcelField(position = 16)
    private String unt_wt_meas_unt;
    @ExcelField(position = 17)
    private String theo_unt_wt;
    @ExcelField(position = 18)
    private String theo_unt_wt_unt;
    @ExcelField(position = 19)
    private String air_cntnt_m;
    @ExcelField(position = 20)
    private String slmp_m;
    @ExcelField(position = 21)
    private String slmp_meas_unt;
    @ExcelField(position = 22)
    private String last_modfd_uid;
    @ExcelField(position = 23)
    private String last_modfd_dt;

    public String getMix_id() {
        return mix_id;
    }

    public void setMix_id(String mix_id) {
        this.mix_id = mix_id;
    }

    public String getDsn_t() {
        return dsn_t;
    }

    public void setDsn_t(String dsn_t) {
        this.dsn_t = dsn_t;
    }

    public String getRmrks_id() {
        return rmrks_id;
    }

    public void setRmrks_id(String rmrks_id) {
        this.rmrks_id = rmrks_id;
    }

    public String getMatl_cd() {
        return matl_cd;
    }

    public void setMatl_cd(String matl_cd) {
        this.matl_cd = matl_cd;
    }

    public String getProdr_supp_cd() {
        return prodr_supp_cd;
    }

    public void setProdr_supp_cd(String prodr_supp_cd) {
        this.prodr_supp_cd = prodr_supp_cd;
    }

    public String getEffdt() {
        return effdt;
    }

    public void setEffdt(String effdt) {
        this.effdt = effdt;
    }

    public String getTerm_dt() {
        return term_dt;
    }

    public void setTerm_dt(String term_dt) {
        this.term_dt = term_dt;
    }

    public String getDsnr_nm() {
        return dsnr_nm;
    }

    public void setDsnr_nm(String dsnr_nm) {
        this.dsnr_nm = dsnr_nm;
    }

    public String getApprd_dt() {
        return apprd_dt;
    }

    public void setApprd_dt(String apprd_dt) {
        this.apprd_dt = apprd_dt;
    }

    public String getApprd_by_uid() {
        return apprd_by_uid;
    }

    public void setApprd_by_uid(String apprd_by_uid) {
        this.apprd_by_uid = apprd_by_uid;
    }

    public String getConc_clas_t() {
        return conc_clas_t;
    }

    public void setConc_clas_t(String conc_clas_t) {
        this.conc_clas_t = conc_clas_t;
    }

    public String getMin_avg_strgh_rqrd() {
        return min_avg_strgh_rqrd;
    }

    public void setMin_avg_strgh_rqrd(String min_avg_strgh_rqrd) {
        this.min_avg_strgh_rqrd = min_avg_strgh_rqrd;
    }

    public String getDsn_strgh_spc() {
        return dsn_strgh_spc;
    }

    public void setDsn_strgh_spc(String dsn_strgh_spc) {
        this.dsn_strgh_spc = dsn_strgh_spc;
    }

    public String getH2o_cem_ratio() {
        return h2o_cem_ratio;
    }

    public void setH2o_cem_ratio(String h2o_cem_ratio) {
        this.h2o_cem_ratio = h2o_cem_ratio;
    }

    public String getUnt_wt_m() {
        return unt_wt_m;
    }

    public void setUnt_wt_m(String unt_wt_m) {
        this.unt_wt_m = unt_wt_m;
    }

    public String getUnt_wt_meas_unt() {
        return unt_wt_meas_unt;
    }

    public void setUnt_wt_meas_unt(String unt_wt_meas_unt) {
        this.unt_wt_meas_unt = unt_wt_meas_unt;
    }

    public String getTheo_unt_wt() {
        return theo_unt_wt;
    }

    public void setTheo_unt_wt(String theo_unt_wt) {
        this.theo_unt_wt = theo_unt_wt;
    }

    public String getTheo_unt_wt_unt() {
        return theo_unt_wt_unt;
    }

    public void setTheo_unt_wt_unt(String theo_unt_wt_unt) {
        this.theo_unt_wt_unt = theo_unt_wt_unt;
    }

    public String getAir_cntnt_m() {
        return air_cntnt_m;
    }

    public void setAir_cntnt_m(String air_cntnt_m) {
        this.air_cntnt_m = air_cntnt_m;
    }

    public String getSlmp_m() {
        return slmp_m;
    }

    public void setSlmp_m(String slmp_m) {
        this.slmp_m = slmp_m;
    }

    public String getSlmp_meas_unt() {
        return slmp_meas_unt;
    }

    public void setSlmp_meas_unt(String slmp_meas_unt) {
        this.slmp_meas_unt = slmp_meas_unt;
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
        for(Field it : this.getClass().getDeclaredFields()) {
            if(it.get(this) == null) {
                return Boolean.FALSE;
            } else if(!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
            if(count++ == 6) {
                return Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }
}
