/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasoilDensityout;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QasoilDensityoutDaoImpl extends GenericDao<BigDecimal, QasoilDensityout> implements QasoilDensityoutDao {

    @Override
    public QasoilDensityout findByTestIdAndNo(BigInteger testId, String no) {
        Query query = getEntityManager().createNamedQuery("QasoilDensityout.findByTestIdAndNo")
                .setParameter("testId", testId)
                .setParameter("testNo", no);
        try {
            return (QasoilDensityout) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }    
}
