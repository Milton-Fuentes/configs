/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaconcCompstrDao;
import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaconcCompstr;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.exception.BaseException;
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
public class QaconcCompstrServiceImpl implements QaconcCompstrService, IBaseEJBException {

    @Inject
    private QaconcCompstrDao dao;

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

    @Override
    public QaconcCompstr findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaconcCompstr findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QaconcCompstr findBySampleTestId(BigInteger id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySampleTestId(id);
    }

    @Override
    public void save(ManageITHeader header, QaconcCompstr elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, QaconcCompstr elem) {
        if (elem != null) {
            QaconcCompstr model = findById(elem.getId());
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
    public List<QaconcCompstr> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public QaconcCompstr createEmptyOrGet(ManageITHeader header, QaSample sampleId, BigInteger sampleTestId) {
        if (sampleId == null || header == null || sampleTestId == null || StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaconcCompstr concComp = findBySampleTestId(sampleTestId);
        if (concComp != null) {
            return concComp;
        }
        // Creating New QaconcCompstr
        concComp = new QaconcCompstr();
        concComp.setSampletestId(sampleTestId);
        concComp.setSamplesperset("1");
        // Mix Design
        if (sampleId.getMixDesignId() != null) {
            try {
                QaconcMixdesigns mixdesign = qaconcMixdesignsService.findById(sampleId.getMixDesignId().toString());
                if (mixdesign != null) {
                    concComp.setMixdesignno(mixdesign.getMixDesign());
                }
            } catch (BaseException ex) {
                System.out.println("Error createEmptyOrGet: Mix Design Error.");
            }
        }
        concComp.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        concComp.setCreateBy(header.getUser());
        concComp.setCreateByIp(header.getModIp());
        concComp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        concComp.setLastModIp(header.getModIp());
        concComp.setLastModBy(header.getUser());
        concComp.setActive('Y');
        concComp.setVersion("0");
        concComp.setAvgdays("28");
        concComp.setSplitsample('N');
        concComp.setMachineStopped('N');
        concComp.setRejected('N');
        concComp.setPotentialActualSubmitReview('N');
        concComp.setWateradded("0");
        concComp.setAdmix("0");
        concComp.setAdmix2("0");
        concComp.setAdmix3("0");
        concComp.setAdmix4("0");
        dao.save(concComp);
        return concComp;
    }

}
