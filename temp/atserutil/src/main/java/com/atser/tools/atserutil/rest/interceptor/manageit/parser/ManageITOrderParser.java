/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.parser;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ManageITOrderParser {

    public static List<ManageITSorted> parseFromList(List<String> o) {
        if (o != null && o.size() > 0) {
        List<ManageITSorted> sorted = new ArrayList<>();
        for (String order : o) {
            if (order.contains(" ")) {
                String[] split = order.split(" ");
                sorted.add(new ManageITSorted(split[0], split[1]));
                break;
            }
        }
        return sorted;
        }
        return null;
    }
}
