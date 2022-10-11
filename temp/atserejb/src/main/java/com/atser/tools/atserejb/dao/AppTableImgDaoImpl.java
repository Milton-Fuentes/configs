/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.AppTableImg;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class AppTableImgDaoImpl extends GenericDao<BigDecimal, AppTableImg> implements AppTableImgDao {

    @Override
    public Boolean exists(String email) {
         String query = "SELECT t.id FROM APP_TABLE_IMG t WHERE t.email = :email AND t.deleted = 'N' AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("email", email);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
}
