/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.VwqaaspmMixdesgExpDao;
import com.atser.tools.atserejb.model.VwqaaspmMixdesgExp;
import com.atser.tools.atserejb.service.qa.QaaspmMixdesignsJmfService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VwqaaspmMixdesgExpServiceImpl implements VwqaaspmMixdesgExpService, IBaseEJBException {

    @Inject
    private VwqaaspmMixdesgExpDao dao;
    
    @Inject
    private QaaspmMixdesignsJmfService qaaspmMixdesignsJmfService;

    @Override
    public List<VwqaaspmMixdesgExp> list(ManageITBodyRequest request) {        
        List<VwqaaspmMixdesgExp> rList;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            rList = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            rList = dao.findAll();
        }

        rList.forEach(m -> {
            m.getJmfList().forEach(j -> {
                j.setSieveList(qaaspmMixdesignsJmfService.getGradationPojoList(m.getId(), j.getId(), NumberSupport.getBigDecimal(m.getSetId())));
            });
        });

        return rList;
    }

    @Override
    public DataGridWrapper<VwqaaspmMixdesgExp> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<VwqaaspmMixdesgExp> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwqaaspmMixdesgExp> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

}
