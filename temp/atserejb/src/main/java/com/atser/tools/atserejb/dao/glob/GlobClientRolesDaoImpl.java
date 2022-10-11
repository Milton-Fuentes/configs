/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobClientRoles;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class GlobClientRolesDaoImpl extends GenericDao<BigDecimal, GlobClientRoles> implements GlobClientRolesDao {

    @Override
    public String getRoleName(BigDecimal roleId, String moduleName, BigDecimal clientId) {
        String query = "SELECT CASE WHEN(CR.ROLES_TITLE IS NULL OR CR.ROLES_TITLE = '') THEN R.SHORTDESC ELSE CR.ROLES_TITLE END AS ROLE"
                + " FROM GLOB_CLIENT_ROLES CR"
                + " INNER JOIN GLOB_ROLES R ON CR.ROLES_ID = R.ID"
                + " INNER JOIN GLOB_MODULE M ON CR.MODULE_ID = M.ID"
                + " WHERE CR.CLIENT_ID = :clientId AND M.MODULE_NAME = :moduleName AND CR.ROLES_ID = :roleId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("roleId", roleId)
                .setParameter("moduleName", moduleName)
                .setParameter("clientId", clientId);
        return q.getSingleResult().toString();

    }
}
