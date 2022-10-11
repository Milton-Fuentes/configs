/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmsubmittalmetadata;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class BpmSubmittalMetaDataDaoImpl extends GenericDao<BigDecimal, Bpmsubmittalmetadata> implements BpmSubmittalMetaDataDao {

    @Override
    public Bpmsubmittalmetadata findByRfiId(BigDecimal id) {
        return (Bpmsubmittalmetadata) getEntityManager().createNativeQuery("SELECT * FROM BPMSUBMITTALMETADATA md "
                + "INNER JOIN BPMSUBMITTALBO subm ON subm.DC_DATA_PID = md.PERSISTENCEID "
                + "WHERE subm.PERSISTENCEID = :id", Bpmsubmittalmetadata.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmsubmittalmetadata elem = (Bpmsubmittalmetadata) getEntityManager()
                .createNamedQuery("Bpmsubmittalmetadata.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
