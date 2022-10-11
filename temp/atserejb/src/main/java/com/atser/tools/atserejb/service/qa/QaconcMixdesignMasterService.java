/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaconcMixdesignMaster;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.qa.ImportConcMixDesignTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface QaconcMixdesignMasterService {

    QaconcMixdesignMaster findById(String id);

    QaconcMixdesignMaster findById(BigDecimal id);
    
    QaconcMixdesignMaster findById(ManageITHeader header, String id);

    QaconcMixdesignMaster findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, QaconcMixdesignMaster elem);

    void update(ManageITHeader header, QaconcMixdesignMaster elem);

    void delete(String id);

    List<QaconcMixdesignMaster> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QaconcMixdesignMaster> dataTableList(ManageITBodyRequest request);
    
    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    List<DataSelectWrapper> filterByProject(String projectId, String supplierId, String supplierLocId);
    
    void assignToProject(ManageITHeader header, String projectId, String mixId);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    String generateExcelTemplate(String paramClientId, String tplbasePath, String docpathsegment);

    List<GenericStatusPojo> saveFromTo(ManageITHeader header, ImportConcMixDesignTO data);
    
    List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException;
}
