/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobFileRevisionDao;
import com.atser.tools.atserejb.model.GlobFileRevision;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobFileRevisionServiceImpl implements GlobFileRevisionService, IBaseEJBException {

    @Inject
    private GlobFileRevisionDao dao;

    @Override
    public GlobFileRevision findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobFileRevision findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobFileRevision elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobFileRevision elem) {
        if (elem != null) {
            GlobFileRevision model = findById(elem.getId());
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
    public void lockFile(BigDecimal revisionId, BigDecimal userId) {
        dao.lockFile(revisionId, userId);
    }

    @Override
    public void unlockFile(BigDecimal revisionId) {
        dao.unlockFile(revisionId);
    }

    @Override
    public Boolean isFileLocked(BigDecimal revisionId, BigDecimal userId) {
        return dao.isFileLocked(revisionId, userId);
    }

    @Override
    public List<GlobFileRevision> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
