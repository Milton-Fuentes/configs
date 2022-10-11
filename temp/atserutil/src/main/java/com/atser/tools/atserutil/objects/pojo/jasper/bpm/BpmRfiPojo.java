/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.bpm;

/**
 *
 * @author dperez
 */
public class BpmRfiPojo {
    String number; 
    String revision; 
    String title; 
    String impact; 
    String priority; 
    String status; 
    String currentTask; 
    String currentResponsable; 
    String receivedDate; 
    String createdDate; 
    String completedDate; 
    String responseRequiredDate; 
    String finalDisposition;
    String source;
    

    public BpmRfiPojo() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public String getCurrentResponsable() {
        return currentResponsable;
    }

    public void setCurrentResponsable(String currentResponsable) {
        this.currentResponsable = currentResponsable;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getResponseRequiredDate() {
        return responseRequiredDate;
    }

    public void setResponseRequiredDate(String responseRequiredDate) {
        this.responseRequiredDate = responseRequiredDate;
    }

    public String getFinalDisposition() {
        return finalDisposition;
    }

    public void setFinalDisposition(String finalDisposition) {
        this.finalDisposition = finalDisposition;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
