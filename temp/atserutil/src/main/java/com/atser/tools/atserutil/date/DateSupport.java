/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author droldan
 */
public class DateSupport {

    public static final Locale LOCALE_US = new Locale("EN", "US");
    public static final String PATTERN_REVERSE = "yyyy-dd-MM";
    public static final String PATTERN_REVERSE_MD = "yyyy-MM-dd";
    public static final String PATTERN_MMDDYY_HHMMSS = "MM-dd-yyyy hh:mm:ss";
    public static final String PATTERN_MMDDYY_HHMMSS_24SLASH = "MM/dd/yyyy HH:mm:ss";
    public static final String PATTERN_MMDDYY_HHMMSSA = "MM-dd-yyyy hh:mm:ss a";
    public static final String PATTERN_MMDDYY_HHMMA = "MM-dd-yyyy hh:mm a";
    public static final String PATTERN_US = "MM/dd/yyyy";
    public static final String PATTERN_US_DASH = "MM-dd-yyyy";
    public static final String PATTERN_TIME = "hh:mm:ss.SSS";
    public static final String PATTERN_TIME_HHMM = "hh:mm";
    public static final String PATTERN_FULL = PATTERN_US + " " + PATTERN_TIME;
    public static final String PATTERN_FULLSYNC = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String PATTERN_HCTRAFULL = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String PATTERN_HCTRAFULL_REGULARTIME = "yyyy-MM-dd'T'hh:mm:ss";
    public static final String PATTERN_CRYPTTIME = "yyyy-MM-dd'T'HH:mm";

    /**
     * FORMAT_MMDDYY_HHMMSS = "MM-dd-yyyy hh:mm:ss"
     */
    public static final SimpleDateFormat FORMAT_MMDDYY_HHMMSS = new SimpleDateFormat(PATTERN_MMDDYY_HHMMSS, LOCALE_US);

    /**
     * FORMAT_MMDDYY_HHMMSS = "MM/dd/yyyy HH:mm:ss"
     */
    public static final SimpleDateFormat FORMAT_MMDDYY_HHMMSS_24SLASH = new SimpleDateFormat(PATTERN_MMDDYY_HHMMSS_24SLASH, LOCALE_US);

    /**
     * FORMAT_MMDDYY_HHMMSS = "MM-dd-yyyy hh:mm:ss a"
     */
    public static final SimpleDateFormat FORMAT_MMDDYY_HHMMSSA = new SimpleDateFormat(PATTERN_MMDDYY_HHMMSSA, LOCALE_US);

    /**
     * PATTERN_MMDDYY_HHMMA = "MM-dd-yyyy hh:mm a"
     */
    public static final SimpleDateFormat FORMAT_MMDDYY_HHMMA = new SimpleDateFormat(PATTERN_MMDDYY_HHMMA, LOCALE_US);

    /**
     * PATTERN_CRYPTTIME = "yyyy-MM-dd'T'HH:mm"
     */
    public static final SimpleDateFormat FORMAT_CRYPTTIME = new SimpleDateFormat(PATTERN_CRYPTTIME, LOCALE_US);

    /**
     * PATTERN_US = "MM/dd/yyyy"
     */
    public static final SimpleDateFormat FORMAT_US = new SimpleDateFormat(PATTERN_US);

    /**
     * PATTERN_US_DASH = "MM-dd-yyyy"
     */
    public static final SimpleDateFormat FORMAT_US_DASH = new SimpleDateFormat(PATTERN_US_DASH);

    /**
     * PATTERN_REVERSE = "yyyy-dd-MM";
     */
    public static final SimpleDateFormat FORMAT_REVERSE = new SimpleDateFormat(PATTERN_REVERSE, LOCALE_US);

    /**
     * PATTERN_REVERSE_MD = "yyyy-MM-dd";
     */
    public static final SimpleDateFormat FORMAT_REVERSE_MD = new SimpleDateFormat(PATTERN_REVERSE_MD, LOCALE_US);

