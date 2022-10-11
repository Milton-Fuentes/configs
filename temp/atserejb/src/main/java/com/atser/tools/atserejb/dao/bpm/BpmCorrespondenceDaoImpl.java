/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmcorrespondencebo;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmCorrespondenceDaoImpl extends GenericDao<BigDecimal, Bpmcorrespondencebo> implements BpmCorrespondenceDao {

    @Override
    public Bpmcorrespondencebo findByFolderId(BigInteger id) {
        try {
            Bpmcorrespondencebo elem = (Bpmcorrespondencebo) getEntityManager()
                    .createNamedQuery("Bpmcorrespondencebo.findByFolderId")
                    .setParameter("folderId", id)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmcorrespondencebo elem = (Bpmcorrespondencebo) getEntityManager()
                .createNamedQuery("Bpmcorrespondencebo.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
