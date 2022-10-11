/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.mgmt;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.MgmtExcel;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionEnvInfo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface MgmtExcelDao extends ICrudDao<BigDecimal, MgmtExcel>{
    
    void saveMetaDataExcel(BigDecimal id, String data, SyncFusionEnvInfo envinfo);

    void setOpenExcel(BigDecimal id, Boolean data, SyncFusionEnvInfo envinfo);
    
    List<MgmtExcel> findAll(List<SyncFusionSorted> sorted,String projectId);
}
