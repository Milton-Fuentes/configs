/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobSpecItemMatDao;
import com.atser.tools.atserejb.model.GlobSpecItemMat;
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
public class GlobSpecItemMatServiceImpl implements GlobSpecItemMatService, IBaseEJBException {

    @Inject
    private GlobSpecItemMatDao dao;

    @Override
    public GlobSpecItemMat findById(String id) {
        return findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobSpecItemMat findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobSpecItemMat elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobSpecItemMat elem) {
        if (elem != null) {
            GlobSpecItemMat model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobSpecItemMat> list(ManageITBodyRequest request) {
        List<GlobSpecItemMat> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public List<GlobSpecItemMat> getSpecItemMatByItemNo(BigInteger projectId, String itemType, String specItemNo) {
        if(projectId == null || StringSupport.isNullOrEmpty(itemType, specItemNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getSpecItemMatByItemNo(projectId, itemType, specItemNo);
    }

    @Override
    public String getSpecItemMatNameByItemNo(BigInteger projectId, String itemType, String specItemNo) {
        if(projectId == null || StringSupport.isNullOrEmpty(itemType, specItemNo)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getSpecItemMatNameByItemNo(projectId, itemType, specItemNo);
    }

}
