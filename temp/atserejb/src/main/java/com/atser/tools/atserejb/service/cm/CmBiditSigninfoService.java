/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author mdelabat
 */
public interface CmBiditSigninfoService extends ICrudService<BigDecimal, CmBiditSigninfo> {

    void sign(ManageITHeader header, ManageITBodyRequest request, String serverPath, String tplbasePath, String docpathsegment, String server_domain, TemplateEngine engine);

    List<CmBiditSigninfo> buildSignList(ManageITHeader header, ManageITBodyRequest request);
    
    Boolean isSignedOff(BigInteger clientId, BigInteger refId, String code, String shortName);
}
