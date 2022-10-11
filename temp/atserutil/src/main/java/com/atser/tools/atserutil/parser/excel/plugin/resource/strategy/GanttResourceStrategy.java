/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.strategy;

import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class GanttResourceStrategy {

    protected Sheet pPage;

    public GanttResourceStrategy() {
    }

    public void setPage(Sheet page) {
        this.pPage = page;
    }

    public abstract ResourceModel getResourceData() throws TemplateDifferentException, ExcelParsingException;

    public abstract String getObjectName();

}
