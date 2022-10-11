/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.calendar.report;

import com.atser.tools.atserutil.date.LocalDateRange;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author dperez
 */
public class CalendarResourcesTO {

    private String rid;
    private String name;
    private List<CalendarDateTO> dates;

    public CalendarResourcesTO() {
    }

    public CalendarResourcesTO(String rid, String name) {
        this.rid = rid;
        this.name = name;
        this.dates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public List<CalendarDateTO> getDates() {
        return dates;
    }

    public void setDates(List<CalendarDateTO> dates) {
        this.dates = dates;
    }

    public void buildCalendarDates(List<CalendarResourcesDataTO> rData) {
        List<CalendarDateTO> rListDate = new ArrayList<>();
        rData.forEach((it) -> {
            try {
                LocalDate startDate = DateSupport.convertToLocalDate(DateSupport.parseString(it.getStartTime(), DateSupport.FORMAT_HCTRAFULL));
                LocalDate endDate = DateSupport.convertToLocalDate(DateSupport.parseString(it.getEndTime(), DateSupport.FORMAT_HCTRAFULL));
                LocalDateRange range = new LocalDateRange(startDate, endDate);
                List<LocalDate> daysBetween = range.toList();
                daysBetween.stream().filter((localDate) -> (rListDate.stream().filter(o -> o.isTheSameDate(localDate)).findFirst().isPresent() == false)).forEachOrdered((_item) -> {
                    rListDate.add(new CalendarDateTO(_item));
                });
            } catch (ParseException ex) {
                Logger.getLogger(CalendarResourcesTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        });        
        rListDate.forEach((it) -> {
            it.buildWOList(rData.stream().filter(o -> o.isWithInRangeDate(it.getRdate())).collect(Collectors.toList()));
        });
        Comparator<CalendarDateTO> sByDate = (CalendarDateTO o1, CalendarDateTO o2) -> o1.getRdate().compareTo(o2.getRdate());
        this.setDates(rListDate.stream().sorted(sByDate).collect(Collectors.toList()));
    }

}
