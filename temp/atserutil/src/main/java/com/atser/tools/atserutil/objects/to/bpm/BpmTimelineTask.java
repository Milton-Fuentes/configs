/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.bpm;

/**
 *
 * @author droldan
 */
public class BpmTimelineTask {

    private Boolean isReverse;
    private String taskTitle;
    private String taskDate;
    private String taskExecutedBy;
    private String taskExecutorJobTitle;
    private String taskStatus;

    public BpmTimelineTask(Boolean isReverse, String taskTitle, String taskDate, String taskExecutedBy, String taskExecutorJobTitle, String taskStatus) {
        this.isReverse = isReverse;
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskExecutedBy = taskExecutedBy;
        this.taskExecutorJobTitle = taskExecutorJobTitle;
        this.taskStatus = taskStatus;
    }
    
    public Boolean getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(Boolean isReverse) {
        this.isReverse = isReverse;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskExecutedBy() {
        return taskExecutedBy;
    }

    public void setTaskExecutedBy(String taskExecutedBy) {
        this.taskExecutedBy = taskExecutedBy;
    }

    public String getTaskExecutorJobTitle() {
        return taskExecutorJobTitle;
    }

    public void setTaskExecutorJobTitle(String taskExecutorJobTitle) {
        this.taskExecutorJobTitle = taskExecutorJobTitle;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "BpmTimelineTask{" + "isReverse=" + isReverse + ", taskTitle=" + taskTitle + ", taskDate=" + taskDate + ", taskExecutedBy=" + taskExecutedBy + ", taskExecutorJobTitle=" + taskExecutorJobTitle + ", taskStatus=" + taskStatus + '}';
    }
}
