/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.builder;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import com.atser.tools.atserutil.parser.excel.plugin.resource.section.SectionDetectTplResource;
import com.atser.tools.atserutil.parser.excel.plugin.resource.section.SectionGanttResource;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class AtserResourceTplBuilder extends BaseBuilder {

    public AtserResourceTplBuilder(Sheet page) {
        super(page);
        data = new ResourceModel();
    }

    @Override
    public void buildResources() throws ExcelParsingException {
        String namepage = sheet.getSheetName();
        List<SectionGanttResource> entityList = parser.createEntity(sheet, namepage, SectionGanttResource.class);
        entityList.forEach((et) -> {
            data.addNewResource(et);
        });

    }

    public boolean isAtserResourceTemplate() {
        SectionDetectTplResource result;
        String pagename = sheet.getSheetName();

        try {
            List<SectionDetectTplResource> emList = parser.createEntity(sheet, pagename, SectionDetectTplResource.class
            );
            result = emList.get(0);
            if (result.isValid()) {
                return true;
            }
        } catch (ExcelParsingException | IllegalArgumentException | IllegalAccessException ex) {
            return false;
        }
        return false;
    }

}
