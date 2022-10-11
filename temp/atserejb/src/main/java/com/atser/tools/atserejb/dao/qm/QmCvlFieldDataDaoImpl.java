/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QmCvlField;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QmCvlFieldDataDaoImpl extends GenericDao<BigDecimal, QmCvlFieldData> implements QmCvlFieldDataDao {

    @Override
    public QmCvlField getQmCvlFieldParent(BigInteger clientId, String sectionName, String fieldCode) {
         String query = "SELECT t.* FROM qm_cvl_field t WHERE t.section_id = (SELECT ID FROM qm_cvl_section WHERE client_id = :clientId AND active = 'Y' AND section_name = :sectionName) AND t.field_code = :fieldCode";
        Query q = getEntityManager().createNativeQuery(query, QmCvlField.class)
                .setParameter("clientId", clientId)
                .setParameter("fieldCode", fieldCode)
                .setParameter("sectionName", sectionName);
        try {
            return (QmCvlField) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
