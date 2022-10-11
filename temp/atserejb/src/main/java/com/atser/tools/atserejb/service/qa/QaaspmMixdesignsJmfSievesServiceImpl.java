/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignsJmfSievesDao;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmfSieves;
import com.atser.tools.atserejb.model.VwQaaspmMixJmfsv;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
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

@Stateless
public class QaaspmMixdesignsJmfSievesServiceImpl implements QaaspmMixdesignsJmfSievesService, IBaseEJBException {

    @Inject
    private QaaspmMixdesignsJmfSievesDao dao;

    @Override
    public QaaspmMixdesignsJmfSieves findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignsJmfSieves findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesignsJmfSieves findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignsJmfSieves findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesignsJmfSieves elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaaspmMixdesignsJmfSieves elem) {
        if (elem != null) {
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, QaaspmMixdesignsJmfSieves elem) {
        if (elem != null) {
            QaaspmMixdesignsJmfSieves model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }
        }
    }

    private QaaspmMixdesignsJmfSieves populate(QaaspmMixdesignsJmfSieves model, QaaspmMixdesignsJmfSieves elem) {
        model.setJmfPercPassing(elem.getJmfPercPassing());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNotNullAndNotEmpty(id)) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaaspmMixdesignsJmfSieves> list(ManageITBodyRequest request) {
        List<QaaspmMixdesignsJmfSieves> list;
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
    public DataTableWrapper<QaaspmMixdesignsJmfSieves> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesignsJmfSieves> finalList = list(request);
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
    public DataGridWrapper<QaaspmMixdesignsJmfSieves> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaaspmMixdesignsJmfSieves> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
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
    public void updateBatch(ManageITHeader header, List<VwQaaspmMixJmfsv> data) {
        if (data != null && data.size() > 0) {
            data.forEach(it -> {
                QaaspmMixdesignsJmfSieves model = findById(it.getId());
                model.setJmfPercPassing(it.getJfmPercPassing().doubleValue());
                dao.update(model);
            });
        }
    }

}
