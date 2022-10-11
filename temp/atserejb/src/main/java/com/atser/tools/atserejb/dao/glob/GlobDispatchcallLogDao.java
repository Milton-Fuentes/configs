/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchCalllogSpecimenTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobDispatchcallLogDao extends ICrudDao<BigDecimal, GlobDispatchcallLog> {

    List<GlobDispatchcallLog> findByRequestOrigID(BigInteger id);

    List<GlobDispatchcallLog> findByProjectID(BigInteger id);

    GlobDispatchcallLog findByWOID(BigInteger id);

    List<DispatchCalllogSpecimenTO> findBySpecimenList(String specList);
    
    List<DataSelectWrapper> getDispatchSelectList(BigInteger clientId);
}
