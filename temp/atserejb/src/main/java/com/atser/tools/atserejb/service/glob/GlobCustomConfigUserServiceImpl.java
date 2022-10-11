/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobCustomConfigUserDao;
import com.atser.tools.atserejb.model.GlobCustomConfig;
import com.atser.tools.atserejb.model.GlobCustomConfigUser;
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
public class GlobCustomConfigUserServiceImpl implements GlobCustomConfigUserService, IBaseEJBException {

    @Inject
    private GlobCustomConfigUserDao dao;

    @Inject
    private GlobCustomConfigService globCustomConfigService;

    @Override
    public GlobCustomConfigUser findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobCustomConfigUser findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobCustomConfigUser elem) {
        if (elem != null) {
            if (elem.getConfigId() != null && elem.getConfigId().getId() != null) {
                if(dao.exists(NumberSupport.getBigInteger(elem.getConfigId().getId()), elem.getUserId())) {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "Setting already exists !");
                }
                GlobCustomConfig configId = globCustomConfigService.findById(elem.getConfigId().getId());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setActive('Y');
                elem.setConfigId(configId);
                elem.setValue(configId.getValue());
                return dao.save(elem).getId();
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Configuration not found !");
            }
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, GlobCustomConfigUser elem) {
        if (elem != null) {
            GlobCustomConfigUser model = findById(elem.getId());
            model.setLastMod(new Date());
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            dao.update(populate(model, elem));
        }
    }

    private GlobCustomConfigUser populate(GlobCustomConfigUser model, GlobCustomConfigUser elem) {
        model.setValue(elem.getValue());
        return model;
    }

    @Override
    public void updateBatch(ManageITHeader header, List<GlobCustomConfigUser> data) {
        if (data != null && data.size() > 0) {
            data.forEach(it -> {
                GlobCustomConfigUser model = findById(it.getId());
                model.setValue(it.getValue());
                dao.update(model);
            });
        }
    }

    @Override
    public void delete(String id) {
        delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobCustomConfigUser> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<GlobCustomConfigUser> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<GlobCustomConfigUser> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobCustomConfigUser> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
