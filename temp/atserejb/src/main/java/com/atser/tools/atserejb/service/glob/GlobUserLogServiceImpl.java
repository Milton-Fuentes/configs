/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobUserLogDao;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.objects.to.GlobUsersLogTo;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobUserLogServiceImpl implements GlobUserLogService, IBaseEJBException {

    @Inject
    GlobUserLogDao dao;
    
    @Override
    public List<GlobUsersLogTo> findAll() {
        return dao.findAll();
    }

    @Override
    public List<GlobUsersLogTo> findAllActualDay() {
        return dao.findAllActualDay();
    }

    @Override
    public GlobUsersLogTo findBySessionId(String sessionid) {
        return dao.findBySessionId(sessionid);
    }    
}
