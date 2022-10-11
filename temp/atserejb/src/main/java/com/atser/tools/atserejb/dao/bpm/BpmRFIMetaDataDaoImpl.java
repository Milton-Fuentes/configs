/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmrfimetadata;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class BpmRFIMetaDataDaoImpl extends GenericDao<BigDecimal, Bpmrfimetadata> implements BpmRFIMetaDataDao {

    @Override
    public Bpmrfimetadata findByRfiId(BigDecimal id) {
        return (Bpmrfimetadata) getEntityManager().createNativeQuery("SELECT * FROM BPMRFIMETADATA md "
                + "INNER JOIN BPMRFIBO rfi ON rfi.DC_DATA_PID = md.PERSISTENCEID "
                + "WHERE rfi.PERSISTENCEID = :id", Bpmrfimetadata.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmrfimetadata elem = (Bpmrfimetadata) getEntityManager()
                .createNamedQuery("Bpmrfimetadata.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
