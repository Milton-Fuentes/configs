/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTestPlanTestsDao;
import com.atser.tools.atserejb.model.QaTestPlanTests;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QaTestPlanTestsServiceImpl implements QaTestPlanTestsService, IBaseEJBException {

    @Inject
    private QaTestPlanTestsDao dao;

    @Override
    public QaTestPlanTests findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaTestPlanTests findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(QaTestPlanTests elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return null;
    }

    @Override
    public void update(QaTestPlanTests elem) {
        if (elem != null) {
            QaTestPlanTests model = findById(elem.getId());
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
    public List<QaTestPlanTests> list(ManageITBodyRequest request) {
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
    public void batchSaveItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId) {
        dao.batchSaveItemTestFromMaster(testplanId, itemId, createdBy, wbsId);
    }

    @Override
    public void batchSaveSubItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId) {
        dao.batchSaveSubItemTestFromMaster(testplanId, itemId, createdBy, wbsId);
    }

}
