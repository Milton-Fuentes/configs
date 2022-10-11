/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.builder.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.builder.BaseBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model.T22TestDef;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.section.nysdot.SectionDetectTplT22Test;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.section.nysdot.SectionT22Test;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTT22TestBuilder extends BaseBuilder {

    public NysDOTT22TestBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionT22Test> entityList = parser.createEntity(sheet, namepage, SectionT22Test.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getSmpasmpl(), rs.getCylssmpl()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new T22TestDef(rs));
            }
        });
    }
    
    public boolean isNysDOTT22Template() {
        SectionDetectTplT22Test result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplT22Test> emList = parser.createEntity(sheet, pagename, SectionDetectTplT22Test.class);
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
