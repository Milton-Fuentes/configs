/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.number;

import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author droldan
 */
public class CurrencySupport {

    public static String formatBigDecimalToString(BigDecimal v, int decimal) {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if (v == null) {
            return formateador.format(BigDecimal.ZERO);
        }
        return formateador.format(v);
    }

    public static BigDecimal formatStringToBigDecimal(String nv, int decimal) throws ParseException {
        double rd = formatStringToDouble(nv, decimal);
        BigDecimal bd = new BigDecimal(rd);
        bd = bd.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    public static BigDecimal formatBigDecimal(BigDecimal nv, int decimal) {
        nv = nv.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return nv;
    }

    public static String formatDoubleToString(Double v, int decimal) {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if (v == null) {
            return formateador.format(0d);
        }
        return formateador.format(v);
    }

    public static Double formatDouble(Double v, int decimal) throws ParseException {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if (v == null) {
            return formatStringToDouble(formateador.format(0d), decimal);
        }
        return formatStringToDouble(formateador.format(v), decimal);
    }

    public static Double formatStringToDouble(String nv, int decimal) throws ParseException {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if(StringSupport.isNullOrEmpty(nv)) {
            return formateador.parse("0").doubleValue();
        }
        return formateador.parse(nv).doubleValue();
    }

    public static String formatFloatToString(Float v, int decimal) {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if (v == null) {
            return formateador.format(0f);
        }
        return formateador.format(v);
    }

    public static Float formatStringToFloat(String nv, int decimal) throws ParseException {
        StringBuilder format = new StringBuilder();
        format.append("###,##0.00");
        if (decimal > 2) {
            for (int i = 0; i < decimal - 2; i++) {
                format.append("0");
            }
        }
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        unusualSymbols.setDecimalSeparator('.');
        unusualSymbols.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat(format.toString(), unusualSymbols);
        if(StringSupport.isNullOrEmpty(nv)) {
            return formateador.parse("0").floatValue();
        }
        return formateador.parse(nv).floatValue();
    }
}