    /**
     * PATTERN_FULL = "MM/dd/yyyy hh:mm:ss.SSS";
     */
    public static final SimpleDateFormat FORMAT_FULL = new SimpleDateFormat(PATTERN_FULL, LOCALE_US);
    /**
     * PATTERN_FULLSYNC = "yyyy-MM-dd'T'HH:mm:ss'Z'"
     */
    public static final SimpleDateFormat FORMAT_FULLSYNC = new SimpleDateFormat(PATTERN_FULLSYNC, LOCALE_US);
    /**
     * PATTERN_TIME = "hh:mm:ss.SSS"
     */
    public static final SimpleDateFormat FORMAT_TIME = new SimpleDateFormat(PATTERN_TIME, LOCALE_US);

    /**
     * PATTERN_TIME_HHMM = "hh:mm"
     */
    public static final SimpleDateFormat FORMAT_TIME_HHMM = new SimpleDateFormat(PATTERN_TIME_HHMM, LOCALE_US);

    /**
     * PATTERN_HCTRAFULL = "yyyy-MM-dd'T'HH:mm:ss"
     */
    public static final SimpleDateFormat FORMAT_HCTRAFULL = new SimpleDateFormat(PATTERN_HCTRAFULL, LOCALE_US);

    /**
     * PATTERN_HCTRAFULL_REGULARTIME = "yyyy-MM-dd'T'hh:mm:ss"
     */
    public static final SimpleDateFormat FORMAT_HCTRAFULL_REGULARTIME = new SimpleDateFormat(PATTERN_HCTRAFULL_REGULARTIME, LOCALE_US);

    private static final List<SimpleDateFormat> formatDateList = new ArrayList<SimpleDateFormat>() {
        {
            add(FORMAT_MMDDYY_HHMMSS);
            add(FORMAT_MMDDYY_HHMMSS_24SLASH);
            add(FORMAT_MMDDYY_HHMMSSA);
            add(FORMAT_MMDDYY_HHMMA);
            add(FORMAT_CRYPTTIME);
            add(FORMAT_US);
            add(FORMAT_US_DASH);
            add(FORMAT_REVERSE);
            add(FORMAT_REVERSE_MD);
            add(FORMAT_FULL);
            add(FORMAT_FULLSYNC);
            add(FORMAT_TIME);
            add(FORMAT_TIME_HHMM);
            add(FORMAT_HCTRAFULL);
            add(FORMAT_HCTRAFULL_REGULARTIME);
        }
    };

    public static String formatUS(Date date) {
        if (date == null) {
            return null;
        } else {
            return FORMAT_US.format(date);
        }
    }

    public static String formatTime(Date date) {
        if (date == null) {
            return null;
        } else {
            return FORMAT_TIME.format(date);
        }
    }

    public static String formatFull(Date date) {
        if (date == null) {
            return null;
        } else {
            return FORMAT_FULL.format(date);
        }
    }

    public static String formatFullSync(Date date) {
        if (date == null) {
            return null;
        } else {
            return FORMAT_FULLSYNC.format(date);
        }
    }

    public static Date parseDynamicStringToDate(String date) {
        for (SimpleDateFormat lDateFormat : formatDateList) {
            try {
                Date response = parseString(date, lDateFormat);
                if (response != null) {
                    return response;
                }
            } catch (ParseException ex) {
                // Wrong Format
            }
        }
        return null;
    }

    public static Date parseDynamicStringToDate(String date, List<SimpleDateFormat> formatList) {
        for (SimpleDateFormat lDateFormat : formatList) {
            try {
                Date response = parseString(date, lDateFormat);
                if (response != null) {
                    return response;
                }
            } catch (ParseException ex) {
                // Wrong Format
            }
        }
        return null;
    }

    /**
     * Create SimpleDateFormat without timezone
     *
     * @param format
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat factorySimpleDateFormat(String format) {
        return factorySimpleDateFormat(format, null);
    }

    public static String getNowToFormat(String format) {
        return formatDate(new Date(), factorySimpleDateFormat(format));
    }

    /**
     * Create SimpleDateFormat with timezone
     *
     * @param format
     * @param timezone
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat factorySimpleDateFormat(String format, String timezone) {
        SimpleDateFormat sm = new SimpleDateFormat(format, LOCALE_US);
        if (timezone != null && !timezone.isEmpty()) {
            sm.setTimeZone(TimeZone.getTimeZone(timezone));
        }
        return sm;
    }

    /**
     * Create DateTimeFormatter without timezone
     *
     * @param format
     * @return
     */
    public static DateTimeFormatter factoryDateTimeFormatter(String format) {
        return factoryDateTimeFormatter(format, null);
    }

