/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaPlist;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaPlistDaoImpl extends GenericDao<BigDecimal, QaPlist> implements QaPlistDao {

    @Override
    public String getNextItemNo(BigInteger projectId) {
        String query = "SELECT NVL(MAX(to_number(item_no)),0)+1 as item_no FROM qa_plist WHERE project_id=:projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? result.toString() : "1";
        } catch (NoResultException ex) {
            return "1";
        }
    }

}
