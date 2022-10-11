/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.dao.bpm.BpmCorrespondenceMetaDataDao;
import com.atser.tools.atserejb.model.Bpmcorrespondencemetadata;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.Bpmrfimetadata;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class BpmCorrespondenceMetaDataServiceImpl implements BpmCorrespondenceMetaDataService, IBaseEJBException {

    @Inject
    private BpmCorrespondenceMetaDataDao dao;

    @Override
    public Bpmcorrespondencemetadata findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public Bpmcorrespondencemetadata findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public Bpmcorrespondencemetadata findByCorrespondenceId(BigDecimal id) {
        return dao.findByCorrespondnceId(id);
    }

    @Override
    public BigInteger save(Bpmcorrespondencemetadata elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.save(elem).getPersistenceid().toBigInteger();
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, Bpmcorrespondencemetadata elem) {
        if (elem != null) {
            return dao.save(elem).getPersistenceid();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(Bpmcorrespondencemetadata elem) {
        if (elem != null) {
            Bpmcorrespondencemetadata model = findById(elem.getPersistenceid());
            dao.update(model);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, Bpmcorrespondencemetadata elem) {
        if (elem != null) {
            ManageITBodyRequest search = new ManageITBodyRequest(0, 1);
            search.filter("persistenceid", elem.getPersistenceid());
            List<Bpmcorrespondencemetadata> list = list(search);
            if (!list.isEmpty()) {
                Bpmcorrespondencemetadata model = list.get(0);
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<Bpmcorrespondencemetadata> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    private Bpmcorrespondencemetadata populate(Bpmcorrespondencemetadata model, Bpmcorrespondencemetadata elem) {
        model.setCompanySentTo(elem.getCompanySentTo());
        model.setDeliveryMethod(elem.getDeliveryMethod());
        model.setKeywords(elem.getKeywords());
        model.setPersonSentTo(elem.getPersonSentTo());
        model.setSentReceived(elem.getSentReceived());
        model.setSentReceivedDate(elem.getSentReceivedDate());
        model.setSubject(elem.getSubject());
        model.setTrackingNumber(elem.getTrackingNumber());
        return model;
    }
}
