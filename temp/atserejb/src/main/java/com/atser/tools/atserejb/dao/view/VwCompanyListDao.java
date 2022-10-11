/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.IViewDao;
import com.atser.tools.atserejb.model.VwCompanyList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface VwCompanyListDao extends IViewDao<BigDecimal, VwCompanyList> {

    List<String> listNamesByClient(BigInteger clientId);

}
