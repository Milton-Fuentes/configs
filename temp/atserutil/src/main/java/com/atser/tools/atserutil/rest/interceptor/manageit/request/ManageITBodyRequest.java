/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.request;

import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITPaging;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITToken;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author droldan
 * @param <T>
 */
public class ManageITBodyRequest<T> {

    private T data;
    private String action;
    private ManageITToken token;
    private AtserLinkedHashMap<String, Object> params;
    private List<ManageITFilter<?>> filter;
    private List<ManageITSorted> sorted;
    private ManageITPaging paging;

    public ManageITBodyRequest() {
        this.token = null;
    }

    public ManageITBodyRequest(int startIndex, int maxResults) {
        paging = new ManageITPaging(startIndex, maxResults);
        filter = new ArrayList<>();
        sorted = new ArrayList<>();
        this.token = null;
    }

    public ManageITBodyRequest(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted) {
        this.filter = filter;
        this.sorted = sorted;
        this.paging = null;
        this.token = null;
    }

    public ManageITBodyRequest(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted, ManageITPaging paging) {
        this.filter = filter;
        this.sorted = sorted;
        this.paging = paging;
        this.token = null;
    }

    /**
     * Filter
     *
     * @param field
     * @param value
     * @param condition
     * @return Current Object
     */
    public ManageITBodyRequest filter(String field, Object value, String condition) {
        if (StringSupport.isNotNullAndNotEmpty(field) && value != null && StringSupport.isNotNullAndNotEmpty(condition)) {
            if (filter == null) {
                filter = new ArrayList<>();
            }
            filter.add(new ManageITFilter<>(field, value, condition));
        }
        return this;
    }

    /**
     * Filter. By default the conditional is equal to
     *
     * @param field
     * @param value
     * @return Current Object
     */
    public ManageITBodyRequest filter(String field, Object value) {
        if (StringSupport.isNotNullAndNotEmpty(field) && value != null) {
            if (filter == null) {
                filter = new ArrayList<>();
            }
            filter.add(new ManageITFilter<>(field, value, "="));
        }
        return this;
    }

    /**
     * Sorted
     *
     * @param name
     * @param direction
     * @return
     */
    public ManageITBodyRequest sorted(String name, String direction) {
        if (StringSupport.isNotNullAndNotEmpty(name) && StringSupport.isNotNullAndNotEmpty(direction)) {
            if(sorted == null) {
                sorted = new ArrayList<>();
            }
            sorted.add(new ManageITSorted(name, direction));
        }
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<ManageITFilter<?>> getFilter() {
        return filter;
    }

    public List<ManageITFilter<?>> getFilterWithOutLikes() {
        if (filter != null) {
            List<ManageITFilter<?>> copyFilter = filter.stream().filter(o -> (!o.getCondition().equals("%="))).collect(Collectors.toList());
            return copyFilter;
        }
        return filter;
    }

    @JsonIgnore
    public Boolean isSearchFilterActive() {
        if (filter != null) {
            return filter.stream().filter(o -> (o.getCondition().equals("%="))).findFirst().isPresent();
        }
        return false;
    }

    public void setFilter(List<ManageITFilter<?>> filter) {
        this.filter = filter;
    }

    public List<ManageITSorted> getSorted() {
        return sorted;
    }

    public void setSorted(List<ManageITSorted> sorted) {
        this.sorted = sorted;
    }

    public AtserLinkedHashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(AtserLinkedHashMap<String, Object> params) {
        this.params = params;
    }

    public ManageITPaging getPaging() {
        return paging;
    }

    public void setPaging(ManageITPaging paging) {
        this.paging = paging;
    }

    public ManageITToken getToken() {
        return token;
    }

    public void setToken(ManageITToken token) {
        this.token = token;
    }
    
    public Boolean containsToken() {
        return (token != null);
    }
}
