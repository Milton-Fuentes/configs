/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobClientTestDao;
import com.atser.tools.atserejb.model.GlobClientTest;
import com.atser.tools.atserejb.service.qa.QaTestMethodsService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobClientTestServiceImpl implements GlobClientTestService, IBaseEJBException {

    @Inject
    private GlobClientTestDao dao;

    @Inject
    QaTestMethodsService qaTestMethodsService;

    @Override
    public GlobClientTest findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobClientTest findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobClientTest elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobClientTest elem) {
        if (elem != null) {
            GlobClientTest model = findById(elem.getId());
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
    public List<GlobClientTest> list(ManageITBodyRequest request) {
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
    public GlobClientTest findByTestId(String clientId, String testId) {
        if (clientId == null && testId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");

        }
        return dao.findByTestId(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(testId));
    }

    @Override
    public GlobClientTest findBySampleTestId(String clientId, String testId) {
        if (clientId == null && testId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");

        }
        return dao.findBySampleTestId(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(testId));
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<GlobClientTest> list = list(request);
        list.forEach(it -> {
            rlist.add(new DataSelectWrapper(it.getId(), it.getReportTitle() != null ? it.getReportTitle() : qaTestMethodsService.findById(StringSupport.getString(it.getTestId())).getName()));
            qaTestMethodsService.findById(StringSupport.getString(it.getTestId())).getName();
        });
        return rlist;

    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobClientTest elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ManageITHeader header, GlobClientTest elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<GlobClientTest> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<GlobClientTest> dataTableList(ManageITBodyRequest request) {
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
