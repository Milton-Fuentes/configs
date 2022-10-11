/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier.model;

import com.atser.tools.atserutil.parser.excel.plugin.supplier.section.SectionNysDOTSupplier;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author droldan
 */
public class SupplierDef implements Serializable {
    
    @Expose
    private String supplier; 
    @Expose
    private String service;
    @Expose
    private String contactName;   
    @Expose
    private String contactTitle;   
    @Expose
    private String address;   
    @Expose
    private String city;  
    @Expose
    private String state;   
    @Expose
    private String zip;    
    @Expose
    private String phone;   
    @Expose
    private String cell;   
    @Expose
    private String fax;   
    @Expose
    private String email;
    @Expose
    private Character active; 
    @Expose
    private String lastMod;  
    @Expose
    private String lastModBy; 
    @Expose
    private String lastModIp;  
    @Expose
    private Date createDate;  
    @Expose
    private String createBy;   
    @Expose
    private String createByIp;
    @Expose
    private Character enabled;
    @Expose
    private Date dueDate;    
    @Expose
    private String location;    
    @Expose
    private String impCode;    
    @Expose
    private String impVendorId;

    public SupplierDef() {
    }

    public SupplierDef(final SectionNysDOTSupplier elem) {
        this.supplier = elem.getProdrSuppNm();
        this.service = elem.getProdrSuppT();
        this.address = elem.getLocDesc1();
        this.active = StringSupport.getActiveAsCharacter(elem.getActvtyStatT());
        this.location = elem.getLocT();
        this.impVendorId = elem.getVendId();
        this.impCode = elem.getProdrSuppCd();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImpCode() {
        return impCode;
    }

    public void setImpCode(String impCode) {
        this.impCode = impCode;
    }

    public String getImpVendorId() {
        return impVendorId;
    }

    public void setImpVendorId(String impVendorId) {
        this.impVendorId = impVendorId;
    }    

}
