/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QalabEquipinfoProjectV2;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QalabEquipinfoProjectV2DaoImpl extends GenericDao<BigDecimal, QalabEquipinfoProjectV2> implements QalabEquipinfoProjectV2Dao {

    @Override
    public Boolean exists(BigInteger equipId, BigInteger projectId) {
        String query = "SELECT t.id FROM QALAB_EQUIPINFO_PROJECT t WHERE t.equip_id = :equipId and t.project_id = :projectId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("equipId", equipId)
                .setParameter("projectId", projectId);
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
