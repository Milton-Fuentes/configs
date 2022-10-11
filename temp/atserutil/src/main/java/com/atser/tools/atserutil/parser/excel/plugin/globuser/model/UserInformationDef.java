/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class UserInformationDef implements Serializable {

    @Expose
    private String userId;
    @Expose
    private String module;
    @Expose
    private String role;
    @Expose
    private String firstName;
    @Expose
    private String middleInitial;
    @Expose
    private String lastName;
    @Expose
    private String email;
    @Expose
    private String suffix;
    @Expose
    private String functionalTitle;
    @Expose
    private String hrTitle;
    @Expose
    private String firm;
    @Expose
    private String unitCode;
    @Expose
    private String unitDescription;
    @Expose
    private String address;
    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private String state;
    @Expose
    private String zip;
    @Expose
    private String workPhone;
    @Expose
    private String cellPhone;
    @Expose
    private String fax;
    @Expose
    private String companyName;
    @Expose
    private String companyWebSite;
    @Expose
    private String designatedLab;
    @Expose
    private String printedSign;
    @Expose
    private String status;

    public UserInformationDef() {
        this.status = "PENDING";
    }

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

    public String getDesignatedLab() {
        return designatedLab;
    }

    public void setDesignatedLab(String designatedLab) {
        this.designatedLab = designatedLab;
    }

    public String getPrintedSign() {
        return printedSign;
    }

    public void setPrintedSign(String printedSign) {
        this.printedSign = printedSign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
