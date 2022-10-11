/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.model;

import com.atser.tools.atserutil.date.CalendarSupport;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.resource.section.SectionGanttResource;
import com.atser.tools.atserutil.parser.excel.plugin.task.section.SectionGanttTask;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public class GModel implements Serializable {

    @Expose
    private List<GTask> model;
    @Expose
    private List<GResource> resources;
    @Expose
    private Map<String, String> parameters;

    public GModel() {
        this.model = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.parameters = new LinkedHashMap<>();
    }

    public List<GResource> getResources() {
        return resources;
    }

    public void setResources(List<GResource> resources) {
        this.resources = resources;
    }

    public List<GTask> getModel() {
        return model;
    }

    public void setModel(List<GTask> model) {
        this.model = model;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public void addResource(SectionGanttResource rs) {
        if (rs != null) {
            this.resources.add(new GResource(rs.getCode(), rs.getFirstname() + " " + rs.getLastname() + " [ " + rs.getTitle() + " ] "));
        }
    }

    public void buildParamsForDates() {
        for (GTask gTask : model) {
            if (!parameters.containsKey("scheduleStartDate")) {
                parameters.put("scheduleStartDate", DateSupport.formatUS(gTask.getStartDate()));
            }
            parameters.put("scheduleEndDate", DateSupport.formatUS(DateSupport.addChronoUnitToDate(gTask.getEndDate(), ChronoUnit.DAYS, 365)));
        }
    }

    public void addTask(SectionGanttTask et) throws ExcelParsingException {
        /* Predecesor Details
        Start to Start (SS) - You cannot start a task until the other task also starts.
        Start to Finish (SF) - You cannot finish a task until the other task finishes.
        Finish to Start (FS) - You cannot start a task until the other task completes.
        Finish to Finish (FF) - You cannot finish a task until the other task completes.*/
        GTask node = new GTask();
        node.setTaskID(et.getId());
        node.setTaskName(et.getDescription());
        if (et.getDuration() != null && !et.getDuration().isEmpty()) {
            String[] arrayDuration = et.getDuration().split(" ");
            switch (arrayDuration.length) {
                case 2: {
                    Double duration = Double.parseDouble(arrayDuration[0]);
                    String unitDuration = CalendarSupport.getTypeDurationUnit(duration, arrayDuration[1]);
                    node.setDuration(duration);
                    node.setDurationUnit(unitDuration);
                    break;
                }
                case 1: {
                    Double duration = Double.parseDouble(arrayDuration[0]);
                    node.setDuration(duration);
                    node.setDurationUnit(CalendarSupport.getTypeDurationUnit(duration, "day"));
                    break;
                }
                default:
                    throw new ExcelParsingException("Wrong duration format.");
            }
        } else {
            node.setDuration(0.0);
            node.setDurationUnit("days");
        }

        if (et.getStart() == null) {
            throw new ExcelParsingException("Wrong Start Date format or null.");
        }
        node.setStartDate(et.getStart());
        node.setBaselineStartDate(node.getStartDate());
        if (!parameters.containsKey("scheduleStartDate")) {
            parameters.put("scheduleStartDate", DateSupport.formatUS(node.getStartDate()));
        }
        node.setEndDate(CalendarSupport.sumByUnitAtDate(node.getStartDate(), CalendarSupport.getCalendarDurationUnit(node.getDurationUnit()), node.getDuration().intValue()));
        node.setBaselineEndDate(node.getEndDate());
        parameters.put("scheduleEndDate", DateSupport.formatUS(DateSupport.addChronoUnitToDate(node.getEndDate(), ChronoUnit.DAYS, 365)));
        node.setProgress((et.getProgress() != null) ? NumberSupport.parseDoubleToPercentage(et.getProgress()) : null);
        node.setPredecessor((et.getLink() != null && !et.getLink().isEmpty()) ? et.getLink() : null);
        node.setParent((et.getParent() != null) ? et.getParent().toString() : null);
        if (et.getAssigned() != null && !et.getAssigned().isEmpty()) {
            String[] strArray = et.getAssigned().split(",");
            List<String> resc = new ArrayList<>();
            for (String strArray1 : strArray) {
                resc.add(strArray1.replaceAll("^\\s*", ""));
            }
            if (!resc.isEmpty()) {
                node.setResourceInfo(resc);
            }
        }
        node.setCost((et.getCost() != null && !et.getCost().isEmpty()) ? ("$ " + et.getCost()) : null);
        addTask(node);
    }

    private void addTask(GTask task) {
        if (task.getParent() == null) {
            model.add(task);
        } else {
            for (GTask gTask : model) {
                Boolean result = gTask.addSubTask(task);
                if (result) {
                    break;
                }
            }
        }
    }
}
