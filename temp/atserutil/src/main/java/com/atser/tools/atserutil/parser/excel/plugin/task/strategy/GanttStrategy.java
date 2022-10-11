/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.strategy;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class GanttStrategy {

    protected Sheet pPage;

    public GanttStrategy() {
    }

    public void setPage(Sheet page) {
        this.pPage = page;
    }

    public abstract GModel getGanttData() throws TemplateDifferentException, ExcelParsingException;

    public abstract String getObjectName();
}
