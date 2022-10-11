/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmForm;
import com.atser.tools.atserutil.objects.bo.cm.CmFormRFIBO;
import com.atser.tools.atserutil.objects.bo.cm.CmFormSubmittalBO;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmFormService extends ICrudService<BigDecimal, CmForm> {

    List<DataSelectWrapper> getRFISelectList(BigInteger clientId);

    List<DataSelectWrapper> getSubmittalSelectList(BigInteger clientId);

    void setBpmProcessDone(BigInteger id, Character status);
    
    CmFormRFIBO rfiFindById(String id);
    
    CmFormSubmittalBO submittalsFindById(String id);

    void changeBpmStatus(ManageITBodyRequest<Object> request);
}
