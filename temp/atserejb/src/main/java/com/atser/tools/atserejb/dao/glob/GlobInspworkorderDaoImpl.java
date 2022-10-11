/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobInspworkorder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobInspworkorderDaoImpl extends GenericDao<BigDecimal, GlobInspworkorder> implements GlobInspworkorderDao {

    @Override
    public GlobInspworkorder findByWoToken(String tk) {
        if (tk == null || tk.isEmpty()) {
            return null;
        }
        try {
            GlobInspworkorder elem = (GlobInspworkorder) getEntityManager()
                    .createNamedQuery("GlobInspworkorder.findByWotoken")
                    .setParameter("wotoken", tk)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobInspworkorder> findByInspDispatchID(BigDecimal id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobInspworkorder> array = getEntityManager().createNamedQuery("GlobInspworkorder.findByInspDispatchID")
                    .setParameter("id", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobInspworkorder> findByProjectID(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobInspworkorder> array = getEntityManager().createNamedQuery("GlobInspworkorder.findByProjectIDAndNotCancelled")
                    .setParameter("projectId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getNextWorkOrderNumber(BigInteger projectId) {
        NumberFormat formatter = new DecimalFormat("I#000");
        String query = "SELECT MAX(TO_NUMBER(regexp_substr(WONUMBER, '[^I]+', 1, 1), '9999.99')) MaxWON FROM GLOB_INSPWORKORDER t WHERE t.PROJECT_ID = :projectId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("projectId", projectId);
        BigDecimal maxwon = (BigDecimal) q.getSingleResult();
        BigInteger result = (maxwon == null) ? BigInteger.ZERO : maxwon.toBigInteger();
        result = result.add(BigInteger.ONE);
        return formatter.format(result);
    }

    @Override
    public List<String> getListActivityNo(BigInteger projectId) {
        List<String> list = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Object> objs = getEntityManager().createNamedQuery("GlobInspworkorder.getDistinctByActivityId")
                .setParameter("projectId", projectId)
                .getResultList();
        objs.forEach((obj) -> {
            list.add(obj.toString());
        });
        return list;
    }

}
