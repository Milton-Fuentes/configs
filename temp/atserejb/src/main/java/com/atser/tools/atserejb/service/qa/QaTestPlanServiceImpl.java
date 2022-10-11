/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTestPlanDao;
import com.atser.tools.atserejb.model.QaTestPlan;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaTestPlanServiceImpl implements QaTestPlanService, IBaseEJBException {

    @Inject
    private QaTestPlanDao dao;

    @Override
    public QaTestPlan findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaTestPlan findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(QaTestPlan elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return null;
    }

    @Override
    public void update(QaTestPlan elem) {
        if (elem != null) {
            QaTestPlan model = findById(elem.getId());
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
    public List<QaTestPlan> list(ManageITBodyRequest request) {
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
    public void setBatchExecutionFlag(String test_plan_id) {
        QaTestPlan model = findById(test_plan_id);
        if (model != null) {
            model.setField2("Y");
            dao.update(model);
        }
    }

    @Override
    public QaTestPlan batchGetTestPlan(BigInteger projectId) {
        if (projectId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.batchGetTestPlan(projectId);
    }

    @Override
    public String getInitApproverEmail(BigInteger testplanid) {
        if (testplanid != null) {
            dao.getInitApproverEmail(testplanid);
        }
        return null;
    }

}
