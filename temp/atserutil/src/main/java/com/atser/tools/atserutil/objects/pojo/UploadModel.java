/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author droldan
 */
// @AllArgsConstructor
// @Getter
public class UploadModel {

    private Map<String, Object> params;
    private Map<String, Object> metaDataFile;

    public UploadModel() {
    }

    public UploadModel(Map<String, Object> params, Map<String, Object> metaDataFile) {
        this.params = params;
        this.metaDataFile = metaDataFile;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getMetaDataFile() {
        return metaDataFile;
    }

    public void setMetaDataFile(Map<String, Object> metaDataFile) {
        this.metaDataFile = metaDataFile;
    }

}
