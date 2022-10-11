/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaInspectionSpecimen;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaInspectionSpecimenDaoImpl extends GenericDao<BigDecimal, QaInspectionSpecimen> implements QaInspectionSpecimenDao {

    @Override
    public Boolean exists(BigInteger inspectionId, String specNo) {
        String query = "SELECT t.id FROM QA_INSPECTION_SPECIMEN t WHERE UPPER(t.SPEC_NO) = UPPER(:specNo) AND t.INSPECTION_ID = :inspectionId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("specNo", specNo).setParameter("inspectionId", inspectionId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public String getNextSequenceNo(BigInteger inspectionId) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as icn FROM qa_inspection_specimen WHERE inspection_id = :inspectionId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("inspectionId", inspectionId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? StringSupport.getString(result) : "1";
        } catch (NoResultException ex) {
            return "1";
        }
    }
    
}
