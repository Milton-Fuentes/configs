/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobClientInfoDefaults;
import com.atser.tools.atserejb.model.GlobClientInfoDefaults;
import java.math.BigDecimal;
import java.util.Optional;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobClientInfoDefaultsDaoImpl extends GenericDao<BigDecimal, GlobClientInfoDefaults> implements GlobClientInfoDefaultsDao {

    @Override
    public Optional<GlobClientInfoDefaults> findByClientId(BigInteger clientId) {
        Query q = getEntityManager().createNamedQuery("GlobClientInfoDefaults.findByClient")
                .setParameter("clientId", clientId);
        try {
            return Optional.ofNullable((GlobClientInfoDefaults) q.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        } catch (NonUniqueResultException ex) {
            log.error(String.format("Duplicate Client Info Defaults: ClientId: '%s'", clientId));
            return Optional.empty();
        }
    }
}
