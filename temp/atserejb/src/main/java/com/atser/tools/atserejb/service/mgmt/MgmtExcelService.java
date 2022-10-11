/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.mgmt;

import com.atser.tools.atserejb.model.MgmtExcel;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface MgmtExcelService {
    
    MgmtExcel findById(String id);
    
    Map<String,Object> isOpen(String id);

    void save(MgmtExcel elem);
    
    void saveMetaDataExcel(String id, Object data, SyncFusionEnvInfo envinfo);
    
    void setOpenExcel(String id, Object data, SyncFusionEnvInfo envinfo);

    void update(MgmtExcel elem);

    void delete(String id);
    
    String getMetaData(String id);

    List<MgmtExcel> findAll(List<SyncFusionSorted> sorted,String projectId);
}
