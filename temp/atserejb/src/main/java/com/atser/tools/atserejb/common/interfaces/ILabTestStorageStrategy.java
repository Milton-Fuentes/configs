/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.interfaces;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface ILabTestStorageStrategy {

    void parseCsvAndSave(String pPath, Map<String, Object> params);
    
    List<GenericStatusPojo> parseExcelAndSave(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException;
}
