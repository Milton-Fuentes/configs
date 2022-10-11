/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task;

import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.document.read.excel.ExcelContext;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttTask;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.task.strategy.GanttContext;
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
public class TaskPluginDirector implements Serializable {

    private ExcelContext pExcelCtx;
    private ExcelDocument pDoc;
    private eTemplateGanttTask pTemplate;
    private GanttContext context;

    public TaskPluginDirector(File pfile, eTemplateGanttTask ptmp) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        this.pExcelCtx = new ExcelContext(pfile);
        this.pTemplate = ptmp;
        this.pDoc = pExcelCtx.getPExcelDoc();
        this.context = new GanttContext(this.pTemplate);
    }

    public List<GModel> getGanttModel() throws TemplateDifferentException, ExcelParsingException {
        List<GModel> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            listmodel.add(context.getpStrategy(page).getGanttData());
        }
        return listmodel;
    }

    public String getGanttModelToJson() throws TemplateDifferentException, ExcelParsingException {
        List<GModel> listmodel = getGanttModel();
        if (listmodel.isEmpty()) {
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

    public eTemplateGanttTask getpTemplate() {
        return pTemplate;
    }

    public void setpTemplate(eTemplateGanttTask pTemplate) {
        this.pTemplate = pTemplate;
    }
}
