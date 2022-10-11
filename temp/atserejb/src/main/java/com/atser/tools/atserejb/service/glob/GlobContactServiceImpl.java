/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobContactDao;
import com.atser.tools.atserejb.model.GlobContact;
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
public class GlobContactServiceImpl implements GlobContactService, IBaseEJBException {

    @Inject
    private GlobContactDao dao;

    @Override
    public GlobContact findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobContact findById(BigInteger id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobContact findByFirstAndLastName(BigInteger clientId, String firstname, String lastname) {
        if (clientId != null && StringSupport.isNotNullAndNotEmpty(firstname)) {
            return dao.findByFirstAndLastName(clientId, firstname, lastname);
        }
        return null;
    }

    public GlobContact findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobContact elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobContact elem) {
        if (elem != null) {
            GlobContact model = findById(elem.getId());
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
    public List<GlobContact> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public BigDecimal findByContactIdByEmail(BigInteger clientId, String email) {
        if (clientId != null && StringSupport.isNotNullAndNotEmpty(email)) {
            return dao.findByContactIdByEmail(clientId, email);
        }
        return null;
    }
}
