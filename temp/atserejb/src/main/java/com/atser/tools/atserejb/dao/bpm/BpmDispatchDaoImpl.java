/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmdispatchbo;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmDispatchDaoImpl extends GenericDao<BigDecimal, Bpmdispatchbo> implements BpmDispatchDao {

    
    @Override
    public Bpmdispatchbo findByFolderId(BigInteger id) {
        try {
            Bpmdispatchbo elem = (Bpmdispatchbo) getEntityManager()
                    .createNamedQuery("Bpmdispatchbo.findByFolderId")
                    .setParameter("folderId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
    public void delete(BigDecimal id) {
        Bpmdispatchbo elem = (Bpmdispatchbo) getEntityManager()
                .createNamedQuery("Bpmdispatchbo.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
