/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.lab.GlobLabsBO;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.atser.tools.atserejb.dao.glob.GlobLabsDao;

@Stateless
public class GlobLabsServiceImpl implements GlobLabsService, IBaseEJBException {

    @Inject
    private GlobLabsDao dao;

    @Override
    public GlobLabs findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLabs findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public GlobLabs findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobLabs findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobLabs elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public GlobLabs findById(BigInteger clientId, BigInteger labId, BigInteger functionId) {
        return dao.findById(clientId, labId, functionId);
    }

    @Override
    public void save(ManageITHeader header, GlobLabs elem) {
        if (elem != null) {
            elem.setLastMod(new Date());
            dao.save(elem);
        }
    }

    @Override
    public void save(List<GlobLabs> elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, GlobLabs elem) {
        if (elem != null) {
            GlobLabs model = findById(elem.getId());
            elem.setLastMod(new Date());
            dao.update(populate(model, elem));
        }
    }

    private GlobLabs populate(GlobLabs model, GlobLabs elem) {
        return model;
    }

    @Override
    public void updateLabId(GlobLabs elem) {
        if (elem != null) {
            dao.update(elem);
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobLabs> list(ManageITBodyRequest request) {
        List<GlobLabs> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobLabs> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobLabs> finalList = list(request);
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
    public Boolean exists(BigInteger clientId, BigInteger labId, BigInteger functionId) {
        return dao.exists(clientId, labId, functionId);
    }

    @Override
    public Object getLabFunctionList(ManageITHeader header, ManageITBodyRequest<Object> body) {
        if (body.getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String datatype = StringSupport.getString(body.getParams().get("dt"));
        if (StringSupport.isNullOrEmpty(datatype)) {
            return getLabFunctionListForSelect(header.getUserid(), header.getClientid(), body.getParams());
        } else {
            switch (datatype) {
                case "select": {
                    return getLabFunctionListForSelect(header.getUserid(), header.getClientid(), body.getParams());
                }
            }
        }
        return new ArrayList<>();
    }

    private List<DataSelectWrapper> getLabFunctionListForSelect(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        List<GlobLabsBO> ds = getLabFunctionListModel(userId, clientId, params);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        Boolean includeModel = (StringSupport.isNullOrEmpty(params.get("imod"))) ? Boolean.FALSE : StringSupport.getBoolean(params.get("imod"));
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getFullName(), (includeModel ? p : null))).collect(Collectors.toList());
    }

    private List<GlobLabsBO> getLabFunctionListModel(String userId, String clientId, AtserLinkedHashMap<String, Object> params) {
        boolean isAdmin = StringSupport.getBoolean(params.get("isAdmin"));
        BigInteger projectId = NumberSupport.getBigInteger(params.get("projectId"));
        return dao.getLabFunctionListModel(userId, clientId, isAdmin, projectId);
    }
}
