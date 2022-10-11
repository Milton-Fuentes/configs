/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaaspmMixdesignJmfsvMasterDao;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfsvMaster;
import com.atser.tools.atserejb.model.VwQaaspmMixJmfsvMaster;
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

@Stateless
public class QaaspmMixdesignJmfsvMasterServiceImpl implements QaaspmMixdesignJmfsvMasterService, IBaseEJBException {

    @Inject
    private QaaspmMixdesignJmfsvMasterDao dao;

    @Override
    public QaaspmMixdesignJmfsvMaster findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignJmfsvMaster findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QaaspmMixdesignJmfsvMaster findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaaspmMixdesignJmfsvMaster findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QaaspmMixdesignJmfsvMaster elem = dao.findById(id);
            return elem;
        }
    }

    @Override
    public void save(ManageITHeader header, QaaspmMixdesignJmfsvMaster elem) {
        if (elem != null) {
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, QaaspmMixdesignJmfsvMaster elem) {
        if (elem != null) {
            QaaspmMixdesignJmfsvMaster model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                dao.update(populate(model, elem));
            }
        }
    }

    private QaaspmMixdesignJmfsvMaster populate(QaaspmMixdesignJmfsvMaster model, QaaspmMixdesignJmfsvMaster elem) {
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
    public List<QaaspmMixdesignJmfsvMaster> list(ManageITBodyRequest request) {
        List<QaaspmMixdesignJmfsvMaster> list;
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
    public DataTableWrapper<QaaspmMixdesignJmfsvMaster> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaaspmMixdesignJmfsvMaster> finalList = list(request);
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
    public DataGridWrapper<QaaspmMixdesignJmfsvMaster> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaaspmMixdesignJmfsvMaster> finalList = list(request);
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
    public void updateBatch(ManageITHeader header, List<VwQaaspmMixJmfsvMaster> data) {
        if (data != null && data.size() > 0) {
            data.forEach(it -> {
                QaaspmMixdesignJmfsvMaster model = findById(it.getId());
                model.setJmfPercPassing(it.getJfmPercPassing());
                dao.update(model);
            });
        }
    }

}
