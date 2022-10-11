/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.strategy;

import com.atser.tools.atserutil.enumerator.parser.eAspmMixDesign;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class AspmMixDesignContext implements Serializable {

    private AspmMixDesignStrategy pStrategy;

    public AspmMixDesignContext(eAspmMixDesign stg) {
        if (stg.equals(eAspmMixDesign.AtserAspmMixDesignTpl)) {
            pStrategy = new StrategyAtserAspmMixDesign();
        }
    }

    public AspmMixDesignStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
