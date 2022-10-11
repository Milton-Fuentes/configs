/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTicket;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaTicketDaoImpl extends GenericDao<BigDecimal, QaTicket> implements QaTicketDao {

    @Override
    public String getNextDCN(BigInteger clientId, BigInteger projectId) {
        String query = "SELECT NVL(MAX(to_number(doc_controlno)),0)+1 as dcn FROM qa_ticket WHERE client_id =:clientId AND project_id=:projectId";
        NumberFormat formatter = new DecimalFormat("#000000");
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? formatter.format(result) : "000001";
        } catch (NoResultException ex) {
            return "000001";
        }
    }    
    
}
