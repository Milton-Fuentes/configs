/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.builder.NysDOTSupplierTplBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyNysDOTSupplier extends SupplierStrategy {

    public StrategyNysDOTSupplier() {
        super();
    }

    @Override
    public List<SupplierDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            NysDOTSupplierTplBuilder pbuilder = new NysDOTSupplierTplBuilder(pPage);
            if (pbuilder.isNysDotResourceTemplate()) {
                pbuilder.buildResources();
                return pbuilder.getData();
            } else {
                throw new TemplateDifferentException("Wrong format in " + pPage.getSheetName());
            }
        }
        return null;
    }

    @Override
    public String getObjectName() {
        return "StrategyNysDOTSupplier";
    }
}
