/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobLogosDao;
import com.atser.tools.atserejb.model.GlobLogos;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobLogosServiceImpl implements GlobLogosService, IBaseEJBException {

    @Inject
    private GlobLogosDao dao;

    @Override
    public GlobLogos findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobLogos findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobLogos elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobLogos elem) {
        if (elem != null) {
            GlobLogos model = findById(elem.getId());
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
    public List<GlobLogos> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobLogos> findSystemLogoByFilter(BigInteger clientid, BigInteger projectid, BigInteger contractid, BigInteger contractorid, BigInteger labid, BigInteger functionid, BigInteger disciplineid) {
        ManageITBodyRequest request = new ManageITBodyRequest(0, 0);
        request.filter("clientId", clientid).filter("projectId", projectid).filter("contractId", contractid).filter("contractorId", contractorid).filter("labId", labid).filter("functionId", functionid).filter("disciplineId", disciplineid);
        return list(request);
    }
}
