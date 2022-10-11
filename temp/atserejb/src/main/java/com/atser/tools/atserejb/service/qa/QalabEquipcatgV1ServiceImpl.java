/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipcatgV1;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.atser.tools.atserejb.dao.qa.QalabEquipcatgV1Dao;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.string.StringSupport;

@Stateless
public class QalabEquipcatgV1ServiceImpl implements QalabEquipcatgV1Service, IBaseEJBException {

    @Inject
    private QalabEquipcatgV1Dao dao;

    @Override
    public QalabEquipcatgV1 findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabEquipcatgV1 findById(BigDecimal id) {
        return dao.findById(id);
    }
    
    @Override
    public BigDecimal save(ManageITHeader header, QalabEquipcatgV1 elem) {
        save(elem);
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QalabEquipcatgV1 elem) {
        update(elem);
    }

    @Override
    public void save(QalabEquipcatgV1 elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QalabEquipcatgV1 elem) {
        if (elem != null) {
            QalabEquipcatgV1 model = findById(elem.getId());
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
    public List<QalabEquipcatgV1> list(ManageITBodyRequest request) {
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public DataGridWrapper<QalabEquipcatgV1> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<QalabEquipcatgV1> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
