/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author droldan
 */
public class LocalDateTimeRange implements Iterable<LocalDateTime> {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public LocalDateTimeRange(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public Iterator<LocalDateTime> iterator() {
        return stream().iterator();
    }

    public Stream<LocalDateTime> stream() {
        return Stream.iterate(startDate, d -> d.plusDays(1)).limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
    }

    public List<LocalDateTime> toListPerDays() { //could also be built from the stream() method
        List<LocalDateTime> dates = new ArrayList<>();
        for (LocalDateTime d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
            dates.add(d);
        }
        return dates;
    }
    
    public List<LocalDateTime> toListPerHours() { //could also be built from the stream() method
        List<LocalDateTime> dates = new ArrayList<>();
        for (LocalDateTime d = startDate; !d.isAfter(endDate); d = d.plusHours(1)) {
            dates.add(d);
        }
        return dates;
    }
    
    public List<LocalDateTime> toList(ChronoUnit unit, long increment) { //could also be built from the stream() method
        List<LocalDateTime> dates = new ArrayList<>();
        
        for (LocalDateTime d = startDate; !d.isAfter(endDate); d = d.plus(increment, unit)) {
            dates.add(d);
        }
        return dates;
    }

}
