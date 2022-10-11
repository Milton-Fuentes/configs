/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobBillingCodeDao;
import com.atser.tools.atserejb.model.GlobBillingCode;
import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserejb.service.qa.QaSampleTestService;
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
public class GlobBillingCodeServiceImpl implements GlobBillingCodeService, IBaseEJBException {

    @Inject
    private GlobBillingCodeDao dao;
    @Inject
    private QaSampleTestService qaSampleTestService;
    @Inject
    private GlobWorkorderService globWorkorderService;

    @Override
    public GlobBillingCode findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobBillingCode findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobBillingCode elem) {
        if (elem != null) {
            if (elem.getBillingCategoryId() == null || elem.getMaterialUseId() == null || StringSupport.isNullOrEmpty(elem.getStandarditem())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, GlobBillingCode elem) {
        if (elem != null) {
            GlobBillingCode model = findById(elem.getId());
            if (!model.equals(elem)) {
                populate(model, elem);
                dao.update(model);
            }

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
    public List<GlobBillingCode> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobBillingCode> listByCustomParams(String projectId, String sampleTestId, String billingCategoryId) {
        if (StringSupport.isNullOrEmpty(sampleTestId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        } else {
            QaSampleTest test = qaSampleTestService.findById(sampleTestId);
            GlobWorkorder wo = globWorkorderService.findById(test.getWorkorderId());
            if (wo.getMaterialUseId() == null) {
                return dao.listByCustomParams(NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(billingCategoryId), test.getTestDate());
            } else {
                return dao.listByCustomParams(NumberSupport.getBigInteger(projectId), NumberSupport.getBigInteger(billingCategoryId), test.getTestDate(), wo.getMaterialUseId());
            }
        }
        return null;
    }

    @Override
    public DataGridWrapper<GlobBillingCode> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<GlobBillingCode> dataTableList(ManageITBodyRequest request) {
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

    private void populate(GlobBillingCode model, GlobBillingCode elem) {
        //---commons -----------------------------------------------------------
        model.setBillingCategoryId(elem.getBillingCategoryId());
        model.setStandarditem(elem.getStandarditem());
        model.setUnitofmeasure(elem.getUnitofmeasure());
        model.setDescription(elem.getDescription());
        model.setCostPlus(elem.getCostPlus());
        model.setByQuotation(elem.getByQuotation());
        model.setMaterialUseId(elem.getMaterialUseId());
    }

}
