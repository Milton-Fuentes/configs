/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.dao.bpm.BpmSubmittalMetaDataDao;
import com.atser.tools.atserejb.model.Bpmsubmittalmetadata;
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
public class BpmSubmittalMetaDataServiceImpl implements BpmSubmittalMetaDataService, IBaseEJBException {

    @Inject
    private BpmSubmittalMetaDataDao dao;

    @Override
    public Bpmsubmittalmetadata findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public Bpmsubmittalmetadata findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public Bpmsubmittalmetadata findBySubmittalId(BigDecimal id) {
        return dao.findByRfiId(id);
    }

    @Override
    public BigInteger save(Bpmsubmittalmetadata elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.save(elem).getPersistenceid().toBigInteger();
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, Bpmsubmittalmetadata elem) {
        if (elem != null) {
            return dao.save(elem).getPersistenceid();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(Bpmsubmittalmetadata elem) {
        if (elem != null) {
            Bpmsubmittalmetadata model = findById(elem.getPersistenceid());
            dao.update(model);
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, Bpmsubmittalmetadata elem) {
        if (elem != null) {
            ManageITBodyRequest search = new ManageITBodyRequest(0, 1);
            search.filter("persistenceid", elem.getPersistenceid());
            List<Bpmsubmittalmetadata> list = list(search);
            if (!list.isEmpty()) {
                Bpmsubmittalmetadata model = list.get(0);
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
    public List<Bpmsubmittalmetadata> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    private Bpmsubmittalmetadata populate(Bpmsubmittalmetadata model, Bpmsubmittalmetadata elem) {
        model.setContentType(elem.getContentType());
        model.setDiscipline(elem.getDiscipline());
        model.setDocumentType(elem.getDocumentType());
        model.setExternalUrl(elem.getExternalUrl());
        model.setKeywords(elem.getKeywords());
        model.setPersistenceversion(elem.getPersistenceversion());
        model.setRevision(elem.getRevision());
        return model;
    }
}
