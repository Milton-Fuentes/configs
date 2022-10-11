/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.BpmProcessInstance;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class BpmProcessInstanceDaoImpl extends GenericDao<BigDecimal, BpmProcessInstance> implements BpmProcessInstanceDao {

    @Override
    public BigDecimal getTotalOverdue(BigDecimal clientId, BigDecimal projectId, Integer fromOverdueDays, Integer toOverdueDays, String processCode) {
        String query = "select count(pi.id) from bpm_process_instance pi "
                + "inner join bpm_process p on pi.process_id = p.id "
                + "where pi.client_id = :clientId and pi.project_id = :projectId and p.code = :processCode and state <> 'COMPLETED'";

        if (fromOverdueDays != null) {
            query += "and (trunc(sysdate)-(trunc(pi.created)+p.required_resp_days)) >= :fromOverdueDays ";
        }
        if (toOverdueDays != null) {
            query += "and (trunc(sysdate)-(trunc(pi.created)+p.required_resp_days)) <= :toOverdueDays";
        }

        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("projectId", projectId)
                .setParameter("processCode", processCode);

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
