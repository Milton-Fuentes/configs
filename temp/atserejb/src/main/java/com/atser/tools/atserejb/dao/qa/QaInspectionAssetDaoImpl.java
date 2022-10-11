/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaInspectionAsset;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaInspectionAssetDaoImpl extends GenericDao<BigDecimal, QaInspectionAsset> implements QaInspectionAssetDao {

    @Override
    public Boolean exists(BigInteger inspectionId, String assetNo) {
        String query = "SELECT t.id FROM QA_INSPECTION_ASSET t WHERE UPPER(t.ASSET_NO) = UPPER(:assetNo) AND t.INSPECTION_ID = :inspectionId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("assetNo", assetNo).setParameter("inspectionId", inspectionId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

}
