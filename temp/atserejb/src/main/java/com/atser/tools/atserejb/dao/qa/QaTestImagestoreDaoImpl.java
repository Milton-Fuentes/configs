/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTestImagestore;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaTestImagestoreDaoImpl extends GenericDao<BigDecimal, QaTestImagestore> implements QaTestImagestoreDao {

    @Override
    public List<QaTestImagestore> getImageListByWoId(BigInteger woId) {
        String query = "SELECT img.*  FROM glob_dispatchcall_log dp "
                + "INNER JOIN glob_workorder wo ON (dp.wo_id = wo.id) "
                + "INNER JOIN qa_sample_test st ON (st.workorder_id = wo.id) "
                + "INNER JOIN qa_test_imagestore img ON (img.sampletest_id = st.id) "
                + "WHERE img.deleted = 'N' AND img.active = 'Y' AND st.active = 'Y' AND wo.id = :woId";
        Query q = getEntityManager().createNativeQuery(query, QaTestImagestore.class).setParameter("woId", woId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
