/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProfilesDao;
import com.atser.tools.atserejb.model.GlobProfiles;
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
public class GlobProfilesServiceImpl implements GlobProfilesService, IBaseEJBException {

    @Inject
    private GlobProfilesDao dao;

    @Override
    public GlobProfiles findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public List<GlobProfiles> findByUserId(BigInteger id) {
        return dao.findByUserId(id);
    }

    @Override
    public List<GlobProfiles> findByUserId(BigDecimal id) {
        return dao.findByUserId(id.toBigInteger());
    }

    public GlobProfiles findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProfiles elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProfiles elem) {
        if (elem != null) {
            GlobProfiles model = findById(elem.getId());
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
    public List<GlobProfiles> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<String> getEmailListByRole(String role_name, BigInteger clientId) {
        if (StringSupport.isNotNullAndNotEmpty(role_name) && clientId != null) {
            return dao.getEmailListByRole(role_name, clientId);
        }
        return null;
    }

}
