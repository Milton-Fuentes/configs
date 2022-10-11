/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.VwBpmRfiAll;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class VwBpmRfiAllDaoImpl extends GenericDao<BigDecimal, VwBpmRfiAll> implements VwBpmRfiAllDao {

    @Override
    public BigDecimal getTotalOverdue(BigDecimal clientId, BigDecimal projectId, Integer fromOverdueDays, Integer toOverdueDays) {
        String query = "select count(persistenceid) from vw_bpm_rfi_all where clientid = :clientId and projectid = :projectId and status <> 'Closed' ";
        if (fromOverdueDays != null) {
            query += "and trunc(TO_DATE(RESPONSE_DUE_DATE, 'MM-DD-YYYY'))-trunc(CREATED) >= :fromOverdueDays ";
        }
        if (toOverdueDays != null) {
            query += "and trunc(TO_DATE(RESPONSE_DUE_DATE, 'MM-DD-YYYY'))-trunc(CREATED) <= :toOverdueDays";
        }
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("projectId", projectId);
        if (fromOverdueDays != null) {
            q.setParameter("fromOverdueDays", fromOverdueDays);
        }
        if (toOverdueDays != null) {
            q.setParameter("toOverdueDays", toOverdueDays);
        }
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
