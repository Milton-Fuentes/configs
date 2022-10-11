/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

/**
 *
 * @author droldan
 * @param <T>
 */
public interface ISearchDao<T> {

    String buildCountQuery(T filters, String tailLine);
    
    String buildQuery(T filters, String tailLine, String orderLine, String orderLine2);
    
    String buildFilters(T filters);
    
    String buildSort(T filters, Integer level);
}
