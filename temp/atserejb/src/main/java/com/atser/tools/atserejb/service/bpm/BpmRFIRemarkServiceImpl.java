/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.bpm.BpmRFIRemarkDao;
import com.atser.tools.atserejb.model.Bpmrfiremark;
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
import javax.ws.rs.core.Response;

@Stateless
public class BpmRFIRemarkServiceImpl implements BpmRFIRemarkService, IBaseEJBException {

    @Inject
    private BpmRFIRemarkDao dao;

    @Override
    public Bpmrfiremark findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public Bpmrfiremark findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, Bpmrfiremark elem) {
        if (elem != null) {
            return dao.save(elem).getPersistenceid();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, Bpmrfiremark elem) {
        if (elem != null) {
            Bpmrfiremark model = findById(elem.getPersistenceid());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
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
    public List<Bpmrfiremark> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<Bpmrfiremark> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<Bpmrfiremark> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Bpmrfiremark populate(Bpmrfiremark model, Bpmrfiremark elem) {
        model.setRemark(elem.getRemark());
        return model;
    }

}
