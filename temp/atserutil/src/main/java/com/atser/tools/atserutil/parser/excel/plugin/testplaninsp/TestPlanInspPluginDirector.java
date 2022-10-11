/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp;

import com.atser.tools.atserutil.document.read.excel.ExcelContext;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eTestPlanInsp;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model.TestPlanInspDef;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.strategy.TestPlanInspContext;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class TestPlanInspPluginDirector implements Serializable {

    private ExcelContext pExcelCtx;
    private ExcelDocument pDoc;
    private eTestPlanInsp pTemplate;
    private TestPlanInspContext context;

    public TestPlanInspPluginDirector(File pfile, eTestPlanInsp ptmp) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        this.pExcelCtx = new ExcelContext(pfile);
        this.pTemplate = ptmp;
        this.pDoc = pExcelCtx.getPExcelDoc();
        this.context = new TestPlanInspContext(this.pTemplate);
    }

    public List<TestPlanInspDef> getModel() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<TestPlanInspDef> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            if (StringSupport.isNotNullAndNotEmpty(page.getSheetName()) && page.getSheetName().equals("Data")) {
                listmodel.addAll(context.getpStrategy(page).getResourceData());
                break;
            } else {
                throw new TemplateDifferentException("Wrong Template format");
            }
        }
        pDoc.closeInput();
        return listmodel;
    }

    public List<TestPlanInspDef> getModelAllSheets() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<TestPlanInspDef> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            listmodel.addAll(context.getpStrategy(page).getResourceData());
        }
        pDoc.closeInput();
        return listmodel;
    }

    public List<TestPlanInspDef> getModelPerSheet(String sheetName) throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<TestPlanInspDef> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            if (StringSupport.isNotNullAndNotEmpty(page.getSheetName()) && page.getSheetName().equals(sheetName)) {
                listmodel.addAll(context.getpStrategy(page).getResourceData());
                break;
            } else {
                throw new TemplateDifferentException("Wrong Template format");
            }
        }
        pDoc.closeInput();
        return listmodel;
    }

    public String getModelToJson() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<TestPlanInspDef> listmodel = getModel();
        if (listmodel.isEmpty()) {
            return null;
        }
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
        String mJson = gson.toJson(listmodel.get(0));
        return mJson;
    }

    public ExcelDocument getpDoc() {
        return pDoc;
    }

    public void setpDoc(ExcelDocument pDoc) {
        this.pDoc = pDoc;
    }

    public ExcelContext getpExcelCtx() {
        return pExcelCtx;
    }

    public void setpExcelCtx(ExcelContext pExcelCtx) {
        this.pExcelCtx = pExcelCtx;
    }

    public eTestPlanInsp getpTemplate() {
        return pTemplate;
    }

    public void setpTemplate(eTestPlanInsp pTemplate) {
        this.pTemplate = pTemplate;
    }
}
