/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.AggsieveDao;
import com.atser.tools.atserejb.model.Aggsieve;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AggsieveServiceImpl implements AggsieveService, IBaseEJBException {

    @Inject
    private AggsieveDao dao;
    
    @Override
    public List<Aggsieve> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }
    
}
