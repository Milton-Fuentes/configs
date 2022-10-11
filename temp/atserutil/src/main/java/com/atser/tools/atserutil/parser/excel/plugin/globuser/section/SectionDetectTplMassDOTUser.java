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

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 3, end = 3)
public class SectionDetectTplMassDOTUser {

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
    private String functionalTitle;
    @ExcelField(position = 10)
    private String hrTitle;
    @ExcelField(position = 11)
    private String unitCode;
    @ExcelField(position = 12)
    private String unitDescription;
    @ExcelField(position = 13)
    private String address;
    @ExcelField(position = 14)
    private String city;
    @ExcelField(position = 15)
    private String country;
    @ExcelField(position = 16)
    private String state;
    @ExcelField(position = 17)
    private String zip;
    @ExcelField(position = 18)
    private String workPhone;
    @ExcelField(position = 19)
    private String cellPhone;
    @ExcelField(position = 20)
    private String fax;
    @ExcelField(position = 21)
    private String companyName;
    @ExcelField(position = 22)
    private String companyWebSite;
    @ExcelField(position = 23)
    private String designatedLaboratory;
    @ExcelField(position = 24)
    private String printedSignatureLegalName;

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

    public String getFunctionalTitle() {
        return functionalTitle;
    }

    public void setFunctionalTitle(String functionalTitle) {
        this.functionalTitle = functionalTitle;
    }

    public String getHrTitle() {
        return hrTitle;
    }

    public void setHrTitle(String hrTitle) {
        this.hrTitle = hrTitle;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyWebSite() {
        return companyWebSite;
    }

    public void setCompanyWebSite(String companyWebSite) {
        this.companyWebSite = companyWebSite;
    }

    public String getDesignatedLaboratory() {
        return designatedLaboratory;
    }

    public void setDesignatedLaboratory(String designatedLaboratory) {
        this.designatedLaboratory = designatedLaboratory;
    }

    public String getPrintedSignatureLegalName() {
        return printedSignatureLegalName;
    }

    public void setPrintedSignatureLegalName(String printedSignatureLegalName) {
        this.printedSignatureLegalName = printedSignatureLegalName;
    }
    
    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        for(Field it : this.getClass().getDeclaredFields()) {
            if(it.get(this) == null) {
                return Boolean.FALSE;
            } else if(!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
