/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.mgmt;

import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import java.io.Serializable;

/**
 * 
 * @author droldan
 */
public class MetaDataExcelBo implements Serializable{
    private String id;
    private Object data;
    private SyncFusionEnvInfo envinfo;

    public MetaDataExcelBo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SyncFusionEnvInfo getEnvinfo() {
        return envinfo;
    }

    public void setEnvinfo(SyncFusionEnvInfo envinfo) {
        this.envinfo = envinfo;
    }    
    
}
