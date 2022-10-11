/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobClientEquipcatgDao;
import com.atser.tools.atserejb.model.GlobClientEquipcatg;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobClientEquipcatgServiceImpl implements GlobClientEquipcatgService, IBaseEJBException {

    @Inject
    private GlobClientEquipcatgDao dao;

    @Override
    public GlobClientEquipcatg findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobClientEquipcatg findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobClientEquipcatg elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobClientEquipcatg elem) {
        if (elem != null) {
            GlobClientEquipcatg model = findById(elem.getId());
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
    public List<GlobClientEquipcatg> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
