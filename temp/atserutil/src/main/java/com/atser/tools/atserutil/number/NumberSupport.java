/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.number;

import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author droldan
 */
public class NumberSupport {

    public static String parseDoubleToPercentage(Double value) {
        int percentage = (int) Math.ceil(value * 100);
        return String.valueOf(percentage);
    }

    public static String parseDoubleToString(Double value) {
        return String.valueOf(value.doubleValue());
    }

    public static Integer parseStringToInteger(String value) throws ParseException {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setParseIntegerOnly(true);
        return formatter.parse(value).intValue();
    }

    public static Double parseStringToDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
    }

    public static Double parseStringToDouble(String number, double... defaultValue) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException | NullPointerException nfe) {
            if (defaultValue.length > 0) {
                return defaultValue[0];
            } else {
                return null;
            }
        }
    }

    public static Integer parseStringToInt(String number) {
        try {
            if (number.contains(".")) {
                Double val = Double.parseDouble(number);
                int r = (int) val.doubleValue();
                return r;
            }
            return Integer.parseInt(number);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
    }

    public static Long parseStringToLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
    }

    @Deprecated
    public static BigDecimal parseStringToBigDecimal(String s) {
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
    }

    public static Integer getInteger(Object value) {
        Integer ret = null;
        if (value != null) {
            if (value instanceof Integer) {
                ret = ((Integer) value);
            } else if (value instanceof BigInteger) {
                ret = ((BigInteger) value).intValue();
            } else if (value instanceof BigDecimal) {
                ret = ((BigDecimal) value).intValue();
            } else if (value instanceof String) {
                if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
                    return null;
                }
                ret = Integer.valueOf(StringSupport.trimToEmpty(value));
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a Integer.");
            }
        }
        return ret;
    }

    public static Double getDouble(Object value) {
        Double ret = null;
        if (value != null) {
            if (value instanceof Integer) {
                ret = ((Integer) value).doubleValue();
            } else if (value instanceof BigInteger) {
                ret = ((BigInteger) value).doubleValue();
            } else if (value instanceof BigDecimal) {
                ret = ((BigDecimal) value).doubleValue();
            } else if (value instanceof String) {
                if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
                    return null;
                }
                try {
                    String v = StringSupport.getString(value);
                    if (v.contains(",")) {
                        v = StringSupport.sanitizeString(v, ",");
                    }
                    ret = Double.valueOf(StringSupport.trimToEmpty(v));
                } catch (NumberFormatException ex) {
                    return ret;
                }
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a Integer.");
            }
        }
        return ret;
    }

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        try {
            if (value != null) {
                if (value instanceof BigDecimal) {
                    ret = (BigDecimal) value;
                } else if (value instanceof String) {
                    if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
                        return null;
                    }
                    ret = new BigDecimal(StringSupport.trimToEmpty(value));
                } else if (value instanceof BigInteger) {
                    ret = new BigDecimal((BigInteger) value);
                } else if (value instanceof Double) {
                    ret = new BigDecimal(parseDoubleToString((Double) value));
                } else if (value instanceof Number) {
                    ret = new BigDecimal(((Number) value).doubleValue());
                } else {
                    throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
                }
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
        return ret;
    }

    public static BigInteger getBigInteger(Object value) {
        BigInteger ret = null;
        try {
            if (value != null) {
                if (value instanceof BigDecimal) {
                    ret = ((BigDecimal) value).toBigInteger();
                } else if (value instanceof BigInteger) {
                    ret = (BigInteger) value;
                } else if (value instanceof String) {
                    if (StringSupport.isNullOrEmpty(value) || value.equals("null")) {
                        return null;
                    }
                    ret = new BigInteger(StringSupport.trimToEmpty(value));
                } else if (value instanceof Long) {
                    ret = BigInteger.valueOf((Long) value);
                } else if (value instanceof Integer) {
                    ret = BigInteger.valueOf((Integer) value);
                } else {
                    throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigInteger.");
                }
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
        return ret;
    }

    @Deprecated
    public static BigInteger parseStringToBigInteger(String s) {
        try {
            return new BigInteger(s);
        } catch (NumberFormatException | NullPointerException nfe) {
            return null;
        }
    }

    public static Boolean isNumeric(String value) {
        return NumberUtils.isCreatable(value);
    }

    public static BigDecimal getZeroWhenNull(BigDecimal value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return value;
    }

    public static BigInteger getZeroWhenNull(BigInteger value) {
        if (value == null) {
            return BigInteger.ZERO;
        }
        return value;
    }

    /**
     * Basic Calculation for BigDecimals
     *
     * @param value1
     * @param value2
     * @param operation (+, -, *, /)
     * @return 0 if error, value if good
     */
    public static BigDecimal calcBigDecimal(BigDecimal value1, BigDecimal value2, String operation) {
        return calcBigDecimal(value1, value2, operation, BigDecimal.ZERO);
    }

    public static BigDecimal calcBigDecimal(BigDecimal value1, BigDecimal value2, String operation, BigDecimal defaultResult) {
        return calcBigDecimal(value1, value2, operation, defaultResult, 2);
    }

    public static BigDecimal calcBigDecimal(BigDecimal value1, BigDecimal value2, String operation, BigDecimal defaultResult, Integer decimalPlaces) {
        BigDecimal v1 = getZeroWhenNull(value1);
        BigDecimal v2 = getZeroWhenNull(value2);

        try {
            switch (operation) {
                case "+": {
                    return v1.add(v2).setScale(decimalPlaces, RoundingMode.CEILING);
                }
                case "-": {
                    return v1.subtract(v2).setScale(decimalPlaces, RoundingMode.CEILING);
                }
                case "*": {
                    return v1.multiply(v2).setScale(decimalPlaces, RoundingMode.CEILING);
                }
                case "/": {
                    return v1.divide(v2, decimalPlaces, RoundingMode.CEILING);
                }
            }
        } catch (ArithmeticException e) {
            return defaultResult;
        }
        return defaultResult;
    }
}
