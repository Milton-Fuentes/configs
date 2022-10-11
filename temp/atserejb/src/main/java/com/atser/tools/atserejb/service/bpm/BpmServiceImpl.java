/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.bpm.BpmProcessInstanceDao;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BpmServiceImpl implements BpmService, IBaseEJBException {

    @Inject
    private BpmProcessInstanceDao dao;

}
