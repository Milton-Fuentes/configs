/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobStakeholderDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.AppTableImg;
import com.atser.tools.atserejb.model.GlobStakeholder;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.BpmTaskMatrix;
import com.atser.tools.atserutil.date.DateSupport;
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
public class GlobStakeholderServiceImpl implements GlobStakeholderService, IBaseEJBException {

    @Inject
    private GlobStakeholderDao dao;

    @Override
    public GlobStakeholder findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobStakeholder findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobStakeholder elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobStakeholder elem) {
        if (elem != null) {
            GlobStakeholder model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobStakeholder populate(GlobStakeholder model, GlobStakeholder elem) {
        model.setFirstname(elem.getFirstname());
        model.setMiddlename(elem.getMiddlename());
        model.setLastname(elem.getLastname());
        model.setPhone(elem.getPhone());
        model.setEmail(elem.getEmail());
        model.setTitle(elem.getTitle());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
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
    public DataTableWrapper<GlobStakeholder> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobStakeholder> finalList = list(request);
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
    public DataGridWrapper<GlobStakeholder> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public List<GlobStakeholder> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<GlobStakeholder> list = list(request);
        list.forEach(it -> {
            String value = "";
            if (StringSupport.isNotNullAndNotEmpty(it.getFirstname())) {
                value += it.getFirstname();
            }
            if (StringSupport.isNotNullAndNotEmpty(it.getMiddlename())) {
                if (!value.isEmpty()) {
                    value += " ";
                }
                value += it.getMiddlename();
            }
            if (StringSupport.isNotNullAndNotEmpty(it.getLastname())) {
                if (!value.isEmpty()) {
                    value += " ";
                }
                value += it.getLastname();
            }
            rlist.add(new DataSelectWrapper(it.getId(), value));
        });
        return rlist;
    }

    @Override
    public List<String> listEmailByIds(String ids) {

        // List all next task by origen-task-id.
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("id", ids, ":=");
        List<GlobStakeholder> list = list(search);

        List<String> emails = new ArrayList<>();
        list.forEach(globStakeholder -> {
            emails.add(globStakeholder.getEmail());
        });

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
