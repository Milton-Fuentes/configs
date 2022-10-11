/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.objects.bo;

import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.string.StringSupport;

/**
 *
 * @author droldan
 */
public class FileDocumentBO {
    
    private String id;    
    private String fDate;
    private String extension;
    private String sourcePath;
    private String owner;
    private String fTitle;
    private String fName;
    private String serverPath;
    private String projectId;
    private String sourceName;
    private String keywords;
    private String fSize;
    private String version;
    private String fileStatus;
    private String dcn;
    private String systemKeywords;
    private String fFrom;
    private String fTo;
    private String contractId;
    private String uploaded;
    private String active;
    private String fDateTmp;
    private String folderId;
    private String downloadUrl;

    public FileDocumentBO(GlobFile src, String baseUrl) {
        this.id = StringSupport.emptyOnNull(src.getId());
        this.fDate = DateSupport.formatUS(src.getFDate());
        this.extension = src.getExtension();
        this.sourcePath = src.getSourcePath();
        this.owner = StringSupport.emptyOnNull(src.getOwner());
        this.fTitle = src.getFTitle();
        this.fName = src.getFName();
        this.serverPath = src.getServerPath();
        this.projectId = StringSupport.emptyOnNull(src.getProjectId());
        this.sourceName = src.getSourceName();
        this.keywords = src.getKeywords();
        this.fSize = StringSupport.emptyOnNull(src.getFSize());
        this.version = StringSupport.emptyOnNull(src.getVersion());
        this.fileStatus = src.getFileStatus();
        this.dcn = src.getDcn();
        this.systemKeywords = src.getSystemKeywords();
        this.fFrom = src.getFFrom();
        this.fTo = src.getFTo();
        this.contractId = StringSupport.emptyOnNull(src.getContractId());
        this.uploaded = DateSupport.formatUS(src.getUploaded());
        this.active = StringSupport.emptyOnNull(src.getActive());
        this.fDateTmp = src.getFDateTmp();
        this.folderId = StringSupport.emptyOnNull(src.getFolderId().getId());
        this.downloadUrl = baseUrl + src.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfDate() {
        return fDate;
    }

    public void setfDate(String fDate) {
        this.fDate = fDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getfSize() {
        return fSize;
    }

    public void setfSize(String fSize) {
        this.fSize = fSize;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getDcn() {
        return dcn;
    }

    public void setDcn(String dcn) {
        this.dcn = dcn;
    }

    public String getSystemKeywords() {
        return systemKeywords;
    }

    public void setSystemKeywords(String systemKeywords) {
        this.systemKeywords = systemKeywords;
    }

    public String getfFrom() {
        return fFrom;
    }

    public void setfFrom(String fFrom) {
        this.fFrom = fFrom;
    }

    public String getfTo() {
        return fTo;
    }

    public void setfTo(String fTo) {
        this.fTo = fTo;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getUploaded() {
        return uploaded;
    }

    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getfDateTmp() {
        return fDateTmp;
    }

    public void setfDateTmp(String fDateTmp) {
        this.fDateTmp = fDateTmp;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

        
}
