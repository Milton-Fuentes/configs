/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmDailyLocationDao;
import com.atser.tools.atserejb.model.CmDailyLocation;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CmDailyLocationServiceImpl implements CmDailyLocationService, IBaseEJBException {

    @Inject
    private CmDailyLocationDao dao;

    @Override
    public CmDailyLocation findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public CmDailyLocation findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(CmDailyLocation elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(CmDailyLocation elem) {
        if (elem != null) {
            CmDailyLocation model = findById(elem.getId());
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
    public List<CmDailyLocation> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public String getDailyLocation(String locationId) {
        if (StringSupport.isNotNullAndNotEmpty(locationId) && !locationId.equals("-1")) {
            return dao.getDailyLocation(locationId);
        }
        return "N/A";
    }

    @Override
    public String getDailyLocation(BigInteger locationId) {
        if (locationId == null) {
            return "N/A";
        }
        return getDailyLocation(locationId.toString());
    }
}
