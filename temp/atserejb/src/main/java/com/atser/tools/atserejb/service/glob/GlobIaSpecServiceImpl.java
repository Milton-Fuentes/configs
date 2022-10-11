/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobIaSpecDao;
import com.atser.tools.atserejb.model.GlobIaSpec;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobIaSpecServiceImpl implements GlobIaSpecService, IBaseEJBException {

    @Inject
    private GlobIaSpecDao dao;

    @Override
    public GlobIaSpec findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobIaSpec findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobIaSpec elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobIaSpec elem) {
        if (elem != null) {
            GlobIaSpec model = findById(elem.getId());
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
    public List<GlobIaSpec> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public BigDecimal getMaxSpecIdByTypeAndClient(String specType, BigInteger clientId) {
        if (StringSupport.isNullOrEmpty(specType) || clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getMaxSpecIdByTypeAndClient(specType, clientId);
    }

}
