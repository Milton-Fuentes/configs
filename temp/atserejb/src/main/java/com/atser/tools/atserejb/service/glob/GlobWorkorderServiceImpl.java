/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobWorkorderDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobProjectClient;
import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobWorkorderServiceImpl implements GlobWorkorderService, IBaseEJBException {

    @Inject
    private GlobWorkorderDao dao;

    @Inject
    private GlobProjectClientService globProjectClientService;

    @Inject
    private GlobProjectService projectService;

    @Override
    public GlobWorkorder findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobWorkorder findById(BigInteger id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobWorkorder findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobWorkorder findByWoToken(String tk) {
        return dao.findByWoToken(tk);
    }

    @Override
    public BigInteger save(GlobWorkorder elem) {
        return save(null, elem);
    }

    @Override
    public BigInteger save(ManageITHeader header, GlobWorkorder elem) {
        if (elem != null) {
            if (header != null) {
                elem.setCreateBy(header.getUser());
                elem.setCreateByIp(header.getModIp());
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
            }
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(GlobWorkorder elem) {
        if (elem != null) {
            GlobWorkorder model = findById(elem.getId());
            model.setProjectId(elem.getProjectId());
            model.setServiceDate(elem.getServiceDate());
            model.setContact(elem.getContact());
            model.setContactRefId(elem.getContactRefId());
            model.setArriveLabTime(elem.getArriveLabTime());
            model.setLastMod(elem.getLastMod());
            model.setCancelled(elem.getCancelled());
            model.setActivityId(elem.getActivityId());
            model.setCertification(elem.getCertification());
            model.setContactTelephone(elem.getContactTelephone());
            model.setWoCompleted(elem.getWoCompleted());
            model.setTravelTime(elem.getTravelTime());
            model.setLastModBy(elem.getLastModBy());
            Integer v = Integer.valueOf(model.getVersion()) + 1;
            model.setVersion(v.toString());
            model.setWoToken(elem.getWoToken());
            dao.update(model);
        }
    }

    @Override
    public void updateWoToken(GlobWorkorder elem) {
        if (elem != null) {
            GlobWorkorder model = findById(elem.getId());
            model.setWoToken(elem.getWoToken());
            dao.update(model);
        }
    }

    @Override
    public void frontUpdate(GlobWorkorder elem) {
        frontUpdate(null, elem);
    }

    @Override
    public void frontUpdate(ManageITHeader header, GlobWorkorder elem) {
        if (elem != null) {
            GlobWorkorder model = findById(elem.getId());
            model.setServiceDate(elem.getServiceDate());
            model.setContact(elem.getContact());
            model.setContactRefId(elem.getContactRefId());
            model.setArriveLabTime(elem.getArriveLabTime());
            model.setCancelled(elem.getCancelled());
            model.setActivityId(elem.getActivityId());
            model.setCertification(elem.getCertification());
            model.setContactTelephone(elem.getContactTelephone());
            model.setWoToken(elem.getWoToken());
            model.setWoCompleted(elem.getWoCompleted());
            model.setTravelTime(elem.getTravelTime());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));

            if (header != null) {
                model.setLastModIp(header.getModIp());
                model.setLastModBy(header.getUser());
            }

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
    public List<GlobWorkorder> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public String getNextWorkOrderNumber(BigInteger projectId) {
        return dao.getNextWorkOrderNumber(projectId);
    }

    @Override
    public Map<String, String> getNextWorkOrderNumbers(BigInteger projectId) {
        Map<String, String> response = new HashMap<>();
        String woNumber = getNextWorkOrderNumber(projectId);
        GlobProject project = projectService.findById(projectId.toString());
        GlobProjectClient cproject = globProjectClientService.findById(project.getProjectClientId().toString());
        String woLong = cproject.getProjectClientNo() + "-" + DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("YY")) + "-" + project.getName() + "-WO-" + woNumber;
        response.put("woNo", woNumber);
        response.put("woLong", woLong);
        return response;
    }

    @Override
    public List<String> getListActivityNo(BigInteger projectId) {
        return dao.getListActivityNo(projectId);
    }

    @Override
    public List<WorkOrderTO> filterAndGetWorkOrderTO(GlobSheduleSearchDefParam filters) {
        if (filters == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return dao.filterAndGetWorkOrderTO(filters);
    }

    @Override
    public Boolean validateWoToken(String token) {
        if (StringSupport.isNullOrEmpty(token)) {
            return Boolean.FALSE;
        }
        return dao.validateWoToken(token);
    }
}
