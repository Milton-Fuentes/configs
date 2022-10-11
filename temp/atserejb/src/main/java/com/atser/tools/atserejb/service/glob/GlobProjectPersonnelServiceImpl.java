/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjectPersonnelDao;
import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobProjectPersonnelServiceImpl implements GlobProjectPersonnelService, IBaseEJBException {

    @Inject
    GlobProjectPersonnelDao dao;

    @Override
    public GlobProjectPersonnel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjectPersonnel findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjectPersonnel elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void saveGlobal(GlobProjectPersonnel elem) {
        if (elem != null) {
            if (!dao.existsGlobalProject(elem.getContactId().getId().toBigInteger())) {
                dao.save(elem);
                dao.inactiveAllProjectWhenGlobal(elem.getClientId(), elem.getContactId().getId().toBigInteger());
            }
        }
    }

    @Override
    public void update(GlobProjectPersonnel elem) {
        if (elem != null) {
            GlobProjectPersonnel model = findById(elem.getId());
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
    public List<GlobProjectPersonnel> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<String> getPersonnelIdWithWO(BigInteger projectId) {
        return dao.getPersonnelIdWithWO(projectId);
    }

    @Override
    public List<String> getPersonnelIdWithWOForDispatchByProject(BigInteger projectId) {
        return dao.getPersonnelIdWithWOForDispatchByProject(projectId);
    }

    @Override
    public List<String> getPersonnelIdWithWOForDispatchByClient(BigInteger clientId) {
        return dao.getPersonnelIdWithWOForDispatchByClient(clientId);
    }

    @Override
    public List<CalendarResourceTO> getDispatchCalendarResources(String clientId, String projectId, String usersFilter) {
        if(StringSupport.isNullOrEmpty(clientId, projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getDispatchCalendarResources(clientId, projectId, usersFilter);
    }

    @Override
    public List<CalendarResourceTO> getAllDispatchCalendarResources(GlobSheduleSearchDefParam filter) {
         if(StringSupport.isNullOrEmpty(filter.clientId, filter.projectId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getAllDispatchCalendarResources(filter);
    }

}
