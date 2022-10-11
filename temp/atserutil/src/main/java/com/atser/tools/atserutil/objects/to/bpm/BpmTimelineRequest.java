/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.bpm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class BpmTimelineRequest {

    private String procRequestedBy;
    private String procRequestorJobTitle;
    private String procRequestedDate;
    private List<BpmTimelineTask> tasks;

    public BpmTimelineRequest() {
        this.procRequestedBy = "";
        this.procRequestedDate = "";
        this.procRequestorJobTitle = "";
        this.tasks = new ArrayList<>();
    }

    public BpmTimelineRequest(String procRequestedBy, String procRequestedDate, List<BpmTimelineTask> tasks) {
        this.procRequestedBy = procRequestedBy;
        this.procRequestedDate = procRequestedDate;
        this.procRequestorJobTitle = "";
        this.tasks = tasks;
    }

    public BpmTimelineRequest(String procRequestedBy, String procRequestorJobTitle, String procRequestedDate, List<BpmTimelineTask> tasks) {
        this.procRequestedBy = procRequestedBy;
        this.procRequestorJobTitle = procRequestorJobTitle;
        this.procRequestedDate = procRequestedDate;
        this.tasks = tasks;
    }

    public String getProcRequestorJobTitle() {
        return procRequestorJobTitle;
    }

    public void setProcRequestorJobTitle(String procRequestorJobTitle) {
        this.procRequestorJobTitle = procRequestorJobTitle;
    }

    public String getProcRequestedBy() {
        return procRequestedBy;
    }

    public void setProcRequestedBy(String procRequestedBy) {
        this.procRequestedBy = procRequestedBy;
    }

    public String getProcRequestedDate() {
        return procRequestedDate;
    }

    public void setProcRequestedDate(String procRequestedDate) {
        this.procRequestedDate = procRequestedDate;
    }

    public List<BpmTimelineTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<BpmTimelineTask> tasks) {
        this.tasks = tasks;
    }
}
