/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobSupplierAddressDao;
import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobSupplierAddressServiceImpl implements GlobSupplierAddressService, IBaseEJBException {

    @Inject
    private GlobSupplierAddressDao dao;

    @Override
    public GlobSupplierAddress findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobSupplierAddress findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobSupplierAddress elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobSupplierAddress elem) {
        if (elem != null) {
            GlobSupplierAddress model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void updateMainLocationBySupplierId(BigInteger supplierId, String location) {
        if (supplierId != null) {
            List<GlobSupplierAddress> rList = list(new ManageITBodyRequest(0, 1).filter("supplierId", supplierId).filter("main", 'Y').filter("active", 'Y'));
            if (rList != null && !rList.isEmpty()) {
                GlobSupplierAddress model = rList.get(0);
                model.setLocation(location);
                dao.update(model);
            }
        }
    }
    
    @Override
    public GlobSupplierAddress getMainLocationBySupplierId(BigInteger supplierId) {
        if (supplierId != null) {
            List<GlobSupplierAddress> rList = list(new ManageITBodyRequest(0, 1).filter("supplierId", supplierId).filter("main", 'Y').filter("active", 'Y'));
            if (rList != null && !rList.isEmpty()) {
                return rList.get(0);
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobSupplierAddress> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
