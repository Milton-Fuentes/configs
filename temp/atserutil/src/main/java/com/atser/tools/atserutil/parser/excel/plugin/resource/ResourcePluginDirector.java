/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource;

import com.atser.tools.atserutil.document.read.excel.ExcelContext;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttResource;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import com.atser.tools.atserutil.parser.excel.plugin.resource.strategy.GanttResourceContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class ResourcePluginDirector implements Serializable {

    private ExcelContext pExcelCtx;
    private ExcelDocument pDoc;
    private eTemplateGanttResource pTemplate;
    private GanttResourceContext context;

    public ResourcePluginDirector(File pfile, eTemplateGanttResource ptmp) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
            this.pExcelCtx = new ExcelContext(pfile);
            this.pTemplate = ptmp;
            this.pDoc = pExcelCtx.getPExcelDoc();
            this.context = new GanttResourceContext(this.pTemplate);
    }

    public List<ResourceModel> getGanttResourceModel() throws TemplateDifferentException, ExcelParsingException {
        List<ResourceModel> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            listmodel.add(context.getpStrategy(page).getResourceData());
        }
        return listmodel;
    }

    public String getGanttResourceModelToJson() throws TemplateDifferentException, ExcelParsingException {
        List<ResourceModel> listmodel = getGanttResourceModel();
        if(listmodel.isEmpty()) {
            return null;
        }
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.excludeFieldsWithoutExposeAnnotation().create();
        String ganttJson = gson.toJson(listmodel.get(0));
        return ganttJson;       
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

    public eTemplateGanttResource getpTemplate() {
        return pTemplate;
    }

    public void setpTemplate(eTemplateGanttResource pTemplate) {
        this.pTemplate = pTemplate;
    }
}