/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobCatgColorListDao;
import com.atser.tools.atserejb.model.GlobCatgColorList;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobCatgColorListServiceImpl implements GlobCatgColorListService, IBaseEJBException {

    @Inject
    private GlobCatgColorListDao dao;

    @Override
    public GlobCatgColorList findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobCatgColorList findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(ManageITHeader header, GlobCatgColorList elem) {
        if (elem != null) {
            elem.setActive('Y');
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, GlobCatgColorList elem) {
        if (elem != null) {
            GlobCatgColorList model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setCode(elem.getCode());
                model.setColor(elem.getColor());
                model.setFontColor(elem.getFontColor());
                model.setText(elem.getText());
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                dao.update(model);
            }
        }
    }

    @Override
    public void update(GlobCatgColorList elem) {
        update(null, elem);
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobCatgColorList> list(ManageITBodyRequest request) {
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
    public DataTableWrapper<GlobCatgColorList> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobCatgColorList> finalList = list(request);
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
    public DataGridWrapper<GlobCatgColorList> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobCatgColorList> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobCatgColorList model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N');
        dao.update(model);
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
