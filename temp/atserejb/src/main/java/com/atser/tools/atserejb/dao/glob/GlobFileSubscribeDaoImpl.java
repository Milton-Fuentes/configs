/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFileSubscribe;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFileSubscribeDaoImpl extends GenericDao<BigDecimal, GlobFileSubscribe> implements GlobFileSubscribeDao {

    @Override
    public Boolean exists(BigInteger fileId, BigInteger subscriberId) {
        String query = "SELECT F.ID FROM GLOB_FILE_SUBSCRIBE F WHERE F.FILE_ID = :fId AND F.SUBSCRIBER_ID = :sId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("fId", fileId)
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
    public void delete(BigInteger fileId, BigInteger subscriberId) {
        getEntityManager().createNativeQuery("DELETE FROM GLOB_FILE_SUBSCRIBE WHERE FILE_ID = :fId AND SUBSCRIBER_ID = :sId")
                .setParameter("fId", fileId)
                .setParameter("sId", subscriberId).executeUpdate();
    }

    @Override
    public List<String> listSubscribersEmailByFileId(BigInteger fileId) {
        return getEntityManager().createNativeQuery("select c.email from glob_file_subscribe fs "
                + "inner join glob_users u on fs.subscriber_id = u.id "
                + "inner join glob_contact c on u.contactid = c.id "
                + "where fs.file_id = :fId").setParameter("fId", fileId).getResultList();
    }

    @Override
    public List<String> listSubscribersEmailByFileIds(List<BigInteger> fileIds) {
        return getEntityManager().createNativeQuery("select distinct c.email from glob_file_subscribe fs "
                + "inner join glob_users u on fs.subscriber_id = u.id "
                + "inner join glob_contact c on u.contactid = c.id "
                + "where fs.file_id in :fIds").setParameter("fIds", fileIds).getResultList();
    }

}
