/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser.builder;

import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.model.UserInformationDef;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.section.SectionDetectTplUser;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.section.SectionUserInformation;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class AtserUserInfTplBuilder extends BaseBuilder {

    public AtserUserInfTplBuilder(Sheet page) {
        super(page);
        data = new ArrayList<>();
    }

    @Override
    public void buildResources() throws ExcelParsingException, EmptyDocumentException {
        String namepage = sheet.getSheetName();
        List<SectionUserInformation> entityList = parser.createEntity(sheet, namepage, SectionUserInformation.class);
        if (entityList == null || entityList.isEmpty()) {
            throw new EmptyDocumentException("Empty Document in " + namepage + " page.");
        }

        entityList.stream().filter((rs) -> (StringSupport.isNotNullAndNotEmpty(rs.getUserId(), rs.getFirstName(), rs.getLastName(), rs.getEmail()))).forEachOrdered((rs) -> {
            if (!rs.detectXmlBomb()) {
                data.add(buildUserInformationDef(rs));
            }
        });
    }

    public boolean isAtserResourceTemplate() {
        SectionDetectTplUser result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplUser> emList = parser.createEntity(sheet, pagename, SectionDetectTplUser.class);
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

    private UserInformationDef buildUserInformationDef(SectionUserInformation rs) {
        UserInformationDef def = new UserInformationDef();
        def.setUserId(rs.getUserId());
        def.setModule(rs.getModule());
        def.setRole(rs.getRole());
        def.setFirstName(rs.getFirstName());
        def.setMiddleInitial(rs.getMiddleInitial());
        def.setLastName(rs.getLastName());
        def.setEmail(rs.getEmail());
        def.setSuffix(rs.getSuffix());
        def.setHrTitle(rs.getHrTitle());
        def.setFunctionalTitle(rs.getFunctionalTitle());
        def.setFirm(rs.getFirm());
        def.setUnitCode(rs.getUnitCode());
        def.setAddress(rs.getAddress());
        def.setCity(rs.getCity());
        def.setState(rs.getState());
        def.setCountry(rs.getCountry());
        def.setZip(rs.getZip());
        def.setWorkPhone(rs.getWorkPhone());
        def.setCellPhone(rs.getCellPhone());
        return def;
    }

}
