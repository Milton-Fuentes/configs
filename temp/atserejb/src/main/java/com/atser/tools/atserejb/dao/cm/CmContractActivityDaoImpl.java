/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmContractActivity;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class CmContractActivityDaoImpl extends GenericDao<BigDecimal, CmContractActivity> implements CmContractActivityDao {

    @Override
    public String getActivityName(BigDecimal id, String format) {
        String name = "N/A";
        if (id != null && !id.equals(new BigDecimal("-1"))) {
            CmContractActivity object = findById(id);
            if (object != null) {
                switch (format) {
                    case "nd": {
                        name = object.getActvNo() + " " + object.getActvDescript();
                        break;
                    }
                    case "nf": {
                        name = object.getActvNo() + " " + object.getActivityFullName();
                        break;
                    }
                    default: {
                        name = object.getActvNo();
                    }
                }
            }
        }
        return name;
    }

}
