/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleCatgDao;
import com.atser.tools.atserejb.model.QaSampleCatg;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaSampleCatgServiceImpl implements QaSampleCatgService, IBaseEJBException {

    @Inject
    private QaSampleCatgDao dao;

    @Override
    public QaSampleCatg findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleCatg findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaSampleCatg elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaSampleCatg elem) {
        if (elem != null) {
            QaSampleCatg model = findById(elem.getId());
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
    public List<QaSampleCatg> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Object getsampleCatgListByClient(ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getsampleCatgListByClientForSelect(header.getUserid(), header.getClientid(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getsampleCatgListByClientForSelect(header.getUserid(), header.getClientid(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getsampleCatgListByClientForSelect(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        List<QaSampleCatg> ds = getsampleCatgListByClientModel(userId, clientId, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getDescription())).collect(Collectors.toList());
    }

    private List<QaSampleCatg> getsampleCatgListByClientModel(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        return dao.getsampleCatgListByClientModel(clientId);
    }

}
