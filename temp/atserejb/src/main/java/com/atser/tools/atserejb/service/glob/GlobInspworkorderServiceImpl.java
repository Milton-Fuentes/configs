/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobInspworkorderDao;
import com.atser.tools.atserejb.model.GlobInspworkorder;
import com.atser.tools.atserejb.service.cm.CmContractActivityService;
import com.atser.tools.atserejb.service.cm.CmDailyLocationService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.InspWorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobInspworkorderServiceImpl implements GlobInspworkorderService, IBaseEJBException {

    @Inject
    private GlobInspworkorderDao dao;

    @Inject
    private CmContractActivityService cmContractActivity;

    @Inject
    private CmDailyLocationService cmDailyLocationService;

    @Override
    public GlobInspworkorder findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobInspworkorder findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobInspworkorder findByWoToken(String tk) {
        return dao.findByWoToken(tk);
    }

    @Override
    public BigInteger save(GlobInspworkorder elem) {
        if (elem != null) {
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(GlobInspworkorder elem) {
        if (elem != null) {
            GlobInspworkorder model = findById(elem.getId());
            model.setServiceDate(elem.getServiceDate());
            model.setServicesRequested(elem.getServicesRequested());
            model.setInspector(elem.getInspector());
            model.setTimeatoffice(elem.getTimeatoffice());
            model.setTimeatsite(elem.getTimeatsite());
            model.setHours(elem.getHours());
            model.setContactrefid(elem.getContactrefid());
            model.setContactPerson(elem.getContactPerson());
            model.setContactTelephone(elem.getContactTelephone());
            model.setSpecInstr(elem.getSpecInstr());
            model.setInspNotes(elem.getInspNotes());
            model.setPaperworkReceived(elem.getPaperworkReceived());
            model.setAssignment(elem.getAssignment());
            model.setCancelled(elem.getCancelled());
            model.setActivityId(elem.getActivityId());
            model.setInspRefid(elem.getInspRefid());
            model.setInspectionFuncid(elem.getInspectionFuncid());
            model.setDecisionflag(elem.getDecisionflag());
            model.setWotoken(elem.getWotoken());
            model.setLastMod(elem.getLastMod());
            model.setLastModBy(elem.getLastModBy());
            Integer v = Integer.valueOf(model.getVersion()) + 1;
            model.setVersion(v.toString());
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
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<InspWorkOrderTO> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<InspWorkOrderTO> finalList = listTo(request);
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
    public List<GlobInspworkorder> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<InspWorkOrderTO> listTo(ManageITBodyRequest request) {
        List<GlobInspworkorder> wolist = list(request);
        List<InspWorkOrderTO> responseList = new ArrayList<>();

        wolist.forEach((wo) -> {
            if (wo.getId() != null) {
                try {
                    responseList.add(toWorkOrderTO(wo));
                } catch (ParseException ex) {
                    Logger.getLogger(GlobInspworkorderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return responseList;
    }

    @Override
    public void updateDecisionFlag(GlobInspworkorder elem) {
        if (elem != null) {
            GlobInspworkorder model = findById(elem.getId());
            model.setDecisionflag(elem.getDecisionflag());
            dao.update(model);
        }
    }

    @Override
    public List<GlobInspworkorder> findByInspDispatchID(BigDecimal id) {
        return dao.findByInspDispatchID(id);
    }

    @Override
    public List<GlobInspworkorder> findByProjectID(BigInteger id) {
        return dao.findByProjectID(id);
    }

    @Override
    public String getNextWorkOrderNumber(BigInteger projectId) {
        return dao.getNextWorkOrderNumber(projectId);
    }

    private InspWorkOrderTO toWorkOrderTO(GlobInspworkorder wo) throws ParseException {
        InspWorkOrderTO woTo = new InspWorkOrderTO();
        woTo.setWoId(wo.getId().toBigInteger());
        woTo.setWonumber(wo.getWonumber());
        woTo.setServiceDate(DateSupport.formatDate(wo.getServiceDate(), DateSupport.FORMAT_US));
        woTo.setInspectorFullName(wo.getInspector());
        if (wo.getTimeatoffice() != null && !wo.getTimeatoffice().isEmpty()) {
            woTo.setTimeatoffice(DateSupport.formatString(wo.getTimeatoffice(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
        }
        if (wo.getTimeatsite() != null && !wo.getTimeatsite().isEmpty()) {
            woTo.setTimeatsite(DateSupport.formatString(wo.getTimeatsite(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("HH:mm")));
        }
        woTo.setHours(wo.getHours());
        woTo.setContactrefId(wo.getContactrefid());
        woTo.setContactperson(wo.getContactPerson());
        woTo.setContacttelephone(wo.getContactTelephone());
        woTo.setSpecialinstruction(wo.getSpecInstr());
        woTo.setPaperworkReceived(String.valueOf(wo.getPaperworkReceived()));
        woTo.setAssigment(wo.getAssignment());
        if (wo.getCancelled() != null && !wo.getCancelled().isEmpty()) {
            woTo.setIscancel(wo.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
        }
        woTo.setInspRefId(wo.getInspRefid());
        woTo.setInspFuncId(wo.getInspectionFuncid());
        woTo.setDecisionFlag(wo.getDecisionflag());
        woTo.setServiceList(wo.getServicesRequested());
        woTo.setTraceDescription(cmContractActivity.getActivityName(wo.getActivityId(), "nd"));
        woTo.setRlocation(cmDailyLocationService.getDailyLocation(wo.getInspdispatchid().getRequestLocation()));
        return woTo;
    }

    @Override
    public List<String> getListActivityNo(BigInteger projectId) {
        return dao.getListActivityNo(projectId);
    }

}
