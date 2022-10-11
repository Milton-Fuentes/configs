/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobCertificationDao;
import com.atser.tools.atserejb.model.GlobCertification;
import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobCertificationServiceImpl implements GlobCertificationService, IBaseEJBException {

    @Inject
    private GlobCertificationDao dao;

    @Override
    public GlobCertification findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobCertification findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, GlobCertification elem) {
        if (elem != null) {
            elem.setActive("Y");
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, GlobCertification elem) {
        if (elem != null) {
            GlobCertification model = findById(elem.getId());
            if (!model.equals(elem)) {
                model.setLastMod(new Date());
                model.setLastModBy(header.getUser());
                model.setLastModIp(header.getModIp());
                model.setQualification(elem.getQualification());
                model.setAcronym(elem.getAcronym());
                dao.update(model);
            }
        }
    }

    @Override
    public void delete(String id) {
        delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            dao.delete(id);
        }
    }

    @Override
    public List<GlobCertification> list(ManageITBodyRequest request) {
        List<GlobCertification> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        /*list.forEach(it -> {
            if (it.getGlobCertificationTestList().size() > 0) {
                it.setCanbeDeleted("false");
                it.setGlobCertificationList(null);
            }
        });*/
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<GlobCertification> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobCertification> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobCertification model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? "Y" : "N");
        dao.update(model);
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
    public List<VwClientTests> findAllPendingTest(String clientId, String certificationId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(certificationId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findAllPendingTest(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(certificationId));
    }

    @Override
    public DataGridWrapper<GlobCertification> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

}
