/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasteelWeldList;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QasteelWeldListDaoImpl extends GenericDao<BigDecimal, QasteelWeldList> implements QasteelWeldListDao {

    @Override
    public QasteelWeldList findByTestId(BigInteger sampletestId) {
        Query query = getEntityManager()
                .createNamedQuery("QasteelWeldList.findBySampletestId")
                .setParameter("sampletestId", sampletestId);
        try {
            return (QasteelWeldList) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
