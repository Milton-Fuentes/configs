/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipcond;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QalabEquipcondService {

    QalabEquipcond findById(String id);

    void save(QalabEquipcond elem);

    void update(QalabEquipcond elem);

    void delete(String id);

    List<QalabEquipcond> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);
    
    Object getVersion(Integer number);
    
    List getRevisions(String id);
}
