/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.exception.ConstraintViolationException;
import javax.ws.rs.core.Response;

@Stateless
public class GlobUserDaoImpl extends GenericDao<BigDecimal, GlobUsers> implements GlobUserDao, IBaseEJBException {

    @Override
    public GlobUsers save(GlobUsers entity) {
        try {
            return super.save(entity);
        } catch (Exception ex) {
            Throwable t = ex.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                throwBaseException(Response.Status.CONFLICT, "User already exists.");
            }
            throwBaseException(Response.Status.BAD_REQUEST, "Bad request.");
        }
        return null;
    }

    @Override
    public Boolean existByUserName(String username) {
        String query = "SELECT t.id FROM glob_users t WHERE upper(userid)=upper(:userId)";
        Query q = getEntityManager().createNativeQuery(query).setParameter("userId", username);
        try {
            return (q.getResultList() != null && !q.getResultList().isEmpty());
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    /**
     * Find SSO
     *
     * @param username
     * @param passwd
     * @return
     */
    @Override
    public GlobUsers findBySSO(String username, String passwd) {
        // Fix this for massdot (remove the upper) 
        String query = "SELECT t.* FROM GLOB_USERS t WHERE userid=:userId AND pass=(SELECT ltrim( to_char( dbms_utility.get_hash_value( upper(:userId)||'/'||upper(:passwd), 1000000000, power(2,30) ), rpad( 'X',29,'X')||'X' ) ) FROM DUAL) AND active='Y'";
        Query q = getEntityManager().createNativeQuery(query, GlobUsers.class).setParameter("userId", username).setParameter("passwd", passwd);
        try {
            return (GlobUsers) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void unlockUserAccounts() {
        String query = "UPDATE glob_users SET locked = 'N', locked_time = null, bad_auth_attempts = 0 WHERE locked = 'Y' AND (SELECT (SYSDATE - locked_time) * 24 * 60 FROM DUAL) >= 30";
        Query q = getEntityManager().createNativeQuery(query);
        q.executeUpdate();
    }

    @Override
    public GlobUsers findByPersonInfoId(BigDecimal piId) {
        // Fix this for massdot (remove the upper) 
        String query = "SELECT u.* FROM GLOB_USERS u WHERE personinfo_id = :piId";
        Query q = getEntityManager().createNativeQuery(query, GlobUsers.class).setParameter("piId", piId);
        try {
            return (GlobUsers) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getUserEmail(BigDecimal userId) {
        // Fix this for massdot (remove the upper) 
        String query = "SELECT C.EMAIL FROM GLOB_USERS U INNER JOIN GLOB_CONTACT C ON U.CONTACTID = C.ID AND U.ID = :uId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("uId", userId);
        try {
            return q.getSingleResult().toString();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
