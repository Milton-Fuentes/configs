/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.request;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.util.Objects;

/**
 *
 * @author droldan
 * @param <T>
 */
public class ManageITRequest<T> {

    private ManageITHeader header;
    private ManageITBodyRequest<T> body;

    public ManageITRequest() {
    }

    public ManageITRequest(ManageITHeader header, ManageITBodyRequest<T> body) {
        this.header = header;
        this.body = body;
    }

    public ManageITHeader getHeader() {
        return header;
    }

    public void setHeader(ManageITHeader header) {
        this.header = header;
    }

    public ManageITBodyRequest<T> getBody() {
        return body;
    }

    public void setBody(ManageITBodyRequest<T> body) {
        this.body = body;
    }   
    
    public Boolean validate() {
        return Objects.nonNull(header) && Objects.nonNull(body);
    }

}
