/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobBiditemMasterDao;
import com.atser.tools.atserejb.model.GlobBiditemMaster;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobBiditemMasterServiceImpl implements GlobBiditemMasterService, IBaseEJBException {

    @Inject
    private GlobBiditemMasterDao dao;

    @Override
    public GlobBiditemMaster findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobBiditemMaster findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(GlobBiditemMaster elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return null;
    }

    @Override
    public void update(GlobBiditemMaster elem) {
        if (elem != null) {
            GlobBiditemMaster model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobBiditemMaster> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public BigDecimal findItemId(String clientId, String itemNo, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(itemNo) || StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findItemId(NumberSupport.getBigDecimal(clientId), itemNo, NumberSupport.getBigDecimal(projectId));
    }

    @Override
    public BigDecimal findItemIdFromBatch(String clientId, String itemNo, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(itemNo) || StringSupport.isNullOrEmpty(projectId)) {
            return BigDecimal.ZERO;
        }
        return dao.findItemId(NumberSupport.getBigDecimal(clientId), itemNo, NumberSupport.getBigDecimal(projectId));
    }

}
