/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobFunctionsDao;
import com.atser.tools.atserejb.model.GlobFunctions;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobFunctionsServiceImpl implements GlobFunctionsService, IBaseEJBException {

    @Inject
    private GlobFunctionsDao dao;

    @Override
    public GlobFunctions findById(String id) {
        return findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobFunctions findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobFunctions elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobFunctions elem) {
        if (elem != null) {
            GlobFunctions model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobFunctions> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            return dao.findAll();
        }
    }

    @Override
    public List<DataSelectWrapper> filterByProject(String projectId, String labId) {
        if (StringSupport.isNullOrEmpty(projectId) || StringSupport.isNullOrEmpty(labId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong params.");
        }
        List<GlobFunctions> model = dao.filterByProject(NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(labId));
        if (model != null) {
            return model.stream().map(p -> new DataSelectWrapper(p.getId(), p.getFName())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
