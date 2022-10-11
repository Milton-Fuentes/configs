/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import java.util.Date;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 3, end = 10000)
public class SectionGanttTask {
    @ExcelField(position = 1)
    private Long id;
    @ExcelField(position = 2)
    private Long parent;
    @ExcelField(position = 3)
    private String description;
    @ExcelField(position = 4)
    private Date start;
    @ExcelField(position = 5)
    private String duration;
    @ExcelField(position = 6)
    private Double progress;
    @ExcelField(position = 7)
    private String assigned;
    @ExcelField(position = 8)
    private String link;
    @ExcelField(position = 9)
    private String cost;

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
