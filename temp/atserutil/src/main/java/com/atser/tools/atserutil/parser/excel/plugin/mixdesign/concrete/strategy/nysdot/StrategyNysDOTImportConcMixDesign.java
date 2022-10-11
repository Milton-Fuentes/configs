/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.strategy.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.builder.nysdot.NysDOTImportConcMixDesignBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.strategy.ConcMixDesignStrategy;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyNysDOTImportConcMixDesign extends ConcMixDesignStrategy {

    public StrategyNysDOTImportConcMixDesign() {
        super();
    }

    @Override
    public List<ConcMixDesignDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            NysDOTImportConcMixDesignBuilder pbuilder = new NysDOTImportConcMixDesignBuilder(pPage);
            if (pbuilder.isNysDOTImportResourceTemplate()) {
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
        return "StrategyNysDOTImportConcMixDesign";
    }
}
