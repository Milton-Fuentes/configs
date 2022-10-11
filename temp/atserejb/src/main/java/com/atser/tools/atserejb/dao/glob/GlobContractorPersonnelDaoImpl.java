/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobContractorPersonnel;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobContractorPersonnelDaoImpl extends GenericDao<BigDecimal, GlobContractorPersonnel> implements GlobContractorPersonnelDao {

    @Override
    public Boolean existItem(String contractor_name, BigInteger clientId) {
        String query = "SELECT t.ID FROM GLOB_CONTRACTOR_PERSONNEL t WHERE UPPER(t.CONTRACTOR) = UPPER(:cname) AND t.CLIENT_ID = :clientId AND active='Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("cname", contractor_name).setParameter("clientId", clientId);
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
