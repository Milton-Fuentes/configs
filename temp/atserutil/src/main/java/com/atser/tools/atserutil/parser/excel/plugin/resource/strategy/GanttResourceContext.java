/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.strategy;

import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttResource;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class GanttResourceContext implements Serializable {

    private GanttResourceStrategy pStrategy;

    public GanttResourceContext(eTemplateGanttResource stg) {
        if (stg.equals(eTemplateGanttResource.AtserResourceTpl)) {
            pStrategy = new StrategyAtserResource();
        }
        if (stg.equals(eTemplateGanttResource.PrimaveraResourceTpl)) {
            pStrategy = new StrategyPrimaveraResource();
        }
    }

    public GanttResourceStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
