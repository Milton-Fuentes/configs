/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTestMethods;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaTestMethodsBO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaTestMethodsDaoImpl extends GenericDao<BigDecimal, QaTestMethods> implements QaTestMethodsDao {

    @Override
    public List<QaTestMethodsBO> getTestMethodsByCatg(String clientId, String catgId) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select a.id, a.name, a.catg_id, a.description, a.reference, a.jsp_page, a.test_table, case when(b.report_title is null or b.report_title='') then a.name else b.report_title end as display_name from qa_test_methods a, glob_client_test b where b.test_id = a.id and b.client_id = :clientId and a.active = 'Y' ");
        if (StringSupport.isNotNullAndNotEmpty(catgId)) {
            queryBuilder.append(" and a.catg_id = :catgId");
        }
        queryBuilder.append(" order by display_name");
        try {
            Query hquery = getEntityManager().createNativeQuery(queryBuilder.toString());
            hquery.setParameter("clientId", clientId);
            if (StringSupport.isNotNullAndNotEmpty(catgId)) {
                hquery.setParameter("catgId", catgId);
            }
            List<Object[]> objects = hquery.getResultList();
            return populateTestMethodsByCatgBo(objects);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<QaTestMethodsBO> populateTestMethodsByCatgBo(List<Object[]> objects) {
        List<QaTestMethodsBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            QaTestMethodsBO p = new QaTestMethodsBO();
            p.setId((StringSupport.isNullOrEmpty(it[0])) ? null : NumberSupport.getBigInteger(it[0]));
            p.setName(StringSupport.emptyOnNull(it[1]));
            p.setCatgId((StringSupport.isNullOrEmpty(it[2])) ? null : NumberSupport.getBigInteger(it[2]));
            p.setDescription(StringSupport.emptyOnNull(it[3]));
            p.setReference(StringSupport.emptyOnNull(it[4]));
            p.setJspPage(StringSupport.emptyOnNull(it[5]));
            p.setTestTable(StringSupport.emptyOnNull(it[6]));
            p.setDisplayName(StringSupport.emptyOnNull(it[7]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public List<QaTestMethods> getTestMethodsByCatgAndTestTable(BigInteger clientId, String catg, String testTable) {
        String query = "SELECT t.* FROM (SELECT * FROM glob_client_sample_catg WHERE client_id=:clientId) cc LEFT JOIN qa_sample_catg c ON (c.id=cc.sample_catg_id), qa_test_methods t, glob_client_test ct "
                + "WHERE c.id = t.catg_id AND t.id = ct.test_id AND ct.client_id = :clientId AND c.name = :catg AND t.test_table = :testTable";
        try {
            return getEntityManager().createNativeQuery(query, QaTestMethods.class)
                    .setParameter("clientId", clientId)
                    .setParameter("catg", catg)
                    .setParameter("testTable", testTable)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public QaTestMethods findBySampleTestId(BigInteger sampleTestId) {
        String query = "SELECT t.* FROM qa_test_methods t, qa_sample_test st WHERE st.TEST_ID= t.id and st.id= :sampleTestId ";
        Query q = getEntityManager().createNativeQuery(query, QaTestMethods.class).setParameter("sampleTestId", sampleTestId);
        try {
            if (q.getSingleResult() != null) {
                return (QaTestMethods) q.getSingleResult();
            }
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
