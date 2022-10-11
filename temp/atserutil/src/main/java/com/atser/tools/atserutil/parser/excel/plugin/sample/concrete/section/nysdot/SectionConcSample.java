/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.section.nysdot;

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
public class SectionConcSample {

    @ExcelField(position = 1)
    private String cont_id;
    @ExcelField(position = 2)
    private String itm_cd;
    @ExcelField(position = 3)
    private String smpl_id;
    @ExcelField(position = 4)
    private String matl_cd;
    @ExcelField(position = 5)
    private String smpl_mix_id;
    @ExcelField(position = 6)
    private String prodr_supp_cd;
    @ExcelField(position = 7)
    private String auth_by_cms_uid;
    @ExcelField(position = 8)
    private String smpl_t;
    @ExcelField(position = 9)
    private String smpl_dt;
    @ExcelField(position = 10)
    private String log_dt;
    @ExcelField(position = 11)
    private String auth_dt;
    @ExcelField(position = 12)
    private String stat_t;
    @ExcelField(position = 13)
    private String qryatser_subslump_tst_fld_lbl;
    @ExcelField(position = 14)
    private String slump;
    @ExcelField(position = 15)
    private String qryatser_subair_tst_fld_lbl;
    @ExcelField(position = 16)
    private String air;

    public String getCont_id() {
        return cont_id;
    }

    public void setCont_id(String cont_id) {
        this.cont_id = cont_id;
    }

    public String getItm_cd() {
        return itm_cd;
    }

    public void setItm_cd(String itm_cd) {
        this.itm_cd = itm_cd;
    }

    public String getSmpl_id() {
        return smpl_id;
    }

    public void setSmpl_id(String smpl_id) {
        this.smpl_id = smpl_id;
    }

    public String getMatl_cd() {
        return matl_cd;
    }

    public void setMatl_cd(String matl_cd) {
        this.matl_cd = matl_cd;
    }

    public String getSmpl_mix_id() {
        return smpl_mix_id;
    }

    public void setSmpl_mix_id(String smpl_mix_id) {
        this.smpl_mix_id = smpl_mix_id;
    }

    public String getProdr_supp_cd() {
        return prodr_supp_cd;
    }

    public void setProdr_supp_cd(String prodr_supp_cd) {
        this.prodr_supp_cd = prodr_supp_cd;
    }

    public String getAuth_by_cms_uid() {
        return auth_by_cms_uid;
    }

    public void setAuth_by_cms_uid(String auth_by_cms_uid) {
        this.auth_by_cms_uid = auth_by_cms_uid;
    }

    public String getSmpl_t() {
        return smpl_t;
    }

    public void setSmpl_t(String smpl_t) {
        this.smpl_t = smpl_t;
    }

    public String getSmpl_dt() {
        return smpl_dt;
    }

    public void setSmpl_dt(String smpl_dt) {
        this.smpl_dt = smpl_dt;
    }

    public String getLog_dt() {
        return log_dt;
    }

    public void setLog_dt(String log_dt) {
        this.log_dt = log_dt;
    }

    public String getAuth_dt() {
        return auth_dt;
    }

    public void setAuth_dt(String auth_dt) {
        this.auth_dt = auth_dt;
    }

    public String getStat_t() {
        return stat_t;
    }

    public void setStat_t(String stat_t) {
        this.stat_t = stat_t;
    }

    public String getQryatser_subslump_tst_fld_lbl() {
        return qryatser_subslump_tst_fld_lbl;
    }

    public void setQryatser_subslump_tst_fld_lbl(String qryatser_subslump_tst_fld_lbl) {
        this.qryatser_subslump_tst_fld_lbl = qryatser_subslump_tst_fld_lbl;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getQryatser_subair_tst_fld_lbl() {
        return qryatser_subair_tst_fld_lbl;
    }

    public void setQryatser_subair_tst_fld_lbl(String qryatser_subair_tst_fld_lbl) {
        this.qryatser_subair_tst_fld_lbl = qryatser_subair_tst_fld_lbl;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
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
