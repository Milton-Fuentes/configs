/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.CmBiditUserProfile;
import com.atser.tools.atserutil.objects.bo.cm.CmBiditUserProfileSearchBO;
import com.atser.tools.atserutil.objects.pojo.cm.CmBiditUserProfileSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface CmBiditUserProfileDao extends ICrudDao<BigDecimal, CmBiditUserProfile> {

    DataTableWrapper<CmBiditUserProfileSearchBO> getFrontEndSearch(CmBiditUserProfileSearchDefParam filters);

    boolean exists(CmBiditUserProfile elem);
}
