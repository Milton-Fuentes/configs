/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.common;

/**
 *
 * @author droldan
 */
public class ManageITPaging {

    private Integer startIndex;
    private Integer maxResults;

    public ManageITPaging() {
    }

    public ManageITPaging(Integer startIndex, Integer maxResults) {
        if (startIndex < 0) {
            this.startIndex = 0;
        } else {
            this.startIndex = startIndex;
        }
        this.maxResults = maxResults;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        if (startIndex < 0) {
            this.startIndex = 0;
        } else {
            this.startIndex = startIndex;
        }
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
