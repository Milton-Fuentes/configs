/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobBillingRateTableDetailDao;
import com.atser.tools.atserejb.model.GlobBillingRateTableDetail;
import com.atser.tools.atserejb.model.QaSampleTestBillingItem;
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
public class GlobBillingRateTableDetailServiceImpl implements GlobBillingRateTableDetailService, IBaseEJBException {

    @Inject
    private GlobBillingRateTableDetailDao dao;

    @Override
    public GlobBillingRateTableDetail findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobBillingRateTableDetail findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobBillingRateTableDetail elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getBillingCodeId()) || StringSupport.isNullOrEmpty(elem.getRateTableId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, GlobBillingRateTableDetail elem) {
        if (elem != null) {
            GlobBillingRateTableDetail model = findById(elem.getId());
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
        if (id != null) {
            dao.delete(id);
        }
    }

    @Override
    public List<GlobBillingRateTableDetail> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<GlobBillingRateTableDetail> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<GlobBillingRateTableDetail> dataTableList(ManageITBodyRequest request) {
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

}
