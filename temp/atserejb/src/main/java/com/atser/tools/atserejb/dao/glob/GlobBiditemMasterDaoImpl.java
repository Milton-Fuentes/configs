/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobBiditemMaster;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobBiditemMasterDaoImpl extends GenericDao<BigDecimal, GlobBiditemMaster> implements GlobBiditemMasterDao {

    @Override
    public BigDecimal findItemId(BigDecimal clientId, String itemNo, BigDecimal projectId) {
        String query = "SELECT ID FROM glob_biditem_master WHERE client_id = :clientId AND item_no = :itemNo AND active = 'Y' AND ( spec_pid = 0 OR spec_pid = :projectId )";
        log.error("com.atser.tools.atserejb.dao.glob.GlobBiditemMasterDaoImpl.findItemId() clientId: " +clientId + "itemNo: " + itemNo + "projectId :" +projectId);
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("itemNo", itemNo).setParameter("projectId", projectId);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            log.error("NonUniqueResultException @Batch GlobBiditemMasterDaoImpl-findItemId Duplicate: " + clientId + "-" + itemNo + "-" + projectId);
            return BigDecimal.ZERO;
        } catch (Exception ex) {
            log.error(" Exception @Batch GlobBiditemMasterDaoImpl-findItemId EX: " + clientId + "-" + itemNo + "-" + projectId);
            //ex.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

}
