/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author droldan
 */
public class ListSupport {

    /**
     * This function creates a key as List where list contains the values of
     * fields to check distinct combinations. The list keys are inserted into a
     * ConcurrentHashMap which stores only unique and distinct keys.
     *
     * @param <T>
     * @param keyExtractors
     * @see Example: List<Record> list =
     * recordsList.stream().filter(distinctByKeys(Record::getId,
     * Record::getName)).collect(Collectors.toList());
     * @return Predicate
     */
    public static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
        return t -> {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());
            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }
    
    /**
     * Print List of Elements
     * @param list 
     */
    public static void printList(List<?> list) {
        if (list != null && !list.isEmpty()) {
            list.stream().forEach(System.out::println);
        }
    }
}
