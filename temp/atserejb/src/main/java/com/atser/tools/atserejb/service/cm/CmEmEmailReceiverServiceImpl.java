/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmEmEmailReceiverDao;
import com.atser.tools.atserejb.model.CmEmEmailReceiver;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author dperez
 */
@Stateless
public class CmEmEmailReceiverServiceImpl implements CmEmEmailReceiverService, IBaseEJBException {

    @Inject
    private CmEmEmailReceiverDao dao;

    @Override
    public CmEmEmailReceiver findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public CmEmEmailReceiver findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(CmEmEmailReceiver elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.save(elem).getId().toBigInteger();
    }

    @Override
    public void update(CmEmEmailReceiver elem) {
        if (elem != null) {
            CmEmEmailReceiver model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        if (!id.isEmpty()) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<CmEmEmailReceiver> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
