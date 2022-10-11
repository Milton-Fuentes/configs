/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobCustomConfigUser;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobCustomConfigUserDaoImpl extends GenericDao<BigDecimal, GlobCustomConfigUser> implements GlobCustomConfigUserDao {

    @Override
    public Boolean exists(BigInteger configId, BigInteger userId) {
        String query = "SELECT t.id FROM GLOB_CUSTOM_CONFIG_USER t WHERE t.deleted = 'N' AND t.config_id = :configId AND t.user_id = :userId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("configId", configId)
                .setParameter("userId", userId);
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
