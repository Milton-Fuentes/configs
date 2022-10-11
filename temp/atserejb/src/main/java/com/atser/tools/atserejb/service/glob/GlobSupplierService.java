/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobSupplierService {

    GlobSupplier findById(String id);
    
    GlobSupplier findByImpCode(String code);

    void save(GlobSupplier elem);

    void update(GlobSupplier elem);

    void delete(String id);

    List<GlobSupplier> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobSupplier> dataTableList(ManageITBodyRequest request);

    void changeEnabled(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    List<GlobSupplier> filterByMaterialType(String clientId, String materialType);

    List<GlobSupplier> filterByMaterialTypeByProject(String clientId, String projectId, String materialType);

    List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType, BigDecimal supplierId);
    
    List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType);

    List<DataSelectWrapper> getSupplierAndLocationForSelect(BigInteger clientId, String materialType);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);
    
    List<GlobSupplier> filterBinderSupplierByProject(String clientId, String projectId);
    
    List<GlobSupplier> filterSupplierByProject(String clientId, String projectId);

    Object processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException;
}
