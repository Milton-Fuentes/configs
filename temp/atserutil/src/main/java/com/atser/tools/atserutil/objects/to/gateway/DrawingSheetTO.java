/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.gateway;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author droldan
 */
public class DrawingSheetTO {
    
    private String sheetNo;
    private String groupName;
    private String catg;
    private String sheetTitle;
    private String subGroupName;
    private String omitted;
    private String ifcRev;
    private String sheetRev;
    private String ndcNo;
    @JsonIgnore
    private String clientId;
    @JsonIgnore
    private String projectId;
    @JsonIgnore
    private String pkgId;
    private String pkgName;
    @JsonIgnore
    private String sheetId;
    private String lastMod;
    private String sheetLink;

    public DrawingSheetTO() {
    }

    public String getSheetNo() {
        return sheetNo;
    }

    public void setSheetNo(String sheetNo) {
        this.sheetNo = sheetNo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    public String getOmitted() {
        return omitted;
    }

    public void setOmitted(String omitted) {
        this.omitted = omitted;
    }

    public String getIfcRev() {
        return ifcRev;
    }

    public void setIfcRev(String ifcRev) {
        this.ifcRev = ifcRev;
    }

    public String getSheetRev() {
        return sheetRev;
    }

    public void setSheetRev(String sheetRev) {
        this.sheetRev = sheetRev;
    }

    public String getNdcNo() {
        return ndcNo;
    }

    public void setNdcNo(String ndcNo) {
        this.ndcNo = ndcNo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getSheetLink() {
        return sheetLink;
    }

    public void setSheetLink(String sheetLink) {
        this.sheetLink = sheetLink;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }
    
    public void buildSheetLink(String baseLink) {
        StringBuilder link = new StringBuilder();
        link.append(baseLink);
        link.append("client_id=").append(this.clientId).append("&");
        link.append("project_id=").append(this.projectId).append("&");
        link.append("pkg_id=").append(this.pkgId).append("&");
        link.append("sheet_id=").append(this.sheetId).append("&");
        link.append("sheet_no=").append(this.sheetNo);
        this.sheetLink = link.toString();
    }
}
