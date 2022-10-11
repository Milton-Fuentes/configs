/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobCustomConfigDao;
import com.atser.tools.atserejb.model.GlobCustomConfig;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobCustomConfigServiceImpl implements GlobCustomConfigService, IBaseEJBException {

    @Inject
    private GlobCustomConfigDao dao;

    @Override
    public GlobCustomConfig findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobCustomConfig findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobCustomConfig elem) {
        if (elem != null) {
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, GlobCustomConfig elem) {
        if (elem != null) {
            GlobCustomConfig model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobCustomConfig populate(GlobCustomConfig model, GlobCustomConfig elem) {
        model.setName(elem.getName());
        model.setDescription(elem.getDescription());
        model.setFunctionality(elem.getFunctionality());
        model.setValue(elem.getValue());
        model.setDatatype(elem.getDatatype());
        model.setDataurl(elem.getDataurl());
        model.setLoadSession(elem.getLoadSession());
        model.setCustomizable(elem.getCustomizable());
        return model;
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
    public List<GlobCustomConfig> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<GlobCustomConfig> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<GlobCustomConfig> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobCustomConfig> finalList = list(request);
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

    @Override
    public String findValueByClientAndFunctionalityAndNameAndUserId(BigInteger clientId, String functionality, String name, BigInteger userId) {
        if (clientId == null || StringSupport.isNullOrEmpty(name)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findValueByClientAndFunctionalityAndNameAndUserId(clientId, functionality, name, userId);
    }

    @Override
    public List<GlobCustomConfig> listPendingConfigsByClientAndFunctionalityAndUserId(BigInteger clientId, String functionality, BigInteger userId) {
        if (clientId == null || userId == null || StringSupport.isNullOrEmpty(functionality)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.listPendingConfigsByClientAndFunctionalityAndUserId(clientId, functionality, userId);
    }

}
