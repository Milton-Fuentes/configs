/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.strategy;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.resource.builder.AtserResourceTplBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;

/**
 *
 * @author droldan
 */
public class StrategyAtserResource extends GanttResourceStrategy {

    public StrategyAtserResource() {
        super();
    }

    @Override
    public ResourceModel getResourceData() throws TemplateDifferentException, ExcelParsingException {
         if (pPage != null) {
             AtserResourceTplBuilder pbuilder = new AtserResourceTplBuilder(pPage);
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
        return "StrategyAtserResource";
    }

}