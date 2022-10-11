/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.strategy;

import com.atser.tools.atserutil.enumerator.parser.eT22Test;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.strategy.nysdot.StrategyT22Test;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class T22TestContext implements Serializable {

    private T22TestStrategy pStrategy;

    public T22TestContext(eT22Test stg) {
        switch (stg) {
            case AtserT22Tpl: {
                pStrategy = null;
                break;
            }
            case NysDOTT22Tpl: {
                pStrategy = new StrategyT22Test();
                break;
            }
        }
    }

    public T22TestStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
