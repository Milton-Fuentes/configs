/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjectClientDao;
import com.atser.tools.atserejb.model.GlobProjectClient;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobProjectClientServiceImpl implements GlobProjectClientService, IBaseEJBException {

    @Inject
    private GlobProjectClientDao dao;

    @Override
    public GlobProjectClient findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjectClient findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjectClient elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProjectClient elem) {
        if (elem != null) {
            GlobProjectClient model = findById(elem.getId());
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
    public List<GlobProjectClient> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Object getFrontEndProjectClientListByCurrentProfile(ManageITHeader header, ManageITBodyRequest body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getProjectClientListByCurrentProfile(header.getUserid(), header.getClientid(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getProjectClientListByCurrentProfileForSelect(header.getUserid(), header.getClientid(), body.getParams());
                }
                case "table": {
                    return getProjectClientListByCurrentProfile(header.getUserid(), header.getClientid(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getProjectClientListByCurrentProfileForSelect(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        List<GlobProjectClient> ds = getProjectClientListByCurrentProfile(userId, clientId, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getProjectClientFullName())).collect(Collectors.toList());
    }

    private List<GlobProjectClient> getProjectClientListByCurrentProfile(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        String functionId = StringSupport.getString(params.get("functionId"));
        boolean isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        boolean uses_global_profiles = StringSupport.getBoolean(params.get("useGlobalProfiles"));
        return dao.getFrontEndProjectClientListByCurrentProfile(userId, clientId, isAdmin, uses_global_profiles, functionId);
    }

}
