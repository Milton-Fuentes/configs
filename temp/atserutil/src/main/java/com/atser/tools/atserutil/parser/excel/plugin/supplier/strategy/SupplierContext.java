/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.supplier.strategy;

import com.atser.tools.atserutil.enumerator.parser.eTemplateSupplier;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class SupplierContext implements Serializable {

    private SupplierStrategy pStrategy;

    public SupplierContext(eTemplateSupplier stg) {
        if (stg.equals(eTemplateSupplier.NysDOTSupplierTpl)) {
            pStrategy = new StrategyNysDOTSupplier();
        }
    }

    public SupplierStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
