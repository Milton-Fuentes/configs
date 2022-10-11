/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobDispatchcallServicesDao;
import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobDispatchcallServicesServiceImpl implements GlobDispatchcallServicesService, IBaseEJBException {

    @Inject
    private GlobDispatchcallServicesDao dao;

    @Override
    public GlobDispatchcallServices findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobDispatchcallServices findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(GlobDispatchcallServices elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void saveAll(List<GlobDispatchcallServices> elems) {
        dao.save(elems);
    }

    @Override
    public void update(GlobDispatchcallServices elem) {
        if (elem != null) {
            GlobDispatchcallServices model = findById(elem.getId());
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
    public List<GlobDispatchcallServices> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobDispatchcallServices> findByCallLogId(BigInteger id) {
        return dao.findByCallLogId(id);
    }

    @Override
    public void deleteAllByCallLogId(BigInteger id) {
        dao.deleteAllByCallLogId(id);
    }

    @Override
    public Integer getCountCallLogRecords(BigInteger id) {
        return dao.getCountCallLogRecords(id);
    }

}
