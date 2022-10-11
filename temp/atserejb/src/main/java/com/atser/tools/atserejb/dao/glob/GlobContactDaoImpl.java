/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobContactDaoImpl extends GenericDao<BigDecimal, GlobContact> implements GlobContactDao {

    @Override
    public GlobContact findByFirstAndLastName(BigInteger clientId, String firstname, String lastname) {
        String query = "SELECT t.* FROM GLOB_CONTACT t WHERE t.firstname = :firstName AND t.lastname = :lastName AND t.client_id = :clientId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query, GlobContact.class).setParameter("firstName", firstname).setParameter("lastName", lastname).setParameter("clientId", clientId);
        try {
            if (q.getSingleResult() != null) {
                return (GlobContact) q.getSingleResult();
            }
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal findByContactIdByEmail(BigInteger clientId, String email) {
        String query = "SELECT t.id FROM GLOB_CONTACT t WHERE t.client_id = :clientId AND trim(lower(t.email)) like lower(:email) AND t.active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("email", "%" + StringSupport.trimToEmpty(email) + "%")
                .setParameter("clientId", clientId);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            log.error("findByEmail Duplicate: ClientId: " + clientId + "- Email:" + email);
            return null;
        }
    }

    @Override
    public Boolean existByEmail(String email) {
        String query = "SELECT t.id FROM GLOB_CONTACT t WHERE t.EMAIL = :email AND t.active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("email", email);
        try {
            return (q.getResultList() != null && !q.getResultList().isEmpty());
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
}
