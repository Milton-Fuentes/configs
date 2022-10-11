/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.calendar;

import com.atser.tools.atserutil.date.LocalDateRange;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.dispatch.EngServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.FieldServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.LabServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 *
 * @author droldan
 */
public class CalendarResourcesDataTO implements Serializable, Cloneable {

    private String id;
    private String subject;
    private String startTime;
    private String endTime;
    private String description;
    private Boolean allDay;
    private String ownerId;
    private String eventStartTimeZone;
    private String eventEndTimeZone;
    private String categorize;
    private String tracNo;
    private String location;
    private String specialInstr;
    private BigInteger projectId;
    private String projectName;
    private String projectNumber;
    private BigInteger infoId;
    private BigInteger regionId;
    private String labName;
    private String siteContact;
    private String sitePhone;
    private String requestedBy;
    private String travelTime;
    private Boolean cancelled;
    private BigDecimal hours;
    private String emailStatus;
    private String regionCatgColorId;
    private String cylinderPickupStatus;
    private String cylinderPickupDate;
    private String isWoCompleted;
    private Integer unanswcount;
    private Integer answcount;
    private Integer submReport;
    private String testNameList;
    private String status;
    private BigInteger materialUseId;
    private String cancelledReason;
    private String recurrence;
    private String recurrenceDates;
    private List<FieldServiceTO> fieldService;
    private List<LabServiceTO> labService;
    private List<EngServiceTO> engService;
    private String certification;

    public CalendarResourcesDataTO(String id, String subject, String description, String startDate, String startTime, String hours, String ownerId, String categorize, String tracNo, String location, String specialInstr) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        try {
            Date tmpStartTime = DateSupport.parseString(startDate + " " + startTime, DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"));
            this.startTime = DateSupport.formatDate(tmpStartTime, DateSupport.FORMAT_HCTRAFULL);
            if (hours != null && !hours.isEmpty()) {
                Double h = Double.valueOf(hours);
                this.endTime = DateSupport.formatDate(DateSupport.addChronoUnitToDate(tmpStartTime, ChronoUnit.HOURS, h.longValue()), DateSupport.FORMAT_HCTRAFULL);
                this.allDay = Boolean.FALSE;
                /*if ((h / 8) >= 1) {
                    this.allDay = Boolean.TRUE;
                } else {
                    this.allDay = Boolean.FALSE;
                }*/
            }
        } catch (ParseException ex) {
            this.startTime = null;
            this.endTime = null;
            this.allDay = Boolean.FALSE;
        }
        this.ownerId = ownerId;
        this.eventStartTimeZone = "UTC -06:00";
        this.eventEndTimeZone = "UTC -06:00";
        this.categorize = categorize;
        this.tracNo = tracNo;
        this.location = location;
        this.specialInstr = specialInstr;
    }
    
    public CalendarResourcesDataTO(WorkOrderTO wo, String ownerId) {
        this.id = StringSupport.getString(wo.getLogId());
        this.subject = "WO # " + wo.getWonumber();
        try {
            Date tmpStartTime = DateSupport.parseString(wo.getServiceDate() + " " + wo.getTimeatsite(), DateSupport.factorySimpleDateFormat("MM/dd/yyyy HH:mm"));
            this.startTime = DateSupport.formatDate(tmpStartTime, DateSupport.FORMAT_HCTRAFULL);
            if (StringSupport.isNotNullAndNotEmpty(wo.getHours())) {
                this.endTime = DateSupport.formatDate(DateSupport.addChronoUnitToDate(tmpStartTime, ChronoUnit.HOURS, wo.getHours().doubleValue()), DateSupport.FORMAT_HCTRAFULL);
                this.allDay = Boolean.FALSE;
            }
        } catch (ParseException ex) {
            this.startTime = null;
            this.endTime = null;
            this.allDay = Boolean.FALSE;
        }
        this.ownerId = ownerId;
        this.eventStartTimeZone = "UTC -06:00";
        this.eventEndTimeZone = "UTC -06:00";
        this.categorize = "1";
        this.tracNo = wo.getTraceDescription();
        this.location = wo.getRlocation();
        this.specialInstr = wo.getSpecialinstruction();
        this.projectId = wo.getProjectId();
        this.projectName = wo.getProjectName();
        this.projectNumber = wo.getProjectNumber();
        this.infoId = wo.getInfo_id();
        this.labName = wo.getLabName();
        this.siteContact = wo.getContactperson();
        this.sitePhone = wo.getContacttelephone();
        this.requestedBy = wo.getRequestedBy();
        this.hours = wo.getHours();
        this.fieldService = wo.getFieldService();
        this.labService = wo.getLabService();
        this.engService = wo.getEngService();
        this.regionId = wo.getRegionId();
        this.travelTime = wo.getTravelTime();
        this.description = wo.getServiceList();
        this.cancelled = wo.getIscancel();
        this.emailStatus = wo.getEmailStatus();
        this.regionCatgColorId = StringSupport.getString(wo.getRegionCatgColorId());
        this.isWoCompleted = wo.getIsWoCompleted();
        this.unanswcount = wo.getUnanswcount();
        this.answcount = wo.getAnswcount();
        this.submReport = wo.getSubmReport();
        this.testNameList = wo.getTestNameList();
        this.materialUseId = wo.getMaterialUseId();
        this.status = wo.getStatus();
        this.cancelledReason = wo.getCancelledReason();
        this.certification = wo.getCertification();
    }

