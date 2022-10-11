/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFolderSubscribe;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFolderSubscribeDaoImpl extends GenericDao<BigDecimal, GlobFolderSubscribe> implements GlobFolderSubscribeDao {

    @Override
    public Boolean exists(BigInteger folderId, BigInteger subscriberId) {
        String query = "SELECT F.ID FROM GLOB_FOLDER_SUBSCRIBE F WHERE F.FOLDER_ID = :fId AND F.SUBSCRIBER_ID = :sId";
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

    @Override
    public void delete(BigInteger folderId, BigInteger subscriberId) {
        getEntityManager().createNativeQuery("delete from GLOB_FOLDER_SUBSCRIBE where folder_id = :fId and SUBSCRIBER_ID = :sId")
                .setParameter("fId", folderId)
                .setParameter("sId", subscriberId).executeUpdate();
    }

    public void deleteAllByParentId(BigInteger parentId, BigInteger subscriberId) {
        getEntityManager().createNativeQuery("delete from glob_folder_subscribe where subscriber_id = :sid and folder_id in ()")
                .setParameter("fId", parentId)
                .setParameter("sId", subscriberId).executeUpdate();
    }

    @Override
    public List<String> listSubscribersEmailByFolderId(BigInteger folderId) {
        return getEntityManager().createNativeQuery("select c.email from glob_folder_subscribe fs "
                + "inner join glob_users u on fs.subscriber_id = u.id "
                + "inner join glob_contact c on u.contactid = c.id "
                + "where fs.folder_id = :fId").setParameter("fId", folderId).getResultList();
    }

    @Override
    public List<String> listSubscribersEmailByFolderIds(List<BigInteger> folderIds) {
        return getEntityManager().createNativeQuery("select distinct c.email from glob_folder_subscribe fs "
                + "inner join glob_users u on fs.subscriber_id = u.id "
                + "inner join glob_contact c on u.contactid = c.id "
                + "where fs.folder_id in :fIds").setParameter("fIds", folderIds).getResultList();
    }

}
