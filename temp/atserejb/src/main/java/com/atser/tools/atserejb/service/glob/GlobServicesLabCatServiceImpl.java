/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobServicesLabCatDao;
import com.atser.tools.atserejb.model.GlobServicesLabCat;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobServicesLabCatServiceImpl implements GlobServicesLabCatService, IBaseEJBException {

    @Inject
    private GlobServicesLabCatDao dao;

    @Override
    public GlobServicesLabCat findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobServicesLabCat findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobServicesLabCat elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobServicesLabCat elem) {
        if (elem != null) {
            GlobServicesLabCat model = findById(elem.getId());
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
    public List<GlobServicesLabCat> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
