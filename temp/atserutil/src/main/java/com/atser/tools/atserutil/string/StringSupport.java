/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.string;

import com.atser.tools.atserutil.number.NumberSupport;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang.StringUtils;
import static org.apache.commons.lang.StringUtils.isEmpty;

/**
 *
 * @author droldan
 */
public class StringSupport {

    public static final String CHAR_SEPARATOR = ",";
    public static final String CODE_SEPARATOR = "-";
    public static final String STRING_EMPTY = "";

    public static final HashMap<Integer, String> charMap = new HashMap<Integer, String>();

    static {
        charMap.put(34, "&quot;");    // double quote
        charMap.put(35, "&#35;");     // hash mark (no HTML named entity)
        charMap.put(38, "&amp;");     // ampersand
        charMap.put(39, "&apos;");    // apostrophe, aka single quote
        charMap.put(60, "&lt;");      // less than
        charMap.put(62, "&gt;");      // greater than
    }

    public static String escapeHtml(String inputString) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = inputString.toCharArray();
        for (char nextChar : charArray) {
            String entityName = charMap.get((int) nextChar);
            if (entityName == null) {
                if (nextChar > 0x7F) {
                    builder.append("&#")
                            .append(Integer.toString(nextChar, 10))
                            .append(";");
                } else {
                    builder.append(nextChar);
                }
            } else {
                builder.append(entityName);
            }
        }
        return builder.toString();
    }

    public static String cleanXSS(String value) {
        if (isNullOrEmpty(value)) {
            return value;
        }
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("%3C", "&lt;").replaceAll("%3E", "&gt;");
        //value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("%28", "&#40;").replaceAll("%29", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }

    public static String cutFromEnd(final String text, final int digits) {
        String value = trimToEmpty(text);
        if (value.length() > digits) {
            value = value.substring(value.length() - digits);
        }
        return value;
    }

    public static String abbreviation(final String text, final int i) {
        String value = trimToEmpty(text);
        if (value.length() > i) {
            value = value.substring(0, i - 3) + "...";
        }
        return value;
    }

    public static String cut(final Object text, final int limit) {
        if (text == null) {
            return null;
        } else {
            String head = text.toString();
            if (head.length() > limit) {
                head = head.substring(0, limit);
            }
            return head;
        }
    }

    public static String cut(final String text, final String tail) {
        String value = trimToEmpty(text);
        if (value.lastIndexOf(tail) >= 0) {
            value = value.substring(0, value.lastIndexOf(tail));
        }
        return value;
    }

    public static boolean isNotEmpty(String... values) {
        for (String value : values) {
            if (isEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static String emptyOnNull(String value) {
        if (value == null) {
            return STRING_EMPTY;
        }
        return value;
    }

    public static String emptyOnNull(Object value) {
        if (value == null) {
            return STRING_EMPTY;
        }
        return value.toString();
    }

    public static String trimToEmpty(Object value) {
        String text = "";
        if (value != null) {
            text = value.toString();
        }
        return text.trim();
    }

    public static int length(String value) {
        String text = trimToEmpty(value);
        return text.length();
    }

    public static String trunc(final String value, final int length) {
        String text = trimToEmpty(value);
        if (length(text) > length) {
            if (length > 100) {
                text = text.substring(0, length - 3) + "...";
            } else {
                text = text.substring(0, length);
            }

        }
        return text.trim();
    }

    /**
     * Sanitize String and Convert
     *
     * @param string
     * @param regex : - Clean Spaces : "\\s+". - Clean Dots : "\\." - Clean
     * Spaces and - Dots: [\\s+,\\.+] - Keep only Letters [^A-Za-z]+
     * @param convert [0 - LowerCase, 1- UpperCase, 2- Default]
     * @return sanitize String
     */
    public static String sanitizeString(String string, String regex, int convert) {
        if (isNotNullAndNotEmpty(string)) {
            String response = string.replaceAll(regex, "");
            switch (convert) {
                case 0: {
                    return response.toLowerCase();
                }
                case 1: {
                    return response.toUpperCase();
                }
                default:
                    return response;
            }
        }
        return string;
    }

    /**
     * Sanitize String and Convert
     *
     * @param string
     * @param regex : Clean Spaces : "\\s+". Clean Dots : "\\." Clean Spaces and
     * Dots: [\\s+,\\.+]
     * @return
     */
    public static String sanitizeString(String string, String regex) {
        if (isNotNullAndNotEmpty(string)) {
            return string.replaceAll(regex, "");
        }
        return string;
    }

    /**
     *
     * @param string
     * @param regex : Clean Spaces : "\\s+". Clean Dots : "\\." Clean Spaces and
     * Dots: [\\s+,\\.+]
     * @param replace
     * @return
     */
    public static String replaceString(String string, String regex, String replace) {
        if (isNotNullAndNotEmpty(string)) {
            return string.replaceAll(regex, replace);
        }
        return string;
    }

    /**
     * Search into a String a Regex a Get the value
     *
     * @param string
     * @param regex
     * @param index
     * @return value
     */
    public static String matchAndGetString(String string, String regex, int index) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group(index);
        }
        return null;
    }

    public static String sanitizeStringForSql(String string) {
        return replaceString(string, "'", "''");
    }

    public static String capitalize(String string) {
        return StringUtils.capitalize(string);
    }

    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static Boolean isNotNullAndNotEmpty(String string) {
        return (string != null && !string.isEmpty());
    }

    public static Boolean isNotNullAndNotEmpty(Object string) {
        return (string != null && !string.toString().isEmpty());
    }

    public static boolean isNotNullAndNotEmpty(String... values) {
        for (String value : values) {
            if (isNullOrEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isNullOrEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    public static Boolean isNullOrEmpty(Object string) {
        return (string == null || string.toString().isEmpty());
    }

    public static boolean isNullOrEmpty(String... values) {
        for (String value : values) {
            if (isNullOrEmpty(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object... values) {
        for (Object value : values) {
            if (isNullOrEmpty(value)) {
                return true;
            }
        }
        return false;
    }

    public static String getString(Object value) {
        String ret = null;
        if (value != null) {
            return value.toString();
        }
        return ret;
    }

    public static String getStringFromClob(Clob clb) throws IOException, SQLException {
        if (clb == null) {
            return STRING_EMPTY;
        }
        // Builder
        StringBuilder str = new StringBuilder();
        String strng;
        // Reader
        BufferedReader bufferRead = new BufferedReader(clb.getCharacterStream());
        while ((strng = bufferRead.readLine()) != null) {
            str.append(strng);
        }
        return str.toString();
    }

    public static Boolean getBoolean(Character string) {
        return getBoolean(getString(string));
    }

    public static Boolean getBoolean(Object string) {
        return getBoolean(getString(string));
    }

    public static Boolean getBoolean(String string) {
        if (isNullOrEmpty(string)) {
            return Boolean.FALSE;
        }
        switch (string.trim().toLowerCase()) {
            case "true":
            case "on":
            case "0":
            case "yes":
            case "y": {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * True: Equals, False: Not Equals
     *
     * @param a
     * @param b
     * @return Boolean
     */
    public static Boolean compareString(String a, String b) {
        return StringSupport.emptyOnNull(a).equals(StringSupport.emptyOnNull(b));
    }

    /**
     * True: Equals, False: Not Equals
     *
     * @param a
     * @param b
     * @return Boolean
     */
    public static Boolean compareCharacter(Character a, Character b) {
        if (a == null && b == null) {
            return Boolean.TRUE;
        } else if ((a == null && b != null) || (a != null && b == null)) {
            return Boolean.FALSE;
        }
        return Character.compare(a, b) == 0;
    }

    /**
     * Convert generic string to Character to represent a Active status (Y, N)
     *
     * @param string
     * @return
     */
    public static Character getActiveAsCharacter(String string) {
        if (isNullOrEmpty(string)) {
            return 'N';
        }
        switch (string.trim().toLowerCase()) {
            case "active":
            case "true":
            case "on":
            case "a":
            case "1":
            case "yes":
            case "y": {
                return 'Y';
            }
        }
        return 'N';
    }

    /**
     * Next Version by Default is 1 if is null
     *
     * @param currentVersion
     * @return
     */
    public static String getNextVersion(String currentVersion) {
        if (StringSupport.isNullOrEmpty(currentVersion)) {
            return "1";
        }
        Integer scVersion = NumberSupport.getInteger(currentVersion);
        if (scVersion != null) {
            return StringSupport.getString(++scVersion);
        }
        return "1";
    }

    /**
     *
     * @param value
     * @param format [ - '%.0f' - Format Number to 0 decimals. - '%.2f' - Format
     * Number to 2 decimals. ]
     * @return
     */
    public static String formatDecimalToString(Object value, String format) {
        String ret = null;
        if (value != null && isNotNullAndNotEmpty(format)) {
            try {
                if (value instanceof Double) {
                    ret = String.format(format, (Double) value);
                } else if (value instanceof BigDecimal) {
                    ret = String.format(format, (BigDecimal) value);
                } else if (value instanceof Float) {
                    ret = String.format(format, (Float) value);
                } else if (value instanceof String) {
                    if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
                        return null;
                    }
                    try {
                        ret = String.format(format, Double.valueOf(StringSupport.trimToEmpty(value)));
                    } catch (NumberFormatException ex) {
                        return ret;
                    }
                } else {
                    throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a String.");
                }
            } catch (IllegalFormatException ex) {
                return null;
            }
        }
        return ret;
    }

    /**
     * Split Decimal in Integer/Decimal Parts. By default take Integer Part.
     *
     * @param value
     * @return
     */
    public static String splitDecimal(String value) {
        return splitDecimal(value, 0);
    }

    /**
     * Split Decimal in Integer/Decimal Parts
     *
     * @param value
     * @param part [0- Integer part, 1- Decimal part]
     * @return
     */
    public static String splitDecimal(String value, int part) {
        String ret;
        if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
            return null;
        }
        int decimalIndex = value.indexOf(".");
        try {
            if (part == 0) {
                ret = value.substring(0, decimalIndex);
            } else {
                ret = value.substring(decimalIndex);
            }
            return ret;
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.printf("String Error: %s, %d\n", value, decimalIndex);
            return null;
        }
    }

    public static <T> String toJsonString(T cls) {
        if (cls != null) {
            ObjectMapper oMapper = new ObjectMapper();
            oMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            try {
                return oMapper.writeValueAsString(cls);
            } catch (JsonProcessingException ex) {
                return "{}";
            }
        }
        return "{}";
    }

    public static List<String> toList(String value, String separator) {
        if (isNullOrEmpty(value)) {
            return null;
        }
        if (isNullOrEmpty(separator)) {
            separator = ",";
        }
        return Stream.of(value.split(separator)).collect(Collectors.toList());
    }

    public static List<String> toList(Object value, String separator) {
        return toList(StringSupport.getString(value), separator);
    }

    public static List<String> toList(Object value) {
        return toList(StringSupport.getString(value), null);
    }
}