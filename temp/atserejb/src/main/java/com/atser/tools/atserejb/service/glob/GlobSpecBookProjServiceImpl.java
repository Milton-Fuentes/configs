/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobSpecBookProjDao;
import com.atser.tools.atserejb.model.GlobSpecBookProj;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobSpecBookProjServiceImpl implements GlobSpecBookProjService, IBaseEJBException {

    @Inject
    private GlobSpecBookProjDao dao;

    @Override
    public GlobSpecBookProj findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobSpecBookProj findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public List<GlobSpecBookProj> findByProjectId(BigInteger pId) {
        return dao.findByProjectId(pId);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobSpecBookProj elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobSpecBookProj elem) {
        if (elem != null) {
            GlobSpecBookProj model = findById(elem.getId());
            //if (!model.equals(elem)) {
            dao.save(populate(model, elem));
            //}
        }
    }

    private GlobSpecBookProj populate(GlobSpecBookProj model, GlobSpecBookProj elem) {
        model.setId(elem.getId());
        model.setProjectId(elem.getProjectId());
        model.setSpecBookId(elem.getSpecBookId());
        model.setField1(elem.getField1());
        model.setField2(elem.getField2());
        model.setField3(elem.getField3());
        model.setField4(elem.getField4());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public DataTableWrapper<GlobSpecBookProj> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobSpecBookProj> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public DataGridWrapper<GlobSpecBookProj> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public List<GlobSpecBookProj> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
