/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.strategy;

import com.atser.tools.atserutil.enumerator.parser.eTestPlanInsp;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.strategy.nysdot.StrategyTestPlanInsp;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class TestPlanInspContext implements Serializable {

    private TestPlanInspStrategy pStrategy;

    public TestPlanInspContext(eTestPlanInsp stg) {
        switch (stg) {
            case AtserTestPlanInsp: {
                pStrategy = null;
                break;
            }
            case NysDOTTestPlanInsp: {
                pStrategy = new StrategyTestPlanInsp();
                break;
            }
        }
    }

    public TestPlanInspStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
