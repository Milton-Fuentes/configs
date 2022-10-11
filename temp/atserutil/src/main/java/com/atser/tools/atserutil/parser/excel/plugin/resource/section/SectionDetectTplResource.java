/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 2, end = 2)
public class SectionDetectTplResource {

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

    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        for (Field it : this.getClass().getDeclaredFields()) {
            if (it.get(this) == null) {
                return Boolean.FALSE;
            } else if (!it.getName().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
