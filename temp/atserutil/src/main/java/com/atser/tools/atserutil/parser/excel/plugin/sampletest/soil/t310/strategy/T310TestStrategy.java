/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model.SoilTestDef;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class T310TestStrategy {

    protected Sheet pPage;

    public T310TestStrategy() {
    }

    public void setPage(Sheet page) {
        this.pPage = page;
    }

    public abstract List<SoilTestDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException;

    public abstract String getObjectName();
}
