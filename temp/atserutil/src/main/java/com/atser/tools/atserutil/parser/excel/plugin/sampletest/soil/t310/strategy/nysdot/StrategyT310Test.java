/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.strategy.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.builder.nysdot.NysDOTT310TestBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model.SoilTestDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.strategy.T310TestStrategy;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyT310Test extends T310TestStrategy {

    public StrategyT310Test() {
        super();
    }

    @Override
    public List<SoilTestDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            NysDOTT310TestBuilder pbuilder = new NysDOTT310TestBuilder(pPage);
            if (pbuilder.isNysDOTT310TestTemplate()) {
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
        return "StrategyT310Test";
    }
}
