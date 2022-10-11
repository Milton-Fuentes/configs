/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.builder.AtserTplConcMixDesignBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyAtserConcMixDesign extends ConcMixDesignStrategy {

    public StrategyAtserConcMixDesign() {
        super();
    }

    @Override
    public List<ConcMixDesignDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
             AtserTplConcMixDesignBuilder pbuilder = new AtserTplConcMixDesignBuilder(pPage);
            if(pbuilder.isAtserResourceTemplate()) {
                pbuilder.buildResources();
                return pbuilder.getData();
            }
            else {
                throw new TemplateDifferentException("Wrong format in " + pPage.getSheetName());
            }
        }
        return null;
    }

    @Override
    public String getObjectName() {
        return "StrategyAtserConcMixDesign";
    }
}
