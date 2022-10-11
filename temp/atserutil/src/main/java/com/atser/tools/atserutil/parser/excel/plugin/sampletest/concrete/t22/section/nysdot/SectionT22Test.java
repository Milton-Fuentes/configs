/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.section.nysdot;

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
public class SectionT22Test {

    @ExcelField(position = 1)
    private String cont_id;
    @ExcelField(position = 2)
    private String smpasmpl;
    @ExcelField(position = 3)
    private String sampledby;
    @ExcelField(position = 4)
    private String sampledate;
    @ExcelField(position = 5)
    private String cylssmpl;
    @ExcelField(position = 6)
    private String smpl_mix_id;
    @ExcelField(position = 7)
    private String matl_cd;
    @ExcelField(position = 8)
    private String breakdate;
    @ExcelField(position = 9)
    private String age;
    @ExcelField(position = 10)
    private String dh;
    @ExcelField(position = 11)
    private String avestr;
    @ExcelField(position = 12)
    private String minspec;
    @ExcelField(position = 13)
    private String io;
    @ExcelField(position = 14)
    private String itm_cd;
    @ExcelField(position = 15)
    private String ln_itm_nbr;
    @ExcelField(position = 16)
    private String desc1;
    @ExcelField(position = 17)
    private String qty_instl_to_dt;
    @ExcelField(position = 18)
    private String location;

    public String getCont_id() {
        return cont_id;
    }

    public void setCont_id(String cont_id) {
        this.cont_id = cont_id;
    }

    public String getSmpasmpl() {
        return smpasmpl;
    }

    public void setSmpasmpl(String smpasmpl) {
        this.smpasmpl = smpasmpl;
    }

    public String getSampledby() {
        return sampledby;
    }

    public void setSampledby(String sampledby) {
        this.sampledby = sampledby;
    }

    public String getSampledate() {
        return sampledate;
    }

    public void setSampledate(String sampledate) {
        this.sampledate = sampledate;
    }

    public String getCylssmpl() {
        return cylssmpl;
    }

    public void setCylssmpl(String cylssmpl) {
        this.cylssmpl = cylssmpl;
    }

    public String getSmpl_mix_id() {
        return smpl_mix_id;
    }

    public void setSmpl_mix_id(String smpl_mix_id) {
        this.smpl_mix_id = smpl_mix_id;
    }

    public String getMatl_cd() {
        return matl_cd;
    }

    public void setMatl_cd(String matl_cd) {
        this.matl_cd = matl_cd;
    }

    public String getBreakdate() {
        return breakdate;
    }

    public void setBreakdate(String breakdate) {
        this.breakdate = breakdate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getAvestr() {
        return avestr;
    }

    public void setAvestr(String avestr) {
        this.avestr = avestr;
    }

    public String getMinspec() {
        return minspec;
    }

    public void setMinspec(String minspec) {
        this.minspec = minspec;
    }

    public String getIo() {
        return io;
    }

    public void setIo(String io) {
        this.io = io;
    }

    public String getItm_cd() {
        return itm_cd;
    }

    public void setItm_cd(String itm_cd) {
        this.itm_cd = itm_cd;
    }

    public String getLn_itm_nbr() {
        return ln_itm_nbr;
    }

    public void setLn_itm_nbr(String ln_itm_nbr) {
        this.ln_itm_nbr = ln_itm_nbr;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getQty_instl_to_dt() {
        return qty_instl_to_dt;
    }

    public void setQty_instl_to_dt(String qty_instl_to_dt) {
        this.qty_instl_to_dt = qty_instl_to_dt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
