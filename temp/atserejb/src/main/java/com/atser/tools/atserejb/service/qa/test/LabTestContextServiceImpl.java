/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.common.interfaces.ILabTestStorageStrategy;
import com.atser.tools.atserejb.common.qualifiers.labtest.LabTestAnnotationLiteral;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.enumerator.eLabSpecification;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.UnsatisfiedResolutionException;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class LabTestContextServiceImpl implements LabTestContextService, IBaseEJBException {

    @Inject
    @Any
    private Instance<ILabTestStorageStrategy> strategyInstance;

    /**
     * Save CSV
     *
     * @param pPath
     * @param params
     */
    @Override
    public void saveCsv(String pPath, Map<String, Object> params) {
        if (StringSupport.isNullOrEmpty(pPath) || params == null || !params.containsKey("standard") || !params.containsKey("spec")) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (StringSupport.isNullOrEmpty(params.get("standard")) || StringSupport.isNullOrEmpty(params.get("spec"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String standard = params.get("standard").toString().toUpperCase();
        String spec = params.get("spec").toString().toUpperCase();
        try {
            ILabTestStorageStrategy strategy = strategyInstance.select(LabTestAnnotationLiteral.test(eLabSpecification.getEnum(standard + "_" + spec))).get();
            if (strategy != null) {
                strategy.parseCsvAndSave(pPath, params);
            } else {
                throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with a CSV format and the description of the test to support it.");
            }
            strategyInstance.destroy(strategy);
        } catch (IllegalArgumentException | UnsatisfiedResolutionException ex) {
            throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with a CSV format and the description of the test to support it.");
        }
    }

    @Override
    public List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("standard"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String standard = params.get("standard").toString().toUpperCase();
        try {
            ILabTestStorageStrategy strategy = strategyInstance.select(LabTestAnnotationLiteral.test(eLabSpecification.getEnum(standard))).get();
            if (strategy != null) {
                return strategy.parseExcelAndSave(metaDataFile, params);
            } else {
                throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with a document format and the description of the test to support it.");
            }
            strategyInstance.destroy(strategy);
        } catch (IllegalArgumentException | UnsatisfiedResolutionException ex) {
            throwBaseException(Response.Status.NOT_IMPLEMENTED, "Please contact us with a document format and the description of the test to support it.");
        }
        return null;
    }
}
