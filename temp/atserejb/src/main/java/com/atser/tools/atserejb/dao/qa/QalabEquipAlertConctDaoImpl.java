/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QalabEquipAlertConct;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QalabEquipAlertConctDaoImpl extends GenericDao<BigDecimal, QalabEquipAlertConct> implements QalabEquipAlertConctDao {

    @Override
    public Boolean exists(BigInteger alertId, BigInteger contactId) {
        String query = "SELECT t.id FROM QALAB_EQUIP_ALERT_CONCT t WHERE t.ALERT_ID = :alertId AND t.CONTACT_ID = :contactId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("alertId", alertId).setParameter("contactId", contactId);
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
