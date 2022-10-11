/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobNotfUser;
import com.atser.tools.atserejb.model.GlobNotfUserModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobNotfUserDaoImpl extends GenericDao<BigDecimal, GlobNotfUser> implements GlobNotfUserDao {

    @Override
    public GlobNotfUser findByUserName(String username) {
        try {
            GlobNotfUser elem = (GlobNotfUser) getEntityManager()
                    .createNamedQuery("GlobNotfUser.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            return elem;
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobNotfUserModel> findAllUserModelInPendingStatus(String module, String functionality, BigInteger clientId, BigInteger userId) {
        String query = "SELECT * FROM glob_notf_user_model c WHERE c.client_id = :clientId AND c.user_id = :userId AND c.status = 'PENDING' AND c.ntf_type = 'EMAIL' AND c.module = :module AND c.functionality = :functionality";
        Query q = getEntityManager().createNativeQuery(query, GlobNotfUserModel.class)
                .setParameter("userId", userId)
                .setParameter("clientId", clientId)
                .setParameter("module", module)
                .setParameter("functionality", functionality);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public void updateUserModelStatus(String module, String functionality, BigInteger clientId, BigInteger userId) {

        String query = "UPDATE glob_notf_user_model SET status = 'DONE' WHERE client_id = :clientId AND user_id = :userId AND status = 'PENDING' AND ntf_type = 'EMAIL' AND module = :module AND functionality = :functionality";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("userId", userId)
                .setParameter("clientId", clientId)
                .setParameter("module", module)
                .setParameter("functionality", functionality);
        try {
            q.executeUpdate();
        } catch (Exception ex) {
            log.error("Module : '%s' --> Functionality: '%s' ---> ClientId: '%s' ----> User Id: '%s' ",module ,functionality,clientId, userId);
        }

    }

}
