/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.strategy;

import com.atser.tools.atserutil.enumerator.parser.eT310Test;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.strategy.nysdot.StrategyT310Test;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class T310TestContext implements Serializable {

    private T310TestStrategy pStrategy;

    public T310TestContext(eT310Test stg) {
        switch (stg) {
            case AtserT310Tpl: {
                pStrategy = null;
                break;
            }
            case NysDOTT310Tpl: {
                pStrategy = new StrategyT310Test();
                break;
            }
        }
    }

    public T310TestStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
