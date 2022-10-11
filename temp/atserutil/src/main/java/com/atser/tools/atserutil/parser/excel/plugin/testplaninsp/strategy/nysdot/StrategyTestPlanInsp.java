/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.strategy.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.builder.nysdot.NysDOTTestPlanInspBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model.TestPlanInspDef;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.strategy.TestPlanInspStrategy;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyTestPlanInsp extends TestPlanInspStrategy {

    public StrategyTestPlanInsp() {
        super();
    }

    @Override
    public List<TestPlanInspDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            NysDOTTestPlanInspBuilder pbuilder = new NysDOTTestPlanInspBuilder(pPage);
            if (pbuilder.isNysDOTTestPlanInspTemplate()) {
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
        return "StrategyTestPlanInsp";
    }
}
