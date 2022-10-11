/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser.section;

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
@ExcelObject(parseType = ParseType.ROW, start = 4, end = 1000)
public class SectionUserInformation {

    @ExcelField(position = 1)
    private String userId;
    @ExcelField(position = 2)
    private String module;
    @ExcelField(position = 3)
    private String role;
    @ExcelField(position = 4)
    private String firstName;
    @ExcelField(position = 5)
    private String middleInitial;
    @ExcelField(position = 6)
    private String lastName;
    @ExcelField(position = 7)
    private String email;
    @ExcelField(position = 8)
    private String suffix;
    @ExcelField(position = 9)
    private String hrTitle;
    @ExcelField(position = 10)
    private String functionalTitle;
    @ExcelField(position = 11)
    private String firm;
    @ExcelField(position = 12)
    private String unitCode;
    @ExcelField(position = 13)
    private String address;
    @ExcelField(position = 14)
    private String city;
    @ExcelField(position = 15)
    private String state;
    @ExcelField(position = 16)
    private String country;
    @ExcelField(position = 17)
    private String zip;
    @ExcelField(position = 18)
    private String workPhone;
    @ExcelField(position = 19)
    private String cellPhone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getHrTitle() {
        return hrTitle;
    }

    public void setHrTitle(String hrTitle) {
        this.hrTitle = hrTitle;
    }

    public String getFunctionalTitle() {
        return functionalTitle;
    }

    public void setFunctionalTitle(String functionalTitle) {
        this.functionalTitle = functionalTitle;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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
