/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasoilDensity;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QasoilDensityDaoImpl extends GenericDao<BigDecimal, QasoilDensity> implements QasoilDensityDao {

    @Override
    public QasoilDensity findBySampleTestId(BigInteger sampleTestId) {
        Query q = getEntityManager().createNamedQuery("QasoilDensity.findBySampletestId")
                .setParameter("sampletestId", sampleTestId);
        try {
            return (QasoilDensity) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
