/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.response;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;

/**
 *
 * @author droldan
 */
public class ManageITResponse {
    
    private ManageITHeader header;
    private ManageITBodyResponse body;

    public ManageITResponse() {
    }

    public ManageITHeader getHeader() {
        return header;
    }

    public void setHeader(ManageITHeader header) {
        this.header = header;
    }

    public ManageITBodyResponse getBody() {
        return body;
    }

    public void setBody(ManageITBodyResponse body) {
        this.body = body;
    }
}
