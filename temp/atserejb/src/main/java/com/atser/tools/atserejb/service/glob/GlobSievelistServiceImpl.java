/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobSievelistDao;
import com.atser.tools.atserejb.model.GlobSievelist;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobSievelistServiceImpl implements GlobSievelistService, IBaseEJBException {

    @Inject
    private GlobSievelistDao dao;

    @Override
    public GlobSievelist findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobSievelist findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal findIdByCommonName(String commonname) {
        if (StringSupport.isNotNullAndNotEmpty(commonname)) {
            return dao.findIdByCommonName(commonname);
        }
        return null;
    }

    @Override
    public void save(GlobSievelist elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobSievelist elem) {
        if (elem != null) {
            GlobSievelist model = findById(elem.getId());
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
    public List<GlobSievelist> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
