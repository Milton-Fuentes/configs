/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.common;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITPaging;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITToken;
import com.atser.tools.atserutil.rest.interceptor.manageit.parser.ManageITFilterParser;
import com.atser.tools.atserutil.rest.interceptor.manageit.parser.ManageITOrderParser;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import org.bonitasoft.engine.search.Order;
import org.bonitasoft.engine.search.SearchOptionsBuilder;
import org.jboss.resteasy.spi.ResteasyUriInfo;

/**
 *
 * @author droldan Query Parameters f: filter (equal (=), notEqual (!=), gt (>),
 * lt (<), like (%=), not like (!%=), in (:=)) o: order (value+asc) l: length s:
 * start t: type
 */
public class ApiCommon {

    @SuppressWarnings("unchecked")
    public static ManageITBodyRequest buildFilter(UriInfo uriInfo) {
        ManageITBodyRequest request = new ManageITBodyRequest();
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> paramLength = queryParams.get("l");
        List<String> paramStart = queryParams.get("s");
        List<String> paramToken = queryParams.get("tk");
        List<String> paramTokenType = queryParams.get("tkt");
        request.setFilter(ManageITFilterParser.parseFromList(queryParams.get("f")));
        request.setSorted(ManageITOrderParser.parseFromList(queryParams.get("o")));
        request.setPaging(new ManageITPaging((paramStart != null && paramStart.size() >= 1) ? Integer.valueOf(paramStart.get(0)) : 0,
                (paramLength != null && paramLength.size() >= 1) ? Integer.valueOf(paramLength.get(0)) : -1));
        if (paramToken != null && paramToken.size() >= 1) {
            ManageITToken token = new ManageITToken(paramToken.get(0));
            if (paramTokenType != null && paramTokenType.size() >= 1) {
                token.setType(paramTokenType.get(0));
            }
            request.setToken(token);
        }
        return request;
    }

    @SuppressWarnings("unchecked")
    public static ManageITRequest buildAdvanceFilter(UriInfo uriInfo) {
        ManageITRequest request = new ManageITRequest();
        ManageITBodyRequest body = new ManageITBodyRequest();
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> paramLength = queryParams.get("l");
        List<String> paramStart = queryParams.get("s");
        List<String> paramToken = queryParams.get("tk");
        List<String> paramTokenType = queryParams.get("tkt");
        body.setFilter(ManageITFilterParser.parseFromList(queryParams.get("f")));
        body.setSorted(ManageITOrderParser.parseFromList(queryParams.get("o")));
        body.setPaging(new ManageITPaging((paramStart != null && paramStart.size() >= 1) ? Integer.valueOf(paramStart.get(0)) : 0,
                (paramLength != null && paramLength.size() >= 1) ? Integer.valueOf(paramLength.get(0)) : -1));
        if (paramToken != null && paramToken.size() >= 1) {
            ManageITToken token = new ManageITToken(paramToken.get(0));
            if (paramTokenType != null && paramTokenType.size() >= 1) {
                token.setType(paramTokenType.get(0));
            }
            body.setToken(token);
        }
        ManageITHeader header = new ManageITHeader();
        header.initHeaderByGet(queryParams.get("h"));
        request.setHeader(header);
        request.setBody(body);
        return request;
    }

    @SuppressWarnings("unchecked")
    public static ManageITRequest buildAdvanceFilter(String uriInfo, ManageITHeader header) {
        if (StringSupport.isNotNullAndNotEmpty(uriInfo)) {
            UriInfo pUriInfo = new ResteasyUriInfo("", uriInfo, "");
            ManageITRequest request = new ManageITRequest();
            ManageITBodyRequest body = new ManageITBodyRequest();
            MultivaluedMap<String, String> queryParams = pUriInfo.getQueryParameters();
            List<String> paramLength = queryParams.get("l");
            List<String> paramStart = queryParams.get("s");
            List<String> paramToken = queryParams.get("tk");
            List<String> paramTokenType = queryParams.get("tkt");
            body.setFilter(ManageITFilterParser.parseFromList(queryParams.get("f")));
            body.setSorted(ManageITOrderParser.parseFromList(queryParams.get("o")));
            body.setPaging(new ManageITPaging((paramStart != null && paramStart.size() >= 1) ? Integer.valueOf(paramStart.get(0)) : 0,
                    (paramLength != null && paramLength.size() >= 1) ? Integer.valueOf(paramLength.get(0)) : -1));
            if (paramToken != null && paramToken.size() >= 1) {
                ManageITToken token = new ManageITToken(paramToken.get(0));
                if (paramTokenType != null && paramTokenType.size() >= 1) {
                    token.setType(paramTokenType.get(0));
                }
                body.setToken(token);
            }
            request.setHeader(header);
            request.setBody(body);
            return request;
        }
        return null;
    }

    public static String getFilterValue(ManageITBodyRequest bodyRequest, String filter) {
        if (bodyRequest.getFilter() != null && !bodyRequest.getFilter().isEmpty()) {
            return StringSupport.getString(bodyRequest.getFilter().stream().filter(e -> ((ManageITFilter) e).getField().equals(filter)).findAny().orElse(null));
        }
        return null;
    }

    /**
     * For Get Request to be used by Bonita Bpm
     *
     * @param uriInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ManageITRequest<SearchOptionsBuilder> buildBonitaSearchOptionsBuilder(UriInfo uriInfo) {
        ManageITRequest<SearchOptionsBuilder> request = new ManageITRequest<>();
        ManageITBodyRequest<SearchOptionsBuilder> body = new ManageITBodyRequest<>();
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> paramLength = queryParams.get("l");
        List<String> paramStart = queryParams.get("s");
        List<ManageITFilter<?>> filters = ManageITFilterParser.parseFromList(queryParams.get("f"));
        List<ManageITSorted> sorts = ManageITOrderParser.parseFromList(queryParams.get("o"));
        ManageITHeader header = new ManageITHeader();
        header.initHeaderByGet(queryParams.get("h"));
        SearchOptionsBuilder sob = new SearchOptionsBuilder((paramStart != null && paramStart.size() >= 1) ? Integer.valueOf(paramStart.get(0)) : 0,
                (paramLength != null && paramLength.size() >= 1) ? Integer.valueOf(paramLength.get(0)) : 0);
        // Process Filters
        if (filters != null && filters.size() > 0) {
            filters.stream().forEach(it -> {
                switch (it.getCondition()) {
                    case "=": {
                        sob.filter(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case ">": {
                        sob.greaterThan(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case ">=": {
                        sob.greaterOrEquals(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case "<": {
                        sob.lessThan(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case "<=": {
                        sob.lessOrEquals(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case "!=": {
                        sob.differentFrom(it.getField(), StringSupport.getString(it.getValue()));
                        break;
                    }
                    case "%=": { // Review Search Activition on BPM Configuration files
                        sob.searchTerm(StringSupport.getString(it.getValue()));
                        break;
                    }
                    default: {
                        sob.filter(it.getField(), StringSupport.getString(it.getValue()));
                    }
                }
            });
        }
        // Process Sorts
        if (sorts != null && sorts.size() > 0) {
            sorts.stream().forEach(it -> {
                sob.sort(it.getName(), it.getDirection().toLowerCase().equals("desc") ? Order.DESC : Order.ASC);
            });
        }
        request.setHeader(header);
        body.setData(sob);
        request.setBody(body);
        return request;
    }
}
