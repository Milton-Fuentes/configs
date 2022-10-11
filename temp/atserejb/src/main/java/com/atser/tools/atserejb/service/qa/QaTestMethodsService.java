/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaTestMethods;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaTestMethodsService {

    QaTestMethods findById(String id);

    void save(QaTestMethods elem);

    void update(QaTestMethods elem);

    void delete(String id);

    List<QaTestMethods> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    Object getFrontEndTestMethodsByCatg(ManageITHeader header, ManageITBodyRequest<Object> body);

    List<QaTestMethods> getTestMethodsByCatgAndTestTable(BigInteger clientId, String catg, String testTable);

    List<DataSelectWrapper> listForSelect(ManageITBodyRequest request);

    public Object findBySampleTestId(String sampleTestId);

}
