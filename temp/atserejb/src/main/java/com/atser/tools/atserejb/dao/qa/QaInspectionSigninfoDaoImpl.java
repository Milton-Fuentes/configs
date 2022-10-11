/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaInspectionSigninfo;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaInspectionSigninfoDaoImpl extends GenericDao<BigDecimal, QaInspectionSigninfo> implements QaInspectionSigninfoDao {

    @Override
    public Boolean isInspectionSignedOff(BigInteger inspectionId) {
        String query = "SELECT (SELECT COUNT(*) FROM qa_inspection_signinfo qsi WHERE qsi.inspection_id = :inspectionId) AS sign_total,"
                + "(SELECT COUNT(*) FROM qa_inspection_signinfo qsi WHERE qsi.inspection_id = :inspectionId AND qsi.signed = 'Y') AS final_sign_total FROM dual";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("inspectionId", inspectionId);
        try {
            Object[] dto = (Object[]) q.getSingleResult();
            Integer signTotal = NumberSupport.getInteger(dto[0]);
            Integer finalSignTotal = NumberSupport.getInteger(dto[1]);
            if (signTotal == 0) {
                return Boolean.FALSE;
            }
            return (Objects.equals(signTotal, finalSignTotal));
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
}
