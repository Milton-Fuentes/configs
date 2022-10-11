/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.sp;

import com.atser.tools.atserejb.dao.sp.NcrLogDao;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.objects.to.gateway.NcrLogTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class NcrLogServiceImpl implements NcrLogService, IBaseEJBException {

    @Inject
    private NcrLogDao dao;

    @Override
    public List<NcrLogTO> filter(ManageITBodyRequest request) {
        if (request.getParams() == null || !request.getParams().isContainsAllKeys(new String[]{"pnumber"})
                || StringSupport.isNullOrEmpty(request.getParams().get("pnumber"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing params.");
        }

        return dao.filter(request.getParams().get("pnumber").toString());
    }

}
