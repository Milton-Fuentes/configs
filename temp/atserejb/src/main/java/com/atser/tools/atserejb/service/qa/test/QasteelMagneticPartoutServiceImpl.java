/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QasteelMagneticPartoutDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.model.QasteelMagneticPartout;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QasteelMagneticPartoutServiceImpl implements QasteelMagneticPartoutService, IBaseEJBException {

    @Inject
    private QasteelMagneticPartoutDao dao;

    @Override
    public QasteelMagneticPartout findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QasteelMagneticPartout findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, QasteelMagneticPartout elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getTestNo()) || elem.getTestId()==null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setNo(dao.getNextTestNo(elem.getTestId()));
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, QasteelMagneticPartout elem) {
        if (elem != null) {
            QasteelMagneticPartout model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
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
    public List<QasteelMagneticPartout> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QasteelMagneticPartout> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QasteelMagneticPartout> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QasteelMagneticPartout> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QasteelMagneticPartout> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    public Integer getNextTestNo(BigInteger testId) {
        if (StringSupport.isNullOrEmpty(testId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getNextTestNo(testId);
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
    public QasteelMagneticPartout findByTestId(BigInteger testId) {
        return dao.findByTestId(testId);
    }

    @Override
    public void calcTest(QasteelMagneticPartout model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByTestId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private QasteelMagneticPartout populate(QasteelMagneticPartout model, QasteelMagneticPartout elem) {

        //---commons -----------------------------------------------------------
        model.setField1(elem.getField1());
        model.setField2(elem.getField2());
        model.setField3(elem.getField3());
        model.setField4(elem.getField4());
        model.setField5(elem.getField5());
        model.setField6(elem.getField6());
        model.setField7(elem.getField7());
        model.setField8(elem.getField8());
        model.setField9(elem.getField9());
        model.setField10(elem.getField10()); 
        model.setTestNo(elem.getTestNo());
        model.setNop(elem.getNop());
        //---test Out Fields----------------------------------------------------
        model.setWelderInfo(elem.getWelderInfo());
        model.setComponent(elem.getComponent());
        model.setAccept(elem.getAccept());
        model.setReject(elem.getReject());
        model.setLocation(elem.getLocation());
        model.setType(elem.getType());
        return model;
    }

}
