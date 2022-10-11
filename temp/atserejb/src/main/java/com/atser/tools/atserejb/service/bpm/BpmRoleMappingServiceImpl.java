/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.dao.bpm.BpmRoleMappingDao;
import com.atser.tools.atserejb.model.BpmRoleMapping;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BpmRoleMappingServiceImpl implements BpmRoleMappingService, IBaseEJBException {

    @Inject
    private BpmRoleMappingDao dao;

    @Override
    public BpmRoleMapping findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public BpmRoleMapping findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BpmRoleMapping findByManageItRoleAndClientID(String role, BigInteger id) {
        return dao.findByManageItRoleAndClientID(role, id);
    }

    @Override
    public void save(BpmRoleMapping elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(BpmRoleMapping elem) {
        if (elem != null) {
            BpmRoleMapping model = findById(elem.getId());
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
    public List< BpmRoleMapping> list(ManageITBodyRequest request) {
       if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
