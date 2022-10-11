/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobContractDao;
import com.atser.tools.atserejb.model.GlobContract;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobContractServiceImpl implements GlobContractService, IBaseEJBException {

    @Inject
    private GlobContractDao dao;

    @Override
    public GlobContract findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobContract findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobContract elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobContract elem) {
        if (elem != null) {
            GlobContract model = findById(elem.getId());
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
    public List<GlobContract> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
