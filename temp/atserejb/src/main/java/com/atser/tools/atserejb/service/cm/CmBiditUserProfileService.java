/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditUserProfile;
import com.atser.tools.atserutil.objects.pojo.cm.CmBiditUserProfileSearchDefParam;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface CmBiditUserProfileService extends ICrudService<BigDecimal, CmBiditUserProfile> {

    CmBiditUserProfile findById(ManageITHeader header, String id);

    CmBiditUserProfile findById(ManageITHeader header, BigDecimal id);

    Object getFrontEndSearch(ManageITHeader header, CmBiditUserProfileSearchDefParam body);

    void changeStatus(ManageITBodyRequest body);
}