    public CalendarResourcesDataTO() {
        this.id = null;
        this.subject = null;
        this.startTime = null;
        this.endTime = null;
        this.description = null;
        this.allDay = null;
        this.ownerId = null;
        this.eventStartTimeZone = "UTC -06:00";
        this.eventEndTimeZone = "UTC -06:00";
        this.categorize = null;
        this.tracNo = null;
        this.location = null;
        this.specialInstr = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEventStartTimeZone() {
        return eventStartTimeZone;
    }

    public void setEventStartTimeZone(String eventStartTimeZone) {
        this.eventStartTimeZone = eventStartTimeZone;
    }

    public String getEventEndTimeZone() {
        return eventEndTimeZone;
    }

    public void setEventEndTimeZone(String eventEndTimeZone) {
        this.eventEndTimeZone = eventEndTimeZone;
    }

    public String getCategorize() {
        return categorize;
    }

    public void setCategorize(String categorize) {
        this.categorize = categorize;
    }

    public String getTracNo() {
        return tracNo;
    }

    public void setTracNo(String tracNo) {
        this.tracNo = tracNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isTheSameDate(LocalDate cdate) {
        try {
            return DateSupport.convertToLocalDate(DateSupport.parseString(getStartTime(), DateSupport.FORMAT_HCTRAFULL)).isEqual(cdate);
        } catch (ParseException ex) {
            return false;
        }
    }

    public boolean isWithInRangeDate(LocalDate cdate) {
        try {
            LocalDate startDate = DateSupport.convertToLocalDate(DateSupport.parseString(getStartTime(), DateSupport.FORMAT_HCTRAFULL));
            LocalDate endDate = DateSupport.convertToLocalDate(DateSupport.parseString(getEndTime(), DateSupport.FORMAT_HCTRAFULL));
            LocalDateRange range = new LocalDateRange(startDate, endDate);
            List<LocalDate> daysBetween = range.toList();
            return daysBetween.stream().filter(o -> o.isEqual(cdate)).findFirst().isPresent();
        } catch (ParseException ex) {
            return false;
        }
    }

    public String getSpecialInstr() {
        return specialInstr;
    }

    public void setSpecialInstr(String specialInstr) {
        this.specialInstr = specialInstr;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getSiteContact() {
        return siteContact;
    }

    public void setSiteContact(String siteContact) {
        this.siteContact = siteContact;
    }

    public String getSitePhone() {
        return sitePhone;
    }

    public void setSitePhone(String sitePhone) {
        this.sitePhone = sitePhone;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public List<FieldServiceTO> getFieldService() {
        return fieldService;
    }

    public void setFieldService(List<FieldServiceTO> fieldService) {
        this.fieldService = fieldService;
    }

    public List<LabServiceTO> getLabService() {
        return labService;
    }

    public void setLabService(List<LabServiceTO> labService) {
        this.labService = labService;
    }

    public List<EngServiceTO> getEngService() {
        return engService;
    }

    public void setEngService(List<EngServiceTO> engService) {
        this.engService = engService;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getRegionCatgColorId() {
        return regionCatgColorId;
    }

    public void setRegionCatgColorId(String regionCatgColorId) {
        this.regionCatgColorId = regionCatgColorId;
    }

    public String getCylinderPickupStatus() {
        return cylinderPickupStatus;
    }

    public void setCylinderPickupStatus(String cylinderPickupStatus) {
        this.cylinderPickupStatus = cylinderPickupStatus;
    }

    public String getCylinderPickupDate() {
        return cylinderPickupDate;
    }

    public void setCylinderPickupDate(String cylinderPickupDate) {
        this.cylinderPickupDate = cylinderPickupDate;
    }

    public String getIsWoCompleted() {
        return isWoCompleted;
    }

    public void setIsWoCompleted(String isWoCompleted) {
        this.isWoCompleted = isWoCompleted;
    }

    public Integer getUnanswcount() {
        return unanswcount;
    }

    public void setUnanswcount(Integer unanswcount) {
        this.unanswcount = unanswcount;
    }

    public Integer getSubmReport() {
        return submReport;
    }

    public void setSubmReport(Integer submReport) {
        this.submReport = submReport;
    }

    public String getTestNameList() {
        return testNameList;
    }

    public void setTestNameList(String testNameList) {
        this.testNameList = testNameList;
    }

    public BigInteger getMaterialUseId() {
        return materialUseId;
    }

    public void setMaterialUseId(BigInteger materialUseId) {
        this.materialUseId = materialUseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAnswcount() {
        return answcount;
    }

    public void setAnswcount(Integer answcount) {
        this.answcount = answcount;
    }

    public String getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(String cancelledReason) {
        this.cancelledReason = cancelledReason;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public String getRecurrenceDates() {
        return recurrenceDates;
    }

    public void setRecurrenceDates(String recurrenceDates) {
        this.recurrenceDates = recurrenceDates;
    }
    
    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }


    @Override
    public CalendarResourcesDataTO clone() {
         try {
            return (CalendarResourcesDataTO) super.clone();
        } catch (CloneNotSupportedException e) {
            return new CalendarResourcesDataTO();
        }
    }   
}
