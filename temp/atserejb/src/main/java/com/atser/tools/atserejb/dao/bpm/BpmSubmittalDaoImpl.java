/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmsubmittalbo;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmSubmittalDaoImpl extends GenericDao<BigDecimal, Bpmsubmittalbo> implements BpmSubmittalDao {

    @Override
    public Bpmsubmittalbo findByFolderId(BigInteger id) {
        try {
            Bpmsubmittalbo elem = (Bpmsubmittalbo) getEntityManager()
                    .createNamedQuery("Bpmsubmittalbo.findByFolderId")
                    .setParameter("folderId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmsubmittalbo elem = (Bpmsubmittalbo) getEntityManager()
                .createNamedQuery("Bpmsubmittalbo.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
