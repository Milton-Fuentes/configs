/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.response;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITMsg;

/**
 *
 * @author droldan
 */
public class ManageITBodyResponse {

    private Object data;
    private ManageITMsg msg;
    

    public ManageITBodyResponse() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }    

    public ManageITMsg getMsg() {
        return msg;
    }

    public void setMsg(ManageITMsg msg) {
        this.msg = msg;
    }
    
}
