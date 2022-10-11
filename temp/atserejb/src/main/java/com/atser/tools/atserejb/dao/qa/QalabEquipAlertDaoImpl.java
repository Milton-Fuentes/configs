/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QalabEquipAlert;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QalabEquipAlertDaoImpl extends GenericDao<BigDecimal, QalabEquipAlert> implements QalabEquipAlertDao {

    @Override
    public Boolean exists(BigInteger clientId, String alertType) {
        String query = "SELECT t.id FROM QALAB_EQUIP_ALERT t WHERE UPPER(t.ALERT_TYPE) = UPPER(:alertType) AND t.CLIENT_ID = :clientId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("alertType", alertType).setParameter("clientId", clientId);
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
