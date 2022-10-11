/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaTicketDao;
import com.atser.tools.atserejb.model.QaTicket;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
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
public class QaTicketServiceImpl implements QaTicketService, IBaseEJBException {

    @Inject
    private QaTicketDao dao;

    @Override
    public QaTicket findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaTicket findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaTicket elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getClientId()) || StringSupport.isNullOrEmpty(elem.getProjectId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setDocControlno(dao.getNextDCN(elem.getClientId(), elem.getProjectId()));
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaTicket elem) {
        if (elem != null) {
            QaTicket model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
                dao.update(model);
            }
        }
    }

    private QaTicket populate(QaTicket model, QaTicket elem) {
        model.setCatg(elem.getCatg());
        model.setSupplierId(elem.getSupplierId());
        model.setTicketNo(elem.getTicketNo());
        model.setOrderDate(elem.getOrderDate());
        model.setOrderNo(elem.getOrderNo());
        model.setRouteFrom(elem.getRouteFrom());
        model.setRouteTo(elem.getRouteTo());
        model.setDeliveryDate(elem.getDeliveryDate());
        model.setDeliveryTime(elem.getDeliveryTime());
        model.setLoadDescript(elem.getLoadDescript());
        model.setLoadWt(elem.getLoadWt());
        model.setLoadUnit(elem.getLoadUnit());
        model.setBiditemNo(elem.getBiditemNo());
        model.setReceivedBy(elem.getReceivedBy());
        model.setCostUnit(elem.getCostUnit());
        model.setCostLoad(elem.getCostLoad());
        model.setCostOther(elem.getCostOther());
        model.setCostInvoice(elem.getCostInvoice());
        model.setInvoiceStatus(elem.getInvoiceStatus());
        model.setPaidDate(elem.getPaidDate());
        model.setRemarks(elem.getRemarks());
        model.setLatGps(elem.getLatGps());
        model.setLonGps(elem.getLonGps());
        model.setAltGps(elem.getAltGps());
        return model;
    }
    
    @Override
    public void delete(BigDecimal id) {
        if(id != null) {
            dao.delete(id);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaTicket> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaTicket> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaTicket> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, list(request));
        }
        return null;
    }

    @Override
    public String getNextDCN(String clientId, String projectId) {
        if (StringSupport.isNullOrEmpty(clientId) || StringSupport.isNullOrEmpty(projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getNextDCN(NumberSupport.getBigInteger(clientId), NumberSupport.getBigInteger(projectId));
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
