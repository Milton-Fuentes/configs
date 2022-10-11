/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier.builder;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.model.SupplierDef;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.section.SectionDetectTplNysDOTSupplier;
import com.atser.tools.atserutil.parser.excel.plugin.supplier.section.SectionNysDOTSupplier;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class NysDOTSupplierTplBuilder extends BaseBuilder {

    public NysDOTSupplierTplBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }
    
    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionNysDOTSupplier> entityList = parser.createEntity(sheet, namepage, SectionNysDOTSupplier.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }
        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getProdrSuppCd(), rs.getProdrSuppNm()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(new SupplierDef(rs));
            }
        });
    }

    public boolean isNysDotResourceTemplate() {
        SectionDetectTplNysDOTSupplier result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplNysDOTSupplier> emList = parser.createEntity(sheet, pagename, SectionDetectTplNysDOTSupplier.class);
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
