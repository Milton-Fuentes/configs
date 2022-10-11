/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.builder;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.SectionConcMixDesign;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.SectionDetectTplConcMixDesign;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class AtserTplConcMixDesignBuilder extends BaseBuilder {

    public AtserTplConcMixDesignBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionConcMixDesign> entityList = parser.createEntity(sheet, namepage, SectionConcMixDesign.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getMixdesignNo(), rs.getProducedBy(), rs.getPlantLocation(), rs.getMixdesignType(), rs.getMixStatus()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new ConcMixDesignDef(rs));
            }
        });
    }

    public boolean isAtserResourceTemplate() {
        SectionDetectTplConcMixDesign result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplConcMixDesign> emList = parser.createEntity(sheet, pagename, SectionDetectTplConcMixDesign.class);
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
