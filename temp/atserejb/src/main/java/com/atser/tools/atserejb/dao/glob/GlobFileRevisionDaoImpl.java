/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFileRevision;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class GlobFileRevisionDaoImpl extends GenericDao<BigDecimal, GlobFileRevision> implements GlobFileRevisionDao {

    @Override
    public void lockFile(BigDecimal revisionId, BigDecimal userId) {
        getEntityManager().createNativeQuery("UPDATE GLOB_FILE_REVISION SET CHECKOUT_ID = :uId, CHECKOUT_TIME = SYSDATE WHERE ID = :rId")
                .setParameter("rId", revisionId)
                .setParameter("uId", userId)
                .executeUpdate();
    }

    @Override
    public void unlockFile(BigDecimal revisionId) {
        String query = "UPDATE GLOB_FILE_REVISION SET CHECKOUT_ID = 0 WHERE CHECKOUT_ID <> 0";
        Query q;
        if (revisionId == null) {
            query += " AND (SELECT (SYSDATE - CHECKOUT_TIME) * 24 * 60 FROM DUAL) >= 2";
            q = getEntityManager().createNativeQuery(query);
        } else {
            query += " AND ID = :rId";
            q = getEntityManager().createNativeQuery(query).setParameter("rId", revisionId);
        }
        q.executeUpdate();
    }

    @Override
    public Boolean isFileLocked(BigDecimal revisionId, BigDecimal userId) {
        Query q = getEntityManager().createNativeQuery("SELECT CHECKOUT_ID FROM GLOB_FILE_REVISION WHERE ID = :rId");
        q.setParameter("rId", revisionId);
        BigDecimal checkoutId = (BigDecimal) q.getSingleResult();

        if (checkoutId == null || checkoutId == BigDecimal.ZERO || checkoutId.equals(userId)) {
            return false;
        } else {
            return true;
        }
    }
}
