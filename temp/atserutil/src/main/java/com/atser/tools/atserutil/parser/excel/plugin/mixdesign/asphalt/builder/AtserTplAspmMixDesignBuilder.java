/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.builder;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.section.SectionAspmMixDesign;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.section.SectionDetectTplAspmMixDesign;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class AtserTplAspmMixDesignBuilder extends BaseBuilder {

    public AtserTplAspmMixDesignBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionAspmMixDesign> entityList = parser.createEntity(sheet, namepage, SectionAspmMixDesign.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getMixdesignNo(), rs.getSupplier(), rs.getSupplierLoc(), rs.getMixdesignType()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new AspmMixDesignDef(rs));
            }
        });
    }

    public boolean isAtserResourceTemplate() {
        SectionDetectTplAspmMixDesign result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplAspmMixDesign> emList = parser.createEntity(sheet, pagename, SectionDetectTplAspmMixDesign.class);
            if(emList == null || emList.isEmpty()) {
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
