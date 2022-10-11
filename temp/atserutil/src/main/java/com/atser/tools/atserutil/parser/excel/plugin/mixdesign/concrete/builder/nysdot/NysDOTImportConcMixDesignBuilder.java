/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.builder.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.builder.BaseBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.nysdot.SectionDetectTplNysDOTImportConcMixDesign;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.section.nysdot.SectionNysDOTImportConcMixDesign;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTImportConcMixDesignBuilder extends BaseBuilder {

    public NysDOTImportConcMixDesignBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionNysDOTImportConcMixDesign> entityList = parser.createEntity(sheet, namepage, SectionNysDOTImportConcMixDesign.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getMix_id(), rs.getProdr_supp_cd(), rs.getConc_clas_t()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new ConcMixDesignDef(rs));
            }
        });
    }

    public boolean isNysDOTImportResourceTemplate() {
        SectionDetectTplNysDOTImportConcMixDesign result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplNysDOTImportConcMixDesign> emList = parser.createEntity(sheet, pagename, SectionDetectTplNysDOTImportConcMixDesign.class);
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
