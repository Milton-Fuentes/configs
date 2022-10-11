/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleTestDaysSpecDao;
import com.atser.tools.atserejb.model.QaSampleTestDaysSpec;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
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
public class QaSampleTestDaysSpecServiceImpl implements QaSampleTestDaysSpecService, IBaseEJBException {

    @Inject
    private QaSampleTestDaysSpecDao dao;

    @Override
    public QaSampleTestDaysSpec findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleTestDaysSpec findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaSampleTestDaysSpec findBySampleTestIdAndTestAge(BigInteger sampleTestId, String testAge, Boolean isHours) {
        if (sampleTestId == null || StringSupport.isNullOrEmpty(testAge)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySampleTestIdAndTestAge(sampleTestId, testAge, isHours);
    }

    @Override
    public void save(ManageITHeader header, QaSampleTestDaysSpec elem) {
        if (elem != null) {
            elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setActive('Y');
            elem.setVersion("0");
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, QaSampleTestDaysSpec elem) {
        if (elem != null) {
            QaSampleTestDaysSpec model = findById(elem.getId());
            model.setTestage(elem.getTestage());
            model.setTestageHours(elem.getTestageHours());
            model.setSpecMin(elem.getSpecMin());
            model.setSpecMax(elem.getSpecMax());
            model.setResult(elem.getResult());
            model.setAverage(elem.getAverage());
            model.setReportStampType(elem.getReportStampType());
            model.setRangeBetween(elem.getRangeBetween());
            model.setRangeSpec(elem.getRangeSpec());
            model.setRetestRequired(elem.getRetestRequired());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModIp(header.getModIp());
            model.setLastModBy(header.getUser());
            model.setVersion(StringSupport.getNextVersion(model.getVersion()));
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
    public List<QaSampleTestDaysSpec> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
