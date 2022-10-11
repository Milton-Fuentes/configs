/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobDepartmentLocationDao;
import com.atser.tools.atserejb.model.GlobDepartmentLocation;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobDepartmentLocationServiceImpl implements GlobDepartmentLocationService, IBaseEJBException {

    @Inject
    private GlobDepartmentLocationDao dao;

    @Override
    public GlobDepartmentLocation findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobDepartmentLocation findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobDepartmentLocation elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobDepartmentLocation elem) {
        if (elem != null) {
            GlobDepartmentLocation model = findById(elem.getId());
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
    public List<GlobDepartmentLocation> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
