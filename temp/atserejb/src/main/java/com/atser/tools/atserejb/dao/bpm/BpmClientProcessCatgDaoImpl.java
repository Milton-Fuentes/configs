/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.BpmClientProcessCatg;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class BpmClientProcessCatgDaoImpl extends GenericDao<BigDecimal, BpmClientProcessCatg> implements BpmClientProcessCatgDao {

    @Override
    public List<BpmClientProcessCatg> getProcessByFunctionality(BigInteger functionalityId) {
        String query = "SELECT bcp.* FROM bpm_funct_process t INNER JOIN bpm_client_process_catg bcp ON (t.process_catg_id = bcp.id) WHERE t.funct_id = :functId ORDER BY bcp.cat_order";
        Query q = getEntityManager().createNativeQuery(query, BpmClientProcessCatg.class).setParameter("functId", functionalityId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
}
