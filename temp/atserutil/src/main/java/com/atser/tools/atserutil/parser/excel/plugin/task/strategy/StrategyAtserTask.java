/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.atser.tools.atserutil.parser.excel.plugin.task.strategy;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.builder.AtserTaskTplBuilder;

/**
 *
 * @author droldan
 */
public class StrategyAtserTask extends GanttStrategy {

    public StrategyAtserTask() {
        super();
    }

    @Override
    public GModel getGanttData() throws TemplateDifferentException, ExcelParsingException {
         if (pPage != null) {
            AtserTaskTplBuilder pbuilder = new AtserTaskTplBuilder(pPage);
            if(pbuilder.isAtserTaskTemplate()) {
                pbuilder.buildTasks();
                return pbuilder.getData();
            }
            else {
                throw new TemplateDifferentException("Wrong format in " + pPage.getSheetName());
            }
        }
        return null;
    }

    @Override
    public String getObjectName() {
        return "AtserTask";
    }

}
