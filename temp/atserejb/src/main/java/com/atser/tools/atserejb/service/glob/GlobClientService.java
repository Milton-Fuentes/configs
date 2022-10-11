/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserutil.objects.pojo.glob.client.ClientConfig;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author droldan
 */
public interface GlobClientService {

    GlobClient findById(String id);

    void save(GlobClient elem);

    void update(GlobClient elem);

    void delete(String id);

    List<GlobClient> list(ManageITBodyRequest request);
    
    Optional<GlobClient> findByCompanyName(String name);
    
    Map<String, Boolean> getMapFlags(String clientId);
    
    Map<String, Boolean> getMapFlags(String clientId, String moduleName);
    
    String generateSequencialNumber(String clientId, BigInteger currentNo, String functionality);
    
    ClientConfig getClientConfig(BigDecimal clientId);
    
    String getStringClientConfig(BigDecimal clientId);
    
    List<DataSelectWrapper> getBidITClientListForDropdown();
}
