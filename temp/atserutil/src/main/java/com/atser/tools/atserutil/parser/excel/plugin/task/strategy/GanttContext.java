/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.task.strategy;

import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttTask;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class GanttContext implements Serializable {

    private GanttStrategy pStrategy;

    public GanttContext(eTemplateGanttTask stg) {
        if (stg.equals(eTemplateGanttTask.AtserTaskTpl)) {
            pStrategy = new StrategyAtserTask();
        }
        if (stg.equals(eTemplateGanttTask.PrimaveraTaskTpl)) {
            pStrategy = new StrategyPrimaveraTask();
        }
    }

    public GanttStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
