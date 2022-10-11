/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmEmEmailReceiver;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface CmEmEmailReceiverService {

    CmEmEmailReceiver findById(String id);

    BigInteger save(CmEmEmailReceiver elem);

    void update(CmEmEmailReceiver elem);

    void delete(ManageITBodyRequest request);

    List<CmEmEmailReceiver> list(ManageITBodyRequest request);
    
}
