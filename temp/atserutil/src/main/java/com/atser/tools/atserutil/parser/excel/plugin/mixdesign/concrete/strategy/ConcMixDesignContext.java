/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.strategy;

import com.atser.tools.atserutil.enumerator.parser.eConcMixDesign;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.strategy.nysdot.StrategyNysDOTImportConcMixDesign;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class ConcMixDesignContext implements Serializable {

    private ConcMixDesignStrategy pStrategy;

    public ConcMixDesignContext(eConcMixDesign stg) {
        switch (stg) {
            case AtserConcMixDesignTpl: {
                pStrategy = new StrategyAtserConcMixDesign();
                break;
            }
            case NysDOTImportConcMixDesignTpl: {
                pStrategy = new StrategyNysDOTImportConcMixDesign();
                break;
            }
        }
    }

    public ConcMixDesignStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
