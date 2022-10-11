/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.mail;

import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class MailMessage implements Serializable {

    protected String subject;
    protected String to[];
    protected String cc[];
    protected String from;
    protected String messageText;
    protected String attContentType;
    protected String attText;
    protected String attFileName;

    public MailMessage(String subject, String[] to, String from, String messageText, String attContentType, String attText, String attFileName) {
        this.subject = subject;
        this.to = to;
        this.cc = null;
        this.from = from;
        this.messageText = messageText;
        this.attContentType = attContentType;
        this.attText = attText;
        this.attFileName = attFileName;
    }

    public MailMessage(String subject, String[] to, String[] cc, String from, String messageText, String attContentType, String attText, String attFileName) {
        this.subject = subject;
        this.to = to;
        this.cc = cc;
        this.from = from;
        this.messageText = messageText;
        this.attContentType = attContentType;
        this.attText = attText;
        this.attFileName = attFileName;
    }

    public MailMessage() {
        this.subject = null;
        this.to = null;
        this.cc = null;
        this.from = null;
        this.messageText = null;
        this.attContentType = null;
        this.attText = null;
        this.attFileName = null;
    }

    public MailMessage(String subject, String[] to, String from, String messageText) {
        this.subject = subject;
        this.to = to;
        this.from = from;
        this.messageText = messageText;
    }
    
     public MailMessage(String subject, String[] to, String[] cc, String from, String messageText) {
        this.subject = subject;
        this.to = to;
        this.cc = cc;
        this.from = from;
        this.messageText = messageText;
    }

    public MailMessage(String subject, String[] to, String from, String messageText, String attFileName) {
        this.subject = subject;
        this.to = to;
        this.from = from;
        this.messageText = messageText;
        this.attFileName = attFileName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getAttContentType() {
        return attContentType;
    }

    public void setAttContentType(String attContentType) {
        this.attContentType = attContentType;
    }

    public String getAttText() {
        return attText;
    }

    public void setAttText(String attText) {
        this.attText = attText;
    }

    public String getAttFileName() {
        return attFileName;
    }

    public void setAttFileName(String attFileName) {
        this.attFileName = attFileName;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "MailMessage{" + "subject=" + subject + ", to=" + to + ", from=" + from + '}';
    }
}
