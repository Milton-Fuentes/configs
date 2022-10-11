/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.mail;

/**
 *
 * @author droldan
 */
public class BpmMailMessage extends MailMessage {

    private String refId;
    private String status;
    private String token;

    public BpmMailMessage() {
        super();
        this.refId = null;
        this.status = null;
        this.token = null;
    }

    public BpmMailMessage(String subject, String[] to, String from, String messageText, String refId, String status, String token) {
        super(subject, to, from, messageText);
        this.refId = refId;
        this.status = status;
        this.token = token;
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

    
    @Override
    public String toString() {
        return "BpmMailMessage{" + "refId=" + refId + ", status=" + status + ", token=" + token + '}';
    }
    
}
