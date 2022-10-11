/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTestMethodsDao;
import com.atser.tools.atserejb.model.QaTestMethods;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaTestMethodsBO;
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
public class QaTestMethodsServiceImpl implements QaTestMethodsService, IBaseEJBException {

    @Inject
    private QaTestMethodsDao dao;

    @Override
    public QaTestMethods findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaTestMethods findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public Object findBySampleTestId(String sampleTestId) {
        if (sampleTestId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");

        }
        return dao.findBySampleTestId(NumberSupport.getBigInteger(sampleTestId));
    }

    @Override
    public void save(QaTestMethods elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaTestMethods elem) {
        if (elem != null) {
            QaTestMethods model = findById(elem.getId());
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
    public List<QaTestMethods> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public Object getFrontEndTestMethodsByCatg(ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getTestMethodsByCatgForSelect(header.getClientid(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getTestMethodsByCatgForSelect(header.getClientid(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getTestMethodsByCatgForSelect(String clientId, AtserLinkedHashMap<String, Object> params) {
        List<QaTestMethodsBO> ds = getTestMethodsByCatgModel(clientId, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getDisplayName())).collect(Collectors.toList());
    }

    private List<QaTestMethodsBO> getTestMethodsByCatgModel(String clientId, AtserLinkedHashMap<String, Object> params) {
        String catgId = StringSupport.getString(params.get("catgId"));
        return dao.getTestMethodsByCatg(clientId, catgId);
    }

    @Override
    public List<QaTestMethods> getTestMethodsByCatgAndTestTable(BigInteger clientId, String catg, String testTable) {
        if (clientId == null || StringSupport.isNullOrEmpty(catg, testTable)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getTestMethodsByCatgAndTestTable(clientId, catg, testTable);
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<QaTestMethods> list = list(request);
        list.forEach(it -> {
            rlist.add(new DataSelectWrapper(it.getId(), it.getName()));
        });
        return rlist;
    }

}
