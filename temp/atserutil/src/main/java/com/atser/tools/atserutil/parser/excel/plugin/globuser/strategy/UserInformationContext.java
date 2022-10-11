/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.globuser.strategy;

import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import java.io.Serializable;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public class UserInformationContext implements Serializable {

    private UserInformationStrategy pStrategy;

    public UserInformationContext(eUserInformation stg) {
        switch(stg) {
            case AtserUserInformationTpl: {
                pStrategy = new StrategyAtserUserInformation();
                break;
            }
            case MassDOTUserInformationTpl: {
                pStrategy = new StrategyMassDOTUserInformation();
                break;
            }
        }
    }

    public UserInformationStrategy getpStrategy(Sheet page) {
        pStrategy.setPage(page);
        return pStrategy;
    }
}
