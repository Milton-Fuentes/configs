/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.mail;

import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class SystemMailMessage extends MailMessage {

    private String refId;
    private String status;
    private String token;
    private BigInteger projectId;
    private BigInteger clientId;
    private BigInteger categoryId;
    private String senderInfo;

    public SystemMailMessage() {
        super();
        this.refId = null;
        this.status = null;
        this.token = null;
    }

    public SystemMailMessage(String subject, String[] to, String from, String messageText, String refId, String status, String token, BigInteger clientId, BigInteger projectId, BigInteger catId) {
        super(subject, to, from, messageText);
        this.refId = refId;
        this.status = status;
        this.token = token;
        this.clientId = clientId;
        this.projectId = projectId;
        this.categoryId = catId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(String senderInfo) {
        this.senderInfo = senderInfo;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }
}
