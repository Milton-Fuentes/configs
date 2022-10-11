/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobRoles;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobRolesDaoImpl extends GenericDao<BigDecimal, GlobRoles> implements GlobRolesDao {

    @Override
    public List<Object[]> getModuleRoles(BigInteger clientId) {
        String query = "SELECT (SELECT CASE WHEN (gcm.module_title IS NULL OR gcm.module_title='') THEN gm.module_name ELSE gcm.module_title END AS module_caption \n"
                + "FROM glob_module gm, glob_client_modules gcm WHERE gm.id=gcm.module_id AND gcm.customer_id = :clientId AND gcm.module_id = cr.module_id) module, \n"
                + "CASE WHEN(cr.roles_title IS NULL OR cr.roles_title='') THEN r.shortdesc ELSE cr.roles_title END AS role, cr.roles_id\n"
                + "FROM glob_roles r, glob_client_roles cr \n"
                + "WHERE r.id=cr.roles_id AND cr.client_id=:clientId\n"
                + "AND (r.role_name = 'project_admin' OR r.role_name = 'contractor_admin' OR r.is_req = 'N')\n"
                + "ORDER BY module";
        try {
            return getEntityManager().createNativeQuery(query)
                    .setParameter("clientId", clientId)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Optional<GlobRoles> findByRoleName(String roleName) {
        Query q = getEntityManager().createNamedQuery("GlobRoles.findByRoleName")
                .setParameter("roleName", roleName);
        try {
            return Optional.ofNullable((GlobRoles) q.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        } catch (NonUniqueResultException ex) {
            log.error(String.format("Duplicate Role Configuration: '%s'", roleName));
            return Optional.empty();
        }
    }
    

}
