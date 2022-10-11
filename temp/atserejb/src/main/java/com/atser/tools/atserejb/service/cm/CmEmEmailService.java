/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmEmEmail;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface CmEmEmailService {

    CmEmEmail findById(String id);

    BigInteger save(CmEmEmail elem);

    void update(CmEmEmail elem);

    void delete(ManageITBodyRequest request);

    List<CmEmEmail> list(ManageITBodyRequest request);
    
}
