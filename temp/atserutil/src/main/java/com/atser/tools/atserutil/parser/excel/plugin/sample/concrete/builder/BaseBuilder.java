/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.builder;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.SheetParser;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model.ConcSampleDef;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class BaseBuilder {

    protected List<ConcSampleDef> data;
    protected SheetParser parser;
    protected Sheet sheet;

    public BaseBuilder(Sheet page) {
        parser = new SheetParser();
        sheet = page;
    }

    public List<ConcSampleDef> getData() {
        return data;
    }

    public abstract void buildResources() throws ExcelParsingException, EmptyDocumentException;
}
