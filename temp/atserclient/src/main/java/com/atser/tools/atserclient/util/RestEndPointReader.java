/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserclient.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author droldan
 * @param <T>
 */
public class RestEndPointReader<T> {

    private final Client rxClient;
    private WebTarget rxTarget;
    private Response rxResponse;
    private String mediaType;
    private final String url;

    public RestEndPointReader(String url) {
        this.rxClient = ClientBuilder.newClient();
        this.rxTarget = rxClient.target(url);
        this.mediaType = MediaType.APPLICATION_JSON;
        this.url = url;
    }

    public RestEndPointReader(String url, String mediaType) {
        this.rxClient = ClientBuilder.newClient();
        this.rxTarget = rxClient.target(url);
        this.mediaType = mediaType;
        this.url = url;
    }

    public RestEndPointReader<T> readEndPointByPost(T parameters) {
        this.rxResponse = this.rxTarget.request().accept(this.mediaType).post(Entity.json(parameters));
        return this;
    }

    public RestEndPointReader<T> readEndPointByGet(Class clazz) {
        this.rxTarget.request().accept(this.mediaType).get(clazz);
        return this;
    }

    public Boolean verifyResponseRs(Response rpx) {
        String responseHTTP = rpx.getStatusInfo().getReasonPhrase();
        int codeResponseHTTP = rpx.getStatusInfo().getStatusCode();
        Response.Status.Family typeResponseHTTP = rpx.getStatusInfo().getFamily();

        if (Response.Status.Family.SUCCESSFUL == typeResponseHTTP) {
            System.out.println("Response.Status.Family.SUCCESSFUL");
            System.out.println(codeResponseHTTP);
            return Boolean.TRUE;
        } else {
            System.out.println("Response.Status.Family.ERROR");
            System.out.println(codeResponseHTTP);
            System.out.println(responseHTTP);

        }
        return Boolean.FALSE;
    }

    public void closeCx() {
        if (this.rxClient != null) {
            this.rxClient.close();
        }
    }

    public WebTarget getRxTarget() {
        return rxTarget;
    }

    public void setRxTarget(WebTarget rxTarget) {
        this.rxTarget = rxTarget;
    }

    public Response getRxResponse() {
        return rxResponse;
    }

    public void setRxResponse(Response rxResponse) {
        this.rxResponse = rxResponse;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getUrl() {
        return url;
    }
}
