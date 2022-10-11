/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droldan
 */
@Deprecated
public class CalendarSupport {

    public static Date getDateFromTimeStamp(Timestamp time) {
        Date date = new Date(time.getTime());
        return date;
    }

    public static Date StringToDate(String fecha, SimpleDateFormat format) {
        Date fechaE = null;
        try {
            fechaE = format.parse(fecha);
            return fechaE;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date StringToDate(String fecha, String format) {
        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date fechaE = null;
        try {
            fechaE = formato.parse(fecha);
            return fechaE;
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean compareDateNow_MothAndYear(Date d) {
        Date t = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("MM-yyyy");
        if (formato.format(t).equals(formato.format(d))) {
            return true;
        }
        return false;
    }

    public static boolean compareDates(Date d1, Date d2) {
        SimpleDateFormat formato = new SimpleDateFormat("MM-yyyy");
        if (formato.format(d1).equals(formato.format(d2))) {
            return true;
        }
        return false;
    }

    // Fecha Actual, aplicando un formato
    public static String getDateNowToString(String format) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat(format);
        return formato.format(c.getTime());
    }

    // De la fecha actual extrae el año.
    public static String getDateNow_Year() {
        Date d = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        return formato.format(d);
    }

    public static String convertDateToString(Date d, String format) {
        SimpleDateFormat formato = new SimpleDateFormat(format);
        return formato.format(d);
    }

    public static int getDayOfWeekFromString(String dia) {
        SimpleDateFormat parser = new SimpleDateFormat("EEEE", new Locale("EN", "US"));
        try {
            Date init = parser.parse(dia);
            return getCalendarValues(init, 'w');
        } catch (ParseException ex) {
            Logger.getLogger(CalendarSupport.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static String getTypeDurationUnit(Double duration, String value) {
        if (value.equals("m") || value.equals("min") || value.equals("minute") || value.equals("minutes")) {
            return (duration > 1) ? "minutes" : "minute";
        }

        if (value.equals("h") || value.equals("hr") || value.equals("hour") || value.equals("hours")) {
            return (duration > 1) ? "hours" : "hour";
        }

        if (value.equals("d") || value.equals("dy") || value.equals("day") || value.equals("days")) {
            return (duration > 1) ? "days" : "day";
        }

        return "days";
    }

    public static int getCalendarDurationUnit(String value) {
        if (value.equals("m") || value.equals("min") || value.equals("minute") || value.equals("minutes")) {
            return Calendar.MINUTE;
        }

        if (value.equals("h") || value.equals("hr") || value.equals("hour") || value.equals("hours")) {
            return Calendar.HOUR_OF_DAY;
        }

        if (value.equals("d") || value.equals("dy") || value.equals("day") || value.equals("days")) {
            return Calendar.DAY_OF_YEAR;
        }

        return -1;
    }

    public static int getCalendarValues(char value) {
        Calendar c = Calendar.getInstance();

        switch (value) {
            case 'a': { // Año
                return c.get(Calendar.YEAR);
            }
            case 'm': { // Mes
                return c.get(Calendar.MONTH);
            }
            case 'd': { // Dia
                return c.get(Calendar.DAY_OF_MONTH);
            }
            case 'h': { // Hora
                return c.get(Calendar.HOUR_OF_DAY);
            }
            case 'i': { // Minuto
                return c.get(Calendar.MINUTE);
            }
            case 's': { // Segundo
                return c.get(Calendar.SECOND);
            }
        }

        return -1;
    }

    public static int getCalendarValues(Date fecha, char value) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);

        switch (value) {
            case 'a': { // Año
                return c.get(Calendar.YEAR);
            }
            case 'm': { // Mes
                return c.get(Calendar.MONTH);
            }
            case 'd': { // Dia
                return c.get(Calendar.DAY_OF_MONTH);
            }
            case 'h': { // Hora
                return c.get(Calendar.HOUR_OF_DAY);
            }
            case 'i': { // Minuto
                return c.get(Calendar.MINUTE);
            }
            case 's': { // Segundo
                return c.get(Calendar.SECOND);
            }
            case 'w': { // Dia de la semana
                return c.get(Calendar.DAY_OF_WEEK);
            }
        }

        return -1;
    }

    // Dias entre dos fechas usando una fecha inicial como el momento actual y una fecha final despues de la actual
    public static Integer dayBeetwenDates(Date fechaFinal) {
        Date fechaInicial = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        return (int) dias;
    }

    // Dias entre dos fechas usando una fecha inicial y final
    public static Integer dayBeetwenDates(Date fechaInicial, Date fechaFinal) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        return (int) dias;
    }

    public static Integer minuteBeetwenDates(Date fechaInicial, Date fechaFinal) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double minutes = Math.floor(diferencia / (1000 * 60));

        return (int) minutes;
    }

    /**
     * Reinicia a las 12:00 AM la hora de la fecha
     *
     * @param value
     * @return
     */
    public static Date clearHour(Date value) {

        if (value == null) {
            return null;
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(value);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    // Saber si la fecha es posterior a la fecha actual
    public static boolean compareTimeInNowAfter(String fechaini, String format) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat(format, new Locale("EN", "US"));
            Date init = parser.parse(fechaini);

            Date userDate = parser.parse(getDateNowToString(format));
            if (init.after(userDate)) {
                return true;
            }
        } catch (ParseException e) {
            System.out.println("No es valida la fecha.");
            return false;
        }
        return false;
    }

    // Recibe una fecha de inicio y fin y dice si la hora actual esta entre esas dos fechas
    public static boolean compareTimeInNow(Date init, Date end) {
        Calendar userDate = Calendar.getInstance();
        return userDate.getTime().after(init) && userDate.getTime().before(end);
    }

    public static boolean compareTimeInDate(String fechaini, String fechafin, String now, String format) {
        try { // "EEEE HH:mm"
            SimpleDateFormat parser = new SimpleDateFormat(format, new Locale("EN", "US"));
            Date init = parser.parse(fechaini);
            Date end = parser.parse(fechafin);

            Date userDate = parser.parse(now);
            if (userDate.after(init) && userDate.before(end)) {
                return true;
            }
        } catch (ParseException e) {
            System.out.println("No es valida la fecha.");
            return false;
        }
        return false;
    }

    public static Date sumByUnitAtDate(Date init, int unit, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(init);
        c.add(unit, amount);
        return c.getTime();
    }

    public static Date sumDaysAtDate(Date init, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(init);
        c.add(Calendar.DAY_OF_YEAR, amount);
        return c.getTime();
    }

    public static Date sumDaysAtDate(int amount) {
        return sumDaysAtDate(Calendar.getInstance().getTime(), amount);
    }

    public static Date sumMinuteAtDate(Date init, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(init);
        c.add(Calendar.MINUTE, amount);
        return c.getTime();
    }

    public static Date restMinuteAtDate(Date init, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(init);
        c.add(Calendar.DAY_OF_YEAR, -(amount));
        return c.getTime();
    }

    public static boolean isAnotherDay(Date init, int amount) {
        int di = getCalendarValues(init, 'w');
        int dd = getCalendarValues(sumMinuteAtDate(init, amount), 'w');

        return di != dd;
    }

    public static Date getFirstDayOfMonth(int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mes);
        cal.set(cal.get(Calendar.YEAR),
                mes,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }

    public static Date getLastdayOfMonth(int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mes);
        cal.set(cal.get(Calendar.YEAR),
                mes,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
}
