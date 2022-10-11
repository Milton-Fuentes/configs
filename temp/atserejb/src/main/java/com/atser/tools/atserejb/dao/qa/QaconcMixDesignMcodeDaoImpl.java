/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaconcMixDesignMcode;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaconcMixDesignMcodeDaoImpl extends GenericDao<BigDecimal, QaconcMixDesignMcode> implements QaconcMixDesignMcodeDao {

    @Override
    public Boolean exists(BigInteger mixId, BigInteger materialId) {
        String query = "SELECT t.id FROM QACONC_MIXDESIGN_MCODE t WHERE t.MIX_ID = :mixId AND t.MATERIAL_ID = :materialId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("mixId", mixId).setParameter("materialId", materialId);
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