    /**
     * Create DateTimeFormatter with timezone
     *
     * @param format
     * @param timezone
     * @return
     */
    public static DateTimeFormatter factoryDateTimeFormatter(String format, String timezone) {
        if (timezone != null && !timezone.isEmpty()) {
            return DateTimeFormatter.ofPattern(format).withZone(ZoneId.of(timezone));
        }
        return DateTimeFormatter.ofPattern(format, LOCALE_US);
    }

    /**
     *
     * @param date
     * @param formatterToDate
     * @param formatterToString
     * @return String formatted
     * @throws ParseException
     */
    public static String formatString(String date, SimpleDateFormat formatterToDate, SimpleDateFormat formatterToString) throws ParseException {
        Date localDate = parseString(date, formatterToDate);
        return formatterToString.format(localDate);
    }

    /**
     * From String to Date
     *
     * @param date
     * @param formatter
     * @return Date
     * @throws ParseException
     */
    public static Date parseString(String date, SimpleDateFormat formatter) throws ParseException {
        return formatter.parse(date);
    }

    public static Date parseString(Object date, SimpleDateFormat formatter) throws ParseException {
        if (date != null) {
            return formatter.parse(date.toString());
        }
        throw new ParseException("The parser cannot be performed.", 0);
    }

    /**
     * From String to LocalDate
     *
     * @param date
     * @param formatter
     * @return
     * @throws DateTimeParseException
     */
    public static LocalDate parseString(String date, DateTimeFormatter formatter) throws DateTimeParseException {
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate parseString(Object date, DateTimeFormatter formatter) throws DateTimeParseException {
        if (date != null) {
            return LocalDate.parse(date.toString(), formatter);
        }
        throw new DateTimeParseException("The parser cannot be performed.", formatter.toString(), 0);
    }

    /**
     * From Date to String
     *
     * @param date
     * @param formatter
     * @return String
     */
    public static String formatDate(Date date, SimpleDateFormat formatter) {
        if (date == null) {
            return null;
        } else {
            return formatter.format(date);
        }
    }

    /**
     * Add ChronoUnit to Date
     *
     * @param init
     * @param unit
     * @param amount
     * @return
     */
    public static Date addChronoUnitToDate(Date init, ChronoUnit unit, long amount) {
        Instant actualValue = init.toInstant();
        switch (unit) {
            case MINUTES:
                return convertToDate(LocalDateTime.now().plusMinutes(amount));
            case NANOS:
            case MICROS:
            case MILLIS:
            case SECONDS:
            case HOURS:
            case HALF_DAYS:
            case DAYS:
                return Date.from(actualValue.plus(amount, unit));
            case MONTHS: {
                return convertToDate(convertToLocalDateTime(init).plusMonths(amount));
            }
            case YEARS: {
                return convertToDate(convertToLocalDateTime(init).plusYears(amount));
            }
        }

        throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
    }

    public static Date addChronoUnitToDate(Date init, ChronoUnit unit, double amount) {
        if (amount > 0) {
            Instant actualValue = init.toInstant();
            switch (unit) {
                case HOURS: {
                    long d = (long) amount;
                    double m = amount - d;
                    Instant plus_hours = actualValue.plus(d, unit);
                    if (m > 0) {
                        long t = (long) (m * 60) * 60;
                        return Date.from(plus_hours.plusSeconds(t));
                    }
                    return Date.from(plus_hours);
                }
            }
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
        }
        return init;
    }

    /**
     * Convert from LocalDateTime to java.util.Date
     *
     * @param date
     * @return java.util.Date
     */
    public static Date convertToDate(LocalDateTime date) {
        return java.util.Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Convert from java.util.Date to LocalDateTime
     *
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Convert from LocalDate to java.util.Date
     *
     * @param date
     * @return java.util.Date
     */
    public static Date convertToDate(LocalDate date) {
        return java.util.Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Convert to LocalDate from java.util.Date
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Convert to LocalDate from java.sql.Date
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate convertToLocalDate(java.sql.Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    /**
     * Get Last Working Day of the Month
     *
     * @param lastDayOfMonth
     * @return LocalDate
     */
    public static LocalDate getLastWorkingDayOfMonth(LocalDate lastDayOfMonth) {
        LocalDate lastWorkingDayofMonth;
        switch (DayOfWeek.of(lastDayOfMonth.get(ChronoField.DAY_OF_WEEK))) {
            case SATURDAY:
                lastWorkingDayofMonth = lastDayOfMonth.minusDays(1);
                break;
            case SUNDAY:
                lastWorkingDayofMonth = lastDayOfMonth.minusDays(2);
                break;
            default:
                lastWorkingDayofMonth = lastDayOfMonth;
        }
        return lastWorkingDayofMonth;
    }

    /**
     * Get First Day of the Month
     *
     * @param date
     * @return Date
     */
    public static Date getFirstDayOfMonth(Date date) {
        LocalDate fd = convertToLocalDate(date).with(TemporalAdjusters.firstDayOfMonth());
        return convertToDate(fd);
    }

    /**
     * Get First Day of the Month
     *
     * @param date
     * @return Date
     */
    public static Date getLastDayOfMonth(Date date) {
        LocalDate ld = convertToLocalDate(date).with(TemporalAdjusters.lastDayOfMonth());
        return convertToDate(ld);
    }

    /**
     * Get First Day of the Month
     *
     * @param date
     * @return Date
     */
    public static Date getFirstDayOfWeek(Date date) {
        LocalDate fd = convertToLocalDate(date);
        TemporalField fieldUS = WeekFields.of(LOCALE_US).dayOfWeek();
        return convertToDate(fd.with(fieldUS, 1));
    }

    /**
     * Get First Day of the Month
     *
     * @param date
     * @return Date
     */
    public static Date getLastDayOfWeek(Date date) {
        LocalDate ld = convertToLocalDate(date);
        TemporalField fieldUS = WeekFields.of(LOCALE_US).dayOfWeek();
        return convertToDate(ld.with(fieldUS, 7));
    }

    public static Long getFromNowDiffSeconds(int hour, int min, int sec) {
        return getFromNowDiffSeconds("US/Central", hour, min, sec);
    }

    public static Long getFromNowDiffSeconds(String zoneId, int hour, int min, int sec) {
        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.of(zoneId);
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNext5;
        zonedNext5 = zonedNow.withHour(hour).withMinute(min).withSecond(sec);
        if (zonedNow.compareTo(zonedNext5) > 0) {
            zonedNext5 = zonedNext5.plusDays(1);
        }
        return Duration.between(zonedNow, zonedNext5).getSeconds();
    }

    public static boolean compareEqualDates(Timestamp d1, Date d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        Timestamp dt2 = new Timestamp(d2.getTime());
        return d1.equals(dt2);
    }

    public static boolean compareEqualDates(Timestamp d1, Timestamp d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        return d1.equals(d2);
    }

    public static boolean compareEqualDates(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        return d1.equals(d2);
    }

    public static Date getDateFromTimeStamp(Timestamp time) {
        if (time != null) {
            return new Date(time.getTime());
        }
        return null;
    }

    public static Long minutesBeetwenDates(LocalDateTime init, LocalDateTime end) {
        Duration duration = Duration.between(init, end);
        return Math.abs(duration.toMinutes());
    }

    public static Long daysBeetwenDates(Date init, Date end) {
        return hoursBeetwenDates(init, end) / 24L;
    }

    public static Long hoursBeetwenDates(Date init, Date end) {
        return minutesBeetwenDates(init, end) / 60L;
    }

    public static Integer minutesBeetwenDates(Date init, Date end) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        String fechaInicioString = df.format(init);
        try {
            init = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(end);
        try {
            end = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = init.getTime();
        long fechaFinalMs = end.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double minutes = Math.floor(diferencia / (1000 * 60));

        return (int) minutes;
    }
}
