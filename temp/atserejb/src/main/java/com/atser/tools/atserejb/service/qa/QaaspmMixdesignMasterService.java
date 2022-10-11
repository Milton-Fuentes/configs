/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaaspmMixdesignMaster;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.qa.ImportAspmMixDesignTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignMasterService extends ICrudService<BigDecimal, QaaspmMixdesignMaster>{

    QaaspmMixdesignMaster findById(ManageITHeader header, String id);

    QaaspmMixdesignMaster findById(ManageITHeader header, BigDecimal id);
    
    void changeStatus(ManageITBodyRequest request);
    
    void updateCurrentJMFNo(BigDecimal mixId, String jmfNo);
    
    List<DataSelectWrapper> filterByProject(String projectId, String supplierId, String supplierLocId, String nmasId, String gyrationId, String mixTypeId);

    void assignToProject(ManageITHeader header, String projectId, String mixId);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    String generateExcelTemplate(String paramClientId, String paramSetId, String tplbasePath, String docpathsegment);

    List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportAspmMixDesignTO data);
}
