/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.builder.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.builder.BaseBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model.SoilTestDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.section.nysdot.SectionDetectTplT310Test;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.section.nysdot.SectionT310Test;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTT310TestBuilder extends BaseBuilder {

    public NysDOTT310TestBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionT310Test> entityList = parser.createEntity(sheet, namepage, SectionT310Test.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getSampleid(), rs.getSampledate()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new SoilTestDef(rs));
            }
        });
    }

    public boolean isNysDOTT310TestTemplate() {
        SectionDetectTplT310Test result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplT310Test> emList = parser.createEntity(sheet, pagename, SectionDetectTplT310Test.class);
            if (emList == null || emList.isEmpty()) {
                return false;
            }
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
