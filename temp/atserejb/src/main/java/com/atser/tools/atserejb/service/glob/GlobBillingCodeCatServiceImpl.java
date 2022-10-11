/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobBillingCodeCatDao;
import com.atser.tools.atserejb.model.GlobBillingCodeCat;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
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
public class GlobBillingCodeCatServiceImpl implements GlobBillingCodeCatService, IBaseEJBException {

    @Inject
    private GlobBillingCodeCatDao dao;

    @Override
    public GlobBillingCodeCat findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobBillingCodeCat findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobBillingCodeCat elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getCategory()) || StringSupport.isNullOrEmpty(elem.getCompanyId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setClientId(NumberSupport.getBigInteger(header.getClientid()));
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, GlobBillingCodeCat elem) {
        if (elem != null) {
            GlobBillingCodeCat model = findById(elem.getId());
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
    public List<GlobBillingCodeCat> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobBillingCodeCat> listByProjectId(ManageITHeader header, String projectId) {
        if (StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        } else {
            return dao.listByProjectId(NumberSupport.getBigInteger(header.getClientid()), NumberSupport.getBigInteger(projectId));
        }
       return null;
    }

    @Override
    public DataGridWrapper<GlobBillingCodeCat> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<GlobBillingCodeCat> dataTableList(ManageITBodyRequest request) {
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

    private void populate(GlobBillingCodeCat model, GlobBillingCodeCat elem) {
        //---commons -----------------------------------------------------------
        model.setCategory(elem.getCategory());
        model.setListOrder(elem.getListOrder());
        model.setCompanyId(elem.getCompanyId());
    }

}
