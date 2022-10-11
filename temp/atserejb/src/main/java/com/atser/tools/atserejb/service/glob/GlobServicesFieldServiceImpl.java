/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobServicesFieldDao;
import com.atser.tools.atserejb.model.GlobServicesField;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobServicesFieldServiceImpl implements GlobServicesFieldService, IBaseEJBException {
    
    @Inject
    private GlobServicesFieldDao dao;
    
    @Override
    public GlobServicesField findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }
    
    @Override
    public GlobServicesField findById(BigDecimal id) {
        return dao.findById(id);
    }
    
    @Override
    public void save(GlobServicesField elem) {
        save(null, elem);
    }
    
    @Override
    public BigDecimal save(ManageITHeader header, GlobServicesField elem) {
        if (elem != null) {
            elem.setFieldOrder(100);
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }
    
    @Override
    public void update(GlobServicesField elem) {
        update(null, elem);
    }
    
    @Override
    public void update(ManageITHeader header, GlobServicesField elem) {
        if (elem != null) {
            GlobServicesField model = findById(elem.getId());            
            dao.update(populate(model, elem));
        }
    }
    
    @Override
    public void delete(String id) {
        delete(NumberSupport.getBigDecimal(id));
    }
    
    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            dao.delete(id);
        }
    }
    
    @Override
    public List<GlobServicesField> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }
    
    @Override
    public GlobServicesField findByAbbrvAndClientId(String serviceAbbrv, BigInteger clientId) {
        if(StringSupport.isNullOrEmpty(serviceAbbrv) || clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return dao.findByAbbrvAndClientId(serviceAbbrv, clientId);
    }
    
    @Override
    public DataGridWrapper<GlobServicesField> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DataTableWrapper<GlobServicesField> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobServicesField> finalList = list(request);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public GlobServicesField findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }
    
    public GlobServicesField findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobServicesField elem = dao.findById(id);
            return elem;
        }
    }
    

    private GlobServicesField populate(GlobServicesField model, GlobServicesField elem) {
        model.setServiceAbbrev(elem.getServiceAbbrev());
        model.setServiceLong(elem.getServiceLong());
         model.setTestMethodId(elem.getTestMethodId());
        return model;
    }

}
