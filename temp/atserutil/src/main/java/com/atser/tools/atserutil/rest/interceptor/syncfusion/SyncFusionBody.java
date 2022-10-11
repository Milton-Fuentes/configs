/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.syncfusion;

/**
 *
 * @author droldan
 */
public class SyncFusionBody {

    private Object data;
    private SyncFusionMsg msg;
    

    public SyncFusionBody() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }    

    public SyncFusionMsg getMsg() {
        return msg;
    }

    public void setMsg(SyncFusionMsg msg) {
        this.msg = msg;
    }
    
}
