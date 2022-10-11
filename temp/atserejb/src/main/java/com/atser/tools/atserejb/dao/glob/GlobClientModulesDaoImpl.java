/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobClientModules;
import java.math.BigDecimal;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobClientModulesDaoImpl extends GenericDao<BigDecimal, GlobClientModules> implements GlobClientModulesDao {

    @Override
    public Optional<GlobClientModules> findByClientAndModuleName(BigDecimal clientId, String moduleName) {
        Query q = getEntityManager().createNamedQuery("GlobClientModules.findByClientAndModuleName")
                .setParameter("clientId", clientId)
                .setParameter("moduleName", moduleName);
        try {
            return Optional.ofNullable((GlobClientModules) q.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        } catch (NonUniqueResultException ex) {
            log.error(String.format("Duplicate Module Configuration: ClientId: '%s' - ModuleName: '%s'", clientId, moduleName));
            return Optional.empty();
        }
    }
}
