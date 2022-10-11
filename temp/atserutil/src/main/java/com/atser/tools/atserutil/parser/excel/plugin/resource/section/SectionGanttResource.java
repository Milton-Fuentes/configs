/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 3, end = 10000)
public class SectionGanttResource {

    @ExcelField(position = 1)
    private String code;
    @ExcelField(position = 2)
    private String firstname;
    @ExcelField(position = 3)
    private String lastname;
    @ExcelField(position = 4)
    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
