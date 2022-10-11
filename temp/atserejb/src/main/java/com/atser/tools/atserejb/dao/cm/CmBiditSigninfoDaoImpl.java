/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author mdelabat
 */
@Stateless
public class CmBiditSigninfoDaoImpl extends GenericDao<BigDecimal, CmBiditSigninfo> implements CmBiditSigninfoDao {

    @Override
    public Boolean isSignedOff(BigInteger clientId, BigInteger refId, BigInteger typeId) {
        String query = "SELECT (SELECT COUNT(*) FROM cm_bidit_signinfo qsi INNER JOIN glob_system_simple_cat gsct ON (qsi.type_id = gsct.id) WHERE qsi.ref_id = :entityId AND gsct.id = :typeId AND gsct.client_id = :clientId AND qsi.client_id = :clientId) AS sign_total,"
                + "(SELECT COUNT(*) FROM cm_bidit_signinfo qsi INNER JOIN glob_system_simple_cat gsct ON (qsi.type_id = gsct.id) WHERE qsi.ref_id = :entityId AND gsct.id = :typeId AND gsct.client_id = :clientId AND qsi.client_id = :clientId AND qsi.signed = 'Y') AS final_sign_total FROM dual";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("entityId", refId)
                .setParameter("clientId", clientId)
                .setParameter("typeId", typeId);
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
