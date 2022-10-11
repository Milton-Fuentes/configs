/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserejb.dao.mgmt.MgmtGanttResourceDao;
import com.atser.tools.atserejb.model.MgmtGanttResource;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GResource;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MgmtGanttResourceServiceImpl implements MgmtGanttResourceService, IBaseEJBException {

    @Inject
    private MgmtGanttResourceDao dao;
    
    @Override
    public MgmtGanttResource findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }
    
    public MgmtGanttResource findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(MgmtGanttResource elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(MgmtGanttResource elem) {
        if (elem != null) {
            MgmtGanttResource model = findById(elem.getId());
            model.setFirstname(elem.getFirstname());
            model.setLastname(elem.getLastname());
            model.setTitle(elem.getTitle());
            model.setDescription(elem.getDescription());
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
    public List<MgmtGanttResource> findAll() {
        return dao.findAll();
    }

    @Override
    public List<MgmtGanttResource> findAll(List<SyncFusionSorted> sorted, String projectId) {
        return dao.findAll(sorted, projectId);
    }

    @Override
    public String getListResourceAsJson(String projectId) {
        List<SyncFusionSorted> sorted = new ArrayList<>();
        sorted.add(new SyncFusionSorted("id", "ascending"));
        List<MgmtGanttResource> listOrig = findAll(sorted, projectId);
        List<GResource> listRp = new ArrayList<>();
        listOrig.forEach((it) -> {
            listRp.add(new GResource(it.getCode(), it.getFirstname() + " " + it.getLastname() + " [ " + it.getTitle() + " ]"));
        });
        Gson gson = new Gson();
        String result = gson.toJson(listRp); 
        return result;
    }
    
    @Override
    public List<GResource> getListResource(String projectId) {
        List<SyncFusionSorted> sorted = new ArrayList<>();
        sorted.add(new SyncFusionSorted("id", "ascending"));
        List<MgmtGanttResource> listOrig = findAll(sorted, projectId);
        List<GResource> listRp = new ArrayList<>();
        listOrig.forEach((it) -> {
            listRp.add(new GResource(it.getCode(), it.getFirstname() + " " + it.getLastname() + " [ " + it.getTitle() + " ]"));
        });
        return listRp;
    }

    @Override
    public void save(List<ResourceModel> elems, Map<String, Object> params) {
        elems.forEach((elem) -> {
            dao.save(elem.getResources(), params);
        });
    }
    
}
