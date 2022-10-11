/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.date;

import java.util.Date;

/**
 *
 * @author droldan
 */
public class DateComparable implements Comparable<DateComparable> {

    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date datetime) {
        this.dateTime = datetime;
    }

    @Override
    public int compareTo(DateComparable o) {
        if (getDateTime() == null || o.getDateTime() == null) {
            return 0;
        }
        return getDateTime().compareTo(o.getDateTime());
    }

}
