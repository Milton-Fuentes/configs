/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.builder;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.section.SectionDetectTplTask;
import com.atser.tools.atserutil.parser.excel.plugin.task.section.SectionGanttTask;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class AtserTaskTplBuilder extends BaseBuilder {

    public AtserTaskTplBuilder(Sheet page) {
        super(page);
        data = new GModel();
    }

    public boolean isAtserTaskTemplate() {
        SectionDetectTplTask result;
        String pagename = sheet.getSheetName();
        try {
            List<SectionDetectTplTask> emList = parser.createEntity(sheet, pagename, SectionDetectTplTask.class);
            result = emList.get(0);
            if (result.isValid()) {
                return true;
            }
        } catch (ExcelParsingException | IllegalArgumentException | IllegalAccessException ex) {
            return false;
        }
        return false;
    }

    @Override
    public void buildTasks() throws ExcelParsingException{
        String namepage = sheet.getSheetName();
        List<SectionGanttTask> entityList = parser.createEntity(sheet, namepage, SectionGanttTask.class);
        for (SectionGanttTask et : entityList) {
            if (et.getId() == null) {
                break;
            }
            data.addTask(et);
        }
    }
}
