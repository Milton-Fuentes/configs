/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.AppTableImg;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface AppTableImgService extends ICrudService<BigDecimal, AppTableImg> {

    void delete(ManageITBodyRequest request);

    void saveDataFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void updateDataFileDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void updateFileDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    List<DataSelectWrapper> listForSelect(ManageITBodyRequest request);

    Boolean exists(String email);

    void changeStatus(ManageITBodyRequest request);
}
