/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.VwCompanyList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class VwCompanyListDaoImpl extends GenericDao<BigDecimal, VwCompanyList> implements VwCompanyListDao {

    @Override
    public List<String> listNamesByClient(BigInteger clientId) {
        return getEntityManager().createNativeQuery("SELECT DISTINCT FIRM NAME FROM VW_COMPANY_LIST T WHERE T.CLIENT_ID = :clientId ORDER BY FIRM")
                .setParameter("clientId", clientId)
                .getResultList();
    }
}
