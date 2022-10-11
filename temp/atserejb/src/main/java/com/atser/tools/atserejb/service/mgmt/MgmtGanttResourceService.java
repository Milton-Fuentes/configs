/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserejb.model.MgmtGanttResource;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GResource;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface MgmtGanttResourceService {
    
    MgmtGanttResource findById(String id);

    void save(MgmtGanttResource elem);
    
    void save(List<ResourceModel> elems, Map<String, Object> params);

    void update(MgmtGanttResource elem);

    void delete(String id);

    List<MgmtGanttResource> findAll();
    
    List<MgmtGanttResource> findAll(List<SyncFusionSorted> sorted,String projectId); 
    
    String getListResourceAsJson(String projectId);
    
    List<GResource> getListResource(String projectId);
}
