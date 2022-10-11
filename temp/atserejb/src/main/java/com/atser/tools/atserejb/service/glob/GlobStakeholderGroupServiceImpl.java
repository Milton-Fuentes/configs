/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobStakeholderGroupDao;
import com.atser.tools.atserejb.model.GlobStakeholder;
import com.atser.tools.atserejb.model.GlobStakeholderGroup;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobStakeholderGroupServiceImpl implements GlobStakeholderGroupService, IBaseEJBException {

    @Inject
    private GlobStakeholderGroupDao dao;

    @Override
    public GlobStakeholderGroup findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobStakeholderGroup findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobStakeholderGroup elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobStakeholderGroup elem) {
        if (elem != null) {
            GlobStakeholderGroup model = findById(elem.getId());
            //if (!model.equals(elem)) {
            dao.save(populate(model, elem));
            //}
        }
    }

    private GlobStakeholderGroup populate(GlobStakeholderGroup model, GlobStakeholderGroup elem) {
        model.setId(elem.getId());
        model.setClientId(elem.getClientId());
        model.setName(elem.getName());
        model.setDescription(elem.getDescription());
        model.setStatus(elem.getStatus());
        model.setGlobStakeholderList(elem.getGlobStakeholderList());
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
    public DataTableWrapper<GlobStakeholderGroup> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobStakeholderGroup> finalList = list(request);
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
    public DataGridWrapper<GlobStakeholderGroup> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public List<GlobStakeholderGroup> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<GlobStakeholderGroup> list = list(request);
        list.forEach(it -> {
            String value = "";
            if (StringSupport.isNotNullAndNotEmpty(it.getName())) {
                value += it.getName();
            }
            rlist.add(new DataSelectWrapper(it.getId(), value));
        });
        return rlist;
    }

    @Override
    public List<String> listEmailByIds(String ids) {
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("id", ids, ":=");
        List<GlobStakeholderGroup> list = list(search);

        List<String> emails = new ArrayList<>();
        for (GlobStakeholderGroup item : list) {
            List<GlobStakeholder> stkhList = item.getGlobStakeholderList();
            for (GlobStakeholder stkh : stkhList) {
                emails.add(stkh.getEmail());
            }
        }
        return emails;
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
