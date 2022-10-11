/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.mgmt;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.MgmtGanttResource;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceDef;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionSorted;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface MgmtGanttResourceDao extends ICrudDao<BigDecimal, MgmtGanttResource> {

    MgmtGanttResource findByCode(String code);

    Boolean checkIfExistByCode(String code, BigInteger projectId);

    void save(List<ResourceDef> elems, Map<String, Object> params);

    List<MgmtGanttResource> findAll(List<SyncFusionSorted> sorted, String projectId);
}
