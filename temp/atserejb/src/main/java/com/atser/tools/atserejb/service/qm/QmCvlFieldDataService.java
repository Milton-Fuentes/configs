/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.model.QmCvlField;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QmCvlFieldDataService {

    QmCvlFieldData findById(String id);
    
    QmCvlFieldData findById(BigDecimal id);

    void save(QmCvlFieldData elem);

    void update(QmCvlFieldData elem);

    void delete(String id);

    List<QmCvlFieldData> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QmCvlFieldData> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    QmCvlField getQmCvlFieldParent(BigInteger clientId, String sectionName, String fieldCode);
}
