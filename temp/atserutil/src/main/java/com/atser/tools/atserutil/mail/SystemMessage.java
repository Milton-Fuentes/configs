/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.mail;

import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanDeserialize;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author droldan
 */
public class SystemMessage implements Serializable {

    private String refId;
    private String functionality;
    private BigInteger catgId;
    private BigInteger projectId;
    private String projectType;
    protected String to[];
    protected String cc[];
    private List<BigInteger> userList;
    private String subject;
    private String messageText;
    private String senderInfo;
    private Boolean isSmsActive;

    public SystemMessage() {
    }

    public SystemMessage(String refId, String functionality, String[] to, String[] cc, String subject, String messageText, LinkedHashMap senderInfo, Boolean isSmsActive) {
        this.refId = refId;
        this.functionality = functionality;
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.messageText = messageText;
        try {
            this.senderInfo = AtserLinkedHashMap.toJsonString(senderInfo);
        } catch (JsonProcessingException ex) {
            this.senderInfo = "{}";
        }
        this.isSmsActive = isSmsActive;
    }

    public SystemMessage(String refId, String functionality, String[] to, String[] cc, String subject, String messageText, String senderInfo, Boolean isSmsActive) {
        this.refId = refId;
        this.functionality = functionality;
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.messageText = messageText;
        this.senderInfo = senderInfo;
        this.isSmsActive = isSmsActive;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public BigInteger getCatgId() {
        return catgId;
    }

    public void setCatgId(BigInteger catgId) {
        this.catgId = catgId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    
    public List<BigInteger> getUserList() {
        return userList;
    }

    public void setUserList(List<BigInteger> userList) {
        this.userList = userList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(String senderInfo) {
        this.senderInfo = senderInfo;
    }

    public void setSenderInfo(LinkedHashMap senderInfo) {
        try {
            this.senderInfo = AtserLinkedHashMap.toJsonString(senderInfo);
        } catch (JsonProcessingException ex) {
            this.senderInfo = "{}";
        }
    }

    @JsonDeserialize(using = JsonBooleanDeserialize.class)
    public Boolean getIsSmsActive() {
        return isSmsActive;
    }

    public void setIsSmsActive(Boolean isSmsActive) {
        this.isSmsActive = isSmsActive;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

}
