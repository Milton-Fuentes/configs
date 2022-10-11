/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobProjectInsptestItemDao;
import com.atser.tools.atserejb.model.GlobProjectInsptestItem;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.parser.eTestPlanInsp;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.GenericStatusPojo;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.TestPlanInspPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model.TestPlanInspDef;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.apache.poi.openxml4j.util.ZipSecureFile;

@Stateless
public class GlobProjectInsptestItemServiceImpl implements GlobProjectInsptestItemService, IBaseEJBException {

    @Inject
    private GlobProjectInsptestItemDao dao;

    @Override
    public GlobProjectInsptestItem findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobProjectInsptestItem findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobProjectInsptestItem elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobProjectInsptestItem elem) {
        if (elem != null) {
            GlobProjectInsptestItem model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobProjectInsptestItem> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    // **************** Import Test Plan Insp [BEGIN] *************************
    @Override
    public List<GenericStatusPojo> processData(Map<String, Object> metaDataFile, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        if (StringSupport.isNullOrEmpty(metaDataFile.get("filename"), params.get("clientId"), params.get("userId"), params.get("filetpl"), params.get("testplanId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<GenericStatusPojo> importErrors = new ArrayList<>();
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        TestPlanInspPluginDirector director;
        ManageITHeader header = new ManageITHeader(StringSupport.emptyOnNull(params.get("sessionUser")), StringSupport.getString(params.get("clientId")), null, StringSupport.emptyOnNull(params.get("modIp")));
        director = new TestPlanInspPluginDirector(new File(StringSupport.emptyOnNull(metaDataFile.get("filename"))), eTestPlanInsp.valueOf(StringSupport.emptyOnNull(params.get("filetpl"))));
        List<TestPlanInspDef> model = director.getModelAllSheets();
        Map<String, Double> rMap = sumItemMap(model);
        List<GlobProjectInsptestItem> currentDbList = list(new ManageITBodyRequest(0, 0).filter("insptestId", NumberSupport.getBigInteger(params.get("testplanId"))));
        if (rMap == null || currentDbList == null || currentDbList.isEmpty()) {
            importErrors.add(new GenericStatusPojo(StringSupport.getString(params.get("testplanId")), "ERROR", null, null, "Empty Document."));
            return importErrors;
        }

        if (currentDbList == null || currentDbList.isEmpty()) {
            importErrors.add(new GenericStatusPojo(StringSupport.getString(params.get("testplanId")), "ERROR", null, null, "Empty Test Plan."));
            return importErrors;
        }
        // Update Items. 
        currentDbList.forEach(it -> {
            Double actualQty = rMap.get(it.getItemNo());
            if (actualQty == null) {
                importErrors.add(new GenericStatusPojo(it.getItemNo(), "ERROR", null, null, "Item No Not Found."));
            } else {
                it.setActualQty(actualQty);
                it.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                it.setLastModIp(header.getModIp());
                it.setLastModBy(header.getUser());
                dao.update(it);
            }
        });
        return importErrors;
    }

    private Map<String, Double> sumItemMap(List<TestPlanInspDef> itemList) {
        if (itemList != null && !itemList.isEmpty()) {
            itemList = itemList.stream().sorted(Comparator.comparing(TestPlanInspDef::getItemNo)).collect(Collectors.toList());
            Map<String, Double> groupByItemNo = itemList.stream().collect(Collectors.groupingBy(TestPlanInspDef::getItemNo, Collectors.summingDouble(f -> f.getActualQty())));
            return groupByItemNo;
        }
        return null;
    }

    // **************** Import Test Plan Insp [END] *************************
}
