/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmrfibo;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmRFIDaoImpl extends GenericDao<BigDecimal, Bpmrfibo> implements BpmRFIDao {

    @Override
    public Bpmrfibo findByFolderId(BigInteger id) {
        try {
            Bpmrfibo elem = (Bpmrfibo) getEntityManager()
                    .createNamedQuery("Bpmrfibo.findByFolderId")
                    .setParameter("folderId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmrfibo elem = (Bpmrfibo) getEntityManager()
                .createNamedQuery("Bpmrfibo.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
