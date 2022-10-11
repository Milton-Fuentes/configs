/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpminspectordispatchbo;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmInspectorDispatchDaoImpl extends GenericDao<BigDecimal, Bpminspectordispatchbo> implements BpmInspectorDispatchDao {

    @Override
    public Bpminspectordispatchbo findByFolderId(BigInteger id) {
        try {
            Bpminspectordispatchbo elem = (Bpminspectordispatchbo) getEntityManager()
                    .createNamedQuery("Bpminspectordispatchbo.findByFolderId")
                    .setParameter("folderId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
    public void delete(BigDecimal id) {
        Bpminspectordispatchbo elem = (Bpminspectordispatchbo) getEntityManager()
                .createNamedQuery("Bpminspectordispatchbo.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
