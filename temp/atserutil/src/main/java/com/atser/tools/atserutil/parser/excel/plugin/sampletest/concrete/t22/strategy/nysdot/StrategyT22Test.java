/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.strategy.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.builder.nysdot.NysDOTT22TestBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model.T22TestDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.strategy.T22TestStrategy;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyT22Test extends T22TestStrategy {

    public StrategyT22Test() {
        super();
    }

    @Override
    public List<T22TestDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            NysDOTT22TestBuilder pbuilder = new NysDOTT22TestBuilder(pPage);
            if (pbuilder.isNysDOTT22Template()) {
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
        return "StrategyT22Test";
    }
}
