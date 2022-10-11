/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobUsersApproval;
import java.math.BigDecimal;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobUsersApprovalDaoImpl extends GenericDao<BigDecimal, GlobUsersApproval> implements GlobUsersApprovalDao {

    @Inject
    private GlobContactDao globContactDao;

    @Inject
    private GlobUserDao globUserDao;

    @Override
    public Boolean existsGlobalByUsername(String username) {
        String query = "SELECT t.id FROM GLOB_USERS_APPROVAL t WHERE t.USERNAME = :username AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("username", username);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return globUserDao.existByUserName(username);
        } catch (NoResultException ex) {
            return globUserDao.existByUserName(username);
        }
    }

    @Override
    public Boolean existsGlobalByEmail(String email) {
        String query = "SELECT t.id FROM GLOB_USERS_APPROVAL t WHERE t.EMAIL = :email AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("email", email);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return globContactDao.existByEmail(email);
        } catch (NoResultException ex) {
            return globContactDao.existByEmail(email);
        }
    }

    @Override
    public Optional<GlobUsersApproval> findByUsername(String username) {
        Query q = getEntityManager().createNamedQuery("GlobUsersApproval.findByUsername")
                .setParameter("username", username);
        try {
            return Optional.ofNullable((GlobUsersApproval) q.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
