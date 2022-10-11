/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjectSpecsSoilcompDao;
import com.atser.tools.atserejb.model.GlobProjectSpecsSoilcomp;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobProjectSpecsSoilcompServiceImpl implements GlobProjectSpecsSoilcompService, IBaseEJBException {

    @Inject
    private GlobProjectSpecsSoilcompDao dao;

    @Override
    public GlobProjectSpecsSoilcomp findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjectSpecsSoilcomp findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjectSpecsSoilcomp elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProjectSpecsSoilcomp elem) {
        if (elem != null) {
            GlobProjectSpecsSoilcomp model = findById(elem.getId());
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
    public List<GlobProjectSpecsSoilcomp> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
