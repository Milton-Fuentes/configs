/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.syncfusion;

import java.util.List;

/**
 *
 * @author droldan
 * @param <T>
 */
public class SyncFusionRequest<T> {

    private T value;
    private String key;
    private String keyColumn;
    private String table;
    private String action;
    private SyncFusionParams params;
    private String requiresCounts;
    private String skip;
    private String take;
    private String antiForgery;
    private String id;
    private List<SyncFusionSorted> sorted;
    private String projectId;
    private String clientId;
    private String sessionId;
    private String token;

    public SyncFusionRequest() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public String getAntiForgery() {
        return antiForgery;
    }

    public void setAntiForgery(String antiForgery) {
        this.antiForgery = antiForgery;
    }

    public void setKeyColumn(String keyColumn) {
        this.keyColumn = keyColumn;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public SyncFusionParams getParams() {
        return params;
    }

    public void setParams(SyncFusionParams params) {
        this.params = params;
    }

    public String getRequiresCounts() {
        return requiresCounts;
    }

    public void setRequiresCounts(String requiresCounts) {
        this.requiresCounts = requiresCounts;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        this.take = take;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   

    public List<SyncFusionSorted> getSorted() {
        return sorted;
    }

    public void setSorted(List<SyncFusionSorted> sorted) {
        this.sorted = sorted;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    

    @Override
    public String toString() {
        return "SyncFusionRequest{" + "value=" + value + ", key=" + key + ", keyColumn=" + keyColumn + ", table=" + table + ", action=" + action + ", params=" + params + ", requiresCounts=" + requiresCounts + ", skip=" + skip + ", take=" + take + '}';
    }    
    

}
