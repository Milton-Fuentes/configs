/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaInspectionType;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaInspectionTypeService {

    QaInspectionType findById(String id);
    
    QaInspectionType findById(BigDecimal id);

    void save(QaInspectionType elem);

    void update(QaInspectionType elem);

    void delete(String id);

    List<QaInspectionType> list(ManageITBodyRequest request);
}
