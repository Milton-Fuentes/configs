/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaInspectionSimpleCat;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaInspectionSimpleCatService {

    QaInspectionSimpleCat findById(String id);
    
    QaInspectionSimpleCat findById(BigDecimal id);

    void save(QaInspectionSimpleCat elem);

    void update(QaInspectionSimpleCat elem);

    void delete(String id);

    List<QaInspectionSimpleCat> list(ManageITBodyRequest request);
}
