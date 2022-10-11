/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.builder.nysdot;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.builder.BaseBuilder;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model.ConcSampleDef;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.section.nysdot.SectionConcSample;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.section.nysdot.SectionDetectTplConcSample;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTConcSampleBuilder extends BaseBuilder {

    public NysDOTConcSampleBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionConcSample> entityList = parser.createEntity(sheet, namepage, SectionConcSample.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getCont_id(), rs.getSmpl_id(), rs.getMatl_cd()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new ConcSampleDef(rs));
            }
        });
    }
    
    public boolean isNysDOTConcSampleTemplate() {
        SectionDetectTplConcSample result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplConcSample> emList = parser.createEntity(sheet, pagename, SectionDetectTplConcSample.class);
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
