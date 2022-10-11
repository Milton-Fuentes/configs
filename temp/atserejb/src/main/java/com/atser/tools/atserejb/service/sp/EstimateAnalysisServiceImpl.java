/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.sp;

import com.atser.tools.atserejb.dao.sp.EstimateAnalysisDao;
import com.atser.tools.atserejb.model.GlobContract;
import com.atser.tools.atserejb.service.glob.GlobContractService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.gateway.TotalEstimateAnalysisTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class EstimateAnalysisServiceImpl implements EstimateAnalysisService, IBaseEJBException {

    @Inject
    private EstimateAnalysisDao dao;
    
    @Inject
    private GlobContractService contractService;
            
    @Override
    public TotalEstimateAnalysisTO filter(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"po_number", "start_date", "end_date"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing params.");
        }
        
        ManageITBodyRequest searchBuilder = new ManageITBodyRequest(0, 0);
        searchBuilder.filter("purchaseOrderNo", request.getParams().get("po_number"));        
        List<GlobContract> contractList = contractService.list(searchBuilder);
        if(contractList == null || contractList.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "PO Number is Wrong.");
        } 
        
        if(contractList.size() > 1) {
            throwBaseException(Response.Status.BAD_REQUEST, "PO Number is not unique.");
        }
        
        String startDate = (request.getParams().get("start_date") == null) ? "" : request.getParams().get("start_date").toString();
        String endDate = (request.getParams().get("end_date") == null) ? "" :request.getParams().get("end_date").toString();
        
        try {
            DateSupport.parseString(startDate, DateSupport.FORMAT_US);
        } catch (ParseException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, "Start Date Format should be MM/dd/yyyy.");
        }
        
        try {
            DateSupport.parseString(endDate, DateSupport.FORMAT_US);
        } catch (ParseException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, "End Date Format should be MM/dd/yyyy.");
        }
        
        return dao.filter(contractList.get(0).getId(), startDate, endDate);
    }

}
