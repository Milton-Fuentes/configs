/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleTestService {

    QaSampleTest findById(String id);

    QaSampleTest findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaSampleTest elem);

    void update(ManageITHeader header, QaSampleTest elem);

    void delete(String id);

    List<QaSampleTest> list(ManageITBodyRequest request);

    Object getFrontEndSearchTest(ManageITHeader header, ManageITBodyRequest body);

    QaSampleTest createEmptyTestOrGetTest(ManageITHeader header, QaSample sampleId, String material, String testTable);

    BigInteger getNextTestNoByProject(BigInteger projectId);

    String generateReport(ManageITHeader header, ManageITBodyRequest<ReportGridWrapper> body, String docpathsegment);

    public void signByTestId(ManageITHeader header, String id, String signaction);
    
    BigDecimal getDynamicTestTableId(String tableName, BigInteger sampleTestId);
}
