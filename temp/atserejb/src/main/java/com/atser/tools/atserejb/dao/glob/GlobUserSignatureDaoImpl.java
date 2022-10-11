/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobUserSignature;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class GlobUserSignatureDaoImpl extends GenericDao<BigDecimal, GlobUserSignature> implements GlobUserSignatureDao {

    @Override
    public GlobUserSignature findByUserId(BigInteger id) {
        GlobUserSignature elem = null;
        try {
            elem = (GlobUserSignature) getEntityManager()
                    .createNamedQuery("GlobUserSignature.findByUserId")
                    .setParameter("userId", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            // Logic OK, result Empty
        }
        return elem;
    }
}
