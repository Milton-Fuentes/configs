/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author droldan
 */
public class GTask implements Serializable {

    @Expose
    private Long taskID;
    @Expose
    private String taskName;
    @Expose
    private Date startDate;
    @Expose
    private Date endDate;
    @Expose
    private Date baselineStartDate;
    @Expose
    private Date baselineEndDate;
    @Expose
    private Double duration;
    @Expose
    private String durationUnit;
    @Expose
    private String progress;
    @Expose
    private List<String> resourceInfo;
    @Expose(serialize = false)
    private String parent;
    @Expose
    private String predecessor;
    @Expose
    private List<GTask> subtasks;
    @Expose
    private String cost;
    @Expose
    private String notesContent;
    @Expose
    private String taskType;
    @Expose
    private Boolean effortDriven;

    public GTask() {
        this.taskID = null;
        this.taskName = null;
        this.startDate = null;
        this.endDate = null;
        this.baselineStartDate = null;
        this.baselineEndDate = null;
        this.duration = null;
        this.durationUnit = null;
        this.progress = "0";
        this.resourceInfo = null;
        this.predecessor = null;
        this.subtasks = null;
        this.parent = null;
        this.cost = null;
        this.notesContent = null;
        this.taskType = null;
        this.effortDriven = null;
    }

    public void GTask(GTask node) {
        this.taskID = node.taskID;
        this.taskName = node.taskName;
        this.startDate = node.startDate;
        this.endDate = node.endDate;
        this.baselineStartDate = node.baselineStartDate;
        this.baselineEndDate = node.baselineEndDate;
        this.duration = node.duration;
        this.durationUnit = node.durationUnit;
        this.progress = node.progress;
        this.resourceInfo = node.resourceInfo;
        this.predecessor = node.predecessor;
        this.subtasks = node.subtasks;
        this.parent = node.parent;
        this.cost = node.cost;
        this.notesContent = node.notesContent;
        this.taskType = node.notesContent;
        this.effortDriven = node.effortDriven;
    }

    public Date getBaselineStartDate() {
        return baselineStartDate;
    }

    public void setBaselineStartDate(Date baselineStartDate) {
        this.baselineStartDate = baselineStartDate;
    }

    public Date getBaselineEndDate() {
        return baselineEndDate;
    }

    public void setBaselineEndDate(Date baselineEndDate) {
        this.baselineEndDate = baselineEndDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Boolean getEffortDriven() {
        return effortDriven;
    }

    public void setEffortDriven(Boolean effortDriven) {
        this.effortDriven = effortDriven;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }
    
    public String getNotesContent() {
        return notesContent;
    }

    public void setNotesContent(String notesContent) {
        this.notesContent = notesContent;
    }
    
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    
    public Boolean addSubTask(GTask node) {
        return recursiveAddNode(this, node);
    }

    private Boolean recursiveAddNode(GTask parent, GTask node) {
        if (parent.taskID == node.getParentToLong()) {
            this.addNode(parent, node);
            return Boolean.TRUE;
        }
        
        if(parent.isLeaf()) {
            return Boolean.FALSE;
        }
        
        for (GTask task: parent.getSubtasks()) {
            Boolean r = recursiveAddNode(task, node);
            if(r) {
                return r;
            }
        }
        return Boolean.FALSE;
    }

    private void addNode(GTask parent, GTask node) {
        if (parent.isLeaf()) {
            parent.initSubTasksAndAdd(node);
        } else {
            parent.getSubtasks().add(node);
        }
    }

    private Boolean isLeaf() {
        return (this.getSubtasks() == null || this.subtasks.isEmpty());
    }

    private Integer grade() {
        return this.subtasks.size();
    }

    private void initSubTasksAndAdd(GTask node) {
        this.subtasks = new ArrayList<>();
        this.subtasks.add(node);
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public List<String> getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(List<String> resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<GTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<GTask> subtasks) {
        this.subtasks = subtasks;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

     public Long getParentToLong() {
        return Long.valueOf(getParent());
    }

   
}
