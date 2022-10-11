/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.VwBpmDispatchBoDao;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserejb.model.VwBpmDispatchBo;
import com.atser.tools.atserejb.service.glob.GlobDispatchcallLogService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bonitasoft.engine.exception.BonitaException;

@Stateless
public class VwBpmDispatchBoServiceImpl implements VwBpmDispatchBoService, IBaseEJBException {

    @Inject
    private VwBpmDispatchBoDao dao;

    @Inject
    private GlobDispatchcallLogService dispatchCallLogService;

    @Override
    public List<VwBpmDispatchBo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        List<VwBpmDispatchBo> returnList;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            returnList = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            returnList = dao.findAll();
        }

        if (returnList != null && !returnList.isEmpty()) {
            for (int i = 0; i < returnList.size(); i++) {
                String decision = checkIfIsPossibleCancelRequest(returnList.get(i), session);
                returnList.get(i).setCanbeCancelled(decision);
            }
        }

        return returnList;
    }

    @Override
    public DataTableWrapper<VwBpmDispatchBo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException{
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwBpmDispatchBo> finalList = list(request, session);
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
    public DataGridWrapper<VwBpmDispatchBo> dataGridList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException{
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VwBpmDispatchBo> finalList = list(request, session);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    /**
     * Check If is Possible Cancel the Request
     *
     * @param item
     * @param session
     * @return String (wo -> false, null -> true)
     * @throws BonitaException
     */
    private String checkIfIsPossibleCancelRequest(VwBpmDispatchBo item, BonitaBpmSupport session) throws BonitaException {
        if (item != null && item.getCaseId() != null && session.isSessionActive()) {
            if (session.isHumanTaskAlreadyAssigned("ready", item.getCaseId().longValue())) {
                return "assigned";
            }
            List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(item.getPersistenceid().toBigInteger());
            int size = reqLogList.size();
            if (size > 0) {
                return "wo";
            }
        }
        return null;
    }

}
