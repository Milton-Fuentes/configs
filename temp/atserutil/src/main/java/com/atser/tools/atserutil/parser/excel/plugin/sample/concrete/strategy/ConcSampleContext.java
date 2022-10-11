/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.strategy;

import com.atser.tools.atserutil.enumerator.parser.eConcSample;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.strategy.nysdot.StrategyConcSample;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class ConcSampleContext implements Serializable {
    private ConcSampleStrategy pStrategy;

    public ConcSampleContext(eConcSample stg) {
        switch (stg) {
            case AtserConcSampleTpl: {
                pStrategy = null;
                break;
            }
            case NysDOTConcSampleTpl: {
                pStrategy = new StrategyConcSample();
                break;
            }
        }
    }

    public ConcSampleStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
