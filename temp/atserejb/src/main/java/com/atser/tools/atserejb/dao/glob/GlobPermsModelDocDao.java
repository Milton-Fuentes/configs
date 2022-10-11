/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobPermsModelDoc;
import com.atser.tools.atserutil.objects.bo.glob.permissionmodel.GlobPermsModelDocBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobPermsModelDocSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobPermsModelDocDao extends ICrudDao<BigDecimal, GlobPermsModelDoc> {

    void deactiveMain(BigInteger clientId);

    BigInteger getNextGlobalSequenceNo(BigInteger clientId);

    DataTableWrapper<GlobPermsModelDocBO> getFrontEndSearch(GlobPermsModelDocSearchDefParam filters);
}
