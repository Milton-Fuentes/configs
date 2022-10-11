/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.strategy.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.builder.nysdot.NysDOTConcSampleBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model.ConcSampleDef;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.strategy.ConcSampleStrategy;
import java.util.List;


/**
 *
 * @author droldan
 */
public class StrategyConcSample extends ConcSampleStrategy {

    public StrategyConcSample() {
        super();
    }

    @Override
    public List<ConcSampleDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
             NysDOTConcSampleBuilder pbuilder = new NysDOTConcSampleBuilder(pPage);
            if(pbuilder.isNysDOTConcSampleTemplate()) {
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
        return "StrategyConcSample";
    }
    
}
