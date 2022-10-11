/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model.T22TestDef;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class T22TestStrategy {

    protected Sheet pPage;

    public T22TestStrategy() {
    }

    public void setPage(Sheet page) {
        this.pPage = page;
    }

    public abstract List<T22TestDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException;

    public abstract String getObjectName();
}
