/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSampleCatg;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class QaSampleCatgDaoImpl extends GenericDao<BigDecimal, QaSampleCatg> implements QaSampleCatgDao {
    
    @Override
    public List<QaSampleCatg> getsampleCatgListByClientModel(String clientId) {
        String query = "select distinct c.id, c.name, case when cc.sample_catg_title is not null then cc.sample_catg_title else c.description end as description, "
                + "c.page_name from (select * from glob_client_sample_catg where client_id=:clientId) cc LEFT JOIN qa_sample_catg c ON (c.id=cc.sample_catg_id), qa_test_methods t, "
                + "glob_client_test ct WHERE c.id = t.catg_id and t.id = ct.test_id and ct.client_id = :clientId order by description";
        try {
            return getEntityManager().createNativeQuery(query, QaSampleCatg.class)
                    .setParameter("clientId", clientId)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
