/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser.strategy;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.builder.MassDOTUserInfTplBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class StrategyMassDOTUserInformation extends UserInformationStrategy{

    public StrategyMassDOTUserInformation() {
        super();
    }

    @Override
    public List<UserInformationDef> getResourceData() throws TemplateDifferentException, ExcelParsingException, EmptyDocumentException {
        if (pPage != null) {
            MassDOTUserInfTplBuilder pbuilder = new MassDOTUserInfTplBuilder(pPage);
            if (pbuilder.isMassDOTResourceTemplate()) {
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
        return "StrategyMassDOTUserInformation";
    }
    
}
