/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.bpm.BpmTaskMatrixDao;
import com.atser.tools.atserejb.model.BpmTaskMatrix;
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
public class BpmTaskMatrixServiceImpl implements BpmTaskMatrixService, IBaseEJBException {

    @Inject
    private BpmTaskMatrixDao dao;

    @Override
    public BpmTaskMatrix findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public BpmTaskMatrix findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BpmTaskMatrix getFirstTaskByProcessId(BigDecimal processId) {
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("orgTaskId", 0).filter("processId", processId);
        List<BpmTaskMatrix> list = list(search);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public BigDecimal save(ManageITHeader header, BpmTaskMatrix elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, BpmTaskMatrix elem) {
        if (elem != null) {
            BpmTaskMatrix model = findById(elem.getId());
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
    public List<BpmTaskMatrix> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<BpmTaskMatrix> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<BpmTaskMatrix> dataTableList(ManageITBodyRequest request) {
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

    private BpmTaskMatrix populate(BpmTaskMatrix model, BpmTaskMatrix elem) {
        // model.setFirstName(elem.getFirstName());
        // model.setLastName(elem.getLastName());
        // model.setEmail(elem.getEmail());
        // model.setContactNo(elem.getContactNo());
        // model.setLastMod(elem.getLastMod());
        // model.setLastModBy(elem.getLastModBy());
        // model.setLastModByIp(elem.getLastModByIp());
        return model;
    }

}
