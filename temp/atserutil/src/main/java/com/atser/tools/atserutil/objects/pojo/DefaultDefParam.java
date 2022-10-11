/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo;

import java.util.Map;

/**
 *
 * @author droldan
 */
public class DefaultDefParam extends DefaultReportDefParam {

    /**
     * Support GET Request filters
     */
    public String dtSearchUrl;
    public Integer startIndex;
    public Integer maxResults;
    public String sortBy;
    public String sortDir;
    /**
     * Support POST Request filters
     */
    public Map<String, String> dtMapSearch;
    /**
     * Specify the DataType table, select, report
     */
    public String dt;
}
