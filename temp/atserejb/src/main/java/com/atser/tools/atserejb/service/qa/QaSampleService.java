/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleService {

    QaSample findById(String id);

    void save(QaSample elem);

    void update(QaSample elem);

    void delete(String id);

    List<QaSample> list(ManageITBodyRequest request);
    
    Boolean existsConcMixDesign(BigInteger mixId);
    
    Boolean existsAspmMixDesign(BigInteger mixId);
    
    String getSampleCategory(String clientId, String sampleNo);

    Object getFrontEndSearchSample(ManageITHeader header, ManageITBodyRequest<Object> body);

    void changeStatus(ManageITBodyRequest<Object> request);
    
    QaSample findBySampleNo(String sampleNo, BigInteger projectId);
    
    String generateReport(ManageITHeader header, ManageITBodyRequest<ReportGridWrapper> body, String docpathsegment);

}
