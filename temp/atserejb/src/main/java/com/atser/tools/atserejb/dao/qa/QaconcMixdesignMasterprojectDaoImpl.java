/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaconcMixdesignMasterproject;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaconcMixdesignMasterprojectDaoImpl extends GenericDao<BigDecimal, QaconcMixdesignMasterproject> implements QaconcMixdesignMasterprojectDao {

    @Override
    public Boolean existsRelationshipWithProject(BigInteger mixdesignId, BigInteger projectId) {
        String query = "SELECT t.id FROM QACONC_MIXDESIGN_MASTERPROJECT t WHERE t.project_id = :projectId AND t.mixdesign_id = :mixdesignId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId).setParameter("mixdesignId", mixdesignId);
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
