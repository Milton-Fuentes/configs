/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaPListType;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaPListTypeService {

    QaPListType findById(String id);

    void save(QaPListType elem);

    void update(QaPListType elem);

    void delete(String id);

    List<QaPListType> list(ManageITBodyRequest request);
    
    List<DataSelectWrapper> listForSelect(ManageITBodyRequest request);
}
