/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.dao.bpm.BpmRFIMetaDataDao;
import com.atser.tools.atserejb.model.Bpmrfimetadata;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.AppTableImg;
import com.atser.tools.atserutil.number.NumberSupport;
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
public class BpmRFIMetaDataServiceImpl implements BpmRFIMetaDataService, IBaseEJBException {

    @Inject
    private BpmRFIMetaDataDao dao;

    @Override
    public Bpmrfimetadata findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public Bpmrfimetadata findByRfiId(BigDecimal id) {
        return dao.findByRfiId(id);
    }

    @Override
    public BigInteger save(Bpmrfimetadata elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.save(elem).getPersistenceid().toBigInteger();
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, Bpmrfimetadata elem) {
        if (elem != null) {
            return dao.save(elem).getPersistenceid();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(Bpmrfimetadata elem) {
        if (elem != null) {
            ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
            search.filter("persistenceid", elem.getPersistenceid());
            List<Bpmrfimetadata> list = list(search);
            if (!list.isEmpty()) {
                Bpmrfimetadata model = list.get(0);
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, Bpmrfimetadata elem) {
        if (elem != null) {
            ManageITBodyRequest search = new ManageITBodyRequest(0, 1);
            search.filter("persistenceid", elem.getPersistenceid());
            List<Bpmrfimetadata> list = list(search);
            if (!list.isEmpty()) {
                Bpmrfimetadata model = list.get(0);
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
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
    public List<Bpmrfimetadata> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    private Bpmrfimetadata populate(Bpmrfimetadata model, Bpmrfimetadata elem) {
        model.setContentType(elem.getContentType());
        model.setDiscipline(elem.getDiscipline());
        model.setDocumentType(elem.getDocumentType());
        model.setExternalUrl(elem.getExternalUrl());
        model.setKeywords(elem.getKeywords());
        model.setPersistenceversion(elem.getPersistenceversion());
        model.setRevision(elem.getRevision());
        model.setRevisionDate(elem.getRevisionDate());
        return model;
    }

}
