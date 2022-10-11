/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.WsRigths;
import com.atser.tools.atserejb.model.WsUsers;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import org.hibernate.exception.ConstraintViolationException;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class WsUsersDaoImpl extends GenericDao<BigDecimal, WsUsers> implements WsUsersDao, IBaseEJBException {

    @Override
    public WsUsers findBySSO(String username, eWsUserCategory category) {
        try {
            String query = "SELECT w.* FROM WS_USERS w WHERE w.USERNAME = :username AND w.CATEGORY = :category AND w.ACTIVE = :active AND w.DELETED = :deleted";
            Query q = getEntityManager().createNativeQuery(query, WsUsers.class)
                    .setParameter("username", username)
                    .setParameter("category", category.getValue())
                    .setParameter("active", 'Y')
                    .setParameter("deleted", 'N');
            return (WsUsers) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public WsUsers save(WsUsers entity) {
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
    public Map<String, List<WsRigths>> getMapRigths() {
        Map<String, List<WsRigths>> cache = new HashMap<>();
        List<WsUsers> array = getEntityManager().createNamedQuery("WsUsers.findAll").getResultList();
        array.forEach((wsUsers) -> {
            initializeList(wsUsers.getWsRigthsList());
            cache.put(wsUsers.getId().toString(), wsUsers.getWsRigthsList());
        });
        return cache;
    }

    @Override
    public List<WsRigths> getRigthsByUserId(BigInteger userid) {
        Query q = getEntityManager().createNativeQuery("SELECT t.* FROM WS_RIGTHS t WHERE t.USERID = :userid", WsRigths.class)
                .setParameter("userid", userid);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<WsUsers> getUserGraph(String graph) {
        EntityGraph eg = getEntityManager().getEntityGraph(graph);
        List<WsUsers> users = getEntityManager().createNamedQuery("WsUsers.findAll")
                .setHint("javax.persistence.fetchgraph", eg)
                .getResultList();
        return users;
    }
}
