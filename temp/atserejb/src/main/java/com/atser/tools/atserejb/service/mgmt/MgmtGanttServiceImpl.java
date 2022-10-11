/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserejb.dao.mgmt.MgmtGanttDao;
import com.atser.tools.atserejb.model.MgmtGantt;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GResource;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MgmtGanttServiceImpl implements MgmtGanttService, IBaseEJBException {

    @Inject
    private MgmtGanttDao dao;

    @Inject
    MgmtGanttResourceService ganttResourceService;

    @Override
    public MgmtGantt findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public MgmtGantt findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(MgmtGantt elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void saveMetaDataGantt(String id, Object data, SyncFusionEnvInfo envinfo) {
        if (data != null && id != null) {
            dao.saveMetaDataGantt(NumberSupport.getBigDecimal(id), data.toString(), envinfo);
        }
    }

    @Override
    public void update(MgmtGantt elem) {
        if (elem != null) {
            MgmtGantt model = findById(elem.getId());
            model.setName(elem.getName());
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
    public String fillMetaDataFromImportFile(List<GModel> listmodel, Map<String, Object> params) {
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
        List<GResource> listRs = ganttResourceService.getListResource(StringSupport.getString(params.get("projectId")));
        GModel model = listmodel.get(0);
        if (model != null) {
            model.setResources(listRs);
            String ganttJson = gson.toJson(model);
            return ganttJson;
        }
        return "[]";
    }

    @Override
    public String getMetaData(String id) {
        Map<String, String> params = new LinkedHashMap<>();
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
        MgmtGantt elem = dao.findById(NumberSupport.getBigDecimal(id));
        List<GResource> listRs = ganttResourceService.getListResource(elem.getProjectId().toString());
        GModel model;
        if (elem.getData() != null && !elem.getData().isEmpty()) {
            model = gson.fromJson(elem.getData(), GModel.class);
            model.buildParamsForDates();
        } else {
            model = new GModel();
            params.put("scheduleStartDate", "1/1/"+DateSupport.getNowToFormat("yyyy"));
            params.put("scheduleEndDate", "12/31/"+DateSupport.getNowToFormat("yyyy"));
            model.setParameters(params);
        }

        model.setResources(listRs);
        String ganttJson = gson.toJson(model);
        return ganttJson;
    }

    @Override
    public List<MgmtGantt> findAll() {
        return dao.findAll();
    }

    @Override
    public Map<String, Object> isOpen(String id) {
        MgmtGantt rd = findById(id);
        Map<String, Object> result = new HashMap<>();
        if (rd.getOpen() == 0) {
            result.put("open", Boolean.FALSE);
        } else {
            result.put("open", Boolean.TRUE);
            result.put("openby", rd.getOpenBy());
        }
        return result;
    }

    @Override
    public void setOpenGantt(String id, Object data, SyncFusionEnvInfo envinfo) {
        if (data != null && envinfo != null && id != null) {
            dao.setOpenGantt(NumberSupport.getBigDecimal(id), (data.toString().equals("true") ? Boolean.TRUE : Boolean.FALSE), envinfo);
        }
    }

    @Override
    public List<MgmtGantt> findAll(List<SyncFusionSorted> sorted, String projectId) {
        return dao.findAll(sorted, projectId);
    }

}
