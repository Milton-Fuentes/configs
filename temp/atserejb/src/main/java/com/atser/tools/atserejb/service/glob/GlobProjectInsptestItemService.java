/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectInsptestItem;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobProjectInsptestItemService {

    GlobProjectInsptestItem findById(String id);

    void save(GlobProjectInsptestItem elem);

    void update(GlobProjectInsptestItem elem);

    void delete(String id);

    List<GlobProjectInsptestItem> list(ManageITBodyRequest request);
    
    List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException;
}
