/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.AppTableImg;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface AppTableImgDao extends ICrudDao<BigDecimal, AppTableImg> {

    Boolean exists(String email);
}
