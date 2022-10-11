/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.builder.AtserTplAspmMixDesignBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyAtserAspmMixDesign extends AspmMixDesignStrategy {

    public StrategyAtserAspmMixDesign() {
        super();
    }

    @Override
    public List<AspmMixDesignDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            AtserTplAspmMixDesignBuilder pbuilder = new AtserTplAspmMixDesignBuilder(pPage);
            if (pbuilder.isAtserResourceTemplate()) {
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
        return "StrategyAtserAspmMixDesign";
    }

}
