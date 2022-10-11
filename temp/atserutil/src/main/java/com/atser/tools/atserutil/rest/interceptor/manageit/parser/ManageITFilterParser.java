/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.parser;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Conditional Methods: equal (=), notEqual (!=), gt (>), ge, lt (<), le, between, like (%=), in (:=)
 * @author droldan
 */
public class ManageITFilterParser {
    
    final static String[] operatorList = new String[]{"!=", "!%=", "%=", ":=", ">=", "<=", ">", "<", "="};

    public static List<ManageITFilter<?>> parseFromList(List<String> f) {
        if (f != null && f.size() > 0) {
            List<ManageITFilter<?>> filters = new ArrayList<>();
            f.forEach(it -> {
                ManageITFilter<?> rf = createFilter(it);
                if (rf != null) {
                    filters.add(createFilter(it));
                }
            });
            return filters;
        }
        return null;
    }

    public static ManageITFilter<?> createFilter(String param) {
        for (String operator : operatorList) {
            if (param.contains(operator)) {
                String[] split = param.split(operator);
                return new ManageITFilter<>(split[0], split[1], operator);
            }

        }
        return null;
    }
}
