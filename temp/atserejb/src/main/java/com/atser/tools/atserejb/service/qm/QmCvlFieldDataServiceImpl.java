/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.dao.qm.QmCvlFieldDataDao;
import com.atser.tools.atserejb.model.QmCvlField;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QmCvlFieldDataServiceImpl implements QmCvlFieldDataService, IBaseEJBException {

    @Inject
    private QmCvlFieldDataDao dao;

    @Override
    public QmCvlFieldData findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QmCvlFieldData findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QmCvlFieldData elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QmCvlFieldData elem) {
        if (elem != null) {
            QmCvlFieldData model = findById(elem.getId());
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
    public List<QmCvlFieldData> list(ManageITBodyRequest request) {
        List<QmCvlFieldData> list;
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
    public DataTableWrapper<QmCvlFieldData> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QmCvlFieldData> finalList = list(request);
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
    public QmCvlField getQmCvlFieldParent(BigInteger clientId, String sectionName, String fieldCode) {
        if (clientId == null || StringSupport.isNullOrEmpty(sectionName, fieldCode)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getQmCvlFieldParent(clientId, sectionName, fieldCode);
    }

}
