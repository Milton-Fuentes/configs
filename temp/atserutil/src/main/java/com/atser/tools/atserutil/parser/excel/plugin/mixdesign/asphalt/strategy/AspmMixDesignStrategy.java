/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class AspmMixDesignStrategy {

    protected Sheet pPage;

    public AspmMixDesignStrategy() {
    }

    public void setPage(Sheet page) {
        this.pPage = page;
    }

    public abstract List<AspmMixDesignDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException;

    public abstract String getObjectName();
}
