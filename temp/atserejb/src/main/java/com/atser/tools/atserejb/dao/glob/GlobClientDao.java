/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserutil.objects.pojo.glob.client.ClientConfig;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobClientDao extends ICrudDao<BigDecimal, GlobClient>{

    Map<String, Boolean> getQmFlags(BigDecimal clientId);

    Map<String, Boolean> getCmFlags(BigDecimal clientId);
    
    ClientConfig getClientConfig(BigDecimal clientId);
    
    String getStringClientConfig(BigDecimal clientId);
    
    List<DataSelectWrapper> getBidITClientListForDropdown();
}
