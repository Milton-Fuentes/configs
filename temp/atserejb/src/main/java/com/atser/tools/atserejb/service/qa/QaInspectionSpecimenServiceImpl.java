/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaInspectionSpecimenDao;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.QaInspectionSpecimen;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaInspectionSpecimenServiceImpl implements QaInspectionSpecimenService, IBaseEJBException {

    @Inject
    private QaInspectionSpecimenDao dao;

    @Inject
    private QaInspectionService qaInspectionService;

    @Override
    public QaInspectionSpecimen findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspectionSpecimen findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaInspectionSpecimen elem) {
        if (elem != null) {
            // Load Inspection
            QaInspection inspId = qaInspectionService.findById(elem.getInspectionId().getId());
            if (inspId == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            if (!dao.exists(inspId.getId().toBigInteger(), elem.getSpecNo())) {
                elem.setSno(dao.getNextSequenceNo(inspId.getId().toBigInteger()));
                elem.setInspectionId(inspId);
                elem.setCreated(new Date());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastMod(new Date());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setActive('Y');
                return dao.save(elem).getId().toBigInteger();
            } else {
                throwBaseException(Response.Status.CONFLICT, "This Specimen already exists.");
            }
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaInspectionSpecimen elem) {
        if (elem != null) {
            QaInspectionSpecimen model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
                if (model != null) {
                    dao.update(model);
                }
            }
        }
    }

    /**
     * Populate Parent
     *
     * @param model
     * @param elem
     * @return
     */
    private QaInspectionSpecimen populate(QaInspectionSpecimen model, QaInspectionSpecimen elem) {
        //model.setSno(elem.getSno());
        model.setSpecNo(elem.getSpecNo());
        model.setGpsLatitude(elem.getGpsLatitude());
        model.setGpsLongitude(elem.getGpsLongitude());
        model.setGpsAltitude(elem.getGpsAltitude());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaInspectionSpecimen> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaInspectionSpecimen> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaInspectionSpecimen> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaInspectionSpecimen> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaInspectionSpecimen> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
