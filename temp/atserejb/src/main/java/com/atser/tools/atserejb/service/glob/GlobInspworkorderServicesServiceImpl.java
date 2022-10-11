/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobInspworkorderServicesDao;
import com.atser.tools.atserejb.model.GlobInspworkorderServices;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobInspworkorderServicesServiceImpl implements GlobInspworkorderServicesService, IBaseEJBException {

    @Inject
    private GlobInspworkorderServicesDao dao;

    @Override
    public GlobInspworkorderServices findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobInspworkorderServices findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(GlobInspworkorderServices elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void saveAll(List<GlobInspworkorderServices> elems) {
        dao.save(elems);
    }

    @Override
    public void update(GlobInspworkorderServices elem) {
        if (elem != null) {
            GlobInspworkorderServices model = findById(elem.getId());
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
    public List<GlobInspworkorderServices> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobInspworkorderServices> findByWOId(BigInteger id) {
        return dao.findByWOId(id);
    }

    @Override
    public void deleteAllByWOId(BigInteger id) {
        dao.deleteAllByWOId(id);
    }

    @Override
    public Integer getCountWORecords(BigInteger id) {
        return dao.getCountWORecords(id);
    }

}
