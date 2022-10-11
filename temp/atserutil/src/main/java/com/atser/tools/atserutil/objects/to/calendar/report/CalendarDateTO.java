/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.calendar.report;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.date.LocalDateRange;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.commons.lang.WordUtils;

/**
 *
 * @author dperez
 */
public class CalendarDateTO {

    private LocalDate rdate;
    private String weekDay;
    private String day;
    private String month;
    private String year;
    private List<CalendarWorkOrderTO> workorders;

    public CalendarDateTO() {
    }

    public CalendarDateTO(LocalDate date) {
        this.rdate = date;
        this.weekDay = WordUtils.capitalizeFully(date.getDayOfWeek().name());
        this.day = String.valueOf(date.getDayOfMonth());
        this.month = WordUtils.capitalizeFully(date.getMonth().name());
        this.year = String.valueOf(date.getYear());
        this.workorders = new ArrayList<>();
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<CalendarWorkOrderTO> getWorkorders() {
        return workorders;
    }

    public void setWorkorders(List<CalendarWorkOrderTO> workorders) {
        this.workorders = workorders;
    }

    public LocalDate getRdate() {
        return rdate;
    }

    public void setRdate(LocalDate rdate) {
        this.rdate = rdate;
    }

    public boolean isTheSameDate(LocalDate cDate) {
        return this.rdate.isEqual(cDate);
    }

    public void buildWOList(List<CalendarResourcesDataTO> rData) {
        rData.forEach(wo -> {
            try {

                LocalDate startDate = DateSupport.convertToLocalDate(DateSupport.parseString(wo.getStartTime(), DateSupport.FORMAT_HCTRAFULL));
                LocalDate endDate = DateSupport.convertToLocalDate(DateSupport.parseString(wo.getEndTime(), DateSupport.FORMAT_HCTRAFULL));

                LocalDateRange dRange = new LocalDateRange(startDate, endDate);
                List<LocalDate> listDates = dRange.toList();
                String starTime = DateSupport.formatString(wo.getStartTime(), DateSupport.FORMAT_HCTRAFULL, DateSupport.factorySimpleDateFormat("HH:mm"));
                String endTime = DateSupport.formatString(wo.getEndTime(), DateSupport.FORMAT_HCTRAFULL, DateSupport.factorySimpleDateFormat("HH:mm"));

                String hour = "";
                LocalDateTime woStartTime = DateSupport.convertToLocalDateTime(DateSupport.parseString(wo.getStartTime(), DateSupport.FORMAT_HCTRAFULL));

                if (listDates.size() > 1) {
                    for (int i = 0; i < listDates.size(); i++) {
                        if (listDates.get(i).isEqual(rdate) && i == 0) {
                            hour = starTime + " - 23:59";
                            break;
                        } else if (listDates.get(i).isEqual(rdate) && i == listDates.size() -1) {
                            hour = "00:00 - " + endTime;
                            break;
                        } else if(listDates.get(i).isEqual(rdate) && i > 0 && i < listDates.size()){
                            hour = "00:00 - 23:59";
                            break;
                        }
                    }
                } else {
                    hour = starTime + " - " + endTime;
                }
                CalendarWorkOrderTO woIt = new CalendarWorkOrderTO(woStartTime, hour, wo.getSubject(), wo.getTracNo(), wo.getLocation());
                woIt.setLabName(wo.getLabName());
                woIt.setProjectName(" ( " + StringSupport.emptyOnNull(wo.getProjectNumber()) + " ) " + StringSupport.emptyOnNull(wo.getProjectName()));
                woIt.setServicesRequested(wo.getDescription());
                this.workorders.add(woIt);
            } catch (ParseException ex) {
                Logger.getLogger(CalendarDateTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Comparator<CalendarWorkOrderTO> byTime = (CalendarWorkOrderTO o1, CalendarWorkOrderTO o2) -> o1.getTime().compareTo(o2.getTime());
        this.workorders = this.workorders.stream().sorted(byTime).collect(Collectors.toList());
    }
}
