/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserejb.model.MgmtGantt;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface MgmtGanttService {

    MgmtGantt findById(String id);
    
    Map<String,Object>  isOpen(String id);

    void save(MgmtGantt elem);

    void saveMetaDataGantt(String id, Object data, SyncFusionEnvInfo envinfo);
    
    void setOpenGantt(String id, Object data, SyncFusionEnvInfo envinfo);

    void update(MgmtGantt elem);

    void delete(String id);

    String getMetaData(String id);
    
    String fillMetaDataFromImportFile(List<GModel> listmodel, Map<String, Object> params);

    List<MgmtGantt> findAll();
    
    List<MgmtGantt> findAll(List<SyncFusionSorted> sorted,String projectId);
}
