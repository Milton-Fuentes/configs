/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmBiditItemMaster;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class CmBiditItemMasterDaoImpl extends GenericDao<BigDecimal, CmBiditItemMaster> implements CmBiditItemMasterDao {

    @Override
    public Boolean hasChilds(BigInteger parentId) {
        String query = "SELECT COUNT(id) FROM CM_BIDIT_ITEM_MASTER WHERE parent_id = :parentId AND deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("parentId", parentId);
        try {
            Integer total = Integer.valueOf(q.getSingleResult().toString());
            if (total > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public void deleteChilds(BigInteger parentId) {
        String query = "UPDATE CmBiditItemMaster t SET t.deleted = 'Y' WHERE t.parentId = :parentId AND t.deleted = 'N'";
        Query q = getEntityManager().createQuery(query)
                .setParameter("parentId", parentId);
        q.executeUpdate();
    }

    @Override
    public void disableChilds(BigInteger parentId) {
        String query = "UPDATE CmBiditItemMaster t SET t.active = 'N' WHERE t.parentId = :parentId AND t.deleted = 'N'";
        Query q = getEntityManager().createQuery(query)
                .setParameter("parentId", parentId);
        q.executeUpdate();
    }

    @Override
    public void setParent(BigInteger id) {
        //String query = "UPDATE CM_BIDIT_ITEM_MASTER SET isparent = :isparent WHERE id = :id AND deleted = 'N'";
        String query = "UPDATE CmBiditItemMaster e SET e.isParent = (SELECT CASE COUNT(*) WHEN 0 THEN 'N' ELSE 'Y' END AS isparent FROM CmBiditItemMaster t WHERE t.parentId = :id AND t.deleted = 'N') WHERE e.id = :id AND e.deleted = 'N'";
        Query q = getEntityManager().createQuery(query)
                .setParameter("id", id);
        q.executeUpdate();
    }
}
