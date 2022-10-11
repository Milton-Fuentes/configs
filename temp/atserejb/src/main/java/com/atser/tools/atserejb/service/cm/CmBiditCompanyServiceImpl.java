/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmBiditCompanyDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.CmBiditCompany;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class CmBiditCompanyServiceImpl implements CmBiditCompanyService, IBaseEJBException {

    @Inject
    private CmBiditCompanyDao dao;

    @Override
    public CmBiditCompany findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditCompany findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditCompany elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getCompanyTin())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
            }
            if (dao.exists(elem.getCompanyTin())) {
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Company already exists !");
            }
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, CmBiditCompany elem) {
        if (elem != null) {
            CmBiditCompany model = findById(elem.getId());
            if (!model.equals(elem)) {
                if (!model.getCompanyTin().equals(elem.getCompanyTin()) && dao.exists(elem.getCompanyTin())) {
                    throwBaseException(Response.Status.EXPECTATION_FAILED, "Company already exists !");
                }
                dao.update(populate(model, elem));
            }
        }
    }

    private CmBiditCompany populate(CmBiditCompany model, CmBiditCompany elem) {
        model.setCompanyTin(elem.getCompanyTin());
        model.setCompanyName(elem.getCompanyName());
        model.setCompanyAddr(elem.getCompanyAddr());
        model.setCompanyAddrDetail(elem.getCompanyAddrDetail());
        model.setCompanyCity(elem.getCompanyCity());
        model.setCompanyState(elem.getCompanyState());
        model.setCompanyZip(elem.getCompanyZip());
        model.setCompanyWebsite(elem.getCompanyWebsite());
        model.setCompanyDescription(elem.getCompanyDescription());
        model.setCompanyTypeId(elem.getCompanyTypeId());
        model.setCompanyName(elem.getCompanyName());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
        return model;
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<CmBiditCompany> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<CmBiditCompany> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditCompany> finalList = list(request);
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
    public DataGridWrapper<CmBiditCompany> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public Boolean exists(String companyTin) {
        return dao.exists(companyTin);
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
    public Optional<CmBiditCompany> findEngineerEstimationCompany(BigInteger clientId) {
        List<CmBiditCompany> clist = list(new ManageITBodyRequest(0, 0).filter("clientId", clientId).filter("userId", -1).filter("engineerEstimate", 'Y').filter("active", 'Y'));
        if(clist != null && !clist.isEmpty()) {
            if(clist.size() > 1) {
                log.error(String.format("Multiple Engineer Estimation Companies have been configure for this client: '%s'", clientId));
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Multiple Engineer Estimation Companies have been configure for this client.");
            }
            return Optional.of(clist.get(0));
        }
        return Optional.empty();
    }

}
