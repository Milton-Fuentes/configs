/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaSampleTestAddInfoDao;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestFailureLogBO;
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
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class QaSampleTestAddInfoServiceImpl implements QaSampleTestAddInfoService, IBaseEJBException {

    @Inject
    private QaSampleTestAddInfoDao dao;

    @Inject
    private QaSampleTestService qaSampleTestService;

    @Override
    public QaSampleTestAddInfo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaSampleTestAddInfo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaSampleTestAddInfo findByTestId(BigInteger testId) {
        return dao.findByTestId(testId);
    }

    @Override
    public QaSampleTestAddInfo findBySampleTestId(String sampletestid) {
        if (StringSupport.isNullOrEmpty(sampletestid)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySampleTestId(NumberSupport.getBigDecimal(sampletestid));
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaSampleTestAddInfo elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getSampleTestId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, QaSampleTestAddInfo elem) {
        if (elem != null && elem.getSampleTestId() != null && elem.getSampleTestId().getId() != null) {
            if (dao.existsQaSampleTestAddInfo(elem.getSampleTestId().getId())) {
                QaSampleTestAddInfo model = findByTestId(NumberSupport.getBigInteger(elem.getSampleTestId().getId()));
                model.setReportStampType(elem.getReportStampType());
                model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                dao.update(model);
            } else {
                // Creating SampleTestAddInfo
                QaSampleTest sampleTest = qaSampleTestService.findById(elem.getSampleTestId().getId());
                if (sampleTest != null) {
                    QaSampleTestAddInfo testAddInfo = new QaSampleTestAddInfo();
                    testAddInfo.setSampleTestId(sampleTest);
                    testAddInfo.setReportStampType(elem.getReportStampType());
                    testAddInfo.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                    testAddInfo.setCreateBy(header.getUser());
                    testAddInfo.setCreateByIp(header.getModIp());
                    testAddInfo.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                    testAddInfo.setLastModIp(header.getModIp());
                    testAddInfo.setLastModBy(header.getUser());
                    testAddInfo.setActive('Y');
                    testAddInfo.setVersion("0");
                    testAddInfo.setEngDecision("No");
                    dao.save(testAddInfo);
                } else {
                    log.error("Sample Test Id not found", elem.getSampleTestId().getId());
                    throwBaseException(Response.Status.BAD_REQUEST, "Sample Test not found.");
                }
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
    public void deleteByTestId(String id) {
        if (id != null) {
            dao.delete(findByTestId(NumberSupport.getBigInteger(id)));
        }
    }

    @Override
    public List<QaSampleTestAddInfo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean existsQaSampleTestAddInfo(BigDecimal sampletestid) {
        return dao.existsQaSampleTestAddInfo(sampletestid);
    }

    @Override
    public List<QaSampleTestFailureLogBO> getFailureLog(String projectId) {
        if (projectId != null) {
            return dao.getFailureLog(projectId);
        }
        return null;
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<QaSampleTestAddInfo> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<QaSampleTestAddInfo> dataTableList(ManageITBodyRequest request) {
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
