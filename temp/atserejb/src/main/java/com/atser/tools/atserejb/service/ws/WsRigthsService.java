/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.model.WsRigths;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface WsRigthsService {

    WsRigths findById(String id);

    void save(WsRigths elem);

    void update(WsRigths elem);

    void delete(String id);

    List<WsRigths> list(ManageITBodyRequest request);
}
