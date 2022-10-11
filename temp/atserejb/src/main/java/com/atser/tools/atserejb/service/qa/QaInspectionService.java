/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaInspectionService extends ICrudService<BigDecimal, QaInspection>{

    QaInspection findById(ManageITHeader header, String id);

    QaInspection findById(ManageITHeader header, BigDecimal id);

    void changeStatus(ManageITBodyRequest request);
    
    void updateTestStatus(BigDecimal id, BigInteger statusId);

    String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request);

    void generateReportAndUploadToTrackIT(QaInspection elem, String serverPath, String tplbasePath, String docpathsegment, ManageITHeader header);
    
    Object getFrontEndSearchInspection(ManageITHeader header, ManageITBodyRequest body);
}
