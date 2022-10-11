/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmPersoninfoDao;
import com.atser.tools.atserejb.model.CmPersoninfo;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class CmPersoninfoServiceImpl implements CmPersoninfoService, IBaseEJBException {

    @Inject
    private CmPersoninfoDao dao;

    @Override
    public CmPersoninfo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmPersoninfo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(CmPersoninfo elem) {
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.save(elem).getId().toBigInteger();
    }

    @Override
    public void update(CmPersoninfo elem) {
        if (elem != null) {
            CmPersoninfo model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        if (!id.isEmpty()) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<CmPersoninfo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<Object[]> getCmTitles(BigInteger clientId) {
        if (clientId != null) {
            return dao.getCmTitles(clientId);
        }
        return null;
    }

    @Override
    public List<Object[]> getCmFirm(BigInteger clientId) {
        if (clientId != null) {
            return dao.getCmFirm(clientId);
        }
        return null;
    }

    @Override
    public List<DataSelectWrapper> getCmTitlesForSelect(BigInteger clientId) {
        List<Object[]> flist = getCmTitles(clientId);
        if (flist == null || flist.isEmpty()) {
            return new ArrayList<>();
        }
        return flist.stream().map(p -> new DataSelectWrapper(p[1], StringSupport.emptyOnNull(p[1]))).collect(Collectors.toList());
    }

    @Override
    public List<DataSelectWrapper> getCmFirmForSelect(BigInteger clientId) {
        List<Object[]> flist = getCmFirm(clientId);
        if (flist == null || flist.isEmpty()) {
            return new ArrayList<>();
        }
        return flist.stream().map(p -> new DataSelectWrapper(p[0], StringSupport.emptyOnNull(p[0]))).collect(Collectors.toList());
    }

}
