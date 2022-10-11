/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QalabMainttypeV2Dao;
import com.atser.tools.atserejb.model.QalabMainttypeV2;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QalabMainttypeV2ServiceImpl implements QalabMainttypeV2Service, IBaseEJBException {

    @Inject
    private QalabMainttypeV2Dao dao;

    @Override
    public QalabMainttypeV2 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabMainttypeV2 findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, QalabMainttypeV2 elem) {
        save(elem);
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QalabMainttypeV2 elem) {
        update(elem);
    }

    @Override
    public void save(QalabMainttypeV2 elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QalabMainttypeV2 elem) {
        if (elem != null) {
            QalabMainttypeV2 model = findById(elem.getId());
            model.setEquippartName(elem.getEquippartName());
            model.setIntervalM(elem.getIntervalM());
            model.setProcedure(elem.getProcedure());
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
    public void delete(BigDecimal id) {
        delete(StringSupport.getString(id));
    }

    @Override
    public List<QalabMainttypeV2> list(ManageITBodyRequest request) {
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
    public DataTableWrapper<QalabMainttypeV2> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabMainttypeV2> finalList = list(request);
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
    public DataGridWrapper<QalabMainttypeV2> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
