/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobCertificationTestDao;
import com.atser.tools.atserejb.model.GlobCertificationTest;
import com.atser.tools.atserejb.model.GlobClientTest;
import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserejb.service.view.VwClientTestsService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
public class GlobCertificationTestServiceImpl implements GlobCertificationTestService, IBaseEJBException {

    @Inject
    private GlobCertificationTestDao dao;

    @Inject
    private VwClientTestsService vwClientTestsService;

    @Override
    public GlobCertificationTest findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobCertificationTest findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobCertificationTest elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }
    
    @Override
    public void save(List<GlobCertificationTest> elems) {
        if (elems != null && !elems.isEmpty()) {
            /*GlobCertification certId = globCertificationService.findById(elems.get(0).getQualificationId().getId());
            elems.forEach(it -> {
                it.setQualificationId(certId);
            });*/
            dao.save(elems);
        }
    }

    @Override
    public void update(GlobCertificationTest elem) {
        if (elem != null) {
            GlobCertificationTest model = findById(elem.getId());
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
    public List<GlobCertificationTest> list(ManageITBodyRequest request) {
        return list(null, request);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List<GlobCertificationTest> list(ManageITHeader header, ManageITBodyRequest body) {
        List<GlobCertificationTest> list;
        if (body != null && (body.getFilter() != null || body.getSorted() != null)) {
            list = dao.filter(body.getFilter(), body.getSorted(), body.getPaging());
        } else {
            list = dao.findAll();
        }

        if (header != null && StringSupport.isNotNullAndNotEmpty(header.getClientid())) {            
            list.forEach(it -> {
                if (it.getTestId() != null) {
                    List<VwClientTests> ctest = vwClientTestsService.list(new ManageITBodyRequest(0, 0).filter("testId", it.getTestId().getId()).filter("clientId", header.getClientid()));
                    if(ctest != null && ctest.size() > 0) {
                        it.getTestId().setName(ctest.get(0).getFinalTestName());   
                    }
                }
            });
        }

        return list;
    }
}
