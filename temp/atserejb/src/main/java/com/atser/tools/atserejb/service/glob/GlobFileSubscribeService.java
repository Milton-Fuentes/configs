/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobFileSubscribe;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFileSubscribeService extends ICrudService<BigDecimal, GlobFileSubscribe> {

    void delete(ManageITBodyRequest request);

    void delete(BigInteger fileId, BigInteger subscriberId);

    Boolean extists(BigInteger fileId, BigInteger subscriberId);

    List<String> listSubscribersEmailByFileId(BigInteger fileId);

    List<String> listSubscribersEmailByFileIds(List<BigInteger> fileIds);

}
