/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser;

import com.atser.tools.atserutil.document.read.excel.ExcelContext;
import com.atser.tools.atserutil.document.read.excel.ExcelDocument;
import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.strategy.UserInformationContext;
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
public class GlobUserPluginDirector implements Serializable {

    private ExcelContext pExcelCtx;
    private ExcelDocument pDoc;
    private eUserInformation pTemplate;
    private UserInformationContext context;

    public GlobUserPluginDirector(File pfile, eUserInformation ptmp) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException {
        this.pExcelCtx = new ExcelContext(pfile);
        this.pTemplate = ptmp;
        this.pDoc = pExcelCtx.getPExcelDoc();
        this.context = new UserInformationContext(this.pTemplate);
    }

    public List<UserInformationDef> getUserInformationModel() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<UserInformationDef> listmodel = new ArrayList<>();
        for (Sheet page : pDoc.getListPages()) {
            if (StringSupport.isNotNullAndNotEmpty(page.getSheetName()) && page.getSheetName().equals("UserData")) {
                listmodel.addAll(context.getpStrategy(page).getResourceData());
                break;
            } else {
                throw new TemplateDifferentException("Wrong Template format");
            }
        }
        pDoc.closeInput();
        return listmodel;
    }

    public String getUserInformationModelToJson() throws TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        List<UserInformationDef> listmodel = getUserInformationModel();
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

    public eUserInformation getpTemplate() {
        return pTemplate;
    }

    public void setpTemplate(eUserInformation pTemplate) {
        this.pTemplate = pTemplate;
    }
}
