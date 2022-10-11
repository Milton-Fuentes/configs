/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.dao.bpm.BpmProcessTrackingDao;
import com.atser.tools.atserejb.model.BpmClientProcessCatg;
import com.atser.tools.atserejb.model.BpmProcessTracking;
import com.atser.tools.atserejb.model.GlobSystemFunct;
import com.atser.tools.atserejb.service.glob.GlobSystemFunctService;
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
public class BpmProcessTrackingServiceImpl implements BpmProcessTrackingService, IBaseEJBException {

    @Inject
    private BpmProcessTrackingDao dao;

    @Inject
    private GlobSystemFunctService globSystemFunctService;

    @Inject
    private BpmClientProcessCatgService bpmClientProcessCatgService;

    @Override
    public BpmProcessTracking findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public BpmProcessTracking findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BpmProcessTracking saveAndGet(ManageITHeader header, ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeysAndNotNull(new String[]{"projectId", "functionality", "process", "refId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GlobSystemFunct> functId = globSystemFunctService.list(new ManageITBodyRequest(0, 1)
                .filter("clientId", header.getClientid())
                .filter("active", 'Y')
                .filter("code", StringSupport.getString(request.getParams().get("functionality"))));
        
        List<BpmClientProcessCatg> processId = bpmClientProcessCatgService.list(new ManageITBodyRequest(0, 1)
                .filter("clientId", header.getClientid())
                .filter("active", 'Y')
                .filter("code", StringSupport.getString(request.getParams().get("process"))));
        
        if(functId == null || functId.isEmpty() || processId == null || processId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong database configuration.");
        }
        
        BpmProcessTracking elem = new BpmProcessTracking();
        elem.setFunctionalityId(functId.get(0).getId().toBigInteger());
        elem.setProcessCatgId(processId.get(0).getId().toBigInteger());
        elem.setClientId(NumberSupport.getBigInteger(header.getClientid()));
        elem.setContractId(NumberSupport.getBigInteger(request.getParams().get("contractId")));
        elem.setProjectId(NumberSupport.getBigInteger(request.getParams().get("projectId")));
        elem.setRefId(NumberSupport.getBigInteger(request.getParams().get("refId")));
        elem.setSystemModule(header.getModule());
        elem.setStatus("CREATED");
        return saveAndGet(header, elem);
    }

    @Override
    public BpmProcessTracking saveAndGet(ManageITHeader header, BpmProcessTracking elem) {
        if (elem != null) {
            elem.setCreated(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setCreatedBy(header.getUser());
            elem.setCreatedById(NumberSupport.getBigInteger(header.getUserid()));
            elem.setCreatedByIp(header.getModIp());
            elem.setDeleted(Short.valueOf("0"));
            elem.setActive(Short.valueOf("1"));
            dao.save(elem);
        }
        return elem;
    }

    @Override
    public BigDecimal save(ManageITHeader header, BpmProcessTracking elem) {
        if (elem != null) {
            elem.setCreated(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setCreatedBy(header.getUser());
            elem.setCreatedById(NumberSupport.getBigInteger(header.getUserid()));
            elem.setCreatedByIp(header.getModIp());
            elem.setDeleted(Short.valueOf("0"));
            elem.setActive(Short.valueOf("1"));
            return dao.save(elem).getPersistenceid();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, BpmProcessTracking elem) {
        if (elem != null) {
            BpmProcessTracking model = findById(elem.getPersistenceid());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private BpmProcessTracking populate(BpmProcessTracking model, BpmProcessTracking elem) {
        model.setSystemModule(elem.getSystemModule());
        model.setFunctionalityId(elem.getFunctionalityId());
        model.setProcessCatgId(elem.getProcessCatgId());
        model.setRefId(elem.getRefId());
        model.setClientId(elem.getClientId());
        model.setProjectId(elem.getProjectId());
        model.setContractId(elem.getContractId());
        model.setInternalStatus(elem.getInternalStatus());
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
    public DataTableWrapper<BpmProcessTracking> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<BpmProcessTracking> finalList = list(request);
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
    public DataGridWrapper<BpmProcessTracking> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public List<BpmProcessTracking> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
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
