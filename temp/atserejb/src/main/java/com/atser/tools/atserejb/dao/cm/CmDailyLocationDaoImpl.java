/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmDailyLocation;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class CmDailyLocationDaoImpl extends GenericDao<BigDecimal, CmDailyLocation> implements CmDailyLocationDao {

    @Override
    public String getDailyLocation(String locationId) {
        if (StringSupport.isNotNullAndNotEmpty(locationId) && !locationId.equals("-1")) {
            CmDailyLocation cmLocation = findById(NumberSupport.getBigDecimal(locationId));
            if (cmLocation != null) {
                return cmLocation.getLocation();
            }
        }
        return "N/A";
    }

}
