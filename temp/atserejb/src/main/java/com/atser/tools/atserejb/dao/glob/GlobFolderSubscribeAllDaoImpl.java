/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFolderSubscribeAll;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFolderSubscribeAllDaoImpl extends GenericDao<BigDecimal, GlobFolderSubscribeAll> implements GlobFolderSubscribeAllDao {

    @Override
    public Boolean exists(BigInteger folderId, BigInteger subscriberId) {
        String query = "SELECT F.ID FROM GLOB_FOLDER_SUBSCRIBE_ALL F WHERE F.FOLDER_ID = :fId AND F.SUBSCRIBER_ID = :sId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("fId", folderId)
                .setParameter("sId", subscriberId);
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
