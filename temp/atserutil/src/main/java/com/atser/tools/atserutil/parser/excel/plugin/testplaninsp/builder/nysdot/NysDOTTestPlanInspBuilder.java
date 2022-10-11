/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.builder.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.builder.BaseBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model.TestPlanInspDef;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.section.nysdot.SectionDetectTplTestPlanInsp;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.section.nysdot.SectionTestPlanInsp;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTTestPlanInspBuilder extends BaseBuilder {

    public NysDOTTestPlanInspBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionTestPlanInsp> entityList = parser.createEntity(sheet, namepage, SectionTestPlanInsp.class, 15);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> validateField(rs)).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new TestPlanInspDef(rs));
            }
        });
    }

    private Boolean validateField(SectionTestPlanInsp rs) {
        if (StringSupport.isNotNullAndNotEmpty(rs.getLineItem(), rs.getItemCode(), rs.getTotalQtyUsedToDate()) 
                && NumberSupport.isNumeric(StringSupport.sanitizeString(rs.getTotalQtyUsedToDate(), ","))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean isNysDOTTestPlanInspTemplate() {
        SectionDetectTplTestPlanInsp result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplTestPlanInsp> emList = parser.createEntity(sheet, pagename, SectionDetectTplTestPlanInsp.class);
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
