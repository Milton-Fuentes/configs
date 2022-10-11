/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier;

import com.atser.tools.atserutil.document.read.excel.ExcelContext;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eTemplateSupplier;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.strategy.SupplierContext;
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
public class SupplierPluginDirector implements Serializable {

    private ExcelContext pExcelCtx;
    private ExcelDocument pDoc;
    private eTemplateSupplier pTemplate;
    private SupplierContext context;

    public SupplierPluginDirector(File pfile, eTemplateSupplier ptmp) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        this.pExcelCtx = new ExcelContext(pfile);
        this.pTemplate = ptmp;
        this.pDoc = pExcelCtx.getPExcelDoc();
        this.context = new SupplierContext(this.pTemplate);
    }

    public List<SupplierDef> getModel() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<SupplierDef> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            if (StringSupport.isNotNullAndNotEmpty(page.getSheetName())) {
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
        List<SupplierDef> listmodel = getModel();
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

    public eTemplateSupplier getpTemplate() {
        return pTemplate;
    }

    public void setpTemplate(eTemplateSupplier pTemplate) {
        this.pTemplate = pTemplate;
    }
}
