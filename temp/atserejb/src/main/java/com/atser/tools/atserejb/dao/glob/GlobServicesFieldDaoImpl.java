/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobServicesField;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobServicesFieldDaoImpl extends GenericDao<BigDecimal, GlobServicesField> implements GlobServicesFieldDao {
    
    @Override
    public GlobServicesField findByAbbrvAndClientId(String serviceAbbrv, BigInteger clientId) {
        String query = "SELECT t.* FROM GLOB_SERVICES_FIELD t WHERE t.client_id = :clientId AND lower(t.service_abbrev) = lower(:serviceAbbrv)";
        Query q = getEntityManager().createNativeQuery(query, GlobServicesField.class).setParameter("serviceAbbrv", serviceAbbrv).setParameter("clientId", clientId);
        try {
            return (GlobServicesField) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            log.error("@ERROR NonUniqueResultException. Abbreviation: " + serviceAbbrv + " - ClientId: " + clientId);
            return (GlobServicesField) q.getResultList().get(0);
        }
    }
}
