/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.bpm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.Bpmcorrespondencemetadata;
import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class BpmCorrespondenceMetaDataDaoImpl extends GenericDao<BigDecimal, Bpmcorrespondencemetadata> implements BpmCorrespondenceMetaDataDao {

    @Override
    public Bpmcorrespondencemetadata findByCorrespondnceId(BigDecimal id) {
        return (Bpmcorrespondencemetadata) getEntityManager().createNativeQuery("SELECT * FROM BPMCORRESPONDENCEMETADATA md "
                + "INNER JOIN BPMCORRESPONDENCEBO cor ON cor.DC_DATA_PID = md.PERSISTENCEID "
                + "WHERE cor.PERSISTENCEID = :id", Bpmcorrespondencemetadata.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void delete(BigDecimal id) {
        Bpmcorrespondencemetadata elem = (Bpmcorrespondencemetadata) getEntityManager()
                .createNamedQuery("Bpmcorrespondencemetadata.findByPersistenceid")
                .setParameter("persistenceid", id)
                .getSingleResult();
        delete(elem);
    }
}
