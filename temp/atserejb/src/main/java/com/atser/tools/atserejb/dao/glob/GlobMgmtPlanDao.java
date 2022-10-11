/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserutil.objects.bo.glob.mgmtplan.GlobMgmtPlanBO;
import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobMgmtPlan;
import com.atser.tools.atserutil.objects.pojo.glob.GlobMgmtPlanSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface GlobMgmtPlanDao extends ICrudDao<BigDecimal, GlobMgmtPlan> {

    DataTableWrapper<GlobMgmtPlanBO> getFrontEndSearch(GlobMgmtPlanSearchDefParam filters);
}
